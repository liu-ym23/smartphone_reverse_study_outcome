package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.forms.OInputView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryEditCommonItemBinding implements ViewBinding {
    public final OInputView inputView;
    private final LinearLayout rootView;
    public final OTextView titleView;

    private MemoryEditCommonItemBinding(LinearLayout r1, OInputView r2, OTextView r3) {
        this.rootView = r1;
        this.inputView = r2;
        this.titleView = r3;
    }

    public static MemoryEditCommonItemBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.input_view, OaidModel.KEY_ID, "input_view");
        OInputView r2 = (OInputView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OInputView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.title_view, OaidModel.KEY_ID, "title_view");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new MemoryEditCommonItemBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryEditCommonItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryEditCommonItemBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_edit_common_item, "layout", "memory_edit_common_item"), r4, false, "com.obric.memorydata.plugin");
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
