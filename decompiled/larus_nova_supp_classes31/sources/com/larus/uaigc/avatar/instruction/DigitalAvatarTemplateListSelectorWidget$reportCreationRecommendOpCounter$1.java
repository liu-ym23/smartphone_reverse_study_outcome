package com.larus.uaigc.avatar.instruction;

import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.avatar.instruction.DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1", f = "DigitalAvatarTemplateListSelectorWidget.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $templatePrimaryKey;
    int label;

    public DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1(long r1, Continuation<? super DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1> r3) {
        this.$templatePrimaryKey = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1(this.$templatePrimaryKey, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        com.larus.network.http.f r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof com.larus.network.http.f) == false) goto L15;
        FLogger.a.e("DigitalAvatarTemplateListSelectorWidget", "api(/alice/community/creation/report_counter) error, msg:" + r15.d);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        long r5 = this.$templatePrimaryKey;
        r4.put("name_space", "community_creation_click");
        r4.put("operator", 1);
        r4.put("entity_id", String.valueOf(r5));
        Unit r6 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", String.class, "/alice/community/creation/report_counter", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}
