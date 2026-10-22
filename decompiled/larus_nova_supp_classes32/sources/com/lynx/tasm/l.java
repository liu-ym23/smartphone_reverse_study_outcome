package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements g {
    public final LynxTemplateRender a;

    public l() {
    }

    public final long a() {
        LynxTemplateRender r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getListEngineProxy();
    }

    public l(LynxTemplateRender r1) {
        this.a = r1;
    }

    public final JavaOnlyMap b(int r2) {
        LynxTemplateRender r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getListPlatformInfo(r2);
    }

    public final void e(int r2, int r3) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.recycleChild(r2, r3);
        return;
    }

    public final void f(int r2, int r3) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.recycleChildAsync(r2, r3);
        return;
    }

    public final void g(int r2, int r3) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeChild(r2, r3);
        return;
    }

    public final void d(int r2, int r3, long r4) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.obtainChildAsync(r2, r3, r4);
        return;
    }

    public final void h(int r2, int r3, long r4) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.renderChild(r2, r3, r4);
        return;
    }

    public final int c(int r7, int r8, long r9, boolean r11) {
        LynxTemplateRender r0 = this.a;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.obtainChild(r7, r8, r9, r11);
    }

    public final void i(int r7, int r8, int r9, long r10) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateChild(r7, r8, r9, r10);
        return;
    }
}
