package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ Room a;

    public m(Room r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        Throwable r12 = (Throwable) r11;
        r12.printStackTrace();
        int r1 = 1;
        if ((r12 instanceof ApiException) == false) goto L5;
        int r0 = ((ApiException) r12).getErrorCode();
    L6:
        Integer r2 = Integer.valueOf(r0);
        String r3 = r12.getMessage();
        if (r3 != null) goto L9;
        r3 = "error";
    L9:
        Map<String, Pair<Integer, Integer>> r4 = AnchorVideoResolutionManager.a;
        String r5 = AnchorVideoResolutionManager.c;
        String r6 = this.a.getIdStr();
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        int r7 = l00.a.a;
        Intrinsics.checkNotNullParameter("change_resolution", "method");
        NewBroadcastMonitor.a r8 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_CLARITY_CHANGE, null, null, 14);
        if (r2 == null) goto L15;
        r1 = r2.intValue();
    L15:
        r8.l(r1);
        r8.c("change_resolution");
        r8.d(r5);
        r8.i(r5, "清晰度切换途径");
        r8.i(r5, "选择的清晰度");
        r8.i(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r3);
        r8.i("room_id", r6);
        r8.a().report();
        AnchorVideoResolutionManager.h("changeResolutionBySelectedResolutionButton failed : " + r12);
        return;
    L5:
        r0 = 1;
        goto L6
    }
}
