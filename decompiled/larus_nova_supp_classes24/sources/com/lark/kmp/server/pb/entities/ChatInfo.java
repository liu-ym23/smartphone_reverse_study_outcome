package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/server/pb/entities/ChatInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/ChatInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/ChatInfo$Builder;Lokio/ByteString;)V", "group_type", "", "getGroup_type", "()Ljava/lang/Long;", "Ljava/lang/Long;", "p2p_bot_app_id", "getP2p_bot_app_id", "p2p_have_bot", "", "getP2p_have_bot", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatInfo extends Message<ChatInfo, a> {
    public static final ProtoAdapter<ChatInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long group_type;
    private final Long p2p_bot_app_id;
    private final Boolean p2p_have_bot;

    public static final class a extends Message.a<ChatInfo, a> {
        public Long d;
        public Long e;
        public Boolean f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new ChatInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ChatInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatInfo c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L8:
            if (r3 != 3) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L10:
            if (r3 != 4) goto L11;
            r0.f = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L11:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L16:
            return new ChatInfo(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatInfo r5) {
            ChatInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return ((r0 + r1.l(1, r6.getGroup_type())) + r1.l(3, r6.getP2p_bot_app_id())) + ProtoAdapter.g.l(4, r6.getP2p_have_bot());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ChatInfo r5) {
            ChatInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r4, 1, r6.getGroup_type());
            r0.i(r4, 3, r6.getP2p_bot_app_id());
            ProtoAdapter.g.i(r4, 4, r6.getP2p_have_bot());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ChatInfo r5) {
            ChatInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 4, r6.getP2p_have_bot());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 3, r6.getP2p_bot_app_id());
            r0.j(r4, 1, r6.getGroup_type());
        }

        public b(FieldEncoding r7, KClass<ChatInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.ChatInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.group_type;
        r0.e = this.p2p_bot_app_id;
        r0.f = this.p2p_have_bot;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatInfo.class).getSimpleName() + "@" + hashCode();
    }

    public final Long getGroup_type() {
        return this.group_type;
    }

    public final Long getP2p_bot_app_id() {
        return this.p2p_bot_app_id;
    }

    public final Boolean getP2p_have_bot() {
        return this.p2p_have_bot;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public ChatInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.group_type = r2.d;
        this.p2p_bot_app_id = r2.e;
        this.p2p_have_bot = r2.f;
    }

    public /* synthetic */ ChatInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
