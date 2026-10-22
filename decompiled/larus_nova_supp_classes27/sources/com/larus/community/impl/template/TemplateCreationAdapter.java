package com.larus.community.impl.template;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.larus.platform.api.creation.TabItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/community/impl/template/TemplateCreationAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "value", "", "Lcom/larus/platform/api/creation/TabItemInfo;", "tabList", "getTabList", "()Ljava/util/List;", "updateTabList", "", "getItemCount", "", "getItemId", "", "position", "containsItem", "", "itemId", "createFragment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationAdapter extends FragmentStateAdapter {
    public final Fragment a;
    public final zp9.m b;
    public final RecyclerView.RecycledViewPool c;
    public List<TabItemInfo> d;

    public final int getItemCount() {
        List<TabItemInfo> r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final boolean containsItem(long r6) {
        List<TabItemInfo> r0 = this.d;
        if (r0 == null) goto L18;
        List<TabItemInfo> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        String r4 = ((TabItemInfo) r3.next()).getId();
        if (r4 != null) goto L10;
        r4 = "DEFAULT";
    L10:
        r2.add(Long.valueOf(r4.hashCode()));
        goto L6
    L12:
        if (r2.contains(Long.valueOf(r6)) != true) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    public final Fragment createFragment(int r4) {
        List<TabItemInfo> r0 = this.d;
        if (r0 == null) goto L14;
        Parcelable r5 = (TabItemInfo) CollectionsKt.getOrNull(r0, r4);
        if (r5 == null) goto L14;
        TemplateCreationListFragment r1 = new TemplateCreationListFragment();
        r1.e = this.b;
        r1.d = this.c;
        Bundle r2 = this.a.getArguments();
        if (r2 == null) goto L10;
        Bundle r3 = new Bundle(r2);
    L11:
        r3.putParcelable("key_tab_item_info", r5);
        r1.setArguments(r3);
        return r1;
    L10:
        r3 = new Bundle();
    L14:
        return new Fragment();
    }

    public final long getItemId(int r3) {
        List<TabItemInfo> r0 = this.d;
        if (r0 == null) goto L8;
        TabItemInfo r4 = (TabItemInfo) CollectionsKt.getOrNull(r0, r3);
        if (r4 == null) goto L8;
        String r5 = r4.getId();
        if (r5 == null) goto L8;
    L10:
        return r5.hashCode();
    L8:
        r5 = "DEFAULT";
        goto L10
    }

    public TemplateCreationAdapter(Fragment r2, zp9.m r3, RecyclerView.RecycledViewPool r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
