package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w {
    public static String a() {
        ArrayList r0 = new ArrayList();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r1 == null) goto L19;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.m r3 = r2.getPlayModes();
        if (r3 == null) goto L19;
        Set r4 = (Set) r3.getValue();
        if (r4 == null) goto L19;
        Sequence r5 = CollectionsKt.asSequence(r4);
        if (r5 == null) goto L19;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        String r7 = c(((Number) r6.next()).intValue());
        if ((!Intrinsics.areEqual(r7, "normal")) == false) goto L14;
        r0.add(r7);
    L19:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 16) goto L22;
        r0.add("link_room");
    L22:
        if (r0.size() != 0) goto L25;
        r0.add("normal");
    L25:
        return CollectionsKt.joinToString$default(r0, ",", "[", "]", 0, null, null, 56, null);
    }

    static {
    }

    public static void b(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r0 = ((IInteractService) jc1.k.n(IInteractService.class)).guestBattleContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isGameShowing() == false) goto L9;
        HashMap r3 = (HashMap) r2;
        r3.put("compete_mode", String.valueOf(r0.getCurrentScoreType()));
        return;
    }

    public static String c(int r1) {
        String r2 = x.a.get(Integer.valueOf(r1));
        if (r2 != null) goto L6;
        r2 = "normal";
    L6:
        return r2.concat("");
    }
}
