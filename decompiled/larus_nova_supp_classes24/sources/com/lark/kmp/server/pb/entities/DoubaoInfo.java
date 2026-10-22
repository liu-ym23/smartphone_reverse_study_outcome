package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/server/pb/entities/DoubaoInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/DoubaoInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/DoubaoInfo$Builder;Lokio/ByteString;)V", "doubao_user_id", "", "getDoubao_user_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "doubao_conversation_id", "getDoubao_conversation_id", "deliver_conf", "Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf;", "getDeliver_conf", "()Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf;", "newBuilder", "toString", "", "Builder", "Companion", "DeliverConf", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DoubaoInfo extends Message<DoubaoInfo, a> {
    public static final ProtoAdapter<DoubaoInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final DeliverConf deliver_conf;
    private final Long doubao_conversation_id;
    private final Long doubao_user_id;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf$Builder;Lokio/ByteString;)V", "deliver_mode", "Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf$DeliverMode;", "getDeliver_mode", "()Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf$DeliverMode;", "newBuilder", "toString", "", "Builder", "Companion", "DeliverMode", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DeliverConf extends Message<DeliverConf, a> {
        public static final ProtoAdapter<DeliverConf> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final DeliverMode deliver_mode;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/server/pb/entities/DoubaoInfo$DeliverConf$DeliverMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LARK", "DOUBAO", "BOTH", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum DeliverMode extends Enum<DeliverMode> implements o0 {
            public static final ProtoAdapter<DeliverMode> ADAPTER = null;
            public static final DeliverMode BOTH = null;
            public static final b Companion = null;
            public static final DeliverMode DOUBAO = null;
            public static final DeliverMode LARK = null;
            public static final /* synthetic */ DeliverMode[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<DeliverMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    DeliverMode.Companion.getClass();
                    if (r2 == 1) goto L12;
                    if (r2 == 2) goto L15;
                    if (r2 == 3) goto L14;
                    return null;
                L14:
                    return DeliverMode.BOTH;
                L15:
                    return DeliverMode.DOUBAO;
                L12:
                    return DeliverMode.LARK;
                }

                public a(KClass<DeliverMode> r2, Syntax r3) {
                    super(r2, r3, null);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<DeliverMode> getEntries() {
                return b;
            }

            static {
                DeliverMode r0 = new DeliverMode("LARK", 0, 1);
                LARK = r0;
                DeliverMode r1 = new DeliverMode("DOUBAO", 1, 2);
                DOUBAO = r1;
                DeliverMode r4 = new DeliverMode("BOTH", 2, 3);
                BOTH = r4;
                DeliverMode[] r6 = {r0, r1, r4};
                a = r6;
                b = EnumEntriesKt.enumEntries(r6);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(DeliverMode.class), Syntax.PROTO_2);
            }

            public static DeliverMode[] values() {
                return (DeliverMode[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final DeliverMode fromValue(int r1) {
                Companion.getClass();
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L15;
                if (r1 == 3) goto L14;
                return null;
            L14:
                return BOTH;
            L15:
                return DOUBAO;
            L12:
                return LARK;
            }

            public static DeliverMode valueOf(String r1) {
                return (DeliverMode) r27.a.a(DeliverMode.class, r1);
            }

            public DeliverMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends Message.a<DeliverConf, a> {
            public DeliverMode d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new DeliverConf(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DeliverConf> {
            @Override // com.lark.wire.ProtoAdapter
            public final DeliverConf c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L11;
                r0.d = DeliverMode.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L13:
                return new DeliverConf(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DeliverConf r4) {
                DeliverConf r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + DeliverMode.ADAPTER.l(1, r5.getDeliver_mode());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DeliverConf r5) {
                DeliverConf r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                DeliverMode.ADAPTER.i(r4, 1, r6.getDeliver_mode());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, DeliverConf r4) {
                DeliverConf r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                DeliverMode.ADAPTER.j(r3, 1, r5.getDeliver_mode());
            }

            public b(FieldEncoding r7, KClass<DeliverConf> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/entities.DoubaoInfo.DeliverConf", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DeliverConf(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DeliverConf.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.deliver_mode;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DeliverConf.class).getSimpleName() + "@" + hashCode();
        }

        public final DeliverMode getDeliver_mode() {
            return this.deliver_mode;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public DeliverConf(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.deliver_mode = r2.d;
        }

        public /* synthetic */ DeliverConf(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<DoubaoInfo, a> {
        public Long d;
        public Long e;
        public DeliverConf f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new DoubaoInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<DoubaoInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final DoubaoInfo c(g0 r6) {
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
            if (r3 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = DeliverConf.ADAPTER.c(r6);
            goto L3
        L11:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L16:
            return new DoubaoInfo(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DoubaoInfo r5) {
            DoubaoInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return ((r0 + r1.l(1, r6.getDoubao_user_id())) + r1.l(2, r6.getDoubao_conversation_id())) + DeliverConf.ADAPTER.l(3, r6.getDeliver_conf());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, DoubaoInfo r5) {
            DoubaoInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r4, 1, r6.getDoubao_user_id());
            r0.i(r4, 2, r6.getDoubao_conversation_id());
            DeliverConf.ADAPTER.i(r4, 3, r6.getDeliver_conf());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, DoubaoInfo r5) {
            DoubaoInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            DeliverConf.ADAPTER.j(r4, 3, r6.getDeliver_conf());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 2, r6.getDoubao_conversation_id());
            r0.j(r4, 1, r6.getDoubao_user_id());
        }

        public b(FieldEncoding r7, KClass<DoubaoInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.DoubaoInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DoubaoInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DoubaoInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.doubao_user_id;
        r0.e = this.doubao_conversation_id;
        r0.f = this.deliver_conf;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DoubaoInfo.class).getSimpleName() + "@" + hashCode();
    }

    public final DeliverConf getDeliver_conf() {
        return this.deliver_conf;
    }

    public final Long getDoubao_conversation_id() {
        return this.doubao_conversation_id;
    }

    public final Long getDoubao_user_id() {
        return this.doubao_user_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public DoubaoInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.doubao_user_id = r2.d;
        this.doubao_conversation_id = r2.e;
        this.deliver_conf = r2.f;
    }

    public /* synthetic */ DoubaoInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
