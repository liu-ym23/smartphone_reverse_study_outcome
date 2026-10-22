package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ y a;

    public a0(y r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        y r0 = this.a;
        SeiAppData r15 = ((b.C0054b) r14).b;
        String r3 = null;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.n(r0.l, null, 2).getRoom();
        if (r1 == null) goto L8;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L8;
        r3 = String.valueOf(r2.getId());
    L8:
        if ((!Intrinsics.areEqual(r15.getChannelId(), r3)) == false) goto L11;
        ALogger.d("SeiHandlerV2", "sei channel id wrong " + r15.getChannelId() + " room " + r3);
        return;
    L11:
        if (r0.b.a == r15.getVersion()) goto L13;
    L18:
        r0.b = new b.a(r15.getVersion(), r15.getUiLayout(), r15.getStyle(), r15.getSubUILayout());
        r0.a().C0(r0.b);
    L19:
        ArrayList r4 = new ArrayList();
        int r5 = r15.getGrids().size();
        int r6 = 0;
        boolean r7 = false;
    L20:
        if (r6 >= r5) goto L22;
        SeiRegion r8 = (SeiRegion) ListProtector.get(r15.getGrids(), r6);
        r4.add(new ch0.j(r8.getInteractId(), r8.isTalking(), r8.getType(), r8.position, r8.isVisible()));
        r6 = r6 + 1;
        r7 = true;
        goto L20
    L22:
        if (r7 == false) goto L24;
    L25:
        ((ArrayList) r0.c).clear();
        ((ArrayList) r0.c).addAll(r4);
    L26:
        if (r7 == false) goto L31;
        r0.c();
        return;
    L31:
        return;
    L24:
        if (r4.isEmpty() == false) goto L26;
    L13:
        if (r0.b.b != r15.getUiLayout()) goto L18;
        if (r0.b.c != r15.getStyle()) goto L18;
        if (r0.b.d == r15.getSubUILayout()) goto L19;
        goto L18
    }
}
