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
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatQRCodeTokenRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/GetChatQRCodeTokenRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/GetChatQRCodeTokenRequest$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "expired_day", "", "getExpired_day", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_unlimited", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetChatQRCodeTokenRequest extends Message<GetChatQRCodeTokenRequest, a> {
    public static final ProtoAdapter<GetChatQRCodeTokenRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final int DEFAULT_EXPIRED_DAY = 7;
    public static final boolean DEFAULT_IS_UNLIMITED = false;
    public static final we6.c<GetChatQRCodeTokenRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;
    private final Integer expired_day;
    private final Boolean is_unlimited;

    public static final class a extends Message.a<GetChatQRCodeTokenRequest, a> implements d<GetChatQRCodeTokenRequest> {
        public String d;
        public Integer e;
        public Boolean f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetChatQRCodeTokenRequest(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<GetChatQRCodeTokenRequest> implements we6.c<GetChatQRCodeTokenRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final GetChatQRCodeTokenRequest c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "chat_id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.f = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L11:
            r7.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L16:
            return new GetChatQRCodeTokenRequest(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(GetChatQRCodeTokenRequest r5) {
            GetChatQRCodeTokenRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getChat_id())) + ProtoAdapter.h.l(2, r6.getExpired_day())) + ProtoAdapter.g.l(3, r6.is_unlimited());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, GetChatQRCodeTokenRequest r5) {
            GetChatQRCodeTokenRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getChat_id());
            ProtoAdapter.h.i(r4, 2, r6.getExpired_day());
            ProtoAdapter.g.i(r4, 3, r6.is_unlimited());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, GetChatQRCodeTokenRequest r5) {
            GetChatQRCodeTokenRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 3, r6.is_unlimited());
            ProtoAdapter.h.j(r4, 2, r6.getExpired_day());
            ProtoAdapter.q.j(r4, 1, r6.getChat_id());
        }

        public b(FieldEncoding r7, KClass<GetChatQRCodeTokenRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.GetChatQRCodeTokenRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ GetChatQRCodeTokenRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetChatQRCodeTokenRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.GetChatQRCodeTokenRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.e = this.expired_day;
        r0.f = this.is_unlimited;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetChatQRCodeTokenRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final Integer getExpired_day() {
        return this.expired_day;
    }

    public final Boolean is_unlimited() {
        return this.is_unlimited;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetChatQRCodeTokenRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.chat_id = r4;
        this.expired_day = r2.e;
        this.is_unlimited = r2.f;
    }

    public /* synthetic */ GetChatQRCodeTokenRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
