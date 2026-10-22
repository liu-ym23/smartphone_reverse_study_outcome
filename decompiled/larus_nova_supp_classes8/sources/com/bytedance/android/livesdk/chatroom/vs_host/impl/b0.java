package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 implements vr1.y, com.bytedance.android.scope.o {
    public b0() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.y
    public final NextLiveData<Boolean> a(DataCenter r3) {
        if (r3 == null) goto L8;
        p0 r4 = (p0) r3.get("zygote_event_hub", null);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getStartPull();
    L8:
        return null;
    }

    @Override // vr1.y
    public final NextLiveData<Boolean> c(DataCenter r3) {
        if (r3 == null) goto L8;
        p0 r4 = (p0) r3.get("zygote_event_hub", null);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getShowLiveEnd();
    L8:
        return null;
    }

    @Override // vr1.y
    public final NextLiveData<Boolean> d(DataCenter r3) {
        if (r3 == null) goto L8;
        p0 r4 = (p0) r3.get("zygote_event_hub", null);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getSwitchStreamDataEvent();
    L8:
        return null;
    }
}
