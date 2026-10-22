package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19446b;

    public q(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "body");
        this.f19445a = r10;
        this.f19446b = r5.toString();
    }

    @Override // kotlinx.serialization.json.b0
    public final String b() {
        return this.f19446b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (q.class != r5.getClass()) goto L17;
        q r10 = (q) r5;
        if (this.f19445a == r10.f19445a) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f19446b, r10.f19446b) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f19445a) * 31;
        return this.f19446b.hashCode() + r5;
    }

    @Override // kotlinx.serialization.json.b0
    public final String toString() {
        boolean r5 = this.f19445a;
        String r10 = this.f19446b;
        if (r5 == false) goto L6;
        StringBuilder r11 = new StringBuilder();
        kotlinx.serialization.json.internal.p.a(r11, r10);
        return r11.toString();
    L6:
        return r10;
    }
}
