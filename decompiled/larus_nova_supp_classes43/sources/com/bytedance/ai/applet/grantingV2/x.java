package com.bytedance.ai.applet.grantingV2;

import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x implements h {

    public static final class a {
    }

    static {
    }

    public x() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        return Intrinsics.areEqual(r10.b(), "permission");
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "item");
        String r0 = r10.e();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L32;
    L26:
        u2.k r12 = null;
    L27:
        if (r12 != null) goto L31;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L31:
        return new PermissionStrategy(r10, r12, r11);
    L32:
        Lazy r13 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L22 JsonSyntaxException -> L24
        u2.k r14 = (u2.k) com.bytedance.ai.applet.base.gson.e.a(r0, u2.k.class);     // Catch: Exception -> L22 JsonSyntaxException -> L24
        String r15 = r14.c();     // Catch: Exception -> L22 JsonSyntaxException -> L24
        String r16 = "";
        if (r15 != null) goto L16;
        r15 = "";
    L16:
        String r17 = r14.b();     // Catch: Exception -> L22 JsonSyntaxException -> L24
        if (r17 == null) goto L20;
        r16 = r17;
    L20:
        r12 = new u2.k(r15, r16);     // Catch: Exception -> L22 JsonSyntaxException -> L24
    L24:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L22:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L26
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
