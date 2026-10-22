package com.larus.canvas.feature.component.logic;

import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$onRemoteImageSelected$1", f = "GenImagePlannerComponent.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$onRemoteImageSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.j $imageInfo;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$onRemoteImageSelected$1(GenImagePlannerComponent r1, ky8.j r2, Continuation<? super GenImagePlannerComponent$onRemoteImageSelected$1> r3) {
        this.this$0 = r1;
        this.$imageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GenImagePlannerComponent$onRemoteImageSelected$1(this.this$0, this.$imageInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        StateFlowImpl r6 = this.this$0.m;
        final ky8.j r3 = this.$imageInfo;
        com.larus.canvas.feature.component.logic.helper.f.a(r6, new p1(r3));
        if (z2.a.enableCreationResourceAccessPipeline() == false) goto L15;
        GenImagePlannerComponent r7 = this.this$0;
        ky8.j r4 = this.$imageInfo;
        this.label = 1;
        if (GenImagePlannerComponent.z3(r7, r4, this) != r0) goto L14;
        return r0;
    L15:
        String r8 = this.$imageInfo.a;
        int r9 = 0;
        if (r8 != null) goto L18;
    L21:
        if (r2 == true) goto L31;
        Integer r10 = this.$imageInfo.c;
        if (r10 == null) goto L25;
        int r11 = r10.intValue();
    L26:
        if (r11 == 0) goto L31;
        Integer r12 = this.$imageInfo.d;
        if (r12 == null) goto L30;
        r9 = r12.intValue();
    L30:
        if (r9 == 0) goto L31;
    L33:
        return Unit.INSTANCE;
    L25:
        r11 = 0;
    L31:
        this.this$0.V3(this.$imageInfo.b);
        goto L33
    L18:
        if (r8.length() == 0) goto L21;
        r2 = false;
        goto L21
    }
}
