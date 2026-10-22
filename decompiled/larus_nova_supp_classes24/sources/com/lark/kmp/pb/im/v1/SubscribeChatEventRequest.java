package com.lark.kmp.pb.im.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/im/v1/SubscribeChatEventRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/SubscribeChatEventRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/SubscribeChatEventRequest$Builder;Lokio/ByteString;)V", "subscribe_chat_ids", "", "", "getSubscribe_chat_ids", "()Ljava/util/List;", "unsubscribe_chat_ids", "getUnsubscribe_chat_ids", "subscription_key", "Lcom/lark/kmp/pb/im/v1/SubscribeChatEventRequest$SubscriptionKey;", "getSubscription_key", "()Lcom/lark/kmp/pb/im/v1/SubscribeChatEventRequest$SubscriptionKey;", "subscription_keys", "getSubscription_keys", "newBuilder", "toString", "Builder", "Companion", "SubscriptionKey", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SubscribeChatEventRequest extends Message<SubscribeChatEventRequest, a> {
    public static final ProtoAdapter<SubscribeChatEventRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final SubscriptionKey DEFAULT_SUBSCRIPTION_KEY = null;
    public static final we6.c<SubscribeChatEventRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final List<String> subscribe_chat_ids;
    private final SubscriptionKey subscription_key;
    private final List<SubscriptionKey> subscription_keys;
    private final List<String> unsubscribe_chat_ids;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/im/v1/SubscribeChatEventRequest$SubscriptionKey;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OTHER", "IMAGE_VIEWER", "SEARCH_WITH_MY_AI", "DOUBAO_TYPING", "DOUBAO_SMART_REPLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SubscriptionKey extends Enum<SubscriptionKey> implements o0 {
        public static final ProtoAdapter<SubscriptionKey> ADAPTER = null;
        public static final b Companion = null;
        public static final SubscriptionKey DOUBAO_SMART_REPLY = null;
        public static final SubscriptionKey DOUBAO_TYPING = null;
        public static final SubscriptionKey IMAGE_VIEWER = null;
        public static final SubscriptionKey OTHER = null;
        public static final SubscriptionKey SEARCH_WITH_MY_AI = null;
        public static final /* synthetic */ SubscriptionKey[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SubscriptionKey> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SubscriptionKey.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<SubscriptionKey> r1, Syntax r2, SubscriptionKey r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static SubscriptionKey a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return SubscriptionKey.DOUBAO_SMART_REPLY;
            L20:
                return SubscriptionKey.DOUBAO_TYPING;
            L21:
                return SubscriptionKey.SEARCH_WITH_MY_AI;
            L22:
                return SubscriptionKey.IMAGE_VIEWER;
            L17:
                return SubscriptionKey.OTHER;
            }
        }

        @JvmStatic
        public static final SubscriptionKey fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<SubscriptionKey> getEntries() {
            return b;
        }

        static {
            SubscriptionKey r0 = new SubscriptionKey("OTHER", 0, 0);
            OTHER = r0;
            SubscriptionKey r1 = new SubscriptionKey("IMAGE_VIEWER", 1, 1);
            IMAGE_VIEWER = r1;
            SubscriptionKey r3 = new SubscriptionKey("SEARCH_WITH_MY_AI", 2, 2);
            SEARCH_WITH_MY_AI = r3;
            SubscriptionKey r5 = new SubscriptionKey("DOUBAO_TYPING", 3, 3);
            DOUBAO_TYPING = r5;
            SubscriptionKey r7 = new SubscriptionKey("DOUBAO_SMART_REPLY", 4, 4);
            DOUBAO_SMART_REPLY = r7;
            SubscriptionKey[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SubscriptionKey.class), Syntax.PROTO_2, r0);
        }

        public static SubscriptionKey[] values() {
            return (SubscriptionKey[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static SubscriptionKey valueOf(String r1) {
            return (SubscriptionKey) r27.a.a(SubscriptionKey.class, r1);
        }

        public SubscriptionKey(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<SubscribeChatEventRequest, a> implements we6.d<SubscribeChatEventRequest> {
        public List<String> d;
        public List<String> e;
        public SubscriptionKey f;
        public List<? extends SubscriptionKey> g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new SubscribeChatEventRequest(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
            this.e = CollectionsKt.emptyList();
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<SubscribeChatEventRequest> implements we6.c<SubscribeChatEventRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final SubscribeChatEventRequest c(g0 r13) {
            Intrinsics.checkNotNullParameter(r13, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            ArrayList r4 = new ArrayList();
            long r5 = r13.c();
        L3:
            int r7 = r13.e();
            if (r7 == (-1)) goto L24;
            if (r7 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r2.add(r13.i());
            goto L3
        L8:
            if (r7 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r3.add(r13.i());
            goto L3
        L10:
            if (r7 != 3) goto L12;
            r1.f = SubscriptionKey.ADAPTER.c(r13);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r13.a(r7, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L12:
            if (r7 != 4) goto L13;
            SubscriptionKey.ADAPTER.m(r13, r4);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r13.a(r7, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r13.j(r7);
            goto L3
        L24:
            ByteString r14 = r13.d(r5);
            Intrinsics.checkNotNullParameter(r2, "subscribe_chat_ids");
            com.lark.wire.internal.a.a(r2);
            r1.d = r2;
            Intrinsics.checkNotNullParameter(r3, "unsubscribe_chat_ids");
            com.lark.wire.internal.a.a(r3);
            r1.e = r3;
            Intrinsics.checkNotNullParameter(r4, "subscription_keys");
            com.lark.wire.internal.a.a(r4);
            r1.g = r4;
            return new SubscribeChatEventRequest(r1, r14, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SubscribeChatEventRequest r6) {
            SubscribeChatEventRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.a().l(1, r7.getSubscribe_chat_ids())) + r1.a().l(2, r7.getUnsubscribe_chat_ids());
            ProtoAdapter<SubscriptionKey> r3 = SubscriptionKey.ADAPTER;
            return (r2 + r3.l(3, r7.getSubscription_key())) + r3.a().l(4, r7.getSubscription_keys());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, SubscribeChatEventRequest r6) {
            SubscribeChatEventRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.a().i(r5, 1, r7.getSubscribe_chat_ids());
            r0.a().i(r5, 2, r7.getUnsubscribe_chat_ids());
            ProtoAdapter<SubscriptionKey> r1 = SubscriptionKey.ADAPTER;
            r1.i(r5, 3, r7.getSubscription_key());
            r1.a().i(r5, 4, r7.getSubscription_keys());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, SubscribeChatEventRequest r6) {
            SubscribeChatEventRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter<SubscriptionKey> r0 = SubscriptionKey.ADAPTER;
            r0.a().j(r5, 4, r7.getSubscription_keys());
            r0.j(r5, 3, r7.getSubscription_key());
            w r1 = ProtoAdapter.q;
            r1.a().j(r5, 2, r7.getUnsubscribe_chat_ids());
            r1.a().j(r5, 1, r7.getSubscribe_chat_ids());
        }

        public b(FieldEncoding r7, KClass<SubscribeChatEventRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.SubscribeChatEventRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SubscribeChatEventRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SUBSCRIPTION_KEY = SubscriptionKey.OTHER;
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SubscribeChatEventRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.SubscribeChatEventRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.subscribe_chat_ids;
        r0.e = this.unsubscribe_chat_ids;
        r0.f = this.subscription_key;
        r0.g = this.subscription_keys;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SubscribeChatEventRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getSubscribe_chat_ids() {
        return this.subscribe_chat_ids;
    }

    public final SubscriptionKey getSubscription_key() {
        return this.subscription_key;
    }

    public final List<SubscriptionKey> getSubscription_keys() {
        return this.subscription_keys;
    }

    public final List<String> getUnsubscribe_chat_ids() {
        return this.unsubscribe_chat_ids;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public SubscribeChatEventRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.subscribe_chat_ids = com.lark.wire.internal.a.c("subscribe_chat_ids", r2.d);
        this.unsubscribe_chat_ids = com.lark.wire.internal.a.c("unsubscribe_chat_ids", r2.e);
        this.subscription_key = r2.f;
        this.subscription_keys = com.lark.wire.internal.a.c("subscription_keys", r2.g);
    }

    public /* synthetic */ SubscribeChatEventRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
