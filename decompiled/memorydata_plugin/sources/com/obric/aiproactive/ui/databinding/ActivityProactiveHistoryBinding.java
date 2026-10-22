package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityProactiveHistoryBinding implements ViewBinding {
    public final ProactiveTopBarIconButton btnBackContainer;
    public final FrameLayout fragmentContainer;
    private final ConstraintLayout rootView;
    public final OBlurMaskView topBlurView;
    public final View topCutOff;
    public final TextView tvTitle;

    private ActivityProactiveHistoryBinding(ConstraintLayout r1, ProactiveTopBarIconButton r2, FrameLayout r3, OBlurMaskView r4, View r5, TextView r6) {
        this.rootView = r1;
        this.btnBackContainer = r2;
        this.fragmentContainer = r3;
        this.topBlurView = r4;
        this.topCutOff = r5;
        this.tvTitle = r6;
    }

    public static ActivityProactiveHistoryBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_back_container, OaidModel.KEY_ID, "btn_back_container");
        ProactiveTopBarIconButton r7 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.top_blur_view, OaidModel.KEY_ID, "top_blur_view");
        OBlurMaskView r9 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OBlurMaskView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.top_cut_off, OaidModel.KEY_ID, "top_cut_off");
        View r10 = r12.findViewById(r0);
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new ActivityProactiveHistoryBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityProactiveHistoryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProactiveHistoryBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_proactive_history, "layout", "activity_proactive_history"), r4, false, "com.obric.memorydata.plugin");
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
