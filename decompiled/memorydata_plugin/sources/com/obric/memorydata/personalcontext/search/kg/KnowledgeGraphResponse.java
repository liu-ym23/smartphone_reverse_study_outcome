package com.obric.memorydata.personalcontext.search.kg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"Lcom/obric/memorydata/personalcontext/search/kg/KnowledgeGraphResponse;", "", "relation_spo", "", "", "sourceIndex", "Lcom/obric/memorydata/personalcontext/search/kg/KGSourceIndex;", "spo_objects", "po_list", "Lcom/obric/memorydata/personalcontext/search/kg/KGPOEntity;", "nameList", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/personalcontext/search/kg/KGSourceIndex;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getRelation_spo", "()Ljava/util/List;", "getSourceIndex", "()Lcom/obric/memorydata/personalcontext/search/kg/KGSourceIndex;", "getSpo_objects", "getPo_list", "getNameList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KnowledgeGraphResponse {
    private final List<String> nameList;
    private final List<KGPOEntity> po_list;
    private final List<String> relation_spo;
    private final KGSourceIndex sourceIndex;
    private final List<String> spo_objects;

    public KnowledgeGraphResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public KnowledgeGraphResponse(List<String> r3, KGSourceIndex r4, List<String> r5, List<KGPOEntity> r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<KGPOEntity> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.relation_spo = r8;
        this.sourceIndex = r4;
        this.spo_objects = r9;
        this.po_list = r10;
        this.nameList = r11;
    }

    public /* synthetic */ KnowledgeGraphResponse(List r8, KGSourceIndex r9, List r10, List r11, List r12, int r13, DefaultConstructorMarker r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r18 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        List r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        KGSourceIndex r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r13 & 16) == 0) goto L21;
        List r6 = null;
    L22:
        this(r2, r3, r4, r5, r6);
        return;
    L21:
        r6 = r18;
        goto L22
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public static /* synthetic */ KnowledgeGraphResponse copy$default(KnowledgeGraphResponse r6, List r7, KGSourceIndex r8, List r9, List r10, List r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<KGPOEntity> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r14 = r6.relation_spo;
    L5:
        List<String> r1 = r14;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.sourceIndex;
    L8:
        KGSourceIndex r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r15 = r6.spo_objects;
    L11:
        List<String> r3 = r15;
        if ((r12 & 8) == 0) goto L14;
        r16 = r6.po_list;
    L14:
        List<KGPOEntity> r4 = r16;
        if ((r12 & 16) == 0) goto L18;
        r17 = r6.nameList;
    L18:
        return r6.copy(r1, r2, r3, r4, r17);
    }

    public final List<String> component1() {
        return this.relation_spo;
    }

    public final KGSourceIndex component2() {
        return this.sourceIndex;
    }

    public final List<String> component3() {
        return this.spo_objects;
    }

    public final List<KGPOEntity> component4() {
        return this.po_list;
    }

    public final List<String> component5() {
        return this.nameList;
    }

    public final KnowledgeGraphResponse copy(List<String> r8, KGSourceIndex r9, List<String> r10, List<KGPOEntity> r11, List<String> r12) {
        return new KnowledgeGraphResponse((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), r9, (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, KnowledgeGraphResponse.class) == true) goto L8;
        return false;
    L8:
        KnowledgeGraphResponse r6 = (KnowledgeGraphResponse) ZeusTransformUtils.preCheckCast(r5, KnowledgeGraphResponse.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.relation_spo, r6.relation_spo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceIndex, r6.sourceIndex) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spo_objects, r6.spo_objects) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.po_list, r6.po_list) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nameList, r6.nameList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final List<String> getNameList() {
        return this.nameList;
    }

    public final List<KGPOEntity> getPo_list() {
        return this.po_list;
    }

    public final List<String> getRelation_spo() {
        return this.relation_spo;
    }

    public final KGSourceIndex getSourceIndex() {
        return this.sourceIndex;
    }

    public final List<String> getSpo_objects() {
        return this.spo_objects;
    }

    public int hashCode() {
        List<String> r0 = this.relation_spo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        KGSourceIndex r4 = this.sourceIndex;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.spo_objects;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<KGPOEntity> r10 = this.po_list;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.nameList;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeGraphResponse(relation_spo=" + this.relation_spo + ", sourceIndex=" + this.sourceIndex + ", spo_objects=" + this.spo_objects + ", po_list=" + this.po_list + ", nameList=" + this.nameList + ')';
    }
}
