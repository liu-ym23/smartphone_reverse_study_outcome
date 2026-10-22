package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityAgentRunDetailBinding implements ViewBinding {
    public final OButton btnStop;
    public final RecyclerView recyclerSteps;
    private final FrameLayout rootView;
    public final LinearLayout runControls;
    public final OFloatingTitleBar titleBar;
    public final OTextView tvEmpty;

    private ActivityAgentRunDetailBinding(FrameLayout r1, OButton r2, RecyclerView r3, LinearLayout r4, OFloatingTitleBar r5, OTextView r6) {
        this.rootView = r1;
        this.btnStop = r2;
        this.recyclerSteps = r3;
        this.runControls = r4;
        this.titleBar = r5;
        this.tvEmpty = r6;
    }

    public static ActivityAgentRunDetailBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_stop, OaidModel.KEY_ID, "btn_stop");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.recycler_steps, OaidModel.KEY_ID, "recycler_steps");
        RecyclerView r8 = (RecyclerView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.run_controls, OaidModel.KEY_ID, "run_controls");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r10 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_empty, OaidModel.KEY_ID, "tv_empty");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new ActivityAgentRunDetailBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityAgentRunDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAgentRunDetailBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_agent_run_detail, "layout", "activity_agent_run_detail"), r4, false, "com.obric.memorydata.plugin");
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
