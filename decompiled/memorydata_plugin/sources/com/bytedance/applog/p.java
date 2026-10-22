package com.bytedance.applog;

import com.bytedance.bdinstall.Env;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static boolean g = false;
    private static boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f1738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f1739b;
    private final String c;
    private final String d;
    private final Env e;
    private final Map<String, String> f;

    /* JADX INFO: renamed from: com.bytedance.applog.p$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f1740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f1741b;
        private String c;
        private String d;
        private Env e;
        private Map<String, String> f;

        public a() {
            this.f = null;
        }

        static /* synthetic */ Env a(a r0) {
            return r0.e;
        }

        static /* synthetic */ String[] b(a r0) {
            return r0.f1740a;
        }

        static /* synthetic */ String[] c(a r0) {
            return r0.f1741b;
        }

        static /* synthetic */ String d(a r0) {
            return r0.c;
        }

        static /* synthetic */ String e(a r0) {
            return r0.d;
        }

        static /* synthetic */ Map f(a r0) {
            return r0.f;
        }

        public a a(Env r1) {
            this.e = r1;
            return this;
        }

        public a a(String r1) {
            this.c = r1;
            return this;
        }

        public a a(String[] r3) {
            if (p.h() == false) goto L5;
            this.f1740a = (String[]) ZeusTransformUtils.preCheckCast(new HashSet(Arrays.asList(r3)).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        L6:
            return this;
        L5:
            this.f1740a = r3;
            goto L6
        }

        public p a() {
            return new p(this, null);
        }

        public a b(String r1) {
            this.d = r1;
            return this;
        }

        public a b(String[] r3) {
            if (p.h() == false) goto L5;
            this.f1741b = (String[]) ZeusTransformUtils.preCheckCast(new HashSet(Arrays.asList(r3)).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        L6:
            return this;
        L5:
            this.f1741b = r3;
            goto L6
        }
    }

    static {
    }

    private p(a r2) {
        this.e = a.a(r2);
        this.f1738a = a.b(r2);
        this.f1739b = a.c(r2);
        this.c = a.d(r2);
        this.d = a.e(r2);
        this.f = a.f(r2);
    }

    /* synthetic */ p(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static String a() {
        if (h == false) goto L5;
        return "/service/2/app_log/";
    L5:
        return "/service/2/app_log_monitor/";
    }

    static /* synthetic */ boolean h() {
        return g;
    }

    public Env b() {
        return this.e;
    }

    public String[] c() {
        return this.f1738a;
    }

    public String[] d() {
        return this.f1739b;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public Map<String, String> g() {
        return this.f;
    }
}
