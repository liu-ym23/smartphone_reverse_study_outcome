package com.larus.common.account.platform.larklogin;

import com.bytedance.sdk.account.impl.d0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import n38.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Function3 {
    public final /* synthetic */ u a;
    public final /* synthetic */ LarkLogin b;

    public /* synthetic */ d(com.larus.common.account.platform.larkauth.h r1, LarkLogin r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5, Object r6, Object r7) {
        u r0 = this.a;
        LarkLogin r1 = this.b;
        String r8 = (String) r5;
        String r9 = (String) r6;
        String r10 = (String) r7;
        LarkLogin.a r2 = LarkLogin.g;
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "code");
        Intrinsics.checkNotNullParameter(r10, "codeVerifier");
        r0.a();
        LarkLogin.g.getClass();
        d0.c().b("/passport/doubao/update_authorize_info/", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("code", r9), TuplesKt.to("platform_app_id", LarkLogin.a.a()), TuplesKt.to("platform", "lark"), TuplesKt.to("code_verifier", r10), TuplesKt.to("scope", r1.a), TuplesKt.to("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login")}), new k(r8));
        return Unit.INSTANCE;
    }
}
