package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NextLiveData<T> extends MutableLiveData<T> {
    private static final Handler sMainHandler = null;
    private int mLatestVersion;
    private final Map<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> nextObserverMap;

    private class NextObserver<R> implements Observer<R> {
        private int initVersion;
        private boolean notifyWhenObserve;
        private Observer<R> observer;
        final /* synthetic */ NextLiveData this$0;

        NextObserver(NextLiveData r10, int r11, Observer<R> r12, boolean r13) {
            this.this$0 = r10;
            this.initVersion = r11;
            this.observer = r12;
            this.notifyWhenObserve = r13;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable R r10) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r10);
            return;
        L5:
            if (this.initVersion < NextLiveData.access$000(this.this$0)) goto L7;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f7765c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ NextLiveData f7766g;

        a(NextLiveData r10, Object r11) {
            this.f7766g = r10;
            this.f7765c = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f7766g.setValue(this.f7765c);
        }
    }

    static {
        sMainHandler = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    static /* synthetic */ int access$000(NextLiveData r10) {
        return r10.mLatestVersion;
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(@NonNull LifecycleOwner r10, @NonNull Observer<? super T> r11) {
        observe(r10, r11, false);
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner r10, @NonNull Observer<? super T> r11, boolean r12) {
        if (this.nextObserverMap.containsKey(r11) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r13 = new NextObserver(this, this.mLatestVersion, r11, r12);
        this.nextObserverMap.put(r11, r13);
        super.observe(r10, r13);
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observeForever(@NonNull Observer<? super T> r10) {
        observeForever(r10, false);
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> r10, boolean r11) {
        if (this.nextObserverMap.containsKey(r10) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r12 = new NextObserver(this, this.mLatestVersion, r10, r11);
        this.nextObserverMap.put(r10, r12);
        super.observeForever(r12);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(@Nullable T r10) {
        sMainHandler.post(new a(this, r10));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NonNull Observer<? super T> r10) {
        NextLiveData<T>.NextObserver<? super T> r11 = this.nextObserverMap.remove(r10);
        if (r11 == null) goto L7;
        super.removeObserver(r11);
        return;
    L7:
        if ((r10 instanceof NextObserver) == false) goto L20;
        Observer<? super T> r12 = null;
        Iterator<Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>>> r13 = this.nextObserverMap.entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> r14 = r13.next();
        if (r10.equals(r14.getValue()) == false) goto L10;
        r12 = r14.getKey();
        super.removeObserver(r10);
    L14:
        if (r12 == null) goto L21;
        this.nextObserverMap.remove(r12);
        return;
    L21:
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T r10) {
        this.mLatestVersion++;
        super.setValue(r10);
    }
}
