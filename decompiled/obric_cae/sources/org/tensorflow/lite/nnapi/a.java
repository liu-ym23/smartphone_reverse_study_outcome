package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0132a f9848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NnApiDelegateImpl f9849b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9850m;

    /* JADX INFO: renamed from: org.tensorflow.lite.nnapi.a$a, reason: collision with other inner class name */
    public static final class C0132a {
    }

    public a() {
        C0132a r8 = new C0132a();
        TensorFlowLite.a();
        this.f9848a = r8;
    }

    @Override // org.tensorflow.lite.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        NnApiDelegateImpl r8 = this.f9849b;
        if (r8 == null) goto L6;
        r8.close();
        this.f9849b = null;
        return;
    }

    @Override // org.tensorflow.lite.b
    public final long getNativeHandle() {
        NnApiDelegateImpl r8 = this.f9849b;
        if (r8 != null) goto L11;
        if (this.f9850m == false) goto L7;
        String r10 = "Should not access delegate after delegate has been closed.";
    L9:
        throw new IllegalStateException(r10);
    L7:
        r10 = "Should not access delegate before interpreter has been constructed.";
        goto L9
    L11:
        return r8.getNativeHandle();
    }
}
