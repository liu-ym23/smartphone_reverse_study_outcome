package com.lark.kmp.pb.im.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/im/v1/ClearChatMessagesRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/ClearChatMessagesRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/ClearChatMessagesRequest$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ClearChatMessagesRequest extends Message<ClearChatMessagesRequest, a> {
    public static final ProtoAdapter<ClearChatMessagesRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<ClearChatMessagesRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;

    public static final class a extends Message.a<ClearChatMessagesRequest, a> implements d<ClearChatMessagesRequest> {
        public String d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new ClearChatMessagesRequest(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ClearChatMessagesRequest> implements we6.c<ClearChatMessagesRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final ClearChatMessagesRequest c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L10;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L10:
            return new ClearChatMessagesRequest(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ClearChatMessagesRequest r4) {
            ClearChatMessagesRequest r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getChat_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ClearChatMessagesRequest r5) {
            ClearChatMessagesRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getChat_id());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, ClearChatMessagesRequest r4) {
            ClearChatMessagesRequest r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            ProtoAdapter.q.j(r3, 1, r5.getChat_id());
        }

        public b(FieldEncoding r7, KClass<ClearChatMessagesRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.ClearChatMessagesRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ClearChatMessagesRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ClearChatMessagesRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.ClearChatMessagesRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ClearChatMessagesRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public ClearChatMessagesRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chat_id = r2.d;
    }

    public /* synthetic */ ClearChatMessagesRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
