package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarTipsView;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarView;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtView_ViewBinding implements Unbinder {
    public AtView a;

    public final void unbind() {
        AtView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mSelectAtLayout = null;
        r0.mRecyclerViewLayout = null;
        r0.mRecommendRecyclerView = null;
        r0.mQuickSideBarTipView = null;
        r0.mQuickSideBarView = null;
        r0.mQuickSideBarCover = null;
        r0.mSearchBar = null;
        r0.mSearchEt = null;
        r0.mPtrFrame = null;
        r0.mSearchResultRV = null;
        r0.mSelectedRV = null;
        r0.mLoadEmptyView = null;
        r0.mSearchEmptyHintTV = null;
        r0.mTitleBar = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AtView_ViewBinding(AtView r4, View r5) {
        this.a = r4;
        r4.mSelectAtLayout = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131363314, "field 'mSelectAtLayout'", LinearLayout.class);
        r4.mRecyclerViewLayout = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131384082, "field 'mRecyclerViewLayout'", LinearLayout.class);
        r4.mRecommendRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131367707, "field 'mRecommendRecyclerView'", RecyclerView.class);
        r4.mQuickSideBarTipView = (QuickSideBarTipsView) Utils.findRequiredViewAsType(r5, 2131383542, "field 'mQuickSideBarTipView'", QuickSideBarTipsView.class);
        r4.mQuickSideBarView = (QuickSideBarView) Utils.findRequiredViewAsType(r5, 2131383543, "field 'mQuickSideBarView'", QuickSideBarView.class);
        r4.mQuickSideBarCover = Utils.findRequiredView(r5, 2131383544, "field 'mQuickSideBarCover'");
        r4.mSearchBar = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131385326, "field 'mSearchBar'", LinearLayout.class);
        r4.mSearchEt = (SCEditText) Utils.findRequiredViewAsType(r5, 2131385429, "field 'mSearchEt'", SCEditText.class);
        r4.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r5, 2131375202, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r4.mSearchResultRV = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131385582, "field 'mSearchResultRV'", RecyclerView.class);
        r4.mSelectedRV = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131385782, "field 'mSelectedRV'", RecyclerView.class);
        r4.mLoadEmptyView = Utils.findRequiredView(r5, 2131378942, "field 'mLoadEmptyView'");
        r4.mSearchEmptyHintTV = (TextView) Utils.findRequiredViewAsType(r5, 2131388429, "field 'mSearchEmptyHintTV'", TextView.class);
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388928, "field 'mTitleBar'", CommonTitleBar.class);
    }
}
