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
public final class ItemAutoMemoryProDataBinding implements ViewBinding {
    public final TextView autoMemoryContent;
    public final ConstraintLayout autoMemoryProContent;
    public final TextView autoMemoryTime;
    public final TextView autoMemoryTitle;
    private final ConstraintLayout rootView;

    private ItemAutoMemoryProDataBinding(ConstraintLayout r1, TextView r2, ConstraintLayout r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.autoMemoryContent = r2;
        this.autoMemoryProContent = r3;
        this.autoMemoryTime = r4;
        this.autoMemoryTitle = r5;
    }

    public static ItemAutoMemoryProDataBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.auto_memory_content, OaidModel.KEY_ID, "auto_memory_content");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        ConstraintLayout r8 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.auto_memory_time, OaidModel.KEY_ID, "auto_memory_time");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.auto_memory_title, OaidModel.KEY_ID, "auto_memory_title");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L11;
        return new ItemAutoMemoryProDataBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemAutoMemoryProDataBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAutoMemoryProDataBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_auto_memory_pro_data, "layout", "item_auto_memory_pro_data"), r4, false, "com.obric.memorydata.plugin");
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
