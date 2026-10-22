package u5b;

import android.graphics.drawable.Drawable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final c e = null;
    public int a;
    public int b;
    public Drawable c;
    public int[] d;

    public static final class a {
        @JvmStatic
        public static c a(int r3, int r4, Drawable r5, int[] r6) {
            c r0 = c.e;
            r0.d = new int[]{0, 0, 0, 0};
            r0.a = r3;
            r0.b = r4;
            r0.c = r5;
            if (r6 != null) goto L5;
            r6 = new int[]{0, 0, 0, 0};
        L5:
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r0.d = r6;
            return r0;
        }
    }

    static {
        e = new c();
    }

    public c() {
        this.d = new int[]{0, 0, 0, 0};
    }
}
