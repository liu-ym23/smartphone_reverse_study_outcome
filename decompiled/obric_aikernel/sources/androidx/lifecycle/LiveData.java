package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
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

        AlwaysActiveObserver(LiveData r10, Observer<? super T> r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return true;
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

        @NonNull
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        LifecycleBoundObserver(@NonNull LiveData r10, LifecycleOwner r11, Observer<? super T> r12) {
            this.this$0 = r10;
            super(r10, r12);
            this.mOwner = r11;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean isAttachedTo(LifecycleOwner r10) {
            if (this.mOwner != r10) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner r10, @NonNull Lifecycle.Event r11) {
            Lifecycle.State r12 = this.mOwner.getLifecycle().getCurrentState();
            if (r12 != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(this.mObserver);
            return;
        L6:
            Lifecycle.State r13 = null;
        L7:
            if (r13 == r12) goto L9;
            activeStateChanged(shouldBeActive());
            Lifecycle.State r14 = this.mOwner.getLifecycle().getCurrentState();
            r13 = r12;
            r12 = r14;
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

        ObserverWrapper(LiveData r10, Observer<? super T> r11) {
            this.this$0 = r10;
            this.mLastVersion = -1;
            this.mObserver = r11;
        }

        void activeStateChanged(boolean r10) {
            if (r10 != this.mActive) goto L5;
            return;
        L5:
            this.mActive = r10;
            LiveData r11 = this.this$0;
            if (r10 == false) goto L8;
            int r12 = 1;
        L9:
            r11.changeActiveCounter(r12);
            if (this.mActive == false) goto L13;
            this.this$0.dispatchingValue(this);
            return;
        L13:
            return;
        L8:
            r12 = -1;
            goto L9
        }

        void detachObserver() {
        }

        boolean isAttachedTo(LifecycleOwner r10) {
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
        Object r10 = NOT_SET;
        this.mPendingData = r10;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r10;
        this.mVersion = -1;
    }

    public LiveData(T r10) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r10;
        this.mVersion = 0;
    }

    static void assertMainThread(String r10) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r10 + " on a background thread");
    }

    private void considerNotify(LiveData<T>.ObserverWrapper r10) {
        if (r10.mActive == true) goto L6;
        return;
    L6:
        if (r10.shouldBeActive() == true) goto L9;
        r10.activeStateChanged(false);
        return;
    L9:
        int r11 = r10.mLastVersion;
        int r12 = this.mVersion;
        if (r11 < r12) goto L12;
        return;
    L12:
        r10.mLastVersion = r12;
        r10.mObserver.onChanged((Object) this.mData);
    }

    @MainThread
    void changeActiveCounter(int r10) {
        int r11 = this.mActiveCount;
        this.mActiveCount = r10 + r11;
        if (this.mChangingActiveState == false) goto L5;
        return;
    L5:
        this.mChangingActiveState = true;
    L27:
        int r12 = this.mActiveCount;     // Catch: Throwable -> L24
        if (r11 == r12) goto L22;
        if (r11 != 0) goto L12;
        if (r12 <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r11 <= 0) goto L16;
        if (r12 != 0) goto L16;
        boolean r14 = true;
    L17:
        if (r13 == false) goto L19;
        onActive();     // Catch: Throwable -> L24
    L21:
        r11 = r12;
        goto L27
    L19:
        if (r14 == false) goto L21;
        onInactive();     // Catch: Throwable -> L24
    L16:
        r14 = false;
    L12:
        r13 = false;
        goto L13
    L22:
        this.mChangingActiveState = false;
        return;
    L24:
        th = move-exception;
        this.mChangingActiveState = false;
        throw th;
    }

    void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper r10) {
        if (this.mDispatchingValue == false) goto L6;
        this.mDispatchInvalidated = true;
        return;
    L6:
        this.mDispatchingValue = true;
    L7:
        this.mDispatchInvalidated = false;
        if (r10 == null) goto L10;
        considerNotify(r10);
        r10 = null;
    L16:
        if (this.mDispatchInvalidated == true) goto L7;
        this.mDispatchingValue = false;
        return;
    L10:
        SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions r11 = this.mObservers.iteratorWithAdditions();
    L12:
        if (r11.hasNext() == false) goto L16;
        considerNotify((ObserverWrapper) r11.next().getValue());
        if (this.mDispatchInvalidated == false) goto L12;
        goto L16
    }

    @Nullable
    public T getValue() {
        T r10 = (T) this.mData;
        if (r10 == NOT_SET) goto L5;
        return r10;
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

    @MainThread
    public void observe(@NonNull LifecycleOwner r10, @NonNull Observer<? super T> r11) {
        assertMainThread("observe");
        if (r10.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleBoundObserver r12 = new LifecycleBoundObserver(this, r10, r11);
        LiveData<T>.ObserverWrapper r13 = this.mObservers.putIfAbsent(r11, r12);
        if (r13 != null) goto L8;
    L12:
        if (r13 == null) goto L14;
        return;
    L14:
        r10.getLifecycle().addObserver(r12);
        return;
    L8:
        if (r13.isAttachedTo(r10) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> r10) {
        assertMainThread("observeForever");
        AlwaysActiveObserver r11 = new AlwaysActiveObserver(this, r10);
        LiveData<T>.ObserverWrapper r12 = this.mObservers.putIfAbsent(r10, r11);
        if ((r12 instanceof LifecycleBoundObserver) == true) goto L9;
        if (r12 == null) goto L6;
        return;
    L6:
        r11.activeStateChanged(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    protected void postValue(T r10) {
        Object r11 = this.mDataLock;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingData != NOT_SET) goto L7;
        boolean r12 = true;
    L8:
        this.mPendingData = r10;     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        if (r12 == true) goto L12;
        return;
    L12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        return;
    L7:
        r12 = false;
        goto L8
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> r10) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper r11 = this.mObservers.remove(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.detachObserver();
        r11.activeStateChanged(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner r10) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r11 = this.mObservers.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> r12 = r11.next();
        if (r12.getValue().isAttachedTo(r10) == false) goto L4;
        removeObserver(r12.getKey());
        goto L4
    }

    @MainThread
    protected void setValue(T r10) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r10;
        dispatchingValue(null);
    }
}
