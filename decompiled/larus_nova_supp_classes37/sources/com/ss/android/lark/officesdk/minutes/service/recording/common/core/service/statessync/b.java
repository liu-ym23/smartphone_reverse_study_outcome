package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b {

    public static final class a extends b {
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
            return 411324219;
        }

        public final String toString() {
            return "DefaultToast";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.b$b, reason: collision with other inner class name */
    public static final class C0027b extends b {
        public static final C0027b a = null;

        static {
            a = new C0027b();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0027b) == true) goto L9;
            return false;
        L9:
            C0027b r4 = (C0027b) r3;
            return true;
        }

        public final int hashCode() {
            return 609598462;
        }

        public final String toString() {
            return "NoKeyToast";
        }

        public C0027b() {
        }
    }

    public static final class c extends b {
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
            return -767945971;
        }

        public final String toString() {
            return "None";
        }

        public c() {
        }
    }

    public static final class d extends b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "QuotaDialog(denyType=" + this.a + ')';
        }

        public d(int r1) {
            this.a = r1;
        }
    }

    public static final class e extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ServerMessageToast(message=" + this.a + ')';
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
        }
    }

    public b() {
    }
}
