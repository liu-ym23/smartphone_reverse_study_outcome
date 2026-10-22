package com.bytedance.android.live.broadcast.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.LiveActivityProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IXTBroadcastService {
    LiveActivityProxy createXTBroadcastBeforeActivityProxy(FragmentActivity r1);

    LiveActivityProxy createXTBroadcastResDownloadActivityProxy(FragmentActivity r1);
}
