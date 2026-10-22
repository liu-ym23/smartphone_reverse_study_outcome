package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDataMigrationBinding implements ViewBinding {
    public final OCardListItem btnExport;
    public final OCardListItem btnImport;
    public final ImageView ivIllustration;
    public final LinearLayout llInstructionList;
    private final FrameLayout rootView;
    public final ONestedScrollView scrollContainer;
    public final TextView tvInstructionTitle;
    public final TextView tvSubtitle;
    public final TextView tvTitle;
    public final OFloatingTitleBar viewTitle;

    private ActivityDataMigrationBinding(FrameLayout r1, OCardListItem r2, OCardListItem r3, ImageView r4, LinearLayout r5, ONestedScrollView r6, TextView r7, TextView r8, TextView r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.btnExport = r2;
        this.btnImport = r3;
        this.ivIllustration = r4;
        this.llInstructionList = r5;
        this.scrollContainer = r6;
        this.tvInstructionTitle = r7;
        this.tvSubtitle = r8;
        this.tvTitle = r9;
        this.viewTitle = r10;
    }

    public static ActivityDataMigrationBinding bind(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_export, OaidModel.KEY_ID, "btn_export");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_import, OaidModel.KEY_ID, "btn_import");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_illustration, OaidModel.KEY_ID, "iv_illustration");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.ll_instruction_list, OaidModel.KEY_ID, "ll_instruction_list");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.scroll_container, OaidModel.KEY_ID, "scroll_container");
        ONestedScrollView r12 = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ONestedScrollView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_instruction_title, OaidModel.KEY_ID, "tv_instruction_title");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_subtitle, OaidModel.KEY_ID, "tv_subtitle");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r16 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L23;
        return new ActivityDataMigrationBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityDataMigrationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityDataMigrationBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_data_migration, "layout", "activity_data_migration"), r4, false, "com.obric.memorydata.plugin");
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
