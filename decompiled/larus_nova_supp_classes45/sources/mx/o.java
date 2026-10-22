package mx;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public final String a;
    public final int b;
    public final float c;
    public final Rect d;

    public static final class a {
    }

    static {
        new Rect(16, 6, 16, 6);
    }

    public /* synthetic */ o(String r2, Rect r3) {
        this(r2, 13.0f, r3);
    }

    public o(String r2, float r3, Rect r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r4, "marginsDp");
        this.a = r2;
        this.b = 2131108578;
        this.c = r3;
        this.d = r4;
    }
}
