package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000489:;B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u00020\u0002H\u0016J\b\u00107\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001e\u0010\u0013R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b \u0010\u0013R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010)\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0019R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000bR\u0013\u00104\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000b¨\u0006<"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedCard;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/FeedCard$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/FeedCard$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/server/pb/entities/FeedCard$Type;", "getType", "()Lcom/lark/kmp/server/pb/entities/FeedCard$Type;", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "update_time_ms", "getUpdate_time_ms", "is_delayed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "parent_card_id", "getParent_card_id", "rank_time", "getRank_time", "rank_time_ms", "getRank_time_ms", "feed_type", "Lcom/lark/kmp/server/pb/entities/FeedType;", "getFeed_type", "()Lcom/lark/kmp/server/pb/entities/FeedType;", "status", "Lcom/lark/kmp/server/pb/entities/FeedCard$Status;", "getStatus", "()Lcom/lark/kmp/server/pb/entities/FeedCard$Status;", "is_hide", "last_unread_time", "Lcom/lark/kmp/server/pb/entities/FeedLastUnreadTime;", "getLast_unread_time", "()Lcom/lark/kmp/server/pb/entities/FeedLastUnreadTime;", "feed_card_field", "Lcom/lark/kmp/server/pb/entities/FeedCardField;", "getFeed_card_field", "()Lcom/lark/kmp/server/pb/entities/FeedCardField;", "biz_id", "getBiz_id", "impr_id", "getImpr_id", "newBuilder", "toString", "Builder", "Companion", "Type", "Status", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedCard extends Message<FeedCard, a> {
    public static final ProtoAdapter<FeedCard> ADAPTER = null;
    public static final c Companion = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    private final String biz_id;
    private final FeedCardField feed_card_field;
    private final FeedType feed_type;
    private final String id;
    private final String impr_id;
    private final Boolean is_delayed;
    private final Boolean is_hide;
    private final FeedLastUnreadTime last_unread_time;
    private final Long parent_card_id;
    private final Long rank_time;
    private final Long rank_time_ms;
    private final Status status;
    private final Type type;
    private final Long update_time;
    private final Long update_time_ms;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedCard$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", "NORMAL", "PENDING_DELETE", "DELETED", "COOLING_OFF", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status COOLING_OFF = null;
        public static final b Companion = null;
        public static final Status DELETED = null;
        public static final Status NORMAL = null;
        public static final Status PENDING_DELETE = null;
        public static final Status UNKNOWN_STATUS = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Status> r1, Syntax r2, Status r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Status a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Status.COOLING_OFF;
            L20:
                return Status.DELETED;
            L21:
                return Status.PENDING_DELETE;
            L22:
                return Status.NORMAL;
            L17:
                return Status.UNKNOWN_STATUS;
            }
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r0;
            Status r1 = new Status("NORMAL", 1, 1);
            NORMAL = r1;
            Status r3 = new Status("PENDING_DELETE", 2, 2);
            PENDING_DELETE = r3;
            Status r5 = new Status("DELETED", 3, 3);
            DELETED = r5;
            Status r7 = new Status("COOLING_OFF", 4, 4);
            COOLING_OFF = r7;
            Status[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedCard$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "CHAT", "MAIL", "DOC", "THREAD", "BOX", "OPENAPP", "TOPIC", "APP_CHAT", "SUBSCRIPTION", "MSG_THREAD", "MY_AI", "APP_FEED", "KNOWLEDGE_AI", "DOUBAO_CUSTOM", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APP_CHAT = null;
        public static final Type APP_FEED = null;
        public static final Type BOX = null;
        public static final Type CHAT = null;
        public static final b Companion = null;
        public static final Type DOC = null;
        public static final Type DOUBAO_CUSTOM = null;
        public static final Type KNOWLEDGE_AI = null;
        public static final Type MAIL = null;
        public static final Type MSG_THREAD = null;
        public static final Type MY_AI = null;
        public static final Type OPENAPP = null;
        public static final Type SUBSCRIPTION = null;
        public static final Type THREAD = null;
        public static final Type TOPIC = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L19;
                    case 1: goto L34;
                    case 2: goto L33;
                    case 3: goto L32;
                    case 4: goto L31;
                    case 5: goto L30;
                    case 6: goto L29;
                    case 7: goto L28;
                    case 8: goto L27;
                    case 9: goto L3;
                    case 10: goto L26;
                    case 11: goto L25;
                    case 12: goto L24;
                    case 13: goto L23;
                    case 14: goto L22;
                    case 15: goto L21;
                    default: goto L3;
                };
            L3:
                return null;
            L21:
                return Type.DOUBAO_CUSTOM;
            L22:
                return Type.KNOWLEDGE_AI;
            L23:
                return Type.APP_FEED;
            L24:
                return Type.MY_AI;
            L25:
                return Type.MSG_THREAD;
            L26:
                return Type.SUBSCRIPTION;
            L27:
                return Type.APP_CHAT;
            L28:
                return Type.TOPIC;
            L29:
                return Type.OPENAPP;
            L30:
                return Type.BOX;
            L31:
                return Type.THREAD;
            L32:
                return Type.DOC;
            L33:
                return Type.MAIL;
            L34:
                return Type.CHAT;
            L19:
                return Type.UNKNOWN_TYPE;
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
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("CHAT", 1, 1);
            CHAT = r1;
            Type r3 = new Type("MAIL", 2, 2);
            MAIL = r3;
            Type r5 = new Type("DOC", 3, 3);
            DOC = r5;
            Type r7 = new Type("THREAD", 4, 4);
            THREAD = r7;
            Type r9 = new Type("BOX", 5, 5);
            BOX = r9;
            Type r11 = new Type("OPENAPP", 6, 6);
            OPENAPP = r11;
            Type r13 = new Type("TOPIC", 7, 7);
            TOPIC = r13;
            Type r15 = new Type("APP_CHAT", 8, 8);
            APP_CHAT = r15;
            Type r14 = new Type("SUBSCRIPTION", 9, 10);
            SUBSCRIPTION = r14;
            Type r12 = new Type("MSG_THREAD", 10, 11);
            MSG_THREAD = r12;
            Type r10 = new Type("MY_AI", 11, 12);
            MY_AI = r10;
            Type r8 = new Type("APP_FEED", 12, 13);
            APP_FEED = r8;
            Type r6 = new Type("KNOWLEDGE_AI", 13, 14);
            KNOWLEDGE_AI = r6;
            Type r4 = new Type("DOUBAO_CUSTOM", 14, 15);
            DOUBAO_CUSTOM = r4;
            Type[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
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

    public static final class a extends Message.a<FeedCard, a> {
        public String d;
        public Type e;
        public Long f;
        public Long g;
        public Boolean h;
        public Long i;
        public Long j;
        public Long k;
        public FeedType l;
        public Status m;
        public Boolean n;
        public FeedLastUnreadTime o;
        public FeedCardField p;
        public String q;
        public String r;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new FeedCard(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<FeedCard> {
        @Override // com.lark.wire.ProtoAdapter
        public final FeedCard c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L32;
            switch(r4) {
                case 1: goto L30;
                case 2: goto L35;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L37;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L33;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L33:
            r1.m = Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L35:
            r1.e = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L37:
            r1.l = FeedType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L7:
            r1.k = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.q = r10.i();
            goto L3
        L9:
            r1.p = FeedCardField.ADAPTER.c(r10);
            goto L3
        L10:
            r1.o = FeedLastUnreadTime.ADAPTER.c(r10);
            goto L3
        L11:
            r1.n = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L16:
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.r = r10.i();
            goto L3
        L22:
            r1.j = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L23:
            r1.i = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L24:
            r1.h = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L25:
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L30:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L6:
            r10.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L32:
            return new FeedCard(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedCard r7) {
            FeedCard r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r8.getId())) + Type.ADAPTER.l(2, r8.getType());
            t r3 = ProtoAdapter.k;
            int r4 = (r2 + r3.l(3, r8.getUpdate_time())) + r3.l(9, r8.getUpdate_time_ms());
            l r5 = ProtoAdapter.g;
            return ((((((((((r4 + r5.l(4, r8.is_delayed())) + r3.l(5, r8.getParent_card_id())) + r3.l(6, r8.getRank_time())) + r3.l(15, r8.getRank_time_ms())) + FeedType.ADAPTER.l(7, r8.getFeed_type())) + Status.ADAPTER.l(10, r8.getStatus())) + r5.l(11, r8.is_hide())) + FeedLastUnreadTime.ADAPTER.l(12, r8.getLast_unread_time())) + FeedCardField.ADAPTER.l(13, r8.getFeed_card_field())) + r1.l(14, r8.getBiz_id())) + r1.l(8, r8.getImpr_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, FeedCard r7) {
            FeedCard r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getId());
            Type.ADAPTER.i(r6, 2, r8.getType());
            t r1 = ProtoAdapter.k;
            r1.i(r6, 3, r8.getUpdate_time());
            r1.i(r6, 9, r8.getUpdate_time_ms());
            l r2 = ProtoAdapter.g;
            r2.i(r6, 4, r8.is_delayed());
            r1.i(r6, 5, r8.getParent_card_id());
            r1.i(r6, 6, r8.getRank_time());
            r1.i(r6, 15, r8.getRank_time_ms());
            FeedType.ADAPTER.i(r6, 7, r8.getFeed_type());
            Status.ADAPTER.i(r6, 10, r8.getStatus());
            r2.i(r6, 11, r8.is_hide());
            FeedLastUnreadTime.ADAPTER.i(r6, 12, r8.getLast_unread_time());
            FeedCardField.ADAPTER.i(r6, 13, r8.getFeed_card_field());
            r0.i(r6, 14, r8.getBiz_id());
            r0.i(r6, 8, r8.getImpr_id());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, FeedCard r7) {
            FeedCard r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r6, 8, r8.getImpr_id());
            r0.j(r6, 14, r8.getBiz_id());
            FeedCardField.ADAPTER.j(r6, 13, r8.getFeed_card_field());
            FeedLastUnreadTime.ADAPTER.j(r6, 12, r8.getLast_unread_time());
            l r1 = ProtoAdapter.g;
            r1.j(r6, 11, r8.is_hide());
            Status.ADAPTER.j(r6, 10, r8.getStatus());
            FeedType.ADAPTER.j(r6, 7, r8.getFeed_type());
            t r2 = ProtoAdapter.k;
            r2.j(r6, 15, r8.getRank_time_ms());
            r2.j(r6, 6, r8.getRank_time());
            r2.j(r6, 5, r8.getParent_card_id());
            r1.j(r6, 4, r8.is_delayed());
            r2.j(r6, 9, r8.getUpdate_time_ms());
            r2.j(r6, 3, r8.getUpdate_time());
            Type.ADAPTER.j(r6, 2, r8.getType());
            r0.j(r6, 1, r8.getId());
        }

        public b(FieldEncoding r7, KClass<FeedCard> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.FeedCard", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedCard(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = Type.CHAT;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedCard.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.f = this.update_time;
        r0.g = this.update_time_ms;
        r0.h = this.is_delayed;
        r0.i = this.parent_card_id;
        r0.j = this.rank_time;
        r0.k = this.rank_time_ms;
        r0.l = this.feed_type;
        r0.m = this.status;
        r0.n = this.is_hide;
        r0.o = this.last_unread_time;
        r0.p = this.feed_card_field;
        r0.q = this.biz_id;
        r0.r = this.impr_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedCard.class).getSimpleName() + "@" + hashCode();
    }

    public final String getBiz_id() {
        return this.biz_id;
    }

    public final FeedCardField getFeed_card_field() {
        return this.feed_card_field;
    }

    public final FeedType getFeed_type() {
        return this.feed_type;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImpr_id() {
        return this.impr_id;
    }

    public final FeedLastUnreadTime getLast_unread_time() {
        return this.last_unread_time;
    }

    public final Long getParent_card_id() {
        return this.parent_card_id;
    }

    public final Long getRank_time() {
        return this.rank_time;
    }

    public final Long getRank_time_ms() {
        return this.rank_time_ms;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final Long getUpdate_time_ms() {
        return this.update_time_ms;
    }

    public final Boolean is_delayed() {
        return this.is_delayed;
    }

    public final Boolean is_hide() {
        return this.is_hide;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public FeedCard(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.type = r2.e;
        this.update_time = r2.f;
        this.update_time_ms = r2.g;
        this.is_delayed = r2.h;
        this.parent_card_id = r2.i;
        this.rank_time = r2.j;
        this.rank_time_ms = r2.k;
        this.feed_type = r2.l;
        this.status = r2.m;
        this.is_hide = r2.n;
        this.last_unread_time = r2.o;
        this.feed_card_field = r2.p;
        this.biz_id = r2.q;
        this.impr_id = r2.r;
    }

    public /* synthetic */ FeedCard(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
