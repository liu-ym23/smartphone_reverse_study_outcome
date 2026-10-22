package com.larus.camera.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.utils.TabPickerAdapter;
import com.larus.utils.m0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001-\u0018\u00002\u00020\u0001:\u0001?B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013J\r\u0010,\u001a\u00020-H\u0002¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0016H\u0002J\u0014\u00106\u001a\u00020\u00162\f\u00107\u001a\b\u0012\u0004\u0012\u00020908J\u0006\u0010:\u001a\u00020\u0007J\u001a\u0010;\u001a\u00020\u00162\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160=J\u0016\u0010>\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007R\u001b\u0010\n\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/camera/impl/widget/TabPickerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedColor", "getSelectedColor", "()I", "selectedColor$delegate", "Lkotlin/Lazy;", "unSelectedColor", "getUnSelectedColor", "unSelectedColor$delegate", "isFirstInitialized", "", "isForceInterceptScroll", "setForceInterceptFling", "", "isForceInterceptFling", "tabContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getTabContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "tabContainer$delegate", "tabItemUpdater", "Lcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;", "getTabItemUpdater", "()Lcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;", "tabItemUpdater$delegate", "layoutManager", "Lcom/larus/camera/impl/widget/PickerLayoutManager;", "adapter", "Lcom/larus/camera/impl/utils/TabPickerAdapter;", "helper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "lastSelectedView", "Landroid/view/View;", "selectedPosition", "scrollHandled", "createFlingListener", "com/larus/camera/impl/widget/TabPickerView$createFlingListener$1", "()Lcom/larus/camera/impl/widget/TabPickerView$createFlingListener$1;", "scrollFromFling", "velocityX", "velocityY", "scrollToItemCenter", "position", "smooth", "setWindowPadding", "setTabList", "list", "", "Lcom/larus/camera/impl/widget/TabPickerView$Tab;", "getTabCount", "setOnTabPickedListener", "listener", "Lkotlin/Function1;", "pickFromFlingGesture", "Tab", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabPickerView extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public final Lazy a;
    public final Lazy b;
    public boolean c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final PickerLayoutManager g;
    public final TabPickerAdapter h;
    public final LinearSnapHelper i;
    public View j;
    public int k;
    public boolean l;

    /* JADX INFO: renamed from: com.larus.camera.impl.widget.TabPickerView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Integer, Unit> {
        public AnonymousClass1(Object r8) {
            super(1, r8, TabPickerView.class, "scrollToItemCenter", "scrollToItemCenter(IZ)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int r3) {
            TabPickerView r0 = (TabPickerView) ((AdaptedFunctionReference) this).receiver;
            int r1 = TabPickerView.m;
            r0.f(r3, true);
        }
    }

    public static final class a {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Tab(name=" + this.a + ", selected=" + this.b + ')';
        }

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements PickerLayoutManager.a {
        public final /* synthetic */ TabPickerView a;

        public b(TabPickerView r1) {
            this.a = r1;
        }

        @Override // com.larus.camera.impl.widget.PickerLayoutManager.a
        public final void a(View r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            TabPickerView r0 = this.a;
            if (r0.c == false) goto L5;
            return;
        L5:
            if (r5 != 0.0f) goto L7;
            boolean r6 = true;
        L8:
            if (r6 == true) goto L10;
            return;
        L10:
            if ((r4 instanceof TextView) == false) goto L12;
            ((TextView) r4).setTextColor(TabPickerView.d(r0));
            this.a.j = r4;
        L12:
            this.a.c = true;
            return;
        L7:
            r6 = false;
            goto L8
        }
    }

    public TabPickerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TabPickerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void a(TabPickerView r0) {
        setTabList$lambda$6(r0);
    }

    public static /* synthetic */ void c(TabPickerView r0) {
        setTabList$lambda$6$lambda$5(r0);
    }

    private final int getSelectedColor() {
        return ((Number) this.a.getValue()).intValue();
    }

    private final RecyclerView getTabContainer() {
        return (RecyclerView) this.e.getValue();
    }

    private final PickerLayoutManager.a getTabItemUpdater() {
        return (PickerLayoutManager.a) this.f.getValue();
    }

    private final int getUnSelectedColor() {
        return ((Number) this.b.getValue()).intValue();
    }

    public final int getTabCount() {
        return this.h.getItemCount();
    }

    public static final /* synthetic */ int d(TabPickerView r0) {
        return r0.getSelectedColor();
    }

    private static final void setTabList$lambda$6(final TabPickerView r2) {
        r2.g.scrollToPosition(r2.k);
        r2.post(new a0(r2));
    }

    private static final void setTabList$lambda$6$lambda$5(TabPickerView r2) {
        r2.f(r2.k, false);
    }

    public final boolean e(int r4) {
        if (Math.abs(r4) > getTabContainer().getMinFlingVelocity()) goto L5;
        return false;
    L5:
        View r0 = this.g.p();
        if (r0 == null) goto L8;
        int r1 = getTabContainer().getChildAdapterPosition(r0);
    L10:
        if (r4 <= 0) goto L12;
        int r5 = 1;
    L13:
        f(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r1 + r5, this.h.getItemCount() - 1), 0), true);
        return true;
    L12:
        r5 = -1;
        goto L13
    L8:
        r1 = this.k;
        goto L10
    }

    public final void setForceInterceptFling(boolean r1) {
        this.d = r1;
    }

    public final void setOnTabPickedListener(final Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        PickerLayoutManager r1 = this.g;
        Function1<? super View, Unit> r2 = new b0(this, r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        r1.b = r2;
    }

    public final void setTabList(List<a> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        this.h.submitList(r4);
        Iterator<T> r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((a) r1).b == false) goto L4;
    L9:
        a r2 = (a) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        this.k = r4.indexOf(r2);
        post(new v(this));
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void f(int r4, boolean r5) {
        View r6 = this.g.findViewByPosition(r4);
        if (r6 != null) goto L5;
        return;
    L5:
        int[] r7 = this.i.calculateDistanceToFinalSnap(this.g, r6);
        if (r7 != null) goto L8;
        return;
    L8:
        if (r5 == false) goto L10;
        Function2 r8 = new TabPickerView$scrollToItemCenter$scroll$1(getTabContainer());
    L11:
        int r0 = r7[0];
        if (r0 == 0) goto L14;
    L15:
        r8.invoke(Integer.valueOf(r0), Integer.valueOf(r7[1]));
        return;
    L14:
        if (r7[1] != 0) goto L15;
        return;
    L10:
        r8 = new TabPickerView$scrollToItemCenter$scroll$2(getTabContainer());
        goto L11
    }

    public TabPickerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new w(r2));
        this.b = LazyKt.lazy(new x(r2));
        this.e = LazyKt.lazy(new y(this));
        this.f = LazyKt.lazy(new z(this));
        PickerLayoutManager r5 = new PickerLayoutManager(r2, getTabItemUpdater());
        this.g = r5;
        TabPickerAdapter r6 = new TabPickerAdapter();
        this.h = r6;
        this.i = new LinearSnapHelper();
        this.k = -1;
        this.l = true;
        FrameLayout.inflate(r2, 2131562928, this);
        getTabContainer().setLayoutManager(r5);
        getTabContainer().setAdapter(r6);
        int r7 = m0.a;
        int r8 = RangesKt.coerceAtLeast(m0.b(getContext()) / 2, 0);
        getTabContainer().setPadding(r8, 0, r8, 0);
        AnonymousClass1 r9 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r9, "scrollListener");
        r6.a = r9;
        getTabContainer().setOnFlingListener(new TabPickerView$createFlingListener$1(this));
        getTabContainer().addOnScrollListener(new AnonymousClass2(this));
    }

    public static Unit b(TabPickerView r3, Function1 r4, View r5) {
        if (r5 != null) goto L5;
        return Unit.INSTANCE;
    L5:
        if (r3.d == false) goto L7;
        r3.f(r3.k, false);
        return Unit.INSTANCE;
    L7:
        int r0 = r3.getTabContainer().getChildAdapterPosition(r5);
        if (r0 != r3.k) goto L11;
        return Unit.INSTANCE;
    L11:
        if ((r5 instanceof TextView) == false) goto L13;
        ((TextView) r5).setTextColor(r3.getSelectedColor());
    L13:
        View r1 = r3.j;
        boolean r2 = r1 instanceof TextView;
        if (r2 == false) goto L20;
        if (r2 == false) goto L17;
        TextView r6 = (TextView) r1;
    L18:
        if (r6 == null) goto L20;
        r6.setTextColor(r3.getUnSelectedColor());
        goto L20
    L17:
        r6 = null;
    L20:
        r3.k = r0;
        r3.j = r5;
        r4.invoke(Integer.valueOf(r0));
        return Unit.INSTANCE;
    }

    public /* synthetic */ TabPickerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
