package com.bytedance.ies.xelement.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.anniex.container.i;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import qe.a;
import qe.b;
import qe.c;

/* JADX INFO: loaded from: classes2.dex */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    public final BannerViewPager A;
    public final LinearLayout B;
    public b C;
    public ViewPager.OnPageChangeListener D;
    public boolean E;
    public final CopyOnWriteArrayList F;
    public final a G;
    public Method H;
    public Field I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6373c;
    public final int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f6379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6384r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6385t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6388w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6389x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6390y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f6391z;

    public Banner(Context r5) {
        super(r5, null, 0);
        this.f6371a = 5000;
        this.f6372b = 5;
        this.f6373c = 20;
        this.d = 20;
        this.e = 5000;
        this.f = 500;
        this.g = 10;
        this.f6374h = -1;
        this.f6375i = -1;
        this.f6376j = -1;
        this.f6377k = -1;
        this.f6378l = 1;
        this.f6379m = "normal";
        this.f6380n = true;
        this.f6381o = true;
        this.f6382p = true;
        this.f6383q = true;
        this.f6384r = true;
        this.s = true;
        this.f6385t = Color.argb(128, 0, 0, 0);
        this.f6386u = Color.argb(255, 255, 255, 255);
        this.f6387v = Color.argb(89, 255, 255, 255);
        this.f6388w = 0;
        this.f6389x = 0;
        this.f6390y = 0;
        this.E = false;
        this.F = new CopyOnWriteArrayList();
        this.G = new a(this, 1);
        this.f6391z = new ArrayList();
        View r10 = LayoutInflater.from(r5).inflate(R$layout.x_swiper_banner, this, true);
        BannerViewPager r11 = (BannerViewPager) r10.findViewById(R$id.bannerViewPager);
        this.A = r11;
        this.B = (LinearLayout) r10.findViewById(R$id.circleIndicator);
        Field r12 = ViewPager.class.getDeclaredField("mScroller");     // Catch: Exception -> L5
        r12.setAccessible(true);     // Catch: Exception -> L5
        r12.set(r11, new c(this, r11.getContext()));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LynxLog.b(4, "Banner", e.getMessage());
    }

    public final void a() {
        if (this.C == null) goto L19;
        ArrayList r5 = this.f6391z;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        View r11 = (View) r10.next();
        int r12 = this.f6387v;
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(1);
        r13.setColor(r12);
        r11.setBackground(r13);
        goto L6
    L8:
        int r14 = this.f6388w;
        if (r14 >= 0) goto L11;
    L13:
        int r15 = 0;
    L15:
        if (r5.size() <= 0) goto L20;
        View r16 = (View) r5.get(r15);
        int r17 = this.f6386u;
        GradientDrawable r18 = new GradientDrawable();
        r18.setShape(1);
        r18.setColor(r17);
        r16.setBackground(r18);
        this.f6389x = this.A.getCurrentItem();
        return;
    L20:
        return;
    L11:
        if (r14 >= r5.size()) goto L13;
        r15 = this.f6388w;
        goto L15
    }

    public final void b(int r5) {
        this.f6388w = r5;
        BannerViewPager r10 = this.A;
        if (e(r10.getCurrentItem()) != r5) goto L9;
        b r11 = this.C;
        if (r11 == null) goto L9;
        if (r11.getCount() <= 0) goto L9;
        return;
    L9:
        b r12 = this.C;
        if (r12 != null) goto L12;
    L15:
        r10.postDelayed(new a(this, 0), 200);
        return;
    L12:
        if (r5 >= r12.getCount()) goto L15;
        r10.post(new i(r5, 5, this));
    }

    public final void c(int r5, View r10) {
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        if (r10.findViewWithTag("swiper_lynx_view_tag") != null) goto L26;
        int r11 = e(r5);
        if (r11 < 0) goto L17;
        CopyOnWriteArrayList r12 = this.F;
        if (r12 == null) goto L17;
        if (r12.size() == 0) goto L17;
        if (r11 >= r12.size()) goto L17;
        View r13 = ((LynxUI) r12.get(r11)).getView();
    L18:
        if (r13 != null) goto L21;
        return;
    L21:
        if ((r13.getParent() instanceof ViewGroup) == false) goto L23;
        ((ViewGroup) r13.getParent()).removeView(r13);
    L23:
        ((ViewGroup) r10).addView(r13);
        return;
    L17:
        r13 = null;
        goto L18
    }

    public final void d(String r5, int r10, int r11, int r12) {
        b r13 = this.C;
        if (r13 == null) goto L5;
        r13.notifyDataSetChanged();
    L5:
        boolean r14 = r5.equals("coverflow");
        BannerViewPager r15 = this.A;
        if (r14 == false) goto L8;
    L24:
        r15.setClipToPadding(false);
        int r16 = this.f6390y / 5;
        if (r11 < 0) goto L28;
        if (r12 < 0) goto L28;
        r15.setPadding(r11 + r10, 0, r12 + r10, 0);
    L29:
        r15.setPageMargin(r10);
        r15.setOffscreenPageLimit(2);
        if (r5.equals("coverflow") == false) goto L33;
        r15.setPageTransformer(false, new CoverFlowTransformer());
        return;
    L33:
        return;
    L28:
        r15.setPadding(r16, 0, r16, 0);
        goto L29
    L8:
        if (r5.equals("flat-coverflow") == true) goto L24;
        if (r5.equals("multi-pages") == false) goto L19;
        r15.setClipToPadding(false);
        int r17 = this.f6376j;
        if (r17 < 0) goto L17;
        int r18 = this.f6377k;
        if (r18 < 0) goto L17;
        r15.setPadding(r17, 0, r18, 0);
    L17:
        r15.setPageMargin(r10);
        r15.setOffscreenPageLimit(1);
        return;
    L19:
        r15.setPageMargin(r10);
        ViewGroup.LayoutParams r19 = r15.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        r20.leftMargin = 0;
        r20.rightMargin = 0;
    L22:
        r15.setOffscreenPageLimit(1);
        r15.setPageTransformer(false, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (this.f6382p == false) goto L15;
        int r10 = r5.getAction();
        a r11 = this.G;
        if (r10 != 1) goto L7;
    L13:
        removeCallbacks(r11);
        postDelayed(r11, this.e);
        goto L15
    L7:
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        if (r10 != 0) goto L15;
        removeCallbacks(r11);
    L15:
        return super.dispatchTouchEvent(r5);
    }

    public final int e(int r5) {
        CopyOnWriteArrayList r10 = this.F;
        if (r10.size() != 0) goto L6;
    L14:
        return r5;
    L6:
        if (this.f6381o == false) goto L14;
        int r11 = r5 - (this.f6371a / 2);
        int r12 = Math.abs(r11) % r10.size();
        if (r11 >= 0) goto L13;
        if (r12 == 0) goto L13;
        return r10.size() - r12;
    L13:
        return r12;
    }

    public final void f() {
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.I != null) goto L7;
        Field r5 = ViewPager.class.getDeclaredField("mFirstLayout");     // Catch: Throwable -> L5
        this.I = r5;     // Catch: Throwable -> L5
        r5.setAccessible(true);     // Catch: Throwable -> L5
    L7:
        this.I.set(this.A, Boolean.TRUE);     // Catch: Throwable -> L5
    }

    public final void g() {
        d(this.f6379m, this.g, this.f6374h, this.f6375i);
        boolean r5 = this.f6383q;
        this.f6383q = r5;
        BannerViewPager r10 = this.A;
        if (r10 == null) goto L6;
        r10.setScrollable(r5);
    L6:
        if (this.C != null) goto L8;
        this.C = new b(this);
        r10.addOnPageChangeListener(this);
        r10.setAdapter(this.C);
    L8:
        int r11 = this.f6388w;
        if (r11 >= 0) goto L11;
    L12:
        this.f6388w = 0;
    L14:
        if (this.f6381o == false) goto L16;
        int r12 = (this.f6371a / 2) + this.f6388w;
    L17:
        boolean r13 = this.s;
        f();     // Catch: Throwable -> L21
        if (this.H != null) goto L23;
        Class r14 = Integer.TYPE;     // Catch: Throwable -> L21
        Class r15 = Boolean.TYPE;     // Catch: Throwable -> L21
        Method r16 = ViewPager.class.getDeclaredMethod("setCurrentItemInternal", new Class[]{r14, r15, r15});     // Catch: Throwable -> L21
        this.H = r16;     // Catch: Throwable -> L21
        r16.setAccessible(true);     // Catch: Throwable -> L21
    L23:
        this.H.invoke(r10, new Object[]{Integer.valueOf(r12), Boolean.valueOf(r13), Boolean.TRUE});     // Catch: Throwable -> L21
    L27:
        if (this.f6382p == false) goto L32;
        a r17 = this.G;
        removeCallbacks(r17);
        postDelayed(r17, this.e);
        return;
    L32:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        r10.setCurrentItem(r12, r13);
        goto L27
    L16:
        r12 = this.f6388w;
        goto L17
    L11:
        if (r11 < this.F.size()) goto L14;
        goto L12
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r5) {
        ViewPager.OnPageChangeListener r10 = this.D;
        if (r10 == null) goto L6;
        r10.onPageScrollStateChanged(r5);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r5, float r10, int r11) {
        boolean r12 = this.E;
        CopyOnWriteArrayList r13 = this.F;
        if (r12 == true) goto L5;
    L13:
        ViewPager.OnPageChangeListener r14 = this.D;
        if (r14 == null) goto L17;
        r14.onPageScrolled(e(r5), r10, r11);
    L17:
        if (this.f6384r == true) goto L66;
        if (r13 == null) goto L67;
        int r15 = e(r5);
        View r16 = null;
        if (r15 < 0) goto L30;
        if (r13 == null) goto L30;
        if (r13.size() == 0) goto L30;
        if (r15 >= r13.size()) goto L30;
        View r17 = ((LynxUI) r13.get(r15)).getView();
        if (r17 == null) goto L30;
        View r18 = r17.findViewWithTag("swiper_item_mask_tag");
    L31:
        if (r15 < 0) goto L44;
        if (r13 == null) goto L44;
        if (r13.size() == 0) goto L44;
        if (r15 >= r13.size()) goto L44;
        int r19 = r13.size();
        if (r15 != 0) goto L41;
        View r20 = ((LynxUI) r13.get(r19 - 1)).getView();
    L42:
        if (r20 == null) goto L44;
        View r21 = r20.findViewWithTag("swiper_item_mask_tag");
    L45:
        if (r15 < 0) goto L58;
        if (r13 == null) goto L58;
        if (r13.size() == 0) goto L58;
        if (r15 >= r13.size()) goto L58;
        if (r15 != (r13.size() - 1)) goto L55;
        View r22 = ((LynxUI) r13.get(0)).getView();
    L56:
        if (r22 == null) goto L58;
        r16 = r22.findViewWithTag("swiper_item_mask_tag");
        goto L58
    L55:
        r22 = ((LynxUI) r13.get(r15 + 1)).getView();
    L58:
        if (r18 == null) goto L61;
        r18.setAlpha(r10);
    L61:
        if (r21 == null) goto L63;
        r21.setAlpha(1.0f - r10);
    L63:
        if (r16 == null) goto L68;
        r16.setAlpha(1.0f - r10);
        return;
    L68:
        return;
    L41:
        r20 = ((LynxUI) r13.get(r15 - 1)).getView();
    L44:
        r21 = null;
    L30:
        r18 = null;
        goto L31
    L67:
        return;
    L66:
        return;
    L5:
        if (this.f6381o == false) goto L13;
        if ("normal".equals(this.f6379m) == false) goto L13;
        if (r13.size() != 2) goto L13;
        c(r5, findViewWithTag(Integer.valueOf(r5)));
        if (r10 <= 0.0f) goto L13;
        int r23 = r5 + 1;
        c(r23, findViewWithTag(Integer.valueOf(r23)));
        goto L13
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r10) {
        ViewPager.OnPageChangeListener r5 = this.D;
        if (r5 == null) goto L6;
        r5.onPageSelected(e(r10));
    L6:
        if (this.f6380n == false) goto L20;
        int r11 = this.f6373c;
        int r12 = this.d;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r11, r12);
        int r14 = this.f6372b;
        r13.leftMargin = r14;
        r13.rightMargin = r14;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(r11, r12);
        r15.leftMargin = r14;
        r15.rightMargin = r14;
        int r16 = e(this.f6389x);
        int r17 = e(r10);
        if (this.F.size() != 0) goto L10;
        r17 = 0;
    L10:
        ArrayList r18 = this.f6391z;
        if (r18.isEmpty() == true) goto L21;
        if (r16 >= 0) goto L14;
        return;
    L14:
        if (r16 >= r18.size()) goto L23;
        if (r17 >= 0) goto L17;
        return;
    L17:
        if (r17 >= r18.size()) goto L25;
        View r19 = (View) r18.get(r16);
        int r20 = this.f6387v;
        GradientDrawable r21 = new GradientDrawable();
        r21.setShape(1);
        r21.setColor(r20);
        r19.setBackground(r21);
        ((View) r18.get(r16)).setLayoutParams(r15);
        View r22 = (View) r18.get(r17);
        int r23 = this.f6386u;
        GradientDrawable r24 = new GradientDrawable();
        r24.setShape(1);
        r24.setColor(r23);
        r22.setBackground(r24);
        ((View) r18.get(r17)).setLayoutParams(r13);
        this.f6389x = r10;
        return;
    L25:
        return;
    L23:
        return;
    L21:
        return;
    }

    public void setLayerTextureType(int r5) {
        this.A.setLayerType(r5, null);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r5) {
        this.D = r5;
    }

    public void setOverflow(int r5) {
        boolean r10 = false;
        if (r5 != 0) goto L5;
        this.A.setLayerType(0, null);
    L5:
        if (r5 == 0) goto L7;
        r10 = true;
    L7:
        setClipChildren(r10);
    }

    public void setTwoItemCircularSwipe(boolean r5) {
        this.E = r5;
    }
}
