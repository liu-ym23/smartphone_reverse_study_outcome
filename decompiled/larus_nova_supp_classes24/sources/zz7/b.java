package zz7;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel4;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static ZoomLevel6 a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomLevel6.values().length];
            r0[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ZoomLevel6.NORMAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final ZoomLevel6 d() {
        ZoomLevel6 r0 = a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ZoomLevel6.NORMAL;
    }

    @JvmStatic
    public static final ZoomLevel4 e() {
        ZoomLevel6 r0 = d();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L22;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L20;
        return ZoomLevel4.NORMAL;
    L20:
        return ZoomLevel4.LARGE4;
    L21:
        return ZoomLevel4.LARGE3;
    L22:
        return ZoomLevel4.LARGE2;
    L23:
        return ZoomLevel4.LARGE1;
    L18:
        return ZoomLevel4.SMALL;
    }

    public static float c(LarkFont r2) {
        switch(a.a[d().ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        int r3 = r2.getNormal();
    L11:
        return r3;
    L7:
        r3 = r2.getLarge2();
        goto L11
    L8:
        r3 = r2.getLarge1();
        goto L11
    L9:
        r3 = r2.getSmall();
        goto L11
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final float f(float r1) {
        return d().getMultiplier() * r1;
    }

    @JvmStatic
    public static final float j(int r5) {
        LarkFont[] r0 = LarkFont.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        LarkFont r3 = r0[r2];
        if (r3.getNormal() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        Intrinsics.checkNotNullParameter(r3, "larkFont");
        return b(r3, d());
    L10:
        return d().getMultiplier() * r5;
    }

    public static float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public static float b(LarkFont r1, ZoomLevel6 r2) {
        switch(a.a[r2.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        int r3 = r1.getNormal();
    L13:
        return r3;
    L7:
        r3 = r1.getLarge4();
        goto L13
    L8:
        r3 = r1.getLarge3();
        goto L13
    L9:
        r3 = r1.getLarge2();
        goto L13
    L10:
        r3 = r1.getLarge1();
        goto L13
    L11:
        r3 = r1.getSmall();
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final int g(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return MathKt.roundToInt(a(r1, d().getMultiplier() * r2));
    }

    @JvmStatic
    public static final float h(Context r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        LarkFont[] r0 = LarkFont.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        LarkFont r3 = r0[r2];
        if (r3.getNormal() == r6) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return i(r5, r3);
    L10:
        return a(r5, d().getMultiplier() * r6);
    }

    @JvmStatic
    public static final float i(Context r1, LarkFont r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "larkFont");
        return a(r1, b(r2, d()));
    }
}
