package com.bytedance.android.live.room.navi.userinfo_p.element;

import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ UserInfoFlipTabElement a;

    public e(UserInfoFlipTabElement r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IFollowPair r4 = (IFollowPair) r3;
        if (this.a.d == null) goto L16;
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L9;
    L11:
        if (r4 != null) goto L13;
        return;
    L13:
        if (r4.getFollowStatus() != 0) goto L19;
        com.bytedance.android.livesdk.interactivity.api.base.b.a r5 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
        q r0 = q.a;
        r5.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.f();
        return;
    L19:
        return;
    L9:
        if (r4.getFollowStatus() != 2) goto L11;
    L10:
        com.bytedance.android.livesdk.interactivity.api.base.b.a r6 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
        q r1 = q.a;
        r6.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.b();
        return;
    L6:
        if (r4.getFollowStatus() == 1) goto L10;
    }
}
