package com.obric.memorydata.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class SettingSwitcherLayoutBinding implements ViewBinding {
    public final AppCompatTextView descText;
    private final FrameLayout rootView;
    public final OSwitch switchButton;

    private SettingSwitcherLayoutBinding(FrameLayout r1, AppCompatTextView r2, OSwitch r3) {
        this.rootView = r1;
        this.descText = r2;
        this.switchButton = r3;
    }

    public static SettingSwitcherLayoutBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.desc_text, OaidModel.KEY_ID, "desc_text");
        AppCompatTextView r2 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), AppCompatTextView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.switch_button, OaidModel.KEY_ID, "switch_button");
        OSwitch r1 = (OSwitch) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OSwitch.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new SettingSwitcherLayoutBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static SettingSwitcherLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingSwitcherLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.setting_switcher_layout, "layout", "setting_switcher_layout"), r4, false, "com.obric.memorydata.plugin");
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
