package com.obric.memorydata.memory.ui.list;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H$J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010#\u001a\u00020\u0014H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/BaseFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "fragmentCache", "", "", "Lcom/obric/memorydata/memory/ui/list/BaseFragmentAdapter$FragmentInfo;", "getFragmentCache", "()Ljava/util/Map;", "getItemCount", "createFragment", "position", "createNewFragmentInfo", "getTitle", "", "getSortedKeys", "", "getKeyAtPosition", "getPositionByKey", "key", "getItemId", "", "containsItem", "", "itemId", "clear", "", "getFragment", "getFragmentByTitle", "title", "getFragmentsByTitle", "FragmentInfo", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseFragmentAdapter extends FragmentStateAdapter {
    private final Map<Integer, a> fragmentCache;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/BaseFragmentAdapter$FragmentInfo;", "", "fragment", "Landroidx/fragment/app/Fragment;", "title", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Fragment f11001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11002b;

        public a(Fragment r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "title");
            this.f11001a = r2;
            this.f11002b = r3;
        }

        public final Fragment a() {
            return this.f11001a;
        }

        public final String b() {
            return this.f11002b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11001a, r6.f11001a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11002b, r6.f11002b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11001a.hashCode() * 31) + this.f11002b.hashCode();
        }

        public String toString() {
            return "FragmentInfo(fragment=" + this.f11001a + ", title=" + this.f11002b + ')';
        }
    }

    public BaseFragmentAdapter(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3);
        this.fragmentCache = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public BaseFragmentAdapter(FragmentActivity r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        super(r4);
        this.fragmentCache = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public void clear() {
        int r0 = this.fragmentCache.size();
        this.fragmentCache.clear();
        notifyItemRangeRemoved(0, r0);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.fragmentCache.values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L15;
        if (((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).a().hashCode() != r7) goto L13;
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

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int r4) {
        int r5 = getKeyAtPosition(r4);
        Map<Integer, a> r0 = this.fragmentCache;
        Integer r1 = Integer.valueOf(r5);
        a r2 = r0.get(r1);
        if (r2 != null) goto L6;
        r2 = createNewFragmentInfo(r5);
        r0.put(r1, r2);
    L6:
        return ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).a();
    }

    public abstract a createNewFragmentInfo(int r1);

    public Fragment getFragment(int r3) {
        int r4 = getKeyAtPosition(r3);     // Catch: IllegalArgumentException -> L8
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.fragmentCache.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");     // Catch: IllegalArgumentException -> L8
        if (r2 == null) goto L11;
        return r2.a();
    L11:
        return null;
    L12:
        return null;
    }

    public Fragment getFragmentByTitle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "title");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.fragmentCache.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (Intrinsics.areEqual(((a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin")).b(), r5) == false) goto L4;
    L9:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.a();
    L8:
        r0 = null;
        goto L9
    }

    public final Map<Integer, a> getFragmentCache() {
        return this.fragmentCache;
    }

    public List<Fragment> getFragmentsByTitle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "title");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.fragmentCache.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if (((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).a().isAdded() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r3 = r8.next();
        if (Intrinsics.areEqual(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).b(), r5) == false) goto L10;
        r1.add(r3);
        goto L10
    L14:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L19;
        r10.add(((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin")).a());
        goto L16
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fragmentCache.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r3) {
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.fragmentCache.get(Integer.valueOf(getKeyAtPosition(r3))), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        Fragment r4 = r2.a();
        if (r4 == null) goto L9;
        return r4.hashCode();
    L9:
        throw new IllegalStateException("Fragment not found at position " + r3);
    }

    public int getKeyAtPosition(int r4) {
        List<Integer> r3 = getSortedKeys();
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

    public int getPositionByKey(int r1) {
        return getSortedKeys().indexOf(Integer.valueOf(r1));
    }

    public abstract List<Integer> getSortedKeys();

    public String getTitle(int r2) {
        int r3 = getKeyAtPosition(r2);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.fragmentCache.get(Integer.valueOf(r3)), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        String r4 = r1.b();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "null";
    }
}
