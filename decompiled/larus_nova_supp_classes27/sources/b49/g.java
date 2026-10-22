package b49;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final byte[] g;
    public final int h;
    public final byte[] i;

    public final String toString() {
        return "FlowDoraDataFrame(stage=" + this.a + ", scene=" + this.b + ", id=" + this.c + ", type=" + this.d + ", seq=" + this.e + ", count=" + this.f + ", data=" + Arrays.toString(this.g) + ", assId=" + this.h + ", assData=" + Arrays.toString(this.i) + ')';
    }

    public final int getType() {
        return this.d;
    }

    public g(int r2, int r3, int r4, int r5, int r6, int r7, byte[] r8, int r9, byte[] r10) {
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r10, "assData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
