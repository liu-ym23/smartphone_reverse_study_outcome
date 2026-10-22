package com.obric.memorydata.memory.review.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkResponse;", "", "code", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCode;", "chunk", "", "nextCursor", "hasMore", "", "totalBytes", "", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCode;Ljava/lang/String;Ljava/lang/String;ZI)V", "getCode", "()Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCode;", "getChunk", "()Ljava/lang/String;", "getNextCursor", "getHasMore", "()Z", "getTotalBytes", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioMemoryTranscriptCode f10434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10435b;
    private final String c;
    private final boolean d;
    private final int e;

    public b(AudioMemoryTranscriptCode r2, String r3, String r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "code");
        Intrinsics.checkNotNullParameter(r3, "chunk");
        this.f10434a = r2;
        this.f10435b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ b(AudioMemoryTranscriptCode r7, String r8, String r9, boolean r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = "";
    L5:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = null;
    L8:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L11;
        boolean r4 = false;
    L13:
        if ((r12 & 16) == 0) goto L15;
        int r5 = 0;
    L16:
        this(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L11:
        r4 = r10;
        goto L13
    }

    public final AudioMemoryTranscriptCode a() {
        return this.f10434a;
    }

    public final String b() {
        return this.f10435b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f10434a == r6.f10434a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10435b, r6.f10435b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f10434a.hashCode() * 31) + this.f10435b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AudioMemoryTranscriptChunkResponse(code=" + this.f10434a + ", chunk=" + this.f10435b + ", nextCursor=" + this.c + ", hasMore=" + this.d + ", totalBytes=" + this.e + ')';
    }
}
