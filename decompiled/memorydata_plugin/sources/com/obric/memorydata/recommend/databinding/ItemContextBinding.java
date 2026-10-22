package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemContextBinding implements ViewBinding {
    public final LinearLayout linearLayout;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private ItemContextBinding(ConstraintLayout r1, LinearLayout r2, TextView r3) {
        this.rootView = r1;
        this.linearLayout = r2;
        this.tvTitle = r3;
    }

    public static ItemContextBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.linear_layout, OaidModel.KEY_ID, "linear_layout");
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ItemContextBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemContextBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemContextBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_context, "layout", "item_context"), r4, false, "com.obric.memorydata.plugin");
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
