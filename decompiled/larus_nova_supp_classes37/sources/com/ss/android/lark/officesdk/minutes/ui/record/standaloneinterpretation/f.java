package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class f implements k {

    public static final class a extends f {
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
            return 262121608;
        }

        public final String toString() {
            return "ClosePage";
        }

        public a() {
        }
    }

    public static final class b extends f {
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
            return 459732080;
        }

        public final String toString() {
            return "ShowLanguagePanel";
        }

        public b() {
        }
    }

    public static final class c extends f {
        public static final c a = null;

        static {
            a = new c();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return 573477803;
        }

        public final String toString() {
            return "ShowSettingsFailedToast";
        }

        public c() {
        }
    }

    public static final class d extends f {
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
            return "ShowSpeakerToast(soundOn=" + this.a + ')';
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public f() {
    }
}
