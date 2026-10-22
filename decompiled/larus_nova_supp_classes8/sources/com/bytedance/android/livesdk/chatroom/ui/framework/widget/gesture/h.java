package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.w0;
import com.bytedance.android.livesdk.chatroom.widget.landscape.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ GestureWidget a;

    public h(GestureWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.getAction() != 0) goto L36;
        GestureWidget r4 = this.a;
        int r5 = GestureWidget.y;
        h70.b r6 = r4.getComponentContext();
        r r7 = null;
        if (r6 == null) goto L10;
        IAbilityCenter r8 = r6.a();
        if (r8 == null) goto L10;
        jo1.d r9 = (jo1.d) r8.getAbility(jo1.d.class);
    L11:
        if (r9 == null) goto L14;
        r9.dismissInputDialog();
    L14:
        if (this.a.isAnchor() == false) goto L23;
        h70.b r10 = this.a.getComponentContext();
        if (r10 == null) goto L20;
        IAbilityCenter r11 = r10.a();
        if (r11 == null) goto L20;
        w0 r12 = (w0) r11.getAbility(w0.class);
    L21:
        if (r12 == null) goto L23;
        r12.hideKeyboard();
    L20:
        r12 = null;
    L23:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r13 = this.a.b;
        if (r13 == null) goto L26;
        r7 = s.a(r13);
    L26:
        if (r7 == null) goto L34;
        View r14 = r7.f;
        if (r14 == null) goto L35;
        r14.setVisibility(8);
        return true;
    L35:
        return true;
    L34:
        return true;
    L10:
        r9 = null;
        goto L11
    L36:
        return false;
    }
}
