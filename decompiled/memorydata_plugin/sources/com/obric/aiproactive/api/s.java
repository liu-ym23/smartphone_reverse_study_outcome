package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveLabelingFeedbackConfigDto;", "", "positiveReasons", "", "", "negativeReasons", "feedbackPlaceholder", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getPositiveReasons", "()Ljava/util/List;", "getNegativeReasons", "getFeedbackPlaceholder", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f6273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f6274b;
    private final String c;

    public s(List<String> r3, List<String> r4, String r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "positiveReasons");
        Intrinsics.checkNotNullParameter(r7, "negativeReasons");
        Intrinsics.checkNotNullParameter(r5, "feedbackPlaceholder");
        this.f6273a = r6;
        this.f6274b = r7;
        this.c = r5;
    }

    public final List<String> a() {
        return this.f6273a;
    }

    public final List<String> b() {
        return this.f6274b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L8;
        return false;
    L8:
        s r6 = (s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6273a, r6.f6273a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6274b, r6.f6274b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f6273a.hashCode() * 31) + this.f6274b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AiProactiveLabelingFeedbackConfigDto(positiveReasons=" + this.f6273a + ", negativeReasons=" + this.f6274b + ", feedbackPlaceholder=" + this.c + ')';
    }
}
