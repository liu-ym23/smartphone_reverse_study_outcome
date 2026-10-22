package com.ss.android.lark.profile_office.userprofile;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface j {

    public static final class a implements j {
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
            return -122149773;
        }

        public final String toString() {
            return "Finish";
        }
    }

    public static final class b implements j {
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
            return 1752258400;
        }

        public final String toString() {
            return "NavigateToDoubaoHomepage";
        }
    }

    public static final class c implements j {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
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
            return 1215234597;
        }

        public final String toString() {
            return "OpenAvatarPreview";
        }
    }

    public static final class d implements j {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenChat(chatterId=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "chatterId");
            this.a = r2;
        }
    }

    public static final class e implements j {
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
            return "OpenDescriptionPhone(phoneNumber=" + this.a + ')';
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "phoneNumber");
            this.a = r2;
        }
    }

    public static final class f implements j {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenDescriptionUrl(url=" + this.a + ')';
        }

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }

    public static final class g implements j {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenLeaderProfile(userId=" + this.a + ')';
        }

        public g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }
    }

    public static final class h implements j {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof h) == true) goto L9;
            return false;
        L9:
            h r4 = (h) r3;
            return true;
        }

        public final int hashCode() {
            return 1035169063;
        }

        public final String toString() {
            return "OpenQrCodePage";
        }
    }

    public static final class i implements j {
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
            return 97474477;
        }

        public final String toString() {
            return "OpenReportPage";
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.j$j, reason: collision with other inner class name */
    public static final class C0118j implements j {
        public static final C0118j a = null;

        static {
            a = new C0118j();
        }

        public C0118j() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0118j) == true) goto L9;
            return false;
        L9:
            C0118j r4 = (C0118j) r3;
            return true;
        }

        public final int hashCode() {
            return 1966487722;
        }

        public final String toString() {
            return "ShareProfile";
        }
    }

    public static final class k implements j {
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
            return "ShowToast(message=" + this.a + ')';
        }

        public k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
        }
    }
}
