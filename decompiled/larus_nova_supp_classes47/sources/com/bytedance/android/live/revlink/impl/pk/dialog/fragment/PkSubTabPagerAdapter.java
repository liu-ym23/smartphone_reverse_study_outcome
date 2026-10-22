package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/PkSubTabPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkSubTabPagerAdapter extends FragmentPagerAdapter {
    public final Lazy a;
    public final Lazy b;
    public final ArrayMap<String, Integer> c;
    public final FragmentManager d;
    public final a e;

    public interface a {
        RevLinkSubListFragment zy(y7 r1);
    }

    public final List<BaseSubFragment> g() {
        return (List) this.a.getValue();
    }

    public final int getCount() {
        if (g().isEmpty() == false) goto L6;
        return 0;
    L6:
        return g().size();
    }

    public final Fragment f(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < g().size()) goto L7;
        return null;
    L7:
        return (Fragment) ListProtector.get(g(), r2);
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(g(), r2);
    }

    public final long getItemId(int r3) {
        return ((BaseSubFragment) ListProtector.get(g(), r3)).getUniqueId().hashCode();
    }

    public final int getItemPosition(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "obj");
        Fragment r0 = (Fragment) r5;
        Bundle r1 = r0.getArguments();
        if (r1 == null) goto L14;
        if (r1.containsKey("_uuid") == false) goto L14;
        String r6 = r1.getString("_uuid");
        Integer r7 = (Integer) this.c.get(r6);
        if (r7 == null) goto L11;
        int r2 = CollectionsKt.indexOf(g(), r0);
        if (r7.intValue() != r2) goto L11;
        return -1;
    L11:
        return -2;
    L14:
        return super/*androidx.viewpager.widget.PagerAdapter*/.getItemPosition(r5);
    }

    public final void h(List<? extends y7> r12) {
        List<? extends y7> r0 = r12;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        g().clear();
        ((ArrayMap) this.b.getValue()).clear();
        notifyDataSetChanged();
        return;
    L11:
        int r3 = r12.size();
        int r4 = g().size();
        Iterator<T> r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L31;
        Object r5 = r13.next();
        int r6 = r1 + 1;
        if (r1 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        y7 r7 = (y7) r5;
        IPkSubTabKey r8 = r7.getKey();
        String r9 = r7.getName();
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        Intrinsics.checkNotNullParameter(r9, "name");
        StringBuilder r10 = new StringBuilder("loadType-");
        r10.append(com.bytedance.android.live.revlink.impl.pk.dialog.vm.b.a(r8));
        r10.append("-actId-");
        if (r8 == null) goto L23;
        Long r14 = Long.valueOf(r8.getFlexActivityId());
    L24:
        r10.append(r14);
        r10.append('-');
        r10.append(r9);
        String r15 = r10.toString();
        BaseSubFragment r16 = (BaseSubFragment) ((ArrayMap) this.b.getValue()).get(r15);
        if (r16 != null) goto L27;
        r16 = this.e.zy(r7);
        ((ArrayMap) this.b.getValue()).put(r15, r16);
    L27:
        if (r1 < r4) goto L29;
        g().add(r16);
    L30:
        r1 = r6;
        goto L13
    L29:
        ListProtector.set(g(), r1, r16);
        goto L30
    L23:
        r14 = null;
        goto L24
    L31:
        if (r3 >= r4) goto L37;
        int r17 = r4 - 1;
        if (r17 < r3) goto L37;
    L34:
        ListProtector.remove(g(), r17);
        if (r17 == r3) goto L37;
        r17 = r17 - 1;
    L37:
        notifyDataSetChanged();
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public PkSubTabPagerAdapter(FragmentManager r2, RevLinkAnchorListFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "generateCallback");
        super(r2);
        this.d = r2;
        this.e = r3;
        this.a = LazyKt.lazy(PkSubTabPagerAdapter$fragments$2.INSTANCE);
        this.b = LazyKt.lazy(PkSubTabPagerAdapter$fragmentMap$2.INSTANCE);
        this.c = new ArrayMap();
    }

    public final Object instantiateItem(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Object r6 = super.instantiateItem(r4, r5);
        if (r6 == null) goto L13;
        BaseSubFragment r7 = (BaseSubFragment) r6;
        String r0 = r7.getUniqueId();
        Bundle r1 = r7.getArguments();
        if (r1 != null) goto L7;
        r1 = new Bundle();
    L7:
        r1.putString("_uuid", r0);
        if (r7.isStateSaved() == true) goto L10;
        r7.setArguments(r1);
    L10:
        this.c.put(r0, Integer.valueOf(r5));
        return r7;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.dialog.fragment.BaseSubFragment");
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "obj");
        super.destroyItem(r2, r3, r4);
    }
}
