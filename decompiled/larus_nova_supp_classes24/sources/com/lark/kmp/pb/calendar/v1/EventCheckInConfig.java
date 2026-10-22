package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$Builder;Lokio/ByteString;)V", "check_in_enable", "", "getCheck_in_enable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "check_in_start_time", "Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime;", "getCheck_in_start_time", "()Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime;", "check_in_end_time", "getCheck_in_end_time", "need_notify_attendees", "getNeed_notify_attendees", "newBuilder", "toString", "", "Builder", "Companion", "CheckInTime", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EventCheckInConfig extends Message<EventCheckInConfig, a> {
    public static final ProtoAdapter<EventCheckInConfig> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean check_in_enable;
    private final CheckInTime check_in_end_time;
    private final CheckInTime check_in_start_time;
    private final Boolean need_notify_attendees;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime$Type;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime$Type;", "duration", "", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CheckInTime extends Message<CheckInTime, a> {
        public static final ProtoAdapter<CheckInTime> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long duration;
        private final Type type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventCheckInConfig$CheckInTime$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BeforeEventStart", "AfterEventStart", "AfterEventEnd", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type AfterEventEnd = null;
            public static final Type AfterEventStart = null;
            public static final Type BeforeEventStart = null;
            public static final b Companion = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 1) goto L12;
                    if (r2 == 2) goto L15;
                    if (r2 == 3) goto L14;
                    return null;
                L14:
                    return Type.AfterEventEnd;
                L15:
                    return Type.AfterEventStart;
                L12:
                    return Type.BeforeEventStart;
                }

                public a(KClass<Type> r2, Syntax r3) {
                    super(r2, r3, null);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Type> getEntries() {
                return b;
            }

            static {
                Type r0 = new Type("BeforeEventStart", 0, 1);
                BeforeEventStart = r0;
                Type r1 = new Type("AfterEventStart", 1, 2);
                AfterEventStart = r1;
                Type r4 = new Type("AfterEventEnd", 2, 3);
                AfterEventEnd = r4;
                Type[] r6 = {r0, r1, r4};
                a = r6;
                b = EnumEntriesKt.enumEntries(r6);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
            }

            public static Type[] values() {
                return (Type[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L15;
                if (r1 == 3) goto L14;
                return null;
            L14:
                return AfterEventEnd;
            L15:
                return AfterEventStart;
            L12:
                return BeforeEventStart;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends Message.a<CheckInTime, a> {
            public Type d;
            public Long e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CheckInTime(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CheckInTime> {
            @Override // com.lark.wire.ProtoAdapter
            public final CheckInTime c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new CheckInTime(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CheckInTime r5) {
                CheckInTime r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + ProtoAdapter.k.l(2, r6.getDuration());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CheckInTime r5) {
                CheckInTime r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.k.i(r4, 2, r6.getDuration());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CheckInTime r5) {
                CheckInTime r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 2, r6.getDuration());
                Type.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<CheckInTime> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.EventCheckInConfig.CheckInTime", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CheckInTime(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CheckInTime.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.duration;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CheckInTime.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final Type getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CheckInTime(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.duration = r2.e;
        }

        public /* synthetic */ CheckInTime(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<EventCheckInConfig, a> {
        public Boolean d;
        public CheckInTime e;
        public CheckInTime f;
        public Boolean g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new EventCheckInConfig(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EventCheckInConfig> {
        @Override // com.lark.wire.ProtoAdapter
        public final EventCheckInConfig c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = CheckInTime.ADAPTER.c(r6);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = CheckInTime.ADAPTER.c(r6);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.g = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L13:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L19:
            return new EventCheckInConfig(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EventCheckInConfig r6) {
            EventCheckInConfig r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            l r1 = ProtoAdapter.g;
            int r2 = r0 + r1.l(1, r7.getCheck_in_enable());
            ProtoAdapter<CheckInTime> r3 = CheckInTime.ADAPTER;
            return ((r2 + r3.l(2, r7.getCheck_in_start_time())) + r3.l(3, r7.getCheck_in_end_time())) + r1.l(4, r7.getNeed_notify_attendees());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, EventCheckInConfig r6) {
            EventCheckInConfig r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            l r0 = ProtoAdapter.g;
            r0.i(r5, 1, r7.getCheck_in_enable());
            ProtoAdapter<CheckInTime> r1 = CheckInTime.ADAPTER;
            r1.i(r5, 2, r7.getCheck_in_start_time());
            r1.i(r5, 3, r7.getCheck_in_end_time());
            r0.i(r5, 4, r7.getNeed_notify_attendees());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, EventCheckInConfig r6) {
            EventCheckInConfig r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 4, r7.getNeed_notify_attendees());
            ProtoAdapter<CheckInTime> r1 = CheckInTime.ADAPTER;
            r1.j(r5, 3, r7.getCheck_in_end_time());
            r1.j(r5, 2, r7.getCheck_in_start_time());
            r0.j(r5, 1, r7.getCheck_in_enable());
        }

        public b(FieldEncoding r7, KClass<EventCheckInConfig> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.EventCheckInConfig", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EventCheckInConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EventCheckInConfig.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.check_in_enable;
        r0.e = this.check_in_start_time;
        r0.f = this.check_in_end_time;
        r0.g = this.need_notify_attendees;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EventCheckInConfig.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getCheck_in_enable() {
        return this.check_in_enable;
    }

    public final CheckInTime getCheck_in_end_time() {
        return this.check_in_end_time;
    }

    public final CheckInTime getCheck_in_start_time() {
        return this.check_in_start_time;
    }

    public final Boolean getNeed_notify_attendees() {
        return this.need_notify_attendees;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public EventCheckInConfig(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.check_in_enable = r2.d;
        this.check_in_start_time = r2.e;
        this.check_in_end_time = r2.f;
        this.need_notify_attendees = r2.g;
    }

    public /* synthetic */ EventCheckInConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
