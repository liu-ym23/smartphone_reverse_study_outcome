package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class y implements z {
    public y() {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void b(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void e(List r1, WaitingListUser r2) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void f(String r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void onOnlineListChanged(List<? extends LinkPlayerInfo> r1) {
    }
}
