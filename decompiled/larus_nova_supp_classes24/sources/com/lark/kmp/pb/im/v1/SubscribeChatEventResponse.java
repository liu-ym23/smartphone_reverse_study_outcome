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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\f\rB\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/im/v1/SubscribeChatEventResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/SubscribeChatEventResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/SubscribeChatEventResponse$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SubscribeChatEventResponse extends Message<SubscribeChatEventResponse, a> {
    public static final ProtoAdapter<SubscribeChatEventResponse> ADAPTER = null;
    public static final c Companion = null;
    public static final we6.c<SubscribeChatEventResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class a extends Message.a<SubscribeChatEventResponse, a> implements d<SubscribeChatEventResponse> {
        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new SubscribeChatEventResponse(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<SubscribeChatEventResponse> implements we6.c<SubscribeChatEventResponse> {
        @Override // com.lark.wire.ProtoAdapter
        public final SubscribeChatEventResponse c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L7;
            r6.j(r3);
            goto L3
        L7:
            return new SubscribeChatEventResponse(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SubscribeChatEventResponse r2) {
            SubscribeChatEventResponse r3 = r2;
            Intrinsics.checkNotNullParameter(r3, "value");
            return r3.unknownFields().size();
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r2, SubscribeChatEventResponse r3) {
            SubscribeChatEventResponse r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "writer");
            Intrinsics.checkNotNullParameter(r4, "value");
            r2.a(r4.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r2, SubscribeChatEventResponse r3) {
            SubscribeChatEventResponse r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "writer");
            Intrinsics.checkNotNullParameter(r4, "value");
            r2.d(r4.unknownFields());
        }

        public b(FieldEncoding r7, KClass<SubscribeChatEventResponse> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.SubscribeChatEventResponse", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SubscribeChatEventResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SubscribeChatEventResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.SubscribeChatEventResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SubscribeChatEventResponse.class).getSimpleName() + '@' + hashCode();
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public SubscribeChatEventResponse(ByteString r2) {
        super(ADAPTER, r2);
    }

    public /* synthetic */ SubscribeChatEventResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r2);
    }
}
