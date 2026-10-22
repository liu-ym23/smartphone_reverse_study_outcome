package com.larus.common.account.platform.larklogin;

import com.bytedance.sdk.account.impl.d0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Function3 {
    public final /* synthetic */ LarkLogin a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ f(LarkLogin r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r12, Object r13, Object r14) {
        LarkLogin r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        String r15 = (String) r12;
        String r16 = (String) r13;
        String r17 = (String) r14;
        LarkLogin.a r3 = LarkLogin.g;
        Intrinsics.checkNotNullParameter(r15, "sessionId");
        Intrinsics.checkNotNullParameter(r16, "code");
        Intrinsics.checkNotNullParameter(r17, "codeVerifier");
        int r5 = n.a;
        LarkLogin.g.getClass();
        String r6 = LarkLogin.a.a();
        String r7 = r0.a;
        Intrinsics.checkNotNullParameter(r6, "platformAppId");
        Intrinsics.checkNotNullParameter(r16, "code");
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r17, "codeVerifier");
        Intrinsics.checkNotNullParameter("doubaolarkauth://flow/enterprise_auth_login", "redirectUri");
        Intrinsics.checkNotNullParameter(r1, "osType");
        Intrinsics.checkNotNullParameter(r2, "terminalType");
        Map r18 = MapsKt.mapOf(new Pair[]{TuplesKt.to("platform_name", "lark"), TuplesKt.to("platform_app_id", r6), TuplesKt.to("code", r16), TuplesKt.to("scope", r7), TuplesKt.to("code_verifier", r17), TuplesKt.to("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login"), TuplesKt.to("os_type", r1), TuplesKt.to("terminal_type", r2)});
        d0.c().b("/passport/doubao/update_authorize_info/", null, r18, new i(r0, r1, r2, r15));
        return Unit.INSTANCE;
    }
}
