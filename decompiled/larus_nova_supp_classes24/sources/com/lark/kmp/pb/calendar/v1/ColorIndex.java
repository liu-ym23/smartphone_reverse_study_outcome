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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ColorIndex;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CARMINE", "RED", "ORANGE", "YELLOW", "GREEN", "TURQUOISE", "BLUE", "WATHET", "INDIGO", "PURPLE", "VIOLET", "NEUTRAL", "NONE_COLOR", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ColorIndex extends Enum<ColorIndex> implements o0 {
    public static final ProtoAdapter<ColorIndex> ADAPTER = null;
    public static final ColorIndex BLUE = null;
    public static final ColorIndex CARMINE = null;
    public static final b Companion = null;
    public static final ColorIndex GREEN = null;
    public static final ColorIndex INDIGO = null;
    public static final ColorIndex NEUTRAL = null;
    public static final ColorIndex NONE_COLOR = null;
    public static final ColorIndex ORANGE = null;
    public static final ColorIndex PURPLE = null;
    public static final ColorIndex RED = null;
    public static final ColorIndex TURQUOISE = null;
    public static final ColorIndex VIOLET = null;
    public static final ColorIndex WATHET = null;
    public static final ColorIndex YELLOW = null;
    public static final /* synthetic */ ColorIndex[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static ColorIndex a(int r1) {
            if (r1 == 99) goto L19;
            switch(r1) {
                case 0: goto L32;
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                default: goto L5;
            };
        L5:
            return null;
        L21:
            return ColorIndex.NEUTRAL;
        L22:
            return ColorIndex.VIOLET;
        L23:
            return ColorIndex.PURPLE;
        L24:
            return ColorIndex.INDIGO;
        L25:
            return ColorIndex.WATHET;
        L26:
            return ColorIndex.BLUE;
        L27:
            return ColorIndex.TURQUOISE;
        L28:
            return ColorIndex.GREEN;
        L29:
            return ColorIndex.YELLOW;
        L30:
            return ColorIndex.ORANGE;
        L31:
            return ColorIndex.RED;
        L32:
            return ColorIndex.CARMINE;
        L19:
            return ColorIndex.NONE_COLOR;
        }
    }

    @JvmStatic
    public static final ColorIndex fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<ColorIndex> getEntries() {
        return b;
    }

    static {
        final ColorIndex r0 = new ColorIndex("CARMINE", 0, 0);
        CARMINE = r0;
        ColorIndex r1 = new ColorIndex("RED", 1, 1);
        RED = r1;
        ColorIndex r3 = new ColorIndex("ORANGE", 2, 2);
        ORANGE = r3;
        ColorIndex r5 = new ColorIndex("YELLOW", 3, 3);
        YELLOW = r5;
        ColorIndex r7 = new ColorIndex("GREEN", 4, 4);
        GREEN = r7;
        ColorIndex r9 = new ColorIndex("TURQUOISE", 5, 5);
        TURQUOISE = r9;
        ColorIndex r11 = new ColorIndex("BLUE", 6, 6);
        BLUE = r11;
        ColorIndex r13 = new ColorIndex("WATHET", 7, 7);
        WATHET = r13;
        ColorIndex r15 = new ColorIndex("INDIGO", 8, 8);
        INDIGO = r15;
        ColorIndex r14 = new ColorIndex("PURPLE", 9, 9);
        PURPLE = r14;
        ColorIndex r12 = new ColorIndex("VIOLET", 10, 10);
        VIOLET = r12;
        ColorIndex r10 = new ColorIndex("NEUTRAL", 11, 11);
        NEUTRAL = r10;
        ColorIndex r8 = new ColorIndex("NONE_COLOR", 12, 99);
        NONE_COLOR = r8;
        ColorIndex[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new b();
        final KClass r4 = Reflection.getOrCreateKotlinClass(ColorIndex.class);
        final Syntax r6 = Syntax.PROTO_2;
        ADAPTER = new a(r4, r6, r0);
    }

    public static ColorIndex[] values() {
        return (ColorIndex[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static ColorIndex valueOf(String r1) {
        return (ColorIndex) r27.a.a(ColorIndex.class, r1);
    }

    public ColorIndex(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
