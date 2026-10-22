package com.larus.voicecall.impl.component.vlm;

import android.widget.ImageView;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeVideoComponent$resetFlashlightIcon$1", f = "RealtimeVideoComponent.kt", i = {}, l = {1602, 1603}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeVideoComponent$resetFlashlightIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    final /* synthetic */ String $reason;
    final /* synthetic */ boolean $show;
    int label;
    final /* synthetic */ RealtimeVideoComponent this$0;

    public RealtimeVideoComponent$resetFlashlightIcon$1(long r1, RealtimeVideoComponent r3, boolean r4, String r5, Continuation<? super RealtimeVideoComponent$resetFlashlightIcon$1> r6) {
        this.$delayTime = r1;
        this.this$0 = r3;
        this.$show = r4;
        this.$reason = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RealtimeVideoComponent$resetFlashlightIcon$1(this.$delayTime, this.this$0, this.$show, this.$reason, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L16:
        boolean r12 = ((Boolean) r11).booleanValue();
        if (r12 == true) goto L19;
    L21:
        boolean r2 = false;
    L22:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[flashlight_debug] resetFlashlightIcon apply, canShow=");
        r5.append(r2);
        r5.append(", enableFlashlight=");
        r5.append(r12);
        r5.append(", show=");
        r5.append(this.$show);
        r5.append(", reason=");
        r5.append(this.$reason);
        r5.append(", delayTime=");
        r5.append(this.$delayTime);
        r5.append(", isCameraBack=");
        r5.append(this.this$0.N.b.getValue());
        r5.append(", previewState=");
        r5.append(this.this$0.N.c.getValue());
        r5.append(", videoCaptureStarted=");
        r5.append(this.this$0.D5());
        r5.append(", isVeCaptureEnable=");
        r5.append(this.this$0.i4());
        r5.append(", flashlightIconNull=");
        if (this.this$0.IF() != null) goto L25;
        boolean r6 = true;
    L26:
        r5.append(r6);
        r5.append(", beforeVisibility=");
        ImageView r7 = this.this$0.IF();
        Boolean r8 = null;
        if (r7 == null) goto L29;
        Integer r9 = Boxing.boxInt(r7.getVisibility());
    L30:
        r5.append(r9);
        r5.append(", beforeSelected=");
        ImageView r10 = this.this$0.IF();
        if (r10 == null) goto L33;
        Boolean r13 = Boxing.boxBoolean(r10.isSelected());
    L34:
        r5.append(r13);
        r5.append(", useTwoLine=");
        z2 r14 = z2.a;
        r5.append(r14.realtimeCallUseTwoLineStyle());
        r5.append(", shouldCloseWhenHidden=");
        r5.append(RealtimeVideoComponent.m3(this.this$0, this.$reason));
        r4.i("RealtimeVideoComponent", r5.toString());
        if (r2 == false) goto L37;
    L54:
        ImageView r15 = this.this$0.IF();
        if (r15 == null) goto L60;
        if (r2 == false) goto L58;
        int r16 = 0;
    L59:
        r15.setVisibility(r16);
        goto L60
    L58:
        r16 = 8;
    L60:
        ImageView r17 = this.this$0.IF();
        if (r17 == null) goto L63;
        r17.setSelected(false);
    L63:
        StringBuilder r18 = new StringBuilder("[flashlight_debug] resetFlashlightIcon after, canShow=");
        r18.append(r2);
        r18.append(", reason=");
        r18.append(this.$reason);
        r18.append(", afterVisibility=");
        ImageView r19 = this.this$0.IF();
        if (r19 == null) goto L66;
        Integer r110 = Boxing.boxInt(r19.getVisibility());
    L67:
        r18.append(r110);
        r18.append(", afterSelected=");
        ImageView r111 = this.this$0.IF();
        if (r111 == null) goto L70;
        r8 = Boxing.boxBoolean(r111.isSelected());
    L70:
        r18.append(r8);
        r4.i("RealtimeVideoComponent", r18.toString());
        return Unit.INSTANCE;
    L66:
        r110 = null;
        goto L67
    L37:
        if (r14.realtimeCallUseTwoLineStyle() == false) goto L54;
        if (RealtimeVideoComponent.m3(this.this$0, this.$reason) == false) goto L54;
        r4.i("RealtimeVideoComponent", "[flashlight_debug] resetFlashlightIcon close real flashlight, reason=" + this.$reason);
        RealtimeVideoComponent r20 = this.this$0;
        if (r20.i4() == false) goto L47;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r21 = r20.G3();
        if (r21 != null) goto L45;
    L52:
        r3 = false;
    L53:
        r4.i("RealtimeVideoComponent", "[flashlight_debug] closeFlashlight, success=" + r3 + ", isVeCaptureEnable=" + r20.i4());
        goto L54
    L45:
        if (r21.c(false) != true) goto L52;
    L47:
        com.larus.voicecall.impl.plugins.o1 r22 = r20.E3().z();
        if (r22 == null) goto L52;
        if (r22.c(false) != true) goto L52;
    L33:
        r13 = null;
        goto L34
    L29:
        r9 = null;
        goto L30
    L25:
        r6 = false;
        goto L26
    L19:
        if (this.$show == false) goto L21;
        r2 = true;
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        RealtimeVideoComponent r112 = this.this$0;
        this.label = 2;
        r11 = r112.z3(this);
        if (r11 != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        long r23 = this.$delayTime;
        this.label = 1;
        if (DelayKt.delay(r23, this) != r0) goto L13;
        return r0;
    }
}
