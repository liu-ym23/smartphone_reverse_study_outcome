package com.larus.camera.impl.ui.component.result.general;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$initPreviewThumbList$5", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$initPreviewThumbList$5 extends SuspendLambda implements Function2<Triple<? extends Boolean, ? extends Boolean, ? extends Boolean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    public ResultPreviewComponent$initPreviewThumbList$5(ResultPreviewComponent r1, Continuation<? super ResultPreviewComponent$initPreviewThumbList$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultPreviewComponent$initPreviewThumbList$5 r0 = new ResultPreviewComponent$initPreviewThumbList$5(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Triple) r1, (Continuation) r2);
    }

    public final Object invoke(Triple<Boolean, Boolean, Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r3);
        Triple r4 = (Triple) this.L$0;
        boolean r0 = ((Boolean) r4.component1()).booleanValue();
        boolean r1 = ((Boolean) r4.component2()).booleanValue();
        boolean r5 = ((Boolean) r4.component3()).booleanValue();
        if (r0 == true) goto L23;
        if (r1 == true) goto L23;
        if (r5 == true) goto L23;
        if (this.this$0.r == true) goto L18;
        com.larus.camera.impl.ui.viewmodel.t r6 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (com.larus.camera.impl.ui.viewmodel.t.e() <= 1) goto L18;
        LarusLayoutViewPreviewComponentBinding r7 = this.this$0.m;
        if (r7 == null) goto L29;
        RecyclerView r8 = r7.c;
        if (r8 == null) goto L29;
        com.larus.utils.e1.x(r8);
    L29:
        return Unit.INSTANCE;
    L18:
        LarusLayoutViewPreviewComponentBinding r9 = this.this$0.m;
        if (r9 == null) goto L29;
        RecyclerView r10 = r9.c;
        if (r10 == null) goto L29;
        com.larus.utils.e1.o(r10);
    L23:
        LarusLayoutViewPreviewComponentBinding r11 = this.this$0.m;
        if (r11 == null) goto L29;
        RecyclerView r12 = r11.c;
        if (r12 == null) goto L29;
        com.larus.utils.e1.o(r12);
        goto L29
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
