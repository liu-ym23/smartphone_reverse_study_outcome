package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewProactiveValueCurrencyPrefixBinding implements ViewBinding {
    private final TextView rootView;

    private ViewProactiveValueCurrencyPrefixBinding(TextView r1) {
        this.rootView = r1;
    }

    public static ViewProactiveValueCurrencyPrefixBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new ViewProactiveValueCurrencyPrefixBinding((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"));
    }

    public static ViewProactiveValueCurrencyPrefixBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewProactiveValueCurrencyPrefixBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.view_proactive_value_currency_prefix, "layout", "view_proactive_value_currency_prefix"), r4, false, "com.obric.memorydata.plugin");
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
    public TextView getRoot() {
        return this.rootView;
    }
}
