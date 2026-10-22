package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
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
            return "OnFishBonePageVisibilityChanged(resumed=" + this.a + ')';
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b$b, reason: collision with other inner class name */
    public static final class C0068b extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0068b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0068b) r4).a) goto L11;
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
            return "OnFishBoneThemeChanged(isDarkMode=" + this.a + ')';
        }

        public C0068b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c extends b {
        public final Context a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
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
            return "OnFishBoneWebContextAttached(source=" + this.b + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public c(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter("onAttach", "source");
            this.a = r3;
            this.b = "onAttach";
        }
    }

    public static final class d extends b {
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
            return "OnFishBoneWebContextDetached(source=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.a = r2;
        }
    }

    public static final class e extends b {
        public final long a;
        public final String b;
        public final int c;
        public final int d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof e) == true) goto L8;
            return false;
        L8:
            e r9 = (e) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "OnFishBoneWebScrollRequested(requestId=" + this.a + ", direction=" + this.b + ", xDp=" + this.c + ", yDp=" + this.d + ')';
        }

        public e(long r2, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "direction");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class f extends b {
        public final Context a;
        public final boolean b;
        public final String c;
        public final Throwable d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
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
            Context r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return ((((r2 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnFishBoneWebViewAttachFailed(retry=" + this.b + ", source=" + this.c + ", error=" + this.d.getClass().getSimpleName() + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public f(Context r2, boolean r3, String r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r4, "source");
            Intrinsics.checkNotNullParameter(r5, "error");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class g extends b {
        public final Context a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "OnFishBoneWebViewCreated(isDarkMode=" + this.b + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public g(Context r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class h extends b {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "OnFishBoneWebVisibilityChanged(visible=" + this.a + ", forceNotify=" + this.b + ')';
        }

        public h(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OnNewContentViewed(source=" + this.a + ')';
        }

        public i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.a = r2;
        }
    }

    public static final class j extends b {
        public static final j a = null;

        static {
            a = new j();
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
            return -935932364;
        }

        public final String toString() {
            return "OnQuotaCtaActionClick";
        }

        public j() {
        }
    }

    public static final class k extends b {
        public static final k a = null;

        static {
            a = new k();
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
            return -1863687782;
        }

        public final String toString() {
            return "OnQuotaCtaBenefitCenterClick";
        }

        public k() {
        }
    }

    public static final class l extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof l) == true) goto L9;
            return false;
        L9:
            if (this.a == ((l) r4).a) goto L11;
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
            return "OnQuotaCtaVisible(forceTrack=" + this.a + ')';
        }

        public l(boolean r1) {
            this.a = r1;
        }
    }

    public static final class m extends b {
        public final MmSummaryViewType a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.a == ((m) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OnSwitchViewType(viewType=" + this.a + ')';
        }

        public m(MmSummaryViewType r2) {
            Intrinsics.checkNotNullParameter(r2, "viewType");
            this.a = r2;
        }
    }

    public static final class n extends b {
        public static final n a = null;

        static {
            a = new n();
        }

        public final String toString() {
            return "OnViewCreated";
        }

        public n() {
        }
    }

    public b() {
    }
}
