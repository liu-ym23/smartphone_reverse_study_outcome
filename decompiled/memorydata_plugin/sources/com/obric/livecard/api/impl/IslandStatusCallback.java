package com.obric.livecard.api.impl;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.livecard.api.IIslandStatusCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/livecard/api/impl/IslandStatusCallback;", "Lcom/obric/livecard/api/IIslandStatusCallback$Stub;", "()V", LocationMonitorConst.TAG, "", "getTag", "()J", "getId", "onIslandSessionChanged", "", "sessionType", "", "flags", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class IslandStatusCallback extends IIslandStatusCallback.Stub {
    private final long tag;

    public IslandStatusCallback() {
        this.tag = SystemClock.elapsedRealtime();
    }

    @Override // com.obric.livecard.api.IIslandStatusCallback
    public long getId() {
        return this.tag;
    }

    public final long getTag() {
        return this.tag;
    }

    @Override // com.obric.livecard.api.IIslandStatusCallback
    public void onIslandSessionChanged(int r1, int r2) {
    }
}
