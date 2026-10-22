package kotlinx.serialization.internal;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final long[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.g f19360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2 f19361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19362c;
    public final long[] d;

    static {
        e = new long[0];
    }

    public w(kotlinx.serialization.descriptors.g r5, Function2 r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r10, "readIfAbsent");
        this.f19360a = r5;
        this.f19361b = r10;
        int r11 = r5.d();
        long r12 = 0;
        if (r11 > 64) goto L8;
        if (r11 == 64) goto L7;
        r12 = (-1) << r11;
    L7:
        this.f19362c = r12;
        this.d = e;
        return;
    L8:
        this.f19362c = 0;
        long[] r13 = new long[(r11 - 1) >>> 6];
        if ((r11 & 63) == 0) goto L11;
        r13[ArraysKt.getLastIndex(r13)] = (-1) << r11;
    L11:
        this.d = r13;
    }
}
