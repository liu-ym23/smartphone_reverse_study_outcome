package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.a.b;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b1\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\nJ\u000e\u0010\t\u001a\u00020%2\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0017J\u0006\u0010)\u001a\u00020\u0017J\u0006\u0010*\u001a\u00020\u0017J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020%J\u0006\u0010.\u001a\u00020%J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0010\u00105\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020%H\u0002J\u0010\u00109\u001a\u00020%2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\nH\u0016J\u000e\u0010<\u001a\u00020%2\u0006\u0010\f\u001a\u00020\nJ\u001e\u0010<\u001a\u00020%2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u000fJ\u000e\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0017J\u000e\u0010C\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0017J\u0010\u0010D\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010E\u001a\u00020%2\b\b\u0001\u0010F\u001a\u00020\u0007J\u0010\u0010G\u001a\u00020%2\b\b\u0001\u0010H\u001a\u00020\u0007J\u001a\u0010I\u001a\u00020%2\b\b\u0001\u0010J\u001a\u00020\u00072\b\b\u0001\u0010F\u001a\u00020\u0007J\u001a\u0010K\u001a\u00020%2\b\b\u0001\u0010L\u001a\u00020\u00072\b\b\u0001\u0010H\u001a\u00020\u0007J\u0010\u0010M\u001a\u00020%2\b\b\u0001\u0010N\u001a\u00020\u0007J\u0010\u0010O\u001a\u00020%2\b\b\u0001\u0010P\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020\u0017J\u0016\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\nJ\u000e\u0010T\u001a\u00020%2\u0006\u0010@\u001a\u00020\u000fJ\u000e\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020\u0017J\u0010\u0010W\u001a\u00020%2\b\b\u0001\u0010X\u001a\u00020\u0007J\u0010\u0010Y\u001a\u00020%2\b\b\u0001\u0010Z\u001a\u00020\u0007J\u0010\u0010[\u001a\u00020%2\b\b\u0001\u0010\\\u001a\u00020\u0007J\u0010\u0010]\u001a\u00020%2\b\b\u0001\u0010^\u001a\u00020\u0007J\u000e\u0010_\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010`\u001a\u00020%J\u0006\u0010a\u001a\u00020%J\b\u0010b\u001a\u00020%H\u0002J\u0016\u0010c\u001a\u00020\u0017*\u00020\u00172\b\b\u0002\u0010d\u001a\u00020\u0007H\u0002J\f\u0010e\u001a\u00020\u0017*\u00020\u0017H\u0002J\f\u0010f\u001a\u00020\u0017*\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/obric/oui/slider/OSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableVibrate", "", "isSeeking", "isStyleSegmented", "isTracking", "leftImage", "Landroid/graphics/drawable/Drawable;", "getLeftImage", "()Landroid/graphics/drawable/Drawable;", "setLeftImage", "(Landroid/graphics/drawable/Drawable;)V", "listener", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "maxValue", "", "minValue", "optimizeEdgeTouchExperience", "rightImage", "getRightImage", "setRightImage", "seekBar", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "seekbarHeight", "sliderHeightPx", "tvLeftIcon", "Landroid/widget/ImageView;", "tvRightIcon", "enableEdgeTouchOptimize", "", "enabled", "getMaxValue", "getMinValue", "getProgress", "getRealProgress", "getSeekBar", "Landroid/widget/SeekBar;", "hideLeftIcon", "hideRightIcon", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "refreshDimensionCache", "setEnabled", "setHapticFeedbackEnabled", "hapticFeedbackEnabled", "setIsSegmented", "tickMarkCount", "initTickPosition", "setLeftIcon", "drawable", "setMaxValue", EventBody.KEY_VALUE, "setMinValue", "setOnSeekBarChangeListenerExt", "setProcessBackgroundColor", "backgroundColorResId", "setProcessBackgroundColorInt", "backgroundColor", "setProcessColor", "processColorResId", "setProcessColorInt", "processColor", "setProcessProgressColor", "progressColorResId", "setProcessProgressColorInt", "progressColor", "setProgress", "process", "animate", "setRightIcon", "setSeekBarHeight", "seekBarHeight", "setThumbColor", "thumbColorResId", "setThumbColorInt", "thumbColor", "setTickColor", "tickColorResId", "setTickColorInt", "tickColor", "setTickMarkCount", "showLeftIcon", "showRightIcon", "vibrate", "round", "decimals", "toFakeValue", "toRealValue", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSlider extends ConstraintLayout {
    private static final float BASE_MAX = 100.0f;
    private static final float BASE_MIN = 0.0f;
    public static final a Companion = null;
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
    private int sliderHeightPx;
    private final ImageView tvLeftIcon;
    private final ImageView tvRightIcon;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/slider/OSlider$Companion;", "", "()V", "BASE_MAX", "", "BASE_MIN", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public OSlider(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSlider(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSlider(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        this.maxValue = BASE_MAX;
        this.enableVibrate = true;
        this.seekbarHeight = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6);
        refreshDimensionCache();
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.OSlider, r8, 0);
        this.seekbarHeight = r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OSlider_sliderHeight, "styleable", "OSlider_sliderHeight"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6));
        setLeftImage(r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OSlider_oui_slider_left_icon, "styleable", "OSlider_oui_slider_left_icon")));
        setRightImage(r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OSlider_oui_slider_right_icon, "styleable", "OSlider_oui_slider_right_icon")));
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_slider, "layout", "o_slider"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.seekBar, OaidModel.KEY_ID, "seekBar"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.seekBar)");
        SeekBarFloatCompat r13 = (SeekBarFloatCompat) ZeusTransformUtils.preCheckCast(r12, SeekBarFloatCompat.class, "com.obric.memorydata.plugin");
        this.seekBar = r13;
        r13.setBackgroundHeight(this.seekbarHeight);
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.tvLeftIcon, OaidModel.KEY_ID, "tvLeftIcon"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.tvLeftIcon)");
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r14, ImageView.class, "com.obric.memorydata.plugin");
        this.tvLeftIcon = r15;
        if (this.leftImage == null) goto L5;
        r15.setVisibility(0);
        r15.setImageDrawable(this.leftImage);
    L5:
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tvRightIcon, OaidModel.KEY_ID, "tvRightIcon"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.tvRightIcon)");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.memorydata.plugin");
        this.tvRightIcon = r17;
        Drawable r18 = this.rightImage;
        if (r18 == null) goto L8;
        r17.setImageDrawable(r18);
        r17.setVisibility(0);
    L8:
        r13.setOnSeekBarChangeListenerExt((TickMarkSeekBar.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TickMarkSeekBar.b.class, "com.obric.memorydata.plugin"));
        r13.setHapticFeedbackEnabled(isHapticFeedbackEnabled());
    }

    public /* synthetic */ OSlider(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ TickMarkSeekBar.b access$getListener$p(OSlider r0) {
        return r0.listener;
    }

    public static final /* synthetic */ void access$setTracking$p(OSlider r0, boolean r1) {
        r0.isTracking = r1;
    }

    public static final /* synthetic */ float access$toRealValue(OSlider r0, float r1) {
        return r0.toRealValue(r1);
    }

    private final void refreshDimensionCache() {
        this.sliderHeightPx = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 32);
    }

    private final float round(float r3, int r4) {
        String r2 = String.format("%." + r4 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r2, "format(this, *args)");
        return Float.parseFloat(r2);
    }

    static /* synthetic */ float round$default(OSlider r0, float r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = 2;
    L7:
        return r0.round(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final float toFakeValue(float r2) {
        float r0 = this.minValue;
        return (((r2 - r0) / (this.maxValue - r0)) * BASE_MAX) + 0.0f;
    }

    private final float toRealValue(float r4) {
        float r0 = this.minValue;
        return round$default(this, r0 + (((r4 - 0.0f) / BASE_MAX) * (this.maxValue - r0)), 0, 1, null);
    }

    private final void vibrate() {
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("vibrator");     // Catch: Exception -> L9
        if (r2 == null) goto L7;
        ((Vibrator) ZeusTransformUtils.preCheckCast(r2, Vibrator.class, "com.obric.memorydata.plugin")).vibrate(10);     // Catch: Exception -> L9
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");     // Catch: Exception -> L9
    }

    public final void enableEdgeTouchOptimize(boolean r1) {
        this.optimizeEdgeTouchExperience = r1;
    }

    public final void enableVibrate(boolean r1) {
        this.enableVibrate = r1;
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

    public final float getRealProgress() {
        return toRealValue(this.seekBar.getFloatProgress());
    }

    public final Drawable getRightImage() {
        return this.rightImage;
    }

    public final SeekBar getSeekBar() {
        return (SeekBar) ZeusTransformUtils.preCheckCast(this.seekBar, SeekBar.class, "com.obric.memorydata.plugin");
    }

    public final void hideLeftIcon() {
        this.tvLeftIcon.setVisibility(8);
    }

    public final void hideRightIcon() {
        this.tvRightIcon.setVisibility(8);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(this.sliderHeightPx, 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (this.optimizeEdgeTouchExperience == false) goto L5;
        Rect r0 = new Rect();
        this.seekBar.getHitRect(r0);
        int r1 = r8.getActionMasked();
        if (r1 == 0) goto L27;
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L23;
    L30:
        b.b(TAG, "onTouchEvent, " + r8.getAction() + ", super.onTouchEvent, isSeeking: " + this.isSeeking);
        return super.onTouchEvent(r8);
    L15:
        if (this.isSeeking == false) goto L19;
        MotionEvent r9 = MotionEvent.obtain(r8);
        r9.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r9);
        r9.recycle();
        return true;
    L19:
        if (r0.contains((int) r8.getX(), (int) r8.getY()) == false) goto L30;
        this.isSeeking = true;
        MotionEvent r2 = MotionEvent.obtain(r8);
        r2.setAction(0);
        r2.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r2);
        r2.recycle();
        MotionEvent r10 = MotionEvent.obtain(r8);
        r10.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r10);
        r10.recycle();
        b.b(TAG, Intrinsics.stringPlus("onTouchEvent, ACTION_MOVE, case 3, isSeeking: ", Boolean.valueOf(this.isSeeking)));
        return true;
    L23:
        if (this.isSeeking == false) goto L30;
        MotionEvent r3 = MotionEvent.obtain(r8);
        r3.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r3);
        r3.recycle();
        this.isSeeking = false;
        requestDisallowInterceptTouchEvent(false);
        b.b(TAG, "onTouchEvent, " + r8.getAction() + ", case 4, isSeeking: " + this.isSeeking);
        return true;
    L27:
        if (r0.contains((int) r8.getX(), (int) r8.getY()) == true) goto L30;
        this.isSeeking = false;
        requestDisallowInterceptTouchEvent(true);
        b.b(TAG, Intrinsics.stringPlus("onTouchEvent, ACTION_DOWN, case 1, isSeeking: ", Boolean.valueOf(this.isSeeking)));
        return true;
    L5:
        return super.onTouchEvent(r8);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.seekBar.setEnabled(r2);
        this.tvLeftIcon.setEnabled(r2);
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        setAlpha(r3);
        return;
    L5:
        r3 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r1) {
        super.setHapticFeedbackEnabled(r1);
        this.seekBar.setHapticFeedbackEnabled(r1);
    }

    public final void setIsSegmented(boolean r2) {
        setIsSegmented(r2, 0, 0);
    }

    public final void setIsSegmented(boolean r1, int r2, int r3) {
        this.isStyleSegmented = r1;
        this.seekBar.setIsSegmented(r1, r2, r3);
    }

    public final void setLeftIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.tvLeftIcon.setImageDrawable(r2);
    }

    public final void setLeftImage(Drawable r1) {
        this.leftImage = r1;
    }

    public final void setMaxValue(float r3) {
        Log.d(TAG, Intrinsics.stringPlus("setMaxValue >>> ", Float.valueOf(r3)));
        this.maxValue = r3;
        this.seekBar.setMinValue(0.0f);
        this.seekBar.setMaxValue(BASE_MAX);
    }

    public final void setMinValue(float r3) {
        Log.d(TAG, Intrinsics.stringPlus("setMinValue >>> ", Float.valueOf(r3)));
        this.minValue = r3;
        this.seekBar.setMinValue(0.0f);
        this.seekBar.setMaxValue(BASE_MAX);
    }

    public final void setOnSeekBarChangeListenerExt(TickMarkSeekBar.b r3) {
        this.listener = (TickMarkSeekBar.b) ZeusTransformUtils.wrapperContextForParams(r3, TickMarkSeekBar.b.class, "com.obric.memorydata.plugin");
    }

    public final void setProcessBackgroundColor(int r1) {
        this.seekBar.setProcessBackgroundColor(r1);
    }

    public final void setProcessBackgroundColorInt(int r1) {
        this.seekBar.setProcessBackgroundColorInt(r1);
    }

    public final void setProcessColor(int r1, int r2) {
        this.seekBar.setProcessColor(r1, r2);
    }

    public final void setProcessColorInt(int r1, int r2) {
        this.seekBar.setProcessColorInt(r1, r2);
    }

    public final void setProcessProgressColor(int r1) {
        this.seekBar.setProcessProgressColor(r1);
    }

    public final void setProcessProgressColorInt(int r1) {
        this.seekBar.setProcessProgressColorInt(r1);
    }

    public final void setProgress(float r2) {
        this.seekBar.setProgress(toFakeValue(r2));
    }

    public final void setProgress(float r2, boolean r3) {
        this.seekBar.setProgress(toFakeValue(r2), r3);
    }

    public final void setRightIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.tvRightIcon.setImageDrawable(r2);
    }

    public final void setRightImage(Drawable r1) {
        this.rightImage = r1;
    }

    public final void setSeekBarHeight(float r1) {
        this.seekBar.setBackgroundHeight(r1);
    }

    public final void setThumbColor(int r1) {
        this.seekBar.setThumbColor(r1);
    }

    public final void setThumbColorInt(int r1) {
        this.seekBar.setThumbColorInt(r1);
    }

    public final void setTickColor(int r1) {
        this.seekBar.setTickColor(r1);
    }

    public final void setTickColorInt(int r1) {
        this.seekBar.setTickColorInt(r1);
    }

    public final void setTickMarkCount(int r1) {
        this.seekBar.setDefaultTickMarkCount(r1);
    }

    public final void showLeftIcon() {
        this.tvLeftIcon.setVisibility(0);
    }

    public final void showRightIcon() {
        this.tvRightIcon.setVisibility(0);
    }
}
