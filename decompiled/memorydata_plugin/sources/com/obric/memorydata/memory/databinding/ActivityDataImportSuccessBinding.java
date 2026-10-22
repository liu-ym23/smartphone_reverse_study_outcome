package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDataImportSuccessBinding implements ViewBinding {
    public final OButton btnAction;
    public final ImageView ivStatusIcon;
    public final LinearLayout llCenterContainer;
    private final FrameLayout rootView;
    public final OTextView tvSubtitle;
    public final OTextView tvTitle;

    private ActivityDataImportSuccessBinding(FrameLayout r1, OButton r2, ImageView r3, LinearLayout r4, OTextView r5, OTextView r6) {
        this.rootView = r1;
        this.btnAction = r2;
        this.ivStatusIcon = r3;
        this.llCenterContainer = r4;
        this.tvSubtitle = r5;
        this.tvTitle = r6;
    }

    public static ActivityDataImportSuccessBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_action, OaidModel.KEY_ID, "btn_action");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.iv_status_icon, OaidModel.KEY_ID, "iv_status_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_center_container, OaidModel.KEY_ID, "ll_center_container");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_subtitle, OaidModel.KEY_ID, "tv_subtitle");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new ActivityDataImportSuccessBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityDataImportSuccessBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityDataImportSuccessBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_data_import_success, "layout", "activity_data_import_success"), r4, false, "com.obric.memorydata.plugin");
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
