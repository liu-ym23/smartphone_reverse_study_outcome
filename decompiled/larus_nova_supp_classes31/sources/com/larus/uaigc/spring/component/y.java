package com.larus.uaigc.spring.component;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y implements f4 {
    public final /* synthetic */ SpringMainVenueLynxComponent a;
    public final /* synthetic */ boolean b;

    @Override // com.larus.platform.api.f4
    public final void a() {
        FLogger.a.i("SpringMainVenueComponent", "[onTimingSetup] timeMs: " + System.currentTimeMillis());
        this.a.G = System.currentTimeMillis();
        zz9.d r1 = this.a.Z3();
        if (r1 == null) goto L15;
        SpringMainVenueLynxComponent r0 = this.a;
        Boolean r3 = r0.C;
        a0a.b r2 = r0.G3();
        long r4 = -1;
        if (r2 == null) goto L13;
        Bundle r5 = r2.a;
        if (r5 == null) goto L9;
        long r6 = r5.getLong("schema_handle_time");
    L10:
        Long r7 = Long.valueOf(r6);
        if (r7 == null) goto L13;
        r4 = r7.longValue();
        goto L13
    L9:
        r6 = -1;
    L13:
        SpringMainVenueLynxComponent r8 = this.a;
        long r9 = r8.F;
        long r10 = r8.G;
        r1.uI(this.b, r3, r4, r8.E, r9, r10, r8.D);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void f() {
        FLogger.a.i("SpringMainVenueComponent", "[onViewDestroy] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadStart() {
        FLogger.a.i("SpringMainVenueComponent", "[onLoadStart] timeMs: " + System.currentTimeMillis());
        this.a.E = System.currentTimeMillis();
    }

    @Override // com.larus.platform.api.f4
    public final void b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.i("SpringMainVenueComponent", "[onFallback] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void c(BulletContainerView r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i("SpringMainVenueComponent", "[onRuntimeReady] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void d(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i("SpringMainVenueComponent", "[onViewCreate] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void e(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        FLogger r0 = FLogger.a;
        r0.i("SpringMainVenueComponent", "[onLoadFail] timeMs: " + System.currentTimeMillis());
        r0.i("SpringMainVenueComponent", "[onLoadFail] e: " + r5.getMessage());
        SpringMainVenueLynxComponent r1 = this.a;
        r1.C = Boolean.FALSE;
        r1.D = r5.getMessage();
        SpringMainVenueLynxComponent.Y2(this.a);
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadSuccess(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i("SpringMainVenueComponent", "[onLoadSuccess] timeMs: " + System.currentTimeMillis());
        SpringMainVenueLynxComponent r5 = this.a;
        r5.C = Boolean.TRUE;
        SpringMainVenueLynxComponent.Y2(r5);
    }

    public y(SpringMainVenueLynxComponent r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
