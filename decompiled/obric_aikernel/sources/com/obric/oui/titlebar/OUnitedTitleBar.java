package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.k;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u0002:\b\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aJ\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\tJ\u0006\u0010+\u001a\u00020\tJ\u0010\u0010,\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010-\u001a\u00020\tJ\u0012\u00100\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.J\u0006\u00101\u001a\u00020\tJ\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020\u000fJ\u0006\u00104\u001a\u00020\tJ\u0006\u00105\u001a\u00020\tJ\f\u00107\u001a\u0006\u0012\u0002\b\u000306H\u0016R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u000f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010U\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\t8\u0002@\u0003X\u0083D¢\u0006\u0006\n\u0004\b[\u0010VR\u0018\u0010\\\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\b%\u0010cR\u0016\u0010d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010VR\u0016\u0010e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010VR\u001e\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR$\u0010i\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010o\u001a\u00020\t8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bo\u0010V\u001a\u0004\bp\u0010XR$\u0010q\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010N\u001a\u0004\br\u0010P\"\u0004\bs\u0010RR$\u0010t\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010@\u001a\u0004\bu\u0010B\"\u0004\bv\u0010DR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\u000f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bz\u0010TR\"\u0010{\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010T\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR&\u0010\u0080\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010V\u001a\u0005\b\u0081\u0001\u0010X\"\u0005\b\u0082\u0001\u0010ZR(\u0010\u0083\u0001\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010:\u001a\u0005\b\u0084\u0001\u0010<\"\u0005\b\u0085\u0001\u0010>R'\u0010\u0086\u0001\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0005\b\u0086\u0001\u0010`\u001a\u0005\b\u0087\u0001\u0010b\"\u0004\b$\u0010c¨\u0006\u008f\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "getSnapRange", "Landroid/view/View;", "defaultScrollingView", "findLiftOnScrollTargetView", "updateWillNotDraw", "", "shouldDrawStatusBarForeground", "getScrollRange", "Lcom/obric/oui/titlebar/OUnitedTitleBar$c;", "listener", "addOnOffsetChangeListener", "removeOnOffsetChangeListener", "expanded", "setExpanded", TypedValues.CycleType.S_WAVE_OFFSET, "dispatchOffsetChange", "Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "onHeaderFlingUnConsumedListener", "setOnHeaderFlingUnConsumedListener", "Landroid/view/ViewGroup$LayoutParams;", "p", "Lcom/obric/oui/titlebar/behavior/BaseBehavior$LayoutParams;", "generateLayoutParams", "setupView", "registerTransform", "view", "setLeftAction", "setRightAction", "isLiftOnScroll", "lifted", "setLiftedState", "hasScrollableChildren", "getDownNestedScrollRange", "getUpNestedPreScrollRange", "shouldLift", "getTopInset", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onWindowInsetChanged", "getPendingAction", "resetPendingAction", "hasChildWithInterpolator", "getTotalScrollRange", "getDownNestedPreScrollRange", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "Landroid/graphics/drawable/Drawable;", "rightActionSrc", "Landroid/graphics/drawable/Drawable;", "getRightActionSrc", "()Landroid/graphics/drawable/Drawable;", "setRightActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "divider", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "setDivider", "(Landroid/view/View;)V", "", "titleText", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "haveChildWithInterpolator", "Z", "textInitPos", "I", "getTextInitPos", "()I", "setTextInitPos", "(I)V", "liftOnScrollTargetViewId", "lastInsets", "Landroidx/core/view/WindowInsetsCompat;", "Landroid/view/ViewGroup;", "rightAction", "Landroid/view/ViewGroup;", "getRightAction", "()Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "mPendingAction", "downScrollRange", "", "mOnOffsetChangeListeners", "Ljava/util/List;", "mOnHeaderFlingUnConsumedListener", "Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "setMOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$b;)V", "INVALID_SCROLL_RANGE", "getINVALID_SCROLL_RANGE", "mTvSubTitle", "getMTvSubTitle", "setMTvSubTitle", "bottomAction", "getBottomAction", "setBottomAction", "Ljava/lang/ref/WeakReference;", "liftOnScrollTargetView", "Ljava/lang/ref/WeakReference;", "liftOnScroll", "inDebug", "getInDebug", "()Z", "setInDebug", "(Z)V", "mCollapsePosition", "getMCollapsePosition", "setMCollapsePosition", "leftActionSrc", "getLeftActionSrc", "setLeftActionSrc", "leftAction", "getLeftAction", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "Behavior", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int ACTION_MARGIN_TOP = 0;
    private static final int COLLAPSE_HEIGHT = 0;
    public static final int COLLAPSE_ON_CENTER = 0;
    public static final int COLLAPSE_ON_LEFT = 1;
    public static final float COLLAPSE_TEXT_SIZE_ON_CENTER = 16.0f;
    public static final float COLLAPSE_TEXT_SIZE_ON_LEFT = 20.0f;
    public static final a Companion = null;
    private static final int EXPANDED_HEIGHT = 0;
    public static final float EXPANDED_TEXT_SIZE = 40.0f;
    public static final int PENDING_ACTION_ANIMATED = 16;
    public static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    public static final int PENDING_ACTION_COLLAPSED = 1;
    public static final int PENDING_ACTION_EXPANDED = 16;
    public static final int PENDING_ACTION_FORCE = 8;
    public static final int PENDING_ACTION_NONE = 0;
    private static final int TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = 0;
    private static final int TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = 0;
    private static final int TITLE_EXPANDED_MARGIN_BOTTOM = 0;
    private final int INVALID_SCROLL_RANGE;
    private View bottomAction;
    private View divider;
    private int downScrollRange;
    private final boolean haveChildWithInterpolator;
    private boolean inDebug;
    private WindowInsetsCompat lastInsets;
    private ViewGroup leftAction;
    private Drawable leftActionSrc;
    private final boolean liftOnScroll;
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private final int liftOnScrollTargetViewId;
    private int mCollapsePosition;
    private b mOnHeaderFlingUnConsumedListener;
    private List<c> mOnOffsetChangeListeners;
    private int mPendingAction;
    private TextView mTvSubTitle;
    private TextView mTvTitle;
    private ViewGroup rightAction;
    private Drawable rightActionSrc;
    private int textInitPos;
    private String titleText;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0016¢\u0006\u0004\bD\u0010EB\u001d\b\u0016\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bD\u0010JJ,\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u0010\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J4\u0010\u0019\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J2\u0010\u001c\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u001c\u0010\u001d\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u001e\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002J \u0010 \u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J0\u0010$\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0016J8\u0010)\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016J@\u0010.\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020!2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0016J \u0010/\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020!H\u0016J0\u00101\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020!2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0016J8\u00102\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020!2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0012H\u0016R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b;\u0010:\u001a\u0004\b<\u0010=R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010:R\u0016\u0010B\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00107R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010:¨\u0006K"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "child", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "velocity", "", "animateOffsetTo", "parent", "header", TypedValues.AttributesType.S_TARGET, "duration", "animateToOffset", "view", "", "canDragView", "getMaxDragOffset", "getScrollRangeForDragFling", "newOffset", "minOffset", "maxOffset", "setHeaderTopBottomOffset", "layout", "velocityY", "fling", "onFlingFinished", "checkSnap", "layoutDirection", "onLayoutChild", "Landroid/view/View;", "directTargetChild", "nestedScrollAxes", "onStartNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "onStopNestedScroll", "velocityX", "onNestedPreFling", "onNestedFling", "Landroid/animation/ValueAnimator;", "mOffsetAnimator", "Landroid/animation/ValueAnimator;", "mSkipNestedPreScroll", "Z", "mShouldDispatchFling", "mTempFlingDispatchConsumed", "I", "offsetDelta", "getOffsetDelta", "()I", "Ljava/lang/ref/WeakReference;", "mLastNestedScrollingChildRef", "Ljava/lang/ref/WeakReference;", "mTempFlingMaxOffset", "mWasFlung", "mTempFlingMinOffset", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimator mOffsetAnimator;
        private boolean mShouldDispatchFling;
        private boolean mSkipNestedPreScroll;
        private int mTempFlingDispatchConsumed;
        private int mTempFlingMaxOffset;
        private int mTempFlingMinOffset;
        private boolean mWasFlung;
        private final int offsetDelta;

        static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Behavior f7719c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f7720g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ OUnitedTitleBar f7721h;

            a(Behavior r10, CoordinatorLayout r11, OUnitedTitleBar r12) {
                this.f7719c = r10;
                this.f7720g = r11;
                this.f7721h = r12;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r10) {
                Intrinsics.checkNotNullParameter(r10, "animation");
                Behavior r11 = this.f7719c;
                CoordinatorLayout r12 = this.f7720g;
                OUnitedTitleBar r13 = this.f7721h;
                Object r14 = r10.getAnimatedValue();
                Objects.requireNonNull(r14, "null cannot be cast to non-null type kotlin.Int");
                r11.setHeaderTopBottomOffset(r12, r13, ((Integer) r14).intValue());
            }
        }

        public Behavior() {
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        private final void animateOffsetTo(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, float r13) {
            int r14 = Math.abs(getTopBottomOffsetForScrollingSibling() - r12);
            float r15 = Math.abs(r13);
            if (r15 <= 0) goto L5;
            int r16 = Math.round(1000 * (r14 / r15));
        L6:
            animateToOffset(r10, r11, r12, r16);
            return;
        L5:
            Intrinsics.checkNotNull(r11);
            r16 = (int) (((r14 / r11.getHeight()) + 1) * 150);
            goto L6
        }

        private final void animateToOffset(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13) {
            int r14 = getTopAndBottomOffset();
            if (r14 != r12) goto L7;
            ValueAnimator r15 = this.mOffsetAnimator;
            if (r15 == null) goto L7;
            Intrinsics.checkNotNull(r15);
            r15.cancel();
        L7:
            ValueAnimator r16 = this.mOffsetAnimator;
            if (r16 != null) goto L10;
            ValueAnimator r17 = new ValueAnimator();
            this.mOffsetAnimator = r17;
            Intrinsics.checkNotNull(r17);
            r17.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r18 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r18);
            r18.addUpdateListener(new a(this, r10, r11));
        L11:
            ValueAnimator r19 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r19);
            r19.setDuration(r13);
            ValueAnimator r20 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r20);
            r20.setIntValues(new int[]{r14, r12});
            ValueAnimator r21 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r21);
            r21.start();
            return;
        L10:
            Intrinsics.checkNotNull(r16);
            r16.cancel();
            goto L11
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
            return canDragView((OUnitedTitleBar) r10);
        }

        public boolean canDragView(OUnitedTitleBar r10) {
            WeakReference<View> r11 = this.mLastNestedScrollingChildRef;
            if (r11 == null) goto L15;
            Intrinsics.checkNotNull(r11);
            View r12 = r11.get();
            if (r12 != null) goto L7;
        L13:
            return false;
        L7:
            if (r12.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r12, -1) == true) goto L13;
            int r13 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r10);
            if (r13 <= (-OUnitedTitleBar.access$getScrollRange(r10))) goto L13;
            return true;
        L15:
            return true;
        }

        public final boolean checkSnap(CoordinatorLayout r10, OUnitedTitleBar r11) {
            int r12 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r11);
            int r13 = -OUnitedTitleBar.access$getSnapRange(r11);
            if (r12 <= r13) goto L11;
            if (r12 >= 0) goto L11;
            if (r12 < ((r13 + 0) / 2)) goto L9;
            r13 = 0;
        L9:
            animateOffsetTo(r10, r11, r13, 0.0f);
            return true;
        L11:
            return false;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r10, View r11, int r12, int r13, float r14) {
            return fling(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public boolean fling(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, float r14) {
            Intrinsics.checkNotNullParameter(r11, "layout");
            if (r14 >= 0) goto L6;
            this.mShouldDispatchFling = true;
            this.mTempFlingDispatchConsumed = 0;
            this.mTempFlingMinOffset = r12;
            this.mTempFlingMaxOffset = r13;
            r12 = Integer.MIN_VALUE;
            r13 = Integer.MAX_VALUE;
        L6:
            return super.fling(r10, r11, r12, r13, r14);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r10) {
            return getMaxDragOffset((OUnitedTitleBar) r10);
        }

        public int getMaxDragOffset(OUnitedTitleBar r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            return -OUnitedTitleBar.access$getScrollRange(r10);
        }

        public final int getOffsetDelta() {
            return this.offsetDelta;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r10) {
            return getScrollRangeForDragFling((OUnitedTitleBar) r10);
        }

        public int getScrollRangeForDragFling(OUnitedTitleBar r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            return OUnitedTitleBar.access$getScrollRange(r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r10, View r11) {
            onFlingFinished(r10, (OUnitedTitleBar) r11);
        }

        public void onFlingFinished(CoordinatorLayout r10, OUnitedTitleBar r11) {
            this.mShouldDispatchFling = false;
            checkSnap(r10, r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
            return onLayoutChild(r10, (OUnitedTitleBar) r11, r12);
        }

        public boolean onLayoutChild(CoordinatorLayout r10, OUnitedTitleBar r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "parent");
            Intrinsics.checkNotNullParameter(r11, "child");
            boolean r13 = super.onLayoutChild(r10, r11, r12);
            if (OUnitedTitleBar.access$getMPendingAction$p(r11) != 0) goto L5;
        L11:
            r11.dispatchOffsetChange(getTopAndBottomOffset());
            return r13;
        L5:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r11) & 1) == 0) goto L9;
            int r14 = -OUnitedTitleBar.access$getScrollRange(r11);
        L7:
            setHeaderTopBottomOffset(r10, r11, r14);
            goto L11
        L9:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r11) & 16) == 0) goto L11;
            r14 = 0;
            goto L7
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14, boolean r15) {
            return onNestedFling(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        public boolean onNestedFling(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, float r13, float r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r11, "child");
            Intrinsics.checkNotNullParameter(r12, TypedValues.AttributesType.S_TARGET);
            this.mWasFlung = true;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14) {
            return onNestedPreFling(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public boolean onNestedPreFling(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, float r13, float r14) {
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r11, "child");
            Intrinsics.checkNotNullParameter(r12, TypedValues.AttributesType.S_TARGET);
            if (r14 > 0) goto L5;
        L8:
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.access$getScrollRange(r11))) goto L8;
            fling(r10, r11, -OUnitedTitleBar.access$getScrollRange(r11), 0, -r14);
            this.mWasFlung = true;
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int[] r15) {
            onNestedPreScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        public void onNestedPreScroll(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13, int r14, int[] r15) {
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r11, "child");
            Intrinsics.checkNotNullParameter(r12, TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullParameter(r15, "consumed");
            if (r14 > 0) goto L5;
            return;
        L5:
            if (this.mSkipNestedPreScroll == true) goto L9;
            r15[1] = scroll(r10, r11, r14, -OUnitedTitleBar.access$getScrollRange(r11), 0);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int r15, int r16) {
            onNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16);
        }

        public void onNestedScroll(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13, int r14, int r15, int r16) {
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r11, "child");
            Intrinsics.checkNotNullParameter(r12, TypedValues.AttributesType.S_TARGET);
            if (r16 >= 0) goto L5;
            scroll(r10, r11, r16, -OUnitedTitleBar.access$getScrollRange(r11), 0);
            boolean r17 = true;
        L6:
            this.mSkipNestedPreScroll = r17;
            return;
        L5:
            r17 = false;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14) {
            return onStartNestedScroll(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public boolean onStartNestedScroll(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, View r13, int r14) {
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r11, "child");
            Intrinsics.checkNotNullParameter(r12, "directTargetChild");
            Intrinsics.checkNotNullParameter(r13, TypedValues.AttributesType.S_TARGET);
            if ((r14 & 2) > 0) goto L5;
        L9:
            boolean r15 = false;
        L10:
            if (r15 == false) goto L14;
            ValueAnimator r16 = this.mOffsetAnimator;
            if (r16 == null) goto L14;
            Intrinsics.checkNotNull(r16);
            r16.cancel();
        L14:
            this.mLastNestedScrollingChildRef = null;
            this.mWasFlung = false;
            this.mShouldDispatchFling = false;
            stopFling();
            return r15;
        L5:
            if (OUnitedTitleBar.access$getScrollRange(r11) <= 0) goto L9;
            if ((r10.getHeight() - r12.getHeight()) > r11.getHeight()) goto L9;
            r15 = true;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, View r11, View r12) {
            onStopNestedScroll(r10, (OUnitedTitleBar) r11, r12);
        }

        public void onStopNestedScroll(CoordinatorLayout r10, OUnitedTitleBar r11, View r12) {
            Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r11, "child");
            Intrinsics.checkNotNullParameter(r12, TypedValues.AttributesType.S_TARGET);
            if (this.mWasFlung == true) goto L5;
            checkSnap(r10, r11);
        L5:
            this.mSkipNestedPreScroll = false;
            this.mLastNestedScrollingChildRef = new WeakReference(r12);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
            return setHeaderTopBottomOffset(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public int setHeaderTopBottomOffset(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, int r14) {
            int r15 = getTopAndBottomOffset();
            if (this.mShouldDispatchFling == false) goto L5;
            r13 = Math.max(this.mTempFlingMinOffset, r13);
            r14 = Math.min(this.mTempFlingMaxOffset, r14);
        L5:
            int r16 = super.setHeaderTopBottomOffset(r10, r11, r12, r13, r14);
            if (r11 == null) goto L8;
            r11.dispatchOffsetChange(getTopAndBottomOffset());
        L8:
            int r17 = 0;
            if (this.mShouldDispatchFling == false) goto L19;
            if (r11 == null) goto L12;
            b r18 = r11.getMOnHeaderFlingUnConsumedListener();
        L13:
            if (r18 == null) goto L19;
            int r19 = ((r12 - r15) + r16) - this.mTempFlingDispatchConsumed;
            if (r19 == 0) goto L17;
            Intrinsics.checkNotNull(r11);
            b r110 = r11.getMOnHeaderFlingUnConsumedListener();
            Intrinsics.checkNotNull(r110);
            r17 = r110.a(r11, r12, r19);
        L17:
            this.mTempFlingDispatchConsumed += -r17;
            goto L19
        L12:
            r18 = null;
        L19:
            return r16 + r17;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a() {
            return OUnitedTitleBar.access$getACTION_MARGIN_TOP$cp();
        }

        public final int b() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp();
        }

        public final int c() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp();
        }

        public final int d() {
            return OUnitedTitleBar.access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp();
        }
    }

    public interface b {
        int a(OUnitedTitleBar r10, int r11, int r12);
    }

    public interface c {
        void a(OUnitedTitleBar r10, int r11);
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f7722a;

        d(OUnitedTitleBar r10) {
            this.f7722a = r10;
        }

        @Override // com.obric.oui.titlebar.OUnitedTitleBar.c
        public void a(OUnitedTitleBar r17, int r18) {
            ViewGroup r10 = this.f7722a.getLeftAction();
            ViewGroup.LayoutParams r11 = null;
            if (r10 == null) goto L5;
            ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        L7:
            if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
            r12 = null;
        L9:
            ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
            ViewGroup r14 = this.f7722a.getRightAction();
            if (r14 == null) goto L12;
            ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        L14:
            if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
            r15 = null;
        L16:
            ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
            TextView r19 = this.f7722a.getMTvTitle();
            if (r19 == null) goto L19;
            ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        L21:
            if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
            r11 = r20;
        L24:
            ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r11;
            a r22 = OUnitedTitleBar.Companion;
            int r23 = r22.a();
            float r24 = 16.0f;
            int r25 = r22.d();
            int r110 = r22.b();
            float r111 = (-r18) / this.f7722a.getTotalScrollRange();
            if (this.f7722a.getMCollapsePosition() != 1) goto L36;
            r110 = r22.c();
            int[] r26 = new int[2];
            TextView r112 = this.f7722a.getMTvTitle();
            if (r112 == null) goto L29;
            r112.getLocationOnScreen(r26);
        L29:
            if (r18 != 0) goto L31;
            int r113 = r26[0];
            int r27 = r26[1];
            this.f7722a.setTextInitPos(r113);
        L31:
            float r28 = this.f7722a.getTextInitPos();
            Resources r114 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
            float r29 = (r28 + MathKt.roundToInt(TypedValue.applyDimension(1, 18, r114.getDisplayMetrics()))) * r111;
            if (r21 == null) goto L34;
            r21.leftMargin = -((int) r29);
        L34:
            r24 = 20.0f;
        L36:
            if (r111 != 1) goto L40;
            View r30 = this.f7722a.getDivider();
            if (r30 == null) goto L43;
            k.h(r30);
        L43:
            if (r13 == null) goto L45;
            r13.topMargin = (-r18) + r23;
        L45:
            if (r16 == null) goto L47;
            r16.topMargin = (-r18) + r23;
        L47:
            int r31 = (int) (r25 - ((r25 - r110) * r111));
            float r32 = ((r24 - 40.0f) * new AccelerateDecelerateInterpolator().getInterpolation(r111)) + 40.0f;
            TextView r33 = this.f7722a.getMTvTitle();
            if (r33 == null) goto L50;
            r33.setTextSize(2, r32);
        L50:
            if (r21 == null) goto L52;
            r21.bottomMargin = r31;
        L52:
            ViewGroup r34 = this.f7722a.getLeftAction();
            if (r34 == null) goto L55;
            r34.setLayoutParams(r13);
        L55:
            ViewGroup r35 = this.f7722a.getRightAction();
            if (r35 == null) goto L58;
            r35.setLayoutParams(r16);
        L58:
            TextView r36 = this.f7722a.getMTvTitle();
            if (r36 == null) goto L62;
            r36.setLayoutParams(r21);
            return;
        L62:
            return;
        L40:
            View r37 = this.f7722a.getDivider();
            if (r37 == null) goto L43;
            k.f(r37);
            goto L43
        L19:
            r20 = null;
            goto L21
        L12:
            r15 = null;
            goto L14
        L5:
            r12 = null;
            goto L7
        }
    }

    static {
        Companion = new a(null);
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        COLLAPSE_HEIGHT = MathKt.roundToInt(TypedValue.applyDimension(1, 56, r10.getDisplayMetrics()));
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        EXPANDED_HEIGHT = MathKt.roundToInt(TypedValue.applyDimension(1, 240, r11.getDisplayMetrics()));
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        ACTION_MARGIN_TOP = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r12.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        TITLE_EXPANDED_MARGIN_BOTTOM = MathKt.roundToInt(TypedValue.applyDimension(1, 92, r13.getDisplayMetrics()));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = MathKt.roundToInt(TypedValue.applyDimension(1, 17, r14.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = MathKt.roundToInt(TypedValue.applyDimension(1, 14, r15.getDisplayMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OUnitedTitleBar(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OUnitedTitleBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        init(r10, r11);
        this.INVALID_SCROLL_RANGE = -1;
        this.downScrollRange = -1;
    }

    public /* synthetic */ OUnitedTitleBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ int access$getACTION_MARGIN_TOP$cp() {
        return ACTION_MARGIN_TOP;
    }

    public static final /* synthetic */ int access$getCOLLAPSE_HEIGHT$cp() {
        return COLLAPSE_HEIGHT;
    }

    public static final /* synthetic */ int access$getEXPANDED_HEIGHT$cp() {
        return EXPANDED_HEIGHT;
    }

    public static final /* synthetic */ int access$getMPendingAction$p(OUnitedTitleBar r10) {
        return r10.mPendingAction;
    }

    public static final /* synthetic */ int access$getScrollRange(OUnitedTitleBar r10) {
        return r10.getScrollRange();
    }

    public static final /* synthetic */ int access$getSnapRange(OUnitedTitleBar r10) {
        return r10.getSnapRange();
    }

    public static final /* synthetic */ int access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp() {
        return TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER;
    }

    public static final /* synthetic */ int access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp() {
        return TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT;
    }

    public static final /* synthetic */ int access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp() {
        return TITLE_EXPANDED_MARGIN_BOTTOM;
    }

    public static final /* synthetic */ void access$setMPendingAction$p(OUnitedTitleBar r10, int r11) {
        r10.mPendingAction = r11;
    }

    private final View findLiftOnScrollTargetView(View r10) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r11 = this.liftOnScrollTargetViewId;
        if (r11 == (-1)) goto L15;
        if (r10 == null) goto L8;
        View r12 = r10.findViewById(r11);
    L9:
        if (r12 == null) goto L11;
    L13:
        if (r12 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r12);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        ViewParent r13 = getParent();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.view.ViewGroup");
        r12 = ((ViewGroup) r13).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r12 = null;
    L15:
        WeakReference<View> r14 = this.liftOnScrollTargetView;
        if (r14 != null) goto L18;
        return null;
    L18:
        return r14.get();
    }

    private final int getScrollRange() {
        return EXPANDED_HEIGHT - COLLAPSE_HEIGHT;
    }

    private final int getSnapRange() {
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        return MathKt.roundToInt(TypedValue.applyDimension(1, 56, r10.getDisplayMetrics()));
    }

    private final void init(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OUnitedTitleBar);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…tyleable.OUnitedTitleBar)");
        this.titleText = r12.getString(l.OUnitedTitleBar_oui_united_title);
        this.mCollapsePosition = r12.getInt(l.OUnitedTitleBar_oui_title_collapse_position, 0);
        this.leftActionSrc = r12.getDrawable(l.OUnitedTitleBar_oui_left_action_src);
        this.rightActionSrc = r12.getDrawable(l.OUnitedTitleBar_oui_right_action_src);
        r12.recycle();
        FrameLayout.inflate(r10, h.o_united_titlebar, this);
        this.leftAction = (ViewGroup) findViewById(f.fl_left_container);
        this.rightAction = (ViewGroup) findViewById(f.fl_right_container);
        this.mTvTitle = (TextView) findViewById(f.tv_title_container);
        this.mTvSubTitle = (TextView) findViewById(f.tv_subtitle_container);
        this.bottomAction = findViewById(f.fl_bottom_container);
        this.divider = findViewById(f.divider);
        TextView r13 = this.mTvTitle;
        if (r13 == null) goto L5;
        r13.setText(this.titleText);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
        setupView();
        registerTransform();
    }

    private final boolean shouldDrawStatusBarForeground() {
        if (getTopInset() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public final void addOnOffsetChangeListener(c r10) {
        if (this.mOnOffsetChangeListeners != null) goto L5;
        this.mOnOffsetChangeListeners = new ArrayList();
    L5:
        if (r10 == null) goto L10;
        List<c> r11 = this.mOnOffsetChangeListeners;
        Intrinsics.checkNotNull(r11);
        if (r11.contains(r10) == true) goto L11;
        List<c> r12 = this.mOnOffsetChangeListeners;
        Intrinsics.checkNotNull(r12);
        r12.add(r10);
        return;
    L11:
        return;
    }

    public final void dispatchOffsetChange(int r10) {
        List<c> r11 = this.mOnOffsetChangeListeners;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNull(r11);
        Iterator<c> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        r12.next().a(this, r10);
        goto L6
    L10:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public BaseBehavior.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new BaseBehavior.LayoutParams(getContext(), r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected BaseBehavior.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new BaseBehavior.LayoutParams(r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    public final View getBottomAction() {
        return this.bottomAction;
    }

    public final View getDivider() {
        return this.divider;
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.INVALID_SCROLL_RANGE;
    }

    public final boolean getInDebug() {
        return this.inDebug;
    }

    public final ViewGroup getLeftAction() {
        return this.leftAction;
    }

    public final Drawable getLeftActionSrc() {
        return this.leftActionSrc;
    }

    public final int getMCollapsePosition() {
        return this.mCollapsePosition;
    }

    public final b getMOnHeaderFlingUnConsumedListener() {
        return this.mOnHeaderFlingUnConsumedListener;
    }

    public final TextView getMTvSubTitle() {
        return this.mTvSubTitle;
    }

    public final TextView getMTvTitle() {
        return this.mTvTitle;
    }

    public final int getPendingAction() {
        return this.mPendingAction;
    }

    public final ViewGroup getRightAction() {
        return this.rightAction;
    }

    public final Drawable getRightActionSrc() {
        return this.rightActionSrc;
    }

    public final int getTextInitPos() {
        return this.textInitPos;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final int getTopInset() {
        WindowInsetsCompat r10 = this.lastInsets;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        return r10.getSystemWindowInsetTop();
    L5:
        return 0;
    }

    public final int getTotalScrollRange() {
        return EXPANDED_HEIGHT - COLLAPSE_HEIGHT;
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public final boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public final WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r10) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r11 = r10;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r11) == true) goto L9;
        this.lastInsets = r11;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    public final void registerTransform() {
        addOnOffsetChangeListener(new d(this));
    }

    public final void removeOnOffsetChangeListener(c r10) {
        List<c> r11 = this.mOnOffsetChangeListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    public final void resetPendingAction() {
        this.mPendingAction = 0;
    }

    public final void setBottomAction(View r10) {
        this.bottomAction = r10;
    }

    public final void setDivider(View r10) {
        this.divider = r10;
    }

    public final void setExpanded(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 16;
    L5:
        this.mPendingAction = r11;
        requestLayout();
        return;
    L4:
        r11 = 1;
        goto L5
    }

    public final void setInDebug(boolean r10) {
        this.inDebug = r10;
    }

    public final void setLeftAction(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ViewGroup r11 = this.leftAction;
        if (r11 == null) goto L5;
        r11.removeAllViews();
    L5:
        ViewGroup r12 = this.leftAction;
        if (r12 == null) goto L9;
        r12.addView(r10);
        return;
    }

    public final void setLeftAction(ViewGroup r10) {
        this.leftAction = r10;
    }

    public final void setLeftActionSrc(Drawable r10) {
        this.leftActionSrc = r10;
    }

    public final boolean setLiftedState(boolean r10) {
        return false;
    }

    public final void setMCollapsePosition(int r10) {
        this.mCollapsePosition = r10;
    }

    public final void setMOnHeaderFlingUnConsumedListener(b r10) {
        this.mOnHeaderFlingUnConsumedListener = r10;
    }

    public final void setMTvSubTitle(TextView r10) {
        this.mTvSubTitle = r10;
    }

    public final void setMTvTitle(TextView r10) {
        this.mTvTitle = r10;
    }

    public final void setOnHeaderFlingUnConsumedListener(b r10) {
        Intrinsics.checkNotNullParameter(r10, "onHeaderFlingUnConsumedListener");
        this.mOnHeaderFlingUnConsumedListener = r10;
    }

    public final void setRightAction(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ViewGroup r11 = this.rightAction;
        if (r11 == null) goto L5;
        r11.removeAllViews();
    L5:
        ViewGroup r12 = this.rightAction;
        if (r12 == null) goto L9;
        r12.addView(r10);
        return;
    }

    public final void setRightAction(ViewGroup r10) {
        this.rightAction = r10;
    }

    public final void setRightActionSrc(Drawable r10) {
        this.rightActionSrc = r10;
    }

    public final void setTextInitPos(int r10) {
        this.textInitPos = r10;
    }

    public final void setTitleText(String r10) {
        this.titleText = r10;
    }

    public final void setupView() {
        if (this.leftActionSrc == null) goto L6;
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        OIconButton r11 = new OIconButton(r10, null, 0, 0, null, 28, null);
        r11.setImageDrawable(this.leftActionSrc);
        Unit r12 = Unit.INSTANCE;
        setLeftAction(r11);
    L6:
        if (this.rightActionSrc == null) goto L8;
        Context r13 = getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "context");
        OIconButton r14 = new OIconButton(r13, null, 0, 0, null, 28, null);
        r14.setImageDrawable(this.rightActionSrc);
        Unit r15 = Unit.INSTANCE;
        setRightAction(r14);
    L8:
        setBackgroundColor(getResources().getColor(u8.c.Transparent));
        if (this.inDebug == false) goto L20;
        ViewGroup r16 = this.leftAction;
        if (r16 == null) goto L13;
        r16.setBackgroundColor(getResources().getColor(u8.c.oui_blue_2));
    L13:
        ViewGroup r17 = this.rightAction;
        if (r17 == null) goto L16;
        r17.setBackgroundColor(getResources().getColor(u8.c.oui_blue_2));
    L16:
        setBackgroundColor(getResources().getColor(u8.c.oui_red_2));
        TextView r18 = this.mTvTitle;
        if (r18 == null) goto L21;
        r18.setBackgroundColor(getResources().getColor(u8.c.oui_yellow_1));
        return;
    L21:
        return;
    }

    public final boolean shouldLift(View r10) {
        View r11 = findLiftOnScrollTargetView(r10);
        if (r11 == null) goto L6;
        r10 = r11;
    L6:
        if (r10 != null) goto L8;
    L12:
        return false;
    L8:
        if (r10.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r10.getScrollY() <= 0) goto L12;
        goto L11
    }
}
