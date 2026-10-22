package com.obric.assistant.window.component;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004bcdeB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00101\u001a\u00020)H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020)H\u0016J\u001e\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\"2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020)H\u0016J\b\u0010>\u001a\u00020)H\u0016J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\"H\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020)H\u0002J\u0012\u0010E\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010F\u001a\u00020)H\u0002J \u0010G\u001a\u0002062\u0006\u00107\u001a\u00020\"2\u0006\u00108\u001a\u0002092\u0006\u0010H\u001a\u00020$H\u0002J0\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\"2\u0006\u0010H\u001a\u00020$2\u0016\b\u0002\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J\u0010\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\"H\u0002J\u0010\u0010N\u001a\u00020)2\u0006\u0010O\u001a\u00020,H\u0002J\b\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010O\u001a\u00020,H\u0002J\u0010\u0010S\u001a\u00020)2\u0006\u0010O\u001a\u00020,H\u0002J\n\u0010T\u001a\u0004\u0018\u000100H\u0002J \u0010U\u001a\u00020)2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u0002002\u0006\u0010\u001c\u001a\u000200H\u0002J\u0010\u0010X\u001a\u00020Y2\u0006\u0010V\u001a\u00020\u001dH\u0002J\b\u0010Z\u001a\u00020)H\u0002J.\u0010[\u001a\u00020)2\b\u0010\\\u001a\u0004\u0018\u00010.2\b\u0010]\u001a\u0004\u0018\u00010.2\u0006\u0010O\u001a\u00020,2\b\u0010^\u001a\u0004\u0018\u00010QH\u0002J \u0010_\u001a\u00020`2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u0002002\u0006\u0010\u001c\u001a\u000200H\u0002J\u0018\u0010a\u001a\u00020,2\u0006\u0010J\u001a\u00020\"2\u0006\u0010H\u001a\u00020$H\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/obric/assistant/window/component/WindowDimComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "obricChatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getObricChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "obricChatPageStateAbility$delegate", "Lkotlin/Lazy;", "windowBottomBlurAbility", "Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "getWindowBottomBlurAbility", "()Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "windowBottomBlurAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "isWindowVisible", "", "backgroundDimScene", "Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimScene;", "backgroundDimAnimationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "activeBackgroundDimAnimationEnd", "Lkotlin/Function1;", "", "isWindowDimAnimatorRunning", "currentBackgroundDimAlpha", "", "lastAppliedDimTarget", "Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimTarget;", "backgroundDimView", "Landroid/view/View;", "onCreate", "onDestroy", "onParentViewCreated", "getWindowAnimators", "", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "isShow", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "onWindowDismissed", "onChatStyleChanged", "isChatWindow", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "syncBackgroundDimState", "updateBackgroundDimSceneIfNeeded", "resetBackgroundDimScene", "getBackgroundDimAnimator", "scene", "startBackgroundDimAnimation", "visible", "onEnd", "cancelBackgroundDimAnimation", "notifyEnd", "applyBackgroundDimAlpha", "alpha", "resolveBackgroundDimTargetInfo", "Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimTargetInfo;", "applyWindowBackgroundDimAlpha", "applyViewBackgroundDimAlpha", "ensureBackgroundDimView", "ensureBackgroundDimViewOrder", "parent", "dimView", "createBackgroundDimLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "removeBackgroundDimView", "logDimTargetChanged", "previousTarget", "newTarget", "targetInfo", "getDimViewOrderLog", "", "resolveBackgroundDimAlpha", "Companion", "BackgroundDimScene", "BackgroundDimTarget", "BackgroundDimTargetInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowDimComponent extends ComponentFeature implements IWindowAnimationProvider, wga.b, hca.b {
    public static final /* synthetic */ int u = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;
    public BackgroundDimScene n;
    public fja.d o;
    public Function1<? super Boolean, Unit> p;
    public boolean q;
    public float r;
    public BackgroundDimTarget s;
    public View t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimScene;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Window", "HalfScreen", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundDimScene extends Enum<BackgroundDimScene> {
        public static final BackgroundDimScene HalfScreen = null;
        public static final BackgroundDimScene None = null;
        public static final BackgroundDimScene Window = null;
        public static final /* synthetic */ BackgroundDimScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BackgroundDimScene> getEntries() {
            return b;
        }

        static {
            BackgroundDimScene r0 = new BackgroundDimScene("None", 0);
            None = r0;
            BackgroundDimScene r1 = new BackgroundDimScene("Window", 1);
            Window = r1;
            BackgroundDimScene r3 = new BackgroundDimScene("HalfScreen", 2);
            HalfScreen = r3;
            BackgroundDimScene[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static BackgroundDimScene[] values() {
            return (BackgroundDimScene[]) a.clone();
        }

        public static BackgroundDimScene valueOf(String r1) {
            return (BackgroundDimScene) r27.a.a(BackgroundDimScene.class, r1);
        }

        public BackgroundDimScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/window/component/WindowDimComponent$BackgroundDimTarget;", "", "<init>", "(Ljava/lang/String;I)V", "ViewLayer", "Window", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundDimTarget extends Enum<BackgroundDimTarget> {
        public static final BackgroundDimTarget ViewLayer = null;
        public static final BackgroundDimTarget Window = null;
        public static final /* synthetic */ BackgroundDimTarget[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BackgroundDimTarget> getEntries() {
            return b;
        }

        static {
            BackgroundDimTarget r0 = new BackgroundDimTarget("ViewLayer", 0);
            ViewLayer = r0;
            BackgroundDimTarget r1 = new BackgroundDimTarget("Window", 1);
            Window = r1;
            BackgroundDimTarget[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static BackgroundDimTarget[] values() {
            return (BackgroundDimTarget[]) a.clone();
        }

        public static BackgroundDimTarget valueOf(String r1) {
            return (BackgroundDimTarget) r27.a.a(BackgroundDimTarget.class, r1);
        }

        public BackgroundDimTarget(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final BackgroundDimTarget a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "BackgroundDimTargetInfo(target=" + this.a + ", isLandscapeWindow=" + this.b + ", hasLayoutInfo=" + this.c + ')';
        }

        public a(BackgroundDimTarget r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BackgroundDimTarget.values().length];
            r0[BackgroundDimTarget.ViewLayer.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[BackgroundDimTarget.Window.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[BackgroundDimScene.values().length];
            r1[BackgroundDimScene.Window.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[BackgroundDimScene.HalfScreen.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[BackgroundDimScene.None.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class d implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class e implements Function0<xha.f> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.f.class));
        }
    }

    public static final class f implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    static {
    }

    public final void onScreenRotationChanged(int r1, int r2) {
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void onWindowPreStashed() {
    }

    public static a p3() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L5;
        WindowLayoutInfo r1 = r0.getWindowLayoutInfo();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        BackgroundDimTarget r4 = BackgroundDimTarget.Window;
    L16:
        if (r1 == null) goto L19;
        r2 = true;
    L19:
        return new a(r4, r3, r2);
    L14:
        r4 = BackgroundDimTarget.ViewLayer;
        goto L16
    L9:
        if (r1.isLandscapeWindowLayout() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void B2() {
        FLogger.a.i("WindowDimComponent", "onParentViewCreated: visible=" + this.m + ", scene=" + this.n + ", currentAlpha=" + this.r);
    }

    public final void B3() {
        laa.d r0 = (laa.d) this.h.getValue();
        if (r0 == null) goto L5;
        ObricFloatChatPageState r1 = r0.getPageState();
    L6:
        FLogger.a.i("WindowDimComponent", "syncBackgroundDimState: pageState=" + r1);
        C3(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void h3() {
        BackgroundDimScene r0 = this.n;
        BackgroundDimScene r1 = BackgroundDimScene.None;
        if (r0 == r1) goto L5;
        FLogger.a.i("WindowDimComponent", "resetBackgroundDimScene: " + this.n + " -> " + r1);
    L5:
        this.n = r1;
    }

    public final void onCreate() {
        FLogger.a.i("WindowDimComponent", "onCreate: register dim animation provider, lifecycle and page state callbacks");
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L5;
        r0.addWindowAnimationCreator(this);
    L5:
        IAssistantChatWindow r1 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r1 == null) goto L8;
        r1.addWindowLifecycleListener(this);
    L8:
        laa.d r2 = (laa.d) this.h.getValue();
        if (r2 == null) goto L12;
        r2.HU(this);
        return;
    }

    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDestroy: currentAlpha=");
        r1.append(this.r);
        r1.append(", lastTarget=");
        r1.append(this.s);
        r1.append(", hasDimView=");
        if (this.t == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("WindowDimComponent", r1.toString());
        IAssistantChatWindow r3 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r3 == null) goto L9;
        r3.removeWindowAnimationCreator(this);
    L9:
        IAssistantChatWindow r4 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r4 == null) goto L12;
        r4.removeWindowLifecycleListener(this);
    L12:
        laa.d r5 = (laa.d) this.h.getValue();
        if (r5 == null) goto L15;
        r5.AN(this);
    L15:
        P2(false);
        F2(0.0f);
        View r6 = this.t;
        if (r6 == null) goto L26;
        r0.i("WindowDimComponent", "removeBackgroundDimView: parent=" + r6.getParent());
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L21;
        ViewGroup r8 = (ViewGroup) r7;
    L22:
        if (r8 == null) goto L24;
        r8.removeView(r6);
    L24:
        this.t = null;
        return;
    L21:
        r8 = null;
        goto L22
    L26:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void onWindowDismissed() {
        FLogger.a.i("WindowDimComponent", "onWindowDismissed: clear dim");
        this.m = false;
        h3();
        P2(true);
        this.r = 0.0f;
        F2(0.0f);
    }

    public final void onWindowStashed() {
        FLogger.a.i("WindowDimComponent", "onWindowStashed: hide dim");
        this.m = false;
        h3();
    }

    public WindowDimComponent() {
        this.h = LazyKt.lazy(new d(this));
        this.i = LazyKt.lazy(new e(this));
        this.j = LazyKt.lazy(new f(this));
        this.k = LazyKt.lazy(new i0(this));
        this.l = LazyKt.lazy(new j0(this));
        this.n = BackgroundDimScene.None;
    }

    public static void N2(float r2) {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.updateBackgroundDimAmount(r2);
        return;
    }

    public final boolean C3(ObricFloatChatPageState r7) {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        r0.getClass();
        if ((r7 instanceof vda.a) == false) goto L5;
        BackgroundDimScene r1 = BackgroundDimScene.Window;
    L18:
        if (r1 != null) goto L20;
        return false;
    L20:
        BackgroundDimScene r2 = this.n;
        if (r2 == r1) goto L23;
        FLogger.a.i("WindowDimComponent", "updateBackgroundDimSceneIfNeeded: " + r2 + " -> " + r1 + ", pageState=" + r7);
    L23:
        this.n = r1;
        if (r2 == r1) goto L27;
        return true;
    L27:
        return false;
    L5:
        r0.getClass();
        if ((r7 instanceof vda.e) == true) goto L16;
        r0.getClass();
        if ((r7 instanceof vda.d) == true) goto L16;
        r0.getClass();
        if ((r7 instanceof vda.f) == true) goto L16;
        r0.getClass();
        if ((r7 instanceof vda.b) == false) goto L15;
        r1 = BackgroundDimScene.None;
        goto L18
    L15:
        r1 = null;
    L16:
        r1 = BackgroundDimScene.HalfScreen;
        goto L18
    }

    public final void F2(float r6) {
        if (r6 > 0.001f) goto L5;
        float r7 = 0.0f;
    L6:
        this.r = r7;
        if (r7 != 0.0f) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L16;
        BackgroundDimTarget r0 = this.s;
        if (r0 == null) goto L14;
        this.s = null;
        Y2(r0, null, r7, null);
    L14:
        N2(0.0f);
        L2(0.0f);
        return;
    L16:
        a r3 = p3();
        BackgroundDimTarget r4 = this.s;
        BackgroundDimTarget r5 = r3.a;
        if (r4 == r5) goto L19;
        this.s = r5;
        Y2(r4, r5, r7, r3);
    L19:
        BackgroundDimTarget r8 = r3.a;
        int r9 = c.a[r8.ordinal()];
        if (r9 != 1) goto L22;
        N2(0.0f);
        L2(r7);
        return;
    L22:
        if (r9 != 2) goto L25;
        L2(0.0f);
        N2(r7);
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L9:
        r2 = false;
        goto L10
    L5:
        r7 = RangesKt.coerceIn(r6, 0.0f, 1.0f);
        goto L6
    }

    public final void L2(float r15) {
        if (r15 > 0.001f) goto L5;
        float r16 = 0.0f;
    L6:
        boolean r3 = true;
        if (r16 <= 0.0f) goto L47;
        ViewGroup r6 = (ViewGroup) this.l.getValue();
        Integer r7 = null;
        View r8 = null;
        r8 = null;
        if (r6 != null) goto L11;
        FLogger.a.w("WindowDimComponent", "ensureBackgroundDimView: chatRoot is null");
    L48:
        if (r8 != null) goto L50;
        return;
    L50:
        if (r16 <= 0.0f) goto L55;
        if (r8.getVisibility() == 0) goto L55;
        FLogger.a.i("WindowDimComponent", "applyViewBackgroundDimAlpha: show dim view, alpha=" + r16);
        r8.setVisibility(0);
    L55:
        if (r16 != 0.0f) goto L57;
        boolean r5 = true;
    L58:
        if (r5 == true) goto L60;
    L71:
        r8.setAlpha(r16);
        return;
    L60:
        if (r8.getVisibility() == 8) goto L62;
    L68:
        if (r3 == false) goto L70;
        FLogger.a.i("WindowDimComponent", "applyViewBackgroundDimAlpha: hide dim view");
    L70:
        r8.setVisibility(8);
        goto L71
    L62:
        if (r8.getAlpha() != 0.0f) goto L64;
        boolean r1 = true;
    L65:
        if (r1 == false) goto L68;
        r3 = false;
        goto L68
    L64:
        r1 = false;
        goto L65
    L57:
        r5 = false;
        goto L58
    L11:
        ViewParent r9 = r6.getParent();
        if ((r9 instanceof ViewGroup) == false) goto L14;
        ViewGroup r10 = (ViewGroup) r9;
    L15:
        if (r10 != null) goto L17;
        FLogger.a.w("WindowDimComponent", "ensureBackgroundDimView: chatRoot parent is null");
        goto L48
    L17:
        View r11 = this.t;
        if (r11 != null) goto L21;
        r11 = new View(getContext());
        r11.setBackgroundColor(-16777216);
        r11.setAlpha(0.0f);
        r11.setVisibility(8);
        r11.setClickable(false);
        r11.setImportantForAccessibility(2);
        FLogger.a.i("WindowDimComponent", "ensureBackgroundDimView: create dim view");
        this.t = r11;
    L21:
        if (Intrinsics.areEqual(r11.getParent(), r10) == false) goto L24;
        U2(r10, r11, r6);
    L23:
        r8 = r11;
        goto L48
    L24:
        ViewParent r12 = r11.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L27;
        ViewGroup r13 = (ViewGroup) r12;
    L28:
        if (r13 == null) goto L30;
        FLogger.a.i("WindowDimComponent", "ensureBackgroundDimView: remove dim view from old parent=" + r13);
        r13.removeView(r11);
    L30:
        Integer r14 = Integer.valueOf(r10.indexOfChild(r6));
        if (r14.intValue() < 0) goto L33;
        boolean r17 = true;
    L34:
        if (r17 == false) goto L36;
        r7 = r14;
    L36:
        if (r7 == null) goto L38;
        int r18 = r7.intValue();
    L40:
        if ((r10 instanceof FrameLayout) == false) goto L43;
        ViewGroup.LayoutParams r19 = new FrameLayout.LayoutParams(-1, -1);
    L46:
        r10.addView(r11, r18, r19);
        U2(r10, r11, r6);
        FLogger.a.i("WindowDimComponent", "ensureBackgroundDimView: add dim view, parent=" + r10 + ", requestIndex=" + r18 + ", " + X2(r10, r11, r6));
        goto L23
    L43:
        if ((r10 instanceof ConstraintLayout) == false) goto L45;
        r19 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r19).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r19).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r19).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r19).bottomToBottom = 0;
        goto L46
    L45:
        r19 = new ViewGroup.LayoutParams(-1, -1);
        goto L46
    L38:
        r18 = r10.getChildCount();
        goto L40
    L33:
        r17 = false;
        goto L34
    L27:
        r13 = null;
        goto L28
    L14:
        r10 = null;
        goto L15
    L47:
        r8 = this.t;
        goto L48
    L5:
        r16 = RangesKt.coerceIn(r15, 0.0f, 1.0f);
        goto L6
    }

    public final void P2(boolean r6) {
        Function1<? super Boolean, Unit> r0 = this.p;
        this.p = null;
        fja.d r2 = this.o;
        if (r2 == null) goto L5;
        int r4 = fja.d.d;
        r2.a(false);
    L5:
        this.o = null;
        this.q = false;
        if (r6 == false) goto L10;
        if (r0 == null) goto L11;
        r0.invoke(Boolean.FALSE);
        return;
    L11:
        return;
    }

    public final void onWindowOpened(WindowOpenSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger.a.i("WindowDimComponent", "onWindowOpened: source=" + r4);
        B3();
    }

    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final void r2(boolean r4) {
        FLogger.a.i("WindowDimComponent", "onChatStyleChanged: isChatWindow=" + r4 + ", keep dim scene=" + this.n);
    }

    public final void x1(ObricFloatChatPageState r3) {
        Intrinsics.checkNotNullParameter(r3, "pageState");
        boolean r4 = C3(r3);
        if (this.m == false) goto L8;
        if (r4 == false) goto L8;
        if (this.q == true) goto L8;
        z3(true, this.n, null);
        return;
    L8:
        F2(this.r);
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider
    public final List<IWindowAnimator> getWindowAnimators(boolean r4, WindowAnimationType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (r4 == false) goto L5;
        B3();
    L5:
        FLogger.a.i("WindowDimComponent", "getWindowAnimators: isShow=" + r4 + ", type=" + r5 + ", scene=" + this.n + ", currentAlpha=" + this.r);
        return CollectionsKt.listOf(new l0(r4, r5, this.n, this));
    }

    public final float m3(boolean r3, BackgroundDimScene r4) {
        if (r3 == true) goto L5;
        return 0.0f;
    L5:
        boolean r5 = v19.h.a;
        boolean r6 = v19.h.b(getContext());
        int r7 = c.b[r4.ordinal()];
        if (r7 != 1) goto L8;
        if (r6 == false) goto L19;
        return 0.3f;
    L19:
        return 0.16f;
    L8:
        if (r7 != 2) goto L10;
        if (r6 == false) goto L16;
        return 0.6f;
    L16:
        return 0.32f;
    L10:
        if (r7 != 3) goto L13;
        return 0.0f;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void U2(ViewGroup r11, View r12, View r13) {
        int r0 = r11.indexOfChild(r12);
        if (r0 >= 0) goto L5;
        return;
    L5:
        xha.f r1 = (xha.f) this.i.getValue();
        ViewParent r2 = null;
        if (r1 == null) goto L8;
        com.obric.assistant.view.n r3 = r1.Bu();
    L9:
        if (r3 == null) goto L11;
        ViewParent r4 = r3.getParent();
    L12:
        int r5 = -1;
        if (Intrinsics.areEqual(r4, r11) == false) goto L15;
        int r6 = r11.indexOfChild(r3);
    L16:
        int r7 = r11.indexOfChild(r13);
        if (r6 < 0) goto L21;
        if (r0 > r6) goto L21;
        boolean r8 = false;
    L22:
        if (r7 < 0) goto L26;
        if (r0 < r7) goto L26;
        boolean r9 = false;
    L27:
        if (r8 == false) goto L30;
        if (r9 == false) goto L30;
        return;
    L30:
        ViewGroup.LayoutParams r10 = r12.getLayoutParams();
        r11.removeView(r12);
        int r14 = r11.indexOfChild(r13);
        if (r3 == null) goto L34;
        r2 = r3.getParent();
    L34:
        if (Intrinsics.areEqual(r2, r11) == false) goto L36;
        r5 = r11.indexOfChild(r3);
    L36:
        if (r14 < 0) goto L40;
        if (r5 < 0) goto L45;
        if (r14 <= r5) goto L40;
    L45:
        int r15 = RangesKt.coerceIn(r14, 0, r11.getChildCount());
        r11.addView(r12, r15, r10);
        FLogger.a.i("WindowDimComponent", "ensureBackgroundDimViewOrder: move dim view, dimIndex=" + r0 + ", blurIndex=" + r6 + ", chatRootIndex=" + r7 + ", targetIndex=" + r15 + ", " + X2(r11, r12, r13));
        return;
    L40:
        if (r5 < 0) goto L42;
        r14 = r5 + 1;
        goto L45
    L42:
        if (r14 >= 0) goto L45;
        r14 = r11.getChildCount();
    L26:
        r9 = true;
    L21:
        r8 = true;
        goto L22
    L15:
        r6 = -1;
        goto L16
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public final String X2(ViewGroup r4, View r5, View r6) {
        xha.f r0 = (xha.f) this.i.getValue();
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        com.obric.assistant.view.n r2 = r0.Bu();
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getParent();
    L9:
        if (Intrinsics.areEqual(r1, r4) == false) goto L11;
        int r3 = r4.indexOfChild(r2);
    L13:
        return "childCount=" + r4.getChildCount() + ", dimIndex=" + r4.indexOfChild(r5) + ", blurIndex=" + r3 + ", chatRootIndex=" + r4.indexOfChild(r6);
    L11:
        r3 = -1;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void z3(final boolean r10, final BackgroundDimScene r11, Function1<? super Boolean, Unit> r12) {
        final float r0 = m3(r10, r11);
        final float r1 = this.r;
        if (r0 <= 0.0f) goto L5;
        a r4 = p3();
    L6:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("startBackgroundDimAnimation, visible=");
        r6.append(r10);
        r6.append(", scene=");
        r6.append(r11);
        r6.append(", startAlpha=");
        r6.append(r1);
        r6.append(", targetAlpha=");
        r6.append(r0);
        r6.append(", currentDimTarget=");
        r6.append(this.s);
        r6.append(", targetDimTarget=");
        if (r4 == null) goto L9;
        BackgroundDimTarget r7 = r4.a;
    L10:
        r6.append(r7);
        r6.append(", isLandscapeWindow=");
        if (r4 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r4.b);
    L14:
        r6.append(r8);
        r6.append(", hasLayoutInfo=");
        if (r4 == null) goto L17;
        Boolean r9 = Boolean.valueOf(r4.c);
    L18:
        r6.append(r9);
        r5.i("WindowDimComponent", r6.toString());
        boolean r13 = true;
        if (r1 != r0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L27;
        r5.i("WindowDimComponent", "startBackgroundDimAnimation: skip, startAlpha == targetAlpha");
        F2(r0);
        this.p = null;
        this.q = false;
        if (r12 == null) goto L33;
        r12.invoke(Boolean.TRUE);
        return;
    L33:
        return;
    L27:
        P2(true);
        this.p = r12;
        if (r12 != null) goto L31;
        r13 = false;
    L31:
        this.q = r13;
        F2(r1);
        com.obric.common.oea.foundation.animation.builder.d.a r15 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r15.b(0.0f, 1.0f, gja.b.d(Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null);
        Function3<? super String, Object, Object, Unit> r2 = new g0(this, r1, r0);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r15.d = r2;
        Function2<? super Boolean, ? super Throwable, Unit> r3 = new h0(r10, r11, this, r0);
        Intrinsics.checkNotNullParameter(r3, "callback");
        r15.e = r3;
        this.o = r15.a().a();
        return;
    L21:
        r14 = false;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void Y2(BackgroundDimTarget r4, BackgroundDimTarget r5, float r6, a r7) {
        if (r4 != r5) goto L4;
        return;
    L4:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("DimTarget changed: ");
        r1.append(r4);
        r1.append(" -> ");
        r1.append(r5);
        r1.append(", alpha=");
        r1.append(r6);
        r1.append(", visible=");
        r1.append(this.m);
        r1.append(", scene=");
        r1.append(this.n);
        r1.append(", isLandscapeWindow=");
        Boolean r8 = null;
        if (r7 == null) goto L7;
        Boolean r9 = Boolean.valueOf(r7.b);
    L8:
        r1.append(r9);
        r1.append(", hasLayoutInfo=");
        if (r7 == null) goto L11;
        r8 = Boolean.valueOf(r7.c);
    L11:
        r1.append(r8);
        r0.i("WindowDimComponent", r1.toString());
        return;
    L7:
        r9 = null;
        goto L8
    }
}
