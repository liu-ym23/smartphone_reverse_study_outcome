package com.lark.kmp.pb.office_sdk.basic;

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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/office_sdk/basic/DoubaoContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/office_sdk/basic/DoubaoContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/office_sdk/basic/DoubaoContent$Builder;Lokio/ByteString;)V", "doubao_msg_id", "", "getDoubao_msg_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "doubao_data", "getDoubao_data", "()Lokio/ByteString;", "query_msg_id", "getQuery_msg_id", "query_msg_owner_id", "getQuery_msg_owner_id", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DoubaoContent extends Message<DoubaoContent, a> {
    public static final ProtoAdapter<DoubaoContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ByteString doubao_data;
    private final Long doubao_msg_id;
    private final Long query_msg_id;
    private final Long query_msg_owner_id;

    public static final class a extends Message.a<DoubaoContent, a> {
        public Long d;
        public ByteString e;
        public Long f;
        public Long g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new DoubaoContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<DoubaoContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final DoubaoContent c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            r1.d = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.f();
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new DoubaoContent(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DoubaoContent r6) {
            DoubaoContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return (((r0 + r1.l(1, r7.getDoubao_msg_id())) + ProtoAdapter.p.l(2, r7.getDoubao_data())) + r1.l(3, r7.getQuery_msg_id())) + r1.l(4, r7.getQuery_msg_owner_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, DoubaoContent r6) {
            DoubaoContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r5, 1, r7.getDoubao_msg_id());
            ProtoAdapter.p.i(r5, 2, r7.getDoubao_data());
            r0.i(r5, 3, r7.getQuery_msg_id());
            r0.i(r5, 4, r7.getQuery_msg_owner_id());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, DoubaoContent r6) {
            DoubaoContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 4, r7.getQuery_msg_owner_id());
            r0.j(r5, 3, r7.getQuery_msg_id());
            ProtoAdapter.p.j(r5, 2, r7.getDoubao_data());
            r0.j(r5, 1, r7.getDoubao_msg_id());
        }

        public b(FieldEncoding r7, KClass<DoubaoContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/office_sdk.basic.DoubaoContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DoubaoContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DoubaoContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.doubao_msg_id;
        r0.e = this.doubao_data;
        r0.f = this.query_msg_id;
        r0.g = this.query_msg_owner_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DoubaoContent.class).getSimpleName() + '@' + hashCode();
    }

    public final ByteString getDoubao_data() {
        return this.doubao_data;
    }

    public final Long getDoubao_msg_id() {
        return this.doubao_msg_id;
    }

    public final Long getQuery_msg_id() {
        return this.query_msg_id;
    }

    public final Long getQuery_msg_owner_id() {
        return this.query_msg_owner_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public DoubaoContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.doubao_msg_id = r2.d;
        this.doubao_data = r2.e;
        this.query_msg_id = r2.f;
        this.query_msg_owner_id = r2.g;
    }

    public /* synthetic */ DoubaoContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
