package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003456B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u00102\u001a\u00020\u0002H\u0016J\b\u00103\u001a\u00020\u000bH\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010$\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000eR\u001d\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020,0\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000eR \u0010.\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b/\u00100\u001a\u0004\b1\u0010\u001d¨\u00067"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse$Builder;Lokio/ByteString;)V", "ordered_weight", "", "", "", "getOrdered_weight", "()Ljava/util/Map;", "entity", "Lcom/lark/kmp/pb/basic/v1/Entity;", "getEntity", "()Lcom/lark/kmp/pb/basic/v1/Entity;", "letter_maps", "", "Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse$LetterMap;", "getLetter_maps", "()Ljava/util/List;", "nicknames", "getNicknames", "show_search", "", "getShow_search", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "member_count", "", "getMember_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "cursor", "getCursor", "()Ljava/lang/String;", "chatter_ids", "getChatter_ids", "chatter_id2department_name", "getChatter_id2department_name", "tag_infos", "Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo;", "getTag_infos", "need_display_department", "getNeed_display_department$annotations", "()V", "getNeed_display_department", "newBuilder", "toString", "Builder", "Companion", "LetterMap", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetChatChattersResponse extends Message<GetChatChattersResponse, a> {
    public static final ProtoAdapter<GetChatChattersResponse> ADAPTER = null;
    public static final b Companion = null;
    public static final c<GetChatChattersResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Map<String, String> chatter_id2department_name;
    private final List<String> chatter_ids;
    private final String cursor;
    private final Entity entity;
    private final List<LetterMap> letter_maps;
    private final Integer member_count;
    private final Boolean need_display_department;
    private final Map<String, String> nicknames;
    private final Map<String, Long> ordered_weight;
    private final Boolean show_search;
    private final Map<String, ChatChatterTagInfo> tag_infos;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse$LetterMap;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse$LetterMap$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/GetChatChattersResponse$LetterMap$Builder;Lokio/ByteString;)V", "letter", "", "getLetter", "()Ljava/lang/String;", "chatter_ids", "", "getChatter_ids", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LetterMap extends Message<LetterMap, a> {
        public static final ProtoAdapter<LetterMap> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> chatter_ids;
        private final String letter;

        public static final class a extends Message.a<LetterMap, a> {
            public String d;
            public List<String> e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new LetterMap(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<LetterMap> {
            @Override // com.lark.wire.ProtoAdapter
            public final LetterMap c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L12;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                String r6 = r8.i();
                Intrinsics.checkNotNullParameter(r6, "letter");
                r1.d = r6;
                goto L3
            L8:
                if (r5 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L9:
                r8.j(r5);
                goto L3
            L12:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "chatter_ids");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new LetterMap(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LetterMap r5) {
                LetterMap r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getLetter())) + r1.a().l(2, r6.getChatter_ids());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LetterMap r5) {
                LetterMap r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getLetter());
                r0.a().i(r4, 2, r6.getChatter_ids());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, LetterMap r6) {
                LetterMap r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.a().j(r5, 2, r7.getChatter_ids());
                r0.j(r5, 1, r7.getLetter());
            }

            public b(FieldEncoding r7, KClass<LetterMap> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/im.v1.GetChatChattersResponse.LetterMap", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LetterMap(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LetterMap.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.letter;
            r0.e = this.chatter_ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LetterMap.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getChatter_ids() {
            return this.chatter_ids;
        }

        public final String getLetter() {
            return this.letter;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public LetterMap(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.letter = r4;
            this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.e);
        }

        public /* synthetic */ LetterMap(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<GetChatChattersResponse, a> implements d<GetChatChattersResponse> {
        public Map<String, Long> d;
        public Entity e;
        public List<LetterMap> f;
        public Map<String, String> g;
        public Boolean h;
        public Integer i;
        public String j;
        public List<String> k;
        public Map<String, String> l;
        public Map<String, ChatChatterTagInfo> m;
        public Boolean n;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetChatChattersResponse(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
            this.f = CollectionsKt.emptyList();
            this.g = MapsKt.emptyMap();
            this.k = CollectionsKt.emptyList();
            this.l = MapsKt.emptyMap();
            this.m = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ GetChatChattersResponse(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "need_display_department is deprecated")
    public static /* synthetic */ void getNeed_display_department$annotations() {
    }

    static {
        Companion = new b();
        GetChatChattersResponse$Companion$ADAPTER$1 r3 = new GetChatChattersResponse$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetChatChattersResponse.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.GetChatChattersResponse>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.ordered_weight;
        r0.e = this.entity;
        r0.f = this.letter_maps;
        r0.g = this.nicknames;
        r0.h = this.show_search;
        r0.i = this.member_count;
        r0.j = this.cursor;
        r0.k = this.chatter_ids;
        r0.l = this.chatter_id2department_name;
        r0.m = this.tag_infos;
        r0.n = this.need_display_department;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetChatChattersResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, String> getChatter_id2department_name() {
        return this.chatter_id2department_name;
    }

    public final List<String> getChatter_ids() {
        return this.chatter_ids;
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final List<LetterMap> getLetter_maps() {
        return this.letter_maps;
    }

    public final Integer getMember_count() {
        return this.member_count;
    }

    public final Boolean getNeed_display_department() {
        return this.need_display_department;
    }

    public final Map<String, String> getNicknames() {
        return this.nicknames;
    }

    public final Map<String, Long> getOrdered_weight() {
        return this.ordered_weight;
    }

    public final Boolean getShow_search() {
        return this.show_search;
    }

    public final Map<String, ChatChatterTagInfo> getTag_infos() {
        return this.tag_infos;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetChatChattersResponse(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.ordered_weight = com.lark.wire.internal.a.d("ordered_weight", r2.d);
        Entity r4 = r2.e;
        Intrinsics.checkNotNull(r4);
        this.entity = r4;
        this.letter_maps = com.lark.wire.internal.a.c("letter_maps", r2.f);
        this.nicknames = com.lark.wire.internal.a.d("nicknames", r2.g);
        this.show_search = r2.h;
        this.member_count = r2.i;
        this.cursor = r2.j;
        this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.k);
        this.chatter_id2department_name = com.lark.wire.internal.a.d("chatter_id2department_name", r2.l);
        this.tag_infos = com.lark.wire.internal.a.d("tag_infos", r2.m);
        this.need_display_department = r2.n;
    }

    public /* synthetic */ GetChatChattersResponse(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
