package com.lark.kmp.pb.vote.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/vote/v1/VotedIndexInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/vote/v1/VotedIndexInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/vote/v1/VotedIndexInfo$Builder;Lokio/ByteString;)V", "index", "", "getIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "count", "getCount", "users", "", "getUsers", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VotedIndexInfo extends Message<VotedIndexInfo, a> {
    public static final ProtoAdapter<VotedIndexInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long count;
    private final Long index;
    private final List<Long> users;

    public static final class a extends Message.a<VotedIndexInfo, a> {
        public Long d;
        public Long e;
        public List<Long> f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new VotedIndexInfo(this, c(), null);
        }

        public a() {
            this.f = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<VotedIndexInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final VotedIndexInfo c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L15;
            if (r4 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.add(ProtoAdapter.k.c(r7));
            goto L3
        L11:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L15:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "users");
            com.lark.wire.internal.a.a(r1);
            r0.f = r1;
            return new VotedIndexInfo(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VotedIndexInfo r5) {
            VotedIndexInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return ((r0 + r1.l(1, r6.getIndex())) + r1.l(2, r6.getCount())) + r1.a().l(3, r6.getUsers());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, VotedIndexInfo r5) {
            VotedIndexInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r4, 1, r6.getIndex());
            r0.i(r4, 2, r6.getCount());
            r0.a().i(r4, 3, r6.getUsers());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, VotedIndexInfo r6) {
            VotedIndexInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.a().j(r5, 3, r7.getUsers());
            r0.j(r5, 2, r7.getCount());
            r0.j(r5, 1, r7.getIndex());
        }

        public b(FieldEncoding r7, KClass<VotedIndexInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/vote.v1.VotedIndexInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VotedIndexInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VotedIndexInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.index;
        r0.e = this.count;
        r0.f = this.users;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VotedIndexInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getCount() {
        return this.count;
    }

    public final Long getIndex() {
        return this.index;
    }

    public final List<Long> getUsers() {
        return this.users;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public VotedIndexInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.index = r2.d;
        this.count = r2.e;
        this.users = com.lark.wire.internal.a.c("users", r2.f);
    }

    public /* synthetic */ VotedIndexInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
