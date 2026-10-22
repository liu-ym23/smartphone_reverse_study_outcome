package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import android.view.ViewGroup;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class g implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends g {
        public static final a a = null;

        static {
            a = new a();
        }

        public final String toString() {
            return "AIInterpretationClick";
        }

        public a() {
        }
    }

    public static final class b extends g {
        public static final b a = null;

        static {
            a = new b();
        }

        public final String toString() {
            return "AIInterpretationHeadsetDialogDismissed";
        }

        public b() {
        }
    }

    public static final class c extends g {
        public static final c a = null;

        static {
            a = new c();
        }

        public final String toString() {
            return "AIInterpretationSwitchTipRequested";
        }

        public c() {
        }
    }

    public static final class d extends g {
        public static final d a = null;

        static {
            a = new d();
        }

        public final String toString() {
            return "AudioSaveBoardingShown";
        }

        public d() {
        }
    }

    public static final class e extends g {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends g {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g$g, reason: collision with other inner class name */
    public static final class C0062g extends g {
        public final MmRecordingAutoSaveDecisionScene a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0062g) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0062g) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AutoSaveDialogClosed(scene=" + this.a + ')';
        }

        public C0062g(MmRecordingAutoSaveDecisionScene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.a = r2;
        }
    }

    public static final class h extends g {
        public final POIInfo a;

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
            return "ChooseLocation(poiInfo=" + this.a + ')';
        }

        public h(POIInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "poiInfo");
            this.a = r2;
        }
    }

    public static final class i extends g {
        public static final i a = null;

        static {
            a = new i();
        }

        public final String toString() {
            return "LanguageClick";
        }

        public i() {
        }
    }

    public static final class j extends g {
        public static final j a = null;

        static {
            a = new j();
        }

        public final String toString() {
            return "PauseResumeClick";
        }

        public j() {
        }
    }

    public static final class k extends g {
        public final ViewGroup a;

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
            return "RegisterLocationMapContainer";
        }

        public k(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.a = r2;
        }
    }

    public static final class l extends g {
        public static final l a = null;

        static {
            a = new l();
        }

        public final String toString() {
            return "RequestLocation";
        }

        public l() {
        }
    }

    public static final class m extends g {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((m) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SelectAIInterpretationLanguage(language=" + this.a + ')';
        }

        public m(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r2) {
            Intrinsics.checkNotNullParameter(r2, "language");
            this.a = r2;
        }
    }

    public static final class n extends g {
        public final boolean a;
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof n) == true) goto L8;
            return false;
        L8:
            n r6 = (n) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "SetAIInterpretationEnabled(enabled=" + this.a + ", language=" + this.b + ')';
        }

        public n(boolean r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3) {
            Intrinsics.checkNotNullParameter(r3, "language");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class o extends g {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof o) == true) goto L9;
            return false;
        L9:
            if (this.a == ((o) r4).a) goto L11;
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
            return "SetAudioSaveType(isSave=" + this.a + ')';
        }

        public o(boolean r1) {
            this.a = r1;
        }
    }

    public static final class p extends g {
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
            return "SetBilingual(enabled=" + this.a + ')';
        }

        public p(boolean r1) {
            this.a = r1;
        }
    }

    public static final class q extends g {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof q) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((q) r4).a) == true) goto L11;
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

        public q(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r2) {
            Intrinsics.checkNotNullParameter(r2, "language");
            this.a = r2;
        }
    }

    public static final class r extends g {
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof r) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((r) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SetTranslateLanguage(language=" + this.a + ')';
        }

        public r(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r2) {
            Intrinsics.checkNotNullParameter(r2, "language");
            this.a = r2;
        }
    }

    public static final class s extends g {
        public static final s a = null;

        static {
            a = new s();
        }

        public final String toString() {
            return "StopRecordingClick";
        }

        public s() {
        }
    }

    public static final class t extends g {
        public final MmRecordingUITab a;

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
            return this.a.hashCode();
        }

        public final String toString() {
            return "SwitchTab(tab=" + this.a + ')';
        }

        public t(MmRecordingUITab r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
            this.a = r2;
        }
    }

    public static final class u extends g {
        public final ViewGroup a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof u) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((u) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UnregisterLocationMapContainer";
        }

        public u(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.a = r2;
        }
    }

    public static final class v extends g {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof v) == true) goto L8;
            return false;
        L8:
            v r6 = (v) r5;
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
            return "UpdateTitle(oldTitle=" + this.a + ", title=" + this.b + ')';
        }

        public v(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "oldTitle");
            Intrinsics.checkNotNullParameter(r3, "title");
            this.a = r2;
            this.b = r3;
        }
    }

    public g() {
    }
}
