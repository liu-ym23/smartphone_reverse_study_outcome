package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FilterView a;

    public a(FilterView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.d("LarkWidget.FilterView", "mResetTv onClick.");
        FilterView r3 = this.a;
        int r0 = FilterView.f;
        r3.getClass();
    }
}
