package com.obric.oui.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.entity.EventBody;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 ]2\u00020\u0001:\u0001^B'\b\u0007\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X\u0012\b\b\u0002\u0010Z\u001a\u00020\u0007¢\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004J\u0016\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020&J\u001e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020&2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020&J\u0010\u00104\u001a\u00020\u00022\u0006\u00102\u001a\u00020&H\u0016J\u0006\u00106\u001a\u000205J\u0010\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020&H\u0016J\u000e\u00109\u001a\u00020\u00022\u0006\u00102\u001a\u00020&J\u0010\u0010<\u001a\u00020&2\u0006\u0010;\u001a\u00020:H\u0016R\u0016\u0010=\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010BR$\u0010C\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010>R\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010M\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010JR\u0016\u0010N\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010AR\u0016\u0010O\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010>R\u0016\u00103\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010>R\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR$\u0010S\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010D\u001a\u0004\bT\u0010F\"\u0004\bU\u0010HR\u0016\u0010.\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010>¨\u0006_"}, d2 = {"Lcom/obric/oui/slider/OSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "vibrate", "", "toRealValue", "toFakeValue", "", "decimals", "round", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "thumbColorResId", "setThumbColor", "processColorResId", "backgroundColorResId", "setProcessColor", "backgroundColor", "setProcessBackgroundColor", "progressColor", "setProcessProgressColor", "showLeftIcon", "hideLeftIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "setLeftIcon", "showRightIcon", "hideRightIcon", "setRightIcon", EventBody.KEY_VALUE, "setMinValue", "setMaxValue", "getMinValue", "getMaxValue", "setTickMarkCount", "process", "setProgress", "", "animate", "getProgress", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "listener", "setOnSeekBarChangeListenerExt", "seekBarHeight", "setSeekBarHeight", "isStyleSegmented", "setIsSegmented", "tickMarkCount", "initTickPosition", "enabled", "enableVibrate", "setEnabled", "Landroid/widget/SeekBar;", "getSeekBar", "hapticFeedbackEnabled", "setHapticFeedbackEnabled", "enableEdgeTouchOptimize", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "isTracking", "Z", "Landroid/widget/ImageView;", "tvRightIcon", "Landroid/widget/ImageView;", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "rightImage", "Landroid/graphics/drawable/Drawable;", "getRightImage", "()Landroid/graphics/drawable/Drawable;", "setRightImage", "(Landroid/graphics/drawable/Drawable;)V", "minValue", "F", "optimizeEdgeTouchExperience", "maxValue", "seekbarHeight", "tvLeftIcon", "isSeeking", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "seekBar", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "leftImage", "getLeftImage", "setLeftImage", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"ClickableViewAccessibility"})
public class OSlider extends ConstraintLayout {
    private static final float BASE_MAX = 100.0f;
    private static final float BASE_MIN = 0.0f;
    public static final b Companion = null;
    private static final String TAG = "OSlider";
    private boolean enableVibrate;
    private boolean isSeeking;
    private boolean isStyleSegmented;
    private boolean isTracking;
    private Drawable leftImage;
    private TickMarkSeekBar.b listener;
    private float maxValue;
    private float minValue;
    private boolean optimizeEdgeTouchExperience;
    private Drawable rightImage;
    private final SeekBarFloatCompat seekBar;
    private float seekbarHeight;
    private final ImageView tvLeftIcon;
    private final ImageView tvRightIcon;

    public static final class a implements TickMarkSeekBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSlider f7434a;

