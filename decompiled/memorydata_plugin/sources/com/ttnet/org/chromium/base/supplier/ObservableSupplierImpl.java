package com.ttnet.org.chromium.base.supplier;

import android.os.Handler;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.ObserverList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sIgnoreThreadChecksForTesting;
    private final Handler mHandler;
    private E mObject;
    private final ObserverList<Callback<E>> mObservers;
    private final Thread mThread;

    static {
    }

    public ObservableSupplierImpl() {
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
        this.mObservers = new ObserverList();
    }

    private void checkThread() {
    }

    public static void setIgnoreThreadChecksForTesting(boolean r0) {
        sIgnoreThreadChecksForTesting = r0;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public E addObserver(Callback<E> r4) {
        final Callback<E> r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        checkThread();
        this.mObservers.addObserver(r5);
        final E r0 = this.mObject;
        if (r0 == null) goto L6;
        this.mHandler.post(new $$Lambda$ObservableSupplierImpl$sQvpD3oQbOZhPNFw2bIYPLosLg(this, r0, r5));
    L6:
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    public E get() {
        checkThread();
        return this.mObject;
    }

    public /* synthetic */ void lambda$addObserver$0$ObservableSupplierImpl(Object r3, Callback r4) {
        Callback<E> r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        if (this.mObject == r3) goto L5;
        return;
    L5:
        if (this.mObservers.hasObserver(r5) == false) goto L10;
        r5.onResult(this.mObject);
        return;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public void removeObserver(Callback<E> r3) {
        Callback<E> r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        checkThread();
        this.mObservers.removeObserver(r4);
    }

    public void set(E r4) {
        checkThread();
        if (r4 != this.mObject) goto L5;
        return;
    L5:
        this.mObject = r4;
        Iterator<Callback<E>> r5 = this.mObservers.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        ((Callback) ZeusTransformUtils.preCheckCast(r5.next(), Callback.class, "com.obric.memorydata.plugin")).onResult(this.mObject);
        goto L7
    }
}
