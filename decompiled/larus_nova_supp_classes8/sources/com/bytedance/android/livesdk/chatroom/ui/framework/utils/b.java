package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r1) {
        if (r1 == null) goto L4;
        Room r0 = z.o(r1);
    L5:
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (VSMediaUIConfigHelper.b(r1) == false) goto L9;
        return true;
    L4:
        r0 = null;
        goto L5
    }
}