        a(OSlider r10) {
            this.f7434a = r10;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public void a(SeekBar r10, float r11, boolean r12) {
            TickMarkSeekBar.b r13 = OSlider.access$getListener$p(this.f7434a);
            if (r13 == null) goto L6;
            r13.a(r10, OSlider.access$toRealValue(this.f7434a, r11), r12);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public void b(int r10) {
            TickMarkSeekBar.b r11 = OSlider.access$getListener$p(this.f7434a);
            if (r11 == null) goto L6;
            r11.b(r10);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public void onStartTrackingTouch(SeekBar r10) {
            OSlider.access$setTracking$p(this.f7434a, true);
            TickMarkSeekBar.b r11 = OSlider.access$getListener$p(this.f7434a);
            if (r11 == null) goto L6;
            r11.onStartTrackingTouch(r10);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public void onStopTrackingTouch(SeekBar r10) {
            OSlider.access$setTracking$p(this.f7434a, false);
            TickMarkSeekBar.b r11 = OSlider.access$getListener$p(this.f7434a);
            if (r11 == null) goto L6;
            r11.onStopTrackingTouch(r10);
            return;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new b(null);
    }

    @JvmOverloads
    public OSlider(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSlider(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSlider(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.maxValue = BASE_MAX;
        this.enableVibrate = true;
        float r13 = 6;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.seekbarHeight = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r14.getDisplayMetrics()));
        TypedArray r15 = r10.getTheme().obtainStyledAttributes(r11, l.OSlider, r12, 0);
        int r16 = l.OSlider_sliderHeight;
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        this.seekbarHeight = r15.getDimensionPixelSize(r16, MathKt.roundToInt(TypedValue.applyDimension(1, r13, r17.getDisplayMetrics())));
        this.leftImage = r15.getDrawable(l.OSlider_oui_slider_left_icon);
        this.rightImage = r15.getDrawable(l.OSlider_oui_slider_right_icon);
        LayoutInflater.from(r10).inflate(h.o_slider, this);
        View r18 = findViewById(f.seekBar);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.seekBar)");
        SeekBarFloatCompat r19 = (SeekBarFloatCompat) r18;
        this.seekBar = r19;
        r19.setBackgroundHeight(this.seekbarHeight);
        View r20 = findViewById(f.tvLeftIcon);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.tvLeftIcon)");
        ImageView r21 = (ImageView) r20;
        this.tvLeftIcon = r21;
        if (this.leftImage == null) goto L5;
        r21.setVisibility(0);
        r21.setImageDrawable(this.leftImage);
    L5:
        View r22 = findViewById(f.tvRightIcon);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.tvRightIcon)");
        ImageView r23 = (ImageView) r22;
        this.tvRightIcon = r23;
        Drawable r24 = this.rightImage;
        if (r24 == null) goto L8;
        r23.setImageDrawable(r24);
        r23.setVisibility(0);
    L8:
        r19.setOnSeekBarChangeListenerExt(new a(this));
        r19.setHapticFeedbackEnabled(isHapticFeedbackEnabled());
    }

    public /* synthetic */ OSlider(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ TickMarkSeekBar.b access$getListener$p(OSlider r10) {
        return r10.listener;
    }

    public static final /* synthetic */ boolean access$isTracking$p(OSlider r10) {
        return r10.isTracking;
    }

    public static final /* synthetic */ void access$setListener$p(OSlider r10, TickMarkSeekBar.b r11) {
        r10.listener = r11;
    }

    public static final /* synthetic */ void access$setTracking$p(OSlider r10, boolean r11) {
        r10.isTracking = r11;
    }

    public static final /* synthetic */ float access$toRealValue(OSlider r10, float r11) {
        return r10.toRealValue(r11);
    }

    private final float round(float r10, int r11) {
        String r12 = String.format("%." + r11 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r10)}, 1));
        Intrinsics.checkNotNullExpressionValue(r12, "format(this, *args)");
        return Float.parseFloat(r12);
    }

    static /* synthetic */ float round$default(OSlider r10, float r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L7;
        r12 = 2;
    L7:
        return r10.round(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final float toFakeValue(float r10) {
        float r11 = this.minValue;
        return (((r10 - r11) / (this.maxValue - r11)) * BASE_MAX) + 0.0f;
    }

    private final float toRealValue(float r10) {
        float r11 = this.minValue;
        return round$default(this, r11 + (((r10 - 0.0f) / BASE_MAX) * (this.maxValue - r11)), 0, 1, null);
    }

    private final void vibrate() {
        Object r10 = getContext().getSystemService("vibrator");     // Catch: Exception -> L8
        if (r10 == null) goto L6;
        ((Vibrator) r10).vibrate(10);     // Catch: Exception -> L8
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");     // Catch: Exception -> L8
    }

    public final void enableEdgeTouchOptimize(boolean r10) {
        this.optimizeEdgeTouchExperience = r10;
    }

    public final void enableVibrate(boolean r10) {
        this.enableVibrate = r10;
    }

    public final Drawable getLeftImage() {
        return this.leftImage;
    }

    public final float getMaxValue() {
        return toRealValue(this.seekBar.getMaxValue());
    }

    public final float getMinValue() {
        return toRealValue(this.seekBar.getMinValue());
    }

    public final float getProgress() {
        return this.seekBar.getFloatProgress();
    }

    public final Drawable getRightImage() {
        return this.rightImage;
    }

    public final SeekBar getSeekBar() {
        return this.seekBar;
    }

    public final void hideLeftIcon() {
        this.tvLeftIcon.setVisibility(8);
    }

    public final void hideRightIcon() {
        this.tvRightIcon.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(MathKt.roundToInt(TypedValue.applyDimension(1, 32, r12.getDisplayMetrics())), 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        if (this.optimizeEdgeTouchExperience == false) goto L5;
        Rect r11 = new Rect();
        this.seekBar.getHitRect(r11);
        int r12 = r10.getActionMasked();
        if (r12 == 0) goto L27;
        if (r12 == 1) goto L23;
        if (r12 == 2) goto L15;
        if (r12 == 3) goto L23;
    L30:
        ea.b.a(TAG, "onTouchEvent, " + r10.getAction() + ", super.onTouchEvent, isSeeking: " + this.isSeeking);
        return super.onTouchEvent(r10);
    L15:
        if (this.isSeeking == false) goto L19;
        MotionEvent r13 = MotionEvent.obtain(r10);
        r13.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r13);
        r13.recycle();
        return true;
    L19:
        if (r11.contains((int) r10.getX(), (int) r10.getY()) == false) goto L30;
        this.isSeeking = true;
        MotionEvent r14 = MotionEvent.obtain(r10);
        Intrinsics.checkNotNullExpressionValue(r14, "downEvent");
        r14.setAction(0);
        r14.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r14);
        r14.recycle();
        MotionEvent r15 = MotionEvent.obtain(r10);
        r15.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r15);
        r15.recycle();
        ea.b.a(TAG, "onTouchEvent, ACTION_MOVE, case 3, isSeeking: " + this.isSeeking);
        return true;
    L23:
        if (this.isSeeking == false) goto L30;
        MotionEvent r16 = MotionEvent.obtain(r10);
        r16.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r16);
        r16.recycle();
        this.isSeeking = false;
        requestDisallowInterceptTouchEvent(false);
        ea.b.a(TAG, "onTouchEvent, " + r10.getAction() + ", case 4, isSeeking: " + this.isSeeking);
        return true;
    L27:
        if (r11.contains((int) r10.getX(), (int) r10.getY()) == true) goto L30;
        this.isSeeking = false;
        requestDisallowInterceptTouchEvent(true);
        ea.b.a(TAG, "onTouchEvent, ACTION_DOWN, case 1, isSeeking: " + this.isSeeking);
        return true;
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.seekBar.setEnabled(r10);
        this.tvLeftIcon.setEnabled(r10);
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        setAlpha(r11);
        return;
    L5:
        r11 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r10) {
        super.setHapticFeedbackEnabled(r10);
        this.seekBar.setHapticFeedbackEnabled(r10);
    }

    public final void setIsSegmented(boolean r10) {
        setIsSegmented(r10, 0, 0);
    }

    public final void setIsSegmented(boolean r10, int r11, int r12) {
        this.isStyleSegmented = r10;
        this.seekBar.setIsSegmented(r10, r11, r12);
    }

    public final void setLeftIcon(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        this.tvLeftIcon.setImageDrawable(r10);
    }

    public final void setLeftImage(Drawable r10) {
        this.leftImage = r10;
    }

    public final void setMaxValue(float r10) {
        Log.d(TAG, "setMaxValue >>> " + r10);
        this.maxValue = r10;
        this.seekBar.setMinValue(0.0f);
        this.seekBar.setMaxValue(BASE_MAX);
    }

    public final void setMinValue(float r10) {
        Log.d(TAG, "setMinValue >>> " + r10);
        this.minValue = r10;
        this.seekBar.setMinValue(0.0f);
        this.seekBar.setMaxValue(BASE_MAX);
    }

    public final void setOnSeekBarChangeListenerExt(TickMarkSeekBar.b r10) {
        this.listener = r10;
    }

    public final void setProcessBackgroundColor(int r10) {
        this.seekBar.setProcessBackgroundColor(r10);
    }

    public final void setProcessColor(int r10, int r11) {
        this.seekBar.setProcessColor(r10, r11);
    }

    public final void setProcessProgressColor(int r10) {
        this.seekBar.setProcessProgressColor(r10);
    }

    public final void setProgress(float r10) {
        this.seekBar.setProgress(toFakeValue(r10));
    }

    public final void setProgress(float r10, boolean r11) {
        this.seekBar.setProgress(toFakeValue(r10), r11);
    }

    public final void setRightIcon(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        this.tvRightIcon.setImageDrawable(r10);
    }

    public final void setRightImage(Drawable r10) {
        this.rightImage = r10;
    }

    public final void setSeekBarHeight(float r10) {
        this.seekBar.setBackgroundHeight(r10);
    }

    public final void setThumbColor(int r10) {
        this.seekBar.setThumbColor(r10);
    }

    public final void setTickMarkCount(int r10) {
        this.seekBar.setDefaultTickMarkCount(r10);
    }

    public final void showLeftIcon() {
        this.tvLeftIcon.setVisibility(0);
    }

    public final void showRightIcon() {
        this.tvRightIcon.setVisibility(0);
    }
}
