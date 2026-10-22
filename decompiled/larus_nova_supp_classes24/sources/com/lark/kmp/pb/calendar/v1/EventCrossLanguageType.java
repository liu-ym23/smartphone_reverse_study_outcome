package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventCrossLanguageType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "ALL_CHINESE", "ALL_NON_CHINESE", "LEAST_ONE_CHINESE_AND_NON_CHINESE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum EventCrossLanguageType extends Enum<EventCrossLanguageType> implements o0 {
    public static final ProtoAdapter<EventCrossLanguageType> ADAPTER = null;
    public static final EventCrossLanguageType ALL_CHINESE = null;
    public static final EventCrossLanguageType ALL_NON_CHINESE = null;
    public static final b Companion = null;
    public static final EventCrossLanguageType LEAST_ONE_CHINESE_AND_NON_CHINESE = null;
    public static final EventCrossLanguageType TYPE_UNKNOWN = null;
    public static final /* synthetic */ EventCrossLanguageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<EventCrossLanguageType> getEntries() {
        return b;
    }

    static {
        final EventCrossLanguageType r0 = new EventCrossLanguageType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r0;
        EventCrossLanguageType r1 = new EventCrossLanguageType("ALL_CHINESE", 1, 1);
        ALL_CHINESE = r1;
        EventCrossLanguageType r3 = new EventCrossLanguageType("ALL_NON_CHINESE", 2, 2);
        ALL_NON_CHINESE = r3;
        EventCrossLanguageType r5 = new EventCrossLanguageType("LEAST_ONE_CHINESE_AND_NON_CHINESE", 3, 3);
        LEAST_ONE_CHINESE_AND_NON_CHINESE = r5;
        EventCrossLanguageType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(EventCrossLanguageType.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static EventCrossLanguageType[] values() {
        return (EventCrossLanguageType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EventCrossLanguageType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return LEAST_ONE_CHINESE_AND_NON_CHINESE;
    L18:
        return ALL_NON_CHINESE;
    L19:
        return ALL_CHINESE;
    L15:
        return TYPE_UNKNOWN;
    }

    public static EventCrossLanguageType valueOf(String r1) {
        return (EventCrossLanguageType) r27.a.a(EventCrossLanguageType.class, r1);
    }

    public EventCrossLanguageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
