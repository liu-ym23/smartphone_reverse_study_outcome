package k5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.monitorV2.k f18597c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f18599b;

    static {
        f18597c = new com.bytedance.android.monitorV2.k((((int) Runtime.getRuntime().maxMemory()) / 1024) / 8, 7);
    }

    public b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "matcherName");
        this.f18598a = r5;
        this.f18599b = new a("__hybrid_default", "default_bid");
    }

    public abstract a a(String r5, String r10);
}
