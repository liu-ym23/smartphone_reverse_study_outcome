package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface v {

    public static final class a implements v {
        public final NexPulseResponseData a;

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
            return "Hit(response=" + this.a + ')';
        }

        public a(NexPulseResponseData r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a = r2;
        }
    }

    public static final class b implements v {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
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
            return 1601625825;
        }

        public final String toString() {
            return "Miss";
        }
    }

    public static final class c implements v {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Suppress(reason=null)";
        }
    }
}
