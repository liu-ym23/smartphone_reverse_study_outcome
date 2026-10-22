package com.lark.kmp.pb.vote.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00102\u001a\u00020\u0002H\u0016J\b\u00103\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001c\u0010\u000bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001e\u0010\u000bR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u001f\u0010!R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b-\u0010\u000bR\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/lark/kmp/pb/vote/v1/VoteContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/vote/v1/VoteContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/vote/v1/VoteContent$Builder;Lokio/ByteString;)V", "uuid", "", "getUuid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "scope_id", "", "getScope_id", "()Ljava/lang/String;", "scope_type", "Lcom/lark/kmp/pb/vote/v1/VoteScopeType;", "getScope_type", "()Lcom/lark/kmp/pb/vote/v1/VoteScopeType;", "container_type", "Lcom/lark/kmp/pb/vote/v1/VoteContainerType;", "getContainer_type", "()Lcom/lark/kmp/pb/vote/v1/VoteContainerType;", "topic", "getTopic", "min_pick_num", "getMin_pick_num", "max_pick_num", "getMax_pick_num", "is_public", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "options", "", "Lcom/lark/kmp/pb/vote/v1/VoteOption;", "getOptions", "()Ljava/util/List;", "status", "Lcom/lark/kmp/pb/vote/v1/VoteStatus;", "getStatus", "()Lcom/lark/kmp/pb/vote/v1/VoteStatus;", "initiator", "getInitiator", "vote_message_type", "Lcom/lark/kmp/pb/vote/v1/VoteMessageType;", "getVote_message_type", "()Lcom/lark/kmp/pb/vote/v1/VoteMessageType;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VoteContent extends Message<VoteContent, a> {
    public static final ProtoAdapter<VoteContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final VoteContainerType container_type;
    private final Long initiator;
    private final Boolean is_public;
    private final Long max_pick_num;
    private final Long min_pick_num;
    private final List<VoteOption> options;
    private final String scope_id;
    private final VoteScopeType scope_type;
    private final VoteStatus status;
    private final String topic;
    private final Long uuid;
    private final VoteMessageType vote_message_type;

    public static final class a extends Message.a<VoteContent, a> {
        public Long d;
        public String e;
        public VoteScopeType f;
        public VoteContainerType g;
        public String h;
        public Long i;
        public Long j;
        public Boolean k;
        public List<VoteOption> l;
        public VoteStatus m;
        public Long n;
        public VoteMessageType o;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new VoteContent(this, c(), null);
        }

        public a() {
            this.l = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<VoteContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final VoteContent c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L31;
            switch(r5) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L35;
                case 4: goto L37;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L33;
                case 11: goto L11;
                case 12: goto L39;
                default: goto L6;
            };
        L33:
            r1.m = VoteStatus.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L35:
            r1.f = VoteScopeType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L37:
            r1.g = VoteContainerType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L39:
            r1.o = VoteMessageType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L11:
            r1.n = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L16:
            r2.add(VoteOption.ADAPTER.c(r11));
            goto L3
        L17:
            r1.k = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L18:
            r1.j = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L19:
            r1.i = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.h = r11.i();
            goto L3
        L29:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.e = r11.i();
            goto L3
        L30:
            r1.d = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L6:
            r11.j(r5);
            Unit r10 = Unit.INSTANCE;
            goto L3
        L31:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "options");
            com.lark.wire.internal.a.a(r2);
            r1.l = r2;
            return new VoteContent(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VoteContent r7) {
            VoteContent r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            t r1 = ProtoAdapter.k;
            int r2 = r0 + r1.l(1, r8.getUuid());
            w r3 = ProtoAdapter.q;
            return ((((((((((r2 + r3.l(2, r8.getScope_id())) + VoteScopeType.ADAPTER.l(3, r8.getScope_type())) + VoteContainerType.ADAPTER.l(4, r8.getContainer_type())) + r3.l(5, r8.getTopic())) + r1.l(6, r8.getMin_pick_num())) + r1.l(7, r8.getMax_pick_num())) + ProtoAdapter.g.l(8, r8.is_public())) + VoteOption.ADAPTER.a().l(9, r8.getOptions())) + VoteStatus.ADAPTER.l(10, r8.getStatus())) + r1.l(11, r8.getInitiator())) + VoteMessageType.ADAPTER.l(12, r8.getVote_message_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, VoteContent r7) {
            VoteContent r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r6, 1, r8.getUuid());
            w r1 = ProtoAdapter.q;
            r1.i(r6, 2, r8.getScope_id());
            VoteScopeType.ADAPTER.i(r6, 3, r8.getScope_type());
            VoteContainerType.ADAPTER.i(r6, 4, r8.getContainer_type());
            r1.i(r6, 5, r8.getTopic());
            r0.i(r6, 6, r8.getMin_pick_num());
            r0.i(r6, 7, r8.getMax_pick_num());
            ProtoAdapter.g.i(r6, 8, r8.is_public());
            VoteOption.ADAPTER.a().i(r6, 9, r8.getOptions());
            VoteStatus.ADAPTER.i(r6, 10, r8.getStatus());
            r0.i(r6, 11, r8.getInitiator());
            VoteMessageType.ADAPTER.i(r6, 12, r8.getVote_message_type());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, VoteContent r7) {
            VoteContent r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            VoteMessageType.ADAPTER.j(r6, 12, r8.getVote_message_type());
            t r0 = ProtoAdapter.k;
            r0.j(r6, 11, r8.getInitiator());
            VoteStatus.ADAPTER.j(r6, 10, r8.getStatus());
            VoteOption.ADAPTER.a().j(r6, 9, r8.getOptions());
            ProtoAdapter.g.j(r6, 8, r8.is_public());
            r0.j(r6, 7, r8.getMax_pick_num());
            r0.j(r6, 6, r8.getMin_pick_num());
            w r1 = ProtoAdapter.q;
            r1.j(r6, 5, r8.getTopic());
            VoteContainerType.ADAPTER.j(r6, 4, r8.getContainer_type());
            VoteScopeType.ADAPTER.j(r6, 3, r8.getScope_type());
            r1.j(r6, 2, r8.getScope_id());
            r0.j(r6, 1, r8.getUuid());
        }

        public b(FieldEncoding r7, KClass<VoteContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/vote.v1.VoteContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VoteContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VoteContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.uuid;
        r0.e = this.scope_id;
        r0.f = this.scope_type;
        r0.g = this.container_type;
        r0.h = this.topic;
        r0.i = this.min_pick_num;
        r0.j = this.max_pick_num;
        r0.k = this.is_public;
        r0.l = this.options;
        r0.m = this.status;
        r0.n = this.initiator;
        r0.o = this.vote_message_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VoteContent.class).getSimpleName() + '@' + hashCode();
    }

    public final VoteContainerType getContainer_type() {
        return this.container_type;
    }

    public final Long getInitiator() {
        return this.initiator;
    }

    public final Long getMax_pick_num() {
        return this.max_pick_num;
    }

    public final Long getMin_pick_num() {
        return this.min_pick_num;
    }

    public final List<VoteOption> getOptions() {
        return this.options;
    }

    public final String getScope_id() {
        return this.scope_id;
    }

    public final VoteScopeType getScope_type() {
        return this.scope_type;
    }

    public final VoteStatus getStatus() {
        return this.status;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final Long getUuid() {
        return this.uuid;
    }

    public final VoteMessageType getVote_message_type() {
        return this.vote_message_type;
    }

    public final Boolean is_public() {
        return this.is_public;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public VoteContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.uuid = r2.d;
        this.scope_id = r2.e;
        this.scope_type = r2.f;
        this.container_type = r2.g;
        this.topic = r2.h;
        this.min_pick_num = r2.i;
        this.max_pick_num = r2.j;
        this.is_public = r2.k;
        this.options = com.lark.wire.internal.a.c("options", r2.l);
        this.status = r2.m;
        this.initiator = r2.n;
        this.vote_message_type = r2.o;
    }

    public /* synthetic */ VoteContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
