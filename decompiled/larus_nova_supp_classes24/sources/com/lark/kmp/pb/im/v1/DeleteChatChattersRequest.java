package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.PickEntities;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001c\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "chatter_ids", "", "getChatter_ids", "()Ljava/util/List;", "new_owner_id", "getNew_owner_id", "option", "Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$DeleteChatChatterOption;", "getOption", "()Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$DeleteChatChatterOption;", "pick_entities", "Lcom/lark/kmp/pb/basic/v1/PickEntities;", "getPick_entities", "newBuilder", "toString", "Builder", "Companion", "DeleteChatChatterOption", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DeleteChatChattersRequest extends Message<DeleteChatChattersRequest, a> {
    public static final ProtoAdapter<DeleteChatChattersRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<DeleteChatChattersRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;
    private final List<String> chatter_ids;
    private final String new_owner_id;
    private final DeleteChatChatterOption option;
    private final List<PickEntities> pick_entities;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$DeleteChatChatterOption;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$DeleteChatChatterOption$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/DeleteChatChattersRequest$DeleteChatChatterOption$Builder;Lokio/ByteString;)V", "withdraw", "", "getWithdraw", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DeleteChatChatterOption extends Message<DeleteChatChatterOption, a> {
        public static final ProtoAdapter<DeleteChatChatterOption> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean withdraw;

        public static final class a extends Message.a<DeleteChatChatterOption, a> {
            public Boolean d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new DeleteChatChatterOption(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DeleteChatChatterOption> {
            @Override // com.lark.wire.ProtoAdapter
            public final DeleteChatChatterOption c(g0 r6) {
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
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                return new DeleteChatChatterOption(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DeleteChatChatterOption r4) {
                DeleteChatChatterOption r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.g.l(1, r5.getWithdraw());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DeleteChatChatterOption r5) {
                DeleteChatChatterOption r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.getWithdraw());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, DeleteChatChatterOption r4) {
                DeleteChatChatterOption r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.g.j(r3, 1, r5.getWithdraw());
            }

            public b(FieldEncoding r7, KClass<DeleteChatChatterOption> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/im.v1.DeleteChatChattersRequest.DeleteChatChatterOption", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DeleteChatChatterOption(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DeleteChatChatterOption.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.withdraw;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DeleteChatChatterOption.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getWithdraw() {
            return this.withdraw;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public DeleteChatChatterOption(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.withdraw = r2.d;
        }

        public /* synthetic */ DeleteChatChatterOption(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<DeleteChatChattersRequest, a> implements d<DeleteChatChattersRequest> {
        public String d;
        public List<String> e;
        public String f;
        public DeleteChatChatterOption g;
        public List<PickEntities> h;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new DeleteChatChattersRequest(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
            this.h = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<DeleteChatChattersRequest> implements we6.c<DeleteChatChattersRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final DeleteChatChattersRequest c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r9.c();
        L3:
            int r6 = r9.e();
            if (r6 == (-1)) goto L21;
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
            if (r6 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r9, "reader");
            r1.f = r9.i();
            goto L3
        L12:
            if (r6 != 4) goto L14;
            r1.g = DeleteChatChatterOption.ADAPTER.c(r9);
            goto L3
        L14:
            if (r6 != 5) goto L15;
            r3.add(PickEntities.ADAPTER.c(r9));
            goto L3
        L15:
            r9.j(r6);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L21:
            ByteString r10 = r9.d(r4);
            Intrinsics.checkNotNullParameter(r2, "chatter_ids");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            Intrinsics.checkNotNullParameter(r3, "pick_entities");
            com.lark.wire.internal.a.a(r3);
            r1.h = r3;
            return new DeleteChatChattersRequest(r1, r10, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DeleteChatChattersRequest r6) {
            DeleteChatChattersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((r0 + r1.l(1, r7.getChat_id())) + r1.a().l(2, r7.getChatter_ids())) + r1.l(3, r7.getNew_owner_id())) + DeleteChatChatterOption.ADAPTER.l(4, r7.getOption())) + PickEntities.ADAPTER.a().l(5, r7.getPick_entities());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, DeleteChatChattersRequest r6) {
            DeleteChatChattersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getChat_id());
            r0.a().i(r5, 2, r7.getChatter_ids());
            r0.i(r5, 3, r7.getNew_owner_id());
            DeleteChatChatterOption.ADAPTER.i(r5, 4, r7.getOption());
            PickEntities.ADAPTER.a().i(r5, 5, r7.getPick_entities());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, DeleteChatChattersRequest r6) {
            DeleteChatChattersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            PickEntities.ADAPTER.a().j(r5, 5, r7.getPick_entities());
            DeleteChatChatterOption.ADAPTER.j(r5, 4, r7.getOption());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getNew_owner_id());
            r0.a().j(r5, 2, r7.getChatter_ids());
            r0.j(r5, 1, r7.getChat_id());
        }

        public b(FieldEncoding r7, KClass<DeleteChatChattersRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.DeleteChatChattersRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DeleteChatChattersRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DeleteChatChattersRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.DeleteChatChattersRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.e = this.chatter_ids;
        r0.f = this.new_owner_id;
        r0.g = this.option;
        r0.h = this.pick_entities;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DeleteChatChattersRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final List<String> getChatter_ids() {
        return this.chatter_ids;
    }

    public final String getNew_owner_id() {
        return this.new_owner_id;
    }

    public final DeleteChatChatterOption getOption() {
        return this.option;
    }

    public final List<PickEntities> getPick_entities() {
        return this.pick_entities;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public DeleteChatChattersRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.chat_id = r4;
        this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.e);
        this.new_owner_id = r2.f;
        this.option = r2.g;
        this.pick_entities = com.lark.wire.internal.a.c("pick_entities", r2.h);
    }

    public /* synthetic */ DeleteChatChattersRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
