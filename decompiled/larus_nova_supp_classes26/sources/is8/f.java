package is8;

import com.larus.bmhome.upload.sdk.api.model.FallbackPolicy;
import com.larus.bmhome.upload.sdk.api.model.PreprocessPolicy;
import com.larus.bmhome.upload.sdk.api.model.RegisterPolicy;
import com.larus.bmhome.upload.sdk.api.model.RoutePolicy;
import com.larus.bmhome.upload.sdk.api.model.TracePolicy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final PreprocessPolicy a;
    public final RoutePolicy b;
    public final RegisterPolicy c;
    public final TracePolicy d;
    public final FallbackPolicy e;
    public final b f;

    public f() {
        this(null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "UploadPolicy(preprocessPolicy=" + this.a + ", routePolicy=" + this.b + ", registerPolicy=" + this.c + ", tracePolicy=" + this.d + ", fallbackPolicy=" + this.e + ", retryPolicy=" + this.f + ')';
    }

    public f(RoutePolicy r5, RegisterPolicy r6, int r7) {
        b r1 = null;
        if ((r7 & 1) == 0) goto L5;
        PreprocessPolicy r0 = PreprocessPolicy.Auto;
    L7:
        if ((r7 & 2) == 0) goto L10;
        r5 = RoutePolicy.Auto;
    L10:
        if ((r7 & 4) == 0) goto L13;
        r6 = RegisterPolicy.Auto;
    L13:
        if ((r7 & 8) == 0) goto L15;
        TracePolicy r2 = TracePolicy.Enabled;
    L17:
        if ((r7 & 16) == 0) goto L19;
        FallbackPolicy r3 = FallbackPolicy.Enabled;
    L21:
        if ((r7 & 32) == 0) goto L23;
        r1 = new b(0);
    L23:
        Intrinsics.checkNotNullParameter(r0, "preprocessPolicy");
        Intrinsics.checkNotNullParameter(r5, "routePolicy");
        Intrinsics.checkNotNullParameter(r6, "registerPolicy");
        Intrinsics.checkNotNullParameter(r2, "tracePolicy");
        Intrinsics.checkNotNullParameter(r3, "fallbackPolicy");
        Intrinsics.checkNotNullParameter(r1, "retryPolicy");
        this.a = r0;
        this.b = r5;
        this.c = r6;
        this.d = r2;
        this.e = r3;
        this.f = r1;
        return;
    L19:
        r3 = null;
        goto L21
    L15:
        r2 = null;
        goto L17
    L5:
        r0 = null;
        goto L7
    }
}
