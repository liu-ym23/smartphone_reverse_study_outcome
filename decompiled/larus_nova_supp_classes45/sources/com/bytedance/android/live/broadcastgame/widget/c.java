package com.bytedance.android.live.broadcastgame.widget;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.live.broadcastgame.effectgame.base.c.b {
    public final /* synthetic */ LiveGameControlWidget a;
    public final /* synthetic */ List b;

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.c.b
    public final void onFail(ExceptionResult r3) {
        ALogger.e("LiveGameControlWidget", "batch fetch error: " + r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.c.b
    public final void onSuccess(List<Sticker> r12) {
        Intrinsics.checkNotNullParameter(r12, "sticker");
        ALogger.d("LiveGameControlWidget", "get effect model: " + r12.size());
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L27;
        Sticker r0 = (Sticker) r13.next();
        LiveGameControlWidget r3 = this.a;
        List r4 = this.b;
        int r5 = LiveGameControlWidget.f;
        r3.getClass();
        ArrayList r6 = new ArrayList();
        Iterator r7 = r4.iterator();
    L7:
        if (r7.hasNext() == false) goto L18;
        Object r8 = r7.next();
        r r9 = ((u) r8).c();
        if (r9 == null) goto L11;
        long r11 = r9.l();
    L13:
        if (r11 != r0.getId()) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L7;
        r6.add(r8);
        goto L7
    L15:
        r14 = false;
        goto L16
    L11:
        r11 = 0;
        goto L13
    L18:
        Iterator r1 = r6.iterator();
    L20:
        if (r1.hasNext() == false) goto L4;
        u r2 = (u) r1.next();
        r r15 = r2.c();
        if (r15 == null) goto L24;
        r15.a = r0;
    L24:
        r r16 = r2.c();
        if (r16 == null) goto L20;
        com.bytedance.android.live.broadcastgame.effectgame.base.c.a(r0, r16);
        goto L20
    L27:
        List r17 = this.b;
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L29:
        if (r19.hasNext() == false) goto L38;
        Object r21 = r19.next();
        r r22 = ((u) r21).c();
        if (r22 != null) goto L33;
    L35:
        boolean r23 = false;
    L36:
        if (r23 == false) goto L29;
        r18.add(r21);
        goto L29
    L33:
        if (r22.d() != true) goto L35;
        r23 = true;
        goto L36
    L38:
        LiveGameControlWidget r24 = this.a;
        long r25 = System.currentTimeMillis();
        ArrayList r26 = new ArrayList();
        LinkedHashMap r27 = new LinkedHashMap();
        int r110 = LiveGameControlWidget.f;
        r24.xq(r18, r25, r26, r27, 0);
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logEffectBatchLoadStart(r18);
    }

    public c(LiveGameControlWidget r1, List r2) {
        this.a = r1;
        this.b = r2;
    }
}
