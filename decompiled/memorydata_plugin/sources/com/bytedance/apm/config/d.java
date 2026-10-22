package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1255b;
    private JSONObject c;
    private JSONObject d;
    private JSONObject e;
    private boolean f;

    /* JADX INFO: renamed from: com.bytedance.apm.config.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1257b;
        private JSONObject c;
        private JSONObject d;
        private JSONObject e;
        private boolean f;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ String a(a r0) {
            return r0.f1256a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f1257b;
        }

        static /* synthetic */ JSONObject c(a r0) {
            return r0.c;
        }

        static /* synthetic */ JSONObject d(a r0) {
            return r0.d;
        }

        static /* synthetic */ JSONObject e(a r0) {
            return r0.e;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.f;
        }

        public a a(int r1) {
            this.f1257b = r1;
            return this;
        }

        public a a(String r1) {
            this.f1256a = r1;
            return this;
        }

        public a a(JSONObject r1) {
            this.c = r1;
            return this;
        }

        public a a(boolean r1) {
            this.f = r1;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(JSONObject r1) {
            this.d = r1;
            return this;
        }

        public a c(JSONObject r1) {
            this.e = r1;
            return this;
        }
    }

    public d(a r2) {
        this.f1254a = a.a(r2);
        this.f1255b = a.b(r2);
        this.c = a.c(r2);
        this.d = a.d(r2);
        this.e = a.e(r2);
        this.f = a.f(r2);
    }

    public static a g() {
        return new a(null);
    }

    public String a() {
        return this.f1254a;
    }

    public JSONObject b() {
        return this.c;
    }

    public JSONObject c() {
        return this.d;
    }

    public int d() {
        return this.f1255b;
    }

    public JSONObject e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }
}
