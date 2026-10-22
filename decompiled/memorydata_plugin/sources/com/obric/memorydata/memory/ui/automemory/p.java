package com.obric.memorydata.memory.ui.automemory;

import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryPagerAdapter;", "Lcom/obric/oui/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getItemCount", "", "createFragment", "position", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p extends com.obric.oui.viewpager2.adapter.a {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10713a = null;

        static {
            int[] r0 = new int[AutoMemoryTab.values().length];
            r0[AutoMemoryTab.AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AutoMemoryTab.DISCOVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10713a = r0;
        }
    }

    public p(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public Fragment b(int r2) {
        AutoMemoryTab r1 = AutoMemoryTab.Companion.a(r2);
        if (r1 != null) goto L5;
        int r3 = -1;
    L7:
        if (r3 != 1) goto L9;
        Object r4 = new AutoMemoryMyCollectionsFragment();
    L14:
        return (Fragment) ZeusTransformUtils.preCheckCast(r4, Fragment.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 == 2) goto L11;
        r4 = new AutoMemoryMyCollectionsFragment();
        goto L14
    L11:
        r4 = new AutoMemoryRecommendCollectionsFragment();
        goto L14
    L5:
        r3 = a.f10713a[r1.ordinal()];
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return AutoMemoryTab.values().length;
    }
}
