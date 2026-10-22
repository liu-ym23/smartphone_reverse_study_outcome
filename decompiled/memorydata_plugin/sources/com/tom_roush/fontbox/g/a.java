package com.tom_roush.fontbox.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16024b;
    private float c;
    private float d;

    public a() {
    }

    public a(float r1, float r2, float r3, float r4) {
        this.f16023a = r1;
        this.f16024b = r2;
        this.c = r3;
        this.d = r4;
    }

    public a(List<Number> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16023a = ((Number) ZeusTransformUtils.preCheckCast(r5.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue();
        this.f16024b = ((Number) ZeusTransformUtils.preCheckCast(r5.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue();
        this.c = ((Number) ZeusTransformUtils.preCheckCast(r5.get(2), Number.class, "com.obric.memorydata.plugin")).floatValue();
        this.d = ((Number) ZeusTransformUtils.preCheckCast(r5.get(3), Number.class, "com.obric.memorydata.plugin")).floatValue();
    }

    public float a() {
        return this.f16023a;
    }

    public void a(float r1) {
        this.f16023a = r1;
    }

    public float b() {
        return this.f16024b;
    }

    public void b(float r1) {
        this.f16024b = r1;
    }

    public float c() {
        return this.c;
    }

    public void c(float r1) {
        this.c = r1;
    }

    public float d() {
        return this.d;
    }

    public void d(float r1) {
        this.d = r1;
    }

    public float e() {
        return d() - b();
    }

    public String toString() {
        return "[" + a() + "," + b() + "," + c() + "," + d() + "]";
    }
}
