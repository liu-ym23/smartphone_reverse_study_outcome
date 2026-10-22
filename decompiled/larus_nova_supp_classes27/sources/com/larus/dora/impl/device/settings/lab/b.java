package com.larus.dora.impl.device.settings.lab;

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
            return "SetAllowDoubaoViewImagesSwitchFailed(toastResId=" + this.a + ')';
        }

        public a() {
            this.a = 2131904037;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.b$b, reason: collision with other inner class name */
    public static final class C0048b implements b {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0048b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0048b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "SetBehaviorAwareSwitchFailed(toastResId=" + this.a + ')';
        }

        public C0048b() {
            this.a = 2131904037;
        }
    }

    public static final class c implements b {
        public final int a;

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
            return this.a;
        }

        public final String toString() {
            return "SetQuickContinuousConversationSwitchFailed(toastResId=" + this.a + ')';
        }

        public c(int r1) {
            this.a = r1;
        }
    }

    public static final class d implements b {
        public final int a;

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
            return this.a;
        }

        public final String toString() {
            return "SetRTCTransportModeFailed(toastResId=" + this.a + ')';
        }

        public d(int r1) {
            this.a = r1;
        }
    }
}
