package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.banner.OBannerTouchHost;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.banner.OBanner;
import com.obric.oui.indicator.OCarouselIndicator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecommendSettingsHeaderBinding implements ViewBinding {
    public final FrameLayout recommendBannerCard;
    public final ConstraintLayout recommendBannerContainer;
    public final OCarouselIndicator recommendBannerIndicator;
    public final DeviceAdaptiveCardListItem recommendMemory;
    public final OBanner recommendSettingsBanner;
    public final OBannerTouchHost recommendSettingsBannerTouchHost;
    private final LinearLayout rootView;
    public final DeviceAdaptiveCardListItem screenObservationSwitch;
    public final TextView screenObservationTemporarilyDisabledTips;

    private ItemRecommendSettingsHeaderBinding(LinearLayout r1, FrameLayout r2, ConstraintLayout r3, OCarouselIndicator r4, DeviceAdaptiveCardListItem r5, OBanner r6, OBannerTouchHost r7, DeviceAdaptiveCardListItem r8, TextView r9) {
        this.rootView = r1;
        this.recommendBannerCard = r2;
        this.recommendBannerContainer = r3;
        this.recommendBannerIndicator = r4;
        this.recommendMemory = r5;
        this.recommendSettingsBanner = r6;
        this.recommendSettingsBannerTouchHost = r7;
        this.screenObservationSwitch = r8;
        this.screenObservationTemporarilyDisabledTips = r9;
    }

    public static ItemRecommendSettingsHeaderBinding bind(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.recommend_banner_card, OaidModel.KEY_ID, "recommend_banner_card");
        FrameLayout r7 = (FrameLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.recommend_banner_container, OaidModel.KEY_ID, "recommend_banner_container");
        ConstraintLayout r8 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.recommend_banner_indicator, OaidModel.KEY_ID, "recommend_banner_indicator");
        OCarouselIndicator r9 = (OCarouselIndicator) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OCarouselIndicator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.recommend_memory, OaidModel.KEY_ID, "recommend_memory");
        DeviceAdaptiveCardListItem r10 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.recommend_settings_banner, OaidModel.KEY_ID, "recommend_settings_banner");
        OBanner r11 = (OBanner) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OBanner.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.recommend_settings_banner_touch_host, OaidModel.KEY_ID, "recommend_settings_banner_touch_host");
        OBannerTouchHost r12 = (OBannerTouchHost) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OBannerTouchHost.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.screen_observation_switch, OaidModel.KEY_ID, "screen_observation_switch");
        DeviceAdaptiveCardListItem r13 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.screen_observation_temporarily_disabled_tips, OaidModel.KEY_ID, "screen_observation_temporarily_disabled_tips");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        return new ItemRecommendSettingsHeaderBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r15, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRecommendSettingsHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendSettingsHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_settings_header, "layout", "item_recommend_settings_header"), r4, false, "com.obric.memorydata.plugin");
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
