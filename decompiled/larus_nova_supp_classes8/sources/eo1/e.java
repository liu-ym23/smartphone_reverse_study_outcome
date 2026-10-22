package eo1;

import com.bytedance.android.live.room.h;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hh1.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final DataCenter a;
    public final RoomContext b;
    public final Room c;
    public final EnterRoomExtra d;
    public final LiveMode e;
    public final com.bytedance.android.live.pushstream.d f;
    public final v0 g;
    public final h.b h;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L22;
        e r4 = (e) r3;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        DataCenter r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RoomContext r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Room r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        EnterRoomExtra r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        LiveMode r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        com.bytedance.android.live.pushstream.d r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        v0 r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        h.b r22 = this.h;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
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
        return "InitParams(dataCenter=" + this.a + ", roomContext=" + this.b + ", room=" + this.c + ", roomExtra=" + this.d + ", liveMode=" + this.e + ", liveStream=" + this.f + ", videoClientFactory=" + this.g + ", liveStatusListener=" + this.h + ")";
    }

    public e(DataCenter r2, RoomContext r3, Room r4, LiveMode r5, com.bytedance.android.live.pushstream.d r6, h.b r7) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "liveMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = r5;
        this.f = r6;
        this.g = null;
        this.h = r7;
    }
}
