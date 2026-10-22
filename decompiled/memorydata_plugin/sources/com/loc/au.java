package com.loc;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private fw f5331b;
    private String c;

    public au(Context r3, fw r4, String r5) {
        this.f5330a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f5331b = r4;
        this.c = r5;
    }

    private static String a(Context r3, fw r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append("\"sdkversion\":\"").append(r4.c()).append("\",\"product\":\"").append(r4.a()).append("\",\"nt\":\"").append(fp.c(r6)).append("\",\"details\":").append(r5);     // Catch: Throwable -> L5
    L8:
        return r0.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    final byte[] a() {
        return fx.a(a(this.f5330a, this.f5331b, this.c));
    }
}
