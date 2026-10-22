package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class j implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends j {
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
            return 803806975;
        }

        public final String toString() {
            return "ContentHeightChanged";
        }

        public a() {
        }
    }

    public static final class b extends j {
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
            return -588010445;
        }

        public final String toString() {
            return "DismissSaveSwitchTooltip";
        }

        public b() {
        }
    }

    public static final class c extends j {
        public final l a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NavigateToSubtitleRequested(request=" + this.a + ')';
        }

        public c(l r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            this.a = r2;
        }
    }

    public static final class d extends j {
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
            return "RequestCloseSheet(reason=" + this.a + ')';
        }

        public d() {
            Intrinsics.checkNotNullParameter("go_to_subtitle", "reason");
            this.a = "go_to_subtitle";
        }
    }

    public static final class e extends j {
        public final MmRecordingAINoteHint a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.a == ((e) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowHint(hint=" + this.a + ')';
        }

        public e(MmRecordingAINoteHint r2) {
            Intrinsics.checkNotNullParameter(r2, "hint");
            this.a = r2;
        }
    }

    public static final class f extends j {
        public static final f a = null;

        static {
            a = new f();
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
            return -353549270;
        }

        public final String toString() {
            return "ShowSaveSwitchTooltip";
        }

        public f() {
        }
    }

    public j() {
    }
}
