package com.larus.dora.obric.device_management.setting.g;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class s {

    public static final class a extends s {
        public final String a;
        public final Map<String, Object> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Route(route=" + this.a + ", params=" + this.b + ')';
        }

        public a(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "route");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a = r2;
            this.b = r3;
        }
    }

    public s() {
    }
}
