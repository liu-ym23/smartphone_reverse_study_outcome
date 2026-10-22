package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemAppSettingBinding implements ViewBinding {
    public final OCardListItem appItemLayout;
    private final OCardListItem rootView;

    private ItemAppSettingBinding(OCardListItem r1, OCardListItem r2) {
        this.rootView = r1;
        this.appItemLayout = r2;
    }

    public static ItemAppSettingBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OCardListItem r0 = (OCardListItem) ZeusTransformUtils.preCheckCast(r4, OCardListItem.class, "com.obric.memorydata.plugin");
        return new ItemAppSettingBinding((OCardListItem) ZeusTransformUtils.preCheckCast(r4, OCardListItem.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemAppSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAppSettingBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_app_setting, "layout", "item_app_setting"), r4, false, "com.obric.memorydata.plugin");
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
    public OCardListItem getRoot() {
        return this.rootView;
    }
}
