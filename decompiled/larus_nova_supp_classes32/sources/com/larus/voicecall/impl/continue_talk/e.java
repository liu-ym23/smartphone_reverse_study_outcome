package com.larus.voicecall.impl.continue_talk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusLayoutContinuousBottomContainerBinding;
import xa8.a;
import xa8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ e(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.voicecall.impl.continue_talk.f2] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.voicecall.impl.continue_talk.g2] */
    @Override // java.lang.Runnable
    public final void run() {
        ChatContinuousTalkComponent r0 = this.a;
        int r1 = ChatContinuousTalkComponent.M;
        final h2 r2 = r0.h3();
        r2.getClass();
        FLogger.a.i("ScreenEdgeEffectManager", "[tryDismissScreenEdgeEffect]: try dismiss screen edge effect");
        r2.e = false;
        d19.g r3 = r2.d;
        if (r3 == null) goto L5;
        r3.a(new f2(r2), new g2(r2));
    L5:
        r0.m3().setContinuousTalk(false);
        r0.m3().closeContinuousTalk();
        LarusLayoutContinuousBottomContainerBinding r4 = r0.n;
        if (r4 == null) goto L10;
        FrameLayout r5 = r4.c;
        if (r5 == null) goto L10;
        r5.setVisibility(8);
    L10:
        r0.H = false;
        va8.o r6 = (va8.o) r0.t.getValue();
        if (r6 == null) goto L13;
        r6.nX();
    L13:
        u7 r7 = r0.u3();
        if (r7 == null) goto L16;
        r7.tU(0);
    L16:
        LarusLayoutContinuousBottomContainerBinding r8 = r0.n;
        if (r8 == null) goto L25;
        View r9 = r8.f;
        if (r9 == null) goto L25;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L24;
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10;
        r11.bottomMargin = 0;
        r9.setLayoutParams(r11);
        com.larus.utils.e1.o(r9);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L25:
        u7 r12 = r0.u3();
        if (r12 == null) goto L28;
        u7.a.a(r12, r0.D);
    L28:
        a r13 = (a) r0.y.getValue();
        if (r13 == null) goto L31;
        r13.mD();
    L31:
        c r14 = (c) r0.z.getValue();
        if (r14 == null) goto L34;
        r14.vL();
    L34:
        com.larus.bmhome.instruction.g r15 = (com.larus.bmhome.instruction.g) r0.w.getValue();
        if (r15 == null) goto L37;
        r15.vW(true);
    L37:
        c r16 = (c) r0.z.getValue();
        if (r16 == null) goto L40;
        r16.a70();
    L40:
        fa9.e.a.f("voice_input", r0.o);
    }
}
