package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion;

        Source(LiveData<V> r10, Observer<? super V> r11) {
            this.mVersion = -1;
            this.mLiveData = r10;
            this.mObserver = r11;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable V r10) {
            if (this.mVersion == this.mLiveData.getVersion()) goto L6;
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(r10);
            return;
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap();
    }

    public MediatorLiveData(T r10) {
        super(r10);
        this.mSources = new SafeIterableMap();
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> r10, @NonNull Observer<? super S> r11) {
        Objects.requireNonNull(r10, "source cannot be null");
        Source<?> r12 = new Source(r10, r11);
        Source<?> r13 = this.mSources.putIfAbsent(r10, r12);
        if (r13 != null) goto L5;
    L9:
        if (r13 == null) goto L12;
        return;
    L12:
        if (hasActiveObservers() == false) goto L15;
        r12.plug();
        return;
    L15:
        return;
    L5:
        if (r13.mObserver == r11) goto L9;
        throw new IllegalArgumentException("This source was already added with the different observer");
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    protected void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r10 = this.mSources.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().getValue().plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    protected void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r10 = this.mSources.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().getValue().unplug();
        goto L4
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> r10) {
        Source<?> r11 = this.mSources.remove(r10);
        if (r11 == null) goto L6;
        r11.unplug();
        return;
    }
}
