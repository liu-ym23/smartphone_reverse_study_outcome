package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class l {

    public static final class a extends l {
        public final long a;
        public final boolean b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            if (this.b == false) goto L5;
            int r2 = 1231;
        L7:
            return r1 + r2;
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "AbsTime(absTimeMs=" + this.a + ", useNearestAbsTime=" + this.b + ')';
        }

        public a(long r1) {
            this.a = r1;
            this.b = true;
        }
    }

    public static final class b extends l {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "RelativeTime(createRelAudioTimeMs=" + this.a + ')';
        }

        public b(long r1) {
            this.a = r1;
        }
    }

    public l() {
    }
}
