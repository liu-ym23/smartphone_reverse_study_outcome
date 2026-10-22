package com.larus.uaigc.instruction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$bindObserver$1", f = "AvatarTemplateWidget.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
final class AvatarTemplateWidget$bindObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AvatarTemplateWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.instruction.AvatarTemplateWidget$bindObserver$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ AvatarTemplateWidget a;
        public final /* synthetic */ CoroutineScope b;

        public AnonymousClass1(AvatarTemplateWidget r1, CoroutineScope r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object a(boolean r24, Continuation<? super Unit> r25) {
            if ((r25 instanceof AvatarTemplateWidget$bindObserver$1$1$emit$1) == false) goto L7;
            AvatarTemplateWidget$bindObserver$1$1$emit$1 r2 = (AvatarTemplateWidget$bindObserver$1$1$emit$1) r25;
            int r3 = r2.label;
            if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
            r2.label = r3 - Integer.MIN_VALUE;
        L8:
            Object r1 = r2.result;
            Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = r2.label;
            String r14 = null;
            LarusItemActionBarAvatarInstructionBinding r15 = null;
            LarusItemActionBarAvatarInstructionBinding r16 = null;
            LarusItemActionBarAvatarInstructionBinding r17 = null;
            LarusItemActionBarAvatarInstructionBinding r18 = null;
            String r19 = null;
            if (r5 == 0) goto L20;
            if (r5 == 1) goto L19;
            if (r5 == 2) goto L18;
            if (r5 == 3) goto L17;
            if (r5 != 4) goto L16;
            ResultKt.throwOnFailure(r1);
        L207:
            Bitmap r6 = (Bitmap) r1;
            if (r6 == null) goto L213;
            LarusItemActionBarAvatarInstructionBinding r7 = this.a.g;
            if (r7 != null) goto L212;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r7 = null;
        L212:
            r7.c.setImageBitmap(r6);
        L213:
            LarusItemActionBarAvatarInstructionBinding r8 = this.a.g;
            if (r8 != null) goto L216;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r8 = null;
        L216:
            TextView r9 = r8.b;
            wa8.a r10 = AvatarTemplateWidget.k6(this.a);
            if (r10 == null) goto L219;
            String r11 = r10.c;
        L220:
            r9.setText(r11);
            LarusItemActionBarAvatarInstructionBinding r12 = this.a.g;
            if (r12 != null) goto L223;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r12 = null;
        L223:
            r12.b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r13 = this.a.g;
            if (r13 != null) goto L226;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L227:
            TextView r20 = r15.b;
            Context r21 = this.a.getContext();
            if (r21 != null) goto L230;
            r21 = AppHost.a.getApplication();
        L230:
            Context r22 = this.a.getContext();
            if (r22 != null) goto L233;
            r22 = AppHost.a.getApplication();
        L233:
            r20.setTextColor(ContextCompat.getColor(r21, v19.c.b(2130972123, r22, 2131103203)));
            AvatarTemplateWidget.o6(this.a);
        L234:
            DigitalAvatarInfoManager.a.getClass();
            if (DigitalAvatarInfoManager.i != null) goto L238;
            e1.o(this.a);
        L238:
            return Unit.INSTANCE;
        L226:
            r15 = r13;
            goto L227
        L219:
            r11 = null;
            goto L220
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            AvatarTemplateWidget r23 = (AvatarTemplateWidget) r2.L$0;
            ResultKt.throwOnFailure(r1);
        L169:
            Bitmap r26 = (Bitmap) r1;
            if (r26 == null) goto L175;
            LarusItemActionBarAvatarInstructionBinding r27 = r23.g;
            if (r27 != null) goto L174;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r27 = null;
        L174:
            r27.c.setImageBitmap(r26);
            Unit r28 = Unit.INSTANCE;
        L176:
            if (r28 != null) goto L181;
        L177:
            LarusItemActionBarAvatarInstructionBinding r29 = this.a.g;
            if (r29 != null) goto L180;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r29 = null;
        L180:
            r29.c.setImageResource(2131241309);
        L181:
            LarusItemActionBarAvatarInstructionBinding r30 = this.a.g;
            if (r30 != null) goto L184;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r30 = null;
        L184:
            TextView r31 = r30.b;
            wa8.a r32 = AvatarTemplateWidget.k6(this.a);
            if (r32 == null) goto L187;
            String r33 = r32.c;
        L188:
            r31.setText(r33);
            LarusItemActionBarAvatarInstructionBinding r34 = this.a.g;
            if (r34 != null) goto L191;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r34 = null;
        L191:
            r34.b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r35 = this.a.g;
            if (r35 != null) goto L194;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L195:
            TextView r36 = r16.b;
            Context r37 = this.a.getContext();
            if (r37 != null) goto L198;
            r37 = AppHost.a.getApplication();
        L198:
            Context r38 = this.a.getContext();
            if (r38 != null) goto L201;
            r38 = AppHost.a.getApplication();
        L201:
            r36.setTextColor(ContextCompat.getColor(r37, v19.c.b(2130972123, r38, 2131103203)));
            AvatarTemplateWidget.o6(this.a);
            goto L234
        L194:
            r16 = r35;
            goto L195
        L187:
            r33 = null;
            goto L188
        L175:
            r28 = null;
            goto L176
        L18:
            ResultKt.throwOnFailure(r1);
        L110:
            Bitmap r39 = (Bitmap) r1;
            if (r39 == null) goto L116;
            LarusItemActionBarAvatarInstructionBinding r40 = this.a.g;
            if (r40 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r40 = null;
        L115:
            r40.c.setImageBitmap(r39);
        L116:
            LarusItemActionBarAvatarInstructionBinding r41 = this.a.g;
            if (r41 != null) goto L119;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r41 = null;
        L119:
            TextView r42 = r41.b;
            wa8.a r43 = AvatarTemplateWidget.k6(this.a);
            if (r43 == null) goto L122;
            String r44 = r43.c;
        L123:
            r42.setText(r44);
            LarusItemActionBarAvatarInstructionBinding r45 = this.a.g;
            if (r45 != null) goto L126;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r45 = null;
        L126:
            r45.b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r46 = this.a.g;
            if (r46 != null) goto L129;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L130:
            TextView r47 = r17.b;
            Context r48 = this.a.getContext();
            if (r48 != null) goto L133;
            r48 = AppHost.a.getApplication();
        L133:
            Context r49 = this.a.getContext();
            if (r49 != null) goto L136;
            r49 = AppHost.a.getApplication();
        L136:
            r47.setTextColor(ContextCompat.getColor(r48, v19.c.b(2130972079, r49, 2131103136)));
            AvatarTemplateWidget.o6(this.a);
            goto L234
        L129:
            r17 = r46;
            goto L130
        L122:
            r44 = null;
            goto L123
        L19:
            AvatarTemplateWidget r50 = (AvatarTemplateWidget) r2.L$0;
            ResultKt.throwOnFailure(r1);
        L63:
            Bitmap r51 = (Bitmap) r1;
            if (r51 == null) goto L69;
            LarusItemActionBarAvatarInstructionBinding r52 = r50.g;
            if (r52 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r52 = null;
        L68:
            r52.c.setImageBitmap(r51);
            Unit r53 = Unit.INSTANCE;
        L70:
            if (r53 != null) goto L84;
        L71:
            AvatarTemplateWidget r54 = this.a;
            LarusItemActionBarAvatarInstructionBinding r55 = r54.g;
            if (r55 != null) goto L74;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r55 = null;
        L74:
            ImageView r56 = r55.c;
            if (r56 == null) goto L84;
            LarusItemActionBarAvatarInstructionBinding r57 = r54.g;
            if (r57 != null) goto L79;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r57 = null;
        L79:
            ImageView r58 = r57.c;
            if (r58 == null) goto L82;
            Context r59 = r58.getContext();
        L83:
            r56.setImageResource(v19.c.b(2130971710, r59, 2131241310));
            Unit r60 = Unit.INSTANCE;
            goto L84
        L82:
            r59 = null;
        L84:
            LarusItemActionBarAvatarInstructionBinding r61 = this.a.g;
            if (r61 != null) goto L87;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r61 = null;
        L87:
            TextView r62 = r61.b;
            wa8.a r63 = AvatarTemplateWidget.k6(this.a);
            if (r63 == null) goto L90;
            String r64 = r63.c;
        L91:
            r62.setText(r64);
            LarusItemActionBarAvatarInstructionBinding r65 = this.a.g;
            if (r65 != null) goto L94;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r65 = null;
        L94:
            r65.b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r66 = this.a.g;
            if (r66 != null) goto L97;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L98:
            TextView r67 = r18.b;
            Context r68 = this.a.getContext();
            if (r68 != null) goto L101;
            r68 = AppHost.a.getApplication();
        L101:
            Context r69 = this.a.getContext();
            if (r69 != null) goto L104;
            r69 = AppHost.a.getApplication();
        L104:
            r67.setTextColor(ContextCompat.getColor(r68, v19.c.b(2130972079, r69, 2131103136)));
            AvatarTemplateWidget.o6(this.a);
            goto L234
        L97:
            r18 = r66;
            goto L98
        L90:
            r64 = null;
            goto L91
        L69:
            r53 = null;
            goto L70
        L20:
            ResultKt.throwOnFailure(r1);
            LarusItemActionBarAvatarInstructionBinding r70 = this.a.g;
            if (r70 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r70 = null;
        L23:
            e1.o(r70.d);
            if (r24 == true) goto L138;
            if (this.a.g != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L28:
            AbsInstructionWidget r71 = this.a;
            Context r72 = r71.getContext();
            if (r72 != null) goto L31;
            r72 = AppHost.a.getApplication();
        L31:
            Context r73 = r71.getContext();
            if (r73 != null) goto L34;
            r73 = AppHost.a.getApplication();
        L34:
            r71.setBackground(ContextCompat.getDrawable(r72, v19.c.b(2130970543, r73, 2131238559)));
            DigitalAvatarInfoManager.a.getClass();
            if (DigitalAvatarInfoManager.g() == true) goto L56;
            LarusItemActionBarAvatarInstructionBinding r74 = this.a.g;
            if (r74 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r74 = null;
        L39:
            float r75 = r74.b.getWidth();
            LarusItemActionBarAvatarInstructionBinding r76 = this.a.g;
            if (r76 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r76 = null;
        L42:
            LinearGradient r77 = new LinearGradient(0.0f, 0.0f, r75, r76.b.getHeight(), AvatarTemplateWidget.k, null, Shader.TileMode.CLAMP);
            LarusItemActionBarAvatarInstructionBinding r78 = this.a.g;
            if (r78 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r78 = null;
        L45:
            r78.b.getPaint().setShader(r77);
            LarusItemActionBarAvatarInstructionBinding r79 = this.a.g;
            if (r79 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r79 = null;
        L48:
            r79.c.setImageResource(2131241308);
            LarusItemActionBarAvatarInstructionBinding r80 = this.a.g;
            if (r80 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r80 = null;
        L51:
            TextView r81 = r80.b;
            wa8.a r82 = AvatarTemplateWidget.k6(this.a);
            if (r82 == null) goto L54;
            r19 = r82.b;
        L54:
            r81.setText(r19);
            goto L234
        L56:
            if (DigitalAvatarInfoManager.i() == false) goto L106;
            String r83 = DigitalAvatarInfoManager.e();
            if (r83 == null) goto L71;
            AvatarTemplateWidget r84 = this.a;
            CoroutineDispatcher r85 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$2$bitmap$1 r86 = new AvatarTemplateWidget$bindObserver$1$1$2$bitmap$1(r83, r84, null);
            r2.L$0 = r84;
            r2.label = 1;
            r1 = BuildersKt.withContext(r85, r86, r2);
            if (r1 != r4) goto L62;
            return r4;
        L62:
            r50 = r84;
            goto L63
        L106:
            if (DigitalAvatarInfoManager.h() == false) goto L234;
            CoroutineDispatcher r87 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$bitmap$1 r88 = new AvatarTemplateWidget$bindObserver$1$1$bitmap$1(this.a, null);
            r2.label = 2;
            r1 = BuildersKt.withContext(r87, r88, r2);
            if (r1 != r4) goto L110;
            return r4;
        L138:
            if (this.a.g != null) goto L140;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L140:
            AbsInstructionWidget r89 = this.a;
            GradientDrawable r90 = new GradientDrawable();
            r90.setCornerRadius(i5.r0());
            Context r91 = r89.getContext();
            if (r91 != null) goto L143;
            r91 = AppHost.a.getApplication();
        L143:
            Context r92 = r89.getContext();
            if (r92 != null) goto L146;
            r92 = AppHost.a.getApplication();
        L146:
            r90.setColor(ContextCompat.getColor(r91, v19.c.b(2130972127, r92, 2131103215)));
            int r93 = c7.b(Boxing.boxInt(1));
            Context r94 = r89.getContext();
            if (r94 != null) goto L149;
            r94 = AppHost.a.getApplication();
        L149:
            Context r110 = r89.getContext();
            if (r110 != null) goto L152;
            r110 = AppHost.a.getApplication();
        L152:
            r90.setStroke(r93, ContextCompat.getColor(r94, v19.c.b(2130973613, r110, 2131105594)));
            r89.setBackground(r90);
            DigitalAvatarInfoManager.a.getClass();
            if (DigitalAvatarInfoManager.g() == true) goto L162;
            LarusItemActionBarAvatarInstructionBinding r95 = this.a.g;
            if (r95 != null) goto L157;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r95 = null;
        L157:
            TextView r96 = r95.b;
            wa8.a r97 = AvatarTemplateWidget.k6(this.a);
            if (r97 == null) goto L160;
            r14 = r97.b;
        L160:
            r96.setText(r14);
            goto L234
        L162:
            if (DigitalAvatarInfoManager.i() == false) goto L203;
            String r98 = DigitalAvatarInfoManager.e();
            if (r98 == null) goto L177;
            AvatarTemplateWidget r99 = this.a;
            CoroutineDispatcher r100 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$6$bitmap$1 r101 = new AvatarTemplateWidget$bindObserver$1$1$6$bitmap$1(r98, r99, null);
            r2.L$0 = r99;
            r2.label = 3;
            r1 = BuildersKt.withContext(r100, r101, r2);
            if (r1 != r4) goto L168;
            return r4;
        L168:
            r23 = r99;
            goto L169
        L203:
            if (DigitalAvatarInfoManager.h() == false) goto L234;
            CoroutineDispatcher r102 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$bitmap$2 r103 = new AvatarTemplateWidget$bindObserver$1$1$bitmap$2(this.a, null);
            r2.label = 4;
            r1 = BuildersKt.withContext(r102, r103, r2);
            if (r1 != r4) goto L207;
            return r4;
        L7:
            r2 = new AvatarTemplateWidget$bindObserver$1$1$emit$1(this, r25);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a(((Boolean) r1).booleanValue(), r2);
        }
    }

    public AvatarTemplateWidget$bindObserver$1(AvatarTemplateWidget r1, Continuation<? super AvatarTemplateWidget$bindObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AvatarTemplateWidget$bindObserver$1 r0 = new AvatarTemplateWidget$bindObserver$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        AvatarTemplateWidget r2 = this.this$0;
        int[] r3 = AvatarTemplateWidget.k;
        com.larus.bmhome.view.actionbar.edit.c r4 = r2.getViewModel();
        if (r4 == null) goto L18;
        i1 r5 = r4.getChosenAvatarInstructionStatus();
        if (r5 == null) goto L18;
        AnonymousClass1 r8 = new AnonymousClass1(this.this$0, r7);
        this.label = 1;
        if (r5.collect(r8, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
