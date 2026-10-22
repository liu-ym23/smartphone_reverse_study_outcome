package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class AiLabButtonLayoutBinding implements ViewBinding {
    public final OButton approveButton;
    public final LinearLayout approveButtonLayout;
    private final LinearLayout rootView;

    private AiLabButtonLayoutBinding(LinearLayout r1, OButton r2, LinearLayout r3) {
        this.rootView = r1;
        this.approveButton = r2;
        this.approveButtonLayout = r3;
    }

    public static AiLabButtonLayoutBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.approve_button, OaidModel.KEY_ID, "approve_button");
        OButton r1 = (OButton) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin");
        return new AiLabButtonLayoutBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r1, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static AiLabButtonLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AiLabButtonLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.ai_lab_button_layout, "layout", "ai_lab_button_layout"), r4, false, "com.obric.memorydata.plugin");
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
