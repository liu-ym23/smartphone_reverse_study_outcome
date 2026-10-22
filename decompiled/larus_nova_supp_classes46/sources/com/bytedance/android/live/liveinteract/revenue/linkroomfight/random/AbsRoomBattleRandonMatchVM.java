package com.bytedance.android.live.liveinteract.revenue.linkroomfight.random;

import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject;
import ih0.h;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/random/AbsRoomBattleRandonMatchVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/google/gson/JsonObject;", "updateExtraInfo", "Lih0/h;", "updateCallback", "", "handleLynxCmd", "onDestroy", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsRoomBattleRandonMatchVM extends ViewModel {
    public abstract void handleLynxCmd(JsonObject r1, h r2);

    public abstract void onDestroy();

    public AbsRoomBattleRandonMatchVM() {
    }

    public static /* synthetic */ void handleLynxCmd$default(AbsRoomBattleRandonMatchVM r0, JsonObject r1, h r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.handleLynxCmd(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleLynxCmd");
    }
}
