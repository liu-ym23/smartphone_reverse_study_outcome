package com.obric.memorydata.memory.memoryentity.a;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.database.entity.gm;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/util/MemoryLocationUtil;", "", "<init>", "()V", "indexLocation", "", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "insertLocation", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "location", "insertIdList", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10311a = null;

    static {
        f10311a = new b();
    }

    private b() {
    }

    private final void a(AppEntity r21, String r22, List<String> r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        gm r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryLocationRawDbDao().queryOneRecord(r22, r21.get_packageName());
        if (r2 != null) goto L5;
        long r10 = System.currentTimeMillis();
        r2 = new gm(0, String.valueOf(r10), r10, r10, -305, 0, r21.get_packageName(), r21.getHashCodeValue(), r22, 33, null);
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    L5:
        r0.add(r2.getEntityId());
    }

    public final List<String> a(MemoryEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        int r7 = r8.getType();
        String r4 = "";
        if (r7 != 10001) goto L5;
        OrderFlightMemoryEntity r9 = (OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin");
        String[] r0 = new String[2];
        StringBuilder r3 = new StringBuilder().append(r9.getDeparturePlace());
        String r6 = r9.getDepartureAirport();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r0[0] = r3.append(r6).toString();
        StringBuilder r2 = new StringBuilder().append(r9.getDestination());
        String r10 = r9.getLandingAirport();
        if (r10 == null) goto L22;
        r4 = r10;
    L22:
        r0[1] = r2.append(r4).toString();
        List r11 = CollectionsKt.listOf(r0);
    L23:
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r12.hasNext() == false) goto L27;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        f10311a.a((AppEntity) ZeusTransformUtils.preCheckCast(r8, AppEntity.class, "com.obric.memorydata.plugin"), r5, r1);
        goto L25
    L27:
        return r1;
    L5:
        if (r7 == 10002) goto L7;
        r11 = CollectionsKt.emptyList();
        goto L23
    L7:
        OrderTrainMemoryEntity r13 = (OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin");
        String[] r14 = new String[2];
        StringBuilder r15 = new StringBuilder().append(r13.getDeparturePlace());
        String r16 = r13.getDepartureStation();
        if (r16 != null) goto L10;
        r16 = "";
    L10:
        r14[0] = r15.append(r16).toString();
        StringBuilder r17 = new StringBuilder().append(r13.getDestination());
        String r18 = r13.getArrivalStation();
        if (r18 == null) goto L14;
        r4 = r18;
    L14:
        r14[1] = r17.append(r4).toString();
        r11 = CollectionsKt.listOf(r14);
        goto L23
    }
}
