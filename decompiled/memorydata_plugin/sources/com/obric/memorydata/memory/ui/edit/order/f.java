package com.obric.memorydata.memory.ui.edit.order;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.memory.ui.edit.j;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.Format;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0002\b\u00030\n0\tH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/order/TrainOrderUI;", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditUI;", "entity", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "<init>", "(Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;)V", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "editItemList", "", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "validateCheckOutDate", "Lcom/obric/memorydata/memory/ui/edit/ValidationResult;", "editMemoryEntity", "date", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends com.obric.memorydata.memory.ui.edit.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OrderTrainMemoryEntity f10919a;

    public f(OrderTrainMemoryEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.f10919a = r2;
    }

    private final j a(MemoryEntity r7, String r8) {
        if (r8 != null) goto L7;
        return new j(true, null, 2, null);
    L7:
        if (ZeusTransformUtils.instanceOf(r7, OrderTrainMemoryEntity.class) == false) goto L9;
        SimpleDateFormat r2 = new SimpleDateFormat(Format.DATE.getValue(), Locale.getDefault());     // Catch: Exception -> L24
        Date r9 = r2.parse(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureDate());     // Catch: Exception -> L24
        if (r9 == null) goto L13;
        long r4 = r9.getTime();     // Catch: Exception -> L24
    L14:
        Date r10 = r2.parse(r8);     // Catch: Exception -> L24
        if (r10 == null) goto L23;
        if (r10.getTime() >= r4) goto L21;
        return new j(false, at.a(ZeusTransformUtils.mapRes(R.string.memory_edit_check_arrive_time_error_tip, TypedValues.Custom.S_STRING, "memory_edit_check_arrive_time_error_tip")));
    L21:
        return new j(true, null, 2, null);
    L23:
        return new j(true, null, 2, null);
    L13:
        r4 = 0;
        goto L14
    L25:
        return new j(false, "date format error");
    L9:
        return new j(false, "editMemoryEntity is not OrderTrainMemoryEntity");
    }

    public static final /* synthetic */ j a(f r0, MemoryEntity r1, String r2) {
        return r0.a(r1, r2);
    }

    public List<com.obric.memorydata.memory.ui.edit.b<? extends MemoryEntity, ?>> a() {
        return CollectionsKt.listOf(new com.obric.memorydata.memory.ui.edit.b[]{new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_departureDate, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_departureDate"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$1.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getDepartureDate(), 2, false, 0, null, 112, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_arrivalDate, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_arrivalDate"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$2.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getArrivalDate(), 2, false, 0, (Function2) ZeusTransformUtils.preCheckCast(new TrainOrderUI$editItemList$3(this), Function2.class, "com.obric.memorydata.plugin"), 32, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_departurePlace, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_departurePlace"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$4.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getDeparturePlace(), 0, false, 0, null, 120, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_destination, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_destination"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$5.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getDestination(), 0, false, 0, null, 120, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_trainNumber, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_trainNumber"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$6.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getTrainNumber(), 0, false, 0, null, 120, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_departureTime, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_departureTime"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$7.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getDepartureTime(), 3, false, 0, null, 112, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_arrivalTime, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_arrivalTime"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$8.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getArrivalTime(), 3, false, 0, null, 112, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_departureStation, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_departureStation"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$9.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getDepartureStation(), 1, false, 0, null, 96, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_arrivalStation, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_arrivalStation"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$10.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getArrivalStation(), 1, false, 0, null, 96, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_ticketGate, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_ticketGate"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$11.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getTicketGate(), 1, false, 0, null, 96, null), new com.obric.memorydata.memory.ui.edit.b(ZeusTransformUtils.mapRes(R.string.MEMORY_ORDER_TRAIN_seatNumber, TypedValues.Custom.S_STRING, "MEMORY_ORDER_TRAIN_seatNumber"), (KMutableProperty1) ZeusTransformUtils.preCheckCast(TrainOrderUI$editItemList$12.INSTANCE, KMutableProperty1.class, "com.obric.memorydata.plugin"), this.f10919a.getSeatNumber(), 1, false, 2, null, 64, null)});
    }
}
