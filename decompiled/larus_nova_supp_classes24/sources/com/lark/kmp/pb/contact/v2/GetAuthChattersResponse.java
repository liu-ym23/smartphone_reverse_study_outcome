package com.lark.kmp.pb.contact.v2;

import com.lark.kmp.pb.basic.v1.ChattersAuthResult;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/contact/v2/GetAuthChattersResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/contact/v2/GetAuthChattersResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/contact/v2/GetAuthChattersResponse$Builder;Lokio/ByteString;)V", "auth_result", "Lcom/lark/kmp/pb/basic/v1/ChattersAuthResult;", "getAuth_result", "()Lcom/lark/kmp/pb/basic/v1/ChattersAuthResult;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetAuthChattersResponse extends Message<GetAuthChattersResponse, a> {
    public static final ProtoAdapter<GetAuthChattersResponse> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<GetAuthChattersResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final ChattersAuthResult auth_result;

    public static final class a extends Message.a<GetAuthChattersResponse, a> implements d<GetAuthChattersResponse> {
        public ChattersAuthResult d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetAuthChattersResponse(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<GetAuthChattersResponse> implements we6.c<GetAuthChattersResponse> {
        @Override // com.lark.wire.ProtoAdapter
        public final GetAuthChattersResponse c(g0 r6) {
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
            r0.d = ChattersAuthResult.ADAPTER.c(r6);
            goto L3
        L10:
            return new GetAuthChattersResponse(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(GetAuthChattersResponse r4) {
            GetAuthChattersResponse r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + ChattersAuthResult.ADAPTER.l(1, r5.getAuth_result());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, GetAuthChattersResponse r5) {
            GetAuthChattersResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ChattersAuthResult.ADAPTER.i(r4, 1, r6.getAuth_result());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, GetAuthChattersResponse r4) {
            GetAuthChattersResponse r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            ChattersAuthResult.ADAPTER.j(r3, 1, r5.getAuth_result());
        }

        public b(FieldEncoding r7, KClass<GetAuthChattersResponse> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/contact.v2.GetAuthChattersResponse", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ GetAuthChattersResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetAuthChattersResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.contact.v2.GetAuthChattersResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.auth_result;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetAuthChattersResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final ChattersAuthResult getAuth_result() {
        return this.auth_result;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetAuthChattersResponse(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.auth_result = r2.d;
    }

    public /* synthetic */ GetAuthChattersResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
