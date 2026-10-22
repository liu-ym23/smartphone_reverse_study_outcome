package com.obric.memorydata.larus_ui.databinding;

import android.security.obric.guard.ObricSecurityGuardStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusDialogCommonBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final TextView dialogMessage;
    public final TextView dialogTitle;
    public final View divider;
    private final LinearLayout rootView;

    private LarusDialogCommonBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4, TextView r5, View r6) {
        this.rootView = r1;
        this.cancel = r2;
        this.confirm = r3;
        this.dialogMessage = r4;
        this.dialogTitle = r5;
        this.divider = r6;
    }

    public static LarusDialogCommonBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cancel, OaidModel.KEY_ID, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.confirm, OaidModel.KEY_ID, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM);
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.dialog_message, OaidModel.KEY_ID, "dialog_message");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.dialog_title, OaidModel.KEY_ID, "dialog_title");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.divider, OaidModel.KEY_ID, "divider");
        View r11 = r12.findViewById(r0);
        if (r11 == null) goto L15;
        return new LarusDialogCommonBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static LarusDialogCommonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LarusDialogCommonBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.larus_dialog_common, "layout", "larus_dialog_common"), r4, false, "com.obric.memorydata.plugin");
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
