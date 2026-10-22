package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySensingEventsBinding implements ViewBinding {
    public final FrameLayout flSensingEventsContainer;
    private final FrameLayout rootView;
    public final RecyclerView rvSensingEvents;
    public final OFloatingTitleBar titleBar;

    private ActivitySensingEventsBinding(FrameLayout r1, FrameLayout r2, RecyclerView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.flSensingEventsContainer = r2;
        this.rvSensingEvents = r3;
        this.titleBar = r4;
    }

    public static ActivitySensingEventsBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.fl_sensing_events_container, OaidModel.KEY_ID, "fl_sensing_events_container");
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_sensing_events, OaidModel.KEY_ID, "rv_sensing_events");
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ActivitySensingEventsBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r6, FrameLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivitySensingEventsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySensingEventsBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_sensing_events, "layout", "activity_sensing_events"), r4, false, "com.obric.memorydata.plugin");
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
