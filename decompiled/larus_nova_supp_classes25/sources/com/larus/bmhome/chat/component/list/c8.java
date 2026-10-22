package com.larus.bmhome.chat.component.list;

import android.view.View;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c8 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ShareCheckBoxComponent a;

    public /* synthetic */ c8(ShareCheckBoxComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ShareCheckBoxComponent r10 = this.a;
        int r11 = ShareCheckBoxComponent.r;
        FLogger.a.d("ShareCheckBoxComponent", "addOnLayoutChangeListener");
        r10.Y2();
    }
}
