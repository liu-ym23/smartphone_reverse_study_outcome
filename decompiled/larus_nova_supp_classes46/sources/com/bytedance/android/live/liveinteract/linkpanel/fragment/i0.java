package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ SettingLynxContainerFragment a;
    public final /* synthetic */ boolean b;

    public i0(SettingLynxContainerFragment r1) {
        this.a = r1;
        this.b = false;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
        com.bytedance.android.livesdk.sharedpref.e r5 = b6.d;
        Boolean r0 = Boolean.valueOf(this.b);
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        if (this.b == true) goto L7;
        DataCenter r6 = this.a.n;
        if (r6 == null) goto L7;
        r6.put("data_video_talk_dot_with_number_show", "");
    L7:
        this.a.d.dismiss();
    }
}
