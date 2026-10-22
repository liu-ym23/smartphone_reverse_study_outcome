package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.l;
import i8b.n;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements l {
    public final List<n> a;
    public final int b;
    public final List<PolicyModel> c;
    public final ValidateConfig d;
    public final String e;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.auth.v2.service.chain.a$a, reason: collision with other inner class name */
    public static final class C0154a {
    }

    static {
    }

    @Override // i8b.l
    public final String getTraceId() {
        return this.e;
    }

    @Override // i8b.l
    public final Object a(List<PolicyModel> r8, Continuation<? super Map<String, com.ss.android.lark.conditional.access.auth.v2.c>> r9) {
        if (this.b < this.a.size()) goto L6;
        ScsLogger.c("SecurityPolicy_AsyncCheckChain", "index >= interceptors.size!");
        return com.ss.android.lark.conditional.access.utils.e.b(r8);
    L6:
        a r6 = new a(this.a, this.b + 1, r8, this.d, this.e);
        return ((n) ListProtector.get(this.a, this.b)).b(r6, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends n> r2, int r3, List<PolicyModel> r4, ValidateConfig r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r4, "mPolicyModels");
        Intrinsics.checkNotNullParameter(r6, "traceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
