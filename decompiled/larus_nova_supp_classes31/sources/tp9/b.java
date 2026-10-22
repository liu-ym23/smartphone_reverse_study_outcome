package tp9;

import android.graphics.PointF;
import android.util.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final a a = null;
    public static final C0076b b = null;

    public class a extends Property<c, float[]> {
        public a() {
            super(float[].class, "nonTranslations");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ float[] get(c r1) {
            return null;
        }

        @Override // android.util.Property
        public final void set(c r4, float[] r5) {
            c r6 = r4;
            float[] r7 = r5;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r7, "values");
            System.arraycopy(r7, 0, r6.e, 0, r7.length);
            r6.a();
        }
    }

    /* JADX INFO: renamed from: tp9.b$b, reason: collision with other inner class name */
    public class C0076b extends Property<c, PointF> {
        public C0076b(Class r2) {
            super(r2, "translations");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(c r1) {
            return null;
        }

        @Override // android.util.Property
        public final void set(c r2, PointF r3) {
            c r4 = r2;
            PointF r5 = r3;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "translation");
            r4.f = r5.x;
            r4.g = r5.y;
            r4.a();
        }
    }

    static {
        a = new a();
        b = new C0076b(PointF.class);
    }
}
