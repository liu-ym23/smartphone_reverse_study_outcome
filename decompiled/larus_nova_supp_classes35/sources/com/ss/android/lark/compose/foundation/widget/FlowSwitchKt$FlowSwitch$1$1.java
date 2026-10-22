package com.ss.android.lark.compose.foundation.widget;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.foundation.widget.FlowSwitchKt$FlowSwitch$1$1", f = "FlowSwitch.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class FlowSwitchKt$FlowSwitch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $state;
    final /* synthetic */ float $thumbMaxOffsetPx;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $thumbOffsetAnimatable;
    int label;

    public FlowSwitchKt$FlowSwitch$1$1(Animatable<Float, AnimationVector1D> r1, a r2, float r3, Continuation<? super FlowSwitchKt$FlowSwitch$1$1> r4) {
        this.$thumbOffsetAnimatable = r1;
        this.$state = r2;
        this.$thumbMaxOffsetPx = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowSwitchKt$FlowSwitch$1$1(this.$thumbOffsetAnimatable, this.$state, this.$thumbMaxOffsetPx, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        float r16 = ((Number) this.$thumbOffsetAnimatable.getTargetValue()).floatValue();
        boolean r2 = this.$state.a;
        float r3 = 0.0f;
        if (r2 == false) goto L11;
        float r4 = this.$thumbMaxOffsetPx;
    L13:
        if (r16 != r4) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == true) goto L24;
        Animatable<Float, AnimationVector1D> r6 = this.$thumbOffsetAnimatable;
        if (r2 == false) goto L20;
        r3 = this.$thumbMaxOffsetPx;
    L20:
        Float r7 = Boxing.boxFloat(r3);
        TweenSpec r8 = AnimationSpecKt.tween$default(200, 0, null, 6, null);
        this.label = 1;
        if (Animatable.animateTo$default(r6, r7, r8, null, null, this, 12, null) != r0) goto L24;
        return r0;
    L15:
        r17 = false;
        goto L16
    L11:
        r4 = 0.0f;
        goto L13
    }
}
