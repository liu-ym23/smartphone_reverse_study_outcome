package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m2<T> implements Consumer {
    public final /* synthetic */ VSAnchorInfoWidget a;

    public m2(VSAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        FollowPair r5 = (FollowPair) r4;
        String r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getUserIdString();
    L6:
        Room r2 = this.a.o;
        if (r2 == null) goto L12;
        User r3 = r2.getOwner();
        if (r3 == null) goto L12;
        r0 = r3.getIdString();
    L12:
        if ((!Intrinsics.areEqual(r1, r0)) == true) goto L28;
        if (r5 == null) goto L20;
        int r6 = r5.followStatus;
        Room r7 = this.a.o;
        if (r7 == null) goto L20;
        User r8 = r7.getOwner();
        if (r8 == null) goto L20;
        r8.setFollowStatus(r6);
    L20:
        if (r5 != null) goto L22;
    L25:
        this.a.yq();
        return;
    L22:
        if (r5.getFollowStatus() != 0) goto L25;
        this.a.zq();
        return;
    L28:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
