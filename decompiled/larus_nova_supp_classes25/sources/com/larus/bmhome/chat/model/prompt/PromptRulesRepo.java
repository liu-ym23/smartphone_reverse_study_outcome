package com.larus.bmhome.chat.model.prompt;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.bean.IsSuggestWordsHitRulesRequest;
import com.larus.bmhome.chat.bean.IsSuggestWordsHitRulesResponse;
import com.larus.bmhome.chat.bean.RuleRequestParamRequest;
import com.larus.bmhome.chat.model.repo.PromptRulesApi;
import com.larus.bmhome.chat.model.repo.UpdateWcbSuggestsApi;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import ic8.r0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PromptRulesRepo {
    public static final PromptRulesRepo a = null;

    static {
        a = new PromptRulesRepo();
    }

    public PromptRulesRepo() {
    }

    public final Object a(List<RuleRequestParamRequest> r13, int r14, Continuation<? super List<r0>> r15) {
        if ((r15 instanceof PromptRulesRepo$getPromptRules$1) == false) goto L7;
        PromptRulesRepo$getPromptRules$1 r0 = (PromptRulesRepo$getPromptRules$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PromptRulesRepo$getPromptRules$1 r10 = r0;
        Object r16 = r10.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        y r17 = (a) r16;
        if ((r17 instanceof y) == false) goto L30;
        y r18 = r17;
        Long r19 = r18.g;
        if (r19 == null) goto L30;
        if (r19.longValue() != 0) goto L30;
        IsSuggestWordsHitRulesResponse r110 = (IsSuggestWordsHitRulesResponse) ((a) r18).b;
        if (r110 == null) goto L31;
        List<r0> r111 = r110.getRulesData();
        if (r111 != null) goto L29;
        return null;
    L29:
        return CollectionsKt.filterNotNull(r111);
    L31:
        return null;
    L30:
        FLogger.a.e("PromptLaunchRepo", "failed in fetch prompt rules remote");
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        PromptRulesApi.a r112 = PromptRulesApi.a;
        IsSuggestWordsHitRulesRequest r4 = new IsSuggestWordsHitRulesRequest(r13, Boxing.boxInt(r14), Boxing.boxInt(1));
        Gson r113 = new Gson();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r113, "gson");
        JSONObject r5 = new JSONObject(GsonProtectorUtils.toJson(r113, r4));
        r10.label = 1;
        r112.getClass();
        r16 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, "Message", IsSuggestWordsHitRulesResponse.class, "/biz/onboarding/is_hit_risk_word", r5, null, true, null, MapsKt.mapOf(TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue())), r10, 944);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new PromptRulesRepo$getPromptRules$1(this, r15);
        goto L8
    }

    public final Object b(String r11, String r12, String r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof PromptRulesRepo$updateWcbSuggests$1) == false) goto L7;
        PromptRulesRepo$updateWcbSuggests$1 r0 = (PromptRulesRepo$updateWcbSuggests$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PromptRulesRepo$updateWcbSuggests$1 r8 = r0;
        Object r15 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        dm9.a.a r16 = (dm9.a) r15;
        if ((r16 instanceof dm9.a.b) == false) goto L21;
        FLogger.a.i("PromptLaunchRepo", "success updateWcbSuggests");
    L24:
        return Unit.INSTANCE;
    L21:
        if ((r16 instanceof dm9.a.a) == false) goto L24;
        FLogger.a.e("PromptLaunchRepo", "failed updateWcbSuggests " + r16.c);
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        UpdateWcbSuggestsApi.a r17 = UpdateWcbSuggestsApi.a;
        PromptRulesRepo$updateWcbSuggests$result$1 r4 = new PromptRulesRepo$updateWcbSuggests$result$1(r12, r11, r13, null);
        r8.label = 1;
        r17.getClass();
        FlowHttpConnection r18 = FlowHttpConnection.a;
        r15 = FlowHttpConnection.g("Message", UpdateWcbSuggestsApi.class, r4, false, null, null, null, r8, 248);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new PromptRulesRepo$updateWcbSuggests$1(this, r14);
        goto L8
    }
}
