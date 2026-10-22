package com.bytedance.android.live.revlink.impl.mergepk.pkmulti;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(IBattleConfigSetting r5, PlayMode r6) {
        if (r5 == null) goto L7;
        if (r5.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L7;
        return "cooperation";
    L7:
        if (r5 == null) goto L11;
        w2 r2 = r5.getShellConfig();
        if (r2 == null) goto L11;
        long r3 = r2.getType();
    L13:
        if (r3 <= 0) goto L16;
        return "compete";
    L16:
        if (r6 != PlayMode.TEAM_PK) goto L19;
        return "team_pk";
    L19:
        if (e.a(r5) == true) goto L59;
        h9 r7 = null;
        if (r5 == null) goto L23;
        d4 r0 = r5.getCustomConfig();
    L24:
        if (r0 != null) goto L59;
        if (r5 != null) goto L28;
    L30:
        if (r5 == null) goto L32;
        String r1 = r5.getActivityId();
    L33:
        if (r1 == null) goto L42;
        String r4 = r5.getActivityId();
        if (r4 == null) goto L42;
        if (r4.length() <= 0) goto L39;
        boolean r8 = true;
    L40:
        if (r8 != true) goto L42;
        return "activity_pk";
    L39:
        r8 = false;
    L42:
        if (r5 == null) goto L44;
        r7 = r5.getSpecifyGiftConfig();
    L44:
        if (r7 == null) goto L46;
        return "focus_gift";
    L46:
        if (r5 != null) goto L48;
    L50:
        if (r5 != null) goto L52;
    L54:
        if (r5 != null) goto L56;
    L58:
        return "routine_pk";
    L56:
        if (r5.getModType() != PkBaseDataContext.PKModType.InteractPk.getType()) goto L58;
        return "interact_compete";
    L52:
        if (r5.getModType() != PkBaseDataContext.PKModType.CloudCollaborate.getType()) goto L54;
        return "link_screen";
    L48:
        if (r5.getModType() != PkBaseDataContext.PKModType.RobC.getType()) goto L50;
        return "c_position";
    L32:
        r1 = null;
        goto L33
    L28:
        if (r5.getModType() != PkBaseDataContext.PKModType.Vote.getType()) goto L30;
        return "vote";
    L23:
        r0 = null;
    L59:
        return "customize_pk";
    L11:
        r3 = 0;
        goto L13
    }
}
