package nuc;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.CoreFriendModuleApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@CoreFriendModuleApi
public final class d0 {
    public static final long[] e = null;
    public final luc.f a;
    public final Function2<luc.f, Integer, Boolean> b;
    public long c;
    public final long[] d;

    public static final class a {
    }

    static {
        e = new long[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(luc.f r5, Function2<? super luc.f, ? super Integer, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r6, "readIfAbsent");
        this.a = r5;
        this.b = r6;
        int r7 = r5.d();
        long r2 = 0;
        if (r7 > 64) goto L8;
        if (r7 == 64) goto L7;
        r2 = (-1) << r7;
    L7:
        this.c = r2;
        this.d = e;
        return;
    L8:
        this.c = 0;
        long[] r8 = new long[(r7 - 1) >>> 6];
        if ((r7 & 63) == 0) goto L11;
        r8[ArraysKt.getLastIndex(r8)] = (-1) << r7;
    L11:
        this.d = r8;
    }
}
