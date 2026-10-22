package com.ss.android.lark.location_ui.picklocation;

import android.view.View;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements View.OnFocusChangeListener {
    public final /* synthetic */ LocationView a;

    public s(LocationView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r3, boolean r4) {
        if (r4 == false) goto L5;
        this.a.mRecommendLayout.setVisibility(0);
        this.a.mRecommendListView.setVisibility(0);
        this.a.mRecommendLineView.setVisibility(0);
        this.a.mContentLayout.setVisibility(8);
        LocationView r5 = this.a;
        r5.f = true;
        r5.mTitleBar.setRightVisible(false);
        this.a.mTitleBar.setLeftImageResource(CommonTitleBarConstants.ICON_BACK);
        this.a.mTitleBar.setLeftText("");
        LocationView r6 = this.a;
        List<POIInfo> r7 = r6.k.v5(true ^ r6.g.isSelfDefine());
        this.a.m.b(r7);
        Statistics.sendEvent("message_location_search_bar_click");
        return;
    L5:
        this.a.mRecommendLayout.setVisibility(8);
        this.a.mRecommendListView.setVisibility(8);
        this.a.mContentLayout.setVisibility(0);
        this.a.mRecommendLineView.setVisibility(8);
        LocationView r8 = this.a;
        r8.f = true;
        r8.mTitleBar.setRightVisible(true);
        this.a.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
    }
}
