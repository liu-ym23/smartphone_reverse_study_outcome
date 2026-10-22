package com.obric.memorydata.memory.ui.list;

import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryFragmentAdapter;", "Lcom/obric/oui/viewpager2/adapter/FragmentStateAdapter;", "containerFragment", "Lcom/obric/memorydata/memory/ui/list/GlobalMemoryTabFragment;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/GlobalMemoryTabFragment;)V", "fragmentCache", "", "", "Lcom/obric/memorydata/memory/ui/list/MemoryFragmentAdapter$FragmentInfo;", "pageOrder", "Lcom/obric/memorydata/memory/ui/list/MemorySourcePageOrder;", "sourceFilters", "", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "submitSourceFilters", "", "filters", "getSourceFilter", "position", "getPositionBySourceKey", "sourceKey", "", "createNewFragmentInfo", "getItemCount", "createFragment", "Landroidx/fragment/app/Fragment;", "getSortedKeys", "getKeyAtPosition", "getItemId", "", "containsItem", "", "itemId", "keyFor", "filter", "FragmentInfo", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u extends com.obric.oui.viewpager2.adapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GlobalMemoryTabFragment f11330a;
    private final Map<Integer, a> g;
    private final ag h;
    private List<MemorySourceFilter> i;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryFragmentAdapter$FragmentInfo;", "", "fragment", "Landroidx/fragment/app/Fragment;", "title", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Fragment f11331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11332b;

        public a(Fragment r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "title");
            this.f11331a = r2;
            this.f11332b = r3;
        }

        public final Fragment a() {
            return this.f11331a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11331a, r6.f11331a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11332b, r6.f11332b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11331a.hashCode() * 31) + this.f11332b.hashCode();
        }

        public String toString() {
            return "FragmentInfo(fragment=" + this.f11331a + ", title=" + this.f11332b + ')';
        }
    }

    public u(GlobalMemoryTabFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "containerFragment");
        super((Fragment) ZeusTransformUtils.preCheckCast(r3, Fragment.class, "com.obric.memorydata.plugin"));
        this.f11330a = r3;
        this.g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.h = new ag();
        this.i = CollectionsKt.emptyList();
    }

    private final int a(MemorySourceFilter r1) {
        return b(r1.getStableKey());
    }

    private final List<Integer> a() {
        return this.h.a();
    }

    private final int b(String r1) {
        if (Intrinsics.areEqual(r1, MemorySourceFilter.KEY_ALL) == false) goto L6;
        return 0;
    L6:
        return r1.hashCode();
    }

    private final a h(int r8) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (a((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r1, MemorySourceFilter.class, "com.obric.memorydata.plugin")) != r8) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L4;
    L12:
        MemorySourceFilter r7 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r1, MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        r7 = MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null);
    L16:
        return new a((Fragment) ZeusTransformUtils.preCheckCast(MemoryListFragment.Companion.a(MemoryTab.COLLECT.ordinal(), r7), Fragment.class, "com.obric.memorydata.plugin"), r7.getSourceAppName());
    L8:
        r6 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    private final int i(int r4) {
        List<Integer> r3 = a();
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        return ((Number) ZeusTransformUtils.preCheckCast(r3.get(r4), Number.class, "com.obric.memorydata.plugin")).intValue();
    L11:
        throw new IllegalArgumentException(("Invalid position: " + r4).toString());
    L5:
        if (r4 >= ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r1 = true;
        goto L7
    }

    public final int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceKey");
        int r3 = b(r2);
        return this.h.a().indexOf(Integer.valueOf(r3));
    }

    public final void a(List<MemorySourceFilter> r7) {
        List<MemorySourceFilter> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "filters");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        this.i = r8;
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.h.a(), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r3.add(Integer.valueOf(a((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r4.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin"))));
        goto L7
    L9:
        List<Integer> r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r1.iterator();
    L11:
        if (r9.hasNext() == false) goto L15;
        Object r10 = r9.next();
        if (r5.contains(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue())) == true) goto L11;
        r6.add(r10);
        goto L11
    L15:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        this.g.remove(Integer.valueOf(r12));
        goto L17
    L19:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r13.hasNext() == false) goto L26;
        int r14 = a((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r13.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin"));
        if (this.g.containsKey(Integer.valueOf(r14)) == true) goto L21;
        Integer r15 = Integer.valueOf(r14);
        this.g.put(r15, h(r14));
        goto L21
    L26:
        if (this.h.update(r5) == false) goto L41;
        h();
        return;
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public boolean a(long r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.h.a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L15;
        if (((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.memorydata.plugin")).intValue() != r7) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
        return true;
    L13:
        r0 = false;
    L15:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public Fragment b(int r4) {
        int r5 = i(r4);
        Map<Integer, a> r0 = this.g;
        Integer r1 = Integer.valueOf(r5);
        a r2 = r0.get(r1);
        if (r2 != null) goto L6;
        r2 = h(r5);
        r0.put(r1, r2);
    L6:
        return ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.obric.oui.viewpager2.adapter.a, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r1) {
        return i(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.h.a().size();
    }

    public final MemorySourceFilter d(int r5) {
        int r6 = i(r5);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (a((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r1, MemorySourceFilter.class, "com.obric.memorydata.plugin")) != r6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L13:
        return (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r1, MemorySourceFilter.class, "com.obric.memorydata.plugin");
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }
}
