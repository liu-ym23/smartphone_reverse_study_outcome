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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/WorkHourSpan;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/WorkHourSpan$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/WorkHourSpan$Builder;Lokio/ByteString;)V", "start_minute", "", "getStart_minute", "()I", "end_minute", "getEnd_minute", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkHourSpan extends Message<WorkHourSpan, a> {
    public static final ProtoAdapter<WorkHourSpan> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final int end_minute;
    private final int start_minute;

    public static final class a extends Message.a<WorkHourSpan, a> {
        public Integer d;
        public Integer e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new WorkHourSpan(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<WorkHourSpan> {
        @Override // com.lark.wire.ProtoAdapter
        public final WorkHourSpan c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L8;
            r0.d = Integer.valueOf(((Number) ProtoAdapter.h.c(r6)).intValue());
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = Integer.valueOf(((Number) ProtoAdapter.h.c(r6)).intValue());
            goto L3
        L9:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            return new WorkHourSpan(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(WorkHourSpan r5) {
            WorkHourSpan r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            s r1 = ProtoAdapter.h;
            return (r0 + r1.l(1, Integer.valueOf(r6.getStart_minute()))) + r1.l(2, Integer.valueOf(r6.getEnd_minute()));
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, WorkHourSpan r5) {
            WorkHourSpan r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            s r0 = ProtoAdapter.h;
            r0.i(r4, 1, Integer.valueOf(r6.getStart_minute()));
            r0.i(r4, 2, Integer.valueOf(r6.getEnd_minute()));
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, WorkHourSpan r5) {
            WorkHourSpan r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            s r0 = ProtoAdapter.h;
            r0.j(r4, 2, Integer.valueOf(r6.getEnd_minute()));
            r0.j(r4, 1, Integer.valueOf(r6.getStart_minute()));
        }

        public b(FieldEncoding r7, KClass<WorkHourSpan> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.WorkHourSpan", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ WorkHourSpan(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(WorkHourSpan.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = Integer.valueOf(this.start_minute);
        r0.e = Integer.valueOf(this.end_minute);
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(WorkHourSpan.class).getSimpleName() + '@' + hashCode();
    }

    public final int getEnd_minute() {
        return this.end_minute;
    }

    public final int getStart_minute() {
        return this.start_minute;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public WorkHourSpan(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Integer r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.start_minute = r4.intValue();
        Integer r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.end_minute = r5.intValue();
    }

    public /* synthetic */ WorkHourSpan(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
