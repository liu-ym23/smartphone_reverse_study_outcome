package com.bytedance.android.livesdk.event;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.paramtransfer.utils.RoomParamTransferUtils;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements is2.g {
    public boolean a;

    public p() {
    }

    public final String businessTypeV2() {
        return "";
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    public final String getSpm() {
        return null;
    }

    public final boolean isIgnored() {
        return false;
    }

    public final void onOrientationChangeV2(int r1) {
    }

    public final void onRoomBackgroundV2() {
    }

    public final void onRoomPrepareV2(boolean r1) {
    }

    public final void onRoomEnterV2(Room r2, ls2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "enterExtra");
        is2.g.a.a(r2, r3);
        RoomOthersData r4 = r2.others;
        if (r4 == null) goto L5;
        List r5 = r4.getMetricTrackerData();
    L7:
        if (this.a == true) goto L10;
        this.a = true;
        RoomParamTransferUtils.INSTANCE.updateInnerTracker(r5);
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void onRoomPreloadV2(Room r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "room");
        Intrinsics.checkNotNullParameter(r1, "room");
        RoomOthersData r3 = r1.others;
        if (r3 == null) goto L5;
        List r4 = r3.getMetricTrackerData();
    L7:
        if (this.a == true) goto L11;
        if (r4 == null) goto L12;
        this.a = true;
        RoomParamTransferUtils.INSTANCE.updateInnerTracker(r4);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onRoomExitV2(long r1, String r3, boolean r4, Room r5, ls2.e r6, boolean r7, EndReason r8) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r8, "reason");
        is2.g.a.b(r3, r6, r8);
        this.a = false;
    }
}
