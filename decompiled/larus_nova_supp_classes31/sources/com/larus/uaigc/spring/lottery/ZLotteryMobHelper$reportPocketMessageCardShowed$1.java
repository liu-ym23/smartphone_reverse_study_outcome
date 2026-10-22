package com.larus.uaigc.spring.lottery;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.lottery.ZLotteryMobHelper$reportPocketMessageCardShowed$1", f = "ZLotteryMobHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ZLotteryMobHelper$reportPocketMessageCardShowed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardType;
    final /* synthetic */ long $createToLynxDuration;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ Boolean $isStream;
    final /* synthetic */ boolean $lynxViewLoadSuccess;
    final /* synthetic */ String $messageId;
    int label;

    public ZLotteryMobHelper$reportPocketMessageCardShowed$1(String r1, boolean r2, long r3, String r5, int r6, String r7, Boolean r8, Continuation<? super ZLotteryMobHelper$reportPocketMessageCardShowed$1> r9) {
        this.$messageId = r1;
        this.$lynxViewLoadSuccess = r2;
        this.$createToLynxDuration = r3;
        this.$cardType = r5;
        this.$errorCode = r6;
        this.$errorMsg = r7;
        this.$isStream = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ZLotteryMobHelper$reportPocketMessageCardShowed$1(this.$messageId, this.$lynxViewLoadSuccess, this.$createToLynxDuration, this.$cardType, this.$errorCode, this.$errorMsg, this.$isStream, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r10);
        int r11 = ZLotteryMobHelper.a;
        JSONObject r12 = new JSONObject();
        String r0 = this.$messageId;
        boolean r1 = this.$lynxViewLoadSuccess;
        long r2 = this.$createToLynxDuration;
        String r4 = this.$cardType;
        int r5 = this.$errorCode;
        String r6 = this.$errorMsg;
        Boolean r7 = this.$isStream;
        r12.put("message_id", r0);
        r12.put("lynx_view_load_result", de8.d.b(Boxing.boxBoolean(r1)));
        r12.put("create_to_lynx_duration", r2);
        r12.put("card_type", r4);
        r12.putOpt("error_code", Boxing.boxInt(r5));
        r12.putOpt("error_msg", r6);
        r12.putOpt("is_stream", de8.d.b(r7));
        Unit r3 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("pocket_message_card_showed", "eventName");
        Intrinsics.checkNotNullParameter(r12, "dataJson");
        o.a.reportEvent("pocket_message_card_showed", r12);     // Catch: Exception -> L7
        com.larus.platform.service.g.a.monitorEventForSlardar("pocket_message_card_showed", r12, new JSONObject(), null);     // Catch: Exception -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        FLogger.a.e("ZLotteryMobHelper", "reportEvent error", e);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
