package com.obric.memorydata.ui.settingsharness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsPendingSnapshot;", "", "rowIds", "", "", "switchTargets", "", "", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "getRowIds", "()Ljava/util/Set;", "getSwitchTargets", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f13050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f13051b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public k(Set<String> r3, Map<String, Boolean> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Map<String, Boolean> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "rowIds");
        Intrinsics.checkNotNullParameter(r6, "switchTargets");
        this.f13050a = r5;
        this.f13051b = r6;
    }

    public /* synthetic */ k(Set r2, Map r3, int r4, DefaultConstructorMarker r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = SetsKt.emptySet();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = MapsKt.emptyMap();
    L8:
        this(r6, r7);
    }

    public final Set<String> a() {
        return this.f13050a;
    }

    public final Map<String, Boolean> b() {
        return this.f13051b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13050a, r6.f13050a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13051b, r6.f13051b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f13050a.hashCode() * 31) + this.f13051b.hashCode();
    }

    public String toString() {
        return "SettingsPendingSnapshot(rowIds=" + this.f13050a + ", switchTargets=" + this.f13051b + ')';
    }
}
