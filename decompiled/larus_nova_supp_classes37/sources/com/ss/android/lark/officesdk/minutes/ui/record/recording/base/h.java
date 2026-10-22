package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class h implements k {

    public static final class a extends h {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "RecordingEnded(recordingId=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "recordingId");
            this.a = r2;
        }
    }

    public static final class b extends h {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowAIInterpretationHeadsetDialog(content=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.a = r2;
        }
    }

    public static final class c extends h {
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
            return -189028216;
        }

        public final String toString() {
            return "ShowAIInterpretationSwitchTipBubble";
        }

        public c() {
        }
    }

    public static final class d extends h {
        public final com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b a;

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
            return "ShowAutoSaveDialog(info=" + this.a + ')';
        }

        public d(com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            this.a = r2;
        }
    }

    public static final class e extends h {
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
            return 1076701856;
        }

        public final String toString() {
            return "ShowAutoTranslationTipBubble";
        }

        public e() {
        }
    }

    public static final class f extends h {
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
            return "ShowFirstMarkTooltip(message=" + this.a + ')';
        }

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
        }
    }

    public static final class g extends h {
        public final svb.a a;

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
            return "ShowToast(event=" + this.a + ')';
        }

        public g(svb.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.h$h, reason: collision with other inner class name */
    public static final class C0063h extends h {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0063h) == true) goto L8;
            return false;
        L8:
            C0063h r6 = (C0063h) r5;
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
            return "UpdateTitleFailed(originalTitle='" + this.a + "')";
        }

        public C0063h(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "originalTitle");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class i extends h {
        public static final i a = null;

        static {
            a = new i();
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
            return 811474385;
        }

        public final String toString() {
            return "Vibrate";
        }

        public i() {
        }
    }

    public h() {
    }
}
