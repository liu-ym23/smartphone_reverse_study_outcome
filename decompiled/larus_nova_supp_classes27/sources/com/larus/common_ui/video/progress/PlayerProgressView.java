package com.larus.common_ui.video.progress;

import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusViewMusicPlayerProgressBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0003GHIB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017J\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020'H\u0017J\u0010\u0010*\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u001a\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u00020\u0017H\u0002J\u0018\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020#H\u0002J\u0018\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0017H\u0002J\u000e\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020#J\u0006\u0010<\u001a\u00020#J&\u0010=\u001a\u00020#2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010>\u001a\u00020\u00152\b\b\u0003\u0010\u0012\u001a\u00020\u0007J\u0016\u0010?\u001a\u00020#2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020#J\u0016\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\u0017J\f\u0010E\u001a\u00020F*\u00020\u0007H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/common_ui/video/progress/PlayerProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewMusicPlayerProgressBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusViewMusicPlayerProgressBinding;", "binding$delegate", "Lkotlin/Lazy;", "duration", "Lkotlin/Function0;", "displayMode", "max", "onProgressChangeListener", "Lcom/larus/common_ui/video/progress/PlayerProgressView$IProgressChangedListener;", "inTouching", "", "downPoint", "Lcom/larus/common_ui/video/progress/PlayerProgressView$TouchPoint;", "dragStartProgress", "animator", "Landroid/animation/ValueAnimator;", "seekbarHeight", "", "seekbarRounded", "seekbarEnlargeHeight", "supportTouch", "setSupportTouch", "", "value", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "handleClick", "handleActionUpOrCancel", "handleActionMove", "handleActionDown", "changeSeekBarStyle", "enlarge", "loading", "startValueAnimator", "fromValue", "toValue", "initSeekBar", "refreshProgressBar", "percent", "smooth", "updateMaxProgress", "total", "asyncUpdateDuration", "startLoading", "stopLoading", "init", "progressChangedListener", "updateProgress", "setUIToDark", "updateTimeLine", "currentTime", "setSeekBarAlignToBottom", "alignToBottom", "subToDisplay", "", "Companion", "IProgressChangedListener", "TouchPoint", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerProgressView extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public final Lazy a;
    public Function0<Integer> b;
    public int c;
    public int d;
    public a e;
    public boolean f;
    public b g;
    public int h;
    public ValueAnimator i;
    public final float j;
    public final boolean k;
    public final float l;
    public boolean m;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/video/progress/PlayerProgressView$Companion$DisplayMode;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        public @interface DisplayMode {
            public static final a Companion = null;
            public static final int DEFAULT = 0;
            public static final int MUSIC = 1;
            public static final int VIDEO = 2;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }
    }

    public interface a {
        void a(double r1);

        void b();

        void c();

        void onProgressChanged(double r1);
    }

    public static final class b {
        public final float a;
        public final float b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "TouchPoint(x=" + this.a + ", y=" + this.b + ')';
        }

        public b(float r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public PlayerProgressView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlayerProgressView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusViewMusicPlayerProgressBinding getBinding() {
        return (LarusViewMusicPlayerProgressBinding) this.a.getValue();
    }

    public final void Z5() {
        AppHost.Companion r0 = AppHost.a;
        Application r1 = r0.getApplication();
        Configuration r2 = new Configuration(r0.getApplication().getResources().getConfiguration());
        r2.uiMode = 32;
        Context r3 = r1.createConfigurationContext(r2);
        NewMiraResourcesManager.getInstance().install(r3);
        getBinding().f.setProgressDrawable(ResourcesCompat.getDrawable(r3.getResources(), 2131243283, null));
    }

    public final void b6() {
        LarusViewMusicPlayerProgressBinding r0 = getBinding();
        float r1 = (r0.f.getProgress() / r0.f.getMax()) * r0.f.getWidth();
        V5(false, true);
        r0.e.setLoadingLength((int) r1);
        FLogger.a.d("PlayerProgressView", "[startLoading] loadingLength=" + r1);
        HorizontalProgressLayer r2 = r0.e;
        r2.getClass();
        e1.x(r2);
        r2.f = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new HorizontalProgressLayer$startLoadingAnimation$1(r2, null), 3, null);
    }

    public final void c6() {
        final LarusViewMusicPlayerProgressBinding r0 = getBinding();
        t0.e(new f(r0));
    }

    public final void U5() {
        getBinding();
    }

    public final String i6(int r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        if (r0.length() >= 2) goto L6;
        r0.insert(0, "0");
    L6:
        return r0.toString();
    }

    public final void k6(int r2) {
        getBinding().f.setMax(r2);
        this.d = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.m == false) goto L7;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L7:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        if (this.m == false) goto L62;
        int r0 = r12.getAction();
        if (r0 != 0) goto L7;
        this.g = new b(r12.getX(), r12.getY());
        this.h = getBinding().f.getProgress();
        V5(true, false);
    L60:
        return true;
    L7:
        if (r0 == 1) goto L43;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L43;
    L13:
        if (this.f == true) goto L17;
        a r1 = this.e;
        if (r1 == null) goto L17;
        r1.c();
    L17:
        this.f = true;
        float r2 = r12.getX() - this.g.a;
        if (Math.abs(r2) <= Math.abs(r12.getY() - this.g.b)) goto L39;
        requestDisallowInterceptTouchEvent(true);
        Integer r13 = Integer.valueOf(getBinding().f.getWidth());
        if (r13.intValue() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        r13 = null;
    L26:
        if (r13 == null) goto L60;
        float r7 = (getBinding().f.getMax() / r13.intValue()) * r2;
        float r14 = RangesKt.coerceIn(this.h + r7, 0.0f, getBinding().f.getMax());
        getBinding().f.setProgress((int) r14);
        FLogger.a.d("PlayerProgressView", "[handleActionMove] offsetX=" + r2 + ", progressOffset=" + r7 + ", newProgress=" + r14 + "   " + getBinding().f.getProgress());
        a r15 = this.e;
        if (r15 == null) goto L30;
        r15.onProgressChanged(((double) getBinding().f.getProgress()) / ((double) getBinding().f.getMax()));
    L30:
        a r16 = this.e;
        if (r16 == null) goto L34;
        r16.a(((double) getBinding().f.getProgress()) / ((double) getBinding().f.getMax()));
    L34:
        if (this.c != 2) goto L60;
        if (getBinding().g.getVisibility() == 0) goto L60;
        getBinding().g.setVisibility(0);
        goto L60
    L22:
        r6 = false;
        goto L23
    L39:
        if (this.f == false) goto L41;
        this.g = new b(r12.getX(), r12.getY());
        this.h = getBinding().f.getProgress();
        goto L60
    L41:
        requestDisallowInterceptTouchEvent(false);
    L43:
        if (this.f == true) goto L51;
        int r3 = getBinding().f.getProgressDrawable().getBounds().left + getPaddingStart();
        float r17 = RangesKt.coerceAtLeast(r12.getX() - r3, 0.0f);
        int r4 = getBinding().f.getProgressDrawable().getBounds().width();
        float r8 = r17 / r4;
        int r9 = (int) (getBinding().f.getMax() * r8);
        getBinding().f.setProgress(r9);
        FLogger.a.d("PlayerProgressView", "[handleClick] clickX=" + r17 + ", barLeftX=" + r3 + ", length=" + r4 + ", progressPercent=" + r8 + ", progress=" + r9);
        a r18 = this.e;
        if (r18 == null) goto L47;
        r18.onProgressChanged(((double) getBinding().f.getProgress()) / ((double) getBinding().f.getMax()));
    L47:
        a r110 = this.e;
        if (r110 == null) goto L51;
        r110.a(((double) getBinding().f.getProgress()) / ((double) getBinding().f.getMax()));
    L51:
        if (this.c == 2) goto L53;
    L55:
        V5(false, false);
        a r111 = this.e;
        if (r111 == null) goto L58;
        r111.b();
    L58:
        this.f = false;
        goto L60
    L53:
        if (getBinding().g.getVisibility() != 0) goto L55;
        getBinding().g.setVisibility(4);
        goto L55
    L62:
        return super/*android.view.ViewGroup*/.onTouchEvent(r12);
    }

    public final void setSeekBarAlignToBottom(boolean r3) {
        ViewGroup.LayoutParams r0 = getBinding().f.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r3 == false) goto L5;
        ((ConstraintLayout.LayoutParams) r1).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r1).topToTop = -1;
        ((ConstraintLayout.LayoutParams) r1).topToBottom = -1;
    L6:
        getBinding().f.setLayoutParams(r1);
        return;
    L5:
        ((ConstraintLayout.LayoutParams) r1).bottomToBottom = 2131369197;
        ((ConstraintLayout.LayoutParams) r1).topToTop = 2131369197;
        goto L6
    }

    public final void setSupportTouch(boolean r1) {
        this.m = r1;
    }

    public static Unit R5(PlayerProgressView r1, float r2) {
        ViewGroup.LayoutParams r0 = r1.getBinding().f.getLayoutParams();
        r0.height = (int) r2;
        r1.getBinding().f.setLayoutParams(r0);
        return Unit.INSTANCE;
    }

    public static Unit T5(PlayerProgressView r1, float r2) {
        ViewGroup.LayoutParams r0 = r1.getBinding().f.getLayoutParams();
        r0.height = (int) r2;
        r1.getBinding().f.setLayoutParams(r0);
        return Unit.INSTANCE;
    }

    public final void J1(float r8, boolean r9) {
        if (this.f == true) goto L19;
        int r0 = (int) ((this.d * r8) / 100);
        if (Build.VERSION.SDK_INT < 24) goto L14;
        if (r9 == false) goto L14;
        if (r0 <= getBinding().f.getProgress()) goto L12;
        getBinding().f.setProgress(r0);
        return;
    L12:
        if ((((double) getBinding().f.getProgress()) - (((double) this.d) * 0.05d)) <= r8) goto L17;
        getBinding().f.setProgress(r0);
        return;
    L17:
        return;
    L14:
        getBinding().f.setProgress(r0);
        return;
    }

    public final void V5(final boolean r4, final boolean r5) {
        if (r4 == false) goto L4;
        final float r0 = this.l;
    L5:
        getBinding().f.post(new g(this, r0, r4, r5));
        return;
    L4:
        r0 = this.j;
        goto L5
    }

    public final void n6(int r7, int r8) {
        int r9 = (int) Math.rint(((double) r8) / 1000.0d);
        int r0 = r9 % 60;
        int r10 = (int) Math.rint(((double) r7) / 1000.0d);
        int r1 = r10 % 60;
        getBinding().b.setText(i6(r10 / 60));
        getBinding().c.setText(i6(r1));
        getBinding().h.setText(i6(r9 / 60));
        getBinding().i.setText(i6(r0));
    }

    public PlayerProgressView(final Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = LazyKt.lazy(new h(r5, this));
        this.d = 100;
        this.g = new b(0.0f, 0.0f);
        float r8 = c7.c(4);
        this.j = r8;
        this.k = true;
        float r1 = c7.c(12);
        this.l = r1;
        this.m = true;
        TypedArray r9 = r5.getTheme().obtainStyledAttributes(r6, new int[]{2130972225, 2130972226, 2130972227}, 0, 0);
        float r10 = r9.getDimension(1, r8);     // Catch: Throwable -> L6
        this.j = r10;     // Catch: Throwable -> L6
        this.k = r9.getBoolean(2, true);     // Catch: Throwable -> L6
        this.l = r9.getDimension(0, r1);     // Catch: Throwable -> L6
        r9.recycle();
        LarusViewMusicPlayerProgressBinding r11 = getBinding();
        V5(false, false);
        SeekBar r12 = r11.f;
        ViewGroup.LayoutParams r0 = r12.getLayoutParams();
        r0.height = (int) r10;
        r12.setLayoutParams(r0);
        r11.f.setThumb(null);
        r11.f.setBackground(null);
        r11.f.setOnSeekBarChangeListener(new k(this));
        return;
    L6:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    public final void Y5(Function0<Integer> r2, a r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "duration");
        Intrinsics.checkNotNullParameter(r3, "progressChangedListener");
        this.b = r2;
        this.c = r4;
        this.e = r3;
    }

    public /* synthetic */ PlayerProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void S5(final PlayerProgressView r9, final float r10, boolean r11, boolean r12) {
        float r1 = r9.getBinding().f.getLayoutParams().height;
        ValueAnimator r0 = r9.i;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isRunning() != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        ValueAnimator r3 = r9.i;
        if (r3 == null) goto L12;
        r3.cancel();
    L12:
        ValueAnimator r13 = tk9.b.b(r1, r10, 120, null, new i(r9), new j(r9, r10), 8);
        r9.i = r13;
        r13.start();
        SeekBar r14 = r9.getBinding().f;
        if (r11 == false) goto L19;
        Resources r15 = r9.getResources();
        if (r9.k == false) goto L17;
        int r16 = 2131243284;
    L18:
        Drawable r17 = ResourcesCompat.getDrawable(r15, r16, null);
    L30:
        r14.setProgressDrawable(r17);
        return;
    L17:
        r16 = 2131243285;
        goto L18
    L19:
        if (r12 == false) goto L25;
        Resources r18 = r9.getResources();
        if (r9.k == false) goto L23;
        int r20 = 2131243286;
    L24:
        r17 = ResourcesCompat.getDrawable(r18, r20, null);
        goto L30
    L23:
        r20 = 2131243287;
        goto L24
    L25:
        Resources r110 = r9.getResources();
        if (r9.k == false) goto L28;
        int r21 = 2131243283;
    L29:
        r17 = ResourcesCompat.getDrawable(r110, r21, null);
        goto L30
    L28:
        r21 = 2131243288;
    L7:
        r2 = false;
        goto L8
    }
}
