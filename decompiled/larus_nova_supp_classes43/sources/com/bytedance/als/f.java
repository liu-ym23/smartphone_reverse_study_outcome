package com.bytedance.als;

import androidx.core.util.Pair;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class f<T> {
    private MutableLiveData<T> mLiveData;
    private final List<Pair<Observer<T>, LifecycleOwner>> mObserverList;
    private final Set<Observer<T>> mObserverSet;

    public class a implements LifecycleObserver {
        public final /* synthetic */ Observer a;
        public final /* synthetic */ f b;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            f.access$000(this.b, this.a);
        }

        public a(f r1, Observer r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    private void createLiveDataIfNotExistsOrAlreadyHasValue() {
        MutableLiveData<T> r0 = this.mLiveData;
        if (r0 != null) goto L5;
        this.mLiveData = new MutableLiveData();
        return;
    L5:
        if (r0.getValue() == null) goto L26;
        Iterator<Pair<Observer<T>, LifecycleOwner>> r1 = this.mObserverList.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Pair<Observer<T>, LifecycleOwner> r10 = r1.next();
        this.mLiveData.removeObserver((androidx.lifecycle.Observer) r10.first);
        goto L8
    L10:
        this.mLiveData = new MutableLiveData();
        Iterator<Pair<Observer<T>, LifecycleOwner>> r11 = this.mObserverList.iterator();
    L12:
        if (r11.hasNext() == false) goto L27;
        Pair<Observer<T>, LifecycleOwner> r12 = r11.next();
        Object r13 = r12.second;
        if (r13 != null) goto L15;
        this.mLiveData.observeForever((androidx.lifecycle.Observer) r12.first);
        goto L12
    L15:
        this.mLiveData.observe((LifecycleOwner) r13, (androidx.lifecycle.Observer) r12.first);
        goto L12
    L27:
        return;
    }

    public T getValue() {
        MutableLiveData<T> r0 = this.mLiveData;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.getValue();
    }

    public f() {
        this.mObserverSet = new HashSet();
        this.mObserverList = new ArrayList();
    }

    private void cleanObserver(Observer<T> r10) {
        this.mObserverSet.remove(r10);
        Iterator<Pair<Observer<T>, LifecycleOwner>> r0 = this.mObserverList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().first != r10) goto L4;
        r0.remove();
    L8:
        MutableLiveData<T> r11 = this.mLiveData;
        if (r11 != null) goto L11;
        return;
    L11:
        if (r11.hasObservers() == true) goto L18;
        this.mLiveData = null;
        return;
    }

    public void observeForever(Observer<T> r10) {
        if (this.mObserverSet.contains(r10) == true) goto L7;
        this.mObserverSet.add(r10);
        createLiveDataIfNotExistsOrAlreadyHasValue();
        this.mObserverList.add(Pair.create(r10, null));
        this.mLiveData.observeForever(r10);
        return;
    L7:
        throw new IllegalArgumentException("Can't add the same observer twice");
    }

    public void postValue(T r10) {
        MutableLiveData<T> r0 = this.mLiveData;
        if (r0 == null) goto L6;
        r0.postValue(r10);
        return;
    }

    public void removeObserver(Observer<T> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        MutableLiveData<T> r0 = this.mLiveData;
        if (r0 == null) goto L8;
        r0.removeObserver(r10);
        cleanObserver(r10);
        return;
    }

    public void setValue(T r10) {
        MutableLiveData<T> r0 = this.mLiveData;
        if (r0 == null) goto L6;
        r0.setValue(r10);
        return;
    }

    public static /* synthetic */ void access$000(f r0, Observer r1) {
        r0.cleanObserver(r1);
    }

    public void observe(LifecycleOwner r10, Observer<T> r11) {
        if (r10 == null) goto L13;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L8;
        return;
    L8:
        if (this.mObserverSet.contains(r11) == true) goto L12;
        this.mObserverSet.add(r11);
        createLiveDataIfNotExistsOrAlreadyHasValue();
        this.mObserverList.add(Pair.create(r11, r10));
        this.mLiveData.observe(r10, r11);
        r10.getLifecycle().addObserver(new a(this, r11));
        return;
    L12:
        throw new IllegalArgumentException("Can't add the same observer twice");
    }
}
