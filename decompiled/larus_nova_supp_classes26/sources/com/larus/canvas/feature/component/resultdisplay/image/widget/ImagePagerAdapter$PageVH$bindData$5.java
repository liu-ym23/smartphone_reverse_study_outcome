package com.larus.canvas.feature.component.resultdisplay.image.widget;

import com.larus.canvas.feature.component.resultdisplay.image.v;
import com.larus.canvas.feature.component.resultdisplay.image.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.widget.ImagePagerAdapter$PageVH$bindData$5", f = "ImagePagerAdapter.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, s = {})
final class ImagePagerAdapter$PageVH$bindData$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ v $saveAction;
    int label;
    final /* synthetic */ ImagePagerAdapter.PageVH this$0;

    public ImagePagerAdapter$PageVH$bindData$5(ImagePagerAdapter.PageVH r1, v r2, Continuation<? super ImagePagerAdapter$PageVH$bindData$5> r3) {
        this.this$0 = r1;
        this.$saveAction = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImagePagerAdapter$PageVH$bindData$5(this.this$0, this.$saveAction, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        y r8 = this.this$0.q;
        if (r8 == null) goto L19;
        ImagePagerAdapter.PageVH r3 = this.this$0;
        v r4 = this.$saveAction;
        s r5 = r3.V3();
        if (r8.f == 2) goto L17;
        r2 = false;
    L17:
        r5.a(r2, r8.a, r8.g);
        r3.g.a(r8.d, r8.e);
        r3.X3(r8, r4);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L11;
        return r0;
    }
}
