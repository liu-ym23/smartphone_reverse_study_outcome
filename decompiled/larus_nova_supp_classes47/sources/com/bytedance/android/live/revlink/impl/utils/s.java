package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public final com.bytedance.android.livesdk.revenue.room.a a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.livesdk.revenue.service.user.a c;

    public final IRoom a() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.a;
        if (r0 == null) goto L5;
        IRoomBase r1 = r0.getCommonRoom();
    L7:
        return (IRoom) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final String c() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.a;
        if (r0 == null) goto L9;
        IRoomBase r1 = r0.getCommonRoom();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.getOwnerKt();
        if (r2 == null) goto L9;
        return r2.getIdString();
    L9:
        return null;
    }

    public final long d() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.a;
        if (r0 == null) goto L7;
        IRoomBase r1 = r0.getCommonRoom();
        if (r1 == null) goto L7;
        return IRoomKtKt.getId(r1);
    L7:
        return 0;
    }

    public final String e() {
        com.bytedance.android.livesdk.revenue.service.user.a r0 = this.c;
        if (r0 == null) goto L7;
        IBaseUser r1 = r0.b();
        if (r1 == null) goto L7;
        return r1.getIdString();
    L7:
        return null;
    }

    public final boolean b() {
        String r0 = e();
        com.bytedance.android.livesdk.revenue.room.a r1 = this.a;
        if (r1 == null) goto L9;
        IRoomBase r2 = r1.getCommonRoom();
        if (r2 == null) goto L9;
        IBaseUser r3 = r2.getOwnerKt();
        if (r3 == null) goto L9;
        String r4 = r3.getIdString();
    L11:
        return Intrinsics.areEqual(r0, r4);
    L9:
        r4 = null;
        goto L11
    }

    public s(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.livesdk.revenue.service.user.a r2) {
        this.b = r1;
        this.c = r2;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r3 = r1.getRoomContext();
    L6:
        this.a = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }
}
