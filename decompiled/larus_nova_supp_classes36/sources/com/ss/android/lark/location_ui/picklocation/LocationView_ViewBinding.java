package com.ss.android.lark.location_ui.picklocation;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.location_ui.widget.LoadingView;
import com.ss.android.lark.location_ui.widget.SearchBar;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LocationView_ViewBinding implements Unbinder {
    public LocationView a;

    public final void unbind() {
        LocationView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTitleBar = null;
        r0.mSearchBar = null;
        r0.mContentLayout = null;
        r0.mMapContainerLayout = null;
        r0.mContainerLayout = null;
        r0.mIvLocationIcon = null;
        r0.mTvRequestPermission = null;
        r0.mNearByListView = null;
        r0.mRecommendLayout = null;
        r0.mRecommendListView = null;
        r0.mIvLocatePosition = null;
        r0.mNearbyLoading = null;
        r0.mRecommendLoading = null;
        r0.mRecommendLineView = null;
        r0.mRecommendEmptyView = null;
        r0.mAppBarLayout = null;
        r0.mScrollNear = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public LocationView_ViewBinding(LocationView r4, View r5) {
        this.a = r4;
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131379155, "field 'mTitleBar'", CommonTitleBar.class);
        r4.mSearchBar = (SearchBar) Utils.findRequiredViewAsType(r5, 2131385326, "field 'mSearchBar'", SearchBar.class);
        r4.mContentLayout = (RelativeLayout) Utils.findRequiredViewAsType(r5, 2131372835, "field 'mContentLayout'", RelativeLayout.class);
        r4.mMapContainerLayout = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131379138, "field 'mMapContainerLayout'", FrameLayout.class);
        r4.mContainerLayout = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131379525, "field 'mContainerLayout'", LinearLayout.class);
        r4.mIvLocationIcon = (ImageView) Utils.findRequiredViewAsType(r5, 2131376382, "field 'mIvLocationIcon'", ImageView.class);
        r4.mTvRequestPermission = (TextView) Utils.findRequiredViewAsType(r5, 2131391295, "field 'mTvRequestPermission'", TextView.class);
        r4.mNearByListView = (ListView) Utils.findRequiredViewAsType(r5, 2131379260, "field 'mNearByListView'", ListView.class);
        r4.mRecommendLayout = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131379139, "field 'mRecommendLayout'", FrameLayout.class);
        r4.mRecommendListView = (ListView) Utils.findRequiredViewAsType(r5, 2131379261, "field 'mRecommendListView'", ListView.class);
        r4.mIvLocatePosition = (ImageView) Utils.findRequiredViewAsType(r5, 2131379143, "field 'mIvLocatePosition'", ImageView.class);
        r4.mNearbyLoading = (LoadingView) Utils.findRequiredViewAsType(r5, 2131379150, "field 'mNearbyLoading'", LoadingView.class);
        r4.mRecommendLoading = (LoadingView) Utils.findRequiredViewAsType(r5, 2131379153, "field 'mRecommendLoading'", LoadingView.class);
        r4.mRecommendLineView = Utils.findRequiredView(r5, 2131379144, "field 'mRecommendLineView'");
        r4.mRecommendEmptyView = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131379145, "field 'mRecommendEmptyView'", LinearLayout.class);
        r4.mAppBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(r5, 2131363114, "field 'mAppBarLayout'", AppBarLayout.class);
        r4.mScrollNear = (NestedScrollView) Utils.findRequiredViewAsType(r5, 2131385232, "field 'mScrollNear'", NestedScrollView.class);
    }
}
