package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.ss.android.lark.contact.export.ContactSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface k {

    public static final class a implements k {
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
            return -1603386757;
        }

        public final String toString() {
            return "AcceptFriend";
        }
    }

    public static final class b implements k {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ApplyFriend(message=" + this.a + ", alias=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "alias");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements k {
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
            return 1515035738;
        }

        public final String toString() {
            return "AvatarClick";
        }
    }

    public static final class d implements k {
        public final boolean a;

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
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "BlockUser(isBlock=" + this.a + ')';
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public static final class e implements k {
        public final GetDoubaoProfileResponse.CTAInfo a;

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
            return "CtaClick(cta=" + this.a + ')';
        }

        public e(GetDoubaoProfileResponse.CTAInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "cta");
            this.a = r2;
        }
    }

    public static final class f implements k {
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
            return -35074850;
        }

        public final String toString() {
            return "DeleteFriend";
        }
    }

    public static final class g implements k {
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
            return "DescriptionPhoneClick(phoneNumber=" + this.a + ')';
        }

        public g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "phoneNumber");
            this.a = r2;
        }
    }

    public static final class h implements k {
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
            return "DescriptionUrlClick(url=" + this.a + ')';
        }

        public h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }

    public static final class i implements k {
        public final String a;
        public final String b;
        public final ContactSource c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            ContactSource r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(userId=" + this.a + ", token=" + this.b + ", source=" + this.c + ')';
        }

        public i(String r1, String r2, ContactSource r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class j implements k {
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
            return "LeaderClick(leaderUserId=" + this.a + ')';
        }

        public j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "leaderUserId");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.k$k, reason: collision with other inner class name */
    public static final class C0119k implements k {
        public static final C0119k a = null;

        static {
            a = new C0119k();
        }

        public C0119k() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0119k) == true) goto L9;
            return false;
        L9:
            C0119k r4 = (C0119k) r3;
            return true;
        }

        public final int hashCode() {
            return 2052328629;
        }

        public final String toString() {
            return "NavigateToDoubaoHomepage";
        }
    }

    public static final class l implements k {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof l) == true) goto L9;
            return false;
        L9:
            l r4 = (l) r3;
            return true;
        }

        public final int hashCode() {
            return -125054171;
        }

        public final String toString() {
            return "QrCodeClick";
        }
    }

    public static final class m implements k {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof m) == true) goto L9;
            return false;
        L9:
            m r4 = (m) r3;
            return true;
        }

        public final int hashCode() {
            return -2012943858;
        }

        public final String toString() {
            return "Reload";
        }
    }

    public static final class n implements k {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof n) == true) goto L9;
            return false;
        L9:
            n r4 = (n) r3;
            return true;
        }

        public final int hashCode() {
            return -2012824151;
        }

        public final String toString() {
            return "Report";
        }
    }

    public static final class o implements k {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof o) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((o) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SaveAlias(alias=" + this.a + ')';
        }

        public o(String r2) {
            Intrinsics.checkNotNullParameter(r2, "alias");
            this.a = r2;
        }
    }

    public static final class p implements k {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof p) == true) goto L9;
            return false;
        L9:
            if (this.a == ((p) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetApplyFriendDialogVisible(visible=" + this.a + ')';
        }

        public p(boolean r1) {
            this.a = r1;
        }
    }

    public static final class q implements k {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof q) == true) goto L9;
            return false;
        L9:
            if (this.a == ((q) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetBlockedDialogVisible(visible=" + this.a + ')';
        }

        public q(boolean r1) {
            this.a = r1;
        }
    }

    public static final class r implements k {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof r) == true) goto L9;
            return false;
        L9:
            if (this.a == ((r) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetDeleteFriendDialogVisible(visible=" + this.a + ')';
        }

        public r(boolean r1) {
            this.a = r1;
        }
    }

    public static final class s implements k {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof s) == true) goto L9;
            return false;
        L9:
            if (this.a == ((s) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetDepartmentExpanded(expanded=" + this.a + ')';
        }

        public s() {
            this.a = true;
        }
    }

    public static final class t implements k {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof t) == true) goto L9;
            return false;
        L9:
            if (this.a == ((t) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetEditAliasDialogVisible(visible=" + this.a + ')';
        }

        public t(boolean r1) {
            this.a = r1;
        }
    }

    public static final class u implements k {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof u) == true) goto L9;
            return false;
        L9:
            if (this.a == ((u) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetReportPopupVisible(visible=" + this.a + ')';
        }

        public u(boolean r1) {
            this.a = r1;
        }
    }

    public static final class v implements k {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof v) == true) goto L9;
            return false;
        L9:
            v r4 = (v) r3;
            return true;
        }

        public final int hashCode() {
            return 371623295;
        }

        public final String toString() {
            return "ShareProfile";
        }
    }
}
