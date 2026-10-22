package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J`\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006,"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "", "recommendationId", "", "feedbackType", "", "feedbackReason", "feedbackText", "traceId", "feedbackSource", "feedbackValue", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getRecommendationId", "()J", "getFeedbackType", "()Ljava/lang/String;", "getFeedbackReason", "getFeedbackText", "getTraceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFeedbackSource", "getFeedbackValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "classify", "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackClassification;", "isValueOnlyFeedback", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "equals", "other", "hashCode", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6278b;
    private final String c;
    private final String d;
    private final Long e;
    private final String f;
    private final Integer g;

    public u(long r1, String r3, String r4, String r5, Long r6, String r7, Integer r8) {
        this.f6277a = r1;
        this.f6278b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ u(long r12, String r14, String r15, String r16, Long r17, String r18, Integer r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r20 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r20 & 16) == 0) goto L17;
        Long r8 = null;
    L19:
        if ((r20 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r20 & 64) == 0) goto L25;
        Integer r10 = null;
    L26:
        this(r12, r5, r6, r7, r8, r9, r10);
        return;
    L25:
        r10 = r19;
        goto L26
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final long a() {
        return this.f6277a;
    }

    public final String b() {
        return this.f6278b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final Long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.memorydata.plugin");
        if (this.f6277a == r10.f6277a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6278b, r10.f6278b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final AiProactiveRecommendationFeedbackClassification h() {
        if (this.f6278b == null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L14;
        return AiProactiveRecommendationFeedbackClassification.ORDINARY_OR_MIXED;
    L14:
        if (this.g != null) goto L18;
        return AiProactiveRecommendationFeedbackClassification.EXPLICIT_CLEAR;
    L18:
        if (r.f6271a.a(this.g) == null) goto L21;
        return AiProactiveRecommendationFeedbackClassification.VALID_VALUE_ONLY;
    L21:
        return AiProactiveRecommendationFeedbackClassification.INVALID_VALUE_ONLY;
    L5:
        if (this.c != null) goto L9;
        if (this.d != null) goto L9;
        r0 = true;
        goto L10
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f6277a) * 31;
        String r1 = this.f6278b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.g;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean i() {
        if (h() != AiProactiveRecommendationFeedbackClassification.VALID_VALUE_ONLY) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AiProactiveRecommendationFeedbackRequest(recommendationId=" + this.f6277a + ", feedbackType=" + this.f6278b + ", feedbackReason=" + this.c + ", feedbackText=" + this.d + ", traceId=" + this.e + ", feedbackSource=" + this.f + ", feedbackValue=" + this.g + ')';
    }
}
