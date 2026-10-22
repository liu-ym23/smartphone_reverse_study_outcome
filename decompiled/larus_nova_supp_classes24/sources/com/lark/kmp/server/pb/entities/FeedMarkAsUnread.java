package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedMarkAsUnread;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/FeedMarkAsUnread$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/FeedMarkAsUnread$Builder;Lokio/ByteString;)V", "unread", "", "getUnread", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "update_time_ms", "", "getUpdate_time_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "read_pos", "getRead_pos", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedMarkAsUnread extends Message<FeedMarkAsUnread, a> {
    public static final ProtoAdapter<FeedMarkAsUnread> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long read_pos;
    private final Boolean unread;
    private final Long update_time_ms;

    public static final class a extends Message.a<FeedMarkAsUnread, a> {
        public Boolean d;
        public Long e;
        public Long f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new FeedMarkAsUnread(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<FeedMarkAsUnread> {
        @Override // com.lark.wire.ProtoAdapter
        public final FeedMarkAsUnread c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L11:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L16:
            return new FeedMarkAsUnread(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedMarkAsUnread r5) {
            FeedMarkAsUnread r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.getUnread());
            t r1 = ProtoAdapter.k;
            return (r0 + r1.l(2, r6.getUpdate_time_ms())) + r1.l(3, r6.getRead_pos());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, FeedMarkAsUnread r5) {
            FeedMarkAsUnread r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.g.i(r4, 1, r6.getUnread());
            t r0 = ProtoAdapter.k;
            r0.i(r4, 2, r6.getUpdate_time_ms());
            r0.i(r4, 3, r6.getRead_pos());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, FeedMarkAsUnread r5) {
            FeedMarkAsUnread r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 3, r6.getRead_pos());
            r0.j(r4, 2, r6.getUpdate_time_ms());
            ProtoAdapter.g.j(r4, 1, r6.getUnread());
        }

        public b(FieldEncoding r7, KClass<FeedMarkAsUnread> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.FeedMarkAsUnread", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedMarkAsUnread(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedMarkAsUnread.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.unread;
        r0.e = this.update_time_ms;
        r0.f = this.read_pos;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedMarkAsUnread.class).getSimpleName() + "@" + hashCode();
    }

    public final Long getRead_pos() {
        return this.read_pos;
    }

    public final Boolean getUnread() {
        return this.unread;
    }

    public final Long getUpdate_time_ms() {
        return this.update_time_ms;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public FeedMarkAsUnread(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.unread = r2.d;
        this.update_time_ms = r2.e;
        this.read_pos = r2.f;
    }

    public /* synthetic */ FeedMarkAsUnread(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
