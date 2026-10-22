package com.bytedance.gkfs.storage;

import ai.j0;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient com.bytedance.gkfs.io.c f4916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.gkfs.io.a f4917c;
    public final String[] d;
    public final transient a e;
    public final transient long f;

    public b(com.bytedance.gkfs.io.c r5, com.bytedance.gkfs.io.a r10, String[] r11, a r12, long r13) {
        this.f4916b = r5;
        this.f4917c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.f4915a = LazyKt.lazy(new ChunkIndexingInfo$rc$2(this));
    }

    public static b a(b r10, com.bytedance.gkfs.io.c r11, String[] r12, a r13, long r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r11 = r10.f4916b;
    L5:
        com.bytedance.gkfs.io.c r5 = r11;
        if ((r15 & 4) == 0) goto L8;
        r12 = r10.d;
    L8:
        String[] r16 = r12;
        if ((r15 & 8) == 0) goto L11;
        r13 = r10.e;
    L11:
        a r17 = r13;
        if ((r15 & 16) == 0) goto L14;
        r14 = r10.f;
    L14:
        com.bytedance.gkfs.io.a r18 = r10.f4917c;
        return new b(r5, r18, r16, r17, r14);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(b.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L23;
        b r11 = (b) r5;
        if (Intrinsics.areEqual(this.f4916b, r11.f4916b) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f4917c, r11.f4917c) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L21;
        return false;
    L21:
        return true;
    L23:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.gkfs.storage.ChunkIndexingInfo");
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        int r5 = ((this.f4916b.f4858a.hashCode() * 31) + this.f4917c.f4853a) * 31;
        return this.e.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ChunkIndexingInfo(id=");
        r5.append(this.f4916b);
        r5.append(", blockId=");
        r5.append(this.f4917c);
        r5.append(", reference=");
        r5.append(Arrays.toString(this.d));
        r5.append(", blockInfo=");
        r5.append(this.e);
        r5.append(", timeCost=");
        return j0.o(r5, this.f, ")");
    }

    public /* synthetic */ b(com.bytedance.gkfs.io.c r10, com.bytedance.gkfs.io.a r11, String[] r12, long r13) {
        this(r10, r11, r12, new a(), r13);
    }
}
