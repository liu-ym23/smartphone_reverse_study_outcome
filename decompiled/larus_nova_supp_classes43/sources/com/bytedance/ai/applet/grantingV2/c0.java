package com.bytedance.ai.applet.grantingV2;

import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 implements h {

    public static final class a {
    }

    static {
    }

    public c0() {
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
        if (StringsKt.contains$default(r11, "authLink", false, 2, null) != true) goto L9;
        r12 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "item");
        String r0 = r13.e();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L42;
    L36:
        u2.l r10 = null;
    L37:
        if (r10 != null) goto L41;
        com.bytedance.ai.utils.g.a.e("QSMusicLoginStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L41:
        return new QSMusicLoginStrategy(r13, r10, r14);
    L42:
        Lazy r11 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        u2.l r12 = (u2.l) com.bytedance.ai.applet.base.gson.e.a(r0, u2.l.class);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        String r15 = r12.b();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        String r16 = r15;
        String r17 = r12.g();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r17 != null) goto L18;
        r17 = "在豆包内使用汽水音乐";
    L18:
        String r18 = r17;
        String r19 = r12.f();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r19 != null) goto L21;
        r19 = "登录后获取更优质的音乐体验";
    L21:
        String r20 = r19;
        String r21 = r12.e();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r21 != null) goto L24;
        r21 = "已拒绝登录汽水音乐";
    L24:
        String r22 = r21;
        String r23 = r12.c();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r23 != null) goto L27;
        r23 = "登录";
    L27:
        String r24 = r23;
        String r25 = r12.d();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r25 != null) goto L30;
        r25 = "不登录";
    L30:
        r10 = u2.l.a(r12, r16, r18, r20, r22, r24, r25, 192);     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L34:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("QSMusicLoginStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L32:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("QSMusicLoginStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L36
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
