package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.SearchEntranceResponse.Data")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/m0;", "", "", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "cells", "Ljava/util/List;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 implements vh7.h {

    @SerializedName("cells")
    public List<InteractEntranceCell> cells;

    public m0() {
        this.cells = new ArrayList();
    }

    public m0(am3.g r5) {
        this.cells = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.cells.add(new InteractEntranceCell(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.cells.isEmpty() == false) goto L19;
        this.cells = new ArrayList();
        return;
    }
}
