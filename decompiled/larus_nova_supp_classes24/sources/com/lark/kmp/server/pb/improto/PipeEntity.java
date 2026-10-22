package com.lark.kmp.server.pb.improto;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/server/pb/improto/PipeEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/improto/PipeEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/improto/PipeEntity$Builder;Lokio/ByteString;)V", "type", "", "getType", "()Ljava/lang/String;", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PipeEntity extends Message<PipeEntity, a> {
    public static final ProtoAdapter<PipeEntity> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long id;
    private final String type;

    public static final class a extends Message.a<PipeEntity, a> {
        public String d;
        public Long e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new PipeEntity(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<PipeEntity> {
        @Override // com.lark.wire.ProtoAdapter
        public final PipeEntity c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L13;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "type");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 3) goto L9;
            r1.e = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L9:
            r7.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L13:
            return new PipeEntity(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PipeEntity r5) {
            PipeEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getType())) + ProtoAdapter.k.l(3, r6.getId());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, PipeEntity r5) {
            PipeEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getType());
            ProtoAdapter.k.i(r4, 3, r6.getId());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, PipeEntity r5) {
            PipeEntity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 3, r6.getId());
            ProtoAdapter.q.j(r4, 1, r6.getType());
        }

        public b(FieldEncoding r7, KClass<PipeEntity> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/improto.PipeEntity", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PipeEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PipeEntity.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PipeEntity.class).getSimpleName() + "@" + hashCode();
    }

    public final Long getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public PipeEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.type = r4;
        this.id = r2.e;
    }

    public /* synthetic */ PipeEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
