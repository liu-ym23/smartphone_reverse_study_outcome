package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.banner.BannerFriendlyFrameLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityRecommendSettingsBinding implements ViewBinding {
    public final FragmentContainerView appMemoryContainer;
    public final View cutOff;
    private final BannerFriendlyFrameLayout rootView;
    public final LinearLayout screenContentSettingsContainer;
    public final OFloatingTitleBar viewTitle;

    private ActivityRecommendSettingsBinding(BannerFriendlyFrameLayout r1, FragmentContainerView r2, View r3, LinearLayout r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.appMemoryContainer = r2;
        this.cutOff = r3;
        this.screenContentSettingsContainer = r4;
        this.viewTitle = r5;
    }

    public static ActivityRecommendSettingsBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.app_memory_container, OaidModel.KEY_ID, "app_memory_container");
        FragmentContainerView r7 = (FragmentContainerView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), FragmentContainerView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r8 = r11.findViewById(r0);
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.screen_content_settings_container, OaidModel.KEY_ID, "screen_content_settings_container");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r10 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        return new ActivityRecommendSettingsBinding((BannerFriendlyFrameLayout) ZeusTransformUtils.preCheckCast(r11, BannerFriendlyFrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityRecommendSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityRecommendSettingsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_recommend_settings, "layout", "activity_recommend_settings"), r4, false, "com.obric.memorydata.plugin");
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
    public BannerFriendlyFrameLayout getRoot() {
        return this.rootView;
    }
}
