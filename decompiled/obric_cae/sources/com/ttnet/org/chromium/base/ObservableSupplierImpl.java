package com.ttnet.org.chromium.base;

import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Handler mHandler;
    private E mObject;
    private final ObserverList<Callback<E>> mObservers;
    private final Thread mThread;

    public ObservableSupplierImpl() {
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
        this.mObservers = new ObserverList();
    }

    public static /* synthetic */ void a(ObservableSupplierImpl r8, Object r10, Callback r11) {
        r8.lambda$addObserver$0(r10, r11);
    }

    private void checkThread() {
    }

    private /* synthetic */ void lambda$addObserver$0(Object r8, Callback r10) {
        if (this.mObject == r8) goto L5;
        return;
    L5:
        if (this.mObservers.hasObserver(r10) == false) goto L10;
        r10.onResult(this.mObject);
        return;
    }

    @Override // com.ttnet.org.chromium.base.ObservableSupplier
    public E addObserver(Callback<E> r8) {
        checkThread();
        this.mObservers.addObserver(r8);
        E r10 = this.mObject;
        if (r10 == null) goto L6;
        this.mHandler.post(new androidx.emoji2.text.g(this, r10, r8, 5));
    L6:
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.Supplier
    public E get() {
        checkThread();
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.ObservableSupplier
    public void removeObserver(Callback<E> r8) {
        checkThread();
        this.mObservers.removeObserver(r8);
    }

    public void set(E r8) {
        checkThread();
        if (r8 != this.mObject) goto L5;
        return;
    L5:
        this.mObject = r8;
        Iterator<Callback<E>> r10 = this.mObservers.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().onResult(this.mObject);
        goto L7
    }
}
