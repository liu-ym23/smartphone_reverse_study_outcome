package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedButtonActions;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/FeedButtonActions$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/FeedButtonActions$Builder;Lokio/ByteString;)V", "actions", "", "", "getActions", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedButtonActions extends Message<FeedButtonActions, a> {
    public static final ProtoAdapter<FeedButtonActions> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, String> actions;

    public static final class a extends Message.a<FeedButtonActions, a> {
        public Map<String, String> d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new FeedButtonActions(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
        }
    }

    public static final class b extends ProtoAdapter<FeedButtonActions> {
        public final Lazy v;

        @Override // com.lark.wire.ProtoAdapter
        public final FeedButtonActions c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            LinkedHashMap r1 = new LinkedHashMap();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L9;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            r1.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "actions");
            r0.d = r1;
            return new FeedButtonActions(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedButtonActions r4) {
            FeedButtonActions r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + ((ProtoAdapter) this.v.getValue()).l(1, r5.getActions());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, FeedButtonActions r5) {
            FeedButtonActions r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ((ProtoAdapter) this.v.getValue()).i(r4, 1, r6.getActions());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, FeedButtonActions r4) {
            FeedButtonActions r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            ((ProtoAdapter) this.v.getValue()).j(r3, 1, r5.getActions());
        }

        public b(FieldEncoding r7, KClass<FeedButtonActions> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.FeedButtonActions", r9, null);
            this.v = LazyKt.lazy(new ky7.b());
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedButtonActions(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedButtonActions.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.actions;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedButtonActions.class).getSimpleName() + "@" + hashCode();
    }

    public final Map<String, String> getActions() {
        return this.actions;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public FeedButtonActions(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.actions = com.lark.wire.internal.a.d("actions", r2.d);
    }

    public /* synthetic */ FeedButtonActions(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
