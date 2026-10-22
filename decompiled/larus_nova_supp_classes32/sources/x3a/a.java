package x3a;

import com.obric.aivoice.core.data.NameKeys;
import ic8.m0;
import java.util.UUID;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final m0 a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final long f;
    public String g;
    public Pair<Integer, Integer> h;
    public Boolean i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "ImageProcessorWrapper(fileInfo=" + this.a + ", width=" + this.b + ", height=" + this.c + ", dataSource=" + this.d + ", key=" + this.e + ')';
    }

    public /* synthetic */ a(m0 r7, int r8) {
        this(r7, 0, 0, r8, UUID.randomUUID().toString());
    }

    public a(m0 r2, int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "fileInfo");
        Intrinsics.checkNotNullParameter(r6, "key");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = System.currentTimeMillis();
        this.g = NameKeys.UnloadStrategy_No_Strategy;
    }
}
