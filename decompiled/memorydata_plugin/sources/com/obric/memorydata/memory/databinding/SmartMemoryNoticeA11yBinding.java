package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class SmartMemoryNoticeA11yBinding implements ViewBinding {
    public final OTextView message;
    private final LinearLayout rootView;
    public final OTextView title;

    private SmartMemoryNoticeA11yBinding(LinearLayout r1, OTextView r2, OTextView r3) {
        this.rootView = r1;
        this.message = r2;
        this.title = r3;
    }

    public static SmartMemoryNoticeA11yBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.message, OaidModel.KEY_ID, "message");
        OTextView r2 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new SmartMemoryNoticeA11yBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static SmartMemoryNoticeA11yBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SmartMemoryNoticeA11yBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.smart_memory_notice_a11y, "layout", "smart_memory_notice_a11y"), r4, false, "com.obric.memorydata.plugin");
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
