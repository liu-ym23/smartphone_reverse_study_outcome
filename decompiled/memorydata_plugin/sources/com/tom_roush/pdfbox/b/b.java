package com.tom_roush.pdfbox.b;

import com.bytedance.apm.util.f;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.io.Closeable;
import java.io.OutputStream;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
public class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f16078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f16079b = null;
    public static final byte[] c = null;
    public static final byte[] d = null;
    public static final byte[] e = null;
    public static final byte[] f = null;
    public static final byte[] g = null;
    public static final byte[] h = null;
    public static final byte[] i = null;
    public static final byte[] j = null;
    public static final byte[] k = null;
    public static final byte[] l = null;
    public static final byte[] m = null;
    public static final byte[] n = null;
    public static final byte[] o = null;
    public static final byte[] p = null;
    public static final byte[] q = null;
    public static final byte[] r = null;
    public static final byte[] s = null;
    private a t;
    private OutputStream u;

    static {
        f16078a = "<<".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        f16079b = ">>".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        c = new byte[]{32};
        d = new byte[]{37};
        e = "PDF-1.4".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        f = new byte[]{-10, -28, -4, MessagePack.Code.MAP32};
        g = "%%EOF".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        h = "R".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        i = "xref".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        j = f.f1488a.getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        k = "n".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        l = "trailer".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        m = "startxref".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        n = "obj".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        o = "endobj".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        p = "[".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        q = "]".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        r = CozeCloudExt.API_KEY_HTTP_STREAM_METHOD.getBytes(com.tom_roush.pdfbox.util.a.f16297a);
        s = "endstream".getBytes(com.tom_roush.pdfbox.util.a.f16297a);
    }

    public a a() {
        return this.t;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (a() == null) goto L5;
        a().close();
    L5:
        OutputStream r1 = this.u;
        if (r1 == null) goto L9;
        r1.close();
        return;
    }
}
