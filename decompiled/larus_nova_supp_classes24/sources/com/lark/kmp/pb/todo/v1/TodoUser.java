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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoUser;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/TodoUser$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/TodoUser$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/String;", "name", "getName", "avatar_key", "getAvatar_key", "tenant_id", "getTenant_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoUser extends Message<TodoUser, a> {
    public static final ProtoAdapter<TodoUser> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String avatar_key;
    private final String name;
    private final String tenant_id;
    private final String user_id;

    public static final class a extends Message.a<TodoUser, a> {
        public String d;
        public String e;
        public String f;
        public String g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new TodoUser(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TodoUser> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoUser c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L12:
            if (r4 != 4) goto L13;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new TodoUser(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoUser r5) {
            TodoUser r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((r0 + r1.l(1, r6.getUser_id())) + r1.l(2, r6.getName())) + r1.l(3, r6.getAvatar_key())) + r1.l(4, r6.getTenant_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TodoUser r5) {
            TodoUser r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getUser_id());
            r0.i(r4, 2, r6.getName());
            r0.i(r4, 3, r6.getAvatar_key());
            r0.i(r4, 4, r6.getTenant_id());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TodoUser r5) {
            TodoUser r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 4, r6.getTenant_id());
            r0.j(r4, 3, r6.getAvatar_key());
            r0.j(r4, 2, r6.getName());
            r0.j(r4, 1, r6.getUser_id());
        }

        public b(FieldEncoding r7, KClass<TodoUser> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/todo.v1.TodoUser", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoUser(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoUser.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.user_id;
        r0.e = this.name;
        r0.f = this.avatar_key;
        r0.g = this.tenant_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoUser.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public TodoUser(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.user_id = r2.d;
        this.name = r2.e;
        this.avatar_key = r2.f;
        this.tenant_id = r2.g;
    }

    public /* synthetic */ TodoUser(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
