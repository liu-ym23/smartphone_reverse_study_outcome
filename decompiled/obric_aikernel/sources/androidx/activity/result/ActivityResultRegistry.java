package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    final transient Map<String, CallbackAndContract<?>> mKeyToCallback;
    private final Map<String, LifecycleContainer> mKeyToLifecycleContainers;
    final Map<String, Integer> mKeyToRc;
    ArrayList<String> mLaunchedKeys;
    final Map<String, Object> mParsedPendingResults;
    final Bundle mPendingResults;
    private Random mRandom;
    private final Map<Integer, String> mRcToKey;

    private static class CallbackAndContract<O> {
        final ActivityResultCallback<O> mCallback;
        final ActivityResultContract<?, O> mContract;

        CallbackAndContract(ActivityResultCallback<O> r10, ActivityResultContract<?, O> r11) {
            this.mCallback = r10;
            this.mContract = r11;
        }
    }

    private static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList<LifecycleEventObserver> mObservers;

        LifecycleContainer(@NonNull Lifecycle r10) {
            this.mLifecycle = r10;
            this.mObservers = new ArrayList();
        }

        void addObserver(@NonNull LifecycleEventObserver r10) {
            this.mLifecycle.addObserver(r10);
            this.mObservers.add(r10);
        }

        void clearObservers() {
            Iterator<LifecycleEventObserver> r10 = this.mObservers.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            LifecycleEventObserver r11 = r10.next();
            this.mLifecycle.removeObserver(r11);
            goto L4
        L6:
            this.mObservers.clear();
        }
    }

    public ActivityResultRegistry() {
        this.mRandom = new Random();
        this.mRcToKey = new HashMap();
        this.mKeyToRc = new HashMap();
        this.mKeyToLifecycleContainers = new HashMap();
        this.mLaunchedKeys = new ArrayList();
        this.mKeyToCallback = new HashMap();
        this.mParsedPendingResults = new HashMap();
        this.mPendingResults = new Bundle();
    }

    private void bindRcKey(int r10, String r11) {
        this.mRcToKey.put(Integer.valueOf(r10), r11);
        this.mKeyToRc.put(r11, Integer.valueOf(r10));
    }

    private <O> void doDispatch(String r10, int r11, @Nullable Intent r12, @Nullable CallbackAndContract<O> r13) {
        if (r13 != null) goto L4;
    L8:
        this.mParsedPendingResults.remove(r10);
        this.mPendingResults.putParcelable(r10, new ActivityResult(r11, r12));
        return;
    L4:
        if (r13.mCallback == null) goto L8;
        if (this.mLaunchedKeys.contains(r10) == false) goto L8;
        r13.mCallback.onActivityResult(r13.mContract.parseResult(r11, r12));
        this.mLaunchedKeys.remove(r10);
    }

    private int generateRandomNumber() {
        int r10 = this.mRandom.nextInt(2147418112);
    L3:
        int r11 = r10 + 65536;
        if (this.mRcToKey.containsKey(Integer.valueOf(r11)) == false) goto L6;
        r10 = this.mRandom.nextInt(2147418112);
        goto L3
    L6:
        return r11;
    }

    private void registerKey(String r10) {
        if (this.mKeyToRc.get(r10) == null) goto L5;
        return;
    L5:
        bindRcKey(generateRandomNumber(), r10);
    }

    @MainThread
    public final boolean dispatchResult(int r10, int r11, @Nullable Intent r12) {
        String r13 = this.mRcToKey.get(Integer.valueOf(r10));
        if (r13 != null) goto L6;
        return false;
    L6:
        doDispatch(r13, r11, r12, this.mKeyToCallback.get(r13));
        return true;
    }

    @MainThread
    public final <O> boolean dispatchResult(int r10, @SuppressLint({"UnknownNullness"}) O r11) {
        String r12 = this.mRcToKey.get(Integer.valueOf(r10));
        if (r12 != null) goto L6;
        return false;
    L6:
        CallbackAndContract<?> r13 = this.mKeyToCallback.get(r12);
        if (r13 == null) goto L14;
        ActivityResultCallback<?> r14 = r13.mCallback;
        if (r14 == null) goto L14;
        if (this.mLaunchedKeys.remove(r12) == false) goto L17;
        r14.onActivityResult(r11);
        return true;
    L17:
        return true;
    L14:
        this.mPendingResults.remove(r12);
        this.mParsedPendingResults.put(r12, r11);
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int r10, @NonNull ActivityResultContract<I, O> r11, @SuppressLint({"UnknownNullness"}) I r12, @Nullable ActivityOptionsCompat r13);

    public final void onRestoreInstanceState(@Nullable Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r11 = r10.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> r12 = r10.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (r12 == null) goto L17;
        if (r11 == null) goto L22;
        this.mLaunchedKeys = r10.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mRandom = (Random) r10.getSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT);
        this.mPendingResults.putAll(r10.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        int r13 = 0;
    L10:
        if (r13 >= r12.size()) goto L23;
        String r14 = r12.get(r13);
        if (this.mKeyToRc.containsKey(r14) == false) goto L16;
        Integer r15 = this.mKeyToRc.remove(r14);
        if (this.mPendingResults.containsKey(r14) == true) goto L16;
        this.mRcToKey.remove(r15);
    L16:
        bindRcKey(r11.get(r13).intValue(), r12.get(r13));
        r13 = r13 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final void onSaveInstanceState(@NonNull Bundle r10) {
        r10.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.mKeyToRc.values()));
        r10.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.mKeyToRc.keySet()));
        r10.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.mLaunchedKeys));
        r10.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
        r10.putSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT, this.mRandom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String r10, @NonNull final ActivityResultContract<I, O> r11, @NonNull ActivityResultCallback<O> r12) {
        registerKey(r10);
        this.mKeyToCallback.put(r10, new CallbackAndContract(r12, r11));
        if (this.mParsedPendingResults.containsKey(r10) == false) goto L5;
        Object r13 = this.mParsedPendingResults.get(r10);
        this.mParsedPendingResults.remove(r10);
        r12.onActivityResult(r13);
    L5:
        ActivityResult r14 = (ActivityResult) this.mPendingResults.getParcelable(r10);
        if (r14 == null) goto L9;
        this.mPendingResults.remove(r10);
        r12.onActivityResult(r11.parseResult(r14.getResultCode(), r14.getData()));
    L9:
        return new AnonymousClass3(this, r10, r11);
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String r10, @NonNull LifecycleOwner r11, @NonNull final ActivityResultContract<I, O> r12, @NonNull final ActivityResultCallback<O> r13) {
        Lifecycle r14 = r11.getLifecycle();
        if (r14.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        registerKey(r10);
        LifecycleContainer r15 = this.mKeyToLifecycleContainers.get(r10);
        if (r15 != null) goto L7;
        r15 = new LifecycleContainer(r14);
    L7:
        r15.addObserver(new AnonymousClass1(this, r10, r13, r12));
        this.mKeyToLifecycleContainers.put(r10, r15);
        return new AnonymousClass2(this, r10, r12);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r11 + " is attempting to register while current state is " + r14.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    @MainThread
    final void unregister(@NonNull String r10) {
        if (this.mLaunchedKeys.contains(r10) == true) goto L7;
        Integer r11 = this.mKeyToRc.remove(r10);
        if (r11 == null) goto L7;
        this.mRcToKey.remove(r11);
    L7:
        this.mKeyToCallback.remove(r10);
        if (this.mParsedPendingResults.containsKey(r10) == false) goto L11;
        Log.w(LOG_TAG, "Dropping pending result for request " + r10 + ": " + this.mParsedPendingResults.get(r10));
        this.mParsedPendingResults.remove(r10);
    L11:
        if (this.mPendingResults.containsKey(r10) == false) goto L13;
        Log.w(LOG_TAG, "Dropping pending result for request " + r10 + ": " + this.mPendingResults.getParcelable(r10));
        this.mPendingResults.remove(r10);
    L13:
        LifecycleContainer r12 = this.mKeyToLifecycleContainers.get(r10);
        if (r12 == null) goto L17;
        r12.clearObservers();
        this.mKeyToLifecycleContainers.remove(r10);
        return;
    }
}
