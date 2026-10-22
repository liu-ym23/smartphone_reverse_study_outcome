package com.larus.dora.api.network;

import java.io.Closeable;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a$a {

    public static final class a extends a$a {
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
            return "HttpFailed(statusCode=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b extends a$a {
        public final Throwable a;
        public final Integer b;
        public final Integer c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Integer r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "RequestFailed(cause=" + this.a + ", statusCode=" + this.b + ", internalErrorCode=" + this.c + ')';
        }

        public b(Throwable r2, Integer r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r2, "cause");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends a$a implements Closeable {
        public final int a;
        public final long b;
        public final InputStream c;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.c.close();
        }

        public c(int r2, long r3, InputStream r5) {
            Intrinsics.checkNotNullParameter(r5, "inputStream");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public a$a() {
    }
}
