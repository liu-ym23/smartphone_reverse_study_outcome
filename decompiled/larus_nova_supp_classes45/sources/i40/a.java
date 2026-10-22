package i40;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.f1;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a implements e {
    public int a;
    public int b;
    public int c;

    public a() {
    }

    public static int e(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r2 = r1.getSystemService("window");
        if (r2 == null) goto L7;
        Point r0 = new Point();
        ((WindowManager) r2).getDefaultDisplay().getSize(r0);
        return r0.y;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @Override // i40.e
    public d a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "root");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "root");
        return null;
    }

    @Override // i40.e
    public d b(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r6 = View.MeasureSpec.getSize(r5);
        if (d(r4, r6) == false) goto L6;
        h.a("on adapter vivo returen");
        return null;
    L6:
        int r0 = this.c;
        if (r0 != 0) goto L10;
        this.c = r6;
        this.a = r6;
        h.a("on last height == 0 return");
        return null;
    L10:
        int r2 = this.a;
        if (r6 <= r2) goto L14;
        h.a("on height bigger than last screent height return height : " + r6 + " \t lastscreenheight " + this.a);
        this.c = r6;
        this.a = r6;
        return null;
    L14:
        if (r0 != r6) goto L17;
        h.a("on last height equals height return height: " + this.c);
        return null;
    L17:
        int r3 = r2 - r6;
        this.c = r6;
        if (r3 <= t6.a(r4, 80.0f)) goto L20;
        h.a("软键盘显示 diff " + r3);
        boolean r7 = true;
    L21:
        int r8 = Math.abs(r3);
        h.a("datas : lastheight " + this.c + ", offset " + r3 + ", isvisible " + r7);
        return new d(r7, r8);
    L20:
        h.a("软键盘隐藏 diff " + r3);
        r7 = false;
        goto L21
    }

    public final boolean d(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r1 = false;
        if (f1.a().booleanValue() == true) goto L5;
        return false;
    L5:
        int r5 = e(r3);
        if (r4 > r5) goto L15;
        int r6 = this.b;
        if (r6 != 0) goto L11;
        this.b = r5;
    L14:
        return r1;
    L11:
        if (r6 == r5) goto L14;
        r1 = true;
        goto L14
    L15:
        return true;
    }

    @Override // i40.e
    public void c(Context r1, ViewGroup r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
    }
}
