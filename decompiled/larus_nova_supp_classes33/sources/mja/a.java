package mja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static C0063a a;
    public static final C0063a b = null;

    /* JADX INFO: renamed from: mja.a$a, reason: collision with other inner class name */
    public static final class C0063a {
        public C0063a() {
        }
    }

    public a() {
    }

    static {
        b = new C0063a();
    }

    public static void c(String r4) {
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (a == null) goto L6;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        return;
    }

    public static void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (a == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        return;
    }

    public static void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (a == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        return;
    L5:
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
    }

    public static void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (a == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        return;
    L5:
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
    }
}
