package ac;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kb.b f341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kb.b f342b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kb.b f343c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f344d = false;

    static {
        f341a = new kb.b();
        kb.b r8 = new kb.b();
        r8.a(kb.a.f9096a);
        f342b = r8;
        kb.b r10 = new kb.b();
        r10.a(kb.a.f9097b);
        f343c = r10;
        f344d = !TextUtils.equals("HUAWEI", Build.BRAND);
    }

    public static void a(Path r8, RectF r10, float[] r11, Path.Direction r12) {
        he.i.f(r8, "path");
        he.i.f(r10, "rect");
        he.i.f(r11, "radii");
        he.i.f(r12, "dir");
        boolean r13 = true;
        if (r11.length != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L16;
        float r15 = r11[0];
        int r16 = r11.length;
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L16;
        float r18 = r11[r17];
        r17 = r17 + 1;
        if (r18 == r15) goto L13;
        boolean r19 = true;
    L14:
        if (r19 == false) goto L9;
        r13 = false;
        goto L16
    L13:
        r19 = false;
    L16:
        if (r13 == false) goto L18;
        r8.addPath(b(r11[0], r10));
        return;
    L18:
        r8.addRoundRect(r10, r11, r12);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static Path b(float r8, RectF r10) {
        he.i.f(r10, "rect");
        float r11 = d(r8, r10);
        kb.b r12 = c(r11, Math.min(r10.width(), r10.height()));
        Rect r13 = new Rect();
        r10.roundOut(r13);
        r12.getClass();
        return r12.f9100a.a(r13.left, r13.top, r13.right, r13.bottom, r11);
    }

    public static kb.b c(float r8, float r10) {
        kb.b r11 = f341a;
        if (r11.f9100a.c(r8, r10) == true) goto L10;
        kb.b r12 = f342b;
        if (r12.f9100a.c(r8, r10) == false) goto L9;
        return r12;
    L9:
        return f343c;
    L10:
        return r11;
    }

    public static float d(float r8, RectF r10) {
        if (r10.isEmpty() == false) goto L6;
        zc.b.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L6:
        float r11 = Math.min(r8, Math.min(r10.width(), r10.height()) / 2.0f);
        if (r11 >= 0.0f) goto L10;
        return 0.0f;
    L10:
        return r11;
    }

    public static final void e(Canvas r8, RectF r10, float r11, Paint r12) {
        he.i.f(r8, "canvas");
        he.i.f(r10, "rectF");
        he.i.f(r12, "paint");
        float r13 = d(r11, r10);
        kb.b r14 = c(r13, Math.min(r10.width(), r10.height()));
        r14.getClass();
        if (r10.isEmpty() == false) goto L5;
        mb.a.b("empty rect: " + r10);
        return;
    L5:
        float r15 = r10.left;
        float r16 = r10.top;
        float r17 = r10.right;
        float r18 = r10.bottom;
        if (r13 >= 0.0f) goto L8;
        mb.a.b("invalid radius: " + r13);
        float r19 = 0.0f;
    L9:
        float r20 = Math.min(r17 - r15, r18 - r16) / 2;
        lb.d r21 = r14.f9100a;
        if (r19 <= r20) goto L12;
        r21.getClass();
        RectF r22 = r21.f9197a;
        r22.set(r15, r16, r17, r18);
        r8.drawRoundRect(r22, r19, r19, r12);
        return;
    L12:
        r21.getClass();
        r8.drawPath(r21.a(r15, r16, r17, r18, r19), r12);
        return;
    L8:
        r19 = r13;
        goto L9
    }
}
