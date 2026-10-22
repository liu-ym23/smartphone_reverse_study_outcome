package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import o22.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VSLandscapeDanmakuCarnivalTrayManager {
    public static final /* synthetic */ int d = 0;
    public d a;
    public o22.c b;
    public final DataCenter c;

    public static final class a {
    }

    public final class b implements o22.c {
        public final /* synthetic */ VSLandscapeDanmakuCarnivalTrayManager a;

        @Override // o22.c
        public final void g(d r1, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "manager");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public b(VSLandscapeDanmakuCarnivalTrayManager r1) {
            this.a = r1;
        }

        @Override // o22.c
        public final void a(DanmakuCarnivalManager r3, j r4) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            Intrinsics.checkNotNullParameter(r4, "msg");
            Intrinsics.checkNotNullParameter(r3, "manager");
            Intrinsics.checkNotNullParameter(r4, "msg");
        }

        @Override // o22.c
        public final void b(DanmakuCarnivalManager r2, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
            VSLandscapeDanmakuCarnivalTrayManager r4 = this.a;
            int r5 = VSLandscapeDanmakuCarnivalTrayManager.d;
            r4.getClass();
            VSLandscapeDanmakuCarnivalTrayManager.a("end carnival ");
        }

        @Override // o22.c
        public final void c(DanmakuCarnivalManager r2, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
            VSLandscapeDanmakuCarnivalTrayManager r4 = this.a;
            int r5 = VSLandscapeDanmakuCarnivalTrayManager.d;
            r4.getClass();
            VSLandscapeDanmakuCarnivalTrayManager.a("onCarnivalStop");
        }

        @Override // o22.c
        public final void d(d r4, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r5) {
            Intrinsics.checkNotNullParameter(r4, "manager");
            Intrinsics.checkNotNullParameter(r5, "msg");
            IVSPlayerService r6 = k.f(IVSPlayerService.class);
            if (r6 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.b r7 = r6.provideVSPlayerTipService(this.a.c);
            if (r7 == null) goto L7;
            r7.hidePlayerTip("danmaku_carnival");
        L7:
            com.bytedance.android.livesdk.interactivity.api.barrage.model.a r8 = r4.c();
            VSLandscapeDanmakuCarnivalTrayManager r9 = this.a;
            StringBuilder r0 = new StringBuilder("start carnival , remain duration = ");
            if (r8 == null) goto L10;
            long r1 = r8.n();
        L11:
            r0.append(r1);
            String r2 = r0.toString();
            int r3 = VSLandscapeDanmakuCarnivalTrayManager.d;
            r9.getClass();
            VSLandscapeDanmakuCarnivalTrayManager.a(r2);
            VSLandscapeDanmakuCarnivalTrayManager r10 = this.a;
            r10.getClass();
            LinkedHashMap r11 = new LinkedHashMap();
            z.a r13 = z.a;
            DataCenter r14 = r10.c;
            r13.getClass();
            if (z.a.a(r14) == false) goto L14;
            r11.put("show_area", "public_screen_emphasize");
        L15:
            com.bytedance.android.livesdk.interactivity.common.utils.c.b(r8, "comment", r11);
            return;
        L14:
            r11.put("show_area", "public_screen_normal");
            goto L15
        L10:
            r1 = 0;
            goto L11
        }

        @Override // o22.c
        public final void f(d r4, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r5) {
            Intrinsics.checkNotNullParameter(r4, "manager");
            Intrinsics.checkNotNullParameter(r5, "msg");
            String r6 = r5.i();
            if (r6 != null) goto L5;
        L12:
            r6 = "即将进入狂欢时刻";
        L13:
            IVSPlayerService r1 = k.f(IVSPlayerService.class);
            if (r1 == null) goto L18;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.b r2 = r1.provideVSPlayerTipService(this.a.c);
            if (r2 == null) goto L18;
            r2.showPlayerTip("danmaku_carnival", r6, true);
        L18:
            VSLandscapeDanmakuCarnivalTrayManager r7 = this.a;
            String r8 = "start warming up show tips, pre content = " + r5.i() + '}';
            int r0 = VSLandscapeDanmakuCarnivalTrayManager.d;
            r7.getClass();
            VSLandscapeDanmakuCarnivalTrayManager.a(r8);
            return;
        L5:
            if (r6.length() <= 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == true) goto L11;
            r6 = null;
        L11:
            if (r6 != null) goto L13;
        L7:
            r3 = false;
            goto L8
        }

        @Override // o22.c
        public final void e(DanmakuCarnivalManager r2, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }
    }

    static {
    }

    public VSLandscapeDanmakuCarnivalTrayManager(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
        BarrageWidgetContext r3 = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(null, r2);
        if (r3 == null) goto L8;
        com.bytedance.live.datacontext.j<d> r4 = r3.getDanmakuCarnivalManager();
        if (r4 == null) goto L9;
        r4.c(new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public static void a(String r1) {
        ALogger.i("CARNIVAL_MESSAGE_LANDSCAPE", r1);
    }
}
