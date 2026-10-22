package l3;

import e3.g;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final WeakReference<g> e;

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final void a(a r10) {
        Intrinsics.checkNotNullParameter(r10, "aiBridgeEvent");
        String r0 = r10.d;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
    L13:
        String r12 = r10.e;
        if (r12 != null) goto L16;
    L19:
        if (r1 == false) goto L21;
    L23:
        g r13 = this.e.get();
        if (r13 == null) goto L27;
        r13.b(r10.a, r10.b);
        return;
    L27:
        return;
    L21:
        if (Intrinsics.areEqual(r10.e, this.a) == true) goto L23;
        return;
    L16:
        if (r12.length() == 0) goto L19;
        r1 = false;
        goto L19
    L11:
        if (Intrinsics.areEqual(r10.d, this.b) == true) goto L13;
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public final boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((r10 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((e) r10).a) == false) goto L19;
        String r11 = this.a;
        if (r11 != null) goto L13;
    L16:
        boolean r12 = true;
    L17:
        if (r12 == true) goto L19;
        return true;
    L13:
        if (r11.length() == 0) goto L16;
        r12 = false;
    L19:
        return false;
    }

    public /* synthetic */ e(g r10, String r11, String r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r15 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        long r16 = System.currentTimeMillis();
    L14:
        this(r10, r14, r15, r16, null);
        return;
    L13:
        r16 = 0;
        goto L14
    L9:
        r15 = r12;
        goto L11
    L5:
        r14 = r11;
        goto L7
    }

    public e(g r10, String r11, String r12, long r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "jsEventDelegate");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = new WeakReference(r10);
    }
}
