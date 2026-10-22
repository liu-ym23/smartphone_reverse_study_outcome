package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003Jg\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "", "recordId", "", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "vote", "Lcom/obric/memorydata/memory/review/model/MemoryReviewVote;", "reasons", "", "comment", "displayedCardJson", "traceJson", "audioUrls", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;Lcom/obric/memorydata/memory/review/model/MemoryReviewVote;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getRecordId", "()Ljava/lang/String;", "getModule", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "getVote", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewVote;", "getReasons", "()Ljava/util/List;", "getComment", "getDisplayedCardJson", "getTraceJson", "getAudioUrls", "businessPayloadJson", "getBusinessPayloadJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryReviewModule f10385b;
    private final MemoryReviewVote c;
    private final List<String> d;
    private final String e;
    private final String f;
    private final String g;
    private final List<String> h;

    public c(String r3, MemoryReviewModule r4, MemoryReviewVote r5, List<String> r6, String r7, String r8, String r9, List<String> r10) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "recordId");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "vote");
        Intrinsics.checkNotNullParameter(r11, "reasons");
        Intrinsics.checkNotNullParameter(r7, "comment");
        Intrinsics.checkNotNullParameter(r8, "displayedCardJson");
        Intrinsics.checkNotNullParameter(r12, "audioUrls");
        this.f10384a = r3;
        this.f10385b = r4;
        this.c = r5;
        this.d = r11;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r12;
    }

    public /* synthetic */ c(String r13, MemoryReviewModule r14, MemoryReviewVote r15, List r16, String r17, String r18, String r19, List r20, int r21, DefaultConstructorMarker r22) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        if ((r21 & 64) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        List r11 = CollectionsKt.emptyList();
    L10:
        this(r13, r14, r15, r7, r17, r18, r10, r11);
        return;
    L9:
        r11 = r1;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }

    public static /* synthetic */ c a(c r10, String r11, MemoryReviewModule r12, MemoryReviewVote r13, List r14, String r15, String r16, String r17, List r18, int r19, Object r20) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        if ((r19 & 1) == 0) goto L5;
        String r4 = r10.f10384a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        MemoryReviewModule r5 = r10.f10385b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        MemoryReviewVote r6 = r10.c;
    L15:
        if ((r19 & 8) == 0) goto L18;
        r2 = r10.d;
    L18:
        if ((r19 & 16) == 0) goto L20;
        String r7 = r10.e;
    L22:
        if ((r19 & 32) == 0) goto L24;
        String r8 = r10.f;
    L26:
        if ((r19 & 64) == 0) goto L28;
        String r9 = r10.g;
    L30:
        if ((r19 & 128) == 0) goto L32;
        List<String> r1 = r10.h;
    L34:
        return r10.a(r4, r5, r6, r2, r7, r8, r9, r1);
    L32:
        r1 = r3;
        goto L34
    L28:
        r9 = r17;
        goto L30
    L24:
        r8 = r16;
        goto L26
    L20:
        r7 = r15;
        goto L22
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }

    public final c a(String r12, MemoryReviewModule r13, MemoryReviewVote r14, List<String> r15, String r16, String r17, String r18, List<String> r19) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "recordId");
        Intrinsics.checkNotNullParameter(r13, "module");
        Intrinsics.checkNotNullParameter(r14, "vote");
        Intrinsics.checkNotNullParameter(r6, "reasons");
        Intrinsics.checkNotNullParameter(r16, "comment");
        Intrinsics.checkNotNullParameter(r17, "displayedCardJson");
        Intrinsics.checkNotNullParameter(r10, "audioUrls");
        return new c(r12, r13, r14, r6, r16, r17, r18, r10);
    }

    public final String a() {
        return this.f10384a;
    }

    public final MemoryReviewModule b() {
        return this.f10385b;
    }

    public final MemoryReviewVote c() {
        return this.c;
    }

    public final List<String> d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10384a, r6.f10384a) == true) goto L12;
        return false;
    L12:
        if (this.f10385b == r6.f10385b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
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

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final List<String> h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f10384a.hashCode() * 31) + this.f10385b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.h.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MemoryReviewFeedback(recordId=" + this.f10384a + ", module=" + this.f10385b + ", vote=" + this.c + ", reasons=" + this.d + ", comment=" + this.e + ", displayedCardJson=" + this.f + ", traceJson=" + this.g + ", audioUrls=" + this.h + ')';
    }
}
