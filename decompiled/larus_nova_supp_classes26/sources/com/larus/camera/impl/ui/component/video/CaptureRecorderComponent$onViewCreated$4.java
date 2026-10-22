package com.larus.camera.impl.ui.component.video;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.bmhome.utils.a4;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/camera/impl/entity/RecordControlUIState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.video.CaptureRecorderComponent$onViewCreated$4", f = "CaptureRecorderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureRecorderComponent$onViewCreated$4 extends SuspendLambda implements Function2<px8.d, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<px8.d> $previousState;
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureRecorderComponent this$0;

    public CaptureRecorderComponent$onViewCreated$4(CaptureRecorderComponent r1, CameraCaptureViewModel r2, Ref.ObjectRef<px8.d> r3, Continuation<? super CaptureRecorderComponent$onViewCreated$4> r4) {
        this.this$0 = r1;
        this.$viewModel = r2;
        this.$previousState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CaptureRecorderComponent$onViewCreated$4 r0 = new CaptureRecorderComponent$onViewCreated$4(this.this$0, this.$viewModel, this.$previousState, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((px8.d) r1, (Continuation) r2);
    }

    public final Object invoke(px8.d r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L58;
        ResultKt.throwOnFailure(r11);
        px8.d r12 = (px8.d) this.L$0;
        FLogger r0 = FLogger.a;
        r0.i(this.this$0.A, "[recordingState] state:" + r12);
        if ((r12 instanceof px8.d.C0130d) == false) goto L17;
        ImageView r1 = this.this$0.n;
        if (r1 == null) goto L9;
        r1.setImageResource(2131241823);
    L9:
        TextView r2 = this.this$0.p;
        if (r2 == null) goto L12;
        e1.o(r2);
    L12:
        final CaptureRecorderComponent r3 = this.this$0;
        if (r3.y == false) goto L15;
        r3.y = false;
        int r4 = c7.b(56);
        float r5 = c7.c(28);
        int r6 = c7.b(64);
        float r7 = c7.c(32);
        ValueAnimator r8 = ValueAnimator.ofInt(new int[]{r4, r6});
        r8.setDuration(200);
        r8.addUpdateListener(new a(r3));
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{r5, r7});
        r9.setDuration(200);
        r9.addUpdateListener(new b(r3));
        r8.start();
        r9.start();
    L55:
        this.$previousState.element = r12;
        return Unit.INSTANCE;
    L15:
        CaptureRecorderComponent.p(r3, c7.b(Boxing.boxInt(64)), c7.c(Boxing.boxInt(32)));
        goto L55
    L17:
        if ((r12 instanceof px8.d.e) == false) goto L26;
        ImageView r10 = this.this$0.n;
        if (r10 == null) goto L21;
        r10.setImageResource(2131241823);
    L21:
        TextView r13 = this.this$0.p;
        if (r13 == null) goto L24;
        e1.o(r13);
    L24:
        float r14 = ((px8.d.e) r12).a;
        int r15 = c7.b(Boxing.boxInt(64));
        float r16 = r15 / 2.0f;
        CaptureRecorderComponent.p(this.this$0, r15 + ((int) ((c7.b(Boxing.boxInt(34)) - r15) * r14)), r16 + ((c7.c(Boxing.boxInt(8)) - r16) * r14));
        goto L55
    L26:
        if ((r12 instanceof px8.d.b) == false) goto L34;
        a4.a.getClass();
        a4.a(a4.b);
        ImageView r17 = this.this$0.n;
        if (r17 == null) goto L30;
        r17.setImageResource(2131241822);
    L30:
        TextView r18 = this.this$0.p;
        if (r18 == null) goto L55;
        e1.x(r18);
        goto L55
    L34:
        if ((r12 instanceof px8.d.c) == false) goto L49;
        ImageView r19 = this.this$0.n;
        if (r19 == null) goto L38;
        r19.setImageResource(2131241822);
    L38:
        TextView r20 = this.this$0.p;
        if (r20 == null) goto L41;
        e1.o(r20);
    L41:
        ImageView r21 = this.this$0.n;
        if (r21 == null) goto L44;
        e1.o(r21);
    L44:
        View r22 = this.this$0.r;
        if (r22 == null) goto L47;
        e1.o(r22);
    L47:
        CaptureRecorderComponent.p(this.this$0, c7.b(Boxing.boxInt(34)), c7.c(Boxing.boxInt(8)));
        goto L55
    L49:
        if ((r12 instanceof px8.d.f) == false) goto L55;
        this.this$0.w.removeCallbacksAndMessages(null);
        this.$viewModel.leaveCapturePageOnCapture();
        this.$viewModel.stopRecord(this.this$0.getContext(), this.this$0.u);
        this.$viewModel.recycleDownEvent();
        qx8.a r23 = qx8.a.b;
        if ((this.$previousState.element instanceof px8.d.c) == false) goto L53;
        String r24 = "hands_free";
    L54:
        r23.getClass();
        r0.i("CameraMonitor", "[onRecordEnd] from: ".concat(r24));
        r23.a.c(CameraEvent.PREVIEW_RECORD);
        qx8.a.i = r24;
        goto L55
    L53:
        r24 = "long_press";
        goto L54
    L58:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
