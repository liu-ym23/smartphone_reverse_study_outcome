package com.bytedance.watson.assist.a;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3362b;
        public int c;
        public int d;
        public int e;
        public float f;
        public List<List<Integer>> g;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3364b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public float o;

        public b() {
        }

        public String toString() {
            return "CpuTimePercent{smallCoreLow=" + this.f3363a + ", smallCoreMidLow=" + this.f3364b + ", smallCoreMidHigh=" + this.c + ", smallCoreHigh=" + this.d + ", smallCoreSum=" + this.e + ", middleCoreLow=" + this.f + ", middleCoreMidLow=" + this.g + ", middleCoreMidHigh=" + this.h + ", middleCoreHigh=" + this.i + ", middleCoreSum=" + this.j + ", bigCoreLow=" + this.k + ", bigCoreMidLow=" + this.l + ", bigCoreMidHigh=" + this.m + ", bigCoreHigh=" + this.n + ", bigCoreSum=" + this.o + '}';
        }
    }

    com.bytedance.watson.assist.a.a a();

    boolean a(float r1);

    c b();

    void c();

    int d();

    int e();

    float f();

    void g();

    b h();

    boolean i();

    a j();
}
