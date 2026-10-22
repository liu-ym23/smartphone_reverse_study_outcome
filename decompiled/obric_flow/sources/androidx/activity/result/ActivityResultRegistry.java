package androidx.activity.result;

import ai.j0;
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
import kotlin.random.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    final transient Map<String, CallbackAndContract<?>> mKeyToCallback;
    private final Map<String, LifecycleContainer> mKeyToLifecycleContainers;
    final Map<String, Integer> mKeyToRc;
    ArrayList<String> mLaunchedKeys;
    final Map<String, Object> mParsedPendingResults;
    final Bundle mPendingResults;
    private final Map<Integer, String> mRcToKey;

    public static class CallbackAndContract<O> {
        final ActivityResultCallback<O> mCallback;
        final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultCallback<O> r5, ActivityResultContract<?, O> r10) {
            this.mCallback = r5;
            this.mContract = r10;
        }
    }

    public static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList<LifecycleEventObserver> mObservers;

        public LifecycleContainer(@NonNull Lifecycle r5) {
            this.mLifecycle = r5;
            this.mObservers = new ArrayList();
        }

        public void addObserver(@NonNull LifecycleEventObserver r5) {
            this.mLifecycle.addObserver(r5);
            this.mObservers.add(r5);
        }

        public void clearObservers() {
            Iterator<LifecycleEventObserver> r5 = this.mObservers.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            LifecycleEventObserver r10 = r5.next();
            this.mLifecycle.removeObserver(r10);
            goto L4
        L6:
            this.mObservers.clear();
        }
    }

    public ActivityResultRegistry() {
        this.mRcToKey = new HashMap();
        this.mKeyToRc = new HashMap();
        this.mKeyToLifecycleContainers = new HashMap();
        this.mLaunchedKeys = new ArrayList();
        this.mKeyToCallback = new HashMap();
        this.mParsedPendingResults = new HashMap();
        this.mPendingResults = new Bundle();
    }

    private void bindRcKey(int r5, String r10) {
        this.mRcToKey.put(Integer.valueOf(r5), r10);
        this.mKeyToRc.put(r10, Integer.valueOf(r5));
    }

    private <O> void doDispatch(String r5, int r10, @Nullable Intent r11, @Nullable CallbackAndContract<O> r12) {
        if (r12 != null) goto L4;
    L8:
        this.mParsedPendingResults.remove(r5);
        this.mPendingResults.putParcelable(r5, new ActivityResult(r10, r11));
        return;
    L4:
        if (r12.mCallback == null) goto L8;
        if (this.mLaunchedKeys.contains(r5) == false) goto L8;
        r12.mCallback.onActivityResult(r12.mContract.parseResult(r10, r11));
        this.mLaunchedKeys.remove(r5);
    }

    private int generateRandomNumber() {
        int r5 = Random.Default.nextInt(2147418112);
    L3:
        int r10 = r5 + 65536;
        if (this.mRcToKey.containsKey(Integer.valueOf(r10)) == false) goto L6;
        r5 = Random.Default.nextInt(2147418112);
        goto L3
    L6:
        return r10;
    }

    private void registerKey(String r5) {
        if (this.mKeyToRc.get(r5) == null) goto L5;
        return;
    L5:
        bindRcKey(generateRandomNumber(), r5);
    }

    @MainThread
    public final boolean dispatchResult(int r5, int r10, @Nullable Intent r11) {
        String r12 = this.mRcToKey.get(Integer.valueOf(r5));
        if (r12 != null) goto L6;
        return false;
    L6:
        doDispatch(r12, r10, r11, this.mKeyToCallback.get(r12));
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int r5, @NonNull ActivityResultContract<I, O> r10, @SuppressLint({"UnknownNullness"}) I r11, @Nullable ActivityOptionsCompat r12);

    public final void onRestoreInstanceState(@Nullable Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r5 = r10.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> r11 = r10.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (r11 == null) goto L17;
        if (r5 == null) goto L22;
        this.mLaunchedKeys = r10.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mPendingResults.putAll(r10.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        int r12 = 0;
    L10:
        if (r12 >= r11.size()) goto L23;
        String r13 = r11.get(r12);
        if (this.mKeyToRc.containsKey(r13) == false) goto L16;
        Integer r14 = this.mKeyToRc.remove(r13);
        if (this.mPendingResults.containsKey(r13) == true) goto L16;
        this.mRcToKey.remove(r14);
    L16:
        bindRcKey(r5.get(r12).intValue(), r11.get(r12));
        r12 = r12 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final void onSaveInstanceState(@NonNull Bundle r5) {
        r5.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.mKeyToRc.values()));
        r5.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.mKeyToRc.keySet()));
        r5.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.mLaunchedKeys));
        r5.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String r5, @NonNull LifecycleOwner r10, @NonNull final ActivityResultContract<I, O> r11, @NonNull final ActivityResultCallback<O> r12) {
        Lifecycle r13 = r10.getLifecycle();
        if (r13.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        registerKey(r5);
        LifecycleContainer r14 = this.mKeyToLifecycleContainers.get(r5);
        if (r14 != null) goto L7;
        r14 = new LifecycleContainer(r13);
    L7:
        r14.addObserver(new AnonymousClass1(this, r5, r12, r11));
        this.mKeyToLifecycleContainers.put(r5, r14);
        return new AnonymousClass2(this, r5, r11);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r10 + " is attempting to register while current state is " + r13.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    @MainThread
    public final void unregister(@NonNull String r10) {
        if (this.mLaunchedKeys.contains(r10) == true) goto L7;
        Integer r5 = this.mKeyToRc.remove(r10);
        if (r5 == null) goto L7;
        this.mRcToKey.remove(r5);
    L7:
        this.mKeyToCallback.remove(r10);
        if (this.mParsedPendingResults.containsKey(r10) == false) goto L11;
        StringBuilder r11 = j0.x("Dropping pending result for request ", r10, ": ");
        r11.append(this.mParsedPendingResults.get(r10));
        Log.w(LOG_TAG, r11.toString());
        this.mParsedPendingResults.remove(r10);
    L11:
        if (this.mPendingResults.containsKey(r10) == false) goto L13;
        StringBuilder r12 = j0.x("Dropping pending result for request ", r10, ": ");
        r12.append(this.mPendingResults.getParcelable(r10));
        Log.w(LOG_TAG, r12.toString());
        this.mPendingResults.remove(r10);
    L13:
        LifecycleContainer r13 = this.mKeyToLifecycleContainers.get(r10);
        if (r13 == null) goto L17;
        r13.clearObservers();
        this.mKeyToLifecycleContainers.remove(r10);
        return;
    }

    @MainThread
    public final <O> boolean dispatchResult(int r5, @SuppressLint({"UnknownNullness"}) O r10) {
        String r11 = this.mRcToKey.get(Integer.valueOf(r5));
        if (r11 != null) goto L6;
        return false;
    L6:
        CallbackAndContract<?> r12 = this.mKeyToCallback.get(r11);
        if (r12 == null) goto L14;
        ActivityResultCallback<?> r13 = r12.mCallback;
        if (r13 == null) goto L14;
        if (this.mLaunchedKeys.remove(r11) == false) goto L17;
        r13.onActivityResult(r10);
        return true;
    L17:
        return true;
    L14:
        this.mPendingResults.remove(r11);
        this.mParsedPendingResults.put(r11, r10);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String r5, @NonNull final ActivityResultContract<I, O> r10, @NonNull ActivityResultCallback<O> r11) {
        registerKey(r5);
        this.mKeyToCallback.put(r5, new CallbackAndContract(r11, r10));
        if (this.mParsedPendingResults.containsKey(r5) == false) goto L5;
        Object r12 = this.mParsedPendingResults.get(r5);
        this.mParsedPendingResults.remove(r5);
        r11.onActivityResult(r12);
    L5:
        ActivityResult r13 = (ActivityResult) this.mPendingResults.getParcelable(r5);
        if (r13 == null) goto L9;
        this.mPendingResults.remove(r5);
        r11.onActivityResult(r10.parseResult(r13.getResultCode(), r13.getData()));
    L9:
        return new AnonymousClass3(this, r5, r10);
    }
}
