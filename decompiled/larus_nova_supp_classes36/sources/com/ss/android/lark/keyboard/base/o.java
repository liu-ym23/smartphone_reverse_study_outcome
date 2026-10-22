package com.ss.android.lark.keyboard.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o {
    public static final a f = null;
    public final long a;
    public final boolean b;
    public final p c;
    public final String d;
    public final boolean e;

    public static final class a implements n.a<o> {
        public a() {
        }
    }

    static {
        f = new a();
    }

    public o() {
        this(0);
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r1 + r3) * 31;
        p r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d.hashCode()) * 31;
        if (this.e == true) goto L15;
        r2 = 1237;
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScheduleInfo(selectedTime=" + this.a + ", is24HourClock=" + this.b + ", sceneData=" + this.c + ", scheduleMessageId=" + this.d + ", isPreScheduleMessage=" + this.e + ')';
    }

    public /* synthetic */ o(int r8) {
        this(0, false, null, "", false);
    }

    public final boolean equals(Object r7) {
        if ((r7 instanceof o) == true) goto L5;
        return false;
    L5:
        o r8 = (o) r7;
        if (this.a == r8.a) goto L8;
        return false;
    L8:
        if (this.b == r8.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r8.d) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public o(long r2, boolean r4, p r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "scheduleMessageId");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
