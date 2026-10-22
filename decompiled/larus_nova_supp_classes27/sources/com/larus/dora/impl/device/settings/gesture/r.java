package com.larus.dora.impl.device.settings.gesture;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class r {

    public static final class a extends r {
        public static final a a = null;

        static {
            a = new a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return 283760619;
        }

        public final String toString() {
            return "Failed";
        }

        public a() {
        }
    }

    public static final class b extends r {
        public static final b a = null;

        static {
            a = new b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
            return true;
        }

        public final int hashCode() {
            return -281176318;
        }

        public final String toString() {
            return "Idle";
        }

        public b() {
        }
    }

    public static final class c extends r {
        public final LastSwitchSide a;
        public final List<DoraGGestureSettings> b;
        public final List<DoraGGestureSettings> c;
        public final List<DoraGGestureSettings> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Success(side=" + this.a + ", mediaList=" + this.b + ", callingList=" + this.c + ", aiList=" + this.d + ')';
        }

        public c(LastSwitchSide r2, List<DoraGGestureSettings> r3, List<DoraGGestureSettings> r4, List<DoraGGestureSettings> r5) {
            Intrinsics.checkNotNullParameter(r2, "side");
            Intrinsics.checkNotNullParameter(r3, "mediaList");
            Intrinsics.checkNotNullParameter(r4, "callingList");
            Intrinsics.checkNotNullParameter(r5, "aiList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public r() {
    }
}
