package com.bytedance.android.live.profile.mysteriousman;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(UserProfileEvent r4) {
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.mysteryMan != 2) goto L8;
    L7:
        return 2;
    L8:
        IBaseUser r1 = r4.user;
        if (r1 != null) goto L11;
    L13:
        IBaseUser r2 = r4.user;
        if (r2 == null) goto L19;
        if (r2.isAnonymous() == true) goto L7;
    L19:
        if (r4.mysteryMan != 1) goto L21;
    L20:
        return 1;
    L21:
        IBaseUser r5 = r4.user;
        if (r5 != null) goto L24;
        return 0;
    L24:
        if (r5.getMysteryMan() == 1) goto L20;
        return 0;
    L11:
        if (r1.getMysteryMan() != 2) goto L13;
        goto L13
    }
}
