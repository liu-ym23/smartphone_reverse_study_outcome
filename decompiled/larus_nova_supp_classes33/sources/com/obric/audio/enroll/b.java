package com.obric.audio.enroll;

import com.obric.audio.enroll.view.EnrollStageView;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final AtomicReference<a> a = null;

    public static final class a {
        public final String a;
        public final com.obric.audio.enroll.a b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Pending(taskId=" + this.a + ", callback=" + this.b + ')';
        }

        public a(String r2, EnrollStageView r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new AtomicReference(null);
    }
}
