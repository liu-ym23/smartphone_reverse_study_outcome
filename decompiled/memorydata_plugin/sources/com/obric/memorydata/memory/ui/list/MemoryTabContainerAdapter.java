package com.obric.memorydata.memory.ui.list;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryTabContainerAdapter;", "Lcom/obric/memorydata/memory/ui/list/BaseFragmentAdapter;", "hostActivity", "Lcom/obric/memorydata/memory/ui/list/MemoryListActivity;", "onFragmentCountChange", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/obric/memorydata/memory/ui/list/MemoryListActivity;Lkotlin/jvm/functions/Function1;)V", "getOnFragmentCountChange", "()Lkotlin/jvm/functions/Function1;", "buildFragment", "Landroidx/fragment/app/Fragment;", "pageKey", "getFragmentTitle", "", "containsFragment", "", "memoryTab", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "addFragment", "removeFragment", "position", "hasFragment", "getTabPosition", "getTab", "getItemId", "", "containsItem", "itemId", "createNewFragmentInfo", "Lcom/obric/memorydata/memory/ui/list/BaseFragmentAdapter$FragmentInfo;", "getSortedKeys", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryTabContainerAdapter extends BaseFragmentAdapter {
    private final MemoryListActivity hostActivity;
    private final Function1<Integer, Unit> onFragmentCountChange;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            MemoryContainerTab r2 = MemoryContainerTab.Companion.a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
            int r5 = Integer.MAX_VALUE;
            if (r2 == null) goto L5;
            int r6 = r2.getPageOrder();
        L6:
            Comparable r7 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r6), Comparable.class, "com.obric.memorydata.plugin");
            MemoryContainerTab r8 = MemoryContainerTab.Companion.a(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
            if (r8 == null) goto L10;
            r5 = r8.getPageOrder();
        L10:
            return ComparisonsKt.compareValues(r7, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
        L5:
            r6 = Integer.MAX_VALUE;
            goto L6
        }
    }

    public MemoryTabContainerAdapter(MemoryListActivity r3, Function1<? super Integer, Unit> r4) {
        MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
        Function1<Integer, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "hostActivity");
        Intrinsics.checkNotNullParameter(r6, "onFragmentCountChange");
        super((FragmentActivity) ZeusTransformUtils.preCheckCast(r5, FragmentActivity.class, "com.obric.memorydata.plugin"));
        this.hostActivity = r5;
        this.onFragmentCountChange = r6;
    }

    private final Fragment buildFragment(int r6) {
        MemoryContainerTab r0 = MemoryContainerTab.Companion.a(r6);
        if (r0 == null) goto L10;
        Fragment r7 = r0.getFragmentCreator().invoke();
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(r7, Fragment.class, "com.obric.memorydata.plugin");
        Bundle r2 = new Bundle();
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(this.hostActivity.getIntent().getParcelableExtra("entity"), AppEntity.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        r2.putParcelable("entity", (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.memorydata.plugin"));
    L7:
        r1.setArguments(r2);
        return (Fragment) ZeusTransformUtils.preCheckCast(r7, Fragment.class, "com.obric.memorydata.plugin");
    L10:
        throw new IllegalArgumentException("Invalid page key: " + r6);
    }

    private final String getFragmentTitle(int r3) {
        MemoryContainerTab r2 = MemoryContainerTab.Companion.a(r3);
        if (r2 == null) goto L8;
        String r4 = r2.getText();
        if (r4 == null) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException("Invalid page key: " + r3);
    }

    public final void addFragment(MemoryContainerTab r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryTab");
        int r0 = r6.getPageKey();
        if (getFragmentCache().containsKey(Integer.valueOf(r0)) == false) goto L5;
        int r1 = getPositionByKey(r0);
        getFragmentCache().remove(Integer.valueOf(r0));
        notifyItemRemoved(r1);
    L5:
        Fragment r2 = createNewFragmentInfo(r0).a();
        Integer r3 = Integer.valueOf(r0);
        getFragmentCache().put(r3, new BaseFragmentAdapter.a(r2, r6.getText()));
        notifyItemInserted(getPositionByKey(r0));
        this.onFragmentCountChange.invoke(Integer.valueOf(getFragmentCache().size()));
    }

    public final boolean containsFragment(MemoryContainerTab r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryTab");
        return getFragmentCache().containsKey(Integer.valueOf(r2.getPageKey()));
    }

    @Override // com.obric.memorydata.memory.ui.list.BaseFragmentAdapter, androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long r5) {
        if ((-2147483648L) <= r5) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L11;
        return false;
    L11:
        return getFragmentCache().containsKey(Integer.valueOf((int) r5));
    L5:
        if (r5 >= 2147483648L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.obric.memorydata.memory.ui.list.BaseFragmentAdapter
    public BaseFragmentAdapter.a createNewFragmentInfo(int r3) {
        return new BaseFragmentAdapter.a(buildFragment(r3), getFragmentTitle(r3));
    }

    @Override // com.obric.memorydata.memory.ui.list.BaseFragmentAdapter, androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return getKeyAtPosition(r1);
    }

    public final Function1<Integer, Unit> getOnFragmentCountChange() {
        return this.onFragmentCountChange;
    }

    @Override // com.obric.memorydata.memory.ui.list.BaseFragmentAdapter
    public List<Integer> getSortedKeys() {
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(getFragmentCache().keySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
    }

    public final MemoryContainerTab getTab(int r3) {
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(getSortedKeys(), r3), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return MemoryContainerTab.Companion.a(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue());
    }

    public final int getTabPosition(MemoryContainerTab r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryTab");
        return getPositionByKey(r2.getPageKey());
    }

    public final boolean hasFragment(MemoryContainerTab r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryTab");
        return getFragmentCache().containsKey(Integer.valueOf(r2.getPageKey()));
    }

    public final void removeFragment(int r5) {
        List<Integer> r0 = getSortedKeys();
        boolean r2 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r2 == true) goto L9;
        return;
    L9:
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(r5), Number.class, "com.obric.memorydata.plugin")).intValue();
        getFragmentCache().remove(Integer.valueOf(r1));
        notifyItemRemoved(r5);
        if (r5 >= getFragmentCache().size()) goto L12;
        notifyItemRangeChanged(r5, getFragmentCache().size() - r5);
    L12:
        this.onFragmentCountChange.invoke(Integer.valueOf(getFragmentCache().size()));
        return;
    L5:
        if (r5 >= ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r2 = true;
        goto L7
    }

    public final void removeFragment(MemoryContainerTab r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryTab");
        int r3 = getPositionByKey(r2.getPageKey());
        if (r3 < 0) goto L6;
        removeFragment(r3);
        return;
    }
}
