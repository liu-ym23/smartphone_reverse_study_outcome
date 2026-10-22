package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ u a;

    public v(u r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        List r10 = (List) r9;
        u r0 = this.a;
        if (r0.g == false) goto L7;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L10;
        Boolean r2 = Boolean.valueOf(r1.isEngineOn());
    L12:
        if (r0.h == false) goto L14;
    L15:
        Map.Entry r3 = tc0.c.h().p;
        if (r3 == null) goto L22;
        g2 r4 = (g2) r3.getValue();
        if (r4 == null) goto L22;
        boolean r5 = true;
        if (r4.getRoomLinkSilenceStatus() != 1) goto L22;
    L23:
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L42;
        ch0.e r6 = (ch0.e) r11.next();
        StringBuilder r7 = new StringBuilder("remoteSilence ");
        r7.append(r5);
        r7.append(" user ");
        r7.append(r6.a.getInteractId());
        r7.append(" silence state ");
        kg6.e r8 = r0.c();
        String r12 = "";
        if (r8 == null) goto L32;
        String r13 = r6.a.getInteractId();
        if (r13 != null) goto L31;
        r13 = "";
    L31:
        Boolean r14 = Boolean.valueOf(r8.x(r13));
    L33:
        r7.append(r14);
        r7.append(" source list_changed");
        ALogger.w(LinkRoomFightContext.TAG, r7.toString());
        String r15 = r6.a.getInteractId();
        if (r15 == null) goto L37;
        r12 = r15;
    L37:
        r0.b(r12, "room battle cross silence");
        goto L25
    L32:
        r14 = null;
        goto L33
    L42:
        return;
    L22:
        r5 = false;
        goto L23
    L14:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L15;
        return;
    L10:
        r2 = null;
        goto L12
    L7:
        rj0.l.n2.getClass();
        rj0.l r16 = rj0.l.a.a();
        if (r16 == null) goto L10;
        r2 = Boolean.valueOf(r16.isEngineOn());
        goto L12
    }
}
