package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class e<T> {

    public static final class a<T> extends e<T> {
        public final Object a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Result.equals-impl0(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Result.hashCode-impl(this.a);
        }

        public final String toString() {
            return "Hit(result=" + Result.toString-impl(this.a) + ')';
        }

        public a(Object r1) {
            this.a = r1;
        }
    }

    public static final class b extends e {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public e() {
    }
}
