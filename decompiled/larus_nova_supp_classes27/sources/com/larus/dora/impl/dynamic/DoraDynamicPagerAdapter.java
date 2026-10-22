package com.larus.dora.impl.dynamic;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDynamicPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "fragmentMap", "", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "items", "", "Lcom/larus/dora/impl/dynamic/dsl/DslTab;", "handler", "Landroid/os/Handler;", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "getItemCount", "getItemId", "", "position", "containsItem", "", "itemId", "createFragment", "getFragment", "Lcom/larus/dora/impl/dynamic/DoraDynamicListFragment;", "setSubPages", "", "subPages", "", "setAction", "setCardContext", "updateConnectionState", "state", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDynamicPagerAdapter extends FragmentStateAdapter {
    public final Map<Integer, Fragment> a;
    public d59.b b;
    public final List<c59.e0> c;
    public final Handler d;
    public e59.a e;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public DoraDynamicPagerAdapter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = new Handler(Looper.getMainLooper());
    }

    public final boolean containsItem(long r7) {
        List<c59.e0> r0 = this.c;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L27;
        Map<String, ? extends Object> r2 = ((c59.e0) r1.next()).a;
        if (r2 == null) goto L13;
        long r3 = r2.hashCode();
    L15:
        if (r3 != r7) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L9;
        return true;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = 0;
        goto L15
    L27:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final Fragment createFragment(final int r4) {
        final Fragment r0 = new DoraDynamicListFragment();
        r0.j = this.e;
        Integer r1 = Integer.valueOf(r4);
        this.a.put(r1, r0);
        e59.a r2 = this.e;
        if (r2 == null) goto L5;
        r2.onAction(new e59.e.b());
    L5:
        this.d.post(new w0(r0, r4, this));
        return r0;
    }

    public final long getItemId(int r3) {
        c59.e0 r4 = (c59.e0) CollectionsKt.getOrNull(this.c, r3);
        if (r4 == null) goto L7;
        Map<String, ? extends Object> r5 = r4.a;
        if (r5 == null) goto L7;
        return r5.hashCode();
    L7:
        return 0;
    }

    public final DoraDynamicListFragment y2(int r2) {
        Map<Integer, Fragment> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Object r3 = r1.get(Integer.valueOf(r2));
        if ((r3 instanceof DoraDynamicListFragment) == true) goto L7;
        return null;
    L7:
        return (DoraDynamicListFragment) r3;
    }

    public final void z2(List<c59.e0> r3) {
        Intrinsics.checkNotNullParameter(r3, "subPages");
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r3);
        g49.d.d("DoraDynamicPagerAdapter", "setSubPages, subPages: " + r3.size());
        this.d.post(new y0(this));
    }
}
