package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentProactiveInitiativeLevelBinding implements ViewBinding {
    public final OCardListItem aggressive;
    public final OCardListItem balanced;
    public final ONestedScrollView contentScroll;
    public final OCardListItem restrained;
    private final FrameLayout rootView;
    public final OFloatingTitleBar titleBar;

    private FragmentProactiveInitiativeLevelBinding(FrameLayout r1, OCardListItem r2, OCardListItem r3, ONestedScrollView r4, OCardListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.aggressive = r2;
        this.balanced = r3;
        this.contentScroll = r4;
        this.restrained = r5;
        this.titleBar = r6;
    }

    public static FragmentProactiveInitiativeLevelBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.aggressive, OaidModel.KEY_ID, "aggressive");
        OCardListItem r7 = (OCardListItem) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.balanced, OaidModel.KEY_ID, "balanced");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.content_scroll, OaidModel.KEY_ID, "content_scroll");
        ONestedScrollView r9 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.restrained, OaidModel.KEY_ID, "restrained");
        OCardListItem r10 = (OCardListItem) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new FragmentProactiveInitiativeLevelBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentProactiveInitiativeLevelBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentProactiveInitiativeLevelBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_proactive_initiative_level, "layout", "fragment_proactive_initiative_level"), r4, false, "com.obric.memorydata.plugin");
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
