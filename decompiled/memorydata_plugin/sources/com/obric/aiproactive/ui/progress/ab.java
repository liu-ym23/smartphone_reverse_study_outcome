package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/ui/progress/RenderedAgentRunGroup;", "", "group", "Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "items", "", "Lkotlin/Pair;", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "", "<init>", "(Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;Ljava/util/List;)V", "getGroup", "()Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f6795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Pair<l, String>> f6796b;

    public ab(k r3, List<Pair<l, String>> r4) {
        List<Pair<l, String>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "group");
        Intrinsics.checkNotNullParameter(r5, "items");
        this.f6795a = r3;
        this.f6796b = r5;
    }

    public final k a() {
        return this.f6795a;
    }

    public final List<Pair<l, String>> b() {
        return this.f6796b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ab.class) == true) goto L8;
        return false;
    L8:
        ab r6 = (ab) ZeusTransformUtils.preCheckCast(r5, ab.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6795a, r6.f6795a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6796b, r6.f6796b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6795a.hashCode() * 31) + this.f6796b.hashCode();
    }

    public String toString() {
        return "RenderedAgentRunGroup(group=" + this.f6795a + ", items=" + this.f6796b + ')';
    }
}
