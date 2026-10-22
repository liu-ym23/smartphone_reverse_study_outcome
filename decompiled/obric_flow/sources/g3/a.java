package g3;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f17023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17024c;

    public a(String r5, String r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r5, "operation");
        this.f17022a = r5;
        this.f17023b = r11;
        this.f17024c = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f17022a;
        if (Intrinsics.areEqual(this.f17022a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17023b, r10.f17023b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17024c, r10.f17024c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f17022a.hashCode() * 31;
        int r10 = 0;
        Integer r11 = this.f17023b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.f17024c;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("UIOperation(operation=");
        r5.append(this.f17022a);
        r5.append(", id=");
        r5.append(this.f17023b);
        r5.append(", value=");
        return j0.p(r5, this.f17024c, ')');
    }
}
