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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatQRCodeTokenResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/GetChatQRCodeTokenResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/GetChatQRCodeTokenResponse$Builder;Lokio/ByteString;)V", "token", "", "getToken", "()Ljava/lang/String;", "url", "getUrl", "expire_time", "", "getExpire_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "is_unlimited", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetChatQRCodeTokenResponse extends Message<GetChatQRCodeTokenResponse, a> {
    public static final ProtoAdapter<GetChatQRCodeTokenResponse> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_IS_UNLIMITED = false;
    public static final we6.c<GetChatQRCodeTokenResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Long expire_time;
    private final Boolean is_unlimited;
    private final String token;
    private final String url;

    public static final class a extends Message.a<GetChatQRCodeTokenResponse, a> implements d<GetChatQRCodeTokenResponse> {
        public String d;
        public String e;
        public Long f;
        public Boolean g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetChatQRCodeTokenResponse(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<GetChatQRCodeTokenResponse> implements we6.c<GetChatQRCodeTokenResponse> {
        @Override // com.lark.wire.ProtoAdapter
        public final GetChatQRCodeTokenResponse c(g0 r7) {
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
            r1.f = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new GetChatQRCodeTokenResponse(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(GetChatQRCodeTokenResponse r5) {
            GetChatQRCodeTokenResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((r0 + r1.l(1, r6.getToken())) + r1.l(2, r6.getUrl())) + ProtoAdapter.k.l(3, r6.getExpire_time())) + ProtoAdapter.g.l(4, r6.is_unlimited());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, GetChatQRCodeTokenResponse r5) {
            GetChatQRCodeTokenResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getToken());
            r0.i(r4, 2, r6.getUrl());
            ProtoAdapter.k.i(r4, 3, r6.getExpire_time());
            ProtoAdapter.g.i(r4, 4, r6.is_unlimited());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, GetChatQRCodeTokenResponse r5) {
            GetChatQRCodeTokenResponse r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 4, r6.is_unlimited());
            ProtoAdapter.k.j(r4, 3, r6.getExpire_time());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getUrl());
            r0.j(r4, 1, r6.getToken());
        }

        public b(FieldEncoding r7, KClass<GetChatQRCodeTokenResponse> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.GetChatQRCodeTokenResponse", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ GetChatQRCodeTokenResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetChatQRCodeTokenResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.GetChatQRCodeTokenResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.token;
        r0.e = this.url;
        r0.f = this.expire_time;
        r0.g = this.is_unlimited;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetChatQRCodeTokenResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getExpire_time() {
        return this.expire_time;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean is_unlimited() {
        return this.is_unlimited;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetChatQRCodeTokenResponse(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.token = r2.d;
        this.url = r2.e;
        this.expire_time = r2.f;
        this.is_unlimited = r2.g;
    }

    public /* synthetic */ GetChatQRCodeTokenResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
