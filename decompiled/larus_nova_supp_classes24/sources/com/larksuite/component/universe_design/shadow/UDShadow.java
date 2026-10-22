package com.larksuite.component.universe_design.shadow;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Deprecated(message = "请使用 UDShadowLayout", replaceWith = @ReplaceWith(expression = "UDShadowLayout", imports = {}))
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\b\u0087\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadow;", "", "value", "", "alpha", "", "size", "offsetX", "offsetY", "<init>", "(Ljava/lang/String;IIFIII)V", "getValue", "()I", "getAlpha", "()F", "getSize", "getOffsetX", "getOffsetY", "NONE", "S_UP", "S_DOWN", "S_LEFT", "S_RIGHT", "M_UP", "M_DOWN", "M_LEFT", "M_RIGHT", "L_UP", "L_DOWN", "L_LEFT", "L_RIGHT", "Companion", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDShadow extends Enum<UDShadow> {
    public static final a Companion = null;
    public static final UDShadow L_DOWN = null;
    public static final UDShadow L_LEFT = null;
    public static final UDShadow L_RIGHT = null;
    public static final UDShadow L_UP = null;
    public static final UDShadow M_DOWN = null;
    public static final UDShadow M_LEFT = null;
    public static final UDShadow M_RIGHT = null;
    public static final UDShadow M_UP = null;
    public static final UDShadow NONE = null;
    public static final UDShadow S_DOWN = null;
    public static final UDShadow S_LEFT = null;
    public static final UDShadow S_RIGHT = null;
    public static final UDShadow S_UP = null;
    public static final /* synthetic */ UDShadow[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final float alpha;
    private final int offsetX;
    private final int offsetY;
    private final int size;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<UDShadow> getEntries() {
        return b;
    }

    static {
        UDShadow r8 = new UDShadow("NONE", 0, 0, 0.0f, 0, 0, 0);
        NONE = r8;
        UDShadow r0 = new UDShadow("S_UP", 1, 1, 0.12f, 4, 0, -2);
        S_UP = r0;
        UDShadow r1 = new UDShadow("S_DOWN", 2, 2, 0.12f, 4, 0, 2);
        S_DOWN = r1;
        UDShadow r4 = new UDShadow("S_LEFT", 3, 3, 0.12f, 4, -2, 0);
        S_LEFT = r4;
        UDShadow r5 = new UDShadow("S_RIGHT", 4, 4, 0.12f, 4, 2, 0);
        S_RIGHT = r5;
        UDShadow r2 = new UDShadow("M_UP", 5, 5, 0.1f, 8, 0, -4);
        M_UP = r2;
        UDShadow r3 = new UDShadow("M_DOWN", 6, 6, 0.1f, 8, 0, 4);
        M_DOWN = r3;
        UDShadow r6 = new UDShadow("M_LEFT", 7, 7, 0.1f, 8, -4, 0);
        M_LEFT = r6;
        UDShadow r7 = new UDShadow("M_RIGHT", 8, 8, 0.1f, 8, -4, 0);
        M_RIGHT = r7;
        UDShadow r9 = new UDShadow("L_UP", 9, 9, 0.08f, 24, 0, -6);
        L_UP = r9;
        UDShadow r10 = new UDShadow("L_DOWN", 10, 10, 0.08f, 24, 0, 6);
        L_DOWN = r10;
        UDShadow r19 = new UDShadow("L_LEFT", 11, 11, 0.08f, 24, -6, 0);
        L_LEFT = r19;
        UDShadow r20 = new UDShadow("L_RIGHT", 12, 12, 0.08f, 24, 6, 0);
        L_RIGHT = r20;
        UDShadow[] r11 = {r8, r0, r1, r4, r5, r2, r3, r6, r7, r9, r10, r19, r20};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static UDShadow[] values() {
        return (UDShadow[]) a.clone();
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getOffsetX() {
        return this.offsetX;
    }

    public final int getOffsetY() {
        return this.offsetY;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final UDShadow of(int r3) {
        Companion.getClass();
        switch(r3) {
            case 0: goto L19;
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
            case 12: goto L20;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("no shadow for value " + r3);
    L20:
        return L_RIGHT;
    L21:
        return L_LEFT;
    L22:
        return L_DOWN;
    L23:
        return L_UP;
    L24:
        return M_RIGHT;
    L25:
        return M_LEFT;
    L26:
        return M_DOWN;
    L27:
        return M_UP;
    L28:
        return S_RIGHT;
    L29:
        return S_LEFT;
    L30:
        return S_DOWN;
    L31:
        return S_UP;
    L19:
        return NONE;
    }

    public static UDShadow valueOf(String r1) {
        return (UDShadow) r27.a.a(UDShadow.class, r1);
    }

    public UDShadow(String r1, int r2, int r3, float r4, int r5, int r6, int r7) {
        super(r1, r2);
        this.value = r3;
        this.alpha = r4;
        this.size = r5;
        this.offsetX = r6;
        this.offsetY = r7;
    }
}
