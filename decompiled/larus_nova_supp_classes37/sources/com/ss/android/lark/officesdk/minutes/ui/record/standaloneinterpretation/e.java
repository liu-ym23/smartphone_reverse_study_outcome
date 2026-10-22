package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class e implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends e {
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
            return -1552342203;
        }

        public final String toString() {
            return "BackClick";
        }

        public a() {
        }
    }

    public static final class b extends e {
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
            return 383219965;
        }

        public final String toString() {
            return "BindSession";
        }

        public b() {
        }
    }

    public static final class c extends e {
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
            return 739582324;
        }

        public final String toString() {
            return "LanguageClick";
        }

        public c() {
        }
    }

    public static final class d extends e {
        public static final d a = null;

        static {
            a = new d();
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
            return 1165187745;
        }

        public final String toString() {
            return "PauseResumeClick";
        }

        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.e$e, reason: collision with other inner class name */
    public static final class C0070e extends e {
        public final MmStandaloneAIInterpretationLanguageSide a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0070e) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0070e) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SelectLanguageSide(side=" + this.a + ')';
        }

        public C0070e(MmStandaloneAIInterpretationLanguageSide r2) {
            Intrinsics.checkNotNullParameter(r2, "side");
            this.a = r2;
        }
    }

    public static final class f extends e {
        public final boolean a;

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
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetBilingual(enabled=" + this.a + ')';
        }

        public f(boolean r1) {
            this.a = r1;
        }
    }

    public static final class g extends e {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.a == ((g) r4).a) goto L11;
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
            return "SetSaveArtifactType(saveArtifactType=" + this.a + ')';
        }

        public g(boolean r1) {
            this.a = r1;
        }
    }

    public static final class h extends e {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c a;

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
            return "SetSpokenLanguage(language=" + this.a + ')';
        }

        public h(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2) {
            Intrinsics.checkNotNullParameter(r2, "language");
            this.a = r2;
        }
    }

    public static final class i extends e {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c a;

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
            return "SetTargetLanguage(language=" + this.a + ')';
        }

        public i(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2) {
            Intrinsics.checkNotNullParameter(r2, "language");
            this.a = r2;
        }
    }

    public static final class j extends e {
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
            return -1098483739;
        }

        public final String toString() {
            return "SpeakerClick";
        }

        public j() {
        }
    }

    public static final class k extends e {
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
            return -1257383670;
        }

        public final String toString() {
            return "StopClick";
        }

        public k() {
        }
    }

    public e() {
    }
}
