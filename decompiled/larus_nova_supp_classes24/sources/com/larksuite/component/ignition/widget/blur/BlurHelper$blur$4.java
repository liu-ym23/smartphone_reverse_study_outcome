package com.larksuite.component.ignition.widget.blur;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.ignition.widget.blur.BlurHelper$blur$4", f = "BlurHelper.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class BlurHelper$blur$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ a $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ float $radius;
    final /* synthetic */ int $scale;
    int label;

    public BlurHelper$blur$4(Context r1, Bitmap r2, float r3, int r4, a r5, Continuation<? super BlurHelper$blur$4> r6) {
        this.$context = r1;
        this.$bitmap = r2;
        this.$radius = r3;
        this.$scale = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new BlurHelper$blur$4(this.$context, this.$bitmap, this.$radius, this.$scale, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        a r2 = this.$callback;
        Resources r3 = this.$context.getResources();
        r2.a(new BitmapDrawable(r3, (Bitmap) r6));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        BlurProcessor r7 = BlurProcessor.a;
        Context r8 = this.$context;
        Bitmap r4 = this.$bitmap;
        float r5 = this.$radius;
        int r9 = this.$scale;
        this.label = 1;
        r6 = BlurProcessor.a(r8, r4, r5, r9, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
