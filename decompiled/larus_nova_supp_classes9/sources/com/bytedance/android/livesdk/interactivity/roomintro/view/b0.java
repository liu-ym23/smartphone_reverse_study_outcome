package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.GameExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 {
    public final Room a;
    public final LiveMode b;
    public final Long c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b0) == false) goto L12;
        b0 r4 = (b0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Room r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LiveMode r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomIntroParams(_room=" + this.a + ", _liveMode=" + this.b + ", _gameCategory=" + this.c + ")";
    }

    public final String a() {
        Room r0 = this.a;
        if (r0 == null) goto L7;
        String r1 = r0.getOwnerUserIdString();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return jc1.k.n(IUserService.class).user().n();
    }

    public final String c() {
        Room r0 = this.a;
        if (r0 != null) goto L5;
        LiveMode r1 = this.b;
    L6:
        int r2 = h1.a;
        return i1.a(r1);
    L5:
        r1 = r0.getStreamType();
        goto L6
    }

    public final Long b() {
        if (Intrinsics.areEqual("game", c()) == false) goto L10;
        Room r0 = this.a;
        if (r0 == null) goto L13;
        GameExtraInfo r1 = r0.gameExtraInfo;
        if (r1 == null) goto L13;
        return Long.valueOf(r1.getGameId());
    L13:
        return this.c;
    L10:
        return null;
    }

    public b0(Room r1, LiveMode r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
