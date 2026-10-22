package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.k;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.MultiTabContainerConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerLayout;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/k;", BuildConfig.FLAVOR, "visible", BuildConfig.FLAVOR, "setPagerTabVisible", "enableSmoothScroll", "setEnableSmoothScroll", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerLayout$c;", "listener", "setSwitchListener", BuildConfig.FLAVOR, "getPageCount", "getTabHeight", "i", "Z", "getEnableOnTouchEvent", "()Z", "setEnableOnTouchEvent", "(Z)V", "enableOnTouchEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "c", "PublicScreenAreaPagerAdapter", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenAreaPagerLayout extends SSViewPager implements k {
    public static final int q = 0;
    public final List<View> a;
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c> b;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b c;
    public boolean d;
    public boolean e;
    public final PublicScreenAreaPagerAdapter f;
    public f g;
    public c h;
    public boolean i;
    public boolean j;
    public final String k;
    public String l;
    public float m;
    public float n;
    public boolean o;
    public boolean p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerLayout$PublicScreenAreaPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PublicScreenAreaPagerAdapter extends PagerAdapter {
        public final List<View> a;

        public final int getCount() {
            return this.a.size();
        }

        public PublicScreenAreaPagerAdapter(List<View> r2) {
            Intrinsics.checkNotNullParameter(r2, "viewList");
            this.a = r2;
        }

        public final int getItemPosition(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "obj");
            if (CollectionsKt.contains(this.a, r2) == true) goto L7;
            return -2;
        L7:
            return CollectionsKt.indexOf(this.a, r2);
        }

        public final Object instantiateItem(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "container");
            View r0 = (View) ListProtector.get(this.a, r5);
            ViewPager.LayoutParams r1 = new ViewPager.LayoutParams();
            ((ViewGroup.LayoutParams) r1).width = -1;
            ((ViewGroup.LayoutParams) r1).height = -2;
            Unit r2 = Unit.INSTANCE;
            r4.addView(r0, r1);
            return ListProtector.get(this.a, r5);
        }

        public final boolean isViewFromObject(View r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "obj");
            return Intrinsics.areEqual(r2, r3);
        }

        public final void destroyItem(ViewGroup r1, int r2, Object r3) {
            Intrinsics.checkNotNullParameter(r1, "container");
            Intrinsics.checkNotNullParameter(r3, "obj");
            r1.removeView((View) r3);
        }
    }

    public static final class a extends DataSetObserver {
        public final /* synthetic */ PublicScreenAreaPagerLayout a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            PublicScreenAreaPagerLayout r0 = this.a;
            int r1 = PublicScreenAreaPagerLayout.q;
            r0.l();
        }

        public a(PublicScreenAreaPagerLayout r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c r1);
    }

    static {
        q = s1.j(2131169050) + s1.j(2131169051);
    }

    public final int getPageCount() {
        return ((ArrayList) this.b).size();
    }

    public final int getTabHeight() {
        Object r0 = this.g;
        if ((r0 instanceof View) == true) goto L5;
        r0 = null;
    L5:
        View r1 = (View) r0;
        if (r1 != null) goto L8;
    L10:
        return 0;
    L8:
        if (r1.getVisibility() != 0) goto L10;
        return q;
    }

    public final void l() {
        Object r2 = null;
        if (this.f.getCount() > 1) goto L5;
    L13:
        f r0 = this.g;
        if ((r0 instanceof View) == false) goto L17;
        r2 = r0;
    L17:
        View r3 = (View) r2;
        if (r3 == null) goto L23;
        r3.setVisibility(8);
        return;
    L23:
        return;
    L5:
        if (this.e == false) goto L13;
        f r1 = this.g;
        if ((r1 instanceof View) == false) goto L10;
        r2 = r1;
    L10:
        View r4 = (View) r2;
        if (r4 == null) goto L21;
        r4.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.k
    public final boolean f() {
        return this.j;
    }

    public final boolean getEnableOnTouchEvent() {
        return this.i;
    }

    public PublicScreenAreaPagerLayout(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        this.j = true;
        int r1 = r8.getAction();
        if (r1 == 3) goto L7;
        if (r1 == 1) goto L7;
        boolean r2 = false;
    L8:
        if (r2 != true) goto L11;
        this.j = false;
    L11:
        if (MultiTabContainerConfig.Companion.getConfig().getEnableGestureIntercept() == false) goto L59;
        IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
        if (r3 == null) goto L22;
        o r4 = IRoomContextService.a.a(r3, null, 0, 3);
        if (r4 == null) goto L22;
        m r5 = r4.H1();
        if (r5 == null) goto L22;
        if (((Boolean) r5.getValue()).booleanValue() == false) goto L59;
    L22:
        if (getCurrentItem() != 0) goto L24;
        boolean r6 = true;
    L26:
        if (getCurrentItem() != (this.f.getCount() - 1)) goto L28;
        boolean r7 = true;
    L29:
        int r9 = r8.getAction();
        if (r9 == 0) goto L55;
        if (r9 != 1) goto L33;
    L54:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.p = false;
    L57:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r8);
    L33:
        if (r9 == 2) goto L36;
        if (r9 == 3) goto L54;
    L36:
        float r10 = r8.getX() - this.m;
        if (Math.abs(r10) <= Math.abs(r8.getY() - this.n)) goto L52;
        float r11 = 0;
        if (r10 <= r11) goto L45;
        if (r6 == false) goto L45;
        if (this.o == true) goto L45;
        getParent().requestDisallowInterceptTouchEvent(false);
    L45:
        if (r10 >= r11) goto L50;
        if (r7 == false) goto L50;
        if (this.o == true) goto L50;
        getParent().requestDisallowInterceptTouchEvent(false);
    L50:
        getParent().requestDisallowInterceptTouchEvent(true);
        this.o = true;
        goto L57
    L52:
        if (this.p == false) goto L57;
        this.p = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L57
    L55:
        this.m = r8.getX();
        this.n = r8.getY();
        this.o = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.p = true;
        goto L57
    L28:
        r7 = false;
        goto L29
    L24:
        r6 = false;
    L59:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r8);
    L7:
        r2 = true;
        goto L8
    }

    public final void h(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c r4) {
        Intrinsics.checkNotNullParameter(r4, "page");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = r4.B5(r0);
        r4.A5(r0);
        if (r4.getPageType() == PublicScreenAreaPageType.Square) goto L8;
    L10:
        ((ArrayList) this.b).add(r4);
        ((ArrayList) this.a).add(r1);
    L11:
        f r5 = this.g;
        if (r5 == null) goto L18;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c> r2 = this.b;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = ((ArrayList) r2).iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        r3.add(((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r6.next()).getPageType());
        goto L15
    L17:
        r5.b(r3);
    L18:
        this.f.notifyDataSetChanged();
        return;
    L8:
        if ((!((ArrayList) this.b).isEmpty()) == false) goto L10;
        ListProtector.add(this.b, 1, r4);
        ListProtector.add(this.a, 1, r1);
        goto L11
    }

    public final boolean i(PublicScreenAreaPageType r6) {
        Intrinsics.checkNotNullParameter(r6, "pageType");
        Iterator r0 = ((ArrayList) this.b).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r0.next()).getPageType() != r6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 < 0) goto L18;
        return true;
    L18:
        return false;
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }

    public final void j(final PublicScreenAreaPageType r5) {
        Intrinsics.checkNotNullParameter(r5, "pageType");
        Function1<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c, Boolean> r0 = new PublicScreenAreaPagerLayout$removePages$removeCondition$1(r5);
        ArrayList r6 = new ArrayList();
        Iterator<T> r1 = this.b.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L9;
        if (((Boolean) r0.invoke((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r1.next())).booleanValue() == false) goto L8;
        r6.add(Integer.valueOf(r2));
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        CollectionsKt.sortDescending(r6);
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        int r3 = ((Number) r7.next()).intValue();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r4 = this.c;
        if (r4 == null) goto L15;
        ((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) ListProtector.get(this.b, r3)).C5(r4);
    L15:
        ListProtector.remove(this.b, r3);
        ListProtector.remove(this.a, r3);
        goto L11
    L16:
        f r8 = this.g;
        if (r8 == null) goto L23;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c> r9 = this.b;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        r10.add(((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r11.next()).getPageType());
        goto L20
    L22:
        r8.b(r10);
    L23:
        this.f.notifyDataSetChanged();
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.i == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }

    public final void setEnableOnTouchEvent(boolean r1) {
        this.i = r1;
    }

    public final void setEnableSmoothScroll(boolean r1) {
        this.d = r1;
    }

    public final void setPagerTabVisible(boolean r1) {
        this.e = r1;
        l();
    }

    public final void setSwitchListener(c r1) {
        this.h = r1;
    }

    public PublicScreenAreaPagerLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = true;
        this.e = true;
        this.i = true;
        ArrayList r4 = new ArrayList();
        this.a = r4;
        this.b = new ArrayList();
        PublicScreenAreaPagerAdapter r5 = new PublicScreenAreaPagerAdapter(r4);
        this.f = r5;
        setAdapter(r5);
        r5.registerDataSetObserver(new a(this));
        addOnPageChangeListener(new AnonymousClass2(this));
        this.k = "slide_bottom_tab";
        this.l = "slide_bottom_tab";
    }

    public final void k(PublicScreenAreaPageType r6, PublicScreenAreaPageChangeSource r7) {
        Intrinsics.checkNotNullParameter(r6, "pageType");
        Intrinsics.checkNotNullParameter(r7, "triggerSource");
        Iterator r0 = ((ArrayList) this.b).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r0.next()).getPageType() != r6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 == (-1)) goto L28;
        if (r2 > 0) goto L16;
    L24:
        setCurrentItem(r2, this.d);
        return;
    L16:
        switch(i.a[r7.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L17;
        };
    L17:
        String r8 = "slide_bottom_tab";
    L23:
        this.l = r8;
        goto L24
    L18:
        r8 = "manage";
        goto L23
    L19:
        r8 = "click_entry";
        goto L23
    L20:
        r8 = "join";
        goto L23
    L21:
        r8 = "create";
        goto L23
    L22:
        r8 = "click_bottom_tab";
        goto L23
    L28:
        return;
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }
}
