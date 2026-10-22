package com.ss.android.lark.locationmessage.ui.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NavigateView_ViewBinding implements Unbinder {
    public NavigateView a;

    public final void unbind() {
        NavigateView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mIvBack = null;
        r0.mIvMore = null;
        r0.mContainerLayout = null;
        r0.mTvRequestPermission = null;
        r0.mIvLocatePosition = null;
        r0.mTvNavigateTitle = null;
        r0.mTvNavigateDesc = null;
        r0.mIvGoToNavigate = null;
        r0.mViewTitleBar = null;
        r0.mBottomLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public NavigateView_ViewBinding(NavigateView r4, View r5) {
        this.a = r4;
        r4.mIvBack = (ImageView) Utils.findRequiredViewAsType(r5, 2131380000, "field 'mIvBack'", ImageView.class);
        r4.mIvMore = (ImageView) Utils.findRequiredViewAsType(r5, 2131380001, "field 'mIvMore'", ImageView.class);
        r4.mContainerLayout = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131379146, "field 'mContainerLayout'", LinearLayout.class);
        r4.mTvRequestPermission = (TextView) Utils.findRequiredViewAsType(r5, 2131391295, "field 'mTvRequestPermission'", TextView.class);
        r4.mIvLocatePosition = (ImageView) Utils.findRequiredViewAsType(r5, 2131379143, "field 'mIvLocatePosition'", ImageView.class);
        r4.mTvNavigateTitle = (TextView) Utils.findRequiredViewAsType(r5, 2131379159, "field 'mTvNavigateTitle'", TextView.class);
        r4.mTvNavigateDesc = (TextView) Utils.findRequiredViewAsType(r5, 2131379158, "field 'mTvNavigateDesc'", TextView.class);
        r4.mIvGoToNavigate = (ImageView) Utils.findRequiredViewAsType(r5, 2131379142, "field 'mIvGoToNavigate'", ImageView.class);
        r4.mViewTitleBar = Utils.findRequiredView(r5, 2131380002, "field 'mViewTitleBar'");
        r4.mBottomLayout = Utils.findRequiredView(r5, 2131379148, "field 'mBottomLayout'");
    }
}
