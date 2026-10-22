package com.obric.memorydata.memory.review.provider;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\f2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\f\u0010\u001f\u001a\u00020\u001c*\u00020\fH\u0002J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003Je\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006."}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSnapshot;", "", "recordId", "", "entityRevision", "refsDigest", "transcriptDigest", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "totalBytes", "", "segments", "", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSegment;", "audioUrls", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getRecordId", "()Ljava/lang/String;", "getEntityRevision", "getRefsDigest", "getTranscriptDigest", "getText", "getTotalBytes", "()I", "getSegments", "()Ljava/util/List;", "getAudioUrls", "positionAt", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptPosition;", "absoluteOffset", TypedValues.CycleType.S_WAVE_OFFSET, "endPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10460b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<j> g;
    private final List<String> h;

    public k(String r3, String r4, String r5, String r6, String r7, int r8, List<j> r9, List<String> r10) {
        List<j> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "recordId");
        Intrinsics.checkNotNullParameter(r4, "entityRevision");
        Intrinsics.checkNotNullParameter(r5, "refsDigest");
        Intrinsics.checkNotNullParameter(r6, "transcriptDigest");
        Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "segments");
        Intrinsics.checkNotNullParameter(r12, "audioUrls");
        this.f10459a = r3;
        this.f10460b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r11;
        this.h = r12;
    }

    private final g a(j r2) {
        return a(r2, r2.d());
    }

    private final g a(j r3, int r4) {
        return new g(r3.a(), r3.b(), r4 - r3.c());
    }

    public final g a(int r10) {
        if (this.g.isEmpty() == true) goto L5;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L8:
        if (r0.hasNext() == false) goto L26;
        Object r4 = r0.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin");
        int r7 = r6.c();
        if (r10 > r6.d()) goto L16;
        if (r7 > r10) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
        if (r10 < r6.c()) goto L23;
        r2 = r5;
        goto L8
    L23:
        return a((j) ZeusTransformUtils.preCheckCast(this.g.get(RangesKt.coerceAtLeast(r2 - 1, 0)), j.class, "com.obric.memorydata.plugin"));
    L19:
        return a(r6, r10);
    L16:
        r8 = false;
        goto L17
    L26:
        return a((j) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.g), j.class, "com.obric.memorydata.plugin"));
    L5:
        return new g(0, 0, 0);
    }

    public final String a() {
        return this.f10459a;
    }

    public final String b() {
        return this.f10460b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10459a, r6.f10459a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10460b, r6.f10460b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int f() {
        return this.f;
    }

    public final List<String> g() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((this.f10459a.hashCode() * 31) + this.f10460b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "AudioMemoryTranscriptSnapshot(recordId=" + this.f10459a + ", entityRevision=" + this.f10460b + ", refsDigest=" + this.c + ", transcriptDigest=" + this.d + ", text=" + this.e + ", totalBytes=" + this.f + ", segments=" + this.g + ", audioUrls=" + this.h + ')';
    }
}
