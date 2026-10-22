package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface l {
    public static final d a = null;

    public static final class a implements l {
        public static final a b = null;

        static {
            b = new a();
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
            return 1364110770;
        }

        public final String toString() {
            return "Alias";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            return !r2.u();
        }
    }

    public static final class b implements l {
        public static final b b = null;

        static {
            b = new b();
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
            return 1365040111;
        }

        public final String toString() {
            return "Block";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (r2.c == true) goto L5;
        L13:
            return false;
        L5:
            if (r2.u() == true) goto L13;
            if (r2.t() == true) goto L13;
            if (r2.s() == true) goto L13;
            if (r2.p() == true) goto L13;
            return true;
        }
    }

    public static final class c implements l {
        public static final c b = null;

        static {
            b = new c();
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
            return -510128695;
        }

        public final String toString() {
            return "City";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            if (r3.d == true) goto L5;
            return false;
        L5:
            if (r3.o() == true) goto L7;
            return false;
        L7:
            if (r3.c().length() <= 0) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == false) goto L15;
            return true;
        L15:
            return false;
        L9:
            r4 = false;
            goto L10
        }
    }

    public static final class d {
        public static final /* synthetic */ d a = null;
        public static final Set<l> b = null;

        public d() {
        }

        static {
            a = new d();
            b = SetsKt.setOf(new l[]{j.b, o.b, i.b, m.b, e.b, g.b, C0120l.b, c.b, h.b, a.b, n.b, b.b, f.b, k.b});
        }
    }

    public static final class e implements l {
        public static final e b = null;

        static {
            b = new e();
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
            return 260639218;
        }

        public final String toString() {
            return "Cta";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (r2.c == true) goto L5;
        L7:
            return false;
        L5:
            if ((!r2.e().isEmpty()) == false) goto L7;
            return true;
        }
    }

    public static final class f implements l {
        public static final f b = null;

        static {
            b = new f();
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
            return -1741060473;
        }

        public final String toString() {
            return "DeleteFriend";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            if (r5.c == true) goto L5;
            return false;
        L5:
            if (r5.u() == false) goto L7;
            return false;
        L7:
            if (r5.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL) goto L9;
            boolean r0 = true;
        L10:
            if (r0 == true) goto L12;
            return false;
        L12:
            if (r5.t() == false) goto L14;
            return false;
        L14:
            if (r5.s() == false) goto L16;
            return false;
        L16:
            if (r5.p() == true) goto L24;
            return true;
        L24:
            return false;
        L9:
            r0 = false;
            goto L10
        }
    }

    public static final class g implements l {
        public static final g b = null;

        static {
            b = new g();
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
            return 1620736304;
        }

        public final String toString() {
            return "Department";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (r2.d == true) goto L5;
        L9:
            return false;
        L5:
            if (r2.o() == false) goto L9;
            if ((!r2.h.isEmpty()) == false) goto L9;
            return true;
        }
    }

    public static final class h implements l {
        public static final h b = null;

        static {
            b = new h();
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
            return 683532146;
        }

        public final String toString() {
            return "DoubaoHomepage";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (r2.d == false) goto L5;
        L7:
            return false;
        L5:
            if (r2.r() == false) goto L7;
            return true;
        }
    }

    public static final class i implements l {
        public static final i b = null;

        static {
            b = new i();
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
            return -1408566323;
        }

        public final String toString() {
            return "DoubaoNumber";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            return r2.r();
        }
    }

    public static final class j implements l {
        public static final j b = null;

        static {
            b = new j();
        }

        public j() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof j) == true) goto L9;
            return false;
        L9:
            j r4 = (j) r3;
            return true;
        }

        public final int hashCode() {
            return -1411086284;
        }

        public final String toString() {
            return "FriendApplication";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (r2.c == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE) goto L7;
            return true;
        }
    }

    public static final class k implements l {
        public static final k b = null;

        static {
            b = new k();
        }

        public k() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof k) == true) goto L9;
            return false;
        L9:
            k r4 = (k) r3;
            return true;
        }

        public final int hashCode() {
            return -983196744;
        }

        public final String toString() {
            return "Friendship";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            if (r3.c == true) goto L5;
        L17:
            return false;
        L5:
            if (r3.u() == true) goto L17;
            if (r3.s() == true) goto L17;
            if (r3.p() == true) goto L17;
            if (r3.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_FORWARD) goto L13;
        L16:
            return true;
        L13:
            if (r3.d() == GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE) goto L16;
            if (r3.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_NONE) goto L17;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.l$l, reason: collision with other inner class name */
    public static final class C0120l implements l {
        public static final C0120l b = null;

        static {
            b = new C0120l();
        }

        public C0120l() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0120l) == true) goto L9;
            return false;
        L9:
            C0120l r4 = (C0120l) r3;
            return true;
        }

        public final int hashCode() {
            return -354018841;
        }

        public final String toString() {
            return "Leader";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            if (r4.d == true) goto L5;
            return false;
        L5:
            if (r4.o() == true) goto L7;
            return false;
        L7:
            if (r4.i().length() <= 0) goto L9;
            boolean r0 = true;
        L10:
            if (r0 == true) goto L12;
            return false;
        L12:
            if (r4.h().length() <= 0) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == false) goto L21;
            return true;
        L21:
            return false;
        L14:
            r5 = false;
            goto L15
        L9:
            r0 = false;
            goto L10
        }
    }

    public static final class m implements l {
        public static final m b = null;

        static {
            b = new m();
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
            return -199750516;
        }

        public final String toString() {
            return "QrCode";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            if (r3.c == false) goto L9;
            i.b.getClass();
            Intrinsics.checkNotNullParameter(r3, "state");
            if (r3.r() == false) goto L9;
            if (r3.u() == false) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class n implements l {
        public static final n b = null;

        static {
            b = new n();
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
            return 1380607809;
        }

        public final String toString() {
            return "Share";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            if (r4.c == true) goto L5;
            return false;
        L5:
            if (r4.u() == false) goto L7;
        L11:
            return true;
        L7:
            if (r4.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == true) goto L11;
            return false;
        L9:
            r5 = false;
            goto L10
        }
    }

    public static final class o implements l {
        public static final o b = null;

        static {
            b = new o();
        }

        public o() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof o) == true) goto L9;
            return false;
        L9:
            o r4 = (o) r3;
            return true;
        }

        public final int hashCode() {
            return -829713834;
        }

        public final String toString() {
            return "TenantInfo";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            if (r4.j().length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
        L19:
            return true;
        L8:
            if (r4.s() == false) goto L10;
        L17:
            boolean r5 = true;
        L18:
            if (r5 == true) goto L19;
            return false;
        L10:
            if (r4.p() == true) goto L17;
            if (r4.m == true) goto L17;
            if (r4.n() == true) goto L17;
            r5 = false;
            goto L18
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        a = d.a;
    }

    boolean a(OfficeProfileState r1);
}
