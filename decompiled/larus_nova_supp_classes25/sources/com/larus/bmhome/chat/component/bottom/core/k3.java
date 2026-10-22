package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import android.widget.EditText;
import com.larus.bmhome.chat.component.bottom.voice.a;
import com.larus.im.bean.conversation.InputLeftButtonStyle;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k3 implements View.OnFocusChangeListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ LarusWidgetInputBinding c;

    public /* synthetic */ k3(EditText r1, CoreInputComponent r2, LarusWidgetInputBinding r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r14, boolean r15) {
        EditText r0 = this.a;
        final CoreInputComponent r1 = this.b;
        LarusWidgetInputBinding r2 = this.c;
        int r3 = CoreInputComponent.d3;
        FLogger.a.d("CoreInputComponent", "inputText focus changed, hasFocus:" + r15);
        r14.post(new v6(r1));
        boolean r4 = false;
        if (r0.getVisibility() != 0) goto L5;
        boolean r5 = true;
    L6:
        int r7 = 3;
        if (r5 == true) goto L9;
    L79:
        if (r15 == false) goto L87;
        Integer r6 = r1.F4().getInputLeftActionStyle();
        int r9 = InputLeftButtonStyle.ButtonStyle_Instruction.getValue();
        if (r6 == null) goto L87;
        if (r6.intValue() != r9) goto L87;
        r1.k4().t0("click_keyboard");
    L87:
        if (r0.getVisibility() != 0) goto L89;
        boolean r8 = true;
    L90:
        if (r8 == false) goto L96;
        if (Intrinsics.areEqual(r14, r0) == false) goto L96;
        if (r15 == true) goto L96;
        r1.o7(false);
    L96:
        if (r0.getVisibility() != 0) goto L98;
        boolean r10 = true;
    L99:
        if (r10 == true) goto L101;
    L120:
        r0.setOnTouchListener(null);
    L122:
        if (r0.getVisibility() != 0) goto L124;
        boolean r11 = true;
    L125:
        if (r11 == false) goto L137;
        if (r15 == false) goto L137;
        if (Intrinsics.areEqual(r14, r0) == false) goto L137;
        com.larus.bmhome.chat.component.fastsend.e0 r16 = (com.larus.bmhome.chat.component.fastsend.e0) r1.z.getValue();
        if (r16 != null) goto L132;
    L134:
        boolean r17 = false;
    L135:
        if (r17 == false) goto L137;
        r1.F10(null, true);
        goto L137
    L132:
        if (r16.bx() != true) goto L134;
        r17 = true;
    L137:
        Iterator r18 = r1.Q2.iterator();
    L139:
        if (r18.hasNext() == false) goto L141;
        ((Function1) r18.next()).invoke(Boolean.valueOf(r15));
        goto L139
    L141:
        r1.FZ(r1.F4().getCurrentInputStatus(), r15);
        a r19 = r1.Zd();
        if (r19 != null) goto L144;
    L146:
        boolean r110 = false;
    L147:
        if (r110 == false) goto L167;
        a r111 = r1.Zd();
        if (r111 != null) goto L152;
    L154:
        if (r4 == true) goto L168;
        if (r15 == true) goto L158;
        return;
    L158:
        if (r1.F4().getCurrentInputStatus() == 4) goto L165;
        a r112 = r1.Zd();
        if (r112 == null) goto L166;
        r112.Cd(r2.y);
        return;
    L166:
        return;
    L165:
        return;
    L168:
        return;
    L152:
        if (r111.DG() != true) goto L154;
        r4 = true;
        goto L154
    L167:
        return;
    L144:
        if (r19.q40() != true) goto L146;
        r110 = true;
        goto L147
    L124:
        r11 = false;
        goto L125
    L101:
        if (Intrinsics.areEqual(r14, r0) == false) goto L120;
        if (r15 == true) goto L120;
        if (r1.u7().length() != 0) goto L106;
        boolean r12 = true;
    L107:
        if (r12 == false) goto L120;
        r0.setOnTouchListener(r1.f5());
        a r13 = r1.Zd();
        if (r13 == null) goto L111;
        boolean r20 = r13.DG();
    L113:
        if (r1.F4().getCurrentInputStatus() == 2) goto L122;
        if (r20 == true) goto L122;
        CoreInputAbility r21 = r1.k4();
        if (r1.k4().k5() == true) goto L119;
        r7 = 1;
    L119:
        r21.g2(r7, true);
        goto L122
    L111:
        r20 = false;
        goto L113
    L106:
        r12 = false;
        goto L107
    L98:
        r10 = false;
        goto L99
    L89:
        r8 = false;
        goto L90
    L9:
        if (r1.F4().getCurrentInputStatus() != 4) goto L11;
        r1.k4().v0();
        goto L79
    L11:
        z8.c r22 = r1.F4().takeOverConfig().h;
        if (r22 == null) goto L14;
        Function0<Boolean> r23 = r22.b;
    L15:
        if (r23 != null) goto L17;
    L19:
        boolean r24 = false;
    L20:
        if (r24 == true) goto L78;
        CoreInputAbility r25 = r1.k4();
        com.larus.bmhome.instruction.g r26 = r1.l4().vc();
        if (r26 != null) goto L24;
    L26:
        boolean r27 = false;
    L27:
        if (r27 == false) goto L35;
        int r28 = od8.h0.a;
        com.larus.bmhome.instruction.g r29 = r1.l4().vc();
        if (r29 == null) goto L31;
        Integer r30 = Integer.valueOf(r29.Q1());
    L33:
        if (od8.h0.f(r30) == false) goto L35;
    L75:
        boolean r31 = true;
    L77:
        r25.Dr(r31);
        goto L78
    L31:
        r30 = null;
    L35:
        com.larus.bmhome.chat.component.bottom.reference.a r32 = r1.g5();
        if (r32 == null) goto L38;
        Boolean r33 = Boolean.valueOf(r32.i9());
    L39:
        com.larus.bmhome.chat.component.bottom.reference.a r113 = r1.g5();
        if (r113 != null) goto L42;
    L44:
        boolean r114 = false;
    L45:
        a r115 = r1.Zd();
        if (r115 != null) goto L48;
    L50:
        boolean r116 = false;
    L51:
        com.larus.bmhome.instruction.g r117 = r1.vc();
        if (r117 != null) goto L54;
    L56:
        boolean r118 = false;
    L57:
        if (r118 == true) goto L75;
        if (Intrinsics.areEqual(r33, Boolean.TRUE) == false) goto L62;
        if (r114 == true) goto L62;
    L76:
        r31 = false;
    L62:
        if (r116 == true) goto L76;
        if (r1.J8() == true) goto L75;
        if (r1.k4().e0() == true) goto L70;
        if (r15 == true) goto L76;
        if (r1.F4().getCurrentInputStatus() == 3) goto L76;
    L70:
        if (r1.F4().getCurrentInputStatus() == 3) goto L76;
    L54:
        if (r117.rA() != true) goto L56;
        r118 = true;
        goto L57
    L48:
        if (r115.DG() != true) goto L50;
        r116 = true;
        goto L51
    L42:
        if (r113.LX() != true) goto L44;
        r114 = true;
        goto L45
    L38:
        r33 = null;
        goto L39
    L24:
        if (r26.z0() != true) goto L26;
        r27 = true;
    L78:
        CoreInputAbility r34 = r1.k4();
        Intrinsics.checkNotNull(r14);
        r34.getClass();
        Intrinsics.checkNotNullParameter(r14, "view");
        r34.s.onFocusChange(r14, r15);
        goto L79
    L17:
        if (((Boolean) r23.invoke()).booleanValue() != true) goto L19;
        r24 = true;
        goto L20
    L14:
        r23 = null;
        goto L15
    L5:
        r5 = false;
        goto L6
    }
}
