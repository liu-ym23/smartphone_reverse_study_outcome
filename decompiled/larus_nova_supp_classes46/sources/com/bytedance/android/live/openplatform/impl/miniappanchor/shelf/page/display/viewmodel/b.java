package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.livesdk.message.model.el;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a {
    public final List<ShelfCardInfo> a;
    public final el b;

    public b(List<ShelfCardInfo> r2, el r3) {
        Intrinsics.checkNotNullParameter(r2, "cardInfoList");
        this.a = r2;
        this.b = r3;
    }
}
