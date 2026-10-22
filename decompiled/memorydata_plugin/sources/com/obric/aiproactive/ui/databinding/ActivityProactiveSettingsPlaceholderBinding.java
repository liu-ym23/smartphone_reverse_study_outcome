package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityProactiveSettingsPlaceholderBinding implements ViewBinding {
    public final FrameLayout contentHost;
    public final View cutOff;
    private final FrameLayout rootView;
    public final OFloatingTitleBar titleBar;

    private ActivityProactiveSettingsPlaceholderBinding(FrameLayout r1, FrameLayout r2, View r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.contentHost = r2;
        this.cutOff = r3;
        this.titleBar = r4;
    }

    public static ActivityProactiveSettingsPlaceholderBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content_host, OaidModel.KEY_ID, "content_host");
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r3 = r6.findViewById(r0);
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ActivityProactiveSettingsPlaceholderBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r6, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityProactiveSettingsPlaceholderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProactiveSettingsPlaceholderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_proactive_settings_placeholder, "layout", "activity_proactive_settings_placeholder"), r4, false, "com.obric.memorydata.plugin");
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
