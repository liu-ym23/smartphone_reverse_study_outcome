package b51;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final boolean a(com.bytedance.android.livesdk.revenue.service.room.c r8) {
        if (r8 == null) goto L4;
        com.bytedance.android.livesdk.revenue.room.a r9 = r8.getRoomContext();
    L6:
        if (r9 == null) goto L10;
        IRoomBase r1 = r9.getCommonRoom();
        if (r1 == null) goto L10;
        boolean r2 = r1.isLiveTypeAudio();
    L11:
        if (r9 == null) goto L13;
        boolean r3 = r9.getCommonIsMediaRoom();
    L15:
        if (r9 == null) goto L23;
        IRoomBase r10 = r9.getCommonRoom();
        if (r10 == null) goto L23;
        IRoomSpecificSceneTypeInfo r12 = r10.getSceneTypeInfo();
        if (r12 == null) goto L23;
        if (r12.isLandscapeVerticalRoom() != 1) goto L23;
        boolean r13 = true;
    L24:
        b r4 = b.c0;
        r4.getClass();
        if (((Number) b.W.getValue(r4, b.a[47])).intValue() == 0) goto L31;
        if (r2 == true) goto L32;
        if (r3 == true) goto L33;
        if (r13 == true) goto L34;
        return true;
    L34:
        return false;
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    L23:
        r13 = false;
        goto L24
    L13:
        r3 = false;
    L10:
        r2 = false;
        goto L11
    L4:
        r9 = null;
        goto L6
    }
}
