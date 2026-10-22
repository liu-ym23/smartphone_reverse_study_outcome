package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemorySettingsUsageAppTailviewBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final OButton trailUsageAppInstallButton;
    public final OSwitch trailUsageAppInstallSwitch;

    private ItemMemorySettingsUsageAppTailviewBinding(FrameLayout r1, OButton r2, OSwitch r3) {
        this.rootView = r1;
        this.trailUsageAppInstallButton = r2;
        this.trailUsageAppInstallSwitch = r3;
    }

    public static ItemMemorySettingsUsageAppTailviewBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.trail_usage_app_install_button, OaidModel.KEY_ID, "trail_usage_app_install_button");
        OButton r2 = (OButton) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.trail_usage_app_install_switch, OaidModel.KEY_ID, "trail_usage_app_install_switch");
        OSwitch r1 = (OSwitch) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OSwitch.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ItemMemorySettingsUsageAppTailviewBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemorySettingsUsageAppTailviewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemorySettingsUsageAppTailviewBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_settings_usage_app_tailview, "layout", "item_memory_settings_usage_app_tailview"), r4, false, "com.obric.memorydata.plugin");
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
