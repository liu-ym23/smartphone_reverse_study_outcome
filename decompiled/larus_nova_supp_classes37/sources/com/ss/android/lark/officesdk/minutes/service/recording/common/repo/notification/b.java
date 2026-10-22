package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b$b, reason: collision with other inner class name */
    public static final class C0044b extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0044b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0044b) r4).a) goto L11;
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
            return "PhoneCall(isCalling=" + this.a + ')';
        }

        public C0044b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
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
            return "SubtitleFailed(isFailed=" + this.a + ')';
        }

        public c(boolean r1) {
            this.a = r1;
        }
    }

    public static final class d extends b {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r4).a) goto L11;
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
            return "WeakNetwork(isWeak=" + this.a + ')';
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public b() {
    }
}
