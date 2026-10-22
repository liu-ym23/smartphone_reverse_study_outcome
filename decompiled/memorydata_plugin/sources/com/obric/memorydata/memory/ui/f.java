package com.obric.memorydata.memory.ui;

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
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/MemoryEntityTitleProvider;", "", "<init>", "()V", "getTitle", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10920a = null;

    static {
        f10920a = new f();
    }

    private f() {
    }

    public final String a(MemoryEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        String r0 = "";
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r8, OrderFlightMemoryEntity.class) == false) goto L23;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureAirport(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L20;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingAirport(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L15;
    L16:
        r3 = true;
    L17:
        if (r3 == true) goto L20;
        StringBuilder r11 = new StringBuilder().append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber()).append(' ').append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureAirport()).append(" - ");
        String r12 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingAirport();
    L94:
        return r11.append(r12).toString();
    L15:
        if (r10.length() != 0) goto L17;
    L20:
        r11 = new StringBuilder().append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber()).append(' ').append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace()).append(" - ");
        r12 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination();
        goto L94
    L7:
        if (r7.length() == 0) goto L10;
        r9 = false;
        goto L11
    L23:
        if (ZeusTransformUtils.instanceOf(r8, OrderTrainMemoryEntity.class) == false) goto L42;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureStation(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L27;
    L30:
        boolean r14 = true;
    L31:
        if (r14 == true) goto L40;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalStation(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L35;
    L36:
        r3 = true;
    L37:
        if (r3 == true) goto L40;
        r11 = new StringBuilder().append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber()).append(' ').append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureStation()).append(" - ");
        r12 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalStation();
        goto L94
    L35:
        if (r15.length() != 0) goto L37;
    L40:
        r11 = new StringBuilder().append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber()).append(' ').append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace()).append(" - ");
        r12 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination();
        goto L94
    L27:
        if (r13.length() == 0) goto L30;
        r14 = false;
        goto L31
    L42:
        if (ZeusTransformUtils.instanceOf(r8, OrderHotelMemoryEntity.class) == false) goto L45;
        return ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelName();
    L45:
        if (ZeusTransformUtils.instanceOf(r8, OrderMovieTicketMemoryEntity.class) == false) goto L48;
        return ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieName();
    L48:
        if (ZeusTransformUtils.instanceOf(r8, OrderTicketMemoryEntity.class) == false) goto L51;
        return ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getName();
    L51:
        if (ZeusTransformUtils.instanceOf(r8, OrderCommonMemoryEntity.class) == false) goto L54;
        return ((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r8, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getOrderName();
    L54:
        if (ZeusTransformUtils.instanceOf(r8, CollectContentMemoryEntity.class) == false) goto L57;
        return ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r8, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle();
    L57:
        if (ZeusTransformUtils.instanceOf(r8, CollectStoreMemoryEntity.class) == false) goto L60;
        return ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r8, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getStoreName();
    L60:
        if (ZeusTransformUtils.instanceOf(r8, EventScheduleMemoryEntity.class) == false) goto L63;
        return ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r8, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getScheduleNme();
    L63:
        if (ZeusTransformUtils.instanceOf(r8, EventTodoMemoryEntity.class) == false) goto L66;
        return ((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r8, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin")).getContent();
    L66:
        if (ZeusTransformUtils.instanceOf(r8, InfoDocumentsMemoryEntity.class) == false) goto L77;
        StringBuilder r16 = new StringBuilder();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getPerson(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L70;
    L71:
        r3 = true;
    L72:
        if (r3 == true) goto L75;
        r0 = ((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getPerson() + 30340;
    L75:
        r11 = r16.append(r0).append(((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getIdType()).append(26159);
        r12 = ((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getIdNumber();
        goto L94
    L70:
        if (r2.length() != 0) goto L72;
    L77:
        if (ZeusTransformUtils.instanceOf(r8, InfoAddressMemoryEntity.class) == false) goto L80;
        r11 = new StringBuilder().append(((InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoAddressMemoryEntity.class, "com.obric.memorydata.plugin")).getAddressType()).append(26159);
        r12 = ((InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoAddressMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress();
        goto L94
    L80:
        if (ZeusTransformUtils.instanceOf(r8, InfoAnniversaryMemoryEntity.class) == false) goto L83;
        r11 = new StringBuilder().append(((InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin")).getAnniversaryType()).append(26159);
        r12 = r.a(StringsKt.replace$default(((InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin")).getAnniversaryDate(), "-", "/", false, 4, null));
        goto L94
    L83:
        if (ZeusTransformUtils.instanceOf(r8, InfoRelationshipMemoryEntity.class) == false) goto L86;
        r11 = new StringBuilder().append(((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getPersonName()).append(26159);
        r12 = ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getRelationType();
        goto L94
    L86:
        if (ZeusTransformUtils.instanceOf(r8, InfoCommonMemoryEntity.class) == false) goto L89;
        return ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r8, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoValue();
    L89:
        if (ZeusTransformUtils.instanceOf(r8, CommonTextMemoryEntity.class) == false) goto L104;
        String r1 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r8, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle();
        if (r1 == null) goto L93;
        return r1;
    L93:
        return ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r8, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();
    L104:
        return "";
    }
}
