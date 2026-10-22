package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemGuideCategoryDescBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvGuideAppDesc;

    private ItemGuideCategoryDescBinding(TextView r1, TextView r2) {
        this.rootView = r1;
        this.tvGuideAppDesc = r2;
    }

    public static ItemGuideCategoryDescBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin");
        return new ItemGuideCategoryDescBinding((TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemGuideCategoryDescBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemGuideCategoryDescBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_guide_category_desc, "layout", "item_guide_category_desc"), r4, false, "com.obric.memorydata.plugin");
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
