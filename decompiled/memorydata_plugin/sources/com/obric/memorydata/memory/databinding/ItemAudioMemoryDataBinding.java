package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemAudioMemoryDataBinding implements ViewBinding {
    public final TextView audioMemoryTime;
    public final TextView audioMemoryTitle;
    public final ConstraintLayout memoryGeneralization;
    public final LinearLayout memorySourceContainer;
    private final ConstraintLayout rootView;

    private ItemAudioMemoryDataBinding(ConstraintLayout r1, TextView r2, TextView r3, ConstraintLayout r4, LinearLayout r5) {
        this.rootView = r1;
        this.audioMemoryTime = r2;
        this.audioMemoryTitle = r3;
        this.memoryGeneralization = r4;
        this.memorySourceContainer = r5;
    }

    public static ItemAudioMemoryDataBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.audio_memory_time, OaidModel.KEY_ID, "audio_memory_time");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.audio_memory_title, OaidModel.KEY_ID, "audio_memory_title");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L11;
        ConstraintLayout r9 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.memory_source_container, OaidModel.KEY_ID, "memory_source_container");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L11;
        return new ItemAudioMemoryDataBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemAudioMemoryDataBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAudioMemoryDataBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_audio_memory_data, "layout", "item_audio_memory_data"), r4, false, "com.obric.memorydata.plugin");
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
