package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseSessionIndex;", "", "byAnchorStageId", "", "", "Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseSession;", "memberStageIds", "", "<init>", "(Ljava/util/Map;Ljava/util/Set;)V", "getByAnchorStageId", "()Ljava/util/Map;", "getMemberStageIds", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, q> f6844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f6845b;

    public r(Map<String, q> r3, Set<String> r4) {
        Map<String, q> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "byAnchorStageId");
        Intrinsics.checkNotNullParameter(r6, "memberStageIds");
        this.f6844a = r5;
        this.f6845b = r6;
    }

    public final Map<String, q> a() {
        return this.f6844a;
    }

    public final Set<String> b() {
        return this.f6845b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6844a, r6.f6844a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6845b, r6.f6845b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6844a.hashCode() * 31) + this.f6845b.hashCode();
    }

    public String toString() {
        return "LegacyV3MobileUseSessionIndex(byAnchorStageId=" + this.f6844a + ", memberStageIds=" + this.f6845b + ')';
    }
}
