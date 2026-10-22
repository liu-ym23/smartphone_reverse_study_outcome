package com.lark.kmp.server.pb.improto;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/server/pb/improto/VersionRange;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/improto/VersionRange$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/improto/VersionRange$Builder;Lokio/ByteString;)V", "start", "", "getStart", "()Ljava/lang/String;", "end", "getEnd", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VersionRange extends Message<VersionRange, a> {
    public static final ProtoAdapter<VersionRange> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String end;
    private final String start;

    public static final class a extends Message.a<VersionRange, a> {
        public String d;
        public String e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new VersionRange(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<VersionRange> {
        @Override // com.lark.wire.ProtoAdapter
        public final VersionRange c(g0 r7) {
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
            Intrinsics.checkNotNullParameter(r5, "start");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L9;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r6 = r7.i();
            Intrinsics.checkNotNullParameter(r6, "end");
            r1.e = r6;
            goto L3
        L9:
            r7.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L13:
            return new VersionRange(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VersionRange r5) {
            VersionRange r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (r0 + r1.l(1, r6.getStart())) + r1.l(2, r6.getEnd());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, VersionRange r5) {
            VersionRange r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getStart());
            r0.i(r4, 2, r6.getEnd());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, VersionRange r5) {
            VersionRange r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getEnd());
            r0.j(r4, 1, r6.getStart());
        }

        public b(FieldEncoding r7, KClass<VersionRange> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/improto.VersionRange", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VersionRange(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VersionRange.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.start;
        r0.e = this.end;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VersionRange.class).getSimpleName() + "@" + hashCode();
    }

    public final String getEnd() {
        return this.end;
    }

    public final String getStart() {
        return this.start;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public VersionRange(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.start = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.end = r5;
    }

    public /* synthetic */ VersionRange(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
