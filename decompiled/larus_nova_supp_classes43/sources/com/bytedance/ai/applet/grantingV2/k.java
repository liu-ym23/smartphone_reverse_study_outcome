package com.bytedance.ai.applet.grantingV2;

import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements h {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        if (Intrinsics.areEqual(r10.b(), "login") == false) goto L13;
        String r11 = r10.e();
        if (r11 != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        if (r12 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.contains$default(r11, "bizLoginDescription", false, 2, null) != true) goto L9;
        r12 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "item");
        String r0 = r12.e();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L45;
    L39:
        u2.j r10 = null;
    L40:
        if (r10 != null) goto L44;
        com.bytedance.ai.utils.g.a.e("LoginStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L44:
        return new LoginStrategy(r12, r10, r13);
    L45:
        Lazy r11 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L35 JsonSyntaxException -> L37
        u2.j r14 = (u2.j) com.bytedance.ai.applet.base.gson.e.a(r0, u2.j.class);     // Catch: Exception -> L35 JsonSyntaxException -> L37
        String r15 = r14.e();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r15 != null) goto L16;
        String r16 = "";
    L17:
        String r17 = r14.f();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r17 != null) goto L20;
        String r18 = "";
    L21:
        String r19 = r14.d();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r19 != null) goto L24;
        String r20 = "";
    L25:
        String r21 = r14.c();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r21 != null) goto L28;
        String r22 = "";
    L29:
        String r23 = r14.b();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r23 != null) goto L32;
        String r24 = "";
    L33:
        r10 = u2.j.a(r14, r16, r18, r20, r22, r24, 96);     // Catch: Exception -> L35 JsonSyntaxException -> L37
    L32:
        r24 = r23;
        goto L33
    L28:
        r22 = r21;
        goto L29
    L24:
        r20 = r19;
        goto L25
    L20:
        r18 = r17;
        goto L21
    L16:
        r16 = r15;
    L37:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LoginStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L35:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LoginStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L39
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
