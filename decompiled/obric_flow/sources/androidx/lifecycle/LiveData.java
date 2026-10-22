package androidx.lifecycle;

import ai.j0;
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

    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        final /* synthetic */ LiveData this$0;

        public AlwaysActiveObserver(LiveData r5, Observer<? super T> r10) {
            this.this$0 = r5;
            super(r5, r10);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return true;
        }
    }

    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

        @NonNull
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        public LifecycleBoundObserver(@NonNull LiveData r5, LifecycleOwner r10, Observer<? super T> r11) {
            this.this$0 = r5;
            super(r5, r11);
            this.mOwner = r10;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean isAttachedTo(LifecycleOwner r5) {
            if (this.mOwner != r5) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner r5, @NonNull Lifecycle.Event r10) {
            Lifecycle.State r11 = this.mOwner.getLifecycle().getCurrentState();
            if (r11 != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(this.mObserver);
            return;
        L6:
            Lifecycle.State r12 = null;
        L7:
            if (r12 == r11) goto L9;
            activeStateChanged(shouldBeActive());
            Lifecycle.State r13 = this.mOwner.getLifecycle().getCurrentState();
            r12 = r11;
            r11 = r13;
            goto L7
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    public abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion;
        final Observer<? super T> mObserver;
        final /* synthetic */ LiveData this$0;

        public ObserverWrapper(LiveData r5, Observer<? super T> r10) {
            this.this$0 = r5;
            this.mLastVersion = -1;
            this.mObserver = r10;
        }

        public void activeStateChanged(boolean r5) {
            if (r5 != this.mActive) goto L5;
            return;
        L5:
            this.mActive = r5;
            LiveData r10 = this.this$0;
            if (r5 == false) goto L8;
            int r11 = 1;
        L9:
            r10.changeActiveCounter(r11);
            if (this.mActive == false) goto L13;
            this.this$0.dispatchingValue(this);
            return;
        L13:
            return;
        L8:
            r11 = -1;
            goto L9
        }

        public void detachObserver() {
        }

        public boolean isAttachedTo(LifecycleOwner r5) {
            return false;
        }

        public abstract boolean shouldBeActive();
    }

    static {
        NOT_SET = new Object();
    }

    public LiveData(T r5) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r5;
        this.mVersion = 0;
    }

    public static void assertMainThread(String r5) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(j0.k("Cannot invoke ", r5, " on a background thread"));
    }

    private void considerNotify(LiveData<T>.ObserverWrapper r5) {
        if (r5.mActive == true) goto L6;
        return;
    L6:
        if (r5.shouldBeActive() == true) goto L9;
        r5.activeStateChanged(false);
        return;
    L9:
        int r10 = r5.mLastVersion;
        int r11 = this.mVersion;
        if (r10 < r11) goto L12;
        return;
    L12:
        r5.mLastVersion = r11;
        r5.mObserver.onChanged((Object) this.mData);
    }

    @MainThread
    public void changeActiveCounter(int r5) {
        int r10 = this.mActiveCount;
        this.mActiveCount = r5 + r10;
        if (this.mChangingActiveState == false) goto L5;
        return;
    L5:
        this.mChangingActiveState = true;
    L28:
        int r11 = this.mActiveCount;     // Catch: Throwable -> L19
        if (r10 == r11) goto L24;
        if (r10 != 0) goto L12;
        if (r11 <= 0) goto L12;
        boolean r12 = true;
    L13:
        if (r10 <= 0) goto L16;
        if (r11 != 0) goto L16;
        boolean r13 = true;
    L17:
        if (r12 == false) goto L21;
        onActive();     // Catch: Throwable -> L19
    L23:
        r10 = r11;
        goto L28
    L21:
        if (r13 == false) goto L23;
        onInactive();     // Catch: Throwable -> L19
    L16:
        r13 = false;
    L12:
        r12 = false;
        goto L13
    L24:
        this.mChangingActiveState = false;
        return;
    L19:
        th = move-exception;
        this.mChangingActiveState = false;
        throw th;
    }

    public void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper r5) {
        if (this.mDispatchingValue == false) goto L6;
        this.mDispatchInvalidated = true;
        return;
    L6:
        this.mDispatchingValue = true;
    L7:
        this.mDispatchInvalidated = false;
        if (r5 == null) goto L10;
        considerNotify(r5);
        r5 = null;
    L16:
        if (this.mDispatchInvalidated == true) goto L7;
        this.mDispatchingValue = false;
        return;
    L10:
        SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions r10 = this.mObservers.iteratorWithAdditions();
    L12:
        if (r10.hasNext() == false) goto L16;
        considerNotify((ObserverWrapper) r10.next().getValue());
        if (this.mDispatchInvalidated == false) goto L12;
        goto L16
    }

    @Nullable
    public T getValue() {
        T r5 = (T) this.mData;
        if (r5 == NOT_SET) goto L5;
        return r5;
    L5:
        return null;
    }

    public int getVersion() {
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
    public void observe(@NonNull LifecycleOwner r5, @NonNull Observer<? super T> r10) {
        assertMainThread("observe");
        if (r5.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleBoundObserver r11 = new LifecycleBoundObserver(this, r5, r10);
        LiveData<T>.ObserverWrapper r12 = this.mObservers.putIfAbsent(r10, r11);
        if (r12 != null) goto L8;
    L12:
        if (r12 == null) goto L14;
        return;
    L14:
        r5.getLifecycle().addObserver(r11);
        return;
    L8:
        if (r12.isAttachedTo(r5) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> r5) {
        assertMainThread("observeForever");
        AlwaysActiveObserver r10 = new AlwaysActiveObserver(this, r5);
        LiveData<T>.ObserverWrapper r11 = this.mObservers.putIfAbsent(r5, r10);
        if ((r11 instanceof LifecycleBoundObserver) == true) goto L9;
        if (r11 == null) goto L6;
        return;
    L6:
        r10.activeStateChanged(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T r5) {
        Object r10 = this.mDataLock;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingData != NOT_SET) goto L7;
        boolean r11 = true;
    L8:
        this.mPendingData = r5;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        if (r11 == true) goto L12;
        return;
    L12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        return;
    L7:
        r11 = false;
        goto L8
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> r5) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper r10 = this.mObservers.remove(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.detachObserver();
        r10.activeStateChanged(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner r5) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r10 = this.mObservers.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> r11 = r10.next();
        if (r11.getValue().isAttachedTo(r5) == false) goto L4;
        removeObserver(r11.getKey());
        goto L4
    }

    @MainThread
    public void setValue(T r5) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r5;
        dispatchingValue(null);
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object r5 = NOT_SET;
        this.mPendingData = r5;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r5;
        this.mVersion = -1;
    }
}
