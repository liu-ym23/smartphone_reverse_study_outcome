package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemSensingFooterBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvNoMore;

    private ItemSensingFooterBinding(ConstraintLayout r1, TextView r2) {
        this.rootView = r1;
        this.tvNoMore = r2;
    }

    public static ItemSensingFooterBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.tv_no_more, OaidModel.KEY_ID, "tv_no_more");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new ItemSensingFooterBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemSensingFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSensingFooterBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_sensing_footer, "layout", "item_sensing_footer"), r4, false, "com.obric.memorydata.plugin");
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
