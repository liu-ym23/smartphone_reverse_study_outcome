package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAudioMemoryListBinding implements ViewBinding {
    public final LinearLayout layoutEmpty;
    public final View listTimeLine;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMemoryList;
    public final OTextView tvEmptyDescription;
    public final OTextView tvEmptyTitle;

    private FragmentAudioMemoryListBinding(ConstraintLayout r1, LinearLayout r2, View r3, RecyclerView r4, OTextView r5, OTextView r6) {
        this.rootView = r1;
        this.layoutEmpty = r2;
        this.listTimeLine = r3;
        this.rvMemoryList = r4;
        this.tvEmptyDescription = r5;
        this.tvEmptyTitle = r6;
    }

    public static FragmentAudioMemoryListBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.list_time_line, OaidModel.KEY_ID, "list_time_line");
        View r8 = r12.findViewById(r0);
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list");
        RecyclerView r9 = (RecyclerView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_empty_description, OaidModel.KEY_ID, "tv_empty_description");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_empty_title, OaidModel.KEY_ID, "tv_empty_title");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new FragmentAudioMemoryListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentAudioMemoryListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentAudioMemoryListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_audio_memory_list, "layout", "fragment_audio_memory_list"), r4, false, "com.obric.memorydata.plugin");
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
