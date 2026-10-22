package org.tensorflow.lite;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class f implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeInterpreterWrapper f9842a;

    public static class a extends e {
    }

    public f(NativeInterpreterWrapperExperimental r8) {
        this.f9842a = r8;
    }

    final void a() {
        if (this.f9842a == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        NativeInterpreterWrapper r8 = this.f9842a;
        if (r8 == null) goto L6;
        r8.close();
        this.f9842a = null;
        return;
    }

    public final void finalize() {
        close();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public final h i() {
        a();
        return this.f9842a.a(0);
    }

    public final int k() {
        a();
        return this.f9842a.f9811p.length;
    }

    public final h n() {
        a();
        return this.f9842a.i(0);
    }

    public final int r() {
        a();
        return this.f9842a.f9812q.length;
    }

    public final void v(Object r8, Object r10) {
        HashMap r11 = new HashMap();
        r11.put(0, r10);
        a();
        NativeInterpreterWrapper r12 = this.f9842a;
        r12.r(new Object[]{r8}, r11);
    }
}
