package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.entity.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailUiState;", "", "title", "", "rule", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "groups", "", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListGroup;", "isSelectionMode", "", "selectedItemIds", "", "", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/database/entity/MemoryRuleEntity;Ljava/util/List;ZLjava/util/Set;)V", "getTitle", "()Ljava/lang/String;", "getRule", "()Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "getGroups", "()Ljava/util/List;", "()Z", "getSelectedItemIds", "()Ljava/util/Set;", "isAllSelected", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryRuleEntity f10705b;
    private final List<b> c;
    private final boolean d;
    private final Set<Long> e;

    public d() {
        this(null, null, null, false, null, 31, null);
    }

    public d(String r3, MemoryRuleEntity r4, List<b> r5, boolean r6, Set<Long> r7) {
        List<b> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Set<Long> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r8, "groups");
        Intrinsics.checkNotNullParameter(r9, "selectedItemIds");
        this.f10704a = r3;
        this.f10705b = r4;
        this.c = r8;
        this.d = r6;
        this.e = r9;
    }

    public /* synthetic */ d(String r7, MemoryRuleEntity r8, List r9, boolean r10, Set r11, int r12, DefaultConstructorMarker r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = "";
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = null;
    L8:
        MemoryRuleEntity r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = CollectionsKt.emptyList();
    L11:
        List r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r10 = false;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L17;
        r15 = SetsKt.emptySet();
    L17:
        this(r1, r2, r3, r4, r15);
    }

    public static /* synthetic */ d a(d r6, String r7, MemoryRuleEntity r8, List r9, boolean r10, Set r11, int r12, Object r13) {
        List<b> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Set<Long> r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f10704a;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.f10705b;
    L8:
        MemoryRuleEntity r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.c;
    L11:
        List<b> r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.d;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r15 = r6.e;
    L18:
        return r6.a(r1, r2, r3, r4, r15);
    }

    private static final Sequence a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "group");
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2.b(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Sequence lambda$g65wNbhGgGg19P3OJUJcWpozECM(b r0) {
        return a(r0);
    }

    public final d a(String r8, MemoryRuleEntity r9, List<b> r10, boolean r11, Set<Long> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r4, "groups");
        Intrinsics.checkNotNullParameter(r6, "selectedItemIds");
        return new d(r8, r9, r4, r11, r6);
    }

    public final String a() {
        return this.f10704a;
    }

    public final MemoryRuleEntity b() {
        return this.f10705b;
    }

    public final List<b> c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final Set<Long> e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10704a, r6.f10704a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10705b, r6.f10705b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean f() {
        Iterator r0 = SequencesKt.flatMap(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$d$g65wNbhGgGg19P3OJUJcWpozECM.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0.next(), y.class, "com.obric.memorydata.plugin");
        if (this.e.contains(Long.valueOf(r1.a())) == true) goto L4;
        return false;
    L8:
        return true;
    }

    public int hashCode() {
        int r0 = this.f10704a.hashCode() * 31;
        MemoryRuleEntity r1 = this.f10705b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AutoMemoryCollectionDetailUiState(title=" + this.f10704a + ", rule=" + this.f10705b + ", groups=" + this.c + ", isSelectionMode=" + this.d + ", selectedItemIds=" + this.e + ')';
    }
}
