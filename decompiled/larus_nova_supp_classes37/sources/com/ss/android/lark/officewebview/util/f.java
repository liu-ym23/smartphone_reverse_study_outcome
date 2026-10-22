package com.ss.android.lark.officewebview.util;

import android.webkit.RenderProcessGoneDetail;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f extends RenderProcessGoneDetail {
    public final boolean a;
    public final int b;

    @Override // android.webkit.RenderProcessGoneDetail
    public final boolean didCrash() {
        return this.a;
    }

    @Override // android.webkit.RenderProcessGoneDetail
    public final int rendererPriorityAtExit() {
        return this.b;
    }

    public f(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
