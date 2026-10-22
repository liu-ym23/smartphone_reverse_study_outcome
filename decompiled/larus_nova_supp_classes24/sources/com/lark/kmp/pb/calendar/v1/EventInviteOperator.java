package com.lark.kmp.pb.calendar.v1;

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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventInviteOperator;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventInviteOperator$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventInviteOperator$Builder;Lokio/ByteString;)V", "user_invite_operator_id", "", "getUser_invite_operator_id", "()Ljava/lang/String;", "user_invite_operator_localized_name", "getUser_invite_operator_localized_name", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EventInviteOperator extends Message<EventInviteOperator, a> {
    public static final ProtoAdapter<EventInviteOperator> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_USER_INVITE_OPERATOR_ID = "";
    public static final String DEFAULT_USER_INVITE_OPERATOR_LOCALIZED_NAME = "";
    private static final long serialVersionUID = 0;
    private final String user_invite_operator_id;
    private final String user_invite_operator_localized_name;

    public static final class a extends Message.a<EventInviteOperator, a> {
        public String d;
        public String e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new EventInviteOperator(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EventInviteOperator> {
        @Override // com.lark.wire.ProtoAdapter
        public final EventInviteOperator c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L13;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L9;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L9:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L13:
            return new EventInviteOperator(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EventInviteOperator r5) {
            EventInviteOperator r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (r0 + r1.l(1, r6.getUser_invite_operator_id())) + r1.l(2, r6.getUser_invite_operator_localized_name());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, EventInviteOperator r5) {
            EventInviteOperator r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getUser_invite_operator_id());
            r0.i(r4, 2, r6.getUser_invite_operator_localized_name());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, EventInviteOperator r5) {
            EventInviteOperator r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getUser_invite_operator_localized_name());
            r0.j(r4, 1, r6.getUser_invite_operator_id());
        }

        public b(FieldEncoding r7, KClass<EventInviteOperator> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.EventInviteOperator", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EventInviteOperator(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EventInviteOperator.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.user_invite_operator_id;
        r0.e = this.user_invite_operator_localized_name;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EventInviteOperator.class).getSimpleName() + '@' + hashCode();
    }

    public final String getUser_invite_operator_id() {
        return this.user_invite_operator_id;
    }

    public final String getUser_invite_operator_localized_name() {
        return this.user_invite_operator_localized_name;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public EventInviteOperator(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.user_invite_operator_id = r2.d;
        this.user_invite_operator_localized_name = r2.e;
    }

    public /* synthetic */ EventInviteOperator(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
