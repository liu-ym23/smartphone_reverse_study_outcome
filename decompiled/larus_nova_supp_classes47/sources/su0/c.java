package su0;

import com.bytedance.android.live.profit.miniplay.SupportLiveMode;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.revenue.room.RevLiveMode;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import dq2.p;
import gd0.v;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements a, o {
    public final com.bytedance.android.live.revenue.core.a a;
    public final k b;

    public final void onStop() {
    }

    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r0 = this.a;
        r0.b(a.class, r0.getScope());
    }

    @Override // su0.a
    public final int pf() {
        ILiveMode r0 = this.b.getLiveMode();
        DataCenter r1 = this.b.getDataCenter();
        Intrinsics.checkNotNullParameter(r0, "liveMode");
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        String r2 = r0.getSceneName();
        if (Intrinsics.areEqual(r2, RevLiveMode.VIDEO.getSceneName()) == false) goto L6;
        int r3 = SupportLiveMode.VIDEO.getValue();
    L18:
        int r4 = 0;
        Integer r5 = (Integer) r1.get("data_link_state", 0);
        if (r5 == null) goto L21;
        int r6 = r5.intValue();
    L22:
        vh6.c.b(d.class).Qc().c();
        if (v.a(r6, 4) == false) goto L25;
        r4 = 1;
    L50:
        int r7 = b.a(r3, r4);
        jy0.b.a("MiniPlayScene", "liveMode: " + r3 + ", linkmicScene: " + r4 + ", miniPlayScene: " + r7);
        return r7;
    L25:
        vh6.c.b(d.class).Qc().e();
        if (v.a(r6, 2) == false) goto L32;
        p r8 = vh6.c.b(d.class).getInteractAudienceService();
        if (r8 == null) goto L32;
        if (r8.a() != true) goto L32;
        r4 = 4;
    L32:
        vh6.c.b(d.class).Qc().h();
        if (v.a(r6, 16) == false) goto L35;
        r4 = 3;
        goto L50
    L35:
        vh6.c.b(d.class).Qc().i();
        if (v.a(r6, 32) == false) goto L38;
        r4 = vh6.c.b(d.class).getCurrentScene();
        goto L50
    L38:
        vh6.c.b(d.class).Qc().l();
        if (v.a(r6, 8) == false) goto L41;
        r4 = vh6.c.b(d.class).getCurrentScene();
        goto L50
    L41:
        vh6.c.b(d.class).Qc().k();
        if (v.a(r6, 64) == false) goto L44;
        r4 = 7;
        goto L50
    L44:
        vh6.c.b(d.class).Qc().g();
        if (v.a(r6, 128) == false) goto L47;
        r4 = 14;
        goto L50
    L47:
        vh6.c.b(d.class).Qc().f();
        if (v.a(r6, DefaultConfig.MAX_CACHE_ENTRIES) == false) goto L50;
        r4 = 17;
        goto L50
    L21:
        r6 = 0;
        goto L22
    L6:
        if (Intrinsics.areEqual(r2, RevLiveMode.THIRD_PARTY.getSceneName()) == false) goto L9;
        r3 = SupportLiveMode.OBS.getValue();
        goto L18
    L9:
        if (Intrinsics.areEqual(r2, RevLiveMode.AUDIO.getSceneName()) == false) goto L12;
        r3 = SupportLiveMode.AUDIO.getValue();
        goto L18
    L12:
        if (Intrinsics.areEqual(r2, RevLiveMode.SCREEN_RECORD.getSceneName()) == false) goto L15;
        r3 = SupportLiveMode.SCREEN_RECORD.getValue();
        goto L18
    L15:
        if (Intrinsics.areEqual(r2, RevLiveMode.MEDIA.getSceneName()) == false) goto L17;
        r3 = SupportLiveMode.MEDIA.getValue();
        goto L18
    L17:
        r3 = SupportLiveMode.UNKNOWN.getValue();
        goto L18
    }

    public c(com.bytedance.android.live.revenue.core.a r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.a = r2;
        this.b = r3;
    }

    @Override // su0.a
    public final int X9(int r1, int r2) {
        return b.a(r1, r2);
    }
}
