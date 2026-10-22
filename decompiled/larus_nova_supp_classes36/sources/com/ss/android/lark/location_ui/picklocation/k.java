package com.ss.android.lark.location_ui.picklocation;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBarConstants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements AdapterView.OnItemClickListener {
    public final /* synthetic */ LocationView a;

    public class a {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void a(POIInfo r6) {
            if (TextUtils.isEmpty(r6.getLocationName()) == true) goto L10;
            LocationView.k(this.a.a, r6, !r6.getIsSelfDefine());
            LocationView r0 = this.a.a;
            r0.T();
            r0.mNearByListView.setVisibility(8);
            r0.mNearbyLoading.b();
            iqb.a r1 = r0.l;
            if (CollectionUtils.isEmpty(r1.b) == true) goto L8;
            r1.b.clear();
            r1.notifyDataSetChanged();
        L8:
            r0.k.w6(r0.b, r0.e, new o(r0, r6), 0);
            return;
        }
    }

    public k(LocationView r1) {
        this.a = r1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        kqb.e.b(LocationHitPoint$ResultType.SEARCH);
        KeyboardUtils.hideKeyboard(this.a.b);
        LocationView r5 = this.a;
        r5.f = false;
        r5.mRecommendListView.setVisibility(8);
        this.a.mContentLayout.setVisibility(0);
        this.a.mTitleBar.setRightVisible(true);
        this.a.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.a.P("");
        POIInfo r6 = this.a.m.a(r3);
        if (r6 != null) goto L5;
        return;
    L5:
        LocationView r7 = this.a;
        r7.k.q(r7.b, r6, new a(this));
        Statistics.sendEvent("message_location__sugg_click");
    }
}
