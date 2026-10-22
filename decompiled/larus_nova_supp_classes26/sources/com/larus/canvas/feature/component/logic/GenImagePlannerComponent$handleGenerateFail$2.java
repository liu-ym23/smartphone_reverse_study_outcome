package com.larus.canvas.feature.component.logic;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$handleGenerateFail$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1262, 1273}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$handleGenerateFail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $curTaskPosition;
    final /* synthetic */ String $localId;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$handleGenerateFail$2(GenImagePlannerComponent r1, String r2, int r3, Continuation<? super GenImagePlannerComponent$handleGenerateFail$2> r4) {
        this.this$0 = r1;
        this.$localId = r2;
        this.$curTaskPosition = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenImagePlannerComponent$handleGenerateFail$2(this.this$0, this.$localId, this.$curTaskPosition, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L23:
        GenImagePlannerComponent r10 = this.this$0;
        String r2 = this.$localId;
        Function1<? super ky8.f, ky8.f> r3 = new l1();
        int r4 = GenImagePlannerComponent.W;
        r10.W4(r2, r3);
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L14:
        if (this.$curTaskPosition == ((Number) ((Pair) this.this$0.q.getValue()).getFirst()).intValue()) goto L16;
        this.this$0.W4(this.$localId, new l1());
        goto L26
    L16:
        if (this.$curTaskPosition != (((ky8.g) this.this$0.m.getValue()).a.size() - 1)) goto L20;
        com.larus.canvas.feature.component.resultdisplay.image.r r11 = this.this$0.Z3();
        if (r11 == null) goto L20;
        r11.yS(new com.larus.canvas.feature.component.resultdisplay.image.t.a(((ky8.g) this.this$0.m.getValue()).a.size() - 2, true));
    L20:
        this.label = 2;
        if (DelayKt.delay(200, this) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        GenImagePlannerComponent r12 = this.this$0;
        String r5 = this.$localId;
        Function1<? super ky8.f, ky8.f> r6 = new k1();
        int r7 = GenImagePlannerComponent.W;
        r12.W4(r5, r6);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L14;
        return r0;
    }
}
