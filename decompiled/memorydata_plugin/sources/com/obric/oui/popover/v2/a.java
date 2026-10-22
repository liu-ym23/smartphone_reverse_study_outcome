package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.h;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b7\b\u0016\u0018\u0000 Ó\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\nÒ\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u009a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00132\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0003J(\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00132\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0002J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\n\u0010¡\u0001\u001a\u00030 \u0001H\u0016J\b\u0010¢\u0001\u001a\u00030 \u0001J\n\u0010£\u0001\u001a\u00030 \u0001H\u0016J\u000f\u0010¤\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b¥\u0001J\t\u0010¦\u0001\u001a\u000202H\u0002J\u0007\u0010§\u0001\u001a\u00020\u0016J\u0007\u0010¨\u0001\u001a\u00020\u0013J\u0007\u0010©\u0001\u001a\u00020\u0013J\u0007\u0010ª\u0001\u001a\u000208J\n\u0010«\u0001\u001a\u00030 \u0001H\u0002J\n\u0010¬\u0001\u001a\u00030 \u0001H\u0002J\u0014\u0010\u00ad\u0001\u001a\u00020\n2\t\u0010®\u0001\u001a\u0004\u0018\u000108H\u0002J\t\u0010¯\u0001\u001a\u00020\nH\u0016J\n\u0010°\u0001\u001a\u00030 \u0001H\u0002J\b\u0010±\u0001\u001a\u00030 \u0001J\n\u0010²\u0001\u001a\u00030 \u0001H\u0016J\n\u0010³\u0001\u001a\u00030 \u0001H\u0016J\n\u0010´\u0001\u001a\u00030 \u0001H\u0016J\n\u0010µ\u0001\u001a\u00030 \u0001H\u0016J\t\u0010¶\u0001\u001a\u00020\u0013H\u0016J\u0013\u0010·\u0001\u001a\u00030 \u00012\u0007\u0010¸\u0001\u001a\u000208H\u0002J\u001a\u0010¹\u0001\u001a\u00030 \u00012\u0007\u0010º\u0001\u001a\u00020\u00072\u0007\u0010»\u0001\u001a\u00020\u0007J\u0010\u0010¼\u0001\u001a\u00030 \u00012\u0006\u0010T\u001a\u00020\nJ\u0011\u0010½\u0001\u001a\u00030 \u00012\u0007\u0010¾\u0001\u001a\u00020\nJ\u0011\u0010¿\u0001\u001a\u00030 \u00012\u0007\u0010À\u0001\u001a\u00020\u0013J\u0011\u0010Á\u0001\u001a\u00030 \u00012\u0007\u0010Â\u0001\u001a\u00020\nJ\u0011\u0010Ã\u0001\u001a\u00030 \u00012\u0007\u0010Ä\u0001\u001a\u00020\u0013J\u0011\u0010Å\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020\u001fJ\u0011\u0010Ç\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020/J\u0011\u0010È\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u000206J\u0011\u0010É\u0001\u001a\u00030 \u00012\u0007\u0010Ê\u0001\u001a\u00020\u0013J\u0011\u0010Ë\u0001\u001a\u00030 \u00012\u0007\u0010Ì\u0001\u001a\u00020\u0013J0\u0010Í\u0001\u001a\u00030 \u00012\t\u0010Î\u0001\u001a\u0004\u0018\u0001082\u0007\u0010Ï\u0001\u001a\u00020\u00132\u0007\u0010Ð\u0001\u001a\u00020\u00132\u0007\u0010À\u0001\u001a\u00020\u0013H\u0016J.\u0010Ñ\u0001\u001a\u00030 \u00012\u0007\u0010Î\u0001\u001a\u0002082\u0007\u0010À\u0001\u001a\u00020\u00132\u0007\u0010\u009c\u0001\u001a\u00020\u00132\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u0014\u0010D\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010R\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010OR$\u0010U\u001a\u00020)2\u0006\u0010T\u001a\u00020)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u000fR\u0014\u0010_\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010OR\u0014\u0010a\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u000fR\u0016\u0010c\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010f\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010eR\u001c\u0010h\u001a\u00020\u00138VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010O\"\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010OR&\u0010n\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0p0oX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010O\"\u0004\bv\u0010kR\u001a\u0010w\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010O\"\u0004\by\u0010kR\u001a\u0010z\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u000f\"\u0004\b|\u0010}R\u001b\u0010~\u001a\u00020\nX\u0096\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u000f\"\u0005\b\u0080\u0001\u0010}R\u0016\u0010\u0081\u0001\u001a\u00020\nX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u000fR\u0016\u0010\u0083\u0001\u001a\u0002028VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010>R\u0016\u0010\u0085\u0001\u001a\u00020\u00138WX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010OR\u0016\u0010\u0087\u0001\u001a\u0002028VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010>R\u0016\u0010\u0089\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u000fR\u0016\u0010\u008b\u0001\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010OR)\u0010\u008d\u0001\u001a\u00020;2\u0006\u0010T\u001a\u00020;8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001d\u0010\u0092\u0001\u001a\u00020\u0013X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010O\"\u0005\b\u0094\u0001\u0010kR\u001d\u0010\u0095\u0001\u001a\u00020\u0013X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010O\"\u0005\b\u0097\u0001\u0010kR\u000f\u0010\u0098\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006×\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover;", "Landroid/widget/PopupWindow;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "builder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "(Lcom/obric/oui/popover/v2/OPopover$Builder;)V", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "isPopoverBubbleLayoutInitialized", "()Z", "mActivity", "Landroid/app/Activity;", "mAnchorViewHeight", "", "mAnchorViewWidth", "mAnimTime", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mContext", "Landroid/content/Context;", "mCoverPreviousWhenStacked", "mDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mDisplayOrientation", "mFocusable", "mGetLocationInWindow", "mHeight", "mIsFirstShow", "mIsShowInDialog", "mOBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "mOutsideTouchable", "mShadowEnabled", "mShadowSpaceTop", "mShadowStyle", "mShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "mSpacingForShadow", "mStackAlphaPrevious", "", "mStackCoverColor", "mStackScalePrevious", "mStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "mView", "Landroid/view/View;", "mWidth", "mWindowFrame", "Landroid/view/ViewGroup;", "popoverAnchorCenterX", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterY", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnimationDurationMillis", "getPopoverAnimationDurationMillis", "()J", "popoverAnimator", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverBgColor", "getPopoverBgColor", "()I", "popoverBorderColor", "getPopoverBorderColor", "popoverBorderWidth", "getPopoverBorderWidth", EventBody.KEY_VALUE, "popoverBubbleLayout", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverContext", "getPopoverContext", "()Landroid/content/Context;", "popoverCoverPreviousWhenStacked", "getPopoverCoverPreviousWhenStacked", "popoverDisplayOrientation", "getPopoverDisplayOrientation", "popoverEnableBubbleMaterial", "getPopoverEnableBubbleMaterial", "popoverEnterAnimator", "getPopoverEnterAnimator", "()Landroid/animation/Animator;", "popoverExitAnimator", "getPopoverExitAnimator", "popoverGravity", "getPopoverGravity", "setPopoverGravity", "(I)V", "popoverHeight", "getPopoverHeight", "popoverMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverPopupOriginX", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginY", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPushedToStack", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverRemovedFromStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverShowWithAnimation", "getPopoverShowWithAnimation", "popoverStackAlphaPrevious", "getPopoverStackAlphaPrevious", "popoverStackCoverColor", "getPopoverStackCoverColor", "popoverStackScalePrevious", "getPopoverStackScalePrevious", "popoverTransparentBg", "getPopoverTransparentBg", "popoverWidth", "getPopoverWidth", "popoverWindowFrame", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverXOffset", "getPopoverXOffset", "setPopoverXOffset", "popoverYOffset", "getPopoverYOffset", "setPopoverYOffset", "transparentBg", "useWindowCoords", "addShadowFrame", "Lkotlin/Pair;", "x", "y", "addShadowFrameIfNeeded", "clearFakeAnchorViewIfNecessary", "", "dismiss", "dismissDirectly", "finishPopoverDismissInternal", "getDisplayRotationDegrees", "getDisplayRotationDegrees$OUI_standardRelease", "getElevationPx", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getPopoverView", "hideSystemUi", "initContentView", "isAnchorFromPopupWindow", "anchorRoot", "isPopoverShowing", "measure", "onDestroy", "onPopoverShownInternal", "onPopoverStartDismissInternal", "playPopoverEnterAnimationInternal", "playPopoverExitAnimationInternal", "resolvePopoverAnimationGravityInternal", "setBubbleLayout", "view", "setCustomAnimator", "inAnimator", "outAnimator", "setEnableAutoDismiss", "setGetLocationInWindow", "getLocationInWindow", "setGravity", "gravity", "setIsShowInDialog", "isShowInDialog", "setMaxContentHeight", "maxHeight", "setOnDismissListener", "listener", "setOnShowListener", "setOnStartDismissListener", "setXOffset", "xOffset", "setYOffset", "yOffset", "showAsDropDown", "anchor", "xoff", "yoff", "showAtLocation", "Builder", "Companion", "OnBubbleDismissListener", "OnBubbleShowListener", "OnBubbleStartDismissListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a extends PopupWindow implements com.obric.oui.popover.v2.c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14351a = null;
    private static boolean ab;
    private e A;
    private c B;
    private int C;
    private int D;
    private boolean E;
    private Animator F;
    private Animator G;
    private boolean H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f14352J;
    private boolean K;
    private int L;
    private boolean M;
    private float N;
    private float O;
    private boolean P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private float U;
    private float V;
    private boolean W;
    private boolean X;
    private final boolean Y;
    private final Function1<Boolean, com.obric.oui.material.c[]> Z;
    private final Runnable aa;
    private final boolean c;
    private final long d;
    private int e;
    private int f;
    private int g;
    private Boolean h;
    private int i;
    private int j;
    private long k;
    private long l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private OPopoverLayout s;
    private ViewGroup t;
    private boolean u;
    private AnimatorSet v;
    private Context w;
    private Activity x;
    private View y;
    private d z;

    /* JADX INFO: renamed from: com.obric.oui.popover.v2.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$Builder;", "Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0765a extends com.obric.oui.popover.v2.d<C0765a> {
        public C0765a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\b\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$Companion;", "", "()V", "TAG", "", "shouldForceDismiss", "", "adaptGravity", "", "originGravity", "adaptGravity$OUI_standardRelease", "setShouldForceDismiss", "", "forceDismiss", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        public final int a(int r5) {
            boolean r1 = true;
            if ((r5 & GravityCompat.START) != 8388611) goto L5;
            boolean r4 = true;
        L7:
            if ((r5 & GravityCompat.END) == 8388613) goto L10;
            r1 = false;
        L10:
            if (r4 == false) goto L12;
            r5 = ((-8388612) & r5) | 3;
        L12:
            if (r1 == true) goto L14;
            return r5;
        L14:
            return ((-8388614) & r5) | 5;
        L5:
            r4 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "", "bubbleStartDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface e {
        void a();
    }

    static {
        f14351a = new b(null);
    }

    public a(C0765a r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.c = r5.u();
        this.d = r5.h();
        this.k = 200;
        this.l = 5000;
        this.o = true;
        this.q = true;
        this.H = true;
        this.I = ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Regular, "style", "OUIShadow_Oui_Shadow_Regular");
        this.K = true;
        this.N = Float.NaN;
        this.O = Float.NaN;
        this.S = true;
        this.T = Color.parseColor("#08000000");
        this.U = 0.3f;
        this.V = 0.98f;
        this.Y = r5.y();
        this.Z = r5.z();
        this.w = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        setPopoverGravity(r5.b());
        this.f = r5.c();
        this.x = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.oui.window.a.f14878a.getActivity(this.w), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.g = r5.d();
        this.h = Boolean.valueOf(r5.e());
        setPopoverXOffset(r5.f());
        setPopoverYOffset(r5.g());
        this.k = r5.h();
        this.l = r5.i();
        this.y = r5.j();
        this.n = r5.l();
        this.m = r5.k();
        this.A = r5.m();
        this.B = r5.n();
        this.z = r5.o();
        this.o = r5.p();
        this.p = r5.a();
        this.r = r5.q();
        this.C = r5.r();
        this.D = r5.s();
        this.E = r5.t();
        this.H = r5.v();
        this.I = r5.w();
        this.f14352J = r5.x();
        this.S = r5.A();
        this.T = r5.B();
        this.U = r5.C();
        this.V = r5.D();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.p);
        setOutsideTouchable(this.o);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        c(a(this.y));
        s();
        setFocusable(true);
        this.aa = new $$Lambda$a$OHRud6_uCu3PfsckGjAH7BctYDI(this);
    }

    public static final /* synthetic */ int a(a r0) {
        return r0.I;
    }

    private final Pair<Integer, Integer> a(int r2, int r3) {
        if (this.H == false) goto L6;
        return b(r2, r3);
    L6:
        return new Pair(0, 0);
    }

    private static final boolean a(a r3, View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r5.getAction() != 0) goto L12;
        h r6 = h.f13408a;
        OPopoverLayout r0 = r3.s;
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

    private final Pair<Integer, Integer> b(int r20, int r21) {
        ViewGroup r6 = null;
        if (this.K == true) goto L15;
        ViewGroup r1 = this.t;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r1 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r1, SingleChildFrameLayout.class) == false) goto L15;
        ViewGroup r2 = this.t;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L13:
        r6.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "contentView.context");
        setWidth(com.obric.oui.common.util.h.a(r3));
        return new Pair(Integer.valueOf(r20), Integer.valueOf(this.L));
    L12:
        r6 = r2;
    L15:
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from(this.w), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r4, SingleChildFrameLayout.class, "com.obric.memorydata.plugin");
        OPopoverLayout r8 = this.s;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L18:
        r5.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        OPopoverLayout r9 = this.s;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r9 = null;
    L21:
        r5.setShadowCornerRadius(MathKt.roundToInt(r9.getCornerRadius()));
        OPopoverLayout r10 = this.s;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r10 = null;
    L24:
        int r11 = r10.getArrowHeight();
        OPopoverLayout r12 = this.s;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r12 = null;
    L27:
        r5.setShadowInsets(r11, r12.getArrowHeight());
        int r13 = this.I;
        if (r13 != 0) goto L32;
        r13 = ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Thick, "style", "OUIShadow_Oui_Shadow_Thick");
    L32:
        if (this.f14352J == false) goto L34;
        com.obric.oui.popover.v2.c.C0767c r14 = f(r13);
    L35:
        r14.a();
        int r15 = r14.b();
        r14.c();
        int r16 = r14.d();
        SingleChildFrameLayout r17 = new SingleChildFrameLayout(this.w, null, 2, null);
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r18, "contentView.context");
        r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(com.obric.oui.common.util.h.a(r18), -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r17.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r17.setClipChildren(false);
        r17.setClipToPadding(false);
        r17.setPadding(0, r15, 0, r16);
        r5.setX(r20);
        r17.setOnTouchListener(new $$Lambda$a$iuBzTvAjFiQm8SRue4O2x5ima6k(this));
        this.L = r15;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r17, ViewGroup.class, "com.obric.memorydata.plugin");
        this.t = r7;
        if (r7 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r7 = null;
    L38:
        r7.setVisibility(4);
        ViewGroup r19 = this.t;
        if (r19 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L42:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r22, "contentView.context");
        setWidth(com.obric.oui.common.util.h.a(r22));
        return new Pair(Integer.valueOf(r20), Integer.valueOf(r15));
    L41:
        r6 = r19;
        goto L42
    L34:
        r14 = new com.obric.oui.popover.v2.c.C0767c(0, 0, 0, 0, 15, null);
        goto L35
    }

    private static final void b(a r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.q == false) goto L6;
        r1.dismiss();
        return;
    }

    private final void c(View r6) {
        a(com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r6, 0, 2, null));
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-2, -2);
        getPopoverBubbleLayout().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        a((ViewGroup) ZeusTransformUtils.preCheckCast(getPopoverBubbleLayout(), ViewGroup.class, "com.obric.memorydata.plugin"));
        setContentView((View) ZeusTransformUtils.preCheckCast(getPopoverWindowFrame(), View.class, "com.obric.memorydata.plugin"));
        View r8 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r8, "contentView");
        a(r8, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private final boolean d(View r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        String r1 = r8.getClass().getName();
        if (Intrinsics.areEqual(r1, "android.widget.PopupWindow$PopupDecorView") == false) goto L37;
        return true;
    L37:
        boolean r2 = ZeusTransformUtils.instanceOf(ZeusTransformUtils.forName("android.widget.PopupWindow$PopupDecorView", "com.obric.memorydata.plugin"), r8);     // Catch: Throwable -> L10
    L11:
        if (r2 == false) goto L39;
        return true;
    L39:
        IBinder r3 = r8.getWindowToken();     // Catch: Throwable -> L36
        IBinder r4 = r8.getApplicationWindowToken();     // Catch: Throwable -> L36
        if (r3 == null) goto L19;
        if (r4 == null) goto L19;
        if (Intrinsics.areEqual(r3, r4) == true) goto L19;
        boolean r5 = true;
    L20:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r9, WindowManager.LayoutParams.class) == false) goto L23;
        WindowManager.LayoutParams r10 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r9, WindowManager.LayoutParams.class, "com.obric.memorydata.plugin");
    L24:
        if (r10 != null) goto L27;
    L25:
        boolean r11 = false;
    L31:
        if (r5 == false) goto L34;
        if (r11 == false) goto L34;
        return true;
    L34:
        Intrinsics.checkNotNullExpressionValue(r1, "className");
        return StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("PopupDecorView", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null);
    L27:
        if (r10.type != 1002) goto L29;
    L30:
        r11 = true;
        goto L31
    L29:
        if (r10.type != 1000) goto L25;
    L23:
        r10 = null;
    L19:
        r5 = false;
    L10:
        r2 = false;
        goto L11
    }

    public static /* synthetic */ void lambda$OHRud6_uCu3PfsckGjAH7BctYDI(a r0) {
        b(r0);
    }

    public static /* synthetic */ boolean lambda$iuBzTvAjFiQm8SRue4O2x5ima6k(a r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    private final void s() {
        if (Intrinsics.areEqual(this.h, true) == false) goto L5;
        t();
    L5:
        OPopoverLayout r1 = null;
        if (this.g == 0) goto L11;
        OPopoverLayout r0 = this.s;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setBgColor(this.g);
    L11:
        OPopoverLayout r2 = this.s;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L15:
        if (r2.b() == true) goto L23;
        OPopoverLayout r3 = this.s;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L19:
        r3.setBorderColor(this.D);
        OPopoverLayout r4 = this.s;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setBorderWidth(this.C);
    L23:
        OPopoverLayout r5 = this.s;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L27:
        r1.setTransparentBg(this.E);
        return;
    L26:
        r1 = r5;
        goto L27
    }

    private final void t() {
        if (Intrinsics.areEqual(this.h, false) == false) goto L6;
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

    private final void u() {
        if (this.x != null) goto L5;
        return;
    L5:
        h r0 = h.f13408a;
        Activity r4 = this.x;
        Intrinsics.checkNotNull(r4);
        ViewGroup r5 = r0.a(r4);
        if (r5 == null) goto L18;
        Sequence<View> r1 = ViewGroupKt.getChildren(r5);
        if (r1 == null) goto L20;
        Sequence r2 = SequencesKt.filter(r1, (Function1) ZeusTransformUtils.preCheckCast(OPopover$clearFakeAnchorViewIfNecessary$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L21;
        Iterator r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L22;
        r5.removeView((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin"));
        com.obric.oui.c.a.b.b("OPopover", "remove fake anchor view");
        goto L16
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    private final float v() {
        int r0 = this.I;
        if (r0 == 0) goto L16;
        float r1 = g(r0);
        if (r1 > 0.0f) goto L12;
        com.obric.oui.c.a.b r2 = com.obric.oui.c.a.b.f13400a;
        if (r2.a(8) == true) goto L10;
        r2.a().a("OPopover", 8, Intrinsics.stringPlus("surfaceInsets elevation resolved to 0, fallback to default. shadowStyleRes=", Integer.valueOf(a(this))), null);
    L10:
        return 0.0f;
    L12:
        if (this.f14352J == false) goto L15;
        return 0.0f;
    L15:
        return r1;
    L16:
        return 0.0f;
    }

    @Override // com.obric.oui.popover.v2.c
    public float a(float r3, int r4, float r5) {
        return com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    @Override // com.obric.oui.popover.v2.c
    public AnimatorSet a(boolean r10, int r11, boolean r12, Animator r13, Function0<Unit> r14, Function0<Unit> r15) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        return com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13, r7, r8);
    }

    public View a(View r3) {
        return com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.c
    public OPopoverLayout a(View r3, int r4) {
        return com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public void a(float r1) {
        this.N = r1;
    }

    public void a(int r1) {
        this.Q = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(int r3, View r4) {
        com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(int r3, View r4, int r5, int r6) {
        com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(View r3, int r4, int r5) {
        com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    public void a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        this.t = r2;
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(ViewGroup r3, Function0<Unit> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3, r5);
    }

    public void a(OPopoverLayout r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        this.s = r2;
    }

    public final void a(boolean r1) {
        this.r = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean a() {
        if (this.s == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int b() {
        return k();
    }

    public void b(float r1) {
        this.O = r1;
    }

    public void b(int r1) {
        this.R = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void b(View r3) {
        com.obric.oui.popover.v2.c.b.b((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void c() {
        n();
        u();
        r();
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.oui.window.a.f14878a.getActivity(this.w), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L14:
        super.dismiss();     // Catch: Exception -> L13
        return;
    L16:
        return;
    L5:
        if (r0.isFinishing() == true) goto L9;
        if (isShowing() == true) goto L14;
    L9:
        if (ab == true) goto L14;
    }

    public final void c(int r3) {
        if (this.s == null) goto L8;
        if (r3 <= 0) goto L9;
        View r0 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r0, "contentView");
        a(r3, r0, Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.popover.v2.c
    public void d() {
        setAnimationStyle(0);
        d r1 = this.z;
        if (r1 == null) goto L7;
        r1.a();
        return;
    }

    public final void d(int r1) {
        e(r1);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.u == false) goto L5;
        return;
    L5:
        if (m() == false) goto L7;
        h();
    L8:
        getContentView().removeCallbacks(this.aa);
        setPopoverXOffset(0);
        setPopoverYOffset(0);
        return;
    L7:
        i();
        goto L8
    }

    @Override // com.obric.oui.popover.v2.c
    public int e() {
        return getPopoverGravity();
    }

    public void e(int r3) {
        com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3);
    }

    public com.obric.oui.popover.v2.c.C0767c f(int r3) {
        return com.obric.oui.popover.v2.c.b.d((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.c
    public void f() {
        setAnimationStyle(0);
        this.u = true;
        e r1 = this.A;
        if (r1 == null) goto L7;
        r1.a();
        return;
    }

    public float g(int r3) {
        return com.obric.oui.popover.v2.c.b.e((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"), r3);
    }

    public void g() {
        setAnimationStyle(0);
        com.obric.oui.popover.v2.c.b.j((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public View getContentViewInternal() {
        return com.obric.oui.popover.v2.c.b.e((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverAnchorCenterX() {
        return this.N;
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverAnchorCenterY() {
        return this.O;
    }

    @Override // com.obric.oui.popover.v2.c
    public long getPopoverAnimationDurationMillis() {
        return this.d;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverAnimationIsWindowMode() {
        return com.obric.oui.popover.v2.c.b.a((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public AnimatorSet getPopoverAnimator() {
        return this.v;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverBgColor() {
        return this.g;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverBorderColor() {
        return this.D;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverBorderWidth() {
        return this.C;
    }

    @Override // com.obric.oui.popover.v2.c
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r0 = this.s;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        return null;
    L6:
        return r0;
    }

    @Override // com.obric.oui.popover.v2.c
    public Context getPopoverContext() {
        return this.w;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.S;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverDisplayOrientation() {
        return this.f;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverEnableBubbleMaterial() {
        return this.Y;
    }

    @Override // com.obric.oui.popover.v2.c
    public Animator getPopoverEnterAnimator() {
        return this.F;
    }

    @Override // com.obric.oui.popover.v2.c
    public Animator getPopoverExitAnimator() {
        return this.G;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverGravity() {
        return f14351a.a(this.e);
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverHeight() {
        return this.n;
    }

    @Override // com.obric.oui.popover.v2.c
    public Function1<Boolean, com.obric.oui.material.c[]> getPopoverMaterials() {
        return this.Z;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverPopupOriginX() {
        return this.Q;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverPopupOriginY() {
        return this.R;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverPushedToStack() {
        return this.W;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverRemovedFromStack() {
        return this.X;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverShowWithAnimation() {
        return this.c;
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverStackAlphaPrevious() {
        return this.U;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverStackCoverColor() {
        return this.T;
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverStackScalePrevious() {
        return this.V;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverTransparentBg() {
        return this.E;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverWidth() {
        return this.m;
    }

    @Override // com.obric.oui.popover.v2.c
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r0 = this.t;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        return null;
    L6:
        return r0;
    }

    public void h() {
        setAnimationStyle(0);
        com.obric.oui.popover.v2.c.b.k((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public void i() {
        setPopoverAnimator(null);
        c r0 = this.B;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        c();
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean j() {
        return isShowing();
    }

    public int k() {
        return com.obric.oui.popover.v2.c.b.d((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public void l() {
        com.obric.oui.popover.v2.c.b.f((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    public boolean m() {
        return com.obric.oui.popover.v2.c.b.g((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public void n() {
        com.obric.oui.popover.v2.c.b.h((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    public void o() {
        com.obric.oui.popover.v2.c.b.i((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    public void p() {
        com.obric.oui.popover.v2.c.b.l((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    public void q() {
        com.obric.oui.popover.v2.c.b.m((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    public void r() {
        com.obric.oui.popover.v2.c.b.n((com.obric.oui.popover.v2.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverAnimator(AnimatorSet r1) {
        this.v = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverGravity(int r1) {
        this.e = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverPushedToStack(boolean r1) {
        this.W = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverRemovedFromStack(boolean r1) {
        this.X = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverXOffset(int r1) {
        this.i = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverYOffset(int r1) {
        this.j = r1;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        int r14 = f14351a.a(r13);
        p();     // Catch: Exception -> L29
        Pair<Integer, Integer> r1 = a(r11, r12);     // Catch: Exception -> L29
        if (this.r == false) goto L6;
    L9:
        boolean r2 = true;
    L10:
        this.P = r2;     // Catch: Exception -> L29
        if (r10 != null) goto L13;
        Unit r3 = null;
    L18:
        if (r3 != null) goto L20;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        r4.a(Float.NaN);     // Catch: Exception -> L29
        r4.b(Float.NaN);     // Catch: Exception -> L29
    L20:
        super.showAsDropDown(r10, r11 - ((Number) ZeusTransformUtils.preCheckCast(r1.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), r12 - ((Number) ZeusTransformUtils.preCheckCast(r1.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue(), r14);     // Catch: Exception -> L29
        q();     // Catch: Exception -> L29
        this.K = false;     // Catch: Exception -> L29
        int[] r15 = new int[2];     // Catch: Exception -> L29
        if (this.P == false) goto L23;
        getContentView().getLocationInWindow(r15);     // Catch: Exception -> L29
    L24:
        a(r15[0]);     // Catch: Exception -> L29
        b(r15[1]);     // Catch: Exception -> L29
        this.u = false;     // Catch: Exception -> L29
        if (m() == false) goto L27;
        g();     // Catch: Exception -> L29
        return;
    L27:
        o();     // Catch: Exception -> L29
        return;
    L23:
        getContentView().getLocationOnScreen(r15);     // Catch: Exception -> L29
        goto L24
    L13:
        int[] r6 = new int[2];     // Catch: Exception -> L29
        if (r2 == false) goto L16;
        r10.getLocationInWindow(r6);     // Catch: Exception -> L29
    L17:
        a(r6[0] + (r10.getWidth() / 2.0f));     // Catch: Exception -> L29
        b(r6[1] + (r10.getHeight() / 2.0f));     // Catch: Exception -> L29
        r3 = Unit.INSTANCE;     // Catch: Exception -> L29
        goto L18
    L16:
        r10.getLocationOnScreen(r6);     // Catch: Exception -> L29
        goto L17
    L6:
        if (this.M == true) goto L9;
        r2 = false;
    L29:
        e = move-exception;
        com.obric.oui.c.a.b.a("OPopover", "showAsDropDown, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r19, int r20, int r21, int r22) {
        View r1 = r19;
        Intrinsics.checkNotNullParameter(r1, "anchor");
        View r4 = r19.getRootView();
        com.obric.oui.window.a r5 = com.obric.oui.window.a.f14878a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getActivity(r6), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        boolean r8 = d(r4);
        if (this.S == true) goto L5;
        this.S = r8;
    L5:
        int r9 = f14351a.a(r20);
        p();     // Catch: Exception -> L45
        Pair<Integer, Integer> r10 = a(r21, r22);     // Catch: Exception -> L45
        if (this.r == false) goto L9;
    L12:
        boolean r11 = true;
    L13:
        this.P = r11;     // Catch: Exception -> L45
        int[] r14 = new int[2];     // Catch: Exception -> L45
        if (r11 == false) goto L19;
        r1.getLocationInWindow(r14);     // Catch: Exception -> L45
        if (r8 == false) goto L20;
        if (r7 == null) goto L20;
        int r12 = r14[0];     // Catch: Exception -> L45
        int r15 = r14[1];     // Catch: Exception -> L45
        ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").getDecorView().getLocationOnScreen(r14);     // Catch: Exception -> L45
        int r13 = r14[0];     // Catch: Exception -> L45
        int r17 = r14[1];     // Catch: Exception -> L45
        r4.getLocationOnScreen(r14);     // Catch: Exception -> L45
        r14[0] = (r12 + r14[0]) - r13;     // Catch: Exception -> L45
        r14[1] = (r15 + r14[1]) - r17;     // Catch: Exception -> L45
    L20:
        a(r14[0] + (r19.getWidth() / 2.0f));     // Catch: Exception -> L45
        b(r14[1] + (r19.getHeight() / 2.0f));     // Catch: Exception -> L45
        if (this.M == false) goto L30;
        View r16 = r19.getRootView();     // Catch: Exception -> L45
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
        Intrinsics.checkNotNullExpressionValue(r18, "anchor.context");     // Catch: Exception -> L45
        int r110 = com.obric.oui.common.util.h.a(r18);     // Catch: Exception -> L45
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
        Intrinsics.checkNotNullExpressionValue(r111, "anchor.context");     // Catch: Exception -> L45
        int r23 = com.obric.oui.common.util.h.c(r111);     // Catch: Exception -> L45
        int r112 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L45
        int r113 = com.obric.oui.window.a.f14878a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L45
        if (r16.getWidth() >= r110) goto L25;
        float r114 = (r110 - r16.getWidth()) / 2.0f;     // Catch: Exception -> L45
    L26:
        int r115 = MathKt.roundToInt(r114);     // Catch: Exception -> L45
        if (r16.getHeight() >= r23) goto L29;
        int r24 = ((r23 - r16.getHeight()) + r112) + r113;     // Catch: Exception -> L45
    L31:
        int r2 = (r21 - ((Number) ZeusTransformUtils.preCheckCast(r10.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue()) - r115;     // Catch: Exception -> L45
        int r3 = (r22 - ((Number) ZeusTransformUtils.preCheckCast(r10.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()) - r24;     // Catch: Exception -> L45
        a(r2);     // Catch: Exception -> L45
        b(r3);     // Catch: Exception -> L45
        setElevation(v());     // Catch: Exception -> L45
        if (this.M == true) goto L40;
        if (r7 == null) goto L40;
        if (Intrinsics.areEqual(r19.getWindowToken(), ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").getDecorView().getWindowToken()) == true) goto L39;
        if (r8 == true) goto L39;
        r1 = r19.getRootView();     // Catch: Exception -> L45
        String r25 = "anchor.rootView";
    L38:
        Intrinsics.checkNotNullExpressionValue(r1, r25);     // Catch: Exception -> L45
    L39:
        r1 = ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").getDecorView();     // Catch: Exception -> L45
        r25 = "activity.window.decorView";
    L40:
        super.showAtLocation(r1, r9, r2, r3);     // Catch: Exception -> L45
        q();     // Catch: Exception -> L45
        setElevation(0.0f);     // Catch: Exception -> L45
        getContentView().setElevation(0.0f);     // Catch: Exception -> L45
        this.K = false;     // Catch: Exception -> L45
        this.u = false;     // Catch: Exception -> L45
        if (m() == false) goto L43;
        g();     // Catch: Exception -> L45
        return;
    L43:
        o();     // Catch: Exception -> L45
        return;
    L29:
        r24 = 0;
        goto L31
    L25:
        r114 = 0.0f;
        goto L26
    L30:
        r24 = 0;
        r115 = 0;
        goto L31
    L19:
        r1.getLocationOnScreen(r14);     // Catch: Exception -> L45
        goto L20
    L9:
        if (this.M == true) goto L12;
        r11 = false;
    L45:
        e = move-exception;
        com.obric.oui.c.a.b.a("OPopover", "showAtLocation, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
