package com.bytedance.android.live.broadcastgame.widget;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveGameControlWidget$processEffectGameSticker$1 implements com.bytedance.android.live.broadcastgame.effectgame.base.a {
    public final Lazy a;
    public final /* synthetic */ LiveGameControlWidget b;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.effectgame.base.a c;
    public final /* synthetic */ u d;

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void c(int r3, Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        ALogger.i("LiveGameControlWidget", "start type=" + r3 + ' ' + r4.getName());
        com.bytedance.android.live.broadcastgame.effectgame.base.a r0 = this.c;
        if (r0 == null) goto L5;
        r0.c(r3, r4);
    L5:
        ((Map) this.a.getValue()).put(Integer.valueOf(r3), Long.valueOf(System.currentTimeMillis()));
    }

    public LiveGameControlWidget$processEffectGameSticker$1(LiveGameControlWidget r1, com.bytedance.android.live.broadcastgame.effectgame.base.a r2, u r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = LazyKt.lazy(LiveGameControlWidget$processEffectGameSticker$1$startTimes$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void d(int r11, Sticker r12, ExceptionResult r13) {
        Intrinsics.checkNotNullParameter(r12, "sticker");
        ALogger.i("LiveGameControlWidget", "fail type=" + r11 + ' ' + r12.getName());
        com.bytedance.android.live.broadcastgame.effectgame.base.a r0 = this.c;
        if (r0 == null) goto L5;
        r0.d(r11, r12, r13);
    L5:
        Long r14 = (Long) ((Map) this.a.getValue()).get(Integer.valueOf(r11));
        if (r14 == null) goto L8;
        long r1 = r14.longValue();
    L9:
        long r6 = r1;
        if (r11 != 1) goto L21;
        LiveGameControlWidget.wq(this.b, this.d, r6, false);
        IInteractGameMonitorService r2 = (IInteractGameMonitorService) k.n(IInteractGameMonitorService.class);
        u r4 = this.d;
        if (r13 == null) goto L14;
        int r8 = r13.getErrorCode();
    L15:
        if (r13 == null) goto L18;
        String r15 = r13.getMsg();
        if (r15 == null) goto L18;
    L19:
        r2.logEffectGameResourceLoad(1, r4, 3, r6, r8, r15);
        return;
    L18:
        r15 = "no error msg";
        goto L19
    L14:
        r8 = 0;
        goto L15
    L21:
        return;
    L8:
        r1 = System.currentTimeMillis();
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void a(int r11, boolean r12, int r13, Sticker r14) {
        Intrinsics.checkNotNullParameter(r14, "sticker");
        ALogger.i("LiveGameControlWidget", "success type=" + r11 + ' ' + r14.getName());
        com.bytedance.android.live.broadcastgame.effectgame.base.a r0 = this.c;
        if (r0 == null) goto L5;
        r0.a(r11, r12, r13, r14);
    L5:
        Long r15 = (Long) ((Map) this.a.getValue()).get(Integer.valueOf(r11));
        if (r15 == null) goto L8;
        long r1 = r15.longValue();
    L9:
        long r6 = r1;
        if (r11 != 1) goto L13;
        LiveGameControlWidget.wq(this.b, this.d, r6, true);
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logEffectGameResourceLoad(0, this.d, r13, r6, 0, "");
        return;
    L13:
        return;
    L8:
        r1 = System.currentTimeMillis();
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void b(int r8, int r9, long r11, Sticker r12) {
        Intrinsics.checkNotNullParameter(r12, "sticker");
        com.bytedance.android.live.broadcastgame.effectgame.base.a r1 = this.c;
        if (r1 == null) goto L6;
        r1.b(r8, r9, r11, r12);
        return;
    }
}
