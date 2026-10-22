package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenLocationTagLayoutBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tagText;

    private ScreenLocationTagLayoutBinding(FrameLayout r1, TextView r2) {
        this.rootView = r1;
        this.tagText = r2;
    }

    public static ScreenLocationTagLayoutBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.tag_text, OaidModel.KEY_ID, "tag_text");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new ScreenLocationTagLayoutBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ScreenLocationTagLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenLocationTagLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.screen_location_tag_layout, "layout", "screen_location_tag_layout"), r4, false, "com.obric.memorydata.plugin");
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
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
