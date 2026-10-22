package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface z {
    void a(String r1, String r2);

    void b(String r1, String r2, boolean r3);

    void e(List r1, WaitingListUser r2);

    void f(String r1, long r2, String r4);

    void onOnlineListChanged(List<? extends LinkPlayerInfo> r1);
}
