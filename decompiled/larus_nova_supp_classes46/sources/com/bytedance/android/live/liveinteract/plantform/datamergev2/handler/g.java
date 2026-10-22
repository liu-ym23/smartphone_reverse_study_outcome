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
public final class g<T> implements Consumer {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        e r0 = this.a;
        SeiAppData r15 = ((com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b) r14).b;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = r0.l;
        if (r1 == null) goto L7;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L7;
        String r3 = String.valueOf(r2.getId());
    L9:
        if ((!Intrinsics.areEqual(r15.getChannelId(), r3)) == false) goto L11;
        ALogger.d("RemoteSeiHandlerV2", "sei channel id wrong " + r15.getChannelId() + " room " + r3);
        return;
    L11:
        ArrayList r4 = new ArrayList();
        int r5 = r15.getGrids().size();
        int r6 = 0;
        boolean r7 = false;
    L12:
        if (r6 >= r5) goto L14;
        SeiRegion r8 = (SeiRegion) ListProtector.get(r15.getGrids(), r6);
        ch0.j r12 = new ch0.j(r8.getInteractId(), r8.isTalking(), r8.getType(), r8.position, r8.isVisible());
        r8.getInteractId();
        r4.add(r12);
        r6 = r6 + 1;
        r7 = true;
        goto L12
    L14:
        if (r7 == false) goto L16;
    L17:
        ((ArrayList) r0.b).clear();
        ((ArrayList) r0.b).addAll(r4);
    L18:
        if (r7 == false) goto L23;
        r0.c();
        return;
    L23:
        return;
    L16:
        if (r4.isEmpty() == false) goto L18;
    L7:
        r3 = null;
        goto L9
    }
}
