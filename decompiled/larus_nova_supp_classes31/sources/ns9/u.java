package ns9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.reach.api.ReachRejectReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class u {

    public static final class a extends u {
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
            return "Accepted(reachUniqueId=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
            this.a = r2;
        }
    }

    public static final class b extends u {
        public final String a;
        public final ReachRejectReason b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "Rejected(reachUniqueId=" + this.a + ", reason=" + this.b + ')';
        }

        public b(String r2, ReachRejectReason r3) {
            Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            this.a = r2;
            this.b = r3;
        }
    }

    public u() {
    }
}
