package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveSectionHeaderBinding implements ViewBinding {
    public final ImageView ivSectionArrow;
    private final LinearLayout rootView;
    public final TextView tvSectionCount;
    public final TextView tvSectionTitle;

    private ItemProactiveSectionHeaderBinding(LinearLayout r1, ImageView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.ivSectionArrow = r2;
        this.tvSectionCount = r3;
        this.tvSectionTitle = r4;
    }

    public static ItemProactiveSectionHeaderBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.iv_section_arrow, OaidModel.KEY_ID, "iv_section_arrow");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_section_count, OaidModel.KEY_ID, "tv_section_count");
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_section_title, OaidModel.KEY_ID, "tv_section_title");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ItemProactiveSectionHeaderBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemProactiveSectionHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveSectionHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_section_header, "layout", "item_proactive_section_header"), r4, false, "com.obric.memorydata.plugin");
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
