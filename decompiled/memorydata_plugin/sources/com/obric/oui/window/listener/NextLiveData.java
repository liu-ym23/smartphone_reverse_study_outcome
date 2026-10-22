package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class NextLiveData<T> extends MutableLiveData<T> {
    private static final Handler sMainHandler = null;
    private int mLatestVersion;
    private final Map<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> nextObserverMap;

    private class NextObserver<R> implements Observer<R> {
        private int initVersion;
        private boolean notifyWhenObserve;
        private Observer<R> observer;
        final /* synthetic */ NextLiveData this$0;

        NextObserver(NextLiveData r3, int r4, Observer<R> r5, boolean r6) {
            Observer<R> r7 = (Observer) ZeusTransformUtils.wrapperContextForParams(r5, Observer.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.initVersion = r4;
            this.observer = r7;
            this.notifyWhenObserve = r6;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(R r3) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r3);
            return;
        L5:
            if (this.initVersion < NextLiveData.access$000(this.this$0)) goto L7;
        }
    }

    static {
        sMainHandler = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    static /* synthetic */ int access$000(NextLiveData r0) {
        return r0.mLatestVersion;
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner r3, Observer<? super T> r4) {
        observe((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), (Observer) ZeusTransformUtils.wrapperContextForParams(r4, Observer.class, "com.obric.memorydata.plugin"), false);
    }

    public void observe(LifecycleOwner r3, Observer<? super T> r4, boolean r5) {
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Observer<? super T> r7 = (Observer) ZeusTransformUtils.wrapperContextForParams(r4, Observer.class, "com.obric.memorydata.plugin");
        if (this.nextObserverMap.containsKey(r7) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r0 = new NextObserver(this, this.mLatestVersion, r7, r5);
        this.nextObserverMap.put(r7, r0);
        super.observe(r6, r0);
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> r3) {
        observeForever((Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin"), false);
    }

    public void observeForever(Observer<? super T> r3, boolean r4) {
        Observer<? super T> r5 = (Observer) ZeusTransformUtils.wrapperContextForParams(r3, Observer.class, "com.obric.memorydata.plugin");
        if (this.nextObserverMap.containsKey(r5) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r0 = new NextObserver(this, this.mLatestVersion, r5, r4);
        this.nextObserverMap.put(r5, r0);
        super.observeForever(r0);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(final T r3) {
        sMainHandler.post(new AnonymousClass1(this, r3));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> r6) {
        Observer<? super T> r7 = (Observer) ZeusTransformUtils.wrapperContextForParams(r6, Observer.class, "com.obric.memorydata.plugin");
        NextObserver r0 = (NextObserver) ZeusTransformUtils.preCheckCast(this.nextObserverMap.remove(r7), NextObserver.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        super.removeObserver(r0);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, NextObserver.class) == false) goto L20;
        Observer r1 = null;
        Iterator<Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>>> r2 = this.nextObserverMap.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7.equals(r3.getValue()) == false) goto L10;
        r1 = (Observer) ZeusTransformUtils.preCheckCast(r3.getKey(), Observer.class, "com.obric.memorydata.plugin");
        super.removeObserver(r7);
    L14:
        if (r1 == null) goto L21;
        this.nextObserverMap.remove(r1);
        return;
    L21:
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T r2) {
        this.mLatestVersion++;
        super.setValue(r2);
    }
}
