package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.PickEntities;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004-./0B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Type;", "getType", "()Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Type;", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "chatter_ids", "", "getChatter_ids", "()Ljava/util/List;", "pick_entities", "Lcom/lark/kmp/pb/basic/v1/PickEntities;", "getPick_entities", "join_token", "getJoin_token", "message_id", "getMessage_id", "inviter_id", "getInviter_id", "source", "Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Source;", "getSource", "()Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Source;", "team_id", "", "getTeam_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "from_page", "Lcom/lark/kmp/pb/im/v1/ChatPageContext;", "getFrom_page", "()Lcom/lark/kmp/pb/im/v1/ChatPageContext;", "newBuilder", "toString", "Builder", "Companion", "Type", "Source", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AddChatChattersRequest extends Message<AddChatChattersRequest, a> {
    public static final ProtoAdapter<AddChatChattersRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_JOIN_TOKEN = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Type DEFAULT_TYPE = null;
    public static final we6.c<AddChatChattersRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;
    private final List<String> chatter_ids;
    private final ChatPageContext from_page;
    private final String inviter_id;
    private final String join_token;
    private final String message_id;
    private final List<PickEntities> pick_entities;
    private final Source source;
    private final Long team_id;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "ChatTemplate", "ChatLinkedPage", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Source extends Enum<Source> implements o0 {
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source ChatLinkedPage = null;
        public static final Source ChatTemplate = null;
        public static final b Companion = null;
        public static final Source Unknown = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Source> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Source.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 10) goto L15;
                if (r2 == 11) goto L14;
                return null;
            L14:
                return Source.ChatLinkedPage;
            L15:
                return Source.ChatTemplate;
            L12:
                return Source.Unknown;
            }

            public a(KClass<Source> r1, Syntax r2, Source r3) {
                super(r1, r2, r3);
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
            Source r0 = new Source("Unknown", 0, 0);
            Unknown = r0;
            Source r1 = new Source("ChatTemplate", 1, 10);
            ChatTemplate = r1;
            Source r3 = new Source("ChatLinkedPage", 2, 11);
            ChatLinkedPage = r3;
            Source[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2, r0);
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
            if (r1 == 0) goto L12;
            if (r1 == 10) goto L15;
            if (r1 == 11) goto L14;
            return null;
        L14:
            return ChatLinkedPage;
        L15:
            return ChatTemplate;
        L12:
            return Unknown;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/im/v1/AddChatChattersRequest$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVITATION", "SHARE", "QRCODE", "MENTION_INVITATION", "OPEN_CHAT", "LINKED_PAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type INVITATION = null;
        public static final Type LINKED_PAGE = null;
        public static final Type MENTION_INVITATION = null;
        public static final Type OPEN_CHAT = null;
        public static final Type QRCODE = null;
        public static final Type SHARE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 1: goto L10;
                    case 2: goto L16;
                    case 3: goto L15;
                    case 4: goto L14;
                    case 5: goto L13;
                    case 6: goto L12;
                    default: goto L3;
                };
            L3:
                return null;
            L12:
                return Type.LINKED_PAGE;
            L13:
                return Type.OPEN_CHAT;
            L14:
                return Type.MENTION_INVITATION;
            L15:
                return Type.QRCODE;
            L16:
                return Type.SHARE;
            L10:
                return Type.INVITATION;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("INVITATION", 0, 1);
            INVITATION = r0;
            Type r1 = new Type("SHARE", 1, 2);
            SHARE = r1;
            Type r4 = new Type("QRCODE", 2, 3);
            QRCODE = r4;
            Type r6 = new Type("MENTION_INVITATION", 3, 4);
            MENTION_INVITATION = r6;
            Type r8 = new Type("OPEN_CHAT", 4, 5);
            OPEN_CHAT = r8;
            Type r10 = new Type("LINKED_PAGE", 5, 6);
            LINKED_PAGE = r10;
            Type[] r12 = {r0, r1, r4, r6, r8, r10};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<AddChatChattersRequest, a> implements we6.d<AddChatChattersRequest> {
        public Type d;
        public String e;
        public List<String> f;
        public List<PickEntities> g;
        public String h;
        public String i;
        public String j;
        public Source k;
        public Long l;
        public ChatPageContext m;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new AddChatChattersRequest(this, c(), null);
        }

        public a() {
            this.f = CollectionsKt.emptyList();
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<AddChatChattersRequest> implements we6.c<AddChatChattersRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final AddChatChattersRequest c(g0 r12) {
            Intrinsics.checkNotNullParameter(r12, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r12.c();
        L3:
            int r6 = r12.e();
            if (r6 == (-1)) goto L23;
            switch(r6) {
                case 1: goto L27;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L6;
                case 9: goto L25;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L25:
            r1.k = Source.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L27:
            r1.d = Type.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L7:
            r1.m = ChatPageContext.ADAPTER.c(r12);
            goto L3
        L8:
            r1.l = (Long) ProtoAdapter.k.c(r12);
            goto L3
        L13:
            r3.add(PickEntities.ADAPTER.c(r12));
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.j = r12.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.i = r12.i();
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.h = r12.i();
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r2.add(r12.i());
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.e = r12.i();
            goto L3
        L6:
            r12.j(r6);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L23:
            ByteString r13 = r12.d(r4);
            Intrinsics.checkNotNullParameter(r2, "chatter_ids");
            com.lark.wire.internal.a.a(r2);
            r1.f = r2;
            Intrinsics.checkNotNullParameter(r3, "pick_entities");
            com.lark.wire.internal.a.a(r3);
            r1.g = r3;
            return new AddChatChattersRequest(r1, r13, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AddChatChattersRequest r6) {
            AddChatChattersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + Type.ADAPTER.l(1, r7.getType());
            w r1 = ProtoAdapter.q;
            return ((((((((r0 + r1.l(2, r7.getChat_id())) + r1.a().l(3, r7.getChatter_ids())) + PickEntities.ADAPTER.a().l(7, r7.getPick_entities())) + r1.l(4, r7.getJoin_token())) + r1.l(5, r7.getMessage_id())) + r1.l(6, r7.getInviter_id())) + Source.ADAPTER.l(9, r7.getSource())) + ProtoAdapter.k.l(10, r7.getTeam_id())) + ChatPageContext.ADAPTER.l(11, r7.getFrom_page());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, AddChatChattersRequest r6) {
            AddChatChattersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            Type.ADAPTER.i(r5, 1, r7.getType());
            w r0 = ProtoAdapter.q;
            r0.i(r5, 2, r7.getChat_id());
            r0.a().i(r5, 3, r7.getChatter_ids());
            PickEntities.ADAPTER.a().i(r5, 7, r7.getPick_entities());
            r0.i(r5, 4, r7.getJoin_token());
            r0.i(r5, 5, r7.getMessage_id());
            r0.i(r5, 6, r7.getInviter_id());
            Source.ADAPTER.i(r5, 9, r7.getSource());
            ProtoAdapter.k.i(r5, 10, r7.getTeam_id());
            ChatPageContext.ADAPTER.i(r5, 11, r7.getFrom_page());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, AddChatChattersRequest r6) {
            AddChatChattersRequest r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ChatPageContext.ADAPTER.j(r5, 11, r7.getFrom_page());
            ProtoAdapter.k.j(r5, 10, r7.getTeam_id());
            Source.ADAPTER.j(r5, 9, r7.getSource());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 6, r7.getInviter_id());
            r0.j(r5, 5, r7.getMessage_id());
            r0.j(r5, 4, r7.getJoin_token());
            PickEntities.ADAPTER.a().j(r5, 7, r7.getPick_entities());
            r0.a().j(r5, 3, r7.getChatter_ids());
            r0.j(r5, 2, r7.getChat_id());
            Type.ADAPTER.j(r5, 1, r7.getType());
        }

        public b(FieldEncoding r7, KClass<AddChatChattersRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.AddChatChattersRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AddChatChattersRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = Type.INVITATION;
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AddChatChattersRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.AddChatChattersRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.chat_id;
        r0.f = this.chatter_ids;
        r0.g = this.pick_entities;
        r0.h = this.join_token;
        r0.i = this.message_id;
        r0.j = this.inviter_id;
        r0.k = this.source;
        r0.l = this.team_id;
        r0.m = this.from_page;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AddChatChattersRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final List<String> getChatter_ids() {
        return this.chatter_ids;
    }

    public final ChatPageContext getFrom_page() {
        return this.from_page;
    }

    public final String getInviter_id() {
        return this.inviter_id;
    }

    public final String getJoin_token() {
        return this.join_token;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final List<PickEntities> getPick_entities() {
        return this.pick_entities;
    }

    public final Source getSource() {
        return this.source;
    }

    public final Long getTeam_id() {
        return this.team_id;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public AddChatChattersRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.type = r2.d;
        this.chat_id = r2.e;
        this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.f);
        this.pick_entities = com.lark.wire.internal.a.c("pick_entities", r2.g);
        this.join_token = r2.h;
        this.message_id = r2.i;
        this.inviter_id = r2.j;
        this.source = r2.k;
        this.team_id = r2.l;
        this.from_page = r2.m;
    }

    public /* synthetic */ AddChatChattersRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
