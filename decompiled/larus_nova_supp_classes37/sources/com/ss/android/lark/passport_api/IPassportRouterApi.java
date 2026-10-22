package com.ss.android.lark.passport_api;

import android.content.Context;
import com.ss.android.lark.passport.signinsdk_api.base.network.bizflow.BizFlowPayload;
import dzb.d;
import kotlin.Result;
import kotlinx.coroutines.flow.i1;
import tzb.a;
import tzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IPassportRouterApi {
    void doDoubaoLogin(Context r1, BizFlowPayload r2, d<Object> r3);

    void getABTestValue(d<Boolean> r1);

    void joinTeamByCode(Context r1, String r2, String r3, BizFlowPayload r4, a r5);

    i1<Result<Object>> preTenantCreate(BizFlowPayload r1, String r2);

    void registerRouterCallback(String r1, b r2);

    void routerNext(Context r1, String r2, BizFlowPayload r3, a r4);

    void ugLog(String r1);
}
