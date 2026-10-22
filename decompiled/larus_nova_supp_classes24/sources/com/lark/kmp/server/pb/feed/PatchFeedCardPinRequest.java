package com.lark.kmp.server.pb.feed;

import com.lark.kmp.server.pb.entities.FeedCardIdentity;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/server/pb/feed/PatchFeedCardPinRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/feed/PatchFeedCardPinRequest$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/feed/PatchFeedCardPinRequest$Builder;Lokio/ByteString;)V", "card", "Lcom/lark/kmp/server/pb/entities/FeedCardIdentity;", "getCard", "()Lcom/lark/kmp/server/pb/entities/FeedCardIdentity;", "mark_pin", "", "getMark_pin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PatchFeedCardPinRequest extends Message<PatchFeedCardPinRequest, a> {
    public static final ProtoAdapter<PatchFeedCardPinRequest> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final FeedCardIdentity card;
    private final Boolean mark_pin;

    public static final class a extends Message.a<PatchFeedCardPinRequest, a> {
        public FeedCardIdentity d;
        public Boolean e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new PatchFeedCardPinRequest(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<PatchFeedCardPinRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final PatchFeedCardPinRequest c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L8;
            r0.d = FeedCardIdentity.ADAPTER.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L9:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            return new PatchFeedCardPinRequest(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PatchFeedCardPinRequest r5) {
            PatchFeedCardPinRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + FeedCardIdentity.ADAPTER.l(1, r6.getCard())) + ProtoAdapter.g.l(2, r6.getMark_pin());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, PatchFeedCardPinRequest r5) {
            PatchFeedCardPinRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            FeedCardIdentity.ADAPTER.i(r4, 1, r6.getCard());
            ProtoAdapter.g.i(r4, 2, r6.getMark_pin());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, PatchFeedCardPinRequest r5) {
            PatchFeedCardPinRequest r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 2, r6.getMark_pin());
            FeedCardIdentity.ADAPTER.j(r4, 1, r6.getCard());
        }

        public b(FieldEncoding r7, KClass<PatchFeedCardPinRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/feed.PatchFeedCardPinRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PatchFeedCardPinRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PatchFeedCardPinRequest.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.card;
        r0.e = this.mark_pin;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PatchFeedCardPinRequest.class).getSimpleName() + "@" + hashCode();
    }

    public final FeedCardIdentity getCard() {
        return this.card;
    }

    public final Boolean getMark_pin() {
        return this.mark_pin;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public PatchFeedCardPinRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.card = r2.d;
        this.mark_pin = r2.e;
    }

    public /* synthetic */ PatchFeedCardPinRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
