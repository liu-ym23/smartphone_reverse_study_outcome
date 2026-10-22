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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeVideoComponent$setupFlashlight$1$1", f = "RealtimeVideoComponent.kt", i = {}, l = {1554}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeVideoComponent$setupFlashlight$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $flashIcon;
    int label;
    final /* synthetic */ RealtimeVideoComponent this$0;

    public RealtimeVideoComponent$setupFlashlight$1$1(ImageView r1, RealtimeVideoComponent r2, Continuation<? super RealtimeVideoComponent$setupFlashlight$1$1> r3) {
        this.$flashIcon = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeVideoComponent$setupFlashlight$1$1(this.$flashIcon, this.this$0, r4);
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
    L12:
        if (((Boolean) r15).booleanValue() == true) goto L15;
        FLogger.a.i("RealtimeVideoComponent", "[flashlight_debug] flashlight click ignored, enableFlashlight=false");
        return Unit.INSTANCE;
    L15:
        RealtimeVideoComponent r16 = this.this$0;
        int r2 = RealtimeVideoComponent.g1;
        if (r16.i4() == false) goto L22;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r17 = this.this$0.G3();
        if (r17 != null) goto L20;
    L27:
        boolean r18 = false;
    L28:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[flashlight_debug] flashlight switch result, success=");
        r4.append(r18);
        r4.append(", targetSelected=");
        r4.append(!this.$flashIcon.isSelected());
        r4.append(", isVeCaptureEnable=");
        r4.append(this.this$0.i4());
        r3.i("RealtimeVideoComponent", r4.toString());
        if (r18 == false) goto L32;
        ImageView r19 = this.$flashIcon;
        r19.setSelected(!r19.isSelected());
    L32:
        if (z2.a.realtimeTalkbackOptEnable() == true) goto L34;
    L41:
        int r110 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.c(this.this$0.Q3().a(), this.this$0.B3(), ((h88.b) this.this$0.Q3()).m, false, Boxing.boxBoolean(Intrinsics.areEqual(this.this$0.N.b.getValue(), Boxing.boxBoolean(true))), "flashlight", null, new j2(this.$flashIcon), 72);
        return Unit.INSTANCE;
    L34:
        if (this.$flashIcon.isSelected() == false) goto L38;
        ImageView r111 = this.this$0.IF();
        if (r111 == null) goto L41;
        r111.setContentDescription(this.this$0.getContext().getString(2131898818));
        goto L41
    L38:
        ImageView r112 = this.this$0.IF();
        if (r112 == null) goto L41;
        r112.setContentDescription(this.this$0.getContext().getString(2131898817));
        goto L41
    L20:
        if (r17.c(!this.$flashIcon.isSelected()) != true) goto L27;
    L26:
        r18 = true;
        goto L28
    L22:
        com.larus.voicecall.impl.plugins.o1 r113 = this.this$0.E3().z();
        if (r113 == null) goto L27;
        if (r113.c(!this.$flashIcon.isSelected()) != true) goto L27;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        FLogger.a.i("RealtimeVideoComponent", "[flashlight_debug] flashlight clicked, beforeSelected=" + this.$flashIcon.isSelected() + ", visibility=" + this.$flashIcon.getVisibility() + ", isCameraBack=" + this.this$0.N.b.getValue() + ", previewState=" + this.this$0.N.c.getValue() + ", videoCaptureStarted=" + this.this$0.D5() + ", isVeCaptureEnable=" + this.this$0.i4());
        RealtimeVideoComponent r114 = this.this$0;
        this.label = 1;
        r15 = r114.z3(this);
        if (r15 != r0) goto L12;
        return r0;
    }
}
