package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c {
    public static final /* synthetic */ int b = 0;
    public final int a;

    public static final class a {
    }

    public static final class b extends c {
        public final EndRecordingReason c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.c == ((b) r4).c) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public b() {
            this(EndRecordingReason.OTHERS);
        }

        public final String toString() {
            return "EndRecording(endReason=" + this.c + ')';
        }

        public b(EndRecordingReason r2) {
            Intrinsics.checkNotNullParameter(r2, "endReason");
            super(8);
            this.c = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c$c, reason: collision with other inner class name */
    public static final class C0037c extends c {
        public static final C0037c c = null;

        static {
            c = new C0037c();
        }

        public C0037c() {
            super(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0037c) == true) goto L9;
            return false;
        L9:
            C0037c r4 = (C0037c) r3;
            return true;
        }

        public final int hashCode() {
            return -1723108791;
        }

        public final String toString() {
            return "Init";
        }
    }

    public static final class d extends c {
        public static final d c = null;

        static {
            c = new d();
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
            return -235307287;
        }

        public final String toString() {
            return "Interrupted";
        }

        public d() {
            super(12);
        }
    }

    public static final class e extends c {
        public static final e c = null;

        static {
            c = new e();
        }

        public e() {
            super(2);
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
            return 519798975;
        }

        public final String toString() {
            return "LocalRecording";
        }
    }

    public static final class f extends c {
        public static final f c = null;

        static {
            c = new f();
        }

        public f() {
            super(3);
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
            return 441888195;
        }

        public final String toString() {
            return "MeetingBinding";
        }
    }

    public static final class g extends c {
        public static final g c = null;

        static {
            c = new g();
        }

        public g() {
            super(4);
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
            return -88739780;
        }

        public final String toString() {
            return "MeetingBound";
        }
    }

    public static final class h extends c {
        public static final h c = null;

        static {
            c = new h();
        }

        public h() {
            super(7);
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
            return 2138586151;
        }

        public final String toString() {
            return "Paused";
        }
    }

    public static final class i extends c {
        public static final i c = null;

        static {
            c = new i();
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
            return -52693556;
        }

        public final String toString() {
            return "PostProcessing";
        }

        public i() {
            super(9);
        }
    }

    public static final class j extends c {
        public static final j c = null;

        static {
            c = new j();
        }

        public j() {
            super(1);
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
            return 1120398865;
        }

        public final String toString() {
            return "PreparingLocalRecording";
        }
    }

    public static final class k extends c {
        public static final k c = null;

        static {
            c = new k();
        }

        public k() {
            super(6);
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
            return -761082792;
        }

        public final String toString() {
            return "Recording";
        }
    }

    public static final class l extends c {
        public static final l c = null;

        static {
            c = new l();
        }

        public l() {
            super(5);
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
            return 416167792;
        }

        public final String toString() {
            return "RecordingCreated";
        }
    }

    public static final class m extends c {
        public final TerminateReason c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.c == ((m) r4).c) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.c.hashCode();
        }

        public final String toString() {
            return "Terminated(reason=" + this.c + ')';
        }

        public m(TerminateReason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            super(11);
            this.c = r2;
        }
    }

    public static final class n extends c {
        public static final n c = null;

        static {
            c = new n();
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
            return -1817745639;
        }

        public final String toString() {
            return "Uploaded";
        }

        public n() {
            super(10);
        }
    }

    static {
    }

    public final boolean a() {
        if ((this instanceof b) == false) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(this, i.c) == true) goto L11;
        if (Intrinsics.areEqual(this, n.c) == true) goto L11;
        if ((this instanceof m) == true) goto L11;
        return true;
    }

    public c(int r1) {
        this.a = r1;
    }
}
