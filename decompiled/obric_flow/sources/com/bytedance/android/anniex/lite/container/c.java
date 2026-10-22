package com.bytedance.android.anniex.lite.container;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends v3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnieXLiteContainer f3238a;

    public c(AnnieXLiteContainer r5) {
        this.f3238a = r5;
    }

    @Override // v3.a
    public final void c(String r5, AnnieXLiteContainer r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        this.f3238a.getLifecycleDispatcher().c(r5, r10);
    }

    @Override // v3.a
    public final void f(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXContainer", "===onKitViewCreate:  " + r5, null, 12);
        AnnieXLiteContainer r12 = this.f3238a;
        AnnieXLiteContainer.access$putState(r12, 1);
        AnnieXLiteContainer.access$putState(r12, 2);
        if (r10.getKitView() == null) goto L5;
        r12.getContainerModel();
        r12.getContainerModel();
    L5:
        r12.getLifecycleDispatcher().f(r12.getUrl(), r12);
        AnnieXLiteContainer.access$bindWebOnScrollChangeListener(r12);
    }

    @Override // v3.a
    public final void g(String r5, s3.b r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        AnnieXLiteContainer r12 = this.f3238a;
        AnnieXLiteContainer.access$setLoadSuccess$p(r12, false);
        AnnieXLiteContainer.access$putState(r12, 4);
        r12.getLifecycleDispatcher().g(r12.getUrl(), r12, r11);
    }

    @Override // v3.a
    public final void h(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXContainer", "kit_view_destroy", MapsKt.mapOf(TuplesKt.to("url", r5)), 8);
        AnnieXLiteContainer r12 = this.f3238a;
        AnnieXLiteContainer.access$putState(r12, 6);
        r12.getLifecycleDispatcher().h(r12.getUrl(), r12);
    }

    @Override // v3.a
    public final void i(String r10, s3.b r11) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r11, "container");
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXContainer", "===onLoadStart:  " + r10, null, 12);
        AnnieXLiteContainer.access$putState(this.f3238a, 3);
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r11, "container");
    }

    @Override // v3.a
    public final void j(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        AnnieXLiteContainer r11 = this.f3238a;
        AnnieXLiteContainer.access$setLoadSuccess$p(r11, true);
        AnnieXLiteContainer.access$putState(r11, 4);
        r11.getLifecycleDispatcher().j(r11.getUrl(), r11);
    }

    @Override // v3.a
    public final void k(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXContainer", "===onRuntimeReady:  " + r5, null, 12);
        AnnieXLiteContainer r12 = this.f3238a;
        AnnieXLiteContainer.access$putState(r12, 5);
        r12.getLifecycleDispatcher().k(r12.getUrl(), r12);
    }
}
