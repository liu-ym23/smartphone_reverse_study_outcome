package com.lark.kmp.pb.todo.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoFollower;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/TodoFollower$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/TodoFollower$Builder;Lokio/ByteString;)V", "follower_id", "", "getFollower_id", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/todo/v1/TodoItemMemberType;", "getType", "()Lcom/lark/kmp/pb/todo/v1/TodoItemMemberType;", "inviter_id", "getInviter_id", "sort_position", "", "getSort_position", "()Ljava/lang/Long;", "Ljava/lang/Long;", "user", "Lcom/lark/kmp/pb/todo/v1/TodoFollower$User;", "getUser", "()Lcom/lark/kmp/pb/todo/v1/TodoFollower$User;", "newBuilder", "toString", "Builder", "Companion", "User", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoFollower extends Message<TodoFollower, a> {
    public static final ProtoAdapter<TodoFollower> ADAPTER = null;
    public static final c Companion = null;
    public static final TodoItemMemberType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    private final String follower_id;
    private final String inviter_id;
    private final Long sort_position;
    private final TodoItemMemberType type;
    private final User user;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoFollower$User;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/TodoFollower$User$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/TodoFollower$User$Builder;Lokio/ByteString;)V", "user", "Lcom/lark/kmp/pb/todo/v1/TodoUser;", "getUser", "()Lcom/lark/kmp/pb/todo/v1/TodoUser;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class User extends Message<User, a> {
        public static final ProtoAdapter<User> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final TodoUser user;

        public static final class a extends Message.a<User, a> {
            public TodoUser d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new User(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<User> {
            @Override // com.lark.wire.ProtoAdapter
            public final User c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = TodoUser.ADAPTER.c(r6);
                goto L3
            L10:
                return new User(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(User r4) {
                User r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + TodoUser.ADAPTER.l(1, r5.getUser());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, User r5) {
                User r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                TodoUser.ADAPTER.i(r4, 1, r6.getUser());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, User r4) {
                User r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                TodoUser.ADAPTER.j(r3, 1, r5.getUser());
            }

            public b(FieldEncoding r7, KClass<User> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/todo.v1.TodoFollower.User", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ User(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(User.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(User.class).getSimpleName() + '@' + hashCode();
        }

        public final TodoUser getUser() {
            return this.user;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public User(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.user = r2.d;
        }

        public /* synthetic */ User(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<TodoFollower, a> {
        public String d;
        public TodoItemMemberType e;
        public String f;
        public Long g;
        public User h;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new TodoFollower(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TodoFollower> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoFollower c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = TodoItemMemberType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            if (r4 != 100) goto L15;
            r1.h = User.ADAPTER.c(r10);
            goto L3
        L15:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L25:
            return new TodoFollower(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoFollower r6) {
            TodoFollower r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((r0 + r1.l(1, r7.getFollower_id())) + TodoItemMemberType.ADAPTER.l(2, r7.getType())) + r1.l(3, r7.getInviter_id())) + ProtoAdapter.k.l(4, r7.getSort_position())) + User.ADAPTER.l(100, r7.getUser());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, TodoFollower r6) {
            TodoFollower r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getFollower_id());
            TodoItemMemberType.ADAPTER.i(r5, 2, r7.getType());
            r0.i(r5, 3, r7.getInviter_id());
            ProtoAdapter.k.i(r5, 4, r7.getSort_position());
            User.ADAPTER.i(r5, 100, r7.getUser());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, TodoFollower r6) {
            TodoFollower r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            User.ADAPTER.j(r5, 100, r7.getUser());
            ProtoAdapter.k.j(r5, 4, r7.getSort_position());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getInviter_id());
            TodoItemMemberType.ADAPTER.j(r5, 2, r7.getType());
            r0.j(r5, 1, r7.getFollower_id());
        }

        public b(FieldEncoding r7, KClass<TodoFollower> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/todo.v1.TodoFollower", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoFollower(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = TodoItemMemberType.Unknown;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoFollower.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.follower_id;
        r0.e = this.type;
        r0.f = this.inviter_id;
        r0.g = this.sort_position;
        r0.h = this.user;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoFollower.class).getSimpleName() + '@' + hashCode();
    }

    public final String getFollower_id() {
        return this.follower_id;
    }

    public final String getInviter_id() {
        return this.inviter_id;
    }

    public final Long getSort_position() {
        return this.sort_position;
    }

    public final TodoItemMemberType getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public TodoFollower(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.follower_id = r2.d;
        this.type = r2.e;
        this.inviter_id = r2.f;
        this.sort_position = r2.g;
        this.user = r2.h;
    }

    public /* synthetic */ TodoFollower(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
