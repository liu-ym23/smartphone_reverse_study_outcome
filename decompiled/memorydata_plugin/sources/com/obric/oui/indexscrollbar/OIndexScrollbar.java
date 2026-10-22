package com.obric.oui.indexscrollbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bF\u0018\u0000 §\u00012\u00020\u0001:\n¦\u0001§\u0001¨\u0001©\u0001ª\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u0004\u0018\u000105J\b\u0010g\u001a\u00020bH\u0002J\b\u0010h\u001a\u00020\bH\u0002J\u0006\u0010i\u001a\u00020bJ\u000e\u0010i\u001a\u00020b2\u0006\u0010j\u001a\u00020\nJ\b\u0010k\u001a\u00020bH\u0002J\u000e\u0010l\u001a\u00020b2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010m\u001a\u00020bH\u0002J\u0006\u0010n\u001a\u00020bJ\b\u0010o\u001a\u00020bH\u0002J-\u0010p\u001a\u00020b2\b\u0010q\u001a\u0004\u0018\u00010\\2\u0016\u0010r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010+0*\u0018\u00010*¢\u0006\u0002\u0010sJ\u001d\u0010t\u001a\u00020b2\u0010\u0010u\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020\nJ\u0006\u0010x\u001a\u00020\nJ\u0006\u0010y\u001a\u00020\nJ\u0006\u0010z\u001a\u00020\nJ\u0006\u0010{\u001a\u00020\nJ\u0010\u0010|\u001a\u00020\b2\u0006\u0010}\u001a\u00020\bH\u0002J\u0019\u0010~\u001a\u00020b2\u0006\u0010\u007f\u001a\u00020#2\u0007\u0010\u0080\u0001\u001a\u00020#H\u0002J\t\u0010\u0081\u0001\u001a\u00020bH\u0002J6\u0010\u0082\u0001\u001a\u00020b2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\b2\u0007\u0010\u0085\u0001\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020\bH\u0014J\u001b\u0010\u0088\u0001\u001a\u00020b2\u0007\u0010\u0089\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\bH\u0014J\u0011\u0010\u008b\u0001\u001a\u00020b2\u0006\u0010d\u001a\u00020eH\u0002J\t\u0010\u008c\u0001\u001a\u00020bH\u0002J\u001b\u0010\u008d\u0001\u001a\u00020b2\u0007\u0010\u008e\u0001\u001a\u00020N2\u0007\u0010\u008f\u0001\u001a\u00020\bH\u0014J\u0012\u0010\u0090\u0001\u001a\u00020b2\u0007\u0010\u0091\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020b2\u0007\u0010\u0093\u0001\u001a\u00020\nH\u0002J\u0010\u0010\u0094\u0001\u001a\u00020b2\u0007\u0010\u0095\u0001\u001a\u00020\nJ\u0010\u0010\u0096\u0001\u001a\u00020b2\u0007\u0010\u0097\u0001\u001a\u00020\bJ\u0010\u0010\u0098\u0001\u001a\u00020b2\u0007\u0010\u0099\u0001\u001a\u00020\nJ\u0012\u0010\u009a\u0001\u001a\u00020b2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010IJ\u0012\u0010\u009c\u0001\u001a\u00020b2\u0007\u0010\u0099\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020b2\u0007\u0010\u009e\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020b2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010ZJ\u001b\u0010 \u0001\u001a\u00020b2\u0007\u0010¡\u0001\u001a\u00020N2\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0002J\u001b\u0010¢\u0001\u001a\u00020b2\u0007\u0010¡\u0001\u001a\u00020N2\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0002J\t\u0010£\u0001\u001a\u00020bH\u0002J\u0014\u0010¤\u0001\u001a\u00020b2\t\u0010¥\u0001\u001a\u0004\u0018\u00010NH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010+0*0*X\u0082.¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "DEFAULTX", "", "OIndexScrollbar_DEBUG", "", "getOIndexScrollbar_DEBUG", "()Z", "OIndexScrollbar_TAG", "", "getOIndexScrollbar_TAG", "()Ljava/lang/String;", "POUND_POSITION_BOTTOM", "getPOUND_POSITION_BOTTOM", "()I", "POUND_POSITION_TOP", "getPOUND_POSITION_TOP", "STATE_END", "STATE_MOVE", "STATE_START", "SURNAME_NUM_COLUMNS_THRESHOLD", "SURNAME_NUM_ROWS_THRESHOLD", "VISIBILITY_LIMIT", "getVISIBILITY_LIMIT", "lastVibratedLetter", "mAlphabetsAdapter", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$AlphabetsAdapter;", "mColumnCount", "mContext", "mCurrentRawX", "", "mEndX", "mGridView", "Landroid/widget/GridView;", "mHasPerformedLongPress", "mHostX", "mIconsForSymbols", "", "Landroid/graphics/Bitmap;", "[[Landroid/graphics/Bitmap;", "mIsPerformingHideAnim", "mIsPerformingShowAnim", "mLastRawX", "mLetterbarShadowWidth", "mLetters", "", "Lcom/obric/oui/indexscrollbar/LBLetter;", "mLettersBar", "Lcom/obric/oui/indexscrollbar/LettersBar;", "mLettersBarOccupiedWidth", "mLongPressEnabled", "mMeasuredHeight", "mMinXDistance", "mMissX", "mPopupFlowLayout", "Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "mPopupGridView", "Lcom/obric/oui/indexscrollbar/SurnameGridView;", "mPopupViewMaxHeight", "mPopupViewPendingHorizontal", "mPopupViewPendingVertical", "mPopupWindow", "Landroid/widget/PopupWindow;", "mPopupYOffset", "mPoundPosition", "mPoundVisibility", "mPrePosition", "mQBListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "mSecondPopup", "mSecondPopupView", "Landroid/widget/TextView;", "mSecondPopupViewArrow", "Landroid/view/View;", "mSecondPopupViewParent", "Landroid/view/ViewGroup;", "mShadowView", "mStartX", "mState", "mSurnameGridViewColumnsThreshold", "mSurnameGridViewItemHeight", "mSurnameGridViewItemWidth", "mSurnameGridViewNumColumns", "mSurnameGridViewNumRows", "mSurnameListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "mSymbols", "", "mWidth", "dipToPx", "dipValue", "", "dismissPopupWindow", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getLetterBar", "getParentxPos", "getScreenWidth", "hideLetterGrid", "withAnim", "hideLetterGridWithAnim", CommonConsts.APM_INNER_EVENT_COST_INIT, "initGridView", "initLetters", "initLettersBar", "initSpecialIcons", "symbols", "bitmaps", "([I[[Landroid/graphics/Bitmap;)V", "initSpecialSelectedIcons", "bitmapsSelected", "([Landroid/graphics/Bitmap;)V", "isLetterGridHidden", "isLetterGridHide", "isLetterGridShow", "isLetterGridShown", "isPerformingAnim", "measureHeight", "measureSpec", "moveQuickBar", "x", "missX", "onHideLetterGridAnimationEnd", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveInLongPressState", "onShowLetterGridAnimationEnd", "onVisibilityChanged", "changedView", "visibility", "setHostWidth", "hostWidth", "setLettersBarBg", "showBg", "setLongPressEnabled", "enabled", "setPoundPosition", "position", "setPoundVisibility", "visible", "setQBListener", "listener", "setShadowVisible", "setState", "state", "setSurnameListener", "showFlowPopupWindow", "alphabetView", "showGridPopupWindow", "showLetterGridWithAnim", "showSecondPopupWindow", "anchorView", "AlphabetsAdapter", "Companion", "QBListener", "SurnameAdapter", "SurnameListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OIndexScrollbar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13897a = null;
    private int[] A;
    private Bitmap[][] B;
    private boolean C;
    private final int D;
    private final int E;
    private int F;
    private PopupWindow G;
    private SurnameGridView H;
    private SurnameFlowLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final int f13898J;
    private final int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private final int U;
    private PopupWindow V;
    private TextView W;
    private final int aa;
    private int ab;
    private int ac;
    private String ad;
    private final int ae;
    private boolean af;
    private int ag;
    private boolean ah;
    private ViewGroup ai;
    private View aj;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13899b;
    private final boolean c;
    private Context d;
    private LettersBar e;
    private GridView f;
    private View g;
    private a h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private final int o;
    private final int p;
    private final int q;
    private int r;
    private float s;
    private float t;
    private float u;
    private c v;
    private e w;
    private boolean x;
    private boolean y;
    private final List<com.obric.oui.indexscrollbar.b> z;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001b\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010#R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$AlphabetsAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "(Lcom/obric/oui/indexscrollbar/OIndexScrollbar;Landroid/content/Context;)V", "isNeedIncreaseHeight", "", "()Z", "mAlphabets", "", "", "[Ljava/lang/String;", "mCurrentLanguage", "mNumRows", "", "mTotalVerticalSpacing", "", "singleCellHeight", "getSingleCellHeight", "()I", "getCount", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isEnabled", "isNeedInsreaseHeightPosition", "setAlphabets", "", "alphabets", "([Ljava/lang/String;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f13901b;
        private String[] c;
        private final String d;
        private final float e;
        private final int f;

        public a(OIndexScrollbar r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            this.f13900a = r3;
            this.f13901b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            String r6 = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(r6, "getDefault().language");
            this.d = r6;
            float r7 = com.obric.oui.indexscrollbar.a.f13913a.a(r6);
            this.e = r7;
            int r8 = ((int) Math.ceil(r7)) - 1;
            GridView r9 = OIndexScrollbar.e(r3);
            Intrinsics.checkNotNull(r9);
            this.f = r8 * r9.getVerticalSpacing();
        }

        private final boolean a() {
            if (((int) ((OIndexScrollbar.f(this.f13900a) - this.f) % this.e)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private final int b() {
            return (int) ((OIndexScrollbar.f(this.f13900a) - this.f) / this.e);
        }

        private final boolean b(int r3) {
            if (r3 != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (r3 != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (r3 == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        public String a(int r1) {
            String[] r0 = this.c;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r0 = null;
        L6:
            return r0[r1];
        }

        public final void a(String[] r1) {
            if (r1 == null) goto L5;
            this.c = r1;
            return;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.c != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L5:
            String[] r2 = this.c;
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r2 = null;
        L9:
            return r2.length;
        }

        @Override // android.widget.Adapter
        public /* synthetic */ Object getItem(int r1) {
            return a(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public View getView(int r13, View r14, ViewGroup r15) {
            Intrinsics.checkNotNullParameter(r15, "parent");
            String[] r16 = this.c;
            if (r16 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r16 = null;
        L5:
            String r17 = r16[r13];
            int r1 = b();
            float r2 = OIndexScrollbar.f(this.f13900a) - this.f;
            float r4 = this.e;
            int r3 = (int) (r2 - (r1 * r4));
            if (r4 != 9.0f) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L16;
            if (a() == false) goto L16;
            if (b(r13) == false) goto L16;
            r1 = r1 + r3;
        L16:
            if (r14 == null) goto L18;
        L30:
            int r18 = (r13 / 3) % 2;
            Context r12 = this.f13901b;
            Intrinsics.checkNotNull(r12);
            Resources r19 = ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin");
            if (r18 != 0) goto L33;
            int r110 = R.drawable.quickbar_ex_alphabet_text_light_colorlist;
            String r111 = "quickbar_ex_alphabet_text_light_colorlist";
        L34:
            r14.setBackground(r19.getDrawable(ZeusTransformUtils.mapRes(r110, "drawable", r111)));
            return r14;
        L33:
            r110 = R.drawable.quickbar_ex_alphabet_text_dark_colorlist;
            r111 = "quickbar_ex_alphabet_text_dark_colorlist";
            goto L34
        L18:
            if (com.obric.oui.indexscrollbar.a.f13913a.e(r17) == false) goto L21;
            ImageView r112 = new ImageView(this.f13901b);
            r112.setImageResource(ZeusTransformUtils.mapRes(R.drawable.letter_bar_unfold_button, "drawable", "letter_bar_unfold_button"));
            r112.setScaleType(ImageView.ScaleType.CENTER);
            r112.setMinimumHeight(r1);
            Object r113 = r112;
        L20:
            r14 = (View) ZeusTransformUtils.preCheckCast(r113, View.class, "com.obric.memorydata.plugin");
            goto L30
        L21:
            TextView r114 = (TextView) ZeusTransformUtils.preCheckCast(new AlphabetView(this.f13901b, null, 0, 6, null), TextView.class, "com.obric.memorydata.plugin");
            r114.setHeight(r1);
            if (com.obric.oui.indexscrollbar.a.f13913a.g(r17) == false) goto L25;
            r114.setTextColor(Color.parseColor("#80000000"));
            r17 = r17.substring(1);
            Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).substring(startIndex)");
        L25:
            if (com.obric.oui.indexscrollbar.a.f13913a.f(r17) == true) goto L27;
            r114.setText((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"));
        L27:
            r113 = r114;
            if (com.obric.oui.indexscrollbar.a.f13913a.h(r17) == false) goto L20;
            r114.setTypeface(null, 0);
            r113 = r114;
            goto L20
        L8:
            r5 = false;
            goto L9
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r5) {
            com.obric.oui.indexscrollbar.a r0 = com.obric.oui.indexscrollbar.a.f13913a;
            String[] r1 = this.c;
            String[] r2 = null;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r1 = null;
        L6:
            if (r0.f(r1[r5]) == true) goto L14;
            com.obric.oui.indexscrollbar.a r3 = com.obric.oui.indexscrollbar.a.f13913a;
            String[] r4 = this.c;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L12:
            if (r3.g(r2[r5]) == true) goto L14;
            return true;
        L10:
            r2 = r4;
        L14:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$Companion;", "", "()V", "LETTER_CHANGED_CLICK", "", "LETTER_CHANGED_SLIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "", "onLetterChanged", "", "letter", "", "type", "", "onLetterGridHidden", "", "onLetterGridShow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a();

        boolean a(String r1, int r2);

        void b();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "surnames", "", "", "(Lcom/obric/oui/indexscrollbar/OIndexScrollbar;Landroid/content/Context;Ljava/util/List;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class d extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f13903b;
        private final List<String> c;

        public d(OIndexScrollbar r3, Context r4, List<String> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            this.f13902a = r3;
            this.f13903b = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.c = r7;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r0 = this.c;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            List<String> r1 = this.c;
            if (r1 != null) goto L5;
            String r3 = null;
        L6:
            Intrinsics.checkNotNull(r3);
            return r3;
        L5:
            r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(r2), String.class, "com.obric.memorydata.plugin");
            goto L6
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            Intrinsics.checkNotNullParameter(r6, "parent");
            if (r5 != null) goto L5;
            r5 = ZeusTransformUtils.inflate(LayoutInflater.from(this.f13903b), ZeusTransformUtils.mapRes(R.layout.o_surname_popup_item_ex, "layout", "o_surname_popup_item_ex"), null, "com.obric.memorydata.plugin");
            r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new AbsListView.LayoutParams(OIndexScrollbar.g(this.f13902a), OIndexScrollbar.h(this.f13902a)), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        L5:
            int r0 = r4 % OIndexScrollbar.i(this.f13902a);
            if (r0 == 0) goto L8;
        L12:
            if (r0 != 0) goto L18;
            if (r5 == null) goto L28;
            int r1 = R.drawable.surname_popup_item_right;
            String r2 = "surname_popup_item_right";
        L16:
            r5.setBackgroundResource(ZeusTransformUtils.mapRes(r1, "drawable", r2));
        L28:
            Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.TextView");
            TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
            List<String> r7 = this.c;
            Intrinsics.checkNotNull(r7);
            r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r7.get(r4), String.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
            return r5;
        L18:
            if (r0 != (OIndexScrollbar.i(this.f13902a) - 1)) goto L20;
        L25:
            if (r5 == null) goto L28;
            r1 = R.drawable.surname_popup_item_left;
            r2 = "surname_popup_item_left";
            goto L16
        L20:
            if (r4 == (getCount() - 1)) goto L25;
            if (r5 == null) goto L28;
            r1 = R.drawable.surname_popup_item_middle;
            r2 = "surname_popup_item_middle";
            goto L16
        L8:
            if (r4 != (getCount() - 1)) goto L12;
            if (r5 == null) goto L28;
            r1 = R.drawable.surname_popup_item_special;
            r2 = "surname_popup_item_special";
            goto L16
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "", "getMatchedSurnames", "", "", "letter", "onSurnameClicked", "", "surname", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface e {
        List<String> a(String r1);

        void b(String r1);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/indexscrollbar/OIndexScrollbar$hideLetterGridWithAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "arg0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13904a;

        f(OIndexScrollbar r1) {
            this.f13904a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            Intrinsics.checkNotNullParameter(r1, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "arg0");
            OIndexScrollbar.d(this.f13904a, false);
            OIndexScrollbar.c(this.f13904a);
            if (OIndexScrollbar.a(this.f13904a) == null) goto L6;
            c r1 = OIndexScrollbar.a(this.f13904a);
            Intrinsics.checkNotNull(r1);
            r1.b();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            Intrinsics.checkNotNullParameter(r1, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "arg0");
            OIndexScrollbar.d(this.f13904a, true);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/indexscrollbar/OIndexScrollbar$initLettersBar$1", "Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "onLetterChanged", "", "letter", "", "type", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements LettersBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13905a;

        g(OIndexScrollbar r1) {
            this.f13905a = r1;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.b
        public boolean a(String r2, int r3) {
            OIndexScrollbar.a(this.f13905a, r2);
            if (OIndexScrollbar.a(this.f13905a) == null) goto L7;
            c r1 = OIndexScrollbar.a(this.f13905a);
            Intrinsics.checkNotNull(r1);
            if (r1.a(r2, r3) == false) goto L7;
            return true;
        L7:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/oui/indexscrollbar/OIndexScrollbar$initLettersBar$2", "Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "OnBackgroundVisibleChanged", "", "visible", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h implements LettersBar.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13906a;

        h(OIndexScrollbar r1) {
            this.f13906a = r1;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.c
        public void a(boolean r1) {
            OIndexScrollbar.a(this.f13906a, r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/oui/indexscrollbar/OIndexScrollbar$showGridPopupWindow$2", "Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "onTouched", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class i implements SurnameGridView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13907a;

        i(OIndexScrollbar r1) {
            this.f13907a = r1;
        }

        private static final void a(OIndexScrollbar r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            OIndexScrollbar.a(r1, null);
        }

        /* JADX INFO: renamed from: lambda$hDEyhxRUh11426Ke4-20WyGEb3o, reason: not valid java name */
        public static /* synthetic */ void m1313lambda$hDEyhxRUh11426Ke420WyGEb3o(OIndexScrollbar r0) {
            a(r0);
        }

        @Override // com.obric.oui.indexscrollbar.SurnameGridView.a
        public void a(int r4) {
            if (r4 != (-1)) goto L5;
            Handler r5 = new Handler(Looper.getMainLooper());
            final OIndexScrollbar r3 = this.f13907a;
            r5.postDelayed(new $$Lambda$OIndexScrollbar$i$hDEyhxRUh11426Ke420WyGEb3o(r3), 100);
            return;
        L5:
            SurnameGridView r0 = OIndexScrollbar.d(this.f13907a);
            Intrinsics.checkNotNull(r0);
            SurnameGridView r1 = OIndexScrollbar.d(this.f13907a);
            Intrinsics.checkNotNull(r1);
            View r2 = r0.getChildAt(r4 - r1.getFirstVisiblePosition());
            Intrinsics.checkNotNullExpressionValue(r2, "mPopupGridView!!.getChil…etFirstVisiblePosition())");
            SurnameGridView r6 = OIndexScrollbar.d(this.f13907a);
            Intrinsics.checkNotNull(r6);
            Object r7 = r6.getAdapter().getItem(r4);
            Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.String");
            r2.setTag((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));
            OIndexScrollbar.a(this.f13907a, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/indexscrollbar/OIndexScrollbar$showLetterGridWithAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "arg0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class j implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f13908a;

        j(OIndexScrollbar r1) {
            this.f13908a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            Intrinsics.checkNotNullParameter(r1, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "arg0");
            OIndexScrollbar.b(this.f13908a, false);
            OIndexScrollbar.b(this.f13908a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            Intrinsics.checkNotNullParameter(r1, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "arg0");
            OIndexScrollbar.b(this.f13908a, true);
            OIndexScrollbar.c(this.f13908a, true);
        }
    }

    static {
        f13897a = new b(null);
    }

    public OIndexScrollbar(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.f13899b = "OIndexScrollbar";
        this.c = Log.isLoggable("OIndexScrollbar", 3);
        this.o = 1;
        this.p = 2;
        this.q = 3;
        this.r = 1;
        this.z = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.C = true;
        this.D = 1;
        this.E = 2;
        this.F = 2;
        this.f13898J = 8;
        this.K = 8;
        this.U = 3;
        this.aa = -99999;
        this.ab = -99999;
        a(r8);
        this.ae = 30;
        this.ag = -1;
        this.ah = true;
    }

    private final int a(double r3) {
        Context r2 = this.d;
        Intrinsics.checkNotNull(r2);
        return (int) ((r3 * ((double) ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics().density)) + ((double) 0.5f));
    }

    private final int a(int r1) {
        return View.MeasureSpec.getSize(r1);
    }

    public static final /* synthetic */ c a(OIndexScrollbar r0) {
        return r0.v;
    }

    private final void a(MotionEvent r15) {
        PopupWindow r0 = this.G;
        if (r0 == null) goto L36;
        Intrinsics.checkNotNull(r0);
        if (r0.isShowing() == false) goto L40;
        int r1 = (int) r15.getRawX();
        int r16 = (int) r15.getRawY();
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f13913a;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        if (r2.d(r3) != 1) goto L24;
        SurnameFlowLayout r4 = this.I;
        if (r4 == null) goto L37;
        int[] r5 = new int[2];
        Intrinsics.checkNotNull(r4);
        r4.getLocationOnScreen(r5);
        int r6 = -1;
        SurnameFlowLayout r8 = this.I;
        Intrinsics.checkNotNull(r8);
        int r9 = r8.getChildCount();
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L18;
        int r11 = r10 + 1;
        SurnameFlowLayout r12 = this.I;
        Intrinsics.checkNotNull(r12);
        View r13 = r12.getChildAt(r10);
        Intrinsics.checkNotNullExpressionValue(r13, "mPopupFlowLayout!!.getChildAt(i)");
        Rect r14 = new Rect();
        r13.getHitRect(r14);
        if (r14.contains(r1 - r5[0], r16 - r5[1]) == true) goto L15;
        r10 = r11;
        goto L12
    L15:
        r6 = r10;
    L18:
        if (r6 >= 0) goto L20;
        SurnameFlowLayout r7 = this.I;
        Intrinsics.checkNotNull(r7);
        View r17 = r7.getChildAt(this.ag);
        Intrinsics.checkNotNullExpressionValue(r17, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r17.setPressed(false);
        a(null);
    L23:
        this.ag = r6;
        return;
    L20:
        if (this.ag == r6) goto L23;
        SurnameFlowLayout r18 = this.I;
        Intrinsics.checkNotNull(r18);
        View r19 = r18.getChildAt(this.ag);
        Intrinsics.checkNotNullExpressionValue(r19, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r19.setPressed(false);
        a(null);
        SurnameFlowLayout r110 = this.I;
        Intrinsics.checkNotNull(r110);
        View r111 = r110.getChildAt(r6);
        Intrinsics.checkNotNullExpressionValue(r111, "mPopupFlowLayout!!.getChildAt(position)");
        r111.setPressed(true);
        CharSequence r20 = ((TextView) ZeusTransformUtils.preCheckCast(r111, TextView.class, "com.obric.memorydata.plugin")).getText();
        Objects.requireNonNull(r20, "null cannot be cast to non-null type kotlin.String");
        r111.setTag((String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.memorydata.plugin"));
        a(r111);
        goto L23
    L37:
        return;
    L24:
        SurnameGridView r21 = this.H;
        if (r21 == null) goto L39;
        int[] r22 = new int[2];
        Intrinsics.checkNotNull(r21);
        r21.getLocationOnScreen(r22);
        int r23 = r1 - r22[0];
        int r112 = r16 - r22[1];
        SurnameGridView r24 = this.H;
        Intrinsics.checkNotNull(r24);
        int r113 = r24.pointToPosition(r23, r112);
        if (r113 >= 0) goto L29;
        SurnameGridView r25 = this.H;
        Intrinsics.checkNotNull(r25);
        View r26 = r25.getChildAt(this.ag);
        Intrinsics.checkNotNullExpressionValue(r26, "mPopupGridView!!.getChildAt(mPrePosition)");
        r26.setPressed(false);
        a(null);
    L32:
        this.ag = r113;
        return;
    L29:
        if (this.ag == r113) goto L32;
        SurnameGridView r27 = this.H;
        Intrinsics.checkNotNull(r27);
        View r28 = r27.getChildAt(this.ag);
        Intrinsics.checkNotNullExpressionValue(r28, "mPopupGridView!!.getChildAt(mPrePosition)");
        r28.setPressed(false);
        a(null);
        SurnameGridView r29 = this.H;
        Intrinsics.checkNotNull(r29);
        View r30 = r29.getChildAt(r113);
        Intrinsics.checkNotNullExpressionValue(r30, "mPopupGridView!!.getChildAt(position)");
        r30.setPressed(true);
        SurnameGridView r31 = this.H;
        Intrinsics.checkNotNull(r31);
        Object r32 = r31.getAdapter().getItem(r113);
        Objects.requireNonNull(r32, "null cannot be cast to non-null type kotlin.String");
        r30.setTag((String) ZeusTransformUtils.preCheckCast(r32, String.class, "com.obric.memorydata.plugin"));
        a(r30);
        goto L32
    L39:
        return;
    L40:
        return;
    }

    private final void a(View r12) {
        if (r12 != null) goto L8;
        PopupWindow r11 = this.V;
        if (r11 == null) goto L25;
        Intrinsics.checkNotNull(r11);
        r11.dismiss();
        return;
    L25:
        return;
    L8:
        if (this.V != null) goto L10;
        PopupWindow r0 = new PopupWindow();
        this.V = r0;
        Intrinsics.checkNotNull(r0);
        r0.setWindowLayoutMode(-2, -2);
        PopupWindow r1 = this.V;
        Intrinsics.checkNotNull(r1);
        r1.setBackgroundDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        PopupWindow r2 = this.V;
        Intrinsics.checkNotNull(r2);
        r2.setClippingEnabled(true);
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_surname_second_popup_ex, "layout", "o_surname_second_popup_ex"), null, "com.obric.memorydata.plugin"), ViewGroup.class, "com.obric.memorydata.plugin");
        this.ai = r3;
        Intrinsics.checkNotNull(r3);
        this.aj = r3.getChildAt(1);
        ViewGroup r4 = this.ai;
        Intrinsics.checkNotNull(r4);
        View r5 = r4.getChildAt(0);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        this.W = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
    L10:
        PopupWindow r6 = this.V;
        Intrinsics.checkNotNull(r6);
        r6.setContentView((View) ZeusTransformUtils.preCheckCast(this.ai, View.class, "com.obric.memorydata.plugin"));
        int[] r7 = new int[2];
        r12.getLocationOnScreen(r7);
        Log.d(this.f13899b, "original anchorViewLocation[0] = " + r7[0] + ", anchorViewLocation[1] = " + r7[1]);
        int[] r8 = new int[2];
        getRootView().getLocationOnScreen(r8);
        Log.d(this.f13899b, "rootViewLocation[0] = " + r8[0] + ", rootViewLocation[1] = " + r8[1]);
        String r9 = r12.getTag().toString();
        TextView r10 = this.W;
        Intrinsics.checkNotNull(r10);
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r13 = this.W;
        Intrinsics.checkNotNull(r13);
        r13.measure(0, 0);
        TextView r14 = this.W;
        Intrinsics.checkNotNull(r14);
        int r15 = ((int) r14.getPaint().measureText(r9)) + a(40.0d);
        int r16 = a(320.0d);
        if (r15 <= r16) goto L13;
        r15 = r16;
    L13:
        TextView r17 = this.W;
        Intrinsics.checkNotNull(r17);
        int r18 = r17.getMeasuredHeight();
        int r19 = r12.getWidth();
        int r20 = r12.getHeight();
        int r110 = (r7[0] - r8[0]) + (r19 / 2);
        int r21 = (r7[1] - r8[1]) + (r20 / 2);
        int r22 = r15 / 2;
        int r23 = r110 - r22;
        int r24 = (r21 - r18) - 20;
        View r25 = this.aj;
        Intrinsics.checkNotNull(r25);
        r25.getLocationOnScreen(new int[2]);
        View r26 = this.aj;
        Intrinsics.checkNotNull(r26);
        r26.setTranslationX(0.0f);
        if (r23 >= 0) goto L17;
        View r27 = this.aj;
        Intrinsics.checkNotNull(r27);
        float r28 = r23;
    L16:
        r27.setTranslationX(r28);
    L21:
        if (this.c == false) goto L23;
        Log.d(this.f13899b, "x = " + r23 + ", width = " + r15 + ", anchorView.getWidth() = " + r12.getWidth());
        Log.d(this.f13899b, "y = " + r24 + ", height = " + r18 + ", anchorView.getHeight() = " + r12.getHeight());
    L23:
        PopupWindow r111 = this.V;
        Intrinsics.checkNotNull(r111);
        r111.showAtLocation((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 51, r23, r24);
        return;
    L17:
        int r112 = r110 + r22;
        if (r112 <= getScreenWidth()) goto L21;
        r27 = this.aj;
        Intrinsics.checkNotNull(r27);
        r28 = r112 - getScreenWidth();
        goto L16
    }

    private final void a(View r25, int r26) {
        if (this.w == null) goto L97;
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f13913a;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        a r4 = this.h;
        Intrinsics.checkNotNull(r4);
        if (r2.a(r3, r4.a(r26)) == true) goto L7;
        return;
    L7:
        e r5 = this.w;
        Intrinsics.checkNotNull(r5);
        a r6 = this.h;
        Intrinsics.checkNotNull(r6);
        List<String> r7 = r5.a(r6.a(r26));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() == 0) goto L102;
        String r8 = "layout";
        String r9 = "com.obric.memorydata.plugin";
        View r10 = ZeusTransformUtils.inflate(LayoutInflater.from(this.d), ZeusTransformUtils.mapRes(R.layout.o_surname_flow_popup, "layout", "o_surname_flow_popup"), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r10, "from(mContext).inflate(R…surname_flow_popup, null)");
        int r11 = R.id.surname_content;
        String r12 = OaidModel.KEY_ID;
        View r13 = r10.findViewById(ZeusTransformUtils.mapRes(r11, OaidModel.KEY_ID, "surname_content"));
        Objects.requireNonNull(r13, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameFlowLayout");
        this.I = (SurnameFlowLayout) ZeusTransformUtils.preCheckCast(r13, SurnameFlowLayout.class, "com.obric.memorydata.plugin");
        this.N = a(7.0d);
        this.O = a((this.K * 33) + 19);
        this.L = a(40.0d);
        this.M = a(33.0d);
        this.T = this.f13898J;
        int r14 = a(98.0d);
        Drawable r15 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_left, "drawable", "surname_popup_item_left"));
        int r16 = this.T * this.L;
        Iterator<String> r17 = r7.iterator();
        int r18 = 1;
        int r19 = 0;
        int r110 = 0;
    L14:
        if (r17.hasNext() == false) goto L38;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, r9);
        Iterator<String> r21 = r17;
        View r20 = ZeusTransformUtils.inflate(LayoutInflater.from(this.d), ZeusTransformUtils.mapRes(R.layout.o_surname_popup_item_ex, r8, "o_surname_popup_item_ex"), null, r9);
        Objects.requireNonNull(r20, "null cannot be cast to non-null type android.widget.TextView");
        final TextView r22 = (TextView) ZeusTransformUtils.preCheckCast(r20, TextView.class, r9);
        r22.setText((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, r9));
        ViewGroup.MarginLayoutParams r112 = new ViewGroup.MarginLayoutParams(-2, -2);
        r112.height = this.M;
        r22.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r112, ViewGroup.LayoutParams.class, r9));
        String r23 = r8;
        String r113 = r9;
        String r114 = r12;
        r22.setPadding(a(10.0d), 0, a(10.0d), 0);
        if (r7.size() != 1) goto L18;
        int r24 = ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_special, "drawable", "surname_popup_item_special");
    L19:
        r22.setBackgroundResource(r24);
        int r27 = (int) Math.ceil(r22.getPaint().measureText(r111));
        if (r15 == null) goto L26;
        int r28 = r15.getIntrinsicWidth();
        if (r28 <= 0) goto L26;
        Drawable r115 = r15;
        double r29 = 20.0d;
        List<String> r210 = r7;
        if (r28 <= (r27 + a(20.0d))) goto L27;
        r27 = r28 - a(20.0d);
    L27:
        if (r27 <= r14) goto L29;
        r27 = r14;
    L29:
        int r30 = r27 + a(r29);
        if ((r110 + r30) <= r16) goto L33;
        r18 = r18 + 1;
        r110 = 0;
    L33:
        int r31 = r110 + r30;
        int r32 = r19;
        if (r32 <= r31) goto L36;
        r19 = r32;
    L37:
        r22.setOnClickListener(new $$Lambda$OIndexScrollbar$3jfd_zIEyEj8YoucPwwY55z91EU(this));
        r22.setOnTouchListener(new $$Lambda$OIndexScrollbar$T27Y7Akl6vXUJhWZHn1AC7YD0M(this, r22));
        SurnameFlowLayout r33 = this.I;
        Intrinsics.checkNotNull(r33);
        r33.addView((View) ZeusTransformUtils.preCheckCast(r22, View.class, r113));
        r110 = r31;
        r9 = r113;
        r15 = r115;
        r12 = r114;
        r17 = r21;
        r8 = r23;
        r7 = r210;
        goto L14
    L36:
        r19 = r31;
    L26:
        r210 = r7;
        r115 = r15;
        r29 = 20.0d;
        goto L27
    L18:
        r24 = ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_left, "drawable", "surname_popup_item_left");
        goto L19
    L38:
        String r116 = r12;
        int r34 = r19;
        String r35 = r9;
        this.S = r18;
        SurnameFlowLayout r36 = this.I;
        Intrinsics.checkNotNull(r36);
        r36.measure(0, 0);
        if (this.c == false) goto L41;
        Log.d(this.f13899b, Intrinsics.stringPlus("surname FlowLayout, width = ", Integer.valueOf(r34)));
        String r37 = this.f13899b;
        SurnameFlowLayout r38 = this.I;
        Intrinsics.checkNotNull(r38);
        Log.d(r37, Intrinsics.stringPlus("surname FlowLayout, measuredHeight = ", Integer.valueOf(r38.getMeasuredHeight())));
    L41:
        SurnameFlowLayout r39 = this.I;
        Intrinsics.checkNotNull(r39);
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        Objects.requireNonNull(r40, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r41 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r40, FrameLayout.LayoutParams.class, r35);
        r41.width = r34;
        SurnameFlowLayout r42 = this.I;
        Intrinsics.checkNotNull(r42);
        r42.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r41, ViewGroup.LayoutParams.class, r35));
        if (this.G != null) goto L44;
        PopupWindow r43 = new PopupWindow();
        this.G = r43;
        Intrinsics.checkNotNull(r43);
        r43.setWindowLayoutMode(-2, -2);
        PopupWindow r44 = this.G;
        Intrinsics.checkNotNull(r44);
        r44.setBackgroundDrawable(ZeusTransformUtils.getResources(this, r35).getDrawable(ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        PopupWindow r45 = this.G;
        Intrinsics.checkNotNull(r45);
        r45.setClippingEnabled(true);
    L44:
        PopupWindow r46 = this.G;
        Intrinsics.checkNotNull(r46);
        r46.setContentView(r10);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r47 = new int[2];
        r25.getLocationOnScreen(r47);
        int r117 = r47[0] + (r25.getWidth() / 2);
        int r118 = r47[1] + (r25.getHeight() / 2);
        if (this.c == false) goto L47;
        int r119 = 0;
        Log.d(this.f13899b, "alphabet anchorX = " + r47[0] + ", anchorY = " + r47[1]);
    L48:
        r10.measure(r119, r119);
        int r48 = r10.getMeasuredWidth();
        int r49 = r10.getMeasuredHeight();
        if (this.c == false) goto L51;
        Log.d(this.f13899b, "popMeasureWidth = " + r48 + ", popMeasureHeight = " + r49);
    L51:
        int r50 = this.U;
        if (r26 >= r50) goto L56;
        boolean r120 = true;
        if (this.S <= 1) goto L57;
    L74:
        boolean r121 = r120;
    L77:
        if (r121 == false) goto L79;
        String r122 = r116;
        View r51 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_top_arrow, r122, "surname_popup_top_arrow"));
        Objects.requireNonNull(r51, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r52 = (ImageView) ZeusTransformUtils.preCheckCast(r51, ImageView.class, r35);
        int r123 = r118 + this.N;
    L80:
        r52.setVisibility(0);
        r52.measure(0, 0);
        int r53 = r52.getMeasuredWidth();
        if (this.c == false) goto L83;
        Log.d(this.f13899b, Intrinsics.stringPlus("arrowWidth = ", Integer.valueOf(r53)));
    L83:
        int r124 = r48 / 2;
        int r54 = (int) Math.min(getScreenWidth() - r117, r124);
        int r125 = r117 - r124;
        int r55 = (r48 - r54) - (r53 / 2);
        View r56 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_top_mask, r122, "surname_top_mask"));
        Objects.requireNonNull(r56, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r57 = (ImageView) ZeusTransformUtils.preCheckCast(r56, ImageView.class, r35);
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        Objects.requireNonNull(r58, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r59 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r58, FrameLayout.LayoutParams.class, r35);
        r59.width = r34;
        View r126 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_bottom_mask, r122, "surname_bottom_mask"));
        Objects.requireNonNull(r126, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r126, ImageView.class, r35);
        ViewGroup.LayoutParams r127 = r1.getLayoutParams();
        Objects.requireNonNull(r127, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r128 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r127, FrameLayout.LayoutParams.class, r35);
        r128.width = r34;
        View r60 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_container, r122, "surname_container"));
        Objects.requireNonNull(r60, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r61 = (LinearLayout) ZeusTransformUtils.preCheckCast(r60, LinearLayout.class, r35);
        ViewGroup.LayoutParams r129 = r61.getLayoutParams();
        Objects.requireNonNull(r129, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r62 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r129, FrameLayout.LayoutParams.class, r35);
        SurnameFlowLayout r130 = this.I;
        Intrinsics.checkNotNull(r130);
        int r131 = r130.getMeasuredHeight();
        int r132 = this.O;
        if (r131 <= r132) goto L86;
        r62.height = r132;
    L86:
        r61.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r62, ViewGroup.LayoutParams.class, r35));
        if (r34 != (this.T * this.L)) goto L89;
        r61.setPadding(a(14.0d), a(1.5d), a(17.0d), a(4.0d));
        r55 = r55 + ZeusTransformUtils.getResources(this, r35).getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.surname_arrow_offset_x, "dimen", "surname_arrow_offset_x"));
        r59.leftMargin = a(20.0d);
        r128.leftMargin = a(20.0d);
        r59.width -= a(10.0d);
        r128.width -= a(10.0d);
    L90:
        r57.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r59, ViewGroup.LayoutParams.class, r35));
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r128, ViewGroup.LayoutParams.class, r35));
        r52.setTranslationX(r55);
        if (Math.abs(getX() - this.j) <= a(1.0d)) goto L94;
        Log.d(this.f13899b, "GridView is hiding now...");
        return;
    L94:
        PopupWindow r63 = this.G;
        Intrinsics.checkNotNull(r63);
        r63.showAtLocation((View) ZeusTransformUtils.preCheckCast(this, View.class, r35), 0, r125, r123);
        return;
    L89:
        r125 = r125 - 1;
        goto L90
    L79:
        r122 = r116;
        View r64 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_bottom_arrow, r122, "surname_popup_bottom_arrow"));
        Objects.requireNonNull(r64, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r65 = (ImageView) ZeusTransformUtils.preCheckCast(r64, ImageView.class, r35);
        r123 = (r118 - r49) - this.N;
        r52 = r65;
    L57:
        if (r26 < r50) goto L63;
        if (r26 >= (r50 * 2)) goto L63;
        if (this.S > 3) goto L74;
    L63:
        if (r26 < (r50 * 2)) goto L69;
        if (r26 >= (r50 * 3)) goto L69;
        if (this.S > 5) goto L74;
    L69:
        if (r26 >= (r50 * 3)) goto L71;
    L75:
        r121 = false;
        goto L77
    L71:
        if (r26 >= (r50 * 4)) goto L75;
        if (this.S <= 7) goto L75;
    L56:
        r120 = true;
        goto L57
    L47:
        r119 = 0;
        goto L48
    L102:
        return;
    L97:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    public static final /* synthetic */ void a(OIndexScrollbar r0, View r1) {
        r0.a(r1);
    }

    private static final void a(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        com.obric.oui.indexscrollbar.a r5 = com.obric.oui.indexscrollbar.a.f13913a;
        a r6 = r0.h;
        Intrinsics.checkNotNull(r6);
        if (r5.e(r6.a(r3)) == true) goto L7;
        c r7 = r0.v;
        Intrinsics.checkNotNull(r7);
        a r8 = r0.h;
        Intrinsics.checkNotNull(r8);
        if (r7.a(r8.a(r3), 1) == false) goto L7;
        r0.invalidate();
    L7:
        r0.h();
    }

    public static final /* synthetic */ void a(OIndexScrollbar r0, String r1) {
        r0.ad = r1;
    }

    public static final /* synthetic */ void a(OIndexScrollbar r0, boolean r1) {
        r0.setShadowVisible(r1);
    }

    private static final boolean a(OIndexScrollbar r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.r == r1.q) goto L5;
        return false;
    L5:
        if (r3.getAction() != 0) goto L14;
        PopupWindow r4 = r1.G;
        if (r4 == null) goto L15;
        Intrinsics.checkNotNull(r4);
        if (r4.isShowing() == false) goto L16;
        PopupWindow r5 = r1.G;
        Intrinsics.checkNotNull(r5);
        r5.dismiss();
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    private static final boolean a(OIndexScrollbar r1, TextView r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$surnameView");
        if (r4.getAction() == 0) goto L9;
        if (r4.getAction() == 2) goto L9;
        r1.a(null);
        return false;
    L9:
        if (r1.V != null) goto L11;
    L15:
        r3.setTag(r2.getText());
        r1.a(r3);
        return false;
    L11:
        if (r1.W == null) goto L15;
        CharSequence r5 = r2.getText();
        TextView r0 = r1.W;
        Intrinsics.checkNotNull(r0);
        if (Intrinsics.areEqual(r5, r0.getText()) == true) goto L15;
        PopupWindow r6 = r1.V;
        Intrinsics.checkNotNull(r6);
        r6.dismiss();
        goto L15
    }

    private final void b(View r19, int r20) {
        if (this.w == null) goto L83;
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f13913a;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        a r4 = this.h;
        Intrinsics.checkNotNull(r4);
        if (r2.a(r3, r4.a(r20)) == true) goto L7;
        return;
    L7:
        e r5 = this.w;
        Intrinsics.checkNotNull(r5);
        a r6 = this.h;
        Intrinsics.checkNotNull(r6);
        List<String> r7 = r5.a(r6.a(r20));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() == 0) goto L85;
        d r8 = new d(this, this.d, r7);
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(this.d), ZeusTransformUtils.mapRes(R.layout.o_surname_popup, "layout", "o_surname_popup"), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "from(mContext).inflate(R…ut.o_surname_popup, null)");
        View r10 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_content, OaidModel.KEY_ID, "surname_content"));
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameGridView");
        this.H = (SurnameGridView) ZeusTransformUtils.preCheckCast(r10, SurnameGridView.class, "com.obric.memorydata.plugin");
        this.N = a(7.0d);
        this.M = a(33.0d);
        this.O = a((this.K * 33) + 19);
        this.P = a(16.0d);
        this.Q = a(6.0d);
        this.T = this.f13898J;
        this.L = a(40.0d);
        int r11 = r7.size();
        int r12 = this.T;
        if (r11 >= r12) goto L16;
        r12 = r7.size();
    L16:
        this.R = r12;
        int r13 = (int) Math.ceil((((double) r7.size()) * 1.0d) / ((double) this.R));
        this.S = r13;
        int r14 = (this.R * this.L) + (this.Q * 2);
        if (r13 <= this.K) goto L19;
        int r15 = this.O;
    L20:
        int r16 = r15 + (this.P * 2);
        if (this.c == false) goto L23;
        Log.d(this.f13899b, "surname GridView, width = " + r14 + ", height = " + r16);
    L23:
        SurnameGridView r17 = this.H;
        Intrinsics.checkNotNull(r17);
        r17.setNumColumns(this.R);
        SurnameGridView r18 = this.H;
        Intrinsics.checkNotNull(r18);
        r18.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r14, r16), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        SurnameGridView r21 = this.H;
        Intrinsics.checkNotNull(r21);
        r21.setGravity(17);
        SurnameGridView r22 = this.H;
        Intrinsics.checkNotNull(r22);
        r22.setAdapter((ListAdapter) ZeusTransformUtils.preCheckCast(r8, ListAdapter.class, "com.obric.memorydata.plugin"));
        SurnameGridView r23 = this.H;
        Intrinsics.checkNotNull(r23);
        r23.setOnPressChangeListener((SurnameGridView.a) ZeusTransformUtils.preCheckCast(new i(this), SurnameGridView.a.class, "com.obric.memorydata.plugin"));
        SurnameGridView r24 = this.H;
        Intrinsics.checkNotNull(r24);
        r24.setOnItemClickListener(new $$Lambda$OIndexScrollbar$fRfCi500cdrmZGieGUeUlw7hyv0(this));
        boolean r25 = true;
        if (this.G != null) goto L26;
        PopupWindow r26 = new PopupWindow();
        this.G = r26;
        Intrinsics.checkNotNull(r26);
        r26.setWindowLayoutMode(-2, -2);
        PopupWindow r27 = this.G;
        Intrinsics.checkNotNull(r27);
        r27.setBackgroundDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        PopupWindow r28 = this.G;
        Intrinsics.checkNotNull(r28);
        r28.setClippingEnabled(true);
    L26:
        PopupWindow r29 = this.G;
        Intrinsics.checkNotNull(r29);
        r29.setContentView(r9);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r30 = new int[2];
        r19.getLocationOnScreen(r30);
        if (this.c == false) goto L29;
        Log.d(this.f13899b, "alphabetView.getWidth = " + r19.getWidth() + ", alphabetView.getHeight = " + r19.getHeight());
    L29:
        int r110 = r30[0] + (r19.getWidth() / 2);
        int r111 = r30[1] + (r19.getHeight() / 2);
        if (this.c == false) goto L32;
        Log.d(this.f13899b, "alphabet anchorX = " + r30[0] + ", anchorY = " + r30[1]);
    L32:
        r9.measure(0, 0);
        int r31 = r9.getMeasuredWidth();
        int r32 = r9.getMeasuredHeight();
        if (this.c == false) goto L35;
        Log.d(this.f13899b, "popMeasureWidth = " + r31 + ", popMeasureHeight = " + r32);
    L35:
        int r33 = this.U;
        if (r20 < r33) goto L38;
    L39:
        if (r20 < r33) goto L45;
        if (r20 >= (r33 * 2)) goto L45;
        if (this.S <= 3) goto L45;
    L59:
        if (r25 == false) goto L61;
        View r34 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_top_arrow, OaidModel.KEY_ID, "surname_popup_top_arrow"));
        Objects.requireNonNull(r34, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r35 = (ImageView) ZeusTransformUtils.preCheckCast(r34, ImageView.class, "com.obric.memorydata.plugin");
        int r112 = r111 + this.N;
    L62:
        r35.setVisibility(0);
        r35.measure(0, 0);
        int r36 = r35.getMeasuredWidth();
        if (this.c == false) goto L65;
        Log.d(this.f13899b, Intrinsics.stringPlus("arrowWidth = ", Integer.valueOf(r36)));
    L65:
        int r113 = r31 / 2;
        int r37 = r110 - r113;
        int r38 = r36 / 2;
        int r39 = (r31 - ((int) Math.min(getScreenWidth() - r110, r113))) - r38;
        View r40 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_top_mask, OaidModel.KEY_ID, "surname_top_mask"));
        Objects.requireNonNull(r40, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r41 = (ImageView) ZeusTransformUtils.preCheckCast(r40, ImageView.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r114 = r41.getLayoutParams();
        Objects.requireNonNull(r114, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r114, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r115.width = this.R * this.L;
        View r116 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_bottom_mask, OaidModel.KEY_ID, "surname_bottom_mask"));
        Objects.requireNonNull(r116, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r116, ImageView.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r117 = r1.getLayoutParams();
        Objects.requireNonNull(r117, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r118 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r117, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r118.width = this.R * this.L;
        View r42 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_container, OaidModel.KEY_ID, "surname_container"));
        Objects.requireNonNull(r42, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r43 = (LinearLayout) ZeusTransformUtils.preCheckCast(r42, LinearLayout.class, "com.obric.memorydata.plugin");
        int r44 = this.R;
        int r119 = this.T;
        if (r44 != r119) goto L72;
        int r45 = this.f13898J;
        ImageView r120 = r41;
        if (r119 != r45) goto L70;
        r43.setPadding(a(14.0d), a(1.5d), a(17.0d), a(4.0d));
        r39 = r39 + ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.surname_arrow_offset_x, "dimen", "surname_arrow_offset_x"));
        r115.leftMargin = a(20.0d);
        int r46 = a(20.0d);
    L71:
        r118.leftMargin = r46;
        int r47 = r37;
    L74:
        if (this.c == false) goto L76;
        Log.d(this.f13899b, Intrinsics.stringPlus("arrowTranslationX = ", Integer.valueOf(r39)));
    L76:
        r35.setTranslationX(r39);
        r120.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r115, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r118, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (Math.abs(getX() - this.j) <= a(1.0d)) goto L80;
        Log.d(this.f13899b, "GridView is hiding now...");
        return;
    L80:
        PopupWindow r48 = this.G;
        Intrinsics.checkNotNull(r48);
        r48.showAtLocation((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0, r47, r112);
        return;
    L70:
        int r49 = ((r45 * a(40.0d)) - (this.R * this.L)) / 2;
        r43.setPadding(a(14.0d) + r49, a(1.5d), a(17.0d) + r49, a(4.0d));
        r39 = r110 - r38;
        r115.leftMargin = a(20.0d) + r49;
        r46 = a(20.0d) + r49;
        goto L71
    L72:
        r120 = r41;
        r47 = r37 - 1;
        goto L74
    L61:
        View r50 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_bottom_arrow, OaidModel.KEY_ID, "surname_popup_bottom_arrow"));
        Objects.requireNonNull(r50, "null cannot be cast to non-null type android.widget.ImageView");
        r35 = (ImageView) ZeusTransformUtils.preCheckCast(r50, ImageView.class, "com.obric.memorydata.plugin");
        r112 = (r111 - r32) - this.N;
    L45:
        if (r20 < (r33 * 2)) goto L51;
        if (r20 >= (r33 * 3)) goto L51;
        if (this.S > 5) goto L59;
    L51:
        if (r20 >= (r33 * 3)) goto L53;
    L57:
        r25 = false;
        goto L59
    L53:
        if (r20 >= (r33 * 4)) goto L57;
        if (this.S <= 7) goto L57;
    L38:
        if (this.S > 1) goto L59;
    L19:
        r15 = r13 * this.M;
        goto L20
    L85:
        return;
    L83:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    public static final /* synthetic */ void b(OIndexScrollbar r0) {
        r0.g();
    }

    private static final void b(OIndexScrollbar r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.widget.TextView");
        String r4 = ((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin")).getText().toString();
        e r0 = r2.w;
        Intrinsics.checkNotNull(r0);
        r0.b(r4);
        r2.c();
    }

    public static final /* synthetic */ void b(OIndexScrollbar r0, boolean r1) {
        r0.y = r1;
    }

    private static final boolean b(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.ah == true) goto L5;
        return false;
    L5:
        com.obric.oui.indexscrollbar.a r5 = com.obric.oui.indexscrollbar.a.f13913a;
        a r6 = r0.h;
        Intrinsics.checkNotNull(r6);
        if (r5.e(r6.a(r3)) == true) goto L13;
        com.obric.oui.indexscrollbar.a r7 = com.obric.oui.indexscrollbar.a.f13913a;
        String r8 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r8, "getDefault().language");
        int r9 = r7.d(r8);
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        if (r9 != 1) goto L10;
        r0.a(r2, r3);
    L11:
        r0.af = true;
        return true;
    L10:
        r0.b(r2, r3);
        goto L11
    L13:
        return false;
    }

    public static final /* synthetic */ void c(OIndexScrollbar r0) {
        r0.i();
    }

    private static final void c(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Object r5 = r1.getItemAtPosition(r3);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.String");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        e r7 = r0.w;
        Intrinsics.checkNotNull(r7);
        r7.b(r6);
        r0.c();
    }

    public static final /* synthetic */ void c(OIndexScrollbar r0, boolean r1) {
        r0.setLettersBarBg(r1);
    }

    public static final /* synthetic */ SurnameGridView d(OIndexScrollbar r0) {
        return r0.H;
    }

    private final void d() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.quickbar_left_letters_bar, OaidModel.KEY_ID, "quickbar_left_letters_bar"));
        Objects.requireNonNull(r0, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
        LettersBar r1 = (LettersBar) ZeusTransformUtils.preCheckCast(r0, LettersBar.class, "com.obric.memorydata.plugin");
        this.e = r1;
        Intrinsics.checkNotNull(r1);
        r1.setLetters(this.z);
        LettersBar r2 = this.e;
        Intrinsics.checkNotNull(r2);
        r2.setListener((LettersBar.b) ZeusTransformUtils.preCheckCast(new g(this), LettersBar.b.class, "com.obric.memorydata.plugin"));
        LettersBar r3 = this.e;
        Intrinsics.checkNotNull(r3);
        r3.setOnBackgroundVisibleChangedListener((LettersBar.c) ZeusTransformUtils.preCheckCast(new h(this), LettersBar.c.class, "com.obric.memorydata.plugin"));
        a();
    }

    public static final /* synthetic */ void d(OIndexScrollbar r0, boolean r1) {
        r0.x = r1;
    }

    public static final /* synthetic */ GridView e(OIndexScrollbar r0) {
        return r0.f;
    }

    private final void e() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.quickbar_right_grid_view, OaidModel.KEY_ID, "quickbar_right_grid_view"));
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.widget.GridView");
        this.f = (GridView) ZeusTransformUtils.preCheckCast(r0, GridView.class, "com.obric.memorydata.plugin");
        a r1 = new a(this, this.d);
        this.h = r1;
        Intrinsics.checkNotNull(r1);
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f13913a;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        r1.a(r2.b(r3));
        GridView r4 = this.f;
        Intrinsics.checkNotNull(r4);
        r4.setAdapter((ListAdapter) ZeusTransformUtils.preCheckCast(this.h, ListAdapter.class, "com.obric.memorydata.plugin"));
        GridView r5 = this.f;
        Intrinsics.checkNotNull(r5);
        r5.setOnItemClickListener(new $$Lambda$OIndexScrollbar$dFZDom_lr9HN3lRj6HeYDrCtEvQ(this));
        GridView r6 = this.f;
        Intrinsics.checkNotNull(r6);
        r6.setOnTouchListener(new $$Lambda$OIndexScrollbar$9Cis1rLBFVoKuSV84U5jAxJk8I(this));
        GridView r7 = this.f;
        Intrinsics.checkNotNull(r7);
        r7.setOnItemLongClickListener(new $$Lambda$OIndexScrollbar$oDbXM6RxqoQgB6hxKEUH3ocLhlU(this));
    }

    public static final /* synthetic */ int f(OIndexScrollbar r0) {
        return r0.n;
    }

    private final void f() {
        c r0 = this.v;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.a();
    L5:
        AnimatorSet r1 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.j})});
        Intrinsics.checkNotNullExpressionValue(r2, "ofPropertyValuesHolder(this, pvhX)");
        r1.play((Animator) ZeusTransformUtils.preCheckCast(r2, Animator.class, "com.obric.memorydata.plugin"));
        r1.setDuration(200);
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new j(this), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r1.start();
    }

    public static final /* synthetic */ int g(OIndexScrollbar r0) {
        return r0.L;
    }

    private final void g() {
        setX(this.j);
        setState(this.q);
        setLettersBarBg(true);
    }

    private final void getParentxPos() {
        if (this.ab == this.aa) goto L5;
        return;
    L5:
        ViewParent r0 = getParent();
        Intrinsics.checkNotNullExpressionValue(r0, "this@OIndexScrollbar.getParent()");
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L9;
        int[] r1 = new int[2];
        ((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")).getLocationInWindow(r1);
        this.ab = r1[0];
        return;
    }

    private final int getScreenWidth() {
        Point r0 = new Point();
        Context r3 = this.d;
        Intrinsics.checkNotNull(r3);
        Object r4 = r3.getSystemService("window");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) ZeusTransformUtils.preCheckCast(r4, WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay().getSize(r0);
        return r0.x;
    }

    public static final /* synthetic */ int h(OIndexScrollbar r0) {
        return r0.M;
    }

    private final void h() {
        j();
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.i})});
        Intrinsics.checkNotNullExpressionValue(r1, "ofPropertyValuesHolder(this, pvhX)");
        r0.play((Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.memorydata.plugin"));
        r0.setDuration(200);
        r0.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new f(this), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r0.start();
    }

    public static final /* synthetic */ int i(OIndexScrollbar r0) {
        return r0.T;
    }

    private final void i() {
        setState(this.o);
        setX(this.i);
        setLettersBarBg(false);
    }

    private final void j() {
        PopupWindow r0 = this.G;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.dismiss();
        this.G = null;
        this.H = null;
        this.I = null;
    L5:
        PopupWindow r1 = this.V;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r1);
        r1.dismiss();
        this.V = null;
        this.W = null;
        return;
    }

    public static /* synthetic */ void lambda$3jfd_zIEyEj8YoucPwwY55z91EU(OIndexScrollbar r0, View r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$9Cis1rLBFVoKuSV84U5jAxJk-8I, reason: not valid java name */
    public static /* synthetic */ boolean m1311lambda$9Cis1rLBFVoKuSV84U5jAxJk8I(OIndexScrollbar r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$T27Y7Ak-l6vXUJhWZHn1AC7YD0M, reason: not valid java name */
    public static /* synthetic */ boolean m1312lambda$T27Y7Akl6vXUJhWZHn1AC7YD0M(OIndexScrollbar r0, TextView r1, View r2, MotionEvent r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$dFZDom_lr9HN3lRj6HeYDrCtEvQ(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$fRfCi500cdrmZGieGUeUlw7hyv0(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        c(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean lambda$oDbXM6RxqoQgB6hxKEUH3ocLhlU(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        return b(r0, r1, r2, r3, r4);
    }

    private final void setHostWidth(int r4) {
        int r0 = (r4 - this.l) - this.m;
        this.i = r0;
        int r5 = r4 - this.k;
        this.j = r5;
        int r1 = this.r;
        if (r1 != this.o) goto L6;
        float r6 = r0;
    L9:
        setX(r6);
        if (this.c == false) goto L12;
        Log.d(this.f13899b, Intrinsics.stringPlus("mStartX = ", Integer.valueOf(this.i)));
    L12:
        invalidate();
        return;
    L6:
        if (r1 != this.q) goto L8;
        r6 = r5;
        goto L9
    L8:
        r6 = getX();
        goto L9
    }

    private final void setLettersBarBg(boolean r2) {
        LettersBar r0 = this.e;
        Intrinsics.checkNotNull(r0);
        r0.setShowBg(r2);
        setShadowVisible(r2);
    }

    private final void setShadowVisible(boolean r1) {
        View r0 = this.g;
        Intrinsics.checkNotNull(r0);
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    private final void setState(int r2) {
        this.r = r2;
        LettersBar r0 = this.e;
        Intrinsics.checkNotNull(r0);
        if (r2 != this.o) goto L5;
        boolean r1 = true;
    L6:
        r0.setSettled(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void a() {
        this.z.clear();
        int[] r0 = this.A;
        int r1 = 0;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        int r4 = r3 + 1;
        List<com.obric.oui.indexscrollbar.b> r5 = this.z;
        com.obric.oui.indexscrollbar.b.a r6 = com.obric.oui.indexscrollbar.b.f13915a;
        int[] r7 = this.A;
        Intrinsics.checkNotNull(r7);
        String r8 = String.valueOf(r7[r3]);
        Bitmap[][] r9 = this.B;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mIconsForSymbols");
        r9 = null;
    L9:
        r5.add(r6.a(r8, r9[r3]));
        r3 = r4;
        goto L5
    L10:
        int[] r10 = this.A;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.length;
    L12:
        com.obric.oui.indexscrollbar.c r12 = com.obric.oui.indexscrollbar.c.f13917a;
        String r13 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r13, "getDefault().language");
        String[] r14 = r12.a(r13);
        int r15 = r14.length - 1;
    L13:
        if (r1 >= r15) goto L20;
        int r16 = r1 + 1;
        com.obric.oui.indexscrollbar.c r17 = com.obric.oui.indexscrollbar.c.f13917a;
        String r18 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r18, "getDefault().language");
        if (r17.a(r18, r1) == false) goto L17;
        List<com.obric.oui.indexscrollbar.b> r19 = this.z;
        com.obric.oui.indexscrollbar.b r20 = com.obric.oui.indexscrollbar.b.f13915a.b(r14[r1]);
    L18:
        r19.add(r20);
        r1 = r16;
        goto L13
    L17:
        r19 = this.z;
        r20 = com.obric.oui.indexscrollbar.b.f13915a.a(r14[r1]);
        goto L18
    L20:
        if (this.C == true) goto L22;
    L25:
        invalidate();
        return;
    L22:
        if (this.F != this.D) goto L24;
        this.z.add(r11, com.obric.oui.indexscrollbar.b.f13915a.a());
        goto L25
    L24:
        this.z.add(com.obric.oui.indexscrollbar.b.f13915a.a());
        goto L25
    L11:
        r11 = 0;
        goto L12
    }

    public final void a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Context r9 = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.d = r9;
        Intrinsics.checkNotNull(r9);
        Resources r10 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin");
        ZeusTransformUtils.inflate(LayoutInflater.from(this.d), ZeusTransformUtils.mapRes(R.layout.o_index_scrollbar, "layout", "o_index_scrollbar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        this.l = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22);
        int r0 = r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.bytedance_quickbar_grid_item_space, "dimen", "bytedance_quickbar_grid_item_space"));
        int r3 = r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.quickbar_ex_grid_column_width, "dimen", "quickbar_ex_grid_column_width"));
        this.ac = r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.bytedance_quickbar_min_distance, "dimen", "bytedance_quickbar_min_distance"));
        this.m = r10.getDrawable(ZeusTransformUtils.mapRes(R.drawable.letters_bar_background_shadow, "drawable", "letters_bar_background_shadow")).getIntrinsicWidth();
        int r1 = (r0 * 2) + this.l;
        Context r11 = this.d;
        Intrinsics.checkNotNull(r11);
        this.k = (r1 + (r3 * ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.bytedance_letterbar_gridview_column_num, TypedValues.Custom.S_INT, "bytedance_letterbar_gridview_column_num")))) + this.m;
        d();
        e();
        this.g = findViewById(ZeusTransformUtils.mapRes(R.id.iv_letter_bar_shadow, OaidModel.KEY_ID, "iv_letter_bar_shadow"));
        setLettersBarBg(false);
    }

    public final void a(boolean r2) {
        j();
        if (b() == true) goto L8;
        if (r2 == false) goto L6;
        h();
        return;
    L6:
        i();
        return;
    }

    public final boolean b() {
        if (this.x == false) goto L5;
    L8:
        return true;
    L5:
        if (this.r == this.o) goto L8;
        return false;
    }

    public final void c() {
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        com.obric.oui.indexscrollbar.a r0 = com.obric.oui.indexscrollbar.a.f13913a;
        String r1 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r1, "getDefault().language");
        if (r0.c(r1) == false) goto L5;
        getParentxPos();
        int r2 = r9.getAction();
        r9.getX();
        r9.getY();
        float r3 = r9.getRawX() - this.ab;
        if (r2 == 0) goto L59;
        if (r2 == 1) goto L31;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L31;
    L71:
        boolean r4 = false;
    L72:
        if (r4 == false) goto L74;
        return true;
    L74:
        if (super.dispatchTouchEvent(r9) == false) goto L77;
        return true;
    L77:
        return false;
    L15:
        if (this.af == false) goto L17;
        a(r9);
        goto L71
    L17:
        float r5 = this.u;
        this.t = r5;
        this.u = r3;
        int r6 = this.r;
        if (r6 != this.o) goto L21;
        int r7 = (r3 > this.i ? 1 : (r3 == this.i ? 0 : -1));
        goto L71
    L21:
        if (r6 == this.p) goto L71;
        if (r6 != this.q) goto L71;
        if ((r3 - r5) <= this.ac) goto L71;
        if (r5 <= this.j) goto L71;
    L29:
        r4 = true;
    L31:
        if (this.af == false) goto L45;
        com.obric.oui.indexscrollbar.a r8 = com.obric.oui.indexscrollbar.a.f13913a;
        String r10 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r10, "getDefault().language");
        if (r8.d(r10) != 1) goto L40;
        if (this.ag < 0) goto L44;
        SurnameFlowLayout r11 = this.I;
        if (r11 == null) goto L44;
        Intrinsics.checkNotNull(r11);
        View r12 = r11.getChildAt(this.ag);
        Intrinsics.checkNotNullExpressionValue(r12, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r12.setPressed(false);
        r12.performClick();
    L44:
        this.ag = -1;
        goto L71
    L40:
        if (this.ag < 0) goto L44;
        SurnameGridView r13 = this.H;
        if (r13 == null) goto L44;
        Intrinsics.checkNotNull(r13);
        View r14 = r13.getChildAt(this.ag);
        Intrinsics.checkNotNullExpressionValue(r14, "mPopupGridView!!.getChildAt(mPrePosition)");
        r14.setPressed(false);
        SurnameGridView r15 = this.H;
        Intrinsics.checkNotNull(r15);
        r15.performItemClick(r14, this.ag, -1);
        goto L44
    L45:
        this.s = 0.0f;
        if (getX() != this.i) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == false) goto L52;
        setLettersBarBg(false);
        goto L71
    L52:
        if (this.r != this.p) goto L71;
        if ((this.u - this.t) <= 0.0f) goto L56;
    L58:
        h();
        goto L29
    L56:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L58;
        f();
        goto L29
    L48:
        r16 = false;
        goto L49
    L59:
        this.af = false;
        OIndexScrollbar r17 = (OIndexScrollbar) ZeusTransformUtils.preCheckCast(this, OIndexScrollbar.class, "com.obric.memorydata.plugin");
        r17.u = r3;
        r17.t = r3;
        int r18 = this.r;
        if (r18 != this.o) goto L62;
        this.s = 0.0f;
    L62:
        int r19 = this.q;
        if (r18 != r19) goto L65;
        this.s = r3 - this.j;
    L65:
        if (r18 != r19) goto L71;
        PopupWindow r20 = this.G;
        if (r20 == null) goto L71;
        Intrinsics.checkNotNull(r20);
        if (r20.isShowing() == false) goto L71;
        PopupWindow r21 = this.G;
        Intrinsics.checkNotNull(r21);
        r21.dismiss();
        goto L71
    L5:
        return super.dispatchTouchEvent(r9);
    }

    public final LettersBar getLetterBar() {
        return this.e;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.c;
    }

    public final String getOIndexScrollbar_TAG() {
        return this.f13899b;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.E;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.D;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.ae;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        this.n = a(r4);
        int r5 = View.MeasureSpec.getSize(r3);
        ViewParent r6 = getParent();
        if (r6 == null) goto L7;
        int r7 = ((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin")).getMeasuredWidth();
        if (r7 <= 0) goto L9;
        setHostWidth(r7);
    L9:
        if (this.c == false) goto L12;
        Log.d(this.f13899b, "measure width:" + r5 + "  parentWidth:" + r7);
        return;
    L12:
        return;
    L7:
        r7 = 0;
        goto L9
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 8) goto L11;
        if (r2 != this) goto L12;
        PopupWindow r4 = this.G;
        if (r4 == null) goto L13;
        Intrinsics.checkNotNull(r4);
        if (r4.isShowing() == false) goto L14;
        PopupWindow r1 = this.G;
        Intrinsics.checkNotNull(r1);
        r1.dismiss();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void setLongPressEnabled(boolean r1) {
        this.ah = r1;
    }

    public final void setPoundPosition(int r1) {
        this.F = r1;
    }

    public final void setPoundVisibility(boolean r1) {
        this.C = r1;
    }

    public final void setQBListener(c r3) {
        this.v = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setSurnameListener(e r3) {
        this.w = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
    }
}
