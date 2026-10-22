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
public final class ItemMemoryDetailSourceBinding implements ViewBinding {
    public final ConstraintLayout clSourceMessage;
    public final ImageView ivAppIcon;
    private final ConstraintLayout rootView;
    public final TextView tvAppName;
    public final TextView tvUpdateTime;
    public final TextView tvViewSource;

    private ItemMemoryDetailSourceBinding(ConstraintLayout r1, ConstraintLayout r2, ImageView r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.clSourceMessage = r2;
        this.ivAppIcon = r3;
        this.tvAppName = r4;
        this.tvUpdateTime = r5;
        this.tvViewSource = r6;
    }

    public static ItemMemoryDetailSourceBinding bind(View r9) {
        ConstraintLayout r4 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r9, ConstraintLayout.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.iv_app_icon, OaidModel.KEY_ID, "iv_app_icon");
        ImageView r5 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_app_name, OaidModel.KEY_ID, "tv_app_name");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_update_time, OaidModel.KEY_ID, "tv_update_time");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_view_source, OaidModel.KEY_ID, "tv_view_source");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        return new ItemMemoryDetailSourceBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r9, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryDetailSourceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailSourceBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_source, "layout", "item_memory_detail_source"), r4, false, "com.obric.memorydata.plugin");
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
