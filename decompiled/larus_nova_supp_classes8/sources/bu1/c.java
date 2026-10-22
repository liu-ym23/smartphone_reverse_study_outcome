package bu1;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements a {
    public final Function1<String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super String, Unit> r1) {
        this.a = r1;
    }

    @Override // bu1.a
    public final void a(com.bytedance.android.livesdk.dsl.recyclerview.b r1, IAction r2, View r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter(r4, "curTemplateHolder");
        Map r5 = r2.getParams();
        if (r5 == null) goto L10;
        String r6 = com.bytedance.android.livesdk.dsl.util.c.d(r5, "scheme");
        if (r6 == null) goto L11;
        Function1<String, Unit> r7 = this.a;
        if (r7 == null) goto L12;
        Unit r8 = (Unit) r7.invoke(r6);
        return;
    L12:
        return;
    L11:
        return;
    }
}
