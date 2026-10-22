package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15008b;
    private int c;
    private int d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private int i;
    private String j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private float q;
    private boolean r;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f15009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15010b;
        private int c;
        private float d;
        private int e;
        private String f;
        private String g;
        private boolean h;
        private boolean i;
        private int j;
        private String k;
        private boolean l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private int q;
        private boolean r;

        public a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f15010b = 14;
            this.c = 20971520;
            this.d = 0.1f;
            this.e = 1048576;
            this.h = true;
            this.i = true;
            this.j = 3;
            this.k = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = 64;
            this.r = false;
            if (r5 == null) goto L10;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            r5 = r0;
        L7:
            this.f15009a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            return;
        L10:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        public a a(float r1) {
            this.d = r1;
            return this;
        }

        public a a(int r1) {
            this.c = r1;
            return this;
        }

        public a a(boolean r1) {
            this.o = r1;
            return this;
        }

        public b a() {
            b r0 = new b(null);
            r0.a(this.f15009a);
            r0.a(this.f15010b);
            r0.b(this.c);
            r0.a(this.d);
            r0.c(this.e);
            if (TextUtils.isEmpty(this.f) == false) goto L5;
            String r1 = com.ss.android.agilelogger.utils.a.b(this.f15009a);
        L6:
            r0.a(r1);
            if (TextUtils.isEmpty(this.g) == false) goto L9;
            String r2 = com.ss.android.agilelogger.utils.a.a(this.f15009a).getAbsolutePath();
        L10:
            r0.b(r2);
            r0.a(this.h);
            r0.b(this.i);
            r0.d(this.j);
            r0.c(this.k);
            r0.c(this.l);
            r0.d(this.m);
            r0.e(this.n);
            r0.f(this.p);
            r0.g(this.o);
            r0.h(this.r);
            r0.e(this.q);
            return r0;
        L9:
            r2 = this.g;
            goto L10
        L5:
            r1 = this.f;
            goto L6
        }

        public a b(int r1) {
            this.e = r1;
            return this;
        }
    }

    private b() {
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public int a() {
        return this.f15008b;
    }

    public void a(float r1) {
        this.q = r1;
    }

    public void a(int r1) {
        this.f15008b = r1;
    }

    public void a(Context r3) {
        this.f15007a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public void a(String r1) {
        this.e = r1;
    }

    public void a(boolean r1) {
        this.g = r1;
    }

    public int b() {
        return this.c;
    }

    public void b(int r1) {
        this.c = r1;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public void b(boolean r1) {
        this.h = r1;
    }

    public float c() {
        return this.q;
    }

    public void c(int r1) {
        this.d = r1;
    }

    public void c(String r1) {
        this.j = r1;
    }

    public void c(boolean r1) {
        this.k = r1;
    }

    public int d() {
        return this.d;
    }

    public void d(int r1) {
        this.i = r1;
    }

    public void d(boolean r1) {
        this.l = r1;
    }

    public String e() {
        return this.e;
    }

    public void e(int r1) {
        this.p = r1;
    }

    public void e(boolean r1) {
        this.m = r1;
    }

    public String f() {
        return this.f;
    }

    public void f(boolean r1) {
        this.o = r1;
    }

    public void g(boolean r1) {
        this.n = r1;
    }

    public boolean g() {
        return this.g;
    }

    public Context getContext() {
        return this.f15007a;
    }

    public void h(boolean r1) {
        this.r = r1;
    }

    public boolean h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public boolean n() {
        return this.o;
    }

    public boolean o() {
        return this.r;
    }

    public boolean p() {
        return this.n;
    }

    public int q() {
        return this.p;
    }
}
