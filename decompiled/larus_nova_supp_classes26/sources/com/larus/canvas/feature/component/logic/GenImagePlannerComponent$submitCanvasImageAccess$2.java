package com.larus.canvas.feature.component.logic;

import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/resource/access/ResourceAccessState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$submitCanvasImageAccess$2", f = "GenImagePlannerComponent.kt", i = {0}, l = {317}, m = "invokeSuspend", n = {"task"}, s = {"L$0"})
public final class GenImagePlannerComponent$submitCanvasImageAccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.resource.access.a0>, Object> {
    final /* synthetic */ String $logScene;
    final /* synthetic */ com.larus.uaigc.service.p0 $request;
    Object L$0;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$submitCanvasImageAccess$2(com.larus.uaigc.service.p0 r1, GenImagePlannerComponent r2, String r3, Continuation<? super GenImagePlannerComponent$submitCanvasImageAccess$2> r4) {
        this.$request = r1;
        this.this$0 = r2;
        this.$logScene = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenImagePlannerComponent$submitCanvasImageAccess$2(this.$request, this.this$0, this.$logScene, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.bmhome.resource.access.a0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larus.bmhome.resource.access.b0 r2 = (com.larus.bmhome.resource.access.b0) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        com.larus.bmhome.resource.access.a0 r8 = (com.larus.bmhome.resource.access.a0) r7;
        GenImagePlannerComponent.Y2(this.this$0, this.$logScene, r2.getTaskId(), r8);
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final com.larus.bmhome.resource.access.b0 r9 = ICreationResourceAccessService.a.b(this.$request);
        final GenImagePlannerComponent r3 = this.this$0;
        final String r4 = this.$logScene;
        Function1 r5 = new q1(r3, r4, r9);
        Function1 r6 = new r1(r3, r4, r9);
        this.L$0 = r9;
        this.label = 1;
        Object r10 = ICreationResourceAccessServiceKt.a(r9, r5, r6, this);
        if (r10 != r0) goto L11;
        return r0;
    L11:
        r2 = r9;
        r7 = r10;
        goto L12
    }
}
