package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {
    void b(List<? extends IBaseUser> r1);

    void e(String r1);

    void f(long r1, List<? extends p> r3, List<? extends p> r4, List<? extends IBaseUser> r5, String r6, Map<String, Long> r7);

    void h(long r1, List<? extends p> r3, List<? extends p> r4, List<? extends IBaseUser> r5, String r6);

    void onInitPageFailed(int r1);
}
