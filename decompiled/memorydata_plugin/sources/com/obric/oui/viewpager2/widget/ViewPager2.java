package com.obric.oui.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.card.MaterialCardView;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewPager2 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f14847a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f14848b;
    boolean c;
    LinearLayoutManager d;
    RecyclerView e;
    com.obric.oui.viewpager2.widget.e f;
    a g;
    private final Rect h;
    private final Rect i;
    private com.obric.oui.viewpager2.widget.b j;
    private RecyclerView.b k;
    private int l;
    private Parcelable m;
    private w n;
    private com.obric.oui.viewpager2.widget.b o;
    private com.obric.oui.viewpager2.widget.c p;
    private com.obric.oui.viewpager2.widget.d q;
    private RecyclerView.e r;
    private boolean s;
    private boolean t;
    private int u;

    private class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        RecyclerViewImpl(ViewPager2 r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (this.this$0.g.h() == false) goto L7;
            return this.this$0.g.i();
        L7:
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r2);
            r2.setFromIndex(this.this$0.f14848b);
            r2.setToIndex(this.this$0.f14848b);
            this.this$0.g.a(r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r2) {
            if (this.this$0.d() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r2) == false) goto L7;
            return true;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent r2) {
            if (this.this$0.d() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r2) == false) goto L7;
            return true;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r2) {
            super(r2);
            readValues(r2, null);
        }

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            readValues(r1, r2);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        private void readValues(Parcel r2, ClassLoader r3) {
            this.mRecyclerViewId = r2.readInt();
            this.mCurrentItem = r2.readInt();
            this.mAdapterState = r2.readParcelable(r3);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.mRecyclerViewId);
            r2.writeInt(this.mCurrentItem);
            r2.writeParcelable(this.mAdapterState, r3);
        }
    }

    private abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f14853a;

        private a(ViewPager2 r1) {
            this.f14853a = r1;
        }

        /* synthetic */ a(ViewPager2 r1, AnonymousClass1 r2) {
            this(r1);
        }

        void a(View r1, AccessibilityNodeInfoCompat r2) {
        }

        void a(AccessibilityEvent r1) {
        }

        void a(AccessibilityNodeInfo r1) {
        }

        void a(AccessibilityNodeInfoCompat r1) {
        }

        void a(RecyclerView.Adapter<?> r1) {
        }

        void a(com.obric.oui.viewpager2.widget.b r1, RecyclerView r2) {
        }

        boolean a() {
            return false;
        }

        boolean a(int r1) {
            return false;
        }

        boolean a(int r1, Bundle r2) {
            return false;
        }

        String b() {
            throw new IllegalStateException("Not implemented.");
        }

        void b(RecyclerView.Adapter<?> r1) {
        }

        boolean b(int r1) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean b(int r1, Bundle r2) {
            throw new IllegalStateException("Not implemented.");
        }

        void c() {
        }

        void d() {
        }

        void e() {
        }

        void f() {
        }

        void g() {
        }

        boolean h() {
            return false;
        }

        CharSequence i() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f14854b;

        b(ViewPager2 r2) {
            this.f14854b = r2;
            super(r2, null);
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void a(AccessibilityNodeInfoCompat r1) {
            if (this.f14854b.d() == true) goto L6;
            r1.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r1.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r1.setScrollable(false);
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public boolean a(int r2) {
            if (r2 == 8192) goto L7;
            if (r2 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.f14854b.d() == true) goto L9;
            return true;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public boolean b(int r1) {
            if (a(r1) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public boolean h() {
            return true;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public CharSequence i() {
            if (h() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }
    }

    private static abstract class c extends RecyclerView.b {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public abstract void a();

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, int r3) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, Object r3) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void b(int r1, int r2) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void c(int r1, int r2) {
            a();
        }
    }

    private class d extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f14855a;

        d(ViewPager2 r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f14855a = r3;
            super(r5);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
        public void a(RecyclerView.o r1, RecyclerView.s r2, View r3, AccessibilityNodeInfoCompat r4) {
            this.f14855a.g.a(r3, r4);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
        public void a(RecyclerView.o r1, RecyclerView.s r2, AccessibilityNodeInfoCompat r3) {
            super.a(r1, r2, r3);
            this.f14855a.g.a(r3);
        }

        @Override // com.obric.oui.orecyclerview.widget.LinearLayoutManager
        public void a(RecyclerView.s r3, int[] r4) {
            int r0 = this.f14855a.getOffscreenPageLimit();
            if (r0 != (-1)) goto L6;
            super.a(r3, r4);
            return;
        L6:
            int r2 = this.f14855a.getPageSize() * r0;
            r4[0] = r2;
            r4[1] = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
        public boolean a(RecyclerView.o r2, RecyclerView.s r3, int r4, Bundle r5) {
            if (this.f14855a.g.a(r4) == false) goto L7;
            return this.f14855a.g.b(r4);
        L7:
            return super.a(r2, r3, r4, r5);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
        public boolean a(RecyclerView r1, View r2, Rect r3, boolean r4, boolean r5) {
            return false;
        }
    }

    public static abstract class e {
        public e() {
        }

        public void a(int r1) {
        }

        public void a(int r1, float r2, int r3) {
        }

        public void b(int r1) {
        }
    }

    class f extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f14856b;
        private final AccessibilityViewCommand c;
        private final AccessibilityViewCommand d;
        private RecyclerView.b e;

        f(ViewPager2 r2) {
            this.f14856b = r2;
            super(r2, null);
            this.c = new ViewPager2$PageAwareAccessibilityProvider$1(this);
            this.d = new ViewPager2$PageAwareAccessibilityProvider$2(this);
        }

        private void b(View r9, AccessibilityNodeInfoCompat r10) {
            int r1 = 0;
            if (this.f14856b.getOrientation() != 1) goto L5;
            int r2 = this.f14856b.d.d(r9);
        L7:
            if (this.f14856b.getOrientation() != 0) goto L9;
            r1 = this.f14856b.d.d(r9);
        L9:
            r10.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r2, 1, r1, 1, false, false));
            return;
        L5:
            r2 = 0;
            goto L7
        }

        private void b(AccessibilityNodeInfoCompat r5) {
            int r1 = 1;
            if (this.f14856b.getAdapter() == null) goto L7;
            int r0 = this.f14856b.getOrientation();
            int r4 = this.f14856b.getAdapter().d();
            if (r0 != 1) goto L8;
            r1 = r4;
            r4 = 1;
        L8:
            r5.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r1, r4, false, 0));
            return;
        L7:
            r4 = 0;
            r1 = 0;
            goto L8
        }

        private void c(AccessibilityNodeInfoCompat r3) {
            RecyclerView.Adapter r0 = this.f14856b.getAdapter();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.d();
            if (r1 != 0) goto L8;
            return;
        L8:
            if (this.f14856b.d() == true) goto L11;
            return;
        L11:
            if (this.f14856b.f14848b <= 0) goto L14;
            r3.addAction(8192);
        L14:
            if (this.f14856b.f14848b >= (r1 - 1)) goto L16;
            r3.addAction(4096);
        L16:
            r3.setScrollable(true);
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        void a(View r1, AccessibilityNodeInfoCompat r2) {
            b(r1, r2);
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void a(AccessibilityEvent r2) {
            r2.setSource(this.f14856b);
            r2.setClassName(b());
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void a(AccessibilityNodeInfo r1) {
            AccessibilityNodeInfoCompat r2 = AccessibilityNodeInfoCompat.wrap(r1);
            b(r2);
            c(r2);
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void a(RecyclerView.Adapter<?> r1) {
            j();
            if (r1 == null) goto L6;
            r1.a(this.e);
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void a(com.obric.oui.viewpager2.widget.b r1, RecyclerView r2) {
            r2.setImportantForAccessibility(2);
            this.e = new AnonymousClass1(this);
            if (this.f14856b.getImportantForAccessibility() != 0) goto L6;
            this.f14856b.setImportantForAccessibility(1);
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public boolean a() {
            return true;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public boolean a(int r1, Bundle r2) {
            if (r1 != 8192) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 4096) goto L8;
            return false;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public String b() {
            if (a() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void b(RecyclerView.Adapter<?> r1) {
            if (r1 == null) goto L5;
            r1.b(this.e);
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public boolean b(int r2, Bundle r3) {
            if (a(r2, r3) == false) goto L11;
            if (r2 != 8192) goto L7;
            int r4 = this.f14856b.getCurrentItem() - 1;
        L8:
            c(r4);
            return true;
        L7:
            r4 = this.f14856b.getCurrentItem() + 1;
            goto L8
        L11:
            throw new IllegalStateException();
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void c() {
            j();
        }

        void c(int r2) {
            if (this.f14856b.d() == false) goto L6;
            this.f14856b.b(r2, true);
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void d() {
            j();
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void e() {
            j();
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void f() {
            j();
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.a
        public void g() {
            j();
        }

        void j() {
            ViewPager2 r0 = this.f14856b;
            int r1 = R.id.accessibilityActionPageLeft;
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageLeft);
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageRight);
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageUp);
            ViewCompat.removeAccessibilityAction(r0, R.id.accessibilityActionPageDown);
            if (this.f14856b.getAdapter() != null) goto L5;
            return;
        L5:
            int r5 = this.f14856b.getAdapter().d();
            if (r5 != 0) goto L9;
            return;
        L9:
            if (this.f14856b.d() == true) goto L12;
            return;
        L12:
            if (this.f14856b.getOrientation() != 0) goto L26;
            boolean r3 = this.f14856b.b();
            if (r3 == false) goto L16;
            int r4 = 16908360;
        L17:
            if (r3 == false) goto L20;
            r1 = 16908361;
        L20:
            if (this.f14856b.f14848b >= (r5 - 1)) goto L23;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r4, null), null, this.c);
        L23:
            if (this.f14856b.f14848b <= 0) goto L32;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r1, null), null, this.d);
            return;
        L32:
            return;
        L16:
            r4 = 16908361;
            goto L17
        L26:
            if (this.f14856b.f14848b >= (r5 - 1)) goto L29;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.c);
        L29:
            if (this.f14856b.f14848b <= 0) goto L34;
            ViewCompat.replaceAccessibilityAction(r0, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.d);
            return;
        }
    }

    public interface g {
        void a(View r1, float r2);
    }

    private class h extends w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f14858b;

        h(ViewPager2 r1) {
            this.f14858b = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.w, com.obric.oui.orecyclerview.widget.aa
        public View a(RecyclerView.h r2) {
            if (this.f14858b.c() == false) goto L6;
            return null;
        L6:
            return super.a(r2);
        }
    }

    private static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f14860b;

        i(int r1, RecyclerView r2) {
            this.f14859a = r1;
            this.f14860b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14860b.smoothScrollToPosition(this.f14859a);
        }
    }

    static {
    }

    public ViewPager2(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r5);
        this.h = new Rect();
        this.i = new Rect();
        this.j = new com.obric.oui.viewpager2.widget.b(3);
        this.c = false;
        this.k = new AnonymousClass1(this);
        this.l = -1;
        this.r = null;
        this.s = false;
        this.t = true;
        this.u = -1;
        a(r5, null);
    }

    public ViewPager2(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7);
        this.h = new Rect();
        this.i = new Rect();
        this.j = new com.obric.oui.viewpager2.widget.b(3);
        this.c = false;
        this.k = new AnonymousClass1(this);
        this.l = -1;
        this.r = null;
        this.s = false;
        this.t = true;
        this.u = -1;
        a(r6, r7);
    }

    public ViewPager2(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.h = new Rect();
        this.i = new Rect();
        this.j = new com.obric.oui.viewpager2.widget.b(3);
        this.c = false;
        this.k = new AnonymousClass1(this);
        this.l = -1;
        this.r = null;
        this.s = false;
        this.t = true;
        this.u = -1;
        a(r6, r7);
    }

    private void a(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        if (f14847a == false) goto L5;
        a r0 = new f(this);
    L6:
        this.g = r0;
        RecyclerViewImpl r1 = new RecyclerViewImpl(this, r5);
        this.e = r1;
        r1.setId(View.generateViewId());
        this.e.setDescendantFocusability(131072);
        d r2 = new d(this, r5);
        this.d = r2;
        this.e.setLayoutManager(r2);
        this.e.setScrollingTouchSlop(1);
        b(r5, r6);
        this.e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e.addOnChildAttachStateChangeListener(f());
        this.f = new com.obric.oui.viewpager2.widget.e(this);
        this.p = new com.obric.oui.viewpager2.widget.c(this, this.f, this.e);
        h r7 = new h(this);
        this.n = r7;
        r7.a(this.e);
        this.e.addOnScrollListener(this.f);
        this.e.setOverScrollMode(getOverScrollMode());
        com.obric.oui.viewpager2.widget.b r8 = new com.obric.oui.viewpager2.widget.b(3);
        this.o = r8;
        this.f.a(r8);
        e r9 = new AnonymousClass2(this);
        e r10 = new AnonymousClass3(this);
        this.o.a(r9);
        this.o.a(r10);
        this.g.a(this.o, this.e);
        this.o.a(this.j);
        com.obric.oui.viewpager2.widget.d r11 = new com.obric.oui.viewpager2.widget.d(this.d);
        this.q = r11;
        this.o.a(r11);
        RecyclerView r12 = this.e;
        attachViewToParent(r12, 0, r12.getLayoutParams());
        return;
    L5:
        r0 = new b(this);
        goto L6
    }

    private void a(RecyclerView.Adapter<?> r1) {
        if (r1 == null) goto L5;
        r1.a(this.k);
        return;
    }

    private void b(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r12 = r3.obtainStyledAttributes(r5, com.obric.memorydata.plugin.R.styleable.ViewPager2);
        ViewCompat.saveAttributeDataForStyleable(this, r3, com.obric.memorydata.plugin.R.styleable.ViewPager2, r5, r12, 0, 0);
        setOrientation(r12.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.ViewPager2_android_orientation, "styleable", "ViewPager2_android_orientation"), 0));     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    private void b(RecyclerView.Adapter<?> r1) {
        if (r1 == null) goto L5;
        r1.b(this.k);
        return;
    }

    private RecyclerView.j f() {
        return new AnonymousClass4(this);
    }

    private void g() {
        if (this.l != (-1)) goto L5;
        return;
    L5:
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.m != null) goto L11;
    L14:
        int r1 = Math.max(0, Math.min(this.l, r0.d() - 1));
        this.f14848b = r1;
        this.l = -1;
        this.e.scrollToPosition(r1);
        this.g.c();
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.viewpager2.adapter.d.class) == false) goto L13;
        ((com.obric.oui.viewpager2.adapter.d) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.viewpager2.adapter.d.class, "com.obric.memorydata.plugin")).a(this.m);
    L13:
        this.m = null;
        goto L14
    }

    void a() {
        w r0 = this.n;
        if (r0 == null) goto L15;
        View r1 = r0.a(this.d);
        if (r1 != null) goto L7;
        return;
    L7:
        int r2 = this.d.d(r1);
        if (r2 != this.f14848b) goto L10;
    L12:
        this.c = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.o.b(r2);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    public void a(int r2, boolean r3) {
        if (c() == true) goto L7;
        b(r2, r3);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void a(e r1) {
        this.j.a(r1);
    }

    void b(int r9, boolean r10) {
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 != null) goto L9;
        if (this.l == (-1)) goto L36;
        this.l = Math.max(r9, 0);
        return;
    L36:
        return;
    L9:
        if (r0.d() > 0) goto L11;
        return;
    L11:
        int r11 = Math.min(Math.max(r9, 0), r0.d() - 1);
        if (r11 == this.f14848b) goto L14;
    L16:
        int r1 = this.f14848b;
        if (r11 != r1) goto L20;
        if (r10 == false) goto L20;
        return;
    L20:
        double r2 = r1;
        this.f14848b = r11;
        this.g.e();
        if (this.f.c() == true) goto L23;
        r2 = this.f.e();
    L23:
        this.f.a(r11, r10);
        if (r10 == true) goto L27;
        this.e.scrollToPosition(r11);
        return;
    L27:
        double r3 = r11;
        if (Math.abs(r3 - r2) <= 3.0d) goto L34;
        RecyclerView r12 = this.e;
        if (r3 <= r2) goto L32;
        int r4 = r11 - 3;
    L33:
        r12.scrollToPosition(r4);
        this.e.post(new i(r11, this.e));
        return;
    L32:
        r4 = r11 + 3;
        goto L33
    L34:
        this.e.smoothScrollToPosition(r11);
        return;
    L14:
        if (this.f.c() == false) goto L16;
    }

    public void b(e r1) {
        this.j.b(r1);
    }

    boolean b() {
        if (this.d.v() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean c() {
        return this.p.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r1) {
        return this.e.canScrollHorizontally(r1);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r1) {
        return this.e.canScrollVertically(r1);
    }

    public boolean d() {
        return this.t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r6) {
        Parcelable r0 = (Parcelable) ZeusTransformUtils.preCheckCast(r6.get(getId()), Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, SavedState.class) == false) goto L5;
        int r1 = ((SavedState) ZeusTransformUtils.preCheckCast(r0, SavedState.class, "com.obric.memorydata.plugin")).mRecyclerViewId;
        r6.put(this.e.getId(), (Parcelable) ZeusTransformUtils.preCheckCast(r6.get(r1), Parcelable.class, "com.obric.memorydata.plugin"));
        r6.remove(r1);
    L5:
        super.dispatchRestoreInstanceState(r6);
        g();
    }

    public void e() {
        if (this.q.a() != null) goto L5;
        return;
    L5:
        double r0 = this.f.e();
        int r2 = (int) r0;
        float r1 = (float) (r0 - ((double) r2));
        this.q.a(r2, r1, Math.round(getPageSize() * r1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.g.a() == false) goto L7;
        return this.g.b();
    L7:
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.e.getAdapter();
    }

    public int getCurrentItem() {
        return this.f14848b;
    }

    public int getItemDecorationCount() {
        return this.e.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.u;
    }

    public int getOrientation() {
        if (this.d.h() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    int getPageSize() {
        RecyclerView r0 = this.e;
        if (getOrientation() != 0) goto L5;
        int r2 = r0.getWidth() - r0.getPaddingLeft();
        int r1 = r0.getPaddingRight();
    L7:
        return r2 - r1;
    L5:
        r2 = r0.getHeight() - r0.getPaddingTop();
        r1 = r0.getPaddingBottom();
        goto L7
    }

    public int getScrollState() {
        return this.f.b();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        this.g.a(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = this.e.getMeasuredWidth();
        int r0 = this.e.getMeasuredHeight();
        Rect r1 = this.h;
        r1.left = getPaddingLeft();
        Rect r2 = this.h;
        r2.right = (r7 - r5) - getPaddingRight();
        Rect r10 = this.h;
        r10.top = getPaddingTop();
        Rect r11 = this.h;
        r11.bottom = (r8 - r6) - getPaddingBottom();
        Gravity.apply(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START, r9, r0, this.h, this.i);
        this.e.layout(this.i.left, this.i.top, this.i.right, this.i.bottom);
        if (this.c == false) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r6, int r7) {
        measureChild(this.e, r6, r7);
        int r0 = this.e.getMeasuredWidth();
        int r1 = this.e.getMeasuredHeight();
        int r2 = this.e.getMeasuredState();
        int r3 = r0 + (getPaddingLeft() + getPaddingRight());
        int r4 = r1 + (getPaddingTop() + getPaddingBottom());
        int r5 = Math.max(r3, getSuggestedMinimumWidth());
        int r8 = Math.max(r4, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(r5, r6, r2), resolveSizeAndState(r8, r7, r2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.l = r5.mCurrentItem;
        this.m = r5.mAdapterState;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.mRecyclerViewId = this.e.getId();
        int r0 = this.l;
        if (r0 != (-1)) goto L5;
        r0 = this.f14848b;
    L5:
        r1.mCurrentItem = r0;
        Parcelable r2 = this.m;
        if (r2 == null) goto L8;
        r1.mAdapterState = r2;
    L11:
        return r1;
    L8:
        RecyclerView.Adapter r3 = this.e.getAdapter();
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.viewpager2.adapter.d.class) == false) goto L11;
        r1.mAdapterState = ((com.obric.oui.viewpager2.adapter.d) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.viewpager2.adapter.d.class, "com.obric.memorydata.plugin")).e();
        goto L11
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r2) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int r2, Bundle r3) {
        if (this.g.a(r2, r3) == false) goto L7;
        return this.g.b(r2, r3);
    L7:
        return super.performAccessibilityAction(r2, r3);
    }

    public void setAdapter(RecyclerView.Adapter r3) {
        RecyclerView.Adapter r0 = this.e.getAdapter();
        this.g.b(r0);
        b(r0);
        this.e.setAdapter(r3);
        this.f14848b = 0;
        g();
        this.g.a(r3);
        a(r3);
    }

    public void setCurrentItem(int r2) {
        a(r2, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int r1) {
        super.setLayoutDirection(r1);
        this.g.g();
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 < 1) goto L5;
    L9:
        this.u = r2;
        this.e.requestLayout();
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int r2) {
        this.d.b(r2);
        this.g.d();
    }

    @Override // android.view.View
    public void setOverScrollMode(int r2) {
        RecyclerView r0 = this.e;
        if (r0 == null) goto L5;
        r0.setOverScrollMode(r2);
    L5:
        super.setOverScrollMode(r2);
    }

    public void setPageTransformer(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        boolean r1 = this.s;
        if (r5 == null) goto L7;
        if (r1 == true) goto L6;
        this.r = this.e.getItemAnimator();
        this.s = true;
    L6:
        this.e.setItemAnimator(null);
    L10:
        if (r5 != this.q.a()) goto L12;
        return;
    L12:
        this.q.a(r5);
        e();
        return;
    L7:
        if (r1 == false) goto L10;
        this.e.setItemAnimator(this.r);
        this.r = null;
        this.s = false;
        goto L10
    }

    public void setUserInputEnabled(boolean r1) {
        this.t = r1;
        this.g.f();
    }
}
