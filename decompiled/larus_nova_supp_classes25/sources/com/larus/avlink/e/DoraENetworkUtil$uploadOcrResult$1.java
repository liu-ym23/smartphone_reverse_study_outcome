package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.DoraENetworkUtil$uploadOcrResult$1", f = "DoraENetworkUtil.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
final class DoraENetworkUtil$uploadOcrResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $imageId;
    final /* synthetic */ Function2<Boolean, AsyncThrowable, Unit> $onComplete;
    final /* synthetic */ int $productType;
    final /* synthetic */ List<f98.r> $visionInfo;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraENetworkUtil$uploadOcrResult$1(int r1, Function2<? super Boolean, ? super AsyncThrowable, Unit> r2, List<f98.r> r3, int r4, Continuation<? super DoraENetworkUtil$uploadOcrResult$1> r5) {
        this.$imageId = r1;
        this.$onComplete = r2;
        this.$visionInfo = r3;
        this.$productType = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraENetworkUtil$uploadOcrResult$1(this.$imageId, this.$onComplete, this.$visionInfo, this.$productType, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        com.larus.network.http.f r12 = (com.larus.network.http.a) r11;
        if ((r12 instanceof y) == false) goto L15;
        FLogger.a.i("DoraE_Camera", "uploadOcrResult finish. imageId: " + this.$imageId + "  resp: " + r12);
    L18:
        Function2<Boolean, AsyncThrowable, Unit> r3 = this.$onComplete;
        if (r3 == null) goto L26;
        Boolean r4 = Boxing.boxBoolean(r2);
        if ((r12 instanceof com.larus.network.http.f) == false) goto L23;
        AsyncThrowable r13 = r12.d;
    L24:
        r3.invoke(r4, r13);
        goto L26
    L23:
        r13 = null;
    L26:
        return Unit.INSTANCE;
    L15:
        if ((r12 instanceof com.larus.network.http.f) == false) goto L17;
        FLogger.a.e("DoraE_Camera", "uploadOcrResult failed. imageId: " + this.$imageId, r12.d);
    L17:
        r2 = false;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        f98.p r14 = new f98.p();
        List<f98.r> r5 = this.$visionInfo;
        int r6 = this.$productType;
        r14.a(r5);
        r14.b(Boxing.boxInt(r6));
        com.larus.dora.api.network.a r7 = com.larus.dora.api.network.a.a;
        JSONObject r8 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r14));
        this.label = 1;
        r11 = com.larus.dora.api.network.a.c(r7, Object.class, "/alice/audio/upload_vision_extra_info", r8, null, this, 248);
        if (r11 != r0) goto L11;
        return r0;
    }
}
