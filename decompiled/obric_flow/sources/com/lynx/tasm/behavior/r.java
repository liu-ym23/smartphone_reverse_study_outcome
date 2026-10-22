package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f10321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f10322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f10323c;
    public float d;
    public boolean e;
    public String f;

    public static JavaOnlyMap a(RectF r10) {
        JavaOnlyMap r5 = new JavaOnlyMap();
        if (r10 == null) goto L6;
        r5.putDouble(OpenPageMethod.ALIGN_LEFT, r10.left);
        r5.putDouble("right", r10.right);
        r5.putDouble("top", r10.top);
        r5.putDouble("bottom", r10.bottom);
        return r5;
    L6:
        r5.putDouble(OpenPageMethod.ALIGN_LEFT, 0.0d);
        r5.putDouble("right", 0.0d);
        r5.putDouble("top", 0.0d);
        r5.putDouble("bottom", 0.0d);
        return r5;
    }
}
