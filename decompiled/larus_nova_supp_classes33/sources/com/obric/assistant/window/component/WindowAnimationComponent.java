package com.obric.assistant.window.component;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.component.ObricIntercomComponent;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0018\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00102\u001a\u00020&H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/assistant/window/component/WindowAnimationComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "Lcom/obric/assistant/window/ability/IWindowSlideAnimationStateAbility;", "<init>", "()V", "windowBottomBlurAbility", "Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "getWindowBottomBlurAbility", "()Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "windowBottomBlurAbility$delegate", "Lkotlin/Lazy;", "obricChatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getObricChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "obricChatPageStateAbility$delegate", "intercomAbility", "Lcom/obric/assistant/component/ObricIntercomComponent;", "getIntercomAbility", "()Lcom/obric/assistant/component/ObricIntercomComponent;", "intercomAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "isSlideAnimationRunning", "", "onCreate", "", "onDestroy", "getWindowAnimators", "", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "isShow", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "getBottomBlurAnimator", "getChatRootAnimator", "shouldSkipChatRootSlideForLandscape", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowAnimationComponent extends ComponentFeature implements IWindowAnimationProvider, xha.g {
    public static final /* synthetic */ int o = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public boolean n;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WindowAnimationType.values().length];
            r0[WindowAnimationType.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[WindowAnimationType.Fade.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[WindowAnimationType.AiKeyOverlayFade.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[WindowAnimationType.Slide.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Function0<xha.f> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class e implements Function0<ObricIntercomComponent> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ObricIntercomComponent.class));
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

    public final void onCreate() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.addWindowAnimationCreator(this);
        return;
    }

    public final void onDestroy() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.removeWindowAnimationCreator(this);
        return;
    }

    public WindowAnimationComponent() {
        this.h = LazyKt.lazy(new c(this));
        this.i = LazyKt.lazy(new d(this));
        this.j = LazyKt.lazy(new e(this));
        this.k = LazyKt.lazy(new f(this));
        this.l = LazyKt.lazy(new q(this));
        this.m = LazyKt.lazy(new r(this));
    }

    @Override // xha.g
    public final boolean Kq() {
        return this.n;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider
    public final List<IWindowAnimator> getWindowAnimators(boolean r8, WindowAnimationType r9) {
        Intrinsics.checkNotNullParameter(r9, "type");
        FLogger r0 = FLogger.a;
        r0.i("WindowAnimationComponent", "getWindowAnimators, isShow is " + r8 + ", type is " + r9);
        IWindowAnimator[] r3 = new IWindowAnimator[2];
        IWindowAnimator r4 = new d0(this, r9, r8);
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L5;
        r0.i("WindowAnimationComponent", "network not available");
    L18:
        r3[0] = r4;
        if (r8 == false) goto L21;
        WindowAnimationType r1 = WindowAnimationType.Fade;
    L23:
        if (b.a[r1.ordinal()] != 1) goto L25;
        IWindowAnimator r2 = new s(r9, this, r8);
    L26:
        r3[1] = r2;
        return CollectionsKt.listOf(r3);
    L25:
        r2 = new v(r9, this, r8);
        goto L26
    L21:
        r1 = WindowAnimationType.None;
        goto L23
    L5:
        int r5 = b.a[r9.ordinal()];
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L9;
        r4 = new y(r9, this, r8);
        goto L18
    L9:
        if (r5 != 3) goto L11;
        r4 = new a0(r9, this, r8);
        goto L18
    L11:
        if (r5 == 4) goto L18;
        throw new NoWhenBranchMatchedException();
    L17:
        r4 = new w(r9, this, r8);
        goto L18
    }
}
