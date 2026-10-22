package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.security.compliance.infra.base.UserScopeProxy;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends UserScopeProxy<a> implements a {
    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final boolean C5(InternalSecurityAction r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        return ((a) rf()).C5(r2);
    }

    @Override // com.ss.android.lark.conditional.access.traffic.handler.policy.center.a
    public final void i3(InternalSecurityAction r2) {
        ((a) rf()).i3(r2);
    }

    public c(j r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "accessor");
        super(r2, r3, a.class);
    }
}
