package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.assistant.omnidetailpage.localmedia.TaskLocalVideoAutoPlayManager$attachToRecyclerView$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k0 extends OmniDetailVerticalLineFrameLayout {
    public final com.obric.assistant.omnidetailpage.localmedia.w c;
    public final LinearLayoutManager d;
    public final RecyclerView e;
    public final CoroutineScope f;
    public List<? extends ifa.c> g;
    public List<? extends ifa.c> h;
    public LocalMediaDisplayMode i;
    public final b j;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LocalMediaDisplayMode.values().length];
            r0[LocalMediaDisplayMode.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LocalMediaDisplayMode.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final int b() {
        int r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = com.larus.utils.m0.a;
        return RangesKt.coerceAtLeast((com.larus.utils.m0.b(getContext()) - getPaddingLeft()) - getPaddingRight(), 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new g0(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.obric.assistant.omnidetailpage.localmedia.w r0 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "owner");
        com.obric.assistant.omnidetailpage.localmedia.y r1 = r0.d;
        if (r1 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(((LinkedHashMap) r0.b).get(r1), this) == false) goto L9;
        r1.R3();
        r0.d = null;
        return;
    }

    public final void a(ifa.f.e r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        setShowLine(r5.c);
        List<ifa.c> r0 = r5.h;
        this.g = r0;
        this.h = r5.i;
        List<ifa.c> r1 = r0;
        boolean r2 = false;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r1.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        if ((((ifa.c) r6.next()) instanceof ifa.c.b) == false) goto L9;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        LocalMediaDisplayMode r8 = LocalMediaDisplayMode.VERTICAL;
    L17:
        this.i = r8;
        int r3 = a.a[r8.ordinal()];
        if (r3 != 1) goto L20;
        int r4 = 0;
    L26:
        if (this.d.getOrientation() == r4) goto L28;
        this.d.setOrientation(r4);
    L28:
        RecyclerView r9 = this.e;
        if (r8 != LocalMediaDisplayMode.HORIZONTAL) goto L31;
        r2 = true;
    L31:
        r9.setNestedScrollingEnabled(r2);
        this.j.y2(this.g, b(), this.i);
        this.e.post(new i0(this));
        return;
    L20:
        if (r3 != 2) goto L23;
        r4 = 1;
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L16:
        r8 = LocalMediaDisplayMode.HORIZONTAL;
    L13:
        r7 = false;
        goto L14
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.assistant.omnidetailpage.blockview.h0] */
    public k0(final Context r10, final com.obric.assistant.omnidetailpage.localmedia.w r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "autoPlayManager");
        super(r10, null, 0);
        this.c = r11;
        LinearLayoutManager r2 = new LinearLayoutManager(r10, 0, false);
        this.d = r2;
        RecyclerView r3 = new RecyclerView(r10);
        r3.setLayoutManager(r2);
        r3.setOverScrollMode(2);
        r3.setClipToPadding(false);
        this.e = r3;
        CoroutineScope r0 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f = r0;
        this.g = CollectionsKt.emptyList();
        this.h = CollectionsKt.emptyList();
        this.i = LocalMediaDisplayMode.HORIZONTAL;
        b r4 = new b(this, r11, new h0(this, r10));
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r4.f = r0;
        this.j = r4;
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setPadding(i5.q(), i5.j0(), i5.q(), i5.j0());
        ImageCardNestedScrollableHost r1 = new ImageCardNestedScrollableHost(r10);
        r1.setClipToPadding(false);
        addView(r1, new FrameLayout.LayoutParams(-1, -2));
        r1.addView(r3, new FrameLayout.LayoutParams(-1, -2));
        r3.setAdapter(r4);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        r3.addOnScrollListener(new TaskLocalVideoAutoPlayManager$attachToRecyclerView$1(r11));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        return;
    L5:
        if ((!this.g.isEmpty()) == false) goto L9;
        this.j.y2(this.g, b(), this.i);
        this.e.post(new f0(this));
        return;
    }
}
