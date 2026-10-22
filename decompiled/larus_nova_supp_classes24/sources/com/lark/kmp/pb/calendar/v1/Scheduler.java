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
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Scheduler;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/Scheduler$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/Scheduler$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Scheduler extends Message<Scheduler, a> {
    public static final ProtoAdapter<Scheduler> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Scheduler$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "ONE_ON_ONE", "ROUND_ROBIN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type ONE_ON_ONE = null;
        public static final Type ROUND_ROBIN = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Type.ROUND_ROBIN;
            L15:
                return Type.ONE_ON_ONE;
            L12:
                return Type.UNKNOWN_TYPE;
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
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
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("ONE_ON_ONE", 1, 1);
            ONE_ON_ONE = r1;
            Type r3 = new Type("ROUND_ROBIN", 2, 2);
            ROUND_ROBIN = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return ROUND_ROBIN;
        L15:
            return ONE_ON_ONE;
        L12:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<Scheduler, a> {
        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new Scheduler(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<Scheduler> {
        @Override // com.lark.wire.ProtoAdapter
        public final Scheduler c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L7;
            r6.j(r3);
            goto L3
        L7:
            return new Scheduler(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Scheduler r2) {
            Scheduler r3 = r2;
            Intrinsics.checkNotNullParameter(r3, "value");
            return r3.unknownFields().size();
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r2, Scheduler r3) {
            Scheduler r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "writer");
            Intrinsics.checkNotNullParameter(r4, "value");
            r2.a(r4.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r2, Scheduler r3) {
            Scheduler r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "writer");
            Intrinsics.checkNotNullParameter(r4, "value");
            r2.d(r4.unknownFields());
        }

        public b(FieldEncoding r7, KClass<Scheduler> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.Scheduler", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Scheduler(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Scheduler.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Scheduler.class).getSimpleName() + '@' + hashCode();
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public Scheduler(ByteString r2) {
        super(ADAPTER, r2);
    }

    public /* synthetic */ Scheduler(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r2);
    }
}
