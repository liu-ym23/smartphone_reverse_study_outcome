package com.obric.memorydata.memory.databinding;

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

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryBottomTabLayoutBinding implements ViewBinding {
    public final ImageView memoryBottomTabIcon;
    public final TextView memoryBottomTabTv;
    private final LinearLayout rootView;

    private MemoryBottomTabLayoutBinding(LinearLayout r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.memoryBottomTabIcon = r2;
        this.memoryBottomTabTv = r3;
    }

    public static MemoryBottomTabLayoutBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.memory_bottom_tab_icon, OaidModel.KEY_ID, "memory_bottom_tab_icon");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_bottom_tab_tv, OaidModel.KEY_ID, "memory_bottom_tab_tv");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new MemoryBottomTabLayoutBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryBottomTabLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryBottomTabLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_bottom_tab_layout, "layout", "memory_bottom_tab_layout"), r4, false, "com.obric.memorydata.plugin");
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
