package li;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f19655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f19656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f19657c;
    public int d;

    public f(LinkedHashMap r5, LinkedHashMap r10, j r11) {
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r10, "contentV2");
        Intrinsics.checkNotNullParameter(r11, "settings");
        this.f19655a = r5;
        this.f19656b = r10;
        this.f19657c = r11;
        this.d = -1;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        LinkedHashMap r11 = r10.f19655a;
        if (Intrinsics.areEqual(this.f19655a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19656b, r10.f19656b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19657c, r10.f19657c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19655a.hashCode() * 31;
        int r10 = (this.f19656b.hashCode() + r5) * 31;
        return this.f19657c.hashCode() + r10;
    }

    public final String toString() {
        return "ConfigWithSwitch(content=" + this.f19655a + ", contentV2=" + this.f19656b + ", settings=" + this.f19657c + ')';
    }
}
