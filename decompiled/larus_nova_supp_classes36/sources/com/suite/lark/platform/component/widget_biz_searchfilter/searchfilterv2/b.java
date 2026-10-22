package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FilterViewV2 a;

    public b(FilterViewV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.d("LarkWidget.FilterViewV2", "mResetTv onClick.");
        FilterViewV2.d r3 = this.a.e;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
