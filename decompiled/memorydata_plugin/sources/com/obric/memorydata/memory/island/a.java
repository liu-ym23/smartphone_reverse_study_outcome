package com.obric.memorydata.memory.island;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/island/BatchMemoryIslandGroup;", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "firstTitle", "", CommonConsts.COUNT_TYPE, "", "firstEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "firstOldEntity", "<init>", "(Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;Ljava/lang/String;ILcom/obric/capabilitykit/entity/memory/MemoryEntity;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;)V", "getKind", "()Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "getFirstTitle", "()Ljava/lang/String;", "getCount", "()I", "getFirstEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getFirstOldEntity", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BatchMemoryIslandKind f10188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10189b;
    private final int c;
    private final MemoryEntity d;
    private final MemoryEntity e;

    public a(BatchMemoryIslandKind r2, String r3, int r4, MemoryEntity r5, MemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r3, "firstTitle");
        Intrinsics.checkNotNullParameter(r5, "firstEntity");
        this.f10188a = r2;
        this.f10189b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final BatchMemoryIslandKind a() {
        return this.f10188a;
    }

    public final String b() {
        return this.f10189b;
    }

    public final int c() {
        return this.c;
    }

    public final MemoryEntity d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f10188a == r6.f10188a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10189b, r6.f10189b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f10188a.hashCode() * 31) + this.f10189b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        MemoryEntity r2 = this.e;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "BatchMemoryIslandGroup(kind=" + this.f10188a + ", firstTitle=" + this.f10189b + ", count=" + this.c + ", firstEntity=" + this.d + ", firstOldEntity=" + this.e + ')';
    }
}
