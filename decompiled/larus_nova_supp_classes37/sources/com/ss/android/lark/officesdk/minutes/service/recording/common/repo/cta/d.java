package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class d implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends d {
        public static final a a = null;

        static {
            a = new a();
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
            return 1295931848;
        }

        public final String toString() {
            return "AsrQuotaRecovered";
        }

        public a() {
        }
    }

    public d() {
    }
}
