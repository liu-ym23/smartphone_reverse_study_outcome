package com.bytedance.android.anniex.lite.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLitePageContainer extends AnnieXLiteContainer implements ia.f {
    public Window a;
    public DialogFragment b;
    public View c;
    public Dialog d;
    public final Lazy e;
    public final Lazy f;
    public na.b g;
    public com.bytedance.android.anniex.container.ui.j h;
    public com.bytedance.android.anniex.base.service.d.b i;
    public com.bytedance.android.anniex.container.ui.b j;
    public boolean k;
    public volatile boolean l;
    public SmartRefreshLayout m;
    public final d n;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OutAnimation.values().length];
            r0[OutAnimation.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OutAnimation.IN_NONE_OUT_AUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OutAnimation.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OutAnimation.RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements gqa.d {
        public final /* synthetic */ AnnieXLitePageContainer a;

        public c(AnnieXLitePageContainer r1) {
            this.a = r1;
        }

        public final void d2(cqa.h r10) {
            Intrinsics.checkNotNullParameter(r10, "it");
            HybridLogger r11 = HybridLogger.a;
            HybridLogger.m("AnnieXLitePageContainer", "reload: " + this.a.getUrl(), null, null, 12);
            this.a.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("refresh_reload", Boolean.TRUE)));
            HybridLogger.m("AnnieXLitePageContainer", "updateGlobalProps: refresh_reload is true", null, null, 12);
            this.a.reload(null);
            AnnieXLitePageContainer.q(this.a.getUrl(), "pull_refresh", null);
        }
    }

    public static final class d extends com.bytedance.android.anniex.base.lifecycle.a {
        public final /* synthetic */ AnnieXLitePageContainer a;

        public d(AnnieXLitePageContainer r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.i(r10, r11);
            HybridLogger r12 = HybridLogger.a;
            HybridLogger.m("AnnieXLitePageContainer", "===onLoadSuccess: " + this.a.getUrl(), null, null, 12);
            SmartRefreshLayout r13 = this.a.m;
            if (r13 == null) goto L5;
            RefreshState r14 = r13.getState();
        L7:
            if (r14 != RefreshState.Refreshing) goto L13;
            SmartRefreshLayout r15 = this.a.m;
            if (r15 == null) goto L11;
            r15.h(true);
        L11:
            AnnieXLitePageContainer.q(this.a.getUrl(), "refresh success", null);
            return;
        L13:
            return;
        L5:
            r14 = null;
            goto L7
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void g(String r10, ia.c r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            super.g(r10, r11, r12);
            HybridLogger r13 = HybridLogger.a;
            RefreshState r1 = null;
            HybridLogger.m("AnnieXLitePageContainer", "===onLoadFail: " + this.a.getUrl(), null, null, 12);
            SmartRefreshLayout r14 = this.a.m;
            if (r14 == null) goto L6;
            r1 = r14.getState();
        L6:
            if (r1 != RefreshState.Refreshing) goto L12;
            SmartRefreshLayout r15 = this.a.m;
            if (r15 == null) goto L10;
            r15.h(true);
        L10:
            AnnieXLitePageContainer.q(this.a.getUrl(), "refresh failed", r12.getMessage());
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$observerKeyboardStatusChange$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(Object r10) {
            super(1, r10, AnnieXLitePageContainer.class, "onSoftInputChange", "onSoftInputChange(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r10) {
            ((AnnieXLitePageContainer) ((CallableReference) this).receiver).onSoftInputChange(r10);
        }
    }

    static {
    }

    @Override // ia.e
    public final void b(View r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final String getViewType() {
        return AIStateLogRequest.SOURCE_PAGE;
    }

    @Override // ia.f
    public final Integer i() {
        return null;
    }

    @Override // ia.f
    public final void m(boolean r1) {
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r1) {
    }

    @Override // ia.e
    public final void onActivityResult(int r1, int r10, Intent r11) {
    }

    @Override // ia.e
    public final void onDestroy() {
    }

    @Override // ia.f
    public final void onShow(DialogInterface r1) {
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void addKitView() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m("AnnieXLitePageContainer", "===addKitView: " + getUrl(), null, null, 12);
        na.a r1 = getEngine();
        if (r1 == null) goto L23;
        View r10 = r1.d();
        if (r10 == null) goto L24;
        v36.c r11 = (v36.c) this.f.getValue();
        if (r11 == null) goto L14;
        y36.i r12 = r11.s;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("enablePullToRefresh");
        r12 = null;
    L12:
        if (r12 == null) goto L14;
        boolean r13 = Intrinsics.areEqual(r12.b, Boolean.TRUE);
    L15:
        if (r13 == true) goto L17;
        getParentViewGroup().removeAllViews();
        getParentViewGroup().addView(r10);
    L21:
        getLifecycleDispatcher().a(getUrl(), this);
        return;
    L17:
        HybridLogger.m("AnnieXLitePageContainer", "===addLottieSwipeRefreshLayout: " + getUrl(), null, null, 12);
        if (this.m == null) goto L20;
        HybridLogger.m("AnnieXLitePageContainer", "===addLottieSwipeRefreshLayout: remove old swipeRefreshLayout", null, null, 12);
        getParentViewGroup().removeView(this.m);
    L20:
        SmartRefreshLayout r14 = new SmartRefreshLayout(getParentViewGroup().getContext());
        r14.A = true;
        r14.addView(r10, new ViewGroup.LayoutParams(-1, -1));
        r14.G(new q(getContext()), -2);
        r14.B(50.0f);
        r14.W = new c(this);
        getParentViewGroup().addView(r14, -1, -1);
        this.m = r14;
    L14:
        r13 = false;
        goto L15
    L24:
        return;
    }

    @Override // ia.e
    public final void onPause() {
        na.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.j(false);
    L5:
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // ia.e
    public final void onResume() {
        na.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.j(true);
    L5:
        onVisibleChange(true, Boolean.FALSE);
        if (this.k == true) goto L9;
        this.k = true;
        AnnieXJSWorkerManager r1 = AnnieXJSWorkerManager.a;
        AnnieXJSWorkerManager.e(getCurrentUrl(), getBid(), getKitType());
        return;
    }

    @Override // ia.e
    public final void onStart() {
        ab.b r10 = (ab.b) this.e.getValue();
        if (r10 == null) goto L6;
        this.h = com.bytedance.android.anniex.lite.utils.c.c(getBid(), this, this.a, this.c, getContext(), r10);
        return;
    }

    @Override // ia.e
    public final void onStop() {
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final boolean canBackPress() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L7;
        y36.a r1 = r0.g();
        if (r1 == null) goto L7;
        boolean r10 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L9:
        return !r10;
    L7:
        r10 = false;
        goto L9
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b
    public final void observerKeyboardStatusChange() {
        if (com.bytedance.ies.bullet.service.base.h.o0() == false) goto L7;
        Dialog r0 = this.d;
        if (r0 == null) goto L9;
        SoftInputKt.d(r0, new AnonymousClass1(this));
        return;
    L9:
        return;
    L7:
        super.observerKeyboardStatusChange();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void release() {
        super.release();
        if (this.l == true) goto L5;
        AnnieXJSWorkerManager r0 = AnnieXJSWorkerManager.a;
        AnnieXJSWorkerManager.d(getCurrentUrl());
        this.k = false;
    L5:
        this.l = true;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void enterBackground() {
        super.enterBackground();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void enterForeground() {
        super.enterForeground();
    }

    public AnnieXLitePageContainer(com.bytedance.android.anniex.base.builder.a r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10);
        this.e = LazyKt.lazy(new AnnieXLitePageContainer$annieXStatusAndNavModel$2(this));
        this.f = LazyKt.lazy(new AnnieXLitePageContainer$pageModel$2(this));
        this.n = new d(this);
    }

    @Override // ia.e
    public final void a(View r13) {
        this.c = r13;
        DialogFragment r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r0 = null;
    L5:
        Dialog r1 = r0.getDialog();
        this.d = r1;
        if (r1 == null) goto L8;
        Window r10 = r1.getWindow();
    L9:
        this.a = r10;
        if (r13 == null) goto L14;
        LinearLayout r11 = (LinearLayout) r13.findViewById(2131363013);
        if (r11 == null) goto L14;
        r11.setBackgroundColor(AnnieXRuntime.a().a());
    L14:
        if (r13 == null) goto L16;
        FrameLayout r12 = (FrameLayout) r13.findViewById(2131363000);
    L17:
        if (r12 != null) goto L23;
        Context r14 = getBuilder().a;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r14 = null;
    L22:
        r12 = new FrameLayout(r14);
    L23:
        setParentViewGroup(r12);
        if (this.a == null) goto L26;
        View r15 = this.c;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.view.ViewGroup");
        com.bytedance.android.anniex.container.ui.b r16 = new com.bytedance.android.anniex.container.ui.b(this, (ViewGroup) r15);
    L27:
        this.j = r16;
        initUi();
        ab.b r17 = (ab.b) this.e.getValue();
        if (r17 == null) goto L112;
        this.i = com.bytedance.android.anniex.lite.utils.c.d(getBid(), this, r13, getContext(), r17);
        com.bytedance.android.anniex.lite.utils.c.b(getBid(), this, getContext());
        if (this.j == null) goto L48;
        Window r18 = this.a;
        Intrinsics.checkNotNullParameter(r17, "uiModel");
        y36.i r19 = r17.a;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r19 = null;
    L36:
        if (Intrinsics.areEqual(r19.b, Boolean.TRUE) == false) goto L40;
        HybridLogger.m("AnnieXLitePageStatusAndNavImp", "disable input scroll", null, null, 12);
        if (r18 == null) goto L48;
        r18.setSoftInputMode(48);
        goto L48
    L40:
        HybridLogger.m("AnnieXLitePageStatusAndNavImp", "use soft input mode", null, null, 12);
        y36.i r20 = r17.h;
        if (r20 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r20 = null;
    L44:
        SoftInputMode r21 = (SoftInputMode) r20.b;
        if (r21 == null) goto L48;
        if (r18 == null) goto L48;
        r18.setSoftInputMode(r21.getSystemValue());
    L48:
        com.bytedance.android.anniex.container.ui.b r22 = this.j;
        if (r22 == null) goto L112;
        String r23 = getBid();
        Intrinsics.checkNotNullParameter(r17, "uiModel");
        Intrinsics.checkNotNullParameter(r23, "bid");
        ImageView r24 = (ImageView) r22.b.findViewById(2131362987);
        ImageView r25 = (ImageView) r22.b.findViewById(2131362990);
        y36.i r26 = r17.s;
        if (r26 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("closePositionRight");
        r26 = null;
    L55:
        if (Intrinsics.areEqual(r26.b, Boolean.TRUE) == false) goto L57;
        ImageView r27 = (ImageView) r22.b.findViewById(2131362988);
    L59:
        if (Intrinsics.areEqual(((y36.i) r17.getType()).b, "fullscreen") == false) goto L72;
        y36.i r28 = r17.p;
        if (r28 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        r28 = null;
    L64:
        Boolean r29 = (Boolean) r28.b;
        if (r29 == null) goto L72;
        if (r29.booleanValue() == true) goto L70;
        r29 = null;
    L70:
        if (r29 == null) goto L72;
        r29.booleanValue();
        r24.setVisibility(0);
        r24.setOnClickListener(new com.bytedance.android.anniex.container.ui.c(r22));
    L72:
        y36.i r30 = r17.r;
        if (r30 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("iconTheme");
        r30 = null;
    L76:
        Integer r31 = (Integer) r30.b;
        boolean r32 = true;
        if (r31 != null) goto L80;
    L82:
        Boolean r33 = (Boolean) ((y36.i) r17.b()).b;
        if (r33 != null) goto L85;
    L100:
        y36.i r34 = r17.q;
        if (r34 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("enableShare");
        r34 = null;
    L104:
        Boolean r35 = (Boolean) r34.b;
        if (r35 == null) goto L112;
        if (r35.booleanValue() == true) goto L110;
        r35 = null;
    L110:
        if (r35 == null) goto L112;
        r35.booleanValue();
        r25.setVisibility(0);
        goto L112
    L85:
        if (r33.booleanValue() == true) goto L87;
    L89:
        r32 = false;
    L90:
        if (r32 == true) goto L93;
        r33 = null;
    L93:
        if (r33 == null) goto L100;
        r33.booleanValue();
        if (r27 == null) goto L98;
        r27.setVisibility(0);
    L98:
        if (r27 == null) goto L100;
        r27.setOnClickListener(new com.bytedance.android.anniex.container.ui.d(r22));
        goto L100
    L87:
        if (Intrinsics.areEqual(r23, "webcast") == false) goto L89;
    L80:
        if (r31.intValue() != 1) goto L82;
        r27.setImageResource(2131231354);
        goto L82
    L57:
        r27 = (ImageView) r22.b.findViewById(2131362989);
    L112:
        DialogFragment r36 = this.b;
        if (r36 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r36 = null;
    L115:
        registerWeakHolder(DialogFragment.class, r36);
        registerWeakHolder(ia.c.class, this);
        na.b r37 = this.g;
        if (r37 == null) goto L118;
        m16.b r38 = getAnnieXContext().h;
        r37.h();
    L118:
        Dialog r39 = this.d;
        if (r39 == null) goto L121;
        r39.setOnKeyListener(new k(this));
    L121:
        na.b r40 = this.g;
        if (r40 == null) goto L124;
        Intrinsics.checkNotNull(r13);
        getAnnieXContext();
        r40.a();
    L124:
        HybridLogger r110 = HybridLogger.a;
        HybridLogger.m("AnnieXLitePageContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L26:
        r16 = null;
        goto L27
    L16:
        r12 = null;
        goto L17
    L8:
        r10 = null;
        goto L9
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        Integer r11 = y36.q.a(r10, true);
        if (r11 == null) goto L9;
        int r12 = r11.intValue();
        com.bytedance.android.anniex.container.ui.j r1 = this.h;
        if (r1 == null) goto L11;
        FrameLayout r13 = r1.b;
        if (r13 == null) goto L12;
        r13.setBackgroundColor(r12);
        return true;
    L12:
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    @Override // ia.f
    public final void d(ia.f.a r10) {
        Intrinsics.checkNotNullParameter(r10, "popupComponent");
        super.setUiComponent(r10);
    }

    @Override // ia.h
    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
        Integer r11 = y36.q.a(r10, true);
        if (r11 == null) goto L7;
        int r12 = r11.intValue();
        com.bytedance.android.anniex.base.service.d.b r1 = this.i;
        if (r1 == null) goto L9;
        r1.b(r12);
        return true;
    L9:
        return true;
    L7:
        return false;
    }

    @Override // ia.h
    public final void f(boolean r10) {
        com.bytedance.android.anniex.base.service.d.b r0 = this.i;
        if (r0 == null) goto L6;
        r0.e(r10);
        return;
    }

    @Override // ia.f
    public final Dialog h(Bundle r10) {
        return new AppCompatDialog(getContext());
    }

    @Override // ia.h
    public final void k(boolean r10) {
        com.bytedance.android.anniex.base.service.d.b r0 = this.i;
        if (r0 == null) goto L6;
        r0.f(r10);
        return;
    }

    @Override // ia.g
    public final void n(boolean r10) {
        com.bytedance.android.anniex.container.ui.j r0 = this.h;
        if (r0 == null) goto L6;
        r0.e(r10);
        return;
    }

    @Override // ia.f
    public final void o(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.b = r10;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXLitePageContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r10) {
        setContainerVisible(true);
        registerWeakHolder(ia.h.class, this);
        com.bytedance.android.anniex.container.b r0 = getLifecycleDispatcher();
        d r1 = this.n;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "lifecycle");
        r0.a.add(r1);
        DialogFragment r11 = null;
        if ((getBuilder() instanceof com.bytedance.android.anniex.base.builder.a) == true) goto L5;
    L12:
        v36.c r12 = (v36.c) this.f.getValue();
        if (r12 == null) goto L61;
        y36.h r13 = r12.c();
        if (r13 == null) goto L61;
        OutAnimation r14 = (OutAnimation) ((y36.i) r13).b;
        if (r14 == null) goto L61;
        int r15 = b.a[r14.ordinal()];
        if (r15 != 1) goto L21;
    L55:
        DialogFragment r16 = this.b;
        if (r16 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L59:
        r11.setStyle(1, 2131954092);
        return;
    L58:
        r11 = r16;
        goto L59
    L21:
        if (r15 == 2) goto L55;
        if (r15 != 3) goto L25;
        DialogFragment r17 = this.b;
        if (r17 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L54:
        r11.setStyle(1, 2131954091);
        return;
    L53:
        r11 = r17;
        goto L54
    L25:
        if (r15 == 4) goto L31;
        DialogFragment r18 = this.b;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L30:
        r11.setStyle(1, 2131954090);
        return;
    L29:
        r11 = r18;
        goto L30
    L31:
        Map r19 = x26.a.a;
        w26.g r20 = (w26.g) x26.a.a(w26.g.class);
        if (r20 == null) goto L38;
        w26.e r21 = (w26.e) r20.n0(w26.e.class);
        if (r21 == null) goto L38;
        Boolean r22 = r21.V0();
        if (r22 == null) goto L38;
        boolean r23 = r22.booleanValue();
    L39:
        if (r23 == false) goto L45;
        DialogFragment r24 = this.b;
        if (r24 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L44:
        r11.setStyle(1, 2131954094);
        return;
    L43:
        r11 = r24;
        goto L44
    L45:
        DialogFragment r25 = this.b;
        if (r25 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L49:
        r11.setStyle(1, 2131954093);
        return;
    L48:
        r11 = r25;
    L38:
        r23 = true;
    L61:
        DialogFragment r26 = this.b;
        if (r26 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L65:
        r11.setStyle(1, 2131954090);
        return;
    L64:
        r11 = r26;
        goto L65
    L5:
        if (((com.bytedance.android.anniex.base.builder.a) getBuilder()).j == false) goto L12;
        DialogFragment r27 = this.b;
        if (r27 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L10:
        r11.setStyle(1, 2131954092);
        return;
    L9:
        r11 = r27;
        goto L10
    }

    @Override // ia.f
    public final void onDismiss(DialogInterface r1) {
        release();
    }

    @Override // ia.b, ia.c
    public final void onEngineReady(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        na.b r11 = this.g;
        if (r11 == null) goto L6;
        r11.e();
        return;
    }

    @Override // ia.h
    public final boolean p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        Integer r11 = y36.q.a(r10, true);
        if (r11 == null) goto L7;
        int r12 = r11.intValue();
        com.bytedance.android.anniex.base.service.d.b r1 = this.i;
        if (r1 == null) goto L9;
        r1.d(r12);
        return true;
    L9:
        return true;
    L7:
        return false;
    }

    @Override // ia.g
    public final boolean setStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        StatusFontMode.Companion.getClass();
        StatusFontMode r11 = StatusFontMode.a.a(r10);
        if (r11 == null) goto L8;
        com.bytedance.android.anniex.container.ui.j r0 = this.h;
        if (r0 == null) goto L7;
        r0.c(r11);
    L7:
        return true;
    L8:
        return false;
    }

    @Override // ia.h
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        com.bytedance.android.anniex.base.service.d.b r0 = this.i;
        if (r0 == null) goto L6;
        r0.c(r10);
        return;
    }

    @Override // ia.e
    public final void setUserVisibleHint(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        onVisibleChange(r10, Boolean.FALSE);
        return;
    L4:
        if (getContainerVisible() == false) goto L6;
        setContainerVisible(false);
        goto L6
    }

    public static void q(String r10, String r11, String r12) {
        s26.d r0 = s26.d.c;
        r r1 = s26.d.c.c(r.class);
        if (r1 == null) goto L9;
        c1 r13 = new c1("anniex_pull_refresh", null, null, null, null, 254);
        JSONObject r14 = new JSONObject();
        r14.put(com.bytedance.android.ec.core.event.a.KEY_URL, r10);
        r14.put("refresh_state", r11);
        if (r12 == null) goto L7;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r12);
    L7:
        r13.d = r14;
        r1.S(r13);
        return;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void onWebScrollChanged(int r1, int r10, int r11, int r12) {
        super.onWebScrollChanged(r1, r10, r11, r12);
        SmartRefreshLayout r13 = this.m;
        if (r13 == null) goto L9;
        if (r10 != 0) goto L6;
        boolean r14 = true;
    L7:
        r13.setEnabled(r14);
        return;
    L6:
        r14 = false;
        goto L7
    }
}
