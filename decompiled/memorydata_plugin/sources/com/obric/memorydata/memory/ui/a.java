package com.obric.memorydata.memory.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0002\u0019\u001c\u0018\u00002\u00020\u0001B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\rB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "viewPagerController", "Lcom/obric/memorydata/memory/ui/ViewPagerInputController;", "disallowParentInterceptWhenVerticalOffset", "", "disableViewPagerInputDuringRecyclerScroll", "<init>", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;Lcom/obric/memorydata/memory/ui/ViewPagerInputController;ZZ)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;Landroidx/viewpager2/widget/ViewPager2;ZZ)V", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;Lcom/obric/oui/viewpager2/widget/ViewPager2;ZZ)V", "getRecyclerView", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", EventBody.KEY_VALUE, "allowViewPager2Fling", "getAllowViewPager2Fling", "()Z", "setAllowViewPager2Fling", "(Z)V", "listener", "com/obric/memorydata/memory/ui/ConflictWithViewPage2Handler$listener$1", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler$listener$1;", "touchListener", "com/obric/memorydata/memory/ui/ConflictWithViewPage2Handler$touchListener$1", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler$touchListener$1;", "remove", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView f10553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f10554b;
    private final boolean c;
    private final boolean d;
    private boolean e;
    private final C0516a f;
    private final b g;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/ConflictWithViewPage2Handler$listener$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0516a extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f10555a;

        C0516a(a r1) {
            this.f10555a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            super.a(r2, r3);
            if (r3 != 0) goto L5;
            n r4 = a.b(this.f10555a);
            if (r4 == null) goto L23;
            r4.a(this.f10555a.b());
            return;
        L23:
            return;
        L5:
            if (r3 != 1) goto L7;
        L9:
            if (r3 != 1) goto L12;
            g.f10964a.a();
        L12:
            if (a.a(this.f10555a) == false) goto L20;
            n r1 = a.b(this.f10555a);
            if (r1 == null) goto L21;
            r1.a(false);
            return;
        L21:
            return;
        L20:
            return;
        L7:
            if (r3 == 2) goto L9;
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"com/obric/memorydata/memory/ui/ConflictWithViewPage2Handler$touchListener$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnItemTouchListener;", "touchSlop", "", "downX", "", "downY", "startedWithVerticalOffset", "", "hasVerticalGesture", "onInterceptTouchEvent", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "handleTouchEvent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f10556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10557b;
        private float c;
        private float d;
        private boolean e;
        private boolean f;

        b(a r3) {
            this.f10556a = r3;
            this.f10557b = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        }

        private final void c(RecyclerView r13, MotionEvent r14) {
            int r0 = r14.getActionMasked();
            if (r0 == 0) goto L35;
            if (r0 != 1) goto L6;
        L27:
            this.e = false;
            this.f = false;
            ViewParent r15 = r13.getParent();
            if (r15 == null) goto L31;
            r15.requestDisallowInterceptTouchEvent(false);
        L31:
            if (r13.getScrollState() != 0) goto L41;
            n r16 = a.b(this.f10556a);
            if (r16 == null) goto L42;
            r16.a(this.f10556a.b());
            return;
        L42:
            return;
        L41:
            return;
        L6:
            if (r0 != 2) goto L8;
            float r4 = Math.abs(r14.getX() - this.c);
            float r5 = Math.abs(r14.getY() - this.d);
            if (this.f == false) goto L13;
        L17:
            o r3 = o.f11379a;
            int r6 = this.f10557b;
            if (this.e == false) goto L20;
        L23:
            boolean r7 = true;
        L24:
            boolean r12 = r3.a(r4, r5, r6, r7, m.b(r13), this.f, this.f10556a.b(), a.c(this.f10556a));
            ViewParent r17 = r13.getParent();
            if (r17 == null) goto L39;
            r17.requestDisallowInterceptTouchEvent(r12);
            return;
        L39:
            return;
        L20:
            if (m.a(r13) == true) goto L23;
            r7 = false;
            goto L24
        L13:
            if (r5 <= this.f10557b) goto L17;
            if (r5 < r4) goto L17;
            this.f = true;
            goto L17
        L8:
            if (r0 == 3) goto L27;
            return;
        L35:
            this.c = r14.getX();
            this.d = r14.getY();
            this.e = m.a(r13);
            this.f = false;
            ViewParent r18 = r13.getParent();
            if (r18 == null) goto L44;
            r18.requestDisallowInterceptTouchEvent(true);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void a(boolean r1) {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public boolean a(RecyclerView r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "rv");
            Intrinsics.checkNotNullParameter(r3, "event");
            c(r2, r3);
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void b(RecyclerView r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "rv");
            Intrinsics.checkNotNullParameter(r3, "event");
            c(r2, r3);
        }
    }

    private a(RecyclerView r3, n r4, boolean r5, boolean r6) {
        n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        this.f10553a = r3;
        this.f10554b = r7;
        this.c = r5;
        this.d = r6;
        this.e = true;
        C0516a r8 = new C0516a(this);
        this.f = r8;
        b r9 = new b(this);
        this.g = r9;
        r3.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(r8, RecyclerView.m.class, "com.obric.memorydata.plugin"));
        r3.addOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(r9, RecyclerView.l.class, "com.obric.memorydata.plugin"));
    }

    public a(RecyclerView r3, ViewPager2 r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        if (r4 == null) goto L5;
        j r0 = new j(r4);
    L6:
        this(r3, (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin"), r5, r6);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.d;
    }

    public static final /* synthetic */ n b(a r0) {
        return r0.f10554b;
    }

    public static final /* synthetic */ boolean c(a r0) {
        return r0.c;
    }

    public final RecyclerView a() {
        return this.f10553a;
    }

    public final void a(boolean r1) {
        this.e = r1;
        n r0 = this.f10554b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public final boolean b() {
        return this.e;
    }

    public final void c() {
        this.f10553a.removeOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(this.f, RecyclerView.m.class, "com.obric.memorydata.plugin"));
        this.f10553a.removeOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(this.g, RecyclerView.l.class, "com.obric.memorydata.plugin"));
    }
}
