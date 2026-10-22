package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemRecommendMemoryDataBinding implements ViewBinding {
    public final ConstraintLayout memoryGeneralization;
    public final LinearLayout memorySourceContainer;
    public final AppCompatImageView memorySourceIcon;
    public final TextView memorySourceText;
    public final TextView newAuditoryDebugBadge;
    private final ConstraintLayout rootView;
    public final TextView screenMemoryTime;
    public final TextView shortMemoryTitle;

    private ItemRecommendMemoryDataBinding(ConstraintLayout r1, ConstraintLayout r2, LinearLayout r3, AppCompatImageView r4, TextView r5, TextView r6, TextView r7, TextView r8) {
        this.rootView = r1;
        this.memoryGeneralization = r2;
        this.memorySourceContainer = r3;
        this.memorySourceIcon = r4;
        this.memorySourceText = r5;
        this.newAuditoryDebugBadge = r6;
        this.screenMemoryTime = r7;
        this.shortMemoryTitle = r8;
    }

    public static ItemRecommendMemoryDataBinding bind(View r11) {
        ConstraintLayout r4 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.memory_source_container, OaidModel.KEY_ID, "memory_source_container");
        LinearLayout r5 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_source_icon, OaidModel.KEY_ID, "memory_source_icon");
        AppCompatImageView r6 = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), AppCompatImageView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_source_text, OaidModel.KEY_ID, "memory_source_text");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.new_auditory_debug_badge, OaidModel.KEY_ID, "new_auditory_debug_badge");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.screen_memory_time, OaidModel.KEY_ID, "screen_memory_time");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.short_memory_title, OaidModel.KEY_ID, "short_memory_title");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        return new ItemRecommendMemoryDataBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRecommendMemoryDataBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendMemoryDataBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_memory_data, "layout", "item_recommend_memory_data"), r4, false, "com.obric.memorydata.plugin");
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
