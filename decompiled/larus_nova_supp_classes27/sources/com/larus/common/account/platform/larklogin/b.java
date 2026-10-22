package com.larus.common.account.platform.larklogin;

import com.bytedance.sdk.account.impl.d0;
import com.larus.account.base.impl.LoginServiceImpl;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import n38.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Function3 {
    public final /* synthetic */ t a;
    public final /* synthetic */ LarkLogin b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(LoginServiceImpl.c r1, LarkLogin r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6, Object r7, Object r8) {
        t r0 = this.a;
        LarkLogin r1 = this.b;
        String r2 = this.c;
        String r9 = (String) r6;
        String r10 = (String) r7;
        String r11 = (String) r8;
        LarkLogin.a r3 = LarkLogin.g;
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r11, "codeVerifier");
        r0.a();
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("code", r10);
        LarkLogin.g.getClass();
        r4.put("platform_app_id", LarkLogin.a.a());
        r4.put("platform", "lark");
        r4.put("code_verifier", r11);
        r4.put("scope", r1.a);
        r4.put("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login");
        if (r2 == null) goto L5;
        r4.put("sec_uid", r2);
    L5:
        j r12 = new j(r1, r9);
        d0.c().b("/passport/doubao/lark/login/", null, r4, r12);
        return Unit.INSTANCE;
    }
}
