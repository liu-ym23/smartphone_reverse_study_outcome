package com.larus.camera.impl.ui.component.capture;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.CaptureTipsView;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTabComponent$onViewCreated$1", f = "CaptureTabComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTabComponent$onViewCreated$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureTabComponent this$0;

    public CaptureTabComponent$onViewCreated$1(CameraCaptureViewModel r1, CaptureTabComponent r2, Continuation<? super CaptureTabComponent$onViewCreated$1> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CaptureTabComponent$onViewCreated$1 r0 = new CaptureTabComponent$onViewCreated$1(this.$viewModel, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L96;
        ResultKt.throwOnFailure(r14);
        String r15 = (String) this.L$0;
        boolean r0 = !this.$viewModel.getCameraData().getSwitchTab();
        CaptureTipsView r2 = (CaptureTipsView) this.this$0.h(2131365141);
        ICameraEventExt r3 = this.$viewModel.getCameraData().getEventExt();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r15, "mode");
        r2.a.a();
        r2.a.b = true;
        View r4 = r2.findViewById(2131374363);
        TextView r5 = (TextView) r2.findViewById(2131374378);
        ImageView r6 = (ImageView) r2.findViewById(2131374367);
        TextView r7 = (TextView) r2.findViewById(2131388767);
        Integer r8 = CaptureTipsView.b.get(r15);
        if (r8 != null) goto L7;
        Intrinsics.checkNotNull(r4);
        com.larus.utils.e1.o(r4);
        Intrinsics.checkNotNull(r7);
        com.larus.utils.e1.o(r7);
    L94:
        return Unit.INSTANCE;
    L7:
        Intrinsics.checkNotNull(r7);
        com.larus.utils.e1.x(r7);
        Intrinsics.checkNotNull(r4);
        com.larus.utils.e1.x(r4);
        r7.setAlpha(0.0f);
        r4.setAlpha(1.0f);
        oq9.h r9 = z2.a.getEduCameraConfig();
        String r12 = "";
        switch(r15.hashCode()) {
            case -1332250801: goto L71;
            case -861871587: goto L57;
            case 358782896: goto L43;
            case 1556930703: goto L11;
            default: goto L83;
        };
    L83:
        Pair r16 = TuplesKt.to("", "");
    L84:
        String r10 = (String) r16.component1();
        String r17 = (String) r16.component2();
        r7.setText(r10);
        r6.setImageResource(r8.intValue());
        r5.setText(r17);
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r4, View.ALPHA, new float[]{1.0f, 0.0f});
        long r11 = 1000;
        if (r0 == false) goto L87;
        long r13 = 1000;
    L88:
        r18.setStartDelay(r13);
        r18.setDuration(300);
        Intrinsics.checkNotNull(r18);
        r18.addListener(new com.larus.camera.impl.widget.i(r4));
        r18.addListener(new com.larus.camera.impl.widget.h(r4));
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r7, View.ALPHA, new float[]{0.0f, 1.0f});
        if (r0 == true) goto L92;
        r11 = 500;
    L92:
        r19.setStartDelay(r11);
        r19.setDuration(300);
        AnimatorSet r1 = new AnimatorSet();
        r1.playTogether(new Animator[]{r18, r19});
        com.larus.camera.impl.utils.h r110 = r2.a;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r1, "animator");
        r110.a.add(r1);
        r1.start();
        goto L94
    L87:
        r13 = 500;
        goto L88
    L11:
        if (r15.equals("CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L83;
        if (r3 == null) goto L17;
        JSONObject r111 = r3.getExtraParams();
        if (r111 == null) goto L17;
        String r112 = r111.optString("college_entrance_examination");
    L19:
        if (Intrinsics.areEqual(r112, "1") == false) goto L31;
        StringBuilder r113 = new StringBuilder();
        String r20 = r9.k();
        if (r20 != null) goto L23;
        r20 = "";
    L23:
        r113.append(r20);
        r113.append('\n');
        String r21 = r9.j();
        if (r21 != null) goto L26;
        r21 = "";
    L26:
        r113.append(r21);
        String r114 = r113.toString();
        String r22 = r9.h();
        if (r22 == null) goto L30;
        r12 = r22;
    L30:
        r16 = TuplesKt.to(r114, r12);
        goto L84
    L31:
        StringBuilder r115 = new StringBuilder();
        String r23 = r9.k();
        if (r23 != null) goto L34;
        r23 = "";
    L34:
        r115.append(r23);
        r115.append('\n');
        String r24 = r9.j();
        if (r24 != null) goto L37;
        r24 = "";
    L37:
        r115.append(r24);
        String r116 = r115.toString();
        String r25 = r9.i();
        if (r25 == null) goto L41;
        r12 = r25;
    L41:
        r16 = TuplesKt.to(r116, r12);
    L17:
        r112 = null;
        goto L19
    L43:
        if (r15.equals("CAPTURE_MODE_EDU_CALCULATION_PHOTO") == false) goto L83;
        StringBuilder r117 = new StringBuilder();
        String r26 = r9.g();
        if (r26 != null) goto L48;
        r26 = "";
    L48:
        r117.append(r26);
        r117.append('\n');
        String r27 = r9.f();
        if (r27 != null) goto L51;
        r27 = "";
    L51:
        r117.append(r27);
        String r118 = r117.toString();
        String r28 = r9.e();
        if (r28 == null) goto L55;
        r12 = r28;
    L55:
        r16 = TuplesKt.to(r118, r12);
        goto L84
    L57:
        if (r15.equals("CAPTURE_MODE_EDU_ARTICLE_PHOTO") == false) goto L83;
        StringBuilder r119 = new StringBuilder();
        String r29 = r9.d();
        if (r29 != null) goto L62;
        r29 = "";
    L62:
        r119.append(r29);
        r119.append('\n');
        String r30 = r9.c();
        if (r30 != null) goto L65;
        r30 = "";
    L65:
        r119.append(r30);
        String r120 = r119.toString();
        String r31 = r9.a();
        if (r31 == null) goto L69;
        r12 = r31;
    L69:
        r16 = TuplesKt.to(r120, r12);
        goto L84
    L71:
        if (r15.equals("CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L83;
        String r121 = r9.n();
        if (r121 != null) goto L76;
        r121 = AppHost.a.getApplication().getString(2131908349);
    L76:
        String r32 = r9.m();
        if (r32 != null) goto L79;
        r32 = AppHost.a.getApplication().getString(2131908350);
    L79:
        String r122 = r121 + '\n' + r32;
        String r33 = r9.l();
        if (r33 != null) goto L82;
        r33 = AppHost.a.getApplication().getString(2131899152);
    L82:
        r16 = TuplesKt.to(r122, r33);
        goto L84
    L96:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
