package com.bytedance.android.anniex.lite.container;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.m;
import com.bytedance.android.anniex.container.j;
import com.bytedance.android.anniex.lite.AnnieXLiteFragment;
import com.bytedance.ies.bullet.service.base.x;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$style;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AnnieXLiteContainer implements s3.e, s3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Window f3241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnnieXLiteFragment f3242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f3243c;
    public Dialog d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f3244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f3245i;

    public f(r3.a r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        super(r5);
        this.e = LazyKt.lazy(new AnnieXLitePageContainer$annieXStatusAndNavModel$2(this));
        this.f = LazyKt.lazy(new AnnieXLitePageContainer$pageModel$2(this));
        this.f3245i = new e(this);
    }

    public static void c(String r5, String r10, String r11) {
        tc.c r12 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.base.i r13 = (com.bytedance.ies.bullet.service.base.i) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.service.base.i.class, com.bytedance.ies.bullet.service.base.i.class);
        if (r13 == null) goto L9;
        x r14 = new x("anniex_pull_refresh");
        JSONObject r15 = new JSONObject();
        r15.put("url", r5);
        r15.put("refresh_state", r10);
        if (r11 == null) goto L7;
        r15.put("error_msg", r11);
    L7:
        r14.e = r15;
        ((com.bytedance.ies.bullet.service.monitor.i) r13).d(r14);
        return;
    }

    @Override // s3.e
    public final void a() {
        onVisibleChange(true, Boolean.FALSE);
        if (this.g == true) goto L6;
        this.g = true;
        com.bytedance.android.anniex.worker.b r5 = com.bytedance.android.anniex.worker.b.f3505a;
        String r10 = getCurrentUrl();
        String r11 = getBid();
        com.bytedance.android.anniex.worker.b.c(getKitType(), r10, r11);
        return;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void addKitView() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXLitePageContainer", "===addKitView: " + getUrl(), null, 12);
        x3.a r10 = getEngine();
        if (r10 == null) goto L12;
        View r11 = r10.b();
        if (r11 != null) goto L7;
        return;
    L7:
        if (this.f.getValue() != null) goto L11;
        getParentViewGroup().removeAllViews();
        getParentViewGroup().addView(r11);
        getLifecycleDispatcher().d(getUrl(), this);
        return;
    L11:
        throw new ClassCastException();
    }

    @Override // s3.e
    public final void b() {
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // s3.e
    public final void b(View r5) {
        throw null;
    }

    @Override // s3.a, s3.b
    public final boolean canBackPress() {
        getContainerModel();
        return true;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.b
    public final String getViewType() {
        return "page";
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.e
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXLitePageContainer", "===onConfigurationChanged: " + getUrl(), null, 12);
    }

    @Override // s3.a, s3.b
    public final void onCreate(Bundle r5) {
        setContainerVisible(true);
        registerWeakHolder(s3.c.class, this);
        j r10 = getLifecycleDispatcher();
        r10.getClass();
        e r11 = this.f3245i;
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        r10.f3151a.add(r11);
        if ((getBuilder() instanceof r3.a) == false) goto L5;
        ((r3.a) getBuilder()).getClass();
    L5:
        qo.a.i(this.f.getValue());
        AnnieXLiteFragment r12 = this.f3242b;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r12 = null;
    L8:
        r12.setStyle(1, R$style.annie_x_full_screen_dialog);
    }

    @Override // s3.a, s3.b
    public final void onEngineReady(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProviderFactory");
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.b
    public final void release() {
        super.release();
        if (this.f3244h == true) goto L9;
        com.bytedance.android.anniex.worker.b r5 = com.bytedance.android.anniex.worker.b.f3505a;
        String r10 = getCurrentUrl();
        Intrinsics.checkNotNullParameter(r10, "url");
        if (Intrinsics.areEqual(com.bytedance.android.anniex.worker.b.a(), Boolean.FALSE) == true) goto L8;
        h.f.b(new m(r10, 3), h.f.g);
    L8:
        this.g = false;
    L9:
        this.f3244h = true;
    }

    @Override // s3.e
    public final void a(View r5) {
        this.f3243c = r5;
        AnnieXLiteFragment r10 = this.f3242b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r10 = null;
    L5:
        Dialog r11 = r10.getDialog();
        this.d = r11;
        if (r11 == null) goto L8;
        Window r12 = r11.getWindow();
    L9:
        this.f3241a = r12;
        if (r5 == null) goto L12;
        FrameLayout r13 = (FrameLayout) r5.findViewById(R$id.annie_x_container_view);
    L13:
        if (r13 != null) goto L19;
        FragmentActivity r14 = getBuilder().f21652a;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r14 = null;
    L18:
        r13 = new FrameLayout(r14);
    L19:
        setParentViewGroup(r13);
        Window r15 = this.f3241a;
        if (r15 == null) goto L22;
        View r16 = this.f3243c;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.ViewGroup");
        Intrinsics.checkNotNullParameter(r15, "window");
        Intrinsics.checkNotNullParameter(this, "container");
        Intrinsics.checkNotNullParameter((ViewGroup) r16, "rootView");
    L22:
        initUi();
        if (this.e.getValue() != null) goto L39;
        Window r17 = this.f3241a;
        if (r17 == null) goto L27;
        r17.addFlags(Integer.MIN_VALUE);
        r17.setStatusBarColor(0);
    L27:
        Window r18 = this.f3241a;
        if (r18 == null) goto L30;
        r18.clearFlags(1024);
    L30:
        AnnieXLiteFragment r19 = this.f3242b;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r19 = null;
    L33:
        registerWeakHolder(DialogFragment.class, r19);
        registerWeakHolder(s3.b.class, this);
        Dialog r20 = this.d;
        if (r20 == null) goto L36;
        r20.setOnKeyListener(new d(this));
    L36:
        int r21 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXLitePageContainer", "===onCreateView: " + getUrl(), null, 12);
        return;
    L39:
        throw new ClassCastException();
    L12:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
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
