package com.bytedance.android.anniex.container;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.bytedance.android.anniex.container.ui.AnnieXDialog;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$style;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AnnieXContainer implements s3.e, s3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f3158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnnieXDialog f3159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SheetBaseDialog f3160c;
    public int d;
    public defpackage.b e;
    public View f;

    public m(r3.c r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        super(r5);
        FragmentActivity r10 = r5.f21650i;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentActivity");
        r10 = null;
    L6:
        this.f3158a = r10;
        Lazy r11 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r11.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r11.getValue()).getClass();
        this.d = ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // s3.e
    public final void a(View r10) {
        setRootView(r10);
        if (r10 == null) goto L5;
        FrameLayout r11 = (FrameLayout) r10.findViewById(R$id.annie_x_container_view);
    L6:
        FragmentActivity r5 = this.f3158a;
        if (r11 != null) goto L9;
        r11 = new FrameLayout(r5);
    L9:
        setParentViewGroup(r11);
        Window r12 = r5.getWindow();
        r12.getDecorView().getSystemUiVisibility();
        int r13 = r12.getAttributes().flags;
        r12.getStatusBarColor();
        View r14 = getRootView();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.ViewGroup");
        this.e = new defpackage.b(r5, this, (ViewGroup) r14);
        initUi();
        View r15 = getRootView();
        if (r15 == null) goto L12;
        View r16 = r15.findViewById(R$id.annie_x_activity_close_left);
    L13:
        this.f = r16;
        SheetBaseDialog r17 = this.f3160c;
        if (r17 == null) goto L16;
        r17.hide();
    L16:
        int r18 = getContext().getResources().getDisplayMetrics().widthPixels;
        DisplayMetrics r19 = new DisplayMetrics();
        WindowManager r20 = r5.getWindowManager();
        if (r20 == null) goto L20;
        r20.getDefaultDisplay().getRealMetrics(r19);
    L20:
        int r21 = r19.heightPixels;
        int r22 = r21 - getRealNavigationBarHeight();
        if (kk.a.h(r5) == true) goto L24;
        r21 = r22;
    L24:
        int r23 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", com.lynx.tasm.base.h.b(r21, r18, "screenHeight: ", "; screenWidth: "), null, 12);
        Window r24 = r5.getWindow();
        if (r24 == null) goto L27;
        this.d = r24.getStatusBarColor();
    L27:
        SheetBaseDialog r25 = this.f3160c;
        if (r25 == null) goto L32;
        Window r26 = r25.getWindow();
        if (r26 == null) goto L32;
        r26.addFlags(Integer.MIN_VALUE);
        r26.setStatusBarColor(0);
        r26.setNavigationBarColor(0);
    L32:
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", "===onCreateView: " + getUrl(), null, 12);
        return;
    L12:
        r16 = null;
        goto L13
    L5:
        r11 = null;
        goto L6
    }

    @Override // s3.e
    public final void b() {
        throw null;
    }

    @Override // s3.e
    public final void b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        SheetBaseDialog r11 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", "===onViewCreated: " + getUrl(), null, 12);
        SheetBaseDialog r12 = this.f3160c;
        if (r12 != null) goto L6;
        r12 = null;
    L6:
        if (r12 == null) goto L8;
        r12.g = new z(this);
    L8:
        View r13 = getRootView();
        if (r13 == null) goto L11;
        r13.setOnClickListener(new l(this, 0));
    L11:
        SheetBaseDialog r14 = this.f3160c;
        if (r14 != null) goto L15;
        r14 = null;
    L15:
        if (r14 == null) goto L17;
        Intrinsics.checkNotNullParameter(new uj.a(), "bottomSheetPullUpProcessor");
    L17:
        SheetBaseDialog r15 = this.f3160c;
        if (r15 != null) goto L21;
        r15 = null;
    L21:
        if (r15 == null) goto L23;
        Intrinsics.checkNotNullParameter(new wc.f(3), "bottomSheetSlideProcessor");
    L23:
        SheetBaseDialog r16 = this.f3160c;
        if (r16 == null) goto L26;
        r11 = r16;
    L26:
        if (r11 == null) goto L30;
        com.bytedance.frameworks.baselib.network.http.cronet.b r17 = new com.bytedance.frameworks.baselib.network.http.cronet.b(4);
        ArrayList r18 = r11.f;
        if (r18.contains(r17) == true) goto L30;
        r18.add(r17);
    L30:
        SheetBaseDialog r19 = this.f3160c;
        if (r19 == null) goto L34;
        r19.getWindow();
        return;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, s3.b
    public final String getViewType() {
        return OpenPageMethod.APP_POPUP;
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void observerKeyboardStatusChange() {
        super.observerKeyboardStatusChange();
        SheetBaseDialog r5 = this.f3160c;
        if (r5 == null) goto L12;
        Function1<Boolean, Unit> r10 = getOnSoftInputChangeListener$anniex_release();
        Window r11 = r5.getWindow();
        if (r11 == null) goto L7;
        View r12 = r11.getDecorView();
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Window r13 = r5.getWindow();
        if (r13 == null) goto L13;
        qo.a.f(r13, r12, r10);
        Unit r14 = Unit.INSTANCE;
        return;
    L13:
        return;
    L7:
        r12 = null;
        goto L8
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, s3.e
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", "===onConfigurationChanged: " + getUrl(), null, 12);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, s3.b
    public final void onCreate(Bundle r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        AnnieXDialog r11 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXPopupContainer", "===onCreate: " + getUrl(), null, 12);
        setContainerVisible(true);
        if (kk.a.h(this.f3158a) == false) goto L10;
        AnnieXDialog r12 = this.f3159b;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L8:
        r11.setStyle(1, R$style.annie_x_no_floating_dialog);
        return;
    L7:
        r11 = r12;
        goto L8
    L10:
        AnnieXDialog r13 = this.f3159b;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
    L14:
        r11.setStyle(1, R$style.annie_x_floating_dialog);
        return;
    L13:
        r11 = r13;
        goto L14
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void onWebPageFinish(WebView r5, String r10) {
        super.onWebPageFinish(r5, r10);
        ab.b r11 = new ab.b(2, r5, this);
        this.f3158a.runOnUiThread(r11);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public final void parseSchema() {
        rd.b r5 = getBulletContext().e;
        if (r5 == null) goto L5;
        Lazy r10 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r5, f4.a.class);
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r5, f4.b.class);
    L5:
        com.bytedance.ies.bullet.core.e r11 = getBulletContext();
        Scenes r12 = Scenes.f5283c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.f5295i = r12;
        com.bytedance.ies.bullet.core.e r13 = getBulletContext();
        Components r14 = Components.d;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.f5296j = r14;
        super.parseSchema();
    }

    @Override // s3.e
    public final void a() {
        enterForeground();
        if (com.bytedance.android.anniex.container.util.b.b(this) == false) goto L6;
        onVisibleChange(true, Boolean.TRUE);
        return;
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
