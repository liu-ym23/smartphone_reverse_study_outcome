package fo1;

import com.bytedance.android.live.room.l;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public final DataCenter a;
    public final RoomContext b;
    public final Room c;
    public final EnterRoomExtra d;
    public final LiveMode e;
    public final boolean f;
    public final boolean g;
    public final com.bytedance.android.live.room.h.b h;
    public final is2.f i;
    public final com.bytedance.android.livesdk.room.b j;
    public final wh1.a k;
    public final l l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L30;
        h r4 = (h) r3;
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
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        boolean r16 = this.f;
        ?? r17 = 1;
        ?? r18 = r16;
        if (r16 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (r15 + r18) * 31;
        boolean r20 = this.g;
        if (r20 == true) goto L29;
        r17 = r20;
    L29:
        int r21 = (r19 + r17) * 31;
        com.bytedance.android.live.room.h.b r22 = this.h;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        is2.f r25 = this.i;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        com.bytedance.android.livesdk.room.b r28 = this.j;
        if (r28 == null) goto L40;
        int r29 = r28.hashCode();
    L41:
        int r30 = (r27 + r29) * 31;
        wh1.a r31 = this.k;
        if (r31 == null) goto L44;
        int r32 = r31.hashCode();
    L45:
        int r33 = (r30 + r32) * 31;
        l r34 = this.l;
        if (r34 == null) goto L49;
        r1 = r34.hashCode();
    L49:
        return r33 + r1;
    L44:
        r32 = 0;
        goto L45
    L40:
        r29 = 0;
        goto L41
    L36:
        r26 = 0;
        goto L37
    L32:
        r23 = 0;
        goto L33
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
        return "InitParams(dataCenter=" + this.a + ", roomContext=" + this.b + ", room=" + this.c + ", roomExtra=" + this.d + ", liveMode=" + this.e + ", isNestedOutside=" + this.f + ", isPortraitView=" + this.g + ", liveStatusListener=" + this.h + ", interactionObserver=" + this.i + ", liveRoomContext=" + this.j + ", liveRoomInteractionContext=" + this.k + ", roomLogger=" + this.l + ")";
    }

    public h(DataCenter r2, RoomContext r3, Room r4, EnterRoomExtra r5, LiveMode r6, boolean r7, boolean r8, com.bytedance.android.live.room.h.b r9, com.bytedance.android.livesdk.chatroom.room.business.previewmerge.h r10, com.bytedance.android.livesdk.room.b r11, wh1.a r12, ii1.a r13) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r6, "liveMode");
        Intrinsics.checkNotNullParameter(r13, "roomLogger");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
