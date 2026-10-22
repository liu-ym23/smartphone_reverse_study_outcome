package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatAdminUsersResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/GetChatAdminUsersResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/GetChatAdminUsersResponse$Builder;Lokio/ByteString;)V", "admin_users", "", "", "getAdmin_users", "()Ljava/util/List;", "entity", "Lcom/lark/kmp/pb/basic/v1/Entity;", "getEntity", "()Lcom/lark/kmp/pb/basic/v1/Entity;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetChatAdminUsersResponse extends Message<GetChatAdminUsersResponse, a> {
    public static final ProtoAdapter<GetChatAdminUsersResponse> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<GetChatAdminUsersResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final List<String> admin_users;
    private final Entity entity;

    public static final class a extends Message.a<GetChatAdminUsersResponse, a> implements d<GetChatAdminUsersResponse> {
        public List<String> d;
        public Entity e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetChatAdminUsersResponse(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<GetChatAdminUsersResponse> implements we6.c<GetChatAdminUsersResponse> {
        @Override // com.lark.wire.ProtoAdapter
        public final GetChatAdminUsersResponse c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L12;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r2.add(r8.i());
            goto L3
        L8:
            if (r5 != 2) goto L9;
            r1.e = Entity.ADAPTER.c(r8);
            goto L3
        L9:
            r8.j(r5);
            goto L3
        L12:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "admin_users");
            com.lark.wire.internal.a.a(r2);
            r1.d = r2;
            return new GetChatAdminUsersResponse(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(GetChatAdminUsersResponse r5) {
            GetChatAdminUsersResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.a().l(1, r6.getAdmin_users())) + Entity.ADAPTER.l(2, r6.getEntity());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, GetChatAdminUsersResponse r5) {
            GetChatAdminUsersResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.a().i(r4, 1, r6.getAdmin_users());
            Entity.ADAPTER.i(r4, 2, r6.getEntity());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, GetChatAdminUsersResponse r5) {
            GetChatAdminUsersResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Entity.ADAPTER.j(r4, 2, r6.getEntity());
            ProtoAdapter.q.a().j(r4, 1, r6.getAdmin_users());
        }

        public b(FieldEncoding r7, KClass<GetChatAdminUsersResponse> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.GetChatAdminUsersResponse", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ GetChatAdminUsersResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetChatAdminUsersResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.GetChatAdminUsersResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.admin_users;
        r0.e = this.entity;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetChatAdminUsersResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getAdmin_users() {
        return this.admin_users;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetChatAdminUsersResponse(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.admin_users = com.lark.wire.internal.a.c("admin_users", r2.d);
        Entity r4 = r2.e;
        Intrinsics.checkNotNull(r4);
        this.entity = r4;
    }

    public /* synthetic */ GetChatAdminUsersResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
