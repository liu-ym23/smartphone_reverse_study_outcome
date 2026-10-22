package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryDetailFooterBinding implements ViewBinding {
    public final LinearLayout cardWrapper;
    public final TextView memoryDetailFooterText;
    private final LinearLayout rootView;

    private ItemMemoryDetailFooterBinding(LinearLayout r1, LinearLayout r2, TextView r3) {
        this.rootView = r1;
        this.cardWrapper = r2;
        this.memoryDetailFooterText = r3;
    }

    public static ItemMemoryDetailFooterBinding bind(View r5) {
        LinearLayout r0 = (LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin");
        int r2 = ZeusTransformUtils.mapRes(R.id.memory_detail_footer_text, OaidModel.KEY_ID, "memory_detail_footer_text");
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r2), TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return new ItemMemoryDetailFooterBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r0, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r2)));
    }

    public static ItemMemoryDetailFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailFooterBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_footer, "layout", "item_memory_detail_footer"), r4, false, "com.obric.memorydata.plugin");
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
