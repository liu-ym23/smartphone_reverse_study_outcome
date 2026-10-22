package com.bytedance.android.live.liveinteract.voicechat.match.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ ChatMatchDialog a;

    public m(ChatMatchDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
        ChatMatchDialog r3 = this.a;
        int r0 = ChatMatchDialog.V;
        r3.Z90(0);
        return;
    }
}
