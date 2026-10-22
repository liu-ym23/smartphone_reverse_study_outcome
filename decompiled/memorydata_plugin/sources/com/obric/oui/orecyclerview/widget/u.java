package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f14236a;

    interface a {
        com.obric.oui.orecyclerview.widget.a.b a(int r1, int r2, int r3, Object r4);

        void a(com.obric.oui.orecyclerview.widget.a.b r1);
    }

    u(a r3) {
        this.f14236a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    private void a(List<com.obric.oui.orecyclerview.widget.a.b> r9, int r10, int r11) {
        List<com.obric.oui.orecyclerview.widget.a.b> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        com.obric.oui.orecyclerview.widget.a.b r5 = (com.obric.oui.orecyclerview.widget.a.b) ZeusTransformUtils.preCheckCast(r3.get(r10), com.obric.oui.orecyclerview.widget.a.b.class, "com.obric.memorydata.plugin");
        com.obric.oui.orecyclerview.widget.a.b r7 = (com.obric.oui.orecyclerview.widget.a.b) ZeusTransformUtils.preCheckCast(r3.get(r11), com.obric.oui.orecyclerview.widget.a.b.class, "com.obric.memorydata.plugin");
        int r12 = r7.f14112a;
        if (r12 != 1) goto L5;
        c(r3, r10, r5, r11, r7);
        return;
    L5:
        if (r12 != 2) goto L7;
        a(r3, r10, r5, r11, r7);
        return;
    L7:
        if (r12 != 4) goto L15;
        b(r3, r10, r5, r11, r7);
        return;
    }

    private int b(List<com.obric.oui.orecyclerview.widget.a.b> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r7 = r5.size() - 1;
        boolean r2 = false;
    L3:
        if (r7 < 0) goto L10;
        if (((com.obric.oui.orecyclerview.widget.a.b) ZeusTransformUtils.preCheckCast(r5.get(r7), com.obric.oui.orecyclerview.widget.a.b.class, "com.obric.memorydata.plugin")).f14112a != 8) goto L8;
        if (r2 == false) goto L9;
        return r7;
    L9:
        r7 = r7 - 1;
        goto L3
    L8:
        r2 = true;
        goto L9
    L10:
        return -1;
    }

    private void c(List<com.obric.oui.orecyclerview.widget.a.b> r3, int r4, com.obric.oui.orecyclerview.widget.a.b r5, int r6, com.obric.oui.orecyclerview.widget.a.b r7) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5.d >= r7.f14113b) goto L5;
        int r8 = -1;
    L7:
        if (r5.f14113b >= r7.f14113b) goto L10;
        r8 = r8 + 1;
    L10:
        if (r7.f14113b > r5.f14113b) goto L13;
        r5.f14113b += r7.d;
    L13:
        if (r7.f14113b > r5.d) goto L15;
        r5.d += r7.d;
    L15:
        r7.f14113b += r8;
        r2.set(r4, r7);
        r2.set(r6, r5);
        return;
    L5:
        r8 = 0;
        goto L7
    }

    void a(List<com.obric.oui.orecyclerview.widget.a.b> r3) {
        List<com.obric.oui.orecyclerview.widget.a.b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    L3:
        int r0 = b(r4);
        if (r0 == (-1)) goto L6;
        a(r4, r0, r0 + 1);
        goto L3
    }

    void a(List<com.obric.oui.orecyclerview.widget.a.b> r9, int r10, com.obric.oui.orecyclerview.widget.a.b r11, int r12, com.obric.oui.orecyclerview.widget.a.b r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r11.f14113b >= r11.d) goto L11;
        if (r13.f14113b == r11.f14113b) goto L7;
    L9:
        boolean r0 = false;
    L17:
        if (r11.d >= r13.f14113b) goto L20;
        r13.f14113b--;
    L25:
        com.obric.oui.orecyclerview.widget.a.b r6 = null;
        if (r11.f14113b > r13.f14113b) goto L29;
        r13.f14113b++;
    L31:
        if (r2 == false) goto L34;
        r14.set(r10, r13);
        r14.remove(r12);
        this.f14236a.a(r11);
        return;
    L34:
        if (r0 == false) goto L48;
        if (r6 == null) goto L43;
        if (r11.f14113b <= r6.f14113b) goto L40;
        r11.f14113b -= r6.d;
    L40:
        if (r11.d <= r6.f14113b) goto L43;
        r11.d -= r6.d;
    L43:
        if (r11.f14113b <= r13.f14113b) goto L46;
        r11.f14113b -= r13.d;
    L46:
        if (r11.d > r13.f14113b) goto L60;
    L61:
        r14.set(r10, r13);
        if (r11.f14113b == r11.d) goto L64;
        r14.set(r12, r11);
    L65:
        if (r6 == null) goto L69;
        r14.add(r10, r6);
        return;
    L69:
        return;
    L64:
        r14.remove(r12);
    L60:
        r11.d -= r13.d;
        goto L61
    L48:
        if (r6 == null) goto L56;
        if (r11.f14113b < r6.f14113b) goto L53;
        r11.f14113b -= r6.d;
    L53:
        if (r11.d < r6.f14113b) goto L56;
        r11.d -= r6.d;
    L56:
        if (r11.f14113b < r13.f14113b) goto L59;
        r11.f14113b -= r13.d;
    L59:
        if (r11.d < r13.f14113b) goto L61;
    L29:
        if (r11.f14113b >= (r13.f14113b + r13.d)) goto L31;
        r6 = this.f14236a.a(2, r11.f14113b + 1, (r13.f14113b + r13.d) - r11.f14113b, null);
        r13.d = r11.f14113b - r13.f14113b;
        goto L31
    L20:
        if (r11.d >= (r13.f14113b + r13.d)) goto L25;
        r13.d--;
        r11.f14112a = 2;
        r11.d = 1;
        if (r13.d != 0) goto L68;
        r14.remove(r12);
        this.f14236a.a(r13);
        return;
    L68:
        return;
    L7:
        if (r13.d != (r11.d - r11.f14113b)) goto L9;
        r0 = false;
        r2 = true;
        goto L17
    L11:
        if (r13.f14113b == (r11.d + 1)) goto L13;
    L15:
        r0 = true;
        goto L17
    L13:
        if (r13.d != (r11.f14113b - r11.d)) goto L15;
        r0 = true;
        r2 = true;
        goto L17
    }

    void b(List<com.obric.oui.orecyclerview.widget.a.b> r8, int r9, com.obric.oui.orecyclerview.widget.a.b r10, int r11, com.obric.oui.orecyclerview.widget.a.b r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        com.obric.oui.orecyclerview.widget.a.b r3 = null;
        if (r10.d >= r12.f14113b) goto L6;
        r12.f14113b--;
    L8:
        com.obric.oui.orecyclerview.widget.a.b r0 = null;
    L10:
        if (r10.f14113b > r12.f14113b) goto L13;
        r12.f14113b++;
    L15:
        r13.set(r11, r10);
        if (r12.d <= 0) goto L18;
        r13.set(r9, r12);
    L19:
        if (r0 == null) goto L21;
        r13.add(r9, r0);
    L21:
        if (r3 == null) goto L24;
        r13.add(r9, r3);
        return;
    L24:
        return;
    L18:
        r13.remove(r9);
        this.f14236a.a(r12);
        goto L19
    L13:
        if (r10.f14113b >= (r12.f14113b + r12.d)) goto L15;
        int r1 = (r12.f14113b + r12.d) - r10.f14113b;
        r3 = this.f14236a.a(4, r10.f14113b + 1, r1, r12.c);
        r12.d -= r1;
        goto L15
    L6:
        if (r10.d >= (r12.f14113b + r12.d)) goto L8;
        r12.d--;
        r0 = this.f14236a.a(4, r10.f14113b, 1, r12.c);
        goto L10
    }
}
