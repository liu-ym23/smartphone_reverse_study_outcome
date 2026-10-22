package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public final List<n> a;
    public final int b;
    public final PolicyModel c;
    public final ValidateConfig d;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.conditional.access.auth.v2.c a(PolicyModel r8) {
        Intrinsics.checkNotNullParameter(r8, "policyModel");
        if (this.b < this.a.size()) goto L6;
        ScsLogger.c("SecurityPolicy_SyncCheckChain", "index >= interceptors.size!");
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L6:
        g r0 = new g(this.a, this.b + 1, r8, this.d);
        return ((n) ListProtector.get(this.a, this.b)).a(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends n> r2, int r3, PolicyModel r4, ValidateConfig r5) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r4, "mPolicyModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
