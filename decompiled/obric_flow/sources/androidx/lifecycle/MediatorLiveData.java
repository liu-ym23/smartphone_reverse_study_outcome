package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    public static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion;

        public Source(LiveData<V> r5, Observer<? super V> r10) {
            this.mVersion = -1;
            this.mLiveData = r5;
            this.mObserver = r10;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable V r5) {
            if (this.mVersion == this.mLiveData.getVersion()) goto L6;
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(r5);
            return;
        }

        public void plug() {
            this.mLiveData.observeForever(this);
        }

        public void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap();
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> r5, @NonNull Observer<? super S> r10) {
        if (r5 == null) goto L17;
        Source<?> r11 = new Source(r5, r10);
        Source<?> r12 = this.mSources.putIfAbsent(r5, r11);
        if (r12 != null) goto L6;
    L10:
        if (r12 == null) goto L13;
        return;
    L13:
        if (hasActiveObservers() == false) goto L18;
        r11.plug();
        return;
    L18:
        return;
    L6:
        if (r12.mObserver == r10) goto L10;
        throw new IllegalArgumentException("This source was already added with the different observer");
    L17:
        throw new NullPointerException("source cannot be null");
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r5 = this.mSources.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().getValue().plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r5 = this.mSources.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().getValue().unplug();
        goto L4
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> r5) {
        Source<?> r10 = this.mSources.remove(r5);
        if (r10 == null) goto L6;
        r10.unplug();
        return;
    }

    public MediatorLiveData(T r5) {
        super(r5);
        this.mSources = new SafeIterableMap();
    }
}
