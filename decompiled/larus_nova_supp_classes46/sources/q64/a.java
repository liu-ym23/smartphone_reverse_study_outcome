package q64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final c f;
    public final d g;
    public final long h;
    public final long i;
    public final long j;

    /* JADX INFO: renamed from: q64.a$a, reason: collision with other inner class name */
    public static final class C0255a {
    }

    static {
    }

    public final String toString() {
        return "BdpHostRequest(url='" + this.a + "', method='" + this.b + "', responseStreaming=" + this.c + ", addHostCommonParams=" + this.d + ", addHostMd5Stub=" + this.e + ", headers=" + this.f + ", requestBody=" + this.g + ", connectTimeOut=" + this.h + ", readTimeOut=" + this.i + ", writeTimeOut=" + this.j + ')';
    }

    public a(String r2, String r3, boolean r4, boolean r5, boolean r6, c r7, d r8, long r9, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r7, "headers");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r13;
    }
}
