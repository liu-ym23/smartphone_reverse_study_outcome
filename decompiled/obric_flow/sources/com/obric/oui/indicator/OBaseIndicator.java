package com.obric.oui.indicator;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.common.oui.R$color;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0005eijW_B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR*\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R*\u00102\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\rR*\u00106\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u0010\rR*\u0010:\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010.\u001a\u0004\b8\u00100\"\u0004\b9\u0010\rR*\u0010>\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010#\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R*\u0010B\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010.\u001a\u0004\b@\u00100\"\u0004\bA\u0010\rR*\u0010F\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010.\u001a\u0004\bD\u00100\"\u0004\bE\u0010\rR*\u0010J\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010#\u001a\u0004\bH\u0010%\"\u0004\bI\u0010'R\"\u0010N\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0016\u001a\u0004\bL\u0010\u0018\"\u0004\bM\u0010\u001aR*\u0010R\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010.\u001a\u0004\bP\u00100\"\u0004\bQ\u0010\rR*\u0010V\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010#\u001a\u0004\bT\u0010%\"\u0004\bU\u0010'R.\u0010^\u001a\u0004\u0018\u00010W2\b\u0010!\u001a\u0004\u0018\u00010W8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R(\u0010d\u001a\u0004\u0018\u00010_2\b\u0010!\u001a\u0004\u0018\u00010_8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006k"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pageCount", "", "setManualPageCount", "(I)V", "currentItem", "setManualCurrentItem", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "", "b", "Z", "getInitialized", "()Z", "setInitialized", "(Z)V", "initialized", "c", "getPendingRefreshParentLayout", "setPendingRefreshParentLayout", "pendingRefreshParentLayout", "", "value", "h", "F", "getDotsWidth", "()F", "setDotsWidth", "(F)V", "dotsWidth", "i", "getDotsHeight", "setDotsHeight", "dotsHeight", "j", "I", "getLayoutHeight", "()I", "setLayoutHeight", "layoutHeight", "k", "getVerticalSidePadding", "setVerticalSidePadding", "verticalSidePadding", "l", "getSidePadding", "setSidePadding", "sidePadding", "m", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "n", "getType", "setType", "type", "o", "getDotsColor", "setDotsColor", "dotsColor", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "q", "getDotsClickable", "setDotsClickable", "dotsClickable", "r", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "s", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Lcom/obric/oui/indicator/l;", "t", "Lcom/obric/oui/indicator/l;", "getPager", "()Lcom/obric/oui/indicator/l;", "setPager", "(Lcom/obric/oui/indicator/l;)V", "pager", "Lcom/obric/oui/indicator/m;", "u", "Lcom/obric/oui/indicator/m;", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/m;)V", "pagerDataSetObserver", "Lcom/obric/oui/indicator/j;", "getCustom", "()Lcom/obric/oui/indicator/j;", "custom", "com/obric/oui/indicator/k", "androidx/core/view/inputmethod/a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f13440v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13443c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13449m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13450n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13451o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13452p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13453q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13454r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l f13455t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public m f13456u;

    @JvmOverloads
    public OBaseIndicator(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static final int a(OBaseIndicator r5, int r10, int r11) {
        String r12 = r5.f13441a;
        if (r11 != 0) goto L13;
        ps.a.g(r12, "mod num is 0");
        return r10;
    L13:
        return r10 % r11;
    L7:
        e = move-exception;
        if ((e instanceof ArithmeticException) == false) goto L11;
        ps.a.g(r12, Intrinsics.stringPlus("不要乱除0呀 ", e.getMessage()));
        return r10;
    L11:
        ps.a.g(r12, Intrinsics.stringPlus("抓住了一个Exception并ignore, ", e.getMessage()));
        return r10;
    }

    public static /* synthetic */ void m(OBaseIndicator r5, int r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        r5.l(r10, r11, null);
    }

    private final void setPagerDataSetObserver(m r5) {
        m r10 = this.f13456u;
        if (r10 == null) goto L6;
        Function1 r11 = r10.a();
        m r12 = this.f13456u;
        Intrinsics.checkNotNull(r12);
        r11.invoke(r12);
    L6:
        this.f13456u = r5;
    }

    public abstract r6.a b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g() {
        l r5 = this.f13455t;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.getCount();
    }

    public abstract j getCustom();

    public final boolean getDotsClickable() {
        return this.f13453q;
    }

    public final int getDotsColor() {
        return this.f13451o;
    }

    public final float getDotsCornerRadius() {
        return this.f13452p;
    }

    public final float getDotsHeight() {
        return this.f13445i;
    }

    public final float getDotsSpacing() {
        return this.f13449m;
    }

    public final int getDotsStrokeColor() {
        return this.f13454r;
    }

    public final float getDotsStrokeWidth() {
        return this.s;
    }

    public final float getDotsWidth() {
        return this.f13444h;
    }

    public final boolean getInitialized() {
        return this.f13442b;
    }

    public final int getLayoutHeight() {
        return this.f13446j;
    }

    public final l getPager() {
        return this.f13455t;
    }

    public final boolean getPendingRefreshParentLayout() {
        return this.f13443c;
    }

    public final int getSidePadding() {
        return this.f13448l;
    }

    public final int getType() {
        return this.f13450n;
    }

    public final int getVerticalSidePadding() {
        return this.f13447k;
    }

    public final void h() {
        if (this.f13455t != null) goto L6;
        return;
    L6:
        if (this.f13442b == true) goto L9;
        this.d = true;
        return;
    L9:
        post(new i(this, 1));
    }

    public final void i() {
        if (this.f13442b == true) goto L6;
        this.e = true;
        return;
    L6:
        this.e = false;
        c();
    }

    public final void j() {
        if (this.f13442b == true) goto L6;
        this.g = true;
        return;
    L6:
        this.g = false;
        d();
    }

    public abstract void k();

    public final void l(int r5, int r10, androidx.core.view.inputmethod.a r11) {
        setPagerDataSetObserver(null);
        setPager(new k(this, r5, r10, r11));
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        post(new i(this, 0));
    }

    public final void setDotsClickable(boolean r5) {
        this.f13453q = r5;
    }

    public final void setDotsColor(int r5) {
        if (this.f13450n == 1) goto L5;
        this.f13451o = r5;
        i();
        return;
    L5:
        this.f13451o = 872415231;
        i();
    }

    public final void setDotsCornerRadius(float r5) {
        if (this.f13452p == r5) goto L7;
        this.f13452p = r5;
        i();
        return;
    }

    public final void setDotsHeight(float r5) {
        if (this.f13445i == r5) goto L7;
        this.f13445i = r5;
        j();
        return;
    }

    public final void setDotsSpacing(float r5) {
        if (this.f13449m == r5) goto L11;
        this.f13449m = r5;
        if (this.f13442b == true) goto L8;
        this.f = true;
        return;
    L8:
        this.f = false;
        e();
        return;
    }

    public final void setDotsStrokeColor(int r5) {
        if (this.f13454r == r5) goto L6;
        this.f13454r = r5;
        i();
        return;
    }

    public final void setDotsStrokeWidth(float r5) {
        if (this.s == r5) goto L7;
        this.s = r5;
        i();
        return;
    }

    public final void setDotsWidth(float r5) {
        if (this.f13444h == r5) goto L7;
        this.f13444h = r5;
        j();
        return;
    }

    public final void setInitialized(boolean r5) {
        this.f13442b = r5;
    }

    public final void setLayoutHeight(int r5) {
        if (this.f13446j == r5) goto L6;
        this.f13446j = r5;
        k();
        return;
    }

    public final void setManualCurrentItem(int r5) {
        l r10 = this.f13455t;
        if ((r10 instanceof k) == false) goto L5;
        k r11 = (k) r10;
    L6:
        if (r11 != null) goto L8;
        ps.a.g(this.f13441a, "setManualCurrentItem requires setManualPager before manual updates");
        throw new IllegalStateException("setManualCurrentItem requires setManualPager before manual updates");
    L8:
        if (r11.b(r5) == false) goto L18;
        r6.a r12 = r11.f13495b;
        if (r12 != null) goto L12;
    L14:
        r11.e.h();
        return;
    L12:
        if (r11.d() == false) goto L14;
        r12.l(0.0f, r11.d);
        return;
    L18:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setManualPageCount(int r5) {
        l r10 = this.f13455t;
        if ((r10 instanceof k) == false) goto L5;
        k r11 = (k) r10;
    L6:
        if (r11 == null) goto L29;
        OBaseIndicator r12 = r11.e;
        if (r5 < 0) goto L27;
        if (r5 <= 0) goto L11;
    L15:
        if (r5 <= 0) goto L23;
        int r13 = r11.d;
        if (r13 < 0) goto L20;
        if (r13 < r5) goto L23;
    L20:
        String r14 = "setManualPageCount requires currentItem in 0 until pageCount, currentItem=" + r11.d + " pageCount=" + r5;
        ps.a.g(r12.f13441a, r14);
        throw new IllegalArgumentException(r14);
    L23:
        if (r11.f13496c == r5) goto L31;
        r11.f13496c = r5;
        h();
        return;
    L31:
        return;
    L11:
        if (r11.d == 0) goto L15;
        StringBuilder r15 = j0.s(r5, "setManualPageCount requires currentItem=0 when pageCount=", ", currentItem=");
        r15.append(r11.d);
        String r16 = r15.toString();
        ps.a.g(r12.f13441a, r16);
        throw new IllegalArgumentException(r16);
    L27:
        String r17 = Intrinsics.stringPlus("setManualPageCount requires pageCount >= 0, pageCount=", Integer.valueOf(r5));
        ps.a.g(r12.f13441a, r17);
        throw new IllegalArgumentException(r17);
    L29:
        ps.a.g(this.f13441a, "setManualPageCount requires setManualPager before manual updates");
        throw new IllegalStateException("setManualPageCount requires setManualPager before manual updates");
    L5:
        r11 = null;
        goto L6
    }

    @JvmOverloads
    public final void setManualPager(int r5) {
        m(this, r5, 0, 6);
    }

    public final void setPager(l r5) {
        l r10 = this.f13455t;
        if (r10 == null) goto L6;
        r10.e();
    L6:
        this.f13455t = r5;
    }

    public final void setPendingRefreshParentLayout(boolean r5) {
        this.f13443c = r5;
    }

    public final void setSidePadding(int r5) {
        if (this.f13448l == r5) goto L6;
        this.f13448l = r5;
        k();
        return;
    }

    public final void setType(int r5) {
        if (this.f13450n == r5) goto L6;
        this.f13450n = r5;
        k();
        i();
        return;
    }

    public final void setVerticalSidePadding(int r5) {
        if (this.f13447k == r5) goto L6;
        this.f13447k = r5;
        k();
        return;
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(ViewPager r5) {
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        PagerAdapter r10 = r5.getAdapter();
        if (r10 != null) goto L5;
        final int r11 = 1;
    L6:
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Function0<Integer> r12 = new AnonymousClass1(r11);
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Intrinsics.checkNotNullParameter(r12, "pageCount");
        if (r5.getAdapter() == null) goto L15;
        setPagerDataSetObserver(new n(this, r5));
        PagerAdapter r13 = r5.getAdapter();
        Intrinsics.checkNotNull(r13);
        Object r14 = this.f13456u;
        if (r14 == null) goto L13;
        r13.registerDataSetObserver((DataSetObserver) r14);
        setPager(new com.bytedance.ies.web.jsbridge2.p(r5, this, r12));
        h();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.database.DataSetObserver");
    L15:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    L5:
        r11 = r10.getCount();
        goto L6
    }

    @JvmOverloads
    public OBaseIndicator(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBaseIndicator(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBaseIndicator(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f13441a = "OBaseIndicator";
        this.f13444h = getCustom().f13484a;
        this.f13445i = getCustom().f13485b;
        this.f13446j = -2;
        this.f13447k = com.lynx.tasm.utils.a.B(7, this);
        this.f13448l = com.lynx.tasm.utils.a.B(10, this);
        this.f13449m = getCustom().f13486c;
        this.f13451o = ContextCompat.getColor(r5, R$color.oui_text_4);
        this.f13452p = this.f13445i / 2;
        this.f13453q = true;
        this.f13454r = ContextCompat.getColor(r5, R$color.Transparent);
        this.s = com.lynx.tasm.utils.a.E(0, this);
        if (r10 == null) goto L6;
        TypedArray r12 = r5.obtainStyledAttributes(r10, getCustom().d);
        setType(r12.getInt(getCustom().e, this.f13450n));
        setDotsWidth(r12.getDimension(getCustom().g, this.f13444h));
        setDotsHeight(r12.getDimension(getCustom().f13487h, this.f13445i));
        setLayoutHeight(r12.getDimensionPixelSize(getCustom().f, -2));
        setDotsSpacing(r12.getDimension(getCustom().f13488i, this.f13449m));
        setDotsColor(r12.getColor(getCustom().f13489j, this.f13451o));
        setDotsCornerRadius(r12.getDimension(getCustom().f13490k, this.f13452p));
        this.f13453q = r12.getBoolean(getCustom().f13491l, true);
        setDotsStrokeColor(r12.getColor(getCustom().f13492m, this.f13454r));
        setDotsStrokeWidth(r12.getDimension(getCustom().f13493n, this.s));
        r12.recycle();
        return;
    }
}
