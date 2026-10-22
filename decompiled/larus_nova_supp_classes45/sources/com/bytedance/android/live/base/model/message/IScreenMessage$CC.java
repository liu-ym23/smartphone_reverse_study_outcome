package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;

/* JADX INFO: renamed from: com.bytedance.android.live.base.model.message.IScreenMessage$-CC, reason: invalid class name */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class IScreenMessage$CC {
    public static /* bridge */ /* synthetic */ boolean $default$canPin(h4 r0) {
        return false;
    }

    public static /* bridge */ /* synthetic */ Map $default$getBuriedPoint(h4 r0) {
        return null;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinBaseMessageId(h4 r2) {
        return 0;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinCommenterId(h4 r2) {
        return 0;
    }

    public static /* bridge */ /* synthetic */ long $default$getPinMessageShowArea(h4 r2) {
        return 2;
    }

    public static IBaseUser $default$getPinUser(h4 r0) {
        return r0.getChatUserInfo();
    }
}
