package sx0;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: sx0.a$a, reason: collision with other inner class name */
    public static final class C0316a extends a implements sx0.b {
        public final float a;
        public final int b;
        public final float c;

        @Override // sx0.b
        public final float a() {
            return this.a;
        }

        public C0316a(float r1, int r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends a implements sx0.b {
        public final float a;
        public final int b;

        @Override // sx0.b
        public final float a() {
            return this.a;
        }

        public b(float r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends a implements sx0.b {
        public final float a;

        @Override // sx0.b
        public final float a() {
            return this.a;
        }

        public c(float r1) {
            this.a = r1;
        }
    }

    public static final class d extends a implements sx0.b {
        public final float a;

        @Override // sx0.b
        public final float a() {
            return this.a;
        }

        public d(float r1) {
            this.a = r1;
        }
    }

    public static final class e extends a {
        public final RectF a;

        public e(RectF r2) {
            Intrinsics.checkNotNullParameter(r2, "playerArea");
            this.a = r2;
        }
    }

    public static final class f extends a implements sx0.b {
        public final float a;

        @Override // sx0.b
        public final float a() {
            return this.a;
        }

        public f(float r1) {
            this.a = r1;
        }
    }

    public static final class g extends a implements sx0.b {
        public final float a;

        @Override // sx0.b
        public final float a() {
            return this.a;
        }

        public g(float r1) {
            this.a = r1;
        }
    }

    public a() {
    }
}
