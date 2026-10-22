package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/WorkHourSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/WorkHourSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/WorkHourSetting$Builder;Lokio/ByteString;)V", "enable_work_hour", "", "getEnable_work_hour", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "work_hour_items", "", "", "Lcom/lark/kmp/pb/calendar/v1/WorkHourItem;", "getWork_hour_items", "()Ljava/util/Map;", "is_first_set", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkHourSetting extends Message<WorkHourSetting, a> {
    public static final ProtoAdapter<WorkHourSetting> ADAPTER = null;
    public static final b Companion = null;
    public static final boolean DEFAULT_ENABLE_WORK_HOUR = false;
    public static final boolean DEFAULT_IS_FIRST_SET = true;
    private static final long serialVersionUID = 0;
    private final Boolean enable_work_hour;
    private final Boolean is_first_set;
    private final Map<String, WorkHourItem> work_hour_items;

    public static final class a extends Message.a<WorkHourSetting, a> {
        public Boolean d;
        public Map<String, WorkHourItem> e;
        public Boolean f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new WorkHourSetting(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ WorkHourSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(WorkHourSetting.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new WorkHourSetting$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.enable_work_hour;
        r0.e = this.work_hour_items;
        r0.f = this.is_first_set;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(WorkHourSetting.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getEnable_work_hour() {
        return this.enable_work_hour;
    }

    public final Map<String, WorkHourItem> getWork_hour_items() {
        return this.work_hour_items;
    }

    public final Boolean is_first_set() {
        return this.is_first_set;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public WorkHourSetting(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.enable_work_hour = r2.d;
        this.work_hour_items = com.lark.wire.internal.a.d("work_hour_items", r2.e);
        this.is_first_set = r2.f;
    }

    public /* synthetic */ WorkHourSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
