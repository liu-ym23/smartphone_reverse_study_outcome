package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalHorizontal;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityGuidePrivacyBinding implements ViewBinding {
    public final OBottomActionBarNormalHorizontal barGuideNext;
    public final ONestedScrollView guidePrivacyContainer;
    public final ImageView ivPrivacyIcon;
    public final OCardListItem listItemFirst;
    public final OCardListItem listItemFourth;
    public final OCardListItem listItemSecond;
    public final OCardListItem listItemThird;
    public final OUILinearLayout llPrivacyContent;
    public final OCardListItem privacyPolicy;
    private final FrameLayout rootView;
    public final TextView tvPrivacyTitle;
    public final OFloatingTitleBar viewTitle;

    private ActivityGuidePrivacyBinding(FrameLayout r1, OBottomActionBarNormalHorizontal r2, ONestedScrollView r3, ImageView r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OUILinearLayout r9, OCardListItem r10, TextView r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.barGuideNext = r2;
        this.guidePrivacyContainer = r3;
        this.ivPrivacyIcon = r4;
        this.listItemFirst = r5;
        this.listItemFourth = r6;
        this.listItemSecond = r7;
        this.listItemThird = r8;
        this.llPrivacyContent = r9;
        this.privacyPolicy = r10;
        this.tvPrivacyTitle = r11;
        this.viewTitle = r12;
    }

    public static ActivityGuidePrivacyBinding bind(View r19) {
        int r1 = ZeusTransformUtils.mapRes(R.id.bar_guide_next, OaidModel.KEY_ID, "bar_guide_next");
        OBottomActionBarNormalHorizontal r8 = (OBottomActionBarNormalHorizontal) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OBottomActionBarNormalHorizontal.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.guide_privacy_container, OaidModel.KEY_ID, "guide_privacy_container");
        ONestedScrollView r9 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_privacy_icon, OaidModel.KEY_ID, "iv_privacy_icon");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.list_item_first, OaidModel.KEY_ID, "list_item_first");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.list_item_fourth, OaidModel.KEY_ID, "list_item_fourth");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.list_item_second, OaidModel.KEY_ID, "list_item_second");
        OCardListItem r13 = (OCardListItem) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.list_item_third, OaidModel.KEY_ID, "list_item_third");
        OCardListItem r14 = (OCardListItem) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_privacy_content, OaidModel.KEY_ID, "ll_privacy_content");
        OUILinearLayout r15 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OUILinearLayout.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.privacy_policy, OaidModel.KEY_ID, "privacy_policy");
        OCardListItem r16 = (OCardListItem) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_privacy_title, OaidModel.KEY_ID, "tv_privacy_title");
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L27;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r18 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r19.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L27;
        return new ActivityGuidePrivacyBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r19, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r19, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityGuidePrivacyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityGuidePrivacyBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_guide_privacy, "layout", "activity_guide_privacy"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
