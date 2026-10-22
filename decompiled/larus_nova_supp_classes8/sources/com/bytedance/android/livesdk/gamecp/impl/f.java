package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.OpenMiniAppCallback;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements IGameCpGameService {

    public static final class a implements qv.d {
        public final /* synthetic */ OpenMiniAppCallback a;

        public a(OpenMiniAppCallback r1) {
            this.a = r1;
        }

        public final void onFail(int r2, String r3) {
            OpenMiniAppCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onFail(r2, r3);
            return;
        }
    }

    public f() {
    }

    public final void preloadMiniGame(String r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.h r1 = r0.getGameService();
        if (r1 == null) goto L9;
        r1.preloadMiniGame(r2);
        return;
    L9:
        return;
    }

    public final void openExternalBrowser(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "gameId");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.h r1 = r0.getGameService();
        if (r1 == null) goto L9;
        r1.openExternalBrowser(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void preloadInteractGame(String r2, String r3, Function0<Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "suc");
        Intrinsics.checkNotNullParameter(r5, "failCheck");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.h r1 = r0.getGameService();
        if (r1 == null) goto L9;
        r1.preloadInteractGame(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    public final void openLiveMiniPlay(Context r8, String r9, Map<String, ? extends Object> r10, Function0<Unit> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "ctx");
        Intrinsics.checkNotNullParameter(r9, "schema");
        Intrinsics.checkNotNullParameter(r10, "meta");
        Intrinsics.checkNotNullParameter(r11, "suc");
        Intrinsics.checkNotNullParameter(r12, "failCheck");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.h r1 = r0.getGameService();
        if (r1 == null) goto L9;
        r1.openLiveMiniPlay(r8, r9, r10, r11, r12);
        return;
    L9:
        return;
    }

    public final void openMiniApp(int r10, String r11, boolean r12, String r13, String r14, Integer r15, OpenMiniAppCallback r16) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.h r1 = r0.getGameService();
        if (r1 == null) goto L9;
        xr.h.a.a(r1, r10, r11, r12, r13, r14, r15, new a(r16));
        return;
    L9:
        return;
    }
}
