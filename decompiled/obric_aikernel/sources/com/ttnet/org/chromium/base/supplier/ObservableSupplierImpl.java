package com.ttnet.org.chromium.base.supplier;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.ObserverList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
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

    public static /* synthetic */ void a(ObservableSupplierImpl r10, Object r11, Callback r12) {
        r10.lambda$addObserver$0(r11, r12);
    }

    private void checkThread() {
    }

    private /* synthetic */ void lambda$addObserver$0(Object r10, Callback r11) {
        if (this.mObject == r10) goto L5;
        return;
    L5:
        if (this.mObservers.hasObserver(r11) == false) goto L10;
        r11.onResult(this.mObject);
        return;
    }

    public static void setIgnoreThreadChecksForTesting(boolean r10) {
        sIgnoreThreadChecksForTesting = r10;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public E addObserver(final Callback<E> r10) {
        checkThread();
        this.mObservers.addObserver(r10);
        final E r11 = this.mObject;
        if (r11 == null) goto L6;
        this.mHandler.post(new a(this, r11, r10));
    L6:
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    @Nullable
    public E get() {
        checkThread();
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public void removeObserver(Callback<E> r10) {
        checkThread();
        this.mObservers.removeObserver(r10);
    }

    public void set(E r10) {
        checkThread();
        if (r10 != this.mObject) goto L5;
        return;
    L5:
        this.mObject = r10;
        Iterator<Callback<E>> r11 = this.mObservers.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().onResult(this.mObject);
        goto L7
    }
}
