package com.bytedance.ai.view.popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.view.popup.anim.AnimController;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.ai.view.popup.viewmodel.AppletPopupViewModel;
import com.bytedance.common.utility.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k2.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¾\u0001¿\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010U\u001a\u0004\u0018\u00010\u00112\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010^\u001a\u00020_H\u0002J\u001c\u0010`\u001a\u0002042\b\u0010a\u001a\u0004\u0018\u00010\u00112\b\u0010b\u001a\u0004\u0018\u000104H\u0002J&\u0010c\u001a\u00020_2\b\b\u0002\u0010d\u001a\u00020*2\b\b\u0002\u0010e\u001a\u00020*2\b\b\u0002\u0010f\u001a\u00020\bH\u0002J\u000e\u0010g\u001a\u00020_2\u0006\u0010h\u001a\u00020\bJ\u000e\u0010i\u001a\u00020_2\u0006\u0010h\u001a\u00020\bJ\u000e\u0010j\u001a\u00020_2\u0006\u0010k\u001a\u00020*J\u000e\u0010l\u001a\u00020_2\u0006\u0010m\u001a\u00020*J\u0010\u0010n\u001a\u00020\u001d2\u0006\u0010o\u001a\u00020pH\u0002J\u001a\u0010q\u001a\u00020_2\u0006\u0010r\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\n\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0010\u0010u\u001a\u00020_2\u0006\u0010v\u001a\u00020-H\u0002J\b\u0010w\u001a\u00020_H\u0002J\u0006\u0010x\u001a\u00020*J\b\u0010y\u001a\u00020\bH\u0002J\u000e\u0010|\u001a\u00020_2\u0006\u0010v\u001a\u00020{J\u0012\u0010}\u001a\u00020_2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010~\u001a\u00020\u007f2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020_2\u0007\u0010\u0081\u0001\u001a\u00020[H\u0016J\u0014\u0010\u0082\u0001\u001a\u00020_2\t\b\u0002\u0010\u0083\u0001\u001a\u00020*H\u0002J\t\u0010\u0084\u0001\u001a\u00020*H\u0002J\t\u0010\u0085\u0001\u001a\u00020_H\u0016J\t\u0010\u0086\u0001\u001a\u00020_H\u0016J\t\u0010\u0087\u0001\u001a\u00020_H\u0016J\t\u0010\u0088\u0001\u001a\u00020_H\u0016J\u0013\u0010\u0089\u0001\u001a\u00020_2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020_H\u0016J\u0012\u0010\u008d\u0001\u001a\u00020_2\u0007\u0010\u008e\u0001\u001a\u00020*H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020_2\u0007\u0010\u0090\u0001\u001a\u00020*H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0011H\u0016J\u0011\u0010\u0092\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0011H\u0016J\t\u0010\u0093\u0001\u001a\u00020_H\u0016J\u0007\u0010\u0094\u0001\u001a\u00020_J\t\u0010\u0095\u0001\u001a\u00020_H\u0016J\t\u0010\u0096\u0001\u001a\u00020*H\u0002J\t\u0010\u0097\u0001\u001a\u00020_H\u0016J\u001b\u0010\u0098\u0001\u001a\u00020_2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u001b\u0010\u009b\u0001\u001a\u00020_2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\t\u0010\u009c\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020_2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009e\u0001\u001a\u00020_2\u0007\u0010\u009f\u0001\u001a\u00020\bH\u0002J\t\u0010 \u0001\u001a\u00020*H\u0002J\t\u0010¡\u0001\u001a\u00020*H\u0002J\t\u0010¢\u0001\u001a\u00020*H\u0002J\u0007\u0010£\u0001\u001a\u00020*J\u001e\u0010¤\u0001\u001a\u00020_2\b\u0010¥\u0001\u001a\u00030¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010pH\u0002J\u001e\u0010¨\u0001\u001a\u00020_2\b\u0010¥\u0001\u001a\u00030¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010pH\u0016J\t\u0010¨\u0001\u001a\u00020_H\u0016J\t\u0010©\u0001\u001a\u00020_H\u0016J\t\u0010ª\u0001\u001a\u00020_H\u0016J\t\u0010«\u0001\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010¬\u0001\u001a\u00020\b2\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0003\u0010®\u0001J\u0007\u0010¯\u0001\u001a\u00020\bJ\u000f\u0010°\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$J\u0011\u0010±\u0001\u001a\u00020_2\u0006\u00105\u001a\u00020*H\u0002J\u0012\u0010²\u0001\u001a\u00020_2\u0007\u0010³\u0001\u001a\u00020*H\u0002J\u0012\u0010´\u0001\u001a\u00020_2\u0007\u0010µ\u0001\u001a\u00020*H\u0016J\u0014\u0010¶\u0001\u001a\u00020_2\t\b\u0001\u0010·\u0001\u001a\u00020\bH\u0002J\t\u0010¸\u0001\u001a\u0004\u0018\u00010pJ\u0019\u0010¹\u0001\u001a\u00020_*\u00030º\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010pH\u0002J\t\u0010»\u0001\u001a\u00020OH\u0002J\u0011\u0010¼\u0001\u001a\u00020_2\b\u0010r\u001a\u0004\u0018\u00010\u0011J\u000f\u0010½\u0001\u001a\u00020_2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0BX\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u000e\u0010D\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bJ\u0010KR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bP\u0010QR\u000e\u0010S\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/bytedance/ai/view/popup/AppletPopup;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ai/view/IAppletView;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "<init>", "()V", "dp100", "", "popupRoot", "Landroid/widget/FrameLayout;", "popupContainer", "Landroid/widget/LinearLayout;", "popupInnerContainer", "Lcom/bytedance/ai/view/popup/RadiusLayout;", "popupTopViewContainer", "popupBg", "Landroid/view/View;", "popupCoordinator", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parameters", "", "Lcom/bytedance/ai/view/popup/api/IAppletParameter;", "animatorParamHandler", "Lcom/bytedance/ai/view/popup/params/AnimationParameter;", "schemaParam", "Lcom/bytedance/ai/view/popup/params/AppletPopupSchemaParam;", "topView", "appletFragment", "Lcom/bytedance/ai/api/model/view/AIFragmentBase;", "getAppletFragment$annotations", "getAppletFragment", "()Lcom/bytedance/ai/api/model/view/AIFragmentBase;", "setAppletFragment", "(Lcom/bytedance/ai/api/model/view/AIFragmentBase;)V", "behavior", "Lcom/bytedance/ai/view/popup/anim/BottomSheetBehavior;", "animController", "Lcom/bytedance/ai/view/popup/anim/AnimController;", "popupContainerHeightPrevious", "lastHeightState", "viewTreeObserverConsumedFlag", "", "lastAvailableHeight", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "peekHeightPrevious", "keyboardVisible", "lastKeyboardHeight", "isDraggablePrevious", "preloadSparkViewOnFirstScreen", "lastInsets", "Landroidx/core/view/WindowInsetsCompat;", "visible", "parentActivityVisible", "lastContentViewBottom", "hasSetAdapativeFlag", "getHasSetAdapativeFlag$ai_sdk_release", "()Z", "setHasSetAdapativeFlag$ai_sdk_release", "(Z)V", "fixPopupAnimLag", "fixPopupHeight", "decorView", "hasDismissed", "margin", "", "[Ljava/lang/Integer;", "imeVisible", "type", "Lcom/bytedance/ai/view/popup/RenderType;", "showMask", "viewModel", "Lcom/bytedance/ai/view/popup/viewmodel/AppletPopupViewModel;", "getViewModel", "()Lcom/bytedance/ai/view/popup/viewmodel/AppletPopupViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "defaultAnimatorProvider", "Lcom/bytedance/ai/view/IPopupAnimator;", "getDefaultAnimatorProvider", "()Lcom/bytedance/ai/view/IPopupAnimator;", "defaultAnimatorProvider$delegate", "addLayoutListener", "layoutListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onApplyWindowInsetsListener", "Landroidx/core/view/OnApplyWindowInsetsListener;", "registerOnApplyWindowInsetsListener", "", "applyWindowInset", "v", "insets", "refreshPopupHeight", "requestLayout", "needRefreshPeekHeight", "loadingHeight", "setBehaviorMinMarginTop", "minMarginTop", "setMinMarginTop", "setDraggable", "isDraggable", "setDisableOutsideClickClose", "disableOutsideClickClose", "obtainFragment", BdpAwemeConstant.KEY_APP_ID, "", "onViewCreated", "view", "getDialogWindow", "Landroid/view/Window;", "registerRootViewGlobalLayoutChangeListerOnce", "listener", "onLayoutChanged", "isImeVisible", "getAvailableHeight", "mLifeCycleListener", "Lcom/bytedance/ai/view/popup/AppletPopup$FragmentLifecycleListener;", "setLifeCycleListener", "onCreate", "onCreateDialog", "Landroid/app/Dialog;", "onSaveInstanceState", "outState", "popupDismiss", "animation", "popSelfBackStackIfTop", "onStart", "onResume", "onPause", "onStop", "onAttach", "context", "Landroid/content/Context;", "onDetach", "onHiddenChanged", "hidden", "setUserVisibleHint", "isVisibleToUser", "onViewAttachedToWindow", "onViewDetachedFromWindow", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "closeWithoutAnimation", "refresh", "useBottomSheetBehaviorLayout", "onDestroy", "onKeyBoardShow", "keyboardHeight", "contentViewBottom", "onKeyBoardHide", "getPopupTopViewHeight", "compatSoftInputMode", "onKeyboardStatusChange", "diffHeight", "needPaddingWhenKeyboardHide", "needPaddingWhenKeyboardShow", "isGravityBottom", "isKeyboardVisible", "showAllowingStateLoss", "manager", "Landroidx/fragment/app/FragmentManager;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "show", "hide", "exitFullScreen", "getSchemaParams", "getCurrentMinMarginTop", "state", "(Ljava/lang/Integer;)I", "getBehaviorState", "getBehavior", "onActivityVisibilityChanged", "checkVisibility", "expected", "onWindowFocusChanged", "hasFocus", "showAppletPage", "containerViewId", "getAppId", "commitNowAllowingStateLossSafely", "Landroidx/fragment/app/FragmentTransaction;", "getPopupAnimator", "setTopView", "init", "FragmentLifecycleListener", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPopup extends AppCompatDialogFragment implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowFocusChangeListener {
    public static final int R = 0;
    public boolean A;
    public int B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public View F;
    public boolean G;
    public Integer[] H;
    public boolean I;
    public final RenderType J;
    public boolean K;
    public final Lazy L;
    public final Lazy M;
    public boolean N;
    public final j O;
    public final k P;
    public b Q;
    public final int d;
    public FrameLayout e;
    public LinearLayout f;
    public RadiusLayout g;
    public FrameLayout h;
    public View i;
    public CoordinatorLayout j;
    public final List<x5.a> k;
    public y5.b l;
    public AppletPopupSchemaParam m;
    public AIFragmentBase n;
    public BottomSheetBehavior<LinearLayout> o;
    public final AnimController p;
    public int q;
    public int r;
    public boolean s;
    public int t;
    public ViewTreeObserver.OnGlobalLayoutListener u;
    public int v;
    public int w;
    public boolean x;
    public WindowInsetsCompat y;
    public boolean z;

    public static final class a {
        public a() {
        }

        public static View a(Window r10) {
            View r11 = r10.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            return r11;
        }

        public static int b(Window r10, View r11, AppletPopup r12) {
            Intrinsics.checkNotNullParameter(r12, "appletPopup");
            if (r10 == null) goto L7;
            WindowManager.LayoutParams r1 = r10.getAttributes();
            if (r1 == null) goto L7;
            int r13 = r1.softInputMode;
        L8:
            boolean r14 = r12.Y90();
            Context r15 = null;
            if ((r13 & 16) == 16) goto L32;
            if (r14 == false) goto L32;
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L29
            if (r10 == null) goto L14;
            View r17 = a(r10);     // Catch: Throwable -> L29
        L16:
            if ((r17 instanceof ViewGroup) == false) goto L18;
            ViewGroup r18 = (ViewGroup) r17;     // Catch: Throwable -> L29
        L19:
            if (r18 == null) goto L24;
            View r19 = r18.getChildAt(0);     // Catch: Throwable -> L29
            if (r19 == null) goto L24;
            int r20 = r19.getMeasuredHeight();     // Catch: Throwable -> L29
        L89:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L33:
            if (r20 != 0) goto L95;
            Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L82
            if (r10 == null) goto L38;
            View r22 = a(r10);     // Catch: Throwable -> L82
            if (r22 == null) goto L38;
        L41:
            if (r22 == null) goto L43;
            r22.getFitsSystemWindows();     // Catch: Throwable -> L82
        L43:
            Rect r23 = new Rect();     // Catch: Throwable -> L82
            if (r22 == null) goto L46;
            r22.getWindowVisibleDisplayFrame(r23);     // Catch: Throwable -> L82
        L46:
            int r24 = r23.bottom - r23.top;
            if (r22 != null) goto L87;
        L53:
            boolean r25 = false;
        L54:
            if (r25 == false) goto L64;
            if (r22 == null) goto L58;
            Context r26 = r22.getContext();     // Catch: Throwable -> L78
            if (r26 == null) goto L58;
        L62:
            if (r26 == null) goto L64;
            r24 = r24 + UIUtils.getStatusBarHeight(r26);     // Catch: Throwable -> L78
        L58:
            AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L78
            g2.b r27 = AppletRuntimeManager.d;     // Catch: Throwable -> L78
            if (r27 == null) goto L61;
            r26 = r27.currentActivity();     // Catch: Throwable -> L78
            goto L62
        L61:
            r26 = null;
        L64:
            int r28 = AppletPopup.R;     // Catch: Throwable -> L78
            boolean r29 = d(r22, r10, r12.getView());     // Catch: Throwable -> L78
            boolean r30 = r12.Y90();     // Catch: Throwable -> L78
            if (r29 == false) goto L80;
            if (r30 == true) goto L80;
            WindowInsetsCompat r31 = r12.y;     // Catch: Throwable -> L78
            if (r31 == null) goto L73;
            Insets r32 = r31.getInsets(WindowInsetsCompat.Type.navigationBars());     // Catch: Throwable -> L78
            if (r32 == null) goto L72;
            int r33 = r32.bottom;     // Catch: Throwable -> L78
        L77:
            r24 = r24 + r33;     // Catch: Throwable -> L78
            goto L80
        L72:
            r33 = 0;
            goto L77
        L73:
            com.bytedance.ai.utils.l r34 = com.bytedance.ai.utils.l.a;     // Catch: Throwable -> L78
            if (r22 == null) goto L76;
            r15 = r22.getContext();     // Catch: Throwable -> L78
        L76:
            r34.getClass();     // Catch: Throwable -> L78
            r33 = com.bytedance.ai.utils.l.a(r15);     // Catch: Throwable -> L78
        L80:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L78
        L86:
            return RangesKt.coerceAtLeast(r24, 0);
        L78:
            th = th;
        L84:
            Result.Companion r35 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L86
        L87:
            if ((r22.getWindowSystemUiVisibility() & 1024) == 0) goto L53;
            r25 = true;
        L38:
            if (r11 == null) goto L40;
            r22 = r11.getRootView();     // Catch: Throwable -> L82
            goto L41
        L40:
            r22 = null;
        L82:
            th = th;
            r24 = 0;
            goto L84
        L95:
            return r20;
        L27:
            Throwable th2 = th;
        L31:
            Result.Companion r36 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        L24:
            r20 = 0;
            goto L89
        L18:
            r18 = null;
            goto L19
        L14:
            r17 = null;
        L29:
            th = move-exception;
            th2 = th;
            r20 = 0;
        L32:
            r20 = 0;
        L7:
            r13 = 0;
            goto L8
        }

        public static int c(Activity r10, AppletPopupSchemaParam r11, AppletPopup r12) {
            int r0 = AppletPopup.R;
            Intrinsics.checkNotNullParameter(r11, "params");
            Intrinsics.checkNotNullParameter(r12, "appletPopup");
            com.bytedance.ai.utils.g.a.d("AppletPopup", "getShowHeight");
            Window r1 = r12.X90();
            if (r1 == null) goto L5;
            a(r1);
        L5:
            Context r13 = null;
            if (r1 == null) goto L8;
            Context r14 = r1.getContext();
        L9:
            int r15 = r11.getRealHeight(r14);
            BottomSheetBehavior<LinearLayout> r16 = r12.o;
            if (r16 == null) goto L12;
            int r17 = r16.D;
        L14:
            if (r17 == 3) goto L16;
        L18:
            int r18 = 0;
            if (r10 == null) goto L26;
            AppletRuntimeManager.INSTANCE.getClass();
            g2.b r19 = AppletRuntimeManager.d;
            if (r19 == null) goto L23;
            Integer r20 = Integer.valueOf(r19.getStatusBarHeight(r10));
        L24:
            if (r20 == null) goto L26;
            int r21 = r20.intValue();
        L27:
            int r22 = b(r1, r12.getView(), r12) - r21;
            int r23 = r12.W90(null);
            if (r23 <= 0) goto L30;
            r18 = r23;
        L30:
            int r24 = (r15 - AppletPopup.R) - r18;
            int r25 = r12.w;
            if (r24 <= r25) goto L34;
            r22 = r15 - r25;
        L36:
            if (r15 <= 0) goto L42;
            if (r1 == null) goto L42;
            if (r18 <= 0) goto L40;
            int r26 = RangesKt.coerceAtMost(r15, r22 - r18);
        L51:
            return r26;
        L40:
            r26 = RangesKt.coerceAtMost(r15, r22);
        L42:
            if (r15 != 0) goto L50;
            if (r1 == null) goto L46;
            r13 = r1.getContext();
        L46:
            if (Intrinsics.areEqual(r11.getRealGravity(r13), "center") == false) goto L52;
            if (r1 == null) goto L53;
            int r27 = com.bytedance.ai.utils.o.a;
            return com.bytedance.ai.utils.o.b(r1.getContext(), 400.0d);
        L53:
            return -1;
        L52:
            return -1;
        L50:
            return r15;
        L34:
            if ((r15 + r25) < r22) goto L36;
            r22 = r22 - r25;
            goto L36
        L23:
            r20 = null;
        L26:
            r21 = 0;
            goto L27
        L16:
            if (r11.getDragHeight() <= 0) goto L18;
            r15 = r11.getDragHeight();
            goto L18
        L12:
            r17 = -1;
            goto L14
        L8:
            r14 = null;
            goto L9
        }

        public static boolean d(View r10, Window r11, View r12) {
            if (r10 != null) goto L5;
            return false;
        L5:
            if (r11 == null) goto L9;
            WindowManager.LayoutParams r13 = r11.getAttributes();
            if (r13 == null) goto L9;
            int r14 = r13.flags;
        L11:
            if ((r10.getWindowSystemUiVisibility() & 512) != 0) goto L13;
        L15:
            boolean r15 = false;
        L16:
            if (r15 == true) goto L18;
        L20:
            boolean r16 = false;
        L21:
            View r17 = null;
            if (r12 == null) goto L24;
            ViewParent r18 = r12.getParent();
        L26:
            if ((r18 instanceof View) == false) goto L28;
            r17 = (View) r18;
        L28:
            if (r17 == null) goto L30;
            int r19 = r17.getPaddingBottom();
        L31:
            if (r19 != 0) goto L33;
            boolean r20 = true;
        L34:
            if (r16 == false) goto L38;
            if (r20 == false) goto L39;
            return true;
        L39:
            return false;
        L38:
            return false;
        L33:
            r20 = false;
            goto L34
        L30:
            r19 = 0;
            goto L31
        L24:
            r18 = null;
            goto L26
        L18:
            if ((Integer.MIN_VALUE & r14) == 0) goto L20;
            r16 = true;
            goto L21
        L13:
            if ((134217728 & r14) != 0) goto L15;
            r15 = true;
        L9:
            r14 = 0;
            goto L11
        }
    }

    public interface b {
        void a(AppletPopup r1);
    }

    public static final class c extends v5.a {
        public c() {
        }

        @Override // v5.a
        public final void a(ViewPropertyAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animator");
            r10.setInterpolator(new LinearInterpolator());
            r10.setDuration(300);
        }

        @Override // v5.a
        public final void b(ViewPropertyAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animator");
            r10.setInterpolator(new LinearInterpolator());
            r10.setDuration(300);
        }
    }

    public static final class d extends BottomSheetBehavior.b {
        public float a;
        public boolean b;
        public final /* synthetic */ AppletPopup c;

        public d(AppletPopup r1) {
            this.c = r1;
            this.a = 1.0f;
        }

        @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
        public final void a(View r10, float r11) {
            Intrinsics.checkNotNullParameter(r10, "bottomSheet");
            AppletPopup r12 = this.c;
            boolean r1 = true;
            if (r12.K == false) goto L29;
            AppletPopupSchemaParam r13 = r12.m;
            View r14 = null;
            if (r13 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r13 = null;
        L8:
            if (r13.getShowMask() == true) goto L29;
            AppletPopupSchemaParam r15 = this.c.m;
            if (r15 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r15 = null;
        L13:
            if (r15.getDragByGesture() == false) goto L29;
            AppletPopupSchemaParam r16 = this.c.m;
            if (r16 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r16 = null;
        L17:
            r16.setShowMask(true);
            AppletPopupSchemaParam r17 = this.c.m;
            if (r17 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r17 = null;
        L20:
            View r0 = this.c.i;
            if (r0 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        L24:
            Intrinsics.checkNotNullParameter(r17, "params");
            Intrinsics.checkNotNullParameter(r14, "view");
            if (r17.getShowMask() == false) goto L27;
            r14.setVisibility(0);
            r14.setAlpha(1.0f);
            goto L29
        L27:
            r14.setVisibility(0);
            r14.setAlpha(0.0f);
            goto L29
        L23:
            r14 = r0;
        L29:
            if (this.a >= r11) goto L32;
            r1 = false;
        L32:
            this.b = r1;
            this.a = r11;
        }

        @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
        public final void b(View r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "bottomSheet");
            BottomSheetBehavior<LinearLayout> r13 = this.c.o;
            View r1 = null;
            AppletPopupSchemaParam r10 = null;
            View r14 = null;
            if (r13 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r13 = null;
        L6:
            if (r13.D == 2) goto L8;
        L27:
            BottomSheetBehavior<LinearLayout> r15 = this.c.o;
            if (r15 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r15 = null;
        L31:
            if (r15.B != 3) goto L33;
            if (r12 == 3) goto L33;
        L39:
            AppletPopup.ea0(this.c, false, false, 6);
            AppletPopup r16 = this.c;
            if (r16.K == false) goto L77;
            if (r12 != 3) goto L62;
            AppletPopupSchemaParam r17 = r16.m;
            if (r17 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r17 = null;
        L47:
            if (r17.getDragByGesture() == false) goto L62;
            AppletPopupSchemaParam r18 = this.c.m;
            if (r18 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r18 = null;
        L51:
            r18.setShowMask(false);
            AppletPopupSchemaParam r19 = this.c.m;
            if (r19 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r19 = null;
        L54:
            View r20 = this.c.i;
            if (r20 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        L58:
            Intrinsics.checkNotNullParameter(r19, "params");
            Intrinsics.checkNotNullParameter(r14, "view");
            if (r19.getShowMask() == false) goto L61;
            r14.setVisibility(0);
            r14.setAlpha(1.0f);
            goto L77
        L61:
            r14.setVisibility(0);
            r14.setAlpha(0.0f);
            goto L77
        L57:
            r14 = r20;
        L62:
            AppletPopupSchemaParam r110 = this.c.m;
            if (r110 != null) goto L65;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r110 = null;
        L65:
            r110.setShowMask(true);
            AppletPopupSchemaParam r111 = this.c.m;
            if (r111 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r111 = null;
        L68:
            View r21 = this.c.i;
            if (r21 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        L72:
            Intrinsics.checkNotNullParameter(r111, "params");
            Intrinsics.checkNotNullParameter(r1, "view");
            if (r111.getShowMask() == false) goto L75;
            r1.setVisibility(0);
            r1.setAlpha(1.0f);
            goto L77
        L75:
            r1.setVisibility(0);
            r1.setAlpha(0.0f);
            goto L77
        L71:
            r1 = r21;
        L77:
            if (r12 != 5) goto L80;
            this.c.da0(false);
            return;
        L80:
            return;
        L33:
            BottomSheetBehavior<LinearLayout> r112 = this.c.o;
            if (r112 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r112 = null;
        L37:
            if (r112.B == 3) goto L77;
            if (r12 != 3) goto L77;
        L8:
            if (this.b == false) goto L27;
            com.bytedance.ai.utils.g.a.i("AppletPopup", "不再消费滚动事件");
            BottomSheetBehavior<LinearLayout> r113 = this.c.o;
            if (r113 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r113 = null;
        L12:
            com.bytedance.ai.view.popup.anim.a r114 = r113.E;
            r114.b();
            if (r114.a != 2) goto L15;
            r114.p.getCurrX();
            r114.p.getCurrY();
            r114.p.abortAnimation();
            r114.p.getCurrX();
            ((BottomSheetBehavior.a) r114.q).a.dispatchOnSlide(r114.p.getCurrY());
        L15:
            r114.p(0);
            AppletPopupSchemaParam r115 = this.c.m;
            if (r115 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r115 = null;
        L19:
            if (Intrinsics.areEqual(r115.getTransitionAnimationOut(), AnimationStyle.ZOOM.getValue()) == true) goto L25;
            AppletPopupSchemaParam r116 = this.c.m;
            if (r116 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        L24:
            r10.setTransitionAnimationOut(AnimationStyle.SLIDE.getValue());
            goto L25
        L23:
            r10 = r116;
        L25:
            this.c.da0(true);
        }
    }

    static {
        new a();
        R = com.bytedance.ai.utils.o.a(20.0f);
    }

    public final boolean Y90() {
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        WindowInsetsCompat r0 = this.y;
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.isVisible(WindowInsetsCompat.Type.ime());
    L10:
        return this.I;
    }

    public final void ba0() {
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        return;
    L5:
        if (this.z == true) goto L7;
        return;
    L7:
        Window r0 = X90();
        AppletPopupSchemaParam r1 = null;
        if (r0 == null) goto L10;
        View r10 = S90(r0);
    L11:
        if (r10 == null) goto L64;
        Rect r11 = new Rect();
        r10.getWindowVisibleDisplayFrame(r11);
        int r12 = r10.getRootView().getHeight();
        int r13 = r12 - r11.bottom;
        boolean r14 = a.d(r10, X90(), getView());
        WindowInsetsCompat r15 = this.y;
        if (r15 != null) goto L15;
    L17:
        boolean r16 = false;
    L18:
        if (r16 == false) goto L25;
        if (r14 == true) goto L25;
        WindowInsetsCompat r17 = this.y;
        if (r17 == null) goto L25;
        Insets r18 = r17.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r18 == null) goto L25;
        int r19 = r18.bottom;
    L27:
        if (r13 <= (((double) r12) * 0.25d)) goto L46;
        if (this.I == false) goto L31;
        return;
    L31:
        this.I = true;
        int r20 = this.B;
        if (r20 != (-1)) goto L35;
        this.B = r13;
        return;
    L35:
        if (r20 != r13) goto L37;
        return;
    L37:
        AppletPopupSchemaParam r21 = this.m;
        if (r21 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L42:
        if (r1.getIgnoreKeyboardStatusChange() == false) goto L44;
        return;
    L44:
        this.B = r13;
        aa0(r13 - r19, r13);
        return;
    L40:
        r1 = r21;
        goto L42
    L46:
        if (this.I == true) goto L48;
        return;
    L48:
        this.I = false;
        int r22 = this.B;
        if (r22 != (-1)) goto L52;
        this.B = r19;
        return;
    L52:
        if (r22 != r19) goto L54;
        return;
    L54:
        AppletPopupSchemaParam r23 = this.m;
        if (r23 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L59:
        if (r1.getIgnoreKeyboardStatusChange() == false) goto L61;
        return;
    L61:
        int r24 = r19 - this.B;
        this.B = r19;
        Z90(r24, r19);
        return;
    L57:
        r1 = r23;
    L25:
        r19 = 0;
        goto L27
    L15:
        if (r15.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L17;
        r16 = true;
        goto L18
    L64:
        return;
    L10:
        r10 = null;
        goto L11
    }

    public final boolean ha0() {
        AppletPopupSchemaParam r0 = this.m;
        AppletPopupSchemaParam r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r0 = null;
    L6:
        if (r0.getEnablePullDownClose() == true) goto L20;
        AppletPopupSchemaParam r10 = this.m;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r10 = null;
    L11:
        if (r10.getDragByGesture() == true) goto L20;
        AppletPopupSchemaParam r11 = this.m;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L17:
        if (Intrinsics.areEqual(r1.getRealGravity(getContext()), "bottom") == true) goto L20;
        return false;
    L15:
        r1 = r11;
    L20:
        return true;
    }

    public final void onDestroy() {
        List<m> r0 = n.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        Iterator r1 = ((ArrayList) n.b).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        AppletPopup r10 = (AppletPopup) ((WeakReference) r1.next()).get();
        if (r10 == null) goto L9;
        if (Intrinsics.areEqual(r10, this) == false) goto L4;
    L9:
        r1.remove();
        goto L4
    L10:
        Iterator r11 = CollectionsKt.toList(n.a).iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        ((m) r11.next()).b(this);
        goto L12
    L14:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        View r12 = getView();
        boolean r13 = false;
        if (r12 == null) goto L21;
        ViewTreeObserver r14 = r12.getViewTreeObserver();
        if (r14 == null) goto L21;
        if (r14.isAlive() != true) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L28;
        View r16 = getView();
        if (r16 == null) goto L28;
        ViewTreeObserver r17 = r16.getViewTreeObserver();
        if (r17 == null) goto L28;
        r17.removeOnWindowFocusChangeListener(this);
    L28:
        View r18 = this.F;
        if (r18 == null) goto L40;
        Map<Integer, List<OnApplyWindowInsetsListener>> r19 = q.a;
        k r20 = this.P;
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r20, "listener");
        int r21 = r18.hashCode();
        Map<Integer, List<OnApplyWindowInsetsListener>> r22 = q.a;
        LinkedHashMap r23 = (LinkedHashMap) r22;
        List r24 = (List) r23.get(Integer.valueOf(r21));
        if (r24 == null) goto L33;
        r24.remove(r20);
    L33:
        List r25 = (List) r23.get(Integer.valueOf(r21));
        if (r25 != null) goto L36;
    L38:
        if (r13 == false) goto L40;
        r22.remove(Integer.valueOf(r21));
        goto L40
    L36:
        if (r25.isEmpty() != true) goto L38;
        r13 = true;
    L40:
        this.F = null;
        return;
    L21:
        r15 = false;
        goto L22
    }

    public final void onPause() {
        List<m> r0 = n.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        Iterator r1 = CollectionsKt.toList(n.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((m) r1.next()).e(this);
        goto L4
    L6:
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onStop() {
        List<m> r0 = n.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        Iterator r1 = CollectionsKt.toList(n.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((m) r1.next()).a(this);
        goto L4
    L6:
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.ai.view.popup.j] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.ai.view.popup.k] */
    public AppletPopup() {
        this.d = com.bytedance.ai.utils.o.a(100.0f);
        this.k = new ArrayList();
        this.p = new AnimController();
        this.r = -1;
        this.B = -1;
        this.D = true;
        this.E = true;
        this.H = new Integer[0];
        this.J = RenderType.WEB;
        final Function0<Fragment> r0 = new AppletPopup$special$$inlined$viewModels$default$1(this);
        this.L = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AppletPopupViewModel.class), new AppletPopup$special$$inlined$viewModels$default$2(r0), null);
        this.M = LazyKt.lazy(new i());
        this.O = new j(this);
        this.P = new k(this);
    }

    public final Window X90() {
        Dialog r0 = getDialog();
        Window r1 = null;
        if (r0 == null) goto L6;
        Window r10 = r0.getWindow();
        if (r10 == null) goto L6;
    L15:
        if (r10 != null) goto L23;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r11 = AppletRuntimeManager.d;
        if (r11 == null) goto L22;
        Activity r12 = r11.currentActivity();
        if (r12 == null) goto L22;
        r1 = r12.getWindow();
    L22:
        return r1;
    L23:
        return r10;
    L6:
        DialogFragment r13 = getParentFragment();
        if ((r13 instanceof DialogFragment) == false) goto L9;
        DialogFragment r14 = r13;
    L10:
        if (r14 == null) goto L14;
        Dialog r15 = r14.getDialog();
        if (r15 == null) goto L14;
        r10 = r15.getWindow();
    L14:
        r10 = null;
        goto L15
    L9:
        r14 = null;
        goto L10
    }

    public final boolean ca0() {
        FragmentManager r0 = getFragmentManager();
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r10 = getTag();
        if (r10 != null) goto L24;
        return false;
    L24:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        int r12 = r0.getBackStackEntryCount();     // Catch: Throwable -> L17
        if (r12 > 0) goto L12;
    L15:
        Object r13 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L17
    L19:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r13) == false) goto L23;
        r13 = r14;
    L23:
        return ((Boolean) r13).booleanValue();
    L12:
        if (Intrinsics.areEqual(r0.getBackStackEntryAt(r12 - 1).getName(), r10) == false) goto L15;
        r1 = r0.popBackStackImmediate(r10, 1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        U90(false);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.A = true;
        U90(true);
        if (this.r != (-1)) goto L11;
        BottomSheetBehavior<LinearLayout> r0 = this.o;
        if (r0 == null) goto L9;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r0 = null;
    L8:
        int r1 = r0.D;
    L10:
        this.r = r1;
        goto L11
    L9:
        r1 = 3;
    L11:
        List<m> r10 = n.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        Iterator r11 = CollectionsKt.toList(n.a).iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        ((m) r11.next()).f(this);
        goto L13
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        List<m> r0 = n.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        Iterator r1 = CollectionsKt.toList(n.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((m) r1.next()).d(this);
        goto L4
    }

    public static View S90(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public final void U90(boolean r10) {
        if (r10 != this.z) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r10 == false) goto L8;
    L16:
        if (r10 == true) goto L18;
    L28:
        boolean r11 = this.A;
        boolean r12 = super/*androidx.fragment.app.Fragment*/.isVisible();
        boolean r13 = getUserVisibleHint();
        View r14 = getView();
        if (r14 == null) goto L31;
        boolean r15 = r14.hasWindowFocus();
    L32:
        if (r11 == false) goto L38;
        if (r12 == false) goto L38;
        if (r13 == false) goto L38;
        if (r15 == false) goto L38;
        r0 = true;
    L38:
        if (r0 == this.z) goto L47;
        this.z = r0;
        Window r16 = X90();
        if (r16 == null) goto L48;
        View r17 = S90(r16);
        if (r17 == null) goto L49;
        WindowInsetsCompat r1 = this.y;
        if (r1 == null) goto L50;
        T90(r17, r1);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L31:
        r15 = false;
        goto L32
    L18:
        if (this.N == true) goto L28;
        if (this.u == null) goto L28;
        this.N = true;
        Window r18 = X90();
        if (r18 == null) goto L28;
        View r19 = S90(r18);
        if (r19 == null) goto L28;
        ViewTreeObserver r20 = r19.getViewTreeObserver();
        if (r20 == null) goto L28;
        r20.addOnGlobalLayoutListener(this.O);
        goto L28
    L8:
        if (this.N == false) goto L16;
        this.N = false;
        Window r21 = X90();
        if (r21 == null) goto L28;
        View r22 = S90(r21);
        if (r22 == null) goto L28;
        ViewTreeObserver r23 = r22.getViewTreeObserver();
        if (r23 == null) goto L28;
        r23.removeOnGlobalLayoutListener(this.O);
        goto L28
    }

    public final void V90(int r11) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.d("AppletPopup", "contentViewBottom: " + r11);
        Window r1 = X90();
        AppletPopupSchemaParam r10 = null;
        if (r1 == null) goto L5;
        View r12 = S90(r1);
    L6:
        View r13 = getView();
        if (r13 == null) goto L9;
        Object r14 = r13.getParent();
    L11:
        if ((r14 instanceof View) == false) goto L13;
        View r15 = (View) r14;
    L14:
        boolean r16 = false;
        if (r15 == null) goto L17;
        int r17 = r15.getPaddingBottom();
    L19:
        if ((r12 instanceof ViewGroup) == false) goto L21;
        ViewGroup r18 = (ViewGroup) r12;
    L22:
        if (r18 == null) goto L26;
        View r19 = r18.getChildAt(0);
        if (r19 == null) goto L26;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L28:
        if ((r20 instanceof FrameLayout.LayoutParams) == false) goto L30;
        FrameLayout.LayoutParams r21 = (FrameLayout.LayoutParams) r20;
    L31:
        if (r21 == null) goto L33;
        int r22 = r21.bottomMargin;
    L34:
        int r110 = (r11 - r17) - r22;
        if (r12 != null) goto L37;
    L62:
        AppletPopupSchemaParam r111 = this.m;
        if (r111 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r111 = null;
    L66:
        if (r111.getSelfAdaptiveHeight() == true) goto L73;
        AppletPopupSchemaParam r112 = this.m;
        if (r112 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L71:
        ea0(this, !r10.getBounceWithKeyboard(), true, 4);
        return;
    L70:
        r10 = r112;
        goto L71
    L73:
        return;
    L37:
        if ((r12.getWindowSystemUiVisibility() & 1024) == 0) goto L39;
        boolean r23 = true;
    L40:
        if (r23 == true) goto L42;
    L44:
        boolean r24 = false;
    L45:
        if (r23 == true) goto L47;
    L59:
        if (r24 == true) goto L61;
        if (r16 == false) goto L62;
    L61:
        r12.setPadding(r12.getPaddingLeft(), r12.getPaddingTop(), r12.getPaddingRight(), r110);
        r0.d("AppletPopup", "updatePadding: " + r110);
        r12.requestLayout();
        goto L62
    L47:
        if (this.J != RenderType.LYNX) goto L59;
        AppletPopupSchemaParam r25 = this.m;
        if (r25 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r25 = null;
    L52:
        if (r25.getKeyboardAdjust() != 2) goto L59;
        AppletPopupSchemaParam r26 = this.m;
        if (r26 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r26 = null;
    L57:
        if (r26.getKeyboardCompat() == false) goto L59;
        r16 = true;
        goto L59
    L42:
        if (this.J != RenderType.WEB) goto L44;
        r24 = true;
        goto L45
    L39:
        r23 = false;
        goto L40
    L33:
        r22 = 0;
        goto L34
    L30:
        r21 = null;
    L26:
        r20 = null;
        goto L28
    L21:
        r18 = null;
        goto L22
    L17:
        r17 = 0;
        goto L19
    L13:
        r15 = null;
        goto L14
    L9:
        r14 = null;
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    public final int W90(Integer r10) {
        if (r10 == null) goto L4;
        int r11 = r10.intValue();
    L8:
        AppletPopupSchemaParam r1 = null;
        if (r11 != 3) goto L20;
        AppletPopupSchemaParam r12 = this.m;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r12 = null;
    L14:
        if (r12.getDragMinMarginTop() <= 0) goto L20;
        AppletPopupSchemaParam r13 = this.m;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L26:
        return r1.getDragMinMarginTop();
    L18:
        r1 = r13;
    L20:
        AppletPopupSchemaParam r14 = this.m;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L25:
        return r1.getMinMarginTop();
    L23:
        r1 = r14;
        goto L25
    L4:
        BottomSheetBehavior<LinearLayout> r15 = this.o;
        if (r15 == null) goto L7;
        r11 = r15.D;
        goto L8
    L7:
        r11 = -1;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.view.popup.a] */
    public final void da0(boolean r17) {
        if (this.G == false) goto L6;
        return;
    L6:
        if (getFragmentManager() == null) goto L99;
        if (r17 == false) goto L101;
        y5.b r0 = this.l;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("animatorParamHandler");
        r0 = null;
    L11:
        v5.a r10 = (v5.a) this.M.getValue();
        ?? r11 = new com.bytedance.ai.view.popup.a(this);
        boolean r12 = false;
        if (r0.c.b == AnimController.AnimProcessType.NONE) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L99;
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        String r15 = r0.a(false);
        r14.element = r15;
        if (Intrinsics.areEqual(r15, AnimationStyle.ZOOM.getValue()) == false) goto L50;
        PathInterpolator r16 = w5.d.a;
        View r18 = r0.b;
        String r19 = r0.a.getFloatingPageName();
        AnimController r110 = r0.c;
        Intrinsics.checkNotNullParameter(r18, "transitionView");
        Intrinsics.checkNotNullParameter(r19, "floatingPageName");
        Intrinsics.checkNotNullParameter(r110, "animController");
        i2.j r111 = i2.i.a;
        s r112 = i2.i.a.a().j();
        if (r112 == null) goto L24;
        PageInfo r113 = r112.getPageInfo();
        if (r113 == null) goto L24;
        String r114 = r113.getPageName();
    L26:
        if (i2.i.a.a().h() == true) goto L28;
    L31:
        boolean r115 = true;
    L32:
        if (r115 == false) goto L47;
        Rect r116 = i2.i.a.a().b();
        if (r116 == null) goto L47;
        com.bytedance.ai.view.popup.anim.c r117 = new com.bytedance.ai.view.popup.anim.c(r18, r110, r11);
        com.bytedance.ai.utils.g r118 = com.bytedance.ai.utils.g.a;
        r118.i("AppletPopup", "zoomOut: zoomOut with Animation first");
        r118.i("AppletPopup", "zoomOutAnimation " + r116.flattenToString());
        Rect r119 = new Rect();
        r18.getGlobalVisibleRect(r119);
        r18.setPivotX(0.0f);
        r18.setPivotY(0.0f);
        float r120 = r116.width() / r119.width();
        float r20 = r116.height() / r18.getHeight();
        float r21 = r116.left - r119.left;
        r18.animate().alpha(0.0f).scaleX(r120).scaleY(r20).translationX(r21).translationY(r116.top - r119.top).setInterpolator(w5.d.a).setDuration(300).setListener(r117).start();
        View r22 = r18.getRootView();
        if (r22 == null) goto L46;
        ViewPropertyAnimator r23 = r22.animate();
        if (r23 == null) goto L46;
        ViewPropertyAnimator r24 = r23.alpha(0.0f);
        if (r24 == null) goto L46;
        ViewPropertyAnimator r25 = r24.setDuration(300);
        if (r25 == null) goto L46;
        r25.start();
    L46:
        r118.i("AppletPopup", "zoomOut: show floating widget after 200 ms");
        p2.c.e(new w5.c(), 200);
        r12 = true;
    L47:
        if (r12 == true) goto L99;
        r14.element = AnimationStyle.SLIDE.getValue();
        goto L50
    L28:
        if (Intrinsics.areEqual(r114, r19) == true) goto L31;
        r115 = false;
    L24:
        r114 = null;
    L50:
        y5.a r26 = new y5.a(r0, r14, r11);
        String r27 = (String) r14.element;
        if (Intrinsics.areEqual(r27, AnimationStyle.SLIDE.getValue()) == false) goto L54;
        Intrinsics.checkNotNull(r0.b.animate().translationY(r0.b.getHeight()).setDuration(r0.a.getResizeDurationInMillSeconds()).setListener(r26));
    L82:
        if (r10 == null) goto L84;
        r10.a(r0.b.animate());
    L84:
        r0.b.animate().start();
        goto L99
    L54:
        if (Intrinsics.areEqual(r27, AnimationStyle.LEFT.getValue()) == false) goto L65;
        DisplayMetrics r28 = new DisplayMetrics();
        if ((r0.b.getContext() instanceof Activity) == false) goto L58;
        Context r29 = r0.b.getContext();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r30 = ((Activity) r29).getWindowManager();
    L59:
        if (r30 == null) goto L63;
        Display r31 = r30.getDefaultDisplay();
        if (r31 == null) goto L63;
        r31.getMetrics(r28);
    L63:
        Intrinsics.checkNotNull(r0.b.animate().translationX(-r28.widthPixels).setDuration(r0.a.getResizeDurationInMillSeconds()).setListener(r26));
        goto L82
    L58:
        Object r32 = r0.b.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type android.view.WindowManager");
        r30 = (WindowManager) r32;
        goto L59
    L65:
        if (Intrinsics.areEqual(r27, AnimationStyle.RIGHT.getValue()) == false) goto L76;
        DisplayMetrics r33 = new DisplayMetrics();
        if ((r0.b.getContext() instanceof Activity) == false) goto L69;
        Context r34 = r0.b.getContext();
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r35 = ((Activity) r34).getWindowManager();
    L70:
        if (r35 == null) goto L74;
        Display r36 = r35.getDefaultDisplay();
        if (r36 == null) goto L74;
        r36.getMetrics(r33);
    L74:
        Intrinsics.checkNotNull(r0.b.animate().translationX(r33.widthPixels).setDuration(r0.a.getResizeDurationInMillSeconds()).setListener(r26));
        goto L82
    L69:
        Object r37 = r0.b.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type android.view.WindowManager");
        r35 = (WindowManager) r37;
        goto L70
    L76:
        if (Intrinsics.areEqual(r27, AnimationStyle.AUTO.getValue()) == false) goto L79;
        View r38 = r0.b;
        r38.setAlpha(1.0f);
        Intrinsics.checkNotNull(r38.animate().alpha(0.0f).setDuration(r0.a.getResizeDurationInMillSeconds()).setListener(r26));
        goto L82
    L79:
        if (Intrinsics.areEqual(r27, AnimationStyle.NONE.getValue()) == false) goto L81;
        r11.invoke();
        r0.c.a(AnimController.AnimProcessType.DONE, false, null);
        goto L82
    L81:
        r11.invoke();
        r0.c.a(AnimController.AnimProcessType.DONE, false, null);
        goto L82
    L14:
        r13 = false;
        goto L15
    L101:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L96
        if (ca0() == false) goto L103;
    L94:
        Object r39 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L96
    L98:
        Result.box-impl(r39);
        goto L99
    L103:
        dismissAllowingStateLoss();     // Catch: Exception -> L89 Throwable -> L96
    L89:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L96
        Throwable r40 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L96
        if (r40 == null) goto L94;
        com.bytedance.crash.d.d(r40, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
    L99:
        this.G = true;
    }

    public final void fa0(boolean r10) {
        BottomSheetBehavior<LinearLayout> r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        AppletPopupSchemaParam r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r0 = null;
    L8:
        r0.s = r10;
        AppletPopupSchemaParam r11 = this.m;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L12:
        r1.setDragByGesture(r10);
        return;
    L11:
        r1 = r11;
        goto L12
    }

    public final void ga0(int r10) {
        Fragment r1 = getChildFragmentManager().findFragmentById(r10);
        AIFragmentBase r11 = null;
        if ((r1 instanceof AIFragmentBase) == false) goto L5;
        AIFragmentBase r12 = (AIFragmentBase) r1;
    L6:
        if (r12 == null) goto L32;
        this.n = r12;
        return;
    L32:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L26
        Bundle r14 = getArguments();     // Catch: Throwable -> L26
        if (r14 == null) goto L13;
        String r15 = r14.getString(BdpAwemeConstant.KEY_APP_ID);     // Catch: Throwable -> L26
        if (r15 == null) goto L13;
    L14:
        FragmentTransaction r16 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L26
        AIFragmentBase r17 = this.n;     // Catch: Throwable -> L26
        if (r17 != null) goto L20;
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L26
        g2.b r18 = AppletRuntimeManager.d;     // Catch: Throwable -> L26
        if (r18 == null) goto L19;
        r11 = r18.g(r15);     // Catch: Throwable -> L26
    L19:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L26
        r17 = r11;
    L20:
        this.n = r17;     // Catch: Throwable -> L26
        r17.setArguments(getArguments());     // Catch: Throwable -> L26
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L26
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP, r10) == true) goto L24;
        r16 = r16.add(r10, r17, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);     // Catch: Throwable -> L26
    L24:
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L26
        p2.c.d(new f(com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP, r16));     // Catch: Throwable -> L26
        Object r20 = Result.constructor-impl(r16);     // Catch: Throwable -> L26
    L28:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L34;
        com.bytedance.ai.utils.g.a.e("AppletPopup", "showAppletPage", r21);
        return;
    L34:
        return;
    L13:
        r15 = "";
    L26:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L5:
        r12 = null;
        goto L6
    }

    public final void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r10);
        U90(true);
    }

    public final void onCreate(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r10);
        if (r10 == null) goto L8;
        Bundle r0 = new Bundle();
        r0.putAll(r10);
        setArguments(r0);
        Serializable r11 = r10.getSerializable("popupSchema");
        if (r11 == null) goto L8;
        this.m = (AppletPopupSchemaParam) r11;
    L8:
        if (this.Q != null) goto L10;
        this.Q = ((AppletPopupViewModel) this.L.getValue()).getMLifeCycleListener();
    L11:
        b r12 = this.Q;
        if (r12 == null) goto L14;
        r12.a(this);
    L14:
        List<m> r13 = n.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        List<WeakReference<AppletPopup>> r14 = n.b;
        ArrayList r15 = (ArrayList) r14;
        r15.add(new WeakReference(this));
        Iterator r16 = CollectionsKt.toList(n.a).iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        ((m) r16.next()).c(this);
        goto L16
    L18:
        return;
    L10:
        AppletPopupViewModel r17 = (AppletPopupViewModel) this.L.getValue();
        b r1 = this.Q;
        Intrinsics.checkNotNull(r1);
        r17.setLifeCycleListener(r1);
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.bytedance.ai.view.popup.AppletPopUpDialog, com.bytedance.ai.view.popup.AppletPopup$onCreateDialog$1] */
    public final Dialog onCreateDialog(Bundle r10) {
        final Context r11 = requireContext();
        ?? r0 = new AnonymousClass1(this, r11);
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L5;
        r0.setOwnerActivity(r12);
    L5:
        AppletPopupSchemaParam r13 = this.m;
        if (r13 != null) goto L9;
        r13 = null;
    L9:
        r0.a = r13;
        return r0;
    }

    public final void onHiddenChanged(boolean r1) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(r1);
        U90(!r1);
    }

    public final void onSaveInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r10);
        r10.putAll(getArguments());
        AppletPopupSchemaParam r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r0 = null;
    L5:
        r10.putSerializable("popupSchema", r0);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        U90(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        r10.removeOnAttachStateChangeListener(this);
        U90(false);
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean r1) {
        U90(r1);
    }

    public final void setUserVisibleHint(boolean r1) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r1);
        U90(r1);
    }

    public final WindowInsetsCompat T90(View r10, WindowInsetsCompat r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L7;
        WindowInsetsCompat r0 = ViewCompat.onApplyWindowInsets(r10, r11);
        boolean r1 = Y90();
        boolean r12 = a.d(r10, X90(), getView());
        if (r11.isVisible(WindowInsetsCompat.Type.navigationBars()) == false) goto L12;
        if (r12 == true) goto L12;
        int r13 = r11.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L13:
        if (r1 == false) goto L15;
        r13 = r11.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L15:
        int r14 = this.B;
        if (r14 != (-1)) goto L19;
        this.B = r13;
        return r0;
    L19:
        if (r14 != r13) goto L21;
        return r0;
    L21:
        AppletPopupSchemaParam r15 = this.m;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r15 = null;
    L25:
        if (r15.getIgnoreKeyboardStatusChange() == false) goto L28;
        return r0;
    L28:
        if (this.z == true) goto L30;
        return r0;
    L30:
        int r16 = this.B;
        int r17 = r13 - r16;
        int r18 = this.d;
        if (r17 <= r18) goto L35;
        aa0(r17, r13);
        this.B = r13;
        return r0;
    L35:
        if ((r16 - r13) <= r18) goto L37;
        Z90(r17, r13);
        this.B = r13;
    L37:
        return r0;
    L12:
        r13 = 0;
        goto L13
    L7:
        return WindowInsetsCompat.CONSUMED;
    L4:
        return WindowInsetsCompat.CONSUMED;
    }

    public final void Z90(int r10, int r11) {
        int r12 = -Math.abs(r10);
        if (r12 <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L9;
        r12 = 0;
    L9:
        Context r14 = getContext();
        if (r14 == null) goto L12;
        com.bytedance.ai.utils.o.d(r12, r14);
    L12:
        this.w = 0;
        if (getActivity() == null) goto L78;
        View r15 = getView();
        AppletPopupSchemaParam r16 = null;
        if (r15 == null) goto L62;
        AppletPopupSchemaParam r17 = this.m;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r17 = null;
    L20:
        if (r17.getSelfAdaptiveHeight() == true) goto L62;
        LinearLayout r18 = this.f;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r18 = null;
    L25:
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        X90();
        FragmentActivity r20 = getActivity();
        AppletPopupSchemaParam r21 = this.m;
        if (r21 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r21 = null;
    L28:
        r19.height = a.c(r20, r21, this);
        RadiusLayout r22 = this.g;
        if (r22 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r22 = null;
    L31:
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        LinearLayout r24 = this.f;
        if (r24 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r24 = null;
    L34:
        r23.height = r24.getLayoutParams().height - 0;
        BottomSheetBehavior<LinearLayout> r1 = this.o;
        if (r1 == null) goto L55;
        r1.C = true;
        if (r1 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r1 = null;
    L40:
        if (r1.D == 3) goto L48;
        BottomSheetBehavior<LinearLayout> r25 = this.o;
        if (r25 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r25 = null;
    L44:
        LinearLayout r26 = this.f;
        if (r26 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r26 = null;
    L47:
        r25.setPeekHeight(r26.getLayoutParams().height);
        goto L55
    L48:
        BottomSheetBehavior<LinearLayout> r27 = this.o;
        if (r27 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r27 = null;
    L51:
        LinearLayout r28 = this.f;
        if (r28 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r28 = null;
    L54:
        r27.w = r28.getLayoutParams().height;
    L55:
        int r29 = y5.e.d;
        AppletPopupSchemaParam r30 = this.m;
        if (r30 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r30 = null;
    L58:
        int r110 = y5.e.a.a(r30, r15, this.H);
        LinearLayout r31 = this.f;
        if (r31 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r31 = null;
    L61:
        y5.e.a.b(r31, r110);
    L62:
        BottomSheetBehavior<LinearLayout> r111 = this.o;
        if (r111 == null) goto L75;
        r111.C = true;
        if (this.x == false) goto L67;
        fa0(true);
    L67:
        BottomSheetBehavior<LinearLayout> r112 = this.o;
        if (r112 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r112 = null;
    L70:
        AppletPopupSchemaParam r0 = this.m;
        if (r0 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L74:
        r112.setHideable(r16.getEnablePullDownClose());
        goto L75
    L73:
        r16 = r0;
    L75:
        CoordinatorLayout r113 = this.j;
        if (r113 == null) goto L78;
        r113.requestLayout();
    L78:
        V90(r11);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final void aa0(int r11, int r12) {
        int r0 = Math.abs(r11);
        if (r0 <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L9;
        r0 = 0;
    L9:
        Context r13 = getContext();
        if (r13 == null) goto L12;
        com.bytedance.ai.utils.o.d(r0, r13);
    L12:
        this.w = Math.abs(r11);
        if (getActivity() == null) goto L116;
        View r14 = getView();
        if (r14 == null) goto L116;
        AppletPopupSchemaParam r1 = this.m;
        RadiusLayout r15 = null;
        if (r1 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r1 = null;
    L20:
        if (r1.getSelfAdaptiveHeight() == true) goto L90;
        int r16 = a.b(X90(), r14, this);
        if (this.q != 0) goto L38;
        AppletPopupSchemaParam r17 = this.m;
        if (r17 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r17 = null;
    L28:
        if (r17.getSelfAdaptiveHeight() == false) goto L33;
        AppletPopupSchemaParam r18 = this.m;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r18 = null;
    L32:
        int r19 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r18.getHeight(), r16 - W90(null)), 0);
    L37:
        this.q = r19;
        goto L38
    L33:
        LinearLayout r20 = this.f;
        if (r20 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r20 = null;
    L36:
        r19 = r20.getMeasuredHeight();
    L38:
        int r110 = RangesKt.coerceAtMost(this.q, r16 - W90(null));
        LinearLayout r21 = this.f;
        if (r21 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r21 = null;
    L41:
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L44;
        r22.height = r110;
    L44:
        int r111 = r110 - 0;
        RadiusLayout r23 = this.g;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r23 = null;
    L47:
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L50;
        r24.height = r111;
    L50:
        int r25 = y5.e.d;
        LinearLayout r26 = this.f;
        if (r26 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r26 = null;
    L53:
        Intrinsics.checkNotNullParameter(r26, "view");
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if ((r27 instanceof FrameLayout.LayoutParams) == false) goto L57;
        ViewGroup.LayoutParams r28 = r26.getLayoutParams();
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r29 = ((FrameLayout.LayoutParams) r28).gravity;
    L63:
        int r30 = r29 & 7;
        LinearLayout r31 = this.f;
        if (r31 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r31 = null;
    L66:
        y5.e.a.b(r31, r30 | 80);
        BottomSheetBehavior<LinearLayout> r32 = this.o;
        if (r32 == null) goto L90;
        r32.C = true;
        if (this.v != 0) goto L77;
        if (r32 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r32 = null;
    L73:
        if (r32.e == false) goto L75;
        int r33 = -1;
    L76:
        this.v = r33;
        goto L77
    L75:
        r33 = r32.d;
    L77:
        BottomSheetBehavior<LinearLayout> r34 = this.o;
        if (r34 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r34 = null;
    L81:
        if (r34.D == 3) goto L86;
        BottomSheetBehavior<LinearLayout> r35 = this.o;
        if (r35 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r35 = null;
    L85:
        r35.setPeekHeight(r111);
        goto L90
    L86:
        BottomSheetBehavior<LinearLayout> r36 = this.o;
        if (r36 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r36 = null;
    L89:
        r36.w = r111;
        goto L90
    L57:
        if ((r27 instanceof CoordinatorLayout.LayoutParams) == false) goto L60;
        CoordinatorLayout.LayoutParams r37 = r26.getLayoutParams();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        r29 = r37.gravity;
        goto L63
    L60:
        if ((r27 instanceof LinearLayout.LayoutParams) == false) goto L62;
        ViewGroup.LayoutParams r38 = r26.getLayoutParams();
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r29 = ((LinearLayout.LayoutParams) r38).gravity;
        goto L63
    L62:
        r29 = 0;
    L90:
        BottomSheetBehavior<LinearLayout> r112 = this.o;
        if (r112 != null) goto L93;
    L103:
        AppletPopupSchemaParam r113 = this.m;
        if (r113 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r113 = null;
    L107:
        if (r113.getSelfAdaptiveHeight() == false) goto L116;
        LinearLayout r114 = this.f;
        if (r114 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r114 = null;
    L111:
        r114.requestLayout();
        RadiusLayout r115 = this.g;
        if (r115 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
    L115:
        r15.requestLayout();
        goto L116
    L114:
        r15 = r115;
        goto L115
    L93:
        if (r112.s == false) goto L103;
        if (r112 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r112 = null;
    L96:
        r112.C = true;
        BottomSheetBehavior<LinearLayout> r116 = this.o;
        if (r116 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r116 = null;
    L99:
        this.x = r116.s;
        fa0(false);
        BottomSheetBehavior<LinearLayout> r117 = this.o;
        if (r117 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r117 = null;
    L102:
        r117.setHideable(false);
    L116:
        V90(r12);
        return;
    L5:
        r10 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [com.bytedance.ai.view.popup.e] */
    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        r12.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        r12.addOnAttachStateChangeListener(this);
        boolean r0 = true;
        if (this.o == null) goto L15;
        ViewTreeObserver.OnGlobalLayoutListener r14 = new com.bytedance.ai.view.popup.d(this);
        this.s = false;
        this.u = r14;
        Window r15 = X90();
        if (r15 == null) goto L7;
        View r16 = S90(r15);
    L9:
        if (this.N == true) goto L15;
        this.N = true;
        com.bytedance.ai.utils.g.a.d("AppletPopup", this + " ######registerRootViewGlobalLayoutChangeListerOnce#####");
        if (r16 == null) goto L15;
        ViewTreeObserver r17 = r16.getViewTreeObserver();
        if (r17 == null) goto L15;
        r17.addOnGlobalLayoutListener(this.O);
        goto L15
    L7:
        r16 = null;
    L15:
        List<x5.a> r18 = this.k;
        AppletPopupSchemaParam r10 = this.m;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r10 = null;
    L18:
        LinearLayout r11 = this.f;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r11 = null;
    L21:
        ArrayList r19 = (ArrayList) r18;
        r19.add(new y5.j(r10, r11));
        AppletPopupSchemaParam r20 = this.m;
        if (r20 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r20 = null;
    L24:
        LinearLayout r21 = this.f;
        if (r21 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r21 = null;
    L27:
        RadiusLayout r22 = this.g;
        if (r22 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r22 = null;
    L30:
        ha0();
        AppletPopupSchemaParam r23 = this.m;
        if (r23 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r23 = null;
    L33:
        r19.add(new y5.h(r20, r21, r22, r23.getRealGravity(getContext())));
        AppletPopupSchemaParam r24 = this.m;
        if (r24 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r24 = null;
    L36:
        View r25 = this.i;
        if (r25 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r25 = null;
    L39:
        r19.add(new y5.i(r24, r25));
        AppletPopupSchemaParam r26 = this.m;
        if (r26 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r26 = null;
    L42:
        View r27 = this.i;
        if (r27 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r27 = null;
    L45:
        r19.add(new y5.g(r26, r27));
        AppletPopupSchemaParam r28 = this.m;
        if (r28 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r28 = null;
    L48:
        View r29 = this.i;
        if (r29 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r29 = null;
    L51:
        r19.add(new y5.d(r28, r29, new e(this)));
        AppletPopupSchemaParam r30 = this.m;
        if (r30 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r30 = null;
    L54:
        LinearLayout r31 = this.f;
        if (r31 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r31 = null;
    L57:
        r19.add(new y5.f(r30, r31, this.H));
        Iterator r110 = ((ArrayList) this.k).iterator();
    L59:
        if (r110.hasNext() == false) goto L61;
        ((x5.a) r110.next()).invoke();
        goto L59
    L61:
        int r111 = z5.a.a;
        Dialog r112 = getDialog();
        if (r112 == null) goto L64;
        Window r113 = r112.getWindow();
    L65:
        AppletPopupSchemaParam r32 = this.m;
        if (r32 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r32 = null;
    L69:
        if (this.f != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
    L71:
        Intrinsics.checkNotNullParameter(r32, "schemaParams");
        int r33 = r32.getKeyboardAdjust();
        if (r33 != 0) goto L74;
        if (r113 == null) goto L86;
        r113.setSoftInputMode(48);
    L86:
        if (getActivity() != null) goto L88;
        return;
    L88:
        if (ha0() == true) goto L116;
        int r114 = a.b(X90(), getView(), this);
        AppletPopupSchemaParam r34 = this.m;
        if (r34 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r34 = null;
    L93:
        if ((!Intrinsics.areEqual(r34.getRealGravity(getContext()), "center")) == false) goto L99;
        AppletPopupSchemaParam r35 = this.m;
        if (r35 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r35 = null;
    L98:
        if (r35.getRealHeight(getActivity()) <= (r114 - W90(null))) goto L99;
    L111:
        if (r0 == false) goto L117;
        r12.setPadding(r12.getPaddingLeft(), r12.getPaddingTop() + W90(null), r12.getPaddingRight(), r12.getPaddingBottom());
        return;
    L117:
        return;
    L99:
        AppletPopupSchemaParam r36 = this.m;
        if (r36 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r36 = null;
    L103:
        if ((!Intrinsics.areEqual(r36.getRealGravity(getContext()), "center")) == true) goto L110;
        AppletPopupSchemaParam r37 = this.m;
        if (r37 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r37 = null;
    L108:
        if (r37.getRealHeight(getActivity()) > (r114 - (W90(null) * 2))) goto L111;
    L110:
        r0 = false;
        goto L111
    L116:
        return;
    L74:
        if (r33 == 1) goto L81;
        if (r33 == 2) goto L78;
        if (r113 == null) goto L86;
        r113.setSoftInputMode(32);
        goto L86
    L78:
        if (r113 == null) goto L80;
        r113.setSoftInputMode(16);
    L80:
        r32.getTransStatusBar();
        goto L86
    L81:
        if (r113 == null) goto L86;
        r113.setSoftInputMode(32);
        goto L86
    L64:
        r113 = null;
        goto L65
    }

    public final void show(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Field r13 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Throwable -> L5
        r13.setAccessible(true);     // Catch: Throwable -> L5
        r13.set(this, Boolean.FALSE);     // Catch: Throwable -> L5
        Field r14 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Throwable -> L5
        r14.setAccessible(true);     // Catch: Throwable -> L5
        r14.set(this, Boolean.TRUE);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L24:
        FragmentTransaction r15 = r10.beginTransaction();     // Catch: Throwable -> L16
        Fragment r16 = r10.findFragmentByTag(r11);     // Catch: Throwable -> L16
        if (r16 == null) goto L10;
        com.bytedance.ai.utils.g.a.d("AppletPopup", "showAllowingStateLoss remove fragment[" + getId() + ']');     // Catch: Throwable -> L16
        r15.remove(r16);     // Catch: Throwable -> L16
    L10:
        com.bytedance.ai.utils.g.a.d("AppletPopup", "showAllowingStateLoss add fragment[" + this + ']');     // Catch: Throwable -> L16
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r15, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r11, 0) == true) goto L14;
        r15.add(this, r11);     // Catch: Throwable -> L16
    L14:
        p2.c.d(new f(r11, r15));     // Catch: Throwable -> L16
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L26;
        com.bytedance.ai.utils.g.a.e("AppletPopup", "showAllowingStateLoss", r18);
        return;
    L26:
        return;
    L16:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        AppletPopupSchemaParam r10 = this.m;
        AppletPopupSchemaParam r11 = null;
        BottomSheetBehavior<LinearLayout> r12 = null;
        if (r10 != null) goto L7;
        r10 = null;
    L7:
        if (r10 != null) goto L10;
        com.bytedance.ai.utils.g.a.w("AppletPopup", "schemaParam is null, close fragment directly");
        da0(false);
        return null;
    L10:
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        StringBuilder r14 = new StringBuilder("[");
        r14.append(this);
        r14.append("] onCreateView, savedInstanceState is ");
        if (r20 != null) goto L13;
        String r15 = "null";
    L14:
        r14.append(r15);
        r13.d("AppletPopup", r14.toString());
        Window r16 = X90();
        if (r16 == null) goto L17;
        View r17 = S90(r16);
    L18:
        this.F = r17;
        if (r17 == null) goto L33;
        Map<Integer, List<OnApplyWindowInsetsListener>> r21 = q.a;
        k r22 = this.P;
        Intrinsics.checkNotNullParameter(r17, "view");
        Intrinsics.checkNotNullParameter(r22, "listener");
        final int r23 = r17.hashCode();
        Map<Integer, List<OnApplyWindowInsetsListener>> r24 = q.a;
        LinkedHashMap r110 = (LinkedHashMap) r24;
        Collection r111 = (Collection) r110.get(Integer.valueOf(r23));
        if (r111 != null) goto L23;
    L26:
        boolean r112 = true;
    L27:
        if (r112 == false) goto L29;
        r24.put(Integer.valueOf(r23), new ArrayList());
        ViewCompat.setOnApplyWindowInsetsListener(r17, new p(r23));
    L29:
        List r25 = (List) r110.get(Integer.valueOf(r23));
        if (r25 == null) goto L32;
        r25.add(r22);
    L32:
        r17.requestApplyInsets();
        goto L33
    L23:
        if (r111.isEmpty() == true) goto L26;
        r112 = false;
    L33:
        int r26 = z5.a.a;
        AppletPopupSchemaParam r27 = this.m;
        if (r27 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r27 = null;
    L36:
        Context r28 = r18.getContext();
        Intrinsics.checkNotNullParameter(r27, "params");
        Intrinsics.checkNotNullParameter(r28, "context");
        if (r27.getMarginTop() <= 0) goto L39;
        int r29 = r27.getMarginTop();
        boolean r113 = true;
    L41:
        if (r27.getMarginBottom() <= 0) goto L43;
        int r114 = r27.getMarginBottom();
        r113 = true;
    L45:
        if (r27.getMarginLeft() <= 0) goto L47;
        int r115 = r27.getMarginLeft();
        boolean r116 = true;
    L49:
        if (r27.getMarginRight() <= 0) goto L51;
        int r117 = r27.getMarginRight();
        r116 = true;
    L52:
        boolean r30 = z5.a.a(r28);
        if (r27.getMarginStart() <= 0) goto L55;
        int r118 = r27.getMarginStart();
        r116 = true;
    L57:
        if (r27.getMarginEnd() <= 0) goto L59;
        int r119 = r27.getMarginEnd();
        r116 = true;
    L60:
        if (r116 == false) goto L79;
        if (r113 == true) goto L79;
        if (Intrinsics.areEqual(r27.getGravity(), "left") == false) goto L65;
    L78:
        r114 = 0;
    L86:
        r29 = 0;
        r117 = 0;
    L87:
        this.H = new Integer[]{Integer.valueOf(r115), Integer.valueOf(r29), Integer.valueOf(r117), Integer.valueOf(r114), Integer.valueOf(r118), Integer.valueOf(r119)};
        if (ha0() == false) goto L145;
        View r1 = r18.inflate(2131558717, r19, false);
        this.e = (FrameLayout) r1.findViewById(2131382788);
        LinearLayout r31 = (LinearLayout) r1.findViewById(2131382778);
        r31.setOnClickListener(new g());
        this.f = r31;
        this.g = (RadiusLayout) r1.findViewById(2131382785);
        this.h = (FrameLayout) r1.findViewById(2131382791);
        this.i = r1.findViewById(2131382777);
        this.j = r1.findViewById(2131382781);
        AppletPopupSchemaParam r32 = this.m;
        if (r32 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r32 = null;
    L92:
        LinearLayout r33 = this.f;
        if (r33 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r33 = null;
    L95:
        this.l = new y5.b(r32, r33, this.p);
        AppletPopupSchemaParam r34 = this.m;
        if (r34 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r34 = null;
    L98:
        r34.getDragByGesture();
        LinearLayout r35 = this.f;
        if (r35 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r35 = null;
    L101:
        CoordinatorLayout.LayoutParams r36 = r35.getLayoutParams();
        boolean r37 = r36 instanceof CoordinatorLayout.LayoutParams;
        CoordinatorLayout.Behavior r38 = r36.getBehavior();
        boolean r39 = r38 instanceof BottomSheetBehavior;
        BottomSheetBehavior<LinearLayout> r40 = (BottomSheetBehavior) r38;
        r40.setHideable(true);
        r40.S = true;
        RadiusLayout r41 = this.g;
        if (r41 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r41 = null;
    L104:
        r40.t = new WeakReference(r41);
        r40.u = new WeakReference(null);
        d r42 = new d(this);
        if (r40.M.contains(r42) == true) goto L108;
        r40.M.add(r42);
    L108:
        if (this.D == false) goto L110;
        r40.e = false;
    L110:
        this.o = r40;
        AnimController r43 = this.p;
        r43.getClass();
        AnimController.AnimProcessType r44 = AnimController.AnimProcessType.NONE;
        r43.a = r44;
        r43.b = r44;
        r43.c = null;
        BottomSheetBehavior<LinearLayout> r45 = this.o;
        if (r45 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r45 = null;
    L113:
        r45.V = this.p;
        BottomSheetBehavior<LinearLayout> r46 = this.o;
        if (r46 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r46 = null;
    L116:
        r46.setFitToContents(false);
        BottomSheetBehavior<LinearLayout> r47 = this.o;
        if (r47 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r47 = null;
    L119:
        AppletPopupSchemaParam r48 = this.m;
        if (r48 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r48 = null;
    L122:
        r47.setHideable(r48.getEnablePullDownClose());
        BottomSheetBehavior<LinearLayout> r49 = this.o;
        if (r49 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r49 = null;
    L125:
        AppletPopupSchemaParam r50 = this.m;
        if (r50 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r50 = null;
    L128:
        r49.s = r50.getDragByGesture();
        BottomSheetBehavior<LinearLayout> r51 = this.o;
        if (r51 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r51 = null;
    L131:
        int r52 = W90(4);
        if (r52 >= 0) goto L134;
        r51.getClass();
    L135:
        BottomSheetBehavior<LinearLayout> r53 = this.o;
        if (r53 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L139:
        int r54 = W90(3);
        if (r54 < 0) goto L143;
        r12.l = r54;
        ga0(2131371662);
        return r1;
    L143:
        r12.getClass();
        throw new IllegalArgumentException("dragMinMarginTop must be greater than or equal to 0");
    L138:
        r12 = r53;
        goto L139
    L134:
        r51.k = r52;
        goto L135
    L145:
        View r55 = r18.inflate(2131558716, r19, false);
        this.e = (FrameLayout) r55.findViewById(2131382788);
        LinearLayout r56 = (LinearLayout) r55.findViewById(2131382778);
        ga0(2131382785);
        r56.setOnClickListener(new g());
        this.f = r56;
        this.g = (RadiusLayout) r55.findViewById(2131382785);
        this.h = (FrameLayout) r55.findViewById(2131382791);
        this.i = r55.findViewById(2131382777);
        List<x5.a> r57 = this.k;
        AppletPopupSchemaParam r58 = this.m;
        if (r58 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r58 = null;
    L148:
        LinearLayout r59 = this.f;
        if (r59 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r59 = null;
    L151:
        ((ArrayList) r57).add(new y5.e(r58, r59, this.H));
        AppletPopupSchemaParam r60 = this.m;
        if (r60 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r60 = null;
    L154:
        LinearLayout r61 = this.f;
        if (r61 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r61 = null;
    L157:
        y5.b r62 = new y5.b(r60, r61, this.p);
        this.l = r62;
        v5.a r63 = (v5.a) this.M.getValue();
        AppletPopupSchemaParam r64 = this.m;
        if (r64 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L161:
        r62.b(r63, r11.getHeight(), new h());
        ea0(this, false, false, 7);
        return r55;
    L160:
        r11 = r64;
        goto L161
    L65:
        if (Intrinsics.areEqual(r27.getGravity(), "start") == false) goto L68;
        if (r30 == false) goto L78;
    L68:
        if (Intrinsics.areEqual(r27.getGravity(), "end") == false) goto L72;
        if (r30 == true) goto L78;
    L72:
        if (Intrinsics.areEqual(r27.getGravity(), "right") == false) goto L74;
    L77:
        r29 = 0;
        r114 = 0;
        r115 = 0;
        goto L87
    L74:
        if (Intrinsics.areEqual(r27.getGravity(), "start") == true) goto L77;
        if (Intrinsics.areEqual(r27.getGravity(), "end") == true) goto L77;
    L84:
        r114 = 0;
    L85:
        r115 = 0;
    L79:
        if (r116 == true) goto L87;
        if (r113 == false) goto L87;
        if (Intrinsics.areEqual(r27.getGravity(), "bottom") == false) goto L84;
    L59:
        r119 = 0;
        goto L60
    L55:
        r118 = 0;
        goto L57
    L51:
        r117 = 0;
        goto L52
    L47:
        r115 = 0;
        r116 = false;
        goto L49
    L43:
        r114 = 0;
        goto L45
    L39:
        r29 = 0;
        r113 = false;
        goto L41
    L17:
        r17 = null;
        goto L18
    L13:
        r15 = "not null";
        goto L14
    }

    public static void ea0(AppletPopup r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r12 = true;
    L5:
        int r10 = 0;
        if ((r14 & 2) == 0) goto L8;
        r13 = false;
    L8:
        int r0 = -1;
        if ((r14 & 4) == 0) goto L11;
        r10 = -1;
    L11:
        AppletPopupSchemaParam r15 = null;
        if (r10 > (-1)) goto L19;
        r11.X90();
        FragmentActivity r16 = r11.getActivity();
        AppletPopupSchemaParam r17 = r11.m;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r17 = null;
    L17:
        r10 = a.c(r16, r17, r11);
    L19:
        if (r13 == false) goto L45;
        BottomSheetBehavior<LinearLayout> r18 = r11.o;
        if (r18 != null) goto L23;
    L46:
        com.bytedance.ai.utils.g.a.d("AppletPopup", "refreshPopupHeight. ShowHeight: " + r10);
        if (r12 == false) goto L96;
        AppletPopupSchemaParam r19 = r11.m;
        if (r19 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r19 = null;
    L51:
        RadiusLayout r110 = r11.g;
        if (r110 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r110 = null;
    L54:
        r11.X90();
        FragmentActivity r1 = r11.getActivity();
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r11, "appletPopup");
        Integer r20 = Integer.valueOf(r10);
        if (r19.getSelfAdaptiveHeight() == true) goto L57;
        if (r20 == null) goto L61;
        int r111 = r20.intValue();
    L62:
        ViewGroup.LayoutParams r21 = r110.getLayoutParams();
        if (r111 < 0) goto L66;
        r111 = r111 + 0;
    L66:
        r21.height = r111;
        r110.requestLayout();
    L67:
        AppletPopupSchemaParam r112 = r11.m;
        if (r112 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r112 = null;
    L70:
        LinearLayout r113 = r11.f;
        if (r113 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r113 = null;
    L73:
        r11.X90();
        FragmentActivity r22 = r11.getActivity();
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r113, "view");
        Intrinsics.checkNotNullParameter(r11, "appletPopup");
        Integer r23 = Integer.valueOf(r10);
        if (r112.getSelfAdaptiveHeight() == true) goto L76;
        if (r23 == null) goto L80;
        int r114 = r23.intValue();
    L81:
        ViewGroup.LayoutParams r24 = r113.getLayoutParams();
        if (r114 < 0) goto L85;
        r114 = r114 + 0;
    L85:
        r24.height = r114;
        r113.requestLayout();
    L86:
        AppletPopupSchemaParam r115 = r11.m;
        if (r115 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L91:
        if (r15.getSelfAdaptiveHeight() == true) goto L93;
        return;
    L93:
        if (r11.C == true) goto L98;
        r11.C = true;
        return;
    L98:
        return;
    L89:
        r15 = r115;
        goto L91
    L80:
        r114 = a.c(r22, r112, r11);
        goto L81
    L76:
        if (r11.C == true) goto L86;
        r113.getLayoutParams().height = -2;
        r113.requestLayout();
        goto L86
    L61:
        r111 = a.c(r1, r19, r11);
        goto L62
    L57:
        if (r11.C == true) goto L67;
        r110.getLayoutParams().height = -2;
        r110.requestLayout();
        goto L67
    L96:
        return;
    L23:
        if (r18.e == true) goto L26;
        r0 = r18.d;
    L26:
        if (r0 == r10) goto L46;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r18 = null;
    L31:
        if (r18.D == 3) goto L36;
        BottomSheetBehavior<LinearLayout> r116 = r11.o;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r116 = null;
    L35:
        r116.setPeekHeight(r10);
    L40:
        if (r12 == true) goto L46;
        LinearLayout r117 = r11.f;
        if (r117 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r117 = null;
    L44:
        r117.requestLayout();
        goto L46
    L36:
        BottomSheetBehavior<LinearLayout> r118 = r11.o;
        if (r118 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r118 = null;
    L39:
        r118.w = r10;
        goto L40
    L45:
        r11.getClass();
        goto L46
    }
}
