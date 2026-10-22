package com.obric.memorydata.realtimecontext;

import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;", "", "activity", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;", "whiteList", "", "Lcom/obric/memorydata/realtimecontext/CompiledSceneConditionGroup;", "blackList", "<init>", "(Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;Ljava/util/List;Ljava/util/List;)V", "getActivity", "()Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;", "getWhiteList", "()Ljava/util/List;", "getBlackList", "needsViewTree", "", "getNeedsViewTree", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActionRecommendSceneActivity f12473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<m> f12474b;
    private final List<m> c;

    public k(ActionRecommendSceneActivity r3, List<m> r4, List<m> r5) {
        List<m> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<m> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r6, "whiteList");
        Intrinsics.checkNotNullParameter(r7, "blackList");
        this.f12473a = r3;
        this.f12474b = r6;
        this.c = r7;
    }

    public final List<m> a() {
        return this.f12474b;
    }

    public final List<m> b() {
        return this.c;
    }

    public final boolean c() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f12474b, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12473a, r6.f12473a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12474b, r6.f12474b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final ActionRecommendSceneActivity getActivity() {
        return this.f12473a;
    }

    public int hashCode() {
        return (((this.f12473a.hashCode() * 31) + this.f12474b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CompiledActionRecommendSceneRule(activity=" + this.f12473a + ", whiteList=" + this.f12474b + ", blackList=" + this.c + ')';
    }
}
