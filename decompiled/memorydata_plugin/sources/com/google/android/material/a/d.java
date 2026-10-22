package com.google.android.material.a;

import android.util.Property;
import android.view.ViewGroup;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f3744a = null;

    static {
        f3744a = new d("childrenAlpha");
    }

    private d(String r2) {
        super(Float.class, r2);
    }

    public Float a(ViewGroup r3) {
        Float r2 = (Float) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.mtrl_internal_children_alpha_tag, OaidModel.KEY_ID, "mtrl_internal_children_alpha_tag")), Float.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        return Float.valueOf(1.0f);
    }

    public void a(ViewGroup r3, Float r4) {
        float r2 = r4.floatValue();
        r3.setTag(ZeusTransformUtils.mapRes(R.id.mtrl_internal_children_alpha_tag, OaidModel.KEY_ID, "mtrl_internal_children_alpha_tag"), Float.valueOf(r2));
        int r5 = r3.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.getChildAt(r0).setAlpha(r2);
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.util.Property
    public /* synthetic */ Float get(ViewGroup r3) {
        return a((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.util.Property
    public /* synthetic */ void set(ViewGroup r3, Float r4) {
        a((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin"), (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin"));
    }
}
