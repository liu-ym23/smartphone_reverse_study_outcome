package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.k;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b7\b\u0016\u0018\u0000 °\u00012\u00020\u0001:\u0004°\u0001±\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0002J\u0010\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\nH\u0002J\b\u0010\\\u001a\u00020WH\u0002J\u0012\u0010]\u001a\u00020W2\b\u0010^\u001a\u0004\u0018\u000106H\u0002J\b\u0010_\u001a\u00020\nH\u0002J\b\u0010`\u001a\u00020\nH\u0002J\b\u0010a\u001a\u00020\nH\u0002J\u001f\u0010b\u001a\u00020W2\u0006\u0010c\u001a\u00020d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020d0fH\u0082\bJ\u0010\u0010g\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\u0018\u0010j\u001a\u00020W2\u0006\u0010k\u001a\u00020l2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010m\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0003J\u0010\u0010n\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010o\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020\nH\u0002J\b\u0010r\u001a\u00020\nH\u0002J\u0010\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020lH\u0016J\u0006\u0010u\u001a\u00020\u0017J\b\u0010v\u001a\u00020\u0017H\u0002J\u0010\u0010w\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\nH\u0002J\u0014\u0010x\u001a\u0004\u0018\u0001062\b\u0010^\u001a\u0004\u0018\u000106H\u0002J\u0012\u0010y\u001a\u00020W2\b\u0010z\u001a\u0004\u0018\u00010{H\u0014J\u0010\u0010|\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0014J\u0018\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0007H\u0014J\u0013\u0010\u0080\u0001\u001a\u00020\u00172\b\u0010^\u001a\u0004\u0018\u000106H\u0016J\t\u0010\u0081\u0001\u001a\u00020WH\u0002J\t\u0010\u0082\u0001\u001a\u00020WH\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\u000f\u0010\u0086\u0001\u001a\u00020W2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0087\u0001\u001a\u00020W2\u0007\u0010\u0088\u0001\u001a\u00020\u0017J\u0011\u0010\u0089\u0001\u001a\u00020W2\u0006\u0010K\u001a\u00020\u0007H\u0016J$\u0010\u008a\u0001\u001a\u00020W2\u0006\u0010#\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\u00072\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0007J\u000f\u0010\u008c\u0001\u001a\u00020W2\u0006\u0010+\u001a\u00020\u0007J\u000f\u0010\u008d\u0001\u001a\u00020W2\u0006\u0010-\u001a\u00020\u0007J\u0012\u0010\u008e\u0001\u001a\u00020W2\t\u0010\u008f\u0001\u001a\u0004\u0018\u000100J\u0012\u0010\u0090\u0001\u001a\u00020W2\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u0007J\u0012\u0010\u0092\u0001\u001a\u00020W2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u001d\u0010\u0094\u0001\u001a\u00020W2\t\b\u0001\u0010\u0095\u0001\u001a\u00020\u00072\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u0007J\u001d\u0010\u0096\u0001\u001a\u00020W2\t\b\u0001\u0010\u0097\u0001\u001a\u00020\u00072\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u0012\u0010\u0098\u0001\u001a\u00020W2\t\b\u0001\u0010\u0099\u0001\u001a\u00020\u0007J\u0011\u0010\u009a\u0001\u001a\u00020W2\b\b\u0001\u00109\u001a\u00020\u0007J\u0012\u0010\u009b\u0001\u001a\u00020W2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010\u009b\u0001\u001a\u00020W2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020W2\t\b\u0001\u0010\u009f\u0001\u001a\u00020\u0007J\u0011\u0010 \u0001\u001a\u00020W2\b\b\u0001\u0010?\u001a\u00020\u0007J\u0012\u0010¡\u0001\u001a\u00020W2\t\b\u0001\u0010¢\u0001\u001a\u00020\u0007J\u0012\u0010£\u0001\u001a\u00020W2\t\b\u0001\u0010¢\u0001\u001a\u00020\u0007J\u0011\u0010¤\u0001\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001f\u0010¥\u0001\u001a\u00020\u00172\u0007\u0010¦\u0001\u001a\u00020\n2\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010¨\u0001\u001a\u00020W2\u0007\u0010©\u0001\u001a\u00020\u0017J\u0011\u0010ª\u0001\u001a\u00020W2\u0006\u0010^\u001a\u000206H\u0003J\u0012\u0010«\u0001\u001a\u00020W2\u0007\u0010¬\u0001\u001a\u00020\nH\u0002J\u0018\u0010\u00ad\u0001\u001a\u00020\n*\u00020\n2\t\b\u0002\u0010®\u0001\u001a\u00020\u0007H\u0002J\r\u0010¯\u0001\u001a\u00020\n*\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010O\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006²\u0001"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundHeight", "", "centerY", "clipPath", "Landroid/graphics/Path;", EventBody.KEY_VALUE, "currentProgress", "getCurrentProgress", "()F", "setCurrentProgress", "(F)V", "currentProgressVelocity", "currentTargetProgress", "debugLogEnabled", "", "enableMoveThumbOnDownOutside", "getEnableMoveThumbOnDownOutside", "()Z", "setEnableMoveThumbOnDownOutside", "(Z)V", "hasDirectionLocked", "isDraggingHorizontally", "isFirstFrame", "isInternalUpdating", "isPress", "isPressThumb", "isStyleSegmented", "isThumbOnTouchDown", "isThumbOnTouchEvent", "mBackgroundColor", "mCurrentTickIndex", "mTouchProgressOffset", "getMTouchProgressOffset", "setMTouchProgressOffset", "maxVisibleProgress", "measureHeightPx", "minVisibleProgress", "mirrorForRtl", "onSeekBarChangeListenerExt", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "paddingHorizontal", "paint", "Landroid/graphics/Paint;", "path", "pendingDownTrackEvent", "Landroid/view/MotionEvent;", "progressAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "progressColor", "rectF", "Landroid/graphics/RectF;", "seekBarVibrateHelper", "Lcom/obric/oui/slider/SeekBarVibrateHelper;", "thumbAnimator", "thumbColor", "thumbNormalScale", "thumbPressScale", "thumbScale", "thumbScaleVelocity", "thumbShadow", "Lcom/obric/oui/common/style/Shadow;", "thumbSize", "thumbStrokeColor", "thumbStrokeRectF", "thumbStrokeWidth", "tickColor", "tickMarkCount", "tickRadius", "touchDownX", "touchDownY", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "trackDownIfNoMoveRunnable", "Ljava/lang/Runnable;", "anchorPoint", "", "calculateScaleByX", "rawX", "calculateXByScale", "scale", "cancelPendingDownTrack", "cancelTouchByInternalUpdate", "event", "currentThumbCenterX", "currentThumbRadius", "currentThumbSize", "debugLog", "stage", "", "message", "Lkotlin/Function0;", "drawBackground", "canvas", "Landroid/graphics/Canvas;", "drawCustomProgress", "d", "Landroid/graphics/drawable/Drawable;", "drawProgress", "drawThumb", "drawTickMark", "getCompatMinValue", "getTrackEndX", "getTrackStartX", "invalidateDrawable", "dr", "isDebugLogEnabled", "isLayoutRtlForProgress", "isTouchAtTrackEdge", "obtainTouchEventForNativeProgress", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "onTrackDownIfNoMove", "refreshDimensionCache", "resetTouchTrackingState", "resolveSegmentedProgressByIndex", "index", "setBackgroundHeight", "setDebugLogEnabled", "enabled", "setDefaultTickMarkCount", "setIsSegmented", "initTickPosition", "setMaxVisibleProgress", "setMinVisibleProgress", "setOnSeekBarChangeListenerExt", "l", "setProcessBackgroundColor", "backgroundColorResId", "setProcessBackgroundColorInt", "backgroundColor", "setProcessColor", "processColorResId", "setProcessColorInt", "processColor", "setProcessProgressColor", "progressColorResId", "setProcessProgressColorInt", "setProgress", "progress", "animate", "setThumbColor", "thumbColorResId", "setThumbColorInt", "setTickColor", TypedValues.Custom.S_COLOR, "setTickColorInt", "toLogicalTrackX", "toggleProgressChangedAnim", "newProgress", "endAction", "toggleThumbScaleAnim", "toPress", "trackTouchEvent", "updateTouchProgressOffsetOnDown", "downX", "round", "decimals", "toRealValue", "Companion", "OnSeekBarChangeListenerExt", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TickMarkSeekBar extends AppCompatSeekBar {
    public static final a Companion = null;
    private static final long DOWN_NO_MOVE_TRACK_DELAY_MS = 150;
    private static final String TAG = "TickSeekBar";
    private static volatile boolean globalDebugLogEnabled;
    private float backgroundHeight;
    private final float centerY;
    private final Path clipPath;
    private float currentProgress;
    private float currentProgressVelocity;
    private float currentTargetProgress;
    private boolean debugLogEnabled;
    private boolean enableMoveThumbOnDownOutside;
    private boolean hasDirectionLocked;
    private boolean isDraggingHorizontally;
    private boolean isFirstFrame;
    private boolean isInternalUpdating;
    private boolean isPress;
    private boolean isPressThumb;
    private boolean isStyleSegmented;
    private boolean isThumbOnTouchDown;
    private boolean isThumbOnTouchEvent;
    private int mBackgroundColor;
    private int mCurrentTickIndex;
    private float mTouchProgressOffset;
    private int maxVisibleProgress;
    private int measureHeightPx;
    private int minVisibleProgress;
    private boolean mirrorForRtl;
    private b onSeekBarChangeListenerExt;
    private final float paddingHorizontal;
    private final Paint paint;
    private final Path path;
    private MotionEvent pendingDownTrackEvent;
    private d progressAnimator;
    private int progressColor;
    private final RectF rectF;
    private final com.obric.oui.slider.a seekBarVibrateHelper;
    private d thumbAnimator;
    private int thumbColor;
    private final float thumbNormalScale;
    private final float thumbPressScale;
    private float thumbScale;
    private float thumbScaleVelocity;
    private k thumbShadow;
    private final float thumbSize;
    private int thumbStrokeColor;
    private final RectF thumbStrokeRectF;
    private float thumbStrokeWidth;
    private int tickColor;
    private int tickMarkCount;
    private final float tickRadius;
    private float touchDownX;
    private float touchDownY;
    private final Lazy touchSlop$delegate;
    private final Runnable trackDownIfNoMoveRunnable;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar$Companion;", "", "()V", "DOWN_NO_MOVE_TRACK_DELAY_MS", "", "TAG", "", "globalDebugLogEnabled", "", "getGlobalDebugLogEnabled", "()Z", "setGlobalDebugLogEnabled", "(Z)V", "actionToString", "action", "", "enableGlobalDebugLog", "", "enabled", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a(int r1) {
            if (r1 != 0) goto L4;
            return "DOWN";
        L4:
            if (r1 != 1) goto L6;
            return "UP";
        L6:
            if (r1 != 2) goto L8;
            return "MOVE";
        L8:
            if (r1 != 3) goto L10;
            return "CANCEL";
        L10:
            if (r1 != 5) goto L12;
            return "POINTER_DOWN";
        L12:
            if (r1 != 6) goto L21;
            return "POINTER_UP";
        L21:
            return String.valueOf(r1);
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }

        public final void a(boolean r1) {
            TickMarkSeekBar.access$setGlobalDebugLogEnabled$cp(r1);
        }

        @JvmStatic
        public final void b(boolean r1) {
            a(r1);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onSegmentedPositionChanged", "index", "", "onStartTrackingTouch", "onStopTrackingTouch", "onTouchDown", "onTouchUp", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(int r1);

        void a(SeekBar r1);

        void a(SeekBar r1, float r2);

        void a(SeekBar r1, float r2, boolean r3);

        void b(SeekBar r1);

        void c(SeekBar r1);
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/obric/oui/slider/TickMarkSeekBar$setOnSeekBarChangeListenerExt$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TickMarkSeekBar f14493a;

        c(TickMarkSeekBar r1) {
            this.f14493a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r9, int r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r9, "seekBar");
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L7:
            TickMarkSeekBar r0 = this.f14493a;
            if (r0.isDebugLogEnabled() == false) goto L11;
            com.obric.oui.c.a.b.b(TickMarkSeekBar.TAG, "[listener-progress][" + Integer.toHexString(System.identityHashCode(r0)) + "] " + ("progress=" + r10 + ", fromUser=" + r11 + ", currentProgress=" + TickMarkSeekBar.access$getCurrentProgress(r0) + ", currentTargetProgress=" + TickMarkSeekBar.access$getCurrentTargetProgress$p(r0) + ", tickMarkCount=" + TickMarkSeekBar.access$getTickMarkCount$p(r0)));
        L11:
            b r1 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f14493a);
            if (r1 == null) goto L16;
            r1.a(r9, TickMarkSeekBar.access$toRealValue(this.f14493a, r10), r11);
            return;
        L16:
            return;
        L5:
            if (this.f14493a.isHapticFeedbackEnabled() == false) goto L7;
            com.obric.oui.slider.a r2 = TickMarkSeekBar.access$getSeekBarVibrateHelper$p(this.f14493a);
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14493a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r3, "context");
            r2.a(r3, r9, r10, r11, TickMarkSeekBar.access$getTickMarkCount$p(this.f14493a), TickMarkSeekBar.access$isStyleSegmented$p(this.f14493a));
            goto L7
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r3) {
            TickMarkSeekBar.access$setMCurrentTickIndex$p(this.f14493a, -1);
            b r2 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f14493a);
            if (r2 == null) goto L7;
            r2.a(r3);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r3) {
            b r4 = TickMarkSeekBar.access$getOnSeekBarChangeListenerExt$p(this.f14493a);
            if (r4 == null) goto L7;
            r4.b((SeekBar) ZeusTransformUtils.preCheckCast(this.f14493a, SeekBar.class, "com.obric.memorydata.plugin"));
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public TickMarkSeekBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public TickMarkSeekBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public TickMarkSeekBar(Context r19, AttributeSet r20, int r21) {
        final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r4, r21);
        this.tickMarkCount = -1;
        this.backgroundHeight = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6);
        this.centerY = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
        this.thumbNormalScale = 1.0f;
        this.thumbPressScale = 1.22f;
        this.thumbSize = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 18);
        this.thumbScale = 1.0f;
        this.minVisibleProgress = -1;
        this.maxVisibleProgress = -1;
        this.tickRadius = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2);
        Paint r6 = new Paint();
        this.paint = r6;
        this.clipPath = new Path();
        this.rectF = new RectF();
        this.thumbStrokeRectF = new RectF();
        this.path = new Path();
        this.mCurrentTickIndex = -1;
        this.seekBarVibrateHelper = new com.obric.oui.slider.a();
        this.thumbShadow = new k(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
        this.isFirstFrame = true;
        this.paddingHorizontal = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        this.touchSlop$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new TickMarkSeekBar$touchSlop$2(r2), Function0.class, "com.obric.memorydata.plugin"));
        this.trackDownIfNoMoveRunnable = new $$Lambda$TickMarkSeekBar$u0SGW8NzFNB6Ve3Di9ZuOg3dvY(this);
        this.enableMoveThumbOnDownOutside = true;
        refreshDimensionCache();
        TypedArray r1 = r2.getTheme().obtainStyledAttributes(r4, R.styleable.TickMarkSeekBar, r21, 0);
        this.backgroundHeight = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarHeight, "styleable", "TickMarkSeekBar_seekbarHeight"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6));
        this.mBackgroundColor = r1.getColor(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarBackgroundColor, "styleable", "TickMarkSeekBar_seekbarBackgroundColor"), ContextCompat.getColor(r2, ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, TypedValues.Custom.S_COLOR, "oui_basic_line_2")));
        this.progressColor = r1.getColor(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarProgressColor, "styleable", "TickMarkSeekBar_seekbarProgressColor"), ContextCompat.getColor(r2, ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6")));
        this.thumbColor = r1.getColor(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarThumbColor, "styleable", "TickMarkSeekBar_seekbarThumbColor"), ContextCompat.getColor(r2, ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, TypedValues.Custom.S_COLOR, "oui_on_accent_default")));
        this.thumbStrokeColor = r1.getColor(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarThumbStrokeColor, "styleable", "TickMarkSeekBar_seekbarThumbStrokeColor"), ContextCompat.getColor(r2, ZeusTransformUtils.mapRes(R.color.oui_basic_line_1, TypedValues.Custom.S_COLOR, "oui_basic_line_1")));
        this.tickColor = r1.getColor(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarTickColor, "styleable", "TickMarkSeekBar_seekbarTickColor"), ContextCompat.getColor(r2, ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, TypedValues.Custom.S_COLOR, "oui_basic_line_2")));
        setEnableMoveThumbOnDownOutside(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarEnableMoveThumbOnDownOutside, "styleable", "TickMarkSeekBar_seekbarEnableMoveThumbOnDownOutside"), true));
        this.mirrorForRtl = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TickMarkSeekBar_seekbarMirrorForRtl, "styleable", "TickMarkSeekBar_seekbarMirrorForRtl"), false);
        r1.recycle();
        setOnSeekBarChangeListenerExt(null);
        r6.setStyle(Paint.Style.FILL);
        com.obric.oui.c.h.f13408a.a(r2, ZeusTransformUtils.mapRes(R.style.OUIShadow_1, "style", "OUIShadow_1"), this.thumbShadow);
        setCurrentProgress(getProgress());
    }

    public /* synthetic */ TickMarkSeekBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ float access$getCurrentProgress(TickMarkSeekBar r0) {
        return r0.getCurrentProgress();
    }

    public static final /* synthetic */ float access$getCurrentTargetProgress$p(TickMarkSeekBar r0) {
        return r0.currentTargetProgress;
    }

    public static final /* synthetic */ boolean access$getGlobalDebugLogEnabled$cp() {
        return globalDebugLogEnabled;
    }

    public static final /* synthetic */ b access$getOnSeekBarChangeListenerExt$p(TickMarkSeekBar r0) {
        return r0.onSeekBarChangeListenerExt;
    }

    public static final /* synthetic */ com.obric.oui.slider.a access$getSeekBarVibrateHelper$p(TickMarkSeekBar r0) {
        return r0.seekBarVibrateHelper;
    }

    public static final /* synthetic */ float access$getThumbScale$p(TickMarkSeekBar r0) {
        return r0.thumbScale;
    }

    public static final /* synthetic */ int access$getTickMarkCount$p(TickMarkSeekBar r0) {
        return r0.tickMarkCount;
    }

    public static final /* synthetic */ boolean access$isStyleSegmented$p(TickMarkSeekBar r0) {
        return r0.isStyleSegmented;
    }

    public static final /* synthetic */ void access$setCurrentProgress(TickMarkSeekBar r0, float r1) {
        r0.setCurrentProgress(r1);
    }

    public static final /* synthetic */ void access$setCurrentProgressVelocity$p(TickMarkSeekBar r0, float r1) {
        r0.currentProgressVelocity = r1;
    }

    public static final /* synthetic */ void access$setGlobalDebugLogEnabled$cp(boolean r0) {
        globalDebugLogEnabled = r0;
    }

    public static final /* synthetic */ void access$setMCurrentTickIndex$p(TickMarkSeekBar r0, int r1) {
        r0.mCurrentTickIndex = r1;
    }

    public static final /* synthetic */ void access$setThumbScale$p(TickMarkSeekBar r0, float r1) {
        r0.thumbScale = r1;
    }

    public static final /* synthetic */ void access$setThumbScaleVelocity$p(TickMarkSeekBar r0, float r1) {
        r0.thumbScaleVelocity = r1;
    }

    public static final /* synthetic */ float access$toRealValue(TickMarkSeekBar r0, int r1) {
        return r0.toRealValue(r1);
    }

    private final void anchorPoint() {
        if (this.isStyleSegmented == false) goto L35;
        final int r1 = 0;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, this.tickMarkCount), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(Integer.valueOf(resolveSegmentedProgressByIndex(((IntIterator) ZeusTransformUtils.preCheckCast(r3, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L6
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r5.hasNext() == true) goto L11;
        Object r6 = null;
    L21:
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L25;
        r1 = r7.intValue();
    L25:
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r4.get(r1), Number.class, "com.obric.memorydata.plugin")).intValue();
        Runnable r9 = new $$Lambda$TickMarkSeekBar$2s97K8WQtJLWId8dAATjDkwrfpM(this, r1);
        boolean r10 = toggleProgressChangedAnim(r8, r9);
        if (isDebugLogEnabled() == false) goto L29;
        com.obric.oui.c.a.b.b(TAG, "[anchor-point][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("closestTickIndex=" + r1 + ", closestProgress=" + r8 + ", currentProgress=" + getCurrentProgress() + ", result=" + r10));
    L29:
        if (r10 == true) goto L36;
        r9.run();
        return;
    L36:
        return;
    L11:
        Object r11 = r5.next();
        if (r5.hasNext() == true) goto L14;
    L13:
        r6 = r11;
        goto L21
    L14:
        int r12 = Math.abs(((Number) ZeusTransformUtils.preCheckCast(r4.get(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue()), Number.class, "com.obric.memorydata.plugin")).intValue() - getProgress());
    L15:
        Object r13 = r5.next();
        int r14 = Math.abs(((Number) ZeusTransformUtils.preCheckCast(r4.get(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue()), Number.class, "com.obric.memorydata.plugin")).intValue() - getProgress());
        if (r12 <= r14) goto L19;
        r11 = r13;
        r12 = r14;
    L19:
        if (r5.hasNext() == true) goto L15;
    }

    /* JADX INFO: renamed from: anchorPoint$lambda-32, reason: not valid java name */
    private static final void m1364anchorPoint$lambda32(TickMarkSeekBar r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.mCurrentTickIndex = r2;
        b r0 = r1.onSeekBarChangeListenerExt;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        r1.invalidate();
    }

    private final float calculateScaleByX(float r5) {
        float r0 = getTrackStartX();
        float r1 = getTrackEndX() - r0;
        if (r1 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn((toLogicalTrackX(r5) - r0) / r1, 0.0f, 1.0f);
    }

    private final float calculateXByScale(float r6) {
        float r0 = this.paddingHorizontal + (this.thumbSize / 2.0f);
        float r1 = (getWidth() - this.paddingHorizontal) - (this.thumbSize / 2.0f);
        float r2 = ((r1 - r0) * RangesKt.coerceIn(r6, 0.0f, 1.0f)) + r0;
        if (isLayoutRtlForProgress() == true) goto L5;
        return r2;
    L5:
        if (this.mirrorForRtl == true) goto L7;
        return r2;
    L7:
        return (r0 + r1) - r2;
    }

    private final void cancelPendingDownTrack() {
        MotionEvent r0 = this.pendingDownTrackEvent;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.pendingDownTrackEvent = null;
        removeCallbacks(this.trackDownIfNoMoveRunnable);
    }

    private final void cancelTouchByInternalUpdate(MotionEvent r5) {
        if (isDebugLogEnabled() == false) goto L10;
        StringBuilder r0 = new StringBuilder().append('[').append("internal-update-cancel").append("][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r1 = new StringBuilder().append("action=");
        a r2 = Companion;
        if (r5 != null) goto L8;
        int r3 = -1;
    L9:
        com.obric.oui.c.a.b.b(TAG, r0.append(r1.append(a.a(r2, r3)).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", touchOffset=").append(getMTouchProgressOffset()).toString()).toString());
        goto L10
    L8:
        r3 = r5.getActionMasked();
    L10:
        this.isPress = false;
        resetTouchTrackingState();
        if (r5 == null) goto L14;
        MotionEvent r6 = MotionEvent.obtain(r5);
        r6.setAction(3);
        super.onTouchEvent(r6);
        r6.recycle();
    L14:
        this.isInternalUpdating = false;
    }

    private final float currentThumbCenterX() {
        float r0 = getWidth();
        float r1 = this.paddingHorizontal;
        float r2 = this.thumbSize;
        return (r1 + (r2 / 2.0f)) + ((getCurrentProgress() / getMax()) * (((r0 - r1) - r1) - r2));
    }

    private final float currentThumbRadius() {
        return (this.thumbSize * this.thumbScale) / 2.0f;
    }

    private final float currentThumbSize() {
        return this.thumbSize * this.thumbScale;
    }

    private final void debugLog(String r4, Function0<String> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if (isDebugLogEnabled() == true) goto L5;
        return;
    L5:
        com.obric.oui.c.a.b.b(TAG, '[' + r4 + "][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ((String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.memorydata.plugin")));
    }

    private final void drawBackground(Canvas r7) {
        r7.save();
        float r0 = this.backgroundHeight / 2;
        this.rectF.set(this.paddingHorizontal, this.centerY - r0, getWidth() - this.paddingHorizontal, this.centerY + r0);
        this.clipPath.reset();
        this.clipPath.addRoundRect(this.rectF, r0, r0, Path.Direction.CW);
        this.paint.setColor(this.mBackgroundColor);
        r7.drawPath(this.clipPath, this.paint);
        r7.restore();
        if (this.isStyleSegmented == false) goto L6;
        drawTickMark(r7);
        return;
    }

    private final void drawCustomProgress(Drawable r5, Canvas r6) {
        r6.translate(0.0f, getPaddingTop());
        r5.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r5.getIntrinsicHeight() / 2), getMeasuredWidth(), (getMeasuredHeight() / 2) + (r5.getIntrinsicHeight() / 2)));
        r5.draw(r6);
    }

    private final void drawProgress(Canvas r10) {
        int r0 = r10.save();
        if (getProgressDrawable() == null) goto L5;
        Drawable r1 = getProgressDrawable();
        Intrinsics.checkNotNullExpressionValue(r1, "progressDrawable");
        drawCustomProgress(r1, r10);
    L9:
        r10.restoreToCount(r0);
        return;
    L5:
        float r2 = this.backgroundHeight / 2;
        float r3 = currentThumbCenterX();
        float r4 = currentThumbRadius();
        RectF r5 = this.rectF;
        float r6 = this.paddingHorizontal;
        float r7 = this.centerY;
        r5.set(r6, r7 - r2, r3, r7 + r2);
        this.path.reset();
        this.path.addRoundRect(this.rectF, new float[]{r2, r2, 0.0f, 0.0f, 0.0f, 0.0f, r2, r2}, Path.Direction.CW);
        this.paint.setColor(this.progressColor);
        if (Build.VERSION.SDK_INT < 26) goto L8;
        this.clipPath.reset();
        this.clipPath.addCircle(r3, this.centerY, r4, Path.Direction.CW);
        r10.clipOutPath(this.clipPath);
    L8:
        r10.drawPath(this.path, this.paint);
        goto L9
    }

    private final void drawThumb(Canvas r8) {
        if (this.thumbColor != 0) goto L5;
        return;
    L5:
        r8.save();
        float r0 = currentThumbSize();
        float r1 = currentThumbCenterX();
        this.paint.setColor(this.thumbColor);
        float r2 = r0 / 2.0f;
        float r5 = this.centerY;
        this.rectF.set(r1 - r2, r5 - r2, r1 + r2, r5 + r2);
        r8.drawRoundRect(this.rectF, r2, r2, this.paint);
        r8.restore();
        r8.save();
        com.obric.oui.c.h.f13408a.a(r8, this.thumbShadow, this.rectF, r2);
        r8.restore();
        float r3 = this.thumbStrokeWidth / 2.0f;
        this.thumbStrokeRectF.set(this.rectF);
        float r4 = -r3;
        this.thumbStrokeRectF.inset(r4, r4);
        Paint.Style r6 = this.paint.getStyle();
        float r7 = this.paint.getStrokeWidth();
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.thumbStrokeWidth);
        this.paint.setColor(this.thumbStrokeColor);
        float r9 = r2 + r3;
        r8.drawRoundRect(this.thumbStrokeRectF, r9, r9, this.paint);
        this.paint.setStrokeWidth(r7);
        this.paint.setStyle(r6);
    }

    private final void drawTickMark(Canvas r9) {
        if (this.tickMarkCount > 0) goto L5;
        return;
    L5:
        if (this.isStyleSegmented == false) goto L11;
        float r0 = getWidth();
        float r1 = this.paddingHorizontal;
        float r2 = ((r0 - r1) - r1) - this.thumbSize;
        int r3 = this.tickMarkCount;
        float r4 = r2 / (r3 - 1);
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L12;
        int r6 = r5 + 1;
        float r7 = this.paddingHorizontal;
        float r8 = this.thumbSize;
        float r10 = (r7 + (r8 / 2.0f)) + (r5 * r4);
        float r11 = (this.centerY + (r8 / 2.0f)) - this.tickRadius;
        this.paint.setColor(this.tickColor);
        r9.drawCircle(r10, r11, this.tickRadius, this.paint);
        r5 = r6;
        goto L7
    L12:
        return;
    }

    @JvmStatic
    public static final void enableGlobalDebugLog(boolean r1) {
        Companion.b(r1);
    }

    private final int getCompatMinValue() {
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return 0;
    L7:
        return getMin();
    }

    private final float getCurrentProgress() {
        return this.currentProgress;
    }

    private final int getTouchSlop() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.touchSlop$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final float getTrackEndX() {
        return (getWidth() - this.paddingHorizontal) - (this.thumbSize / 2.0f);
    }

    private final float getTrackStartX() {
        return this.paddingHorizontal + (this.thumbSize / 2.0f);
    }

    private final boolean isLayoutRtlForProgress() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final boolean isTouchAtTrackEdge(float r8) {
        float r0 = toLogicalTrackX(r8);
        boolean r2 = true;
        if (r0 > getTrackStartX()) goto L5;
        boolean r1 = true;
    L7:
        if (r0 < getTrackEndX()) goto L9;
        boolean r4 = true;
    L10:
        if (r1 == true) goto L14;
        if (r4 == true) goto L14;
        r2 = false;
    L14:
        if (r2 == true) goto L16;
    L19:
        return r2;
    L16:
        if (isDebugLogEnabled() == false) goto L19;
        com.obric.oui.c.a.b.b(TAG, "[track-edge-hit][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("rawX=" + r8 + ", logicalX=" + r0 + ", hitStart=" + r1 + ", hitEnd=" + r4 + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX()));
        goto L19
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    public static /* synthetic */ void lambda$2s97K8WQtJLWId8dAATjDkwrfpM(TickMarkSeekBar r0, int r1) {
        m1364anchorPoint$lambda32(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$u0SGW8NzFNB6V-e3Di9ZuOg3dvY, reason: not valid java name */
    public static /* synthetic */ void m1365lambda$u0SGW8NzFNB6Ve3Di9ZuOg3dvY(TickMarkSeekBar r0) {
        m1366trackDownIfNoMoveRunnable$lambda0(r0);
    }

    private final MotionEvent obtainTouchEventForNativeProgress(MotionEvent r15) {
        if (r15 != null) goto L6;
        return null;
    L6:
        if (r15.getAction() == 0) goto L11;
        if (r15.getAction() == 2) goto L11;
        return null;
    L11:
        if (this.isThumbOnTouchDown == false) goto L13;
    L14:
        boolean r3 = true;
        if (this.mTouchProgressOffset != 0.0f) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L21;
    L19:
        return null;
    L21:
        if (isTouchAtTrackEdge(r15.getX()) == true) goto L23;
        int r10 = getMax() - getCompatMinValue();
        if (r10 > 0) goto L30;
        return null;
    L30:
        float r2 = calculateScaleByX(r15.getX());
        float r11 = RangesKt.coerceIn((this.mTouchProgressOffset / r10) + r2, 0.0f, 1.0f);
        float r12 = calculateXByScale(r11);
        if (r12 == r15.getX()) goto L34;
        r3 = false;
    L34:
        if (r3 == false) goto L37;
        return null;
    L37:
        if (isDebugLogEnabled() == false) goto L40;
        com.obric.oui.c.a.b.b(TAG, "[native-event-correct][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("rawX=" + r15.getX() + ", scale=" + r2 + ", nativeScale=" + r11 + ", nativeX=" + r12 + ", offset=" + getMTouchProgressOffset() + ", range=" + r10));
    L40:
        MotionEvent r14 = MotionEvent.obtain(r15);
        r14.offsetLocation(r12 - r15.getX(), 0.0f);
        return r14;
    L23:
        if (isDebugLogEnabled() == false) goto L26;
        com.obric.oui.c.a.b.b(TAG, "[native-event-skip-edge][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r15.getX() + ", logicalX=" + toLogicalTrackX(r15.getX()) + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX() + ", offset=" + getMTouchProgressOffset()));
    L26:
        return null;
    L17:
        r1 = false;
        goto L18
    L13:
        if (this.isThumbOnTouchEvent == false) goto L19;
        goto L14
    }

    private final void onTrackDownIfNoMove() {
        if (this.isPress == false) goto L23;
        if (this.isInternalUpdating == true) goto L23;
        if (this.hasDirectionLocked == true) goto L23;
        if (this.isDraggingHorizontally == true) goto L23;
        if (this.isThumbOnTouchDown == true) goto L23;
        MotionEvent r0 = this.pendingDownTrackEvent;
        this.pendingDownTrackEvent = null;
        removeCallbacks(this.trackDownIfNoMoveRunnable);
        if (r0 != null) goto L17;
        return;
    L17:
        if (isDebugLogEnabled() == false) goto L20;
        com.obric.oui.c.a.b.b(TAG, "[delayed-track-run][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("action=" + a.a(Companion, r0.getAction()) + ", x=" + r0.getX() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress()));
    L20:
        trackTouchEvent(r0);
        r0.recycle();
        return;
    L23:
        if (isDebugLogEnabled() == false) goto L26;
        com.obric.oui.c.a.b.b(TAG, "[delayed-track-skip][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("isPress=" + this.isPress + ", isInternalUpdating=" + this.isInternalUpdating + ", hasDirectionLocked=" + this.hasDirectionLocked + ", isDraggingHorizontally=" + this.isDraggingHorizontally + ", isThumbOnTouchDown=" + this.isThumbOnTouchDown));
    L26:
        cancelPendingDownTrack();
    }

    private final void refreshDimensionCache() {
        this.measureHeightPx = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 32);
        this.thumbStrokeWidth = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0.5d);
    }

    private final void resetTouchTrackingState() {
        if (isDebugLogEnabled() == false) goto L6;
        com.obric.oui.c.a.b.b(TAG, "[reset-touch-state][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("isThumbOnTouchDown=" + this.isThumbOnTouchDown + ", isThumbOnTouchEvent=" + this.isThumbOnTouchEvent + ", hasDirectionLocked=" + this.hasDirectionLocked + ", isDraggingHorizontally=" + this.isDraggingHorizontally));
    L6:
        this.isThumbOnTouchDown = false;
        this.isThumbOnTouchEvent = false;
        this.hasDirectionLocked = false;
        this.isDraggingHorizontally = false;
        cancelPendingDownTrack();
        toggleThumbScaleAnim(false);
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    private final int resolveSegmentedProgressByIndex(int r4) {
        int r0 = this.tickMarkCount;
        if (r0 > 1) goto L6;
        return 0;
    L6:
        if (r4 > 0) goto L10;
        return getCompatMinValue();
    L10:
        if (r4 >= (r0 - 1)) goto L12;
        int r1 = getCompatMinValue();
        return MathKt.roundToInt(r1 + ((getMax() - r1) * (r4 / (this.tickMarkCount - 1))));
    L12:
        return getMax();
    }

    private final float round(float r4, int r5) {
        String r3 = String.format(Locale.CHINA, "%." + r5 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1));
        Intrinsics.checkNotNullExpressionValue(r3, "format(locale, this, *args)");
        return Float.parseFloat(r3);
    }

    static /* synthetic */ float round$default(TickMarkSeekBar r0, float r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = 2;
    L7:
        return r0.round(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final void setCurrentProgress(float r1) {
        this.currentProgress = r1;
    }

    public static /* synthetic */ void setIsSegmented$default(TickMarkSeekBar r1, boolean r2, int r3, int r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.setIsSegmented(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIsSegmented");
    }

    private final float toLogicalTrackX(float r4) {
        float r0 = getTrackStartX();
        float r1 = getTrackEndX();
        if (isLayoutRtlForProgress() == true) goto L5;
        return r4;
    L5:
        if (this.mirrorForRtl == true) goto L7;
        return r4;
    L7:
        return (r0 + r1) - r4;
    }

    private final float toRealValue(int r4) {
        return round$default(this, r4 / 100, 0, 1, null);
    }

    private final boolean toggleProgressChangedAnim(float r10, Runnable r11) {
        final Runnable r12 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        if (getCurrentProgress() != r10) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return false;
    L9:
        if (this.isThumbOnTouchDown == false) goto L11;
    L28:
        d r1 = this.progressAnimator;
        if (r1 == null) goto L32;
        d.a(r1, false, 1, null);
    L32:
        setCurrentProgress(r10);
        this.currentTargetProgress = getCurrentProgress();
        invalidate();
        if (r12 == null) goto L36;
        r12.run();
    L36:
        return true;
    L11:
        if (this.isThumbOnTouchEvent == true) goto L28;
        if (this.currentTargetProgress != r10) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L23;
        d r3 = this.progressAnimator;
        if (r3 == null) goto L22;
        d.a(r3, false, 1, null);
    L22:
        this.currentTargetProgress = r10;
        com.obric.common.oea.foundation.animation.builder.c.a r13 = new com.obric.common.oea.foundation.animation.builder.c.a();
        float r4 = getCurrentProgress();
        float r5 = this.currentTargetProgress;
        com.obric.common.oea.foundation.animation.spec.spring.b r6 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null);
        r6.a(0.1f);
        Unit r7 = Unit.INSTANCE;
        this.progressAnimator = r13.a(r4, r5, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r6, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), Float.valueOf(this.currentProgressVelocity)).a((Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r12), Function2.class, "com.obric.memorydata.plugin")).a().a();
        invalidate();
    L27:
        return true;
    L23:
        setCurrentProgress(r10);
        this.currentTargetProgress = r10;
        invalidate();
        if (r12 == null) goto L27;
        r12.run();
        goto L27
    L16:
        r2 = false;
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ boolean toggleProgressChangedAnim$default(TickMarkSeekBar r2, float r3, Runnable r4, int r5, Object r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.toggleProgressChangedAnim(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleProgressChangedAnim");
    }

    /* JADX INFO: renamed from: trackDownIfNoMoveRunnable$lambda-0, reason: not valid java name */
    private static final void m1366trackDownIfNoMoveRunnable$lambda0(TickMarkSeekBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.onTrackDownIfNoMove();
    }

    private final void trackTouchEvent(MotionEvent r6) {
        int r0 = getCompatMinValue();
        int r1 = getMax() - r0;
        if (r1 > 0) goto L6;
        return;
    L6:
        if (isTouchAtTrackEdge(r6.getX()) == false) goto L11;
        if (toLogicalTrackX(r6.getX()) > getTrackStartX()) goto L11;
        float r2 = r0;
    L17:
        if (isDebugLogEnabled() == false) goto L20;
        com.obric.oui.c.a.b.b(TAG, "[track-touch][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r6.getX() + ", logicalX=" + toLogicalTrackX(r6.getX()) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", newProgress=" + r2 + ", minValue=" + r0 + ", max=" + getMax() + ", touchOffset=" + getMTouchProgressOffset()));
    L20:
        toggleProgressChangedAnim$default(this, r2, null, 2, null);
        return;
    L11:
        if (isTouchAtTrackEdge(r6.getX()) == true) goto L13;
    L15:
        float r3 = this.mTouchProgressOffset + (calculateScaleByX(r6.getX()) * r1);
        float r4 = r0;
        r2 = RangesKt.coerceIn(r3 + r4, r4, getMax());
        goto L17
    L13:
        if (toLogicalTrackX(r6.getX()) < getTrackEndX()) goto L15;
        r2 = getMax();
        goto L17
    }

    private final void updateTouchProgressOffsetOnDown(float r7) {
        int r0 = getCompatMinValue();
        int r1 = getMax() - r0;
        if (r1 > 0) goto L6;
        this.mTouchProgressOffset = 0.0f;
        return;
    L6:
        float r2 = calculateScaleByX(r7);
        this.mTouchProgressOffset = getCurrentProgress() - ((r1 * r2) + r0);
        if (isDebugLogEnabled() == false) goto L11;
        com.obric.oui.c.a.b.b(TAG, "[touch-offset-update][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("downX=" + r7 + ", scale=" + r2 + ", minValue=" + r0 + ", range=" + r1 + ", currentProgress=" + getCurrentProgress() + ", touchOffset=" + getMTouchProgressOffset()));
        return;
    }

    public final boolean getEnableMoveThumbOnDownOutside() {
        return this.enableMoveThumbOnDownOutside;
    }

    public final float getMTouchProgressOffset() {
        return this.mTouchProgressOffset;
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "dr");
        super.invalidateDrawable(r2);
    }

    public final boolean isDebugLogEnabled() {
        if (this.debugLogEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (globalDebugLogEnabled == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "canvas");     // Catch: Throwable -> L9
        if (this.isFirstFrame == false) goto L6;
        this.isFirstFrame = false;     // Catch: Throwable -> L9
        setCurrentProgress(getProgress());     // Catch: Throwable -> L9
    L6:
        drawBackground(r2);     // Catch: Throwable -> L9
        drawTickMark(r2);     // Catch: Throwable -> L9
        drawProgress(r2);     // Catch: Throwable -> L9
        drawThumb(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(this.measureHeightPx, 1073741824));
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent r24) {
        MotionEvent r1 = r24;
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        String r9 = "action=";
        if (isDebugLogEnabled() == false) goto L22;
        StringBuilder r2 = new StringBuilder().append('[').append("touch-enter").append("][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r7 = new StringBuilder().append("action=");
        a r8 = Companion;
        if (r1 != null) goto L11;
        int r3 = -1;
    L12:
        StringBuilder r4 = r7.append(a.a(r8, r3)).append(", x=");
        if (r1 != null) goto L15;
        Float r10 = null;
    L16:
        StringBuilder r5 = r4.append(r10).append(", y=");
        if (r1 != null) goto L19;
        Float r11 = null;
    L20:
        com.obric.oui.c.a.b.b(TAG, r2.append(r5.append(r11).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", isPress=").append(this.isPress).append(", isInternalUpdating=").append(this.isInternalUpdating).append(", touchOffset=").append(getMTouchProgressOffset()).toString()).toString());
        goto L22
    L19:
        r11 = Float.valueOf(r24.getY());
        goto L20
    L15:
        r10 = Float.valueOf(r24.getX());
        goto L16
    L11:
        r3 = r24.getActionMasked();
    L22:
        if (this.isInternalUpdating == true) goto L24;
        int r6 = (int) (((int) this.paddingHorizontal) + (this.thumbSize / 2));
        setPadding(r6, 0, r6, 0);
        if (r1 != null) goto L36;
        Integer r12 = null;
    L37:
        if (r1 != null) goto L39;
        Integer r13 = null;
    L41:
        if (r13 == null) goto L51;
        if (r13.intValue() != 0) goto L51;
        cancelPendingDownTrack();
        this.mTouchProgressOffset = 0.0f;
        this.touchDownX = r24.getX();
        this.touchDownY = r24.getY();
        this.hasDirectionLocked = false;
        this.isDraggingHorizontally = false;
        if (isDebugLogEnabled() == false) goto L51;
        com.obric.oui.c.a.b.b(TAG, "[touch-down-init][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r24.getX() + ", y=" + r24.getY() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", thumbCenter=" + currentThumbCenterX()));
    L51:
        if (r12 != null) goto L54;
    L55:
        if (r12 != null) goto L58;
    L60:
        this.isPress = false;
        this.isThumbOnTouchDown = false;
        this.isThumbOnTouchEvent = false;
        cancelPendingDownTrack();
        invalidate();
        r13 = r13;
        r9 = "action=";
        boolean r14 = false;
    L152:
        MotionEvent r15 = obtainTouchEventForNativeProgress(r24);
        if (r15 != null) goto L155;
        MotionEvent r16 = r1;
    L156:
        boolean r17 = super.onTouchEvent(r16);
        if (isDebugLogEnabled() == true) goto L159;
        String r18 = r9;
    L172:
        if (r15 == null) goto L176;
        r15.recycle();
        Unit r19 = Unit.INSTANCE;
    L176:
        if (this.isInternalUpdating == false) goto L178;
        cancelTouchByInternalUpdate(r24);
        boolean r20 = true;
    L179:
        if (r1 == null) goto L216;
        int r21 = r24.getAction();
        if (this.isInternalUpdating == true) goto L215;
        if (r21 == 0) goto L193;
        if (r21 != 2) goto L196;
        if (this.isThumbOnTouchDown == false) goto L190;
    L194:
        trackTouchEvent(r24);
        goto L196
    L190:
        if (this.isDraggingHorizontally == true) goto L194;
    L196:
        if (r21 == 1) goto L201;
        if (r21 != 3) goto L215;
    L201:
        if (isDebugLogEnabled() == false) goto L205;
        com.obric.oui.c.a.b.b(TAG, "[touch-finish][" + Integer.toHexString(System.identityHashCode(this)) + "] " + (r18 + a.a(Companion, r21) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", isStyleSegmented=" + this.isStyleSegmented + ", touchOffset=" + getMTouchProgressOffset()));
    L205:
        if (r21 == 1) goto L207;
    L214:
        resetTouchTrackingState();
        goto L215
    L207:
        if (this.isStyleSegmented == false) goto L209;
        anchorPoint();
    L210:
        b r22 = this.onSeekBarChangeListenerExt;
        if (r22 == null) goto L214;
        r22.a((SeekBar) ZeusTransformUtils.preCheckCast(this, SeekBar.class, "com.obric.memorydata.plugin"), toRealValue(getProgress()));
        Unit r23 = Unit.INSTANCE;
        goto L214
    L209:
        toggleProgressChangedAnim$default(this, getProgress(), null, 2, null);
        goto L210
    L193:
        if (this.isThumbOnTouchDown == false) goto L196;
    L215:
        Unit r25 = Unit.INSTANCE;
        Unit r26 = Unit.INSTANCE;
    L216:
        this.isInternalUpdating = false;
        setPadding(0, 0, 0, 0);
        if (isDebugLogEnabled() == false) goto L224;
        StringBuilder r27 = new StringBuilder().append('[').append("touch-exit").append("][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r28 = new StringBuilder().append(r18);
        a r29 = Companion;
        if (r13 != null) goto L222;
        int r30 = -1;
    L223:
        com.obric.oui.c.a.b.b(TAG, r27.append(r28.append(a.a(r29, r30)).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", forceBreakTouch=").append(r20).toString()).toString());
        goto L224
    L222:
        r30 = r13.intValue();
    L224:
        if (r20 == false) goto L227;
        return false;
    L227:
        return r17;
    L178:
        r20 = r14;
        goto L179
    L159:
        StringBuilder r31 = new StringBuilder().append('[').append("touch-super-result").append("][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        if (r15 != null) goto L162;
        MotionEvent r32 = r1;
    L163:
        r18 = r9;
        StringBuilder r33 = new StringBuilder().append(r18);
        a r110 = Companion;
        if (r32 != null) goto L166;
        int r34 = -1;
    L167:
        StringBuilder r35 = r33.append(a.a(r110, r34)).append(", usedCorrectedEvent=");
        if (r15 == null) goto L170;
        boolean r36 = true;
    L171:
        com.obric.oui.c.a.b.b(TAG, r31.append(r35.append(r36).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", result=").append(r17).toString()).toString());
        goto L172
    L170:
        r36 = false;
        goto L171
    L166:
        r34 = r32.getActionMasked();
        goto L167
    L162:
        r32 = r15;
        goto L163
    L155:
        r16 = r15;
        goto L156
    L58:
        if (r12.intValue() != 2) goto L60;
    L61:
        this.isPress = true;
        float r37 = currentThumbCenterX();
        float r38 = this.thumbSize;
        float r39 = (r37 - (r38 / 2.0f)) - 30.0f;
        float r40 = (r37 + (r38 / 2.0f)) + 30.0f;
        if (getEnableMoveThumbOnDownOutside() == false) goto L78;
        float r41 = r24.getX();
        if (r39 <= r41) goto L66;
    L68:
        boolean r42 = false;
    L69:
        if (r42 == false) goto L78;
        this.isThumbOnTouchEvent = true;
        if (isDebugLogEnabled() == false) goto L78;
        StringBuilder r43 = new StringBuilder().append('[').append("thumb-hit-area").append("][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r44 = new StringBuilder().append("action=");
        a r45 = Companion;
        if (r13 != null) goto L76;
        int r46 = -1;
    L77:
        com.obric.oui.c.a.b.b(TAG, r43.append(r44.append(a.a(r45, r46)).append(", x=").append(r24.getX()).append(", thumbLeft=").append(r39).append(", thumbRight=").append(r40).toString()).toString());
    L79:
        if (r12 != null) goto L82;
    L119:
        r1 = r24;
        r14 = false;
    L120:
        if (r13 == null) goto L145;
        if (r13.intValue() != 2) goto L145;
        if (this.hasDirectionLocked == true) goto L145;
        float r47 = Math.abs(r24.getX() - this.touchDownX);
        float r48 = Math.abs(r24.getY() - this.touchDownY);
        if (r47 <= getTouchSlop()) goto L129;
    L130:
        this.hasDirectionLocked = true;
        if (r47 <= r48) goto L133;
        boolean r49 = true;
    L134:
        this.isDraggingHorizontally = r49;
        cancelPendingDownTrack();
        if (isDebugLogEnabled() == false) goto L139;
        com.obric.oui.c.a.b.b(TAG, "[direction-lock][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("dx=" + r47 + ", dy=" + r48 + ", touchSlop=" + getTouchSlop() + ", isDraggingHorizontally=" + this.isDraggingHorizontally + ", isThumbOnTouchDown=" + this.isThumbOnTouchDown));
    L139:
        if (this.isDraggingHorizontally == false) goto L142;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L145
    L142:
        if (this.isThumbOnTouchDown == true) goto L145;
        this.hasDirectionLocked = false;
        this.touchDownX = r24.getX();
        this.touchDownY = r24.getY();
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L145
    L133:
        r49 = false;
        goto L134
    L129:
        if (r48 > getTouchSlop()) goto L130;
    L145:
        if (this.isThumbOnTouchDown == false) goto L147;
    L150:
        boolean r50 = true;
    L151:
        toggleThumbScaleAnim(r50);
        invalidate();
        goto L152
    L147:
        if (this.isThumbOnTouchEvent == true) goto L150;
        r50 = false;
        goto L151
    L82:
        if (r12.intValue() != 0) goto L119;
        float r51 = r24.getX();
        if (r39 <= r51) goto L86;
    L88:
        boolean r52 = false;
    L89:
        if (r52 == false) goto L99;
        this.isThumbOnTouchDown = true;
        updateTouchProgressOffsetOnDown(r24.getX());
        getParent().requestDisallowInterceptTouchEvent(true);
        b r53 = this.onSeekBarChangeListenerExt;
        if (r53 == null) goto L95;
        r53.c((SeekBar) ZeusTransformUtils.preCheckCast(this, SeekBar.class, "com.obric.memorydata.plugin"));
        Unit r54 = Unit.INSTANCE;
    L95:
        if (isDebugLogEnabled() == false) goto L105;
        com.obric.oui.c.a.b.b(TAG, "[touch-down-thumb][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r24.getX() + ", offset=" + getMTouchProgressOffset() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress()));
    L105:
        r1 = r24;
        r14 = false;
    L106:
        if (r14 == true) goto L120;
        if (getEnableMoveThumbOnDownOutside() == false) goto L120;
        if (this.isThumbOnTouchDown == true) goto L120;
        this.mTouchProgressOffset = 0.0f;
        b r55 = this.onSeekBarChangeListenerExt;
        if (r55 == null) goto L115;
        r55.c((SeekBar) ZeusTransformUtils.preCheckCast(this, SeekBar.class, "com.obric.memorydata.plugin"));
        Unit r56 = Unit.INSTANCE;
    L115:
        this.pendingDownTrackEvent = MotionEvent.obtain(r24);
        postDelayed(this.trackDownIfNoMoveRunnable, 150);
        if (isDebugLogEnabled() == false) goto L120;
        com.obric.oui.c.a.b.b(TAG, "[delayed-track-schedule][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r24.getX() + ", y=" + r24.getY() + ", delayMs=150"));
        goto L120
    L99:
        if (getEnableMoveThumbOnDownOutside() == true) goto L105;
        this.isPress = false;
        this.isThumbOnTouchDown = false;
        this.isThumbOnTouchEvent = false;
        r1 = r24;
        r1.setAction(1);
        if (isDebugLogEnabled() == false) goto L104;
        com.obric.oui.c.a.b.b(TAG, "[touch-down-outside-break][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r24.getX() + ", enableMoveThumbOnDownOutside=" + getEnableMoveThumbOnDownOutside()));
    L104:
        r14 = true;
        goto L106
    L86:
        if (r51 > r40) goto L88;
        r52 = true;
        goto L89
    L76:
        r46 = r13.intValue();
        goto L77
    L66:
        if (r41 > r40) goto L68;
        r42 = true;
    L78:
        r13 = r13;
        goto L79
    L54:
        if (r12.intValue() == 0) goto L61;
    L39:
        r13 = Integer.valueOf(r24.getActionMasked());
        goto L41
    L36:
        r12 = Integer.valueOf(r24.getAction());
        goto L37
    L24:
        if (isDebugLogEnabled() == false) goto L31;
        StringBuilder r57 = new StringBuilder().append('[').append("touch-break-internal-update").append("][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r58 = new StringBuilder().append("action=");
        a r59 = Companion;
        if (r1 != null) goto L29;
        int r60 = -1;
    L30:
        com.obric.oui.c.a.b.b(TAG, r57.append(r58.append(a.a(r59, r60)).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).toString()).toString());
        goto L31
    L29:
        r60 = r24.getActionMasked();
    L31:
        cancelTouchByInternalUpdate(r24);
        return false;
    }

    public final void setBackgroundHeight(float r1) {
        this.backgroundHeight = r1;
        invalidate();
    }

    public final void setDebugLogEnabled(boolean r3) {
        this.debugLogEnabled = r3;
        if (isDebugLogEnabled() == false) goto L7;
        com.obric.oui.c.a.b.b(TAG, "[config][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("instanceDebug=" + r3 + ", globalDebug=" + globalDebugLogEnabled));
        return;
    }

    public void setDefaultTickMarkCount(int r1) {
        this.tickMarkCount = r1;
        this.mCurrentTickIndex = -1;
        invalidate();
    }

    public final void setEnableMoveThumbOnDownOutside(boolean r1) {
        this.enableMoveThumbOnDownOutside = r1;
    }

    public final void setIsSegmented(boolean r1, int r2, int r3) {
        this.isStyleSegmented = r1;
        if (r1 == false) goto L5;
        setProgressDrawable(null);
        this.mCurrentTickIndex = r3;
        this.tickMarkCount = r2;
        setProgress(resolveSegmentedProgressByIndex(r3));
    L6:
        anchorPoint();
        invalidate();
        return;
    L5:
        this.tickMarkCount = -1;
        this.mCurrentTickIndex = -1;
        goto L6
    }

    public final void setMTouchProgressOffset(float r1) {
        this.mTouchProgressOffset = r1;
    }

    public final void setMaxVisibleProgress(int r1) {
        this.maxVisibleProgress = r1;
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setMinVisibleProgress(int r1) {
        this.minVisibleProgress = r1;
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(b r3) {
        this.onSeekBarChangeListenerExt = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        super.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) ZeusTransformUtils.preCheckCast(new c(this), SeekBar.OnSeekBarChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public final void setProcessBackgroundColor(int r4) {
        this.mBackgroundColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        invalidate();
    }

    public final void setProcessBackgroundColorInt(int r1) {
        this.mBackgroundColor = r1;
        invalidate();
    }

    public final void setProcessColor(int r4, int r5) {
        this.progressColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        this.mBackgroundColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
        invalidate();
    }

    public final void setProcessColorInt(int r1, int r2) {
        this.progressColor = r1;
        this.mBackgroundColor = r2;
        invalidate();
    }

    public final void setProcessProgressColor(int r4) {
        this.progressColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        invalidate();
    }

    public final void setProcessProgressColorInt(int r1) {
        this.progressColor = r1;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r4) {
        super.setProgress(r4);
        if (isDebugLogEnabled() == false) goto L6;
        com.obric.oui.c.a.b.b(TAG, "[setProgress][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("progress=" + r4 + ", isPress=" + this.isPress + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.currentTargetProgress));
    L6:
        this.isThumbOnTouchDown = true;
        if (this.isPress == false) goto L9;
        this.isInternalUpdating = true;
    L9:
        toggleProgressChangedAnim$default(this, r4, null, 2, null);
        this.isThumbOnTouchDown = false;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r4, boolean r5) {
        super.setProgress(r4, r5);
        if (isDebugLogEnabled() == false) goto L7;
        com.obric.oui.c.a.b.b(TAG, "[setProgressWithAnimate][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("progress=" + r4 + ", animate=" + r5 + ", isPress=" + this.isPress + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.currentTargetProgress));
    L7:
        if (r5 == true) goto L10;
        this.isThumbOnTouchDown = true;
    L10:
        if (this.isPress == false) goto L12;
        this.isInternalUpdating = true;
    L12:
        toggleProgressChangedAnim$default(this, r4, null, 2, null);
        this.isThumbOnTouchDown = false;
    }

    public final void setThumbColor(int r4) {
        this.thumbColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        invalidate();
    }

    public final void setThumbColorInt(int r1) {
        this.thumbColor = r1;
        invalidate();
    }

    public final void setTickColor(int r4) {
        this.tickColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        invalidate();
    }

    public final void setTickColorInt(int r1) {
        this.tickColor = r1;
        invalidate();
    }

    public final void toggleThumbScaleAnim(boolean r8) {
        if (this.isPressThumb != r8) goto L5;
        return;
    L5:
        this.isPressThumb = r8;
        d r0 = this.thumbAnimator;
        if (r0 == null) goto L9;
        d.a(r0, false, 1, null);
    L9:
        com.obric.common.oea.foundation.animation.builder.c.a r1 = new com.obric.common.oea.foundation.animation.builder.c.a();
        float r3 = this.thumbScale;
        if (r8 == false) goto L12;
        float r9 = this.thumbPressScale;
    L13:
        this.thumbAnimator = r1.a(r3, r9, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), Float.valueOf(this.thumbScaleVelocity)).a((Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function3.class, "com.obric.memorydata.plugin")).a().a();
        return;
    L12:
        r9 = this.thumbNormalScale;
        goto L13
    }
}
