package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001e\u001f !\"B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/lark/kmp/server/pb/entities/PriorityInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/PriorityInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/PriorityInfo$Builder;Lokio/ByteString;)V", "priority_status", "Lcom/lark/kmp/server/pb/entities/PriorityInfo$PriorityStatus;", "getPriority_status", "()Lcom/lark/kmp/server/pb/entities/PriorityInfo$PriorityStatus;", "max_priority_position", "", "getMax_priority_position", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "update_time_ms", "", "getUpdate_time_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "priority_msg_type_2_single_priority_msg", "", "Lcom/lark/kmp/server/pb/entities/PriorityInfo$SinglePriorityMsg;", "getPriority_msg_type_2_single_priority_msg", "()Ljava/util/Map;", "newBuilder", "toString", "", "Builder", "Companion", "SinglePriorityMsg", "PriorityMsgType", "PriorityStatus", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PriorityInfo extends Message<PriorityInfo, a> {
    public static final ProtoAdapter<PriorityInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer max_priority_position;
    private final Map<Integer, SinglePriorityMsg> priority_msg_type_2_single_priority_msg;
    private final PriorityStatus priority_status;
    private final Long update_time_ms;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/server/pb/entities/PriorityInfo$PriorityMsgType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PRIORITY_MSG_TYPE_UNKNOWN", "ORGANIZATION", "URGENT", "UNREAD_AT", "SPECIAL_FOCUS", "RECENTLY_ADDED_GROUP", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PriorityMsgType extends Enum<PriorityMsgType> implements o0 {
        public static final ProtoAdapter<PriorityMsgType> ADAPTER = null;
        public static final b Companion = null;
        public static final PriorityMsgType ORGANIZATION = null;
        public static final PriorityMsgType PRIORITY_MSG_TYPE_UNKNOWN = null;
        public static final PriorityMsgType RECENTLY_ADDED_GROUP = null;
        public static final PriorityMsgType SPECIAL_FOCUS = null;
        public static final PriorityMsgType UNREAD_AT = null;
        public static final PriorityMsgType URGENT = null;
        public static final /* synthetic */ PriorityMsgType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<PriorityMsgType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                PriorityMsgType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<PriorityMsgType> r1, Syntax r2, PriorityMsgType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static PriorityMsgType a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return PriorityMsgType.RECENTLY_ADDED_GROUP;
            L23:
                return PriorityMsgType.SPECIAL_FOCUS;
            L24:
                return PriorityMsgType.UNREAD_AT;
            L25:
                return PriorityMsgType.URGENT;
            L26:
                return PriorityMsgType.ORGANIZATION;
            L20:
                return PriorityMsgType.PRIORITY_MSG_TYPE_UNKNOWN;
            }
        }

        @JvmStatic
        public static final PriorityMsgType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<PriorityMsgType> getEntries() {
            return b;
        }

        static {
            PriorityMsgType r0 = new PriorityMsgType("PRIORITY_MSG_TYPE_UNKNOWN", 0, 0);
            PRIORITY_MSG_TYPE_UNKNOWN = r0;
            PriorityMsgType r1 = new PriorityMsgType("ORGANIZATION", 1, 1);
            ORGANIZATION = r1;
            PriorityMsgType r3 = new PriorityMsgType("URGENT", 2, 2);
            URGENT = r3;
            PriorityMsgType r5 = new PriorityMsgType("UNREAD_AT", 3, 3);
            UNREAD_AT = r5;
            PriorityMsgType r7 = new PriorityMsgType("SPECIAL_FOCUS", 4, 4);
            SPECIAL_FOCUS = r7;
            PriorityMsgType r9 = new PriorityMsgType("RECENTLY_ADDED_GROUP", 5, 5);
            RECENTLY_ADDED_GROUP = r9;
            PriorityMsgType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PriorityMsgType.class), Syntax.PROTO_2, r0);
        }

        public static PriorityMsgType[] values() {
            return (PriorityMsgType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static PriorityMsgType valueOf(String r1) {
            return (PriorityMsgType) r27.a.a(PriorityMsgType.class, r1);
        }

        public PriorityMsgType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/server/pb/entities/PriorityInfo$PriorityStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PRIORITY_STATUS_UNKNOWN", "RECEIVED_PRIORITY_MESSAGE", "CANCEL_PRIORITY", "PRIORITY", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PriorityStatus extends Enum<PriorityStatus> implements o0 {
        public static final ProtoAdapter<PriorityStatus> ADAPTER = null;
        public static final PriorityStatus CANCEL_PRIORITY = null;
        public static final b Companion = null;
        public static final PriorityStatus PRIORITY = null;
        public static final PriorityStatus PRIORITY_STATUS_UNKNOWN = null;
        public static final PriorityStatus RECEIVED_PRIORITY_MESSAGE = null;
        public static final /* synthetic */ PriorityStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<PriorityStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                PriorityStatus.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return PriorityStatus.PRIORITY;
            L18:
                return PriorityStatus.CANCEL_PRIORITY;
            L19:
                return PriorityStatus.RECEIVED_PRIORITY_MESSAGE;
            L15:
                return PriorityStatus.PRIORITY_STATUS_UNKNOWN;
            }

            public a(KClass<PriorityStatus> r1, Syntax r2, PriorityStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<PriorityStatus> getEntries() {
            return b;
        }

        static {
            PriorityStatus r0 = new PriorityStatus("PRIORITY_STATUS_UNKNOWN", 0, 0);
            PRIORITY_STATUS_UNKNOWN = r0;
            PriorityStatus r1 = new PriorityStatus("RECEIVED_PRIORITY_MESSAGE", 1, 1);
            RECEIVED_PRIORITY_MESSAGE = r1;
            PriorityStatus r3 = new PriorityStatus("CANCEL_PRIORITY", 2, 2);
            CANCEL_PRIORITY = r3;
            PriorityStatus r5 = new PriorityStatus("PRIORITY", 3, 3);
            PRIORITY = r5;
            PriorityStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PriorityStatus.class), Syntax.PROTO_2, r0);
        }

        public static PriorityStatus[] values() {
            return (PriorityStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final PriorityStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return PRIORITY;
        L18:
            return CANCEL_PRIORITY;
        L19:
            return RECEIVED_PRIORITY_MESSAGE;
        L15:
            return PRIORITY_STATUS_UNKNOWN;
        }

        public static PriorityStatus valueOf(String r1) {
            return (PriorityStatus) r27.a.a(PriorityStatus.class, r1);
        }

        public PriorityStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/server/pb/entities/PriorityInfo$SinglePriorityMsg;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/PriorityInfo$SinglePriorityMsg$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/PriorityInfo$SinglePriorityMsg$Builder;Lokio/ByteString;)V", "priority_msg_position", "", "getPriority_msg_position", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "priority_msg_type", "Lcom/lark/kmp/server/pb/entities/PriorityInfo$PriorityMsgType;", "getPriority_msg_type", "()Lcom/lark/kmp/server/pb/entities/PriorityInfo$PriorityMsgType;", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SinglePriorityMsg extends Message<SinglePriorityMsg, a> {
        public static final ProtoAdapter<SinglePriorityMsg> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer priority_msg_position;
        private final PriorityMsgType priority_msg_type;

        public static final class a extends Message.a<SinglePriorityMsg, a> {
            public Integer d;
            public PriorityMsgType e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new SinglePriorityMsg(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SinglePriorityMsg> {
            @Override // com.lark.wire.ProtoAdapter
            public final SinglePriorityMsg c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = PriorityMsgType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new SinglePriorityMsg(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SinglePriorityMsg r5) {
                SinglePriorityMsg r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.h.l(1, r6.getPriority_msg_position())) + PriorityMsgType.ADAPTER.l(2, r6.getPriority_msg_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SinglePriorityMsg r5) {
                SinglePriorityMsg r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getPriority_msg_position());
                PriorityMsgType.ADAPTER.i(r4, 2, r6.getPriority_msg_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SinglePriorityMsg r5) {
                SinglePriorityMsg r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                PriorityMsgType.ADAPTER.j(r4, 2, r6.getPriority_msg_type());
                ProtoAdapter.h.j(r4, 1, r6.getPriority_msg_position());
            }

            public b(FieldEncoding r7, KClass<SinglePriorityMsg> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/entities.PriorityInfo.SinglePriorityMsg", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SinglePriorityMsg(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SinglePriorityMsg.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.priority_msg_position;
            r0.e = this.priority_msg_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SinglePriorityMsg.class).getSimpleName() + "@" + hashCode();
        }

        public final Integer getPriority_msg_position() {
            return this.priority_msg_position;
        }

        public final PriorityMsgType getPriority_msg_type() {
            return this.priority_msg_type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public SinglePriorityMsg(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.priority_msg_position = r2.d;
            this.priority_msg_type = r2.e;
        }

        public /* synthetic */ SinglePriorityMsg(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<PriorityInfo, a> {
        public PriorityStatus d;
        public Integer e;
        public Long f;
        public Map<Integer, SinglePriorityMsg> g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new PriorityInfo(this, c(), null);
        }

        public a() {
            this.g = MapsKt.emptyMap();
        }
    }

    public static final class b extends ProtoAdapter<PriorityInfo> {
        public final Lazy v;

        @Override // com.lark.wire.ProtoAdapter
        public final PriorityInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r0 = new a();
            LinkedHashMap r1 = new LinkedHashMap();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L21;
            if (r4 != 1) goto L8;
            r0.d = PriorityStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r0.e = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r0.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r10));
            goto L3
        L13:
            r10.j(r4);
            goto L3
        L21:
            ByteString r11 = r10.d(r2);
            Intrinsics.checkNotNullParameter(r1, "priority_msg_type_2_single_priority_msg");
            r0.g = r1;
            return new PriorityInfo(r0, r11, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PriorityInfo r5) {
            PriorityInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((r6.unknownFields().size() + PriorityStatus.ADAPTER.l(1, r6.getPriority_status())) + ProtoAdapter.h.l(2, r6.getMax_priority_position())) + ProtoAdapter.k.l(3, r6.getUpdate_time_ms())) + ((ProtoAdapter) this.v.getValue()).l(4, r6.getPriority_msg_type_2_single_priority_msg());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, PriorityInfo r5) {
            PriorityInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            PriorityStatus.ADAPTER.i(r4, 1, r6.getPriority_status());
            ProtoAdapter.h.i(r4, 2, r6.getMax_priority_position());
            ProtoAdapter.k.i(r4, 3, r6.getUpdate_time_ms());
            ((ProtoAdapter) this.v.getValue()).i(r4, 4, r6.getPriority_msg_type_2_single_priority_msg());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, PriorityInfo r5) {
            PriorityInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ((ProtoAdapter) this.v.getValue()).j(r4, 4, r6.getPriority_msg_type_2_single_priority_msg());
            ProtoAdapter.k.j(r4, 3, r6.getUpdate_time_ms());
            ProtoAdapter.h.j(r4, 2, r6.getMax_priority_position());
            PriorityStatus.ADAPTER.j(r4, 1, r6.getPriority_status());
        }

        public b(FieldEncoding r7, KClass<PriorityInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.PriorityInfo", r9, null);
            this.v = LazyKt.lazy(new ky7.d());
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PriorityInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PriorityInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.priority_status;
        r0.e = this.max_priority_position;
        r0.f = this.update_time_ms;
        r0.g = this.priority_msg_type_2_single_priority_msg;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PriorityInfo.class).getSimpleName() + "@" + hashCode();
    }

    public final Integer getMax_priority_position() {
        return this.max_priority_position;
    }

    public final Map<Integer, SinglePriorityMsg> getPriority_msg_type_2_single_priority_msg() {
        return this.priority_msg_type_2_single_priority_msg;
    }

    public final PriorityStatus getPriority_status() {
        return this.priority_status;
    }

    public final Long getUpdate_time_ms() {
        return this.update_time_ms;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public PriorityInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.priority_status = r2.d;
        this.max_priority_position = r2.e;
        this.update_time_ms = r2.f;
        this.priority_msg_type_2_single_priority_msg = com.lark.wire.internal.a.d("priority_msg_type_2_single_priority_msg", r2.g);
    }

    public /* synthetic */ PriorityInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
