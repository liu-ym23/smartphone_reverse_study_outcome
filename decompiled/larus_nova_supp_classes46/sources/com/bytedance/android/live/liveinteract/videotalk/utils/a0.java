package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.profit.dress.config.LinkmicPlayMode;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 {
    public static final int b(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, PbRequest.SwitchType.ROOM);
        z5 r2 = IRoomKt_androidKt.getLinkerDetailKt(r1);
        if (r2 != null) goto L5;
        return 0;
    L5:
        if (ILinkerDetailKt.getUiLayoutExt(r2) != 0) goto L7;
        return 0;
    L7:
        return ILinkerDetailKt.getUiLayoutExt(r2);
    }

    public static final int a(int r5, IRoom r6) {
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        z5 r7 = IRoomKt_androidKt.getLinkerDetailKt(r6);
        if (r7 != null) goto L5;
        return 0;
    L5:
        if (ILinkerDetailKt.getUiLayoutExt(r7) != 0) goto L7;
        List r8 = ILinkerDetailKt.getPlayModesEx(r7);
        if (r8 == null) goto L15;
        List r9 = r8;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        r1.add(Long.valueOf(((Number) r10.next()).longValue()));
        goto L12
    L14:
        List r11 = CollectionsKt.toList(r1);
    L17:
        if (r11 != null) goto L19;
    L41:
        if (r5 != 12) goto L44;
        return 5;
    L44:
        if (r5 != 16) goto L57;
    L45:
        return 51;
    L57:
        return 0;
    L19:
        if (r11.isEmpty() == true) goto L41;
        if (r11.contains(Long.valueOf(LinkmicPlayMode.DYNAMIC_WINDOW_LAYOUT.getValue())) == false) goto L27;
        if (r5 != 12) goto L50;
        return 2;
    L50:
        return 7;
    L27:
        if (r11.contains(Long.valueOf(LinkmicPlayMode.C_POSITION_LAYOUT.getValue())) == false) goto L32;
        if (r5 != 12) goto L52;
        return 3;
    L52:
        return 6;
    L32:
        if (r11.contains(Long.valueOf(LinkmicPlayMode.VIDEO_CHAT_FLOAT_WINDOW_LAYOUT.getValue())) == false) goto L36;
        if (r5 == 12) goto L36;
        return 1;
    L36:
        if (r11.contains(Long.valueOf(LinkmicPlayMode.VIDEO_TEAM_FIGHT_LAYOUT.getValue())) == false) goto L39;
        return 4;
    L39:
        if (r11.contains(Long.valueOf(LinkmicPlayMode.LINK_ROOM_FIGHT.getValue())) == true) goto L45;
        return 0;
    L15:
        r11 = null;
        goto L17
    L7:
        return ILinkerDetailKt.getUiLayoutExt(r7);
    }
}
