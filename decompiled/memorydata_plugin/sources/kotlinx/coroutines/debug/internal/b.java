package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.aj;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\b\u0010\b\u001a\u00020\tH\u0002\u001a\u000e\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"MAGIC", "", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "MIN_CAPACITY", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "noImpl", "", "mark", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final aj f17321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f17322b = null;
    private static final g c = null;

    static {
        f17321a = new aj("REHASH");
        f17322b = new g(null);
        c = new g(true);
    }

    public static final /* synthetic */ g a(Object r0) {
        return b(r0);
    }

    public static final /* synthetic */ aj a() {
        return f17321a;
    }

    public static final /* synthetic */ Void b() {
        return c();
    }

    private static final g b(Object r1) {
        if (r1 != null) goto L5;
        return f17322b;
    L5:
        if (Intrinsics.areEqual(r1, true) == false) goto L8;
        return c;
    L8:
        return new g(r1);
    }

    private static final Void c() {
        throw new UnsupportedOperationException("not implemented");
    }
}
