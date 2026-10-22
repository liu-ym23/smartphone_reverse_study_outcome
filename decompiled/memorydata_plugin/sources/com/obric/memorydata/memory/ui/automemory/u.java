package com.obric.memorydata.memory.ui.automemory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryUiState;", "", "selectedTab", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "isLoading", "", "autoItems", "", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "discoverItems", "<init>", "(Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;ZLjava/util/List;Ljava/util/List;)V", "getSelectedTab", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "()Z", "getAutoItems", "()Ljava/util/List;", "getDiscoverItems", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AutoMemoryTab f10766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10767b;
    private final List<d> c;
    private final List<d> d;

    public u() {
        this(null, false, null, null, 15, null);
    }

    public u(AutoMemoryTab r3, boolean r4, List<d> r5, List<d> r6) {
        List<d> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<d> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "selectedTab");
        Intrinsics.checkNotNullParameter(r7, "autoItems");
        Intrinsics.checkNotNullParameter(r8, "discoverItems");
        this.f10766a = r3;
        this.f10767b = r4;
        this.c = r7;
        this.d = r8;
    }

    public /* synthetic */ u(AutoMemoryTab r2, boolean r3, List r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = AutoMemoryTab.AUTO;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = CollectionsKt.emptyList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r9 = CollectionsKt.emptyList();
    L14:
        this(r2, r3, r8, r9);
    }

    public static /* synthetic */ u a(u r1, AutoMemoryTab r2, boolean r3, List r4, List r5, int r6, Object r7) {
        List<d> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<d> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.f10766a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f10767b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.d;
    L15:
        return r1.a(r2, r3, r8, r9);
    }

    public final AutoMemoryTab a() {
        return this.f10766a;
    }

    public final u a(AutoMemoryTab r2, boolean r3, List<d> r4, List<d> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "selectedTab");
        Intrinsics.checkNotNullParameter(r1, "autoItems");
        Intrinsics.checkNotNullParameter(r6, "discoverItems");
        return new u(r2, r3, r1, r6);
    }

    public final boolean b() {
        return this.f10767b;
    }

    public final List<d> c() {
        return this.c;
    }

    public final List<d> d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.memorydata.plugin");
        if (this.f10766a == r6.f10766a) goto L12;
        return false;
    L12:
        if (this.f10767b == r6.f10767b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f10766a.hashCode() * 31) + Boolean.hashCode(this.f10767b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AutoMemoryUiState(selectedTab=" + this.f10766a + ", isLoading=" + this.f10767b + ", autoItems=" + this.c + ", discoverItems=" + this.d + ')';
    }
}
