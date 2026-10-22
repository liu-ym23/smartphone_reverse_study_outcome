package com.larksuite.component.universe_design.radius;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/universe_design/radius/UDRadius;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "XS", "S", "M", "L", "XL", "XXL", "ROUND", "getRadiusSize", "context", "Landroid/content/Context;", "Companion", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDRadius extends Enum<UDRadius> {
    public static final a Companion = null;
    public static final UDRadius L = null;
    public static final UDRadius M = null;
    public static final UDRadius NONE = null;
    public static final UDRadius ROUND = null;
    public static final UDRadius S = null;
    public static final UDRadius XL = null;
    public static final UDRadius XS = null;
    public static final UDRadius XXL = null;
    public static final /* synthetic */ UDRadius[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static UDRadius a(int r3) {
            switch(r3) {
                case 0: goto L13;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L4;
            };
        L4:
            throw new IllegalArgumentException("no radius for value " + r3 + '!');
        L14:
            return UDRadius.ROUND;
        L15:
            return UDRadius.XXL;
        L16:
            return UDRadius.XL;
        L17:
            return UDRadius.L;
        L18:
            return UDRadius.M;
        L19:
            return UDRadius.S;
        L20:
            return UDRadius.XS;
        L13:
            return UDRadius.NONE;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UDRadius.values().length];
            r0[UDRadius.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[UDRadius.XS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[UDRadius.S.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[UDRadius.M.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[UDRadius.L.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[UDRadius.XL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[UDRadius.XXL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[UDRadius.ROUND.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static EnumEntries<UDRadius> getEntries() {
        return b;
    }

    static {
        UDRadius r0 = new UDRadius("NONE", 0, 0);
        NONE = r0;
        UDRadius r1 = new UDRadius("XS", 1, 1);
        XS = r1;
        UDRadius r3 = new UDRadius("S", 2, 2);
        S = r3;
        UDRadius r5 = new UDRadius("M", 3, 3);
        M = r5;
        UDRadius r7 = new UDRadius("L", 4, 4);
        L = r7;
        UDRadius r9 = new UDRadius("XL", 5, 5);
        XL = r9;
        UDRadius r11 = new UDRadius("XXL", 6, 6);
        XXL = r11;
        UDRadius r13 = new UDRadius("ROUND", 7, 6);
        ROUND = r13;
        UDRadius[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
        Companion = new a();
    }

    public static UDRadius[] values() {
        return (UDRadius[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UDRadius valueOf(String r1) {
        return (UDRadius) r27.a.a(UDRadius.class, r1);
    }

    public final int getRadiusSize(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        switch(b.a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L13:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    L16:
        return d.d(r3, 2131169387);
    L17:
        return d.d(r3, 2131169385);
    L18:
        return d.d(r3, 2131169382);
    L19:
        return d.d(r3, 2131169383);
    L20:
        return d.d(r3, 2131169384);
    L21:
        return d.d(r3, 2131169386);
    }

    public UDRadius(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
