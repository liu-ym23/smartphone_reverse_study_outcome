package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfig;
import com.bytedance.android.livesdk.config.sp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y0 extends b7.a {
    public ih0.c a;
    public int b;
    public long c;
    public final Uri d;
    public final Function0<Unit> e;

    public final void onRelease() {
        super.onRelease();
        ALogger.i("MultiLinkDynamicWidget", "main HybridCard onRelease, url:" + this.d);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.e(String.valueOf(this.d), "render", "root", System.currentTimeMillis() - this.c);
    }

    public final void onLoadSuccess(View r2) {
        super.onLoadSuccess(r2);
        ALogger.i("MultiLinkDynamicWidget", "render HybridCard load success");
    }

    public y0(Uri r1, Function0<Unit> r2) {
        this.d = r1;
        this.e = r2;
    }

    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onFallback errorMessage=" + r11);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_error", String.valueOf(this.d), "render", "root", r10, r11, System.currentTimeMillis() - this.c);
        return super.onFallback(r10, r11);
    }

    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        super.onInnerFallback(r10, r11);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onInnerFallback errorMessage=" + r11);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_inner_error", String.valueOf(this.d), "render", "root", r10, r11, System.currentTimeMillis() - this.c);
    }

    public final void onLoadStart(View r1, boolean r2) {
        super.onLoadStart(r1, r2);
        this.c = System.currentTimeMillis();
    }

    public final void onContainerError(View r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        super.onContainerError(r9, r10, r11);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onContainerError errorMessage=" + r11);
        int r12 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("container_error", String.valueOf(this.d), "render", "root", r10, r11, System.currentTimeMillis() - this.c);
    }

    public final void onLoadFail(View r8, String r9, String r10) {
        super.onLoadFail(r8, r9, r10);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard load fail reason=" + r10);
        this.a = null;
        Function0<Unit> r11 = this.e;
        if (r11 == null) goto L5;
        Unit r12 = (Unit) r11.invoke();
    L5:
        int r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(String.valueOf(this.d), "render", "root", System.currentTimeMillis() - this.c, r10);
        if (this.b >= ((MultiLinkRevenueEnterRoomOptConfig) sp.a.getValue()).reloadCount()) goto L11;
        this.b++;
        ih0.c r14 = this.a;
        if (r14 == null) goto L12;
        ih0.c.a.a(r14, null, null, 7);
        return;
    L12:
        return;
    }
}
