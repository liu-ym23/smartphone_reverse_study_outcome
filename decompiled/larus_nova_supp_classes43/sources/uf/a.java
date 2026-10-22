package uf;

import com.bytedance.android.ec.common.api.domainselect.IDomainSelect;
import com.bytedance.android.ec.core.opt.ab.p;
import jj4.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IDomainSelect {

    /* JADX INFO: renamed from: uf.a$a, reason: collision with other inner class name */
    public static final class C0203a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.android.ec.common.api.domainselect.IDomainSelect
    public final String selectedHost() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_use_domain_ecombdapi", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r12).booleanValue() == false) goto L16;
        return "https://ecom.ecombdapi.com";
    L16:
        return "https://aweme.snssdk.com";
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }
}
