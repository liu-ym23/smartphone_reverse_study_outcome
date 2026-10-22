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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/WebinarAttendeeType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Speaker", "Audience", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum WebinarAttendeeType extends Enum<WebinarAttendeeType> implements o0 {
    public static final ProtoAdapter<WebinarAttendeeType> ADAPTER = null;
    public static final WebinarAttendeeType Audience = null;
    public static final b Companion = null;
    public static final WebinarAttendeeType Speaker = null;
    public static final WebinarAttendeeType Unknown = null;
    public static final /* synthetic */ WebinarAttendeeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<WebinarAttendeeType> getEntries() {
        return b;
    }

    static {
        final WebinarAttendeeType r0 = new WebinarAttendeeType("Unknown", 0, 0);
        Unknown = r0;
        WebinarAttendeeType r1 = new WebinarAttendeeType("Speaker", 1, 1);
        Speaker = r1;
        WebinarAttendeeType r3 = new WebinarAttendeeType("Audience", 2, 2);
        Audience = r3;
        WebinarAttendeeType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(WebinarAttendeeType.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static WebinarAttendeeType[] values() {
        return (WebinarAttendeeType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final WebinarAttendeeType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return Audience;
    L15:
        return Speaker;
    L12:
        return Unknown;
    }

    public static WebinarAttendeeType valueOf(String r1) {
        return (WebinarAttendeeType) r27.a.a(WebinarAttendeeType.class, r1);
    }

    public WebinarAttendeeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
