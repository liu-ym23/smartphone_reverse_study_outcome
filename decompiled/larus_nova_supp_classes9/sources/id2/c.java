package id2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;

    public c(long r2, String r4, String r5, String r6, String r7, String r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "jsonExtra");
        Intrinsics.checkNotNullParameter(r5, "fullLocalPath");
        Intrinsics.checkNotNullParameter(r6, "accompanimentTrackLocalPath");
        Intrinsics.checkNotNullParameter(r7, "midiLocalPath");
        Intrinsics.checkNotNullParameter(r8, "lrcLocalPath");
        Intrinsics.checkNotNullParameter(r10, "coverUrl");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
