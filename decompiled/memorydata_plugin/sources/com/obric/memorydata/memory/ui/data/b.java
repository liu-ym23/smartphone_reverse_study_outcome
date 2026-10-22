package com.obric.memorydata.memory.ui.data;

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
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0005"}, d2 = {"getViewType", "Lcom/obric/memorydata/memory/ui/data/MemoryItemType;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "getDetailTypeFromEntity", "getListTypeFromEntity", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10793a = null;

        static {
            int[] r0 = new int[MemoryCategoryType.values().length];
            r0[MemoryCategoryType.MEMORY_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[MemoryCategoryType.MEMORY_RELATION_TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[MemoryCategoryType.MEMORY_AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[MemoryCategoryType.MEMORY_AUTO_MEMORY_PRO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[MemoryCategoryType.MEMORY_OBSERVATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[MemoryCategoryType.MEMORY_LIST_ENTITY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[MemoryCategoryType.MEMORY_DETAIL_ENTITY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[MemoryCategoryType.MEMORY_FOOTER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[MemoryCategoryType.MEMORY_CALENDAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[MemoryCategoryType.MEMORY_EPISODIC_TOPIC.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f10793a = r0;
        }
    }

    public static final MemoryItemType a(com.obric.memorydata.memory.ui.data.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        MemoryCategoryType r0 = r2.getType();
        switch(a.f10793a[r0.ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return MemoryItemType.TYPE_EPISODIC_TOPIC;
    L18:
        return MemoryItemType.TYPE_CALENDAR;
    L19:
        return MemoryItemType.TYPE_MEMORY_FOOTER;
    L20:
        return b(r2);
    L21:
        return c(r2);
    L22:
        return MemoryItemType.TYPE_SHORT_ENTITY;
    L23:
        return MemoryItemType.TYPE_AUTO_MEMORY_PRO;
    L24:
        return MemoryItemType.TYPE_AUDIO_ENTITY;
    L25:
        return MemoryItemType.TYPE_RELATION_TITLE;
    L16:
        return MemoryItemType.TYPE_TIME;
    }

    private static final MemoryItemType b(com.obric.memorydata.memory.ui.data.a r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.memorydata.memory.ui.data.MemoryItem.DetailEntity");
        MemoryEntity r3 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b();
        if (ZeusTransformUtils.instanceOf(r3, CollectContentMemoryEntity.class) == false) goto L6;
        return MemoryItemType.TYPE_DETAIL_COLLECT_CONTENT;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, CollectStoreMemoryEntity.class) == false) goto L9;
        return MemoryItemType.TYPE_DETAIL_COLLECT_STORE;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, CommonTextMemoryEntity.class) == false) goto L12;
        return MemoryItemType.TYPE_DETAIL_COMMON_TEXT;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, EventScheduleMemoryEntity.class) == false) goto L15;
        return MemoryItemType.TYPE_DETAIL_EVENT_SCHEDULE;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, EventTodoMemoryEntity.class) == false) goto L18;
        return MemoryItemType.TYPE_DETAIL_EVENT_TODO;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, InfoAddressMemoryEntity.class) == false) goto L21;
        return MemoryItemType.TYPE_DETAIL_INFO_ADDRESS;
    L21:
        if (ZeusTransformUtils.instanceOf(r3, InfoAnniversaryMemoryEntity.class) == false) goto L24;
        return MemoryItemType.TYPE_DETAIL_INFO_ANNIVERSARY;
    L24:
        if (ZeusTransformUtils.instanceOf(r3, InfoCommonMemoryEntity.class) == false) goto L27;
        return MemoryItemType.TYPE_DETAIL_INFO_COMMON;
    L27:
        if (ZeusTransformUtils.instanceOf(r3, InfoDocumentsMemoryEntity.class) == false) goto L30;
        return MemoryItemType.TYPE_DETAIL_INFO_DOCUMENTS;
    L30:
        if (ZeusTransformUtils.instanceOf(r3, InfoRelationshipMemoryEntity.class) == false) goto L33;
        return MemoryItemType.TYPE_DETAIL_INFO_RELATION;
    L33:
        if (ZeusTransformUtils.instanceOf(r3, OrderCommonMemoryEntity.class) == false) goto L36;
        return MemoryItemType.TYPE_DETAIL_ORDER_COMMON;
    L36:
        if (ZeusTransformUtils.instanceOf(r3, OrderFlightMemoryEntity.class) == false) goto L39;
        return MemoryItemType.TYPE_DETAIL_ORDER_FLIGHT;
    L39:
        if (ZeusTransformUtils.instanceOf(r3, OrderHotelMemoryEntity.class) == false) goto L42;
        return MemoryItemType.TYPE_DETAIL_ORDER_HOTEL;
    L42:
        if (ZeusTransformUtils.instanceOf(r3, OrderMovieTicketMemoryEntity.class) == false) goto L45;
        return MemoryItemType.TYPE_DETAIL_ORDER_MOVIE_TICKET;
    L45:
        if (ZeusTransformUtils.instanceOf(r3, OrderTicketMemoryEntity.class) == false) goto L48;
        return MemoryItemType.TYPE_DETAIL_ORDER_TICKET;
    L48:
        if (ZeusTransformUtils.instanceOf(r3, OrderTrainMemoryEntity.class) == false) goto L52;
        return MemoryItemType.TYPE_DETAIL_ORDER_TRAIN;
    L52:
        throw new IllegalArgumentException("Unknown memory entity type");
    }

    private static final MemoryItemType c(com.obric.memorydata.memory.ui.data.a r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.memorydata.memory.ui.data.MemoryItem.ListEntity");
        MemoryEntity r3 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b();
        if (ZeusTransformUtils.instanceOf(r3, CollectContentMemoryEntity.class) == false) goto L6;
        return MemoryItemType.TYPE_LIST_COLLECT_CONTENT;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, CollectStoreMemoryEntity.class) == false) goto L9;
        return MemoryItemType.TYPE_LIST_COLLECT_STORE;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, CommonTextMemoryEntity.class) == false) goto L12;
        return MemoryItemType.TYPE_LIST_COMMON_TEXT;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, EventScheduleMemoryEntity.class) == false) goto L15;
        return MemoryItemType.TYPE_LIST_EVENT_SCHEDULE;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, EventTodoMemoryEntity.class) == false) goto L18;
        return MemoryItemType.TYPE_LIST_EVENT_TODO;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, InfoAddressMemoryEntity.class) == false) goto L21;
        return MemoryItemType.TYPE_LIST_INFO_ADDRESS;
    L21:
        if (ZeusTransformUtils.instanceOf(r3, InfoAnniversaryMemoryEntity.class) == false) goto L24;
        return MemoryItemType.TYPE_LIST_INFO_ANNIVERSARY;
    L24:
        if (ZeusTransformUtils.instanceOf(r3, InfoCommonMemoryEntity.class) == false) goto L27;
        return MemoryItemType.TYPE_LIST_INFO_COMMON;
    L27:
        if (ZeusTransformUtils.instanceOf(r3, InfoDocumentsMemoryEntity.class) == false) goto L30;
        return MemoryItemType.TYPE_LIST_INFO_DOCUMENTS;
    L30:
        if (ZeusTransformUtils.instanceOf(r3, InfoRelationshipMemoryEntity.class) == false) goto L33;
        return MemoryItemType.TYPE_LIST_INFO_RELATION;
    L33:
        if (ZeusTransformUtils.instanceOf(r3, OrderCommonMemoryEntity.class) == false) goto L36;
        return MemoryItemType.TYPE_LIST_ORDER_COMMON;
    L36:
        if (ZeusTransformUtils.instanceOf(r3, OrderFlightMemoryEntity.class) == false) goto L39;
        return MemoryItemType.TYPE_LIST_ORDER_FLIGHT;
    L39:
        if (ZeusTransformUtils.instanceOf(r3, OrderHotelMemoryEntity.class) == false) goto L42;
        return MemoryItemType.TYPE_LIST_ORDER_HOTEL;
    L42:
        if (ZeusTransformUtils.instanceOf(r3, OrderMovieTicketMemoryEntity.class) == false) goto L45;
        return MemoryItemType.TYPE_LIST_ORDER_MOVIE_TICKET;
    L45:
        if (ZeusTransformUtils.instanceOf(r3, OrderTicketMemoryEntity.class) == false) goto L48;
        return MemoryItemType.TYPE_LIST_ORDER_TICKET;
    L48:
        if (ZeusTransformUtils.instanceOf(r3, OrderTrainMemoryEntity.class) == false) goto L52;
        return MemoryItemType.TYPE_LIST_ORDER_TRAIN;
    L52:
        throw new IllegalArgumentException("Unknown memory entity type");
    }
}
