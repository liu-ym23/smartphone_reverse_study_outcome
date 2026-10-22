package com.bytedance.privacy.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.e.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3002a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f3003b;

    static {
    }

    public a() {
    }

    private int a(Context r2, String r3, Bundle r4) {
        int r1 = com.bytedance.privacy.d.a.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
        if (r1 == com.bytedance.privacy.d.a.p()) goto L7;
        c.d(f3002a, "Generate key pair failed! ret:" + r1);
        return r1;
    L7:
        return com.bytedance.privacy.d.a.p();
    }

    public static a a() {
        if (f3003b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3003b != null) goto L9;
        f3003b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3003b;
    }

    private List<Certificate> a(Context r2, String r3, String r4, Bundle r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        c.d(f3002a, "Attest bundle is null");
        return new ArrayList();
    L6:
        r5.putString(com.bytedance.privacy.d.a.g(), r4);
        com.bytedance.privacy.d.a.c r6 = com.bytedance.privacy.d.a.c(r1, r3, r5);
        if (r6.b() == com.bytedance.privacy.d.a.p()) goto L10;
        c.d(f3002a, "Attest key with ids failed! ret:" + r6.b());
        return new ArrayList();
    L10:
        List<Certificate> r7 = r6.c();
        if (r7 != null) goto L13;
    L17:
        c.d(f3002a, "keyAttestation result certChain invalid for keyAlias=" + r3);
        return new ArrayList();
    L13:
        if (r7.isEmpty() == true) goto L17;
        c.a(f3002a, "Attest key with ids succeed! keyAlias=" + r3 + ", cert chain size: " + r7.size());
        return r7;
    }

    private List<Certificate> a(Context r2, String r3, String r4, boolean r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Bundle r6 = new Bundle();
        if (r5 == false) goto L5;
        r6.putBoolean(com.bytedance.privacy.d.a.h(), true);
    L5:
        r6.putString(com.bytedance.privacy.d.a.g(), r4);
        com.bytedance.privacy.d.a.c r7 = com.bytedance.privacy.d.a.c(r1, r3, r6);
        if (r7.b() == com.bytedance.privacy.d.a.p()) goto L9;
        c.d(f3002a, "Attest key failed! ret:" + r7.b());
        return new ArrayList();
    L9:
        List<Certificate> r8 = r7.c();
        c.a(f3002a, "Attest key succeed! cert chain size:" + r8.size());
        return r8;
    }

    public List<Certificate> a(Context r3, String r4, String r5, String r6, Bundle r7, Bundle r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = com.bytedance.privacy.c.a.a();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        c.d(f3002a, "Request challenge failed!!");
        return new ArrayList();
    L6:
        int r10 = a(r9, r6, r7);
        if (r10 == com.bytedance.privacy.d.a.p()) goto L10;
        c.d(f3002a, "Generate attestation key pair failed! ret:" + r10);
        return new ArrayList();
    L10:
        List<Certificate> r11 = a(r9, r6, r0 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r5 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4, r8);
        if (r11.isEmpty() == false) goto L14;
        c.d(f3002a, "attestKeyWithIds failed, delete keyAlias: " + r6);
        a(r9, r6);
        return new ArrayList();
    L14:
        return r11;
    }

    public List<Certificate> a(Context r3, String r4, String r5, boolean r6, Bundle r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = com.bytedance.privacy.c.a.a();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        c.d(f3002a, "Request challenge failed!!");
        return new ArrayList();
    L6:
        int r9 = a(r8, r4, r7);
        if (r9 == com.bytedance.privacy.d.a.p()) goto L11;
        c.d(f3002a, "Generate attestation key pair failed! ret:" + r9);
        return new ArrayList();
    L11:
        return a(r8, r4, r0 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r5 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4, r6);
    }

    public void a(Context r3, String r4) {
        int r2 = com.bytedance.privacy.d.a.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, new Bundle());
        if (r2 != com.bytedance.privacy.d.a.p()) goto L5;
        c.b(f3002a, "Deleted attest key successfully: " + r4);
        return;
    L5:
        c.d(f3002a, "Failed to delete attest key: " + r4 + ", ret: " + r2);
    }
}
