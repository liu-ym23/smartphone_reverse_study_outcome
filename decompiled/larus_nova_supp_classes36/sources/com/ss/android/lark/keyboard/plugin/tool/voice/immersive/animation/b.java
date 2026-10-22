package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final int a;
    public final String b;
    public final HashMap<Integer, Integer> c;
    public int d;
    public float e;

    public final void d() {
        v(0);
        n(0);
        y(0);
        b(0);
    }

    public final void f() {
        this.c.put(10, -1);
        this.c.remove(11);
        this.c.remove(15);
    }

    public final void g() {
        this.c.put(2, -1);
        this.c.remove(3);
        this.c.remove(17);
    }

    public final void h() {
        this.c.put(4, -1);
        this.c.remove(5);
        this.c.remove(12);
    }

    public final void i() {
        this.c.put(6, -1);
        this.c.remove(7);
        this.c.remove(13);
    }

    public final void j() {
        this.c.put(0, -1);
        this.c.remove(1);
        this.c.remove(16);
    }

    public final void k() {
        this.c.put(8, -1);
        this.c.remove(9);
        this.c.remove(14);
    }

    public final String toString() {
        Iterator<Map.Entry<Integer, Integer>> r0 = this.c.entrySet().iterator();
        StringBuilder r1 = new StringBuilder("view:" + this.b + '(' + this.a + ")->");
    L4:
        if (r0.hasNext() == false) goto L33;
        Map.Entry<Integer, Integer> r2 = r0.next();
        int r3 = r2.getKey().intValue();
        if (r3 != 30) goto L8;
        String r4 = "CONSTRAINT_WIDTH:" + r2.getValue().intValue() + "  ";
    L31:
        r1.append(r4);
        goto L4
    L8:
        if (r3 == 31) goto L29;
        switch(r3) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            default: goto L10;
        };
    L10:
        r4 = InvRouter.UNKNOWN;
        goto L31
    L11:
        r4 = "END_MARGIN:" + r2.getValue().intValue() + "  ";
        goto L31
    L12:
        r4 = "START_MARGIN:" + r2.getValue().intValue() + "  ";
        goto L31
    L13:
        r4 = "BOTTOM_MARGIN:" + r2.getValue().intValue() + "  ";
        goto L31
    L14:
        r4 = "TOP_MARGIN:" + r2.getValue().intValue() + "  ";
        goto L31
    L15:
        r4 = "RIGHT_MARGIN:" + r2.getValue().intValue() + "  ";
        goto L31
    L16:
        r4 = "LEFT_MARGIN:" + r2.getValue().intValue() + "  ";
        goto L31
    L17:
        r4 = "BOTTOM_TO_TOP:" + r2.getValue().intValue() + "  ";
        goto L31
    L18:
        r4 = "BOTTOM_TO_BOTTOM:" + r2.getValue().intValue() + "  ";
        goto L31
    L19:
        r4 = "TOP_TO_BOTTOM:" + r2.getValue().intValue() + "  ";
        goto L31
    L20:
        r4 = "TOP_TO_TOP:" + r2.getValue().intValue() + "  ";
        goto L31
    L21:
        r4 = "RIGHT_TO_LEFT:" + r2.getValue().intValue() + "  ";
        goto L31
    L22:
        r4 = "RIGHT_TO_RIGHT:" + r2.getValue().intValue() + "  ";
        goto L31
    L23:
        r4 = "LEFT_TO_RIGHT:" + r2.getValue().intValue() + "  ";
        goto L31
    L24:
        r4 = "LEFT_TO_LEFT:" + r2.getValue().intValue() + "  ";
        goto L31
    L25:
        r4 = "END_TO_START:" + r2.getValue().intValue() + "  ";
        goto L31
    L26:
        r4 = "END_TO_END:" + r2.getValue().intValue() + "  ";
        goto L31
    L27:
        r4 = "START_TO_END:" + r2.getValue().intValue() + "  ";
        goto L31
    L28:
        r4 = "START_TO_START :" + r2.getValue().intValue() + "  ";
        goto L31
    L29:
        r4 = "CONSTRAINT_HEIGHT:" + r2.getValue().intValue() + "  ";
        goto L31
    L33:
        return r1.toString();
    }

    public final void e() {
        j();
        g();
        h();
        i();
        k();
        f();
    }

    public /* synthetic */ b(int r2) {
        this(r2, "");
    }

    public final void a(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(15, r4);
    }

    public final void b(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(10, r4);
    }

    public final void c(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(11, r4);
    }

    public final void l(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(31, r4);
    }

    public final void m(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(30, r4);
    }

    public final void n(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(2, r4);
    }

    public final void o(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(3, r4);
    }

    public final void p(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(4, r4);
    }

    public final void q(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(6, r4);
    }

    public final void r(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 4;
    L5:
        this.d = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }

    public final void s(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        this.d = r2;
        return;
    L4:
        r2 = 8;
        goto L5
    }

    public final void t(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(16, r4);
    }

    public final void u(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(1, r4);
    }

    public final void v(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(0, r4);
    }

    public final void w(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(14, r4);
    }

    public final void x(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(9, r4);
    }

    public final void y(int r3) {
        Integer r4 = Integer.valueOf(r3);
        this.c.put(8, r4);
    }

    public b(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "debugInfo");
        this.a = r2;
        this.b = r3;
        this.c = new HashMap();
    }
}
