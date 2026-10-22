package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.GetEntranceResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/b;", "", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "cells", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("cells")
    public InteractEntranceCell cells;

    public b() {
        this.cells = new InteractEntranceCell(0, null, null, null, 0, null, 131071);
    }

    public b(am3.g r10) {
        long r0 = r10.c();
    L3:
        int r2 = r10.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.cells = new InteractEntranceCell(r10);
        goto L3
    L7:
        am3.h.e(r10);
        goto L3
    L9:
        r10.d(r0);
        if (this.cells != null) goto L19;
        this.cells = new InteractEntranceCell(0, null, null, null, 0, null, 131071);
        return;
    }
}
