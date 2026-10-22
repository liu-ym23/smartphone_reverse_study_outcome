package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleableRes;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.k;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0003`abB'\b\u0007\u0012\u0006\u0010Z\u001a\u00020Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\b\u0002\u0010]\u001a\u00020\u0006¢\u0006\u0004\b^\u0010_J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR*\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\"\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR.\u0010*\u001a\u0004\u0018\u00010#2\b\u0010\u0007\u001a\u0004\u0018\u00010#8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010.\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR*\u00102\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\"\u0010:\u001a\u0002038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u0002038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R(\u0010D\u001a\u0004\u0018\u00010?2\b\u0010\u0007\u001a\u0004\u0018\u00010?8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\"\u0010L\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00105\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R*\u0010P\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\t\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010\rR*\u0010T\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0019\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010\u001dR*\u0010X\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0019\u001a\u0004\bV\u0010\u001b\"\u0004\bW\u0010\u001d¨\u0006c"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "", "setViewPager", "", EventBody.KEY_VALUE, "p", "I", "getSidePadding", "()I", "setSidePadding", "(I)V", "sidePadding", "r", "getType", "setType", WsConstants.KEY_CONNECTION_TYPE, "s", "getDotsColor", "setDotsColor", "dotsColor", "", "o", "F", "getLayoutHeight", "()F", "setLayoutHeight", "(F)V", "layoutHeight", "t", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "Lcom/obric/oui/indicator/OBaseIndicator$b;", "x", "Lcom/obric/oui/indicator/OBaseIndicator$b;", "getPager", "()Lcom/obric/oui/indicator/OBaseIndicator$b;", "setPager", "(Lcom/obric/oui/indicator/OBaseIndicator$b;)V", "pager", "m", "getDotsWidth", "setDotsWidth", "dotsWidth", "q", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "", "h", "Z", "getPendingRefreshParentLayout", "()Z", "setPendingRefreshParentLayout", "(Z)V", "pendingRefreshParentLayout", "g", "getInitialized", "setInitialized", "initialized", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "y", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/OBaseIndicator$c;)V", "pagerDataSetObserver", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "u", "getDotsClickable", "setDotsClickable", "dotsClickable", BaseSwitches.V, "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "w", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "n", "getDotsHeight", "setDotsHeight", "dotsHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6787c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6792k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    protected final ArrayList<com.obric.oui.indicator.b> f6793l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f6794m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f6795n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f6796o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6797p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f6798q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6799r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @ColorInt
    private int f6800s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f6801t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6802u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @ColorInt
    private int f6803v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f6804w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private b f6805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private c f6806y;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f6808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f6809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f6810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f6811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f6812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f6813g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f6814h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f6815i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f6816j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f6817k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f6818l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f6819m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f6820n;

        public a(float r10, float r11, float r12, @StyleableRes int[] r13, @StyleableRes int r14, @StyleableRes int r15, @StyleableRes int r16, @StyleableRes int r17, @StyleableRes int r18, @StyleableRes int r19, @StyleableRes int r110, @StyleableRes int r111, @StyleableRes int r112, @StyleableRes int r113) {
            Intrinsics.checkNotNullParameter(r13, "styleableId");
            this.f6807a = r10;
            this.f6808b = r11;
            this.f6809c = r12;
            this.f6810d = r13;
            this.f6811e = r14;
            this.f6812f = r15;
            this.f6813g = r16;
            this.f6814h = r17;
            this.f6815i = r18;
            this.f6816j = r19;
            this.f6817k = r110;
            this.f6818l = r111;
            this.f6819m = r112;
            this.f6820n = r113;
        }

        public final float a() {
            return this.f6808b;
        }

        public final float b() {
            return this.f6809c;
        }

        public final float c() {
            return this.f6807a;
        }

        public final int d() {
            return this.f6818l;
        }

        public final int e() {
            return this.f6816j;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L34;
            a r11 = (a) r10;
            if (Float.compare(this.f6807a, r11.f6807a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f6808b, r11.f6808b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f6809c, r11.f6809c) == 0) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6810d, r11.f6810d) == true) goto L14;
            return false;
        L14:
            if (this.f6811e == r11.f6811e) goto L16;
            return false;
        L16:
            if (this.f6812f == r11.f6812f) goto L18;
            return false;
        L18:
            if (this.f6813g == r11.f6813g) goto L20;
            return false;
        L20:
            if (this.f6814h == r11.f6814h) goto L22;
            return false;
        L22:
            if (this.f6815i == r11.f6815i) goto L24;
            return false;
        L24:
            if (this.f6816j == r11.f6816j) goto L26;
            return false;
        L26:
            if (this.f6817k == r11.f6817k) goto L28;
            return false;
        L28:
            if (this.f6818l == r11.f6818l) goto L30;
            return false;
        L30:
            if (this.f6819m == r11.f6819m) goto L32;
            return false;
        L32:
            if (this.f6820n == r11.f6820n) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        public final int f() {
            return this.f6817k;
        }

        public final int g() {
            return this.f6814h;
        }

        public final int h() {
            return this.f6815i;
        }

        public int hashCode() {
            int r10 = ((((Float.hashCode(this.f6807a) * 31) + Float.hashCode(this.f6808b)) * 31) + Float.hashCode(this.f6809c)) * 31;
            int[] r11 = this.f6810d;
            if (r11 == null) goto L5;
            int r12 = Arrays.hashCode(r11);
        L7:
            return ((((((((((((((((((((r10 + r12) * 31) + Integer.hashCode(this.f6811e)) * 31) + Integer.hashCode(this.f6812f)) * 31) + Integer.hashCode(this.f6813g)) * 31) + Integer.hashCode(this.f6814h)) * 31) + Integer.hashCode(this.f6815i)) * 31) + Integer.hashCode(this.f6816j)) * 31) + Integer.hashCode(this.f6817k)) * 31) + Integer.hashCode(this.f6818l)) * 31) + Integer.hashCode(this.f6819m)) * 31) + Integer.hashCode(this.f6820n);
        L5:
            r12 = 0;
            goto L7
        }

        public final int i() {
            return this.f6819m;
        }

        public final int j() {
            return this.f6820n;
        }

        public final int k() {
            return this.f6813g;
        }

        public final int l() {
            return this.f6812f;
        }

        public final int[] m() {
            return this.f6810d;
        }

        public final int n() {
            return this.f6811e;
        }

        public String toString() {
            return "CustomDot(defaultWidth=" + this.f6807a + ", defaultHeight=" + this.f6808b + ", defaultSpacing=" + this.f6809c + ", styleableId=" + Arrays.toString(this.f6810d) + ", typeId=" + this.f6811e + ", layoutHeightId=" + this.f6812f + ", dotsWidthId=" + this.f6813g + ", dotsHeightId=" + this.f6814h + ", dotsSpacingId=" + this.f6815i + ", dotsColorId=" + this.f6816j + ", dotsCornerRadiusId=" + this.f6817k + ", dotsClickableId=" + this.f6818l + ", dotsStrokeColorId=" + this.f6819m + ", dotsStrokeWidthId=" + this.f6820n + ")";
        }
    }

    public interface b {
        void a(int r10, boolean r11);

        int b();

        void c();

        void d(com.obric.oui.indicator.d r10);

        boolean e();

        int getCount();
    }

    public interface c {
        Function1<c, Unit> getReleaseAction();
    }

    static final class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f6821c;

        d(OBaseIndicator r10) {
            this.f6821c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f6821c.getPendingRefreshParentLayout() == false) goto L6;
            this.f6821c.u();
        L6:
            if (OBaseIndicator.a(this.f6821c) == false) goto L9;
            this.f6821c.q();
        L9:
            if (OBaseIndicator.c(this.f6821c) == false) goto L12;
            OBaseIndicator.g(this.f6821c);
        L12:
            if (OBaseIndicator.b(this.f6821c) == false) goto L15;
            OBaseIndicator.f(this.f6821c);
            return;
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f6822c;

        e(OBaseIndicator r10) {
            this.f6822c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OBaseIndicator.e(this.f6822c);
            this.f6822c.q();
            OBaseIndicator.f(this.f6822c);
            OBaseIndicator.h(this.f6822c);
            b r10 = this.f6822c.getPager();
            if (r10 != null) goto L5;
        L7:
            k.h(this.f6822c);
            return;
        L5:
            if (r10.getCount() != 1) goto L7;
            k.g(this.f6822c);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2, reason: invalid class name */
    public static final class AnonymousClass2 extends DataSetObserver implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f6823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager f6824b;

        AnonymousClass2(OBaseIndicator r10, ViewPager r11) {
            this.f6823a = r10;
            this.f6824b = r11;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public Function1<c, Unit> getReleaseAction() {
            return new OBaseIndicator$setViewPager$2$releaseAction$1(this);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f6823a.o();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$3, reason: invalid class name */
    public static final class AnonymousClass3 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewPager.OnPageChangeListener f6825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f6826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPager f6827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0 f6828d;

        AnonymousClass3(OBaseIndicator r10, ViewPager r11, Function0 r12) {
            this.f6826b = r10;
            this.f6827c = r11;
            this.f6828d = r12;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public void a(int r10, boolean r11) {
            this.f6827c.setCurrentItem(r10, r11);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public int b() {
            return OBaseIndicator.d(this.f6826b, this.f6827c.getCurrentItem(), getCount());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public void c() {
            ViewPager.OnPageChangeListener r10 = this.f6825a;
            if (r10 == null) goto L6;
            this.f6827c.removeOnPageChangeListener(r10);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public void d(final com.obric.oui.indicator.d r10) {
            Intrinsics.checkNotNullParameter(r10, "onPageChangeListenerHelper");
            ViewPager.OnPageChangeListener r11 = new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(this, r10);
            this.f6825a = r11;
            ViewPager r12 = this.f6827c;
            Intrinsics.checkNotNull(r11);
            r12.addOnPageChangeListener(r11);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public boolean e() {
            return com.obric.oui.indicator.a.b(this.f6827c);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public int getCount() {
            return ((Number) this.f6828d.invoke()).intValue();
        }
    }

    @JvmOverloads
    public OBaseIndicator(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBaseIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBaseIndicator(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6787c = "OBaseIndicator";
        this.f6793l = new ArrayList();
        this.f6794m = getCustom().c();
        this.f6795n = getCustom().a();
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.f6796o = TypedValue.applyDimension(1, 32, r13.getDisplayMetrics());
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.f6797p = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r14.getDisplayMetrics()));
        this.f6798q = getCustom().b();
        this.f6800s = ContextCompat.getColor(r10, u8.c.oui_text_4);
        this.f6801t = this.f6795n / 2;
        this.f6802u = true;
        this.f6803v = ContextCompat.getColor(r10, u8.c.Transparent);
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        this.f6804w = TypedValue.applyDimension(1, 0, r15.getDisplayMetrics());
        if (r11 == null) goto L6;
        TypedArray r16 = r10.obtainStyledAttributes(r11, getCustom().m());
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttr…ttrs, custom.styleableId)");
        setType(r16.getInt(getCustom().n(), this.f6799r));
        setDotsWidth(r16.getDimension(getCustom().k(), this.f6794m));
        setDotsHeight(r16.getDimension(getCustom().g(), this.f6795n));
        setLayoutHeight(r16.getDimension(getCustom().l(), this.f6796o));
        setDotsSpacing(r16.getDimension(getCustom().h(), this.f6798q));
        setDotsColor(r16.getColor(getCustom().e(), this.f6800s));
        setDotsCornerRadius(r16.getDimension(getCustom().f(), this.f6801t));
        this.f6802u = r16.getBoolean(getCustom().d(), true);
        setDotsStrokeColor(r16.getColor(getCustom().i(), this.f6803v));
        setDotsStrokeWidth(r16.getDimension(getCustom().j(), this.f6804w));
        r16.recycle();
        return;
    }

    public /* synthetic */ OBaseIndicator(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ boolean a(OBaseIndicator r10) {
        return r10.f6790i;
    }

    public static final /* synthetic */ boolean b(OBaseIndicator r10) {
        return r10.f6792k;
    }

    public static final /* synthetic */ boolean c(OBaseIndicator r10) {
        return r10.f6791j;
    }

    public static final /* synthetic */ int d(OBaseIndicator r10, int r11, int r12) {
        return r10.l(r11, r12);
    }

    public static final /* synthetic */ void e(OBaseIndicator r10) {
        r10.p();
    }

    public static final /* synthetic */ void f(OBaseIndicator r10) {
        r10.r();
    }

    public static final /* synthetic */ void g(OBaseIndicator r10) {
        r10.s();
    }

    public static final /* synthetic */ void h(OBaseIndicator r10) {
        r10.t();
    }

    private final int l(int r10, int r11) {
        if (r11 != 0) goto L14;
        ea.b.j(this.f6787c, "mod num is 0");
        return r10;
    L14:
        return r10 % r11;
    L7:
        e = move-exception;
        boolean r12 = e instanceof ArithmeticException;
        String r13 = this.f6787c;
        if (r12 == false) goto L11;
        StringBuilder r14 = new StringBuilder();
        String r15 = "不要乱除0呀 ";
    L12:
        r14.append(r15);
        r14.append(e.getMessage());
        ea.b.j(r13, r14.toString());
        return r10;
    L11:
        r14 = new StringBuilder();
        r15 = "抓住了一个Exception并ignore, ";
        goto L12
    }

    private final void m() {
        post(new d(this));
    }

    private final void p() {
        if (this.f6805x != null) goto L5;
        return;
    L5:
        int r10 = this.f6793l.size();
        b r11 = this.f6805x;
        Intrinsics.checkNotNull(r11);
        if (r10 >= r11.getCount()) goto L8;
        b r12 = this.f6805x;
        Intrinsics.checkNotNull(r12);
        j(r12.getCount() - this.f6793l.size());
        return;
    L8:
        int r13 = this.f6793l.size();
        b r14 = this.f6805x;
        Intrinsics.checkNotNull(r14);
        if (r13 <= r14.getCount()) goto L13;
        int r15 = this.f6793l.size();
        b r16 = this.f6805x;
        Intrinsics.checkNotNull(r16);
        w(r15 - r16.getCount());
        return;
    }

    private final void r() {
        if (this.f6788g == true) goto L6;
        this.f6792k = true;
        return;
    L6:
        int r10 = 0;
        this.f6792k = false;
        b r11 = this.f6805x;
        if (r11 != null) goto L9;
        return;
    L9:
        Intrinsics.checkNotNull(r11);
        int r12 = r11.getCount();
    L10:
        if (r10 >= r12) goto L15;
        b r13 = this.f6805x;
        Intrinsics.checkNotNull(r13);
        if (r10 == r13.b()) goto L14;
        this.f6793l.get(r10).setWidth((int) this.f6794m);
    L14:
        r10 = r10 + 1;
        goto L10
    }

    private final void s() {
        if (this.f6788g == true) goto L6;
        this.f6791j = true;
        return;
    L6:
        int r10 = 0;
        this.f6791j = false;
        b r11 = this.f6805x;
        if (r11 != null) goto L9;
        return;
    L9:
        Intrinsics.checkNotNull(r11);
        int r12 = r11.b();
    L10:
        if (r10 >= r12) goto L12;
        this.f6793l.get(r10).setHorizontalMargin((int) this.f6798q);
        r10 = r10 + 1;
        goto L10
    }

    private final void setPagerDataSetObserver(c r10) {
        c r11 = this.f6806y;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNull(r11);
        Function1<c, Unit> r12 = r11.getReleaseAction();
        c r13 = this.f6806y;
        Intrinsics.checkNotNull(r13);
        r12.invoke(r13);
    L5:
        this.f6806y = r10;
    }

    private final void t() {
        b r10 = this.f6805x;
        if (r10 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r10);
        if (r10.e() == false) goto L9;
        b r11 = this.f6805x;
        Intrinsics.checkNotNull(r11);
        r11.c();
        com.obric.oui.indicator.d r12 = k();
        b r13 = this.f6805x;
        Intrinsics.checkNotNull(r13);
        r13.d(r12);
        b r14 = this.f6805x;
        Intrinsics.checkNotNull(r14);
        r12.c(r14.b(), 0.0f);
        return;
    }

    private final void w(int r10) {
        int r11 = this.f6793l.size();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        v(r12 + r11);
        r12 = r12 + 1;
        goto L3
    }

    public abstract a getCustom();

    public final boolean getDotsClickable() {
        return this.f6802u;
    }

    public final int getDotsColor() {
        return this.f6800s;
    }

    public final float getDotsCornerRadius() {
        return this.f6801t;
    }

    public final float getDotsHeight() {
        return this.f6795n;
    }

    public final float getDotsSpacing() {
        return this.f6798q;
    }

    public final int getDotsStrokeColor() {
        return this.f6803v;
    }

    public final float getDotsStrokeWidth() {
        return this.f6804w;
    }

    public final float getDotsWidth() {
        return this.f6794m;
    }

    protected final boolean getInitialized() {
        return this.f6788g;
    }

    public final float getLayoutHeight() {
        return this.f6796o;
    }

    public final b getPager() {
        return this.f6805x;
    }

    protected final boolean getPendingRefreshParentLayout() {
        return this.f6789h;
    }

    public final int getSidePadding() {
        return this.f6797p;
    }

    public final int getType() {
        return this.f6799r;
    }

    public abstract void i(int r10);

    protected final void j(int r10) {
        int r11 = this.f6793l.size();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        i(r12 + r11);
        r12 = r12 + 1;
        goto L3
    }

    public abstract com.obric.oui.indicator.d k();

    public abstract void n(int r10);

    public final void o() {
        if (this.f6805x != null) goto L5;
        return;
    L5:
        post(new e(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        m();
    }

    protected final void q() {
        if (this.f6788g == true) goto L6;
        this.f6790i = true;
        return;
    L6:
        int r10 = 0;
        this.f6790i = false;
        int r11 = this.f6793l.size();
    L7:
        if (r10 >= r11) goto L9;
        n(r10);
        r10 = r10 + 1;
        goto L7
    }

    public final void setDotsClickable(boolean r10) {
        this.f6802u = r10;
    }

    public final void setDotsColor(int r10) {
        if (this.f6799r != 1) goto L5;
        r10 = 872415231;
    L8:
        this.f6800s = r10;
        q();
        return;
    L5:
        if (this.f6800s != r10) goto L8;
    }

    public final void setDotsCornerRadius(float r10) {
        if (this.f6801t == r10) goto L6;
        this.f6801t = r10;
        q();
        return;
    }

    public final void setDotsHeight(float r10) {
        if (this.f6795n == r10) goto L6;
        this.f6795n = r10;
        r();
        return;
    }

    public final void setDotsSpacing(float r10) {
        if (this.f6798q == r10) goto L6;
        this.f6798q = r10;
        s();
        return;
    }

    public final void setDotsStrokeColor(int r10) {
        if (this.f6803v == r10) goto L6;
        this.f6803v = r10;
        q();
        return;
    }

    public final void setDotsStrokeWidth(float r10) {
        if (this.f6804w == r10) goto L6;
        this.f6804w = r10;
        q();
        return;
    }

    public final void setDotsWidth(float r10) {
        if (this.f6794m == r10) goto L6;
        this.f6794m = r10;
        r();
        return;
    }

    protected final void setInitialized(boolean r10) {
        this.f6788g = r10;
    }

    public final void setLayoutHeight(float r10) {
        if (this.f6796o == r10) goto L6;
        this.f6796o = r10;
        u();
        return;
    }

    public final void setPager(b r10) {
        b r11 = this.f6805x;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNull(r11);
        r11.c();
    L5:
        this.f6805x = r10;
    }

    protected final void setPendingRefreshParentLayout(boolean r10) {
        this.f6789h = r10;
    }

    public final void setSidePadding(int r10) {
        if (this.f6797p == r10) goto L6;
        this.f6797p = r10;
        u();
        return;
    }

    public final void setType(int r10) {
        if (this.f6799r == r10) goto L6;
        this.f6799r = r10;
        u();
        q();
        return;
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(ViewPager r10) {
        Intrinsics.checkNotNullParameter(r10, "viewPager");
        PagerAdapter r11 = r10.getAdapter();
        if (r11 == null) goto L5;
        int r12 = r11.getCount();
    L6:
        y(r10, r12);
        return;
    L5:
        r12 = 1;
        goto L6
    }

    public abstract void u();

    public abstract void v(int r10);

    protected final void x() {
        this.f6788g = true;
    }

    public final void y(ViewPager r10, final int r11) {
        Intrinsics.checkNotNullParameter(r10, "viewPager");
        z(r10, new AnonymousClass1(r11));
    }

    public final void z(ViewPager r10, Function0<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "viewPager");
        Intrinsics.checkNotNullParameter(r11, "pageCount");
        if (r10.getAdapter() == null) goto L7;
        setPagerDataSetObserver(new AnonymousClass2(this, r10));
        PagerAdapter r12 = r10.getAdapter();
        Intrinsics.checkNotNull(r12);
        Object r13 = this.f6806y;
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.database.DataSetObserver");
        r12.registerDataSetObserver((DataSetObserver) r13);
        setPager(new AnonymousClass3(this, r10, r11));
        o();
        return;
    L7:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }
}
