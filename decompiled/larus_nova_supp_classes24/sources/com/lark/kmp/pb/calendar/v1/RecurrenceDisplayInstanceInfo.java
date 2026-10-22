package com.lark.kmp.pb.calendar.v1;

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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/RecurrenceDisplayInstanceInfo$Builder;Lokio/ByteString;)V", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "original_time", "getOriginal_time", "is_all_day", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RecurrenceDisplayInstanceInfo extends Message<RecurrenceDisplayInstanceInfo, a> {
    public static final ProtoAdapter<RecurrenceDisplayInstanceInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long end_time;
    private final Boolean is_all_day;
    private final Long original_time;
    private final Long start_time;

    public static final class a extends Message.a<RecurrenceDisplayInstanceInfo, a> {
        public Long d;
        public Long e;
        public Long f;
        public Boolean g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new RecurrenceDisplayInstanceInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<RecurrenceDisplayInstanceInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final RecurrenceDisplayInstanceInfo c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.g = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L13:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L19:
            return new RecurrenceDisplayInstanceInfo(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(RecurrenceDisplayInstanceInfo r5) {
            RecurrenceDisplayInstanceInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return (((r0 + r1.l(1, r6.getStart_time())) + r1.l(2, r6.getEnd_time())) + r1.l(3, r6.getOriginal_time())) + ProtoAdapter.g.l(4, r6.is_all_day());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, RecurrenceDisplayInstanceInfo r5) {
            RecurrenceDisplayInstanceInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r4, 1, r6.getStart_time());
            r0.i(r4, 2, r6.getEnd_time());
            r0.i(r4, 3, r6.getOriginal_time());
            ProtoAdapter.g.i(r4, 4, r6.is_all_day());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, RecurrenceDisplayInstanceInfo r5) {
            RecurrenceDisplayInstanceInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 4, r6.is_all_day());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 3, r6.getOriginal_time());
            r0.j(r4, 2, r6.getEnd_time());
            r0.j(r4, 1, r6.getStart_time());
        }

        public b(FieldEncoding r7, KClass<RecurrenceDisplayInstanceInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.RecurrenceDisplayInstanceInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ RecurrenceDisplayInstanceInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RecurrenceDisplayInstanceInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.start_time;
        r0.e = this.end_time;
        r0.f = this.original_time;
        r0.g = this.is_all_day;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RecurrenceDisplayInstanceInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final Long getOriginal_time() {
        return this.original_time;
    }

    public final Long getStart_time() {
        return this.start_time;
    }

    public final Boolean is_all_day() {
        return this.is_all_day;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public RecurrenceDisplayInstanceInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.start_time = r2.d;
        this.end_time = r2.e;
        this.original_time = r2.f;
        this.is_all_day = r2.g;
    }

    public /* synthetic */ RecurrenceDisplayInstanceInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
