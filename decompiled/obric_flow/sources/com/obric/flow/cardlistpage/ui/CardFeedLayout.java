package com.obric.flow.cardlistpage.ui;

import ai.j0;
import android.app.ActivityOptions;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.ai.event.MessageIndication;
import com.obric.clockwidgets.ClockWidgetConfigActivity;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.R$string;
import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import com.obric.flow.cardlistpage.ui.component.feedlist.u;
import com.obric.flow.cardlistpage.ui.component.feedlist.w;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.ControllerState;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import com.obric.flow.cardlistpage.ui.component.popupdialog.o;
import com.obric.flow.cardlistpage.ui.popup.WidgetLayer;
import com.obric.flow.cardlistpage.ui.settings.CardFeedSettingsActivity;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.material.n;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.zte.miboard.cards.AppCallbackUtils;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i2;
import kotlinx.coroutines.h0;
import obric.flow.miniappwidget.m;
import obric.flow.miniappwidget.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R0\u00106\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u0010\u0015R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010!\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010!\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010!\u001a\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/CardFeedLayout;", "Landroid/widget/FrameLayout;", "", "Lhq/h;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "useDarkStatusBarIcons", "", "setStatusColor", "(Z)V", "Lkotlin/Function1;", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Lkotlin/jvm/functions/Function1;", "getOnStatusBarAppearanceChanged", "()Lkotlin/jvm/functions/Function1;", "setOnStatusBarAppearanceChanged", "(Lkotlin/jvm/functions/Function1;)V", "onStatusBarAppearanceChanged", "Lcom/obric/flow/cardlistpage/ui/k;", "q", "Lcom/obric/flow/cardlistpage/ui/k;", "getLauncherCallback", "()Lcom/obric/flow/cardlistpage/ui/k;", "setLauncherCallback", "(Lcom/obric/flow/cardlistpage/ui/k;)V", "launcherCallback", "Lobric/flow/miniappwidget/m;", "u", "Lkotlin/Lazy;", "getMiniAppWidgetInstallStateObserver", "()Lobric/flow/miniappwidget/m;", "miniAppWidgetInstallStateObserver", "Lobric/flow/miniappwidget/q;", "v", "getMiniAppWidgetServerAliveObserver", "()Lobric/flow/miniappwidget/q;", "miniAppWidgetServerAliveObserver", "Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/p;", "G", "Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/p;", "getOverlayAnimatorComponent", "()Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/p;", "setOverlayAnimatorComponent", "(Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/p;)V", "overlayAnimatorComponent", "Lcom/obric/flow/cardlistpage/ui/component/overlayanimator/ControllerState;", "H", "getOnOverlayStateChanged", "setOnOverlayStateChanged", "onOverlayStateChanged", "Lcom/obric/flow/cardlistpage/domain/repository/b;", "J", "getRepository", "()Lcom/obric/flow/cardlistpage/domain/repository/b;", "repository", "Lfq/a;", "K", "getWidgetInfoProvider", "()Lfq/a;", "widgetInfoProvider", "Lcom/obric/flow/cardlistpage/ui/component/feedlist/u;", "L", "getFeedListOwner", "()Lcom/obric/flow/cardlistpage/ui/component/feedlist/u;", "feedListOwner", "", "U", "getMMaxFlingVelocity", "()I", "mMaxFlingVelocity", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCardFeedLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardFeedLayout.kt\ncom/obric/flow/cardlistpage/ui/CardFeedLayout\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,1575:1\n181#2,3:1576\n180#2,5:1579\n181#2,3:1584\n180#2,5:1587\n*S KotlinDebug\n*F\n+ 1 CardFeedLayout.kt\ncom/obric/flow/cardlistpage/ui/CardFeedLayout\n*L\n348#1:1576,3\n348#1:1579,5\n584#1:1584,3\n584#1:1587,5\n*E\n"})
public final class CardFeedLayout extends FrameLayout {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f11536c0 = 0;
    public final View A;
    public int B;
    public final s C;
    public final o D;
    public final l E;
    public w F;
    public p G;
    public Function1 H;
    public final com.obric.flow.cardlistpage.apm.d I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final OIconButtonFloating M;
    public final OSearchBar N;
    public final OIconButtonFloating O;
    public int P;
    public float Q;
    public boolean R;
    public int S;
    public VelocityTracker T;
    public final Lazy U;
    public float V;
    public final int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppWidgetManager f11537a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f11538a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gu.d f11539b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f11540b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final obric.flow.miniappwidget.l f11541c;
    public final RecyclerView d;
    public final FrameLayout e;
    public com.obric.flow.cardlistpage.ui.view.i f;
    public final FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kotlinx.coroutines.internal.c f11542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0 f11545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public jp.d f11549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1 f11550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f11551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.fragment.app.d f11552r;
    public final CardFeedLayout$qsbReceiver$1 s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CardFeedLayout$miniAppSystemReceiver$1 f11553t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f11554u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f11555v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WidgetLayer f11556w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.ui.component.search.i f11557x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.ui.component.floatingbtn.j f11558y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.ui.component.topgradient.b f11559z;

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.CardFeedLayout$onAttachedToWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedLayout$onAttachedToWindow$1", f = "CardFeedLayout.kt", i = {}, l = {936}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CardFeedLayout this$0;

