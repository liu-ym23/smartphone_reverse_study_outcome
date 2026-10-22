package com.tom_roush.pdfbox.pdmodel.graphics.b;

import com.tom_roush.pdfbox.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f16261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f16262b;
    private final b c;

    public a(float[] r3, b r4) {
        this.f16261a = (float[]) ZeusTransformUtils.preCheckCast(r3.clone(), float[].class, "com.obric.memorydata.plugin");
        this.f16262b = null;
        this.c = r4;
    }

    public float[] a() {
        b r0 = this.c;
        float[] r2 = this.f16261a;
        if (r0 != null) goto L7;
        return (float[]) ZeusTransformUtils.preCheckCast(r2.clone(), float[].class, "com.obric.memorydata.plugin");
    L7:
        return Arrays.copyOf(r2, r0.b());
    }

    public com.tom_roush.pdfbox.a.a b() {
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        r0.a(this.f16261a);
        i r2 = this.f16262b;
        if (r2 == null) goto L5;
        r0.a(r2);
    L5:
        return r0;
    }

    public String toString() {
        return "PDColor{components=" + Arrays.toString(this.f16261a) + ", patternName=" + this.f16262b + "}";
    }
}
