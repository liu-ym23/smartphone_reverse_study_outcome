package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/openplatform/f;", "p1", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/api/openplatform/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudienceInteractPlayBehavior$registerShowPanelEvent$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.broadcastgame.api.openplatform.f, Unit> {
    public AudienceInteractPlayBehavior$registerShowPanelEvent$1(a r8) {
        super(1, r8, a.class, "onPanelEvent", "onPanelEvent(Lcom/bytedance/android/live/broadcastgame/api/openplatform/OpenGamePanelEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.live.broadcastgame.api.openplatform.f r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        a r0 = (a) ((CallableReference) this).receiver;
        int r1 = a.i;
        r0.getClass();
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"onPanelEvent: " + r7});
        if (Intrinsics.areEqual(r7.b, "from_toolbar") == false) goto L5;
    L8:
        String r8 = r7.b;
        int r3 = r8.hashCode();
        if (r3 == (-1271529498)) goto L22;
        if (r3 == (-949931101)) goto L19;
        if (r3 == 214339523) goto L16;
    L24:
        String r9 = "";
    L25:
        OpenPlatformMonitorUtils.c.g(r0.e(r0.b), r0.f(), r9);
        String r11 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r12 = r0.b;
        String r4 = null;
        if (r12 == null) goto L28;
        Long r13 = Long.valueOf(r12.f);
    L29:
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r5 = r0.b;
        if (r5 == null) goto L32;
        String r6 = r5.i;
    L33:
        if (r5 == null) goto L35;
        String r14 = r5.a;
    L36:
        if (r5 == null) goto L38;
        r4 = r5.n;
    L38:
        com.bytedance.android.live.broadcastgame.opengame.service.e.d(r13, r6, r14, r4);
    L40:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L42;
        com.bytedance.android.livesdk.user.f r15 = jc1.k.n(IUserService.class).user();
        Context r16 = r0.g;
        com.bytedance.android.livesdk.user.l.a r17 = new com.bytedance.android.livesdk.user.l.a();
        r17.a = s1.B(2131915990);
        r17.d = "open_platform";
        r17.c = -1;
        RxUtilKt.c(r15.login(r16, new com.bytedance.android.livesdk.user.l(r17)).subscribe(new g(r0), h.a), r0.c);
        return;
    L42:
        r0.g();
        return;
    L35:
        r14 = null;
        goto L36
    L32:
        r6 = null;
        goto L33
    L28:
        r13 = null;
        goto L29
    L16:
        if (r8.equals("from_temp_area") == false) goto L24;
        r9 = "temp_area";
        goto L25
    L19:
        if (r8.equals("from_mini_card") == false) goto L24;
        r9 = "card";
        goto L25
    L22:
        if (r8.equals("from_toolbar") == false) goto L24;
        r9 = NewBroadcastMonitor.STAGE.TOOLBAR;
        goto L25
    L5:
        if (Intrinsics.areEqual(r7.b, "from_mini_card") == true) goto L8;
        if (Intrinsics.areEqual(r7.b, "from_temp_area") == false) goto L40;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.broadcastgame.api.openplatform.f) r1);
        return Unit.INSTANCE;
    }
}