        public AnonymousClass1(CardFeedLayout r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            i2 r12 = obric.flow.b.f20427a;
            g r13 = new g(this.this$0, 0);
            this.label = 1;
            r12.getClass();
            if (i2.k(r12, r13, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.CardFeedLayout$onAttachedToWindow$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedLayout$onAttachedToWindow$2", f = "CardFeedLayout.kt", i = {}, l = {970}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CardFeedLayout this$0;

        public AnonymousClass2(CardFeedLayout r5, Continuation<? super AnonymousClass2> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            i2 r12 = obric.flow.externalcard.a.f20437a;
            g r13 = new g(this.this$0, 1);
            this.label = 1;
            r12.getClass();
            if (i2.k(r12, r13, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @JvmOverloads
    public CardFeedLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public static final /* synthetic */ com.obric.flow.cardlistpage.domain.repository.b a(CardFeedLayout r5) {
        return r5.getRepository();
    }

    public static final /* synthetic */ fq.a b(CardFeedLayout r5) {
        return r5.getWidgetInfoProvider();
    }

    public static final void c(CardFeedLayout r5) {
        r5.q("overlay_opened", false);
        com.lynx.tasm.utils.k.r().a("enter_assistant_flow", new JSONObject());
        if (r5.i() == true) goto L5;
        r5.setStatusColor(!ym.a.h(r5.getContext()));
        return;
    L5:
        obric.flow.externalcard.a.b(false);
        r5.l();
        r5.o();
        if (r5.d == null) goto L13;
        s r10 = r5.C;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r10 = null;
    L10:
        r10.f(new com.obric.flow.cardlistpage.ui.component.feedlist.i(false, true));
        return;
    }

    public static final void d(CardFeedLayout r5) {
        r5.q("overlay_hidden", true);
        if (r5.i() == true) goto L5;
        r5.setStatusColor(!ym.a.h(r5.getContext()));
        return;
    L5:
        com.lynx.tasm.utils.k.r().a("exit_assistant_flow", new JSONObject());
        obric.flow.externalcard.a.b(true);
        o r10 = r5.D;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
        r10 = null;
    L8:
        r10.k(new com.obric.flow.cardlistpage.ui.component.popupdialog.p(false));
        r5.p();
        r5.m();
    }

    public static final /* synthetic */ void e(CardFeedLayout r5) {
        r5.setStatusColor(false);
    }

    public static final void f(CardFeedLayout r5, int r10) {
        r5.getClass();
        int r11 = RangesKt.coerceAtLeast(r10, 0) - MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        if (r5.B == r11) goto L14;
        r5.B = r11;
        r5.getFeedListOwner().f11619a.f11524c = r11;
        s r12 = r5.C;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r12 = null;
    L8:
        r12.f(new com.obric.flow.cardlistpage.ui.component.feedlist.i(false, false));
        StringBuilder r13 = new StringBuilder("updateHeaderSpacerHeight: ");
        r13.append(r11);
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.w(r13, " desc=search_bar_layout", "CardFeedLayout", "tag", "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L13;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("CardFeedLayout", r14);
        return;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    private final u getFeedListOwner() {
        return (u) this.L.getValue();
    }

    private final int getMMaxFlingVelocity() {
        return ((Number) this.U.getValue()).intValue();
    }

    private final m getMiniAppWidgetInstallStateObserver() {
        return (m) this.f11554u.getValue();
    }

    private final q getMiniAppWidgetServerAliveObserver() {
        return (q) this.f11555v.getValue();
    }

    private final com.obric.flow.cardlistpage.domain.repository.b getRepository() {
        return (com.obric.flow.cardlistpage.domain.repository.b) this.J.getValue();
    }

    private final fq.a getWidgetInfoProvider() {
        return (fq.a) this.K.getValue();
    }

    private final void setStatusColor(boolean r5) {
        Function1 r10 = this.f11550p;
        if (r10 != null) goto L5;
    L7:
        WindowInsetsController r11 = getWindowInsetsController();
        if (r11 != null) goto L10;
        return;
    L10:
        if (r5 == false) goto L12;
        int r12 = 8;
    L13:
        r11.setSystemBarsAppearance(r12, 8);
        return;
    L12:
        r12 = 0;
        goto L13
    L5:
        if (((Boolean) r10.invoke(Boolean.valueOf(r5))).booleanValue() != true) goto L7;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getKeyCode() != 4) goto L31;
        if (r5.getAction() != 1) goto L31;
        p r10 = this.G;
        if (r10 == null) goto L9;
        float r11 = r10.f11690j;
    L11:
        if (r11 <= 0.6f) goto L31;
        if (this.f11544j == false) goto L17;
        Function0 r12 = this.f11545k;
        if (r12 == null) goto L25;
        r12.invoke();
    L25:
        return true;
    L17:
        WidgetLayer r13 = this.f11556w;
        if (r13 != null) goto L20;
    L26:
        p r14 = this.G;
        if (r14 == null) goto L29;
        r14.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.d(false, true));
    L29:
        return true;
    L20:
        if (r13.c() != true) goto L26;
        o r15 = this.D;
        if (r15 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
        r15 = null;
    L24:
        r15.k(new com.obric.flow.cardlistpage.ui.component.popupdialog.p(true));
        goto L25
    L9:
        r11 = 0.0f;
    L31:
        return super.dispatchKeyEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L20;
        int r10 = r5.getActionMasked();
        if (r10 != 0) goto L6;
        this.f11538a0 = r5.getPointerId(0);
        goto L20
    L6:
        if (r10 == 1) goto L16;
        if (r10 == 5) goto L13;
        if (r10 == 6) goto L16;
    L13:
        if (r5.getPointerId(r5.getActionIndex()) == this.f11538a0) goto L20;
        return true;
    L16:
        if (r5.getPointerId(r5.getActionIndex()) == this.f11538a0) goto L20;
        return true;
    L20:
        return super.dispatchTouchEvent(r5);
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [com.obric.flow.cardlistpage.ui.CardFeedLayout$animateQsbContentAlpha$2, java.lang.Object, kotlin.jvm.internal.Lambda] */
    public final void g(final float r10, Token$Duration r11) {
        FrameLayout r5 = this.g;
        jp.d r12 = this.f11549o;
        if (r12 == null) goto L6;
        int r13 = jp.d.d;
        r12.a(false);
    L6:
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        FrameLayout r14 = null;
    L9:
        com.obric.common.oea.foundation.animation.builder.a r15 = new com.obric.common.oea.foundation.animation.builder.a(r14);
        com.obric.common.oea.foundation.animation.builder.a.a(r15);
        AnimationProperty$FloatProperty r16 = AnimationProperty$FloatProperty.ALPHA;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        r5 = null;
    L12:
        Float r17 = Float.valueOf(r5.getAlpha());
        com.obric.common.oea.foundation.animation.spec.spring.b r18 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, r11);
        r18.f11323b = 0.01f;
        Unit r19 = Unit.INSTANCE;
        r15.c(r16, r17, r10, r18, null);
        ?? r110 = new CardFeedLayout$animateQsbContentAlpha$2(this, r10);
        Intrinsics.checkNotNullParameter(r110, "callback");
        r15.e = r110;
        this.f11549o = com.obric.common.oea.foundation.animation.builder.b.a(r15.b());
        return;
    L8:
        r14 = r5;
        goto L9
    }

    public final k getLauncherCallback() {
        return this.f11551q;
    }

    public final Function1<ControllerState, Unit> getOnOverlayStateChanged() {
        return this.H;
    }

    public final Function1<Boolean, Boolean> getOnStatusBarAppearanceChanged() {
        return this.f11550p;
    }

    public final p getOverlayAnimatorComponent() {
        return this.G;
    }

    public final void h() {
        if (this.f11544j == false) goto L7;
        Function0 r5 = this.f11545k;
        if (r5 == null) goto L7;
        r5.invoke();
    L7:
        WidgetLayer r10 = this.f11556w;
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.c() != true) goto L20;
        WidgetLayer r11 = this.f11556w;
        if (r11 == null) goto L14;
        r11.b(false);
    L14:
        o r12 = this.D;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
        r12 = null;
    L17:
        r12.k(new com.obric.flow.cardlistpage.ui.component.popupdialog.p(false));
        return;
    }

    public final boolean i() {
        return getContext().getApplicationContext().getSharedPreferences("card_feed_prefs", 0).getBoolean("privacy_statement_agreed", false);
    }

    public final void j() {
        if (this.f11546l == true) goto L5;
        return;
    L5:
        removeCallbacks(this.f11552r);
        this.f11547m = false;
        this.f11546l = false;
        com.obric.flow.cardlistpage.ui.component.search.i r5 = this.f11557x;     // Catch: Exception -> L9
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchComponent");     // Catch: Exception -> L9
        r5 = null;
    L11:
        r5.f(com.obric.flow.cardlistpage.ui.component.search.b.f11753a);     // Catch: Exception -> L9
        com.obric.flow.cardlistpage.ui.component.floatingbtn.j r10 = this.f11558y;     // Catch: Exception -> L9
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("floatingBtnComponent");     // Catch: Exception -> L9
        r10 = null;
    L14:
        r10.f(com.obric.flow.cardlistpage.ui.component.floatingbtn.d.f11633a);     // Catch: Exception -> L9
        g(1.0f, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("onSearchActivityFinish error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L21;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", "onSearchActivityFinish error", e);
        return;
    L21:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void k(hq.h r17) {
        int r5 = 0;
        Intrinsics.checkNotNullParameter(r17, "effect");
        MviLogLevel r10 = com.obric.flow.cardlistpage.mvi.h.f11535a;
        Intrinsics.checkNotNullParameter(r17, "effect");
        String r11 = r17.a();
        if (r11 != null) goto L5;
        r11 = r17.toString();
    L5:
        com.obric.flow.cardlistpage.mvi.h.a(r17.b(), "[" + r17.getClass().getSimpleName() + "] Effect: " + r11);
        Intrinsics.checkNotNullParameter(r17, "effect");
        if ((r17 instanceof hq.b) == false) goto L34;
        androidx.fragment.app.d r12 = this.f11552r;
        if (this.f11547m == false) goto L10;
        return;
    L10:
        if (this.f11546l == true) goto L110;
        jp.d r13 = this.f11549o;     // Catch: Exception -> L18
        if (r13 == null) goto L15;
        int r14 = jp.d.d;     // Catch: Exception -> L18
        r13.a(false);     // Catch: Exception -> L18
    L15:
        com.obric.flow.cardlistpage.ui.component.search.i r15 = this.f11557x;     // Catch: Exception -> L18
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchComponent");     // Catch: Exception -> L18
        r15 = null;
    L20:
        r15.f(com.obric.flow.cardlistpage.ui.component.search.d.f11756a);     // Catch: Exception -> L18
        com.obric.flow.cardlistpage.ui.component.floatingbtn.j r16 = this.f11558y;     // Catch: Exception -> L18
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("floatingBtnComponent");     // Catch: Exception -> L18
        r16 = null;
    L23:
        r16.f(com.obric.flow.cardlistpage.ui.component.floatingbtn.f.f11635a);     // Catch: Exception -> L18
        this.f11547m = true;     // Catch: Exception -> L18
        removeCallbacks(r12);     // Catch: Exception -> L18
        postDelayed(r12, 1500);     // Catch: Exception -> L18
        OSearchBar r18 = this.N;     // Catch: Exception -> L18
        if (r18 != null) goto L26;
        removeCallbacks(r12);     // Catch: Exception -> L18
        this.f11547m = false;     // Catch: Exception -> L18
        return;
    L26:
        int[] r19 = new int[2];     // Catch: Exception -> L18
        r18.getLocationOnScreen(r19);     // Catch: Exception -> L18
        q("open_search_page", false);     // Catch: Exception -> L18
        Intent r20 = new Intent();     // Catch: Exception -> L18
        r20.setComponent(new ComponentName("com.obric.quicksearch", "com.android.quicksearchbox.SearchActivity"));     // Catch: Exception -> L18
        r20.setFlags(268468224);     // Catch: Exception -> L18
        r20.putExtra("extra_transition_type", "handover");     // Catch: Exception -> L18
        r20.putExtra("extra_search_bar_width", r18.getWidth());     // Catch: Exception -> L18
        r20.putExtra("extra_search_bar_height", r18.getHeight());     // Catch: Exception -> L18
        r20.putExtra("extra_search_bar_x", r19[0]);     // Catch: Exception -> L18
        r20.putExtra("extra_search_bar_y", r19[1]);     // Catch: Exception -> L18
        Bundle r21 = new Bundle();     // Catch: Exception -> L18
        r21.putBinder("extra_caller_binder", new h());     // Catch: Exception -> L18
        r20.putExtras(r21);     // Catch: Exception -> L18
        getContext().startActivity(r20, ActivityOptions.makeCustomAnimation(getContext(), 0, 0).toBundle());     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        removeCallbacks(r12);
        this.f11547m = false;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("navigate to search failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r22 = su.a.f22013b;
        if (r22 == null) goto L32;
        ((ju.b) r22.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", "navigate to search failed", e);
        return;
    L32:
        throw new IllegalStateException("KoinApplication has not been started");
    L110:
        return;
    L34:
        if ((r17 instanceof hq.c) == false) goto L47;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L37
        getContext().getApplicationContext().startActivity(new Intent(getContext(), CardFeedSettingsActivity.class).addFlags(268435456));     // Catch: Throwable -> L37
        Object r24 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);
        if (r25 == null) goto L101;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("open settings failed", "msg");
        Intrinsics.checkNotNullParameter(r25, "t");
        org.koin.core.a r26 = su.a.f22013b;
        if (r26 == null) goto L45;
        ((ju.b) r26.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", "open settings failed", r25);
        return;
    L45:
        throw new IllegalStateException("KoinApplication has not been started");
    L101:
        return;
    L37:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L39
    L47:
        if ((r17 instanceof hq.e) == false) goto L56;
        l r28 = this.E;
        if (r28 == null) goto L103;
        r28.a();
        int r29 = r28.f11783b.allocateAppWidgetId();
        r28.f11785h = r29;
        String r30 = "open: pendingWidgetId=" + r29;
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter(r30, "msg");
        org.koin.core.a r31 = su.a.f22013b;
        if (r31 == null) goto L54;
        ((ju.b) r31.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("WidgetPickerCoordinator", r30);
        BuildersKt.launch$default(r28.d, null, null, new WidgetPickerCoordinator$open$1(r28, null), 3, null);
        return;
    L54:
        throw new IllegalStateException("KoinApplication has not been started");
    L103:
        return;
    L56:
        if ((r17 instanceof hq.d) == false) goto L70;
        hq.d r32 = (hq.d) r17;
        int r33 = r32.f17361a;
        if (r32.f17362b == false) goto L62;
        Context r34 = getContext();     // Catch: Exception -> L60
        Intent r35 = new Intent(getContext(), ClockWidgetConfigActivity.class);     // Catch: Exception -> L60
        r35.addFlags(268435456);     // Catch: Exception -> L60
        r35.putExtra("appWidgetId", r33);     // Catch: Exception -> L60
        r35.putExtra("request_code", 3);     // Catch: Exception -> L60
        r34.startActivity(r35);     // Catch: Exception -> L60
    L89:
        return;
    L62:
        Context r36 = getContext();     // Catch: Exception -> L60
        Intent r37 = new Intent(getContext(), TransparentDialogActivity.class);     // Catch: Exception -> L60
        r37.putExtra("appWidgetId", r33);     // Catch: Exception -> L60
        r37.addFlags(268435456);     // Catch: Exception -> L60
        r37.putExtra("extra_action", "extra_action_go_widget_config");     // Catch: Exception -> L60
        r37.putExtra("request_code", 3);     // Catch: Exception -> L60
        r36.startActivity(r37);     // Catch: Exception -> L60
    L60:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("show widget config activity failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r38 = su.a.f22013b;
        if (r38 == null) goto L68;
        ((ju.b) r38.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", "show widget config activity failed", e);
        return;
    L68:
        throw new IllegalStateException("KoinApplication has not been started");
    L70:
        if ((r17 instanceof hq.f) == false) goto L81;
        hq.f r39 = (hq.f) r17;
        final String r40 = r39.f17364a;
        String r41 = r39.f17365b;
        com.obric.oui.dialog.v2.alert.e r110 = new com.obric.oui.dialog.v2.alert.e(getContext());     // Catch: Exception -> L74
        String r42 = getContext().getString(R$string.delete_widget_confirm_title, new Object[]{r41});     // Catch: Exception -> L74
        r110.f13159i = false;     // Catch: Exception -> L74
        r110.g = r42;     // Catch: Exception -> L74
        r110.f13158h = getContext().getString(R$string.delete_widget_confirm);     // Catch: Exception -> L74
        r110.f13168r = true;     // Catch: Exception -> L74
        String r43 = getContext().getString(R$string.delete_widget_cancel);     // Catch: Exception -> L74
        CardFeedLayout$showDeleteConfirmDialog$modal$1 r111 = CardFeedLayout$showDeleteConfirmDialog$modal$1.INSTANCE;     // Catch: Exception -> L74
        Intrinsics.checkNotNullParameter(r43, MessageIndication.CONTENT_TYPE_TEXT);     // Catch: Exception -> L74
        Intrinsics.checkNotNullParameter(r111, "listener");     // Catch: Exception -> L74
        r110.f13162l = r43;     // Catch: Exception -> L74
        r110.f13163m = new com.obric.oui.dialog.v2.alert.c(r111, 0);     // Catch: Exception -> L74
        String r44 = getContext().getString(R$string.delete_widget_confirm_yes);     // Catch: Exception -> L74
        Function2<DialogInterface, Integer, Unit> r112 = new CardFeedLayout$showDeleteConfirmDialog$modal$2(r40);     // Catch: Exception -> L74
        Intrinsics.checkNotNullParameter(r44, MessageIndication.CONTENT_TYPE_TEXT);     // Catch: Exception -> L74
        Intrinsics.checkNotNullParameter(r112, "listener");     // Catch: Exception -> L74
        r110.f13165o = r44;     // Catch: Exception -> L74
        r110.f13166p = new com.obric.oui.dialog.v2.alert.c(r112, 1);     // Catch: Exception -> L74
        final com.obric.oui.dialog.v2.alert.f r45 = r110.c();     // Catch: Exception -> L74
        r45.setOnShowListener(new c(this, r45));     // Catch: Exception -> L74
        r45.setOnDismissListener(new d(this, r5));     // Catch: Exception -> L74
        post(new e(this, r45));     // Catch: Exception -> L74
        return;
    L74:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("show confirm dialog failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r46 = su.a.f22013b;
        if (r46 == null) goto L79;
        ((ju.b) r46.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", "show confirm dialog failed", e);
        return;
    L79:
        throw new IllegalStateException("KoinApplication has not been started");
    L81:
        if ((r17 instanceof hq.g) == false) goto L84;
        hq.g r47 = (hq.g) r17;
        n(r47.e, r47.f17366a, r47.f17367b, r47.f17368c, r47.d);
        return;
    L84:
        if ((r17 instanceof hq.a) == false) goto L108;
        WidgetLayer r48 = this.f11556w;
        if (r48 == null) goto L109;
        r48.postDelayed(new androidx.fragment.app.d(r17, 22), 500);
        return;
    L109:
        return;
    }

    public final void l() {
        if (this.f11548n == false) goto L5;
        return;
    L5:
        if (getContext().getApplicationContext().getSharedPreferences("card_feed_prefs", 0).getBoolean("push_permission_requested_once", false) == true) goto L13;
        this.f11548n = true;
        kotlinx.coroutines.internal.c r5 = this.f11542h;
        if (r5 == null) goto L12;
        BuildersKt.launch$default(r5, null, null, new CardFeedLayout$requestPushPermissionDelayed$1(this, null), 3, null);
        return;
    L12:
        return;
    }

    public final void m() {
        if (this.f11546l == true) goto L30;
        return;
    L30:
        Uri r10 = Uri.parse("content://com.obric.quicksearch.launcher_call");     // Catch: Exception -> L17
        ContentProviderClient r11 = getContext().getContentResolver().acquireUnstableContentProviderClient(r10);     // Catch: Exception -> L17
        if (r11 != null) goto L31;
    L11:
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("requestQsbFinish called", "msg");     // Catch: Throwable -> L9
        org.koin.core.a r12 = su.a.f22013b;     // Catch: Throwable -> L9
        if (r12 == null) goto L20;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("CardFeedLayout", "requestQsbFinish called");     // Catch: Throwable -> L9
        if (r11 == null) goto L32;
        r11.release();     // Catch: Exception -> L17
        return;
    L32:
        return;
    L20:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L9
    L31:
        r11.call("finishSearchActivity", null, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r11 == null) goto L23;
        r11.release();     // Catch: Exception -> L17
    L23:
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("requestQsbFinish failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L29;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", "requestQsbFinish failed", e);
        return;
    L29:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void n(String r5, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        setSystemGestureExclusionRects(CollectionsKt.mutableListOf(new Rect[]{new Rect(r10, r11, r12, r13)}));
        String r14 = r5 + ", gesture exclusion rect, l: " + r10 + ", r: " + r12 + ", t: " + r11 + ", b: " + r13;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L7;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("CardFeedLayout", r14);
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void o() {
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("startListening", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L11;
        s r10 = null;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("CardFeedLayout", "startListening");
        s r11 = this.C;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
    L8:
        r10.f(com.obric.flow.cardlistpage.ui.component.feedlist.l.f11591a);
        return;
    L7:
        r10 = r11;
        goto L8
    L11:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets r10) {
        Intrinsics.checkNotNullParameter(r10, "insets");
        int r5 = r10.getInsets(WindowInsets.Type.navigationBars()).bottom;
        if (r5 == this.P) goto L13;
        this.P = r5;
        RecyclerView r11 = this.d;
        if (r11 == null) goto L8;
        r11.setPadding(r11.getPaddingLeft(), r11.getPaddingTop(), r11.getPaddingRight(), this.P);
    L8:
        String r12 = "onApplyWindowInsets bottomInset: " + r5;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L12;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("CardFeedLayout", r12);
        goto L13
    L12:
        throw new IllegalStateException("KoinApplication has not been started");
    L13:
        return r10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter r5 = new IntentFilter();
        r5.addAction("com.obric.quicksearch.action.SEARCH_READY");
        r5.addAction("com.obric.quicksearch.action.SEARCH_FINISH");
        ContextCompat.registerReceiver(getContext(), this.s, r5, 2);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.TIME_SET");
        r10.addAction("android.intent.action.TIMEZONE_CHANGED");
        r10.addAction("android.intent.action.DATE_CHANGED");
        r10.addAction("android.intent.action.LOCALE_CHANGED");
        ContextCompat.registerReceiver(getContext(), this.f11553t, r10, 2);
        q r11 = getMiniAppWidgetServerAliveObserver();
        monitor-enter(r11);
    L24:
        th = move-exception;
        throw th;
    L6:
        if (r11.d == false) goto L65;
        monitor-exit(r11);
    L27:
        m r12 = getMiniAppWidgetInstallStateObserver();
        Uri r13 = r12.f20504c;
        if (r12.d == true) goto L46;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L33
        r12.f20503b.getContentResolver().registerContentObserver(r13, true, r12.e);     // Catch: Throwable -> L33
        r12.d = true;     // Catch: Throwable -> L33
        String r15 = "register success uri=" + r13;     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter("MiniAppInstallObserver", "tag");     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L33
        org.koin.core.a r16 = su.a.f22013b;     // Catch: Throwable -> L33
        if (r16 == null) goto L36;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppInstallObserver", r15);     // Catch: Throwable -> L33
        Object r17 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L38:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L46;
        String r19 = "register failed uri=" + r13;
        Intrinsics.checkNotNullParameter("MiniAppInstallObserver", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Intrinsics.checkNotNullParameter(r18, "t");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L44;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppInstallObserver", r19, r18);
        goto L46
    L44:
        throw new IllegalStateException("KoinApplication has not been started");
    L36:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L46:
        if (this.G == null) goto L52;
        Intrinsics.checkNotNullParameter(this, "cardRoot");
        n.q(3, 1, this);
        String r21 = "attachBlurDrawable cardRoot:" + this;
        Intrinsics.checkNotNullParameter("OverlayAnimatorComponent", "tag");
        Intrinsics.checkNotNullParameter(r21, "msg");
        org.koin.core.a r22 = su.a.f22013b;
        if (r22 == null) goto L51;
        ((ju.b) r22.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("OverlayAnimatorComponent", r21);
        goto L52
    L51:
        throw new IllegalStateException("KoinApplication has not been started");
    L52:
        s r23 = this.C;
        if (r23 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r23 = null;
    L55:
        r23.f11600h.f20500n = r23.f11611t;
        if (i() == false) goto L58;
        o();
    L58:
        kotlinx.coroutines.internal.c r24 = h0.b();
        this.f11542h = r24;
        BuildersKt.launch$default(r24, null, null, new AnonymousClass1(this, null), 3, null);
        kotlinx.coroutines.internal.c r25 = this.f11542h;
        if (r25 == null) goto L67;
        BuildersKt.launch$default(r25, null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L67:
        return;
    L65:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L12
        r11.f20515b.getContentResolver().registerContentObserver(r11.f20516c, true, r11.e);     // Catch: Throwable -> L12
        r11.d = true;     // Catch: Throwable -> L12
        String r27 = "register success uri=" + r11.f20516c;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("MiniAppServerAliveObserver", "tag");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r27, "msg");     // Catch: Throwable -> L12
        org.koin.core.a r28 = su.a.f22013b;     // Catch: Throwable -> L12
        if (r28 == null) goto L15;
        ((ju.b) r28.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppServerAliveObserver", r27);     // Catch: Throwable -> L12
        Object r29 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L17:
        Throwable r30 = Result.m127exceptionOrNullimpl(r29);     // Catch: Throwable -> L24
        if (r30 == null) goto L26;
        String r31 = "register failed uri=" + r11.f20516c;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter("MiniAppServerAliveObserver", "tag");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r31, "msg");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r30, "t");     // Catch: Throwable -> L24
        org.koin.core.a r32 = su.a.f22013b;     // Catch: Throwable -> L24
        if (r32 == null) goto L23;
        ((ju.b) r32.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppServerAliveObserver", r31, r30);     // Catch: Throwable -> L24
        goto L26
    L23:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L24
    L26:
        monitor-exit(r11);
        goto L27
    L15:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L24
        r29 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        goto L17
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r13) {
        if (r13 == null) goto L29;
        Context r5 = getContext();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter("CardFeedLayout onConfigurationChanged", "desc");
        int r10 = r13.densityDpi;
        int r11 = r13.screenWidthDp;
        int r12 = r13.screenHeightDp;
        StringBuilder r14 = j0.v("CardFeedLayout onConfigurationChanged newConfig:", r10, r11, " ", " ");
        r14.append(r12);
        String r15 = r14.toString();
        Intrinsics.checkNotNullParameter("DensityUtils", "tag");
        Intrinsics.checkNotNullParameter(r15, "msg");
        org.koin.core.a r16 = su.a.f22013b;
        if (r16 == null) goto L28;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("DensityUtils", r15);
        com.obric.flow.cardlistpage.util.b.d(r5, "CardFeedLayout onConfigurationChanged");
        s r17 = this.C;
        if (r17 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r17 = null;
    L8:
        boolean r18 = false;
        r17.f(new com.obric.flow.cardlistpage.ui.component.feedlist.i(false, false));
        obric.flow.miniappwidget.l r19 = this.f11541c;
        if (r19 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppWidgetHost");
        r19 = null;
    L12:
        if ((r13.uiMode & 48) != 32) goto L14;
        r18 = true;
    L14:
        String r20 = r19.f20491a;
        String r21 = "onThemeChanged hostId=" + r20 + " isNightMode=" + r18;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r21, "msg");     // Catch: Throwable -> L18
        org.koin.core.a r22 = su.a.f22013b;     // Catch: Throwable -> L18
        if (r22 == null) goto L21;
        ((ju.b) r22.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetHost", r21);     // Catch: Throwable -> L18
        r19.e().onThemeChanged(r18);     // Catch: Throwable -> L18
        goto L29
    L21:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        String r23 = "onThemeChanged failed hostId=" + r20;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r23, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r24 = su.a.f22013b;
        if (r24 == null) goto L26;
        ((ju.b) r24.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r23, th);
        goto L29
    L26:
        throw new IllegalStateException("KoinApplication has not been started");
    L28:
        throw new IllegalStateException("KoinApplication has not been started");
    L29:
        super.onConfigurationChanged(r13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        getContext().unregisterReceiver(this.s);     // Catch: Throwable -> L5
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L89:
        getContext().unregisterReceiver(this.f11553t);     // Catch: Throwable -> L9
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        m r10 = getMiniAppWidgetInstallStateObserver();
        if (r10.d == true) goto L82;
    L26:
        q r11 = getMiniAppWidgetServerAliveObserver();
        monitor-enter(r11);
    L43:
        th = move-exception;
        throw th;
    L29:
        if (r11.d == true) goto L86;
        monitor-exit(r11);
    L48:
        if (this.G == null) goto L54;
        Intrinsics.checkNotNullParameter("OverlayAnimatorComponent", "tag");
        Intrinsics.checkNotNullParameter("detachBlurDrawable", "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L53;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("OverlayAnimatorComponent", "detachBlurDrawable");
        goto L54
    L53:
        throw new IllegalStateException("KoinApplication has not been started");
    L54:
        s r13 = this.C;
        if (r13 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r13 = null;
    L57:
        obric.flow.miniappwidget.l r14 = r13.f11600h;
        Function2 r15 = r13.f11611t;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "listener");
        if (r14.f20500n != r15) goto L60;
        r14.f20500n = null;
    L60:
        r13.e.removeCallbacks(r13.f11612u);
        r13.f11610r = false;
        r13.s = 0;
        s r16 = this.C;
        if (r16 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
        r16 = null;
    L63:
        RecyclerView r17 = r16.e;
        Iterator<View> r18 = ViewGroupKt.getChildren(r17).iterator();
    L65:
        if (r18.hasNext() == false) goto L72;
        Object r19 = r17.getChildViewHolder(r18.next());
        if ((r19 instanceof gq.a) == false) goto L69;
        gq.a r20 = (gq.a) r19;
    L70:
        if (r20 == null) goto L65;
        r20.onDestroy();
        goto L65
    L69:
        r20 = null;
        goto L70
    L72:
        l r21 = this.E;
        if (r21 == null) goto L75;
        r21.a();
    L75:
        p();
        kotlinx.coroutines.internal.c r22 = this.f11542h;
        if (r22 == null) goto L78;
        h0.c(r22, null);
    L78:
        this.f11542h = null;
        return;
    L86:
        r11.f20515b.getContentResolver().unregisterContentObserver(r11.e);     // Catch: Throwable -> L34
        Object r23 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r24 = Result.m127exceptionOrNullimpl(r23);     // Catch: Throwable -> L43
        if (r24 == null) goto L45;
        String r25 = "unregister failed uri=" + r11.f20516c;     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter("MiniAppServerAliveObserver", "tag");     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r25, "msg");     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r24, "t");     // Catch: Throwable -> L43
        org.koin.core.a r26 = su.a.f22013b;     // Catch: Throwable -> L43
        if (r26 == null) goto L42;
        ((ju.b) r26.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppServerAliveObserver", r25, r24);     // Catch: Throwable -> L43
        goto L45
    L42:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L43
    L45:
        r11.d = false;     // Catch: Throwable -> L43
        monitor-exit(r11);
        goto L48
    L34:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L43
        r23 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L43
        goto L36
    L82:
        r10.f20503b.getContentResolver().unregisterContentObserver(r10.e);     // Catch: Throwable -> L16
        Object r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r29 = Result.m127exceptionOrNullimpl(r28);
        if (r29 == null) goto L25;
        String r30 = "unregister failed uri=" + r10.f20504c;
        Intrinsics.checkNotNullParameter("MiniAppInstallObserver", "tag");
        Intrinsics.checkNotNullParameter(r30, "msg");
        Intrinsics.checkNotNullParameter(r29, "t");
        org.koin.core.a r31 = su.a.f22013b;
        if (r31 == null) goto L24;
        ((ju.b) r31.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppInstallObserver", r30, r29);
        goto L25
    L24:
        throw new IllegalStateException("KoinApplication has not been started");
    L25:
        r10.d = false;
    L16:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r28 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L89
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        sj.g r5 = com.obric.flow.cardlistpage.b.f11456a;
        if (Intrinsics.areEqual(com.obric.flow.cardlistpage.b.f11456a, com.obric.flow.cardlistpage.a.f11440b) == false) goto L5;
        return true;
    L5:
        float r11 = r10.getRawX();
        float r12 = r10.getRawY();
        int r13 = r10.getAction();
        ControllerState r14 = null;
        o r15 = null;
        if (r13 != 0) goto L8;
        this.Q = r11;
        this.V = r12;
        this.R = false;
        this.f11543i = false;
        p r16 = this.G;
        if (r16 == null) goto L37;
        float r17 = r16.o().f11673c;
    L38:
        this.f11540b0 = r17;
        p r18 = this.G;
        if (r18 != null) goto L41;
    L47:
        VelocityTracker r19 = this.T;
        if (r19 == null) goto L50;
        r19.clear();
    L50:
        VelocityTracker r20 = this.T;
        if (r20 != null) goto L53;
        r20 = VelocityTracker.obtain();
    L53:
        this.T = r20;
        if (r20 == null) goto L56;
        r20.addMovement(r10);
    L56:
        p r21 = this.G;
        if (r21 == null) goto L60;
        r14 = r21.f11694n;
    L60:
        if (r14 == ControllerState.OPENED) goto L63;
        return true;
    L63:
        return super.onInterceptTouchEvent(r10);
    L41:
        if (r18.o().f != true) goto L47;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("onInterceptTouchEvent: wasAnimating", "msg");
        org.koin.core.a r22 = su.a.f22013b;
        if (r22 == null) goto L46;
        ((ju.b) r22.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("CardFeedLayout", "onInterceptTouchEvent: wasAnimating");
        goto L47
    L46:
        throw new IllegalStateException("KoinApplication has not been started");
    L37:
        r17 = 0.0f;
        goto L38
    L8:
        if (r13 != 2) goto L56;
        float r23 = Math.abs(r11 - this.Q);
        float r24 = Math.abs(r12 - this.V);
        if (r23 <= this.W) goto L56;
        if (r23 <= r24) goto L56;
        if (this.f11544j == false) goto L17;
        return false;
    L17:
        this.R = true;
        p r25 = this.G;
        if (r25 != null) goto L20;
    L24:
        WidgetLayer r26 = this.f11556w;
        if (r26 != null) goto L27;
    L33:
        return true;
    L27:
        if (r26.c() != true) goto L33;
        o r27 = this.D;
        if (r27 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
    L32:
        r15.k(new com.obric.flow.cardlistpage.ui.component.popupdialog.p(true));
        this.f11543i = true;
        goto L33
    L31:
        r15 = r27;
        goto L32
    L20:
        if (r25.q() != true) goto L24;
        p r28 = this.G;
        if (r28 == null) goto L24;
        r28.f(com.obric.flow.cardlistpage.ui.component.overlayanimator.a.f11644a);
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        int r13 = Math.min(r5, r10);
        this.S = r13;
        p r14 = this.G;
        if (r14 == null) goto L13;
        if (r13 <= 0) goto L13;
        if (r14.f11688h == r13) goto L13;
        r14.f11688h = r13;
        float r15 = r14.f11690j;
        CardFeedLayout r16 = (CardFeedLayout) r14.e.get();
        com.obric.flow.cardlistpage.mvi.a r17 = (com.obric.flow.cardlistpage.mvi.a) r14.f11531a;
        if (r16 == null) goto L11;
        float r18 = r16.getAlpha();
    L12:
        r14.l(r15, r18, ((Boolean) ((com.obric.flow.cardlistpage.ui.component.overlayanimator.u) r17.b()).f.getValue()).booleanValue());
        goto L13
    L11:
        r18 = ((com.obric.flow.cardlistpage.ui.component.overlayanimator.u) r17.b()).b();
    L13:
        super.onSizeChanged(r5, r10, r11, r12);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r11.getPointerId(0) == this.f11538a0) goto L5;
        return true;
    L5:
        p r5 = this.G;
        ControllerState r10 = null;
        if (r5 == null) goto L28;
        com.obric.flow.cardlistpage.ui.component.overlayanimator.j0 r12 = r5.o();
        ControllerState r13 = ControllerState.HIDDEN;
        ControllerState r14 = r12.f11672b;
        if (r14 == r13) goto L16;
        if (r14 == ControllerState.ALPHA_HIDDEN) goto L16;
        if (r12.f == false) goto L28;
        if (r12.f11671a == true) goto L28;
    L16:
        if (r11.getActionMasked() != 1) goto L18;
    L23:
        this.R = false;
        VelocityTracker r15 = this.T;
        if (r15 == null) goto L26;
        r15.recycle();
    L26:
        this.T = null;
    L27:
        return true;
    L18:
        if (r11.getActionMasked() == 3) goto L23;
        if (r11.getActionMasked() != 6) goto L27;
        if (r11.getPointerId(r11.getActionIndex()) != this.f11538a0) goto L27;
    L28:
        int r16 = r11.getActionMasked();
        if (r16 == 0) goto L38;
        if (r16 != 2) goto L48;
        VelocityTracker r17 = this.T;
        if (r17 != null) goto L35;
        r17 = VelocityTracker.obtain();
    L35:
        this.T = r17;
        if (r17 == null) goto L48;
        r17.addMovement(r11);
    L48:
        if (this.f11543i == false) goto L50;
        return true;
    L50:
        int r18 = r11.getActionMasked();
        float r19 = 0.0f;
        if (r18 == 0) goto L158;
        int r20 = this.W;
        if (r18 == 1) goto L103;
        if (r18 == 2) goto L58;
        if (r18 == 3) goto L103;
        if (r18 == 6) goto L103;
    L162:
        return true;
    L58:
        boolean r21 = this.R;
        com.obric.flow.cardlistpage.ui.component.overlayanimator.a r22 = com.obric.flow.cardlistpage.ui.component.overlayanimator.a.f11644a;
        if (r21 == false) goto L90;
        float r110 = r11.getRawX() - this.Q;
        if (r110 <= 0.0f) goto L79;
        p r23 = this.G;
        if (r23 == null) goto L65;
        float r24 = r23.o().f11673c;
    L67:
        if (r24 != 1.0f) goto L79;
        p r25 = this.G;
        if (r25 == null) goto L72;
        r10 = r25.o().f11672b;
    L72:
        if (r10 == ControllerState.OPENED) goto L76;
        p r26 = this.G;
        if (r26 == null) goto L76;
        r26.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.d(true, false));
    L76:
        p r111 = this.G;
        if (r111 == null) goto L162;
        r111.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.e(r110));
        goto L162
    L65:
        r24 = 0.0f;
    L79:
        p r27 = this.G;
        if (r27 != null) goto L82;
    L86:
        float r112 = RangesKt.coerceIn(this.f11540b0 + (r110 / this.S), 0.0f, 1.0f);
        p r113 = this.G;
        if (r113 == null) goto L162;
        r113.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.f(r112, false, ""));
        goto L162
    L82:
        if (r27.q() != true) goto L86;
        p r28 = this.G;
        if (r28 == null) goto L86;
        r28.f(r22);
        goto L86
    L90:
        if (Math.abs(r11.getRawX() - this.Q) <= r20) goto L162;
        if (this.R == true) goto L162;
        if (this.f11544j == true) goto L162;
        this.R = true;
        p r114 = this.G;
        if (r114 == null) goto L162;
        if (r114.q() != true) goto L162;
        p r115 = this.G;
        if (r115 == null) goto L162;
        r115.f(r22);
    L103:
        if (r11.getAction() == 6) goto L105;
    L107:
        VelocityTracker r29 = this.T;
        if (r29 == null) goto L110;
        r29.computeCurrentVelocity(1000, getMMaxFlingVelocity());
    L110:
        VelocityTracker r30 = this.T;
        if (r30 == null) goto L113;
        float r31 = r30.getXVelocity();
    L114:
        float r116 = r11.getRawX() - this.Q;
        int r32 = r20 * 2;
        if ((r116 * r31) < 0.0f) goto L117;
    L119:
        p r117 = this.G;
        if (r117 == null) goto L122;
        com.obric.flow.cardlistpage.ui.component.overlayanimator.j0 r118 = r117.o();
    L123:
        if (r118 == null) goto L125;
        float r119 = r118.f11673c;
    L126:
        this.R = false;
        if (r119 <= 0.0f) goto L141;
        if (r119 >= 1.0f) goto L141;
        WidgetLayer r120 = this.f11556w;
        if (r120 == null) goto L137;
        Intrinsics.checkNotNull(r120);
        if (r120.getX() <= 0.0f) goto L137;
        p r121 = this.G;
        if (r121 == null) goto L154;
        r121.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.b(r31, true));
    L154:
        this.R = false;
        VelocityTracker r122 = this.T;
        if (r122 == null) goto L157;
        r122.recycle();
    L157:
        this.T = null;
    L137:
        p r123 = this.G;
        if (r123 == null) goto L154;
        r123.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.b(r31, false));
    L141:
        if (r119 != 0.0f) goto L144;
    L145:
        p r124 = this.G;
        if (r124 == null) goto L154;
        WidgetLayer r33 = this.f11556w;
        if (r33 == null) goto L152;
        Intrinsics.checkNotNull(r33);
        if (r33.getX() <= 0.0f) goto L152;
        boolean r34 = true;
    L153:
        r124.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.b(r31, r34));
    L152:
        r34 = false;
        goto L153
    L144:
        if (r119 != 1.0f) goto L154;
    L125:
        r119 = 0.0f;
        goto L126
    L122:
        r118 = null;
        goto L123
    L117:
        if (Math.abs(r116) <= r32) goto L119;
        r31 = 0.0f;
        goto L119
    L113:
        r31 = 0.0f;
        goto L114
    L105:
        if (r11.getPointerId(0) == this.f11538a0) goto L107;
        return true;
    L158:
        this.Q = r11.getRawX();
        p r125 = this.G;
        if (r125 == null) goto L161;
        r19 = r125.o().f11673c;
    L161:
        this.f11540b0 = r19;
        goto L162
    L38:
        VelocityTracker r35 = this.T;
        if (r35 == null) goto L41;
        r35.clear();
    L41:
        VelocityTracker r36 = this.T;
        if (r36 != null) goto L44;
        r36 = VelocityTracker.obtain();
    L44:
        this.T = r36;
        if (r36 == null) goto L48;
        r36.addMovement(r11);
        goto L48
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r5) {
        super.onWindowFocusChanged(r5);
        ju.a r10 = ju.a.f18481a;
        r10.d("CardFeedLayout", "onWindowFocusChanged:" + r5 + ", isWaitingForQsb=" + this.f11546l);
        if (r5 == true) goto L5;
        return;
    L5:
        if (this.f11546l == false) goto L10;
        r10.i("CardFeedLayout", "onWindowFocusChanged: recovered from QSB crash/background");
        if (this.f11546l == false) goto L10;
        m();
        j();
    L10:
        p r11 = this.G;
        if (r11 == null) goto L15;
        r11.f11699t = -1;
        r11.t(r11.f11690j, false);
        return;
    }

    public final void p() {
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter("stopListening", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L11;
        s r10 = null;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("CardFeedLayout", "stopListening");
        s r11 = this.C;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
    L8:
        r10.f(com.obric.flow.cardlistpage.ui.component.feedlist.m.f11592a);
        return;
    L7:
        r10 = r11;
        goto L8
    L11:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void q(String r11, boolean r12) {
        if (this.f11547m == true) goto L33;
        if (this.f11546l == true) goto L33;
        return;
    L33:
        ContentProviderClient r10 = getContext().getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.quicksearch.launcher_call"));     // Catch: Exception -> L19
        if (r10 != null) goto L32;
    L13:
        String r13 = "updateQsbHandoverBlur useQsbBlur=" + r12 + " reason=" + r11;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r13, "msg");     // Catch: Throwable -> L11
        org.koin.core.a r5 = su.a.f22013b;     // Catch: Throwable -> L11
        if (r5 == null) goto L22;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("CardFeedLayout", r13);     // Catch: Throwable -> L11
        if (r10 == null) goto L34;
        r10.release();     // Catch: Exception -> L19
        return;
    L34:
        return;
    L22:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L11
    L32:
        Bundle r14 = new Bundle();     // Catch: Throwable -> L11
        r14.putBoolean("useQsbBlur", r12);     // Catch: Throwable -> L11
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r10.call("updateHandoverBlur", null, r14);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r10 == null) goto L25;
        r10.release();     // Catch: Exception -> L19
    L25:
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        String r16 = "updateQsbHandoverBlur failed reason=".concat(r11);
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L31;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedLayout", r16, e);
        return;
    L31:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void setLauncherCallback(k r5) {
        this.f11551q = r5;
    }

    public final void setOnOverlayStateChanged(Function1<? super ControllerState, Unit> r5) {
        this.H = r5;
    }

    public final void setOnStatusBarAppearanceChanged(Function1<? super Boolean, Boolean> r5) {
        this.f11550p = r5;
    }

    public final void setOverlayAnimatorComponent(p r5) {
        this.G = r5;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.flow.cardlistpage.ui.CardFeedLayout$qsbReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.flow.cardlistpage.ui.CardFeedLayout$miniAppSystemReceiver$1] */
    @JvmOverloads
    public CardFeedLayout(final Context r26, AttributeSet r27) {
        Intrinsics.checkNotNullParameter(r26, "context");
        super(r26, r27);
        this.f11552r = new androidx.fragment.app.d(this, 21);
        this.s = new CardFeedLayout$qsbReceiver$1(this);
        this.f11553t = new CardFeedLayout$miniAppSystemReceiver$1(this);
        this.f11554u = LazyKt.lazy(new CardFeedLayout$miniAppWidgetInstallStateObserver$2(r26, this));
        this.f11555v = LazyKt.lazy(new CardFeedLayout$miniAppWidgetServerAliveObserver$2(r26, this));
        this.J = LazyKt.lazy(new CardFeedLayout$repository$2(r26, this));
        this.K = LazyKt.lazy(new CardFeedLayout$widgetInfoProvider$2(r26, this));
        this.L = LazyKt.lazy(new CardFeedLayout$feedListOwner$2(this));
        this.f11542h = h0.b();
        this.f11537a = AppWidgetManager.getInstance(getContext());
        AppCallbackUtils.setAppCallback(new f());
        Context r5 = getContext().createConfigurationContext(new Configuration(getContext().getResources().getConfiguration()));
        this.B = MathKt.roundToInt(TypedValue.applyDimension(1, 88.0f, r5.getResources().getDisplayMetrics())) - MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        com.obric.flow.cardlistpage.util.b.d(getContext(), "init");
        View r10 = LayoutInflater.from(getContext()).inflate(R$layout.card_list_page, this, true);
        this.g = (FrameLayout) r10.findViewById(R$id.container_view);
        WidgetLayer r11 = (WidgetLayer) r10.findViewById(R$id.widget_layer);
        this.f11556w = r11;
        if (r11 == null) goto L6;
        r11.setRealDensityContext(r5);
    L6:
        this.e = (FrameLayout) r10.findViewById(R$id.header_real_density_container);
        LayoutInflater.from(r5).inflate(R$layout.card_list_page_header_real_density, this.e, true);
        FrameLayout r12 = this.e;
        FrameLayout r13 = null;
        if (r12 == null) goto L9;
        View r14 = r12.findViewById(R$id.view_gradient_card_scrolled);
    L10:
        this.A = r14;
        FrameLayout r15 = this.e;
        if (r15 == null) goto L13;
        OIconButtonFloating r16 = (OIconButtonFloating) r15.findViewById(R$id.btn_gen_card);
    L14:
        this.M = r16;
        FrameLayout r17 = this.e;
        if (r17 == null) goto L17;
        OSearchBar r18 = (OSearchBar) r17.findViewById(R$id.btn_search_bar);
    L18:
        this.N = r18;
        FrameLayout r19 = this.e;
        if (r19 == null) goto L21;
        OIconButtonFloating r20 = (OIconButtonFloating) r19.findViewById(R$id.btn_settings);
    L22:
        this.O = r20;
        this.d = (RecyclerView) r10.findViewById(R$id.recycler_view);
        Context r21 = com.obric.flow.cardlistpage.util.g.a(getContext());
        this.f11539b = new gu.d(r21);
        obric.flow.miniappwidget.l r22 = new obric.flow.miniappwidget.l(r21, this.f11542h, new ug.e(getContext(), 11));
        r22.f();
        this.f11541c = r22;
        i2 r23 = obric.flow.b.f20427a;
        gu.d r24 = this.f11539b;
        if (r24 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("appWidgetHost");
        r24 = null;
    L25:
        obric.flow.b.f20428b = r24;
        View r25 = this.A;
        Intrinsics.checkNotNull(r25);
        kotlinx.coroutines.internal.c r28 = this.f11542h;
        if (r28 != null) goto L28;
        r28 = h0.b();
    L28:
        com.obric.flow.cardlistpage.ui.component.topgradient.b r29 = new com.obric.flow.cardlistpage.ui.component.topgradient.b(r25, r28, this);
        this.f11559z = r29;
        com.obric.flow.cardlistpage.ui.component.topgradient.c r30 = new com.obric.flow.cardlistpage.ui.component.topgradient.c();
        Intrinsics.checkNotNullParameter(r30, "intent");
        r29.d(r30);
        com.obric.flow.cardlistpage.ui.component.topgradient.b r31 = this.f11559z;
        if (r31 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("topGradientComponent");
        r31 = null;
    L31:
        com.obric.flow.cardlistpage.ui.component.topgradient.d r32 = new com.obric.flow.cardlistpage.ui.component.topgradient.d();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "intent");
        r31.d(r32);
        OIconButtonFloating r33 = this.M;
        Intrinsics.checkNotNull(r33);
        OIconButtonFloating r34 = this.O;
        kotlinx.coroutines.internal.c r35 = this.f11542h;
        if (r35 != null) goto L34;
        r35 = h0.b();
    L34:
        this.f11558y = new com.obric.flow.cardlistpage.ui.component.floatingbtn.j(r33, r34, r35, this);
        OSearchBar r36 = this.N;
        Intrinsics.checkNotNull(r36);
        kotlinx.coroutines.internal.c r37 = this.f11542h;
        if (r37 != null) goto L37;
        r37 = h0.b();
    L37:
        this.f11557x = new com.obric.flow.cardlistpage.ui.component.search.i(r36, r37, this, new CardFeedLayout$initComponents$1(this));
        WidgetLayer r38 = this.f11556w;
        Intrinsics.checkNotNull(r38);
        kotlinx.coroutines.internal.c r39 = this.f11542h;
        if (r39 != null) goto L40;
        r39 = h0.b();
    L40:
        this.D = new o(r38, r39, this);
        Context r40 = getContext();
        RecyclerView r41 = this.d;
        Intrinsics.checkNotNull(r41);
        kotlinx.coroutines.internal.c r42 = this.f11542h;
        if (r42 != null) goto L43;
        r42 = h0.b();
    L43:
        kotlinx.coroutines.internal.c r43 = r42;
        gu.d r44 = this.f11539b;
        if (r44 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("appWidgetHost");
        gu.d r45 = null;
    L47:
        AppWidgetManager r46 = this.f11537a;
        if (r46 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("appWidgetManager");
        AppWidgetManager r47 = null;
    L51:
        obric.flow.miniappwidget.l r48 = this.f11541c;
        if (r48 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppWidgetHost");
        obric.flow.miniappwidget.l r49 = null;
    L55:
        this.C = new s(r40, r41, r43, r45, r47, r49, getFeedListOwner(), this);
        Context r110 = getContext();
        gu.d r50 = this.f11539b;
        if (r50 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("appWidgetHost");
        gu.d r111 = null;
    L59:
        AppWidgetManager r51 = this.f11537a;
        if (r51 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("appWidgetManager");
        AppWidgetManager r112 = null;
    L63:
        kotlinx.coroutines.internal.c r52 = this.f11542h;
        if (r52 != null) goto L66;
        r52 = h0.b();
    L66:
        this.E = new l(r110, r111, r112, r52, new CardFeedLayout$initComponents$2(this), new CardFeedLayout$initComponents$3(this), CardFeedLayout$initComponents$4.INSTANCE);
        w r53 = new w(new com.obric.flow.cardlistpage.ui.component.overlayanimator.u(), 2);
        this.F = r53;
        Intrinsics.checkNotNull(r53);
        kotlinx.coroutines.internal.c r54 = this.f11542h;
        if (r54 != null) goto L69;
        r54 = h0.b();
    L69:
        p r55 = new p(this, r53, r54, this);
        r55.f = new CardFeedLayout$initComponents$5$1(this);
        r55.g = new CardFeedLayout$initComponents$5$2(this);
        this.G = r55;
        if (this.I != null) goto L81;
        RecyclerView r56 = this.d;
        if (r56 == null) goto L81;
        kotlinx.coroutines.internal.c r57 = this.f11542h;
        if (r57 == null) goto L81;
        w r58 = this.F;
        if (r58 == null) goto L81;
        this.I = new com.obric.flow.cardlistpage.apm.d(getContext(), r58, r56, r57);
    L81:
        RecyclerView r59 = this.d;
        if (r59 == null) goto L85;
        r59.setVisibility(4);
    L85:
        FrameLayout r60 = this.e;
        if (r60 == null) goto L89;
        r60.setVisibility(4);
    L89:
        Function0<Unit> r61 = new CardFeedLayout$initData$1(this);
        if (i() == false) goto L92;
        r61.invoke();
    L97:
        this.S = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.U = LazyKt.lazy(new CardFeedLayout$mMaxFlingVelocity$2(r26));
        this.W = ViewConfiguration.get(r26).getScaledTouchSlop();
        this.f11538a0 = -100;
        return;
    L92:
        com.obric.flow.cardlistpage.ui.view.i r62 = new com.obric.flow.cardlistpage.ui.view.i(getContext(), new com.obric.oui.privacy.c(getContext().getPackageName(), getContext().getString(R$string.app_name), getContext().getString(R$string.app_description), CollectionsKt.listOf(new com.obric.oui.privacy.d(getContext().getString(R$string.privacy_policy_description), CollectionsKt.listOf(new String[]{getContext().getString(R$string.permission_push_access), getContext().getString(R$string.permission_read_installed_apps), getContext().getString(R$string.permission_read_sms_apps)}))), getContext().getString(R$string.privacy_policy), CollectionsKt.arrayListOf(new String[]{getContext().getString(R$string.privacy_policy_link)}), getContext().getString(com.obric.common.oui.R$string.oui_agree), getContext().getString(com.obric.common.oui.R$string.oui_cancel_and_quit), true, false, false));
        r62.f11855c = new ai.p(6, this, r61);
        this.f = r62;
        FrameLayout r63 = this.g;
        if (r63 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("mContentView");
    L96:
        r13.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
        setStatusColor(!ym.a.h(getContext()));
        goto L97
    L95:
        r13 = r63;
        goto L96
    L62:
        r112 = r51;
        goto L63
    L58:
        r111 = r50;
        goto L59
    L54:
        r49 = r48;
        goto L55
    L50:
        r47 = r46;
        goto L51
    L46:
        r45 = r44;
        goto L47
    L21:
        r20 = null;
        goto L22
    L17:
        r18 = null;
        goto L18
    L13:
        r16 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    }
}
