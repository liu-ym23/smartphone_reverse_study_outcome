package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveNowActionChipBinding implements ViewBinding {
    private final OButton rootView;

    private ItemProactiveNowActionChipBinding(OButton r1) {
        this.rootView = r1;
    }

    public static ItemProactiveNowActionChipBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new ItemProactiveNowActionChipBinding((OButton) ZeusTransformUtils.preCheckCast(r3, OButton.class, "com.obric.memorydata.plugin"));
    }

    public static ItemProactiveNowActionChipBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveNowActionChipBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_now_action_chip, "layout", "item_proactive_now_action_chip"), r4, false, "com.obric.memorydata.plugin");
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
    public OButton getRoot() {
        return this.rootView;
    }
}
