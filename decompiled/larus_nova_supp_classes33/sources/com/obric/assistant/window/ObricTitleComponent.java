package com.obric.assistant.window;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.view.WindowChatTitleAlignLeftStyle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\u0006\u0010!\u001a\u000202J\u0010\u00104\u001a\u0002022\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000202H\u0016J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u00020\"H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006;"}, d2 = {"Lcom/obric/assistant/window/ObricTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/window/ability/IObricTitleAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "chatFragmentCoreAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentCoreAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentCoreAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "titleContainer", "Landroid/widget/FrameLayout;", "getTitleContainer", "()Landroid/widget/FrameLayout;", "titleContainer$delegate", "interruptMoveAction", "", "portraitTitleStrategy", "Lcom/obric/assistant/window/strategies/PortraitTitleStrategy;", "getPortraitTitleStrategy", "()Lcom/obric/assistant/window/strategies/PortraitTitleStrategy;", "portraitTitleStrategy$delegate", "landscapeTitleStrategy", "Lcom/obric/assistant/window/strategies/LandscapeTitleStrategy;", "getLandscapeTitleStrategy", "()Lcom/obric/assistant/window/strategies/LandscapeTitleStrategy;", "landscapeTitleStrategy$delegate", "strategy", "Lcom/obric/assistant/window/strategies/api/BaseTitleStrategy;", "getStrategy", "()Lcom/obric/assistant/window/strategies/api/BaseTitleStrategy;", "onCreate", "", "onDestroy", "changeTitleAlpha", "alpha", "", "initTitle", "onChatStyleChanged", "isChatWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTitleComponent extends BaseContentWidget implements xha.d, hca.b {
    public static final /* synthetic */ int t = 0;
    public int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;

    public static final class a {
    }

    public static final class b implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
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

    public static final class c implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    @Override // xha.d
    public final void initTitle() {
        FLogger.a.i("ObricTitleComponent", "initTitle");
        FrameLayout r0 = (FrameLayout) this.q.getValue();
        if (r0 == null) goto L6;
        r0.setBackgroundColor(0);
        return;
    }

    public final void onCreate() {
        FLogger.a.i("ObricTitleComponent", "onCreate " + hashCode());
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        laa.d r0 = (laa.d) this.n.getValue();
        if (r0 == null) goto L6;
        r0.HU(this);
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("ObricTitleComponent", "onDestroy " + hashCode());
        laa.d r0 = (laa.d) this.n.getValue();
        if (r0 == null) goto L6;
        r0.AN(this);
        return;
    }

    public ObricTitleComponent() {
        this.m = 2131388843;
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new j1(this));
        this.q = LazyKt.lazy(new k1(this));
        this.r = LazyKt.lazy(new l1(this));
        this.s = LazyKt.lazy(new m1(this));
    }

    public final int U2() {
        return this.m;
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    @Override // xha.d
    public final void Y60(float r5) {
        if (s1a.a.d(this) == false) goto L5;
        eia.r r0 = (dia.d) this.s.getValue();
    L6:
        r0.getClass();
        FLogger.a.i("BaseTitleStrategy", "changeTitleAlpha: " + r5);
        com.larus.platform.api.g0 r1 = (com.larus.platform.api.g0) r0.e.getValue();
        WindowChatTitleAlignLeftStyle r2 = null;
        if (r1 == null) goto L9;
        View r3 = r1.getTitleView();
    L11:
        if ((r3 instanceof WindowChatTitleAlignLeftStyle) == false) goto L13;
        r2 = (WindowChatTitleAlignLeftStyle) r3;
    L13:
        if (r2 == null) goto L16;
        r2.y7(r5);
        return;
    L16:
        return;
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = (dia.h) this.r.getValue();
        goto L6
    }

    public final void r2(boolean r1) {
        if (s1a.a.d(this) == false) goto L5;
        eia.v r2 = (dia.d) this.s.getValue();
    L6:
        r2.a();
        return;
    L5:
        r2 = (dia.h) this.r.getValue();
        goto L6
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
    }
}
