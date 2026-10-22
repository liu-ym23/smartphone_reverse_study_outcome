package com.ss.ugc.live.sdk.msg.utils;

import java.lang.Throwable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class g<V, E extends Throwable> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static b a(Throwable r1) {
            Intrinsics.checkNotNullParameter(r1, "ex");
            return new b(r1);
        }
    }

    public static final class b<E extends Throwable> extends g {
        public final E b;

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "[Failure: " + this.b + ']';
        }

        public b(E r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.b = r2;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, ((b) r3).b) == false) goto L10;
            return true;
        }
    }

    public static final class c<V> extends g {
        public final V b;

        public final int hashCode() {
            V r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "[Success: " + this.b + ']';
        }

        public c(V r1) {
            this.b = r1;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, ((c) r3).b) == false) goto L10;
            return true;
        }
    }

    static {
    }

    public g() {
    }
}
