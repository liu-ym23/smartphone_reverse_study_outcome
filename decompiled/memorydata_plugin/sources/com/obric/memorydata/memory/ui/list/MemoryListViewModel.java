package com.obric.memorydata.memory.ui.list;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "getMemoryList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "memoryTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "sourcePackageName", "", "sourceProductType", "", "(Lcom/obric/memorydata/memory/ui/list/MemoryTab;Ljava/lang/String;Ljava/lang/Integer;)Lkotlinx/coroutines/flow/Flow;", "deleteMemoryEntity", "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateMemoryItemTime", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DateTime;", "before", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "after", "(Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryListViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "MemoryListViewModel";

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListViewModel$Companion;", "", "<init>", "()V", "TAG", "", "transformToMemoryItemEntity", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "currentTimestamp", "", "transformToMemoryItemEntity$memory_obricRelease", "(Lcom/obric/memorydata/database/entity/RawMemoryEntity;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "isPast", "", "memoryEntity", "getOrderEndTime", "it", "getEventEndTime", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ Object a(a r1, RawMemoryEntity r2, long r3, Continuation r5, int r6, Object r7) {
            Continuation<? super List<com.obric.memorydata.memory.ui.data.a.h>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            if ((r6 & 1) == 0) goto L6;
            r3 = System.currentTimeMillis();
        L6:
            return r1.a(r2, r3, r8);
        }

        public static /* synthetic */ List a(a r0, MemoryEntity r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = System.currentTimeMillis();
        L6:
            return r0.a(r1, r2);
        }

        public static final /* synthetic */ boolean a(a r0, MemoryEntity r1, long r2) {
            return r0.b(r1, r2);
        }

        private final boolean b(MemoryEntity r4, long r5) {
            if (ZeusTransformUtils.instanceOf(r4, OrderHotelMemoryEntity.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r4, OrderFlightMemoryEntity.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r4, OrderTrainMemoryEntity.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r4, OrderMovieTicketMemoryEntity.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r4, OrderTicketMemoryEntity.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r4, OrderCommonMemoryEntity.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r4, EventScheduleMemoryEntity.class) == false) goto L24;
            if (d(r4, r5) >= r5) goto L24;
            return true;
        L24:
            return false;
        L21:
            if (c(r4, r5) >= r5) goto L24;
            return true;
        }

        private final long c(MemoryEntity r7, long r8) {
            if (ZeusTransformUtils.instanceOf(r7, OrderFlightMemoryEntity.class) == false) goto L8;
            StringBuilder r6 = new StringBuilder().append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingDate()).append(' ');
            String r9 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingTime();
        L5:
            StringBuilder r10 = r6.append(r9);
        L6:
            String r11 = r10.toString();
        L56:
            if (r11 != null) goto L58;
            return r8;
        L58:
            return com.obric.memorydata.utils.r.d(r11);
        L8:
            if (ZeusTransformUtils.instanceOf(r7, OrderTrainMemoryEntity.class) == false) goto L10;
            r6 = new StringBuilder().append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalDate()).append(' ');
            r9 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalTime();
            goto L5
        L10:
            boolean r2 = false;
            if (ZeusTransformUtils.instanceOf(r7, OrderHotelMemoryEntity.class) == false) goto L32;
            CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getCheckOutTime(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L15;
        L18:
            boolean r13 = true;
        L19:
            if (r13 == true) goto L21;
            String r14 = ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getCheckOutTime();
        L22:
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getCheckOutDate(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L25;
        L26:
            r2 = true;
        L27:
            if (r2 == true) goto L29;
            String r15 = ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getCheckOutDate();
        L30:
            r10 = new StringBuilder().append(r15).append(' ').append(r14);
            goto L6
        L29:
            Calendar r3 = Calendar.getInstance();
            r3.setTimeInMillis(com.obric.memorydata.utils.r.d(((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getCheckInDate()));
            r3.add(6, 1);
            r15 = com.obric.memorydata.utils.r.h(r3.getTimeInMillis());
            goto L30
        L25:
            if (r4.length() != 0) goto L27;
        L21:
            r14 = "23:59:59";
            goto L22
        L15:
            if (r12.length() == 0) goto L18;
            r13 = false;
            goto L19
        L32:
            if (ZeusTransformUtils.instanceOf(r7, OrderMovieTicketMemoryEntity.class) == false) goto L44;
            CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r16 != null) goto L36;
        L37:
            r2 = true;
        L39:
            if (r2 == true) goto L42;
            return com.obric.memorydata.utils.r.d(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieDate() + ' ' + ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime());
        L42:
            return com.obric.memorydata.utils.r.d(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieDate() + ' ' + ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getStartTime()) + ((long) RegionBean.DEFAULT_EXPIRE_TIME);
        L36:
            if (r16.length() != 0) goto L39;
        L44:
            if (ZeusTransformUtils.instanceOf(r7, OrderTicketMemoryEntity.class) == false) goto L55;
            CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L48;
        L49:
            r2 = true;
        L51:
            if (r2 == true) goto L54;
            return com.obric.memorydata.utils.r.d(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getDate() + ' ' + ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime());
        L54:
            return com.obric.memorydata.utils.r.d(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getDate() + ' ' + ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r7, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getStartTime()) + ((long) RegionBean.DEFAULT_EXPIRE_TIME);
        L48:
            if (r17.length() != 0) goto L51;
        L55:
            r11 = null;
            goto L56
        }

        private final long d(MemoryEntity r2, long r3) {
            if (ZeusTransformUtils.instanceOf(r2, EventScheduleMemoryEntity.class) == true) goto L5;
            return r3;
        L5:
            if (com.obric.memorydata.utils.at.a(((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getEndDate()) == false) goto L10;
            if (com.obric.memorydata.utils.at.a(((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime()) == false) goto L10;
            return com.obric.memorydata.utils.r.d(((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getEndDate() + ' ' + ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime());
        L10:
            return ((long) RegionBean.DEFAULT_EXPIRE_TIME) + com.obric.memorydata.utils.r.d(((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getDate() + ' ' + ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getStartTime());
        }

        public final Object a(RawMemoryEntity r4, long r5, Continuation<? super List<com.obric.memorydata.memory.ui.data.a.h>> r7) {
            Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryListViewModel$Companion$transformToMemoryItemEntity$2(r4, r5, null), Function2.class, "com.obric.memorydata.plugin"), r3);
        }

        public final List<com.obric.memorydata.memory.ui.data.a.h> a(MemoryEntity r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return CollectionsKt.listOf(new com.obric.memorydata.memory.ui.data.a.h(r10, b(r10, r11), false, null, null, 24, null));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a.h>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11054a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListViewModel$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11055a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f11055a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, MemoryListViewModel$getMemoryList$$inlined$map$1$2$1.class) == false) goto L7;
                MemoryListViewModel$getMemoryList$$inlined$map$1$2$1 r0 = (MemoryListViewModel$getMemoryList$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, MemoryListViewModel$getMemoryList$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f11055a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r11 = PagingDataTransforms.flatMap((PagingData) ZeusTransformUtils.preCheckCast(r6, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryListViewModel$getMemoryList$1$1(null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new MemoryListViewModel$getMemoryList$$inlined$map$1$2$1(this, r8);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3) {
            this.f11054a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a.h>> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f11054a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MemoryListViewModel f11057b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11058a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MemoryListViewModel f11059b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, MemoryListViewModel r4) {
                this.f11058a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11059b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, MemoryListViewModel$getMemoryList$$inlined$map$2$2$1.class) == false) goto L7;
                MemoryListViewModel$getMemoryList$$inlined$map$2$2$1 r0 = (MemoryListViewModel$getMemoryList$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, MemoryListViewModel$getMemoryList$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f11058a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new MemoryListViewModel$getMemoryList$2$1(this.f11059b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new MemoryListViewModel$getMemoryList$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3, MemoryListViewModel r4) {
            this.f11056a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11057b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f11056a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f11057b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListViewModel$deleteMemoryEntity$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListViewModel$deleteMemoryEntity$2", f = "MemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ MemoryEntity $memoryEntity;
        int label;

        AnonymousClass2(MemoryEntity r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$memoryEntity = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$memoryEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Boolean> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Boolean> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            return Boxing.boxBoolean(com.obric.memorydata.memory.memoryentity.d.a(com.obric.memorydata.memory.memoryentity.d.f10317a, this.$memoryEntity, MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue(), null, 4, null));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListViewModel$generateMemoryItemTime$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DateTime;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListViewModel$generateMemoryItemTime$2", f = "MemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11652 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super com.obric.memorydata.memory.ui.data.a.d>, Object> {
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.h $after;
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.h $before;
        int label;

        C11652(com.obric.memorydata.memory.ui.data.a.h r3, com.obric.memorydata.memory.ui.data.a.h r4, Continuation<? super C11652> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$after = r3;
            this.$before = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11652(this.$after, this.$before, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.d> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.d> r4) {
            return ((C11652) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11652.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r6);
            if (this.$after == null) goto L14;
            com.obric.memorydata.memory.ui.data.a.h r7 = this.$before;
            if (r7 != null) goto L9;
        L10:
            LocalDate r5 = Instant.ofEpochMilli(this.$after.b().getLastModifiedTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            Intrinsics.checkNotNullExpressionValue(r5, "toLocalDate(...)");
            return new com.obric.memorydata.memory.ui.data.a.d(r5);
        L9:
            if (com.obric.memorydata.utils.h.a(r7.b().getLastModifiedTime(), this.$after.b().getLastModifiedTime()) == false) goto L10;
            return null;
        L14:
            return null;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryListViewModel() {
    }

    public static final /* synthetic */ Object access$generateMemoryItemTime(MemoryListViewModel r2, com.obric.memorydata.memory.ui.data.a.h r3, com.obric.memorydata.memory.ui.data.a.h r4, Continuation r5) {
        return r2.generateMemoryItemTime(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object generateMemoryItemTime(com.obric.memorydata.memory.ui.data.a.h r4, com.obric.memorydata.memory.ui.data.a.h r5, Continuation<? super com.obric.memorydata.memory.ui.data.a.d> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11652(r5, r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.i getMemoryList$default(MemoryListViewModel r1, MemoryTab r2, String r3, Integer r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.getMemoryList(r2, r3, r4);
    }

    public final Object deleteMemoryEntity(MemoryEntity r4, Continuation<? super Unit> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r6 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getMemoryList(MemoryTab r12, String r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r12, "memoryTab");
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(com.obric.memorydata.memory.memoryentity.d.a(com.obric.memorydata.memory.memoryentity.d.f10317a, r12, new PagingConfig(20, 20, false, 20, 0, 0, 52, null), null, r13, r14, 4, null).getFlow()), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }
}
