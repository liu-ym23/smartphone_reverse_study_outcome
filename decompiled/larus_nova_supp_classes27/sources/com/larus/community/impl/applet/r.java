package com.larus.community.impl.applet;

import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r {
    public static final ConcurrentHashMap<String, a> a = null;

    public static final class a {
        public final Bundle a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "PayloadEntry(payload=" + this.a + ", createTimeMs=" + this.b + ')';
        }

        public a(Bundle r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "payload");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }
}
