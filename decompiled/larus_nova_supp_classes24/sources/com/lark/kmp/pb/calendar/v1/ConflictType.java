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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "NORMAL", "RECURRENCE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ConflictType extends Enum<ConflictType> implements o0 {
    public static final ProtoAdapter<ConflictType> ADAPTER = null;
    public static final b Companion = null;
    public static final ConflictType NONE = null;
    public static final ConflictType NORMAL = null;
    public static final ConflictType RECURRENCE = null;
    public static final /* synthetic */ ConflictType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<ConflictType> getEntries() {
        return b;
    }

    static {
        ConflictType r0 = new ConflictType("NONE", 0, 1);
        NONE = r0;
        ConflictType r1 = new ConflictType("NORMAL", 1, 2);
        NORMAL = r1;
        ConflictType r4 = new ConflictType("RECURRENCE", 2, 3);
        RECURRENCE = r4;
        ConflictType[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(ConflictType.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static ConflictType[] values() {
        return (ConflictType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ConflictType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return null;
    L14:
        return RECURRENCE;
    L15:
        return NORMAL;
    L12:
        return NONE;
    }

    public static ConflictType valueOf(String r1) {
        return (ConflictType) r27.a.a(ConflictType.class, r1);
    }

    public ConflictType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
