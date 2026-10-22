package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    static d a() {
        return new k();
    }

    static d a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return a();
    L8:
        return new e();
    L10:
        return new k();
    }

    public static void a(View r3) {
        Drawable r0 = r3.getBackground();
        if (ZeusTransformUtils.instanceOf(r0, MaterialShapeDrawable.class) == false) goto L6;
        a(r3, (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(r0, MaterialShapeDrawable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public static void a(View r2, float r3) {
        Drawable r4 = r2.getBackground();
        if (ZeusTransformUtils.instanceOf(r4, MaterialShapeDrawable.class) == false) goto L6;
        ((MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(r4, MaterialShapeDrawable.class, "com.obric.memorydata.plugin")).setElevation(r3);
        return;
    }

    public static void a(View r1, MaterialShapeDrawable r2) {
        if (r2.isElevationOverlayEnabled() == false) goto L6;
        r2.setParentAbsoluteElevation(r.d(r1));
        return;
    }

    static f b() {
        return new f();
    }
}
