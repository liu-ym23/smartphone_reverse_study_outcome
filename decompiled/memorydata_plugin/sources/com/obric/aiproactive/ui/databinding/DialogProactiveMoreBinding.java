package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogProactiveMoreBinding implements ViewBinding {
    public final TextView btnCloseProactive;
    public final TextView btnFeedback;
    private final LinearLayout rootView;

    private DialogProactiveMoreBinding(LinearLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.btnCloseProactive = r2;
        this.btnFeedback = r3;
    }

    public static DialogProactiveMoreBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_close_proactive, OaidModel.KEY_ID, "btn_close_proactive");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.btn_feedback, OaidModel.KEY_ID, "btn_feedback");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new DialogProactiveMoreBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static DialogProactiveMoreBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogProactiveMoreBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.dialog_proactive_more, "layout", "dialog_proactive_more"), r4, false, "com.obric.memorydata.plugin");
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
