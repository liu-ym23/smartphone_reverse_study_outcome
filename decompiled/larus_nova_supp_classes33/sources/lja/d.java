package lja;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class d {
    public static final /* synthetic */ int b = 0;
    public final RectF a;

    public static final class a {
        public static void a(Path r9, e r10, float r11, float r12, float r13) {
            Intrinsics.checkNotNullParameter(r9, "$this$arcTo");
            Intrinsics.checkNotNullParameter(r10, "arcCenter");
            float r0 = r10.a;
            float r14 = r10.b;
            r9.arcTo(r0 - r11, r14 - r11, r0 + r11, r14 + r11, r12, r13 - r12, false);
        }
    }

    static {
    }

    public abstract Path a(float r1, float r2, float r3, float r4, float r5);

    public boolean c(float r1, float r2) {
        return true;
    }

    public abstract String getType();

    public d() {
        this.a = new RectF();
    }

    public static Path b(float r9, float r10, float r11, float r12, float r13) {
        Path r8 = new Path();
        r8.addRoundRect(r9, r10, r11, r12, r13, r13, Path.Direction.CW);
        r8.close();
        return r8;
    }

    public void d(Canvas r7, Paint r8, float r9, float r10, float r11, float r12, float r13) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r8, "paint");
        r7.drawPath(a(r9, r10, r11, r12, r13), r8);
    }
}
