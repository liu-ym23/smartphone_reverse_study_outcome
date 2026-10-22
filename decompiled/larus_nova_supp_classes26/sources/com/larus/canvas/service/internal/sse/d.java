package com.larus.canvas.service.internal.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final int a;
        public final int b;
        public final long c;
        public final String d;
        public final int e;
        public final String f;
        public final String g;
        public final String h;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            long r1 = this.c;
            return ((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        }

        public final String toString() {
            return "ChunkEndInfo(status=" + this.a + ", count=" + this.b + ", duration=" + this.c + ", errorDesc=" + this.d + ", errorCode=" + this.e + ", binaryType=" + this.f + ", logId=" + this.g + ", requestPath=" + this.h + ')';
        }

        public a(int r3, int r4, long r5, String r7, int r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r7, "errorDesc");
            Intrinsics.checkNotNullParameter("json", "binaryType");
            Intrinsics.checkNotNullParameter(r9, "logId");
            Intrinsics.checkNotNullParameter(r10, "requestPath");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = "json";
            this.g = r9;
            this.h = r10;
        }
    }

    static {
    }
}
