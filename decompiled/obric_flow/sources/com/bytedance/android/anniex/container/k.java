package com.bytedance.android.anniex.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.obric.launcher.widget.R$id;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends AnnieXContainer implements s3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f3153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Components f3155c;

    public k(r3.b r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        super(r5);
        FragmentActivity r10 = r5.f21647i;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r10 = null;
    L6:
        this.f3153a = r10;
        this.f3155c = r5.f21649k;
    }

    @Override // s3.d
    public final void a(com.bytedance.android.anniex.container.ui.a r5) {
        Intrinsics.checkNotNullParameter(r5, "pageComponent");
        setUiComponent(r5);
    }

    @Override // s3.e
    public final void b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, s3.b
    public final String getViewType() {
        return "page";
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void observerKeyboardStatusChange() {
        super.observerKeyboardStatusChange();
        Context r5 = getContext();
        if ((r5 instanceof Activity) == false) goto L5;
        Activity r10 = (Activity) r5;
    L6:
        if (r10 == null) goto L12;
        Function1<Boolean, Unit> r11 = getOnSoftInputChangeListener$anniex_release();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ComponentActivity) == false) goto L10;
        ((ComponentActivity) r10).getLifecycle().addObserver(com.bytedance.ies.bullet.base.utils.keyboard.a.f5240a);
    L10:
        qo.a.f(r10.getWindow(), null, r11);
        return;
    L12:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, s3.e
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPageContainer", "===onConfigurationChanged: " + getUrl(), null, 12);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, s3.b
    public final void onCreate(Bundle r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPageContainer", "===onCreate: " + getUrl(), null, 12);
        setContainerVisible(true);
        registerWeakHolder(s3.c.class, this);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void parseSchema() {
        rd.b r5 = getBulletContext().e;
        if (r5 == null) goto L5;
        com.lynx.tasm.utils.a.m(getBulletContext(), r5);
        Lazy r10 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r5, f4.b.class);
    L5:
        com.bytedance.ies.bullet.core.e r11 = getBulletContext();
        Scenes r12 = Scenes.f5282b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.f5295i = r12;
        com.bytedance.ies.bullet.core.e r13 = getBulletContext();
        Components r14 = this.f3155c;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.f5296j = r14;
        super.parseSchema();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void postFirstVisibleEvent() {
        if (this.f3154b == false) goto L5;
        return;
    L5:
        if (getKitView() == null) goto L9;
        this.f3154b = true;
        com.bytedance.android.anniex.worker.b r5 = com.bytedance.android.anniex.worker.b.f3505a;
        String r10 = getCurrentUrl();
        String r11 = getBid();
        com.bytedance.android.anniex.worker.b.c(getKitType(), r10, r11);
        return;
    }

    @Override // s3.e
    public final void a(View r5) {
        setRootView(r5);
        if (r5 == null) goto L5;
        FrameLayout r10 = (FrameLayout) r5.findViewById(R$id.annie_x_container_view);
    L6:
        FragmentActivity r11 = this.f3153a;
        if (r10 != null) goto L9;
        r10 = new FrameLayout(r11);
    L9:
        setParentViewGroup(r10);
        View r12 = getRootView();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(this, "container");
        Intrinsics.checkNotNullParameter((ViewGroup) r12, "rootView");
        initUi();
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPageContainer", "===onCreateView: " + getUrl(), null, 12);
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // s3.e
    public final void b() {
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // s3.e
    public final void a() {
        onVisibleChange(true, Boolean.FALSE);
    }

    @Override // s3.e
    public final void a(boolean r5) {
        if (r5 == true) goto L4;
    L6:
        onVisibleChange(r5, Boolean.FALSE);
        return;
    L4:
        if (getContainerVisible() == false) goto L6;
        setContainerVisible(false);
        goto L6
    }
}
