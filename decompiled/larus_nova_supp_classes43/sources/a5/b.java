package a5;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;
    public static final AtomicBoolean b = null;
    public static final Handler c = null;
    public static volatile Application d;
    public static volatile a e;
    public static String f;
    public static final C0001b g = null;
    public static final a5.a h = null;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final float e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r11.e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + Float.floatToIntBits(this.e);
        }

        public final String toString() {
            return "DisplaySnapshot(widthPixels=" + this.a + ", heightPixels=" + this.b + ", densityDpi=" + this.c + ", orientation=" + this.d + ", fontScale=" + this.e + ')';
        }

        public a(int r1, int r10, int r11, int r12, float r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }
    }

    /* JADX INFO: renamed from: a5.b$b, reason: collision with other inner class name */
    public static final class C0001b implements DisplayManager.DisplayListener {
        public C0001b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r10) {
            b r0 = b.a;
            String r11 = "display_changed:" + r10;
            monitor-enter(r0);
            b.f = r11;     // Catch: Throwable -> L7
            Handler r12 = b.c;     // Catch: Throwable -> L7
            a5.a r1 = b.h;     // Catch: Throwable -> L7
            r12.removeCallbacks(r1);     // Catch: Throwable -> L7
            r12.postDelayed(r1, 100);     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public b() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [a5.a] */
    static {
        a = new b();
        b = new AtomicBoolean(false);
        c = new Handler(Looper.getMainLooper());
        f = "init";
        g = new C0001b();
        h = new a5.a();
    }

    public static a a(Context r10) {
        Resources r11 = r10.getResources();
        DisplayMetrics r0 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics());
        Configuration r12 = r11.getConfiguration();
        return new a(r0.widthPixels, r0.heightPixels, r12.densityDpi, r12.orientation, r12.fontScale);
    }
}
