package com.larus.common.account.bdauth.repository;

import com.larus.account.base.api.IMultiAccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements Function4<Boolean, String, Integer, String, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<List<q38.b>> a;

    public i(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3, Object r4, Object r5) {
        boolean r6 = ((Boolean) r2).booleanValue();
        String r7 = (String) r3;
        int r8 = ((Number) r4).intValue();
        String r9 = (String) r5;
        if (r6 == true) goto L7;
        FLogger.a.w("BDAuthorizeRepository", "fetchServerAccountList failed, code=" + r8 + ", msg=" + r9);
        if (this.a.isActive() == false) goto L11;
        kotlinx.coroutines.i<List<q38.b>> r10 = this.a;
        Result.Companion r11 = Result.Companion;
        r10.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
    L11:
        return Unit.INSTANCE;
    L7:
        List r12 = IMultiAccountService.a.g();
        if (this.a.isActive() == false) goto L11;
        this.a.resumeWith(Result.constructor-impl(r12));
        goto L11
    }
}
