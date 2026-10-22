package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ MemoryContextService a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ ShelfInfo d;

    public h(MemoryContextService r1, List r2, List r3, ShelfInfo r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r10) {
        ShelfCardInfo r11 = (ShelfCardInfo) r10;
        if (r11 == null) goto L8;
        this.b.add(r11);
        if (this.b.size() != this.c.size()) goto L9;
        qo0.a.c("MemoryContextService", "upgrade success");
        MemoryContextService r12 = this.a;
        int r0 = MemoryContextService.c;
        AnchorShelfContextService.onModifyShelfSuccess$default((AnchorShelfContextService) r12.getOpenPlatformContext().getService(AnchorShelfContextService.class), ShelfInfo.a(this.d, null, this.b, false, null, null, null, 1048573), null, false, 6, null);
        return;
    L9:
        return;
    }
}
