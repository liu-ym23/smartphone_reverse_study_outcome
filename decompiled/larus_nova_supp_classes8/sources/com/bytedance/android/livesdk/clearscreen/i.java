package com.bytedance.android.livesdk.clearscreen;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public final Element<?> a;
    public final v70.c b;
    public final View c;
    public ClearScreenConst.AnimType d;
    public final boolean e;
    public ViewPropertyAnimator f;
    public final String g;
    public final DataCenter h;
    public final d90.d i;
    public boolean j;

    public i() {
        this(0);
    }

    public final Float a() {
        if (this.e == false) goto L7;
        View r0 = this.c;
        if (r0 == null) goto L11;
        float r1 = r0.getAlpha();
    L13:
        return Float.valueOf(r1);
    L11:
        return null;
    L7:
        v70.c r2 = this.b;
        if (r2 == null) goto L11;
        r1 = r2.a.getAlpha();
        goto L13
    }

    public final ViewPropertyAnimator b() {
        if (this.e == false) goto L7;
        View r0 = this.c;
        if (r0 == null) goto L10;
        ViewPropertyAnimator r1 = r0.animate();
    L11:
        this.f = r1;
        return r1;
    L10:
        r1 = null;
        goto L11
    L7:
        v70.c r2 = this.b;
        if (r2 == null) goto L10;
        r1 = r2.a();
        goto L11
    }

    public final boolean c() {
        if (this.e == false) goto L10;
        View r0 = this.c;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getVisibility() != 0) goto L17;
        return true;
    L17:
        return false;
    L10:
        v70.c r1 = this.b;
        if (r1 != null) goto L13;
        return false;
    L13:
        if (r1.getVisibility() != 0) goto L19;
        return true;
    L19:
        return false;
    }

    public i(int r1) {
        this.j = false;
        this.d = ClearScreenConst.AnimType.TRANS;
        this.g = "";
    }

    public final void d(ArrayList<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "clearGoneList");
        if (((Boolean) e81.c.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (((Boolean) e81.d.getValue()).booleanValue() == false) goto L62;
        boolean r0 = this.e;
        if (r0 == true) goto L19;
        WidgetElement r2 = this.a;
        if ((r2 instanceof WidgetElement) == false) goto L19;
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.common.i r1 = (com.bytedance.android.livesdk.common.i) r2.f(com.bytedance.android.livesdk.common.i.class);
        if (r1 == null) goto L57;
        String r3 = r1.cg();
        if (r3 == null) goto L58;
        r6.remove(r3);
        return;
    L58:
        return;
    L57:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
    L19:
        if (r0 == true) goto L60;
        TetrisElement r4 = this.a;
        if ((r4 instanceof TetrisElement) == false) goto L61;
        if (r4 == null) goto L42;
        List r5 = r4.m;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();
        if ((((Element) r9) instanceof WidgetElement) == false) goto L25;
        r7.add(r9);
        goto L25
    L29:
        Iterator r10 = r7.iterator();
    L31:
        if (r10.hasNext() == false) goto L63;
        WidgetElement r11 = (Element) r10.next();
        if (r11 == null) goto L40;
        com.bytedance.android.livesdk.common.i r12 = (com.bytedance.android.livesdk.common.i) r11.f(com.bytedance.android.livesdk.common.i.class);
        if (r12 == null) goto L31;
        String r13 = r12.cg();
        if (r13 == null) goto L31;
        r6.remove(r13);
        goto L31
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
    L63:
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement");
    L61:
        return;
    L60:
        return;
    }

    public final void e(int r2) {
        if (this.e == false) goto L7;
        View r0 = this.c;
        if (r0 == null) goto L11;
        r0.setVisibility(r2);
        return;
    L11:
        return;
    L7:
        v70.c r1 = this.b;
        if (r1 == null) goto L13;
        r1.setVisibility(r2);
        return;
    }

    public i(Element<?> r3, ClearScreenConst.AnimType r4) {
        Intrinsics.checkNotNullParameter(r3, "element");
        Intrinsics.checkNotNullParameter(r4, "animType");
        this(0);
        this.b = r3.h();
        this.d = r4;
        this.a = r3;
        this.e = false;
        this.g = r3.d.a;
    }

    public i(View r2, ClearScreenConst.AnimType r3, String r4, d90.d r5) {
        Intrinsics.checkNotNullParameter(r3, "animType");
        Intrinsics.checkNotNullParameter(r4, "description");
        this(0);
        this.c = r2;
        this.d = r3;
        this.e = true;
        this.g = r4;
        this.i = r5;
        if (r5 == null) goto L5;
        DataCenter r6 = r5.h;
    L6:
        this.h = r6;
        return;
    L5:
        r6 = null;
        goto L6
    }
}
