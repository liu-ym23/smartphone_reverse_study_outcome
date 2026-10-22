package com.larus.doc.impl.video.widget;

import android.animation.ObjectAnimator;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.video.widget.HorizontalProgressLayer$startLoadingAnimation$1", f = "HorizontalProgressLayer.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class HorizontalProgressLayer$startLoadingAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ HorizontalProgressLayer this$0;

    public HorizontalProgressLayer$startLoadingAnimation$1(HorizontalProgressLayer r1, Continuation<? super HorizontalProgressLayer$startLoadingAnimation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new HorizontalProgressLayer$startLoadingAnimation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0039 -> B:15:0x0043). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0058 -> B:19:0x005b). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r3 = this.I$0;
        ObjectAnimator[] r4 = (ObjectAnimator[]) this.L$0;
        ResultKt.throwOnFailure(r9);
        HorizontalProgressLayer$startLoadingAnimation$1 r10 = this;
    L19:
        r3 = r3 + 1;
    L15:
        if (r3 < r2) goto L16;
    L9:
        r3 = 0;
        if (r10.this$0.getVisibility() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L21;
        ObjectAnimator[] r6 = HorizontalProgressLayer.c(r10.this$0);
        r4 = r6;
        r2 = r6.length;
        goto L15
    L21:
        return Unit.INSTANCE;
    L12:
        r5 = false;
        goto L13
    L16:
        r4[r3].start();
        r10.L$0 = r4;
        r10.I$0 = r3;
        r10.I$1 = r2;
        r10.label = 1;
        if (DelayKt.delay(700, r10) != r0) goto L19;
        return r0;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        HorizontalProgressLayer r11 = this.this$0;
        int r7 = HorizontalProgressLayer.f;
        r11.getClass();
        r10 = this;
        goto L9
    }
}
