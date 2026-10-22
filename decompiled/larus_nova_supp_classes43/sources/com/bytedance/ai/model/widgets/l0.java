package com.bytedance.ai.model.widgets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l0 implements ix7.h {
    public final /* synthetic */ WebEngineAssem a;

    public final void b(int r1, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
    }

    public final void onScrollChanged(int r1, int r10, int r11, int r12) {
    }

    public l0(WebEngineAssem r1) {
        this.a = r1;
    }

    public final void a(int r10, int r11, boolean r12, boolean r13) {
        WebEngineAssem r14 = this.a;
        if (r14.q == false) goto L16;
        boolean r15 = r14.u;
        boolean r0 = true;
        if (r15 == true) goto L8;
        if (r13 == false) goto L8;
        boolean r16 = true;
    L9:
        r14.r = r16;
        if (r15 == false) goto L13;
        if (r13 == false) goto L13;
    L14:
        r14.s = r0;
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "scrollY: " + r11 + ", clampedY: " + r13 + ", isReachTop: " + this.a.r + ", isReachBottom: " + this.a.s);
        return;
    L13:
        r0 = false;
    L8:
        r16 = false;
        goto L9
    }
}
