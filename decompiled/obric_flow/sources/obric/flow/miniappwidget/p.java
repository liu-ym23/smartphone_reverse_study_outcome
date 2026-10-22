package obric.flow.miniappwidget;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20513c;

    public p(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "instanceId");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        this.f20511a = r5;
        this.f20512b = r10;
        this.f20513c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r5;
        String r11 = r10.f20511a;
        if (Intrinsics.areEqual(this.f20511a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20512b, r10.f20512b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20513c, r10.f20513c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f20511a.hashCode() * 31, 31, this.f20512b);
        return this.f20513c.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("MiniAppWidgetRuntimeCleanupRequest(instanceId=");
        r5.append(this.f20511a);
        r5.append(", appletId=");
        r5.append(this.f20512b);
        r5.append(", widgetId=");
        return j0.q(r5, this.f20513c, ")");
    }
}
