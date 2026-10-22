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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/im/v1/ChatPageContext;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/ChatPageContext$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/ChatPageContext$Builder;Lokio/ByteString;)V", "target_url", "", "getTarget_url", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatPageContext extends Message<ChatPageContext, a> {
    public static final ProtoAdapter<ChatPageContext> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String target_url;

    public static final class a extends Message.a<ChatPageContext, a> {
        public String d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new ChatPageContext(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ChatPageContext> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatPageContext c(g0 r7) {
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
            return new ChatPageContext(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatPageContext r4) {
            ChatPageContext r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getTarget_url());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ChatPageContext r5) {
            ChatPageContext r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getTarget_url());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, ChatPageContext r4) {
            ChatPageContext r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            ProtoAdapter.q.j(r3, 1, r5.getTarget_url());
        }

        public b(FieldEncoding r7, KClass<ChatPageContext> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.ChatPageContext", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatPageContext(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatPageContext.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.target_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatPageContext.class).getSimpleName() + '@' + hashCode();
    }

    public final String getTarget_url() {
        return this.target_url;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public ChatPageContext(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.target_url = r2.d;
    }

    public /* synthetic */ ChatPageContext(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
