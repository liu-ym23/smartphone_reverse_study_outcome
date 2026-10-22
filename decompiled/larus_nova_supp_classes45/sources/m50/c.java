package m50;

import java.nio.ShortBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;
    public ShortBuffer d;
    public short[] e;
    public int f;
    public final int g;

    public c(short[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        this.a = 34963;
        this.b = 35044;
        this.c = 2;
        this.f = -1;
        this.g = 0;
        this.g = r2.length;
        this.e = r2;
    }
}
