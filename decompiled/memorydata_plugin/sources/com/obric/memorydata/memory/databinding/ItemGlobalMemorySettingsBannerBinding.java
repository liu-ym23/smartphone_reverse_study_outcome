package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemGlobalMemorySettingsBannerBinding implements ViewBinding {
    public final ImageView globalMemoryBannerImage;
    public final TextView globalMemoryBannerTip;
    public final TextView globalMemoryBannerTitle;
    private final ConstraintLayout rootView;

    private ItemGlobalMemorySettingsBannerBinding(ConstraintLayout r1, ImageView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.globalMemoryBannerImage = r2;
        this.globalMemoryBannerTip = r3;
        this.globalMemoryBannerTitle = r4;
    }

    public static ItemGlobalMemorySettingsBannerBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.global_memory_banner_image, OaidModel.KEY_ID, "global_memory_banner_image");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.global_memory_banner_tip, OaidModel.KEY_ID, "global_memory_banner_tip");
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.global_memory_banner_title, OaidModel.KEY_ID, "global_memory_banner_title");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ItemGlobalMemorySettingsBannerBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemGlobalMemorySettingsBannerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemGlobalMemorySettingsBannerBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_global_memory_settings_banner, "layout", "item_global_memory_settings_banner"), r4, false, "com.obric.memorydata.plugin");
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
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
