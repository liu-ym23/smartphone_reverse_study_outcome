package com.larus.doc.impl.video.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.larus.doc.biz.impl.databinding.LarusViewVideoPlayerProgressBinding;
import com.larus.utils.logger.FLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0003=>?B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001eH\u0017J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u001a\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u0017H\u0002J\u0018\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\u0018\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0017H\u0002J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\"J\u0006\u00105\u001a\u00020\"J&\u00106\u001a\u00020\"2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u00107\u001a\u00020\u00152\b\b\u0003\u0010\u0012\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\"2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0017J\u0016\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J\f\u0010;\u001a\u00020<*\u00020\u0007H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/doc/impl/video/widget/PlayerProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusViewVideoPlayerProgressBinding;", "getBinding", "()Lcom/larus/doc/biz/impl/databinding/LarusViewVideoPlayerProgressBinding;", "binding$delegate", "Lkotlin/Lazy;", "duration", "Lkotlin/Function0;", "displayMode", "max", "onProgressChangeListener", "Lcom/larus/doc/impl/video/widget/PlayerProgressView$IProgressChangedListener;", "inTouching", "", "downPoint", "Lcom/larus/doc/impl/video/widget/PlayerProgressView$TouchPoint;", "animator", "Landroid/animation/ValueAnimator;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "handleClick", "", "handleActionUpOrCancel", "handleActionMove", "handleActionDown", "changeSeekBarStyle", "enlarge", "loading", "startValueAnimator", "fromValue", "", "toValue", "initSeekBar", "refreshProgressBar", "percent", "smooth", "updateMaxProgress", "total", "asyncUpdateDuration", "startLoading", "stopLoading", "init", "progressChangedListener", "updateProgress", "updateTimeLine", "currentTime", "subToDisplay", "", "Companion", "IProgressChangedListener", "TouchPoint", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerProgressView extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final Lazy a;
    public int b;
    public int c;
    public a d;
    public boolean e;
    public b f;
    public ValueAnimator g;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/doc/impl/video/widget/PlayerProgressView$Companion$DisplayMode;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    private final LarusViewVideoPlayerProgressBinding getBinding() {
        return (LarusViewVideoPlayerProgressBinding) this.a.getValue();
    }

    public final String V5(int r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        if (r0.length() >= 2) goto L6;
        r0.insert(0, "0");
    L6:
        return r0.toString();
    }

    public final void Y5(int r2) {
        getBinding().e.setMax(2000);
        this.c = 2000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        int r0 = r12.getAction();
        if (r0 != 0) goto L5;
        this.f = new b(r12.getX(), r12.getY());
        U5(true, false);
    L50:
        return true;
    L5:
        if (r0 == 1) goto L33;
        if (r0 != 2) goto L8;
        this.e = true;
        float r1 = r12.getX() - this.f.a;
        if (Math.abs(r1) <= Math.abs(r12.getY() - this.f.b)) goto L28;
        requestDisallowInterceptTouchEvent(true);
        if (r1 <= 0.0f) goto L15;
        float r2 = Math.abs(r1);
    L16:
        float r6 = (getBinding().e.getMax() / getBinding().e.getWidth()) * r2;
        float r4 = RangesKt.coerceIn(getBinding().e.getProgress() + r6, 0.0f, getBinding().e.getMax());
        getBinding().e.setProgress((int) r4);
        FLogger.a.d("PlayerProgressView", "[handleActionMove] offsetX=" + r2 + ", progressOffset=" + r6 + ", newProgress=" + r4 + "   " + getBinding().e.getProgress());
        a r3 = this.d;
        if (r3 == null) goto L19;
        r3.onProgressChanged(((double) getBinding().e.getProgress()) / ((double) getBinding().e.getMax()));
    L19:
        a r5 = this.d;
        if (r5 == null) goto L23;
        r5.a(((double) getBinding().e.getProgress()) / ((double) getBinding().e.getMax()));
    L23:
        if (this.b == 2) goto L25;
    L31:
        this.f = new b(r12.getX(), r12.getY());
        goto L50
    L25:
        if (getBinding().f.getVisibility() == 0) goto L31;
        getBinding().f.setVisibility(0);
        goto L31
    L15:
        r2 = -Math.abs(r1);
        goto L16
    L28:
        if (this.e == false) goto L30;
        this.f = new b(r12.getX(), r12.getY());
        goto L50
    L30:
        requestDisallowInterceptTouchEvent(false);
        goto L31
    L8:
        if (r0 != 3) goto L50;
    L33:
        if (this.e == true) goto L41;
        int r7 = getBinding().e.getProgressDrawable().getBounds().left + getPaddingStart();
        float r13 = RangesKt.coerceAtLeast(r12.getX() - r7, 0.0f);
        int r8 = getBinding().e.getProgressDrawable().getBounds().width();
        float r9 = r13 / r8;
        int r10 = (int) (getBinding().e.getMax() * r9);
        getBinding().e.setProgress(r10);
        FLogger.a.i("PlayerProgressView", "[handleClick] clickX=" + r13 + ", barLeftX=" + r7 + ", length=" + r8 + ", progressPercent=" + r9 + ", progress=" + r10);
        a r14 = this.d;
        if (r14 == null) goto L37;
        r14.onProgressChanged(((double) getBinding().e.getProgress()) / ((double) getBinding().e.getMax()));
    L37:
        a r15 = this.d;
        if (r15 == null) goto L41;
        r15.a(((double) getBinding().e.getProgress()) / ((double) getBinding().e.getMax()));
    L41:
        if (this.b == 2) goto L43;
    L45:
        U5(false, false);
        a r16 = this.d;
        if (r16 == null) goto L48;
        r16.b();
    L48:
        this.e = false;
        goto L50
    L43:
        if (getBinding().f.getVisibility() != 0) goto L45;
        getBinding().f.setVisibility(4);
        goto L45
    }

    public static Unit R5(PlayerProgressView r1, float r2) {
        ViewGroup.LayoutParams r0 = r1.getBinding().e.getLayoutParams();
        r0.height = (int) r2;
        r1.getBinding().e.setLayoutParams(r0);
        return Unit.INSTANCE;
    }

    public static Unit S5(PlayerProgressView r1, float r2) {
        ViewGroup.LayoutParams r0 = r1.getBinding().e.getLayoutParams();
        r0.height = (int) r2;
        r1.getBinding().e.setLayoutParams(r0);
        return Unit.INSTANCE;
    }

    public final void J1(float r2, boolean r3) {
        if (this.e == true) goto L7;
        int r4 = (int) ((this.c * r2) / 100);
        int r5 = Build.VERSION.SDK_INT;
        getBinding().e.setProgress(r4);
        return;
    }

    public final void U5(final boolean r4, final boolean r5) {
        if (r4 == false) goto L4;
        int r0 = 12;
    L5:
        final int r1 = c7.b(Integer.valueOf(r0));
        getBinding().e.post(new f(this, r1, r4, r5));
        return;
    L4:
        r0 = 4;
        goto L5
    }

    public final void Z5(int r7, int r8) {
        int r9 = (int) Math.rint(((double) 0) / 1000.0d);
        int r0 = r9 % 60;
        int r10 = (int) Math.rint(((double) r7) / 1000.0d);
        int r1 = r10 % 60;
        getBinding().b.setText(V5(r10 / 60));
        getBinding().c.setText(V5(r1));
        getBinding().g.setText(V5(r9 / 60));
        getBinding().h.setText(V5(r0));
    }

    public PlayerProgressView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new g(r2, this));
        this.c = 100;
        this.f = new b(0.0f, 0.0f);
        LarusViewVideoPlayerProgressBinding r5 = getBinding();
        U5(false, false);
        r5.e.setThumb(null);
        r5.e.setBackground(null);
        r5.e.setOnSeekBarChangeListener(new j(this));
    }

    public /* synthetic */ PlayerProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void T5(final PlayerProgressView r9, int r10, boolean r11, boolean r12) {
        float r1 = r9.getBinding().e.getLayoutParams().height;
        final float r2 = r10;
        ValueAnimator r13 = r9.g;
        if (r13 == null) goto L7;
        boolean r0 = true;
        if (r13.isRunning() != true) goto L7;
    L8:
        if (r0 == false) goto L12;
        ValueAnimator r14 = r9.g;
        if (r14 == null) goto L12;
        r14.cancel();
    L12:
        ValueAnimator r15 = tk9.b.b(r1, r2, 120, null, new h(r9), new i(r9, r2), 8);
        r9.g = r15;
        r15.start();
        SeekBar r16 = r9.getBinding().e;
        if (r11 == false) goto L15;
        Drawable r17 = ResourcesCompat.getDrawable(r9.getResources(), 2131243284, null);
    L18:
        r16.setProgressDrawable(r17);
        return;
    L15:
        if (r12 == false) goto L17;
        r17 = ResourcesCompat.getDrawable(r9.getResources(), 2131243286, null);
        goto L18
    L17:
        r17 = ResourcesCompat.getDrawable(r9.getResources(), 2131243283, null);
    L7:
        r0 = false;
        goto L8
    }
}
