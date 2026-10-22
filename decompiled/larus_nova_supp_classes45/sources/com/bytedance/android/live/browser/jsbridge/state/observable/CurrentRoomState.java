package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.BaseObservableState;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/state/observable/CurrentRoomState;", "Lcom/bytedance/android/live/browser/jsbridge/state/BaseObservableState;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CurrentRoomState extends BaseObservableState<IRoom> implements Observer<KVData> {
    public final DataCenter e;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        Room r0 = (Room) this.e.get("data_room", null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return k.n(IRoomService.class).getCurrentRoom();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
    public final void i() {
        this.e.removeObserver(this);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f d() {
        return i.e.c.b;
    }

    public CurrentRoomState(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(false);
        this.e = r2;
        r2.observeForever("data_room", this);
    }

    public final void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
        if (r2 == null) goto L5;
        Room r3 = (Room) r2.getData();
    L6:
        h(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
