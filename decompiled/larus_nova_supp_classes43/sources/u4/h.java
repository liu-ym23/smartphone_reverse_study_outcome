package u4;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final String a;
    public final String b;
    public final boolean c;
    public final WeakReference<a> d;

    public final int hashCode() {
        return (this.a + this.b + this.c).hashCode();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.a);
        r0.append(' ');
        r0.append(this.b);
        r0.append(' ');
        r0.append(this.c);
        r0.append(' ');
        WeakReference<a> r1 = this.d;
        if (r1 == null) goto L5;
        a r10 = r1.get();
    L6:
        r0.append(r10);
        return r0.toString();
    L5:
        r10 = null;
        goto L6
    }

    public final boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        if (Intrinsics.areEqual(r11.a, this.a) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r11.b, this.b) == true) goto L13;
        return false;
    L13:
        if (r11.c != this.c) goto L26;
        WeakReference<a> r12 = r11.d;
        a r1 = null;
        if (r12 == null) goto L17;
        a r13 = r12.get();
    L18:
        WeakReference<a> r14 = this.d;
        if (r14 == null) goto L21;
        r1 = r14.get();
    L21:
        if (r13 != r1) goto L27;
        return true;
    L27:
        return false;
    L17:
        r13 = null;
        goto L18
    L26:
        return false;
    }

    public h(String r10, String r11, boolean r12, WeakReference<a> r13) {
        Intrinsics.checkNotNullParameter(r10, "mappingStorage");
        Intrinsics.checkNotNullParameter(r11, "eventName");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
