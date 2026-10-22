package v49;

import android.content.Context;
import android.view.VelocityTracker;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.views.WheelView;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g extends OverScroller {
    public final WheelView a;
    public int b;
    public float c;
    public boolean d;
    public VelocityTracker e;
    public boolean f;
    public v49.a g;
    public int h;

    public static final class a {
    }

    static {
    }

    public final void e() {
        this.d = false;
        this.b = 0;
        this.h = -1;
        d("reset");
        forceFinished(true);
    }

    public final int b() {
        int r0 = this.a.getItemHeightPx();
        int r1 = this.a.getItemSize();
        if (r1 != 0) goto L6;
        return -1;
    L6:
        int r2 = this.b;
        if (r2 >= 0) goto L9;
        int r3 = (r2 - (r0 / 2)) / r0;
    L10:
        int r4 = r3 % r1;
        if (this.a.r == true) goto L14;
        if (r3 < r1) goto L14;
        r4 = r1 - 1;
    L14:
        if (r4 < 0) goto L16;
        return r4;
    L16:
        return r4 + r1;
    L9:
        r3 = (r2 + (r0 / 2)) / r0;
        goto L10
    }

    public static void c(g r6) {
        int r0 = r6.a.getItemHeightPx();
        int r1 = r6.b % r0;
        if (r1 != 0) goto L8;
        v49.a r2 = r6.g;
        if (r2 == null) goto L8;
        r2.a(r6.h);
    L8:
        if (r1 <= 0) goto L13;
        if (r1 >= (r0 / 2)) goto L13;
        r6.d = true;
        r6.g(r6.b, -r1, BaiduNaviStatus.WRONG_AK_PARAM, "justify");
        r6.a.invalidate();
        return;
    L13:
        if (r1 < (r0 / 2)) goto L15;
        r6.d = true;
        r6.g(r6.b, r0 - r1, BaiduNaviStatus.WRONG_AK_PARAM, "justify");
        r6.a.invalidate();
        return;
    L15:
        if (r1 < 0) goto L17;
    L19:
        int r3 = -r0;
        if (r1 > (r3 / 2)) goto L26;
        r6.d = true;
        r6.g(r6.b, r3 - r1, BaiduNaviStatus.WRONG_AK_PARAM, "justify");
        r6.a.invalidate();
        return;
    L26:
        return;
    L17:
        if (r1 <= ((-r0) / 2)) goto L19;
        r6.d = true;
        r6.g(r6.b, -r1, BaiduNaviStatus.WRONG_AK_PARAM, "justify");
        r6.a.invalidate();
    }

    public final void d(String r3) {
        int r0 = this.h;
        int r1 = b();
        if (r0 == r1) goto L21;
        this.h = r1;
        this.a.getContext();
        g49.d.a("WheelScroller", "performVibrateEffect, scene: [" + r3 + ']');
        if (Intrinsics.areEqual(r3, "computeScroll") == false) goto L7;
    L8:
        int r4 = s49.a.a;
        WheelView r5 = this.a;
        if (r5 != null) goto L19;
    L15:
        v49.a r6 = this.g;
        if (r6 == null) goto L22;
        r6.onChanged();
        return;
    L22:
        return;
    L19:
        r5.performHapticFeedback(26);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        g49.d.b("VibratorSmt", "performHapticFeedbackAOSP error: " + e);
        goto L15
    L7:
        if (Intrinsics.areEqual(r3, "touchEvent") == false) goto L15;
    }

    public g(Context r5, WheelView r6) {
        Intrinsics.checkNotNullParameter(r6, "mWheelView");
        super(r5, new LinearInterpolator());
        this.a = r6;
    L13:
        e = move-exception;
        g49.d.c("ScrollerExt", "init reflect error", e);
        f.d = false;
    L15:
        this.h = -1;
        return;
    L4:
        if (f.a != null) goto L7;
        f.a = f.a();     // Catch: Exception -> L13
    L7:
        if (f.b != null) goto L11;
        Class<?> r7 = f.a;     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L13
        Method r8 = r7.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L13
        f.b = r8;     // Catch: Exception -> L13
        if (r8 == null) goto L11;
        r8.setAccessible(true);     // Catch: Exception -> L13
    L11:
        f.d = true;     // Catch: Exception -> L13
        goto L15
    }

    public final void a(int r4, String r5) {
        this.b += r4;
        WheelView r6 = this.a;
        if (r6.r == true) goto L10;
        int r7 = (r6.getItemSize() - 1) * this.a.getItemHeightPx();
        int r0 = this.a.getItemHeightPx() * 0;
        int r1 = this.b;
        int r2 = -r0;
        if (r1 >= r2) goto L7;
        this.b = r2;
        goto L10
    L7:
        int r8 = r7 + r0;
        if (r1 <= r8) goto L10;
        this.b = r8;
    L10:
        d(r5);
    }

    public final void f(int r3, boolean r4) {
        int r5 = r3 * this.a.getItemHeightPx();
        int r0 = this.b;
        int r6 = r5 - r0;
        if (r6 != 0) goto L6;
        return;
    L6:
        if (r4 == false) goto L8;
        this.d = true;
        g(r0, r6, BaiduNaviStatus.WRONG_AK_PARAM, "setCurrentIndex");
        this.a.invalidate();
        return;
    L8:
        a(r6, "setCurrentIndex");
        this.a.invalidate();
    }

    public final void g(int r7, int r8, int r9, String r10) {
        g49.d.a("WheelScroller", "startScrollInternal, startX: 0, startY: " + r7 + ", dx: 0, dy: " + r8 + ", duration: " + r9 + ", scene: " + r10);
        startScroll(0, r7, 0, r8, r9);
    }
}
