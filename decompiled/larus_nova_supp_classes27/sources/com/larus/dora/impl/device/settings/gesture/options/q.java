package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class q {

    public static final class a extends q {
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
            return -84984259;
        }

        public final String toString() {
            return "Idle";
        }

        public a() {
        }
    }

    public static final class b extends q {
        public final DoraGGestureSettings a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Success(selectedGesture=" + this.a + ')';
        }

        public b(DoraGGestureSettings r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedGesture");
            this.a = r2;
        }
    }

    public q() {
    }
}
