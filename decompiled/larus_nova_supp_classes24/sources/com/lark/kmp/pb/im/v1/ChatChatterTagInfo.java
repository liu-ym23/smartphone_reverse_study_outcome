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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$Builder;Lokio/ByteString;)V", "tags", "", "Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo;", "getTags", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "TagInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatChatterTagInfo extends Message<ChatChatterTagInfo, a> {
    public static final ProtoAdapter<ChatChatterTagInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<TagInfo> tags;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo$Builder;Lokio/ByteString;)V", "tag_type", "Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo$TagType;", "getTag_type", "()Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo$TagType;", "description", "", "getDescription", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "TagType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TagInfo extends Message<TagInfo, a> {
        public static final ProtoAdapter<TagInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String description;
        private final TagType tag_type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/im/v1/ChatChatterTagInfo$TagInfo$TagType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CLASS_TEACHER", "DISCIPLINE_TEACHER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum TagType extends Enum<TagType> implements o0 {
            public static final ProtoAdapter<TagType> ADAPTER = null;
            public static final TagType CLASS_TEACHER = null;
            public static final b Companion = null;
            public static final TagType DISCIPLINE_TEACHER = null;
            public static final TagType UNKNOWN = null;
            public static final /* synthetic */ TagType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<TagType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    TagType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return TagType.DISCIPLINE_TEACHER;
                L15:
                    return TagType.CLASS_TEACHER;
                L12:
                    return TagType.UNKNOWN;
                }

                public a(KClass<TagType> r1, Syntax r2, TagType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<TagType> getEntries() {
                return b;
            }

            static {
                TagType r0 = new TagType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                TagType r1 = new TagType("CLASS_TEACHER", 1, 1);
                CLASS_TEACHER = r1;
                TagType r3 = new TagType("DISCIPLINE_TEACHER", 2, 2);
                DISCIPLINE_TEACHER = r3;
                TagType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(TagType.class), Syntax.PROTO_2, r0);
            }

            public static TagType[] values() {
                return (TagType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final TagType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return DISCIPLINE_TEACHER;
            L15:
                return CLASS_TEACHER;
            L12:
                return UNKNOWN;
            }

            public static TagType valueOf(String r1) {
                return (TagType) r27.a.a(TagType.class, r1);
            }

            public TagType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends Message.a<TagInfo, a> {
            public TagType d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new TagInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TagInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final TagInfo c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                r1.d = TagType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L9:
                r10.j(r4);
                goto L3
            L16:
                return new TagInfo(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TagInfo r5) {
                TagInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + TagType.ADAPTER.l(1, r6.getTag_type())) + ProtoAdapter.q.l(2, r6.getDescription());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TagInfo r5) {
                TagInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                TagType.ADAPTER.i(r4, 1, r6.getTag_type());
                ProtoAdapter.q.i(r4, 2, r6.getDescription());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TagInfo r5) {
                TagInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getDescription());
                TagType.ADAPTER.j(r4, 1, r6.getTag_type());
            }

            public b(FieldEncoding r7, KClass<TagInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/im.v1.ChatChatterTagInfo.TagInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TagInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.tag_type;
            r0.e = this.description;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TagInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getDescription() {
            return this.description;
        }

        public final TagType getTag_type() {
            return this.tag_type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public TagInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.tag_type = r2.d;
            this.description = r2.e;
        }

        public /* synthetic */ TagInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<ChatChatterTagInfo, a> {
        public List<TagInfo> d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new ChatChatterTagInfo(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<ChatChatterTagInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatChatterTagInfo c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L9;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            r1.add(TagInfo.ADAPTER.c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "tags");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new ChatChatterTagInfo(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatChatterTagInfo r4) {
            ChatChatterTagInfo r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + TagInfo.ADAPTER.a().l(1, r5.getTags());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ChatChatterTagInfo r5) {
            ChatChatterTagInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            TagInfo.ADAPTER.a().i(r4, 1, r6.getTags());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, ChatChatterTagInfo r4) {
            ChatChatterTagInfo r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            TagInfo.ADAPTER.a().j(r3, 1, r5.getTags());
        }

        public b(FieldEncoding r7, KClass<ChatChatterTagInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.ChatChatterTagInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatChatterTagInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatChatterTagInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.tags;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatChatterTagInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final List<TagInfo> getTags() {
        return this.tags;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public ChatChatterTagInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.tags = com.lark.wire.internal.a.c("tags", r2.d);
    }

    public /* synthetic */ ChatChatterTagInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
