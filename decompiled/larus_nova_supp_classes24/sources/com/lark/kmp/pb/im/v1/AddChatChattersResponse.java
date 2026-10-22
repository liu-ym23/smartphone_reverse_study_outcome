package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.Entity;
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
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/im/v1/AddChatChattersResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/AddChatChattersResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/AddChatChattersResponse$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "entity", "Lcom/lark/kmp/pb/basic/v1/Entity;", "getEntity", "()Lcom/lark/kmp/pb/basic/v1/Entity;", "join_group_application_id", "getJoin_group_application_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AddChatChattersResponse extends Message<AddChatChattersResponse, a> {
    public static final ProtoAdapter<AddChatChattersResponse> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final we6.c<AddChatChattersResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;
    private final Entity entity;
    private final String join_group_application_id;

    public static final class a extends Message.a<AddChatChattersResponse, a> implements d<AddChatChattersResponse> {
        public String d;
        public Entity e;
        public String f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new AddChatChattersResponse(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<AddChatChattersResponse> implements we6.c<AddChatChattersResponse> {
        @Override // com.lark.wire.ProtoAdapter
        public final AddChatChattersResponse c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = Entity.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L11;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L11:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L16:
            return new AddChatChattersResponse(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AddChatChattersResponse r6) {
            AddChatChattersResponse r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(1, r7.getChat_id())) + Entity.ADAPTER.l(2, r7.getEntity())) + r1.l(3, r7.getJoin_group_application_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, AddChatChattersResponse r6) {
            AddChatChattersResponse r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getChat_id());
            Entity.ADAPTER.i(r5, 2, r7.getEntity());
            r0.i(r5, 3, r7.getJoin_group_application_id());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, AddChatChattersResponse r6) {
            AddChatChattersResponse r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getJoin_group_application_id());
            Entity.ADAPTER.j(r5, 2, r7.getEntity());
            r0.j(r5, 1, r7.getChat_id());
        }

        public b(FieldEncoding r7, KClass<AddChatChattersResponse> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.AddChatChattersResponse", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AddChatChattersResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddChatChattersResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.AddChatChattersResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.e = this.entity;
        r0.f = this.join_group_application_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AddChatChattersResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final String getJoin_group_application_id() {
        return this.join_group_application_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public AddChatChattersResponse(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chat_id = r2.d;
        this.entity = r2.e;
        this.join_group_application_id = r2.f;
    }

    public /* synthetic */ AddChatChattersResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
