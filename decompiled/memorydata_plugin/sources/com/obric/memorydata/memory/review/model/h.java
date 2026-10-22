package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "", "recordId", "", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "title", "summary", "cardPayloadJson", "feedbackState", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "traceJson", "updateTimeMillis", "", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;Ljava/lang/String;J)V", "getRecordId", "()Ljava/lang/String;", "getModule", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "getTitle", "getSummary", "getCardPayloadJson", "getFeedbackState", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "getTraceJson", "getUpdateTimeMillis", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryReviewModule f10394b;
    private final String c;
    private final String d;
    private final String e;
    private final MemoryReviewFeedbackState f;
    private final String g;
    private final long h;

    public h(String r2, MemoryReviewModule r3, String r4, String r5, String r6, MemoryReviewFeedbackState r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r6, "cardPayloadJson");
        Intrinsics.checkNotNullParameter(r7, "feedbackState");
        this.f10393a = r2;
        this.f10394b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final String a() {
        return this.f10393a;
    }

    public final MemoryReviewModule b() {
        return this.f10394b;
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

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, h.class) == true) goto L8;
        return false;
    L8:
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10393a, r8.f10393a) == true) goto L12;
        return false;
    L12:
        if (this.f10394b == r8.f10394b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r8.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r8.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r8.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final MemoryReviewFeedbackState f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((this.f10393a.hashCode() * 31) + this.f10394b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r8 = this.g;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + Long.hashCode(this.h);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MemoryReviewRecord(recordId=" + this.f10393a + ", module=" + this.f10394b + ", title=" + this.c + ", summary=" + this.d + ", cardPayloadJson=" + this.e + ", feedbackState=" + this.f + ", traceJson=" + this.g + ", updateTimeMillis=" + this.h + ')';
    }
}
