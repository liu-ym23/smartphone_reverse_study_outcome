package com.larus.uaigc.instruction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$initView$1", f = "AvatarTemplateWidget.kt", i = {0}, l = {131, 155}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AvatarTemplateWidget$initView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AvatarTemplateWidget this$0;

    public AvatarTemplateWidget$initView$1(AvatarTemplateWidget r1, Continuation<? super AvatarTemplateWidget$initView$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AvatarTemplateWidget$initView$1 r0 = new AvatarTemplateWidget$initView$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        String r5 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L72:
        Bitmap r16 = (Bitmap) r15;
        if (r16 == null) goto L78;
        LarusItemActionBarAvatarInstructionBinding r2 = this.this$0.g;
        if (r2 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L77:
        r2.c.setImageBitmap(r16);
    L78:
        LarusItemActionBarAvatarInstructionBinding r17 = this.this$0.g;
        if (r17 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L81:
        TextView r18 = r17.b;
        wa8.a r3 = AvatarTemplateWidget.k6(this.this$0);
        if (r3 == null) goto L84;
        r5 = r3.c;
    L84:
        r18.setText(r5);
        AvatarTemplateWidget.o6(this.this$0);
    L86:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        AvatarTemplateWidget r4 = (AvatarTemplateWidget) this.L$1;
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L39:
        Bitmap r19 = (Bitmap) r15;
        if (r19 == null) goto L45;
        LarusItemActionBarAvatarInstructionBinding r7 = r4.g;
        if (r7 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L44:
        r7.c.setImageBitmap(r19);
        Unit r110 = Unit.INSTANCE;
    L46:
        if (r110 != null) goto L60;
    L47:
        AvatarTemplateWidget r111 = this.this$0;
        LarusItemActionBarAvatarInstructionBinding r8 = r111.g;
        if (r8 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L50:
        ImageView r9 = r8.c;
        if (r9 == null) goto L60;
        LarusItemActionBarAvatarInstructionBinding r112 = r111.g;
        if (r112 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L55:
        ImageView r113 = r112.c;
        if (r113 == null) goto L58;
        Context r114 = r113.getContext();
    L59:
        r9.setImageResource(v19.c.b(2130971710, r114, 2131241310));
        Unit r115 = Unit.INSTANCE;
        goto L60
    L58:
        r114 = null;
    L60:
        LarusItemActionBarAvatarInstructionBinding r116 = this.this$0.g;
        if (r116 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L63:
        TextView r117 = r116.b;
        wa8.a r10 = AvatarTemplateWidget.k6(this.this$0);
        if (r10 == null) goto L66;
        r5 = r10.c;
    L66:
        r117.setText(r5);
        AvatarTemplateWidget.o6(this.this$0);
        goto L86
    L45:
        r110 = null;
        goto L46
    L10:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r118 = (CoroutineScope) this.L$0;
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.g() == true) goto L32;
        LarusItemActionBarAvatarInstructionBinding r11 = this.this$0.g;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L15:
        float r12 = r11.b.getWidth();
        LarusItemActionBarAvatarInstructionBinding r13 = this.this$0.g;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L18:
        LinearGradient r119 = new LinearGradient(0.0f, 0.0f, r12, r13.b.getHeight(), AvatarTemplateWidget.k, null, Shader.TileMode.CLAMP);
        LarusItemActionBarAvatarInstructionBinding r14 = this.this$0.g;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L21:
        r14.b.getPaint().setShader(r119);
        LarusItemActionBarAvatarInstructionBinding r120 = this.this$0.g;
        if (r120 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L24:
        r120.c.setImageResource(2131241308);
        LarusItemActionBarAvatarInstructionBinding r121 = this.this$0.g;
        if (r121 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L27:
        TextView r122 = r121.b;
        wa8.a r20 = AvatarTemplateWidget.k6(this.this$0);
        if (r20 == null) goto L30;
        r5 = r20.b;
    L30:
        r122.setText(r5);
        goto L86
    L32:
        if (DigitalAvatarInfoManager.i() == false) goto L68;
        String r21 = DigitalAvatarInfoManager.e();
        if (r21 == null) goto L47;
        AvatarTemplateWidget r22 = this.this$0;
        CoroutineDispatcher r23 = Dispatchers.getIO();
        AvatarTemplateWidget$initView$1$1$bitmap$1 r24 = new AvatarTemplateWidget$initView$1$1$bitmap$1(r21, r22, null);
        this.L$0 = r118;
        this.L$1 = r22;
        this.label = 1;
        r15 = BuildersKt.withContext(r23, r24, this);
        if (r15 != r0) goto L38;
        return r0;
    L38:
        r4 = r22;
        goto L39
    L68:
        if (DigitalAvatarInfoManager.h() == false) goto L86;
        CoroutineDispatcher r123 = Dispatchers.getIO();
        AvatarTemplateWidget$initView$1$bitmap$1 r25 = new AvatarTemplateWidget$initView$1$bitmap$1(this.this$0, null);
        this.label = 2;
        r15 = BuildersKt.withContext(r123, r25, this);
        if (r15 != r0) goto L72;
        return r0;
    }
}
