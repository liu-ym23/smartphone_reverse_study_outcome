package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class t2 extends st.a implements qt.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f17974b;

    public t2(mt.n r5) {
        this.f17973a = r5;
        this.f17974b = new AtomicReference();
    }

    @Override // qt.c
    public final void a(Disposable r5) {
        AtomicReference r10 = this.f17974b;
        ObservablePublishAlt$PublishConnection r11 = (ObservablePublishAlt$PublishConnection) r5;
    L4:
        if (r10.compareAndSet(r11, null) == true) goto L8;
        if (r10.get() == r11) goto L4;
        return;
    }

    @Override // st.a
    public final void d(pt.g r5) {
    L2:
        AtomicReference r10 = this.f17974b;
        ObservablePublishAlt$PublishConnection r11 = (ObservablePublishAlt$PublishConnection) r10.get();
        if (r11 != null) goto L5;
    L6:
        ObservablePublishAlt$PublishConnection r12 = new ObservablePublishAlt$PublishConnection(r10);
    L8:
        if (r10.compareAndSet(r11, r12) == true) goto L9;
        if (r10.get() == r11) goto L8;
    L9:
        r11 = r12;
    L10:
        boolean r13 = false;
        if (r11.connect.get() == false) goto L13;
    L25:
        r5.accept(r11);     // Catch: Throwable -> L19
        if (r13 == false) goto L31;
        this.f17973a.subscribe(r11);
        return;
    L31:
        return;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        throw io.reactivex.internal.util.d.d(th);
    L13:
        if (r11.connect.compareAndSet(false, true) == false) goto L25;
        r13 = true;
        goto L25
    L5:
        if (r11.isDisposed() == false) goto L10;
        goto L6
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
    L2:
        AtomicReference r10 = this.f17974b;
        ObservablePublishAlt$PublishConnection r11 = (ObservablePublishAlt$PublishConnection) r10.get();
        if (r11 != null) goto L11;
        ObservablePublishAlt$PublishConnection r12 = new ObservablePublishAlt$PublishConnection(r10);
    L6:
        if (r10.compareAndSet(r11, r12) == true) goto L7;
        if (r10.get() == r11) goto L6;
    L7:
        r11 = r12;
    L11:
        ObservablePublishAlt$InnerDisposable r13 = new ObservablePublishAlt$InnerDisposable(r5, r11);
        r5.onSubscribe(r13);
        if (r11.add(r13) == true) goto L14;
        Throwable r14 = r11.error;
        if (r14 == null) goto L20;
        r5.onError(r14);
        return;
    L20:
        r5.onComplete();
        return;
    L14:
        if (r13.isDisposed() == false) goto L26;
        r11.remove(r13);
        return;
    }
}
