package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class IconMemoryTabListTitleOperationBinding implements ViewBinding {
    private final OIconButton rootView;

    private IconMemoryTabListTitleOperationBinding(OIconButton r1) {
        this.rootView = r1;
    }

    public static IconMemoryTabListTitleOperationBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new IconMemoryTabListTitleOperationBinding((OIconButton) ZeusTransformUtils.preCheckCast(r3, OIconButton.class, "com.obric.memorydata.plugin"));
    }

    public static IconMemoryTabListTitleOperationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IconMemoryTabListTitleOperationBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.icon_memory_tab_list_title_operation, "layout", "icon_memory_tab_list_title_operation"), r4, false, "com.obric.memorydata.plugin");
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
    public OIconButton getRoot() {
        return this.rootView;
    }
}
