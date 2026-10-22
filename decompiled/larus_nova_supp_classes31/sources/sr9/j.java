package sr9;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements d {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // sr9.d
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return "";
    }

    @Override // sr9.d
    public final Pair<Integer, Integer> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    @Override // sr9.d
    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return "";
    }

    @Override // sr9.d
    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Intrinsics.checkNotNullParameter("upload", "contentSource");
    }

    @Override // sr9.d
    public final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Intrinsics.checkNotNullParameter("album", "previousPage");
    }

    @Override // sr9.d
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return "";
    }

    @Override // sr9.d
    public final boolean g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return false;
    }

    @Override // sr9.d
    public final String h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return "";
    }
}
