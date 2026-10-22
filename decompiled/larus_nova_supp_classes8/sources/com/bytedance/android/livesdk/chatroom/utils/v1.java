package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v1 implements com.bytedance.android.livesdk.log.filter.v {
    public static final v1 a = null;

    public v1() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new v1();
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        int r0 = r3.hashCode();
        if (r0 == (-425257212)) goto L16;
        if (r0 == 90939617) goto L13;
        if (r0 == 1252764889) goto L10;
        return;
    L10:
        if (r3.equals("livesdk_anchor_lottery_click") == false) goto L47;
    L17:
        IUserService r5 = jc1.k.f(IUserService.class);
        if (r5 == null) goto L23;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L23;
        String r7 = r6.n();
        if (r7 == null) goto L23;
    L24:
        r4.put("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
        UserType r8 = jc1.k.n(IInteractService.class).tryGetTargetUserType(r7);
        if (r8 == null) goto L42;
        int r9 = u1.a[r8.ordinal()];
        if (r9 != 1) goto L29;
        String r10 = SourceType.ANCHOR;
    L40:
        r4.put("user_type", r10);
        goto L42
    L29:
        if (r9 != 2) goto L31;
        r10 = "guest";
        goto L40
    L31:
        if (r9 != 3) goto L33;
    L37:
        r10 = "user";
        goto L40
    L33:
        if (r9 == 4) goto L37;
        throw new NoWhenBranchMatchedException();
    L42:
        if (jc1.k.n(IKtvService.class).isAudienceSingEnableSwitchOn() == false) goto L44;
        String r11 = "on";
    L45:
        r4.put("order_status", r11);
        return;
    L44:
        r11 = "off";
    L23:
        r7 = "0";
        goto L24
    L47:
        return;
    L13:
        if (r3.equals("livesdk_click_lottery") == true) goto L17;
        return;
    L16:
        if (r3.equals("livesdk_lottery_show") == true) goto L17;
    }
}
