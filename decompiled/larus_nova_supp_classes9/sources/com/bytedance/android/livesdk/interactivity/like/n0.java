package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.livesdk.interactivity.api.like.utils.UserInfoDiggBridge;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n0 implements Action {
    public final /* synthetic */ DiggWidget a;

    public n0(DiggWidget r1) {
        this.a = r1;
    }

    public final void run() {
        UserInfoDiggBridge r0 = this.a.l;
        if (r0 == null) goto L9;
        u32.l r1 = r0.a();
        if (r1 == null) goto L7;
        r1.removeListener(r0);
    L7:
        r0.c();
        return;
    }
}
