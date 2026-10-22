package com.obric.memorydata.memory.contextsync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextSwitchSnapshot;", "", "globalMemory", "", "personalInfoMemory", "collectionMemory", "<init>", "(ZZZ)V", "getGlobalMemory", "()Z", "getPersonalInfoMemory", "getCollectionMemory", "semanticSyncEnabled", "getSemanticSyncEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10101b;
    private final boolean c;

    public e(boolean r1, boolean r2, boolean r3) {
        this.f10100a = r1;
        this.f10101b = r2;
        this.c = r3;
    }

    public final boolean a() {
        return this.f10100a;
    }

    public final boolean b() {
        return this.f10101b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        if (this.f10100a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f10101b == false) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f10100a == r6.f10100a) goto L12;
        return false;
    L12:
        if (this.f10101b == r6.f10101b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f10100a) * 31) + Boolean.hashCode(this.f10101b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "MemoryContextSwitchSnapshot(globalMemory=" + this.f10100a + ", personalInfoMemory=" + this.f10101b + ", collectionMemory=" + this.c + ')';
    }
}
