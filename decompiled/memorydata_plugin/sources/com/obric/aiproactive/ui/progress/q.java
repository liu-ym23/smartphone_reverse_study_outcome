package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseSession;", "", "stages", "", "Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "isActive", "", "<init>", "(Ljava/util/List;Z)V", "getStages", "()Ljava/util/List;", "()Z", "anchor", "getAnchor", "()Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.aiproactive.api.i> f6842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6843b;
    private final com.obric.aiproactive.api.i c;

    public q(List<com.obric.aiproactive.api.i> r3, boolean r4) {
        List<com.obric.aiproactive.api.i> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "stages");
        this.f6842a = r5;
        this.f6843b = r4;
        this.c = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r5), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
    }

    public final List<com.obric.aiproactive.api.i> a() {
        return this.f6842a;
    }

    public final boolean b() {
        return this.f6843b;
    }

    public final com.obric.aiproactive.api.i c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6842a, r6.f6842a) == true) goto L12;
        return false;
    L12:
        if (this.f6843b == r6.f6843b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6842a.hashCode() * 31) + Boolean.hashCode(this.f6843b);
    }

    public String toString() {
        return "LegacyV3MobileUseSession(stages=" + this.f6842a + ", isActive=" + this.f6843b + ')';
    }
}
