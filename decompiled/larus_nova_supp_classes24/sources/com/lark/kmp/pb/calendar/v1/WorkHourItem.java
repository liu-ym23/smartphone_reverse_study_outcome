package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/WorkHourItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/WorkHourItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/WorkHourItem$Builder;Lokio/ByteString;)V", "spans", "", "Lcom/lark/kmp/pb/calendar/v1/WorkHourSpan;", "getSpans", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkHourItem extends Message<WorkHourItem, a> {
    public static final ProtoAdapter<WorkHourItem> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<WorkHourSpan> spans;

    public static final class a extends Message.a<WorkHourItem, a> {
        public List<WorkHourSpan> d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new WorkHourItem(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<WorkHourItem> {
        @Override // com.lark.wire.ProtoAdapter
        public final WorkHourItem c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L9;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            r1.add(WorkHourSpan.ADAPTER.c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "spans");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new WorkHourItem(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(WorkHourItem r4) {
            WorkHourItem r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + WorkHourSpan.ADAPTER.a().l(1, r5.getSpans());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, WorkHourItem r5) {
            WorkHourItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            WorkHourSpan.ADAPTER.a().i(r4, 1, r6.getSpans());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, WorkHourItem r4) {
            WorkHourItem r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            WorkHourSpan.ADAPTER.a().j(r3, 1, r5.getSpans());
        }

        public b(FieldEncoding r7, KClass<WorkHourItem> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.WorkHourItem", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ WorkHourItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(WorkHourItem.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.spans;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(WorkHourItem.class).getSimpleName() + '@' + hashCode();
    }

    public final List<WorkHourSpan> getSpans() {
        return this.spans;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public WorkHourItem(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.spans = com.lark.wire.internal.a.c("spans", r2.d);
    }

    public /* synthetic */ WorkHourItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
