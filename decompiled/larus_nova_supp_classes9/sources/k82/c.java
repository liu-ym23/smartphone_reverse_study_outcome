package k82;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c {
    public final View a;
    public final a b;

    public void a() {
    }

    public c(View r2, h82.b r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        this.a = r2;
        this.b = r3;
    }
}
