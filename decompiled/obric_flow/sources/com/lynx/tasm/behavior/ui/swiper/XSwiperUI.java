package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.accessibility.d;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.k;
import com.obric.oui.panel.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import jn.a;
import jn.b;
import jn.g;
import jn.h;

/* JADX INFO: loaded from: classes2.dex */
public class XSwiperUI extends UISimpleView<b> {
    public static final int G = 0;
    public static final int H = 0;
    public final m.b A;
    public final a B;
    public final Handler C;
    public final ArrayList D;
    public final a0 E;
    public f F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10670c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10679p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10680q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10681r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f10682t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10683u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10684v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10685w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10686x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10687y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10688z;

    static {
        G = Color.argb(255, 255, 255, 255);
        H = Color.argb(89, 255, 255, 255);
    }

    public XSwiperUI(b0 r5, z r10) {
        super(r5, r10);
        this.f10668a = "normal";
        this.f10669b = false;
        this.f10670c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.f10671h = -1;
        this.f10672i = -1;
        this.f10673j = -1;
        this.f10674k = -1;
        this.f10675l = -1;
        this.f10676m = false;
        this.f10677n = false;
        this.f10678o = false;
        this.f10679p = true;
        this.f10680q = 5000;
        this.f10681r = 500;
        this.s = 0;
        this.f10682t = 0;
        this.f10683u = false;
        this.f10684v = false;
        this.f10685w = false;
        this.f10686x = true;
        this.f10687y = false;
        this.f10688z = true;
        this.A = new m.b(11);
        a r11 = new a();
        r11.f18360a = 0.0f;
        r11.f18361b = 0.8f;
        r11.f18362c = 1.0f;
        r11.d = 0.8f;
        r11.e = 1.0f;
        this.B = r11;
        this.C = new Handler(Looper.getMainLooper());
        this.D = new ArrayList();
        this.E = new a0(this);
        this.F = null;
    }

