package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i0 f10361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f10362b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final e f10363c = null;

    static {
        f10361a = new i0("REHASH");
        f10362b = new e(null);
        f10363c = new e(Boolean.TRUE);
    }

    public static final /* synthetic */ i0 a() {
        return f10361a;
    }

    public static final /* synthetic */ e b(Object r10) {
        return d(r10);
    }

    public static final /* synthetic */ Void c() {
        return e();
    }

    private static final e d(Object r10) {
        if (r10 != null) goto L5;
        return f10362b;
    L5:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L8;
        return f10363c;
    L8:
        return new e(r10);
    }

    private static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
