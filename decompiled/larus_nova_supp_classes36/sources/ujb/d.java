package ujb;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final String a;
    public final a b;

    public interface a {
        void a(View r1, f r2);
    }

    public d(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "buttonAction");
        this.a = r2;
        this.b = r3;
    }
}