    public static /* synthetic */ View b(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View l(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View m(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View n(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View o(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View p(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View q(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View r(XSwiperUI r5) {
        return r5.mView;
    }

    public static /* synthetic */ View s(XSwiperUI r5) {
        return r5.mView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(int r5, boolean r10) {
        jn.f r11 = ((b) getView()).f18363a;
        if (r11.getChildCount() <= 0) goto L6;
        r11.f18377h = r5;
        r11.f18368a = r10;
        i(r11, r5, r10, false);
        return;
    L6:
        r11.f18377h = r5;
        r11.f18368a = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        b r10 = new b(r5);
        g r11 = new g(this, r10);
        r10.f18363a.U.add(r11);
        r10.addOnAttachStateChangeListener(new bf.b(this, 3));
        LynxLog.b(2, "LynxSwiperUI", "create Android NewSwiperView");
        return r10;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getAccessibilityHostView() {
        return ((b) this.mView).f18363a;
    }

    public final void i(jn.f r10, int r11, boolean r12, boolean r13) {
        int r5 = r10.getTotalCount();
        int r14 = r10.getCurrentIndex();
        boolean r15 = this.f10678o;
        int r16 = 0;
        if (r15 == false) goto L15;
        if (r11 != 0) goto L15;
        if (r14 != (r5 - 1)) goto L15;
        if (r5 > 2) goto L9;
        if (r13 == true) goto L9;
    L10:
        int r17 = r10.getTotalCount();
        if (r11 < 0) goto L35;
        if (r11 >= r17) goto L36;
        r10.b(r11, r16, r12);
        return;
    L36:
        return;
    L35:
        return;
    L9:
        r16 = 1;
    L15:
        if (r15 == true) goto L17;
    L27:
        if (r11 < r14) goto L30;
        r16 = 1;
    L30:
        int r18 = r10.getTotalCount();
        if (r11 < 0) goto L39;
        if (r11 >= r18) goto L40;
        r10.b(r11, r16, r12);
        return;
    L40:
        return;
    L39:
        return;
    L17:
        if (r11 != (r5 - 1)) goto L27;
        if (r14 != 0) goto L27;
        if (r5 > 2) goto L22;
        r16 = 1;
    L22:
        int r19 = r10.getTotalCount();
        if (r11 < 0) goto L37;
        if (r11 >= r19) goto L38;
        r10.b(r11, r16, r12);
        return;
    L38:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        if ((r5 instanceof LynxUI) == false) goto L6;
        this.mChildren.add(r10, r5);
        r5.setParent(this);
        this.D.add(r10, ((LynxUI) r5).getView());
        ((b) getView()).f18363a.setAdapter(new h(this));
        ((b) getView()).b();
        j(false, false, true);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.f10676m;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(boolean r10, boolean r11, boolean r12) {
        jn.f r5 = ((b) getView()).f18363a;
        if (this.f10676m == false) goto L6;
        int r13 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - getBorderTopWidth();
        int r14 = getBorderBottomWidth();
    L5:
        int r15 = r13 - r14;
        if (r15 != 0) goto L9;
        return;
    L9:
        r5.setHLayoutUpdated(r10);
        r5.setVLayoutUpdated(r11);
        r5.setPropsUpdated(r12);
        r5.setPageMargin(this.f10673j);
        String r16 = this.f10668a;
        r16.getClass();
        byte r17 = -1;
        switch(r16.hashCode()) {
            case -1039745817: goto L29;
            case 2908512: goto L25;
            case 94431515: goto L21;
            case 1720139793: goto L17;
            case 1980277093: goto L13;
            default: goto L32;
        };
    L32:
        switch(r17) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L50;
            case 3: goto L42;
            case 4: goto L34;
            default: goto L55;
        };
    L34:
        r5.setTransformer(this.A);
        if (k(r5, r15) == false) goto L55;
        float r18 = r15;
        r5.setPageSize((int) Math.ceil(0.6f * r18));
        int r19 = (int) ((r18 * 0.4f) / 2.0f);
        if (isRtl() == true) goto L39;
    L41:
        r5.N = r19;
        goto L55
    L39:
        if (this.f10676m == true) goto L41;
        r5.N = -r19;
        goto L55
    L42:
        r5.setTransformer(null);
        if (k(r5, r15) == false) goto L55;
        float r20 = r15;
        r5.setPageSize((int) Math.ceil(0.6f * r20));
        int r21 = (int) ((r20 * 0.4f) / 2.0f);
        if (isRtl() == true) goto L47;
    L49:
        r5.N = r21;
        goto L55
    L47:
        if (this.f10676m == true) goto L49;
        r5.N = -r21;
        goto L55
    L50:
        r5.setTransformer(this.B);
        if (k(r5, r15) == false) goto L55;
        r5.setPageSize(r15);
        r5.N = 0;
        goto L55
    L53:
        r5.setPageSize((int) Math.ceil(r15 * 0.8f));
        r5.setTransformer(null);
        r5.N = 0;
        goto L55
    L54:
        r5.setPageSize(r15);
        r5.setTransformer(null);
        r5.N = 0;
    L55:
        r5.requestLayout();
        return;
    L13:
        if (r16.equals("coverflow") == false) goto L32;
        r17 = 4;
        goto L32
    L17:
        if (r16.equals("flat-coverflow") == false) goto L32;
        r17 = 3;
        goto L32
    L21:
        if (r16.equals("carry") == false) goto L32;
        r17 = 2;
        goto L32
    L25:
        if (r16.equals("carousel") == false) goto L32;
        r17 = 1;
        goto L32
    L29:
        if (r16.equals("normal") == false) goto L32;
        r17 = 0;
        goto L32
    L6:
        r13 = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - getBorderLeftWidth();
        r14 = getBorderRightWidth();
        goto L5
    }

    public final boolean k(jn.f r5, int r10) {
        int r11 = this.f10675l;
        int r12 = this.f10674k;
        int r13 = (r10 - r11) - r12;
        int r14 = this.f10673j;
        int r15 = (r13 - r14) - r14;
        if (this.f10686x == false) goto L6;
        r13 = r15;
    L6:
        if (r11 < 0) goto L21;
        if (r12 < 0) goto L24;
        if (r13 <= 0) goto L25;
        r5.setPageSize(r13);
        int r16 = this.f10675l;
        int r17 = this.f10673j + r16;
        if (this.f10686x == false) goto L14;
        r16 = r17;
    L14:
        if (isRtl() == true) goto L16;
    L18:
        r5.N = r16;
        return false;
    L16:
        if (this.f10676m == true) goto L18;
        r5.N = -r16;
        return false;
    L25:
        return true;
    L24:
        return true;
    L21:
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        int r5 = getWidth();
        int r10 = getHeight();
        super.onLayoutUpdated();
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((b) this.mView).setPadding(this.mPaddingLeft + this.mBorderLeftWidth, r11, this.mPaddingRight + this.mBorderRightWidth, r12);
        ArrayList r13 = this.D;
        r13.clear();
        Iterator<LynxBaseUI> r14 = this.mChildren.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(((LynxUI) r14.next()).getView());
        goto L4
    L6:
        ((b) getView()).f18363a.setAdapter(new h(this));
        b r15 = (b) this.mView;
        boolean r16 = isRtl();
        boolean r17 = true;
        if (r16 == false) goto L9;
        ViewCompat.setLayoutDirection(r15.f18364b, 1);
    L10:
        r15.f18363a.setIsRTL(r16);
        if (getOverflow() == 0) goto L14;
        ((b) this.mView).setClipChildren(false);
    L14:
        if (this.f10671h == r5) goto L16;
        boolean r18 = true;
    L18:
        if (this.f10672i != r10) goto L21;
        r17 = false;
    L21:
        j(r18, r17, false);
        if (this.f10671h == r5) goto L24;
    L27:
        float r19 = r5;
        float r20 = r10;
        if (this.g == true) goto L30;
    L34:
        this.f10671h = r5;
        this.f10672i = r10;
        return;
    L30:
        if (this.mContext.f10152u == null) goto L34;
        i r21 = new i(getSign(), "contentsizechanged");
        r21.a("contentWidth", Float.valueOf(r19 / DisplayMetricsHolder.a().density));
        r21.a("contentHeight", Float.valueOf(r20 / DisplayMetricsHolder.a().density));
        if (getLynxContext() == null) goto L34;
        getLynxContext().g.b(r21);
        goto L34
    L24:
        if (this.f10672i != r10) goto L27;
        return;
    L16:
        r18 = false;
        goto L18
    L9:
        ViewCompat.setLayoutDirection(r15.f18364b, 0);
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void onListCellAppear(String r5, UIList r10) {
        super.onListCellPrepareForReuse(r5, r10);
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        String r11 = constructListStateCacheKey(getTagName(), r5, getIdSelector());
        if (r10.f10522t.containsKey(r11) == false) goto L8;
        int r12 = ((Integer) r10.f10522t.get(r11)).intValue();
    L9:
        c(r12, false);
        return;
    L8:
        r12 = -1;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r5, LynxBaseUI r10, boolean r11) {
        super.onListCellDisAppear(r5, r10, r11);
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        String r12 = constructListStateCacheKey(getTagName(), r5, getIdSelector());
        if (r11 == false) goto L9;
        r10.storeKeyToNativeStorage(r12, Integer.valueOf(((b) this.mView).f18363a.getCurrentIndex()));
        return;
    L9:
        r10.removeKeyFromNativeStorage(r12);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r5, LynxBaseUI r10) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        c(0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f10685w == false) goto L5;
        j(false, false, true);
        this.f10685w = false;
    L5:
        d r5 = this.mContext.j();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.f() == true) goto L12;
        if (r5.g() == true) goto L12;
        return;
    L12:
        if (this.F != null) goto L14;
        this.F = new f(this, 3);
    L14:
        jn.f r10 = ((b) this.mView).f18363a;
        if (r10 == null) goto L20;
        ViewCompat.setAccessibilityDelegate(r10, this.F);
        ViewCompat.setImportantForAccessibility(r10, 1);
        ViewCompat.setImportantForAccessibility(this.mView, 2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        if ((r5 instanceof LynxUI) == false) goto L9;
        this.mChildren.remove(r5);
        this.D.remove(((LynxUI) r5).getView());
        ((b) getView()).f18363a.setAdapter(new h(this));
        b r10 = (b) getView();
        if (r10.f18364b.getChildCount() <= 0) goto L7;
        r10.f18364b.removeViewAt(0);
        r10.f = r10.f;
        r10.c();
    L7:
        j(false, false, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f0
    public void scrollTo(ReadableMap r10, Callback r11) {
        jn.f r5 = ((b) getView()).f18363a;
        if (r5 != null) goto L5;
    L23:
        r11.invoke(new Object[]{1, "Check failed when invoking scrollTo method: viewPager == null || adapter == null"});
        return;
    L5:
        if (r5.getAdapter() == null) goto L23;
        int r12 = r10.getInt("index", -1);
        boolean r13 = r10.getBoolean("smooth", this.f10679p);
        int r14 = !r10.getString("direction", "end").equals("begin") ? 1 : 0;
        if (r5.getChildCount() != 0) goto L11;
        r11.invoke(new Object[]{1, "Check failed when invoking scrollTo method: no swiper item added to viewpager"});
        return;
    L11:
        if (r12 >= 0) goto L13;
    L21:
        r11.invoke(new Object[]{4, "Check failed when invoking scrollTo method: index < 0 or index >= data count"});
        return;
    L13:
        if (r12 >= r5.getTotalCount()) goto L21;
        int r15 = r5.getTotalCount();
        if (r12 < 0) goto L19;
        if (r12 >= r15) goto L19;
        r5.b(r12, r14, r13);
    L19:
        r11.invoke(new Object[]{0});
    }

    @c0(defaultBoolean = false, name = "autoplay")
    public void setAutoPlay(boolean r5) {
        this.f10677n = r5;
        Handler r10 = this.C;
        a0 r11 = this.E;
        r10.removeCallbacks(r11);
        if (this.f10677n == false) goto L6;
        r10.postDelayed(r11, this.f10680q);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultFloat = 0.3f, name = "bounce-begin-threshold")
    public void setBounceBeginThreshold(float r5) {
        ((b) getView()).f18363a.setBounceBeginThreshold(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultInt = 500, name = "bounce-duration")
    public void setBounceDuration(int r5) {
        ((b) getView()).f18363a.setBounceDuration(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultFloat = 0.3f, name = "bounce-end-threshold")
    public void setBounceEndThreshold(float r5) {
        ((b) getView()).f18363a.setBounceEndThreshold(r5);
    }

    @c0(defaultBoolean = false, name = "circular")
    public void setCircular(boolean r5) {
        this.f10678o = r5;
        ((b) this.mView).f18363a.setLoop(r5);
    }

    @c0(defaultBoolean = true, name = "compatible")
    public void setCompatible(boolean r5) {
        this.f10686x = r5;
        this.f10685w = true;
    }

    @c0(defaultInt = 0, name = "current")
    public void setCurrentIndex(int r5) {
        c(r5, this.f10679p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultInt = 500, name = "duration")
    public void setDuration(int r5) {
        this.f10681r = r5;
        if (this.f10679p == false) goto L6;
        ((b) getView()).f18363a.setAnimDuration(r5);
        return;
    L6:
        ((b) getView()).f18363a.setAnimDuration(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = false, name = "enable-bounce")
    public void setEnableBounce(boolean r5) {
        ((b) getView()).f18363a.setEnableBounce(r5);
    }

    @c0(defaultBoolean = false, name = "enable-nested-child")
    public void setEnableNestedChild(boolean r5) {
        jn.f r10 = ((b) this.mView).f18363a;
        if (r10 == null) goto L6;
        r10.setEnableNestedChild(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = true, name = "enable-vice-loop")
    public void setEnableViceLoop(boolean r5) {
        ((b) getView()).f18363a.setEnableViceLoop(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 == null) goto L6;
        this.f10669b = r5.containsKey("change");
        this.f10670c = r5.containsKey("scrollstart");
        this.d = r5.containsKey("scrollend");
        this.e = r5.containsKey("transition");
        this.f = r5.containsKey("scrolltobounce");
        this.g = r5.containsKey("contentsizechanged");
        return;
    }

    @c0(defaultBoolean = false, name = "finish-reset")
    public void setFinishReset(boolean r5) {
        this.f10684v = r5;
    }

    @c0(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r5) {
        ((b) this.mView).f18363a.setForceCanScroll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = true, name = "handle-gesture")
    public void setHandleGesture(boolean r5) {
        ((b) getView()).f18363a.setHandleGesture(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = false, name = "ignore-layout-update")
    public void setIgnoreLayoutUpdate(boolean r5) {
        ((b) getView()).f18363a.setIgnoreLayoutUpdate(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = false, name = "indicator-dots")
    public void setIndicator(boolean r5) {
        LinearLayout r10 = ((b) getView()).f18364b;
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        return;
    L5:
        r11 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(name = "indicator-active-color")
    public void setIndicatorActiveColor(String r5) {
        int r10 = ColorUtils.b(r5);     // Catch: Exception -> L4
    L5:
        b r11 = (b) getView();
        r11.d = r10;
        LinearLayout r12 = r11.f18364b;
        int r13 = r12.getChildCount();
    L6:
        r13 = r13 - 1;
        if (r13 <= (-1)) goto L17;
        if (r13 != r11.f) goto L6;
        r12.getChildAt(r13).setBackground(b.a(r11.d));
        return;
    L17:
        return;
    L4:
        r10 = G;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(name = "indicator-color")
    public void setIndicatorColor(String r5) {
        int r10 = ColorUtils.b(r5);     // Catch: Exception -> L4
    L5:
        b r11 = (b) getView();
        r11.e = r10;
        LinearLayout r12 = r11.f18364b;
        int r13 = r12.getChildCount();
    L6:
        r13 = r13 - 1;
        if (r13 <= (-1)) goto L13;
        if (r13 == r11.f) goto L6;
        r12.getChildAt(r13).setBackground(b.a(r11.e));
        goto L6
    L13:
        return;
    L4:
        r10 = H;
        goto L5
    }

    @c0(defaultInt = 5000, name = "interval")
    public void setInterval(int r5) {
        this.f10680q = r5;
    }

    @c0(defaultBoolean = false, name = "keep-item-view")
    public void setKeepItemView(boolean r5) {
        ((b) this.mView).f18363a.setKeepItemView(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r5) {
        super.setLynxDirection(r5);
        if (r5 == 2) goto L7;
        if (r5 == 2) goto L7;
        b r10 = (b) getView();
        ViewCompat.setLayoutDirection(r10.f18364b, 0);
        r10.f18363a.setIsRTL(false);
    L8:
        this.f10685w = true;
        return;
    L7:
        b r11 = (b) getView();
        ViewCompat.setLayoutDirection(r11.f18364b, 1);
        r11.f18363a.setIsRTL(true);
        goto L8
    }

    @c0(name = "max-x-scale")
    public void setMaxXScale(double r5) {
        float r10 = (float) r5;
        this.B.f18362c = r10;
    }

    @c0(name = "max-y-scale")
    public void setMaxYScale(double r5) {
        float r10 = (float) r5;
        this.B.e = r10;
    }

    @c0(name = "min-x-scale")
    public void setMinXScale(double r5) {
        float r10 = (float) r5;
        this.B.f18361b = r10;
    }

    @c0(name = "min-y-scale")
    public void setMinYScale(double r5) {
        float r10 = (float) r5;
        this.B.d = r10;
    }

    @c0(name = "mode")
    public void setMode(String r5) {
        this.f10668a = r5;
        this.f10685w = true;
    }

    @c0(name = "next-margin")
    public void setNextMargin(pm.a r10) {
        if (r10.getType() != ReadableType.String) goto L17;
        String r5 = r10.asString();
        if (r5.endsWith("px") == false) goto L8;
    L11:
        int r11 = (int) k.c(r5, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().f10152u);
        if (r11 >= 0) goto L15;
        r11 = -1;
    L15:
        this.f10674k = r11;
        this.f10685w = true;
        return;
    L8:
        if (r5.endsWith("rpx") == true) goto L11;
        return;
    }

    @c0(defaultFloat = 0.0f, name = "norm-translation-factor")
    public void setNormalTranslationFactor(double r5) {
        if (r5 <= 1.0d) goto L5;
        return;
    L5:
        if (r5 < (-1.0d)) goto L9;
        float r10 = (float) r5;
        this.B.f18360a = r10;
        this.f10685w = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(name = "orientation")
    @Deprecated
    public void setOrientation(String r5) {
        if ("vertical".equals(r5) == false) goto L9;
        this.f10676m = true;
        b r10 = (b) getView();
        r10.g = 1;
        LinearLayout r11 = r10.f18364b;
        if (r11 == null) goto L7;
        r10.removeView(r11);
        r10.d(1);
    L7:
        r10.f18363a.setOrientation(1);
    L14:
        this.f10685w = true;
        return;
    L9:
        if ("horizontal".equals(r5) == false) goto L14;
        this.f10676m = false;
        b r12 = (b) getView();
        r12.g = 0;
        LinearLayout r13 = r12.f18364b;
        if (r13 == null) goto L13;
        r12.removeView(r13);
        r12.d(0);
    L13:
        r12.f18363a.setOrientation(0);
        goto L14
    }

    @c0(name = "page-margin")
    public void setPageMargin(pm.a r10) {
        if (r10.getType() != ReadableType.String) goto L14;
        String r5 = r10.asString();
        if (r5.endsWith("px") == false) goto L7;
    L8:
        int r11 = (int) k.c(r5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, getLynxContext().f10152u);
        if (r11 > 0) goto L12;
        r11 = 0;
    L12:
        this.f10673j = r11;
        this.f10685w = true;
        return;
    L7:
        if (r5.endsWith("rpx") == true) goto L8;
        return;
    }

    @c0(name = "previous-margin")
    public void setPreviousMargin(pm.a r10) {
        if (r10.getType() != ReadableType.String) goto L17;
        String r5 = r10.asString();
        if (r5.endsWith("px") == false) goto L8;
    L11:
        int r11 = (int) k.c(r5, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().f10152u);
        if (r11 >= 0) goto L15;
        r11 = -1;
    L15:
        this.f10675l = r11;
        this.f10685w = true;
        return;
    L8:
        if (r5.endsWith("rpx") == true) goto L11;
        return;
    }

    @c0(defaultBoolean = false, name = "scroll-before-detached")
    public void setScrollBeforeDetached(boolean r5) {
        this.f10687y = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = true, name = "smooth-scroll")
    public void setSmoothScroll(boolean r5) {
        this.f10679p = r5;
        if (r5 == false) goto L6;
        ((b) getView()).f18363a.setAnimDuration(this.f10681r);
        return;
    L6:
        ((b) getView()).f18363a.setAnimDuration(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c0(defaultBoolean = false, name = "touchable")
    public void setTouchable(boolean r5) {
        this.f10688z = r5;
        ((b) getView()).f18363a.setTouchable(r5);
    }

    @c0(defaultInt = 0, name = "transition-throttle")
    public void setTransitionThrottle(int r5) {
        this.s = r5;
    }

    @c0(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean r5) {
        if (r5 == false) goto L8;
        b r10 = (b) this.mView;
        r10.g = 1;
        LinearLayout r11 = r10.f18364b;
        if (r11 == null) goto L7;
        r10.removeView(r11);
        r10.d(1);
    L7:
        r10.f18363a.setOrientation(1);
    L12:
        this.f10676m = r5;
        this.f10685w = true;
        return;
    L8:
        b r12 = (b) this.mView;
        r12.g = 0;
        LinearLayout r13 = r12.f18364b;
        if (r13 == null) goto L11;
        r12.removeView(r13);
        r12.d(0);
    L11:
        r12.f18363a.setOrientation(0);
        goto L12
    }
}
