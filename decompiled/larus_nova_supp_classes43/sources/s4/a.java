package s4;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: s4.a$a, reason: collision with other inner class name */
    public static final class C0194a {
        public final double a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final boolean f;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0194a) == true) goto L8;
            return false;
        L8:
            C0194a r11 = (C0194a) r10;
            if (Double.compare(this.a, r11.a) == 0) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r0 = Double.doubleToLongBits(this.a);
            int r1 = ((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            if (this.f == false) goto L5;
            int r10 = 1231;
        L7:
            return r1 + r10;
        L5:
            r10 = 1237;
            goto L7
        }

        public final String toString() {
            return "ScreenSizeInfo(density=" + this.a + ", screenWidthPx=" + this.b + ", screenHeightPx=" + this.c + ", screenWidthDp=" + this.d + ", screenHeightDp=" + this.e + ", swappedWH=" + this.f + ')';
        }

        public C0194a(double r1, int r10, int r11, int r12, int r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }
    }

    static {
    }

    public static int c(int r10, double r11) {
        return (int) ((((double) r10) / r11) + ((double) 0.5f));
    }

    public static C0194a a(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r12.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L6:
        Resources r1 = r12.getResources();
        double r10 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        f r11 = f.a;
        int r13 = f.b(r12);
        int r14 = f.a(r12);
        if (r0 == false) goto L9;
        if (r13 >= r14) goto L9;
    L11:
        boolean r15 = true;
    L13:
        if (r0 == false) goto L15;
        int r16 = Math.max(r13, r14);
    L16:
        int r17 = r16;
        if (r0 == false) goto L19;
        int r18 = Math.min(r13, r14);
    L20:
        int r19 = r18;
        return new C0194a(r10, r17, r19, c(r17, r10), c(r19, r10), r15);
    L19:
        r18 = Math.max(r13, r14);
        goto L20
    L15:
        r16 = Math.min(r13, r14);
    L9:
        if (r0 == true) goto L12;
        if (r13 > r14) goto L11;
    L12:
        r15 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static int b(Context r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r11 == false) goto L10;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        if (r12 == null) goto L7;
        int r13 = r12.getStatusBarHeight(r10);
    L8:
        if (r13 <= 0) goto L10;
        return r13;
    L7:
        r13 = 0;
    L10:
        int r14 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r14 > 0) goto L13;
        return 0;
    L13:
        return r10.getResources().getDimensionPixelSize(r14);
    }
}
