package com.bytedance.android.live.liveinteract.wrdspreload;

import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ MultiLinkWRDSPreloadManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IRoom c;

    public a(MultiLinkWRDSPreloadManager r1, String r2, IRoom r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        RoomLinkMicSyncData r10 = this.a.getRoomLinkMicSyncData(this.b, this.c, false);
        MultiLinkWRDSPreloadManager r0 = this.a;
        int r2 = r0.hashCode();
        StringBuilder r3 = new StringBuilder("fetchListV2Observable, scene=");
        r3.append(this.b);
        r3.append(", roomId=");
        IRoom r4 = this.c;
        if (r4 == null) goto L5;
        Long r5 = Long.valueOf(r4.getId());
    L6:
        r3.append(r5);
        r3.append(", wrds=");
        r3.append(r10);
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(r0, "MultiLinkWRDSPreloadManager", r2, r3.toString(), false, 8, null);
        if (r10 != null) goto L10;
        this.a.b(this.c);
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
