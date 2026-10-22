package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.security.compliance.infra.base.UserScopeProxy;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends UserScopeProxy<g> implements g {
    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        return ((g) rf()).U(r2);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single v5(String r3) {
        Intrinsics.checkNotNullParameter("fixed:advanced_login:geo_restricted", "displayKey");
        Intrinsics.checkNotNullParameter(r3, "traceId");
        return ((g) rf()).v5(r3);
    }

    public c(com.ss.android.lark.passportc.api.j r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "accessor");
        super(r2, r3, g.class);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<? extends CustomDisplayConfig> Ld(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "traceId");
        return ((g) rf()).Ld(r2, r3);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final void S5(List<String> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "ids");
        g.a.a((g) rf(), r1);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<CustomDisplayModel> ye(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "traceId");
        return ((g) rf()).ye(r2, r3);
    }
}
