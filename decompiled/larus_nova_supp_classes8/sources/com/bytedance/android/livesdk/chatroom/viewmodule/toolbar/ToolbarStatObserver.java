package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarStatObserver implements is2.g {
    public final RoomBaseSession a;

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

    public ToolbarStatObserver(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.a = r2;
    }

    public final void onRoomPrepareV2(boolean r5) {
        boolean r0 = true;
        if (this.a.getHasRoomPrepare() == false) goto L5;
    L12:
        ToolbarLoadTimeStatsVM.a r6 = ToolbarLoadTimeStatsVM.Companion;
        Function0<Unit> r3 = new AnonymousClass2(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "action");
        if (ToolbarLoadTimeStatsVM.a.c() > 0) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L21;
        r3.invoke();
        return;
    L21:
        return;
    L5:
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L12;
        ToolbarLoadTimeStatsVM.a r7 = ToolbarLoadTimeStatsVM.Companion;
        Function0<Unit> r4 = new AnonymousClass1(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "action");
        if (ToolbarLoadTimeStatsVM.a.c() > 0) goto L10;
        r0 = false;
    L10:
        if (r0 == false) goto L19;
        r4.invoke();
        return;
    }

    public final void onRoomEnterV2(Room r2, ls2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "enterExtra");
        is2.g.a.a(r2, r3);
    }

    public final void onRoomPreloadV2(Room r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "room");
        Intrinsics.checkNotNullParameter(r1, "room");
    }

    public final void onRoomExitV2(long r1, String r3, boolean r4, Room r5, ls2.e r6, boolean r7, EndReason r8) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r8, "reason");
        is2.g.a.b(r3, r6, r8);
    }
}
