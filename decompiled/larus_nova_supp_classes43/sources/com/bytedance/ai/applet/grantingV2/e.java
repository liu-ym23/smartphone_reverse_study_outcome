package com.bytedance.ai.applet.grantingV2;

import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements h {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        return Intrinsics.areEqual(r10.b(), "aweme_login");
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "item");
        String r0 = r11.e();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L36;
    L30:
        u2.d r10 = null;
    L31:
        if (r10 != null) goto L35;
        com.bytedance.ai.utils.g.a.e("FirstPartyLoginStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L35:
        return new FirstPartyLoginStrategy(r11, r10, r12);
    L36:
        Lazy r13 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L26 JsonSyntaxException -> L28
        u2.d r14 = (u2.d) com.bytedance.ai.applet.base.gson.e.a(r0, u2.d.class);     // Catch: Exception -> L26 JsonSyntaxException -> L28
        String r15 = r14.b();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        String r16 = r15;
        String r17 = r14.e();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r17 != null) goto L18;
        r17 = "抖音账号授权登录";
    L18:
        String r18 = r17;
        String r19 = r14.d();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r19 != null) goto L21;
        r19 = "登录后继续使用";
    L21:
        String r20 = r19;
        String r21 = r14.c();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r21 != null) goto L24;
        r21 = "已拒绝登录";
    L24:
        r10 = u2.d.a(r14, r16, r18, r20, r21, 48);     // Catch: Exception -> L26 JsonSyntaxException -> L28
    L28:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("FirstPartyLoginStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L26:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("FirstPartyLoginStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L30
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
