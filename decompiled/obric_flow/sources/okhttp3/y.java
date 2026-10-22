package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h0 f20767c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f20769b;

    static {
        Pattern r5 = h0.e;
        f20767c = z.f("application/x-www-form-urlencoded");
    }

    public y(ArrayList r5, ArrayList r10) {
        Intrinsics.checkNotNullParameter(r5, "encodedNames");
        Intrinsics.checkNotNullParameter(r10, "encodedValues");
        this.f20768a = Util.toImmutableList(r5);
        this.f20769b = Util.toImmutableList(r10);
    }

    public final long a(nu.k r5, boolean r10) {
        if (r10 == false) goto L4;
        nu.j r11 = new nu.j();
    L5:
        List r12 = this.f20768a;
        int r13 = r12.size();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L10;
        if (r14 <= 0) goto L9;
        r11.T(38);
    L9:
        r11.b0((String) r12.get(r14));
        r11.T(61);
        r11.b0((String) this.f20769b.get(r14));
        r14 = r14 + 1;
        goto L6
    L10:
        if (r10 == false) goto L12;
        long r15 = r11.f20328b;
        r11.b();
        return r15;
    L12:
        return 0;
    L4:
        Intrinsics.checkNotNull(r5);
        r11 = r5.h();
        goto L5
    }

    @Override // okhttp3.q0
    public final long contentLength() {
        return a(null, true);
    }

    @Override // okhttp3.q0
    public final h0 contentType() {
        return f20767c;
    }

    @Override // okhttp3.q0
    public final void writeTo(nu.k r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        a(r5, false);
    }
}
