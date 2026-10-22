package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventQueryResultDto;", "", "statusCode", "", "events", "", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventEnvelopeDto;", "nextSequenceNumber", "", "hasMore", "", "<init>", "(ILjava/util/List;JZ)V", "getStatusCode", "()I", "getEvents", "()Ljava/util/List;", "getNextSequenceNumber", "()J", "getHasMore", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f12573b;
    private final long c;
    private final boolean d;

    public f() {
        this(0, null, 0, false, 15, null);
    }

    public f(int r3, List<d> r4, long r5, boolean r7) {
        List<d> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "events");
        this.f12572a = r3;
        this.f12573b = r6;
        this.c = r5;
        this.d = r7;
    }

    public /* synthetic */ f(int r8, List r9, long r10, boolean r12, int r13, DefaultConstructorMarker r14) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r11 = CollectionsKt.emptyList();
    L9:
        List r3 = r11;
        if ((r13 & 4) == 0) goto L12;
        r10 = 0;
    L12:
        long r4 = r10;
        if ((r13 & 8) == 0) goto L15;
        boolean r6 = false;
    L16:
        this(r2, r3, r4, r6);
        return;
    L15:
        r6 = r12;
        goto L16
    L5:
        r2 = r8;
        goto L7
    }

    public final List<d> a() {
        return this.f12573b;
    }

    public final long b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f12572a == r10.f12572a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12573b, r10.f12573b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f12572a) * 31) + this.f12573b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "AIMediaEventQueryResultDto(statusCode=" + this.f12572a + ", events=" + this.f12573b + ", nextSequenceNumber=" + this.c + ", hasMore=" + this.d + ')';
    }
}
