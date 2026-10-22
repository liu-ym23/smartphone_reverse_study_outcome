package com.larksuite.component.universe_design.timepicker.impl.base;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import e18.e;
import e18.f;
import h18.d;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u0000 ²\u00012\u00020\u0001:\u0006°\u0001±\u0001²\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010a\u001a\u00020b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010c\u001a\u00020bH\u0002J0\u0010d\u001a\u00020b2\u0006\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020!2\u0006\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u00020!H\u0014J\b\u0010j\u001a\u00020bH\u0002J\b\u0010k\u001a\u00020\u001eH\u0014J\b\u0010l\u001a\u00020\u001eH\u0014J\b\u0010m\u001a\u00020bH\u0002J\b\u0010n\u001a\u00020bH\u0002J\u000e\u0010o\u001a\u00020b2\u0006\u0010p\u001a\u00020qJ\u000e\u0010r\u001a\u00020b2\u0006\u0010s\u001a\u00020\u001eJ\u0006\u0010t\u001a\u00020bJ\u0006\u0010u\u001a\u00020bJ\u0006\u0010y\u001a\u00020bJ\u0010\u0010z\u001a\u00020b2\u0006\u0010{\u001a\u00020|H\u0014J.\u0010}\u001a\u00020b2\u0006\u0010{\u001a\u00020|2\u0006\u0010~\u001a\u00020\u001e2\u000e\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170RH\u0002¢\u0006\u0003\u0010\u0080\u0001J+\u0010\u0081\u0001\u001a\u00020\u001e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00162\u000e\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170RH\u0002¢\u0006\u0003\u0010\u0082\u0001J\u001d\u0010\u0083\u0001\u001a\u00020b2\u0007\u0010\u0084\u0001\u001a\u00020\u001e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020b2\u0006\u0010{\u001a\u00020|H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u001e2\u0007\u0010\u008a\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020!H\u0002J\u0014\u0010\u008d\u0001\u001a\u00020J2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u008f\u0001\u001a\u00020b2\u0006\u0010@\u001a\u00020!2\u0007\u0010\u0090\u0001\u001a\u00020!H\u0014J\u0013\u0010\u0091\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0010\u0010\u0094\u0001\u001a\u00020b2\u0007\u0010\u0095\u0001\u001a\u00020\u001eJ\"\u0010\u0096\u0001\u001a\u00020!2\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00162\u0007\u0010\u0097\u0001\u001a\u00020!H\u0002J\u0013\u0010\u0098\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020bH\u0014J\u0010\u0010\u009c\u0001\u001a\u00020b2\u0007\u0010\u009d\u0001\u001a\u00020!J\u0010\u0010\u009e\u0001\u001a\u00020b2\u0007\u0010\u009f\u0001\u001a\u00020,J\u0010\u0010 \u0001\u001a\u00020b2\u0007\u0010¡\u0001\u001a\u00020,J\u0010\u0010¢\u0001\u001a\u00020b2\u0007\u0010£\u0001\u001a\u00020(J\u0010\u0010¤\u0001\u001a\u00020b2\u0007\u0010¥\u0001\u001a\u00020\u001eJ\u0010\u0010¦\u0001\u001a\u00020b2\u0007\u0010¥\u0001\u001a\u00020\u001eJ\u0012\u0010§\u0001\u001a\u00020b2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\\J\u0011\u0010©\u0001\u001a\u00020b2\b\u0010I\u001a\u0004\u0018\u00010JJ\u000f\u0010ª\u0001\u001a\u00020b2\u0006\u0010)\u001a\u00020!J\u000f\u0010«\u0001\u001a\u00020b2\u0006\u0010*\u001a\u00020!J\u0011\u0010¬\u0001\u001a\u00020b2\b\u0010C\u001a\u0004\u0018\u00010DJ\u0012\u0010\u00ad\u0001\u001a\u00020b2\t\u0010®\u0001\u001a\u0004\u0018\u00010YJ\u000f\u0010¯\u0001\u001a\u00020b2\u0006\u0010P\u001a\u00020!R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00162\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001a\u00105\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u000e\u0010=\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170RX\u0084\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010v\u001a\u00020!2\u0006\u0010v\u001a\u00020!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u00107\"\u0004\bx\u00109R\u0016\u0010\u0087\u0001\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010$R\u0013\u0010\u009a\u0001\u001a\u00020!8F¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u00107¨\u0006³\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "wheelHandler", "Landroid/os/Handler;", "getWheelHandler", "()Landroid/os/Handler;", "setWheelHandler", "(Landroid/os/Handler;)V", "mExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "paintCenterText", "Landroid/text/TextPaint;", "paintIndicator", "Landroid/graphics/Paint;", "value", "Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;", "", "adapter", "getAdapter", "()Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;", "setAdapter", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;)V", "textSize", "", "outTextSize", "maxTextHeight", "", "itemHeight", "getItemHeight", "()F", "setItemHeight", "(F)V", "typeface", "Landroid/graphics/Typeface;", "textColorCenter", "dividerColor", "isLoop", "", "()Z", "setLoop", "(Z)V", "firstLineY", "secondLineY", "totalScrollY", "getTotalScrollY", "setTotalScrollY", "initPosition", "getInitPosition", "()I", "setInitPosition", "(I)V", "preCurrentIndex", "getPreCurrentIndex", "setPreCurrentIndex", "itemsVisible", "wheelMeasuredHeight", "wheelMeasuredWidth", "widthMeasureSpec", "mLastDownTime", "", "dividerType", "Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$DividerType;", "gestureDetector", "Landroid/view/GestureDetector;", "mFuture", "Ljava/util/concurrent/ScheduledFuture;", "label", "", "selectedItemIndex", "mOffset", "mLastDownEventY", "mShowTwoFigure", "mScaledVerticalScrollFactor", "dividerExtraStart", "mVisibleItems", "", "getMVisibleItems", "()[Ljava/lang/Object;", "setMVisibleItems", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "mLoopChangeListener", "Lcom/larksuite/component/universe_design/timepicker/impl/base/ILoopChangeListener;", "isScrollChangeDrawn", "itemSelectedListener", "Lcom/larksuite/component/universe_design/timepicker/impl/base/OnItemSelectedListener;", "getItemSelectedListener", "()Lcom/larksuite/component/universe_design/timepicker/impl/base/OnItemSelectedListener;", "setItemSelectedListener", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/OnItemSelectedListener;)V", "initView", "", "initPaints", "onLayout", "changed", "left", "top", "right", "bottom", "initializeFadingEdges", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "remeasure", "measureTextWidthHeight", "smoothScroll", "action", "Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$ACTION;", "scrollBy", "velocityY", "cancelFuture", "selectCurrentItem", "currentItem", "getCurrentItem", "setCurrentItem", "onItemSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawWheelContent", "itemHeightOffset", "visibleItems", "(Landroid/graphics/Canvas;F[Ljava/lang/Object;)V", "updateVisibleItems", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;[Ljava/lang/Object;)F", "updateSelectedItem", "itemCenterY", "visibleItem", "drawDivider", "centerTextBaseLine", "getCenterTextBaseLine", "getScaleTextSize", "translateY", "getLoopMappingIndex", "index", "getContentText", "item", "onMeasure", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "checkLoopChange", "scrollDy", "calculateLoopNextIndex", "nextCurrentIndex", "onGenericMotionEvent", "onDetachedFromWindow", "itemsCount", "getItemsCount", "setItemVisible", "itemVisible", "setShowTwoFigure", "showTwoFigure", "setCyclic", "cyclic", "setTypeface", "font", "setTextSize", "dpSize", "setTextSizeOuter", "setOnItemSelectedListener", "onItemSelectedListener", "setLabel", "setTextColorCenter", "setDividerColor", "setDividerType", "setLoopChangeListener", "listener", "setDividerExtraStart", "ACTION", "DividerType", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class WheelView extends View {
    public static final a Companion = null;
    public static final float DEFAULT_WHEEL_CENTER_TEXT_SIZE_DP = 17.0f;
    public static final float DEFAULT_WHEEL_OUTER_TEXT_SIZE_DP = 14.0f;
    private static final int IGNORE_SCROLL_OFFSET_THRESHOLD = 10;
    private static final String TAG = "WheelView";
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 1.0f;
    private static final int VELOCITY_FLING = 5;
    public static final int WHEEL_ITEM_HEIGHT = 48;
    private e18.a<? extends Object> adapter;
    private int dividerColor;
    private int dividerExtraStart;
    private DividerType dividerType;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private int initPosition;
    private boolean isLoop;
    private boolean isScrollChangeDrawn;
    private float itemHeight;
    private OnItemSelectedListener itemSelectedListener;
    private int itemsVisible;
    private String label;
    private final ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private float mLastDownEventY;
    private long mLastDownTime;
    private e18.b mLoopChangeListener;
    private float mOffset;
    private final float mScaledVerticalScrollFactor;
    private boolean mShowTwoFigure;
    private Object[] mVisibleItems;
    private int maxTextHeight;
    private float outTextSize;
    private TextPaint paintCenterText;
    private Paint paintIndicator;
    private int preCurrentIndex;
    private float secondLineY;
    private int selectedItemIndex;
    private int textColorCenter;
    private float textSize;
    private float totalScrollY;
    private Typeface typeface;
    public Handler wheelHandler;
    private int wheelMeasuredHeight;
    private int wheelMeasuredWidth;
    private int widthMeasureSpec;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$ACTION;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK", "FLING", "DAGGLE", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;
        public static final /* synthetic */ ACTION[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ACTION> getEntries() {
            return b;
        }

        static {
            ACTION r0 = new ACTION("CLICK", 0);
            CLICK = r0;
            ACTION r1 = new ACTION("FLING", 1);
            FLING = r1;
            ACTION r3 = new ACTION("DAGGLE", 2);
            DAGGLE = r3;
            ACTION[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ACTION[] values() {
            return (ACTION[]) a.clone();
        }

        public static ACTION valueOf(String r1) {
            return (ACTION) r27.a.a(ACTION.class, r1);
        }

        public ACTION(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$DividerType;", "", "<init>", "(Ljava/lang/String;I)V", "FILL", "EXTRA", "NONE", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DividerType extends Enum<DividerType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DividerType[] $VALUES = null;
        public static final DividerType EXTRA = null;
        public static final DividerType FILL = null;
        public static final DividerType NONE = null;

        private static final /* synthetic */ DividerType[] $values() {
            return new DividerType[]{FILL, EXTRA, NONE};
        }

        public static EnumEntries<DividerType> getEntries() {
            return $ENTRIES;
        }

        static {
            FILL = new DividerType("FILL", 0);
            EXTRA = new DividerType("EXTRA", 1);
            NONE = new DividerType("NONE", 2);
            DividerType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static DividerType[] values() {
            return (DividerType[]) $VALUES.clone();
        }

        public static DividerType valueOf(String r1) {
            return (DividerType) r27.a.a(DividerType.class, r1);
        }

        private DividerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WheelView a;

        public b(WheelView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e18.b r0 = WheelView.access$getMLoopChangeListener$p(this.a);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ OnItemSelectedListener a;
        public final /* synthetic */ WheelView b;

        public c(OnItemSelectedListener r1, WheelView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onItemSelected(this.b.getCurrentItem());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public WheelView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AttributeSet r0 = null;
        this(r3, r0, 2, r0);
    }

    private final void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength((int) this.firstLineY);
    }

    public final synchronized void cancelFuture() {
        monitor-enter(this);
        ScheduledFuture<?> r0 = this.mFuture;     // Catch: Throwable -> L17
        if (r0 == null) goto L15;
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == true) goto L15;
        ScheduledFuture<?> r2 = this.mFuture;     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        r2.cancel(true);     // Catch: Throwable -> L17
    L14:
        this.mFuture = null;     // Catch: Throwable -> L17
        goto L15
    L8:
        if (r0.isCancelled() != true) goto L10;
        r1 = true;
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return TOP_AND_BOTTOM_FADING_EDGE_STRENGTH;
    }

    private final float getCenterTextBaseLine() {
        TextPaint r0 = this.paintCenterText;
        if (r0 == null) goto L9;
        Paint.FontMetrics r1 = r0.getFontMetrics();
        if (r1 == null) goto L11;
        float r2 = r1.bottom;
        return ((r2 - r1.top) / 2) - r2;
    L11:
        return 0.0f;
    L9:
        return 0.0f;
    }

    private final void initPaints() {
        TextPaint r0 = new TextPaint();
        r0.setColor(this.textColorCenter);
        r0.setAntiAlias(true);
        r0.setTypeface(this.typeface);
        r0.setTextSize(r0.getTextSize());
        r0.setTextAlign(Paint.Align.CENTER);
        this.paintCenterText = r0;
        Paint r1 = new Paint();
        r1.setColor(this.dividerColor);
        r1.setAntiAlias(true);
        this.paintIndicator = r1;
    }

    private final void measureTextWidthHeight() {
        TextPaint r0 = this.paintCenterText;
        if (r0 == null) goto L5;
        r0.setTextSize(this.textSize);
    L5:
        Rect r1 = new Rect();
        TextPaint r2 = this.paintCenterText;
        if (r2 == null) goto L8;
        r2.getTextBounds("星期", 0, 2, r1);
    L8:
        this.maxTextHeight = r1.height() + 2;
    }

    private final void remeasure() {
        if (this.adapter != null) goto L5;
        return;
    L5:
        measureTextWidthHeight();
        float r0 = d.b(getContext(), 48);
        this.itemHeight = r0;
        this.wheelMeasuredHeight = (int) (r0 * (this.itemsVisible - 2));
        this.wheelMeasuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        int r1 = this.wheelMeasuredHeight;
        float r2 = this.itemHeight;
        this.firstLineY = (r1 - r2) / 2.0f;
        this.secondLineY = (r1 + r2) / 2.0f;
        if (this.initPosition != (-1)) goto L14;
        e18.a<? extends Object> r3 = this.adapter;
        if (this.isLoop == false) goto L11;
        if (r3 == null) goto L11;
        int r4 = (r3.getItemsCount() + 1) / 2;
    L12:
        this.initPosition = r4;
        this.preCurrentIndex = r4;
        return;
    L11:
        r4 = 0;
        goto L12
    }

    public final int getItemsCount() {
        e18.a<? extends Object> r0 = this.adapter;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getItemsCount();
    }

    public final Handler getWheelHandler() {
        Handler r0 = this.wheelHandler;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("wheelHandler");
        return null;
    }

    public final void onItemSelected() {
        OnItemSelectedListener r0 = this.itemSelectedListener;
        if (r0 == null) goto L6;
        post(new c(r0, this));
        return;
    }

    public final void selectCurrentItem() {
        OnItemSelectedListener r0 = this.itemSelectedListener;
        if (r0 == null) goto L6;
        r0.onItemSelected(getCurrentItem());
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelFuture();
    }

    public final e18.a<? extends Object> getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        return this.selectedItemIndex;
    }

    public final int getInitPosition() {
        return this.initPosition;
    }

    public final float getItemHeight() {
        return this.itemHeight;
    }

    public final OnItemSelectedListener getItemSelectedListener() {
        return this.itemSelectedListener;
    }

    public final Object[] getMVisibleItems() {
        return this.mVisibleItems;
    }

    public final int getPreCurrentIndex() {
        return this.preCurrentIndex;
    }

    public final float getTotalScrollY() {
        return this.totalScrollY;
    }

    public final boolean isLoop() {
        return this.isLoop;
    }

    public static final /* synthetic */ e18.b access$getMLoopChangeListener$p(WheelView r0) {
        return r0.mLoopChangeListener;
    }

    private final void drawDivider(Canvas r10) {
        Paint r6 = this.paintIndicator;
        if (r6 != null) goto L5;
        return;
    L5:
        DividerType r0 = this.dividerType;
        if (r0 != DividerType.EXTRA) goto L16;
        float r1 = this.dividerExtraStart;
        int r2 = this.wheelMeasuredWidth;
        if (r1 <= r2) goto L10;
    L13:
        float r7 = 0.0f;
    L14:
        float r8 = r2 - r7;
        float r4 = this.firstLineY;
        float r3 = r7;
        r10.drawLine(r3, r4, r8, r4, r6);
        float r5 = this.secondLineY;
        r10.drawLine(r3, r5, r8, r5, r6);
        return;
    L10:
        if (r1 < 0.0f) goto L13;
        r7 = r1;
        goto L14
    L16:
        if (r0 != DividerType.FILL) goto L20;
        float r9 = this.firstLineY;
        r10.drawLine(0.0f, r9, this.wheelMeasuredWidth, r9, r6);
        float r11 = this.secondLineY;
        r10.drawLine(0.0f, r11, this.wheelMeasuredWidth, r11, r6);
        return;
    }

    private final String getContentText(Object r5) {
        if (r5 != null) goto L6;
        return "";
    L6:
        if ((r5 instanceof e18.c) == false) goto L10;
        return ((e18.c) r5).a();
    L10:
        if ((r5 instanceof Integer) == false) goto L16;
        if (this.mShowTwoFigure == false) goto L16;
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{r5}, 1));
    L16:
        return r5.toString();
    }

    private final int getLoopMappingIndex(int r4) {
        e18.a<? extends Object> r0 = this.adapter;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.getItemsCount() > 0) goto L8;
        return 0;
    L8:
        if (r4 >= 0) goto L11;
        return getLoopMappingIndex(r4 + r0.getItemsCount());
    L11:
        if (r4 > (r0.getItemsCount() - 1)) goto L13;
        return r4;
    L13:
        return getLoopMappingIndex(r4 - r0.getItemsCount());
    }

    private final float getScaleTextSize(float r5) {
        float r0 = this.textSize;
        return Math.min(Math.max(r0 - (Math.abs(r5 - (this.wheelMeasuredHeight / 2.0f)) * ((r0 - this.outTextSize) / this.itemHeight)), this.outTextSize), this.textSize);
    }

    private final void initView(Context r3) {
        setWheelHandler(new com.larksuite.component.universe_design.timepicker.impl.base.a(this));
        GestureDetector r0 = new GestureDetector(r3, new e(this));
        this.gestureDetector = r0;
        r0.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    public final void checkLoopChange(float r7) {
        e18.a<? extends Object> r0 = this.adapter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.isLoop == true) goto L8;
        return;
    L8:
        if (this.mLoopChangeListener == null) goto L36;
        int r2 = this.initPosition + (((int) (this.totalScrollY / this.itemHeight)) % r0.getItemsCount());
        float r1 = this.totalScrollY % this.itemHeight;
        if (Math.abs(r1) > (this.itemHeight - 10)) goto L13;
    L16:
        int r3 = calculateLoopNextIndex(r0, r2);
        boolean r4 = true;
        if (r7 <= 0.0f) goto L22;
        if (r3 < this.preCurrentIndex) goto L25;
    L24:
        r4 = false;
    L25:
        if (r4 == true) goto L27;
        return;
    L27:
        if (this.mLoopChangeListener != null) goto L29;
        return;
    L29:
        if (this.isScrollChangeDrawn == true) goto L31;
        return;
    L31:
        this.isScrollChangeDrawn = false;
        post(new b(this));
        return;
    L22:
        if (r3 <= this.preCurrentIndex) goto L24;
    L13:
        if (r1 <= 0.0f) goto L15;
        r2 = r2 + 1;
        goto L16
    L15:
        r2 = r2 - 1;
        goto L16
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        e18.a<? extends Object> r0 = this.adapter;
        if (r0 != null) goto L5;
        return;
    L5:
        Object[] r1 = this.mVisibleItems;
        float r2 = updateVisibleItems(r0, r1);
        drawDivider(r3);
        drawWheelContent(r3, r2, r1);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r15) {
        Intrinsics.checkNotNullParameter(r15, "event");
        GestureDetector r0 = this.gestureDetector;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r0 = null;
    L5:
        boolean r1 = r0.onTouchEvent(r15);
        if (r15.isFromSource(2) == true) goto L8;
    L28:
        invalidate();
        return super.onGenericMotionEvent(r15);
    L8:
        if (r15.getAction() != 8) goto L28;
        float r2 = (-r15.getAxisValue(9)) * this.mScaledVerticalScrollFactor;
        this.totalScrollY += r2;
        e18.a<? extends Object> r3 = this.adapter;
        if (this.isLoop == true) goto L24;
        if (r3 == null) goto L24;
        float r4 = (-this.initPosition) * this.itemHeight;
        float r5 = (r3.getItemsCount() - 1) - this.initPosition;
        float r6 = this.itemHeight;
        float r7 = r5 * r6;
        float r8 = this.totalScrollY;
        if ((((double) r8) - (((double) r6) * 0.25d)) >= r4) goto L16;
        r4 = r8 - r2;
    L19:
        if (r8 >= r4) goto L22;
        this.totalScrollY = r4;
        goto L24
    L22:
        if (r8 <= r7) goto L24;
        this.totalScrollY = r7;
        goto L24
    L16:
        if ((((double) r8) + (((double) r6) * 0.25d)) <= r7) goto L19;
        r7 = r8 - r2;
    L24:
        checkLoopChange(r2);
        if (r1 == true) goto L28;
        smoothScroll(ACTION.DAGGLE);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        GestureDetector r0 = this.gestureDetector;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r0 = null;
    L5:
        boolean r1 = r0.onTouchEvent(r13);
        int r2 = r13.getAction();
        if (r2 != 0) goto L8;
        this.mLastDownTime = System.currentTimeMillis();
        cancelFuture();
        this.mLastDownEventY = r13.getRawY();
    L38:
        invalidate();
        return true;
    L8:
        if (r2 == 2) goto L21;
        if (r1 == true) goto L38;
        float r14 = r13.getY();
        float r3 = this.itemHeight;
        int r15 = (int) (r14 / r3);
        if (Math.abs(this.totalScrollY % r3) >= 10.0f) goto L13;
        float r4 = 0.0f;
    L17:
        this.mOffset = ((r15 - ((this.itemsVisible - 2) / 2)) * this.itemHeight) + r4;
        if ((System.currentTimeMillis() - this.mLastDownTime) <= 120) goto L20;
        smoothScroll(ACTION.DAGGLE);
        goto L38
    L20:
        smoothScroll(ACTION.CLICK);
        goto L38
    L13:
        float r5 = this.totalScrollY;
        float r6 = this.itemHeight;
        float r7 = ((r5 % r6) + r6) % r6;
        if (r7 <= (r6 / 2.0f)) goto L16;
        r4 = r6 - r7;
        goto L17
    L16:
        r4 = -r7;
        goto L17
    L21:
        float r8 = this.mLastDownEventY - r13.getRawY();
        this.mLastDownEventY = r13.getRawY();
        this.totalScrollY += r8;
        e18.a<? extends Object> r16 = this.adapter;
        if (this.isLoop == true) goto L36;
        if (r16 == null) goto L36;
        float r9 = (-this.initPosition) * this.itemHeight;
        float r17 = (r16.getItemsCount() - 1) - this.initPosition;
        float r10 = this.itemHeight;
        float r19 = r17 * r10;
        float r11 = this.totalScrollY;
        if ((((double) r11) - (((double) r10) * 0.25d)) >= r9) goto L28;
        r9 = r11 - r8;
    L31:
        if (r11 >= r9) goto L34;
        this.totalScrollY = r9;
        goto L36
    L34:
        if (r11 <= r19) goto L36;
        this.totalScrollY = r19;
        goto L36
    L28:
        if ((((double) r11) + (((double) r10) * 0.25d)) <= r19) goto L31;
        r19 = r11 - r8;
    L36:
        checkLoopChange(r8);
        goto L38
    }

    public final void scrollBy(float r8) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new e18.d(this, r8), 0, 5, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(e18.a<? extends Object> r1) {
        this.adapter = r1;
        invalidate();
    }

    public final void setCurrentItem(int r1) {
        this.selectedItemIndex = r1;
        this.initPosition = r1;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r1) {
        this.isLoop = r1;
    }

    public final void setDividerColor(int r2) {
        if (r2 == 0) goto L7;
        this.dividerColor = r2;
        Paint r0 = this.paintIndicator;
        if (r0 == null) goto L8;
        r0.setColor(r2);
        return;
    L8:
        return;
    }

    public final void setDividerExtraStart(int r1) {
        this.dividerExtraStart = r1;
    }

    public final void setDividerType(DividerType r1) {
        this.dividerType = r1;
    }

    public final void setInitPosition(int r1) {
        this.initPosition = r1;
    }

    public final void setItemHeight(float r1) {
        this.itemHeight = r1;
    }

    public final void setItemSelectedListener(OnItemSelectedListener r1) {
        this.itemSelectedListener = r1;
    }

    public final void setItemVisible(int r2) {
        if (r2 == this.itemsVisible) goto L5;
        this.mVisibleItems = new Object[r2];
    L5:
        this.itemsVisible = r2;
        requestLayout();
    }

    public final void setLabel(String r1) {
        this.label = r1;
    }

    public final void setLoop(boolean r1) {
        this.isLoop = r1;
    }

    public final void setLoopChangeListener(e18.b r1) {
        this.mLoopChangeListener = r1;
    }

    public final void setMVisibleItems(Object[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mVisibleItems = r2;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener r1) {
        this.itemSelectedListener = r1;
    }

    public final void setPreCurrentIndex(int r1) {
        this.preCurrentIndex = r1;
    }

    public final void setShowTwoFigure(boolean r1) {
        this.mShowTwoFigure = r1;
    }

    public final void setTextColorCenter(int r2) {
        if (r2 == 0) goto L7;
        this.textColorCenter = r2;
        TextPaint r0 = this.paintCenterText;
        if (r0 == null) goto L8;
        r0.setColor(r2);
        return;
    L8:
        return;
    }

    public final void setTextSize(float r2) {
        if (r2 > 0.0f) goto L5;
        return;
    L5:
        float r3 = d.a(getContext(), r2);
        this.textSize = r3;
        TextPaint r0 = this.paintCenterText;
        if (r0 == null) goto L9;
        r0.setTextSize(r3);
        return;
    }

    public final void setTextSizeOuter(float r2) {
        if (r2 > 0.0f) goto L5;
        return;
    L5:
        this.outTextSize = d.a(getContext(), r2);
    }

    public final void setTotalScrollY(float r1) {
        this.totalScrollY = r1;
    }

    public final void setTypeface(Typeface r2) {
        Intrinsics.checkNotNullParameter(r2, "font");
        this.typeface = r2;
        TextPaint r0 = this.paintCenterText;
        if (r0 == null) goto L6;
        r0.setTypeface(r2);
        return;
    }

    public final void setWheelHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.wheelHandler = r2;
    }

    public final void smoothScroll(ACTION r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        cancelFuture();
        if (r9 != ACTION.FLING) goto L5;
    L6:
        float r10 = this.totalScrollY;
        float r0 = this.itemHeight;
        float r11 = ((r10 % r0) + r0) % r0;
        this.mOffset = r11;
        if (r11 <= (r0 / 2.0f)) goto L9;
        float r1 = r0 - r11;
    L10:
        this.mOffset = r1;
    L11:
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new f(this, this.mOffset), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        r1 = -r11;
        goto L10
    L5:
        if (r9 != ACTION.DAGGLE) goto L11;
        goto L6
    }

    public WheelView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.mExecutor = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("ase/WheelView"));
        this.typeface = h18.e.a(r6);
        this.itemsVisible = 5;
        this.mVisibleItems = new Object[5];
        this.isScrollChangeDrawn = true;
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(ViewConfiguration.get(r6), r6);
        this.textSize = d.a(r6, 17.0f);
        this.outTextSize = d.a(r6, 14.0f);
        this.dividerColor = r6.getResources().getColor(2131103351);
        this.textColorCenter = r6.getResources().getColor(2131106622);
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{R.attr.fontFamily, 2130974985, 2130974986, 2130974987}, 0, 0);
        this.textColorCenter = r8.getColor(2, this.textColorCenter);
        this.dividerColor = r8.getColor(1, this.dividerColor);
        this.textSize = r8.getDimensionPixelOffset(3, (int) this.textSize);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "typedArray");
        int r0 = r8.getResourceId(0, 0);
        if (r0 > 0) goto L12;
        Typeface r1 = Typeface.DEFAULT;
    L8:
        if (r1 != null) goto L10;
        r1 = Typeface.DEFAULT;
    L10:
        this.typeface = r1;
        r8.recycle();
        initView(r6);
        return;
    L12:
        r1 = ResourcesCompat.getFont(r6, r0);     // Catch: Resources.NotFoundException -> L6
    L6:
        r1 = Typeface.DEFAULT;
        goto L8
    }

    private final int calculateLoopNextIndex(e18.a<? extends Object> r2, int r3) {
        if (r3 >= 0) goto L5;
        r3 = r3 + r2.getItemsCount();
    L5:
        if (r3 > (r2.getItemsCount() - 1)) goto L7;
        return r3;
    L7:
        return r3 - r2.getItemsCount();
    }

    private final void updateSelectedItem(float r7, Object r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        e18.a<? extends Object> r0 = this.adapter;
        if (r0 != null) goto L7;
        return;
    L7:
        float r1 = this.firstLineY;
        if (r7 > r1) goto L14;
        int r3 = this.maxTextHeight;
        if (((r3 / 2.0f) + r7) < r1) goto L14;
        if ((r1 - r7) >= ((r7 + r3) - r1)) goto L27;
        this.selectedItemIndex = r0.a(r8);
        return;
    L27:
        return;
    L14:
        float r4 = this.secondLineY;
        if (r7 > r4) goto L21;
        int r5 = this.maxTextHeight;
        if (((r5 / 2.0f) + r7) < r4) goto L21;
        if ((r4 - r7) <= ((r7 + r5) - r4)) goto L29;
        this.selectedItemIndex = r0.a(r8);
        return;
    L29:
        return;
    L21:
        int r6 = this.maxTextHeight;
        if (r7 >= (r1 + (r6 / 2.0f))) goto L24;
        return;
    L24:
        if (((r6 / 2.0f) + r7) > r4) goto L32;
        this.selectedItemIndex = r0.a(r8);
        return;
    }

    private final float updateVisibleItems(e18.a<?> r7, Object[] r8) {
        int r1 = 0;
        if (this.initPosition >= 0) goto L6;
        this.initPosition = 0;
    L6:
        if (this.initPosition < r7.getItemsCount()) goto L47;
        this.initPosition = r7.getItemsCount() - 1;
    L47:
        this.preCurrentIndex = this.initPosition + (((int) (this.totalScrollY / this.itemHeight)) % r7.getItemsCount());     // Catch: ArithmeticException -> L11
    L12:
        float r0 = this.totalScrollY % this.itemHeight;
        float r2 = Math.abs(r0);
        float r4 = this.itemHeight;
        if (r2 <= (r4 - 10)) goto L19;
        if (r0 <= 0.0f) goto L17;
        this.preCurrentIndex++;
        r0 = -(r4 - Math.abs(r0));
        goto L19
    L17:
        this.preCurrentIndex--;
        r0 = r4 - Math.abs(r0);
    L19:
        if (this.isLoop == false) goto L21;
        int r3 = this.preCurrentIndex;
        if (r3 >= 0) goto L30;
        this.preCurrentIndex = r3 + r7.getItemsCount();
    L30:
        if (this.preCurrentIndex <= (r7.getItemsCount() - 1)) goto L32;
        this.preCurrentIndex -= r7.getItemsCount();
    L32:
        this.isScrollChangeDrawn = true;
    L33:
        int r5 = this.itemsVisible;
        if (r1 >= r5) goto L46;
        int r6 = this.preCurrentIndex - ((r5 / 2) - r1);
        if (this.isLoop == false) goto L39;
        r8[r1] = r7.getItem(getLoopMappingIndex(r6));
    L45:
        r1 = r1 + 1;
        goto L33
    L39:
        if (r6 >= 0) goto L42;
        r8[r1] = "";
        goto L45
    L42:
        if (r6 <= (r7.getItemsCount() - 1)) goto L44;
        r8[r1] = "";
        goto L45
    L44:
        r8[r1] = r7.getItem(r6);
        goto L45
    L46:
        return r0;
    L21:
        if (this.preCurrentIndex >= 0) goto L24;
        this.preCurrentIndex = 0;
    L24:
        if (this.preCurrentIndex <= (r7.getItemsCount() - 1)) goto L32;
        this.preCurrentIndex = r7.getItemsCount() - 1;
        goto L32
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        this.widthMeasureSpec = r1;
        remeasure();
        setMeasuredDimension(this.wheelMeasuredWidth, this.wheelMeasuredHeight);
    }

    private final void drawWheelContent(Canvas r10, float r11, Object[] r12) {
        TextPaint r0 = this.paintCenterText;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.itemsVisible;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L18;
        if (Math.abs(r11) >= 5.0f) goto L13;
        if (r2 == 0) goto L17;
        if (r2 != (this.itemsVisible - 1)) goto L13;
    L17:
        r2 = r2 + 1;
    L13:
        float r3 = this.itemHeight;
        float r4 = (((r2 - 1) * r3) - r11) + (r3 / 2.0f);
        Object r5 = r12[r2];
        String r6 = getContentText(r5);
        if (TextUtils.isEmpty(this.label) == true) goto L16;
        r6 = r6 + this.label;
    L16:
        r0.setTextSize(getScaleTextSize(r4));
        r10.drawText(TextUtils.ellipsize(r6, r0, this.wheelMeasuredWidth, TextUtils.TruncateAt.END).toString(), this.wheelMeasuredWidth / 2.0f, getCenterTextBaseLine() + r4, r0);
        updateSelectedItem(r4, r5);
        r0.setTextSize(this.textSize);
        goto L17
    }

    public /* synthetic */ WheelView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (r1 == false) goto L5;
        initializeFadingEdges();
        return;
    }
}
