package i40;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.utils.t6;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends a {
    public int d;
    public float e;
    public int f;
    public int g;

    @Override // i40.a, i40.e
    public final d b(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return null;
    }

    public f() {
        this.d = -1;
        this.f = Integer.MIN_VALUE;
    }

    public static int[] g(ViewGroup r5) {
        int[] r1 = new int[2];
        r5.getLocationInWindow(r1);
        h.a("data : root loc : " + Arrays.toString(r1) + " , root params: " + r5.getHeight() + "   " + r5.getY());
        r1[1] = r1[1] + r5.getHeight();
        if (r5.getChildCount() <= 1) goto L11;
        View r6 = r5.getChildAt(1);
        if (r6 == null) goto L10;
        View r7 = ((ViewGroup) r6).getChildAt(3);
        if (r7 == null) goto L11;
        int[] r2 = new int[2];
        r7.getLocationInWindow(r2);
        int[] r0 = new int[2];
        r7.getLocationOnScreen(r0);
        h.a("datas: ps " + Arrays.toString(r2) + " pss" + Arrays.toString(r0));
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L11:
        return r1;
    }

    public final float f(Context r3) {
        if (this.e != 0.0f) goto L6;
        this.e = t6.a(r3, 80.0f);
    L6:
        return this.e;
    }

    public final int h(Context r3) {
        if (this.d != (-1)) goto L5;
        this.d = a.e(r3);
    L5:
        h.a("screen height : " + this.d);
        return this.d;
    }

    @Override // i40.a, i40.e
    public final d a(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "root");
        super.a(r5, r6);
        h.a("after draw ======");
        h.a("on judge screen : sheight: " + h(r6.getContext()) + ", maxY : " + this.f + " , lasty " + this.g + ' ');
        boolean r0 = true;
        int r7 = g(r6)[1];
        StringBuilder r1 = new StringBuilder(" y : ");
        r1.append(r7);
        r1.append(", delta = ");
        r1.append(f(r6.getContext()));
        h.a(r1.toString());
        if (this.g != r7) goto L6;
        h.a("same y return :  " + r7);
        return null;
    L6:
        if (this.f >= r7) goto L8;
        this.f = r7;
    L8:
        int r2 = Math.abs(this.f - r7);
        if (this.g < r7) goto L12;
        r0 = false;
    L12:
        if (r0 == false) goto L18;
        if (r2 >= f(r6.getContext())) goto L16;
        Boolean r8 = Boolean.FALSE;
        h.a("软键盘隐藏 diff " + r2);
    L22:
        h.a("datas : lastheight " + this.c + ", offset " + r2 + ", isvisible " + r8);
        this.g = r7;
        if (r8 != null) goto L25;
        return null;
    L25:
        return new d(r8.booleanValue(), r2);
    L16:
        h.a("软键盘状态错误，正在变大但大于delta值  offset " + r2 + "  ,delta = " + f(r6.getContext()));
    L21:
        r8 = null;
        goto L22
    L18:
        if (r2 <= f(r6.getContext())) goto L20;
        r8 = Boolean.TRUE;
        h.a("软键盘显示 diff " + r2);
        goto L22
    L20:
        h.a("软键盘状态错误，正在变小但依然小于delta值  offset " + r2 + ",delta = " + f(r6.getContext()));
        goto L21
    }

    @Override // i40.a, i40.e
    public final void c(Context r2, ViewGroup r3, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        super.c(r2, r3, r4, r5, r6, r7);
        h.a("after layout ====");
        h.a("on judge screen : sheight: " + h(r3.getContext()));
        g(r3);
    }
}
