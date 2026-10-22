package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Build;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Room r4) {
        Intrinsics.checkNotNullParameter(r4, "room");
        if (r4.getStreamUrl() != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L37;
        boolean r1 = VrUtils.x(r4);
        if (r4.isCompoundScene() == true) goto L20;
        StreamUrl r5 = r4.getStreamUrl();
        if (r5 == null) goto L16;
        LiveCoreSDKData r6 = r5.getLiveCoreSDKData();
        if (r6 == null) goto L16;
        LiveCoreSDKData.PullData r7 = r6.pullData;
        if (r7 == null) goto L16;
        int r8 = r7.getKind();
    L17:
        if (r8 > 0) goto L20;
        boolean r9 = false;
    L21:
        if (r1 == true) goto L25;
        if (r9 == true) goto L25;
        boolean r10 = false;
    L26:
        if (r10 == false) goto L28;
        return true;
    L28:
        if (Build.VERSION.SDK_INT >= 24) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == true) goto L39;
        ILivePlayerHostService r12 = is0.c.c().hostService();
        if (r12 == null) goto L35;
        r12.getColorWeakModelEffectInfo();
    L35:
        return false;
    L39:
        return true;
    L30:
        r11 = false;
    L25:
        r10 = true;
    L16:
        r8 = 0;
    L20:
        r9 = true;
        goto L21
    L37:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
