package com.bytedance.android.live.base.model.follow;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.ScheduledLive")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/follow/ScheduledLive;", "", "()V", "scheduledLiveRoomList", "", "Lcom/bytedance/android/live/base/model/follow/ScheduledLiveItem;", "getScheduledLiveRoomList", "()Ljava/util/List;", "setScheduledLiveRoomList", "(Ljava/util/List;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScheduledLive implements h {

    @SerializedName("list")
    protected List<ScheduledLiveItem> scheduledLiveRoomList;

    public ScheduledLive() {
    }

    public ScheduledLive(g r5) {
        this.scheduledLiveRoomList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.scheduledLiveRoomList.add(new ScheduledLiveItem(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final List<ScheduledLiveItem> getScheduledLiveRoomList() {
        return this.scheduledLiveRoomList;
    }

    public final void setScheduledLiveRoomList(List<ScheduledLiveItem> r1) {
        this.scheduledLiveRoomList = r1;
    }
}
