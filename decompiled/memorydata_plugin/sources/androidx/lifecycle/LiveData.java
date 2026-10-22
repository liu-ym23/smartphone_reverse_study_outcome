package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        final /* synthetic */ LiveData this$0;

        AlwaysActiveObserver(LiveData r3, Observer<? super T> r4) {
            Observer r5 = (Observer) ZeusTransformUtils.wrapperContextForParams(r4, Observer.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3, r5);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return true;
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        LifecycleBoundObserver(LiveData r3, LifecycleOwner r4, Observer<? super T> r5) {
            LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Observer r7 = (Observer) ZeusTransformUtils.wrapperContextForParams(r5, Observer.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3, r7);
            this.mOwner = r6;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean isAttachedTo(LifecycleOwner r3) {
            LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
            if (this.mOwner != r4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
            LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Lifecycle.State r6 = this.mOwner.getLifecycle().getCurrentState();
            if (r6 != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(this.mObserver);
            return;
        L6:
            Lifecycle.State r7 = null;
        L7:
            if (r7 == r6) goto L9;
            activeStateChanged(shouldBeActive());
            Lifecycle.State r8 = this.mOwner.getLifecycle().getCurrentState();
            r7 = r6;
            r6 = r8;
            goto L7
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    private abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion;
        final Observer<? super T> mObserver;
        final /* synthetic */ LiveData this$0;

        ObserverWrapper(LiveData r3, Observer<? super T> r4) {
            Observer<? super T> r5 = (Observer) ZeusTransformUtils.wrapperContextForParams(r4, Observer.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mLastVersion = -1;
            this.mObserver = r5;
        }

        void activeStateChanged(boolean r2) {
            if (r2 != this.mActive) goto L5;
            return;
        L5:
            this.mActive = r2;
            LiveData r0 = this.this$0;
            if (r2 == false) goto L8;
            int r3 = 1;
        L9:
            r0.changeActiveCounter(r3);
            if (this.mActive == false) goto L13;
            this.this$0.dispatchingValue(this);
            return;
        L13:
            return;
        L8:
            r3 = -1;
            goto L9
        }

        void detachObserver() {
        }

        boolean isAttachedTo(LifecycleOwner r2) {
            LifecycleOwner r1 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r2, LifecycleOwner.class, "com.obric.memorydata.plugin");
            return false;
        }

        abstract boolean shouldBeActive();
    }

    static {
        NOT_SET = new Object();
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object r0 = NOT_SET;
        this.mPendingData = r0;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r0;
        this.mVersion = -1;
    }

    public LiveData(T r3) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r3;
        this.mVersion = 0;
    }

    static void assertMainThread(String r3) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r3 + " on a background thread");
    }

    private void considerNotify(LiveData<T>.ObserverWrapper r3) {
        if (r3.mActive == true) goto L6;
        return;
    L6:
        if (r3.shouldBeActive() == true) goto L9;
        r3.activeStateChanged(false);
        return;
    L9:
        int r0 = r3.mLastVersion;
        int r1 = this.mVersion;
        if (r0 < r1) goto L12;
        return;
    L12:
        r3.mLastVersion = r1;
        r3.mObserver.onChanged((Object) this.mData);
    }

    void changeActiveCounter(int r5) {
        int r0 = this.mActiveCount;
        this.mActiveCount = r5 + r0;
        if (this.mChangingActiveState == false) goto L5;
        return;
    L5:
        this.mChangingActiveState = true;
    L27:
        int r2 = this.mActiveCount;     // Catch: Throwable -> L24
        if (r0 == r2) goto L22;
        if (r0 != 0) goto L12;
        if (r2 <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r0 <= 0) goto L16;
        if (r2 != 0) goto L16;
        boolean r1 = true;
    L17:
        if (r3 == false) goto L19;
        onActive();     // Catch: Throwable -> L24
    L21:
        r0 = r2;
        goto L27
    L19:
        if (r1 == false) goto L21;
        onInactive();     // Catch: Throwable -> L24
    L16:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    L22:
        this.mChangingActiveState = false;
        return;
    L24:
        th = move-exception;
        this.mChangingActiveState = false;
        throw th;
    }

    void dispatchingValue(LiveData<T>.ObserverWrapper r6) {
        if (this.mDispatchingValue == false) goto L6;
        this.mDispatchInvalidated = true;
        return;
    L6:
        this.mDispatchingValue = true;
    L7:
        this.mDispatchInvalidated = false;
        if (r6 == null) goto L10;
        considerNotify(r6);
        r6 = null;
    L16:
        if (this.mDispatchInvalidated == true) goto L7;
        this.mDispatchingValue = false;
        return;
    L10:
        SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions r1 = this.mObservers.iteratorWithAdditions();
    L12:
        if (r1.hasNext() == false) goto L16;
        considerNotify((ObserverWrapper) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), ObserverWrapper.class, "com.obric.memorydata.plugin"));
        if (this.mDispatchInvalidated == false) goto L12;
        goto L16
    }

    public T getValue() {
        T r1 = (T) this.mData;
        if (r1 == NOT_SET) goto L5;
        return r1;
    L5:
        return null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasObservers() {
        if (this.mObservers.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInitialized() {
        if (this.mData == NOT_SET) goto L5;
        return true;
    L5:
        return false;
    }

    public void observe(LifecycleOwner r4, Observer<? super T> r5) {
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Observer<? super T> r7 = (Observer) ZeusTransformUtils.wrapperContextForParams(r5, Observer.class, "com.obric.memorydata.plugin");
        assertMainThread("observe");
        if (r6.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleBoundObserver r0 = new LifecycleBoundObserver(this, r6, r7);
        ObserverWrapper r3 = (ObserverWrapper) ZeusTransformUtils.preCheckCast(this.mObservers.putIfAbsent(r7, r0), ObserverWrapper.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
    L12:
        if (r3 == null) goto L14;
        return;
    L14:
        r6.getLifecycle().addObserver(r0);
        return;
    L8:
        if (r3.isAttachedTo(r6) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void observeForever(Observer<? super T> r3) {
        Observer<? super T> r4 = (Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin");
        assertMainThread("observeForever");
        AlwaysActiveObserver r0 = new AlwaysActiveObserver(this, r4);
        ObserverWrapper r2 = (ObserverWrapper) ZeusTransformUtils.preCheckCast(this.mObservers.putIfAbsent(r4, r0), ObserverWrapper.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, LifecycleBoundObserver.class) == true) goto L9;
        if (r2 == null) goto L6;
        return;
    L6:
        r0.activeStateChanged(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T r4) {
        Object r0 = this.mDataLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingData != NOT_SET) goto L7;
        boolean r1 = true;
    L8:
        this.mPendingData = r4;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r1 == true) goto L12;
        return;
    L12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void removeObserver(Observer<? super T> r3) {
        Observer<? super T> r4 = (Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin");
        assertMainThread("removeObserver");
        ObserverWrapper r2 = (ObserverWrapper) ZeusTransformUtils.preCheckCast(this.mObservers.remove(r4), ObserverWrapper.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        r2.detachObserver();
        r2.activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner r6) {
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r6, LifecycleOwner.class, "com.obric.memorydata.plugin");
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r0 = this.mObservers.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((ObserverWrapper) ZeusTransformUtils.preCheckCast(r2.getValue(), ObserverWrapper.class, "com.obric.memorydata.plugin")).isAttachedTo(r7) == false) goto L4;
        removeObserver((Observer) ZeusTransformUtils.preCheckCast(r2.getKey(), Observer.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public void setValue(T r2) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r2;
        dispatchingValue(null);
    }
}
