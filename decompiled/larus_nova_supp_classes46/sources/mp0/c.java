package mp0;

import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements o {
    public final List<d> a;
    public final lp0.a b;

    public final void onStart() {
    }

    public final void onStop() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).onStop();
        goto L4
    }

    public c(lp0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.b = r2;
        this.a = new ArrayList();
    }
}
