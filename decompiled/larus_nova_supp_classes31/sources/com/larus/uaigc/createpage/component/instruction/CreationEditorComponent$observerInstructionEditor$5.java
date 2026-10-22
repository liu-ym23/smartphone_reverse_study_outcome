package com.larus.uaigc.createpage.component.instruction;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$5", f = "CreationEditorComponent.kt", i = {}, l = {2900}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r21, Continuation r22) {
            aq8.j r1 = (aq8.j) r21;
            FLogger r2 = FLogger.a;
            r2.d("CreationEditorComponent", "actionBarInstructionChanged");
            final CreationEditorComponent r3 = this.a;
            com.larus.bmhome.actionbar.model.z0 r5 = r1.a;
            int r6 = CreationEditorComponent.g2;
            r3.getClass();
            r2.i("CreationEditorComponent", "openInstructionEditor");
            com.larus.bmhome.actionbar.model.r r4 = r5.q;
            Integer r7 = null;
            if (r4 == null) goto L101;
            ViewGroup r8 = r3.h4();
            if (r8 == null) goto L7;
            ConstraintLayout r9 = r8.findViewById(2131388849);
        L9:
            if (r9 == null) goto L11;
            r9.setClickable(false);
        L11:
            LinearLayout r10 = r3.C;
            if (r10 != null) goto L14;
            boolean r0 = false;
        L71:
            View r11 = r3.o;
            if (r11 == null) goto L74;
            com.larus.utils.e1.x(r11);
        L74:
            View r12 = r3.o;
            if (r12 == null) goto L93;
            SimpleDraweeView r13 = r12.findViewById(2131374716);
            TextView r14 = (TextView) r12.findViewById(2131362053);
            ImageView r15 = (ImageView) r12.findViewById(2131364717);
            if (((Boolean) r3.v1.getValue()).booleanValue() == false) goto L81;
            com.larus.bmhome.actionbar.model.g1 r16 = r5.d;
            if (r16 != null) goto L83;
        L84:
            String r17 = null;
        L86:
            if (com.larus.utils.o0.d(r17) == false) goto L89;
            ImageLoaderKt.u(r13, r17, "creation_inner_instruction_editor");
        L89:
            if (com.larus.utils.o0.d(r5.h) == false) goto L91;
            String r18 = r5.h;
        L92:
            r14.setText(r18);
            com.larus.utils.e1.d(r15, new l1(r3));
            goto L93
        L91:
            r18 = r5.e;
        L83:
            r17 = r16.b;
            goto L86
        L81:
            r16 = r5.c;
            if (r16 == null) goto L84;
        L93:
            com.larus.bmhome.actionbar.model.h1 r19 = r4.c;
            if (r19 == null) goto L98;
            String r20 = r19.a;
            if (r20 == null) goto L98;
            r3.Q5(r20);
        L98:
            ICoreInputAbility r23 = r3.a4();
            if (r23 == null) goto L101;
            ICoreInputAbility.b.e(r23, "creation_openInstructionEditor", null, r0, 6);
            goto L101
        L14:
            if (r3.R4() == false) goto L19;
            LinearLayout r24 = r3.j4();
            if (r24 == null) goto L19;
            r10 = r24;
        L19:
            uz9.a r25 = r3.r;
            if (r25 == null) goto L22;
            r25.a.clear();
            r25.b = null;
        L22:
            com.larus.bmhome.view.actionbar.edit.b r26 = r3.D3();
            uz9.a r27 = r3.r;
            if (r27 == null) goto L25;
            Intrinsics.checkNotNullParameter(r26, "factory");
            r27.a.add(r26);
        L25:
            View r28 = LayoutInflater.from(r3.getContext()).inflate(2131562002, null);
            r3.o = r28;
            if (r28 == null) goto L28;
            com.larus.utils.e1.o(r28);
        L28:
            View r29 = r3.o;
            ny9.s r30 = r3.W3();
            if (r30 == null) goto L33;
            boolean r31 = true;
            if (r30.z() != true) goto L33;
        L34:
            if (r31 == false) goto L36;
            LinearLayout r32 = null;
        L37:
            if (r32 == null) goto L39;
            r32.removeAllViews();
            r32.addView(r29);
        L39:
            uz9.a r33 = r3.r;
            if (r33 == null) goto L66;
            com.larus.bmhome.view.actionbar.edit.c r110 = r3.i4();
            r110.setCurrentInstructionConfig(r4);
            ny9.s r34 = r3.W3();
            if (r34 == null) goto L44;
            String r35 = r34.w();
        L45:
            String r111 = "";
            if (r35 != null) goto L48;
            r35 = "";
        L48:
            String r112 = String.valueOf(r4.a);
            String r113 = r4.g;
            if (r113 == null) goto L52;
            r111 = r113;
        L52:
            r110.setActionBarName(r35, r112, r111);
            ny9.s r36 = r3.W3();
            if (r36 == null) goto L57;
            ChatParam r37 = r36.c();
            if (r37 == null) goto L57;
            r110.bindChatParam(r37);
        L57:
            Unit r38 = Unit.INSTANCE;
            if (r3.R4() == false) goto L60;
            ActivityResultLauncher<String> r114 = r3.L0;
        L62:
            if (r3.R4() == false) goto L64;
            ActivityResultLauncher<Intent> r115 = r3.P0;
        L65:
            r0 = false;
            com.larus.bmhome.view.actionbar.edit.b.a.a(r33, r4, r32, r110, r114, r115, (CreationEditorComponent.e) r3.X.getValue(), new com.larus.bmhome.view.actionbar.edit.d(r3.i4().getInstructionDefaultParams()), null, false, null, 896);
        L67:
            qy9.a r39 = r3.e4();
            if (r39 == null) goto L71;
            r39.lk(r10);
            goto L71
        L64:
            r115 = null;
            goto L65
        L60:
            r114 = null;
            goto L62
        L44:
            r35 = null;
            goto L45
        L66:
            r0 = false;
            goto L67
        L36:
            r32 = r10;
        L33:
            r31 = false;
            goto L34
        L7:
            r9 = null;
        L101:
            aq8.e r40 = r1.b;
            if (r40 == null) goto L116;
            String r41 = r40.a;
            if (r41 == null) goto L116;
            ICoreInputAbility r42 = this.a.a4();
            if (r42 == null) goto L116;
            aq8.e r43 = r1.b;
            if (r43 == null) goto L110;
            Integer r44 = r43.b;
        L111:
            if (r43 == null) goto L113;
            r7 = r43.c;
        L113:
            ICoreInputAbility.b.d(r42, r41, false, true, r44, r7, false, 32);
            goto L116
        L110:
            r44 = null;
        L116:
            return Unit.INSTANCE;
        }
    }

    public CreationEditorComponent$observerInstructionEditor$5(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$5(this.this$0, r3);
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
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getActionBarInstructionChanged();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
