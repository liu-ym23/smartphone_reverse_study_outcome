package plb;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a {
    public static final /* synthetic */ int e = 0;
    public final View a;
    public final RectF b;
    public final RectF c;
    public final Region d;

    /* JADX INFO: renamed from: plb.a$a, reason: collision with other inner class name */
    public static final class C0311a {
    }

    static {
    }

    public void a() {
    }

    public void b(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
    }

    public boolean c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return false;
    }

    public void d(RectF r2, RectF r3) {
        Intrinsics.checkNotNullParameter(r2, "baseView");
        Intrinsics.checkNotNullParameter(r3, "baseContent");
    }

    public final void e() {
        RectF r0 = this.c;
        float r1 = this.a.getWidth();
        float r2 = this.a.getHeight();
        RectF r3 = new RectF();
        RectF r4 = new RectF();
        float r5 = r0.left;
        float r6 = 0.0f;
        if (r5 >= 0.0f) goto L5;
        r5 = 0.0f;
    L5:
        r3.left = r5;
        float r7 = r0.top;
        if (r7 >= 0.0f) goto L8;
        r7 = 0.0f;
    L8:
        r3.top = r7;
        r3.right = r5 + RangesKt.coerceAtMost(r0.width(), r1);
        r3.bottom = r3.top + RangesKt.coerceAtMost(r0.height(), r2);
        float r8 = r0.left;
        if (r8 >= 0.0f) goto L11;
        float r9 = Math.abs(r8);
    L12:
        r4.left = r9;
        float r10 = r0.top;
        if (r10 >= 0.0f) goto L15;
        r6 = Math.abs(r10);
    L15:
        r4.top = r6;
        r4.right = r4.left + RangesKt.coerceAtMost(r0.width(), r1);
        r4.bottom = r4.top + RangesKt.coerceAtMost(r0.height(), r2);
        Log.i("ILargeImageViewPlusProvider", "updateVisibleContentRect, baseView:" + r3 + ",baseContent:" + r4);
        d(r3, r4);
        return;
    L11:
        r9 = 0.0f;
        goto L12
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
        RectF r3 = new RectF(2.1474836E9f, 2.1474836E9f, 2.1474836E9f, 2.1474836E9f);
        this.b = r3;
        this.c = new RectF(r3);
        this.d = new Region();
    }
}
