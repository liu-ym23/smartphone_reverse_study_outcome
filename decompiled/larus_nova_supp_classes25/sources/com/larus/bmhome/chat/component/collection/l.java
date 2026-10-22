package com.larus.bmhome.chat.component.collection;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.d;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.utils.i;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import kotlin.Unit;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements View.OnClickListener {
    public final /* synthetic */ ChatCollectMessageComponent a;
    public final /* synthetic */ NovaTitleBarEx b;

    public /* synthetic */ l(ChatCollectMessageComponent r1, NovaTitleBarEx r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r54) {
        final ChatCollectMessageComponent r1 = this.a;
        final NovaTitleBarEx r11 = this.b;
        if (r1.n != null) goto L5;
        return;
    L5:
        if (r1.h3() == false) goto L7;
        int r14 = 2131908557;
    L9:
        if (r1.h3() == false) goto L11;
        int r2 = v19.c.b(2130971811, r1.getContext(), 2131241921);
    L12:
        ArrayList r3 = new ArrayList();
        int r13 = r14;
        r3.add(new l0(r13, r14, null, null, null, null, null, Integer.valueOf(r2), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127));
        View r12 = CreateMenu.f(new CreateMenu(r1.getContext()), r3, 0, false, null, null, null, null, new b(r1, r11), 510);
        Balloon r4 = d.a(d.a, r11, r12, false, null, null, null, null, 124);
        ViewGroup.LayoutParams r5 = r12.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L16:
        if (r6 == null) goto L20;
        r6.setMarginEnd((-i5.Q()) + i5.r0());
    L20:
        if (i.h(r1.getContext()) == false) goto L22;
        r4.x(r11, -r11.getMeasuredWidth(), -i5.Q());
    L23:
        Unit r7 = Unit.INSTANCE;
        return;
    L22:
        r4.x(r11, r11.getMeasuredWidth(), -i5.Q());
        goto L23
    L15:
        r6 = null;
        goto L16
    L11:
        r2 = v19.c.b(2130971810, r1.getContext(), 2131241918);
        goto L12
    L7:
        r14 = 2131910857;
        goto L9
    }
}
