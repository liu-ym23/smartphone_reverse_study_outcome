package com.larus.slides.impl;

import com.larus.slides.sdk.api.orientation.FullscreenOption;
import com.larus.slides.sdk.api.orientation.OrientationMode;
import com.larus.slides.sdk.api.orientation.SetFullscreenModel;
import com.larus.slides.sdk.api.orientation.SetOrientationModel;
import com.larus.slides.sdk.api.orientation.SlidesStates;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesActivity$adapterSensorOrientationChanged$2$1", f = "SlidesActivity.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
final class SlidesActivity$adapterSensorOrientationChanged$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SlidesActivity this$0;

    public SlidesActivity$adapterSensorOrientationChanged$2$1(SlidesActivity r1, Continuation<? super SlidesActivity$adapterSensorOrientationChanged$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SlidesActivity$adapterSensorOrientationChanged$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [android.content.Context, com.larus.slides.impl.SlidesActivity] */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        ?? r15 = this.this$0;
        Integer r2 = r15.f;
        boolean r16 = xw9.h.a(r15);
        if (r16 == false) goto L14;
    L31:
        FLogger.a.i("SlidesActivity", "sensor orientation changed o=" + r2 + " isLocked=" + r16 + " slidesState=" + this.this$0.n);
        return Unit.INSTANCE;
    L14:
        if (Intrinsics.areEqual(this.this$0.n, SlidesStates.PRESENTATION.getStates()) == true) goto L31;
        if (r2 != null) goto L18;
    L19:
        if (r2 != null) goto L22;
    L24:
        if (r2 != null) goto L27;
    L30:
        this.this$0.i = r2;
        goto L31
    L27:
        if (r2.intValue() != 0) goto L30;
        this.this$0.jp(new SetFullscreenModel(Boxing.boxBoolean(false), new FullscreenOption(Boxing.boxBoolean(false), Boxing.boxBoolean(false), Boxing.boxBoolean(false), null, 8, null)));
        this.this$0.K60(new SetOrientationModel(OrientationMode.PORTRAIT.getMode(), null, null, 6, null));
        goto L30
    L22:
        if (r2.intValue() != 270) goto L24;
    L29:
        this.this$0.jp(new SetFullscreenModel(Boxing.boxBoolean(true), new FullscreenOption(Boxing.boxBoolean(true), Boxing.boxBoolean(true), Boxing.boxBoolean(true), null, 8, null)));
        this.this$0.K60(new SetOrientationModel(OrientationMode.LANDSCAPE.getMode(), null, null, 6, null));
        goto L30
    L18:
        if (r2.intValue() == 90) goto L29;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        this.label = 1;
        if (DelayKt.delay(350, this) != r0) goto L11;
        return r0;
    }
}
