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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/MappingColor;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/MappingColor$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/MappingColor$Builder;Lokio/ByteString;)V", "background_color", "", "getBackground_color", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "foreground_color", "getForeground_color", "event_card_color", "getEvent_card_color", "event_color_index", "", "getEvent_color_index", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MappingColor extends Message<MappingColor, a> {
    public static final ProtoAdapter<MappingColor> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer background_color;
    private final Integer event_card_color;
    private final String event_color_index;
    private final Integer foreground_color;

    public static final class a extends Message.a<MappingColor, a> {
        public Integer d;
        public Integer e;
        public Integer f;
        public String g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new MappingColor(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MappingColor> {
        @Override // com.lark.wire.ProtoAdapter
        public final MappingColor c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            r1.d = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new MappingColor(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MappingColor r5) {
            MappingColor r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            s r1 = ProtoAdapter.h;
            return (((r0 + r1.l(1, r6.getBackground_color())) + r1.l(2, r6.getForeground_color())) + r1.l(3, r6.getEvent_card_color())) + ProtoAdapter.q.l(4, r6.getEvent_color_index());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MappingColor r5) {
            MappingColor r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            s r0 = ProtoAdapter.h;
            r0.i(r4, 1, r6.getBackground_color());
            r0.i(r4, 2, r6.getForeground_color());
            r0.i(r4, 3, r6.getEvent_card_color());
            ProtoAdapter.q.i(r4, 4, r6.getEvent_color_index());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MappingColor r5) {
            MappingColor r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.j(r4, 4, r6.getEvent_color_index());
            s r0 = ProtoAdapter.h;
            r0.j(r4, 3, r6.getEvent_card_color());
            r0.j(r4, 2, r6.getForeground_color());
            r0.j(r4, 1, r6.getBackground_color());
        }

        public b(FieldEncoding r7, KClass<MappingColor> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.MappingColor", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MappingColor(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MappingColor.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.background_color;
        r0.e = this.foreground_color;
        r0.f = this.event_card_color;
        r0.g = this.event_color_index;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MappingColor.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getBackground_color() {
        return this.background_color;
    }

    public final Integer getEvent_card_color() {
        return this.event_card_color;
    }

    public final String getEvent_color_index() {
        return this.event_color_index;
    }

    public final Integer getForeground_color() {
        return this.foreground_color;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public MappingColor(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.background_color = r2.d;
        this.foreground_color = r2.e;
        this.event_card_color = r2.f;
        this.event_color_index = r2.g;
    }

    public /* synthetic */ MappingColor(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
