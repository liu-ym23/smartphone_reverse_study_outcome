package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ p a;

    public t(p r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        p r0 = this.a;
        SeiAppData r10 = ((com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b) r9).b;
        r0.getClass();
        List r1 = r10.getGrids();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.size();
    L6:
        if (r3 <= 0) goto L18;
        List r4 = r10.getGrids();
        if (r4 == null) goto L12;
        SeiRegion r5 = (SeiRegion) ListProtector.get(r4, 0);
        if (r5 == null) goto L12;
        r5.getInteractId();
    L12:
        List r6 = r10.getGrids();
        if (r6 == null) goto L17;
        SeiRegion r7 = (SeiRegion) ListProtector.get(r6, 0);
        if (r7 == null) goto L17;
        r7.isTalking();
    L17:
        Objects.toString(r0.d);
    L18:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r8 = r0.m;
        if (r8 == null) goto L23;
        IRoom r11 = r8.getRoom();
        if (r11 == null) goto L23;
        String r12 = String.valueOf(r11.getId());
    L24:
        boolean r13 = true;
        if ((!Intrinsics.areEqual(r10.getChannelId(), r12)) == false) goto L27;
        ALogger.d("SeiHandlerV3", "sei channel id wrong " + r10.getChannelId() + " room " + r12);
        return;
    L27:
        LinkedHashMap r14 = new LinkedHashMap();
        int r15 = r10.getGrids().size();
        int r16 = 0;
    L28:
        if (r16 >= r15) goto L31;
        SeiRegion r17 = (SeiRegion) ListProtector.get(r10.getGrids(), r16);
        r14.put(r17.getInteractId(), Boolean.valueOf(r17.isTalking()));
        r16 = r16 + 1;
        goto L28
    L31:
        if (r14.size() == r0.d.size()) goto L33;
        r2 = true;
    L33:
        Iterator r18 = r14.entrySet().iterator();
    L35:
        if (r18.hasNext() == false) goto L39;
        Map.Entry r19 = (Map.Entry) r18.next();
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) r0.d).get((String) r19.getKey()), Boolean.valueOf(((Boolean) r19.getValue()).booleanValue()))) == false) goto L35;
    L40:
        if (r13 == false) goto L48;
        ((LinkedHashMap) r0.d).clear();
        r0.d.putAll(r14);
        r0.a().h1(r14);
        return;
    L48:
        return;
    L39:
        r13 = r2;
    L23:
        r12 = null;
        goto L24
    L5:
        r3 = 0;
        goto L6
    }
}
