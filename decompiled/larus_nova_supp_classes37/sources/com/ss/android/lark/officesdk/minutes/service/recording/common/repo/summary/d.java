package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class d implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends d {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "FishBoneMarkResult(marked=" + this.a + ')';
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    public static final class b extends d {
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
            return 1869041905;
        }

        public final String toString() {
            return "RequestVibrate";
        }

        public b() {
        }
    }

    public d() {
    }
}
