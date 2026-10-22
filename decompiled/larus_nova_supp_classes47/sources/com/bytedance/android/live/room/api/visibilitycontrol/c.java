package com.bytedance.android.live.room.api.visibilitycontrol;

import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {
    void Gc(LiveVisibilityControl.KEY r1, boolean r2, long r3);

    void addControlItem(d r1);

    void removeControlItem(LiveVisibilityControl.KEY r1);

    NextLiveData<Integer> wd(LiveVisibilityControl.KEY r1);
}
