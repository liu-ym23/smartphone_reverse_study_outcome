package com.bytedance.android.live.liveinteract.voicechat.match.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ ChatMatchDialog a;

    public l(ChatMatchDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ChatMatchDialog r0 = this.a;
        boolean r4 = Intrinsics.areEqual((Boolean) r3, Boolean.TRUE);
        int r1 = ChatMatchDialog.V;
        r0.ba0(r4);
    }
}
