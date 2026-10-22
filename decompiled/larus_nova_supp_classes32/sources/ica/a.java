package ica;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;

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
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "CameraAutoSendPayload(requestId=" + this.a + ", text=" + this.b + ", imagePath=" + this.c + ", callerPackage=" + this.d + ", createTime=" + this.e + ')';
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Result.constructor-impl(Boolean.valueOf(new PolarisFileWrapper(this.c).delete()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public a(String r4, String r5, String r6, String r7) {
        long r0 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "requestId");
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "imagePath");
        Intrinsics.checkNotNullParameter(r7, "callerPackage");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r0;
    }
}
