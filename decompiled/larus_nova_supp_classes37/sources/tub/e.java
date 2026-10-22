package tub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityStartMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingRejectReason;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class e {

    public static final class a extends e {
        public final String a;
        public final RecordingPriorityStartMode b;
        public final List<d> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "CanStart(sceneInstanceId=" + this.a + ", startMode=" + this.b + ", interruptInstances=" + this.c + ')';
        }

        public a(String r2, RecordingPriorityStartMode r3, List<d> r4) {
            Intrinsics.checkNotNullParameter(r2, "sceneInstanceId");
            Intrinsics.checkNotNullParameter(r3, "startMode");
            Intrinsics.checkNotNullParameter(r4, "interruptInstances");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends e {
        public final String a;
        public final RecordingRejectReason b;
        public final List<d> c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
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
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Reject(sceneInstanceId=" + this.a + ", reason=" + this.b + ", blockingInstances=" + this.c + ", errorDisplayMsg=" + this.d + ')';
        }

        public b(String r2, RecordingRejectReason r3, List<d> r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "sceneInstanceId");
            Intrinsics.checkNotNullParameter(r3, "reason");
            Intrinsics.checkNotNullParameter(r4, "blockingInstances");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public e() {
        RecordingPriorityStartMode r0 = RecordingPriorityStartMode.NORMAL;
    }
}
