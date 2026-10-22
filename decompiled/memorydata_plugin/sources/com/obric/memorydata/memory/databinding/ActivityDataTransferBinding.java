package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDataTransferBinding implements ViewBinding {
    public final OButton btnAction;
    public final ImageView ivQrCode;
    public final ImageView ivStatusIcon;
    public final LinearLayout layoutConnecting;
    public final ConstraintLayout layoutGenericStatus;
    public final ONestedScrollView layoutWaitingForScan;
    public final LinearLayout llCenterContainer;
    public final LinearLayout llEncryptingStatus;
    public final LinearLayout llProgressContainer;
    public final OPageStatus pageStatusConnecting;
    public final OPageStatus pageStatusRestoring;
    public final OProgressView progressBar;
    private final FrameLayout rootView;
    public final ODownloadProgressView smallLoadingView;
    public final TextView tvDeviceName;
    public final TextView tvDeviceNameLabel;
    public final OTextView tvProgressPercent;
    public final OTextView tvSubtitle;
    public final OTextView tvTitle;
    public final OTextView tvTransferredSize;
    public final OFloatingTitleBar viewTitle;

    private ActivityDataTransferBinding(FrameLayout r3, OButton r4, ImageView r5, ImageView r6, LinearLayout r7, ConstraintLayout r8, ONestedScrollView r9, LinearLayout r10, LinearLayout r11, LinearLayout r12, OPageStatus r13, OPageStatus r14, OProgressView r15, ODownloadProgressView r16, TextView r17, TextView r18, OTextView r19, OTextView r20, OTextView r21, OTextView r22, OFloatingTitleBar r23) {
        this.rootView = r3;
        this.btnAction = r4;
        this.ivQrCode = r5;
        this.ivStatusIcon = r6;
        this.layoutConnecting = r7;
        this.layoutGenericStatus = r8;
        this.layoutWaitingForScan = r9;
        this.llCenterContainer = r10;
        this.llEncryptingStatus = r11;
        this.llProgressContainer = r12;
        this.pageStatusConnecting = r13;
        this.pageStatusRestoring = r14;
        this.progressBar = r15;
        this.smallLoadingView = r16;
        this.tvDeviceName = r17;
        this.tvDeviceNameLabel = r18;
        this.tvProgressPercent = r19;
        this.tvSubtitle = r20;
        this.tvTitle = r21;
        this.tvTransferredSize = r22;
        this.viewTitle = r23;
    }

    public static ActivityDataTransferBinding bind(View r28) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_action, OaidModel.KEY_ID, "btn_action");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_qr_code, OaidModel.KEY_ID, "iv_qr_code");
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_status_icon, OaidModel.KEY_ID, "iv_status_icon");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_connecting, OaidModel.KEY_ID, "layout_connecting");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_generic_status, OaidModel.KEY_ID, "layout_generic_status");
        ConstraintLayout r12 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_waiting_for_scan, OaidModel.KEY_ID, "layout_waiting_for_scan");
        ONestedScrollView r13 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_center_container, OaidModel.KEY_ID, "ll_center_container");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_encrypting_status, OaidModel.KEY_ID, "ll_encrypting_status");
        LinearLayout r15 = (LinearLayout) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_progress_container, OaidModel.KEY_ID, "ll_progress_container");
        LinearLayout r16 = (LinearLayout) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.page_status_connecting, OaidModel.KEY_ID, "page_status_connecting");
        OPageStatus r17 = (OPageStatus) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OPageStatus.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.page_status_restoring, OaidModel.KEY_ID, "page_status_restoring");
        OPageStatus r18 = (OPageStatus) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OPageStatus.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.progress_bar, OaidModel.KEY_ID, "progress_bar");
        OProgressView r19 = (OProgressView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OProgressView.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.small_loading_view, OaidModel.KEY_ID, "small_loading_view");
        ODownloadProgressView r20 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_device_name, OaidModel.KEY_ID, "tv_device_name");
        TextView r21 = (TextView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_device_name_label, OaidModel.KEY_ID, "tv_device_name_label");
        TextView r22 = (TextView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_progress_percent, OaidModel.KEY_ID, "tv_progress_percent");
        OTextView r23 = (OTextView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_subtitle, OaidModel.KEY_ID, "tv_subtitle");
        OTextView r24 = (OTextView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        OTextView r25 = (OTextView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_transferred_size, OaidModel.KEY_ID, "tv_transferred_size");
        OTextView r26 = (OTextView) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OTextView.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L45;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r27 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r28.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L45;
        return new ActivityDataTransferBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r28, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r28, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityDataTransferBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityDataTransferBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_data_transfer, "layout", "activity_data_transfer"), r4, false, "com.obric.memorydata.plugin");
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
