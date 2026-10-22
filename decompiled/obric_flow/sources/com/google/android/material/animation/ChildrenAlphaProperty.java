package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = null;

    static {
        CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    private ChildrenAlphaProperty(String r5) {
        super(Float.class, r5);
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Float get(@NonNull ViewGroup r5) {
        return get2(r5);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ViewGroup r5, @NonNull Float r10) {
        set2(r5, r10);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(@NonNull ViewGroup r5) {
        Float r10 = (Float) r5.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Float.valueOf(1.0f);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ViewGroup r5, @NonNull Float r10) {
        float r11 = r10.floatValue();
        r5.setTag(R.id.mtrl_internal_children_alpha_tag, r10);
        int r12 = r5.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r5.getChildAt(r13).setAlpha(r11);
        r13 = r13 + 1;
        goto L3
    }
}
