package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryTimeLineBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final View timeLineDown;
    public final View timeLineDownBackgroundView;
    public final View timeLinePoint;
    public final View timeLineUp;
    public final View timeLineUpBackgroundView;
    public final TextView tvMemoryTime;

    private ItemMemoryTimeLineBinding(ConstraintLayout r1, View r2, View r3, View r4, View r5, View r6, TextView r7) {
        this.rootView = r1;
        this.timeLineDown = r2;
        this.timeLineDownBackgroundView = r3;
        this.timeLinePoint = r4;
        this.timeLineUp = r5;
        this.timeLineUpBackgroundView = r6;
        this.tvMemoryTime = r7;
    }

    public static ItemMemoryTimeLineBinding bind(View r10) {
        int r0 = ZeusTransformUtils.mapRes(R.id.time_line_down, OaidModel.KEY_ID, "time_line_down");
        View r4 = r10.findViewById(r0);
        if (r4 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.time_line_down_background_view, OaidModel.KEY_ID, "time_line_down_background_view");
        View r5 = r10.findViewById(r0);
        if (r5 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.time_line_point, OaidModel.KEY_ID, "time_line_point");
        View r6 = r10.findViewById(r0);
        if (r6 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.time_line_up, OaidModel.KEY_ID, "time_line_up");
        View r7 = r10.findViewById(r0);
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.time_line_up_background_view, OaidModel.KEY_ID, "time_line_up_background_view");
        View r8 = r10.findViewById(r0);
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_memory_time, OaidModel.KEY_ID, "tv_memory_time");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        return new ItemMemoryTimeLineBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r10, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryTimeLineBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryTimeLineBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_time_line, "layout", "item_memory_time_line"), r4, false, "com.obric.memorydata.plugin");
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
