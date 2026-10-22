package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005./012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0015\u0010&\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000f¨\u00063"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$Builder;Lokio/ByteString;)V", "building_level_id", "", "getBuilding_level_id", "()Ljava/lang/String;", "level_ids", "", "getLevel_ids", "()Ljava/util/List;", "capacity", "", "getCapacity", "()I", "equipment_requirement", "Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$EquipmentRequireType;", "getEquipment_requirement", "()Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$EquipmentRequireType;", "display_name", "getDisplay_name", "last_wait_time_type", "Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$LastWaitTimeType;", "getLast_wait_time_type", "()Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$LastWaitTimeType;", "last_wait_time_duration", "getLast_wait_time_duration", "status", "Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$WaitListStatus;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$WaitListStatus;", "create_user_id", "getCreate_user_id", "max_capacity", "getMax_capacity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "building_zone_codes", "getBuilding_zone_codes", "newBuilder", "toString", "Builder", "Companion", "EquipmentRequireType", "LastWaitTimeType", "WaitListStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ResourceWaitListOrder extends Message<ResourceWaitListOrder, a> {
    public static final ProtoAdapter<ResourceWaitListOrder> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String building_level_id;
    private final List<String> building_zone_codes;
    private final int capacity;
    private final String create_user_id;
    private final String display_name;
    private final EquipmentRequireType equipment_requirement;
    private final int last_wait_time_duration;
    private final LastWaitTimeType last_wait_time_type;
    private final List<String> level_ids;
    private final Integer max_capacity;
    private final WaitListStatus status;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$EquipmentRequireType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RequireNoneEquipment", "IncludeProjector", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EquipmentRequireType extends Enum<EquipmentRequireType> implements o0 {
        public static final ProtoAdapter<EquipmentRequireType> ADAPTER = null;
        public static final b Companion = null;
        public static final EquipmentRequireType IncludeProjector = null;
        public static final EquipmentRequireType RequireNoneEquipment = null;
        public static final /* synthetic */ EquipmentRequireType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EquipmentRequireType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EquipmentRequireType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return EquipmentRequireType.IncludeProjector;
            L9:
                return EquipmentRequireType.RequireNoneEquipment;
            }

            public a(KClass<EquipmentRequireType> r1, Syntax r2, EquipmentRequireType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<EquipmentRequireType> getEntries() {
            return b;
        }

        static {
            EquipmentRequireType r0 = new EquipmentRequireType("RequireNoneEquipment", 0, 0);
            RequireNoneEquipment = r0;
            EquipmentRequireType r1 = new EquipmentRequireType("IncludeProjector", 1, 1);
            IncludeProjector = r1;
            EquipmentRequireType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EquipmentRequireType.class), Syntax.PROTO_2, r0);
        }

        public static EquipmentRequireType[] values() {
            return (EquipmentRequireType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final EquipmentRequireType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return IncludeProjector;
        L9:
            return RequireNoneEquipment;
        }

        public static EquipmentRequireType valueOf(String r1) {
            return (EquipmentRequireType) r27.a.a(EquipmentRequireType.class, r1);
        }

        public EquipmentRequireType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$LastWaitTimeType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BEFORE_EVENT_START", "WHEN_EVENT_START", "AFTER_EVENT_START", "WHEN_EVENT_END", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum LastWaitTimeType extends Enum<LastWaitTimeType> implements o0 {
        public static final ProtoAdapter<LastWaitTimeType> ADAPTER = null;
        public static final LastWaitTimeType AFTER_EVENT_START = null;
        public static final LastWaitTimeType BEFORE_EVENT_START = null;
        public static final b Companion = null;
        public static final LastWaitTimeType WHEN_EVENT_END = null;
        public static final LastWaitTimeType WHEN_EVENT_START = null;
        public static final /* synthetic */ LastWaitTimeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<LastWaitTimeType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                LastWaitTimeType.Companion.getClass();
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L19;
                if (r2 == 3) goto L18;
                if (r2 == 4) goto L17;
                return null;
            L17:
                return LastWaitTimeType.WHEN_EVENT_END;
            L18:
                return LastWaitTimeType.AFTER_EVENT_START;
            L19:
                return LastWaitTimeType.WHEN_EVENT_START;
            L15:
                return LastWaitTimeType.BEFORE_EVENT_START;
            }

            public a(KClass<LastWaitTimeType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<LastWaitTimeType> getEntries() {
            return b;
        }

        static {
            LastWaitTimeType r0 = new LastWaitTimeType("BEFORE_EVENT_START", 0, 1);
            BEFORE_EVENT_START = r0;
            LastWaitTimeType r1 = new LastWaitTimeType("WHEN_EVENT_START", 1, 2);
            WHEN_EVENT_START = r1;
            LastWaitTimeType r4 = new LastWaitTimeType("AFTER_EVENT_START", 2, 3);
            AFTER_EVENT_START = r4;
            LastWaitTimeType r6 = new LastWaitTimeType("WHEN_EVENT_END", 3, 4);
            WHEN_EVENT_END = r6;
            LastWaitTimeType[] r8 = {r0, r1, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(LastWaitTimeType.class), Syntax.PROTO_2);
        }

        public static LastWaitTimeType[] values() {
            return (LastWaitTimeType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final LastWaitTimeType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L19;
            if (r1 == 3) goto L18;
            if (r1 == 4) goto L17;
            return null;
        L17:
            return WHEN_EVENT_END;
        L18:
            return AFTER_EVENT_START;
        L19:
            return WHEN_EVENT_START;
        L15:
            return BEFORE_EVENT_START;
        }

        public static LastWaitTimeType valueOf(String r1) {
            return (LastWaitTimeType) r27.a.a(LastWaitTimeType.class, r1);
        }

        public LastWaitTimeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ResourceWaitListOrder$WaitListStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "WAITING", "FAILED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum WaitListStatus extends Enum<WaitListStatus> implements o0 {
        public static final ProtoAdapter<WaitListStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final WaitListStatus FAILED = null;
        public static final WaitListStatus UNKNOWN = null;
        public static final WaitListStatus WAITING = null;
        public static final /* synthetic */ WaitListStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<WaitListStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                WaitListStatus.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return WaitListStatus.FAILED;
            L15:
                return WaitListStatus.WAITING;
            L12:
                return WaitListStatus.UNKNOWN;
            }

            public a(KClass<WaitListStatus> r1, Syntax r2, WaitListStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<WaitListStatus> getEntries() {
            return b;
        }

        static {
            WaitListStatus r0 = new WaitListStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            WaitListStatus r1 = new WaitListStatus("WAITING", 1, 1);
            WAITING = r1;
            WaitListStatus r3 = new WaitListStatus("FAILED", 2, 2);
            FAILED = r3;
            WaitListStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(WaitListStatus.class), Syntax.PROTO_2, r0);
        }

        public static WaitListStatus[] values() {
            return (WaitListStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final WaitListStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return FAILED;
        L15:
            return WAITING;
        L12:
            return UNKNOWN;
        }

        public static WaitListStatus valueOf(String r1) {
            return (WaitListStatus) r27.a.a(WaitListStatus.class, r1);
        }

        public WaitListStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<ResourceWaitListOrder, a> {
        public String d;
        public List<String> e;
        public Integer f;
        public EquipmentRequireType g;
        public String h;
        public LastWaitTimeType i;
        public Integer j;
        public WaitListStatus k;
        public String l;
        public Integer m;
        public List<String> n;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new ResourceWaitListOrder(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
            this.n = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<ResourceWaitListOrder> {
        @Override // com.lark.wire.ProtoAdapter
        public final ResourceWaitListOrder c(g0 r12) {
            Intrinsics.checkNotNullParameter(r12, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r12.c();
        L3:
            int r6 = r12.e();
            if (r6 == (-1)) goto L27;
            switch(r6) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L33;
                case 5: goto L19;
                case 6: goto L31;
                case 7: goto L14;
                case 8: goto L29;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L29:
            WaitListStatus r7 = WaitListStatus.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            Intrinsics.checkNotNullParameter(r7, "status");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            r1.k = r7;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L31:
            LastWaitTimeType r9 = LastWaitTimeType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            Intrinsics.checkNotNullParameter(r9, "last_wait_time_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            r1.i = r9;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r10 = Unit.INSTANCE;
            goto L3
        L33:
            EquipmentRequireType r11 = EquipmentRequireType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            Intrinsics.checkNotNullParameter(r11, "equipment_requirement");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            r1.g = r11;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r13 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r3.add(r12.i());
            goto L3
        L8:
            r1.m = (Integer) ProtoAdapter.h.c(r12);
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r14 = r12.i();
            Intrinsics.checkNotNullParameter(r14, "create_user_id");
            r1.l = r14;
            goto L3
        L14:
            r1.j = Integer.valueOf(((Number) ProtoAdapter.h.c(r12)).intValue());
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.h = r12.i();
            goto L3
        L24:
            r1.f = Integer.valueOf(((Number) ProtoAdapter.h.c(r12)).intValue());
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r2.add(r12.i());
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r15 = r12.i();
            Intrinsics.checkNotNullParameter(r15, "building_level_id");
            r1.d = r15;
            goto L3
        L6:
            r12.j(r6);
            Unit r16 = Unit.INSTANCE;
            goto L3
        L27:
            ByteString r17 = r12.d(r4);
            Intrinsics.checkNotNullParameter(r2, "level_ids");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            Intrinsics.checkNotNullParameter(r3, "building_zone_codes");
            com.lark.wire.internal.a.a(r3);
            r1.n = r3;
            return new ResourceWaitListOrder(r1, r17, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ResourceWaitListOrder r7) {
            ResourceWaitListOrder r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r8.getBuilding_level_id())) + r1.a().l(2, r8.getLevel_ids());
            s r3 = ProtoAdapter.h;
            return ((((((((r2 + r3.l(3, Integer.valueOf(r8.getCapacity()))) + EquipmentRequireType.ADAPTER.l(4, r8.getEquipment_requirement())) + r1.l(5, r8.getDisplay_name())) + LastWaitTimeType.ADAPTER.l(6, r8.getLast_wait_time_type())) + r3.l(7, Integer.valueOf(r8.getLast_wait_time_duration()))) + WaitListStatus.ADAPTER.l(8, r8.getStatus())) + r1.l(9, r8.getCreate_user_id())) + r3.l(10, r8.getMax_capacity())) + r1.a().l(11, r8.getBuilding_zone_codes());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, ResourceWaitListOrder r7) {
            ResourceWaitListOrder r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getBuilding_level_id());
            r0.a().i(r6, 2, r8.getLevel_ids());
            s r1 = ProtoAdapter.h;
            r1.i(r6, 3, Integer.valueOf(r8.getCapacity()));
            EquipmentRequireType.ADAPTER.i(r6, 4, r8.getEquipment_requirement());
            r0.i(r6, 5, r8.getDisplay_name());
            LastWaitTimeType.ADAPTER.i(r6, 6, r8.getLast_wait_time_type());
            r1.i(r6, 7, Integer.valueOf(r8.getLast_wait_time_duration()));
            WaitListStatus.ADAPTER.i(r6, 8, r8.getStatus());
            r0.i(r6, 9, r8.getCreate_user_id());
            r1.i(r6, 10, r8.getMax_capacity());
            r0.a().i(r6, 11, r8.getBuilding_zone_codes());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, ResourceWaitListOrder r7) {
            ResourceWaitListOrder r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.a().j(r6, 11, r8.getBuilding_zone_codes());
            s r1 = ProtoAdapter.h;
            r1.j(r6, 10, r8.getMax_capacity());
            r0.j(r6, 9, r8.getCreate_user_id());
            WaitListStatus.ADAPTER.j(r6, 8, r8.getStatus());
            r1.j(r6, 7, Integer.valueOf(r8.getLast_wait_time_duration()));
            LastWaitTimeType.ADAPTER.j(r6, 6, r8.getLast_wait_time_type());
            r0.j(r6, 5, r8.getDisplay_name());
            EquipmentRequireType.ADAPTER.j(r6, 4, r8.getEquipment_requirement());
            r1.j(r6, 3, Integer.valueOf(r8.getCapacity()));
            r0.a().j(r6, 2, r8.getLevel_ids());
            r0.j(r6, 1, r8.getBuilding_level_id());
        }

        public b(FieldEncoding r7, KClass<ResourceWaitListOrder> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.ResourceWaitListOrder", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ResourceWaitListOrder(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceWaitListOrder.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.building_level_id;
        r0.e = this.level_ids;
        r0.f = Integer.valueOf(this.capacity);
        r0.g = this.equipment_requirement;
        r0.h = this.display_name;
        r0.i = this.last_wait_time_type;
        r0.j = Integer.valueOf(this.last_wait_time_duration);
        r0.k = this.status;
        r0.l = this.create_user_id;
        r0.m = this.max_capacity;
        r0.n = this.building_zone_codes;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ResourceWaitListOrder.class).getSimpleName() + '@' + hashCode();
    }

    public final String getBuilding_level_id() {
        return this.building_level_id;
    }

    public final List<String> getBuilding_zone_codes() {
        return this.building_zone_codes;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final String getCreate_user_id() {
        return this.create_user_id;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final EquipmentRequireType getEquipment_requirement() {
        return this.equipment_requirement;
    }

    public final int getLast_wait_time_duration() {
        return this.last_wait_time_duration;
    }

    public final LastWaitTimeType getLast_wait_time_type() {
        return this.last_wait_time_type;
    }

    public final List<String> getLevel_ids() {
        return this.level_ids;
    }

    public final Integer getMax_capacity() {
        return this.max_capacity;
    }

    public final WaitListStatus getStatus() {
        return this.status;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public ResourceWaitListOrder(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.building_level_id = r4;
        this.level_ids = com.lark.wire.internal.a.c("level_ids", r2.e);
        Integer r5 = r2.f;
        Intrinsics.checkNotNull(r5);
        this.capacity = r5.intValue();
        EquipmentRequireType r6 = r2.g;
        Intrinsics.checkNotNull(r6);
        this.equipment_requirement = r6;
        this.display_name = r2.h;
        LastWaitTimeType r7 = r2.i;
        Intrinsics.checkNotNull(r7);
        this.last_wait_time_type = r7;
        Integer r8 = r2.j;
        Intrinsics.checkNotNull(r8);
        this.last_wait_time_duration = r8.intValue();
        WaitListStatus r9 = r2.k;
        Intrinsics.checkNotNull(r9);
        this.status = r9;
        String r10 = r2.l;
        Intrinsics.checkNotNull(r10);
        this.create_user_id = r10;
        this.max_capacity = r2.m;
        this.building_zone_codes = com.lark.wire.internal.a.c("building_zone_codes", r2.n);
    }

    public /* synthetic */ ResourceWaitListOrder(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
