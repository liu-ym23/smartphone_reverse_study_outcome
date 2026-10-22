package com.obric.aiproactive.ui.model;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/obric/aiproactive/ui/model/AiProactiveActionExecutionPlan;", "", "recommendationId", "", "actionIndex", "", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "optimisticPatch", "Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "optimisticRecommendation", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "<init>", "(JLjava/lang/Integer;Lcom/obric/aiproactive/api/AiProactiveCardStatus;Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;Lcom/obric/aiproactive/api/ProactiveRecommendationDto;)V", "getRecommendationId", "()J", "getActionIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardStatus", "()Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "getOptimisticPatch", "()Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "getOptimisticRecommendation", "()Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "component1", "component2", "component3", "component4", "component5", "copy", "(JLjava/lang/Integer;Lcom/obric/aiproactive/api/AiProactiveCardStatus;Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;Lcom/obric/aiproactive/api/ProactiveRecommendationDto;)Lcom/obric/aiproactive/ui/model/AiProactiveActionExecutionPlan;", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f6718b;
    private final AiProactiveCardStatus c;
    private final h d;
    private final ProactiveRecommendationDto e;

    public b(long r1, Integer r3, AiProactiveCardStatus r4, h r5, ProactiveRecommendationDto r6) {
        this.f6717a = r1;
        this.f6718b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final long a() {
        return this.f6717a;
    }

    public final Integer b() {
        return this.f6718b;
    }

    public final AiProactiveCardStatus c() {
        return this.c;
    }

    public final h d() {
        return this.d;
    }

    public final ProactiveRecommendationDto e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (this.f6717a == r10.f6717a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6718b, r10.f6718b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f6717a) * 31;
        Integer r1 = this.f6718b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        AiProactiveCardStatus r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        h r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        ProactiveRecommendationDto r11 = this.e;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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

    public String toString() {
        return "AiProactiveActionExecutionPlan(recommendationId=" + this.f6717a + ", actionIndex=" + this.f6718b + ", cardStatus=" + this.c + ", optimisticPatch=" + this.d + ", optimisticRecommendation=" + this.e + ')';
    }
}
