package com.larus.dora.obric.onboarding;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.a$a, reason: collision with other inner class name */
    public static final class C0108a implements a {
        public final ActionEvent a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0108a) == true) goto L8;
            return false;
        L8:
            C0108a r6 = (C0108a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "State(action=" + this.a + ", type=" + this.b + ')';
        }

        public final int getType() {
            return this.b;
        }

        public C0108a(ActionEvent r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.a = r2;
            this.b = r3;
        }
    }
}
