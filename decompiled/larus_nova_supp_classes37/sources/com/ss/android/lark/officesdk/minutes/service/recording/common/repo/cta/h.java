package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class h {

    public static final class a extends h {
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
            return -459055362;
        }

        public final String toString() {
            return "NotReady";
        }

        public a() {
        }
    }

    public static final class b extends h {
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
            return 1003316954;
        }

        public final String toString() {
            return "QuotaEnough";
        }

        public b() {
        }
    }

    public static final class c extends h {
        public final MmQuotaType a;
        public final MmQuotaData b;
        public final MmRecordingQuotaCtaScene c;
        public final MmRecordingQuotaCtaRenderType d;

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
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "QuotaUnavailable(quotaType=" + this.a + ", quotaData=" + this.b + ", scene=" + this.c + ", renderType=" + this.d + ')';
        }

        public c(MmQuotaType r2, MmQuotaData r3, MmRecordingQuotaCtaScene r4, MmRecordingQuotaCtaRenderType r5) {
            Intrinsics.checkNotNullParameter(r2, "quotaType");
            Intrinsics.checkNotNullParameter(r3, "quotaData");
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r5, "renderType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class d extends h {
        public final MmQuotaType a;
        public final MmQuotaData b;
        public final MmRecordingQuotaCtaScene c;
        public final MmRecordingQuotaCtaRenderType d;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Upgrade(quotaType=" + this.a + ", quotaData=" + this.b + ", scene=" + this.c + ", renderType=" + this.d + ')';
        }

        public d(MmQuotaType r2, MmQuotaData r3, MmRecordingQuotaCtaScene r4, MmRecordingQuotaCtaRenderType r5) {
            Intrinsics.checkNotNullParameter(r2, "quotaType");
            Intrinsics.checkNotNullParameter(r3, "quotaData");
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r5, "renderType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public h() {
    }
}
