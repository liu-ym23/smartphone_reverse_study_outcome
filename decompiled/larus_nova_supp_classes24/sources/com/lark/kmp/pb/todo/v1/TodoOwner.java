package com.lark.kmp.pb.todo.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Deprecated(message = "TodoOwner is deprecated")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoOwner;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/TodoOwner$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/TodoOwner$Builder;Lokio/ByteString;)V", "user", "Lcom/lark/kmp/pb/todo/v1/TodoUser;", "getUser", "()Lcom/lark/kmp/pb/todo/v1/TodoUser;", "assigner_id", "", "getAssigner_id", "()Ljava/lang/String;", "read_milli_time", "", "getRead_milli_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoOwner extends Message<TodoOwner, a> {
    public static final ProtoAdapter<TodoOwner> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String assigner_id;
    private final Long read_milli_time;
    private final TodoUser user;

    public static final class a extends Message.a<TodoOwner, a> {
        public TodoUser d;
        public String e;
        public Long f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new TodoOwner(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TodoOwner> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoOwner c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            r1.d = TodoUser.ADAPTER.c(r7);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.f = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L11:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L16:
            return new TodoOwner(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoOwner r5) {
            TodoOwner r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + TodoUser.ADAPTER.l(1, r6.getUser())) + ProtoAdapter.q.l(2, r6.getAssigner_id())) + ProtoAdapter.k.l(3, r6.getRead_milli_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TodoOwner r5) {
            TodoOwner r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            TodoUser.ADAPTER.i(r4, 1, r6.getUser());
            ProtoAdapter.q.i(r4, 2, r6.getAssigner_id());
            ProtoAdapter.k.i(r4, 3, r6.getRead_milli_time());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TodoOwner r5) {
            TodoOwner r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 3, r6.getRead_milli_time());
            ProtoAdapter.q.j(r4, 2, r6.getAssigner_id());
            TodoUser.ADAPTER.j(r4, 1, r6.getUser());
        }

        public b(FieldEncoding r7, KClass<TodoOwner> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/todo.v1.TodoOwner", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoOwner(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoOwner.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.user;
        r0.e = this.assigner_id;
        r0.f = this.read_milli_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoOwner.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAssigner_id() {
        return this.assigner_id;
    }

    public final Long getRead_milli_time() {
        return this.read_milli_time;
    }

    public final TodoUser getUser() {
        return this.user;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public TodoOwner(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.user = r2.d;
        this.assigner_id = r2.e;
        this.read_milli_time = r2.f;
    }

    public /* synthetic */ TodoOwner(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
