package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecommendSettingsPrivacyDialogProtectBinding implements ViewBinding {
    public final ImageView recommendSettingsPrivacyDialogImage;
    private final FrameLayout rootView;

    private ItemRecommendSettingsPrivacyDialogProtectBinding(FrameLayout r1, ImageView r2) {
        this.rootView = r1;
        this.recommendSettingsPrivacyDialogImage = r2;
    }

    public static ItemRecommendSettingsPrivacyDialogProtectBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.recommend_settings_privacy_dialog_image, OaidModel.KEY_ID, "recommend_settings_privacy_dialog_image");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new ItemRecommendSettingsPrivacyDialogProtectBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRecommendSettingsPrivacyDialogProtectBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendSettingsPrivacyDialogProtectBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_settings_privacy_dialog_protect, "layout", "item_recommend_settings_privacy_dialog_protect"), r4, false, "com.obric.memorydata.plugin");
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
