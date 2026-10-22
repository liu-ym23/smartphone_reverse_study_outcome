package u21;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.v2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import x21.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final c a;

    public a(z21.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = new c(r2);
    }

    public static boolean d(IBaseBattleSetting r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        IBattleConfigSetting r8 = r7.getBattleConfigSetting();
        if (r8 == null) goto L16;
        v2 r9 = r8.getSelfSettingRate();
        if (r9 == null) goto L17;
        long r1 = 99;
        long r3 = r9.getPkValueType();
        if (1 <= r3) goto L13;
        return false;
    L13:
        if (r1 < r3) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    }

    public static String b(d r2, IBaseBattleSetting r3) {
        Intrinsics.checkNotNullParameter(r2, "pkState");
        String r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof d.c) == false) goto L11;
        h3 r4 = r3.getTitleConfig();
        if (r4 != null) goto L24;
        return null;
    L24:
        return r4.getContent();
    L11:
        if ((r2 instanceof d.b) == false) goto L25;
        h3 r5 = r3.getPunishConfig();
        if (r5 == null) goto L15;
        r0 = r5.getContent();
    L15:
        if (r0 != null) goto L17;
    L21:
        d51.c r6 = d51.c.A0;
        r6.getClass();
        return (String) d51.c.j.getValue(r6, d51.c.a[8]);
    L17:
        if (r0.length() != 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L21;
        return r0;
    L19:
        r7 = false;
        goto L20
    L25:
        return null;
    }

    public static k c(d r2, IBaseBattleSetting r3) {
        Intrinsics.checkNotNullParameter(r2, "pkState");
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof d.c) == false) goto L11;
        h3 r4 = r3.getTitleConfig();
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.getNewIcon();
    L11:
        if ((r2 instanceof d.b) == false) goto L18;
        h3 r5 = r3.getPunishConfig();
        if (r5 != null) goto L15;
        return null;
    L15:
        return r5.getNewIcon();
    L18:
        return null;
    }

    public final FeedMultiPlayMode a(IBaseBattleSetting r5, Map<String, Long> r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        IBattleConfigSetting r0 = r5.getBattleConfigSetting();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L30;
        IBattleConfigSetting r7 = r5.getBattleConfigSetting();
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == true) goto L31;
        this.a.getClass();
        if (r6 != null) goto L24;
    L26:
        if (r1 == false) goto L29;
        return FeedMultiPlayMode.TEAM_PK;
    L29:
        return FeedMultiPlayMode.PERSONAL_PK;
    L24:
        if ((!r6.isEmpty()) == false) goto L26;
        r1 = true;
        goto L26
    L31:
        return FeedMultiPlayMode.BREAK_THROUGH;
    L16:
        if (r7.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L18;
        r8 = true;
        goto L19
    L30:
        return FeedMultiPlayMode.VOTE;
    L8:
        if (r0.getModType() != PkBaseDataContext.PKModType.Vote.getType()) goto L10;
        r2 = true;
        goto L11
    }
}
