package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.ChatOptionInfo;
import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/im/v1/MGetChatsResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/MGetChatsResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/MGetChatsResponse$Builder;Lokio/ByteString;)V", "entity", "Lcom/lark/kmp/pb/basic/v1/Entity;", "getEntity", "()Lcom/lark/kmp/pb/basic/v1/Entity;", "chat_option_info", "", "", "Lcom/lark/kmp/pb/basic/v1/ChatOptionInfo;", "getChat_option_info", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MGetChatsResponse extends Message<MGetChatsResponse, a> {
    public static final ProtoAdapter<MGetChatsResponse> ADAPTER = null;
    public static final b Companion = null;
    public static final c<MGetChatsResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Map<String, ChatOptionInfo> chat_option_info;
    private final Entity entity;

    public static final class a extends Message.a<MGetChatsResponse, a> implements d<MGetChatsResponse> {
        public Entity d;
        public Map<String, ChatOptionInfo> e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new MGetChatsResponse(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ MGetChatsResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        MGetChatsResponse$Companion$ADAPTER$1 r3 = new MGetChatsResponse$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MGetChatsResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.MGetChatsResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.entity;
        r0.e = this.chat_option_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MGetChatsResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, ChatOptionInfo> getChat_option_info() {
        return this.chat_option_info;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public MGetChatsResponse(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Entity r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.entity = r4;
        this.chat_option_info = com.lark.wire.internal.a.d("chat_option_info", r2.e);
    }

    public /* synthetic */ MGetChatsResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
