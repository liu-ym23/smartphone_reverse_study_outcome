package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemAgentRunGroupHeaderBinding implements ViewBinding {
    private final OSectionTitleBar rootView;
    public final OSectionTitleBar sectionTitle;

    private ItemAgentRunGroupHeaderBinding(OSectionTitleBar r1, OSectionTitleBar r2) {
        this.rootView = r1;
        this.sectionTitle = r2;
    }

    public static ItemAgentRunGroupHeaderBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OSectionTitleBar r0 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r4, OSectionTitleBar.class, "com.obric.memorydata.plugin");
        return new ItemAgentRunGroupHeaderBinding((OSectionTitleBar) ZeusTransformUtils.preCheckCast(r4, OSectionTitleBar.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemAgentRunGroupHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAgentRunGroupHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_agent_run_group_header, "layout", "item_agent_run_group_header"), r4, false, "com.obric.memorydata.plugin");
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
    public OSectionTitleBar getRoot() {
        return this.rootView;
    }
}
