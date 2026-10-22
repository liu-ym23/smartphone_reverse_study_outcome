package rq0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a {
    public final List<ShelfCardInfo> a;
    public final f b;

    public c(List<ShelfCardInfo> r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "cardInfoList");
        this.a = r2;
        this.b = r3;
    }
}
