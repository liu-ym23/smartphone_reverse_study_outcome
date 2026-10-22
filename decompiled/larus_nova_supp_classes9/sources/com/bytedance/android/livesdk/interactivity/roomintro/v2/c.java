package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.GameExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final Room a;
    public final LiveMode b;
    public final Long c;
    public final gz.b d;
    public final Function1<gz.b, Unit> e;
    public final Function1<Boolean, Unit> f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
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
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        gz.b r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r13 = (r9 + r11) * 31;
        Function1<gz.b, Unit> r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Function1<Boolean, Unit> r17 = this.f;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomIntroParamsV2(_room=" + this.a + ", _liveMode=" + this.b + ", _gameCategory=" + this.c + ", inputPoiStruct=" + this.d + ", poiChangeCallback=" + this.e + ", onRoomIntroChangeCallback=" + this.f + ")";
    }

    public final String a() {
        Room r0 = this.a;
        if (r0 == null) goto L7;
        String r1 = r0.getOwnerUserIdString();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return k.n(IUserService.class).user().n();
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

    public final Long d() {
        Room r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.id);
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

    /* JADX WARN: Multi-variable type inference failed */
    public c(Room r1, LiveMode r2, Long r3, gz.b r4, Function1<? super gz.b, Unit> r5, Function1<? super Boolean, Unit> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
