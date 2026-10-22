package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends q1 {
    public final /* synthetic */ b7.a a;
    public final /* synthetic */ AnnieXLynxView b;

    public final void onRuntimeReady() {
        super.onRuntimeReady();
        this.a.onLoadSuccess(this.b);
    }

    public l(b7.a r1, AnnieXLynxView r2) {
        this.a = r1;
        this.b = r2;
    }
}
