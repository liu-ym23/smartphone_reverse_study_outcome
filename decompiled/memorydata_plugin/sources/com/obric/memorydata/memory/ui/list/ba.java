package com.obric.memorydata.memory.ui.list;

import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalFragmentAdapter;", "Lcom/obric/oui/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "fragmentCache", "", "", "getItemCount", "createFragment", "position", "getKeyAtPosition", "getTitle", "", "getItemId", "", "containsItem", "", "itemId", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ba extends com.obric.oui.viewpager2.adapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11222a = null;
    private static final List<String> h = null;
    private final Map<Integer, Fragment> g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalFragmentAdapter$Companion;", "", "<init>", "()V", "displayTags", "", "", "getDisplayTags", "()Ljava/util/List;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final List<String> a() {
            return ba.a();
        }
    }

    static {
        f11222a = new a(null);
        h = CollectionsKt.listOf(new String[]{PersonalTag.f11118a.a(), PersonalTag.f11118a.h(), PersonalTag.f11118a.c(), PersonalTag.f11118a.f()});
    }

    public ba(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3);
        this.g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ List a() {
        return h;
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public boolean a(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3 >= h.size()) goto L7;
        return true;
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public Fragment b(int r4) {
        int r5 = d(r4);
        Map<Integer, Fragment> r3 = this.g;
        Integer r0 = Integer.valueOf(r5);
        Fragment r1 = r3.get(r0);
        if (r1 != null) goto L6;
        r1 = (Fragment) ZeusTransformUtils.preCheckCast(PersonalChildFragment.Companion.a(r5), Fragment.class, "com.obric.memorydata.plugin");
        r3.put(r0, r1);
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r1, Fragment.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.viewpager2.adapter.a, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r1) {
        return d(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return h.size();
    }

    public final int d(int r4) {
        boolean r3 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r3 == false) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException(("Invalid position: " + r4).toString());
    L5:
        if (r4 >= ((Collection) ZeusTransformUtils.preCheckCast(h, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r3 = true;
        goto L7
    }
}
