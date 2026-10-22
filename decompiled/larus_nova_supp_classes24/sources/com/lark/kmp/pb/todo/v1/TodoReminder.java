package com.lark.kmp.pb.todo.v1;

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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoReminder;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/TodoReminder$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/TodoReminder$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/todo/v1/TodoReminder$Type;", "getType", "()Lcom/lark/kmp/pb/todo/v1/TodoReminder$Type;", "time", "", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "is_all_day", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoReminder extends Message<TodoReminder, a> {
    public static final ProtoAdapter<TodoReminder> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean is_all_day;
    private final Long time;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoReminder$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ABSOLUTE", "RELATIVE", "FLOATING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final Type ABSOLUTE = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type FLOATING = null;
        public static final Type RELATIVE = null;
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
                return Type.FLOATING;
            L15:
                return Type.RELATIVE;
            L12:
                return Type.ABSOLUTE;
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
            Type r0 = new Type("ABSOLUTE", 0, 1);
            ABSOLUTE = r0;
            Type r1 = new Type("RELATIVE", 1, 2);
            RELATIVE = r1;
            Type r4 = new Type("FLOATING", 2, 3);
            FLOATING = r4;
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
            return FLOATING;
        L15:
            return RELATIVE;
        L12:
            return ABSOLUTE;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<TodoReminder, a> {
        public Type d;
        public Long e;
        public Boolean f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new TodoReminder(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TodoReminder> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoReminder c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L19:
            return new TodoReminder(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoReminder r5) {
            TodoReminder r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + ProtoAdapter.k.l(2, r6.getTime())) + ProtoAdapter.g.l(3, r6.is_all_day());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TodoReminder r5) {
            TodoReminder r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Type.ADAPTER.i(r4, 1, r6.getType());
            ProtoAdapter.k.i(r4, 2, r6.getTime());
            ProtoAdapter.g.i(r4, 3, r6.is_all_day());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TodoReminder r5) {
            TodoReminder r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 3, r6.is_all_day());
            ProtoAdapter.k.j(r4, 2, r6.getTime());
            Type.ADAPTER.j(r4, 1, r6.getType());
        }

        public b(FieldEncoding r7, KClass<TodoReminder> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/todo.v1.TodoReminder", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoReminder(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoReminder.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.time;
        r0.f = this.is_all_day;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoReminder.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getTime() {
        return this.time;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean is_all_day() {
        return this.is_all_day;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public TodoReminder(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.type = r2.d;
        this.time = r2.e;
        this.is_all_day = r2.f;
    }

    public /* synthetic */ TodoReminder(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
