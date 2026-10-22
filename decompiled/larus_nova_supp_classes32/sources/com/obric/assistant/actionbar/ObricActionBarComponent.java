package com.obric.assistant.actionbar;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.data.ObricFloatChatPageState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import qha.m;
import v19.c7;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u000203H\u0016J\b\u00107\u001a\u000203H\u0016J\u0016\u00108\u001a\u0002032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u00109\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\b\u0010:\u001a\u000203H\u0016J\u0010\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000203H\u0002J\u0010\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020=H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006B"}, d2 = {"Lcom/obric/assistant/actionbar/ObricActionBarComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/IObricActionBarAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "Lkotlin/Lazy;", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "Landroid/view/ViewGroup;", "getActionBarContainer", "()Landroid/view/ViewGroup;", "customActionBarView", "Landroidx/recyclerview/widget/RecyclerView;", "getCustomActionBarView", "()Landroidx/recyclerview/widget/RecyclerView;", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "actionBarList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "portraitActionBarStrategy", "Lcom/obric/assistant/window/strategies/PortraitActionBarStrategy;", "getPortraitActionBarStrategy", "()Lcom/obric/assistant/window/strategies/PortraitActionBarStrategy;", "portraitActionBarStrategy$delegate", "landscapeActionBarStrategy", "Lcom/obric/assistant/window/strategies/LandscapeActionBarStrategy;", "getLandscapeActionBarStrategy", "()Lcom/obric/assistant/window/strategies/LandscapeActionBarStrategy;", "landscapeActionBarStrategy$delegate", "strategy", "Lcom/obric/assistant/window/strategies/api/BaseActionBarStrategy;", "getStrategy", "()Lcom/obric/assistant/window/strategies/api/BaseActionBarStrategy;", "obricTaskPosition", NameKeys.UnloadStrategy_No_Strategy, "getObricTaskPosition", "()I", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "onStop", "onDestroy", "onParentViewCreated", "updateActionBar", "setActionBarList", "getActionBarList", "onSpecialOpen", "onInputAboveLayoutVisibleChange", LynxUIOverlay.PROP_VISIBLE, NameKeys.UnloadStrategy_No_Strategy, "updateActionBarView", "onChatStyleChanged", "isChatWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarComponent extends ComponentFeature implements laa.b, hca.b {
    public static final /* synthetic */ int m = 0;
    public final Lazy h;
    public final Lazy i;
    public List<? extends qha.e> j;
    public final Lazy k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class c implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    static {
    }

    public final void B2() {
        FLogger.a.i("ObricActionBarComponent", "onParentViewCreated " + hashCode());
        if (s1a.a.e(this) == false) goto L23;
        com.larus.bmhome.chat.component.bottom.core.a r0 = F2();
        RecyclerView r1 = null;
        if (r0 == null) goto L7;
        GradientMaskView r2 = r0.a();
    L8:
        if (r2 == null) goto L14;
        int r3 = aia.b.a;
        r2.setPadding(c7.b(4), r2.getPaddingTop(), 0, r2.getPaddingBottom());
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 == null) goto L13;
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        ((ViewGroup.MarginLayoutParams) r5).topMargin = 0;
        r2.setLayoutParams(r5);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L14:
        com.larus.bmhome.chat.component.bottom.core.a r6 = F2();
        if (r6 == null) goto L17;
        r1 = r6.d();
    L17:
        if (r1 == null) goto L21;
        ViewGroup.LayoutParams r7 = r1.getLayoutParams();
        if (r7 == null) goto L21;
        int r8 = aia.b.a;
        r7.height = c7.b(34);
    L21:
        N2().a();
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final va8.c F2() {
        o r0 = (o) this.h.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public final int L2() {
        List<? extends qha.e> r0 = this.j;
        if (r0 == null) goto L16;
        IntRange r1 = CollectionsKt.getIndices(r0);
        if (r1 == null) goto L21;
        IntIterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L22;
        int r3 = r2.nextInt();
        List<? extends qha.e> r4 = this.j;
        if (r4 == null) goto L12;
        qha.e r5 = (qha.e) ListProtector.get(r4, r3);
    L14:
        if ((r5 instanceof m) == false) goto L8;
        return r3;
    L12:
        r5 = null;
        goto L14
    L22:
        return 0;
    L21:
        return 0;
    L16:
        return 0;
    }

    public final void onCreate() {
        FLogger.a.i("ObricActionBarComponent", "onCreate " + hashCode());
        laa.d r0 = (laa.d) this.i.getValue();
        if (r0 == null) goto L6;
        r0.HU(this);
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("ObricActionBarComponent", "onDestroy " + hashCode());
        if (s1a.a.e(this) == false) goto L5;
        XQ(false);
    L5:
        laa.d r0 = (laa.d) this.i.getValue();
        if (r0 == null) goto L9;
        r0.AN(this);
        return;
    }

    public final void onStop() {
        FLogger r0 = FLogger.a;
        r0.i("ObricActionBarComponent", "onStop " + hashCode());
        if (s1a.a.e(this) == false) goto L15;
        eia.e r1 = N2();
        r1.getClass();
        r0.i("BaseActionBarStrategy", "resetConfig enable: true");
        ICoreInputAbility r2 = (ICoreInputAbility) r1.d.getValue();
        if (r2 == null) goto L9;
        CoreInputAbility r3 = r2.JO();
        if (r3 == null) goto L9;
        r3.w9(true);
    L9:
        ICoreInputAbility r4 = (ICoreInputAbility) r1.d.getValue();
        if (r4 == null) goto L16;
        CoreInputAbility r5 = r4.JO();
        if (r5 == null) goto L17;
        r5.n9(false);
        return;
    L17:
        return;
    L16:
        return;
    }

    public ObricActionBarComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.k = LazyKt.lazy(new g(this));
        this.l = LazyKt.lazy(new h(this));
    }

    @Override // laa.b
    public final void AP() {
        if (s1a.a.e(this) == false) goto L6;
        N2().g();
        return;
    }

    public final eia.e N2() {
        if (s1a.a.d(this) == false) goto L6;
        return (dia.a) this.l.getValue();
    L6:
        return (dia.e) this.k.getValue();
    }

    @Override // laa.b
    public final void dI() {
        va8.c r0 = F2();
        if (r0 == null) goto L12;
        Integer r1 = r0.k();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.intValue() < (L2() + 1)) goto L14;
        va8.c r2 = F2();
        if (r2 == null) goto L15;
        r2.i(L2());
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // laa.b
    public final List<qha.e> i30() {
        return this.j;
    }

    @Override // laa.b
    public final void XQ(boolean r2) {
        if (s1a.a.e(this) == false) goto L6;
        N2().f(r2);
        return;
    }

    @Override // laa.b
    public final void Zw(List<? extends qha.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "actionBarList");
        this.j = r2;
        va8.c r3 = F2();
        if (r3 == null) goto L12;
        Integer r4 = r3.k();
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.intValue() < (L2() + 1)) goto L14;
        va8.c r5 = F2();
        if (r5 == null) goto L15;
        r5.i(L2());
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void r2(boolean r1) {
        if (s1a.a.e(this) == false) goto L6;
        N2().a();
        return;
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
    }
}
