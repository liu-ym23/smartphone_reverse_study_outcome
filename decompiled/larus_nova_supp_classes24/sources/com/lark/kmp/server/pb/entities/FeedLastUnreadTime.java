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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedLastUnreadTime;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/FeedLastUnreadTime$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/FeedLastUnreadTime$Builder;Lokio/ByteString;)V", "last_unread_time", "", "getLast_unread_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "last_unread_pos", "", "getLast_unread_pos", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedLastUnreadTime extends Message<FeedLastUnreadTime, a> {
    public static final ProtoAdapter<FeedLastUnreadTime> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer last_unread_pos;
    private final Long last_unread_time;

    public static final class a extends Message.a<FeedLastUnreadTime, a> {
        public Long d;
        public Integer e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new FeedLastUnreadTime(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<FeedLastUnreadTime> {
        @Override // com.lark.wire.ProtoAdapter
        public final FeedLastUnreadTime c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = (Integer) ProtoAdapter.h.c(r6);
            goto L3
        L9:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            return new FeedLastUnreadTime(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedLastUnreadTime r5) {
            FeedLastUnreadTime r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.k.l(1, r6.getLast_unread_time())) + ProtoAdapter.h.l(2, r6.getLast_unread_pos());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, FeedLastUnreadTime r5) {
            FeedLastUnreadTime r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.k.i(r4, 1, r6.getLast_unread_time());
            ProtoAdapter.h.i(r4, 2, r6.getLast_unread_pos());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, FeedLastUnreadTime r5) {
            FeedLastUnreadTime r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.h.j(r4, 2, r6.getLast_unread_pos());
            ProtoAdapter.k.j(r4, 1, r6.getLast_unread_time());
        }

        public b(FieldEncoding r7, KClass<FeedLastUnreadTime> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.FeedLastUnreadTime", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedLastUnreadTime(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedLastUnreadTime.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.last_unread_time;
        r0.e = this.last_unread_pos;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedLastUnreadTime.class).getSimpleName() + "@" + hashCode();
    }

    public final Integer getLast_unread_pos() {
        return this.last_unread_pos;
    }

    public final Long getLast_unread_time() {
        return this.last_unread_time;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public FeedLastUnreadTime(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.last_unread_time = r2.d;
        this.last_unread_pos = r2.e;
    }

    public /* synthetic */ FeedLastUnreadTime(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
