package com.obric.oui.titlebar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 \u007f2\u00020\u00012\u00020\u0002:\u0006~\u007f\u0080\u0001\u0081\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010;J\u000e\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020\tJ\u0014\u0010Z\u001a\u0004\u0018\u00010\r2\b\u0010[\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0014J\f\u0010`\u001a\u0006\u0012\u0002\b\u00030aH\u0016J\u0006\u0010b\u001a\u00020\tJ\u0006\u0010c\u001a\u00020\tJ\u0006\u0010d\u001a\u00020\tJ\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002J\u0006\u0010g\u001a\u00020\tJ\u0006\u0010h\u001a\u00020\tJ\u0006\u0010i\u001a\u00020\tJ\u0006\u0010j\u001a\u00020\u0017J\u0006\u0010k\u001a\u00020\u0017J\u001a\u0010l\u001a\u00020V2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010m\u001a\u00020\u0017J\u0012\u0010n\u001a\u0004\u0018\u00010\u001e2\b\u0010o\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010p\u001a\u00020VJ\u0010\u0010q\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010;J\u0006\u0010r\u001a\u00020VJ\u000e\u0010s\u001a\u00020V2\u0006\u0010t\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020V2\u0006\u0010u\u001a\u00020\rJ\u000e\u0010v\u001a\u00020\u00172\u0006\u0010w\u001a\u00020\u0017J\u000e\u0010x\u001a\u00020V2\u0006\u0010y\u001a\u000204J\u000e\u0010H\u001a\u00020V2\u0006\u0010u\u001a\u00020\rJ\u0006\u0010z\u001a\u00020VJ\b\u0010{\u001a\u00020\u0017H\u0002J\u0010\u0010|\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010\rJ\b\u0010}\u001a\u00020VH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\t8\u0002X\u0083D¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001c\u0010F\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R\u001c\u0010I\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010(\"\u0004\bK\u0010*R\u001a\u0010L\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u00102R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "INVALID_SCROLL_RANGE", "", "getINVALID_SCROLL_RANGE", "()I", "bottomAction", "Landroid/view/View;", "getBottomAction", "()Landroid/view/View;", "setBottomAction", "(Landroid/view/View;)V", "divider", "getDivider", "setDivider", "downScrollRange", "haveChildWithInterpolator", "", "inDebug", "getInDebug", "()Z", "setInDebug", "(Z)V", "lastInsets", "Landroidx/core/view/WindowInsetsCompat;", "leftAction", "Landroid/view/ViewGroup;", "getLeftAction", "()Landroid/view/ViewGroup;", "setLeftAction", "(Landroid/view/ViewGroup;)V", "leftActionSrc", "Landroid/graphics/drawable/Drawable;", "getLeftActionSrc", "()Landroid/graphics/drawable/Drawable;", "setLeftActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "liftOnScroll", "liftOnScrollTargetView", "Ljava/lang/ref/WeakReference;", "liftOnScrollTargetViewId", "mCollapsePosition", "getMCollapsePosition", "setMCollapsePosition", "(I)V", "mOnHeaderFlingUnConsumedListener", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "setMOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;)V", "mOnOffsetChangeListeners", "", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "mPendingAction", "mTvSubTitle", "Landroid/widget/TextView;", "getMTvSubTitle", "()Landroid/widget/TextView;", "setMTvSubTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "rightAction", "getRightAction", "setRightAction", "rightActionSrc", "getRightActionSrc", "setRightActionSrc", "textInitPos", "getTextInitPos", "setTextInitPos", "titleText", "", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "addOnOffsetChangeListener", "", "listener", "dispatchOffsetChange", TypedValues.CycleType.S_WAVE_OFFSET, "findLiftOnScrollTargetView", "defaultScrollingView", "generateLayoutParams", "Lcom/obric/oui/titlebar/behavior/BaseBehavior$LayoutParams;", "p", "Landroid/view/ViewGroup$LayoutParams;", "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getDownNestedPreScrollRange", "getDownNestedScrollRange", "getPendingAction", "getScrollRange", "getSnapRange", "getTopInset", "getTotalScrollRange", "getUpNestedPreScrollRange", "hasChildWithInterpolator", "hasScrollableChildren", CommonConsts.APM_INNER_EVENT_COST_INIT, "isLiftOnScroll", "onWindowInsetChanged", "insets", "registerTransform", "removeOnOffsetChangeListener", "resetPendingAction", "setExpanded", "expanded", "view", "setLiftedState", "lifted", "setOnHeaderFlingUnConsumedListener", "onHeaderFlingUnConsumedListener", "setupView", "shouldDrawStatusBarForeground", "shouldLift", "updateWillNotDraw", "Behavior", "Companion", "OnHeaderFlingUnConsumedListener", "OnOffsetChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ,\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J,\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0012\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010(\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0002J2\u0010)\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0002H\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0002H\u0016J\u001c\u00100\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016J \u00101\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0012H\u0016J8\u00103\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 2\u0006\u00105\u001a\u00020\u000fH\u0016J0\u00106\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0016J8\u00107\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00122\u0006\u00105\u001a\u00020:H\u0016J@\u0010;\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u0012H\u0016J0\u0010@\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u0012H\u0016J \u0010C\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000bH\u0016J4\u0010D\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010E\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006F"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mLastNestedScrollingChildRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mOffsetAnimator", "Landroid/animation/ValueAnimator;", "mShouldDispatchFling", "", "mSkipNestedPreScroll", "mTempFlingDispatchConsumed", "", "mTempFlingMaxOffset", "mTempFlingMinOffset", "mWasFlung", "offsetDelta", "getOffsetDelta", "()I", "animateOffsetTo", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", TypedValues.CycleType.S_WAVE_OFFSET, "velocity", "", "animateToOffset", "parent", "header", TypedValues.AttributesType.S_TARGET, "duration", "canDragView", "view", "checkSnap", "fling", "layout", "minOffset", "maxOffset", "velocityY", "getMaxDragOffset", "getScrollRangeForDragFling", "onFlingFinished", "onLayoutChild", "layoutDirection", "onNestedFling", "velocityX", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "directTargetChild", "nestedScrollAxes", "onStopNestedScroll", "setHeaderTopBottomOffset", "newOffset", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        private final void animateOffsetTo(CoordinatorLayout r3, OUnitedTitleBar r4, int r5, float r6) {
            int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
            float r7 = Math.abs(r6);
            if (r7 <= 0.0f) goto L5;
            int r8 = Math.round(1000 * (r0 / r7));
        L6:
            animateToOffset(r3, r4, r5, r8);
            return;
        L5:
            Intrinsics.checkNotNull(r4);
            r8 = (int) (((r0 / r4.getHeight()) + 1) * AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);
            goto L6
        }

        private final void animateToOffset(final CoordinatorLayout r6, final OUnitedTitleBar r7, int r8, int r9) {
            int r0 = getTopAndBottomOffset();
            if (r0 != r8) goto L7;
            ValueAnimator r1 = this.mOffsetAnimator;
            if (r1 == null) goto L7;
            Intrinsics.checkNotNull(r1);
            r1.cancel();
        L7:
            ValueAnimator r2 = this.mOffsetAnimator;
            if (r2 != null) goto L10;
            ValueAnimator r3 = new ValueAnimator();
            this.mOffsetAnimator = r3;
            Intrinsics.checkNotNull(r3);
            r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
            ValueAnimator r4 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r4);
            r4.addUpdateListener(new $$Lambda$OUnitedTitleBar$Behavior$svrYgPqzLlLkx7DO8ICBzCUuy_U(this, r6, r7));
        L11:
            ValueAnimator r10 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r10);
            r10.setDuration(r9);
            ValueAnimator r11 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r11);
            r11.setIntValues(new int[]{r0, r8});
            ValueAnimator r5 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r5);
            r5.start();
            return;
        L10:
            Intrinsics.checkNotNull(r2);
            r2.cancel();
            goto L11
        }

        /* JADX INFO: renamed from: animateToOffset$lambda-0, reason: not valid java name */
        private static final void m1391animateToOffset$lambda0(Behavior r2, CoordinatorLayout r3, OUnitedTitleBar r4, ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r5, "animation");
            View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
            Object r7 = r5.getAnimatedValue();
            Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Int");
            r2.setHeaderTopBottomOffset(r3, r6, ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).intValue());
        }

        public static /* synthetic */ void lambda$svrYgPqzLlLkx7DO8ICBzCUuy_U(Behavior r0, CoordinatorLayout r1, OUnitedTitleBar r2, ValueAnimator r3) {
            m1391animateToOffset$lambda0(r0, r1, r2, r3);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ boolean canDragView(View r3) {
            return canDragView((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        public boolean canDragView(OUnitedTitleBar r5) {
            WeakReference<View> r0 = this.mLastNestedScrollingChildRef;
            if (r0 == null) goto L15;
            Intrinsics.checkNotNull(r0);
            View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L7;
        L13:
            return false;
        L7:
            if (r1.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r1, -1) == true) goto L13;
            int r4 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r5);
            if (r4 <= (-OUnitedTitleBar.access$getScrollRange(r5))) goto L13;
            return true;
        L15:
            return true;
        }

        public final boolean checkSnap(CoordinatorLayout r5, OUnitedTitleBar r6) {
            int r0 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r6);
            int r1 = -OUnitedTitleBar.access$getSnapRange(r6);
            if (r0 <= r1) goto L11;
            if (r0 >= 0) goto L11;
            if (r0 < ((r1 + 0) / 2)) goto L9;
            r1 = 0;
        L9:
            animateOffsetTo(r5, r6, r1, 0.0f);
            return true;
        L11:
            return false;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ boolean fling(CoordinatorLayout r7, View r8, int r9, int r10, float r11) {
            return fling(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r9, r10, r11);
        }

        public boolean fling(CoordinatorLayout r7, OUnitedTitleBar r8, int r9, int r10, float r11) {
            Intrinsics.checkNotNullParameter(r8, "layout");
            if (r11 >= 0.0f) goto L5;
            this.mShouldDispatchFling = true;
            this.mTempFlingDispatchConsumed = 0;
            this.mTempFlingMinOffset = r9;
            this.mTempFlingMaxOffset = r10;
            r9 = Integer.MIN_VALUE;
            r10 = Integer.MAX_VALUE;
        L5:
            View r2 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
            return super.fling(r7, r2, r9, r10, r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int getMaxDragOffset(View r3) {
            return getMaxDragOffset((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        public int getMaxDragOffset(OUnitedTitleBar r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            return -OUnitedTitleBar.access$getScrollRange(r1);
        }

        public final int getOffsetDelta() {
            return this.offsetDelta;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int getScrollRangeForDragFling(View r3) {
            return getScrollRangeForDragFling((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        public int getScrollRangeForDragFling(OUnitedTitleBar r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            return OUnitedTitleBar.access$getScrollRange(r1);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ void onFlingFinished(CoordinatorLayout r3, View r4) {
            onFlingFinished(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        }

        public void onFlingFinished(CoordinatorLayout r2, OUnitedTitleBar r3) {
            this.mShouldDispatchFling = false;
            checkSnap(r2, r3);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
            return onLayoutChild(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onLayoutChild(CoordinatorLayout r3, OUnitedTitleBar r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r4, "child");
            boolean r6 = super.onLayoutChild(r3, (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), r5);
            if (OUnitedTitleBar.access$getMPendingAction$p(r4) != 0) goto L5;
        L11:
            r4.dispatchOffsetChange(getTopAndBottomOffset());
            return r6;
        L5:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r4) & 1) == 0) goto L9;
            View r0 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
            int r1 = -OUnitedTitleBar.access$getScrollRange(r4);
        L7:
            setHeaderTopBottomOffset(r3, r0, r1);
            goto L11
        L9:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r4) & 16) == 0) goto L11;
            r0 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
            r1 = 0;
            goto L7
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onNestedFling(CoordinatorLayout r8, View r9, View r10, float r11, float r12, boolean r13) {
            return onNestedFling(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        public boolean onNestedFling(CoordinatorLayout r1, OUnitedTitleBar r2, View r3, float r4, float r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r1, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r2, "child");
            Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
            this.mWasFlung = true;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r7, View r8, View r9, float r10, float r11) {
            return onNestedPreFling(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r9, r10, r11);
        }

        public boolean onNestedPreFling(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r8, "child");
            Intrinsics.checkNotNullParameter(r9, TypedValues.AttributesType.S_TARGET);
            if (r11 > 0.0f) goto L5;
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.access$getScrollRange(r8))) goto L10;
            fling(r7, r8, -OUnitedTitleBar.access$getScrollRange(r8), 0, -r11);
            this.mWasFlung = true;
            return true;
        L10:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onNestedPreScroll(CoordinatorLayout r8, View r9, View r10, int r11, int r12, int[] r13) {
            onNestedPreScroll(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        public void onNestedPreScroll(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int[] r12) {
            Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r8, "child");
            Intrinsics.checkNotNullParameter(r9, TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullParameter(r12, "consumed");
            if (r11 > 0) goto L5;
            return;
        L5:
            if (this.mSkipNestedPreScroll == true) goto L9;
            int r4 = -OUnitedTitleBar.access$getScrollRange(r8);
            r12[1] = scroll(r7, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), r11, r4, 0);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onNestedScroll(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int r14, int r15) {
            onNestedScroll(r9, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r10, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, r15);
        }

        public void onNestedScroll(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r8, "child");
            Intrinsics.checkNotNullParameter(r9, TypedValues.AttributesType.S_TARGET);
            if (r13 >= 0) goto L5;
            scroll(r7, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), r13, -OUnitedTitleBar.access$getScrollRange(r8), 0);
            boolean r14 = true;
        L6:
            this.mSkipNestedPreScroll = r14;
            return;
        L5:
            r14 = false;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r7, View r8, View r9, View r10, int r11) {
            return onStartNestedScroll(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r9, r10, r11);
        }

        public boolean onStartNestedScroll(CoordinatorLayout r2, OUnitedTitleBar r3, View r4, View r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r3, "child");
            Intrinsics.checkNotNullParameter(r4, "directTargetChild");
            Intrinsics.checkNotNullParameter(r5, TypedValues.AttributesType.S_TARGET);
            if ((r6 & 2) > 0) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L14;
            ValueAnimator r8 = this.mOffsetAnimator;
            if (r8 == null) goto L14;
            Intrinsics.checkNotNull(r8);
            r8.cancel();
        L14:
            this.mLastNestedScrollingChildRef = null;
            this.mWasFlung = false;
            this.mShouldDispatchFling = false;
            stopFling();
            return r7;
        L5:
            if (OUnitedTitleBar.access$getScrollRange(r3) <= 0) goto L9;
            if ((r2.getHeight() - r4.getHeight()) > r3.getHeight()) goto L9;
            r7 = true;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onStopNestedScroll(CoordinatorLayout r3, View r4, View r5) {
            onStopNestedScroll(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r5);
        }

        public void onStopNestedScroll(CoordinatorLayout r2, OUnitedTitleBar r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r3, "child");
            Intrinsics.checkNotNullParameter(r4, TypedValues.AttributesType.S_TARGET);
            if (this.mWasFlung == true) goto L5;
            checkSnap(r2, r3);
        L5:
            this.mSkipNestedPreScroll = false;
            this.mLastNestedScrollingChildRef = new WeakReference(r4);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
            return setHeaderTopBottomOffset(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.memorydata.plugin"), r9, r10, r11);
        }

        public int setHeaderTopBottomOffset(CoordinatorLayout r8, OUnitedTitleBar r9, int r10, int r11, int r12) {
            int r0 = getTopAndBottomOffset();
            if (this.mShouldDispatchFling == false) goto L5;
            r11 = Math.max(this.mTempFlingMinOffset, r11);
            r12 = Math.min(this.mTempFlingMaxOffset, r12);
        L5:
            int r13 = super.setHeaderTopBottomOffset(r8, (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), r10, r11, r12);
            if (r9 == null) goto L9;
            r9.dispatchOffsetChange(getTopAndBottomOffset());
        L9:
            int r14 = 0;
            if (this.mShouldDispatchFling == false) goto L20;
            if (r9 != null) goto L13;
            b r15 = null;
        L14:
            if (r15 == null) goto L20;
            int r16 = ((r10 - r0) + r13) - this.mTempFlingDispatchConsumed;
            if (r16 == 0) goto L18;
            Intrinsics.checkNotNull(r9);
            b r17 = r9.getMOnHeaderFlingUnConsumedListener();
            Intrinsics.checkNotNull(r17);
            r14 = r17.a(r9, r10, r16);
        L18:
            this.mTempFlingDispatchConsumed += -r14;
            goto L20
        L13:
            r15 = r9.getMOnHeaderFlingUnConsumedListener();
        L20:
            return r13 + r14;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Companion;", "", "()V", "ACTION_MARGIN_TOP", "", "getACTION_MARGIN_TOP", "()I", "COLLAPSE_HEIGHT", "getCOLLAPSE_HEIGHT", "COLLAPSE_ON_CENTER", "COLLAPSE_ON_LEFT", "COLLAPSE_TEXT_SIZE_ON_CENTER", "", "COLLAPSE_TEXT_SIZE_ON_LEFT", "EXPANDED_HEIGHT", "getEXPANDED_HEIGHT", "EXPANDED_TEXT_SIZE", "PENDING_ACTION_ANIMATED", "PENDING_ACTION_ANIMATE_ENABLED", "PENDING_ACTION_COLLAPSED", "PENDING_ACTION_EXPANDED", "PENDING_ACTION_FORCE", "PENDING_ACTION_NONE", "TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER", "getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER", "TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT", "getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT", "TITLE_EXPANDED_MARGIN_BOTTOM", "getTITLE_EXPANDED_MARGIN_BOTTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a() {
            return OUnitedTitleBar.access$getACTION_MARGIN_TOP$cp();
        }

        public final int b() {
            return OUnitedTitleBar.access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp();
        }

        public final int c() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp();
        }

        public final int d() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "", "onFlingUnConsumed", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "targetOffset", "unconsumed", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        int a(OUnitedTitleBar r1, int r2, int r3);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "", "onOffsetChanged", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "currOffset", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(OUnitedTitleBar r1, int r2);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/titlebar/OUnitedTitleBar$registerTransform$1", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "onOffsetChanged", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "currOffset", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f14757a;

        d(OUnitedTitleBar r1) {
            this.f14757a = r1;
        }

        @Override // com.obric.oui.titlebar.OUnitedTitleBar.c
        public void a(OUnitedTitleBar r17, int r18) {
            ViewGroup r2 = this.f14757a.getLeftAction();
            ViewGroup.MarginLayoutParams r3 = null;
            if (r2 != null) goto L5;
            ViewGroup.LayoutParams r4 = null;
        L7:
            if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L9;
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        L10:
            ViewGroup r6 = this.f14757a.getRightAction();
            if (r6 != null) goto L13;
            ViewGroup.LayoutParams r7 = null;
        L15:
            if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L17;
            ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        L18:
            TextView r9 = this.f14757a.getMTvTitle();
            if (r9 != null) goto L21;
            ViewGroup.LayoutParams r10 = null;
        L23:
            if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L25;
            r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        L25:
            int r11 = h.a((View) ZeusTransformUtils.preCheckCast(this.f14757a, View.class, "com.obric.memorydata.plugin"), OUnitedTitleBar.Companion.a());
            float r12 = 16.0f;
            int r13 = h.a((View) ZeusTransformUtils.preCheckCast(this.f14757a, View.class, "com.obric.memorydata.plugin"), OUnitedTitleBar.Companion.b());
            int r14 = h.a((View) ZeusTransformUtils.preCheckCast(this.f14757a, View.class, "com.obric.memorydata.plugin"), OUnitedTitleBar.Companion.c());
            float r15 = (-r18) / this.f14757a.getTotalScrollRange();
            if (this.f14757a.getMCollapsePosition() != 1) goto L39;
            r14 = h.a((View) ZeusTransformUtils.preCheckCast(this.f14757a, View.class, "com.obric.memorydata.plugin"), OUnitedTitleBar.Companion.d());
            int[] r16 = new int[2];
            TextView r19 = this.f14757a.getMTvTitle();
            if (r19 == null) goto L31;
            r19.getLocationOnScreen(r16);
        L31:
            if (r18 != 0) goto L33;
            int r20 = r16[0];
            int r110 = r16[1];
            this.f14757a.setTextInitPos(r20);
        L33:
            float r21 = (this.f14757a.getTextInitPos() + h.a((View) ZeusTransformUtils.preCheckCast(this.f14757a, View.class, "com.obric.memorydata.plugin"), 18)) * r15;
            if (r3 == null) goto L37;
            r3.leftMargin = -((int) r21);
        L37:
            r12 = 20.0f;
        L39:
            if (r15 != 1.0f) goto L41;
            boolean r111 = true;
        L42:
            View r112 = this.f14757a.getDivider();
            if (r111 == false) goto L47;
            if (r112 == null) goto L50;
            o.a(r112);
        L50:
            if (r5 == null) goto L53;
            r5.topMargin = (-r18) + r11;
        L53:
            if (r8 == null) goto L56;
            r8.topMargin = (-r18) + r11;
        L56:
            int r1 = (int) (r13 - ((r13 - r14) * r15));
            float r22 = ((r12 - 40.0f) * new AccelerateDecelerateInterpolator().getInterpolation(r15)) + 40.0f;
            TextView r23 = this.f14757a.getMTvTitle();
            if (r23 == null) goto L60;
            r23.setTextSize(2, r22);
        L60:
            if (r3 == null) goto L63;
            r3.bottomMargin = r1;
        L63:
            ViewGroup r24 = this.f14757a.getLeftAction();
            if (r24 == null) goto L67;
            r24.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        L67:
            ViewGroup r25 = this.f14757a.getRightAction();
            if (r25 == null) goto L71;
            r25.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        L71:
            TextView r0 = this.f14757a.getMTvTitle();
            if (r0 == null) goto L76;
            r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            return;
        L76:
            return;
        L47:
            if (r112 == null) goto L50;
            o.b(r112);
            goto L50
        L41:
            r111 = false;
            goto L42
        L21:
            r10 = r9.getLayoutParams();
            goto L23
        L17:
            r8 = null;
            goto L18
        L13:
            r7 = r6.getLayoutParams();
            goto L15
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = r2.getLayoutParams();
            goto L7
        }
    }

    static {
        Companion = new a(null);
        COLLAPSE_HEIGHT = 56;
        EXPANDED_HEIGHT = 240;
        ACTION_MARGIN_TOP = 12;
        TITLE_EXPANDED_MARGIN_BOTTOM = 92;
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = 17;
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = 14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OUnitedTitleBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OUnitedTitleBar(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        init(r5, r6);
        this.INVALID_SCROLL_RANGE = -1;
        this.downScrollRange = -1;
    }

    public /* synthetic */ OUnitedTitleBar(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
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

    public static final /* synthetic */ int access$getMPendingAction$p(OUnitedTitleBar r0) {
        return r0.mPendingAction;
    }

    public static final /* synthetic */ int access$getScrollRange(OUnitedTitleBar r0) {
        return r0.getScrollRange();
    }

    public static final /* synthetic */ int access$getSnapRange(OUnitedTitleBar r0) {
        return r0.getSnapRange();
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

    private final View findLiftOnScrollTargetView(View r5) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r0 = this.liftOnScrollTargetViewId;
        if (r0 == (-1)) goto L15;
        if (r5 == null) goto L8;
        View r6 = r5.findViewById(r0);
    L9:
        if (r6 == null) goto L11;
    L13:
        if (r6 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r6);
        goto L15
    L11:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L13;
        ViewParent r7 = getParent();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.view.ViewGroup");
        r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r6 = null;
    L15:
        WeakReference<View> r4 = this.liftOnScrollTargetView;
        if (r4 != null) goto L19;
        return null;
    L19:
        return (View) ZeusTransformUtils.preCheckCast(r4.get(), View.class, "com.obric.memorydata.plugin");
    }

    private final int getScrollRange() {
        return h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), EXPANDED_HEIGHT - COLLAPSE_HEIGHT);
    }

    private final int getSnapRange() {
        return h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 56);
    }

    private final void init(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        TypedArray r8 = r7.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OUnitedTitleBar);
        Intrinsics.checkNotNullExpressionValue(r8, "context.obtainStyledAttr…tyleable.OUnitedTitleBar)");
        this.titleText = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_united_title, "styleable", "OUnitedTitleBar_oui_united_title"));
        this.mCollapsePosition = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_title_collapse_position, "styleable", "OUnitedTitleBar_oui_title_collapse_position"), 0);
        this.leftActionSrc = r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_left_action_src, "styleable", "OUnitedTitleBar_oui_left_action_src"));
        this.rightActionSrc = r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OUnitedTitleBar_oui_right_action_src, "styleable", "OUnitedTitleBar_oui_right_action_src"));
        r8.recycle();
        FrameLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_united_titlebar, "layout", "o_united_titlebar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.leftAction = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.fl_left_container, OaidModel.KEY_ID, "fl_left_container")), ViewGroup.class, "com.obric.memorydata.plugin");
        this.rightAction = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.fl_right_container, OaidModel.KEY_ID, "fl_right_container")), ViewGroup.class, "com.obric.memorydata.plugin");
        this.mTvTitle = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_title_container, OaidModel.KEY_ID, "tv_title_container")), TextView.class, "com.obric.memorydata.plugin");
        this.mTvSubTitle = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_subtitle_container, OaidModel.KEY_ID, "tv_subtitle_container")), TextView.class, "com.obric.memorydata.plugin");
        this.bottomAction = findViewById(ZeusTransformUtils.mapRes(R.id.fl_bottom_container, OaidModel.KEY_ID, "fl_bottom_container"));
        this.divider = findViewById(ZeusTransformUtils.mapRes(R.id.divider, OaidModel.KEY_ID, "divider"));
        TextView r9 = this.mTvTitle;
        if (r9 == null) goto L6;
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.titleText, CharSequence.class, "com.obric.memorydata.plugin"));
    L6:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), new $$Lambda$OUnitedTitleBar$GF4WYN25FeVz4OZLEx1Zc64O1s(this));
        setupView();
        registerTransform();
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final WindowInsetsCompat m1389init$lambda0(OUnitedTitleBar r0, View r1, WindowInsetsCompat r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        WindowInsetsCompat r3 = r0.onWindowInsetChanged(r2);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    /* JADX INFO: renamed from: lambda$GF4WYN25FeVz4OZLEx1Zc6-4O1s, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m1390lambda$GF4WYN25FeVz4OZLEx1Zc64O1s(OUnitedTitleBar r0, View r1, WindowInsetsCompat r2) {
        return m1389init$lambda0(r0, r1, r2);
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

    public final void addOnOffsetChangeListener(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (this.mOnOffsetChangeListeners != null) goto L5;
        this.mOnOffsetChangeListeners = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L5:
        if (r5 == null) goto L10;
        List<c> r0 = this.mOnOffsetChangeListeners;
        Intrinsics.checkNotNull(r0);
        if (r0.contains(r5) == true) goto L11;
        List<c> r3 = this.mOnOffsetChangeListeners;
        Intrinsics.checkNotNull(r3);
        r3.add(r5);
        return;
    L11:
        return;
    }

    public final void dispatchOffsetChange(int r5) {
        List<c> r0 = this.mOnOffsetChangeListeners;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        Iterator<c> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin")).a(this, r5);
        goto L6
    L10:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin")), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(generateLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin")), FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public BaseBehavior.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new BaseBehavior.LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public BaseBehavior.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new BaseBehavior.LayoutParams(r1);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return (CoordinatorLayout.Behavior) ZeusTransformUtils.preCheckCast(new BaseBehavior.Behavior(), CoordinatorLayout.Behavior.class, "com.obric.memorydata.plugin");
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
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.getSystemWindowInsetTop();
    L5:
        return 0;
    }

    public final int getTotalScrollRange() {
        return h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), EXPANDED_HEIGHT - COLLAPSE_HEIGHT);
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

    public final WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r0) == true) goto L9;
        this.lastInsets = r0;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r3;
    L5:
        r0 = null;
        goto L7
    }

    public final void registerTransform() {
        addOnOffsetChangeListener((c) ZeusTransformUtils.preCheckCast(new d(this), c.class, "com.obric.memorydata.plugin"));
    }

    public final void removeOnOffsetChangeListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        List<c> r2 = this.mOnOffsetChangeListeners;
        if (r2 == null) goto L7;
        TypeIntrinsics.asMutableCollection((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).remove(r4);
        return;
    }

    public final void resetPendingAction() {
        this.mPendingAction = 0;
    }

    public final void setBottomAction(View r1) {
        this.bottomAction = r1;
    }

    public final void setDivider(View r1) {
        this.divider = r1;
    }

    public final void setExpanded(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 16;
    L5:
        this.mPendingAction = r2;
        requestLayout();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public final void setInDebug(boolean r1) {
        this.inDebug = r1;
    }

    public final void setLeftAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ViewGroup r0 = this.leftAction;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        ViewGroup r1 = this.leftAction;
        if (r1 == null) goto L11;
        r1.addView(r2);
        return;
    }

    public final void setLeftAction(ViewGroup r1) {
        this.leftAction = r1;
    }

    public final void setLeftActionSrc(Drawable r1) {
        this.leftActionSrc = r1;
    }

    public final boolean setLiftedState(boolean r1) {
        return false;
    }

    public final void setMCollapsePosition(int r1) {
        this.mCollapsePosition = r1;
    }

    public final void setMOnHeaderFlingUnConsumedListener(b r3) {
        this.mOnHeaderFlingUnConsumedListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setMTvSubTitle(TextView r1) {
        this.mTvSubTitle = r1;
    }

    public final void setMTvTitle(TextView r1) {
        this.mTvTitle = r1;
    }

    public final void setOnHeaderFlingUnConsumedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onHeaderFlingUnConsumedListener");
        this.mOnHeaderFlingUnConsumedListener = r4;
    }

    public final void setRightAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ViewGroup r0 = this.rightAction;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        ViewGroup r1 = this.rightAction;
        if (r1 == null) goto L11;
        r1.addView(r2);
        return;
    }

    public final void setRightAction(ViewGroup r1) {
        this.rightAction = r1;
    }

    public final void setRightActionSrc(Drawable r1) {
        this.rightActionSrc = r1;
    }

    public final void setTextInitPos(int r1) {
        this.textInitPos = r1;
    }

    public final void setTitleText(String r1) {
        this.titleText = r1;
    }

    public final void setupView() {
        if (this.leftActionSrc == null) goto L6;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        OIconButton r0 = new OIconButton(r4, null, 0, 0, null, 28, null);
        r0.setImageDrawable(getLeftActionSrc());
        setLeftAction((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
    L6:
        if (this.rightActionSrc == null) goto L8;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OIconButton r1 = new OIconButton(r5, null, 0, 0, null, 28, null);
        r1.setImageDrawable(getRightActionSrc());
        setRightAction((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"));
    L8:
        setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        if (this.inDebug == false) goto L23;
        ViewGroup r2 = this.leftAction;
        if (r2 == null) goto L14;
        r2.setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_blue_2, TypedValues.Custom.S_COLOR, "oui_blue_2")));
    L14:
        ViewGroup r3 = this.rightAction;
        if (r3 == null) goto L18;
        r3.setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_blue_2, TypedValues.Custom.S_COLOR, "oui_blue_2")));
    L18:
        setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_red_2, TypedValues.Custom.S_COLOR, "oui_red_2")));
        TextView r6 = this.mTvTitle;
        if (r6 == null) goto L24;
        r6.setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_yellow_1, TypedValues.Custom.S_COLOR, "oui_yellow_1")));
        return;
    L24:
        return;
    }

    public final boolean shouldLift(View r1) {
        View r0 = findLiftOnScrollTargetView(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }
}
