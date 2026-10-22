package com.lark.kmp.pb.contact.v1;

import com.lark.kmp.pb.basic.v1.SyncDataStrategy;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/contact/v1/MGetChattersRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/contact/v1/MGetChattersRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/contact/v1/MGetChattersRequest$Builder;Lokio/ByteString;)V", "chatter_ids", "", "", "getChatter_ids", "()Ljava/util/List;", "is_from_server", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "sync_data_strategy", "Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "getSync_data_strategy", "()Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MGetChattersRequest extends Message<MGetChattersRequest, a> {
    public static final ProtoAdapter<MGetChattersRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_IS_FROM_SERVER = false;
    public static final we6.c<MGetChattersRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final List<String> chatter_ids;
    private final Boolean is_from_server;
    private final SyncDataStrategy sync_data_strategy;

    public static final class a extends Message.a<MGetChattersRequest, a> implements d<MGetChattersRequest> {
        public List<String> d;
        public Boolean e;
        public SyncDataStrategy f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new MGetChattersRequest(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<MGetChattersRequest> implements we6.c<MGetChattersRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final MGetChattersRequest c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L18;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L8:
            if (r5 != 2) goto L10;
            r1.e = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L10:
            if (r5 != 3) goto L11;
            r1.f = SyncDataStrategy.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L11:
            r11.j(r5);
            goto L3
        L18:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "chatter_ids");
            com.lark.wire.internal.a.a(r2);
            r1.d = r2;
            return new MGetChattersRequest(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MGetChattersRequest r5) {
            MGetChattersRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.a().l(1, r6.getChatter_ids())) + ProtoAdapter.g.l(2, r6.is_from_server())) + SyncDataStrategy.ADAPTER.l(3, r6.getSync_data_strategy());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MGetChattersRequest r5) {
            MGetChattersRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.a().i(r4, 1, r6.getChatter_ids());
            ProtoAdapter.g.i(r4, 2, r6.is_from_server());
            SyncDataStrategy.ADAPTER.i(r4, 3, r6.getSync_data_strategy());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MGetChattersRequest r5) {
            MGetChattersRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            SyncDataStrategy.ADAPTER.j(r4, 3, r6.getSync_data_strategy());
            ProtoAdapter.g.j(r4, 2, r6.is_from_server());
            ProtoAdapter.q.a().j(r4, 1, r6.getChatter_ids());
        }

        public b(FieldEncoding r7, KClass<MGetChattersRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/contact.v1.MGetChattersRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MGetChattersRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MGetChattersRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.contact.v1.MGetChattersRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chatter_ids;
        r0.e = this.is_from_server;
        r0.f = this.sync_data_strategy;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MGetChattersRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getChatter_ids() {
        return this.chatter_ids;
    }

    public final SyncDataStrategy getSync_data_strategy() {
        return this.sync_data_strategy;
    }

    public final Boolean is_from_server() {
        return this.is_from_server;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public MGetChattersRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.d);
        this.is_from_server = r2.e;
        this.sync_data_strategy = r2.f;
    }

    public /* synthetic */ MGetChattersRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
