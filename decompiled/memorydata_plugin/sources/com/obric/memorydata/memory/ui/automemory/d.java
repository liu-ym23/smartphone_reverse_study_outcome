package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "", "rule", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "newMemoryCount", "", "<init>", "(Lcom/obric/memorydata/database/entity/MemoryRuleEntity;J)V", "getRule", "()Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "getNewMemoryCount", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryRuleEntity f10672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10673b;

    public d(MemoryRuleEntity r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "rule");
        this.f10672a = r2;
        this.f10673b = r3;
    }

    public /* synthetic */ d(MemoryRuleEntity r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ d a(d r0, MemoryRuleEntity r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f10672a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f10673b;
    L9:
        return r0.a(r1, r2);
    }

    public final MemoryRuleEntity a() {
        return this.f10672a;
    }

    public final d a(MemoryRuleEntity r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "rule");
        return new d(r1, r2);
    }

    public final long b() {
        return this.f10673b;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
        return false;
    L8:
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10672a, r8.f10672a) == true) goto L12;
        return false;
    L12:
        if (this.f10673b == r8.f10673b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10672a.hashCode() * 31) + Long.hashCode(this.f10673b);
    }

    public String toString() {
        return "AutoMemoryCollectionCardItem(rule=" + this.f10672a + ", newMemoryCount=" + this.f10673b + ')';
    }
}
