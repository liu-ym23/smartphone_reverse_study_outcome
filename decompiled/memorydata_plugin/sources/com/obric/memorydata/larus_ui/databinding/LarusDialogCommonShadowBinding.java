package com.obric.memorydata.larus_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusDialogCommonShadowBinding implements ViewBinding {
    private final CardView rootView;

    private LarusDialogCommonShadowBinding(CardView r1) {
        this.rootView = r1;
    }

    public static LarusDialogCommonShadowBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new LarusDialogCommonShadowBinding((CardView) ZeusTransformUtils.preCheckCast(r3, CardView.class, "com.obric.memorydata.plugin"));
    }

    public static LarusDialogCommonShadowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LarusDialogCommonShadowBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.larus_dialog_common_shadow, "layout", "larus_dialog_common_shadow"), r4, false, "com.obric.memorydata.plugin");
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
    public CardView getRoot() {
        return this.rootView;
    }
}
