package j29;

import kotlin.jvm.internal.Intrinsics;
import zp9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements t1a.c {
    public static final /* synthetic */ int b = 0;
    public final g a;

    /* JADX INFO: renamed from: j29.a$a, reason: collision with other inner class name */
    public static final class C0129a {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        g r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CreationTrackParamsWrap(creationFeedTrackParams=" + this.a + ')';
    }

    static {
    }

    public a(g r1) {
        this.a = r1;
    }
}
