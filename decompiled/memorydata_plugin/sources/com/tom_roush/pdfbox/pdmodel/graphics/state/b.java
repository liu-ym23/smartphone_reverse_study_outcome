package com.tom_roush.pdfbox.pdmodel.graphics.state;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import com.tom_roush.pdfbox.pdmodel.common.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class b implements Cloneable {
    private double A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Path> f16275b;
    private Map<Path, Region> c;
    private com.tom_roush.pdfbox.util.c d;
    private com.tom_roush.pdfbox.pdmodel.graphics.b.a e;
    private com.tom_roush.pdfbox.pdmodel.graphics.b.a f;
    private com.tom_roush.pdfbox.pdmodel.graphics.b.b g;
    private com.tom_roush.pdfbox.pdmodel.graphics.b.b h;
    private d i;
    private float j;
    private Paint.Cap k;
    private Paint.Join l;
    private float m;
    private com.tom_roush.pdfbox.pdmodel.graphics.b n;
    private RenderingIntent o;
    private boolean p;
    private com.tom_roush.pdfbox.pdmodel.graphics.a.a q;
    private c r;
    private double s;
    private double t;
    private boolean u;
    private boolean v;
    private boolean w;
    private double x;
    private com.tom_roush.pdfbox.a.b y;
    private double z;

    public b(h r6) {
        this.f16275b = new ArrayList(1);
        this.c = new IdentityHashMap();
        this.d = new com.tom_roush.pdfbox.util.c();
        this.e = com.tom_roush.pdfbox.pdmodel.graphics.b.d.f16264b.c();
        this.f = com.tom_roush.pdfbox.pdmodel.graphics.b.d.f16264b.c();
        this.g = com.tom_roush.pdfbox.pdmodel.graphics.b.d.f16264b;
        this.h = com.tom_roush.pdfbox.pdmodel.graphics.b.d.f16264b;
        this.i = new d();
        this.j = 1.0f;
        this.k = Paint.Cap.BUTT;
        this.l = Paint.Join.MITER;
        this.m = 10.0f;
        this.n = new com.tom_roush.pdfbox.pdmodel.graphics.b();
        this.p = false;
        this.q = com.tom_roush.pdfbox.pdmodel.graphics.a.a.f16257a;
        this.s = 1.0d;
        this.t = 1.0d;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = 0.0d;
        this.y = null;
        this.z = 1.0d;
        this.A = 0.0d;
        this.f16275b.add(r6.i());
    }

    private void a(Path r3, boolean r4) {
        if (this.f16274a == true) goto L5;
        this.f16275b = new ArrayList(this.f16275b);
        this.f16274a = true;
    L5:
        List<Path> r2 = this.f16275b;
        if (r4 == false) goto L8;
        r3 = new Path(r3);
    L8:
        r2.add(r3);
    }

    public com.tom_roush.pdfbox.util.c a() {
        return this.d;
    }

    public void a(double r1) {
        this.s = r1;
    }

    public void a(float r1) {
        this.j = r1;
    }

    public void a(Paint.Cap r1) {
        this.k = r1;
    }

    public void a(Paint.Join r1) {
        this.l = r1;
    }

    public void a(Path r2) {
        a(r2, true);
    }

    public void a(com.tom_roush.pdfbox.a.b r1) {
        this.y = r1;
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.a.a r1) {
        this.q = r1;
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.b r1) {
        this.n = r1;
    }

    public void a(RenderingIntent r1) {
        this.o = r1;
    }

    public void a(c r1) {
        this.r = r1;
    }

    public void a(com.tom_roush.pdfbox.util.c r1) {
        this.d = r1;
    }

    public void a(boolean r1) {
        this.p = r1;
    }

    public d b() {
        return this.i;
    }

    public void b(double r1) {
        this.t = r1;
    }

    public void b(float r1) {
        this.m = r1;
    }

    public void b(boolean r1) {
        this.u = r1;
    }

    public b c() {
        b r0 = (b) ZeusTransformUtils.preCheckCast(super.clone(), b.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L4
        r0.i = this.i.h();     // Catch: CloneNotSupportedException -> L4
        r0.d = this.d.b();     // Catch: CloneNotSupportedException -> L4
        r0.e = this.e;     // Catch: CloneNotSupportedException -> L4
        r0.f = this.f;     // Catch: CloneNotSupportedException -> L4
        r0.n = this.n;     // Catch: CloneNotSupportedException -> L4
        r0.f16275b = this.f16275b;     // Catch: CloneNotSupportedException -> L4
        r0.c = this.c;     // Catch: CloneNotSupportedException -> L4
        r0.f16274a = false;     // Catch: CloneNotSupportedException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void c(double r1) {
        this.x = r1;
    }

    public void c(boolean r1) {
        this.v = r1;
    }

    public /* synthetic */ Object clone() {
        return c();
    }

    public void d(double r1) {
        this.z = r1;
    }

    public void d(boolean r1) {
        this.w = r1;
    }

    public void e(double r1) {
        this.A = r1;
    }
}
