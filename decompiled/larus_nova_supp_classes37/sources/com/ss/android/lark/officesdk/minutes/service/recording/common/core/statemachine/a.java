package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a$a, reason: collision with other inner class name */
    public static final class C0036a extends a {
        public static final C0036a a = null;

        static {
            a = new C0036a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0036a) == true) goto L9;
            return false;
        L9:
            C0036a r4 = (C0036a) r3;
            return true;
        }

        public final int hashCode() {
            return 908255335;
        }

        public final String toString() {
            return "LocalRecordingPreparedEvent";
        }

        public C0036a() {
        }
    }

    public static final class b extends a {
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
            return -3478193;
        }

        public final String toString() {
            return "LocalRecordingStartedEvent";
        }

        public b() {
        }
    }

    public static final class c extends a {
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
            return 869266823;
        }

        public final String toString() {
            return "MeetingBoundEvent";
        }

        public c() {
        }
    }

    public static final class d extends a {
        public final TerminateReason a;

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
            return this.a.hashCode();
        }

        public final String toString() {
            return "MeetingCreateFailedEvent(reason=" + this.a + ')';
        }

        public d() {
            this(TerminateReason.MEETING_CREATED_FAILED);
        }

        public d(TerminateReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class e extends a {
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
            return 1952136093;
        }

        public final String toString() {
            return "MeetingCreatedEvent";
        }

        public e() {
        }
    }

    public static final class f extends a {
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
            return -628466824;
        }

        public final String toString() {
            return "RecordingInterruptEvent";
        }

        public f() {
        }
    }

    public static final class g extends a {
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
            return 1975130315;
        }

        public final String toString() {
            return "RecordingInterruptResumeEvent";
        }

        public g() {
        }
    }

    public static final class h extends a {
        public static final h a = null;

        static {
            a = new h();
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
            return -876670907;
        }

        public final String toString() {
            return "RecordingPauseEvent";
        }

        public h() {
        }
    }

    public static final class i extends a {
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
            return 695051404;
        }

        public final String toString() {
            return "RecordingResumeEvent";
        }

        public i() {
        }
    }

    public static final class j extends a {
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
            return -456435622;
        }

        public final String toString() {
            return "RecordingStartedEvent";
        }

        public j() {
        }
    }

    public static final class k extends a {
        public final EndRecordingReason a;

        public k(EndRecordingReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class l extends a {
        public static final l a = null;

        static {
            a = new l();
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
            return 2035916141;
        }

        public final String toString() {
            return "StartCreateMeetingEvent";
        }

        public l() {
        }
    }

    public static final class m extends a {
        public static final m a = null;

        static {
            a = new m();
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
            return -932099317;
        }

        public final String toString() {
            return "StartUploadingEvent";
        }

        public m() {
        }
    }

    public static final class n extends a {
        public final TerminateReason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof n) == true) goto L9;
            return false;
        L9:
            if (this.a == ((n) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "TerminateSessionEvent(reason=" + this.a + ')';
        }

        public n(TerminateReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public static final class o extends a {
        public static final o a = null;

        static {
            a = new o();
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
            return 1463479862;
        }

        public final String toString() {
            return "UploadFinishEvent";
        }

        public o() {
        }
    }

    public a() {
    }
}
