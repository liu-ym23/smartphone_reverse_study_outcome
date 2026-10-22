package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import com.bytedance.android.live.liveinteract.utils.g1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BaseTalkApplyListFragmentV2 a;

    public a(BaseTalkApplyListFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Boolean r10 = (Boolean) r9;
        if (g1.a() == false) goto L5;
        this.a.y.clear();
    L5:
        BaseTalkApplyListFragmentV2 r11 = this.a;
        int r0 = BaseTalkApplyListFragmentV2.M;
        yj0.f r1 = r11.e;
        if (r1 == null) goto L9;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a.f(r1, true, "audienceIncreasePriceApplySuccess", 50, "", r11.I);
        return;
    }
}
