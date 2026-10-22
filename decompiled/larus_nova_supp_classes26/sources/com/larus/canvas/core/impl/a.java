package com.larus.canvas.core.impl;

import com.larus.im.internal.delegate.c;
import com.larus.im.internal.delegate.d1;
import cy8.w;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public int a;
    public long b;

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.a$a, reason: collision with other inner class name */
    public static final class C0086a {
        public final int a;
        public final String b;
        public final int c;
        public final String d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0086a) == true) goto L8;
            return false;
        L8:
            C0086a r6 = (C0086a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            String r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChunkEndInfo(status=" + this.a + ", errorDesc=" + this.b + ", errorCode=" + this.c + ", logId=" + this.d + ", requestPath=" + this.e + ')';
        }

        public C0086a(int r2, String r3, int r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "errorDesc");
            Intrinsics.checkNotNullParameter(r6, "requestPath");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
    }

    public final void a(w r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a = 0;
        this.b = c.a.currentTimeMillis();
        e0 r0 = new e0();
        com.larus.canvas.core.impl.b.a(r0, "binary_type", "json");
        com.larus.canvas.core.impl.b.a(r0, "request_path", r4.c);
        com.larus.canvas.core.impl.b.a(r0, "scene", "start");
        d0 r5 = r0.a();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        d1.b.a("flow_canvas_chunk_request", r5);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
