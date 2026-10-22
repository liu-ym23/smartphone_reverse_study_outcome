package com.tom_roush.pdfbox.pdmodel.graphics.state;

import com.tom_roush.pdfbox.pdmodel.font.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16279b;
    private float c;
    private float d;
    private p e;
    private float f;
    private RenderingMode g;
    private float h;
    private boolean i;

    public d() {
        this.f16278a = 0.0f;
        this.f16279b = 0.0f;
        this.c = 100.0f;
        this.d = 0.0f;
        this.g = RenderingMode.FILL;
        this.h = 0.0f;
        this.i = true;
    }

    public float a() {
        return this.f16278a;
    }

    public void a(float r1) {
        this.f16278a = r1;
    }

    public void a(p r1) {
        this.e = r1;
    }

    public void a(RenderingMode r1) {
        this.g = r1;
    }

    public void a(boolean r1) {
        this.i = r1;
    }

    public float b() {
        return this.f16279b;
    }

    public void b(float r1) {
        this.f16279b = r1;
    }

    public float c() {
        return this.c;
    }

    public void c(float r1) {
        this.c = r1;
    }

    public /* synthetic */ Object clone() {
        return h();
    }

    public float d() {
        return this.d;
    }

    public void d(float r1) {
        this.d = r1;
    }

    public p e() {
        return this.e;
    }

    public void e(float r1) {
        this.f = r1;
    }

    public float f() {
        return this.f;
    }

    public void f(float r1) {
        this.h = r1;
    }

    public float g() {
        return this.h;
    }

    public d h() {
        return (d) ZeusTransformUtils.preCheckCast(super.clone(), d.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
