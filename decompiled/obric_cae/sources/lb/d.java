package lb;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f9197a;

    public static final class a {
        public static void a(Path r10, e r11, float r12, float r13, float r14) {
            float r8 = r11.f9198a;
            float r15 = r11.f9199b;
            r10.arcTo(r8 - r12, r15 - r12, r8 + r12, r15 + r12, r13, r14 - r13, false);
        }
    }

    public d() {
        this.f9197a = new RectF();
    }

    public static Path b(float r10, float r11, float r12, float r13, float r14) {
        Path r8 = new Path();
        r8.addRoundRect(r10, r11, r12, r13, r14, r14, Path.Direction.CW);
        r8.close();
        return r8;
    }

    public abstract Path a(float r8, float r10, float r11, float r12, float r13);

    public boolean c(float r8, float r10) {
        return true;
    }
}
