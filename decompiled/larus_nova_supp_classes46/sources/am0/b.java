package am0;

import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.message.model.w1;
import com.bytedance.android.livesdk.message.model.x1;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s71.d;
import s71.e;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements g<v61.a> {
    public final w1 a;
    public final x1 b;

    public b(w1 r1, x1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final d a(v61.a r2, c r3) {
        v61.a r4 = (v61.a) r3;
        Intrinsics.checkNotNullParameter(r2, "us");
        Intrinsics.checkNotNullParameter(r4, "others");
        if (r2.k < r4.k) goto L6;
        return d.c.a;
    L6:
        if (Intrinsics.areEqual(r4.j, CardTypeAndPriority.AudienceLink.getType()) == true) goto L25;
        if (Intrinsics.areEqual(r4.j, CardTypeAndPriority.VideoTalk.getType()) == true) goto L25;
        if (Intrinsics.areEqual(r4.j, CardTypeAndPriority.DrawAndGuess.getType()) == true) goto L25;
        if (Intrinsics.areEqual(r4.j, CardTypeAndPriority.WatchVideo.getType()) == true) goto L25;
        w1 r5 = this.a;
        if (r5 == null) goto L30;
        int r6 = r5.type;
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L28;
        return d.a.a;
    L28:
        return d.a.a;
    L29:
        return new d.b(0);
    L30:
        return new d.b(0);
    L25:
        return d.d.a;
    }

    public final e b(c r7, v61.a r8) {
        v61.a r9 = (v61.a) r7;
        Intrinsics.checkNotNullParameter(r9, "us");
        Intrinsics.checkNotNullParameter(r8, "winner");
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r3 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_fail_show");
        r3.b("type", r9.j.toString());
        r3.b("reason", "2");
        r3.b("extra", "winner card: " + r8.j.toString() + ", winner card priority: " + r8.k + ", us priority: " + r9.k);
        Unit r4 = Unit.INSTANCE;
        r0.b(r3.a());
    L7:
        if (r9.isShowing() == false) goto L13;
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L13;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r5 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_destroy");
        r5.b("position", Integer.valueOf(CommonCardConstant.Position.BOTTOM_RIGHT.getValue()));
        r5.b("type", r9.j.toString());
        r5.b("reason", "3");
        Unit r10 = Unit.INSTANCE;
        r1.b(r5.a());
    L13:
        if (Intrinsics.areEqual(r8.j, CardTypeAndPriority.AudienceLink.getType()) == true) goto L32;
        if (Intrinsics.areEqual(r8.j, CardTypeAndPriority.VideoTalk.getType()) == true) goto L32;
        if (Intrinsics.areEqual(r8.j, CardTypeAndPriority.DrawAndGuess.getType()) == true) goto L32;
        if (Intrinsics.areEqual(r8.j, CardTypeAndPriority.WatchVideo.getType()) == true) goto L32;
        x1 r11 = this.b;
        if (r11 == null) goto L36;
        int r12 = r11.type;
        if (r12 == 1) goto L35;
        if (r12 == 2) goto L34;
        return s71.a.a;
    L34:
        return s71.a.a;
    L35:
        return new s71.c(0);
    L36:
        return s71.a.a;
    L32:
        return s71.b.a;
    }
}
