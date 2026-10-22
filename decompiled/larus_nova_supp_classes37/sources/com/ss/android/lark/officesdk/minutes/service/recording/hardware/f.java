package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class f {

    public static final class a extends f {
        public final int a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Failed(code=" + this.a + ", message=" + this.b + ')';
        }

        public a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends f {
        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r5).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Success(recordingId=null)";
        }
    }

    public f() {
    }
}
