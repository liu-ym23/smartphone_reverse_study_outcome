package com.larus.dora.impl.device.ailab;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface b {

    public static final class a implements b {
        public final int a;

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
            return this.a;
        }

        public final String toString() {
            return "UpDatePrecaptureUploadFailed(toastResId=" + this.a + ')';
        }

        public a() {
            this.a = 2131903668;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.b$b, reason: collision with other inner class name */
    public static final class C0032b implements b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0032b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0032b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "UpdateConvStartEndSoundFailed(taostResId=" + this.a + ')';
        }

        public C0032b() {
            this.a = 2131903992;
        }
    }
}
