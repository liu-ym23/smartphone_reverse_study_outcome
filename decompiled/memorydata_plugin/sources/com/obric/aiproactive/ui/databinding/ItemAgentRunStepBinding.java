package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.progress.ODownloadProgressView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemAgentRunStepBinding implements ViewBinding {
    public final LinearLayout artifactReferenceContainer;
    public final ImageView ivStepMarker;
    public final LinearLayout mobileChildContainer;
    public final ODownloadProgressView progressStepMarker;
    private final ConstraintLayout rootView;
    public final View stepConnectorBottom;
    public final View stepConnectorTop;
    public final LinearLayout stepContent;
    public final OListItemGeneral stepHeader;
    public final FrameLayout stepMarkerContainer;

    private ItemAgentRunStepBinding(ConstraintLayout r1, LinearLayout r2, ImageView r3, LinearLayout r4, ODownloadProgressView r5, View r6, View r7, LinearLayout r8, OListItemGeneral r9, FrameLayout r10) {
        this.rootView = r1;
        this.artifactReferenceContainer = r2;
        this.ivStepMarker = r3;
        this.mobileChildContainer = r4;
        this.progressStepMarker = r5;
        this.stepConnectorBottom = r6;
        this.stepConnectorTop = r7;
        this.stepContent = r8;
        this.stepHeader = r9;
        this.stepMarkerContainer = r10;
    }

    public static ItemAgentRunStepBinding bind(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.artifact_reference_container, OaidModel.KEY_ID, "artifact_reference_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_step_marker, OaidModel.KEY_ID, "iv_step_marker");
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.mobile_child_container, OaidModel.KEY_ID, "mobile_child_container");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.progress_step_marker, OaidModel.KEY_ID, "progress_step_marker");
        ODownloadProgressView r11 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.step_connector_bottom, OaidModel.KEY_ID, "step_connector_bottom");
        View r12 = r17.findViewById(r1);
        if (r12 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.step_connector_top, OaidModel.KEY_ID, "step_connector_top");
        View r13 = r17.findViewById(r1);
        if (r13 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.step_content, OaidModel.KEY_ID, "step_content");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.step_header, OaidModel.KEY_ID, "step_header");
        OListItemGeneral r15 = (OListItemGeneral) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OListItemGeneral.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.step_marker_container, OaidModel.KEY_ID, "step_marker_container");
        FrameLayout r16 = (FrameLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L23;
        return new ItemAgentRunStepBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r17, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ItemAgentRunStepBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAgentRunStepBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_agent_run_step, "layout", "item_agent_run_step"), r4, false, "com.obric.memorydata.plugin");
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
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
