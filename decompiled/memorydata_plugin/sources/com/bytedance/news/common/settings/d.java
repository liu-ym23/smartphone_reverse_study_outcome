package com.bytedance.news.common.settings;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f2932a;

    /* JADX INFO: renamed from: com.bytedance.news.common.settings.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2933a;

        public a() {
        }

        public a a(String r1) {
            this.f2933a = r1;
            return this;
        }

        public d a() {
            AnonymousClass1 r1 = null;
            b r0 = new b(r1);
            r0.f2934a = this.f2933a;
            return new d(r0, r1);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2934a;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }
    }

    private d(b r1) {
        this.f2932a = r1;
    }

    /* synthetic */ d(b r1, AnonymousClass1 r2) {
        this(r1);
    }

    public String a() {
        return this.f2932a.f2934a;
    }
}
