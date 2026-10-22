package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySourceTextBinding implements ViewBinding {
    public final View cutOff;
    private final FrameLayout rootView;
    public final OScrollView sourceTextContainer;
    public final OTextView tvSourceFullText;
    public final OFloatingTitleBar viewTitle;

    private ActivitySourceTextBinding(FrameLayout r1, View r2, OScrollView r3, OTextView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.cutOff = r2;
        this.sourceTextContainer = r3;
        this.tvSourceFullText = r4;
        this.viewTitle = r5;
    }

    public static ActivitySourceTextBinding bind(View r8) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r4 = r8.findViewById(r0);
        if (r4 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.source_text_container, OaidModel.KEY_ID, "source_text_container");
        OScrollView r5 = (OScrollView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OScrollView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_source_full_text, OaidModel.KEY_ID, "tv_source_full_text");
        OTextView r6 = (OTextView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r7 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        return new ActivitySourceTextBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r8, FrameLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivitySourceTextBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySourceTextBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_source_text, "layout", "activity_source_text"), r4, false, "com.obric.memorydata.plugin");
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
