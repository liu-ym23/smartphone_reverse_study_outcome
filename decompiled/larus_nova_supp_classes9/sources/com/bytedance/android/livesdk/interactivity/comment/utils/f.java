package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final boolean a(IRoom r2) {
        if (r2 == null) goto L20;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L21;
        IRoomAuthStatus.IRoomAuthSpecialStyle r4 = r3.getRoomAuthSpecialStyle();
        if (r4 == null) goto L22;
        IRoomAuthStatusStyle r5 = r4.getChatStyle();
        if (r5 == null) goto L23;
        String r6 = r5.getContent();
        if (r6 != null) goto L13;
        return true;
    L13:
        if (r6.length() <= 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 != true) goto L25;
        return false;
    L25:
        return true;
    L15:
        r7 = false;
        goto L16
    L23:
        return true;
    L22:
        return true;
    L21:
        return true;
    L20:
        return true;
    }

    public static final String c(IRoom r0) {
        if (r0 == null) goto L11;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L11;
        IRoomAuthStatus.IRoomAuthSpecialStyle r2 = r1.getRoomAuthSpecialStyle();
        if (r2 == null) goto L11;
        IRoomAuthStatusStyle r3 = r2.getChatStyle();
        if (r3 == null) goto L11;
        String r4 = r3.getContent();
        if (r4 == null) goto L11;
        return r4;
    L11:
        return BuildConfig.FLAVOR;
    }

    public static final boolean b(IRoom r0, boolean r1) {
        if (r0 == null) goto L7;
        IRoomAuthStatus r2 = r0.getRoomAuthStatus();
        if (r2 != null) goto L6;
        return r1;
    L6:
        return r2.getEnableChat();
    L7:
        return r1;
    }
}
