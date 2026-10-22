package com.bytedance.gkfs.storage;

import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.gkfs.io.c f4925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f4926c;
    public final Lambda d;
    public final b e;
    public final long f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4928i;

    /* JADX WARN: Multi-variable type inference failed */
    public e(com.bytedance.gkfs.io.c r5, File r10, Function0 r11, b r12, long r13, long r14, long r15, int r16) {
        this.f4925b = r5;
        this.f4926c = r10;
        this.d = (Lambda) r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f4927h = r15;
        this.f4928i = r16;
        this.f4924a = LazyKt.lazy(new GkFSChunkStorageInfo$dilutedSize$2(this));
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == false) goto L22;
        e r10 = (e) r5;
        com.bytedance.gkfs.io.c r11 = r10.f4925b;
        if (Intrinsics.areEqual(this.f4925b, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4926c, r10.f4926c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L14;
        return false;
    L14:
        if (this.f == r10.f) goto L16;
        return false;
    L16:
        if (this.g == r10.g) goto L18;
        return false;
    L18:
        if (this.f4927h == r10.f4927h) goto L20;
        return false;
    L20:
        if (this.f4928i == r10.f4928i) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        com.bytedance.gkfs.io.c r10 = this.f4925b;
        if (r10 == null) goto L5;
        int r11 = r10.f4858a.hashCode();
    L6:
        int r12 = r11 * 31;
        File r13 = this.f4926c;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        Lambda r16 = this.d;
        if (r16 == null) goto L13;
        r5 = r16.hashCode();
    L13:
        int r17 = (this.e.hashCode() + ((r15 + r5) * 31)) * 31;
        long r18 = this.f;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = this.g;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        long r22 = this.f4927h;
        return ((r21 + ((int) (r22 ^ (r22 >>> 32)))) * 31) + this.f4928i;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSChunkStorageInfo(identity=" + this.f4925b + ", chunkReaderProvider=" + this.d + ", indexing=" + this.e + ", lockCost=" + this.f + ", ioCost=" + this.g + ", timeCost=" + this.f4927h + ", size=" + this.f4928i + ", dilutedSize=" + ((Number) this.f4924a.getValue()).intValue() + ')';
    }
}
