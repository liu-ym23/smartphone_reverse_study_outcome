package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends q1 {
    public final /* synthetic */ AnnieXLynxView a;

    public final void onRuntimeReady() {
        super.onRuntimeReady();
        Object r0 = this.a.getTag(2131362966);
        if ((r0 instanceof b7.a) == true) goto L5;
        r0 = null;
    L5:
        b7.a r1 = (b7.a) r0;
        if (r1 == null) goto L9;
        r1.onLoadSuccess(this.a);
        return;
    }

    public k(AnnieXLynxView r1) {
        this.a = r1;
    }
}
