package com.larus.agents.impl.network;

import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class NetworkOfficeTaskPreferenceRemoteDataSource implements com.larus.agents.impl.settings.d {

    public static final class a {
    }

    static {
    }

    public NetworkOfficeTaskPreferenceRemoteDataSource() {
    }

    @Override // com.larus.agents.impl.settings.d
    public final Object a(Continuation<? super Result<com.larus.agents.impl.settings.b>> r7) {
        if ((r7 instanceof NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1) == false) goto L7;
        NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1 r0 = (NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == false) goto L29;
        BizResponse r10 = r9.a;
        if (r10.isSuccess() == false) goto L27;
        Result.Companion r5 = Result.Companion;
        d r11 = (d) r10.getData();
        if (r11 == null) goto L24;
        r4 = r11.a();
    L24:
        if (r4 != null) goto L37;
        r4 = "";
    L37:
        return Result.constructor-impl(new com.larus.agents.impl.settings.b(r4, 0));
    L27:
        FLogger.a.w("AgentsMdRemoteDataSource", "get agents.md failed, code=" + r10.getCode());
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("get agents.md failed")));
    L29:
        if ((r9 instanceof dm9.a.a) == false) goto L36;
        FLogger r6 = FLogger.a;
        StringBuilder r13 = new StringBuilder("get agents.md error, code=");
        dm9.a.a r14 = (dm9.a.a) r9;
        r13.append(r14.a);
        r6.w("AgentsMdRemoteDataSource", r13.toString());
        Result.Companion r15 = Result.Companion;
        Throwable r16 = r14.c;
        if (r16 != null) goto L34;
        r16 = new IllegalStateException("get agents.md request error");
    L34:
        return Result.constructor-impl(ResultKt.createFailure(r16));
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        AgentsMdApi.a r17 = AgentsMdApi.a;
        NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1 r19 = new NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1(null);
        r0.label = 1;
        r17.getClass();
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new AgentsMdApi$Companion$safeCall$2(r19, "/alice/generaltask/memory/get_agentsmd", null), r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new NetworkOfficeTaskPreferenceRemoteDataSource$fetch$1(this, r7);
        goto L8
    }

    @Override // com.larus.agents.impl.settings.d
    public final Object b(com.larus.agents.impl.settings.b r6, Continuation<? super OfficeTaskPreferenceSaveResult> r7) {
        if ((r7 instanceof NetworkOfficeTaskPreferenceRemoteDataSource$save$1) == false) goto L7;
        NetworkOfficeTaskPreferenceRemoteDataSource$save$1 r0 = (NetworkOfficeTaskPreferenceRemoteDataSource$save$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == false) goto L30;
        dm9.a.b r10 = r9;
        long r4 = r10.a.getCode();
        if (r4 != 0) goto L23;
        OfficeTaskPreferenceSaveResult r11 = OfficeTaskPreferenceSaveResult.SUCCESS;
    L27:
        if (r11 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L35;
        FLogger.a.w("AgentsMdRemoteDataSource", "set agents.md failed, code=" + r10.a.getCode());
        return r11;
    L35:
        return r11;
    L23:
        if (r4 != 671020000) goto L25;
        r11 = OfficeTaskPreferenceSaveResult.SECURITY_RISK;
        goto L27
    L25:
        r11 = OfficeTaskPreferenceSaveResult.FAILURE;
        goto L27
    L30:
        if ((r9 instanceof dm9.a.a) == false) goto L34;
        FLogger.a.w("AgentsMdRemoteDataSource", "set agents.md error, code=" + ((dm9.a.a) r9).a);
        return OfficeTaskPreferenceSaveResult.FAILURE;
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        AgentsMdApi.a r12 = AgentsMdApi.a;
        NetworkOfficeTaskPreferenceRemoteDataSource$save$result$1 r5 = new NetworkOfficeTaskPreferenceRemoteDataSource$save$result$1(r6, null);
        r0.label = 1;
        r12.getClass();
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new AgentsMdApi$Companion$safeCall$2(r5, "/alice/generaltask/memory/set_agentsmd", null), r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new NetworkOfficeTaskPreferenceRemoteDataSource$save$1(this, r7);
        goto L8
    }
}
