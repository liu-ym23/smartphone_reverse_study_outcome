package com.obric.memorydata.memory.ui;

import androidx.fragment.app.Fragment;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u001cJ\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\bJ\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u0010\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/ui/MemoryCalendarListPageAdapter;", "Lcom/obric/oui/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "fragmentCreator", "Lkotlin/Function1;", "Ljava/time/LocalDate;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/obric/oui/viewpager2/widget/ViewPager2;Lkotlin/jvm/functions/Function1;)V", "getViewPager", "()Lcom/obric/oui/viewpager2/widget/ViewPager2;", "getFragmentCreator", "()Lkotlin/jvm/functions/Function1;", "dateList", "", "createFragment", "position", "", "getItemCount", "getItemId", "", "containsItem", "", "itemId", "setDateList", "", "", "setCurrentItem", "date", "getCurrentDate", "getDate", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends com.obric.oui.viewpager2.adapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10772a = null;
    private final ViewPager2 g;
    private final Function1<LocalDate, Fragment> h;
    private final List<LocalDate> i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/MemoryCalendarListPageAdapter$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10772a = new a(null);
    }

    public d(Fragment r3, ViewPager2 r4, Function1<? super LocalDate, ? extends Fragment> r5) {
        Function1<LocalDate, Fragment> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewPager");
        Intrinsics.checkNotNullParameter(r6, "fragmentCreator");
        super(r3);
        this.g = r4;
        this.h = r6;
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public final int a(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        int r3 = this.i.indexOf(r2);
        if (r3 != (-1)) goto L5;
    L7:
        return r3;
    L5:
        if (this.g.getCurrentItem() == r3) goto L7;
        this.g.a(r3, false);
        goto L7
    }

    public final LocalDate a() {
        int r0 = this.g.getCurrentItem();
        if (r0 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r0 >= this.i.size()) goto L7;
        return (LocalDate) ZeusTransformUtils.preCheckCast(this.i.get(r0), LocalDate.class, "com.obric.memorydata.plugin");
    }

    public final void a(List<LocalDate> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dateList");
        if (Intrinsics.areEqual(this.i, r5) == false) goto L5;
        return;
    L5:
        this.i.clear();
        this.i.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        h();
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public boolean a(long r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L15;
        if (((LocalDate) ZeusTransformUtils.preCheckCast(r8.next(), LocalDate.class, "com.obric.memorydata.plugin")).toEpochDay() != r7) goto L13;
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
    public Fragment b(int r3) {
        LocalDate r4 = (LocalDate) ZeusTransformUtils.preCheckCast(this.i.get(r3), LocalDate.class, "com.obric.memorydata.plugin");
        return (Fragment) ZeusTransformUtils.preCheckCast(this.h.invoke(r4), Fragment.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.viewpager2.adapter.a, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r2) {
        return ((LocalDate) ZeusTransformUtils.preCheckCast(this.i.get(r2), LocalDate.class, "com.obric.memorydata.plugin")).toEpochDay();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.i.size();
    }

    public final LocalDate d(int r2) {
        return (LocalDate) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.i, r2), LocalDate.class, "com.obric.memorydata.plugin");
    }
}
