package com.lark.kmp.server.pb.entities;

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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedCardIdentity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/FeedCardIdentity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/FeedCardIdentity$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/server/pb/entities/FeedCard$Type;", "getType", "()Lcom/lark/kmp/server/pb/entities/FeedCard$Type;", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedCardIdentity extends Message<FeedCardIdentity, a> {
    public static final ProtoAdapter<FeedCardIdentity> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String id;
    private final FeedCard.Type type;

    public static final class a extends Message.a<FeedCardIdentity, a> {
        public String d;
        public FeedCard.Type e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new FeedCardIdentity(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<FeedCardIdentity> {
        @Override // com.lark.wire.ProtoAdapter
        public final FeedCardIdentity c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L9;
            r1.e = FeedCard.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L9:
            r10.j(r4);
            goto L3
        L16:
            return new FeedCardIdentity(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedCardIdentity r5) {
            FeedCardIdentity r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + FeedCard.Type.ADAPTER.l(2, r6.getType());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, FeedCardIdentity r5) {
            FeedCardIdentity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getId());
            FeedCard.Type.ADAPTER.i(r4, 2, r6.getType());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, FeedCardIdentity r5) {
            FeedCardIdentity r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            FeedCard.Type.ADAPTER.j(r4, 2, r6.getType());
            ProtoAdapter.q.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<FeedCardIdentity> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.FeedCardIdentity", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedCardIdentity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedCardIdentity.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedCardIdentity.class).getSimpleName() + "@" + hashCode();
    }

    public final String getId() {
        return this.id;
    }

    public final FeedCard.Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public FeedCardIdentity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.type = r2.e;
    }

    public /* synthetic */ FeedCardIdentity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
