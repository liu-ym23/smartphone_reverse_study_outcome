package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.larus.avlink.e.DoraENetworkUtil$uploadOcrDetectionResult$1", f = "DoraENetworkUtil.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
final class DoraENetworkUtil$uploadOcrDetectionResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $imageId;
    final /* synthetic */ boolean $ocrDetectionRes;
    final /* synthetic */ Function2<Boolean, AsyncThrowable, Unit> $onComplete;
    final /* synthetic */ int $productType;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraENetworkUtil$uploadOcrDetectionResult$1(int r1, Function2<? super Boolean, ? super AsyncThrowable, Unit> r2, int r3, boolean r4, Continuation<? super DoraENetworkUtil$uploadOcrDetectionResult$1> r5) {
        this.$imageId = r1;
        this.$onComplete = r2;
        this.$productType = r3;
        this.$ocrDetectionRes = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraENetworkUtil$uploadOcrDetectionResult$1(this.$imageId, this.$onComplete, this.$productType, this.$ocrDetectionRes, r8);
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
        FLogger.a.i("DoraE_Camera", "uploadOcrDetectionResult finish. imageId: " + this.$imageId + ", resp: " + r12);
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
        FLogger.a.e("DoraE_Camera", "uploadOcrDetectionResult failed. imageId: " + this.$imageId, r12.d);
    L17:
        r2 = false;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        f98.p r14 = new f98.p();
        int r5 = this.$productType;
        boolean r6 = this.$ocrDetectionRes;
        int r7 = this.$imageId;
        f98.r r8 = new f98.r();
        f98.s r9 = new f98.s();
        r9.a(String.valueOf(r7));
        r9.b(Boxing.boxInt(2));
        r8.d(r9);
        r8.c(Boxing.boxInt(2));
        r8.b(Boxing.boxBoolean(r6));
        r14.a(CollectionsKt.listOf(r8));
        r14.b(Boxing.boxInt(r5));
        com.larus.dora.api.network.a r10 = com.larus.dora.api.network.a.a;
        JSONObject r15 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r14));
        this.label = 1;
        r11 = com.larus.dora.api.network.a.c(r10, Object.class, "/alice/audio/upload_vision_extra_info", r15, null, this, 248);
        if (r11 != r0) goto L11;
        return r0;
    }
}
