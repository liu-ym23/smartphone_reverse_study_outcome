package ilb;

import android.graphics.Region;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Region a;
    public boolean b;
    public boolean c;
    public boolean d;

    public a() {
        this(0);
    }

    public a(int r2) {
        Region r3 = new Region();
        Intrinsics.checkNotNullParameter(r3, "region");
        this.a = r3;
        this.b = false;
        this.c = false;
        this.d = false;
    }
}
