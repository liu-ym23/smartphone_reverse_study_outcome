package com.obric.memorydata.memory.island;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/island/BatchMemoryIslandItem;", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "<init>", "(Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;)V", "getKind", "()Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getOldEntity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BatchMemoryIslandKind f10190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryEntity f10191b;
    private final MemoryEntity c;

    public b(BatchMemoryIslandKind r2, MemoryEntity r3, MemoryEntity r4) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r3, "entity");
        this.f10190a = r2;
        this.f10191b = r3;
        this.c = r4;
    }

    public final BatchMemoryIslandKind a() {
        return this.f10190a;
    }

    public final MemoryEntity b() {
        return this.f10191b;
    }

    public final MemoryEntity c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f10190a == r6.f10190a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10191b, r6.f10191b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f10190a.hashCode() * 31) + this.f10191b.hashCode()) * 31;
        MemoryEntity r2 = this.c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "BatchMemoryIslandItem(kind=" + this.f10190a + ", entity=" + this.f10191b + ", oldEntity=" + this.c + ')';
    }
}
