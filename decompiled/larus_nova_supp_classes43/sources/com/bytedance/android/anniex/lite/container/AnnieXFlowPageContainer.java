package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$lastViewHashCodes$1;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.l0;
import com.bytedance.ies.bullet.service.base.router.config.StackManager;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXFlowPageContainer extends AnnieXLiteContainer implements ia.d, l0 {
    public final Activity a;
    public View b;
    public boolean c;
    public volatile boolean d;
    public na.b e;
    public final Lazy f;
    public com.bytedance.android.anniex.container.ui.j g;
    public com.bytedance.android.anniex.base.service.d.b h;
    public com.bytedance.android.anniex.container.ui.h i;
    public final Lazy j;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OutAnimation.values().length];
            r0[OutAnimation.BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[OutAnimation.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[OutAnimation.LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[OutAnimation.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[OutAnimation.IN_NONE_OUT_AUTO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer$observerKeyboardStatusChange$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(Object r10) {
            super(1, r10, AnnieXFlowPageContainer.class, "onSoftInputChange", "onSoftInputChange(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r10) {
            ((AnnieXFlowPageContainer) ((CallableReference) this).receiver).onSoftInputChange(r10);
        }
    }

    static {
    }

    @Override // ia.e
    public final void b(View r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final String getPageOptType() {
        return "flow";
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final String getViewType() {
        return AIStateLogRequest.SOURCE_PAGE;
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

    @Override // ia.e
    public final void onStart() {
    }

    public final String B() {
        String r0 = (String) ((y36.i) new y36.p(getAnnieXContext().f.a, "bundle", null)).b;
        if (r0 != null) goto L8;
        String r1 = getBuilder().c.getString("__x_param_bundle");
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L8:
        return r0;
    }

    public final String MW() {
        return (String) ((y36.i) new y36.p(getAnnieXContext().f.a, "bdx_tag", null)).b;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final boolean canBackPress() {
        AnnieXBlankDetectorManager$lastViewHashCodes$1 r0 = AnnieXBlankDetectorManager.a;
        AnnieXBlankDetectorManager.c(getKitView(), getAnnieXContext().f.a);
        if (com.bytedance.android.anniex.lite.utils.c.h(this, getAnnieXContext()) == false) goto L5;
        return false;
    L5:
        v36.a r1 = getContainerModel();
        if (r1 == null) goto L10;
        y36.a r10 = r1.g();
        if (r10 == null) goto L10;
        boolean r11 = Intrinsics.areEqual(((y36.i) r10).b, Boolean.TRUE);
    L11:
        if (r11 == false) goto L16;
        HybridLogger.m("AnnieXFlowPageContainer", "====intercept backPress=====", null, null, 12);
        na.b r12 = this.e;
        if (r12 == null) goto L15;
        r12.f();
    L15:
        return false;
    L16:
        return true;
    L10:
        r11 = false;
        goto L11
    }

    @Override // ia.b, ia.c
    public final void finish() {
        v36.c r0 = (v36.c) this.j.getValue();
        if (r0 == null) goto L21;
        y36.h r1 = r0.c();
        if (r1 == null) goto L22;
        OutAnimation r10 = (OutAnimation) ((y36.i) r1).b;
        if (r10 == null) goto L23;
        int r11 = b.a[r10.ordinal()];
        if (r11 != 1) goto L11;
        this.a.overridePendingTransition(0, 2130772094);
        return;
    L11:
        if (r11 != 2) goto L13;
        this.a.overridePendingTransition(0, 2130772097);
        return;
    L13:
        if (r11 != 4) goto L15;
    L17:
        this.a.overridePendingTransition(0, 0);
        return;
    L15:
        if (r11 == 5) goto L17;
        this.a.overridePendingTransition(2130772022, 2130772025);
        return;
    L23:
        return;
    L22:
        return;
    }

    public final String getChannel() {
        String r0 = (String) ((y36.i) new y36.p(getAnnieXContext().f.a, "channel", null)).b;
        if (r0 != null) goto L8;
        String r1 = getBuilder().c.getString("__x_param_channel");
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L8:
        return r0;
    }

    @Override // ia.d, ia.e
    public final void onPause() {
        na.b r0 = this.e;
        if (r0 == null) goto L5;
        r0.j(false);
    L5:
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // ia.e
    public final void onResume() {
        na.b r0 = this.e;
        if (r0 == null) goto L5;
        r0.j(true);
    L5:
        onVisibleChange(true, Boolean.FALSE);
        if (this.c == true) goto L9;
        this.c = true;
        AnnieXJSWorkerManager r1 = AnnieXJSWorkerManager.a;
        AnnieXJSWorkerManager.e(getCurrentUrl(), getBid(), getKitType());
        return;
    }

    @Override // ia.e
    public final void onStop() {
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void close() {
        super.close();
        this.a.finish();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final String getContainerId() {
        return getAnnieXContext().b;
    }

    public final Uri getSchema() {
        return UriProtector.parse(getCurrentUrl());
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b
    public final void observerKeyboardStatusChange() {
        if (com.bytedance.ies.bullet.service.base.h.o0() == false) goto L10;
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L7;
        Activity r1 = (Activity) r0;
    L8:
        if (r1 == null) goto L12;
        SoftInputKt.c(r1, new AnonymousClass1(this));
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    L10:
        super.observerKeyboardStatusChange();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void release() {
        super.release();
        if (this.d == true) goto L8;
        Lazy r0 = StackManager.c;
        StackManager.a.a().c(this, getAnnieXContext().b);
        AnnieXJSWorkerManager r1 = AnnieXJSWorkerManager.a;
        AnnieXJSWorkerManager.d(getCurrentUrl());
        na.b r10 = this.e;
        if (r10 == null) goto L7;
        r10.onRelease();
    L7:
        this.c = false;
    L8:
        this.d = true;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void enterBackground() {
        super.enterBackground();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b, ia.c
    public final void enterForeground() {
        super.enterForeground();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final Scenes getScenes() {
        return Scenes.AnnieXPage;
    }

    public AnnieXFlowPageContainer(com.bytedance.android.anniex.base.builder.b r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10);
        Activity r11 = r10.j;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        r11 = null;
    L6:
        this.a = r11;
        this.f = LazyKt.lazy(new AnnieXFlowPageContainer$annieXStatusAndNavModel$2(this));
        this.j = LazyKt.lazy(new AnnieXFlowPageContainer$pageModel$2(this));
    }

    @Override // ia.e
    public final void a(View r10) {
        this.b = r10;
        if (r10 == null) goto L5;
        FrameLayout r1 = (FrameLayout) r10.findViewById(2131363000);
    L6:
        if (r1 != null) goto L8;
        r1 = new FrameLayout(this.a);
    L8:
        setParentViewGroup(r1);
        Activity r11 = this.a;
        View r12 = this.b;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        this.i = new com.bytedance.android.anniex.container.ui.h(r11, this, (ViewGroup) r12);
        initUi();
        ab.b r13 = (ab.b) this.f.getValue();
        if (r13 == null) goto L18;
        this.g = com.bytedance.android.anniex.lite.utils.c.c(getBid(), this, this.a.getWindow(), r10, getContext(), r13);
        this.h = com.bytedance.android.anniex.lite.utils.c.d(getBid(), this, r10, getContext(), r13);
        String r14 = getBid();
        Context r15 = getContext();
        this.a.getWindow();
        com.bytedance.android.anniex.lite.utils.c.b(r14, this, r15);
        com.bytedance.android.anniex.container.ui.h r16 = this.i;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r16 = null;
    L13:
        r16.c(this.a.getWindow(), r13);
        com.bytedance.android.anniex.container.ui.h r17 = this.i;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r17 = null;
    L16:
        r17.b(r13, getBid());
    L18:
        if (this.b == null) goto L22;
        na.b r18 = this.e;
        if (r18 == null) goto L22;
        getAnnieXContext();
        r18.a();
    L22:
        HybridLogger r19 = HybridLogger.a;
        HybridLogger.m("AnnieXFlowPageContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        Integer r11 = y36.q.a(r10, true);
        if (r11 == null) goto L9;
        int r12 = r11.intValue();
        com.bytedance.android.anniex.container.ui.j r1 = this.g;
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

    @Override // ia.h
    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
        Integer r11 = y36.q.a(r10, true);
        if (r11 == null) goto L7;
        int r12 = r11.intValue();
        com.bytedance.android.anniex.base.service.d.b r1 = this.h;
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
        com.bytedance.android.anniex.base.service.d.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.e(r10);
        return;
    }

    @Override // ia.d
    public final void j(na.b r1) {
        this.e = r1;
    }

    @Override // ia.h
    public final void k(boolean r10) {
        com.bytedance.android.anniex.base.service.d.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.f(r10);
        return;
    }

    @Override // ia.d
    public final void l(ia.d.a r10) {
        Intrinsics.checkNotNullParameter(r10, "pageComponent");
        super.setUiComponent(r10);
    }

    @Override // ia.g
    public final void n(boolean r10) {
        com.bytedance.android.anniex.container.ui.j r0 = this.g;
        if (r0 == null) goto L6;
        r0.e(r10);
        return;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXFlowPageContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r10) {
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXFlowPageContainer", "===onCreate: " + getUrl(), null, null, 12);
        setContainerVisible(true);
        Lazy r0 = StackManager.c;
        StackManager.a.a().a(this, getAnnieXContext().b);
        v36.c r1 = (v36.c) this.j.getValue();
        if (r1 == null) goto L24;
        y36.h r12 = r1.c();
        if (r12 == null) goto L25;
        OutAnimation r13 = (OutAnimation) ((y36.i) r12).b;
        if (r13 == null) goto L26;
        int r14 = b.a[r13.ordinal()];
        if (r14 != 1) goto L11;
        this.a.overridePendingTransition(2130772649, 2130772095);
        return;
    L11:
        if (r14 != 2) goto L13;
        this.a.overridePendingTransition(2130772023, 2130772095);
        return;
    L13:
        if (r14 != 3) goto L15;
        this.a.overridePendingTransition(2130772022, 2130772095);
        return;
    L15:
        if (r14 != 4) goto L17;
    L19:
        this.a.overridePendingTransition(0, 0);
        return;
    L17:
        if (r14 == 5) goto L19;
        this.a.overridePendingTransition(2130772023, 2130772024);
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // ia.b, ia.c
    public final void onEngineReady(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        na.b r11 = this.e;
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
        com.bytedance.android.anniex.base.service.d.b r1 = this.h;
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
        com.bytedance.android.anniex.container.ui.j r0 = this.g;
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
        com.bytedance.android.anniex.base.service.d.b r0 = this.h;
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

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, ia.b
    public final void loadSchema(String r10, Map<String, ? extends Object> r11, m16.b r12, com.bytedance.android.anniex.base.lifecycle.a r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        getAnnieXContext().h.d(ia.c.class, this);
        registerWeakHolder(ia.h.class, this);
        if (com.bytedance.ies.bullet.service.base.h.P() == false) goto L5;
        registerWeakHolder(Activity.class, this.a);
    L5:
        getAnnieXContext().h.d(l0.class, this);
        na.b r0 = this.e;
        if (r0 == null) goto L8;
        m16.b r1 = getAnnieXContext().h;
        r0.h();
    L8:
        super.loadSchema(r10, r11, r12, r13);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void onWebScrollChanged(int r1, int r10, int r11, int r12) {
        super.onWebScrollChanged(r1, r10, r11, r12);
    }
}
