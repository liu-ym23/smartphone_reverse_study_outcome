package dc;

import kotlin.jvm.internal.Intrinsics;
import sj.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f16633a;

    static {
        f16633a = new e();
    }

    public static void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        f16633a.b("[ResourceLoader] " + r5);
    }

    public static void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        f16633a.a("[ResourceLoader] " + r5);
    }
}
