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
public final class ItemMemoryDetailHeaderMediaBinding implements ViewBinding {
    public final ImageView imageSource;
    private final ConstraintLayout rootView;
    public final TextView tvSourceContent;
    public final View viewOverlay;

    private ItemMemoryDetailHeaderMediaBinding(ConstraintLayout r1, ImageView r2, TextView r3, View r4) {
        this.rootView = r1;
        this.imageSource = r2;
        this.tvSourceContent = r3;
        this.viewOverlay = r4;
    }

    public static ItemMemoryDetailHeaderMediaBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.image_source, OaidModel.KEY_ID, "image_source");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_source_content, OaidModel.KEY_ID, "tv_source_content");
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.view_overlay, OaidModel.KEY_ID, "view_overlay");
        View r1 = r6.findViewById(r0);
        if (r1 == null) goto L11;
        return new ItemMemoryDetailHeaderMediaBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryDetailHeaderMediaBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailHeaderMediaBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_header_media, "layout", "item_memory_detail_header_media"), r4, false, "com.obric.memorydata.plugin");
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
