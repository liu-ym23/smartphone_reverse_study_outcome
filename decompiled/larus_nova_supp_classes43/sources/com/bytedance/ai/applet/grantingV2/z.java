package com.bytedance.ai.applet.grantingV2;

import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z implements h {

    public static final class a {
    }

    static {
    }

    public z() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        return Intrinsics.areEqual(r10.b(), "privacy");
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "item");
        String r0 = r12.e();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L37;
    L31:
        u2.j r10 = null;
    L32:
        if (r10 != null) goto L36;
        com.bytedance.ai.utils.g.a.e("PrivacyStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L36:
        return new PrivacyStrategy(r12, r10, r13);
    L37:
        Lazy r11 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L27 JsonSyntaxException -> L29
        u2.j r14 = (u2.j) com.bytedance.ai.applet.base.gson.e.a(r0, u2.j.class);     // Catch: Exception -> L27 JsonSyntaxException -> L29
        String r15 = r14.e();     // Catch: Exception -> L27 JsonSyntaxException -> L29
        if (r15 != null) goto L16;
        String r16 = "";
    L17:
        String r17 = r14.f();     // Catch: Exception -> L27 JsonSyntaxException -> L29
        if (r17 != null) goto L20;
        String r18 = "";
    L21:
        String r19 = r14.d();     // Catch: Exception -> L27 JsonSyntaxException -> L29
        if (r19 != null) goto L24;
        String r20 = "";
    L25:
        r10 = u2.j.a(r14, r16, r18, r20, null, null, 120);     // Catch: Exception -> L27 JsonSyntaxException -> L29
    L24:
        r20 = r19;
        goto L25
    L20:
        r18 = r17;
        goto L21
    L16:
        r16 = r15;
    L29:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PrivacyStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L27:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PrivacyStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L31
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
