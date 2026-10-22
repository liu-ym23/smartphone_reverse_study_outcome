package com.bytedance.gkfs.io;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f4888c;
    public final long d;
    public final long e;
    public final e f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4891j;

    public l(n r20, long r21, long r23, e r25, long r26, long r28, long r30, int r32) {
        if ((r32 & 1) == 0) goto L5;
        n r5 = n.d;
    L7:
        if ((r32 & 2) == 0) goto L9;
        long r10 = 0;
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r11 = 0;
    L15:
        if ((r32 & 8) == 0) goto L17;
        e r12 = e.d;
    L19:
        if ((r32 & 32) == 0) goto L21;
        long r13 = 0;
    L23:
        if ((r32 & 64) == 0) goto L25;
        long r14 = 0;
    L27:
        if ((r32 & 128) == 0) goto L29;
        long r15 = 0;
    L30:
        this(r5, r10, r11, r12, 0, r13, r14, r15);
        return;
    L29:
        r15 = r30;
        goto L30
    L25:
        r14 = r28;
        goto L27
    L21:
        r13 = r26;
        goto L23
    L17:
        r12 = r25;
        goto L19
    L13:
        r11 = r23;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof l) == false) goto L22;
        l r10 = (l) r5;
        n r11 = r10.f4888c;
        if (Intrinsics.areEqual(this.f4888c, r11) == true) goto L8;
        return false;
    L8:
        if (this.d == r10.d) goto L10;
        return false;
    L10:
        if (this.e == r10.e) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L14;
        return false;
    L14:
        if (this.g == r10.g) goto L16;
        return false;
    L16:
        if (this.f4889h == r10.f4889h) goto L18;
        return false;
    L18:
        if (this.f4890i == r10.f4890i) goto L20;
        return false;
    L20:
        if (this.f4891j == r10.f4891j) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        n r10 = this.f4888c;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        long r12 = this.d;
        int r13 = ((r11 * 31) + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = this.e;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        e r16 = this.f;
        if (r16 == null) goto L9;
        r5 = r16.hashCode();
    L9:
        long r17 = this.g;
        int r18 = (((r15 + r5) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        long r19 = this.f4889h;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = this.f4890i;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        long r23 = this.f4891j;
        return r22 + ((int) (r23 ^ (r23 >>> 32)));
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GkFSIOStatistics(status=");
        r5.append(this.f4888c);
        r5.append(", headerTimeCost=");
        r5.append(this.d);
        r5.append(", headerStorageCost=");
        r5.append(this.e);
        r5.append(", chunkStatistics=");
        r5.append(this.f);
        r5.append(", tailTimeCost=");
        r5.append(this.f4889h);
        r5.append(", tailStorageCost=");
        r5.append(this.f4890i);
        r5.append(", totalTimeCost=");
        r5.append(this.f4891j);
        r5.append(", fileDilutedStorageCost=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f4886a, ')');
    }

    public l(n r5, long r10, long r11, e r12, long r13, long r14, long r15, long r16) {
        this.f4888c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.f4889h = r14;
        this.f4890i = r15;
        this.f4891j = r16;
        Iterator r17 = r12.f4864c.entrySet().iterator();
        int r18 = 0;
        int r19 = 0;
    L4:
        if (r17.hasNext() == false) goto L6;
        r19 = r19 + ((Number) ((com.bytedance.gkfs.storage.e) ((Map.Entry) r17.next()).getValue()).f4924a.getValue()).intValue();
        goto L4
    L6:
        this.f4886a = (r11 + ((long) r19)) + this.f4890i;
        long r20 = this.e;
        Iterator r21 = this.f.f4864c.entrySet().iterator();
    L8:
        if (r21.hasNext() == false) goto L10;
        r18 = r18 + ((com.bytedance.gkfs.storage.e) ((Map.Entry) r21.next()).getValue()).f4928i;
        goto L8
    L10:
        this.f4887b = (r20 + ((long) r18)) + this.f4890i;
    }
}
