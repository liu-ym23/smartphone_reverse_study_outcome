package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface j0 {
    void a(ILivePlayerClient r1, String r2, NextLiveData<Boolean> r3, Map<String, String> r4, DataCenter r5);

    String c(DataCenter r1);

    boolean d(DataCenter r1);

    boolean e(DataCenter r1);

    NextLiveData<Boolean> f(DataCenter r1);

    boolean g(DataCenter r1);

    ILivePlayerClient getLivePlayerClient();

    IProgressCastService h();

    NextLiveData<Boolean> i(DataCenter r1);

    void j(DataCenter r1);
}
