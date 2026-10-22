package com.larus.dora.impl.device.settings.lab.headdown;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.a$a, reason: collision with other inner class name */
    public static final class C0049a extends a {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0049a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0049a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "Calibrating(remainingSeconds=" + this.a + ')';
        }

        public C0049a(int r1) {
            this.a = r1;
        }
    }

    public static final class b extends a {
        public final HeadDownCalibrationFailureReason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failure(reason=" + this.a + ')';
        }

        public b(HeadDownCalibrationFailureReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class c extends a {
        public static final c a = null;

        static {
            a = new c();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return -2122688393;
        }

        public final String toString() {
            return "Intro";
        }

        public c() {
        }
    }

    public static final class d extends a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "Preparing(remainingSeconds=" + this.a + ", progress=" + this.b + ')';
        }

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e extends a {
        public static final e a = null;

        static {
            a = new e();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof e) == true) goto L9;
            return false;
        L9:
            e r4 = (e) r3;
            return true;
        }

        public final int hashCode() {
            return 675273550;
        }

        public final String toString() {
            return "Success";
        }

        public e() {
        }
    }

    public a() {
    }
}
