package br0;

import android.os.Bundle;
import android.view.Surface;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends lr0.a {

    public static final class a implements Runnable {
        public final /* synthetic */ Surface a;
        public final /* synthetic */ k b;

        public a(Surface r1, k r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LiveMgCastContextService r0 = (LiveMgCastContextService) this.b.a.getService(LiveMgCastContextService.class);
            Surface r1 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "gameSurface");
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r2 = AnchorMiniGameDataContext.a.a();
            d0 r3 = null;
            if (r2 == null) goto L7;
            com.bytedance.live.datacontext.m<Boolean> r4 = r2.getOpenCamera();
            if (r4 == null) goto L7;
            Boolean r5 = (Boolean) r4.getValue();
        L9:
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L11;
            return;
        L11:
            if (r0.d == null) goto L13;
            return;
        L13:
            if (r0.h == false) goto L27;
            Integer r6 = (Integer) com.bytedance.android.livesdk.sharedpref.b.a.a();
            if (r6 == null) goto L20;
            boolean r7 = true;
            if (r6.intValue() != 1) goto L20;
        L21:
            if (r7 == false) goto L23;
            int r8 = 90;
        L24:
            com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c r9 = r0.a;
            if (r9 == null) goto L27;
            r9.a(r8);
            goto L27
        L23:
            r8 = 270;
        L20:
            r7 = false;
        L27:
            com.bytedance.android.live.openplatform.impl.minigameanchor.cast.a r10 = new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.a(r1);
            r0.d = r10;
            IPushStreamService r11 = jc1.k.f(IPushStreamService.class);
            if (r11 == null) goto L32;
            com.bytedance.android.live.pushstream.d r12 = r11.getPushLiveStream();
            if (r12 == null) goto L32;
            r3 = r12.A();
        L32:
            r10.c = r3;
            if (r3 == null) goto L35;
            r3.g0();
        L35:
            int r13 = qo0.a.a;
            qo0.a.c(r10.a, "startRender liveStream:" + r10.c);
            return;
        L7:
            r5 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public k(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r4) {
        qo0.a.c("minigame_live_cast", "onEvent on_live_biz_start_camera_preview");
        if (((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).i() == false) goto L10;
        if (r4 == null) goto L11;
        Surface r5 = (Surface) r4.getParcelable("camera_preview_surface");
        if (r5 == null) goto L12;
        qo0.a.c("minigame_live_cast", "onEvent on_live_biz_start_camera_preview, surface: " + r5);
        i0.c().post(new a(r5, this));
        return null;
    L12:
        return null;
    L11:
        return null;
    L10:
        return null;
    }
}
