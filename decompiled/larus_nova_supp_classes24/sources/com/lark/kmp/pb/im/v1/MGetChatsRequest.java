package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.SyncDataStrategy;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001d\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/im/v1/MGetChatsRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/MGetChatsRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/MGetChatsRequest$Builder;Lokio/ByteString;)V", "chat_ids", "", "", "getChat_ids", "()Ljava/util/List;", "should_auth", "", "getShould_auth", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "strategy", "Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "getStrategy", "()Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "source", "Lcom/lark/kmp/pb/im/v1/MGetChatsRequest$Source;", "getSource", "()Lcom/lark/kmp/pb/im/v1/MGetChatsRequest$Source;", "newBuilder", "toString", "Builder", "Companion", "Source", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MGetChatsRequest extends Message<MGetChatsRequest, a> {
    public static final ProtoAdapter<MGetChatsRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_SHOULD_AUTH = false;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final we6.c<MGetChatsRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final List<String> chat_ids;
    private final Boolean should_auth;
    private final Source source;
    private final SyncDataStrategy strategy;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/im/v1/MGetChatsRequest$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT_WINDOW", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Source extends Enum<Source> implements o0 {
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source CHAT_WINDOW = null;
        public static final b Companion = null;
        public static final Source UNKNOWN = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Source> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Source.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return Source.CHAT_WINDOW;
            L9:
                return Source.UNKNOWN;
            }

            public a(KClass<Source> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("UNKNOWN", 0, 1);
            UNKNOWN = r0;
            Source r1 = new Source("CHAT_WINDOW", 1, 2);
            CHAT_WINDOW = r1;
            Source[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Source fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return CHAT_WINDOW;
        L9:
            return UNKNOWN;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<MGetChatsRequest, a> implements we6.d<MGetChatsRequest> {
        public List<String> d;
        public Boolean e;
        public SyncDataStrategy f;
        public Source g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new MGetChatsRequest(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<MGetChatsRequest> implements we6.c<MGetChatsRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final MGetChatsRequest c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L24;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L8:
            if (r5 != 2) goto L10;
            r1.e = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L10:
            if (r5 != 3) goto L12;
            r1.f = SyncDataStrategy.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L12:
            if (r5 != 4) goto L13;
            r1.g = Source.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L13:
            r11.j(r5);
            goto L3
        L24:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "chat_ids");
            com.lark.wire.internal.a.a(r2);
            r1.d = r2;
            return new MGetChatsRequest(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MGetChatsRequest r5) {
            MGetChatsRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((r6.unknownFields().size() + ProtoAdapter.q.a().l(1, r6.getChat_ids())) + ProtoAdapter.g.l(2, r6.getShould_auth())) + SyncDataStrategy.ADAPTER.l(3, r6.getStrategy())) + Source.ADAPTER.l(4, r6.getSource());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MGetChatsRequest r5) {
            MGetChatsRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.a().i(r4, 1, r6.getChat_ids());
            ProtoAdapter.g.i(r4, 2, r6.getShould_auth());
            SyncDataStrategy.ADAPTER.i(r4, 3, r6.getStrategy());
            Source.ADAPTER.i(r4, 4, r6.getSource());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MGetChatsRequest r5) {
            MGetChatsRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Source.ADAPTER.j(r4, 4, r6.getSource());
            SyncDataStrategy.ADAPTER.j(r4, 3, r6.getStrategy());
            ProtoAdapter.g.j(r4, 2, r6.getShould_auth());
            ProtoAdapter.q.a().j(r4, 1, r6.getChat_ids());
        }

        public b(FieldEncoding r7, KClass<MGetChatsRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.MGetChatsRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MGetChatsRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MGetChatsRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.MGetChatsRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_ids;
        r0.e = this.should_auth;
        r0.f = this.strategy;
        r0.g = this.source;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MGetChatsRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getChat_ids() {
        return this.chat_ids;
    }

    public final Boolean getShould_auth() {
        return this.should_auth;
    }

    public final Source getSource() {
        return this.source;
    }

    public final SyncDataStrategy getStrategy() {
        return this.strategy;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public MGetChatsRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chat_ids = com.lark.wire.internal.a.c("chat_ids", r2.d);
        this.should_auth = r2.e;
        this.strategy = r2.f;
        this.source = r2.g;
    }

    public /* synthetic */ MGetChatsRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
