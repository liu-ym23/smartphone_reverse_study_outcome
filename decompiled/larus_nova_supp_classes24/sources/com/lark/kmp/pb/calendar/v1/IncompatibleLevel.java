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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/IncompatibleLevel;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SHOW_HINT", "DISABLE_EDIT", "DISABLE_READ", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum IncompatibleLevel extends Enum<IncompatibleLevel> implements o0 {
    public static final ProtoAdapter<IncompatibleLevel> ADAPTER = null;
    public static final b Companion = null;
    public static final IncompatibleLevel DISABLE_EDIT = null;
    public static final IncompatibleLevel DISABLE_READ = null;
    public static final IncompatibleLevel SHOW_HINT = null;
    public static final /* synthetic */ IncompatibleLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<IncompatibleLevel> getEntries() {
        return b;
    }

    static {
        IncompatibleLevel r0 = new IncompatibleLevel("SHOW_HINT", 0, 1);
        SHOW_HINT = r0;
        IncompatibleLevel r1 = new IncompatibleLevel("DISABLE_EDIT", 1, 2);
        DISABLE_EDIT = r1;
        IncompatibleLevel r4 = new IncompatibleLevel("DISABLE_READ", 2, 3);
        DISABLE_READ = r4;
        IncompatibleLevel[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(IncompatibleLevel.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static IncompatibleLevel[] values() {
        return (IncompatibleLevel[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final IncompatibleLevel fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return null;
    L14:
        return DISABLE_READ;
    L15:
        return DISABLE_EDIT;
    L12:
        return SHOW_HINT;
    }

    public static IncompatibleLevel valueOf(String r1) {
        return (IncompatibleLevel) r27.a.a(IncompatibleLevel.class, r1);
    }

    public IncompatibleLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
