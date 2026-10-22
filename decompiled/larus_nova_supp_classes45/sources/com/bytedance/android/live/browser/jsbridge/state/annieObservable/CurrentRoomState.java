package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/state/annieObservable/CurrentRoomState;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/annie/api/data/subscribe/BaseDataObsProvider;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CurrentRoomState extends BaseDataObsProvider<Room> implements Observer<KVData> {
    public final DataCenter b;

    public final Object g() {
        Room r0 = (Room) this.b.get("data_room", null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return k.n(IRoomService.class).getCurrentRoom();
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.e.c r0 = com.bytedance.android.live.browser.jsbridge.i.e.c.b;
        return "current_room";
    }

    public final void onRelease() {
        this.b.removeObserver(this);
    }

    public CurrentRoomState(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        r2.observeForever("data_room", this);
    }

    public final void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
        if (r2 == null) goto L5;
        Room r3 = (Room) r2.getData();
    L6:
        i(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
