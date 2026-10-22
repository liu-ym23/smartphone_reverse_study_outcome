package bu1;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements a {
    public b() {
    }

    @Override // bu1.a
    public final void a(com.bytedance.android.livesdk.dsl.recyclerview.b r2, IAction r3, View r4, j r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Intrinsics.checkNotNullParameter(r5, "curTemplateHolder");
        Map<String, ? extends Object> r6 = r3.getParams();
        if (r6 == null) goto L7;
        if (r2 == null) goto L8;
        r2.b(r6);
        return;
    L8:
        return;
    }
}
