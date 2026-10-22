package iq;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f18210b;

    public a(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "extras");
        this.f18209a = r5;
        this.f18210b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f18209a;
        if (Intrinsics.areEqual(this.f18209a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18210b, r10.f18210b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f18209a.hashCode() * 31;
        return this.f18210b.hashCode() + r5;
    }

    public final String toString() {
        return "OEvent(eventName=" + this.f18209a + ", extras=" + this.f18210b + ")";
    }
}
