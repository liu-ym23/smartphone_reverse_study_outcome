package y6;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c(ActivityLifecycle.NAME)
    private final String f13685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("version")
    private final String f13686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("path")
    private final String f13687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c("service")
    private final String f13688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d6.c("libraries")
    private final List<a> f13689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d6.c("resources")
    private final List<c> f13690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @d6.c(WsConstants.KEY_EXTRA)
    private final String f13691g;

    public b(String r10, String r11, String r12, String r13, List<a> r14, List<c> r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r13, "service");
        Intrinsics.checkNotNullParameter(r14, "libraries");
        Intrinsics.checkNotNullParameter(r15, "resources");
        Intrinsics.checkNotNullParameter(r16, WsConstants.KEY_EXTRA);
        this.f13685a = r10;
        this.f13686b = r11;
        this.f13687c = r12;
        this.f13688d = r13;
        this.f13689e = r14;
        this.f13690f = r15;
        this.f13691g = r16;
    }

    public final String a() {
        return this.f13691g;
    }

    public final List<a> b() {
        return this.f13689e;
    }

    public final String c() {
        return this.f13685a;
    }

    public final String d() {
        return this.f13687c;
    }

    public final List<c> e() {
        return this.f13690f;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aee.res.PackageInfo");
        b r12 = (b) r10;
        if (Intrinsics.areEqual(this.f13685a, r12.f13685a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f13686b, r12.f13686b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f13687c, r12.f13687c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f13688d, r12.f13688d) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.f13689e, r12.f13689e) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f13690f, r12.f13690f) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.f13691g, r12.f13691g) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r11 = null;
        goto L10
    }

    public final String f() {
        return this.f13688d;
    }

    public final String g() {
        if (this.f13688d.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        StringBuilder r11 = new StringBuilder();
        r11.append("service-");
        r11.append(this.f13685a);
        r11.append('@');
        String r12 = this.f13686b;
    L8:
        r11.append(r12);
        return r11.toString();
    L10:
        r11 = new StringBuilder();
        r11.append("service-n-");
        r12 = this.f13688d;
        goto L8
    L5:
        r10 = false;
        goto L6
    }

    public final String h() {
        return this.f13686b;
    }

    public int hashCode() {
        return (((((((((((this.f13685a.hashCode() * 31) + this.f13686b.hashCode()) * 31) + this.f13687c.hashCode()) * 31) + this.f13688d.hashCode()) * 31) + this.f13689e.hashCode()) * 31) + this.f13690f.hashCode()) * 31) + this.f13691g.hashCode();
    }

    public final String i() {
        return this.f13685a + '@' + this.f13686b;
    }

    public String toString() {
        return "PackageInfo(name=" + this.f13685a + ", version=" + this.f13686b + ", path=" + this.f13687c + ", service=" + this.f13688d + ", libraries=" + this.f13689e + ", resources=" + this.f13690f + ", extra=" + this.f13691g + ')';
    }
}
