package com.bytedance.frameworks.plugin.dependency;

/* JADX INFO: loaded from: classes.dex */
public class PluginAttribute extends BaseAttribute {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a[] f3940a = null;

        static {
            f3940a = new a[]{new a("PENDING", 0), new a("INSTALLING", 1), new a("INSTALL_FAILED", 2), new a("INSTALLED", 3), new a("RESOLVING", 4), new a("RESOLVE_FAILED", 5), new a("RESOLVED", 6), new a("ACTIVED", 7)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f3940a.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f3941a = null;

        static {
            f3941a = new b[]{new b("LAZY", 0), new b("RIGHTNOW", 1)};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f3941a.clone();
        }
    }

    public PluginAttribute() {
        a[] r8 = a.f3940a;
        b[] r10 = b.f3941a;
    }
}
