package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class r implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k {

    public static final class a extends r {
        public static final a a = null;

        static {
            a = new a();
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
            return -1236682910;
        }

        public final String toString() {
            return "DismissSaveSwitchTooltip";
        }

        public b() {
        }
    }

    public static final class c extends r {
        public final String a;

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
            return "HideSheet(reason=" + this.a + ')';
        }

        public c() {
            this("close");
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class d extends r {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l a;

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
            return "NavigateToSubtitle(request=" + this.a + ')';
        }

        public d(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            this.a = r2;
        }
    }

    public static final class e extends r {
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
            return -505831255;
        }

        public final String toString() {
            return "OpenCamera";
        }

        public e() {
        }
    }

    public static final class f extends r {
        public final MmAINoteHint a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.a == ((f) r4).a) goto L11;
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

        public f(MmAINoteHint r2) {
            Intrinsics.checkNotNullParameter(r2, "hint");
            this.a = r2;
        }
    }

    public static final class g extends r {
        public static final g a = null;

        static {
            a = new g();
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
            return 374054747;
        }

        public final String toString() {
            return "ShowSaveSwitchTooltip";
        }

        public g() {
        }
    }

    public static final class h extends r {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.a == ((h) r4).a) goto L11;
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
            return "ShowSheet(expandImmediately=" + this.a + ')';
        }

        public h(boolean r1) {
            this.a = r1;
        }
    }

    public r() {
    }
}
