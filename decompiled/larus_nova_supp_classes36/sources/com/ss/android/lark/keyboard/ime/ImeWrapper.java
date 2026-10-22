package com.ss.android.lark.keyboard.ime;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.util.Pools;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.CarUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ³\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b°\u0001±\u0001²\u0001³\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010E\u001a\u00020AH\u0014J\b\u0010F\u001a\u00020AH\u0014J\b\u0010G\u001a\u00020)H\u0002J\u0010\u0010H\u001a\u00020A2\u0006\u0010/\u001a\u00020\tH\u0016J\u0018\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020AH\u0002J\b\u0010N\u001a\u00020\u0017H\u0016J\b\u0010O\u001a\u00020\u0017H\u0016J\b\u0010P\u001a\u00020\u0017H\u0016J\u0006\u0010Q\u001a\u00020-J\b\u0010R\u001a\u00020\u0017H\u0016J\b\u0010S\u001a\u00020\u0017H\u0016J\u0018\u0010T\u001a\u00020A2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0012H\u0016J\b\u0010U\u001a\u00020\u0017H\u0016J\b\u0010V\u001a\u00020\u0017H\u0016J\b\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020:H\u0016J\b\u0010\\\u001a\u00020\tH\u0016J\b\u0010]\u001a\u00020AH\u0002J\b\u0010^\u001a\u00020AH\u0002J\u0010\u0010_\u001a\u00020A2\u0006\u0010`\u001a\u00020\u0017H\u0016J\b\u0010a\u001a\u00020\u0017H\u0016J\u0010\u0010b\u001a\u00020A2\u0006\u0010`\u001a\u00020\u0017H\u0016J\b\u0010c\u001a\u00020\u0017H\u0016J\u0012\u0010d\u001a\u00020A2\b\b\u0002\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020AH\u0002J/\u0010g\u001a\u00020A*\u00020h2!\u0010i\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020A0jH\u0002J\u001c\u0010n\u001a\u00020A2\b\b\u0002\u0010o\u001a\u00020\t2\b\b\u0002\u0010p\u001a\u00020\u0017H\u0002J\f\u0010q\u001a\u00020A*\u00020?H\u0002J=\u0010r\u001a\u00020h2\u0006\u0010e\u001a\u00020\t2\u0006\u0010o\u001a\u00020\t2\b\b\u0002\u0010s\u001a\u00020\t2\u0019\b\u0002\u0010t\u001a\u0013\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020A0j¢\u0006\u0002\buH\u0002J\b\u0010v\u001a\u00020\tH\u0002J\u0010\u0010w\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\b\u0010x\u001a\u00020&H\u0002J\u0006\u0010y\u001a\u00020zJ\u0006\u0010{\u001a\u00020|J\u0018\u0010}\u001a\u00020A2\u0006\u0010~\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020\tH\u0014J6\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020\u00172\u0007\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0014J\u0012\u0010\u0086\u0001\u001a\u00020A2\u0007\u0010\u0087\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020A2\u0007\u0010\u0087\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020A2\u0007\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u008b\u0001\u001a\u00020A2\u0007\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0016J\u001a\u0010\u008d\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u0017H\u0016J\u0011\u0010\u008f\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\u0012\u0010\u0090\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020 H\u0002J&\u0010\u0092\u0001\u001a\u00020A2\u0007\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0095\u0001\u001a\u00020|H\u0002J\u0011\u0010\u0096\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\t\u0010\u0097\u0001\u001a\u00020AH\u0002J\t\u0010\u0098\u0001\u001a\u00020AH\u0002J\t\u0010\u0099\u0001\u001a\u00020AH\u0002J\t\u0010\u009a\u0001\u001a\u00020AH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020A2\u0007\u0010\u009d\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u009e\u0001\u001a\u00020 2\u0007\u0010\u009f\u0001\u001a\u00020LH\u0002J\t\u0010 \u0001\u001a\u00020\u0017H\u0002J\u0012\u0010¡\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020 H\u0002J\t\u0010¢\u0001\u001a\u00020AH\u0002J\u001b\u0010£\u0001\u001a\u00020A2\u0007\u0010¤\u0001\u001a\u00020 2\u0007\u0010¥\u0001\u001a\u00020\u0017H\u0002J\u001b\u0010¦\u0001\u001a\u00020A2\u0007\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0002J\u0015\u0010§\u0001\u001a\u00020A2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0014J\n\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\u0015\u0010¬\u0001\u001a\u00020A*\n\u0012\u0005\u0012\u00030®\u00010\u00ad\u0001H\u0002J\u0015\u0010¯\u0001\u001a\u00020A*\n\u0012\u0005\u0012\u00030®\u00010\u00ad\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020 0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b1\u00102R\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:0$X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006´\u0001"}, d2 = {"Lcom/ss/android/lark/keyboard/ime/ImeWrapper;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/keyboard/ime/ImeController;", "Lcom/ss/android/lark/keyboard/ime/ImeCoordinator$InsetsDispatchListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "store", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "bottomSpacing", "lastImeHeight", "minPanelHeight", "maxPanelHeightProvider", "Lkotlin/Function0;", "", "storeImeHeight", "panelHeight", "enableWindowInsetsAnim", "", "imeHeightObserver", "", "Lcom/ss/android/lark/keyboard/ime/ImeHeightObserver;", "imeInsetsInterceptor", "Lcom/ss/android/lark/keyboard/ime/ImeInsetsInterceptor;", "panelHeightFollowIme", "deferredInsets", "lastWindowInsets", "Lcom/ss/android/lark/keyboard/ime/ImeInsetsHolder;", "innerActionHandle", "Lcom/ss/android/lark/keyboard/ime/ImeEventHandleImpl;", "actionHandles", "", "imeAnimController", "Lcom/ss/android/lark/keyboard/ime/ImeWrapper$ImeAnimController;", "imeEnable", "innerContainer", "Lcom/ss/android/lark/keyboard/ime/ImePanelContainer;", "insetsPool", "Landroidx/core/util/Pools$SimplePool;", "focusDelegateProvider", "Landroid/view/View;", "hasPendingPanelAnim", "value", "inAnimationCount", "setInAnimationCount", "(I)V", "imeState", "Lcom/ss/android/lark/keyboard/ime/ImeStateFlow;", "getImeState", "()Lcom/ss/android/lark/keyboard/ime/ImeStateFlow;", "panelState", "getPanelState", "extraMap", "", "getExtraMap$keyboard_base_release", "()Ljava/util/Map;", "runningAnimators", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/animation/Animator;", "setPanelState", "", "state", "Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;", "setImeState", "onAttachedToWindow", "onDetachedFromWindow", "prepareInnerContainer", "setBottomSpacing", "onGlobalDispatchInsets", "decorFitSystemWindow", "dispatchWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "adjustPanelHeightBeforeShow", "showPanel", "hidePanel", "showIme", "requestFocusForShowIme", "hideIme", "hideImeUseCompat", "setFocusDelegate", "isImeShow", "isPanelShow", "getPanel", "Landroid/view/ViewGroup;", "getHandle", "Lcom/ss/android/lark/keyboard/ime/ImeEventHandle;", TabAppInfo.IMAGE_JSON_KEY, "height", "attachImpl", "detachImpl", "setAnimationEnable", "enable", "isAnimationEnable", "setImeEnable", "isInAnimation", "playEnterAnim", "fromHeight", "cancelRunningAnimations", "doOnEndIgnoreCancel", "Landroid/animation/ValueAnimator;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "playExitAnim", "toHeight", "notifyExit", "startOnNextFrame", "preparePanelAnimator", "type", "initFunction", "Lkotlin/ExtensionFunctionType;", "getInitialImeHeight", "setImeHeightToStore", "createImeAnimController", "getAnimDuration", "", "getAnimInterpolator", "Landroid/view/animation/Interpolator;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "addImeHeightObserver", "listener", "removeImeHeightObserver", "addInsetsInterceptor", "interceptor", "removeInsetsInterceptor", "setPanelHeight", "setPanelHeightImmediately", "followIme", "setHeightInner", "notifyHeightChangeForAnimationOfIme", "imeInsetsHolder", "notifyHeightChangeForAnimation", "from", "to", "interpolator", "notifyHeightChange", "notifyPanelShow", "notifyPanelHide", "notifyImeShow", "notifyImeHide", "updateHeightWhenInsetsChange", "recordImeHeight", "imeHeight", "obtainImeInsetsHolder", "insets", "isOfficeSdkRuntime", "consumeImeInsets", "notifyImeWrapperHeightUpdate", "handleWindowInsets", "insetsHolder", "systemDispatch", "startCompatInsetsAnimation", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "buildLayoutSnapshot", "", "consume", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/keyboard/ime/ImeEventHandleImpl$ActionWrapper;", "pollExecuteOnce", "ImeAnimControllerImpl", "ImeAnimController", "InterpolatorFilter", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class ImeWrapper extends FrameLayout implements com.ss.android.lark.keyboard.ime.a, ImeCoordinator.b {
    public static final a B = null;
    public final CopyOnWriteArrayList<Animator> A;
    public final Context a;
    public final com.ss.android.lark.storage.kv.repo.a b;
    public int c;
    public int d;
    public final int e;
    public final Function0<Float> f;
    public int g;
    public int h;
    public boolean i;
    public final List<e> j;
    public final List<g> k;
    public boolean l;
    public boolean m;
    public final f n;
    public final d o;
    public final Map<Integer, d> p;
    public final ImeAnimControllerImpl q;
    public boolean r;
    public final h s;
    public final Pools.SimplePool<f> t;
    public Function0<? extends View> u;
    public boolean v;
    public int w;
    public final j x;
    public final j y;
    public final Map<Integer, Object> z;

    public final class ImeAnimControllerImpl extends WindowInsetsAnimationCompat.Callback {
        public Interpolator a;
        public long b;
        public final /* synthetic */ ImeWrapper c;

        public ImeAnimControllerImpl(ImeWrapper r4) {
            this.c = r4;
            super(1);
            this.a = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
            this.b = 285;
        }

        public final void onPrepare(final WindowInsetsAnimationCompat r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onPrepare(r4);
            Interpolator r0 = r4.getInterpolator();
            if (r4.getTypeMask() != WindowInsetsCompat.Type.ime()) goto L6;
            if (r0 == null) goto L6;
            this.a = r0;
            this.b = r4.getDurationMillis();
        L6:
            com.ss.android.lark.keyboard.ime.b r1 = com.ss.android.lark.keyboard.ime.b.a;
            final ImeWrapper r2 = this.c;
            Function0<String> r3 = new ImeWrapper$ImeAnimControllerImpl$onPrepare$1(r4, r2);
            r1.getClass();
            com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r3);
        }

        public final WindowInsetsCompat onProgress(final WindowInsetsCompat r4, final List<WindowInsetsAnimationCompat> r5) {
            Intrinsics.checkNotNullParameter(r4, "insets");
            Intrinsics.checkNotNullParameter(r5, "runningAnimations");
            com.ss.android.lark.keyboard.ime.b r0 = com.ss.android.lark.keyboard.ime.b.a;
            final ImeWrapper r2 = this.c;
            Function0<String> r1 = new ImeWrapper$ImeAnimControllerImpl$onProgress$1(r4, r5, r2);
            r0.getClass();
            com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r1);
            return r4;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Interpolator {
        public final Interpolator a;
        public final float b;
        public final int c;
        public final float d;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r2) {
            float r3 = this.a.getInterpolation(r2);
            if (this.c >= 0) goto L5;
            float r4 = Math.max(0.0f, r3 - this.b);
            float r0 = this.d;
        L7:
            return r4 * r0;
        L5:
            r4 = Math.min(this.b, r3);
            r0 = this.d;
            goto L7
        }

        public b(Interpolator r2, float r3, int r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ ImeWrapper b;
        public final /* synthetic */ Animator c;

        public c(View r1, ImeWrapper r2, Animator r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("ImeWrapper", "startOnNextFrame: invoked");     // Catch: Throwable -> L4
            this.b.v = false;     // Catch: Throwable -> L4
            this.c.start();     // Catch: Throwable -> L4
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
        B = new a();
    }

    public ImeWrapper(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImeWrapper(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getInitialImeHeight() {
        int r0 = this.b.getInt("lark:im:keyboard:imeHeight", 0);
        Log.i("ImeWrapper", "getInitialImeHeight: heightInSp is " + r0);
        if (r0 > this.e) goto L6;
        int r1 = s.a;
        Context r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        return UIUtils.dp2px(r2, 260.0f);
    L6:
        return r0;
    }

    public final boolean T() {
        if (this.w <= 0) goto L5;
    L10:
        return true;
    L5:
        if (this.m == true) goto L10;
        if (this.v == true) goto L10;
        return false;
    }

    public final void X() {
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).J();
        goto L4
    }

    public final void Y() {
        Log.d("ImeWrapper", "state change: panel hide");
        R(this.o.d);
        Iterator r0 = ((LinkedHashMap) this.p).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        R(((d) r0.next()).d);
        goto L4
    }

    public final void Z() {
        Log.d("ImeWrapper", "state change: panel show");
        R(this.o.c);
        Iterator r0 = ((LinkedHashMap) this.p).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        R(((d) r0.next()).c);
        goto L4
    }

    public final long getAnimDuration() {
        return this.q.b;
    }

    public final Interpolator getAnimInterpolator() {
        return this.q.a;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean B() {
        if (getPanelState().b() == ImeStateDetail.Hide) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean a() {
        if (getPanelState().b().isHideOrExit() == false) goto L6;
        return false;
    L6:
        if (this.i == false) goto L9;
        setPanelState(ImeStateDetail.Exit);
        a0(this, 0, true, 1);
        return true;
    L9:
        setPanelState(ImeStateDetail.Hide);
        this.s.setVisibility(4);
        setHeightInner(0);
        Y();
        U(0);
        return true;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean e() {
        if (getPanelState().b().isEnterOrShow() == false) goto L6;
        return false;
    L6:
        if (this.w <= 0) goto L9;
        Log.i("ImeWrapper", "showPanel: inAnimationCount > 0");
        return false;
    L9:
        int r0 = MathKt.roundToInt(((Number) this.f.invoke()).floatValue());
        if (this.h <= r0) goto L12;
        Log.i("ImeWrapper", "adjustPanelHeightBeforeShow: panelHeight > maxPanelHeight, adjust panelHeight from " + this.h + " to " + r0);
        int r1 = RangesKt.coerceAtMost(this.h, r0);
        this.h = r1;
        this.s.setExpectHeight(r1);
    L12:
        ImeStateDetail r2 = getImeState().b();
        ImeStateDetail r3 = ImeStateDetail.Enter;
        if (r2 == r3) goto L19;
        if (getImeState().b() == ImeStateDetail.Show) goto L19;
        final int r4 = 0;
        boolean r5 = false;
    L22:
        Function0<Unit> r6 = new ImeWrapper$showPanel$showPanelActionNoAnim$1(this);
        if (this.i == false) goto L29;
        setHeightInner(this.h);
        this.s.setVisibility(0);
        setPanelState(r3);
        Log.i("ImeWrapper", "panelEnter: prepare. form: " + r4 + ", to: " + this.h + " , panelTransform: " + getPanelState() + " -> " + r3);
        Iterator<Animator> r7 = this.A.iterator();
    L26:
        if (r7.hasNext() == false) goto L28;
        r7.next().cancel();
        goto L26
    L28:
        V(r4, this.h, getAnimInterpolator());
        Z();
        X();
        c0(b0(this, r4, this.h, new ImeWrapper$playEnterAnim$1(this, r4)));
    L32:
        return true;
    L29:
        if (r5 == false) goto L31;
        this.o.g(r6);
        goto L32
    L31:
        r6.invoke();
    L19:
        if (g() == true) goto L21;
        return false;
    L21:
        r4 = this.d;
        r5 = true;
        goto L22
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean g() {
        if (getImeState().b().isEnterOrShow() == true) goto L6;
        return false;
    L6:
        Function0<? extends View> r0 = this.u;
        if (r0 == null) goto L10;
        View r1 = (View) r0.invoke();
        if (r1 == null) goto L10;
    L11:
        int r2 = s.a;
        Context r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r1, "currentFocusView");
        KeyboardUtils.hideKeyboard(r3, r1);
        return true;
    L10:
        r1 = this;
        goto L11
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final int height() {
        return getLayoutParams().height;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s.setVisibility(4);
        setPanelState(ImeStateDetail.Hide);
        int r0 = ImeCoordinator.e;
        Intrinsics.checkNotNullParameter(this, "imeWrapper");
        if (isAttachedToWindow() == true) goto L5;
        Log.e("GlobalTraversalObserver", "imeWrapper is not attach to window , method return.");
        return;
    L5:
        View r1 = getRootView();
        int r2 = ImeCoordinator.e;
        ImeCoordinator r3 = (ImeCoordinator) r1.findViewById(r2);
        if (r3 != null) goto L8;
        r3 = new ImeCoordinator(getContext());
        r3.setId(r2);
        ((ViewGroup) r1.findViewById(R.id.content)).addView(r3, 0);
    L8:
        ((ArrayList) r3.d).add(this);
        r3.requestApplyInsets();
        r3.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = ImeCoordinator.e;
        Intrinsics.checkNotNullParameter(this, "imeWrapper");
        if (isAttachedToWindow() == true) goto L5;
        Log.e("GlobalTraversalObserver", "imeWrapper is not attach to window , method return.");
    L5:
        ImeCoordinator r1 = (ImeCoordinator) getRootView().findViewById(ImeCoordinator.e);
        if (r1 == null) goto L9;
        ((ArrayList) r1.d).remove(this);
    L9:
        boolean r2 = B();
        setPanelState(ImeStateDetail.Hide);
        if (r2 == false) goto L12;
        Y();
    L12:
        setHeightInner(0);
        this.d = 0;
        f r3 = this.n;
        r3.a = 0;
        r3.b = 0;
        r3.c = 0;
        r3.d = false;
        r3.e = false;
        r3.f = false;
        U(0);
        this.s.setVisibility(4);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean y() {
        if (getImeState().b() == ImeStateDetail.Hide) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean z() {
        if (getImeState().b().isEnterOrShow() == false) goto L6;
        return false;
    L6:
        if (getImeState().b() != ImeStateDetail.Exit) goto L9;
        this.o.g(new ImeWrapper$showIme$1(this));
    L9:
        if (this.r == true) goto L12;
        Log.w("ImeWrapper", "business require disable show ime");
        return false;
    L12:
        Function0<? extends View> r0 = this.u;
        if (r0 == null) goto L16;
        View r1 = (View) r0.invoke();
        if (r1 == null) goto L16;
    L17:
        int r2 = s.a;
        Intrinsics.checkNotNullParameter(r1, "focus");
        if (CarUtils.a() == false) goto L20;
        KeyboardUtils.showKeyboardIgnoreExternalKeyboardCheck(r1);
        return true;
    L20:
        KeyboardUtils.showKeyboard(r1);
        return true;
    L16:
        r1 = this;
        goto L17
    }

    public final Map<Integer, Object> getExtraMap$keyboard_base_release() {
        return this.z;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public j getImeState() {
        return this.x;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public ViewGroup getPanel() {
        return this.s;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public j getPanelState() {
        return this.y;
    }

    public static final String J(ImeWrapper r4) {
        View r0 = r4.getRootView().findViewById(R.id.content);
        StringBuilder r1 = new StringBuilder("layout[rootH=");
        r1.append(r4.getRootView().getHeight());
        r1.append(", rootBottom=");
        r1.append(r4.getRootView().getBottom());
        r1.append(", contentH=");
        Integer r2 = null;
        if (r0 == null) goto L5;
        Integer r3 = Integer.valueOf(r0.getHeight());
    L6:
        r1.append(r3);
        r1.append(", contentBottom=");
        if (r0 == null) goto L9;
        r2 = Integer.valueOf(r0.getBottom());
    L9:
        r1.append(r2);
        r1.append(", wrapperH=");
        r1.append(r4.getHeight());
        r1.append(", wrapperTop=");
        r1.append(r4.getTop());
        r1.append(", wrapperBottom=");
        r1.append(r4.getBottom());
        r1.append(", innerH=");
        r1.append(r4.s.getHeight());
        r1.append(", innerTop=");
        r1.append(r4.s.getTop());
        r1.append(", innerBottom=");
        r1.append(r4.s.getBottom());
        r1.append(']');
        return r1.toString();
    L5:
        r3 = null;
        goto L6
    }

    public static void R(LinkedList r4) {
        Iterator r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d.a) r0.next()).b.invoke();
        goto L4
    L6:
        ArrayList r1 = new ArrayList();
        Iterator r2 = r4.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if ((!((d.a) r3).a) == false) goto L8;
        r1.add(r3);
        goto L8
    L12:
        r4.clear();
        r4.addAll(r1);
    }

    private final void setHeightInner(int r3) {
        Log.d("ImeWrapper", "setHeightInner: update height is " + r3);
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L7;
        r0.height = r3;
        setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void setImeHeightToStore(int r3) {
        this.g = r3;
        this.b.putInt("lark:im:keyboard:imeHeight", r3);
    }

    private final void setImeState(ImeStateDetail r3) {
        j r0 = getImeState();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.a.setValue(r3);
    }

    private final void setInAnimationCount(int r3) {
        if (r3 > 2) goto L8;
        if (r3 < 0) goto L9;
        this.w = r3;
        Log.d("ImeWrapper", "inAnimationCount: update value is " + r3);
        return;
    L9:
        return;
    }

    private final void setPanelState(ImeStateDetail r3) {
        j r0 = getPanelState();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.a.setValue(r3);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void H(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.j).remove(r2);
    }

    public final void U(int r3) {
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).a(r3);
        goto L4
    }

    public final void W(f r6) {
        Interpolator r0 = getAnimInterpolator();
        if (r6.d == false) goto L12;
        int r1 = r6.c + this.c;
        int r2 = Math.max(r6.a, r6.b);
        if (r6.a <= r6.b) goto L7;
        int r3 = 1;
    L8:
        if (r3 <= 0) goto L10;
        int r4 = r2;
    L11:
        float r5 = r1 + r2;
        r0 = new b(r0, r4 / r5, r3, r5 / r2);
        goto L12
    L10:
        r4 = r1;
        goto L11
    L7:
        r3 = -1;
    L12:
        V(r6.a, r6.b, r0);
    }

    public final void c0(Animator r2) {
        this.v = true;
        OneShotPreDrawListener.add(this, new c(this, this, r2));
        invalidate();
    }

    public final void d0(int r2) {
        if (B() == true) goto L8;
        int r3 = Math.max(r2, 0);
        setHeightInner(r3);
        if (this.m == true) goto L9;
        U(r3);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void l(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.j).add(r2);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void n(g r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.k).add(r2);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        int r3 = MathKt.roundToInt(((Number) this.f.invoke()).floatValue());
        if (B() == true) goto L5;
        return;
    L5:
        if (this.h <= r3) goto L9;
        this.h = r3;
        this.s.setExpectHeight(r3);
        setHeightInner(this.h);
        U(this.h);
        return;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public void setAnimationEnable(boolean r3) {
        if (this.i != r3) goto L5;
        return;
    L5:
        this.i = r3;
        if (r3 == false) goto L11;
        ImeAnimControllerImpl r4 = this.q;
        if (Build.VERSION.SDK_INT < 30) goto L10;
        ViewCompat.setWindowInsetsAnimationCallback(r4.c, r4);
        return;
    L10:
        r4.getClass();
        return;
    L11:
        ImeAnimControllerImpl r5 = this.q;
        if (Build.VERSION.SDK_INT < 30) goto L14;
        ViewCompat.setWindowInsetsAnimationCallback(r5.c, null);
        return;
    L14:
        r5.getClass();
    }

    public void setBottomSpacing(int r3) {
        Log.i("ImeWrapper", "imeWrapper: setBottomSpacing " + r3);
        this.c = r3;
    }

    public void setFocusDelegate(Function0<? extends View> r1) {
        this.u = r1;
        if (r1 != null) goto L5;
        setFocusable(true);
        setFocusableInTouchMode(true);
        return;
    L5:
        clearFocus();
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public void setImeEnable(boolean r1) {
        this.r = r1;
    }

    public void setPanelHeight(int r4) {
        int r0 = this.h;
        if (r4 != (-2)) goto L9;
        this.l = true;
        int r1 = this.d;
        if (r1 > 0) goto L8;
        int r2 = s.a;
        Context r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        r1 = UIUtils.dp2px(r3, 260.0f);
    L8:
        this.h = r1;
    L9:
        if (r4 <= 0) goto L11;
        this.h = r4;
        this.l = false;
    L11:
        this.s.setExpectHeight(this.h);
        if (B() == false) goto L20;
        int r5 = this.h;
        if (r0 != r5) goto L16;
        return;
    L16:
        if (this.i == true) goto L18;
        setHeightInner(r5);
        return;
    L18:
        setHeightInner(Math.max(r0, r5));
        Log.i("ImeWrapper", "onPanelHeight update: form " + r0 + ", to " + this.h);
        c0(b0(this, r0, this.h, new AnonymousClass1(this)));
        V(r0, this.h, getAnimInterpolator());
        X();
        return;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final com.ss.android.lark.keyboard.ime.c v(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Map<Integer, d> r0 = this.p;
        Integer r4 = Integer.valueOf(r3.hashCode());
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Object r2 = r1.get(r4);
        if (r2 != null) goto L6;
        r2 = new d();
        r1.put(r4, r2);
    L6:
        return (com.ss.android.lark.keyboard.ime.c) r2;
    }

    public static final /* synthetic */ void L(ImeWrapper r0, int r1) {
        r0.setHeightInner(r1);
    }

    public static final /* synthetic */ void P(ImeWrapper r0, int r1) {
        r0.setInAnimationCount(r1);
    }

    public static final /* synthetic */ void Q(ImeWrapper r0, ImeStateDetail r1) {
        r0.setPanelState(r1);
    }

    public final void S(final f r22, final boolean r23) {
        if (r23 == true) goto L5;
    L9:
        Log.d("ImeWrapper", "handleWindowInsets: insets holder is " + r22 + ", last ime height is " + this.d + " , is systemDispatch is " + r23);
        final boolean r1 = hasWindowFocus() ^ true;
        com.ss.android.lark.keyboard.ime.b r2 = com.ss.android.lark.keyboard.ime.b.a;
        Function0<String> r3 = new ImeWrapper$handleWindowInsets$1(r23, r1, this, r22);
        r2.getClass();
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r3);
        if (this.i == true) goto L12;
    L18:
        final boolean r15 = r22.e;
        final boolean r9 = r22.d;
        final boolean r8 = r22.f;
        boolean r0 = this.i & this.m;
        final boolean r7 = (r0 & r9) & (!r8);
        final boolean r6 = r0 & (!r9);
        if (r8 == true) goto L21;
        int r5 = r22.a;
    L22:
        if (r8 == true) goto L24;
        int r4 = r22.b;
    L25:
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        final ImeStateDetail r11 = getImeState().b();
        final int r16 = r4;
        final int r17 = r5;
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", new ImeWrapper$consumeImeInsets$1(r22, r8, this, r9, r7, r6, r17, r16, r11));
        if (r9 == false) goto L45;
        final boolean r12 = B();
        StringBuilder r13 = new StringBuilder("panel is show ");
        r13.append(r12);
        r13.append(" , currentImeState.isHideOrExit is ");
        final ImeStateDetail r14 = r11;
        r13.append(r14);
        r13.append(".isHideOrExit() , insetsImeShow is ");
        r13.append(r15);
        Log.d("ImeWrapper", r13.toString());
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", new ImeWrapper$consumeImeInsets$2(r12, r14, r15));
        if (r12 == true) goto L34;
        d0(r16);
        if (r7 == false) goto L32;
        Log.d("ImeWrapper", "notifyHeightChangeForAnimationOfIme 1");
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$3.INSTANCE);
        W(r22);
    L32:
        boolean r18 = r6;
        boolean r19 = true;
    L57:
        if (r22.e == false) goto L70;
        int r20 = r22.b;
        if (r20 <= 0) goto L64;
        if (this.g == r20) goto L64;
        setImeHeightToStore(r20);
    L64:
        if (this.l == false) goto L70;
        if (r20 <= this.e) goto L70;
        if (this.h == r20) goto L70;
        this.h = r20;
        this.s.setExpectHeight(r20);
    L70:
        if (r7 == true) goto L75;
        if (r15 == false) goto L73;
        ImeStateDetail r21 = ImeStateDetail.Show;
    L83:
        ImeStateDetail r24 = ImeStateDetail.Hide;
        if (r14 == r24) goto L86;
        boolean r25 = true;
    L87:
        if (r21 != r24) goto L90;
        r19 = false;
    L90:
        if (r25 == false) goto L96;
        if (r19 == true) goto L96;
        Log.d("ImeWrapper", "state change: ime hide");
        R(this.o.b);
        Iterator r26 = ((LinkedHashMap) this.p).values().iterator();
    L94:
        if (r26.hasNext() == false) goto L96;
        R(((d) r26.next()).b);
    L96:
        setImeState(r21);
        if (r25 == true) goto L104;
        if (r19 == false) goto L104;
        Log.d("ImeWrapper", "state change: ime show");
        R(this.o.a);
        Iterator r27 = ((LinkedHashMap) this.p).values().iterator();
    L101:
        if (r27.hasNext() == false) goto L104;
        R(((d) r27.next()).a);
    L104:
        if (((Ref.BooleanRef) r11).element == false) goto L106;
        setPanelState(ImeStateDetail.Exit);
    L106:
        this.d = r22.b;
        this.n.a(r22);
        if (r14 == getImeState().b()) goto L109;
        Log.i("ImeWrapper", "consume window insets end: " + r22 + ", needAnimation: " + r7 + ", updateAnimation: " + r18 + ", deferred insets " + this.m + ", imeTransform: " + r14 + " -> " + getImeState().b());
    L109:
        com.ss.android.lark.keyboard.ime.b r28 = com.ss.android.lark.keyboard.ime.b.a;
        Function0<String> r29 = new ImeWrapper$consumeImeInsets$7(this, r14, r10);
        r28.getClass();
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r29);
        X();
        return;
    L86:
        r25 = false;
        goto L87
    L73:
        r21 = ImeStateDetail.Hide;
        goto L83
    L75:
        if (r14.isHideOrExit() == false) goto L79;
        if (r15 == false) goto L79;
        r21 = ImeStateDetail.Enter;
    L79:
        if (r14.isEnterOrShow() == false) goto L82;
        if (r15 == true) goto L82;
        r21 = ImeStateDetail.Exit;
    L82:
        r21 = r14;
        goto L83
    L34:
        if (r14.isHideOrExit() == false) goto L39;
        if (r15 == false) goto L39;
        if (r7 == false) goto L38;
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$4.INSTANCE);
        r10.element = true;
        a0(this, r16, false, 2);
    L44:
        r19 = true;
    L51:
        r18 = r6;
        goto L57
    L38:
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$5.INSTANCE);
        this.s.setVisibility(4);
        Y();
        setPanelState(ImeStateDetail.Hide);
        d0(r16);
    L39:
        if (r15 == true) goto L44;
        if (getPanelState().b() != ImeStateDetail.Exit) goto L44;
        if (r7 == false) goto L44;
        r19 = true;
        r10.element = true;
        a0(this, r16, false, 2);
        goto L51
    L45:
        r14 = r11;
        r19 = true;
        if (r17 != r16) goto L52;
        if (r8 == true) goto L51;
        if (this.m == true) goto L51;
    L52:
        d0(r16);
        r18 = r6;
        if (r18 == false) goto L57;
        Log.d("ImeWrapper", "notifyHeightChangeForAnimationOfIme 2");
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$6.INSTANCE);
        W(r22);
        goto L57
    L24:
        r4 = 0;
        goto L25
    L21:
        r5 = 0;
        goto L22
    L12:
        if (r22.d == false) goto L18;
        if (r23 == false) goto L18;
        if (this.m == true) goto L18;
        if (r1 == true) goto L18;
        Log.d("ImeWrapper", "handleWindowInsets: has window insets animation, start compat insets anim");
        this.m = true;
        int r30 = r22.a;
        int r31 = r22.b;
        ValueAnimator r32 = ObjectAnimator.ofFloat(new float[]{1000.0f});
        r32.setDuration(getAnimDuration());
        r32.setInterpolator(getAnimInterpolator());
        Intrinsics.checkNotNull(r32);
        r32.addListener(new r(this, r30, r31));
        r32.addUpdateListener(new p(r30, r31, this));
        r32.addListener(new q(this));
        c0(r32);
        goto L18
    L5:
        if (r22.d == true) goto L9;
        if (r22.b != this.d) goto L9;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        Log.d("ImeWrapper", "ImeWrapper: onMeasure: height is " + getMeasuredHeight());
    }

    @Override // com.ss.android.lark.keyboard.ime.ImeCoordinator.b
    public final void r(boolean r10, final WindowInsetsCompat r11) {
        Intrinsics.checkNotNullParameter(r11, "dispatchWindowInsets");
        Log.d("ImeWrapper", "onGlobalDispatchMeasure: called");
        int r1 = WindowInsetsCompat.Type.ime();
        int r2 = WindowInsetsCompat.Type.systemBars();
        boolean r3 = r11.isVisible(r1);
        boolean r6 = false;
        if (this.n.e == r3) goto L5;
        boolean r4 = true;
    L6:
        Log.d("ImeWrapper", "unwrapIme: lastWindowInsets " + this.n.e + ", insetsImeVisible " + r3);
        int r5 = r11.getInsets(r2).bottom;
        if (CarUtils.b() == false) goto L9;
        r5 = 0;
    L9:
        int r7 = Math.max((r11.getInsets(r1).bottom - r5) - this.c, 0);
        if (r4 == true) goto L12;
        int r8 = this.d;
    L15:
        final f r9 = (f) this.t.acquire();
        if (r9 != null) goto L18;
        r9 = new f();
    L18:
        r9.a = r8;
        r9.b = r7;
        r9.d = r4;
        r9.e = r3;
        r9.c = r5;
        r9.f = r10;
        com.ss.android.lark.keyboard.ime.b r12 = com.ss.android.lark.keyboard.ime.b.a;
        Function0<String> r13 = new ImeWrapper$onGlobalDispatchInsets$1(r9, r11, this);
        r12.getClass();
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r13);
        List<g> r14 = this.k;
        if ((r14 instanceof Collection) == true) goto L21;
    L23:
        Iterator r15 = ((ArrayList) r14).iterator();
    L25:
        if (r15.hasNext() == false) goto L29;
        if ((!((g) r15.next()).r(r9)) == true) goto L25;
    L30:
        if (r6 == false) goto L32;
        S(r9, true);
    L32:
        this.t.release(r9);
        return;
    L29:
        r6 = true;
        goto L30
    L21:
        if (((ArrayList) r14).isEmpty() == false) goto L23;
    L12:
        if (r3 == false) goto L14;
        r8 = 0;
        goto L15
    L14:
        r8 = this.d;
        r7 = 0;
        goto L15
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void u(int r1, boolean r2) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.h = r1;
        this.l = r2;
        this.s.setExpectHeight(r1);
        if (B() == false) goto L8;
        setHeightInner(this.h);
        U(this.h);
        return;
    }

    public ImeWrapper(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = r4;
        this.b = LarkKVStorage.h(new com.ss.android.lark.storage.a("lark:im:keyboard"), true);
        int r7 = s.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        this.e = UIUtils.dp2px(r4, 200.0f);
        this.f = new ImeWrapper$maxPanelHeightProvider$1(this);
        int r8 = getInitialImeHeight();
        this.g = r8;
        this.h = r8;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.n = new f();
        d r9 = new d();
        this.o = r9;
        LinkedHashMap r0 = new LinkedHashMap();
        this.p = r0;
        this.q = new ImeAnimControllerImpl(this);
        this.r = true;
        h r10 = new h(r4, this);
        r10.setVisibility(4);
        r10.setExpectHeight(this.h);
        this.s = r10;
        this.t = new Pools.SimplePool(3);
        ImeStateDetail r1 = ImeStateDetail.Hide;
        this.x = new j(r1);
        this.y = new j(r1);
        this.z = new LinkedHashMap();
        this.A = new CopyOnWriteArrayList();
        setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        setWillNotDraw(false);
        addView(r10, getLayoutParams());
        r0.put(Integer.valueOf(hashCode()), r9);
    }

    public static final void K(ImeWrapper r1, ValueAnimator r2, Function1 r3) {
        r1.getClass();
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = true;
        r2.addListener(new k(r4));
        r2.addListener(new l(r4, r3, r2));
    }

    public final void V(int r10, int r11, Interpolator r12) {
        Log.d("ImeWrapper", "notifyHeightChangeForAnimation: invoke");
        long r0 = getAnimDuration();
        Iterator<T> r8 = this.j.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((e) r8.next()).n(r10, r11, r0, r12);
        goto L4
    }

    public /* synthetic */ ImeWrapper(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void a0(final ImeWrapper r1, final int r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        r1.getClass();
        Log.i("ImeWrapper", "panelExit: prepare. form: " + r1.h + ", to: " + r2 + " , panelTransform: " + r1.getPanelState() + " -> " + ImeStateDetail.Exit);
        Iterator<Animator> r5 = r1.A.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r5.next().cancel();
        goto L10
    L12:
        if (r3 == false) goto L14;
        r1.V(r1.h, r2, r1.getAnimInterpolator());
        r1.X();
    L14:
        r1.c0(b0(r1, r1.h, r2, new ImeWrapper$playExitAnim$1(r1, r2)));
    }

    public static ValueAnimator b0(final ImeWrapper r8, final int r9, final int r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(B, "<this>");
        final int r7 = 2;
        r8.getClass();
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r0.setDuration(r8.getAnimDuration());
        r0.setInterpolator(r8.getAnimInterpolator());
        final int r6 = Math.max(r9, r10);
        Function1<Float, Unit> r1 = new ImeWrapper$preparePanelAnimator$2$onAnimationUpdate$1(r10, r9, r8, r6, r7);
        Intrinsics.checkNotNull(r0);
        r0.addListener(new o(r8, r1));
        r0.addUpdateListener(new m(r1));
        r0.addListener(new n(r8, r1, r0));
        r8.A.add(r0);
        r11.invoke(r0);
        return r0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        Log.d("ImeWrapper", "ImeWrapper: onLayout: height is " + getHeight());
    }
}
