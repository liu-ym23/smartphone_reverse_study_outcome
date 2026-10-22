package com.larus.bmhome.chat.mode;

import android.view.View;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.layout.widget.NestedScrollableContainer;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.utils.logger.FLogger;
import gd8.f;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ ModeSwitchComponent a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ x(ModeSwitchComponent r1, l0 r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ModeSwitchComponent r0 = this.a;
        l0 r1 = this.b;
        int r2 = this.c;
        int r3 = this.d;
        int r4 = ModeSwitchComponent.k0;
        ICoreInputAbility r5 = (ICoreInputAbility) r0.r.getValue();
        boolean r6 = false;
        if (r5 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == true) goto L49;
        View r8 = r1.getContentView();
        Object r9 = r1.getParent();
        if ((r9 instanceof View) == false) goto L13;
        View r10 = (View) r9;
    L14:
        if (r10 == null) goto L50;
        f r11 = (f) s1a.d.a(r0).getAbility(f.class);
        if (r11 == null) goto L45;
        LarusPageChatBinding r12 = r11.e();
        if (r12 == null) goto L46;
        NestedScrollableContainer r13 = r12.o;
        if (r13 != null) goto L23;
        return;
    L23:
        if (r8.getHeight() == 0) goto L51;
        int r14 = RangesKt.coerceAtLeast(((r13.getHeight() - r8.getHeight()) - r0.h3(r10, DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION)) / 2, 0);
        int r15 = r13.getBottom() - r0.N;
        int r16 = (r13.getTop() + r14) + r8.getHeight();
        float r17 = r14;
        if (r0.N <= 0) goto L28;
        float r18 = RangesKt.coerceAtMost((r15 - r0.h3(r10, 36)) - r16, 0);
    L29:
        r8.setTranslationY(r17 + r18);
        float r19 = r8.getY();
        if (r19 >= r0.h3(r10, 16)) goto L32;
        boolean r110 = true;
    L33:
        r0.A = r110;
        int r20 = r0.h3(r10, 16);
        float r111 = r19 - r1.c(96, 1.0f);
        r1.g.setTranslationY(r111);
        if (r111 < r20) goto L36;
        boolean r21 = true;
    L37:
        r1.y = r21;
        r1.l(r1.s, r1.r, r1.o);
        r0.V3();
        if (r2 == r3) goto L40;
    L43:
        r0.O = r8.getTranslationY();
        FLogger.a.d("ModeSwitchComponent", "wcb sug height changed localMessageId=" + r0.M + " oldHeight=" + r2 + " newHeight=" + r0.N + " content=" + r13.getTop() + ".." + r13.getBottom() + " centeredTop=" + r14 + " height=" + r8.getHeight() + " sliderBottom=" + r16 + " sugTop=" + r15 + " translationY=" + r8.getTranslationY());
        return;
    L40:
        if (r8.getTranslationY() != r0.O) goto L42;
        r6 = true;
    L42:
        if (r6 == false) goto L43;
        return;
    L36:
        r21 = false;
        goto L37
    L32:
        r110 = false;
        goto L33
    L28:
        r18 = 0.0f;
        goto L29
    L51:
        return;
    L46:
        return;
    L45:
        return;
    L50:
        return;
    L13:
        r10 = null;
        goto L14
    L49:
        return;
    L5:
        if (r5.c2() != true) goto L7;
        r7 = true;
        goto L8
    }
}
