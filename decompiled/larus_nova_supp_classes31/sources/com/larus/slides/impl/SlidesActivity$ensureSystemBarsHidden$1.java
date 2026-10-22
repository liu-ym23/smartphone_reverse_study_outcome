package com.larus.slides.impl;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesActivity$ensureSystemBarsHidden$1", f = "SlidesActivity.kt", i = {}, l = {719}, m = "invokeSuspend", n = {}, s = {})
final class SlidesActivity$ensureSystemBarsHidden$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $decorView;
    final /* synthetic */ Ref.IntRef $uiOptions;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    public SlidesActivity$ensureSystemBarsHidden$1(View r1, Ref.IntRef r2, Continuation<? super SlidesActivity$ensureSystemBarsHidden$1> r3) {
        this.$decorView = r1;
        this.$uiOptions = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SlidesActivity$ensureSystemBarsHidden$1(this.$decorView, this.$uiOptions, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0043 -> B:13:0x0046). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r4 = this.I$0;
        Ref.IntRef r5 = (Ref.IntRef) this.L$1;
        View r6 = (View) this.L$0;
        ResultKt.throwOnFailure(r10);
        SlidesActivity$ensureSystemBarsHidden$1 r11 = this;
    L13:
        WindowInsetsCompat r7 = ViewCompat.getRootWindowInsets(r6);
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L22;
        r6.setSystemUiVisibility(r5.element);
        r2 = r2 + 1;
    L9:
        if (r2 >= r4) goto L24;
        r11.L$0 = r6;
        r11.L$1 = r5;
        r11.I$0 = r4;
        r11.I$1 = r2;
        r11.label = 1;
        if (DelayKt.delay(100, r11) != r0) goto L13;
        return r0;
    L24:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L16:
        if (r7.isVisible(WindowInsetsCompat.Type.systemBars()) != true) goto L18;
        r8 = true;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        View r12 = this.$decorView;
        r4 = 3;
        r6 = r12;
        r5 = this.$uiOptions;
        r2 = 0;
        r11 = this;
        goto L9
    }
}
