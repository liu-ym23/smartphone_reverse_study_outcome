package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends n0 implements Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w0 f9427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.google.common.base.q f9428i;

    @Override // com.google.common.util.concurrent.o
    public final void b() {
        w0 r5 = this.f9427h;
        boolean r10 = false;
        if (r5 == null) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 & (this.f9424a instanceof a)) == false) goto L14;
        Object r12 = this.f9424a;
        if ((r12 instanceof a) == true) goto L11;
    L13:
        r5.cancel(r10);
        goto L14
    L11:
        if (((a) r12).f9399a == false) goto L13;
        r10 = true;
    L14:
        this.f9427h = null;
        this.f9428i = null;
        return;
    L5:
        r11 = false;
        goto L7
    }

    @Override // com.google.common.util.concurrent.o
    public final String i() {
        w0 r5 = this.f9427h;
        com.google.common.base.q r10 = this.f9428i;
        String r11 = super.i();
        if (r5 == null) goto L5;
        String r12 = String.valueOf(r5);
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.m(r12.length() + 16, "inputFuture=[", r12, "], ");
    L6:
        if (r10 == null) goto L9;
        String r14 = String.valueOf(r10);
        int r15 = androidx.room.jarjarred.org.antlr.runtime.a.g(11, r13);
        StringBuilder r16 = new StringBuilder(r14.length() + r15);
        r16.append(r13);
        r16.append("function=[");
        r16.append(r14);
        r16.append("]");
        return r16.toString();
    L9:
        if (r11 == null) goto L15;
        String r17 = String.valueOf(r13);
        if (r11.length() == 0) goto L14;
        return r17.concat(r11);
    L14:
        return new String(r17);
    L15:
        return null;
    L5:
        r13 = "";
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        w0 r5 = this.f9427h;
        com.google.common.base.q r10 = this.f9428i;
        boolean r11 = this.f9424a instanceof a;
        boolean r12 = true;
        if (r5 != null) goto L5;
        boolean r13 = true;
    L6:
        boolean r14 = r11 | r13;
        if (r10 == null) goto L11;
        r12 = false;
    L11:
        if ((r14 | r12) == false) goto L13;
        return;
    L13:
        this.f9427h = null;
        if (r5.isCancelled() == false) goto L71;
        Object r15 = this.f9424a;
        if (r15 != null) goto L33;
        if (r5.isDone() == true) goto L20;
        e r16 = new e(this, r5);
        if (o.f.b(this, null, r16) == true) goto L69;
        r15 = this.f9424a;
        goto L33
    L69:
        r5.addListener(r16, DirectExecutor.INSTANCE);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        b r17 = new b(th);     // Catch: Throwable -> L29
    L30:
        o.f.b(this, r16, r17);
        return;
    L29:
        r17 = b.f9401b;
        goto L30
    L20:
        if (o.f.b(this, null, o.g(r5)) == false) goto L73;
        o.d(this);
        return;
    L73:
        return;
    L33:
        if ((r15 instanceof a) == false) goto L76;
        r5.cancel(((a) r15).f9399a);
        return;
    L76:
        return;
    L71:
        Object r18 = r10.apply(p0.g(r5));     // Catch: Throwable -> L45
        this.f9428i = null;
        if (r18 != null) goto L42;
        r18 = o.g;
    L42:
        if (o.f.b(this, null, r18) == false) goto L78;
        o.d(this);
        return;
    L78:
        return;
    L45:
        th = move-exception;
        k(th);     // Catch: Throwable -> L49
        this.f9428i = null;
        return;
    L49:
        th = move-exception;
        this.f9428i = null;
        throw th;
    L52:
        e = move-exception;
        k(e);
        return;
    L61:
        cancel(false);
        return;
    L55:
        e = move-exception;
        k(e);
        return;
    L58:
        e = move-exception;
        k(e.getCause());
        return;
    L5:
        r13 = false;
        goto L6
    }
}
