package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        CallbackAndContract(ActivityResultCallback<O> r3, ActivityResultContract<?, O> r4) {
            this.mCallback = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ActivityResultCallback.class, "com.obric.memorydata.plugin");
            this.mContract = r4;
        }
    }

    private static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList<LifecycleEventObserver> mObservers;

        LifecycleContainer(Lifecycle r1) {
            this.mLifecycle = r1;
            this.mObservers = new ArrayList();
        }

        void addObserver(LifecycleEventObserver r3) {
            LifecycleEventObserver r4 = (LifecycleEventObserver) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
            this.mLifecycle.addObserver(r4);
            this.mObservers.add(r4);
        }

        void clearObservers() {
            Iterator<LifecycleEventObserver> r0 = this.mObservers.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            LifecycleEventObserver r1 = (LifecycleEventObserver) ZeusTransformUtils.preCheckCast(r0.next(), LifecycleEventObserver.class, "com.obric.memorydata.plugin");
            this.mLifecycle.removeObserver(r1);
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

    private void bindRcKey(int r3, String r4) {
        this.mRcToKey.put(Integer.valueOf(r3), r4);
        this.mKeyToRc.put(r4, Integer.valueOf(r3));
    }

    private <O> void doDispatch(String r2, int r3, Intent r4, CallbackAndContract<O> r5) {
        if (r5 != null) goto L4;
    L8:
        this.mParsedPendingResults.remove(r2);
        this.mPendingResults.putParcelable(r2, new ActivityResult(r3, r4));
        return;
    L4:
        if (r5.mCallback == null) goto L8;
        if (this.mLaunchedKeys.contains(r2) == false) goto L8;
        r5.mCallback.onActivityResult(r5.mContract.parseResult(r3, r4));
        this.mLaunchedKeys.remove(r2);
    }

    private int generateRandomNumber() {
        int r0 = this.mRandom.nextInt(2147418112);
    L3:
        int r1 = r0 + 65536;
        if (this.mRcToKey.containsKey(Integer.valueOf(r1)) == false) goto L6;
        r0 = this.mRandom.nextInt(2147418112);
        goto L3
    L6:
        return r1;
    }

    private void registerKey(String r4) {
        if (((Integer) ZeusTransformUtils.preCheckCast(this.mKeyToRc.get(r4), Integer.class, "com.obric.memorydata.plugin")) == null) goto L5;
        return;
    L5:
        bindRcKey(generateRandomNumber(), r4);
    }

    public final boolean dispatchResult(int r4, int r5, Intent r6) {
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.mRcToKey.get(Integer.valueOf(r4)), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        return false;
    L6:
        doDispatch(r7, r5, r6, (CallbackAndContract) ZeusTransformUtils.preCheckCast(this.mKeyToCallback.get(r7), CallbackAndContract.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public final <O> boolean dispatchResult(int r4, O r5) {
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.mRcToKey.get(Integer.valueOf(r4)), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return false;
    L6:
        CallbackAndContract r0 = (CallbackAndContract) ZeusTransformUtils.preCheckCast(this.mKeyToCallback.get(r6), CallbackAndContract.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
    L14:
        this.mPendingResults.remove(r6);
        this.mParsedPendingResults.put(r6, r5);
        return true;
    L9:
        if (r0.mCallback == null) goto L14;
        ActivityResultCallback<O> r1 = r0.mCallback;
        if (this.mLaunchedKeys.remove(r6) == false) goto L17;
        r1.onActivityResult(r5);
        return true;
    L17:
        return true;
    }

    public abstract <I, O> void onLaunch(int r1, ActivityResultContract<I, O> r2, I r3, ActivityOptionsCompat r4);

    public final void onRestoreInstanceState(Bundle r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r0 = r7.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> r1 = r7.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (r1 == null) goto L17;
        if (r0 == null) goto L22;
        this.mLaunchedKeys = r7.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mRandom = (Random) ZeusTransformUtils.preCheckCast(r7.getSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT), Random.class, "com.obric.memorydata.plugin");
        this.mPendingResults.putAll(r7.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        int r8 = 0;
    L10:
        if (r8 >= r1.size()) goto L23;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get(r8), String.class, "com.obric.memorydata.plugin");
        if (this.mKeyToRc.containsKey(r2) == false) goto L16;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this.mKeyToRc.remove(r2), Integer.class, "com.obric.memorydata.plugin");
        if (this.mPendingResults.containsKey(r2) == true) goto L16;
        this.mRcToKey.remove(r3);
    L16:
        bindRcKey(((Integer) ZeusTransformUtils.preCheckCast(r0.get(r8), Integer.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r1.get(r8), String.class, "com.obric.memorydata.plugin"));
        r8 = r8 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final void onSaveInstanceState(Bundle r4) {
        r4.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.mKeyToRc.values()));
        r4.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.mKeyToRc.keySet()));
        r4.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.mLaunchedKeys));
        r4.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) ZeusTransformUtils.preCheckCast(this.mPendingResults.clone(), Bundle.class, "com.obric.memorydata.plugin"));
        r4.putSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT, this.mRandom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> ActivityResultLauncher<I> register(final String r4, final ActivityResultContract<I, O> r5, ActivityResultCallback<O> r6) {
        ActivityResultCallback r7 = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r6, ActivityResultCallback.class, "com.obric.memorydata.plugin");
        registerKey(r4);
        this.mKeyToCallback.put(r4, new CallbackAndContract(r7, r5));
        if (this.mParsedPendingResults.containsKey(r4) == false) goto L5;
        Object r0 = this.mParsedPendingResults.get(r4);
        this.mParsedPendingResults.remove(r4);
        r7.onActivityResult(r0);
    L5:
        ActivityResult r1 = (ActivityResult) ZeusTransformUtils.preCheckCast(this.mPendingResults.getParcelable(r4), ActivityResult.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        this.mPendingResults.remove(r4);
        r7.onActivityResult(r5.parseResult(r1.getResultCode(), r1.getData()));
    L9:
        return new AnonymousClass3(this, r4, r5);
    }

    public final <I, O> ActivityResultLauncher<I> register(final String r5, LifecycleOwner r6, final ActivityResultContract<I, O> r7, ActivityResultCallback<O> r8) {
        LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r6, LifecycleOwner.class, "com.obric.memorydata.plugin");
        final ActivityResultCallback r10 = (ActivityResultCallback) ZeusTransformUtils.wrapperContextForParams(r8, ActivityResultCallback.class, "com.obric.memorydata.plugin");
        Lifecycle r0 = r9.getLifecycle();
        if (r0.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        registerKey(r5);
        LifecycleContainer r11 = (LifecycleContainer) ZeusTransformUtils.preCheckCast(this.mKeyToLifecycleContainers.get(r5), LifecycleContainer.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L7;
        r11 = new LifecycleContainer(r0);
    L7:
        r11.addObserver(new AnonymousClass1(this, r5, r10, r7));
        this.mKeyToLifecycleContainers.put(r5, r11);
        return new AnonymousClass2(this, r5, r7);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r9 + " is attempting to register while current state is " + r0.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    final void unregister(String r7) {
        if (this.mLaunchedKeys.contains(r7) == true) goto L7;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.mKeyToRc.remove(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        this.mRcToKey.remove(r0);
    L7:
        this.mKeyToCallback.remove(r7);
        if (this.mParsedPendingResults.containsKey(r7) == false) goto L11;
        Log.w(LOG_TAG, "Dropping pending result for request " + r7 + ": " + this.mParsedPendingResults.get(r7));
        this.mParsedPendingResults.remove(r7);
    L11:
        if (this.mPendingResults.containsKey(r7) == false) goto L13;
        Log.w(LOG_TAG, "Dropping pending result for request " + r7 + ": " + this.mPendingResults.getParcelable(r7));
        this.mPendingResults.remove(r7);
    L13:
        LifecycleContainer r1 = (LifecycleContainer) ZeusTransformUtils.preCheckCast(this.mKeyToLifecycleContainers.get(r7), LifecycleContainer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        r1.clearObservers();
        this.mKeyToLifecycleContainers.remove(r7);
        return;
    }
}
