package bd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public final String toString() {
        return "MultiLinkRegion(uid='" + this.a + "', x=" + this.b + ", y=" + this.c + ", width=" + this.d + ", height=" + this.e + ')';
    }

    public b(String r2, float r3, float r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
