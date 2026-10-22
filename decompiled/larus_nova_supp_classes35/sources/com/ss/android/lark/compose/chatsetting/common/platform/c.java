package com.ss.android.lark.compose.chatsetting.common.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
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
            return -1030014494;
        }

        public final String toString() {
            return "BlockedByOther";
        }
    }

    public static final class b implements c {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
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
            return 2136181082;
        }

        public final String toString() {
            return "BlockedOthers";
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.common.platform.c$c, reason: collision with other inner class name */
    public static final class C0129c implements c {
        public static final C0129c a = null;

        static {
            a = new C0129c();
        }

        public C0129c() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0129c) == true) goto L9;
            return false;
        L9:
            C0129c r4 = (C0129c) r3;
            return true;
        }

        public final int hashCode() {
            return 19740967;
        }

        public final String toString() {
            return "ClearHistorySuccess";
        }
    }

    public static final class d implements c {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof d) == true) goto L9;
            return false;
        L9:
            d r4 = (d) r3;
            return true;
        }

        public final int hashCode() {
            return -1068275787;
        }

        public final String toString() {
            return "GeneralError";
        }
    }

    public static final class e implements c {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
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
            return -1175779915;
        }

        public final String toString() {
            return "GroupCannotBeShared";
        }
    }

    public static final class f implements c {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof f) == true) goto L9;
            return false;
        L9:
            f r4 = (f) r3;
            return true;
        }

        public final int hashCode() {
            return -138536617;
        }

        public final String toString() {
            return "GroupInfoEditNotAllowed";
        }
    }

    public static final class g implements c {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof g) == true) goto L9;
            return false;
        L9:
            g r4 = (g) r3;
            return true;
        }

        public final int hashCode() {
            return 155647794;
        }

        public final String toString() {
            return "MovedToMuted";
        }
    }

    public static final class h implements c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NeedAddContact(chatterName=" + this.a + ')';
        }

        public h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "chatterName");
            this.a = r2;
        }
    }

    public static final class i implements c {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof i) == true) goto L9;
            return false;
        L9:
            i r4 = (i) r3;
            return true;
        }

        public final int hashCode() {
            return 126862060;
        }

        public final String toString() {
            return "NeedAddContactFallback";
        }
    }

    public static final class j implements c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((j) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Text(value=" + this.a + ')';
        }

        public j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.a = r2;
        }
    }

    public static final class k implements c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof k) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((k) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UdText(value=" + this.a + ')';
        }

        public k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.a = r2;
        }
    }
}
