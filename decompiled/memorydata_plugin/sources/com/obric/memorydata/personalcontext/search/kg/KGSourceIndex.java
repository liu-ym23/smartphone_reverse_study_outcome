package com.obric.memorydata.personalcontext.search.kg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/kg/KGSourceIndex;", "", "relation", "", "Lcom/obric/memorydata/personalcontext/search/kg/KGSourceEntity;", "property", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getRelation", "()Ljava/util/List;", "getProperty", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KGSourceIndex {
    private final List<KGSourceEntity> property;
    private final List<KGSourceEntity> relation;

    /* JADX WARN: Multi-variable type inference failed */
    public KGSourceIndex() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public KGSourceIndex(List<KGSourceEntity> r3, List<KGSourceEntity> r4) {
        List<KGSourceEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<KGSourceEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.relation = r5;
        this.property = r6;
    }

    public /* synthetic */ KGSourceIndex(List r2, List r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = null;
    L8:
        this(r6, r7);
    }

    public static /* synthetic */ KGSourceIndex copy$default(KGSourceIndex r1, List r2, List r3, int r4, Object r5) {
        List<KGSourceEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<KGSourceEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.relation;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.property;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<KGSourceEntity> component1() {
        return this.relation;
    }

    public final List<KGSourceEntity> component2() {
        return this.property;
    }

    public final KGSourceIndex copy(List<KGSourceEntity> r2, List<KGSourceEntity> r3) {
        return new KGSourceIndex((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, KGSourceIndex.class) == true) goto L8;
        return false;
    L8:
        KGSourceIndex r6 = (KGSourceIndex) ZeusTransformUtils.preCheckCast(r5, KGSourceIndex.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.relation, r6.relation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.property, r6.property) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<KGSourceEntity> getProperty() {
        return this.property;
    }

    public final List<KGSourceEntity> getRelation() {
        return this.relation;
    }

    public int hashCode() {
        List<KGSourceEntity> r0 = this.relation;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<KGSourceEntity> r4 = this.property;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KGSourceIndex(relation=" + this.relation + ", property=" + this.property + ')';
    }
}
