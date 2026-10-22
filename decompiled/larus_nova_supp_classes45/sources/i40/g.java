package i40;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.b6;
import com.bytedance.android.livesdk.c6;
import com.bytedance.android.livesdk.config.q5;
import com.bytedance.android.livesdk.d6;
import com.bytedance.android.livesdk.k5;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.q6;
import com.bytedance.android.livesdk.utils.t6;
import j40.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends i40.a {
    public int d;
    public int e;
    public final q5 f;
    public final boolean g;
    public final Boolean h;
    public final boolean i;

    public static final class a {
    }

    static {
    }

    public g(boolean r1) {
        this.i = r1;
        this.f = (q5) b6.a.getValue();
        this.g = FoldScreenUtils.f();
        this.h = (Boolean) c6.a.getValue();
    }

    @Override // i40.a, i40.e
    public final d b(Context r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        h.c("--onBeforeMeasure start--", this.i);
        int r7 = View.MeasureSpec.getSize(r6);
        if (d(r5, r7) == false) goto L6;
        h.c("--adapter vivo return null--", this.i);
        return null;
    L6:
        h.c("lastHeight:" + this.c + "  maxHeight:" + this.d + "   currentHeight:" + r7 + ',', this.i);
        if (this.h.booleanValue() == false) goto L12;
        if (r7 != 0) goto L12;
        h.c("【one frame return height = 0, intercept it, return null】", this.i);
        return null;
    L12:
        if (((Boolean) q6.a.getValue()).booleanValue() == false) goto L18;
        if (PadConfigUtils.a() == false) goto L18;
        if (r7 != 0) goto L18;
        return null;
    L18:
        if (this.c != 0) goto L25;
        this.c = r7;
        if (this.d != 0) goto L22;
        f(r7, r5);
    L22:
        h.c("--last height == 0,return null--", this.i);
        return null;
    L25:
        if (r7 <= this.d) goto L28;
        h.c("on height bigger than last screent height return height : " + r7 + " \t lastscreenheight " + this.d, this.i);
        f(r7, r5);
    L28:
        if (this.c != r7) goto L31;
        h.c("--last height:" + this.c + " equals height, return null--", this.i);
        return null;
    L31:
        int r0 = this.d - r7;
        this.c = r7;
        Float r1 = (Float) d6.a.getValue();
        if (this.g == true) goto L34;
    L39:
        h.c("offset(keyboard height):" + r0 + ", threshold:" + t6.a(r5, r1.floatValue()) + ", lastHeight:" + this.c + ", height:" + r7, this.i);
        float r8 = (float) r0;
        if (r8 <= t6.a(r5, r1.floatValue())) goto L42;
        h.c("软键盘显示,高度是:" + r0, this.i);
    L49:
        boolean r9 = true;
    L51:
        int r11 = Math.abs(r0);
        h.c("软键盘显示结果：" + r9, this.i);
        return new d(r9, r11);
    L42:
        Configuration r2 = r5.getResources().getConfiguration();
        if (PadConfigUtils.a() == true) goto L45;
    L50:
        h.c("软键盘隐藏,高度是:" + r0, this.i);
        r9 = false;
        goto L51
    L45:
        if (r2.keyboard != 2) goto L50;
        if (r8 <= t6.a(r5, 48.0f)) goto L50;
        h.c("软键盘显示，连接外接键盘，高度是" + r0, this.i);
        goto L49
    L34:
        if (this.f.enableFoldScreenKeyboardOpt == false) goto L39;
        if (FoldScreenUtils.a() != 0) goto L38;
        r1 = Float.valueOf(this.f.expandStatusThreshold);
        goto L39
    L38:
        r1 = Float.valueOf(this.f.foldStatusThreshold);
        goto L39
    }

    public final void f(int r3, Context r4) {
        if (s1.getContext() != null) goto L5;
    L17:
        int r5 = Math.min(r3, Math.min(s1.w(), s1.y()));
    L18:
        this.d = r5;
        h.c("set max height: " + r3 + ", after set: " + this.d, this.i);
        return;
    L5:
        if (s1.getContext().getResources().getConfiguration().orientation != 1) goto L17;
        if (this.e != 0) goto L10;
        this.e = StatusBarUtil.getStatusBarHeight(r4);
    L10:
        if (FoldScreenUtils.e() == true) goto L12;
    L16:
        r5 = Math.max(r3, Math.max(s1.w() - this.e, s1.y()));
        goto L18
    L12:
        if (n.a.getValue().getEnableInteractivity() == false) goto L16;
        if (((Boolean) k5.a.getValue()).booleanValue() == false) goto L16;
        r5 = Math.max(r3, s1.w() - this.e);
        goto L18
    }
}
