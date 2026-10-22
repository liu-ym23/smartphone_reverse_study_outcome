package com.lark.kmp.pb.im.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/im/v1/PatchChatAdminUsersRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/PatchChatAdminUsersRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/PatchChatAdminUsersRequest$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "to_add_user_ids", "", "getTo_add_user_ids", "()Ljava/util/List;", "to_del_user_ids", "getTo_del_user_ids", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PatchChatAdminUsersRequest extends Message<PatchChatAdminUsersRequest, a> {
    public static final ProtoAdapter<PatchChatAdminUsersRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<PatchChatAdminUsersRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;
    private final List<String> to_add_user_ids;
    private final List<String> to_del_user_ids;

    public static final class a extends Message.a<PatchChatAdminUsersRequest, a> implements d<PatchChatAdminUsersRequest> {
        public String d;
        public List<String> e;
        public List<String> f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new PatchChatAdminUsersRequest(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
            this.f = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<PatchChatAdminUsersRequest> implements we6.c<PatchChatAdminUsersRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final PatchChatAdminUsersRequest c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r9.c();
        L3:
            int r6 = r9.e();
            if (r6 == (-1)) goto L15;
            if (r6 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r9, "reader");
            String r7 = r9.i();
            Intrinsics.checkNotNullParameter(r7, "chat_id");
            r1.d = r7;
            goto L3
        L8:
            if (r6 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r9, "reader");
            r2.add(r9.i());
            goto L3
        L10:
            if (r6 != 3) goto L11;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r9, "reader");
            r3.add(r9.i());
            goto L3
        L11:
            r9.j(r6);
            goto L3
        L15:
            ByteString r10 = r9.d(r4);
            Intrinsics.checkNotNullParameter(r2, "to_add_user_ids");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            Intrinsics.checkNotNullParameter(r3, "to_del_user_ids");
            com.lark.wire.internal.a.a(r3);
            r1.f = r3;
            return new PatchChatAdminUsersRequest(r1, r10, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PatchChatAdminUsersRequest r6) {
            PatchChatAdminUsersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(1, r7.getChat_id())) + r1.a().l(2, r7.getTo_add_user_ids())) + r1.a().l(3, r7.getTo_del_user_ids());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, PatchChatAdminUsersRequest r6) {
            PatchChatAdminUsersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getChat_id());
            r0.a().i(r5, 2, r7.getTo_add_user_ids());
            r0.a().i(r5, 3, r7.getTo_del_user_ids());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, PatchChatAdminUsersRequest r6) {
            PatchChatAdminUsersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.a().j(r5, 3, r7.getTo_del_user_ids());
            r0.a().j(r5, 2, r7.getTo_add_user_ids());
            r0.j(r5, 1, r7.getChat_id());
        }

        public b(FieldEncoding r7, KClass<PatchChatAdminUsersRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.PatchChatAdminUsersRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PatchChatAdminUsersRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PatchChatAdminUsersRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.PatchChatAdminUsersRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.e = this.to_add_user_ids;
        r0.f = this.to_del_user_ids;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PatchChatAdminUsersRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final List<String> getTo_add_user_ids() {
        return this.to_add_user_ids;
    }

    public final List<String> getTo_del_user_ids() {
        return this.to_del_user_ids;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public PatchChatAdminUsersRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.chat_id = r4;
        this.to_add_user_ids = com.lark.wire.internal.a.c("to_add_user_ids", r2.e);
        this.to_del_user_ids = com.lark.wire.internal.a.c("to_del_user_ids", r2.f);
    }

    public /* synthetic */ PatchChatAdminUsersRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
