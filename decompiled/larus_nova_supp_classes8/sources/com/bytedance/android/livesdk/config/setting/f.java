package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.cm;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(DataCenter r3) {
        Room r0 = null;
        if (r3 == null) goto L5;
        r0 = (Room) r3.get("data_room", null);
    L5:
        if (r3 == null) goto L16;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r3.get("data_is_portrait", r1), r1) == true) goto L16;
        if (r0 == null) goto L14;
        if (r0.isMediaRoom() == true) goto L16;
    L14:
        if (cm.a.getValue().intValue() <= 0) goto L16;
        return true;
    L16:
        return false;
    }
}
