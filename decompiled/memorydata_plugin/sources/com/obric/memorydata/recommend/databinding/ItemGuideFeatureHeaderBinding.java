package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemGuideFeatureHeaderBinding implements ViewBinding {
    public final ImageView ivGuideScreenMemory;
    private final LinearLayout rootView;
    public final TextView viewGuideDesc;
    public final OUIFrameLayout viewGuideIcon;
    public final TextView viewGuideTitle;

    private ItemGuideFeatureHeaderBinding(LinearLayout r1, ImageView r2, TextView r3, OUIFrameLayout r4, TextView r5) {
        this.rootView = r1;
        this.ivGuideScreenMemory = r2;
        this.viewGuideDesc = r3;
        this.viewGuideIcon = r4;
        this.viewGuideTitle = r5;
    }

    public static ItemGuideFeatureHeaderBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.iv_guide_screen_memory, OaidModel.KEY_ID, "iv_guide_screen_memory");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_guide_desc, OaidModel.KEY_ID, "view_guide_desc");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_guide_icon, OaidModel.KEY_ID, "view_guide_icon");
        OUIFrameLayout r9 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_guide_title, OaidModel.KEY_ID, "view_guide_title");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        return new ItemGuideFeatureHeaderBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemGuideFeatureHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemGuideFeatureHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_guide_feature_header, "layout", "item_guide_feature_header"), r4, false, "com.obric.memorydata.plugin");
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
