package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.b0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\t\nB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerIndicatorV2;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/f;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "TabView", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenAreaPagerIndicatorV2 extends LinearLayout implements f {
    public static final int g = 0;
    public static final int h = 0;
    public static final float i = 0.0f;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> n = null;
    public final Paint a;
    public final Paint b;
    public ViewPager c;
    public final b d;
    public final List<PublicScreenAreaPageType> e;
    public final PublicScreenAreaPagerIndicatorV2$pageChangeListener$1 f;

    public final class TabView extends View {
        public boolean a;
        public boolean b;
        public final Paint c;
        public Paint d;
        public final PublicScreenAreaPageType e;
        public final String f;
        public final /* synthetic */ PublicScreenAreaPagerIndicatorV2 g;

        public final void b(final boolean r3) {
            this.a = r3;
            a(false, null);
            postInvalidate();
            ViewCompat.setAccessibilityDelegate(this, new PublicScreenAreaPagerIndicatorV2$TabView$setSelect$1(this, r3));
        }

        @Override // android.view.View
        public final void onDraw(Canvas r6) {
            Intrinsics.checkNotNullParameter(r6, "canvas");
            super.onDraw(r6);
            if (this.a == false) goto L5;
            Paint r0 = this.g.b;
        L6:
            this.d = r0;
            float r1 = r0.measureText(this.f);
            r6.drawText(this.f, 0.0f, PublicScreenAreaPagerIndicatorV2.h - this.d.getFontMetrics().descent, this.d);
            if (this.b == false) goto L10;
            float r2 = PublicScreenAreaPagerIndicatorV2.i;
            r6.drawCircle(r1 + r2, PublicScreenAreaPagerIndicatorV2.g + r2, r2, this.c);
            return;
        L10:
            return;
        L5:
            r0 = this.g.a;
            goto L6
        }

        public final void a(boolean r5, Function0<Unit> r6) {
            PublicScreenAreaPageType r0 = this.e;
            if (r0 != PublicScreenAreaPageType.PublicScreen) goto L6;
            return;
        L6:
            if (r0 != PublicScreenAreaPageType.ChatChannel) goto L19;
            boolean r1 = this.b;
            if (this.a == false) goto L10;
            this.b = false;
        L12:
            if (r1 == this.b) goto L35;
            postInvalidate();
            if (this.b == false) goto L36;
            if (r6 == null) goto L37;
            Unit r7 = (Unit) r6.invoke();
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L10:
            this.b = r5;
            goto L12
        L19:
            if (r0 == PublicScreenAreaPageType.Square) goto L21;
            return;
        L21:
            if (this.b != r5) goto L24;
            return;
        L24:
            if (this.a == false) goto L26;
            com.bytedance.android.livesdk.sharedpref.e<Long> r8 = PublicScreenAreaPagerIndicatorV2.n;
            r8.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r8, 3L);
            this.b = false;
        L33:
            postInvalidate();
            return;
        L26:
            com.bytedance.android.livesdk.sharedpref.e<Long> r9 = PublicScreenAreaPagerIndicatorV2.n;
            com.bytedance.android.livesdk.sharedpref.f.d(r9, Long.valueOf(((Long) r9.getValue()).longValue() + 1));
            this.b = true;
            com.bytedance.android.livesdk.interactivity.api.h r10 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
            if (r10 == null) goto L33;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b> r11 = r10.getSquareTabManager();
            if (r11 == null) goto L33;
            com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r13 = (com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b) r11.getValue();
            if (r13 == null) goto L33;
            r13.c();
            goto L33
        }

        public TabView(PublicScreenAreaPagerIndicatorV2 r2, Context r3, PublicScreenAreaPageType r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "pageType");
            Intrinsics.checkNotNullParameter(r5, "tabTitle");
            this.g = r2;
            super(r3);
            this.e = r4;
            this.f = r5;
            Paint r6 = new Paint();
            r6.setColor(PublicScreenAreaPagerIndicatorV2.m);
            Unit r7 = Unit.INSTANCE;
            this.c = r6;
            this.d = r2.a;
        }
    }

    public static final class a {
    }

    public static final class b extends DataSetObserver {
        public final /* synthetic */ PublicScreenAreaPagerIndicatorV2 a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            PublicScreenAreaPagerIndicatorV2 r0 = this.a;
            int r1 = PublicScreenAreaPagerIndicatorV2.g;
            r0.d();
            this.a.f();
        }

        public b(PublicScreenAreaPagerIndicatorV2 r1) {
            this.a = r1;
        }
    }

    static {
        g = s1.f(8.0f);
        h = s1.j(2131169050);
        i = s1.f(4.0f);
        j = ColorProtector.parseColor("#99FFFFFF");
        k = -1;
        l = ColorProtector.parseColor("#4D000000");
        m = ColorProtector.parseColor("#FE2C55");
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L8;
        String r2 = r1.n();
        if (r2 == null) goto L8;
    L9:
        n = new com.bytedance.android.livesdk.sharedpref.e("live_square_tab_red_dot_show_times_".concat(r2), 0L);
        return;
    L8:
        r2 = BuildConfig.FLAVOR;
        goto L9
    }

    public final void f() {
        ViewPager r0 = this.c;
        if (r0 == null) goto L12;
        int r1 = r0.getCurrentItem();
        int r2 = getChildCount();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L17;
        View r4 = getChildAt(r3);
        if ((r4 instanceof TabView) == false) goto L11;
        if (r3 != r1) goto L10;
        ((TabView) r4).b(true);
        goto L11
    L10:
        ((TabView) r4).b(false);
    L11:
        r3 = r3 + 1;
        goto L5
    L17:
        return;
    }

    public final void d() {
        removeAllViews();
        ViewPager r0 = this.c;
        if (r0 == null) goto L32;
        PagerAdapter r1 = r0.getAdapter();
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = r1.getCount();
    L8:
        if (r2 >= r3) goto L23;
        PublicScreenAreaPageType r4 = (PublicScreenAreaPageType) ListProtector.get(this.e, r2);
        int r5 = g.a[r4.ordinal()];
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L14;
        String r6 = "广场";
    L22:
        TabView r7 = new TabView(this, getContext(), (PublicScreenAreaPageType) ListProtector.get(this.e, r2), r6);
        r7.setLayoutParams(new LinearLayout.LayoutParams(((int) this.a.measureText(r6)) + UtilityKotlinExtentionsKt.i(12), h));
        r7.setOnClickListener(new h(this, r7));
        addView(r7);
        r2 = r2 + 1;
        goto L8
    L14:
        if (r5 == 3) goto L16;
        r6 = BuildConfig.FLAVOR;
        goto L22
    L16:
        r6 = "聊天频道";
        goto L22
    L19:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.d.b == false) goto L21;
        r6 = "房间";
        goto L22
    L21:
        r6 = "评论区";
        goto L22
    L23:
        requestLayout();
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public PublicScreenAreaPagerIndicatorV2(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.f
    public final void a(PublicScreenAreaPagerLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        ViewPager r0 = this.c;
        if (r0 == null) goto L7;
        r0.removeOnPageChangeListener(this.f);
        PagerAdapter r1 = r0.getAdapter();
        if (r1 == null) goto L7;
        r1.unregisterDataSetObserver(this.d);
    L7:
        this.c = r3;
        r3.addOnPageChangeListener(this.f);
        PagerAdapter r4 = r3.getAdapter();
        if (r4 == null) goto L10;
        r4.registerDataSetObserver(this.d);
    L10:
        d();
        f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.f
    public final void b(List<? extends PublicScreenAreaPageType> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        ((ArrayList) this.e).clear();
        ((ArrayList) this.e).addAll(r2);
    }

    public final boolean c(PublicScreenAreaPageType r2) {
        Intrinsics.checkNotNullParameter(r2, "pageType");
        int r3 = ((ArrayList) this.e).indexOf(r2);
        if (r3 <= 0) goto L8;
        View r4 = getChildAt(r3);
        if ((r4 instanceof TabView) == true) goto L7;
        return false;
    L7:
        return ((TabView) r4).b;
    L8:
        return false;
    }

    public final void e(final j r3) {
        Intrinsics.checkNotNullParameter(r3, "trigger");
        List<PublicScreenAreaPageType> r0 = this.e;
        ArrayList r1 = (ArrayList) r0;
        int r2 = r1.indexOf(PublicScreenAreaPageType.ChatChannel);
        if (r2 <= 0) goto L8;
        View r4 = getChildAt(r2);
        if ((r4 instanceof TabView) == false) goto L9;
        ((TabView) r4).a(true, new PublicScreenAreaPagerIndicatorV2$showChannelRedDot$1(r3));
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPagerIndicatorV2$pageChangeListener$1] */
    public PublicScreenAreaPagerIndicatorV2(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        boolean r7 = ((Boolean) b0.a.getValue()).booleanValue();
        Paint r8 = new Paint();
        r8.setColor(j);
        r8.setTextSize(UtilityKotlinExtentionsKt.i(12));
        if (r7 == false) goto L5;
        r8.setShadowLayer(8.0f, 0.0f, 0.0f, l);
    L5:
        Unit r3 = Unit.INSTANCE;
        this.a = r8;
        Paint r9 = new Paint();
        r9.setColor(k);
        r9.setTextSize(UtilityKotlinExtentionsKt.i(12));
        if (r7 == false) goto L8;
        r9.setShadowLayer(8.0f, 0.0f, 0.0f, l);
    L8:
        this.b = r9;
        this.d = new b(this);
        this.e = new ArrayList();
        this.f = new PublicScreenAreaPagerIndicatorV2$pageChangeListener$1(this);
        setOrientation(0);
    }
}
