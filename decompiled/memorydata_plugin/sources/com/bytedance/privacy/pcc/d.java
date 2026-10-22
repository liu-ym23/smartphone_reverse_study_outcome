package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3078a = "d";

    static {
    }

    private d() {
    }

    public static String a(Context r4, String r5, String r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        a(r9, r5);
        Bundle r0 = new Bundle();
        r0.putInt(com.bytedance.privacy.d.a.a(), com.bytedance.privacy.d.a.d());
        r0.putInt(com.bytedance.privacy.d.a.b(), 256);
        r0.putInt(com.bytedance.privacy.d.a.c(), com.bytedance.privacy.d.a.e() | com.bytedance.privacy.d.a.f());
        int r1 = com.bytedance.privacy.d.a.a(r9, r5, r0);
        if (r1 != com.bytedance.privacy.d.a.p()) goto L17;
        Bundle r2 = new Bundle();
        r2.putString(com.bytedance.privacy.d.a.g(), r6);
        r2.putString(com.bytedance.privacy.d.a.j(), r7);
        r2.putString(com.bytedance.privacy.d.a.k(), r8);
        r2.putBoolean(com.bytedance.privacy.d.a.h(), true);
        com.bytedance.privacy.d.a.c r10 = com.bytedance.privacy.d.a.c(r9, r5, r2);
        if (r10.b() != com.bytedance.privacy.d.a.p()) goto L15;
        List<Certificate> r11 = r10.c();
        if (r11 == null) goto L13;
        if (r11.isEmpty() == true) goto L13;
        return com.bytedance.privacy.e.a.a(r11, Math.min(r11.size(), 3));
    L13:
        throw new Exception("cert chain is empty");
    L15:
        throw new Exception("keyAttestation failed: ret=" + r10.b());
    L17:
        throw new Exception("generateKeyPair failed: ret=" + r1);
    }

    public static void a(Context r3, String r4) {
        int r5 = com.bytedance.privacy.d.a.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, new Bundle());
        if (r5 != com.bytedance.privacy.d.a.p()) goto L5;
        com.bytedance.privacy.e.c.a(f3078a, "deleteSignKey: alias=" + r4);
        return;
    L5:
        com.bytedance.privacy.e.c.d(f3078a, "deleteSignKey: ret=" + r5 + " alias=" + r4);
    }

    public static byte[] a(Context r2, String r3, byte[] r4) {
        com.bytedance.privacy.d.a.c r5 = com.bytedance.privacy.d.a.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, new Bundle());
        byte[] r6 = r5.d();
        if (r5.b() != com.bytedance.privacy.d.a.p()) goto L9;
        if (r6 == null) goto L9;
        if (r6.length == 0) goto L9;
        return r6;
    L9:
        throw new Exception("sign failed: ret=" + r5.b());
    }
}
