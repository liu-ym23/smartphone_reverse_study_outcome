package com.bytedance.android.livesdk.floatview;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements is2.g {
    public final String businessTypeV2() {
        return "live_float_window";
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

    public final void onRoomEnterV2(Room r2, ls2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "enterExtra");
    }

    public final void onRoomExitV2(long r1, String r3, boolean r4, Room r5, ls2.e r6, boolean r7, EndReason r8) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r8, "reason");
    }

    public final void onRoomPrepareV2(boolean r1) {
    }

    public g() {
    }

    public final void onRoomPreloadV2(Room r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "room");
        Intrinsics.checkNotNullParameter(r1, "room");
    }
}
