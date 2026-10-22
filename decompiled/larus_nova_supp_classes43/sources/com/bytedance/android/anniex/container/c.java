package com.bytedance.android.anniex.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends AnnieXContainer implements ia.d {
    public final Activity a;
    public boolean b;
    public ab.b c;
    public com.bytedance.android.anniex.container.ui.k d;
    public final Components e;

    public static final class a {
    }

    static {
    }

    @Override // ia.e
    public final void b(View r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b, ia.c
    public final String getViewType() {
        return AIStateLogRequest.SOURCE_PAGE;
    }

    @Override // ia.d
    public final void j(na.b r1) {
    }

    @Override // ia.e
    public final void onActivityResult(int r1, int r10, Intent r11) {
    }

    @Override // ia.d, ia.e
    public final void onPause() {
    }

    @Override // ia.e
    public final void onStart() {
    }

    @Override // ia.e
    public final void onDestroy() {
        AnnieXJSWorkerManager r0 = AnnieXJSWorkerManager.a;
        AnnieXJSWorkerManager.d(getCurrentUrl());
        this.b = false;
    }

    @Override // ia.e
    public final void onResume() {
        onVisibleChange(true, Boolean.FALSE);
    }

    @Override // ia.e
    public final void onStop() {
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void postFirstVisibleEvent() {
        if (this.b == false) goto L5;
        return;
    L5:
        if (getKitView() == null) goto L9;
        this.b = true;
        AnnieXJSWorkerManager r0 = AnnieXJSWorkerManager.a;
        AnnieXJSWorkerManager.e(getCurrentUrl(), getBid(), getKitType());
        return;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b
    public final void observerKeyboardStatusChange() {
        super.observerKeyboardStatusChange();
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 == null) goto L9;
        SoftInputKt.c(r1, getOnSoftInputChangeListener$anniex_release());
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void parseSchema() {
        t36.d r0 = getBulletContext().e;
        if (r0 == null) goto L5;
        int r1 = t36.i.a;
        t36.i.b(getBulletContext(), r0);
        Lazy r10 = SchemaService.f;
        SchemaService.a.a().getClass();
        this.c = (ab.b) SchemaService.d(r0, ab.b.class);
    L5:
        BulletContext r11 = getBulletContext();
        Scenes r12 = Scenes.AbsActivity;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.i = r12;
        BulletContext r13 = getBulletContext();
        Components r14 = this.e;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.j = r14;
        getBulletContext().I = true;
        super.parseSchema();
    }

    public final void setSecureInfo() {
        getBulletContext().c.J("on_container_created_start");
        ArgusContainerDelegate r0 = getBulletContext().D;
        if (r0 == null) goto L5;
        r0.b(this.a, com.bytedance.ies.bullet.secure.d.a(getBulletContext(), ArgusContainerCreateType.Activity));
    L5:
        getBulletContext().c.J("on_container_created_end");
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b, ia.c
    public final void enterBackground() {
        super.enterBackground();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b, ia.c
    public final void enterForeground() {
        super.enterForeground();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.b, ia.c
    public final void release() {
        super.release();
    }

    public c(com.bytedance.android.anniex.base.builder.b r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10);
        Activity r0 = r10.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        r0 = null;
    L6:
        this.a = r0;
        this.e = r10.l;
    }

    @Override // ia.e
    public final void a(View r10) {
        setRootView(r10);
        if (r10 == null) goto L5;
        FrameLayout r11 = (FrameLayout) r10.findViewById(2131363000);
    L6:
        if (r11 != null) goto L8;
        r11 = new FrameLayout(this.a);
    L8:
        setParentViewGroup(r11);
        Activity r1 = this.a;
        View r12 = getRootView();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        this.d = new com.bytedance.android.anniex.container.ui.k(r1, this, (ViewGroup) r12);
        initUi();
        ab.b r13 = this.c;
        if (r13 == null) goto L14;
        com.bytedance.android.anniex.container.ui.k r14 = this.d;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r14 = null;
    L13:
        r14.g(r13);
    L14:
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.m("AnnieXPageContainer", "===onCreateView: " + getUrl(), null, null, 12);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // ia.g
    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L6:
        return r0.c(r10);
    }

    @Override // ia.h
    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleBarBgColor");
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L6:
        return r0.e(r10);
    }

    @Override // ia.h
    public final void f(boolean r10) {
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.f(r10);
    }

    @Override // ia.h
    public final void k(boolean r10) {
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.k(r10);
    }

    @Override // ia.d
    public final void l(ia.d.a r10) {
        Intrinsics.checkNotNullParameter(r10, "pageComponent");
        super.setUiComponent(r10);
    }

    @Override // ia.g
    public final void n(boolean r10) {
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.n(r10);
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r1) {
        setSecureInfo();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, ia.e
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXPageContainer", "===onConfigurationChanged: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public final void onCreate(Bundle r10) {
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m("AnnieXPageContainer", "===onCreate: " + getUrl(), null, null, 12);
        setContainerVisible(true);
        registerWeakHolder(ia.h.class, this);
    }

    @Override // ia.h
    public final boolean p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L6:
        return r0.p(r10);
    }

    @Override // ia.g
    public final boolean setStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L6:
        return r0.setStatusFontMode(r10);
    }

    @Override // ia.h
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        com.bytedance.android.anniex.container.ui.k r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
        r0 = null;
    L5:
        r0.setTitle(r10);
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

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebPageFinish(WebView r1, String r10) {
        super.onWebPageFinish(r1, r10);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebScrollChanged(int r1, int r10, int r11, int r12) {
        super.onWebScrollChanged(r1, r10, r11, r12);
    }
}
