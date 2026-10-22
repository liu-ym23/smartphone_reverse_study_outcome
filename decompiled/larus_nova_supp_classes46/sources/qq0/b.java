package qq0;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ AudienceShelfDisplayDialog a;

    public b(AudienceShelfDisplayDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == true) goto L5;
        return;
    L5:
        if (this.a.m == true) goto L9;
        f2.c("主播已更新内容", 0);
        return;
    }
}
