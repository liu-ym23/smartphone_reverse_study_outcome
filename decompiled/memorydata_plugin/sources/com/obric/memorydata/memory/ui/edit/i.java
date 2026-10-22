package com.obric.memorydata.memory.ui.edit;

import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0002\b\u00030\u00060\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/MemoryFormUtils;", "", "<init>", "()V", "getMemoryFormUI", "", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryEntity", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10906a = null;

    static {
        f10906a = new i();
    }

    private i() {
    }

    public final List<b<? extends MemoryEntity, ?>> a(MemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        int r2 = r3.getType();
        if (r2 == 10201) goto L31;
        if (r2 == 10202) goto L47;
        if (r2 == 10301) goto L46;
        if (r2 == 10302) goto L45;
        if (r2 == 10401) goto L44;
        switch(r2) {
            case 10001: goto L43;
            case 10002: goto L42;
            case 10003: goto L41;
            case 10004: goto L40;
            case 10005: goto L39;
            case 10006: goto L38;
            default: goto L13;
        };
    L13:
        switch(r2) {
            case 10101: goto L37;
            case 10102: goto L36;
            case 10103: goto L35;
            case 10104: goto L34;
            case 10105: goto L33;
            default: goto L32;
        };
    L32:
        return CollectionsKt.emptyList();
    L33:
        return new com.obric.memorydata.memory.ui.edit.info.c((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r3, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L34:
        return new com.obric.memorydata.memory.ui.edit.info.e((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r3, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L35:
        return new com.obric.memorydata.memory.ui.edit.info.b((InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r3, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L36:
        return new com.obric.memorydata.memory.ui.edit.info.a((InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r3, InfoAddressMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L37:
        return new com.obric.memorydata.memory.ui.edit.info.d((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r3, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L38:
        return new com.obric.memorydata.memory.ui.edit.order.e((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r3, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L39:
        return new com.obric.memorydata.memory.ui.edit.order.a((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r3, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L40:
        return new com.obric.memorydata.memory.ui.edit.order.c((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r3, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L41:
        return new com.obric.memorydata.memory.ui.edit.order.d((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r3, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L42:
        return new com.obric.memorydata.memory.ui.edit.order.f((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r3, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L43:
        return new com.obric.memorydata.memory.ui.edit.order.b((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r3, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L44:
        return new com.obric.memorydata.memory.ui.edit.common.a((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L45:
        return new com.obric.memorydata.memory.ui.edit.event.b((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L46:
        return new com.obric.memorydata.memory.ui.edit.event.a((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L47:
        return new com.obric.memorydata.memory.ui.edit.collect.b((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    L31:
        return new com.obric.memorydata.memory.ui.edit.collect.a((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r3, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).a();
    }
}
