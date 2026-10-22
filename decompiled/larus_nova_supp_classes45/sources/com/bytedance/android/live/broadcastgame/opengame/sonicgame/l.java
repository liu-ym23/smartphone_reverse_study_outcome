package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.scoreboard.EventName;
import com.bytedance.android.live.profit.scoreboard.o;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements com.bytedance.android.live.profit.scoreboard.d {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    public final void b(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        RxUtilKt.c(r2, this.a.b);
    }

    public final void a(EventName r9, o r11) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r11, "message");
        int r0 = q.a;
        boolean r1 = true;
        q.f("OpenAPI", new Object[]{"on score counting event message = " + r11});
        int r12 = j.a[r9.ordinal()];
        if (r12 != 1) goto L5;
        MainThreadPostUtils.d(this.a.c);
        k.a(this.a, 1, r11);
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r13 = AudienceGameContext.a.a();
        if (r13 == null) goto L36;
        m<Boolean> r14 = r13.getDisableEntrance();
        if (r14 == null) goto L36;
        Boolean r15 = (Boolean) r14.getValue();
        if (r15 == null) goto L36;
        boolean r16 = r15.booleanValue();
    L37:
        if (r16 == false) goto L40;
        q.f("OpenAPI", new Object[]{"ON_ROUND_MESSAGE_START abort by EnterRoomMessageReceiver.disableEntrance"});
        return;
    L40:
        boolean r17 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class).k2(this.a.d.m.i);
        return;
    L36:
        r16 = false;
        goto L37
    L5:
        if (r12 == 2) goto L11;
        if (r12 == 3) goto L9;
        System.out.println();
        return;
    L9:
        k.a(this.a, 3, r11);
        return;
    L11:
        if (r11.b() != (-1)) goto L14;
        return;
    L14:
        if (this.a.d.o == true) goto L16;
    L28:
        k.a(this.a, 2, r11);
        return;
    L16:
        if ((!r11.c().isEmpty()) == false) goto L25;
        Iterator r18 = r11.c().iterator();
    L19:
        if (r18.hasNext() == false) goto L25;
        com.bytedance.android.live.profit.scoreboard.m r2 = (com.bytedance.android.live.profit.scoreboard.m) r18.next();
        if (r2.a() == true) goto L19;
        if (CastLongProtector.parseLong(r2.b()) != this.a.d.m.a) goto L19;
    L26:
        if (r1 == false) goto L28;
        MainThreadPostUtils.c(this.a.c, ((long) r11.b()) * 1000);
    L25:
        r1 = false;
        goto L26
    }
}
