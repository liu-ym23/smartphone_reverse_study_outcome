package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventAttendeeInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventAttendeeInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventAttendeeInfo$Builder;Lokio/ByteString;)V", "total_no", "", "getTotal_no", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "accept_no", "getAccept_no", "decline_no", "getDecline_no", "tentative_no", "getTentative_no", "need_action_no", "getNeed_action_no", "all_individual_attendee", "", "getAll_individual_attendee", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "snapshot_page_token", "", "getSnapshot_page_token", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EventAttendeeInfo extends Message<EventAttendeeInfo, a> {
    public static final ProtoAdapter<EventAttendeeInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer accept_no;
    private final Boolean all_individual_attendee;
    private final Integer decline_no;
    private final Integer need_action_no;
    private final String snapshot_page_token;
    private final Integer tentative_no;
    private final Integer total_no;

    public static final class a extends Message.a<EventAttendeeInfo, a> {
        public Integer d;
        public Integer e;
        public Integer f;
        public Integer g;
        public Integer h;
        public Boolean i;
        public String j;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new EventAttendeeInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EventAttendeeInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final EventAttendeeInfo c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L15;
            switch(r4) {
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
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.j = r7.i();
            goto L3
        L8:
            r1.i = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L9:
            r1.h = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L10:
            r1.g = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L11:
            r1.f = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L12:
            r1.e = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L13:
            r1.d = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L6:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L15:
            return new EventAttendeeInfo(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EventAttendeeInfo r5) {
            EventAttendeeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            s r1 = ProtoAdapter.h;
            return ((((((r0 + r1.l(1, r6.getTotal_no())) + r1.l(2, r6.getAccept_no())) + r1.l(3, r6.getDecline_no())) + r1.l(4, r6.getTentative_no())) + r1.l(5, r6.getNeed_action_no())) + ProtoAdapter.g.l(6, r6.getAll_individual_attendee())) + ProtoAdapter.q.l(7, r6.getSnapshot_page_token());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, EventAttendeeInfo r5) {
            EventAttendeeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            s r0 = ProtoAdapter.h;
            r0.i(r4, 1, r6.getTotal_no());
            r0.i(r4, 2, r6.getAccept_no());
            r0.i(r4, 3, r6.getDecline_no());
            r0.i(r4, 4, r6.getTentative_no());
            r0.i(r4, 5, r6.getNeed_action_no());
            ProtoAdapter.g.i(r4, 6, r6.getAll_individual_attendee());
            ProtoAdapter.q.i(r4, 7, r6.getSnapshot_page_token());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, EventAttendeeInfo r5) {
            EventAttendeeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.j(r4, 7, r6.getSnapshot_page_token());
            ProtoAdapter.g.j(r4, 6, r6.getAll_individual_attendee());
            s r0 = ProtoAdapter.h;
            r0.j(r4, 5, r6.getNeed_action_no());
            r0.j(r4, 4, r6.getTentative_no());
            r0.j(r4, 3, r6.getDecline_no());
            r0.j(r4, 2, r6.getAccept_no());
            r0.j(r4, 1, r6.getTotal_no());
        }

        public b(FieldEncoding r7, KClass<EventAttendeeInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.EventAttendeeInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EventAttendeeInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EventAttendeeInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.total_no;
        r0.e = this.accept_no;
        r0.f = this.decline_no;
        r0.g = this.tentative_no;
        r0.h = this.need_action_no;
        r0.i = this.all_individual_attendee;
        r0.j = this.snapshot_page_token;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EventAttendeeInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getAccept_no() {
        return this.accept_no;
    }

    public final Boolean getAll_individual_attendee() {
        return this.all_individual_attendee;
    }

    public final Integer getDecline_no() {
        return this.decline_no;
    }

    public final Integer getNeed_action_no() {
        return this.need_action_no;
    }

    public final String getSnapshot_page_token() {
        return this.snapshot_page_token;
    }

    public final Integer getTentative_no() {
        return this.tentative_no;
    }

    public final Integer getTotal_no() {
        return this.total_no;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public EventAttendeeInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.total_no = r2.d;
        this.accept_no = r2.e;
        this.decline_no = r2.f;
        this.tentative_no = r2.g;
        this.need_action_no = r2.h;
        this.all_individual_attendee = r2.i;
        this.snapshot_page_token = r2.j;
    }

    public /* synthetic */ EventAttendeeInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
