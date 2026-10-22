package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ s a;

    public u(s r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ContributeShowResponse.ResponseData r3 = ((ContributeShowResponse) r2).getData();
        if (r3 == null) goto L10;
        ContributeShowResponse.OwnerHonorInfo r4 = r3.getOwnerHonorInfo();
        if (r4 == null) goto L11;
        s.a r0 = (s.a) ((q46.b) this.a).a;
        if (r0 == null) goto L12;
        r0.ta(r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
