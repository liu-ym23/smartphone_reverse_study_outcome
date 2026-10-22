package com.lark.kmp.pb.contact.v2;

import com.lark.kmp.pb.basic.v1.ActionType;
import com.lark.kmp.pb.basic.v1.SyncDataStrategy;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/contact/v2/GetAuthChattersRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/contact/v2/GetAuthChattersRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/contact/v2/GetAuthChattersRequest$Builder;Lokio/ByteString;)V", "action_type", "Lcom/lark/kmp/pb/basic/v1/ActionType;", "getAction_type", "()Lcom/lark/kmp/pb/basic/v1/ActionType;", "chatters_auth_info", "", "", "getChatters_auth_info", "()Ljava/util/Map;", "sync_data_strategy", "Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "getSync_data_strategy", "()Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetAuthChattersRequest extends Message<GetAuthChattersRequest, a> {
    public static final ProtoAdapter<GetAuthChattersRequest> ADAPTER = null;
    public static final b Companion = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final c<GetAuthChattersRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final ActionType action_type;
    private final Map<String, String> chatters_auth_info;
    private final SyncDataStrategy sync_data_strategy;

    public static final class a extends Message.a<GetAuthChattersRequest, a> implements d<GetAuthChattersRequest> {
        public ActionType d;
        public Map<String, String> e;
        public SyncDataStrategy f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetAuthChattersRequest(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ GetAuthChattersRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
        GetAuthChattersRequest$Companion$ADAPTER$1 r3 = new GetAuthChattersRequest$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetAuthChattersRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.contact.v2.GetAuthChattersRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.action_type;
        r0.e = this.chatters_auth_info;
        r0.f = this.sync_data_strategy;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetAuthChattersRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final ActionType getAction_type() {
        return this.action_type;
    }

    public final Map<String, String> getChatters_auth_info() {
        return this.chatters_auth_info;
    }

    public final SyncDataStrategy getSync_data_strategy() {
        return this.sync_data_strategy;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetAuthChattersRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        ActionType r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.action_type = r4;
        this.chatters_auth_info = com.lark.wire.internal.a.d("chatters_auth_info", r2.e);
        this.sync_data_strategy = r2.f;
    }

    public /* synthetic */ GetAuthChattersRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
