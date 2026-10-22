package com.obric.memorydata.memory.ui.edit;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J]\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/MemoryEditState;", "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "editItems", "", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", "editMemoryEntity", "editStates", "", "", "", "version", "", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/util/List;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/util/Map;J)V", "getMemoryEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getEditItems", "()Ljava/util/List;", "getEditMemoryEntity", "getEditStates", "()Ljava/util/Map;", "getVersion", "()J", "isAllValid", "()Z", "hasValueChange", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryEntity f10900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b<MemoryEntity, Object>> f10901b;
    private final MemoryEntity c;
    private final Map<String, Boolean> d;
    private final long e;

    public e(MemoryEntity r3, List<b<MemoryEntity, Object>> r4, MemoryEntity r5, Map<String, Boolean> r6, long r7) {
        List<b<MemoryEntity, Object>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map<String, Boolean> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        Intrinsics.checkNotNullParameter(r8, "editItems");
        Intrinsics.checkNotNullParameter(r9, "editStates");
        this.f10900a = r3;
        this.f10901b = r8;
        this.c = r5;
        this.d = r9;
        this.e = r7;
    }

    public /* synthetic */ e(MemoryEntity r6, List r7, MemoryEntity r8, Map r9, long r10, int r12, DefaultConstructorMarker r13) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        MemoryEntity r2 = null;
    L7:
        if ((r12 & 8) == 0) goto L10;
        r1 = MapsKt.emptyMap();
    L10:
        if ((r12 & 16) == 0) goto L12;
        long r3 = 0;
    L13:
        this(r6, r0, r2, r1, r3);
        return;
    L12:
        r3 = r10;
        goto L13
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ e a(e r7, MemoryEntity r8, List r9, MemoryEntity r10, Map r11, long r12, int r14, Object r15) {
        List<b<MemoryEntity, Object>> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Map<String, Boolean> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.f10900a;
    L5:
        MemoryEntity r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r13 = r7.f10901b;
    L8:
        List<b<MemoryEntity, Object>> r2 = r13;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        MemoryEntity r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r16 = r7.d;
    L14:
        Map<String, Boolean> r4 = r16;
        if ((r14 & 16) == 0) goto L18;
        r12 = r7.e;
    L18:
        return r7.a(r1, r2, r3, r4, r12);
    }

    public final MemoryEntity a() {
        return this.f10900a;
    }

    public final e a(MemoryEntity r9, List<b<MemoryEntity, Object>> r10, MemoryEntity r11, Map<String, Boolean> r12, long r13) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "memoryEntity");
        Intrinsics.checkNotNullParameter(r3, "editItems");
        Intrinsics.checkNotNullParameter(r5, "editStates");
        return new e(r9, r3, r11, r5, r13);
    }

    public final MemoryEntity b() {
        return this.c;
    }

    public final Map<String, Boolean> c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
        return false;
    L8:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10900a, r8.f10900a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10901b, r8.f10901b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r8.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f10900a.hashCode() * 31) + this.f10901b.hashCode()) * 31;
        MemoryEntity r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MemoryEditState(memoryEntity=" + this.f10900a + ", editItems=" + this.f10901b + ", editMemoryEntity=" + this.c + ", editStates=" + this.d + ", version=" + this.e + ')';
    }
}
