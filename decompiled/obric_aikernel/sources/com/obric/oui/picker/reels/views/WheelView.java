package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u009b\u0001B#\b\u0007\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u0012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J!\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0015\u0010\"\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!R*\u0010'\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u001cR$\u0010;\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR*\u0010@\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001a\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010\u001eR$\u0010C\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001eR$\u0010G\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR*\u0010K\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u001a\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u001eR\u001d\u0010P\u001a\u00020L8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010*\u001a\u0004\bN\u0010OR*\u0010T\u001a\u00020.2\u0006\u0010Q\u001a\u00020.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00100\u001a\u0004\b\u0019\u00102\"\u0004\bS\u00104R*\u0010Y\u001a\u00020.2\u0006\u0010U\u001a\u00020.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bV\u00100\u001a\u0004\bW\u00102\"\u0004\bX\u00104R\u001d\u0010\\\u001a\u00020L8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010*\u001a\u0004\b[\u0010OR.\u0010d\u001a\u0004\u0018\u00010\u00022\b\u0010]\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010h\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u00100\u001a\u0004\bf\u00102\"\u0004\bg\u00104R\u001d\u0010k\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010*\u001a\u0004\bj\u0010,R\u0013\u0010m\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bl\u0010\u001cR$\u0010s\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\u001cR*\u0010z\u001a\u00020\u00022\u0006\u0010v\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010\u001a\u001a\u0004\bx\u0010\u001c\"\u0004\by\u0010\u001eR\"\u0010~\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u00100\u001a\u0004\b|\u00102\"\u0004\b}\u00104R-\u0010\u0082\u0001\u001a\u00020\u00022\u0006\u0010v\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010\u001a\u001a\u0005\b\u0080\u0001\u0010\u001c\"\u0005\b\u0081\u0001\u0010\u001eR \u0010\u0085\u0001\u001a\u00020L8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010*\u001a\u0005\b\u0084\u0001\u0010OR'\u0010\u0088\u0001\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010p\"\u0005\b\u0087\u0001\u0010rR'\u0010\u008b\u0001\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010\u001c\"\u0005\b\u008a\u0001\u0010\u001eR&\u0010\u008f\u0001\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u00100\u001a\u0005\b\u008d\u0001\u00102\"\u0005\b\u008e\u0001\u00104R\"\u0010\u0094\u0001\u001a\u00030\u0090\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010*\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/view/View;", "", "getClipMiddleRectTop", "getClipMiddleRectBottom", "", "", "entries", "", "setEntries", "([Ljava/lang/String;)V", "", "", "tag", "setTagText", "", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Lcom/obric/oui/picker/reels/views/a;", "onWheelChangedListener", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/a;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/a;)V", "width", "i", "I", "getItemWidthPx", "()I", "setItemWidthPx", "(I)V", "itemWidthPx", "getCurrentItem", "()Ljava/lang/String;", "currentItem", CommonConsts.COUNT_TYPE, "h", "getItemCount", "setItemCount", "itemCount", "Landroid/graphics/Paint;", "s", "Lkotlin/Lazy;", "getMHighlightPaint", "()Landroid/graphics/Paint;", "mHighlightPaint", "", "B", "Z", "getShowTopRightCorner", "()Z", "setShowTopRightCorner", "(Z)V", "showTopRightCorner", "getWheelHeight", "wheelHeight", TypedValues.Custom.S_COLOR, "getHighlightColor", "setHighlightColor", "highlightColor", "radius", "y", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "highlightConorRadiusPx", "getSelectedTextColor", "setSelectedTextColor", "selectedTextColor", "index", "getCurrentIndex", "setCurrentIndex", "currentIndex", "g", "getStartIndex", "setStartIndex", "startIndex", "Landroid/text/TextPaint;", "p", "getMTagTextPaint", "()Landroid/text/TextPaint;", "mTagTextPaint", "cyclic", "z", "setCyclic", "isCyclic", "isShow", "c", "getShowDivider", "setShowDivider", "showDivider", "q", "getMSelectedTextPaint", "mSelectedTextPaint", EventBody.KEY_VALUE, "w", "Ljava/lang/Integer;", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "tagGap", "D", "getShowBottomRightCorner", "setShowBottomRightCorner", "showBottomRightCorner", "r", "getMDividerPaint", "mDividerPaint", "getItemSize", "itemSize", "size", "getSelectedTextSizePx", "()F", "setSelectedTextSizePx", "(F)V", "selectedTextSizePx", "getWheelWidth", "wheelWidth", "height", "j", "getItemHeightPx", "setItemHeightPx", "itemHeightPx", "A", "getShowTopLeftCorner", "setShowTopLeftCorner", "showTopLeftCorner", "k", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "selectedItemHeightPx", "o", "getMTextPaint", "mTextPaint", "getTextSizePx", "setTextSizePx", "textSizePx", "getTextColor", "setTextColor", "textColor", "C", "getShowBottomLeftCorner", "setShowBottomLeftCorner", "showBottomLeftCorner", "Lcom/obric/oui/picker/reels/views/c;", "t", "getMScroller", "()Lcom/obric/oui/picker/reels/views/c;", "mScroller", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class WheelView extends View {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7012c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Rect f7018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Rect f7019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Rect f7020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f7021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f7022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f7023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f7024r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f7025s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f7026t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final List<String> f7027u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CharSequence f7028v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Integer f7029w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f7030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7031y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f7032z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public WheelView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public WheelView(final Context r24, AttributeSet r25) {
        Intrinsics.checkNotNullParameter(r24, "context");
        super(r24, r25);
        this.f7014h = 5;
        float r10 = 343;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        this.f7015i = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()));
        float r12 = 40;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.f7016j = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.f7017k = MathKt.roundToInt(TypedValue.applyDimension(1, 48, r14.getDisplayMetrics()));
        this.f7021o = LazyKt.lazy(WheelView$mTextPaint$2.INSTANCE);
        this.f7022p = LazyKt.lazy(WheelView$mTagTextPaint$2.INSTANCE);
        this.f7023q = LazyKt.lazy(WheelView$mSelectedTextPaint$2.INSTANCE);
        this.f7024r = LazyKt.lazy(WheelView$mDividerPaint$2.INSTANCE);
        this.f7025s = LazyKt.lazy(WheelView$mHighlightPaint$2.INSTANCE);
        this.f7026t = LazyKt.lazy(new WheelView$mScroller$2(this, r24));
        this.f7027u = new ArrayList();
        float r15 = 8;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        this.f7031y = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r16.getDisplayMetrics()));
        TypedArray r17 = r24.obtainStyledAttributes(r25, l.OWheelView);
        Intrinsics.checkNotNullExpressionValue(r17, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r18 = r17.getBoolean(l.OWheelView_oui_wheelCyclic, false);
        int r19 = r17.getInt(l.OWheelView_oui_wheelStartIndex, 0);
        boolean r110 = r17.getBoolean(l.OWheelView_oui_wheelShowDivider, false);
        int r20 = r17.getInt(l.OWheelView_oui_wheelItemCount, 5);
        int r111 = l.OWheelView_oui_wheelItemWidth;
        Resources r112 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r112, "Resources.getSystem()");
        int r21 = r17.getDimensionPixelOffset(r111, MathKt.roundToInt(TypedValue.applyDimension(1, r10, r112.getDisplayMetrics())));
        int r113 = l.OWheelView_oui_wheelItemHeight;
        Resources r114 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
        int r115 = r17.getDimensionPixelOffset(r113, MathKt.roundToInt(TypedValue.applyDimension(1, r12, r114.getDisplayMetrics())));
        int r116 = l.OWheelView_oui_wheelTextSize;
        Resources r117 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r117, "Resources.getSystem()");
        int r118 = r17.getDimensionPixelSize(r116, MathKt.roundToInt(TypedValue.applyDimension(2, 18, r117.getDisplayMetrics())));
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        int r23 = r17.getDimensionPixelSize(r116, MathKt.roundToInt(TypedValue.applyDimension(2, 14, r22.getDisplayMetrics())));
        int r26 = r17.getColor(l.OWheelView_oui_wheelTextColor, ContextCompat.getColor(r24, v8.a.oui_basic_text_1));
        int r119 = r17.getColor(l.OWheelView_oui_wheelSelectedTextColor, ContextCompat.getColor(r24, v8.a.oui_accent_6_bg));
        int r120 = l.OWheelView_oui_wheelSelectedTextSize;
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        int r28 = r17.getDimensionPixelSize(r120, MathKt.roundToInt(TypedValue.applyDimension(2, 22, r27.getDisplayMetrics())));
        int r29 = r17.getColor(l.OWheelView_oui_wheelHighlightColor, ContextCompat.getColor(r24, v8.a.oui_fill_element_2));
        int r121 = l.OWheelView_oui_wheelHighlightConorRadius;
        Resources r122 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r122, "Resources.getSystem()");
        int r30 = r17.getDimensionPixelOffset(r121, MathKt.roundToInt(TypedValue.applyDimension(1, r15, r122.getDisplayMetrics())));
        CharSequence[] r31 = r17.getTextArray(l.OWheelView_oui_wheelEntries);
        if (r31 == null) goto L7;
        ArrayList r123 = new ArrayList(r31.length);
        int r124 = r31.length;
        int r32 = 0;
    L5:
        if (r32 >= r124) goto L8;
        CharSequence r210 = r31[r32];
        r123.add(r210.toString());
        r32 = r32 + 1;
    L8:
        r17.recycle();
        setCyclic(r18);
        setShowDivider(r110);
        setStartIndex(r19);
        setItemCount(r20);
        setItemWidthPx(r21);
        setItemHeightPx(r115);
        setHighlightConorRadiusPx(r30);
        TextPaint r33 = getMTextPaint();
        r33.setTextAlign(Paint.Align.CENTER);
        r33.setTextSize(r118);
        r33.setColor(r26);
        r33.setTypeface(Typeface.create(null, 400, false));
        TextPaint r34 = getMTagTextPaint();
        r34.setTextAlign(Paint.Align.LEFT);
        r34.setTextSize(r23);
        r34.setColor(r26);
        r34.setTypeface(Typeface.create(null, 480, false));
        TextPaint r35 = getMSelectedTextPaint();
        r35.setTextAlign(Paint.Align.CENTER);
        r35.setTextSize(r28);
        r35.setColor(r119);
        r35.setTypeface(Typeface.create(null, 500, false));
        Paint r36 = getMDividerPaint();
        Resources r37 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r37, "Resources.getSystem()");
        r36.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, r37.getDisplayMetrics()));
        r36.setColor(ContextCompat.getColor(r24, u8.c.LinePrimary));
        Paint r38 = getMHighlightPaint();
        r38.setStyle(Paint.Style.FILL);
        r38.setColor(r29);
        if (r123 != null) goto L11;
    L14:
        boolean r125 = true;
    L15:
        if (r125 == true) goto L17;
        setEntries(r123);
    L17:
        setVerticalFadingEdgeEnabled(true);
        Resources r39 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r39, "Resources.getSystem()");
        setFadingEdgeLength(MathKt.roundToInt(TypedValue.applyDimension(1, r12, r39.getDisplayMetrics())));
        return;
    L11:
        if (r123.isEmpty() == true) goto L14;
        r125 = false;
        goto L15
    L7:
        r123 = null;
        goto L8
    }

    public /* synthetic */ WheelView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final int a() {
        float r10 = this.f7030x;
        if (this.f7028v == null) goto L9;
        float r11 = getMTagTextPaint().measureText(String.valueOf(this.f7028v));
        Integer r12 = this.f7029w;
        if (r12 == null) goto L7;
        int r13 = r12.intValue();
    L8:
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        float r15 = 2 * ((r13 + r11) + MathKt.roundToInt(TypedValue.applyDimension(1, 16, r14.getDisplayMetrics())));
    L11:
        return Math.max((int) (r10 + r15), getMinimumWidth());
    L7:
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 2, r16.getDisplayMetrics()));
        goto L8
    L9:
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r15 = MathKt.roundToInt(TypedValue.applyDimension(1, 28, r17.getDisplayMetrics()));
        goto L11
    }

    private final void b(Canvas r10) {
        if (this.f7012c == true) goto L5;
        return;
    L5:
        Rect r11 = this.f7019m;
        if (r11 == null) goto L9;
        float r12 = r11.left;
        int r13 = r11.top;
        r10.drawLine(r12, r13, r11.right, r13, getMDividerPaint());
        float r14 = r11.left;
        int r15 = r11.bottom;
        r10.drawLine(r14, r15, r11.right, r15, getMDividerPaint());
        return;
    }

    private final void c(Canvas r11, int r12, int r13) {
        String r10 = h(r12);
        if (r10 == null) goto L22;
        Rect r14 = this.f7019m;
        Intrinsics.checkNotNull(r14);
        int r15 = r14.centerX();
        Rect r16 = this.f7019m;
        Intrinsics.checkNotNull(r16);
        int r17 = r16.centerY();
        Paint.FontMetrics r18 = getMTextPaint().getFontMetrics();
        float r19 = r18.top + r18.bottom;
        float r20 = 2;
        int r21 = (int) (r19 / r20);
        Paint.FontMetrics r22 = getMSelectedTextPaint().getFontMetrics();
        int r23 = (int) ((r22.top + r22.bottom) / r20);
        int r110 = ((r12 - getMScroller().d()) * this.f7016j) - r13;
        float r111 = f(r110);
        int r24 = this.f7016j;
        if (1 > r110) goto L11;
        if (r24 <= r110) goto L11;
        r11.save();
        Rect r112 = this.f7019m;
        Intrinsics.checkNotNull(r112);
        r11.clipRect(r112);
        float r25 = r15;
        float r113 = r111 + r17;
        Canvas r26 = r11;
        String r27 = r10;
        float r28 = r25;
        r26.drawText(r27, 0, r10.length(), r28, r113 - r23, getMSelectedTextPaint());
        r11.restore();
        r11.save();
        Rect r114 = this.f7020n;
    L9:
        Intrinsics.checkNotNull(r114);
        r11.clipRect(r114);
        int r29 = 0;
        int r30 = r10.length();
        float r31 = r113 - r21;
        TextPaint r32 = getMTextPaint();
    L10:
        r26.drawText(r27, r29, r30, r28, r31, r32);
        r11.restore();
        return;
    L11:
        if (r110 < r24) goto L14;
        r11.save();
        Rect r115 = this.f7020n;
    L13:
        Intrinsics.checkNotNull(r115);
        r11.clipRect(r115);
        r29 = 0;
        r30 = r10.length();
        r28 = r15;
        r31 = (r17 + r111) - r21;
        r32 = getMTextPaint();
        r26 = r11;
        r27 = r10;
        goto L10
    L14:
        if (r110 < 0) goto L16;
    L18:
        int r33 = -r24;
        r11.save();
        if (r110 > r33) goto L21;
        r115 = this.f7018l;
        goto L13
    L21:
        Rect r116 = this.f7019m;
        Intrinsics.checkNotNull(r116);
        r11.clipRect(r116);
        r30 = r10.length();
        r28 = r15;
        r31 = (r17 + r111) - r23;
        r32 = getMSelectedTextPaint();
        r26 = r11;
        r27 = r10;
        r29 = 0;
        goto L10
    L16:
        if (r110 <= (-r24)) goto L18;
        r11.save();
        Rect r117 = this.f7019m;
        Intrinsics.checkNotNull(r117);
        r11.clipRect(r117);
        float r34 = r15;
        r113 = r111 + r17;
        r26 = r11;
        r27 = r10;
        r28 = r34;
        r26.drawText(r27, 0, r10.length(), r28, r113 - r23, getMSelectedTextPaint());
        r11.restore();
        r11.save();
        r114 = this.f7018l;
        goto L9
    }

    private final void d(Canvas r10) {
        int r11 = getMScroller().d();
        int r12 = getMScroller().e();
        int r13 = (this.f7014h + 1) / 2;
        int r14 = r11 - r13;
        if (r12 >= 0) goto L5;
        r14 = r14 - 1;
        int r15 = r11 + r13;
    L8:
        if (r14 >= r15) goto L10;
        c(r10, r14, r12);
        r14 = r14 + 1;
        goto L8
    L10:
        return;
    L5:
        r15 = r11 + r13;
        if (r12 <= 0) goto L8;
        r15 = r15 + 1;
        goto L8
    }

    private final void e(Canvas r10) {
        CharSequence r11 = this.f7028v;
        if (r11 == null) goto L10;
        Rect r12 = this.f7019m;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.centerY();
        Rect r14 = this.f7019m;
        Intrinsics.checkNotNull(r14);
        int r15 = r14.centerX();
        Paint.FontMetrics r16 = getMTagTextPaint().getFontMetrics();
        float r17 = r16.top + r16.bottom;
        float r18 = 2;
        int r19 = (int) (r17 / r18);
        Integer r20 = this.f7029w;
        if (r20 == null) goto L7;
        int r21 = r20.intValue();
    L8:
        r10.drawText(r11, 0, r11.length(), (r15 + (this.f7030x / r18)) + r21, r13 - r19, getMTagTextPaint());
        return;
    L7:
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        r21 = MathKt.roundToInt(TypedValue.applyDimension(1, r18, r22.getDisplayMetrics()));
        goto L8
    }

    private final float f(int r10) {
        int r11 = this.f7017k;
        int r12 = this.f7016j;
        float r13 = (r11 - r12) / 2.0f;
        if (r13 <= 0) goto L5;
        float r14 = r12;
        if (Math.abs(r10) <= r14) goto L11;
        float r15 = r10;
        return (Math.signum(r15) * r13) + r15;
    L11:
        return r10 * ((r13 / r14) + 1.0f);
    L5:
        return r10;
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.f7024r.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.f7025s.getValue();
    }

    private final c getMScroller() {
        return (c) this.f7026t.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.f7023q.getValue();
    }

    private final TextPaint getMTagTextPaint() {
        return (TextPaint) this.f7022p.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.f7021o.getValue();
    }

    private final int getWheelHeight() {
        return ((getPaddingTop() + getPaddingBottom()) + (this.f7016j * (this.f7014h - 1))) + this.f7017k;
    }

    private final int getWheelWidth() {
        return (getPaddingLeft() + getPaddingRight()) + this.f7015i;
    }

    private final String h(int r10) {
        int r11 = this.f7027u.size();
        if (r11 != 0) goto L6;
        return null;
    L6:
        if (this.f7032z == false) goto L11;
        r10 = r10 % r11;
        if (r10 >= 0) goto L15;
        r10 = r10 + r11;
    L15:
        return this.f7027u.get(r10);
    L11:
        if (r10 < 0) goto L17;
        if (r11 > r10) goto L15;
        return null;
    L17:
        return null;
    }

    public static /* synthetic */ void k(WheelView r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        r10.j(r11, r12);
    }

    private final void l() {
        int r10 = getPaddingLeft();
        int r11 = getMeasuredWidth() - getPaddingRight();
        int r12 = getPaddingTop();
        int r13 = getMeasuredHeight() - getPaddingBottom();
        int r14 = (r12 + r13) / 2;
        Rect r15 = new Rect();
        r15.left = r10;
        r15.right = r11;
        int r16 = this.f7017k;
        r15.top = r14 - (r16 / 2);
        r15.bottom = (r16 / 2) + r14;
        Unit r17 = Unit.INSTANCE;
        this.f7019m = r15;
        Rect r18 = new Rect();
        r18.left = r10;
        r18.right = r11;
        r18.top = r12;
        r18.bottom = r14 - (this.f7017k / 2);
        this.f7018l = r18;
        Rect r19 = new Rect();
        r19.left = r10;
        r19.right = r11;
        r19.top = r14 + (this.f7017k / 2);
        r19.bottom = r13;
        this.f7020n = r19;
    }

    @Override // android.view.View
    public void computeScroll() {
        getMScroller().a();
    }

    public final String g(int r10) {
        if (r10 >= 0) goto L7;
        if (r10 < this.f7027u.size()) goto L7;
        return null;
    L7:
        return this.f7027u.get(r10);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 1.0f;
    }

    public final int getClipMiddleRectBottom() {
        Rect r10 = this.f7019m;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r10 = this.f7019m;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.top;
    }

    public final int getCurrentIndex() {
        return getMScroller().c();
    }

    public final String getCurrentItem() {
        return g(getCurrentIndex());
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final int getHighlightConorRadiusPx() {
        return this.f7031y;
    }

    public final int getItemCount() {
        return this.f7014h;
    }

    public final int getItemHeightPx() {
        return this.f7016j;
    }

    public final int getItemSize() {
        return this.f7027u.size();
    }

    public final int getItemWidthPx() {
        return this.f7015i;
    }

    public final com.obric.oui.picker.reels.views.a getOnWheelChangedListener() {
        return getMScroller().f();
    }

    public final int getSelectedItemHeightPx() {
        return this.f7017k;
    }

    public final int getSelectedTextColor() {
        return getMSelectedTextPaint().getColor();
    }

    public final float getSelectedTextSizePx() {
        return getMSelectedTextPaint().getTextSize();
    }

    public final boolean getShowBottomLeftCorner() {
        return this.C;
    }

    public final boolean getShowBottomRightCorner() {
        return this.D;
    }

    public final boolean getShowDivider() {
        return this.f7012c;
    }

    public final boolean getShowTopLeftCorner() {
        return this.A;
    }

    public final boolean getShowTopRightCorner() {
        return this.B;
    }

    public final int getStartIndex() {
        return this.f7013g;
    }

    public final Integer getTagGap() {
        return this.f7029w;
    }

    public final int getTextColor() {
        return getMTextPaint().getColor();
    }

    public final float getTextSizePx() {
        return getMTextPaint().getTextSize();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 1.0f;
    }

    public final boolean i() {
        return this.f7032z;
    }

    public final void j(int r10, boolean r11) {
        getMScroller().n(r10, r11);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c r10 = getMScroller();
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        r10.k(r11);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        d(r10);
        b(r10);
        e(r10);
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        int r16 = a();
        if (r12 == Integer.MIN_VALUE) goto L6;
        if (r12 == 1073741824) goto L7;
        r13 = r16;
    L7:
        if (r14 == 1073741824) goto L10;
        r15 = getWheelHeight();
    L10:
        setMeasuredDimension(r13, r15);
        l();
        return;
    L6:
        r13 = Math.min(r16, r13);
        goto L7
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        return getMScroller().j(r10);
    }

    public final void setCurrentIndex(int r10) {
        k(this, r10, false, 2, null);
    }

    public final void setCyclic(boolean r10) {
        this.f7032z = r10;
        getMScroller().m();
        invalidate();
    }

    public final void setEntries(List<String> r10) {
        this.f7027u.clear();
        this.f7030x = 0.0f;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L14;
        this.f7027u.addAll(r10);
        Iterator<T> r12 = this.f7027u.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        this.f7030x = Math.max(this.f7030x, getMSelectedTextPaint().measureText((String) r12.next()));
    L14:
        getMScroller().m();
        k(this, this.f7013g, false, 2, null);
        requestLayout();
        return;
    L5:
        if (r10.isEmpty() == true) goto L8;
        r11 = false;
        goto L9
    }

    public final void setEntries(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "entries");
        setEntries(ArraysKt.toList(r10));
    }

    public final void setHighlightColor(int r10) {
        getMHighlightPaint().setColor(r10);
        invalidate();
    }

    public final void setHighlightConorRadiusPx(int r10) {
        this.f7031y = r10;
        invalidate();
    }

    public final void setItemCount(int r10) {
        this.f7014h = r10;
        invalidate();
    }

    public final void setItemHeightPx(int r10) {
        this.f7016j = r10;
        invalidate();
    }

    public final void setItemWidthPx(int r10) {
        this.f7015i = r10;
        invalidate();
    }

    public final void setOnWheelChangedListener(com.obric.oui.picker.reels.views.a r10) {
        getMScroller().o(r10);
    }

    public final void setSelectedItemHeightPx(int r10) {
        this.f7017k = r10;
        invalidate();
    }

    public final void setSelectedTextColor(int r10) {
        getMSelectedTextPaint().setColor(r10);
        invalidate();
    }

    public final void setSelectedTextSizePx(float r10) {
        getMSelectedTextPaint().setTextSize(r10);
        invalidate();
    }

    public final void setShowBottomLeftCorner(boolean r10) {
        this.C = r10;
    }

    public final void setShowBottomRightCorner(boolean r10) {
        this.D = r10;
    }

    public final void setShowDivider(boolean r10) {
        this.f7012c = r10;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r10) {
        this.A = r10;
    }

    public final void setShowTopRightCorner(boolean r10) {
        this.B = r10;
    }

    public final void setStartIndex(int r10) {
        this.f7013g = r10;
        getMScroller().n(r10, false);
    }

    public final void setTagGap(Integer r10) {
        this.f7029w = r10;
        invalidate();
    }

    public final void setTagText(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        if ((!StringsKt.isBlank(r10)) == false) goto L6;
        this.f7028v = r10;
        invalidate();
        return;
    }

    public final void setTextColor(int r10) {
        getMTextPaint().setColor(r10);
        invalidate();
    }

    public final void setTextSizePx(float r10) {
        getMTextPaint().setTextSize(r10);
        invalidate();
    }
}
