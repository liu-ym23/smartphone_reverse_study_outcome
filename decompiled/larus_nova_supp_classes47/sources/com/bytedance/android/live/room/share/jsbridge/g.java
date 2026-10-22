package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends SimpleShareCallback {
    public final /* synthetic */ ShareLiveMethod a;
    public final /* synthetic */ LiveWebShareParams b;

    public final void onFail(Throwable r2) {
        this.a.l().onFail(r2);
    }

    public g(ShareLiveMethod r1, LiveWebShareParams r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSuccess(String r2, String r3) {
        onSuccessWithExtra(r2, r3, null);
    }

    public final void onSuccessWithExtra(String r6, String r7, Map<String, List<String>> r8) {
        this.a.l().onSuccessWithExtra(r6, r7, r8);
        ShareLiveMethod r9 = this.a;
        String r1 = null;
        if (this.b.isLiveShare() == false) goto L8;
        Room r0 = this.a.c;
        if (r0 == null) goto L7;
        long r2 = r0.getRoomId();
    L9:
        Long r3 = Long.valueOf(r2);
    L10:
        Room r4 = this.a.c;
        if (r4 != null) goto L13;
        r1 = "";
    L15:
        ShareLiveMethod.k(r9, r3, r6, 1, r1);
        ShareLiveMethod r10 = this.a;
        Room r5 = r10.c;
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        ShareLiveMethod.j(r10, r5, r6, r7, r10.d);
        return;
    L13:
        if (r4 == null) goto L15;
        r1 = r4.getLabels();
        goto L15
    L7:
        r3 = null;
        goto L10
    L8:
        r2 = 0;
        goto L9
    }
}
