package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        Source(LiveData<V> r3, Observer<? super V> r4) {
            Observer<? super V> r5 = (Observer) ZeusTransformUtils.wrapperContextForParams(r4, Observer.class, "com.obric.memorydata.plugin");
            this.mVersion = -1;
            this.mLiveData = r3;
            this.mObserver = r5;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V r3) {
            if (this.mVersion == this.mLiveData.getVersion()) goto L6;
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(r3);
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

    public MediatorLiveData(T r1) {
        super(r1);
        this.mSources = new SafeIterableMap();
    }

    public <S> void addSource(LiveData<S> r4, Observer<? super S> r5) {
        Observer r6 = (Observer) ZeusTransformUtils.wrapperContextForParams(r5, Observer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "source cannot be null");
        Source<?> r0 = new Source(r4, r6);
        Source r7 = (Source) ZeusTransformUtils.preCheckCast(this.mSources.putIfAbsent(r4, r0), Source.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L9:
        if (r7 == null) goto L12;
        return;
    L12:
        if (hasActiveObservers() == false) goto L15;
        r0.plug();
        return;
    L15:
        return;
    L5:
        if (r7.mObserver == r6) goto L9;
        throw new IllegalArgumentException("This source was already added with the different observer");
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r3 = this.mSources.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Source) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Source.class, "com.obric.memorydata.plugin")).plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r3 = this.mSources.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Source) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Source.class, "com.obric.memorydata.plugin")).unplug();
        goto L4
    }

    public <S> void removeSource(LiveData<S> r2) {
        Source r1 = (Source) ZeusTransformUtils.preCheckCast(this.mSources.remove(r2), Source.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.unplug();
        return;
    }
}
