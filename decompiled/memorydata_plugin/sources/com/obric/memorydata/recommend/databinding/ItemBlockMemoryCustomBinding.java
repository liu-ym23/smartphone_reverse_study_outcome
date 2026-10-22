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
public final class ItemBlockMemoryCustomBinding implements ViewBinding {
    public final LinearLayout contentRoot;
    private final ConstraintLayout rootView;
    public final TextView tvContent;

    private ItemBlockMemoryCustomBinding(ConstraintLayout r1, LinearLayout r2, TextView r3) {
        this.rootView = r1;
        this.contentRoot = r2;
        this.tvContent = r3;
    }

    public static ItemBlockMemoryCustomBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content_root, OaidModel.KEY_ID, "content_root");
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_content, OaidModel.KEY_ID, "tv_content");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ItemBlockMemoryCustomBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemBlockMemoryCustomBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemBlockMemoryCustomBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_block_memory_custom, "layout", "item_block_memory_custom"), r4, false, "com.obric.memorydata.plugin");
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
