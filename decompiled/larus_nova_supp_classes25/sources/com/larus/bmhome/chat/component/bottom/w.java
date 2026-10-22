package com.larus.bmhome.chat.component.bottom;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatConstraintLayout;
import gd8.f;
import ry8.c;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ ChatBottomComponent a;

    public /* synthetic */ w(ChatBottomComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.bmhome.chat.component.bottom.s] */
    @Override // java.lang.Runnable
    public final void run() {
        final ChatBottomComponent r0 = this.a;
        int r1 = ChatBottomComponent.L0;
        r0.getClass();
        c r2 = d.a(r0).getAbility(c.class);
        if (r2 == null) goto L24;
        InputViewCreatorDelegate r3 = InputViewCreatorDelegate.b;
        LarusPageChatBinding r4 = r0.z3();
        FrameLayout r5 = null;
        if (r4 == null) goto L8;
        ChatConstraintLayout r6 = r4.a;
    L9:
        g9 r7 = r3.f(r6);
        if (r7 == null) goto L23;
        View r8 = r7.root();
        if (r8 == null) goto L25;
        r8.measure(0, 0);
        int r9 = r8.getMeasuredWidth();
        int r10 = r8.getMeasuredHeight();
        View r11 = r3.d(r0.getContext());
        r11.setId(2131375364);
        r11.setLayoutParams(new FrameLayout.LayoutParams(r9, r10));
        com.larus.utils.e1.q(r11);
        f r12 = r0.G3();
        if (r12 == null) goto L19;
        LarusPageChatBinding r13 = r12.e();
        if (r13 == null) goto L19;
        r5 = r13.i;
    L19:
        if (r5 == null) goto L26;
        r5.removeAllViews();
        r5.addView(r11);
        r2.g00(r8, r11);
        r2.Ri(new s(r0));
        return;
    L26:
        return;
    L25:
        return;
    L23:
        return;
    L8:
        r6 = null;
        goto L9
    }
}
