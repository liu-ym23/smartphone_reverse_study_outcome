package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunExpansionPolicyState;", "", "autoExpandedStepIds", "", "", "autoHandledStepIds", "manuallyControlledStepIds", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "getAutoExpandedStepIds", "()Ljava/util/Set;", "getAutoHandledStepIds", "getManuallyControlledStepIds", "recordManualChoice", "stepId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f6810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f6811b;
    private final Set<String> c;

    public f() {
        this(null, null, null, 7, null);
    }

    public f(Set<String> r3, Set<String> r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "autoExpandedStepIds");
        Intrinsics.checkNotNullParameter(r7, "autoHandledStepIds");
        Intrinsics.checkNotNullParameter(r8, "manuallyControlledStepIds");
        this.f6810a = r6;
        this.f6811b = r7;
        this.c = r8;
    }

    public /* synthetic */ f(Set r2, Set r3, Set r4, int r5, DefaultConstructorMarker r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = SetsKt.emptySet();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = SetsKt.emptySet();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = SetsKt.emptySet();
    L11:
        this(r7, r8, r9);
    }

    public final f a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "stepId");
        return a(SetsKt.minus(this.f6810a, r4), SetsKt.plus(this.f6811b, r4), SetsKt.plus(this.c, r4));
    }

    public final f a(Set<String> r2, Set<String> r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "autoExpandedStepIds");
        Intrinsics.checkNotNullParameter(r5, "autoHandledStepIds");
        Intrinsics.checkNotNullParameter(r6, "manuallyControlledStepIds");
        return new f(r1, r5, r6);
    }

    public final Set<String> a() {
        return this.f6810a;
    }

    public final Set<String> b() {
        return this.f6811b;
    }

    public final Set<String> c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6810a, r6.f6810a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6811b, r6.f6811b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f6810a.hashCode() * 31) + this.f6811b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AgentRunExpansionPolicyState(autoExpandedStepIds=" + this.f6810a + ", autoHandledStepIds=" + this.f6811b + ", manuallyControlledStepIds=" + this.c + ')';
    }
}
