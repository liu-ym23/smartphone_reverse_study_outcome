package com.obric.oui.slider;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.app.NotificationCompat;
import da.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import o9.p;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 R2\u00020\u0001:\u0002STB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u000e¢\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\f\u0010\u000f\u001a\u00020\u0002*\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0014J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0002J\u0016\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u000eJ\"\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000eJ\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010-R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010=R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00109R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00109R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00109R\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010?R\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010?R\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00109R\u0016\u0010I\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u00107R\u0016\u0010J\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010=R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010?¨\u0006U"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "currentThumbCenterX", "currentThumbSize", "currentThumbRadius", "Landroid/graphics/Canvas;", "canvas", "", "drawBackground", "drawProgress", "drawTickMark", "drawThumb", "anchorPoint", "", "toRealValue", "decimals", "round", "onDraw", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "tickMarkCount", "setDefaultTickMarkCount", "backgroundHeight", "setBackgroundHeight", "processColorResId", "backgroundColorResId", "setProcessColor", "backgroundColor", "setProcessBackgroundColor", "progressColor", "setProcessProgressColor", "thumbColorResId", "setThumbColor", "isStyleSegmented", "initTickPosition", "setIsSegmented", "Landroid/graphics/drawable/Drawable;", "dr", "invalidateDrawable", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "l", "setOnSeekBarChangeListenerExt", "onSeekBarChangeListenerExt", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/Path;", "mCurrentTickIndex", "I", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/RectF;", "Z", "thumbSize", "F", "tickRadius", "thumbColor", "tickColor", "Lcom/obric/oui/slider/a;", "seekBarVibrateHelper", "Lcom/obric/oui/slider/a;", "centerY", "thumbSizePress", "mBackgroundColor", "path", "isPress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class TickMarkSeekBar extends AppCompatSeekBar {
    public static final a Companion = null;
    private static final String TAG = "TickSeekBar";
    private float backgroundHeight;
    private final float centerY;
    private final Path clipPath;
    private boolean isPress;
    private boolean isStyleSegmented;
    private int mBackgroundColor;
    private int mCurrentTickIndex;
    private b onSeekBarChangeListenerExt;
    private final Paint paint;
    private final Path path;
    private int progressColor;
    private final RectF rectF;
    private final com.obric.oui.slider.a seekBarVibrateHelper;
    private int thumbColor;
    private p thumbShadow;
    private final float thumbSize;
    private final float thumbSizePress;
    private int tickColor;
    private int tickMarkCount;
    private final float tickRadius;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        void a(SeekBar r10, float r11, boolean r12);

        void b(int r10);

        void onStartTrackingTouch(SeekBar r10);

        void onStopTrackingTouch(SeekBar r10);
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TickMarkSeekBar f7436c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7437g;

        c(TickMarkSeekBar r10, int r11) {
            this.f7436c = r10;
            this.f7437g = r11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            TickMarkSeekBar.access$setMCurrentTickIndex$p(this.f7436c, this.f7437g);
            b r11 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f7436c);
            if (r11 == null) goto L5;
            r11.b(this.f7437g);
        L5:
            this.f7436c.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }
    }

    public static final class d implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TickMarkSeekBar f7438a;

        d(TickMarkSeekBar r10) {
            this.f7438a = r10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "seekBar");
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L7:
            b r13 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f7438a);
            if (r13 == null) goto L11;
            r13.a(r10, TickMarkSeekBar.access$toRealValue(this.f7438a, r11), r12);
            return;
        L11:
            return;
        L5:
            if (this.f7438a.isHapticFeedbackEnabled() == false) goto L7;
            com.obric.oui.slider.a r14 = TickMarkSeekBar.access$getSeekBarVibrateHelper$p(this.f7438a);
            Context r15 = this.f7438a.getContext();
            Intrinsics.checkNotNullExpressionValue(r15, "context");
            r14.a(r15, r10, r11, r12, TickMarkSeekBar.access$getTickMarkCount$p(this.f7438a), TickMarkSeekBar.access$isStyleSegmented$p(this.f7438a));
            goto L7
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r10) {
            TickMarkSeekBar.access$setMCurrentTickIndex$p(this.f7438a, -1);
            b r11 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f7438a);
            if (r11 == null) goto L6;
            r11.onStartTrackingTouch(r10);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r10) {
            TickMarkSeekBar.access$anchorPoint(this.f7438a);
            b r11 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f7438a);
            if (r11 == null) goto L6;
            r11.onStopTrackingTouch(this.f7438a);
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public TickMarkSeekBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public TickMarkSeekBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public TickMarkSeekBar(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        this.tickMarkCount = -1;
        float r10 = 6;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        this.backgroundHeight = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()));
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        this.centerY = MathKt.roundToInt(TypedValue.applyDimension(1, 16, r12.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.thumbSize = MathKt.roundToInt(TypedValue.applyDimension(1, 18, r13.getDisplayMetrics()));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.thumbSizePress = MathKt.roundToInt(TypedValue.applyDimension(1, 22, r14.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        this.tickRadius = MathKt.roundToInt(TypedValue.applyDimension(1, 2, r15.getDisplayMetrics()));
        Paint r16 = new Paint();
        this.paint = r16;
        this.clipPath = new Path();
        this.rectF = new RectF();
        this.path = new Path();
        this.mCurrentTickIndex = -1;
        this.seekBarVibrateHelper = new com.obric.oui.slider.a();
        this.thumbShadow = new p(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
        TypedArray r17 = r18.getTheme().obtainStyledAttributes(r19, l.TickMarkSeekBar, r20, 0);
        int r21 = l.TickMarkSeekBar_seekbarHeight;
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        this.backgroundHeight = r17.getDimensionPixelSize(r21, MathKt.roundToInt(TypedValue.applyDimension(1, r10, r22.getDisplayMetrics())));
        this.mBackgroundColor = r17.getColor(l.TickMarkSeekBar_seekbarBackgroundColor, r17.getResources().getColor(u8.c.oui_basic_line_2));
        this.progressColor = r17.getColor(l.TickMarkSeekBar_seekbarProgressColor, r17.getResources().getColor(u8.c.oui_functional_blue_6));
        this.thumbColor = r17.getColor(l.TickMarkSeekBar_seekbarThumbColor, r17.getResources().getColor(u8.c.oui_on_accent_default));
        setOnSeekBarChangeListenerExt(null);
        this.tickColor = getResources().getColor(u8.c.oui_basic_line_3);
        r16.setStyle(Paint.Style.FILL);
        f.f8522a.b(r18, k.OUIShadow_1_2, this.thumbShadow);
    }

    public /* synthetic */ TickMarkSeekBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ void access$anchorPoint(TickMarkSeekBar r10) {
        r10.anchorPoint();
    }

    public static final /* synthetic */ int access$getMCurrentTickIndex$p(TickMarkSeekBar r10) {
        return r10.mCurrentTickIndex;
    }

    public static final /* synthetic */ b access$getOnSeekBarChangeListenerExt$p(TickMarkSeekBar r10) {
        return r10.onSeekBarChangeListenerExt;
    }

    public static final /* synthetic */ com.obric.oui.slider.a access$getSeekBarVibrateHelper$p(TickMarkSeekBar r10) {
        return r10.seekBarVibrateHelper;
    }

    public static final /* synthetic */ int access$getTickMarkCount$p(TickMarkSeekBar r10) {
        return r10.tickMarkCount;
    }

    public static final /* synthetic */ boolean access$isStyleSegmented$p(TickMarkSeekBar r10) {
        return r10.isStyleSegmented;
    }

    public static final /* synthetic */ void access$setMCurrentTickIndex$p(TickMarkSeekBar r10, int r11) {
        r10.mCurrentTickIndex = r11;
    }

    public static final /* synthetic */ void access$setOnSeekBarChangeListenerExt$p(TickMarkSeekBar r10, b r11) {
        r10.onSeekBarChangeListenerExt = r11;
    }

    public static final /* synthetic */ void access$setStyleSegmented$p(TickMarkSeekBar r10, boolean r11) {
        r10.isStyleSegmented = r11;
    }

    public static final /* synthetic */ void access$setTickMarkCount$p(TickMarkSeekBar r10, int r11) {
        r10.tickMarkCount = r11;
    }

    public static final /* synthetic */ float access$toRealValue(TickMarkSeekBar r10, int r11) {
        return r10.toRealValue(r11);
    }

    private final void anchorPoint() {
        if (this.isStyleSegmented == false) goto L30;
        IntRange r10 = RangesKt.until(0, this.tickMarkCount);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<Integer> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.add(Integer.valueOf(((IntIterator) r12).nextInt() * (getMax() / (this.tickMarkCount - 1))));
        goto L6
    L8:
        Iterator<Integer> r13 = CollectionsKt.getIndices(r11).iterator();
        if (r13.hasNext() == true) goto L11;
        Integer r14 = null;
    L21:
        Integer r15 = r14;
        if (r15 == null) goto L24;
        int r16 = r15.intValue();
    L25:
        ObjectAnimator r17 = ObjectAnimator.ofInt(this, "progress", new int[]{((Number) r11.get(r16)).intValue()});
        r17.setDuration(100);
        r17.start();
        r17.addListener(new c(this, r16));
        return;
    L24:
        r16 = 0;
        goto L25
    L11:
        Integer r18 = r13.next();
        if (r13.hasNext() == true) goto L14;
    L13:
        r14 = r18;
        goto L21
    L14:
        int r19 = Math.abs(((Number) r11.get(r18.intValue())).intValue() - getProgress());
    L15:
        Integer r20 = r13.next();
        int r21 = Math.abs(((Number) r11.get(r20.intValue())).intValue() - getProgress());
        if (r19 <= r21) goto L19;
        r18 = r20;
        r19 = r21;
    L19:
        if (r13.hasNext() == true) goto L15;
    }

    private final float currentThumbCenterX() {
        float r10 = getWidth();
        float r11 = this.thumbSize;
        return (r11 / 2.0f) + (((getProgress() * 1.0f) / getMax()) * (r10 - r11));
    }

    private final float currentThumbRadius() {
        return currentThumbSize() / 2.0f;
    }

    private final float currentThumbSize() {
        if (this.isPress == false) goto L6;
        return this.thumbSizePress;
    L6:
        return this.thumbSize;
    }

    private final void drawBackground(Canvas r10) {
        r10.save();
        float r11 = this.backgroundHeight / 2;
        currentThumbCenterX();
        currentThumbRadius();
        this.rectF.set(0.0f, this.centerY - r11, getWidth(), this.centerY + r11);
        this.clipPath.reset();
        this.clipPath.addRoundRect(this.rectF, r11, r11, Path.Direction.CW);
        this.paint.setColor(this.mBackgroundColor);
        r10.drawPath(this.clipPath, this.paint);
        r10.restore();
        if (this.isStyleSegmented == false) goto L6;
        drawTickMark(r10);
        return;
    }

    private final void drawProgress(Canvas r10) {
        r10.save();
        float r11 = this.backgroundHeight / 2;
        float r12 = currentThumbCenterX();
        float r13 = currentThumbRadius();
        RectF r14 = this.rectF;
        float r15 = this.centerY;
        r14.set(0.0f, r15 - r11, r12, r15 + r11);
        this.path.reset();
        this.path.addRoundRect(this.rectF, new float[]{r11, r11, 0.0f, 0.0f, 0.0f, 0.0f, r11, r11}, Path.Direction.CW);
        this.paint.setColor(this.progressColor);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.clipPath.reset();
        this.clipPath.addCircle(r12, this.centerY, r13, Path.Direction.CW);
        r10.clipOutPath(this.clipPath);
    L5:
        r10.drawPath(this.path, this.paint);
        r10.restore();
    }

    private final void drawThumb(Canvas r10) {
        r10.save();
        float r11 = currentThumbSize();
        float r12 = currentThumbCenterX();
        this.paint.setColor(this.thumbColor);
        float r13 = r11 / 2.0f;
        float r14 = this.centerY;
        this.rectF.set(r12 - r13, r14 - r13, r12 + r13, r14 + r13);
        r10.drawRoundRect(this.rectF, r13, r13, this.paint);
        r10.restore();
        r10.save();
        f.f8522a.c(r10, this.thumbShadow, this.rectF, r13);
        r10.restore();
    }

    private final void drawTickMark(Canvas r10) {
        if (this.tickMarkCount > 0) goto L5;
        return;
    L5:
        if (this.isStyleSegmented == false) goto L11;
        float r11 = getWidth() - this.thumbSize;
        int r12 = this.tickMarkCount;
        float r13 = r11 / (r12 - 1);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L12;
        float r15 = this.thumbSize;
        float r16 = (this.centerY + (r15 / 2.0f)) - this.tickRadius;
        this.paint.setColor(this.tickColor);
        r10.drawCircle((r15 / 2.0f) + (r14 * r13), r16, this.tickRadius, this.paint);
        r14 = r14 + 1;
        goto L7
    L12:
        return;
    }

    private final float round(float r10, int r11) {
        String r12 = String.format(Locale.CHINA, "%." + r11 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r10)}, 1));
        Intrinsics.checkNotNullExpressionValue(r12, "format(locale, this, *args)");
        return Float.parseFloat(r12);
    }

    static /* synthetic */ float round$default(TickMarkSeekBar r10, float r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L7;
        r12 = 2;
    L7:
        return r10.round(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    public static /* synthetic */ void setIsSegmented$default(TickMarkSeekBar r10, boolean r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        r10.setIsSegmented(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIsSegmented");
    }

    private final float toRealValue(int r10) {
        return round$default(this, r10 / 100, 0, 1, null);
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "dr");
        super.invalidateDrawable(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "canvas");     // Catch: Throwable -> L6
        drawBackground(r10);     // Catch: Throwable -> L6
        drawTickMark(r10);     // Catch: Throwable -> L6
        drawProgress(r10);     // Catch: Throwable -> L6
        drawThumb(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int r10, int r11) {
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(MathKt.roundToInt(TypedValue.applyDimension(1, 32, r12.getDisplayMetrics())), 1073741824));
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getAction());
    L5:
        if (r11 == null) goto L10;
        if (r11.intValue() != 0) goto L10;
    L16:
        boolean r12 = true;
    L17:
        this.isPress = r12;
        invalidate();
        return super.onTouchEvent(r10);
    L10:
        if (r11 != null) goto L13;
    L15:
        r12 = false;
        goto L17
    L13:
        if (r11.intValue() != 2) goto L15;
    L4:
        r11 = null;
        goto L5
    }

    public final void setBackgroundHeight(float r10) {
        this.backgroundHeight = r10;
        invalidate();
    }

    public void setDefaultTickMarkCount(int r10) {
        this.tickMarkCount = r10;
        this.mCurrentTickIndex = -1;
        invalidate();
    }

    public final void setIsSegmented(boolean r10, int r11, int r12) {
        this.isStyleSegmented = r10;
        if (r10 == false) goto L5;
        setProgressDrawable(null);
        this.mCurrentTickIndex = r12;
        this.tickMarkCount = r11;
        setProgress(r12 * (getMax() / (r11 - 1)));
    L6:
        anchorPoint();
        invalidate();
        return;
    L5:
        this.tickMarkCount = -1;
        this.mCurrentTickIndex = -1;
        goto L6
    }

    public final void setOnSeekBarChangeListenerExt(b r10) {
        this.onSeekBarChangeListenerExt = r10;
        super.setOnSeekBarChangeListener(new d(this));
    }

    public final void setProcessBackgroundColor(int r10) {
        this.mBackgroundColor = getResources().getColor(r10);
        invalidate();
    }

    public final void setProcessColor(int r10, int r11) {
        this.progressColor = getResources().getColor(r10);
        this.mBackgroundColor = getResources().getColor(r11);
        invalidate();
    }

    public final void setProcessProgressColor(int r10) {
        this.progressColor = getResources().getColor(r10);
        invalidate();
    }

    public final void setThumbColor(int r10) {
        this.thumbColor = getResources().getColor(r10);
    }
}
