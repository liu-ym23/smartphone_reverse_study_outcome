package com.larksuite.component.ud.radius;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/ud/radius/UDRadius;", "", "Landroid/content/Context;", "context", "", "getRadiusSize", "value", "I", "getValue", "()I", "Companion", "a", "NONE", "XS", "S", "M", "L", "XL", "XXL", "ROUND", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
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
    private final int value;

    public static final class a {
        public a() {
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

    public static UDRadius valueOf(String r1) {
        return (UDRadius) r27.a.a(UDRadius.class, r1);
    }

    public static UDRadius[] values() {
        return (UDRadius[]) a.clone();
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
        a = new UDRadius[]{r0, r1, r3, r5, r7, r9, r11, r13};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
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
        return qz7.a.a(r3, 2131169387);
    L17:
        return qz7.a.a(r3, 2131169385);
    L18:
        return qz7.a.a(r3, 2131169382);
    L19:
        return qz7.a.a(r3, 2131169383);
    L20:
        return qz7.a.a(r3, 2131169384);
    L21:
        return qz7.a.a(r3, 2131169386);
    }

    public UDRadius(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
