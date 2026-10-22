package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import android.widget.EditText;
import com.larus.bmhome.chat.component.bottom.voice.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y5 implements Function1 {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 f;
    public final /* synthetic */ a g;
    public final /* synthetic */ EditText h;
    public final /* synthetic */ Ref.ObjectRef i;

    public /* synthetic */ y5(Ref.IntRef r1, CoreInputComponent r2, Ref.IntRef r3, Ref.IntRef r4, Ref.ObjectRef r5, com.larus.bmhome.chat.component.bottom.voice.d0 r6, a r7, EditText r8, Ref.ObjectRef r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final Object invoke(Object r13) {
        Ref.IntRef r0 = this.a;
        CoreInputComponent r1 = this.b;
        Ref.IntRef r2 = this.c;
        Ref.IntRef r3 = this.d;
        Ref.ObjectRef r4 = this.e;
        com.larus.bmhome.chat.component.bottom.voice.d0 r5 = this.f;
        a r6 = this.g;
        EditText r7 = this.h;
        Ref.ObjectRef r8 = this.i;
        com.larus.bmhome.chat.component.bottom.voice.service.d r14 = (com.larus.bmhome.chat.component.bottom.voice.service.d) r13;
        int r9 = CoreInputComponent.d3;
        int r10 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        com.larus.bmhome.chat.component.bottom.voice.d0.a.a("observeNonStreamDetailStatus " + r14);
        int r11 = -1;
        boolean r12 = true;
        if ((r14 instanceof com.larus.bmhome.chat.component.bottom.voice.service.d.e) == false) goto L23;
        r0.element = r1.u7().length();
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r15 = r1.W4();
        if (r15 == null) goto L7;
        int r16 = r15.V0();
    L8:
        r2.element = r16;
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r17 = r1.W4();
        if (r17 == null) goto L11;
        r11 = r17.e1();
    L11:
        r3.element = r11;
        com.larus.bmhome.chat.component.bottom.voice.d0.a.a("UserActionDown currentSelectionStart " + r2.element + " currentSelectionEnd " + r3.element + ", originTextLength " + r0.element);
        int r18 = r0.element;
        if (r18 != 0) goto L14;
        r4.element = "empty";
    L21:
        r5.c("long_press_button", (String) r4.element);
        r1.W5(false);
    L74:
        return Unit.INSTANCE;
    L14:
        int r19 = r2.element;
        if (r19 < 0) goto L18;
        if (r19 > r18) goto L18;
    L19:
        if (r12 == false) goto L21;
        r4.element = "mid";
    L18:
        r12 = false;
        goto L19
    L7:
        r16 = -1;
        goto L8
    L23:
        if ((r14 instanceof com.larus.bmhome.chat.component.bottom.voice.service.d.f) == false) goto L37;
        if (r1.f1().m() == null) goto L27;
        int r110 = 2131240674;
    L28:
        r6.jj(r7, r110, r1.u7());
        va8.m r111 = r1.vU();
        if (r111 == null) goto L35;
        va8.l r112 = r111.iX();
        if (r112 == null) goto L35;
        View r113 = r112.c();
        if (r113 == null) goto L35;
        com.larus.utils.e1.x(r113);
    L35:
        r8.element = "release_icon";
        goto L74
    L27:
        r110 = 2131240017;
        goto L28
    L37:
        if ((r14 instanceof com.larus.bmhome.chat.component.bottom.voice.service.d.a) == false) goto L47;
        r6.T70(r7);
        va8.m r114 = r1.vU();
        if (r114 == null) goto L45;
        va8.l r115 = r114.iX();
        if (r115 == null) goto L45;
        View r116 = r115.c();
        if (r116 == null) goto L45;
        com.larus.utils.e1.o(r116);
    L45:
        r1.W5(true);
        r1.Yt(r2.element, r3.element);
        r5.d(r0.element, 0, "long_press_button", (String) r8.element, (String) r4.element);
        goto L74
    L47:
        if ((r14 instanceof com.larus.bmhome.chat.component.bottom.voice.service.d.b) == false) goto L57;
        r6.T70(r7);
        va8.m r117 = r1.vU();
        if (r117 == null) goto L55;
        va8.l r118 = r117.iX();
        if (r118 == null) goto L55;
        View r119 = r118.c();
        if (r119 == null) goto L55;
        com.larus.utils.e1.o(r119);
    L55:
        r1.W5(true);
        r1.Yt(r2.element, r3.element);
        r5.d(r0.element, 0, "long_press_button", "error", (String) r4.element);
        goto L74
    L57:
        if ((r14 instanceof com.larus.bmhome.chat.component.bottom.voice.service.d.c) == false) goto L60;
        r1.h5(((com.larus.bmhome.chat.component.bottom.voice.service.d.c) r14).a.a, Integer.valueOf(r2.element), Integer.valueOf(r3.element));
        goto L74
    L60:
        if ((r14 instanceof com.larus.bmhome.chat.component.bottom.voice.service.d.C0055d) == false) goto L74;
        r6.T70(r7);
        va8.m r20 = r1.vU();
        if (r20 == null) goto L68;
        va8.l r21 = r20.iX();
        if (r21 == null) goto L68;
        View r22 = r21.c();
        if (r22 == null) goto L68;
        com.larus.utils.e1.o(r22);
    L68:
        r1.W5(true);
        r1.Yt(r2.element, r3.element);
        com.larus.bmhome.chat.component.bottom.voice.service.d.C0055d r120 = (com.larus.bmhome.chat.component.bottom.voice.service.d.C0055d) r14;
        com.larus.bmhome.chat.component.bottom.voice.service.e r23 = r120.a;
        int r24 = r23.c;
        if (r24 != (-1)) goto L71;
        r1.h5(r23.a, null, null);
    L72:
        r5.d(r0.element, r120.a.a.length(), "long_press_button", (String) r8.element, (String) r4.element);
        goto L74
    L71:
        r1.h5(r23.a, Integer.valueOf(r2.element - r24), Integer.valueOf(r2.element));
        goto L72
    }
}
