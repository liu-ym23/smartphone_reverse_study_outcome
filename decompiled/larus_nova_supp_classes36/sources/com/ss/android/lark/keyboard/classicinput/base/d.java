package com.ss.android.lark.keyboard.classicinput.base;

import android.view.View;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SlidingUpPanelLayout a;

    public d(SlidingUpPanelLayout r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }
}
