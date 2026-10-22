package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.m;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.n;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.obric.launcher.widget.R$id;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AnnieXLiteContainer implements s3.d, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f3235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f3236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3237c;
    public volatile boolean d;
    public final Lazy e;
    public final Lazy f;

    public a(r3.b r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        super(r5);
        FragmentActivity r10 = r5.f21647i;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r10 = null;
    L6:
        this.f3235a = r10;
        this.e = LazyKt.lazy(new AnnieXFlowPageContainer$annieXStatusAndNavModel$2(this));
        this.f = LazyKt.lazy(new AnnieXFlowPageContainer$pageModel$2(this));
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

    @Override // s3.a, s3.b
    public final boolean canBackPress() {
        Lazy r5 = com.bytedance.android.anniex.detect.a.f3206a;
        getKitView();
        rd.b r10 = getAnnieXContext().f.f21723a;
        ((com.bytedance.android.anniex.detect.b) com.bytedance.android.anniex.detect.a.f3206a.getValue()).getClass();
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXBlankDetect", "总开关关闭，无需白屏检测", null, 12);
        a4.a r11 = getAnnieXContext();
        Intrinsics.checkNotNullParameter(this, "pageContainer");
        Intrinsics.checkNotNullParameter(r11, "annieXContext");
        if (xq.b.k() == false) goto L7;
        tc.c r12 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.android.anniex.base.service.a.class, getBid()) == null) goto L7;
        throw new ClassCastException();
    L7:
        getContainerModel();
        return true;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.b
    public final void close() {
        super.close();
        this.f3235a.finish();
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String d() {
        String r5 = (String) new vd.a(getAnnieXContext().f.f21723a, "bundle", null).f22372b;
        if (r5 != null) goto L8;
        String r10 = getBuilder().f21654c.getString("__x_param_bundle");
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    L8:
        return r5;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String e() {
        return (String) new vd.a(getAnnieXContext().f.f21723a, "bdx_tag", null).f22372b;
    }

    @Override // s3.a, s3.b
    public final void finish() {
        qo.a.i(this.f.getValue());
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getChannel() {
        String r5 = (String) new vd.a(getAnnieXContext().f.f21723a, LynxMonitorService.KEY_CHANNEL, null).f22372b;
        if (r5 != null) goto L8;
        String r10 = getBuilder().f21654c.getString("__x_param_channel");
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    L8:
        return r5;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.b
    public final String getContainerId() {
        return getAnnieXContext().f90b;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final Scenes getScenes() {
        return Scenes.f5284h;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final Uri getSchema() {
        return Uri.parse(getCurrentUrl());
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.b
    public final String getViewType() {
        return "page";
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public final void loadSchema(String r5, Map r10, rb.b r11, v3.a r12) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        rb.b r13 = getAnnieXContext().f92h;
        r13.getClass();
        Intrinsics.checkNotNullParameter(s3.b.class, "clazz");
        r13.b(s3.b.class, new rb.a(this, 0));
        registerWeakHolder(s3.c.class, this);
        ConcurrentHashMap r14 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r15 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r15 == null) goto L9;
        xc.d r16 = (xc.d) r15.a(xc.d.class);
        if (r16 == null) goto L9;
        Boolean r17 = r16.R();
        if (r17 == null) goto L9;
        boolean r18 = r17.booleanValue();
    L10:
        if (r18 == false) goto L12;
        registerWeakHolder(Activity.class, this.f3235a);
    L12:
        super.loadSchema(r5, r10, r11, r12);
        return;
    L9:
        r18 = true;
        goto L10
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.e
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXFlowPageContainer", "===onConfigurationChanged: " + getUrl(), null, 12);
    }

    @Override // s3.a, s3.b
    public final void onCreate(Bundle r13) {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXFlowPageContainer", "===onCreate: " + getUrl(), null, 12);
        setContainerVisible(true);
        com.bytedance.ies.bullet.service.base.router.config.b r10 = (com.bytedance.ies.bullet.service.base.router.config.b) com.bytedance.ies.bullet.service.base.router.config.b.f6000c.getValue();
        String r11 = getAnnieXContext().f90b;
        r10.getClass();
        Intrinsics.checkNotNullParameter(this, "item");
        com.bytedance.ies.bullet.base.utils.logger.b r12 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r14 = "";
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r11, r12.f5260a);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
        Pair r16 = TuplesKt.to("popup url", String.valueOf(Uri.parse(getCurrentUrl())));     // Catch: Throwable -> L10
        ArrayList r17 = r10.f6002b;
        Map r18 = MapsKt.mapOf(new Pair[]{r16, TuplesKt.to("popup stack", r17.toString())});     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter("add popup to stack", "msg");     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "add popup to stack", r18, r12);     // Catch: Throwable -> L10
        Object r19 = Result.m124constructorimpl(Boolean.valueOf(r17.add(this)));     // Catch: Throwable -> L10
    L12:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 == null) goto L20;
        int r21 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Pair r110 = TuplesKt.to("activity url", String.valueOf(Uri.parse(getCurrentUrl())));
        String r22 = r20.getMessage();
        if (r22 == null) goto L18;
        r14 = r22;
    L18:
        Map r111 = MapsKt.mapOf(new Pair[]{r110, TuplesKt.to("error message", r14)});
        Intrinsics.checkNotNullParameter("XPage", "moduleTag");
        Intrinsics.checkNotNullParameter("add stack error", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XPage", "add stack error", r111, r12);
    L20:
        if (this.f.getValue() != null) goto L23;
        return;
    L23:
        throw new ClassCastException();
    L10:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // s3.a, s3.b
    public final void onEngineReady(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProviderFactory");
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, s3.b
    public final void release() {
        super.release();
        if (this.d == true) goto L24;
        com.bytedance.ies.bullet.service.base.router.config.b r5 = (com.bytedance.ies.bullet.service.base.router.config.b) com.bytedance.ies.bullet.service.base.router.config.b.f6000c.getValue();
        String r10 = getAnnieXContext().f90b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "item");
        com.bytedance.ies.bullet.base.utils.logger.b r11 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r12 = "";
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r10, r11.f5260a);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L10
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L10
        Map r15 = MapsKt.mapOf(TuplesKt.to("popup url", String.valueOf(Uri.parse(getCurrentUrl()))));     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter("remove popup to stack", "msg");     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "remove popup to stack", r15, r11);     // Catch: Throwable -> L10
        Object r16 = Result.m124constructorimpl(Boolean.valueOf(r5.f6002b.remove(this)));     // Catch: Throwable -> L10
    L12:
        Throwable r17 = Result.m127exceptionOrNullimpl(r16);
        if (r17 == null) goto L19;
        int r18 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Pair r19 = TuplesKt.to("activity url", String.valueOf(Uri.parse(getCurrentUrl())));
        String r20 = r17.getMessage();
        if (r20 == null) goto L18;
        r12 = r20;
    L18:
        Map r21 = MapsKt.mapOf(new Pair[]{r19, TuplesKt.to("error message", r12)});
        Intrinsics.checkNotNullParameter("XPage", "moduleTag");
        Intrinsics.checkNotNullParameter("remove stack error", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XPage", "remove stack error", r21, r11);
    L19:
        com.bytedance.android.anniex.worker.b r22 = com.bytedance.android.anniex.worker.b.f3505a;
        String r23 = getCurrentUrl();
        Intrinsics.checkNotNullParameter(r23, "url");
        if (Intrinsics.areEqual(com.bytedance.android.anniex.worker.b.a(), Boolean.FALSE) == true) goto L23;
        h.f.b(new m(r23, 3), h.f.g);
    L23:
        this.f3237c = false;
    L10:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L24:
        this.d = true;
    }

    @Override // s3.e
    public final void a() {
        onVisibleChange(true, Boolean.FALSE);
        if (this.f3237c == true) goto L6;
        this.f3237c = true;
        com.bytedance.android.anniex.worker.b r5 = com.bytedance.android.anniex.worker.b.f3505a;
        String r10 = getCurrentUrl();
        String r11 = getBid();
        com.bytedance.android.anniex.worker.b.c(getKitType(), r10, r11);
        return;
    }

    @Override // s3.e
    public final void b() {
        onVisibleChange(false, Boolean.FALSE);
    }

    @Override // s3.e
    public final void a(View r5) {
        this.f3236b = r5;
        if (r5 == null) goto L5;
        FrameLayout r10 = (FrameLayout) r5.findViewById(R$id.annie_x_container_view);
    L6:
        FragmentActivity r11 = this.f3235a;
        if (r10 != null) goto L9;
        r10 = new FrameLayout(r11);
    L9:
        setParentViewGroup(r10);
        View r12 = this.f3236b;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(this, "container");
        Intrinsics.checkNotNullParameter((ViewGroup) r12, "rootView");
        initUi();
        if (this.e.getValue() != null) goto L14;
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXFlowPageContainer", "===onCreateView: " + getUrl(), null, 12);
        return;
    L14:
        throw new ClassCastException();
    L5:
        r10 = null;
        goto L6
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
