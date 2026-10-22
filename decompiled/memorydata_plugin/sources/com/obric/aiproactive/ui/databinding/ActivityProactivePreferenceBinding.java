package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityProactivePreferenceBinding implements ViewBinding {
    public final View bgGradient;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPreferences;
    public final TextView tvTitle;

    private ActivityProactivePreferenceBinding(ConstraintLayout r1, View r2, RecyclerView r3, TextView r4) {
        this.rootView = r1;
        this.bgGradient = r2;
        this.rvPreferences = r3;
        this.tvTitle = r4;
    }

    public static ActivityProactivePreferenceBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bg_gradient, OaidModel.KEY_ID, "bg_gradient");
        View r2 = r6.findViewById(r0);
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_preferences, OaidModel.KEY_ID, "rv_preferences");
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ActivityProactivePreferenceBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r4, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityProactivePreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProactivePreferenceBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_proactive_preference, "layout", "activity_proactive_preference"), r4, false, "com.obric.memorydata.plugin");
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
