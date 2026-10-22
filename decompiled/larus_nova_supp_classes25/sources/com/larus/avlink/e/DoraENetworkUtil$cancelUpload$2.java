package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.DoraENetworkUtil$cancelUpload$2", f = "DoraENetworkUtil.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_CALL_BY_CONVERSATION_MODE}, m = "invokeSuspend", n = {}, s = {})
final class DoraENetworkUtil$cancelUpload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $imageId;
    final /* synthetic */ List<b49.h> $images;
    final /* synthetic */ int $mode;
    final /* synthetic */ Function1<Boolean, Unit> $onComplete;
    final /* synthetic */ int $productType;
    final /* synthetic */ int $scene;
    final /* synthetic */ int $status;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraENetworkUtil$cancelUpload$2(int r1, int r2, Function1<? super Boolean, Unit> r3, String r4, String r5, int r6, List<b49.h> r7, int r8, int r9, Continuation<? super DoraENetworkUtil$cancelUpload$2> r10) {
        this.$imageId = r1;
        this.$mode = r2;
        this.$onComplete = r3;
        this.$botId = r4;
        this.$conversationId = r5;
        this.$scene = r6;
        this.$images = r7;
        this.$productType = r8;
        this.$status = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new DoraENetworkUtil$cancelUpload$2(this.$imageId, this.$mode, this.$onComplete, this.$botId, this.$conversationId, this.$scene, this.$images, this.$productType, this.$status, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [f98.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r13) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r8 = false;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
        Object r1 = r13;
    L28:
        com.larus.network.http.a r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof y) == false) goto L32;
        FLogger.a.i("DoraE_Camera", "cancelUpload success. imageId: " + this.$imageId + ", mode: " + this.$mode);
        r8 = true;
    L34:
        Function1<Boolean, Unit> r3 = this.$onComplete;
        if (r3 == null) goto L38;
        r3.invoke(Boxing.boxBoolean(r8));
    L38:
        return Unit.INSTANCE;
    L32:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L34;
        FLogger.a.i("DoraE_Camera", "cancelUpload failed. imageId: " + this.$imageId + ", mode: " + this.$mode);
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        ?? r4 = new f98.e();
        String r5 = this.$botId;
        String r6 = this.$conversationId;
        int r9 = this.$mode;
        int r10 = this.$scene;
        List<b49.h> r11 = this.$images;
        int r12 = this.$productType;
        int r14 = this.$status;
        int r15 = this.$imageId;
        r4.c(r5);
        r4.e(r6);
        r4.a = 0;
        r4.b = r9;
        r4.i(r10);
        if (r11 != null) goto L11;
    L13:
        boolean r16 = false;
    L14:
        if (r16 == false) goto L24;
        List r17 = CollectionsKt.filterNotNull(r11);
        ?? r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L17:
        if (r19.hasNext() == false) goto L25;
        f98.l r20 = f98.g.b((b49.h) r19.next(), r9);
        if (r20 == null) goto L21;
        r20.g(null);
        r20.i(r14);
    L22:
        if (r20 == null) goto L17;
        r18.add(r20);
        goto L17
    L21:
        r20 = null;
    L25:
        r4.d(r18);
        r4.h(r12);
        com.larus.dora.api.network.a r21 = com.larus.dora.api.network.a.a;
        JSONObject r22 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r4));
        this.label = 1;
        r1 = com.larus.dora.api.network.a.c(r21, f98.h.class, "/alice/audio/process_vision_file", r22, null, this, 248);
        if (r1 != r7) goto L28;
        return r7;
    L24:
        f98.l r23 = new f98.l();
        r23.f(6);
        r23.m(String.valueOf(r15));
        r23.i(r14);
        r18 = CollectionsKt.listOf(r23);
        goto L25
    L11:
        if ((!r11.isEmpty()) != true) goto L13;
        r16 = true;
        goto L14
    }
}
