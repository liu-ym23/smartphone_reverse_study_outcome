package com.lark.kmp.server.pb.improto;

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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/server/pb/improto/PayloadType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "PB2", "JSON", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum PayloadType extends Enum<PayloadType> implements o0 {
    public static final ProtoAdapter<PayloadType> ADAPTER = null;
    public static final b Companion = null;
    public static final PayloadType JSON = null;
    public static final PayloadType PB2 = null;
    public static final PayloadType TYPE_UNKNOWN = null;
    public static final /* synthetic */ PayloadType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<PayloadType> getEntries() {
        return b;
    }

    static {
        final PayloadType r0 = new PayloadType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r0;
        PayloadType r1 = new PayloadType("PB2", 1, 1);
        PB2 = r1;
        PayloadType r3 = new PayloadType("JSON", 2, 2);
        JSON = r3;
        PayloadType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(PayloadType.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static PayloadType[] values() {
        return (PayloadType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final PayloadType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return JSON;
    L15:
        return PB2;
    L12:
        return TYPE_UNKNOWN;
    }

    public static PayloadType valueOf(String r1) {
        return (PayloadType) r27.a.a(PayloadType.class, r1);
    }

    public PayloadType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
