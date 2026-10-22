package com.ss.android.lark.chat.cot.detail;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotStepExposureTracker {
    public final RecyclerView a;
    public final CotDetailBlueprintAdapter b;
    public final Function1<k, Unit> c;
    public final Set<String> d;
    public boolean e;
    public boolean f;
    public ViewTreeObserver g;
    public final a h;
    public final CotStepExposureTracker$scrollListener$1 i;
    public final CotStepExposureTracker$childAttachListener$1 j;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ CotStepExposureTracker a;

        public a(CotStepExposureTracker r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CotStepExposureTracker r0 = this.a;
            r0.b();
            if (r0.e == true) goto L6;
        L47:
            return true;
        L6:
            if (r0.a.isComputingLayout() == false) goto L8;
        L11:
            boolean r1 = true;
        L12:
            if (r1 == false) goto L15;
            r0.a();
            goto L47
        L15:
            if (r0.e == false) goto L47;
            LinearLayoutManager r2 = r0.a.getLayoutManager();
            if ((r2 instanceof LinearLayoutManager) == false) goto L20;
            LinearLayoutManager r3 = r2;
        L21:
            if (r3 == null) goto L47;
            int r4 = r3.findFirstVisibleItemPosition();
            int r5 = r3.findLastVisibleItemPosition();
            if (r4 == (-1)) goto L47;
            if (r5 == (-1)) goto L47;
            IntRange r6 = new IntRange(r4, r5);
            List r7 = r0.b.c.getCurrentList();
            ArrayList r8 = new ArrayList();
            IntIterator r9 = r6.iterator();
        L29:
            if (r9.hasNext() == false) goto L33;
            k r10 = (k) CollectionsKt.getOrNull(r7, r9.nextInt());
            if (r10 == null) goto L29;
            r8.add(r10);
            goto L29
        L33:
            Iterator r11 = r8.iterator();
        L35:
            if (r11.hasNext() == false) goto L47;
            k r12 = (k) r11.next();
            CotDetailBlockType r13 = r12.b;
            if (r13 != CotDetailBlockType.GROUP) goto L39;
        L42:
            boolean r14 = true;
        L43:
            if (r14 == false) goto L35;
            if (r0.d.add(r12.a) == false) goto L35;
            r0.c.invoke(r12);
            goto L35
        L39:
            if (r13 == CotDetailBlockType.TOOLCALL) goto L42;
            r14 = false;
            goto L43
        L20:
            r3 = null;
            goto L21
        L8:
            if (r0.a.hasPendingAdapterUpdates() == true) goto L11;
            r1 = false;
            goto L12
        }
    }

    public final void a() {
        if (this.e == true) goto L6;
        return;
    L6:
        if (this.f == false) goto L8;
        return;
    L8:
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0.isAlive() == true) goto L11;
        return;
    L11:
        this.g = r0;
        this.f = true;
        r0.addOnPreDrawListener(this.h);
        this.a.postInvalidateOnAnimation();
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        ViewTreeObserver r0 = this.g;
        if (r0 != null) goto L8;
    L13:
        this.g = null;
        this.f = false;
        return;
    L8:
        if (r0.isAlive() == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r0.removeOnPreDrawListener(this.h);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.chat.cot.detail.CotStepExposureTracker$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.ss.android.lark.chat.cot.detail.CotStepExposureTracker$childAttachListener$1] */
    public CotStepExposureTracker(RecyclerView r2, CotDetailBlueprintAdapter r3, Function1<? super k, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "onStepView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new LinkedHashSet();
        this.h = new a(this);
        this.i = new CotStepExposureTracker$scrollListener$1(this);
        this.j = new CotStepExposureTracker$childAttachListener$1(this);
    }
}
