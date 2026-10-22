package com.lark.kmp.server.pb.improto;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.b0;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003678B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0#¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0015\u0010)\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b*\u0010\u0017R\u0015\u0010+\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b,\u0010\u0017R\u0015\u0010-\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020.0#¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&¨\u00069"}, d2 = {"Lcom/lark/kmp/server/pb/improto/Packet;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/improto/Packet$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/improto/Packet$Builder;Lokio/ByteString;)V", "sid", "", "getSid", "()Ljava/lang/String;", "payload_type", "Lcom/lark/kmp/server/pb/improto/PayloadType;", "getPayload_type", "()Lcom/lark/kmp/server/pb/improto/PayloadType;", "cmd", "Lcom/lark/kmp/server/pb/improto/Command;", "getCmd", "()Lcom/lark/kmp/server/pb/improto/Command;", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "payload", "getPayload", "()Lokio/ByteString;", "cid", "getCid", "pipe_entity", "Lcom/lark/kmp/server/pb/improto/PipeEntity;", "getPipe_entity", "()Lcom/lark/kmp/server/pb/improto/PipeEntity;", "version_payloads", "", "Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload;", "getVersion_payloads", "()Ljava/util/List;", "pipe_entities", "getPipe_entities", "wait_retry_interval", "getWait_retry_interval", "command", "getCommand", "cursor", "", "getCursor", "()Ljava/lang/Long;", "Ljava/lang/Long;", "compacted_sids", "getCompacted_sids", "newBuilder", "toString", "Builder", "Companion", "VersionPayload", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Packet extends Message<Packet, a> {
    public static final ProtoAdapter<Packet> ADAPTER = null;
    public static final c Companion = null;
    public static final PayloadType DEFAULT_PAYLOAD_TYPE = null;
    public static final int DEFAULT_STATUS = 200;
    private static final long serialVersionUID = 0;
    private final String cid;
    private final Command cmd;
    private final Integer command;
    private final List<Long> compacted_sids;
    private final Long cursor;
    private final ByteString payload;
    private final PayloadType payload_type;
    private final List<PipeEntity> pipe_entities;
    private final PipeEntity pipe_entity;
    private final String sid;
    private final Integer status;
    private final List<VersionPayload> version_payloads;
    private final Integer wait_retry_interval;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload$Builder;Lokio/ByteString;)V", "version_range", "Lcom/lark/kmp/server/pb/improto/VersionRange;", "getVersion_range", "()Lcom/lark/kmp/server/pb/improto/VersionRange;", "payload", "getPayload", "()Lokio/ByteString;", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class VersionPayload extends Message<VersionPayload, a> {
        public static final ProtoAdapter<VersionPayload> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ByteString payload;
        private final VersionRange version_range;

        public static final class a extends Message.a<VersionPayload, a> {
            public VersionRange d;
            public ByteString e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new VersionPayload(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<VersionPayload> {
            @Override // com.lark.wire.ProtoAdapter
            public final VersionPayload c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                r1.d = VersionRange.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                ByteString r5 = r7.f();
                Intrinsics.checkNotNullParameter(r5, "payload");
                r1.e = r5;
                goto L3
            L9:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L13:
                return new VersionPayload(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(VersionPayload r5) {
                VersionPayload r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + VersionRange.ADAPTER.l(1, r6.getVersion_range())) + ProtoAdapter.p.l(2, r6.getPayload());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, VersionPayload r5) {
                VersionPayload r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                VersionRange.ADAPTER.i(r4, 1, r6.getVersion_range());
                ProtoAdapter.p.i(r4, 2, r6.getPayload());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, VersionPayload r5) {
                VersionPayload r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.p.j(r4, 2, r6.getPayload());
                VersionRange.ADAPTER.j(r4, 1, r6.getVersion_range());
            }

            public b(FieldEncoding r7, KClass<VersionPayload> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/improto.Packet.VersionPayload", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ VersionPayload(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VersionPayload.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.version_range;
            r0.e = this.payload;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(VersionPayload.class).getSimpleName() + "@" + hashCode();
        }

        public final ByteString getPayload() {
            return this.payload;
        }

        public final VersionRange getVersion_range() {
            return this.version_range;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public VersionPayload(a r2, ByteString r3) {
            super(ADAPTER, r3);
            VersionRange r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.version_range = r4;
            ByteString r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.payload = r5;
        }

        public /* synthetic */ VersionPayload(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<Packet, a> {
        public String d;
        public PayloadType e;
        public Command f;
        public Integer g;
        public ByteString h;
        public String i;
        public PipeEntity j;
        public List<VersionPayload> k;
        public List<PipeEntity> l;
        public Integer m;
        public Integer n;
        public Long o;
        public List<Long> p;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new Packet(this, c(), null);
        }

        public a() {
            this.k = CollectionsKt.emptyList();
            this.l = CollectionsKt.emptyList();
            this.p = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Packet> {
        @Override // com.lark.wire.ProtoAdapter
        public final Packet c(g0 r13) {
            Intrinsics.checkNotNullParameter(r13, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            ArrayList r4 = new ArrayList();
            long r5 = r13.c();
        L3:
            int r7 = r13.e();
            if (r7 == (-1)) goto L26;
            switch(r7) {
                case 1: goto L25;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            Command r8 = Command.ADAPTER.c(r13);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            Intrinsics.checkNotNullParameter(r8, "cmd");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            r1.f = r8;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r13.a(r7, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L30:
            PayloadType r10 = PayloadType.ADAPTER.c(r13);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            Intrinsics.checkNotNullParameter(r10, "payload_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            r1.e = r10;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r13.a(r7, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r11 = Unit.INSTANCE;
            goto L3
        L7:
            r4.add(ProtoAdapter.k.c(r13));
            goto L3
        L8:
            r1.o = (Long) ProtoAdapter.l.c(r13);
            goto L3
        L9:
            r1.n = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L10:
            r1.m = (Integer) ProtoAdapter.i.c(r13);
            goto L3
        L11:
            r3.add(PipeEntity.ADAPTER.c(r13));
            goto L3
        L12:
            r2.add(VersionPayload.ADAPTER.c(r13));
            goto L3
        L13:
            r1.j = PipeEntity.ADAPTER.c(r13);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.i = r13.i();
            goto L3
        L15:
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.h = r13.f();
            goto L3
        L16:
            r1.g = (Integer) ProtoAdapter.i.c(r13);
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.d = r13.i();
            goto L3
        L6:
            r13.j(r7);
            Unit r12 = Unit.INSTANCE;
            goto L3
        L26:
            ByteString r14 = r13.d(r5);
            Intrinsics.checkNotNullParameter(r2, "version_payloads");
            com.lark.wire.internal.a.a(r2);
            r1.k = r2;
            Intrinsics.checkNotNullParameter(r3, "pipe_entities");
            com.lark.wire.internal.a.a(r3);
            r1.l = r3;
            Intrinsics.checkNotNullParameter(r4, "compacted_sids");
            com.lark.wire.internal.a.a(r4);
            r1.p = r4;
            return new Packet(r1, r14, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Packet r7) {
            Packet r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((r0 + r1.l(1, r8.getSid())) + PayloadType.ADAPTER.l(2, r8.getPayload_type())) + Command.ADAPTER.l(3, r8.getCmd());
            b0 r3 = ProtoAdapter.i;
            int r4 = ((r2 + r3.l(4, r8.getStatus())) + ProtoAdapter.p.l(5, r8.getPayload())) + r1.l(6, r8.getCid());
            ProtoAdapter<PipeEntity> r5 = PipeEntity.ADAPTER;
            return ((((((r4 + r5.l(7, r8.getPipe_entity())) + VersionPayload.ADAPTER.a().l(8, r8.getVersion_payloads())) + r5.a().l(9, r8.getPipe_entities())) + r3.l(10, r8.getWait_retry_interval())) + ProtoAdapter.h.l(11, r8.getCommand())) + ProtoAdapter.l.l(12, r8.getCursor())) + ProtoAdapter.k.a().l(13, r8.getCompacted_sids());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, Packet r7) {
            Packet r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getSid());
            PayloadType.ADAPTER.i(r6, 2, r8.getPayload_type());
            Command.ADAPTER.i(r6, 3, r8.getCmd());
            b0 r1 = ProtoAdapter.i;
            r1.i(r6, 4, r8.getStatus());
            ProtoAdapter.p.i(r6, 5, r8.getPayload());
            r0.i(r6, 6, r8.getCid());
            ProtoAdapter<PipeEntity> r2 = PipeEntity.ADAPTER;
            r2.i(r6, 7, r8.getPipe_entity());
            VersionPayload.ADAPTER.a().i(r6, 8, r8.getVersion_payloads());
            r2.a().i(r6, 9, r8.getPipe_entities());
            r1.i(r6, 10, r8.getWait_retry_interval());
            ProtoAdapter.h.i(r6, 11, r8.getCommand());
            ProtoAdapter.l.i(r6, 12, r8.getCursor());
            ProtoAdapter.k.a().i(r6, 13, r8.getCompacted_sids());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, Packet r7) {
            Packet r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            ProtoAdapter.k.a().j(r6, 13, r8.getCompacted_sids());
            ProtoAdapter.l.j(r6, 12, r8.getCursor());
            ProtoAdapter.h.j(r6, 11, r8.getCommand());
            b0 r0 = ProtoAdapter.i;
            r0.j(r6, 10, r8.getWait_retry_interval());
            ProtoAdapter<PipeEntity> r1 = PipeEntity.ADAPTER;
            r1.a().j(r6, 9, r8.getPipe_entities());
            VersionPayload.ADAPTER.a().j(r6, 8, r8.getVersion_payloads());
            r1.j(r6, 7, r8.getPipe_entity());
            w r2 = ProtoAdapter.q;
            r2.j(r6, 6, r8.getCid());
            ProtoAdapter.p.j(r6, 5, r8.getPayload());
            r0.j(r6, 4, r8.getStatus());
            Command.ADAPTER.j(r6, 3, r8.getCmd());
            PayloadType.ADAPTER.j(r6, 2, r8.getPayload_type());
            r2.j(r6, 1, r8.getSid());
        }

        public b(FieldEncoding r7, KClass<Packet> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/improto.Packet", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Packet(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_PAYLOAD_TYPE = PayloadType.PB2;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Packet.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.sid;
        r0.e = this.payload_type;
        r0.f = this.cmd;
        r0.g = this.status;
        r0.h = this.payload;
        r0.i = this.cid;
        r0.j = this.pipe_entity;
        r0.k = this.version_payloads;
        r0.l = this.pipe_entities;
        r0.m = this.wait_retry_interval;
        r0.n = this.command;
        r0.o = this.cursor;
        r0.p = this.compacted_sids;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Packet.class).getSimpleName() + "@" + hashCode();
    }

    public final String getCid() {
        return this.cid;
    }

    public final Command getCmd() {
        return this.cmd;
    }

    public final Integer getCommand() {
        return this.command;
    }

    public final List<Long> getCompacted_sids() {
        return this.compacted_sids;
    }

    public final Long getCursor() {
        return this.cursor;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    public final PayloadType getPayload_type() {
        return this.payload_type;
    }

    public final List<PipeEntity> getPipe_entities() {
        return this.pipe_entities;
    }

    public final PipeEntity getPipe_entity() {
        return this.pipe_entity;
    }

    public final String getSid() {
        return this.sid;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final List<VersionPayload> getVersion_payloads() {
        return this.version_payloads;
    }

    public final Integer getWait_retry_interval() {
        return this.wait_retry_interval;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public Packet(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.sid = r2.d;
        PayloadType r4 = r2.e;
        Intrinsics.checkNotNull(r4);
        this.payload_type = r4;
        Command r5 = r2.f;
        Intrinsics.checkNotNull(r5);
        this.cmd = r5;
        this.status = r2.g;
        this.payload = r2.h;
        this.cid = r2.i;
        this.pipe_entity = r2.j;
        this.version_payloads = com.lark.wire.internal.a.c("version_payloads", r2.k);
        this.pipe_entities = com.lark.wire.internal.a.c("pipe_entities", r2.l);
        this.wait_retry_interval = r2.m;
        this.command = r2.n;
        this.cursor = r2.o;
        this.compacted_sids = com.lark.wire.internal.a.c("compacted_sids", r2.p);
    }

    public /* synthetic */ Packet(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
