package com.bytedance.common.utility;

import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f1985a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1986a;

        public a() {
        }
    }

    static {
        f1985a = new c();
    }

    public f() {
    }

    public static f a() {
        return f1985a;
    }

    public static void a(f r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1 == f1985a) goto L8;
        f1985a = r1;
        return;
    }

    public static byte[] a(byte[] r3) {
        GZIPOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L9
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L9
        r2.write(r3);     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        return r1.toByteArray();
    L7:
        th = th;
        r0 = r2;
    L10:
        if (r0 == null) goto L12;
        r0.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }

    public String a(String r3, List<Pair<String, String>> r4) {
        List<Pair<String, String>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        a r0 = new a();
        r0.f1986a = true;
        return a(r3, r5, null, r0);
    }

    public abstract String a(String r1, List<Pair<String, String>> r2, Map<String, String> r3, a r4);

    public abstract String a(String r1, Map<String, String> r2, a r3);

    public abstract String a(String r1, byte[] r2, Map<String, String> r3, a r4);

    public String a(String r3, byte[] r4, boolean r5, String r6, boolean r7) {
        HashMap r0 = new HashMap();
        if (r5 == false) goto L10;
        r4 = a(r4);     // Catch: Exception -> L6
        r0.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L10:
        if (h.a(r6) == true) goto L12;
        r0.put(NetConst.KEY_CONTENT_TYPE, r6);
    L12:
        a r8 = new a();
        r8.f1986a = r7;
        return a(r3, r4, r0, r8);
    }

    public byte[] b(String r1, byte[] r2, Map<String, String> r3, a r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return null;
    }
}
