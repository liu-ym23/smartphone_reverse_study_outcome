package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import com.bytedance.android.livesdk.interactivity.api.settings.config.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int e = 0;
    public final long a;
    public final int b;
    public final int c;
    public final int d;

    public static final class a {
        public static e a(p0 r7) {
            Intrinsics.checkNotNullParameter(r7, "localConfig");
            return new e(r7.d(), r7.e(), r7.c(), r7.b());
        }
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L14;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "PSSpeedAdaptConfig(updateInterval=" + this.a + ", updateScrollSize=" + this.b + ", updateFoldSize=" + this.c + ", scrollSpeed=" + this.d + ")";
    }

    public e(long r1, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
