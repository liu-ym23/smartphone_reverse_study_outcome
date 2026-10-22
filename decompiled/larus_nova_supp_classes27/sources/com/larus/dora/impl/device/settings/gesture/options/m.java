package com.larus.dora.impl.device.settings.gesture.options;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface m {

    public static final class a implements m {
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
            return 37259595;
        }

        public final String toString() {
            return "ClosePage";
        }
    }

    public static final class b implements m {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "SetGestureOptionFailed(toastResId=" + this.a + ')';
        }

        public b() {
            this.a = 2131903668;
        }
    }

    public static final class c implements m {
        public final p a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ShowQuickControlGuideDialog(dialog=" + this.a + ')';
        }

        public c(p r2) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            this.a = r2;
        }
    }
}
