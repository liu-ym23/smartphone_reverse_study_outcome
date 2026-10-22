package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface e {

    public static final class a implements e {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
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
            return 1763533770;
        }

        public final String toString() {
            return "Failure";
        }
    }

    public static final class b implements e {
        public final MembershipQuotaSummaryDto a;

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
            return "Success(summary=" + this.a + ')';
        }

        public b(MembershipQuotaSummaryDto r2) {
            Intrinsics.checkNotNullParameter(r2, "summary");
            this.a = r2;
        }
    }
}
