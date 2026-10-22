package y6;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c(ActivityLifecycle.NAME)
    private final String f13680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("version")
    private final String f13681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("path")
    private final String f13682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c("useNative")
    private final boolean f13683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d6.c(WsConstants.KEY_EXTRA)
    private final String f13684e;

    public a(String r10, String r11, String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r14, WsConstants.KEY_EXTRA);
        this.f13680a = r10;
        this.f13681b = r11;
        this.f13682c = r12;
        this.f13683d = r13;
        this.f13684e = r14;
    }

    public final String a() {
        return this.f13680a;
    }

    public final String b() {
        return this.f13681b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.f13680a, r11.f13680a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13681b, r11.f13681b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f13682c, r11.f13682c) == true) goto L18;
        return false;
    L18:
        if (this.f13683d == r11.f13683d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f13684e, r11.f13684e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int r10 = ((((this.f13680a.hashCode() * 31) + this.f13681b.hashCode()) * 31) + this.f13682c.hashCode()) * 31;
        boolean r11 = this.f13683d;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return ((r10 + r12) * 31) + this.f13684e.hashCode();
    }

    public String toString() {
        return "LibraryInfo(name=" + this.f13680a + ", version=" + this.f13681b + ", path=" + this.f13682c + ", useNative=" + this.f13683d + ", extra=" + this.f13684e + ')';
    }
}
