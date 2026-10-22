package com.obric.assistant.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.view.ObricIconSwipeUpView;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OrionChatWindowComponent$b implements ObricIconSwipeUpView.c {
    public final /* synthetic */ OrionChatWindowComponent a;
    public final /* synthetic */ ObricIconSwipeUpView b;

    @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
    public final void c() {
    }

    @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
    public final void b(float r11) {
        OrionChatWindowComponent r0 = this.a;
        int r1 = OrionChatWindowComponent.T;
        laa.d r2 = r0.B3();
        if (r2 == null) goto L6;
        laa.d.a.d(r2, true, com.obric.assistant.util.m2.b, Float.valueOf(r11), true, false, null, 48);
        return;
    }

    @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
    public final void onClick(boolean r10) {
        if (r10 == false) goto L6;
        OrionChatWindowComponent r11 = this.a;
        int r0 = OrionChatWindowComponent.T;
        laa.d r1 = r11.B3();
        if (r1 == null) goto L22;
        laa.d.a.d(r1, true, com.obric.assistant.util.m2.b, null, true, false, null, 52);
        return;
    L22:
        return;
    L6:
        laa.h r12 = (laa.h) this.a.m.getValue();
        if (r12 == null) goto L11;
        boolean r2 = true;
        if (r12.W10() != true) goto L11;
    L12:
        if (r2 == false) goto L17;
        FLogger.a.i("OrionWindowStyleComponent", "close secondary menu");
        laa.h r13 = (laa.h) this.a.m.getValue();
        if (r13 == null) goto L21;
        r13.X30();
        return;
    L21:
        return;
    L17:
        laa.d r14 = this.a.B3();
        if (r14 == null) goto L24;
        r14.Gm(false);
        return;
    L24:
        return;
    L11:
        r2 = false;
        goto L12
    }

    public OrionChatWindowComponent$b(OrionChatWindowComponent r1, ObricIconSwipeUpView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
    public final void d(float r9, boolean r10) {
        OrionChatWindowComponent r0 = this.a;
        int r1 = OrionChatWindowComponent.T;
        laa.d r2 = r0.B3();
        boolean r3 = true;
        if (r2 == null) goto L9;
        ObricFloatChatPageState r4 = r2.getPageState();
        if (r4 == null) goto L9;
        if (r4.getHeight() != 0) goto L9;
        boolean r5 = true;
    L10:
        int r6 = Integer.MAX_VALUE;
        if (r5 == true) goto L24;
        laa.d r7 = this.a.B3();
        if (r7 == null) goto L17;
        ObricFloatChatPageState r8 = r7.getPageState();
        if (r8 == null) goto L17;
        int r11 = r8.getHeight();
    L19:
        if (r11 > com.obric.assistant.util.m2.e) goto L24;
        laa.d r12 = this.a.B3();
        if (r12 == null) goto L50;
        laa.d.a.c(r12, null, false, null, 7);
    L50:
        this.b.c();
        return;
    L17:
        r11 = Integer.MAX_VALUE;
    L24:
        if (r9 <= (-i5.k0())) goto L32;
        laa.d r13 = this.a.B3();
        if (r13 == null) goto L31;
        ObricFloatChatPageState r14 = r13.getPageState();
        if (r14 == null) goto L31;
        r6 = r14.getHeight();
    L31:
        if (r6 <= com.obric.assistant.util.m2.b) goto L32;
    L47:
        laa.d r15 = this.a.B3();
        if (r15 == null) goto L50;
        laa.d.a.a(r15, 0.0f, false, 3);
    L32:
        if (r10 == false) goto L47;
        laa.d r16 = this.a.B3();
        if (r16 == null) goto L42;
        ObricFloatChatPageState r17 = r16.getPageState();
        if (r17 == null) goto L42;
        ObricFloatChatPageState r18 = r17.getPreviousState();
        if (r18 == null) goto L42;
        ObricFloatChatPageData.Companion.getClass();
        if ((r18 instanceof vda.a) != true) goto L42;
    L43:
        if (r3 == false) goto L47;
        laa.d r19 = this.a.B3();
        if (r19 == null) goto L50;
        laa.d.a.d(r19, true, com.obric.assistant.util.m2.b, null, true, false, null, 52);
    L42:
        r3 = false;
    L9:
        r5 = false;
        goto L10
    }

    @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
    public final void a(float r5, float r6, boolean r7) {
        GradientMaskView r0 = null;
        if (r7 == false) goto L25;
        OrionChatWindowComponent r8 = this.a;
        int r9 = OrionChatWindowComponent.T;
        laa.d r10 = r8.B3();
        int r11 = 0;
        if (r10 == null) goto L11;
        ObricFloatChatPageState r12 = r10.getPageState();
        if (r12 == null) goto L11;
        ObricFloatChatPageData.Companion.getClass();
        boolean r1 = true;
        if ((r12 instanceof vda.a) != true) goto L11;
    L12:
        if (r1 == false) goto L17;
        int r13 = com.obric.assistant.util.m2.a;
        ViewGroup r14 = (ViewGroup) this.a.x.getValue();
        View r15 = this.a.m3();
        FrameLayout r2 = (FrameLayout) this.a.z.getValue();
        com.larus.bmhome.chat.component.bottom.core.a r3 = this.a.p3();
        if (r3 == null) goto L16;
        r0 = r3.a();
    L16:
        r11 = com.obric.assistant.util.m2.b(r14, r15, r2, r0);
    L22:
        laa.d r16 = this.a.B3();
        if (r16 == null) goto L33;
        r16.o2(r11 + ((int) r6));
        return;
    L33:
        return;
    L17:
        laa.d r17 = this.a.B3();
        if (r17 == null) goto L22;
        ObricFloatChatPageState r18 = r17.getPageState();
        if (r18 == null) goto L22;
        r11 = r18.getHeight();
    L11:
        r1 = false;
        goto L12
    L25:
        OrionChatWindowComponent r19 = this.a;
        int r20 = OrionChatWindowComponent.T;
        laa.d r21 = r19.B3();
        if (r21 == null) goto L31;
        int r22 = com.obric.assistant.util.m2.a;
        ViewGroup r23 = (ViewGroup) this.a.x.getValue();
        View r4 = this.a.m3();
        FrameLayout r24 = (FrameLayout) this.a.z.getValue();
        com.larus.bmhome.chat.component.bottom.core.a r25 = this.a.p3();
        if (r25 == null) goto L30;
        r0 = r25.a();
    L30:
        r21.o2(com.obric.assistant.util.m2.b(r23, r4, r24, r0));
    L31:
        this.b.d(((i5.q() * 0.15f) * r5) / (i5.q() + (r5 * 0.15f)));
    }
}
