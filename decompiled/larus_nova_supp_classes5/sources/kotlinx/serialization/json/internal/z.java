package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class z implements q {
    public char[] a;
    public int b;

    public final void e() {
        i r0 = i.c;
        char[] r1 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "array");
        Intrinsics.checkNotNullParameter(r1, "array");
        monitor-enter(r0);
        int r2 = r0.b;     // Catch: Throwable -> L10
        if ((r1.length + r2) >= h.a) goto L7;
        r0.b = r2 + r1.length;     // Catch: Throwable -> L10
        r0.a.addLast(r1);     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        return new String(this.a, 0, this.b);
    }

    public z() {
        i r0 = i.c;
        monitor-enter(r0);
        char[] r1 = r0.a.removeLastOrNull();     // Catch: Throwable -> L14
        if (r1 == null) goto L8;
        r0.b -= r1.length;     // Catch: Throwable -> L14
    L9:
        monitor-exit(r0);
        if (r1 != null) goto L12;
        r1 = new char[128];
    L12:
        this.a = r1;
        return;
    L8:
        r1 = null;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void a(char r4) {
        d(this.b, 1);
        char[] r0 = this.a;
        int r1 = this.b;
        this.b = r1 + 1;
        r0[r1] = r4;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "text");
        int r0 = r6.length();
        if (r0 != 0) goto L5;
        return;
    L5:
        d(this.b, r0);
        r6.getChars(0, r6.length(), this.a, this.b);
        this.b += r0;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void c(String r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        d(this.b, r11.length() + 2);
        char[] r0 = this.a;
        int r2 = this.b;
        int r3 = r2 + 1;
        r0[r2] = '\"';
        int r4 = r11.length();
        r11.getChars(0, r4, r0, r3);
        int r5 = r4 + r3;
        int r6 = r3;
    L3:
        if (r6 >= r5) goto L25;
        char r7 = r0[r6];
        byte[] r8 = o0.b;
        if (r7 >= r8.length) goto L24;
        if (r8[r7] == 0) goto L24;
        int r1 = r6 - r3;
        int r9 = r11.length();
    L10:
        if (r1 >= r9) goto L22;
        d(r6, 2);
        char r10 = r11.charAt(r1);
        byte[] r12 = o0.b;
        if (r10 >= r12.length) goto L19;
        byte r13 = r12[r10];
        if (r13 != 0) goto L16;
        int r14 = r6 + 1;
        this.a[r6] = r10;
    L20:
        r6 = r14;
    L21:
        r1 = r1 + 1;
        goto L10
    L16:
        if (r13 != 1) goto L18;
        String r15 = o0.a[r10];
        Intrinsics.checkNotNull(r15);
        d(r6, r15.length());
        r15.getChars(0, r15.length(), this.a, r6);
        r6 = r6 + r15.length();
        this.b = r6;
        goto L21
    L18:
        char[] r16 = this.a;
        r16[r6] = '\\';
        r16[r6 + 1] = (char) r13;
        r6 = r6 + 2;
        this.b = r6;
        goto L21
    L19:
        r14 = r6 + 1;
        this.a[r6] = r10;
        goto L20
    L22:
        d(r6, 1);
        this.a[r6] = '\"';
        this.b = r6 + 1;
        return;
    L24:
        r6 = r6 + 1;
        goto L3
    L25:
        r0[r5] = '\"';
        this.b = r5 + 1;
    }

    @Override // kotlinx.serialization.json.internal.q
    public final void writeLong(long r1) {
        b(String.valueOf(r1));
    }

    public final void d(int r3, int r4) {
        int r5 = r4 + r3;
        char[] r0 = this.a;
        if (r0.length > r5) goto L6;
        this.a = Arrays.copyOf(r0, RangesKt.coerceAtLeast(r5, r3 * 2));
        return;
    }
}
