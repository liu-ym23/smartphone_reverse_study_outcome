package y6;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c(ActivityLifecycle.NAME)
    private final String f13692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("version")
    private final String f13693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("path")
    private final String f13694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c(WsConstants.KEY_EXTRA)
    private final String f13695d;

    public c(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r13, WsConstants.KEY_EXTRA);
        this.f13692a = r10;
        this.f13693b = r11;
        this.f13694c = r12;
        this.f13695d = r13;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.f13692a, r11.f13692a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13693b, r11.f13693b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f13694c, r11.f13694c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f13695d, r11.f13695d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f13692a.hashCode() * 31) + this.f13693b.hashCode()) * 31) + this.f13694c.hashCode()) * 31) + this.f13695d.hashCode();
    }

    public String toString() {
        return "ResourceInfo(name=" + this.f13692a + ", version=" + this.f13693b + ", path=" + this.f13694c + ", extra=" + this.f13695d + ')';
    }
}
