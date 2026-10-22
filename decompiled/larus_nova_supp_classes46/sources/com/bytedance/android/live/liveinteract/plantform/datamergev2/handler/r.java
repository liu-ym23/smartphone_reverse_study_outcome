package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ p a;

    public r(p r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        p r0 = this.a;
        SeiAppData r15 = ((com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b) r14).b;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = r0.m;
        if (r1 == null) goto L7;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L7;
        String r3 = String.valueOf(r2.getId());
    L9:
        if ((!Intrinsics.areEqual(r15.getChannelId(), r3)) == false) goto L12;
        ALogger.d("SeiHandlerV3", "sei channel id wrong " + r15.getChannelId() + " room " + r3);
        return;
    L12:
        if (r15.getStyle() == r0.b.c) goto L17;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r4 = r0.m;
        if (r4 == null) goto L17;
        r4.b(r15.getStyle());
    L17:
        if (r0.b.a == r15.getVersion()) goto L19;
    L24:
        r0.b = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a(r15.getVersion(), r15.getUiLayout(), r15.getStyle(), r15.getSubUILayout());
        r0.a().C0(r0.b);
    L25:
        ArrayList r5 = new ArrayList();
        int r6 = r15.getGrids().size();
        int r7 = 0;
        boolean r8 = false;
    L26:
        if (r7 >= r6) goto L28;
        SeiRegion r9 = (SeiRegion) ListProtector.get(r15.getGrids(), r7);
        ch0.j r12 = new ch0.j(r9.getInteractId(), r9.isTalking(), r9.getType(), r9.position, r9.isVisible());
        r9.getInteractId();
        r5.add(r12);
        r7 = r7 + 1;
        r8 = true;
        goto L26
    L28:
        if (r8 == false) goto L30;
    L31:
        ((ArrayList) r0.c).clear();
        ((ArrayList) r0.c).addAll(r5);
    L32:
        if (r8 == false) goto L39;
        r0.c();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r16 = r0.m;
        if (r16 == null) goto L40;
        r16.a();
        return;
    L40:
        return;
    L39:
        return;
    L30:
        if (r5.isEmpty() == false) goto L32;
    L19:
        if (r0.b.b != r15.getUiLayout()) goto L24;
        if (r0.b.c != r15.getStyle()) goto L24;
        if (r0.b.d == r15.getSubUILayout()) goto L25;
    L7:
        r3 = null;
        goto L9
    }
}
