package com.larus.canvas.service.internal;

import com.larus.canvas.feature.api.CanvasApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ny8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.GetCanvasBlockInfoProcessor$process$1", f = "GetCanvasBlockInfoProcessor.kt", i = {0}, l = {26}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class GetCanvasBlockInfoProcessor$process$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetCanvasBlockInfoProcessor this$0;

    public GetCanvasBlockInfoProcessor$process$1(GetCanvasBlockInfoProcessor r1, Continuation<? super GetCanvasBlockInfoProcessor$process$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        GetCanvasBlockInfoProcessor$process$1 r0 = new GetCanvasBlockInfoProcessor$process$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L11:
        dm9.a.b r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L17;
        i r3 = (i) r15.a.getData();
        if (r3 == null) goto L16;
        GetCanvasBlockInfoProcessor r4 = this.this$0;
        BuildersKt.launch$default((CoroutineScope) r4.c.getValue(), null, null, new AbsProcessor$onSuccess$1(r4, r3, null), 3, null);
        FLogger.a.i(r4.e, "success  " + r15);
    L38:
        return Unit.INSTANCE;
    L16:
        GetCanvasBlockInfoProcessor r5 = this.this$0;
        ny8.b r6 = new ny8.b(Boxing.boxInt(1), 6);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "error");
        BuildersKt.launch$default((CoroutineScope) r5.c.getValue(), null, null, new AbsProcessor$onFailure$1(r5, r6, null), 3, null);
        FLogger.a.e(r5.e, "failed " + r15);
        goto L38
    L17:
        GetCanvasBlockInfoProcessor r7 = this.this$0;
        boolean r8 = r15 instanceof dm9.a.a;
        if (r8 == false) goto L20;
        dm9.a.a r9 = (dm9.a.a) r15;
    L21:
        if (r9 == null) goto L23;
        Integer r10 = Boxing.boxInt(r9.a);
    L24:
        if (r8 == false) goto L26;
        dm9.a.a r11 = (dm9.a.a) r15;
    L27:
        if (r11 == null) goto L29;
        String r12 = r11.b;
    L30:
        if (r8 == false) goto L32;
        dm9.a.a r13 = (dm9.a.a) r15;
    L33:
        if (r13 == null) goto L35;
        Throwable r16 = r13.c;
    L36:
        ny8.b r17 = new ny8.b(r10, r12, r16);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r17, "error");
        BuildersKt.launch$default((CoroutineScope) r7.c.getValue(), null, null, new AbsProcessor$onFailure$1(r7, r17, null), 3, null);
        FLogger.a.e(this.this$0.e, "failed " + r15);
        goto L38
    L35:
        r16 = null;
        goto L36
    L32:
        r13 = null;
        goto L33
    L29:
        r12 = null;
        goto L30
    L26:
        r11 = null;
        goto L27
    L23:
        r10 = null;
        goto L24
    L20:
        r9 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        CanvasApi.a r19 = CanvasApi.a;
        GetCanvasBlockInfoProcessor$process$1$resp$1 r20 = new GetCanvasBlockInfoProcessor$process$1$resp$1(this.this$0, null);
        this.L$0 = r18;
        this.label = 1;
        r19.getClass();
        FlowHttpConnection r110 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Social", CanvasApi.class, r20, true, "/creativity/canvas/get_canvas_block_info", null, null, this, 224);
        if (r14 != r0) goto L11;
        return r0;
    }
}
