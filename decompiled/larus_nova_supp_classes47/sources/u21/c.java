package u21;

import af2.d;
import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.f;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.g;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h;
import com.bytedance.android.live.revlink.impl.multianchor.pk.e;
import com.bytedance.android.live.revlink.impl.multianchor.pk.team.TeamStatus;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.t1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final e a;
    public final z21.a b;

    public c(z21.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.b = r2;
        this.a = e.a;
    }

    public final h a(c3 r8) {
        Intrinsics.checkNotNullParameter(r8, "meta");
        h r0 = new h();
        r0.a = e(r8);
        r0.b = c(e(r8), r8.getBattleScorePairList());
        r0.c = b(e(r8), r8.getBattleScorePairList());
        List<? extends af2.b> r1 = r8.getBattleScorePairList();
        Integer r2 = null;
        if (r1 != null) goto L5;
        Map<String, ? extends com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a> r3 = null;
    L6:
        r0.d = r3;
        c1 r4 = r8.getBattleSetting();
        if (r4 == null) goto L9;
        Boolean r5 = Boolean.valueOf(r4.getPunishOptimizeOn());
    L10:
        r0.e = r5;
        c1 r6 = r8.getBattleSetting();
        if (r6 == null) goto L13;
        Intrinsics.checkNotNullParameter(r6, "$this$bloodDisplayDuration");
        r2 = Integer.valueOf((int) RangesKt.coerceAtMost(r6.get_bloodDisplayDuration(), d.b(r6)));
    L13:
        r0.f = r2;
        f(r0, r8.getBattleSetting());
        return r0;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = new com.bytedance.android.live.revlink.impl.multianchor.pk.d(com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.c.b, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.b.b, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.C0142a.b).b(r1);
        goto L6
    }

    public final Map<String, Long> e(c3 r2) {
        Intrinsics.checkNotNullParameter(r2, "meta");
        e r0 = this.a;
        Map r3 = r2.getMultiPkTeam();
        r0.getClass();
        return e.b(r3);
    }

    public static void f(h r2, IBaseBattleSetting r3) {
        if (r3 == null) goto L4;
        IBattleBarConfig r4 = r3.getBarConfig();
    L5:
        if (r4 == null) goto L51;
        Intrinsics.checkNotNullParameter(r4, "$this$valid4TeamPk");
        boolean r0 = false;
        if (r4.getLeftColor().length() != 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
    L33:
        if (r0 != true) goto L52;
        String r6 = r4.getLeftColor();
        if (TextUtils.isEmpty(r6) == true) goto L38;
        Color.parseColor(r6);     // Catch: Throwable -> L43
    L38:
        String r7 = r4.getRightColor();
        if (TextUtils.isEmpty(r7) == true) goto L53;
        Color.parseColor(r7);     // Catch: Throwable -> L44
        return;
    L53:
        return;
    L54:
        return;
    L52:
        return;
    L13:
        if (r4.getRightColor().length() != 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == true) goto L33;
        if (r4.getLeftScoreViewColor().length() != 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L33;
        if (r4.getRightScoreViewColor().length() != 0) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == true) goto L33;
        Color.parseColor(r4.getLeftColor());     // Catch: Throwable -> L32
        Color.parseColor(r4.getRightColor());     // Catch: Throwable -> L32
        Color.parseColor(r4.getLeftScoreViewColor());     // Catch: Throwable -> L32
        Color.parseColor(r4.getRightScoreViewColor());     // Catch: Throwable -> L32
        r0 = true;
        goto L33
    L27:
        r10 = false;
        goto L28
    L21:
        r9 = false;
        goto L22
    L15:
        r8 = false;
        goto L16
    L9:
        r5 = false;
        goto L10
    L51:
        return;
    L4:
        r4 = null;
        goto L5
    }

    public final f b(Map<String, Long> r8, List<? extends af2.b> r9) {
        f r0 = null;
        if (r8 == null) goto L44;
        if (r9 == null) goto L44;
        IRoom r1 = this.b.a;
        if (r1 == null) goto L44;
        IBaseUser r2 = r1.getOwner();
        if (r2 == null) goto L44;
        String r3 = iz.a.a(r2);
        if (r3 == null) goto L44;
        Iterator<? extends af2.b> r10 = r9.iterator();
        af2.b r4 = null;
        af2.b r5 = null;
    L15:
        if (r10.hasNext() == false) goto L22;
        af2.b r6 = r10.next();
        if (Intrinsics.areEqual(af2.c.a(r6), r3) == false) goto L20;
        r4 = r6;
    L20:
        if (d(r3, af2.c.a(r6), r8) != TeamStatus.RIGHT) goto L15;
        r5 = r6;
        goto L15
    L22:
        if (r4 == null) goto L44;
        r0 = new f();
        r0.b = Integer.valueOf((int) r4.getMultiPkTeamScore());
        if (r5 == null) goto L27;
        int r12 = (int) r5.getMultiPkTeamScore();
    L28:
        r0.c = Integer.valueOf(r12);
        Boolean r13 = Boolean.valueOf(r4.isMultiPkTeamRelativeText());
        r0.a = r13;
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L31;
        r4.getMultiPkTeamScoreText();
    L31:
        Boolean r14 = r0.a;
        Boolean r15 = Boolean.FALSE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L35;
        r4.getMultiPkTeamScoreText();
    L35:
        if (Intrinsics.areEqual(r0.a, r15) == false) goto L38;
        if (r5 == null) goto L38;
        r5.getMultiPkTeamScoreText();
    L38:
        boolean r16 = r4 instanceof t1;
        if (r16 == false) goto L41;
        ((t1) r4).getCurAddScoreText();
    L41:
        if (r16 == false) goto L43;
        ((t1) r4).getBuffScoreRatio();
    L43:
        System.currentTimeMillis();
        goto L44
    L27:
        r12 = 0;
    L44:
        return r0;
    }

    public final Map<String, g> c(Map<String, Long> r8, List<? extends af2.b> r9) {
        IRoom r0 = this.b.a;
        HashMap r1 = null;
        if (r0 == null) goto L7;
        IBaseUser r2 = r0.getOwner();
        if (r2 == null) goto L7;
        String r3 = iz.a.a(r2);
    L8:
        if (r3 == null) goto L22;
        if (r9 == null) goto L22;
        if (r8 == null) goto L22;
        r1 = new HashMap();
        Iterator<? extends af2.b> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L22;
        af2.b r4 = r10.next();
        String r5 = af2.c.a(r4);
        if (r5 == null) goto L14;
        g r6 = new g();
        d(r3, r5, r8);
        if (r4.getScoreText() != null) goto L21;
        String.valueOf(0);
    L21:
        r6.a = Integer.valueOf((int) af2.c.b(r4));
        Unit r7 = Unit.INSTANCE;
        r1.put(r5, r6);
    L22:
        return r1;
    L7:
        r3 = null;
        goto L8
    }

    public static TeamStatus d(String r4, String r5, Map r6) {
        Intrinsics.checkNotNullParameter(r6, "userIdToTeamId");
        Long r7 = (Long) r6.get(r4);
        Long r8 = (Long) r6.get(r5);
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.longValue() == 0) goto L18;
        if (r8 != null) goto L8;
        return null;
    L8:
        if (r8.longValue() != 0) goto L11;
        return null;
    L11:
        if (Intrinsics.areEqual(r8, r7) == false) goto L14;
        return TeamStatus.LEFT;
    L14:
        return TeamStatus.RIGHT;
    L18:
        return null;
    }
}
