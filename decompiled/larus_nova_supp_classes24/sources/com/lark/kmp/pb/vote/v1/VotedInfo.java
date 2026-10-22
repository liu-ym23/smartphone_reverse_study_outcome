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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0019\u0010\u000bR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001b\u0010\u000bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001d\u0010\u000b¨\u0006#"}, d2 = {"Lcom/lark/kmp/pb/vote/v1/VotedInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/vote/v1/VotedInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/vote/v1/VotedInfo$Builder;Lokio/ByteString;)V", "vote_id", "", "getVote_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "is_voted", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "voted_indexes", "", "getVoted_indexes", "()Ljava/util/List;", "voted_index_info", "Lcom/lark/kmp/pb/vote/v1/VotedIndexInfo;", "getVoted_index_info", "version", "getVersion", "voter_number", "getVoter_number", "voted_number", "getVoted_number", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VotedInfo extends Message<VotedInfo, a> {
    public static final ProtoAdapter<VotedInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean is_voted;
    private final Long version;
    private final Long vote_id;
    private final List<VotedIndexInfo> voted_index_info;
    private final List<Long> voted_indexes;
    private final Long voted_number;
    private final Long voter_number;

    public static final class a extends Message.a<VotedInfo, a> {
        public Long d;
        public Boolean e;
        public List<Long> f;
        public List<VotedIndexInfo> g;
        public Long h;
        public Long i;
        public Long j;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new VotedInfo(this, c(), null);
        }

        public a() {
            this.f = CollectionsKt.emptyList();
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<VotedInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final VotedInfo c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L14;
            switch(r5) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.j = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L8:
            r0.i = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L9:
            r0.h = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L10:
            r2.add(VotedIndexInfo.ADAPTER.c(r8));
            goto L3
        L11:
            r1.add(ProtoAdapter.k.c(r8));
            goto L3
        L12:
            r0.e = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L13:
            r0.d = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L6:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L14:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r1, "voted_indexes");
            com.lark.wire.internal.a.a(r1);
            r0.f = r1;
            Intrinsics.checkNotNullParameter(r2, "voted_index_info");
            com.lark.wire.internal.a.a(r2);
            r0.g = r2;
            return new VotedInfo(r0, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VotedInfo r6) {
            VotedInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return ((((((r0 + r1.l(1, r7.getVote_id())) + ProtoAdapter.g.l(2, r7.is_voted())) + r1.a().l(3, r7.getVoted_indexes())) + VotedIndexInfo.ADAPTER.a().l(4, r7.getVoted_index_info())) + r1.l(5, r7.getVersion())) + r1.l(6, r7.getVoter_number())) + r1.l(7, r7.getVoted_number());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, VotedInfo r6) {
            VotedInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r5, 1, r7.getVote_id());
            ProtoAdapter.g.i(r5, 2, r7.is_voted());
            r0.a().i(r5, 3, r7.getVoted_indexes());
            VotedIndexInfo.ADAPTER.a().i(r5, 4, r7.getVoted_index_info());
            r0.i(r5, 5, r7.getVersion());
            r0.i(r5, 6, r7.getVoter_number());
            r0.i(r5, 7, r7.getVoted_number());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, VotedInfo r6) {
            VotedInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 7, r7.getVoted_number());
            r0.j(r5, 6, r7.getVoter_number());
            r0.j(r5, 5, r7.getVersion());
            VotedIndexInfo.ADAPTER.a().j(r5, 4, r7.getVoted_index_info());
            r0.a().j(r5, 3, r7.getVoted_indexes());
            ProtoAdapter.g.j(r5, 2, r7.is_voted());
            r0.j(r5, 1, r7.getVote_id());
        }

        public b(FieldEncoding r7, KClass<VotedInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/vote.v1.VotedInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VotedInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VotedInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.vote_id;
        r0.e = this.is_voted;
        r0.f = this.voted_indexes;
        r0.g = this.voted_index_info;
        r0.h = this.version;
        r0.i = this.voter_number;
        r0.j = this.voted_number;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VotedInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getVersion() {
        return this.version;
    }

    public final Long getVote_id() {
        return this.vote_id;
    }

    public final List<VotedIndexInfo> getVoted_index_info() {
        return this.voted_index_info;
    }

    public final List<Long> getVoted_indexes() {
        return this.voted_indexes;
    }

    public final Long getVoted_number() {
        return this.voted_number;
    }

    public final Long getVoter_number() {
        return this.voter_number;
    }

    public final Boolean is_voted() {
        return this.is_voted;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public VotedInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.vote_id = r2.d;
        this.is_voted = r2.e;
        this.voted_indexes = com.lark.wire.internal.a.c("voted_indexes", r2.f);
        this.voted_index_info = com.lark.wire.internal.a.c("voted_index_info", r2.g);
        this.version = r2.h;
        this.voter_number = r2.i;
        this.voted_number = r2.j;
    }

    public /* synthetic */ VotedInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
