package com.google.android.material.shape;

import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f4041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f4042b;

    public b(float r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L6;
        r6 = ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).f4041a;
        r4 = r4 + ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).f4042b;
        goto L4
    L6:
        this.f4041a = r6;
        this.f4042b = r4;
    }

    @Override // com.google.android.material.shape.c
    public float a(RectF r2) {
        return Math.max(0.0f, this.f4041a.a(r2) + this.f4042b);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f4041a.equals(r6.f4041a) == false) goto L14;
        if (this.f4042b != r6.f4042b) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4041a, Float.valueOf(this.f4042b)});
    }
}
