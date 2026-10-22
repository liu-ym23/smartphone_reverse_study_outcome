package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecommendAppSettingBinding implements ViewBinding {
    public final ConstraintLayout clContentContainer;
    public final OSwitch enableSwitch;
    public final AppCompatImageView ivContentImg;
    public final LinearLayout llRoot;
    private final LinearLayout rootView;
    public final OTextView tvContentTitle;

    private ItemRecommendAppSettingBinding(LinearLayout r1, ConstraintLayout r2, OSwitch r3, AppCompatImageView r4, LinearLayout r5, OTextView r6) {
        this.rootView = r1;
        this.clContentContainer = r2;
        this.enableSwitch = r3;
        this.ivContentImg = r4;
        this.llRoot = r5;
        this.tvContentTitle = r6;
    }

    public static ItemRecommendAppSettingBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cl_content_container, OaidModel.KEY_ID, "cl_content_container");
        ConstraintLayout r7 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.enable_switch, OaidModel.KEY_ID, "enable_switch");
        OSwitch r8 = (OSwitch) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OSwitch.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.iv_content_img, OaidModel.KEY_ID, "iv_content_img");
        AppCompatImageView r9 = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), AppCompatImageView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.tv_content_title, OaidModel.KEY_ID, "tv_content_title");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L13;
        return new ItemRecommendAppSettingBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRecommendAppSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendAppSettingBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_app_setting, "layout", "item_recommend_app_setting"), r4, false, "com.obric.memorydata.plugin");
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
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
