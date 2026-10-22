package com.bytedance.android.live.misc;

import com.bytedance.android.live.profit.privilege.service.PrivilegePreloadService;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements Action {
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ vlc.l c;

    public m(com.bytedance.android.livesdk.revenue.message.b r1, String r2, PrivilegePreloadService.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        this.a.removeMessageListener(this.b, this.c);
    }
}
