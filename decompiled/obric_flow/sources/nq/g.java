package nq;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f20296b;

    public g(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        this.f20295a = r5;
        this.f20296b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        String r11 = r10.f20295a;
        if (Intrinsics.areEqual(this.f20295a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20296b, r10.f20296b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f20295a.hashCode() * 31;
        return this.f20296b.hashCode() + r5;
    }

    public final String toString() {
        return "PendingEvent(eventName=" + this.f20295a + ", jsonObject=" + this.f20296b + ')';
    }
}
