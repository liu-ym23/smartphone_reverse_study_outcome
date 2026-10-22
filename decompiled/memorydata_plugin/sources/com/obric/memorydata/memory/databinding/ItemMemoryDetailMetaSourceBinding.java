package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryDetailMetaSourceBinding implements ViewBinding {
    public final ConstraintLayout bottomSourceContainer;
    public final ImageView memorySourceIcon;
    public final TextView memorySourceTv;
    public final TextView memoryTimeTv;
    private final LinearLayout rootView;
    public final TextView titleText;
    public final TextView tvViewSource;

    private ItemMemoryDetailMetaSourceBinding(LinearLayout r1, ConstraintLayout r2, ImageView r3, TextView r4, TextView r5, TextView r6, TextView r7) {
        this.rootView = r1;
        this.bottomSourceContainer = r2;
        this.memorySourceIcon = r3;
        this.memorySourceTv = r4;
        this.memoryTimeTv = r5;
        this.titleText = r6;
        this.tvViewSource = r7;
    }

    public static ItemMemoryDetailMetaSourceBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bottom_source_container, OaidModel.KEY_ID, "bottom_source_container");
        ConstraintLayout r7 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_source_icon, OaidModel.KEY_ID, "memory_source_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_source_tv, OaidModel.KEY_ID, "memory_source_tv");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_time_tv, OaidModel.KEY_ID, "memory_time_tv");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.title_text, OaidModel.KEY_ID, "title_text");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_view_source, OaidModel.KEY_ID, "tv_view_source");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        return new ItemMemoryDetailMetaSourceBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r13, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryDetailMetaSourceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailMetaSourceBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_meta_source, "layout", "item_memory_detail_meta_source"), r4, false, "com.obric.memorydata.plugin");
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
