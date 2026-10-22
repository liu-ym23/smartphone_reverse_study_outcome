package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventCrossLanguageInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventCrossLanguageInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventCrossLanguageInfo$Builder;Lokio/ByteString;)V", "language_type", "Lcom/lark/kmp/pb/calendar/v1/EventCrossLanguageType;", "getLanguage_type", "()Lcom/lark/kmp/pb/calendar/v1/EventCrossLanguageType;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EventCrossLanguageInfo extends Message<EventCrossLanguageInfo, a> {
    public static final ProtoAdapter<EventCrossLanguageInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final EventCrossLanguageType language_type;

    public static final class a extends Message.a<EventCrossLanguageInfo, a> {
        public EventCrossLanguageType d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new EventCrossLanguageInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EventCrossLanguageInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final EventCrossLanguageInfo c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L11;
            r0.d = EventCrossLanguageType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L13:
            return new EventCrossLanguageInfo(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EventCrossLanguageInfo r4) {
            EventCrossLanguageInfo r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + EventCrossLanguageType.ADAPTER.l(1, r5.getLanguage_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, EventCrossLanguageInfo r5) {
            EventCrossLanguageInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            EventCrossLanguageType.ADAPTER.i(r4, 1, r6.getLanguage_type());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, EventCrossLanguageInfo r4) {
            EventCrossLanguageInfo r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            EventCrossLanguageType.ADAPTER.j(r3, 1, r5.getLanguage_type());
        }

        public b(FieldEncoding r7, KClass<EventCrossLanguageInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.EventCrossLanguageInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EventCrossLanguageInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EventCrossLanguageInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.language_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EventCrossLanguageInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final EventCrossLanguageType getLanguage_type() {
        return this.language_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public EventCrossLanguageInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.language_type = r2.d;
    }

    public /* synthetic */ EventCrossLanguageInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
