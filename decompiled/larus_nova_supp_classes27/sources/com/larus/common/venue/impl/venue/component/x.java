package com.larus.common.venue.impl.venue.component;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x implements f4 {
    public final /* synthetic */ FlowCommonVenueLynxComponent a;

    public final void a() {
        FLogger.a.i("FlowCommonVenueComponent", "[onTimingSetup] timeMs: " + System.currentTimeMillis());
        this.a.D = System.currentTimeMillis();
        v09.c r1 = this.a.Q3();
        if (r1 == null) goto L15;
        FlowCommonVenueLynxComponent r0 = this.a;
        Boolean r2 = r0.z;
        x09.a r3 = r0.C3();
        long r4 = -1;
        if (r3 == null) goto L13;
        Bundle r5 = r3.a;
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
        FlowCommonVenueLynxComponent r8 = this.a;
        r1.Fd(r2, r4, r8.B, r8.C, r8.D, r8.A);
        return;
    }

    public final void f() {
        FLogger.a.i("FlowCommonVenueComponent", "[onViewDestroy] timeMs: " + System.currentTimeMillis());
    }

    public final void onLoadStart() {
        FLogger.a.i("FlowCommonVenueComponent", "[onLoadStart] timeMs: " + System.currentTimeMillis());
        this.a.B = System.currentTimeMillis();
    }

    public x(FlowCommonVenueLynxComponent r1) {
        this.a = r1;
    }

    public final void b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.i("FlowCommonVenueComponent", "[onFallback] timeMs: " + System.currentTimeMillis());
    }

    public final void c(BulletContainerView r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i("FlowCommonVenueComponent", "[onRuntimeReady] timeMs: " + System.currentTimeMillis());
    }

    public final void d(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i("FlowCommonVenueComponent", "[onViewCreate] timeMs: " + System.currentTimeMillis());
    }

    public final void e(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        FLogger r0 = FLogger.a;
        r0.i("FlowCommonVenueComponent", "[onLoadFail] timeMs: " + System.currentTimeMillis());
        r0.i("FlowCommonVenueComponent", "[onLoadFail] e: " + r5.getMessage());
        FlowCommonVenueLynxComponent r1 = this.a;
        r1.z = Boolean.FALSE;
        r1.A = r5.getMessage();
        FlowCommonVenueLynxComponent.Y2(this.a);
    }

    public final void onLoadSuccess(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i("FlowCommonVenueComponent", "[onLoadSuccess] timeMs: " + System.currentTimeMillis());
        FlowCommonVenueLynxComponent r5 = this.a;
        r5.z = Boolean.TRUE;
        FlowCommonVenueLynxComponent.Y2(r5);
    }
}
