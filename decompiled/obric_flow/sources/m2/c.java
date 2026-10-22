package m2;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19978c;
    public final WeakReference d;

    public c(String r5, String r10, boolean r11, WeakReference r12) {
        Intrinsics.checkNotNullParameter(r5, "mappingStorage");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.f19976a = r5;
        this.f19977b = r10;
        this.f19978c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        if (Intrinsics.areEqual(r10.f19976a, this.f19976a) == true) goto L11;
    L24:
        return false;
    L11:
        if (Intrinsics.areEqual(r10.f19977b, this.f19977b) == false) goto L24;
        if (r10.f19978c != this.f19978c) goto L24;
        a r11 = null;
        WeakReference r12 = r10.d;
        if (r12 == null) goto L17;
        a r13 = (a) r12.get();
    L18:
        WeakReference r14 = this.d;
        if (r14 == null) goto L21;
        r11 = (a) r14.get();
    L21:
        if (r13 != r11) goto L24;
        return true;
    L17:
        r13 = null;
        goto L18
    }

    public final int hashCode() {
        return (this.f19976a + this.f19977b + this.f19978c).hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f19976a);
        r5.append(' ');
        r5.append(this.f19977b);
        r5.append(' ');
        r5.append(this.f19978c);
        r5.append(' ');
        WeakReference r10 = this.d;
        if (r10 == null) goto L5;
        a r11 = (a) r10.get();
    L6:
        r5.append(r11);
        return r5.toString();
    L5:
        r11 = null;
        goto L6
    }
}
