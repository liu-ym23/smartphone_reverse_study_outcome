package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dislike.action.NotifyAction;
import com.bytedance.android.livesdk.dislike.layout.OptionDescItemLayoutV2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ DislikeOptionsBottomDialog a;

    public g(DislikeOptionsBottomDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        DislikeOptionsBottomDialog r0 = this.a;
        FollowInfo r13 = ((User) ((BaseResponse) r12).data).getFollowInfo();
        if (r13 == null) goto L5;
        long r1 = r13.getPushStatus();
    L6:
        r0.K = r1;
        HashMap r14 = bn2.k.a;
        int r3 = bn2.k.a(this.a.K);
        OptionDescItemLayoutV2 r15 = this.a.F;
        if (r15 == null) goto L9;
        r15.update(new nt1.c(r3, 2131920751, null, false, false, false, null, 124));
    L9:
        DislikeOptionsBottomDialog r16 = this.a;
        NotifyAction r2 = r16.G;
        if (r2 == null) goto L13;
        r2.f = r16.K;
    L13:
        if (r16.H == true) goto L20;
        Long r17 = Long.valueOf(r16.K);
        Room r4 = this.a.p1;
        if (r4 == null) goto L17;
        String r5 = r4.getOwnerUserIdString();
    L18:
        bn2.k.c(r17, r5, "long_press", this.a.H);
        this.a.H = true;
        return;
    L17:
        r5 = null;
        goto L18
    L20:
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
