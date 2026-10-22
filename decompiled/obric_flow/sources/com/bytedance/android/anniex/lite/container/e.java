package com.bytedance.android.anniex.lite.container;

import com.scwang.smartrefresh.layout.constant.RefreshState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends v3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3240a;

    public e(f r5) {
        this.f3240a = r5;
    }

    @Override // v3.a
    public final void g(String r5, s3.b r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        super.g(r5, r10, r11);
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXLitePageContainer", "===onLoadFail: " + this.f3240a.getUrl(), null, 12);
        this.f3240a.getClass();
        if (RefreshState.Refreshing != null) goto L6;
        this.f3240a.getClass();
        f.c(this.f3240a.getUrl(), "refresh failed", r11.getMessage());
        return;
    }

    @Override // v3.a
    public final void j(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXLitePageContainer", "===onLoadSuccess: " + this.f3240a.getUrl(), null, 12);
        this.f3240a.getClass();
        if (RefreshState.Refreshing != null) goto L6;
        this.f3240a.getClass();
        f.c(this.f3240a.getUrl(), "refresh success", null);
        return;
    }
}
