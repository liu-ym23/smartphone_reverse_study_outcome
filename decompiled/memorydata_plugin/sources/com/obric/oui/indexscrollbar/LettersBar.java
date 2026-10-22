package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.trace.TraceCons;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u008f\u00012\u00020\u0001:\u0006\u008f\u0001\u0090\u0001\u0091\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u00070Vj\b\u0012\u0004\u0012\u00020\u0007`WH\u0002J\u0010\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020ZH\u0016J(\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010b\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010c\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010d\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010e\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J\u0012\u0010f\u001a\u00020\u001f2\b\b\u0001\u0010g\u001a\u00020\u0007H\u0002J(\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00072\u0016\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u00070Vj\b\u0012\u0004\u0012\u00020\u0007`WH\u0002J\u0010\u0010k\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010l\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0002J\u0012\u0010o\u001a\u00020\\2\b\u0010p\u001a\u0004\u0018\u00010qH\u0014J\u0010\u0010r\u001a\u00020\\2\u0006\u0010^\u001a\u00020_H\u0014J\u0018\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0014J\b\u0010v\u001a\u00020\\H\u0002J\u001d\u0010w\u001a\u00020\\2\u0010\u0010x\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010.¢\u0006\u0002\u0010yJ\u0016\u0010z\u001a\u00020\\2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0007J\u0010\u0010}\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0016\u0010~\u001a\u00020\\2\u000e\u0010\u007f\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106J\u0012\u0010\u0080\u0001\u001a\u00020\\2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010:J\u0012\u0010\u0082\u0001\u001a\u00020\\2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010\u0083\u0001\u001a\u00020\\2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001J\u0010\u0010\u0087\u0001\u001a\u00020\\2\u0007\u0010\u0088\u0001\u001a\u00020\u0018J\u0010\u0010\u0089\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020\u0018J\u0011\u0010\u008b\u0001\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0007H\u0002J\u001b\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020\u001b2\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010'\"\u0004\bF\u0010)R\u001a\u0010G\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R\u0011\u0010J\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\fR\u001a\u0010L\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010'\"\u0004\bT\u0010)¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dismissPopupTask", "Ljava/lang/Runnable;", "getDismissPopupTask", "()Ljava/lang/Runnable;", "dotLetterTextSizePx", "", "downX", "getDownX", "()F", "setDownX", "(F)V", "downY", "getDownY", "setDownY", "isHolderState", "", "()Z", "lastPopupLetter", "", "mBackgroundChangeListener", "Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "mBitmapPaint", "Landroid/graphics/Paint;", "mChosenLetterIndex", "mContext", "mDotIcon", "Landroid/graphics/Bitmap;", "mDotIconX", "mHasChosenLetterFontColor", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "(I)V", "mHighlightIcon", "mHighlightIconHeight", "mHighlightIconStartX", "mIconsForSymbolsSelected", "", "[Landroid/graphics/Bitmap;", "mLetterBarHeight", "mLetterFontCenterX", "mLetterFontSize", "mLetterLocaleFontSize", "mLetterPaint", "mLetters", "", "Lcom/obric/oui/indexscrollbar/LBLetter;", "mLettersBarWidth", "mListener", "Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "mNoChosenLetterFontColor", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mPopupWindow", "Lcom/obric/oui/indexscrollbar/OIndexPopupWindowController;", "mScreenWidth", "mSettled", "mShowBg", "mSingleLetterMinHeight", "newChosen", "getNewChosen", "setNewChosen", "oldChosen", "getOldChosen", "setOldChosen", "showPopupTask", "getShowPopupTask", "showPopupTaskStartTime", "", "getShowPopupTaskStartTime", "()J", "setShowPopupTaskStartTime", "(J)V", "touchSlop", "getTouchSlop", "setTouchSlop", "calculateVisibleLettersIndexes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "drawDot", "", "index", "canvas", "Landroid/graphics/Canvas;", "xPos", "yPos", "drawHighlightBackground", "drawHighlightIcon", "drawLetter", "drawSymbol", "getBitmapTintPaint", "tintColor", "getSingleLetterHeight", "totalHeight", "visibleLetters", CommonConsts.APM_INNER_EVENT_COST_INIT, "isTouchedLetter", "measureHeight", "measureSpec", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDimensionCache", "setBitmapsSelected", "bitmaps", "([Landroid/graphics/Bitmap;)V", "setLetterFontColor", "hasChosenColor", "noChosenColor", "setLetterPaint", "setLetters", "letters", "setListener", "listener", "setOnBackgroundVisibleChangedListener", "setPopupWindowStyle", "textColor", TraceCons.METRIC_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "setSettled", "settled", "setShowBg", "showBg", "setTouchedLetter", "showPopupWindow", MemoryInfoSectionEditActivity.KIND_SCENE, "c", "Companion", "LBListener", "OnBackgroundVisibleChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LettersBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13894a = null;
    private float A;
    private String B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private final Runnable H;
    private final Runnable I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private long f13895J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f13896b;
    private List<com.obric.oui.indexscrollbar.b> c;
    private int d;
    private boolean e;
    private Bitmap[] f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final Paint m;
    private final Paint n;
    private Bitmap o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Bitmap t;
    private int u;
    private b v;
    private boolean w;
    private c x;
    private final d y;
    private int z;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$Companion;", "", "()V", "POPUP_CONTAINER_MARGIN_DP", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "", "onLetterChanged", "", "letter", "", "type", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        boolean a(String r1, int r2);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "", "OnBackgroundVisibleChanged", "", "visible", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(boolean r1);
    }

    static {
        f13894a = new a(null);
    }

    public LettersBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public LettersBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public LettersBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.d = -1;
        this.e = true;
        this.m = new Paint();
        Paint r0 = new Paint(1);
        r0.setFilterBitmap(true);
        r0.setDither(true);
        this.n = r0;
        this.y = new d(r6);
        a(r6);
        this.F = -1;
        this.G = -1;
        this.H = new $$Lambda$LettersBar$Rq9GqKrQWzASKC48OIxAtJrmhsc(this);
        this.I = new $$Lambda$LettersBar$8Riq8JTLW2lVCbysBk1dJzn2eA(this);
        this.f13895J = -1;
    }

    public /* synthetic */ LettersBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final float a(int r3, ArrayList<Integer> r4) {
        return (float) Math.max(r3 / r4.size(), this.h);
    }

    private final Paint a(int r4) {
        this.n.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.memorydata.plugin"));
        return this.n;
    }

    private final void a() {
        this.A = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10);
    }

    private final void a(int r5, Canvas r6, float r7, float r8) {
        if (c(r5) == true) goto L5;
        return;
    L5:
        if (this.e == false) goto L9;
        Paint r9 = new Paint();
        r9.setColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        int r10 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 14);
        h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 14);
        float r11 = r10 / 2.0f;
        int r4 = this.k;
        r6.drawRoundRect(new RectF(r4 - r11, r8 - r11, r4 + r11, r8 + r11), r11, r11, r9);
        return;
    }

    private final void a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.f13896b = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        a();
        Context r0 = this.f13896b;
        Intrinsics.checkNotNull(r0);
        Resources r1 = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin");
        this.h = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.letters_bar_single_letter_min_height, "dimen", "letters_bar_single_letter_min_height"));
        this.g = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 14);
        this.i = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.letters_bar_letter_font_size, "dimen", "letters_bar_letter_font_size"));
        this.j = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.letters_bar_letter_locale_font_size, "dimen", "letters_bar_letter_locale_font_size"));
        this.k = (this.g / 2) + getPaddingLeft();
        this.o = BitmapFactory.decodeResource(r1, ZeusTransformUtils.mapRes(R.drawable.letters_bar_highlight_icon, "drawable", "letters_bar_highlight_icon"));
        Drawable r2 = r1.getDrawable(ZeusTransformUtils.mapRes(R.drawable.letters_bar_highlight_icon, "drawable", "letters_bar_highlight_icon"));
        this.p = this.k - (r2.getIntrinsicWidth() / 2);
        this.q = r2.getIntrinsicHeight();
        this.r = r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        this.s = r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b"));
        Bitmap r3 = BitmapFactory.decodeResource(r1, ZeusTransformUtils.mapRes(R.drawable.letters_bar_dot, "drawable", "letters_bar_dot"));
        this.t = r3;
        int r4 = this.k;
        Intrinsics.checkNotNull(r3);
        this.u = r4 - (r3.getWidth() / 2);
        this.m.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.m.setTextSize(this.i);
        this.m.setAntiAlias(true);
        this.z = ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
    }

    private static final void a(LettersBar r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        int r0 = r4.F;
        int r1 = r4.G;
        if (r0 == r1) goto L11;
        if (r1 < 0) goto L11;
        List<com.obric.oui.indexscrollbar.b> r2 = r4.c;
        Intrinsics.checkNotNull(r2);
        if (r1 >= r2.size()) goto L11;
        r4.a("ACTION_DOWN", r4.G);
        b r3 = r4.v;
        if (r3 == null) goto L10;
        Intrinsics.checkNotNull(r3);
        List<com.obric.oui.indexscrollbar.b> r5 = r4.c;
        Intrinsics.checkNotNull(r5);
        r3.a(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r5.get(r4.G), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).a(), 1);
    L10:
        com.obric.oui.a.a.f13272a.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 26);
        r4.setTouchedLetter(r4.G);
    L11:
        r4.f13895J = -1;
    }

    private final void a(String r12, int r13) {
        float r0 = a(this.l, b());
        List<com.obric.oui.indexscrollbar.b> r1 = this.c;
        Intrinsics.checkNotNull(r1);
        String r2 = ((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r1.get(r13), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).a();
        if (Intrinsics.areEqual(r2, this.B) == false) goto L5;
        return;
    L5:
        com.obric.oui.c.a.b.b("LettersBar", "showPopupWindow, scene: " + r12 + ", c = " + r13 + ", letter = " + r2 + ", lastPopupLetter = " + this.B);
        Bitmap[] r14 = this.f;
        if (r14 != null) goto L8;
        Integer r15 = null;
    L9:
        List<com.obric.oui.indexscrollbar.b> r4 = this.c;
        Intrinsics.checkNotNull(r4);
        if (((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r4.get(r13), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).getType() != 2) goto L15;
        if (r15 == null) goto L15;
        if (Integer.parseInt(r2) > r15.intValue()) goto L15;
        Bitmap[] r16 = this.f;
        Intrinsics.checkNotNull(r16);
        Bitmap r7 = r16[Integer.parseInt(r2) - 1];
    L16:
        int r17 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_h_title_bar_window, "dimen", "oui_h_title_bar_window"));
        int r8 = (this.z - getWidth()) - h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 68);
        int r3 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r3 <= 0) goto L19;
        r17 = r17 + ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3);
    L19:
        int r10 = r17;
        int[] r18 = new int[2];
        getLocationInWindow(r18);
        this.y.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r2, r7, r8, (int) (((r18[1] + getPaddingTop()) + (r13 * r0)) + (r0 / 2)), r10);
        this.B = r2;
        return;
    L15:
        r7 = null;
        goto L16
    L8:
        r15 = Integer.valueOf(r14.length);
        goto L9
    }

    private final int b(int r2) {
        int r1 = View.MeasureSpec.getMode(r2);
        int r3 = View.MeasureSpec.getSize(r2);
        if (r1 != Integer.MIN_VALUE) goto L5;
        return r3;
    L5:
        if (r1 == 1073741824) goto L9;
        return 0;
    L9:
        return r3;
    }

    private final ArrayList<Integer> b() {
        ArrayList<Integer> r0 = new ArrayList();
        int r1 = this.l;
        List<com.obric.oui.indexscrollbar.b> r2 = this.c;
        Intrinsics.checkNotNull(r2);
        if ((r1 / r2.size()) >= this.h) goto L5;
        List<com.obric.oui.indexscrollbar.b> r4 = this.c;
        Intrinsics.checkNotNull(r4);
        int r3 = (int) Math.max(2.0d, ((int) Math.ceil(r4.size() / ((this.l / this.h) - 2))) * 2);
    L6:
        r0.add(0);
        List<com.obric.oui.indexscrollbar.b> r5 = this.c;
        Intrinsics.checkNotNull(r5);
        if (r3 >= (r5.size() / 2)) goto L12;
        int r6 = r3;
    L9:
        List<com.obric.oui.indexscrollbar.b> r7 = this.c;
        Intrinsics.checkNotNull(r7);
        if (r6 >= (r7.size() - 1)) goto L12;
        r0.add(Integer.valueOf(r6));
        r6 = r6 + r3;
    L12:
        List<com.obric.oui.indexscrollbar.b> r8 = this.c;
        Intrinsics.checkNotNull(r8);
        if (r3 >= r8.size()) goto L15;
        List<com.obric.oui.indexscrollbar.b> r9 = this.c;
        Intrinsics.checkNotNull(r9);
        r0.add(Integer.valueOf(r9.size() - 1));
    L15:
        return r0;
    L5:
        r3 = 1;
        goto L6
    }

    private final void b(int r5, Canvas r6, float r7, float r8) {
        List<com.obric.oui.indexscrollbar.b> r9 = this.c;
        if (r9 != null) goto L5;
        com.obric.oui.indexscrollbar.b r10 = null;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        Bitmap[] r11 = r10.b();
        if (r11 != null) goto L12;
        return;
    L12:
        if (c(r5) == true) goto L14;
    L16:
        boolean r12 = false;
    L18:
        if (c() == false) goto L20;
    L23:
        boolean r2 = true;
    L25:
        if (r12 == false) goto L27;
        Bitmap r0 = r11[2];
    L30:
        if (r0 != null) goto L34;
        r0 = r11[0];
        if (r0 != null) goto L34;
        return;
    L34:
        if (r12 == false) goto L36;
        int r13 = this.r;
    L37:
        r6.drawBitmap(r0, this.k - (r0.getWidth() / 2), r8 - (r0.getHeight() / 2), a(r13));
        return;
    L36:
        r13 = this.s;
        goto L37
    L27:
        if (r2 == false) goto L29;
        r0 = r11[1];
        goto L30
    L29:
        r0 = r11[0];
        goto L30
    L20:
        if (this.e == false) goto L23;
        r2 = false;
        goto L25
    L14:
        if (this.e == false) goto L16;
        r12 = true;
        goto L18
    L5:
        r10 = (com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r9, r5), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private static final void b(LettersBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.y.b() == false) goto L6;
        r1.y.a();
        r1.setTouchedLetter(-1);
        r1.setShowBg(false);
        return;
    }

    private final void c(int r6, Canvas r7, float r8, float r9) {
        List<com.obric.oui.indexscrollbar.b> r0 = this.c;
        Intrinsics.checkNotNull(r0);
        String r1 = ((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r0.get(r6), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).a();
        if (StringsKt.startsWith$default(r1, ".", false, 2, null) == false) goto L5;
        d(r6, r7, r8, r9);
        return;
    L5:
        Paint.FontMetricsInt r10 = this.m.getFontMetricsInt();
        r7.drawText(r1, r8, (r9 - ((r10.bottom - r10.top) / 2)) - r10.top, this.m);
    }

    private final boolean c() {
        if (this.d == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean c(int r1) {
        if (this.d != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final void d(int r2, Canvas r3, float r4, float r5) {
        Bitmap r6 = this.t;
        if (r6 == null) goto L7;
        r3.drawBitmap(r6, this.u, r5 - (r6.getHeight() / 2), a(this.m.getColor()));
        return;
    }

    /* JADX INFO: renamed from: lambda$8Riq8JTLW2lVC-bysBk1dJzn2eA, reason: not valid java name */
    public static /* synthetic */ void m1310lambda$8Riq8JTLW2lVCbysBk1dJzn2eA(LettersBar r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$Rq9GqKrQWzASKC48OIxAtJrmhsc(LettersBar r0) {
        a(r0);
    }

    private final void setLetterPaint(int r7) {
        if (c(r7) == false) goto L5;
        Paint r0 = this.m;
        int r1 = this.r;
    L6:
        r0.setColor(r1);
        this.m.setFakeBoldText(false);
        this.m.setTextSize(this.A);
        List<com.obric.oui.indexscrollbar.b> r2 = this.c;
        Intrinsics.checkNotNull(r2);
        if (StringsKt.startsWith$default(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r2.get(r7), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).a(), ".", false, 2, null) == true) goto L13;
        List<com.obric.oui.indexscrollbar.b> r3 = this.c;
        Intrinsics.checkNotNull(r3);
        if (((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r3.get(r7), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).getType() != 1) goto L11;
        this.m.setTextSize(this.j);
        this.m.setFakeBoldText(true);
        return;
    L11:
        this.m.setTextSize(this.i);
        return;
    L13:
        return;
    L5:
        r0 = this.m;
        r1 = this.s;
        goto L6
    }

    private final void setTouchedLetter(int r1) {
        this.d = r1;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        super.dispatchTouchEvent(r13);
        int r0 = r13.getAction();
        float r1 = r13.getY();
        this.F = this.d;
        float r2 = (r1 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<com.obric.oui.indexscrollbar.b> r3 = this.c;
        Intrinsics.checkNotNull(r3);
        int r4 = (int) (r2 * r3.size());
        this.G = r4;
        if (r0 != 0) goto L5;
        removeCallbacks(this.I);
        this.C = r13.getX();
        this.D = r13.getY();
        this.E = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        if (this.y.b() == true) goto L48;
        this.f13895J = System.currentTimeMillis();
        postDelayed(this.H, 200);
    L48:
        this.B = null;
    L49:
        setShowBg(false);
    L50:
        return true;
    L5:
        if (r0 != 1) goto L7;
        removeCallbacks(this.H);
        if ((System.currentTimeMillis() - this.f13895J) >= 100) goto L38;
        if (this.y.b() == true) goto L38;
        this.f13895J = -1;
        this.H.run();
        postDelayed(this.I, 200);
        return true;
    L38:
        if (this.y.b() == false) goto L40;
        removeCallbacks(this.I);
    L40:
        this.f13895J = -1;
        if (this.e == false) goto L43;
        this.y.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L44:
        invalidate();
        goto L50
    L43:
        this.y.a();
        goto L44
    L7:
        if (r0 == 2) goto L16;
        if (r0 != 3) goto L50;
        removeCallbacks(this.H);
        if (this.y.b() == false) goto L14;
        removeCallbacks(this.I);
    L14:
        this.f13895J = -1;
        this.y.a();
        setTouchedLetter(-1);
        goto L50
    L16:
        if (Math.sqrt(Math.pow(r13.getX() - this.C, 2.0d) + Math.pow(r13.getY() - this.D, 2.0d)) >= this.E) goto L19;
        return true;
    L19:
        if (this.y.b() == false) goto L49;
        if (r4 < 0) goto L49;
        List<com.obric.oui.indexscrollbar.b> r14 = this.c;
        Intrinsics.checkNotNull(r14);
        if (r4 >= r14.size()) goto L49;
        if (this.e == true) goto L26;
    L30:
        setTouchedLetter(r4);
        goto L49
    L26:
        if (this.F == r4) goto L30;
        if (this.v == null) goto L30;
        removeCallbacks(this.I);
        a("ACTION_MOVE", r4);
        com.obric.oui.a.a.f13272a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 26);
        b r15 = this.v;
        Intrinsics.checkNotNull(r15);
        List<com.obric.oui.indexscrollbar.b> r5 = this.c;
        Intrinsics.checkNotNull(r5);
        r15.a(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r5.get(r4), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).a(), 0);
        goto L30
    }

    public final Runnable getDismissPopupTask() {
        return this.I;
    }

    public final float getDownX() {
        return this.C;
    }

    public final float getDownY() {
        return this.D;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.r;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.s;
    }

    public final int getNewChosen() {
        return this.G;
    }

    public final int getOldChosen() {
        return this.F;
    }

    public final Runnable getShowPopupTask() {
        return this.H;
    }

    public final long getShowPopupTaskStartTime() {
        return this.f13895J;
    }

    public final int getTouchSlop() {
        return this.E;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        a();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        r11.save();
        r11.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r0 = b();
        float r1 = a(this.l, r0);
        Iterator<Integer> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "index");
        setLetterPaint(r4.intValue());
        float r5 = this.k;
        Paint r6 = this.m;
        List<com.obric.oui.indexscrollbar.b> r7 = this.c;
        Intrinsics.checkNotNull(r7);
        float r8 = 2;
        float r9 = r5 - (r6.measureText(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r7.get(r4.intValue()), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).a()) / r8);
        float r10 = (r3 * r1) + (r1 / r8);
        a(r4.intValue(), r11, r9, r10);
        List<com.obric.oui.indexscrollbar.b> r12 = this.c;
        Intrinsics.checkNotNull(r12);
        int r13 = ((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r12.get(r4.intValue()), com.obric.oui.indexscrollbar.b.class, "com.obric.memorydata.plugin")).getType();
        int r14 = r4.intValue();
        if (r13 != 2) goto L8;
        b(r14, r11, r9, r10);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        c(r14, r11, r9, r10);
        goto L9
    L10:
        r11.restore();
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.l = (b(r2) - getPaddingTop()) - getPaddingBottom();
    }

    public final void setBitmapsSelected(Bitmap[] r1) {
        this.f = r1;
    }

    public final void setDownX(float r1) {
        this.C = r1;
    }

    public final void setDownY(float r1) {
        this.D = r1;
    }

    public final void setLetters(List<com.obric.oui.indexscrollbar.b> r3) {
        this.c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setListener(b r3) {
        this.v = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setMHasChosenLetterFontColor(int r1) {
        this.r = r1;
    }

    public final void setMNoChosenLetterFontColor(int r1) {
        this.s = r1;
    }

    public final void setNewChosen(int r1) {
        this.G = r1;
    }

    public final void setOldChosen(int r1) {
        this.F = r1;
    }

    public final void setOnBackgroundVisibleChangedListener(c r3) {
        this.x = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setSettled(boolean r1) {
        this.e = r1;
        if (r1 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r4) {
        if (this.w == r4) goto L12;
        this.w = r4;
        if (r4 == false) goto L7;
        Drawable r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.letters_bar_background, "drawable", "letters_bar_background"));
    L8:
        setBackground(r5);
        c r6 = this.x;
        if (r6 == null) goto L13;
        Intrinsics.checkNotNull(r6);
        r6.a(this.w);
        return;
    L13:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void setShowPopupTaskStartTime(long r1) {
        this.f13895J = r1;
    }

    public final void setTouchSlop(int r1) {
        this.E = r1;
    }
}
