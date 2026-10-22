package com.larus.bmhome.instruction;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.tips.GuideTipsDelegate;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.chat.common.databinding.LarusLayoutInstructionEditorContainerBinding;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$1", f = "InstructionInputComponent.kt", i = {}, l = {1620}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r9v44, types: [com.larus.bmhome.instruction.t0] */
        public final Object emit(Object r22, Continuation r23) {
            aq8.j r0 = (aq8.j) r22;
            FLogger r2 = FLogger.a;
            r2.d("InstructionInputComponent", "actionBarInstructionChanged = " + r0);
            final InstructionInputComponent r3 = this.a;
            com.larus.bmhome.actionbar.model.z0 r4 = r0.a;
            final Function0<Unit> r5 = r0.c;
            String r6 = InstructionInputComponent.Z2;
            r3.getClass();
            r2.i("InstructionInputComponent", "openInstructionEditor");
            final com.larus.bmhome.actionbar.model.r r7 = r4.q;
            if (r7 == null) goto L200;
            boolean r8 = v19.h.a;
            if (v19.h.b(r3.getContext()) == false) goto L9;
            com.larus.bmhome.actionbar.model.g1 r9 = r4.d;
            if (r9 != null) goto L11;
        L12:
            String r10 = null;
        L13:
            Integer r11 = r3.H;
            if (r11 == null) goto L21;
            int r12 = r11.intValue();
            LarusLayoutInstructionEditorContainerBinding r13 = r3.k1;
            if (r13 == null) goto L18;
            AppCompatTextView r14 = r13.b;
        L19:
            if (r14 == null) goto L21;
            r14.setTextColor(ContextCompat.getColor(r3.getContext(), r12));
            goto L21
        L18:
            r14 = null;
        L21:
            LarusLayoutInstructionEditorContainerBinding r15 = r3.k1;
            if (r15 == null) goto L24;
            AppCompatTextView r16 = r15.b;
        L25:
            if (r16 != null) goto L27;
        L31:
            LarusLayoutInstructionEditorContainerBinding r17 = r3.k1;
            if (r17 == null) goto L34;
            AppCompatImageView r18 = r17.g;
        L35:
            if (r18 == null) goto L37;
            com.larus.utils.e1.o(r18);
        L37:
            LarusLayoutInstructionEditorContainerBinding r19 = r3.k1;
            if (r19 == null) goto L40;
            ConstraintLayout r20 = r19.k;
        L41:
            if (r20 == null) goto L43;
            r20.setClickable(false);
        L43:
            com.larus.bmhome.actionbar.model.r r21 = r4.q;
            if (r21 == null) goto L51;
            Integer r24 = r21.a;
            if (r24 == null) goto L51;
            if (r24.intValue() != 5) goto L51;
            boolean r25 = true;
        L53:
            if (r25 == true) goto L55;
        L86:
            LarusLayoutInstructionEditorContainerBinding r26 = r3.k1;
            if (r26 == null) goto L89;
            ConstraintLayout r27 = r26.j;
        L90:
            if (r27 == null) goto L96;
            ViewGroup.LayoutParams r110 = r27.getLayoutParams();
            if (r110 == null) goto L95;
            ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
            ((ViewGroup.MarginLayoutParams) r111).height = i5.h0();
            r27.setLayoutParams(r111);
            goto L96
        L95:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L96:
            LarusLayoutInstructionEditorContainerBinding r28 = r3.k1;
            if (r28 == null) goto L99;
            ConstraintLayout r29 = r28.k;
        L100:
            if (r29 == null) goto L106;
            ViewGroup.LayoutParams r112 = r29.getLayoutParams();
            if (r112 == null) goto L105;
            ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
            ((ViewGroup.MarginLayoutParams) r113).height = -1;
            r113.topToTop = 0;
            r113.bottomToBottom = 0;
            r113.startToStart = 0;
            ((ViewGroup.MarginLayoutParams) r113).bottomMargin = 0;
            r29.setLayoutParams(r113);
            goto L106
        L105:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L106:
            LarusLayoutInstructionEditorContainerBinding r30 = r3.k1;
            if (r30 == null) goto L109;
            AppCompatImageView r31 = r30.c;
        L110:
            if (r31 == null) goto L116;
            ViewGroup.LayoutParams r114 = r31.getLayoutParams();
            if (r114 == null) goto L115;
            ViewGroup.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
            ((ConstraintLayout.LayoutParams) r115).topToTop = 0;
            ((ConstraintLayout.LayoutParams) r115).bottomToBottom = 0;
            ((ConstraintLayout.LayoutParams) r115).endToEnd = 0;
            r31.setLayoutParams(r115);
            goto L116
        L115:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L116:
            vp8.k r32 = r3.m;
            if (r32 == null) goto L119;
            Boolean r33 = Boolean.valueOf(r32.g(r7));
        L121:
            if (Intrinsics.areEqual(r33, Boolean.TRUE) == true) goto L200;
            if (com.larus.utils.o0.d(r10) == false) goto L131;
            LarusLayoutInstructionEditorContainerBinding r34 = r3.k1;
            if (r34 == null) goto L128;
            SimpleDraweeView r35 = r34.h;
        L129:
            if (r35 == null) goto L139;
            ImageLoaderKt.y(r35, r10, "custom_actionbar_icon_instruction", new r0(), 4);
        L139:
            LarusLayoutInstructionEditorContainerBinding r36 = r3.k1;
            if (r36 == null) goto L142;
            View r37 = r36.d;
        L143:
            if (r37 == null) goto L145;
            com.larus.utils.e1.d(r37, new s0(r3));
        L145:
            InstructionEditorViewModel r116 = r3.a4();
            if (r116 == null) goto L155;
            r116.setActionBarName(String.valueOf(r4.e), String.valueOf(r7.a), r7.g);
            LarusLayoutInstructionEditorContainerBinding r38 = r3.k1;
            if (r38 == null) goto L150;
            LinearLayout r117 = r38.i;
        L151:
            if (r117 == null) goto L155;
            r117.removeAllViews();
            com.larus.bmhome.view.actionbar.edit.b r39 = r3.P1;
            if (r39 == null) goto L155;
            com.larus.bmhome.view.actionbar.edit.b.a.a(r39, r7, r117, r116, r3.r, r3.s, (InstructionInputComponent.f) r3.x2.getValue(), new com.larus.bmhome.view.actionbar.edit.d(r116.getInstructionDefaultParams()), null, false, new t0(r3), 384);
            goto L155
        L150:
            r117 = null;
        L155:
            int r40 = od8.h0.a;
            Integer r41 = r7.a;
            if (r41 != null) goto L159;
        L161:
            boolean r42 = false;
        L162:
            if (r42 == true) goto L179;
            Integer r43 = r7.a;
            if (r43 != null) goto L167;
        L169:
            boolean r44 = false;
        L170:
            if (r44 == true) goto L179;
            final int r45 = r3.T1 + 1;
            r3.T1 = r45;
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Fragment r46 = com.larus.ui.arch.component.internal.attach.a.b(r3, r3);
            Function0 r118 = new u0(r45, r3, r7, r5);
            InstructionEditorViewModel r47 = r3.a4();
            if (r47 == null) goto L174;
            com.larus.bmhome.actionbar.model.r r48 = r47.getInstructionRebuildStateConf();
        L175:
            if (r48 != null) goto L177;
            long r119 = 0;
        L178:
            SafeExtKt.c(r46, r118, r119);
        L182:
            Integer r49 = r7.a;
            if (r49 != null) goto L186;
        L195:
            com.larus.bmhome.view.actionbar.deepresearch.b r50 = com.larus.bmhome.view.actionbar.deepresearch.b.a;
            com.larus.bmhome.chat.component.cvs.y r51 = r3.u0();
            if (r51 == null) goto L198;
            String r52 = r51.Y1();
        L199:
            com.larus.bmhome.view.actionbar.deepresearch.b.a(r52);
            goto L200
        L198:
            r52 = null;
            goto L199
        L186:
            if (r49.intValue() != 21) goto L195;
            com.larus.bmhome.view.actionbar.deepresearch.b r53 = com.larus.bmhome.view.actionbar.deepresearch.b.a;
            t1a.b r54 = s1a.d.a(r3);
            monitor-enter(r53);
            Intrinsics.checkNotNullParameter(r4, "item");     // Catch: Throwable -> L192
            Intrinsics.checkNotNullParameter(r54, "context");     // Catch: Throwable -> L192
            com.larus.bmhome.view.actionbar.deepresearch.b.c = r4;     // Catch: Throwable -> L192
            com.larus.bmhome.view.actionbar.deepresearch.b.d = r54.getAbility(g.class);     // Catch: Throwable -> L192
            com.larus.bmhome.view.actionbar.deepresearch.b.e = r54.getAbility(com.larus.bmhome.chat.component.cvs.y.class);     // Catch: Throwable -> L192
            GuideTipsDelegate.b.b(1);     // Catch: Throwable -> L192
            monitor-exit(r53);
        L192:
            th = move-exception;
            throw th;
        L177:
            r119 = 200;
            goto L178
        L174:
            r48 = null;
            goto L175
        L167:
            if (r43.intValue() != 13) goto L169;
            r44 = true;
        L179:
            InstructionEditorViewModel r55 = r3.a4();
            if (r55 == null) goto L182;
            r55.onInstructionEditorViewChanged(1, r5);
            goto L182
        L159:
            if (r41.intValue() != 8) goto L161;
            r42 = true;
            goto L162
        L142:
            r37 = null;
            goto L143
        L128:
            r35 = null;
            goto L129
        L131:
            Integer r56 = r3.G;
            if (r56 == null) goto L139;
            int r57 = r56.intValue();
            LarusLayoutInstructionEditorContainerBinding r58 = r3.k1;
            if (r58 == null) goto L136;
            SimpleDraweeView r59 = r58.h;
        L137:
            if (r59 == null) goto L139;
            r59.setImageResource(r57);
            goto L139
        L136:
            r59 = null;
            goto L137
        L119:
            r33 = null;
            goto L121
        L109:
            r31 = null;
            goto L110
        L99:
            r29 = null;
            goto L100
        L89:
            r27 = null;
            goto L90
        L55:
            if (AppHost.a.isOversea() == true) goto L86;
            LarusLayoutInstructionEditorContainerBinding r60 = r3.k1;
            if (r60 == null) goto L59;
            ConstraintLayout r61 = r60.j;
        L60:
            if (r61 == null) goto L66;
            ViewGroup.LayoutParams r120 = r61.getLayoutParams();
            if (r120 == null) goto L65;
            ConstraintLayout.LayoutParams r121 = (ConstraintLayout.LayoutParams) r120;
            ((ViewGroup.MarginLayoutParams) r121).height = i5.b0();
            r61.setLayoutParams(r121);
            goto L66
        L65:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L66:
            LarusLayoutInstructionEditorContainerBinding r62 = r3.k1;
            if (r62 == null) goto L69;
            ConstraintLayout r63 = r62.k;
        L70:
            if (r63 == null) goto L76;
            ViewGroup.LayoutParams r122 = r63.getLayoutParams();
            if (r122 == null) goto L75;
            ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
            ((ViewGroup.MarginLayoutParams) r123).height = -2;
            r123.topToTop = -1;
            r123.bottomToBottom = 0;
            ((ViewGroup.MarginLayoutParams) r123).bottomMargin = i5.z();
            r63.setLayoutParams(r123);
            goto L76
        L75:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L76:
            LarusLayoutInstructionEditorContainerBinding r64 = r3.k1;
            if (r64 == null) goto L79;
            AppCompatImageView r65 = r64.c;
        L80:
            if (r65 == null) goto L116;
            ViewGroup.LayoutParams r124 = r65.getLayoutParams();
            if (r124 == null) goto L85;
            ViewGroup.LayoutParams r125 = (ConstraintLayout.LayoutParams) r124;
            ((ConstraintLayout.LayoutParams) r125).topToTop = -1;
            ((ConstraintLayout.LayoutParams) r125).bottomToBottom = 0;
            r65.setLayoutParams(r125);
            goto L116
        L85:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L79:
            r65 = null;
            goto L80
        L69:
            r63 = null;
            goto L70
        L59:
            r61 = null;
        L51:
            r25 = false;
            goto L53
        L40:
            r20 = null;
            goto L41
        L34:
            r18 = null;
            goto L35
        L27:
            if (com.larus.utils.o0.d(r4.h) == false) goto L29;
            String r126 = r4.h;
        L30:
            r16.setText(r126);
            goto L31
        L29:
            r126 = r4.e;
            goto L30
        L24:
            r16 = null;
        L11:
            r10 = r9.b;
            goto L13
        L9:
            r9 = r4.c;
            if (r9 == null) goto L12;
        L200:
            ICoreInputAbility r66 = this.a.G3();
            if (r66 == null) goto L203;
            r66.C1(false, true, "");
        L203:
            CustomActionBar r67 = this.a.P0;
            if (r67 == null) goto L206;
            r67.S();
        L206:
            aq8.e r68 = r0.b;
            if (r68 == null) goto L224;
            String r69 = r68.a;
            if (r69 == null) goto L224;
            InstructionInputComponent r127 = this.a;
            ICoreInputAbility r70 = r127.G3();
            if (r70 == null) goto L220;
            aq8.e r1 = r0.b;
            if (r1 == null) goto L215;
            Integer r71 = r1.b;
        L216:
            if (r1 == null) goto L218;
            Integer r72 = r1.c;
        L219:
            ICoreInputAbility.b.d(r70, r69, false, true, r71, r72, false, 32);
            goto L220
        L218:
            r72 = null;
            goto L219
        L215:
            r71 = null;
        L220:
            qaa.a r73 = r127.h4();
            if (r73 == null) goto L224;
            r73.yh(r69);
        L224:
            return Unit.INSTANCE;
        }
    }

    public InstructionInputComponent$observerInstructionEditor$1(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InstructionInputComponent r6 = this.this$0;
        String r2 = InstructionInputComponent.Z2;
        kotlinx.coroutines.flow.d1<aq8.j> r7 = r6.a4().getActionBarInstructionChanged();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
