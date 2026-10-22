package f20;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public final List<? extends a<?, ?>> a;

    public f(List<? extends a<?, ?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "delegates");
        this.a = r2;
    }

    public final a<Object, AbsOpenFeatureTabListItemViewHolder<Object>> a(Object r4) {
        Iterator<? extends a<?, ?>> r0 = this.a.iterator();     // Catch: Exception -> L8
    L4:
        if (r0.hasNext() == false) goto L11;
        a<?, ?> r1 = r0.next();     // Catch: Exception -> L8
        if (r1.accept(r4) == false) goto L4;
        return r1;
    L11:
        return new b();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
