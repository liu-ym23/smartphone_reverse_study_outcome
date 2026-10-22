package com.obric.memorydata.union.build.storage;

import com.obric.memorydata.database.entity.ip;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JS\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/obric/memorydata/union/build/storage/ResolvedSemanticOperation;", "", "index", "", "operation", "Lcom/obric/memorydata/union/build/storage/SemanticBatchOperation;", "existing", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "targetKeys", "", "", "expectedChangeSeqs", "", "", "<init>", "(ILcom/obric/memorydata/union/build/storage/SemanticBatchOperation;Ljava/util/List;Ljava/util/Set;Ljava/util/Map;)V", "getIndex", "()I", "getOperation", "()Lcom/obric/memorydata/union/build/storage/SemanticBatchOperation;", "getExisting", "()Ljava/util/List;", "getTargetKeys", "()Ljava/util/Set;", "getExpectedChangeSeqs", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SemanticBatchOperation f13121b;
    private final List<ip> c;
    private final Set<String> d;
    private final Map<String, Long> e;

    public g(int r3, SemanticBatchOperation r4, List<ip> r5, Set<String> r6, Map<String, Long> r7) {
        List<ip> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Map<String, Long> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "operation");
        Intrinsics.checkNotNullParameter(r8, "existing");
        Intrinsics.checkNotNullParameter(r9, "targetKeys");
        Intrinsics.checkNotNullParameter(r10, "expectedChangeSeqs");
        this.f13120a = r3;
        this.f13121b = r4;
        this.c = r8;
        this.d = r9;
        this.e = r10;
    }

    public static /* synthetic */ g a(g r6, int r7, SemanticBatchOperation r8, List r9, Set r10, Map r11, int r12, Object r13) {
        List<ip> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Set<String> r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Map<String, Long> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f13120a;
    L5:
        int r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.f13121b;
    L8:
        SemanticBatchOperation r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.c;
    L11:
        List<ip> r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r15 = r6.d;
    L14:
        Set<String> r4 = r15;
        if ((r12 & 16) == 0) goto L18;
        r16 = r6.e;
    L18:
        return r6.a(r1, r2, r3, r4, r16);
    }

    public final int a() {
        return this.f13120a;
    }

    public final g a(int r8, SemanticBatchOperation r9, List<ip> r10, Set<String> r11, Map<String, Long> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "operation");
        Intrinsics.checkNotNullParameter(r4, "existing");
        Intrinsics.checkNotNullParameter(r5, "targetKeys");
        Intrinsics.checkNotNullParameter(r6, "expectedChangeSeqs");
        return new g(r8, r9, r4, r5, r6);
    }

    public final SemanticBatchOperation b() {
        return this.f13121b;
    }

    public final List<ip> c() {
        return this.c;
    }

    public final Set<String> d() {
        return this.d;
    }

    public final Map<String, Long> e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (this.f13120a == r6.f13120a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13121b, r6.f13121b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        return (((((((Integer.hashCode(this.f13120a) * 31) + this.f13121b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ResolvedSemanticOperation(index=" + this.f13120a + ", operation=" + this.f13121b + ", existing=" + this.c + ", targetKeys=" + this.d + ", expectedChangeSeqs=" + this.e + ')';
    }
}
