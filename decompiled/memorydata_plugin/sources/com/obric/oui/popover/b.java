package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.k;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b7\b\u0016\u0018\u0000 ¦\u00012\u00020\u0001:\f¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\\2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0003J$\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\\2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0002J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u0014H\u0003JA\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\u000f2\b\b\u0002\u0010i\u001a\u00020\u00142\b\b\u0002\u0010j\u001a\u00020\u0014H\u0001¢\u0006\u0002\bkJ\b\u0010l\u001a\u00020aH\u0002J\b\u0010m\u001a\u00020aH\u0016J\u0006\u0010n\u001a\u00020aJ\u0006\u0010o\u001a\u00020\u000fJ&\u0010p\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010r\u001a\u00020sJ\u0006\u0010t\u001a\u00020\u000fJ\u0006\u0010u\u001a\u00020\u000fJ\u0006\u0010v\u001a\u00020\u001bJ\u0006\u0010w\u001a\u00020\u000fJ\u0006\u0010x\u001a\u00020\u000fJ\u0010\u0010y\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020\u000fH\u0004J\u0006\u0010z\u001a\u00020\tJ\b\u0010{\u001a\u00020aH\u0002J\u0006\u0010|\u001a\u00020aJ\b\u0010}\u001a\u00020aH\u0002J\b\u0010~\u001a\u00020aH\u0002J\u0006\u0010\u007f\u001a\u00020aJ0\u0010\u0080\u0001\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u001dJ\u0012\u0010\u0082\u0001\u001a\u00020a2\u0007\u0010\u0083\u0001\u001a\u00020\u000fH\u0007J\u0010\u0010\u0084\u0001\u001a\u00020a2\u0007\u0010\u0085\u0001\u001a\u00020\u0014J\u0014\u0010\u0086\u0001\u001a\u00020a2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\tH\u0002J+\u0010\u0088\u0001\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\b\b\u0002\u0010j\u001a\u00020\u0014H\u0003J\u0019\u0010\u0089\u0001\u001a\u00020a2\u0007\u0010\u008a\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011J\t\u0010\u008c\u0001\u001a\u00020aH\u0002J\u0010\u0010\u008d\u0001\u001a\u00020a2\u0007\u0010\u008e\u0001\u001a\u00020\u0014J\u0017\u0010\u008f\u0001\u001a\u00020a2\u0006\u0010f\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0090\u0001J\u0010\u0010\u0091\u0001\u001a\u00020a2\u0007\u0010\u0092\u0001\u001a\u00020\u0014J\u0010\u0010\u0093\u0001\u001a\u00020a2\u0007\u0010\u0094\u0001\u001a\u00020\u000fJ\u001b\u0010\u0095\u0001\u001a\u00020a2\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010\u0096\u0001\u001a\u00020a2\u0007\u0010\u0097\u0001\u001a\u00020HJ\u0010\u0010\u0098\u0001\u001a\u00020a2\u0007\u0010\u0099\u0001\u001a\u00020\u000fJ\u0010\u0010\u009a\u0001\u001a\u00020a2\u0007\u0010\u009b\u0001\u001a\u00020\u000fJ-\u0010\u009c\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\b\b\u0002\u0010j\u001a\u00020\u0014H\u0007JH\u0010\u009c\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\u0007\u0010\u009d\u0001\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u000f2\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\b\b\u0002\u0010j\u001a\u00020\u0014H\u0007J7\u0010\u009c\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\u000f2\u0007\u0010\u009d\u0001\u001a\u00020\u001d2\u0007\u0010\u009e\u0001\u001a\u00020\u000f2\b\b\u0002\u0010j\u001a\u00020\u0014H\u0007J-\u0010\u009f\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0007\u0010 \u0001\u001a\u00020\u000f2\u0007\u0010¡\u0001\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020\u000fH\u0016J)\u0010¢\u0001\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0016J\t\u0010£\u0001\u001a\u00020aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020\u000f8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010W\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010XR\u0012\u0010Y\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010XR\u000e\u0010Z\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ª\u0001"}, d2 = {"Lcom/obric/oui/popover/OPopover;", "Landroid/widget/PopupWindow;", "builder", "Lcom/obric/oui/popover/OPopover$Builder;", "(Lcom/obric/oui/popover/OPopover$Builder;)V", "activity", "Landroid/app/Activity;", "animFloatP", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "animSet", "Landroid/animation/AnimatorSet;", "bubbleText", "", "bubbleTextRes", "", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "hasCome", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "mAlignArrowPadding", "mAnimTime", "", "mArrowOffset", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mBubbleOffset", "mClickListener", "Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "mCornerRadius", "mDismissListener", "Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mFocusable", "mGetLocationInWindow", "mGravity", "getMGravity", "()I", "mHeight", "mIsFirstShow", "mIsShowInDialog", "mLayoutClickable", "mNeedArrow", "mNeedOverShoot", "mNeedShadow", "mOBubbleLayout", "Lcom/obric/oui/popover/OPopoverLayout;", "mOnClickMaintain", "mOutsideTouchable", "mPadding", "mParentHeight", "mParentWidth", "mShadowColor", "mShadowRadius", "mShadowSpaceTop", "mShowAsDropDown", "mShowElevationShadow", "mShowListener", "Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "mShowWithAnimation", "mSubText", "mSubTextColor", "mTargetLocation", "Landroid/graphics/Point;", "mTextColor", "mTextSize", "mTextView", "Lcom/obric/oui/popover/PopoverTextView;", "mTypeFace", "Landroid/graphics/Typeface;", "mUseDefaultView", "mView", "mWidth", "mWindowFrame", "Landroid/view/ViewGroup;", "mXOffset", "mYOffset", "padding", "shadowDx", "Ljava/lang/Float;", "shadowDy", "transparentBg", "addShadowFrame", "Lkotlin/Pair;", "x", "y", "addShadowFrameIfNeeded", "animatorEasyInOut", "", "isIn", "calTargetPosition", "", "isMiddle", "gravity", "anchorWidth", "anchorHeight", "ignoreAlign", "hasAdapted", "calTargetPosition$OUI_standardRelease", "clearFakeAnchorViewIfNecessary", "dismiss", "dismissDirectly", "getArrowHeight", "getBubblePosition", "anchor", "position", "Landroid/graphics/Rect;", "getBubbledHeight", "getBubbledWidth", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getOrientation", "getPopoverView", "hideSystemUi", "hideView", "initContentView", "measure", "onDestroy", "popupAtLocation", "arrowOffSet", "setAdjustHeight", "adjustHeight", "setAlignArrowPadding", "align", "setBubbleLayout", "view", "setBubblePositionAndShow", "setCustomAnimator", "inAnimator", "outAnimator", "setDefaultView", "setEnableAutoDismiss", EventBody.KEY_VALUE, "setGravity", "setGravity$OUI_standardRelease", "setIsShowInDialog", "isShowInDialog", "setMaxContentHeight", "maxHeight", "setMaxContentHeightIfPossible", "setTargetLocation", "targetLocation", "setXOffset", "xOffset", "setYOffset", "yOffset", "show", "arrowOffset", TypedValues.CycleType.S_WAVE_OFFSET, "showAsDropDown", "xoff", "yoff", "showAtLocation", "showDirectly", "Builder", "CommonFloatProperty", "Companion", "OnBubbleClickListener", "OnBubbleDismissListener", "OnBubbleShowListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class b extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14318a = null;
    private static volatile int am;
    private static boolean an;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private float E;
    private boolean F;
    private float G;
    private Float H;
    private Float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f14319J;
    private boolean K;
    private boolean L;
    private OPopoverLayout M;
    private ViewGroup N;
    private PopoverTextView O;
    private boolean P;
    private int Q;
    private AnimatorSet R;
    private Activity S;
    private View T;
    private d U;
    private f V;
    private e W;
    private boolean X;
    private int Y;
    private int Z;
    private boolean aa;
    private Animator ab;
    private Animator ac;
    private String ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private int ah;
    private boolean ai;
    private Point aj;
    private final Runnable ak;
    private final com.obric.oui.animation.a.c<View> al;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14320b;
    private float c;
    private float d;
    private int e;
    private boolean f;
    private boolean g;
    private int h;
    private Boolean i;
    private int j;
    private int k;
    private long l;
    private long m;
    private boolean n;
    private int o;
    private int p;
    private String q;
    private int r;
    private float s;
    private int t;
    private Typeface u;
    private boolean v;
    private float w;
    private int x;
    private int y;
    private boolean z;

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\bF\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010°\u0001\u001a\u00020\u00002\u0007\u0010±\u0001\u001a\u00020\u000fJ\b\u0010²\u0001\u001a\u00030³\u0001J\u0010\u0010´\u0001\u001a\u00020\u00002\u0007\u0010µ\u0001\u001a\u00020\u000fJ\u0010\u0010¶\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\u0015J\u0010\u0010¸\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010º\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\u0015J\u0012\u0010»\u0001\u001a\u00020\u00002\t\b\u0001\u0010¼\u0001\u001a\u00020!J\u0010\u0010½\u0001\u001a\u00020\u00002\u0007\u0010¾\u0001\u001a\u00020!J\u0010\u0010¿\u0001\u001a\u00020\u00002\u0007\u0010À\u0001\u001a\u00020!J\u0010\u0010Á\u0001\u001a\u00020\u00002\u0007\u0010Â\u0001\u001a\u00020-J\u0010\u0010Ã\u0001\u001a\u00020\u00002\u0007\u0010Ä\u0001\u001a\u00020!J\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u0010\u0010Å\u0001\u001a\u00020\u00002\u0007\u0010Æ\u0001\u001a\u00020\u000fJ\u0010\u0010Ç\u0001\u001a\u00020\u00002\u0007\u0010È\u0001\u001a\u00020\u000fJ\u0010\u0010É\u0001\u001a\u00020\u00002\u0007\u0010Ê\u0001\u001a\u00020!J\u0012\u0010Ë\u0001\u001a\u00020\u00002\u0007\u0010Ì\u0001\u001a\u00020!H\u0007J\u0010\u0010Í\u0001\u001a\u00020\u00002\u0007\u0010Î\u0001\u001a\u00020\u000fJ\u0010\u0010Ï\u0001\u001a\u00020\u00002\u0007\u0010Ð\u0001\u001a\u00020\u000fJ\u0010\u0010Ñ\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0010\u0010Ó\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0012\u0010Ô\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fH\u0007J\u0010\u0010Õ\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0010\u0010Ö\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u000206J\u0010\u0010Ø\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020<J\u0010\u0010Ù\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020uJ\u0010\u0010Ú\u0001\u001a\u00020\u00002\u0007\u0010Û\u0001\u001a\u00020\u000fJ\u0010\u0010Ü\u0001\u001a\u00020\u00002\u0007\u0010Ý\u0001\u001a\u00020\tJ\u0010\u0010Þ\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020!J\u0010\u0010ß\u0001\u001a\u00020\u00002\u0007\u0010à\u0001\u001a\u00020\u000fJ\u0010\u0010á\u0001\u001a\u00020\u00002\u0007\u0010â\u0001\u001a\u00020\u000fJ\u0010\u0010ã\u0001\u001a\u00020\u00002\u0007\u0010Â\u0001\u001a\u00020-J\u0010\u0010ä\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020!J\u0010\u0010å\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020!J\u0010\u0010æ\u0001\u001a\u00020\u00002\u0007\u0010ç\u0001\u001a\u00020\tJ\u0011\u0010è\u0001\u001a\u00020\u00002\b\u0010é\u0001\u001a\u00030\u008a\u0001J\u0010\u0010ê\u0001\u001a\u00020\u00002\u0007\u0010ë\u0001\u001a\u00020\u000fJ\u0011\u0010ì\u0001\u001a\u00020\u00002\b\u0010í\u0001\u001a\u00030\u0093\u0001J\u0012\u0010î\u0001\u001a\u00020\u00002\u0007\u0010ï\u0001\u001a\u00020!H\u0007J\u0010\u0010ð\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020!J\u0010\u0010ñ\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020!J\u0019\u0010ò\u0001\u001a\u00020\u00002\u0007\u0010ó\u0001\u001a\u00020\t2\u0007\u0010ô\u0001\u001a\u00020\tJ\u0010\u0010õ\u0001\u001a\u00020\u00002\u0007\u0010ö\u0001\u001a\u00020\tJ\u0010\u0010÷\u0001\u001a\u00020\u00002\u0007\u0010÷\u0001\u001a\u00020\u000fJ\u0010\u0010ª\u0001\u001a\u00020\u00002\u0007\u0010ø\u0001\u001a\u00020\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R\u001a\u0010G\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001a\u0010J\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u001a\u0010M\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R\u001a\u0010P\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R\u001a\u0010S\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\u001a\u0010V\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\u001a\u0010Y\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013R\u001a\u0010\\\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013R\u001a\u0010_\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u0010\u0013R\u001a\u0010b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R\u001a\u0010e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\rR\u001a\u0010h\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010#\"\u0004\bj\u0010%R\u001a\u0010k\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR\u001a\u0010n\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0011\"\u0004\bp\u0010\u0013R\u001a\u0010q\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0011\"\u0004\bs\u0010\u0013R\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0011\"\u0004\b|\u0010\u0013R\u001a\u0010}\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010/\"\u0004\b\u007f\u00101R\u001d\u0010\u0080\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010#\"\u0005\b\u0082\u0001\u0010%R\u001d\u0010\u0083\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010#\"\u0005\b\u0085\u0001\u0010%R\u001d\u0010\u0086\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u000b\"\u0005\b\u0088\u0001\u0010\rR\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010\u008f\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0011\"\u0005\b\u0091\u0001\u0010\u0013R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001d\u0010\u0098\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010#\"\u0005\b\u009a\u0001\u0010%R\u001d\u0010\u009b\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010#\"\u0005\b\u009d\u0001\u0010%R\u001d\u0010\u009e\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010#\"\u0005\b \u0001\u0010%R$\u0010¡\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¦\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R$\u0010§\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¦\u0001\u001a\u0006\b¨\u0001\u0010£\u0001\"\u0006\b©\u0001\u0010¥\u0001R\u001d\u0010ª\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u0011\"\u0005\b¬\u0001\u0010\u0013R\u001d\u0010\u00ad\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0011\"\u0005\b¯\u0001\u0010\u0013¨\u0006ù\u0001"}, d2 = {"Lcom/obric/oui/popover/OPopover$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "mAlignArrowPadding", "", "getMAlignArrowPadding", "()Z", "setMAlignArrowPadding", "(Z)V", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mArrowOffset", "getMArrowOffset", "setMArrowOffset", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mBubbleText", "", "getMBubbleText", "()Ljava/lang/String;", "setMBubbleText", "(Ljava/lang/String;)V", "mBubbleTextRes", "getMBubbleTextRes", "setMBubbleTextRes", "mClickListener", "Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "getMClickListener", "()Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "setMClickListener", "(Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;)V", "mDismissListener", "Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;)V", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mLayoutClickable", "getMLayoutClickable", "setMLayoutClickable", "mNeedAddColor", "getMNeedAddColor", "setMNeedAddColor", "mNeedArrow", "getMNeedArrow", "setMNeedArrow", "mNeedOverShoot", "getMNeedOverShoot", "setMNeedOverShoot", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mOnClickMaintain", "getMOnClickMaintain", "setMOnClickMaintain", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mPadding", "getMPadding", "setMPadding", "mShadowColor", "getMShadowColor", "setMShadowColor", "mShadowRadius", "getMShadowRadius", "setMShadowRadius", "mShowAsDropDown", "getMShowAsDropDown", "setMShowAsDropDown", "mShowElevationShadow", "getMShowElevationShadow", "setMShowElevationShadow", "mShowListener", "Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;)V", "mShowWithAnimation", "getMShowWithAnimation", "setMShowWithAnimation", "mSubText", "getMSubText", "setMSubText", "mSubTextColor", "getMSubTextColor", "setMSubTextColor", "mTextColor", "getMTextColor", "setMTextColor", "mTextSize", "getMTextSize", "setMTextSize", "mTypeFace", "Landroid/graphics/Typeface;", "getMTypeFace", "()Landroid/graphics/Typeface;", "setMTypeFace", "(Landroid/graphics/Typeface;)V", "mUseDefaultView", "getMUseDefaultView", "setMUseDefaultView", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowDx", "getShadowDx", "()Ljava/lang/Float;", "setShadowDx", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "shadowDy", "getShadowDy", "setShadowDy", "transparentBg", "getTransparentBg", "setTransparentBg", "useAlphaAnim", "getUseAlphaAnim", "setUseAlphaAnim", "alignArrowPadding", "align", "build", "Lcom/obric/oui/popover/OPopover;", "onClickMaintain", "maintain", "setAnimTime", OaidModel.KEY_TIME, "setArrowOffset", TypedValues.CycleType.S_WAVE_OFFSET, "setAutoDismissDelayMillis", "setBgColor", TypedValues.Custom.S_COLOR, "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBubbleText", "str", "setBubbleTextRes", "resId", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setGravity", "gravity", "setHeight", "height", "setHideVirtualKey", "hide", "setLayoutClickable", "clickable", "setNeedArrow", "need", "setNeedOverShoot", "setNeedPath", "setNeedShadow", "setOnClickListener", "listener", "setOnDismissListener", "setOnShowListener", "setOutSideTouchable", "touchable", "setPadding", "padding", "setShadowColor", "setShowElevationShadow", "show", "setShowWithAnim", "withAnim", "setSubText", "setSubTextColor", "setTextColor", "setTextSize", "textSize", "setTypeface", "tf", "setUseDefaultView", "useDefault", "setView", "view", "setWidth", "width", "setXOffset", "setYOffset", "shadowOffset", "dx", "dy", "shadowRadius", "radius", "showAsDropDown", "transparent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private boolean A;
        private int B;
        private boolean C;
        private float D;
        private boolean E;
        private boolean F;
        private boolean G;
        private int H;
        private int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private boolean f14321J;
        private float K;
        private Float L;
        private Float M;
        private boolean N;
        private boolean O;
        private boolean P;
        private String Q;
        private int R;
        private boolean S;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Activity f14322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14323b;
        private int c;
        private float d;
        private int e;
        private boolean f;
        private boolean g;
        private int h;
        private int i;
        private long j;
        private long k;
        private boolean l;
        private View m;
        private int n;
        private int o;
        private String p;
        private int q;
        private float r;
        private Typeface s;
        private int t;
        private d u;
        private e v;
        private f w;
        private boolean x;
        private float y;
        private boolean z;

        public a(Activity r6) {
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "activity");
            Activity r8 = ZeusTransformUtils.wrapperContext2Activity(r7, "com.obric.memorydata.plugin");
            this.f14322a = r8;
            this.e = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_background, TypedValues.Custom.S_COLOR, "oui_toast_background"));
            this.j = 800;
            this.k = Long.MIN_VALUE;
            this.p = "";
            this.r = 13.0f;
            this.t = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f14322a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_text, TypedValues.Custom.S_COLOR, "oui_toast_text"));
            this.y = 12.0f;
            this.z = true;
            this.B = ViewCompat.MEASURED_STATE_MASK;
            this.D = 2.0f;
            this.E = true;
            this.G = true;
            this.P = true;
            this.Q = "";
            this.R = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f14322a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_text, TypedValues.Custom.S_COLOR, "oui_toast_text"));
            this.S = true;
        }

        public final int A() {
            return this.B;
        }

        public final boolean B() {
            return this.C;
        }

        public final float C() {
            return this.D;
        }

        public final boolean D() {
            return this.F;
        }

        public final boolean E() {
            return this.G;
        }

        public final int F() {
            return this.H;
        }

        public final int G() {
            return this.I;
        }

        public final boolean H() {
            return this.f14321J;
        }

        public final float I() {
            return this.K;
        }

        public final Float J() {
            return this.L;
        }

        public final Float K() {
            return this.M;
        }

        public final boolean L() {
            return this.N;
        }

        public final boolean M() {
            return this.O;
        }

        public final boolean N() {
            return this.P;
        }

        public final String O() {
            return this.Q;
        }

        public final int P() {
            return this.R;
        }

        public final boolean Q() {
            return this.S;
        }

        public final b R() {
            return new b(this);
        }

        public final a a(int r1) {
            this.e = r1;
            return this;
        }

        public final a a(long r1) {
            this.k = r1;
            return this;
        }

        public final a a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.m = r2;
            return this;
        }

        public final a a(e r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.v = r4;
            return this;
        }

        public final a a(boolean r1) {
            this.l = r1;
            return this;
        }

        public final boolean a() {
            return this.f14323b;
        }

        public final int b() {
            return this.c;
        }

        public final a b(boolean r1) {
            this.C = r1;
            return this;
        }

        public final float c() {
            return this.d;
        }

        public final int d() {
            return this.e;
        }

        public final boolean e() {
            return this.f;
        }

        public final boolean f() {
            return this.g;
        }

        public final int g() {
            return this.h;
        }

        public final Activity getActivity() {
            return this.f14322a;
        }

        public final int h() {
            return this.i;
        }

        public final long i() {
            return this.j;
        }

        public final long j() {
            return this.k;
        }

        public final boolean k() {
            return this.l;
        }

        public final View l() {
            return this.m;
        }

        public final int m() {
            return this.n;
        }

        public final int n() {
            return this.o;
        }

        public final String o() {
            return this.p;
        }

        public final int p() {
            return this.q;
        }

        public final float q() {
            return this.r;
        }

        public final Typeface r() {
            return this.s;
        }

        public final int s() {
            return this.t;
        }

        public final d t() {
            return this.u;
        }

        public final e u() {
            return this.v;
        }

        public final f v() {
            return this.w;
        }

        public final boolean w() {
            return this.x;
        }

        public final float x() {
            return this.y;
        }

        public final boolean y() {
            return this.z;
        }

        public final boolean z() {
            return this.A;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/OPopover$CommonFloatProperty;", "", EventBody.KEY_VALUE, "", "(F)V", "getValue", "()F", "setValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0764b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f14324a;

        public C0764b(float r1) {
            this.f14324a = r1;
        }

        public final float a() {
            return this.f14324a;
        }

        public final void a(float r1) {
            this.f14324a = r1;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u000fH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/popover/OPopover$Companion;", "", "()V", "OPACITY_LONG", "", "OPACITY_SHORT", "POPUP_WINDOW_ELEVATION", "", "SCALE_LONG", "SCALE_SHORT", "TAG", "", "USE_OUI_SHADOW", "", "currentShowBubbleNumbers", "", "shouldForceDismiss", "adaptGravity", "originGravity", "adaptGravity$OUI_standardRelease", "getCurrentShowBubbleNumbers", "setShouldForceDismiss", "", "forceDismiss", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }

        public final int a(int r1) {
            if (r1 != 8388611) goto L5;
            return 3;
        L5:
            if (r1 != 8388613) goto L11;
            return 5;
        L11:
            return r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "", "clickBubble", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface e {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface f {
        void a();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/popover/OPopover$animFloatP$1", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "getValue", "", "obj", "setValue", "", EventBody.KEY_VALUE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends com.obric.oui.animation.a.c<View> {
        g() {
            super(BaseSwitches.V);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float a2(View r4) {
            if (r4 == null) goto L20;
            Object r5 = r4.getTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, OaidModel.KEY_ID, "o_popover_anim_p"));
            if (r5 == null) goto L21;
            com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
            Float r1 = null;
            if (ZeusTransformUtils.instanceOf(r5, C0764b.class) == true) goto L12;
            r5 = null;
        L12:
            C0764b r6 = (C0764b) ZeusTransformUtils.preCheckCast(r5, C0764b.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L16;
            r1 = Float.valueOf(r6.a());
        L16:
            if (r1 != null) goto L19;
            return 0.0f;
        L19:
            return r1.floatValue();
        L21:
            return 0.0f;
        L20:
            return 0.0f;
        }

        @Override // com.obric.oui.animation.a.c
        public /* synthetic */ float a(View r3) {
            return a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(View r3, float r4) {
            if (r3 == null) goto L16;
            Object r2 = r3.getTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, OaidModel.KEY_ID, "o_popover_anim_p"));
            if (r2 == null) goto L17;
            com.obric.oui.c.c r5 = com.obric.oui.c.c.f13403a;
            if (ZeusTransformUtils.instanceOf(r2, C0764b.class) == true) goto L11;
            r2 = null;
        L11:
            C0764b r6 = (C0764b) ZeusTransformUtils.preCheckCast(r2, C0764b.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L18;
            r6.a(r4);
            return;
        L18:
            return;
        L17:
            return;
        }

        @Override // com.obric.oui.animation.a.c
        public /* synthetic */ void a(View r3, float r4) {
            a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/popover/OPopover$animatorEasyInOut$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f14325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f14326b;
        final /* synthetic */ b c;
        final /* synthetic */ Ref.ObjectRef<com.obric.oui.animation.easy.b<? extends View>> d;

        h(boolean r1, ViewGroup r2, b r3, Ref.ObjectRef<com.obric.oui.animation.easy.b<? extends View>> r4) {
            this.f14325a = r1;
            this.f14326b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            if (this.f14325a == true) goto L10;
            this.f14326b.setVisibility(8);
            e r3 = b.a(this.c);
            if (r3 == null) goto L8;
            r3.a();
        L8:
            this.c.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationStart(r3);
            com.obric.oui.animation.easy.b r4 = (com.obric.oui.animation.easy.b) ZeusTransformUtils.preCheckCast(this.d.element, com.obric.oui.animation.easy.b.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            r4.b();
        L7:
            if (this.f14325a == false) goto L14;
            f r5 = b.b(this.c);
            if (r5 == null) goto L12;
            r5.a();
        L12:
            this.f14326b.setVisibility(0);
            return;
        }
    }

    static {
        f14318a = new c(null);
    }

    public b(a r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.h = ViewCompat.MEASURED_STATE_MASK;
        this.l = 200;
        this.m = 5000;
        this.n = true;
        this.q = "";
        this.s = 13.0f;
        this.v = true;
        this.w = 12.0f;
        this.z = true;
        this.C = true;
        this.E = 2.0f;
        this.L = true;
        this.ad = "";
        this.ae = -7829368;
        this.af = true;
        this.ag = true;
        this.S = ZeusTransformUtils.wrapperContext2Activity(ZeusTransformUtils.getActivity(r5, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f14320b = r5.b();
        this.d = r5.c();
        this.e = r5.d();
        this.f = r5.e();
        this.i = Boolean.valueOf(r5.f());
        this.j = r5.g();
        this.k = r5.h();
        this.l = r5.i();
        this.m = r5.j();
        this.n = r5.k();
        this.T = r5.l();
        this.p = r5.n();
        this.o = r5.m();
        this.q = r5.o();
        this.r = r5.p();
        this.s = r5.q();
        this.t = r5.s();
        this.u = r5.r();
        this.U = r5.t();
        this.W = r5.u();
        this.V = r5.v();
        this.v = r5.w();
        this.w = r5.x();
        this.z = r5.y();
        this.A = r5.a();
        this.g = r5.z();
        this.h = r5.A();
        this.D = r5.B();
        this.E = r5.C();
        this.F = r5.D();
        this.X = r5.E();
        this.Y = r5.F();
        this.Z = r5.G();
        this.aa = r5.H();
        this.G = r5.I();
        this.H = r5.J();
        this.I = r5.K();
        this.f14319J = r5.L();
        this.K = r5.M();
        this.L = r5.N();
        this.ad = r5.O();
        this.ae = r5.P();
        this.af = r5.Q();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.A);
        setOutsideTouchable(this.z);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.n == true) goto L10;
        View r2 = this.T;
        if (r2 == null) goto L10;
        a(r2);
        OPopoverLayout r3 = this.M;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L9:
        r3.setUseDefaultView(false);
    L11:
        f();
        setFocusable(true);
        this.ak = new $$Lambda$b$2mi1OV1lpePOhBa3vZPIYB7yZZs(this);
        this.al = (com.obric.oui.animation.a.c) ZeusTransformUtils.preCheckCast(new g(), com.obric.oui.animation.a.c.class, "com.obric.memorydata.plugin");
        return;
    L10:
        g();
        goto L11
    }

    public static final /* synthetic */ e a(b r0) {
        return r0.W;
    }

    private final Pair<Integer, Integer> a(int r1, int r2) {
        return b(r1, r2);
    }

    private final void a(View r8) {
        OPopoverLayout r0 = new OPopoverLayout((Context) ZeusTransformUtils.preCheckCast(this.S, Context.class, "com.obric.memorydata.plugin"));
        this.M = r0;
        ViewGroup r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBackgroundColor(0);
        if (this.n == true) goto L8;
        OPopoverLayout r1 = this.M;
        if (r1 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L20:
        int r5 = OPopoverLayout.f14313a.b();
    L21:
        r1.setCornerRadiusDp(r5);
        if (this.G != 0.0f) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == true) goto L30;
        OPopoverLayout r4 = this.M;
        if (r4 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L29:
        r4.setCornerRadius(this.G);
    L30:
        OPopoverLayout r6 = this.M;
        if (r6 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r6 = null;
    L33:
        r6.setSubText(this.ad);
        OPopoverLayout r7 = this.M;
        if (r7 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L36:
        r7.setGravity(17);
        OPopoverLayout r9 = this.M;
        if (r9 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r9 = null;
    L39:
        r9.addView(r8);
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(-2, -2);
        OPopoverLayout r11 = this.M;
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r11 = null;
    L42:
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (this.e == 0) goto L48;
        OPopoverLayout r12 = this.M;
        if (r12 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r12 = null;
    L47:
        r12.setMBgColor(this.e);
    L48:
        OPopoverLayout r13 = this.M;
        if (r13 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r13 = null;
    L51:
        r13.setMNeedArrow(this.v);
        OPopoverLayout r14 = this.M;
        if (r14 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r14 = null;
    L54:
        r14.setMNeedShadow(this.g);
        OPopoverLayout r15 = this.M;
        if (r15 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r15 = null;
    L57:
        r15.getShadowConfig().a(this.h);
        if (this.H == null) goto L64;
        OPopoverLayout r16 = this.M;
        if (r16 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r16 = null;
    L62:
        OPopoverLayout.b r17 = r16.getShadowConfig();
        Float r18 = this.H;
        Intrinsics.checkNotNull(r18);
        r17.b(r18.floatValue());
    L64:
        if (this.I == null) goto L70;
        OPopoverLayout r19 = this.M;
        if (r19 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r19 = null;
    L68:
        OPopoverLayout.b r20 = r19.getShadowConfig();
        Float r21 = this.I;
        Intrinsics.checkNotNull(r21);
        r20.c(r21.floatValue());
    L70:
        if (this.L == false) goto L78;
        OPopoverLayout r22 = this.M;
        if (r22 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r22 = null;
    L74:
        r22.setClickable(true);
        OPopoverLayout r23 = this.M;
        if (r23 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r23 = null;
    L77:
        r23.setOnClickListener(new $$Lambda$b$PqDyJsmQn7erChsxuOlA99dQOs(this));
    L82:
        OPopoverLayout r24 = this.M;
        if (r24 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r24 = null;
    L85:
        ViewGroup r25 = (ViewGroup) ZeusTransformUtils.preCheckCast(r24, ViewGroup.class, "com.obric.memorydata.plugin");
        this.N = r25;
        if (r25 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L89:
        setContentView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int r26 = Build.VERSION.SDK_INT;
        return;
    L88:
        r2 = r25;
        goto L89
    L78:
        OPopoverLayout r27 = this.M;
        if (r27 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r27 = null;
    L81:
        r27.setClickable(false);
        goto L82
    L24:
        r3 = false;
        goto L25
    L8:
        if (Intrinsics.areEqual(this.ad, "") == false) goto L13;
        r1 = this.M;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L12:
        r5 = OPopoverLayout.f14313a.c();
        goto L21
    L13:
        r1 = this.M;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L16:
        r5 = OPopoverLayout.f14313a.d();
        goto L21
    }

    private final void a(View r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r4, OPopoverMenuView.class) == false) goto L6;
        ((OPopoverMenuView) ZeusTransformUtils.preCheckCast(r4, OPopoverMenuView.class, "com.obric.memorydata.plugin")).setPopoverMaxHeight(r5);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L11;
        Iterator<View> r6 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        a((View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.memorydata.plugin"), r5);
        goto L9
    L13:
        return;
    }

    private static final void a(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, com.obric.oui.animation.a.b r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        com.obric.oui.c.c r11 = com.obric.oui.c.c.f13403a;
        Object r12 = r1.getTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, OaidModel.KEY_ID, "o_popover_anim_p"));
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((C0764b) ZeusTransformUtils.preCheckCast(r12, C0764b.class, "com.obric.memorydata.plugin")) == null) goto L11;
        float r13 = com.obric.oui.c.b.a(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, C0764b.class) == false) goto L4;
        goto L4
    }

    private static final void a(b r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        d r2 = r0.U;
        if (r2 == null) goto L7;
        r2.a();
    L7:
        if (r0.K == true) goto L10;
        r0.dismiss();
        return;
    }

    public static /* synthetic */ void a(b r9, View r10, int r11, boolean r12, float r13, int r14, int r15, boolean r16, int r17, Object r18) {
        if (r18 != null) goto L10;
        if ((r17 & 64) == 0) goto L6;
        boolean r8 = false;
    L7:
        r9.a(r10, r11, r12, r13, r14, r15, r8);
        return;
    L6:
        r8 = r16;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    private static final boolean a(b r3, View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r5.getAction() != 0) goto L12;
        com.obric.oui.c.h r6 = com.obric.oui.c.h.f13408a;
        OPopoverLayout r0 = r3.M;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L7:
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "event");
        if (r6.a(r1, r5) == false) goto L13;
        r3.dismiss();
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public static final /* synthetic */ f b(b r0) {
        return r0.V;
    }

    private final Pair<Integer, Integer> b(int r18, int r19) {
        ViewGroup r6 = null;
        if (this.ag == true) goto L15;
        ViewGroup r1 = this.N;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r1 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r1, SingleChildFrameLayout.class) == false) goto L15;
        ViewGroup r2 = this.N;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L13:
        r6.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "contentView.context");
        setWidth(com.obric.oui.common.util.h.a(r3));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(this.ah));
    L12:
        r6 = r2;
    L15:
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.S, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r4, SingleChildFrameLayout.class, "com.obric.memorydata.plugin");
        OPopoverLayout r8 = this.M;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L18:
        r5.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        OPopoverLayout r9 = this.M;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r9 = null;
    L21:
        r5.setShadowCornerRadius(MathKt.roundToInt(r9.getCornerRadius()));
        OPopoverLayout r10 = this.M;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r10 = null;
    L24:
        int r11 = r10.getArrowHeight();
        OPopoverLayout r12 = this.M;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r12 = null;
    L27:
        r5.setShadowInsets(r11, r12.getArrowHeight());
        List<k> r13 = com.obric.oui.common.style.f.a((Context) ZeusTransformUtils.preCheckCast(this.S, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.style.OUIShadow_3, "style", "OUIShadow_3"));
        Intrinsics.checkNotNullExpressionValue(r13, "shadows");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r110 = 0;
    L29:
        if (r14.hasNext() == false) goto L43;
        k r7 = (k) ZeusTransformUtils.preCheckCast(r14.next(), k.class, "com.obric.memorydata.plugin");
        if ((r7.b() - r7.c()) <= r17) goto L34;
        r17 = MathKt.roundToInt(r7.b() - r7.c());
    L34:
        if ((r7.b() + r7.c()) <= r110) goto L37;
        r110 = MathKt.roundToInt(r7.b() + r7.c());
    L37:
        if ((r7.b() - r7.d()) <= r15) goto L40;
        r15 = MathKt.roundToInt(r7.b() - r7.d());
    L40:
        if ((r7.b() + r7.d()) <= r16) goto L29;
        r16 = MathKt.roundToInt(r7.b() + r7.d());
        goto L29
    L43:
        SingleChildFrameLayout r20 = new SingleChildFrameLayout((Context) ZeusTransformUtils.preCheckCast(this.S, Context.class, "com.obric.memorydata.plugin"), null, 2, null);
        Context r21 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r21, "contentView.context");
        r20.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(com.obric.oui.common.util.h.a(r21), -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r20.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r20.setClipChildren(false);
        r20.setClipToPadding(false);
        r20.setPadding(0, r15, 0, r16);
        r5.setX(r18);
        r20.setOnTouchListener(new $$Lambda$b$qt8ZaN_hLd9wVaXiv53sdsm8E(this));
        this.ah = r15;
        ViewGroup r22 = (ViewGroup) ZeusTransformUtils.preCheckCast(r20, ViewGroup.class, "com.obric.memorydata.plugin");
        this.N = r22;
        if (r22 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r22 = null;
    L46:
        r22.setVisibility(4);
        ViewGroup r23 = this.N;
        if (r23 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L50:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r24 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r24, "contentView.context");
        setWidth(com.obric.oui.common.util.h.a(r24));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(r15));
    L49:
        r6 = r23;
        goto L50
    }

    private final void b(View r11, int r12, boolean r13, boolean r14) {
        int r3 = f14318a.a(r12);
        int[] r15 = new int[2];
        Point r0 = this.aj;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r15[0] = r0.x;
        r15[1] = r0.y;
    L9:
        int[] r16 = a(r13, r3, r11.getMeasuredWidth(), r11.getMeasuredHeight(), false, r14);
        if (this.f14319J == false) goto L12;
        showAsDropDown(r11, r16[0], r16[1] - r11.getMeasuredHeight(), 0);
    L13:
        this.ag = false;
        k();
        return;
    L12:
        showAtLocation(r11, 0, Math.max(0, r15[0] + r16[0]), Math.max(0, r15[1] + r16[1]));
        goto L13
    L6:
        if (this.F == false) goto L8;
        r11.getLocationInWindow(r15);
        goto L9
    L8:
        r11.getLocationOnScreen(r15);
        goto L9
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.obric.oui.animation.easy.b] */
    private final void b(boolean r24) {
        ViewGroup r2 = this.N;
        OPopoverLayout r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r2 = null;
    L5:
        int r4 = -1;
        if (r24 == true) goto L8;
        am--;
        this.P = true;
    L8:
        this.R = new AnimatorSet();
        int r6 = e();
        if (r6 != 3) goto L11;
        float r7 = r2.getX() + r2.getMeasuredWidth();
        float r8 = r2.getY();
        OPopoverLayout r12 = this.M;
        if (r12 != null) goto L31;
    L30:
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L32:
        float r5 = r3.getBubbleOffset() + r8;
    L33:
        View r10 = r2.getChildAt(0);
        if (r10 != null) goto L36;
        float r11 = 0.0f;
    L37:
        r2.setPivotY(r5);
        r2.setPivotX(r7 + r11);
        float r13 = 1.0f;
        PathInterpolator r9 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r14 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        if (r24 == false) goto L40;
        float r15 = 0.0f;
    L41:
        if (r24 == false) goto L43;
        float r16 = 1.0f;
    L45:
        if (r2.getAlpha() != 0.0f) goto L47;
        boolean r17 = true;
    L48:
        if (r17 == false) goto L50;
    L55:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r15, r16});
        if (r24 == false) goto L58;
        Object r19 = ZeusTransformUtils.preCheckCast(r9, TimeInterpolator.class, "com.obric.memorydata.plugin");
    L59:
        r18.setInterpolator((TimeInterpolator) r19);
        if (r24 == false) goto L62;
        long r110 = 300;
    L63:
        r18.setDuration(r110);
        r2.setVisibility(0);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        if (r24 == false) goto L71;
        Animator r21 = this.ab;
        if (r21 == null) goto L71;
        AnimatorSet r22 = this.R;
        if (r22 == null) goto L112;
    L70:
        r22.play(r21);
    L112:
        AnimatorSet r23 = this.R;
        if (r23 == null) goto L116;
        r23.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new h(r24, r2, this, r20), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
    L116:
        AnimatorSet r0 = this.R;
        if (r0 == null) goto L121;
        r0.start();
        return;
    L121:
        return;
    L71:
        if (r24 == true) goto L77;
        r21 = this.ac;
        if (r21 == null) goto L77;
        r22 = this.R;
        if (r22 != null) goto L70;
    L77:
        AnimatorSet r25 = this.R;
        if (r25 == null) goto L82;
        r25.play((Animator) ZeusTransformUtils.preCheckCast(r18, Animator.class, "com.obric.memorydata.plugin"));
    L82:
        if (r24 == false) goto L84;
        float r111 = 0.5f;
    L85:
        if (r24 == false) goto L87;
        float r112 = 1.0f;
    L89:
        if (e() == 48) goto L92;
        r4 = 1;
    L92:
        if (r24 == false) goto L94;
        float r26 = -com.obric.oui.common.util.h.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), 10);
    L95:
        float r27 = r4;
        final float r113 = r26 * r27;
        if (r24 == false) goto L98;
        float r28 = 0.0f;
    L99:
        final float r114 = r28 * r27;
        if (r24 == false) goto L102;
        final float r29 = 0.0f;
    L103:
        if (r24 == false) goto L105;
        final float r30 = 10000.0f;
    L107:
        if (com.obric.oui.animation.easy.c.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).a() == true) goto L109;
        r2.setScaleX(r111);
        r2.setScaleY(r111);
        r2.setTranslationY(r113);
        r2.setTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, OaidModel.KEY_ID, "o_popover_anim_p"), new C0764b(r29));
    L109:
        if (r24 == false) goto L111;
        r13 = 0.8f;
    L111:
        ?? r115 = com.obric.oui.animation.easy.b.a(com.obric.oui.animation.easy.c.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).a(r13).b(439.0f), this.al, r30, null, 4, null);
        final ViewGroup r31 = r2;
        final float r32 = r111;
        final float r33 = r112;
        r115.a(new $$Lambda$b$gxKLQnvWmHyAiVQRHcadG8hmrps(r31, r29, r30, r32, r33, r113, r114));
        r20.element = r115;
        goto L112
    L105:
        r30 = 0.0f;
        goto L107
    L102:
        r29 = 10000.0f;
        goto L103
    L98:
        r28 = -com.obric.oui.common.util.h.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), 10);
        goto L99
    L94:
        r26 = 0.0f;
        goto L95
    L87:
        r112 = 0.5f;
        goto L89
    L84:
        r111 = 1.0f;
        goto L85
    L62:
        r110 = 100;
        goto L63
    L58:
        r19 = ZeusTransformUtils.preCheckCast(r14, TimeInterpolator.class, "com.obric.memorydata.plugin");
        goto L59
    L50:
        if (r2.getAlpha() != 1.0f) goto L52;
        boolean r116 = true;
    L53:
        if (r116 == true) goto L55;
        r15 = r2.getAlpha();
        goto L55
    L52:
        r116 = false;
        goto L53
    L47:
        r17 = false;
        goto L48
    L43:
        r16 = 0.0f;
        goto L45
    L40:
        r15 = 1.0f;
        goto L41
    L36:
        r11 = r10.getX();
    L31:
        r3 = r12;
        goto L32
    L11:
        if (r6 == 5) goto L25;
        if (r6 == 48) goto L20;
        if (r6 == 80) goto L15;
        r5 = 0.0f;
        r7 = 0.0f;
        goto L33
    L15:
        float r34 = r2.getX();
        OPopoverLayout r35 = this.M;
        if (r35 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L19:
        r7 = r34 + r3.getBubbleOffset();
        r5 = r2.getY() + r2.getPaddingTop();
        goto L33
    L18:
        r3 = r35;
        goto L19
    L20:
        float r36 = r2.getX();
        OPopoverLayout r37 = this.M;
        if (r37 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L24:
        r7 = r36 + r3.getBubbleOffset();
        r5 = (r2.getY() + r2.getMeasuredHeight()) - r2.getPaddingBottom();
        goto L33
    L23:
        r3 = r37;
        goto L24
    L25:
        r7 = r2.getX();
        r8 = r2.getY();
        r12 = this.M;
        if (r12 != null) goto L31;
        goto L31
    }

    private static final void c(b r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.C == false) goto L6;
        r1.b(false);
        return;
    }

    private final int e() {
        return f14318a.a(this.f14320b);
    }

    private final void f() {
        boolean r1 = true;
        if (Intrinsics.areEqual(this.i, true) == false) goto L5;
        h();
    L5:
        OPopoverLayout r2 = null;
        if (this.e == 0) goto L11;
        OPopoverLayout r0 = this.M;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setMBgColor(this.e);
    L11:
        OPopoverLayout r3 = this.M;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L14:
        r3.setBubbleOrientation(c(e()));
        if (this.w == 0.0f) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L23;
        OPopoverLayout r4 = this.M;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setMPadding(this.Q);
    L23:
        OPopoverLayout r5 = this.M;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r5 = null;
    L26:
        r5.getShadowConfig().a(this.h);
        OPopoverLayout r6 = this.M;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r6 = null;
    L29:
        r6.getShadowConfig().a(this.E);
        OPopoverLayout r7 = this.M;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L32:
        r7.setBorderColor(this.Z);
        OPopoverLayout r8 = this.M;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L35:
        r8.setBorderWidth(this.Y);
        OPopoverLayout r9 = this.M;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L39:
        r2.setTransparentBg(this.aa);
        return;
    L38:
        r2 = r9;
        goto L39
    }

    private final void g() {
        PopoverTextView r2 = null;
        PopoverTextView r0 = new PopoverTextView((Context) ZeusTransformUtils.preCheckCast(this.S, Context.class, "com.obric.memorydata.plugin"), null, 2, null);
        this.O = r0;
        if (this.t == 0) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r0 = null;
    L6:
        int r1 = this.t;
    L10:
        r0.setTextColor(r1);
        if (this.u == null) goto L16;
        PopoverTextView r3 = this.O;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r3 = null;
    L15:
        r3.setTypeface(this.u);
    L16:
        PopoverTextView r4 = this.O;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r4 = null;
    L19:
        r4.setTextSize(1, 14.0f);
        PopoverTextView r5 = this.O;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r5 = null;
    L22:
        r5.setTextAlignment(5);
        PopoverTextView r6 = this.O;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r6 = null;
    L25:
        r6.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        PopoverTextView r7 = this.O;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r7 = null;
    L28:
        PopoverTextView r8 = this.O;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r8 = null;
    L31:
        r7.setLineHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 20));
        PopoverTextView r9 = this.O;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r9 = null;
    L34:
        r9.setGravity(17);
        PopoverTextView r10 = this.O;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r10 = null;
    L37:
        PopoverTextView r11 = this.O;
        if (r11 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r11 = null;
    L40:
        r10.setMaxWidth(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), 276));
        PopoverTextView r12 = this.O;
        if (r12 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r12 = null;
    L43:
        r12.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r13 = this.O;
        if (r13 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r13 = null;
    L46:
        a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"));
        if (this.i != null) goto L49;
        this.i = true;
    L49:
        boolean r14 = false;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.q, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L62;
        if (Intrinsics.areEqual(this.ad, "") == false) goto L57;
        PopoverTextView r15 = this.O;
        if (r15 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r15 = null;
    L56:
        r15.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.q, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L62
    L57:
        SpannableString r16 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(this.q + '\n' + this.ad, CharSequence.class, "com.obric.memorydata.plugin"));
        r16.setSpan(new StyleSpan(0), 0, this.q.length(), 33);
        r16.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, this.q.length(), 33);
        r16.setSpan(new AbsoluteSizeSpan(14, true), 0, this.q.length(), 33);
        r16.setSpan(new ForegroundColorSpan(this.ae), this.q.length() + 1, r16.length(), 33);
        r16.setSpan(new AbsoluteSizeSpan(14, true), this.q.length() + 1, r16.length(), 33);
        r16.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), this.q.length() + 1, r16.length(), 33);
        PopoverTextView r17 = this.O;
        if (r17 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r17 = null;
    L60:
        r17.setText((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
    L62:
        if (this.r == 0) goto L68;
        PopoverTextView r18 = this.O;
        if (r18 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r18 = null;
    L66:
        r18.setText(this.r);
    L68:
        if (this.s != 0.0f) goto L70;
        r14 = true;
    L70:
        if (r14 == true) goto L76;
        PopoverTextView r19 = this.O;
        if (r19 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L75:
        r2.setTextSize(1, this.s);
        goto L76
    L74:
        r2 = r19;
    L76:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L7:
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r0 = null;
    L9:
        r1 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.S, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_text, TypedValues.Custom.S_COLOR, "oui_toast_text"));
        goto L10
    }

    private final void h() {
        if (Intrinsics.areEqual(this.i, false) == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 19) goto L10;
        View r2 = getContentView();
        int r0 = 8;
    L8:
        r2.setSystemUiVisibility(r0);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 19) goto L13;
        r0 = 4102;
        r2 = getContentView();
        goto L8
    }

    private final void i() {
        int r0 = this.o;
        if (r0 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.p == 0) goto L7;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r2 = View.MeasureSpec.makeMeasureSpec(this.p, 1073741824);
        getContentView().measure(r1, r2);
    }

    private final void j() {
        ViewGroup r0 = this.N;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r0 = null;
    L5:
        r0.setVisibility(0);
        f r2 = this.V;
        if (r2 == null) goto L10;
        r2.a();
        return;
    }

    private final void k() {
        ViewGroup r4 = com.obric.oui.c.h.f13408a.a(this.S);
        if (r4 == null) goto L15;
        Sequence<View> r0 = ViewGroupKt.getChildren(r4);
        if (r0 == null) goto L17;
        Sequence r1 = SequencesKt.filter(r0, (Function1) ZeusTransformUtils.preCheckCast(OPopover$clearFakeAnchorViewIfNecessary$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        r4.removeView((View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.memorydata.plugin"));
        com.obric.oui.c.a.b.b("OPopover", "remove fake anchor view");
        goto L13
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static /* synthetic */ void lambda$2mi1OV1lpePOhBa3vZPIYB7yZZs(b r0) {
        c(r0);
    }

    /* JADX INFO: renamed from: lambda$PqDyJ-smQn7erChsxuOlA99dQOs, reason: not valid java name */
    public static /* synthetic */ void m1337lambda$PqDyJsmQn7erChsxuOlA99dQOs(b r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$gxKLQnvWmHyAiVQRHcadG8hmrps(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, com.obric.oui.animation.a.b r7, float r8, float r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$qt8ZaN_hL-d9wVaXiv53sds-m8E, reason: not valid java name */
    public static /* synthetic */ boolean m1338lambda$qt8ZaN_hLd9wVaXiv53sdsm8E(b r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        AnimatorSet r0 = this.R;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
    L6:
        AnimatorSet r1 = this.R;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        this.R = null;
        k();
        if (this.S.isFinishing() == true) goto L15;
        if (isShowing() == false) goto L15;
    L20:
        super.dismiss();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L15:
        if (an == true) goto L20;
    }

    public final void a(int r1) {
        this.j = r1;
    }

    public final void a(View r2, int r3, boolean r4, float r5, int r6, int r7, boolean r8) {
        int r9 = f14318a.a(r3);
        this.j = r6;
        this.k = r7;
        this.d = r5;
        a(r2, r9, r4, r8);
    }

    public final void a(View r7, int r8, boolean r9, boolean r10) {
        int r11 = f14318a.a(r8);
        if (this.S.isFinishing() == true) goto L35;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getWindowToken() == null) goto L38;
        this.x = r7.getMeasuredHeight();
        this.y = r7.getMeasuredWidth();
        getContentView().removeCallbacks(this.ak);
        this.f14320b = r11;
        OPopoverLayout r0 = this.M;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L11:
        this.Q = r0.getPadding();
        if (isShowing() == true) goto L33;
        int r2 = c(r11);
        i();
        if (r9 == false) goto L23;
        if (r11 != 48) goto L18;
    L20:
        int r4 = c();
    L21:
        this.c = r4 / 2.0f;
    L25:
        OPopoverLayout r5 = this.M;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L29:
        r1.a(r2, this.c + this.d);
        b(r7, r11, r9, r10);
        this.P = false;
        if (this.m <= 0) goto L32;
        getContentView().postDelayed(this.ak, this.m);
    L32:
        am++;
        return;
    L28:
        r1 = r5;
        goto L29
    L18:
        if (r11 == 80) goto L20;
        r4 = b();
        goto L21
    L23:
        if (this.B == true) goto L25;
        this.d += this.Q;
        this.B = true;
        goto L25
    L33:
        super.dismiss();
        return;
    L38:
        return;
    }

    public final void a(boolean r1) {
        this.D = r1;
    }

    public final int[] a(boolean r8, int r9, int r10, int r11, boolean r12, boolean r13) {
        int[] r1 = new int[2];
        if (this.D == false) goto L14;
        if (r8 == true) goto L14;
        if (r12 == true) goto L14;
        int r14 = e();
        if (r14 == 3) goto L13;
        if (r14 == 5) goto L13;
        if (r14 == 48) goto L12;
        if (r14 != 80) goto L14;
    L12:
        this.j -= d();
    L13:
        this.k -= d();
    L14:
        int r15 = f14318a.a(r9);
        if (r15 == 3) goto L36;
        if (r15 == 5) goto L31;
        if (r15 == 48) goto L26;
        if (r15 == 80) goto L21;
    L40:
        return r1;
    L21:
        if ((r8 | r13) == false) goto L23;
        int r16 = (r10 - c()) / 2;
    L24:
        r1[0] = this.j + r16;
        r1[1] = this.k + r11;
        goto L40
    L23:
        r16 = 0;
        goto L24
    L26:
        if ((r8 | r13) == false) goto L28;
        int r17 = (r10 - c()) / 2;
    L29:
        r1[0] = this.j + r17;
        r1[1] = (-b()) + this.k;
        goto L40
    L28:
        r17 = 0;
        goto L29
    L31:
        if ((r8 | r13) == false) goto L33;
        int r18 = (r11 - b()) / 2;
    L34:
        r1[0] = this.j + r10;
        r1[1] = this.k + r18;
        goto L40
    L33:
        r18 = 0;
        goto L34
    L36:
        if ((r8 | r13) == false) goto L38;
        int r19 = (r11 - b()) / 2;
    L39:
        r1[0] = this.j - c();
        r1[1] = this.k + r19;
        goto L40
    L38:
        r19 = 0;
        goto L39
    }

    public final int b() {
        i();
        return getContentView().getMeasuredHeight();
    }

    public final void b(int r1) {
        this.k = r1;
    }

    public final int c() {
        i();
        return getContentView().getMeasuredWidth();
    }

    public final int c(int r3) {
        int r2 = f14318a.a(r3);
        if (r2 != 3) goto L5;
        return 2;
    L5:
        if (r2 == 5) goto L15;
        if (r2 != 48) goto L9;
        return 3;
    L9:
        if (r2 != 80) goto L15;
        return 0;
    L15:
        return 1;
    }

    public final int d() {
        OPopoverLayout r0 = this.M;
        if (r0 == null) goto L7;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L9:
        return r0.getArrowHeight();
    L7:
        return 0;
    }

    public final void d(int r3) {
        OPopoverLayout r0 = this.M;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBubbleOrientation(c(f14318a.a(r3)));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.P == true) goto L6;
        b(false);
        getContentView().removeCallbacks(this.ak);
        this.j = 0;
        this.k = 0;
        return;
    }

    public final void e(int r6) {
        OPopoverLayout r0 = this.M;
        if (r0 == null) goto L18;
        if (r6 <= 0) goto L19;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L9:
        int r7 = RangesKt.coerceAtLeast(r6 - (r0.getArrowHeight() * 2), 0);
        OPopoverLayout r2 = this.M;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L12:
        a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), r7);
        OPopoverLayout r8 = this.M;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L16:
        r1.requestLayout();
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L15:
        r1 = r8;
        goto L16
    L19:
        return;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r5, int r6, int r7, int r8) {
        int r9 = f14318a.a(r8);
        Pair<Integer, Integer> r1 = a(r6, r7);     // Catch: Exception -> L8
        super.showAsDropDown(r5, r6 - ((Number) ZeusTransformUtils.preCheckCast(r1.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), r7 - ((Number) ZeusTransformUtils.preCheckCast(r1.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue(), r9);     // Catch: Exception -> L8
        this.P = false;     // Catch: Exception -> L8
        if (this.af == false) goto L6;
        b(true);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        j();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.obric.oui.c.a.b.a("OPopover", "showAsDropDown, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "anchor");
        int r15 = f14318a.a(r12);
        Pair<Integer, Integer> r2 = a(r13, r14);     // Catch: Exception -> L19
        if (this.ai == false) goto L13;
        View r3 = r11.getRootView();     // Catch: Exception -> L19
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r5, "anchor.context");     // Catch: Exception -> L19
        int r6 = com.obric.oui.common.util.h.a(r5);     // Catch: Exception -> L19
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r7, "anchor.context");     // Catch: Exception -> L19
        int r0 = com.obric.oui.common.util.h.b(r7);     // Catch: Exception -> L19
        int r8 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L19
        int r9 = com.obric.oui.window.a.f14878a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L19
        if (r3.getWidth() >= r6) goto L8;
        float r10 = (r6 - r3.getWidth()) / 2.0f;     // Catch: Exception -> L19
    L9:
        int r16 = MathKt.roundToInt(r10);     // Catch: Exception -> L19
        if (r3.getHeight() >= r0) goto L12;
        int r1 = ((r0 - r3.getHeight()) + r8) + r9;     // Catch: Exception -> L19
    L14:
        super.showAtLocation(r11, r15, (r13 - ((Number) ZeusTransformUtils.preCheckCast(r2.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue()) - r16, (r14 - ((Number) ZeusTransformUtils.preCheckCast(r2.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()) - r1);     // Catch: Exception -> L19
        this.P = false;     // Catch: Exception -> L19
        if (this.af == false) goto L17;
        b(true);     // Catch: Exception -> L19
        return;
    L17:
        j();     // Catch: Exception -> L19
        return;
    L12:
        r1 = 0;
        goto L14
    L8:
        r10 = 0.0f;
        goto L9
    L13:
        r1 = 0;
        r16 = 0;
    L19:
        e = move-exception;
        com.obric.oui.c.a.b.a("OPopover", "showAtLocation, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
