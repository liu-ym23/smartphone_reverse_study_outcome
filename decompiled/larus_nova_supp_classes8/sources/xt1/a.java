package xt1;

import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int e = 0;
    public final o a;
    public final String b;
    public final String c;
    public final boolean d;

    /* JADX INFO: renamed from: xt1.a$a, reason: collision with other inner class name */
    public static final class C0427a {
    }

    static {
    }

    public final String getType() {
        return this.b;
    }

    public a(o r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "dslData");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = true;
    }
}
