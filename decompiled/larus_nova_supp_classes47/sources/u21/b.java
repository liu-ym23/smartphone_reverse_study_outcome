package u21;

import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d;
import com.bytedance.android.livesdk.link.model.c3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public b() {
    }

    public static Map a(List r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator r1 = r7.iterator();
    L7:
        if (r1.hasNext() == false) goto L26;
        af2.b r2 = (af2.b) r1.next();
        String r3 = af2.c.a(r2);
        if (r3 == null) goto L7;
        Iterator r4 = r7.iterator();
    L13:
        if (r4.hasNext() == false) goto L16;
        TextUtils.equals(((af2.b) r4.next()).getScoreText(), DataType.FALSE);
        goto L13
    L16:
        if (r2.isHugeRewardPk() == false) goto L18;
        r2.getScoreRelativeText();
    L20:
        if (r2.isHugeRewardPk() == true) goto L22;
        r2.getScoreRelativeText();
    L22:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c r5 = new com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c();
        r2.getBattleRank();
        r2.isHugeRewardPk();
        if (r2.getScoreText() != null) goto L25;
        String.valueOf(0);
    L25:
        r5.a = Integer.valueOf((int) af2.c.b(r2));
        Unit r6 = Unit.INSTANCE;
        r0.put(r3, r5);
        goto L7
    L18:
        r2.getScoreText();
        goto L20
    L26:
        return r0;
    }

    public static d b(c3 r5) {
        Map<String, ? extends com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a> r0 = null;
        if (r5 != null) goto L5;
        Map<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c> r1 = null;
    L6:
        if (r5 == null) goto L11;
        List<? extends af2.b> r6 = r5.getBattleScorePairList();
        if (r6 == null) goto L11;
        r0 = new com.bytedance.android.live.revlink.impl.multianchor.pk.d(com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.c.b, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.b.b, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.C0142a.b).a(r6);
    L11:
        d r7 = new d();
        r7.a = r1;
        r7.b = r0;
        return r7;
    L5:
        r1 = a(r5.getBattleScorePairList());
        goto L6
    }
}
