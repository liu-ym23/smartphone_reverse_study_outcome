package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.d;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DanmakuCarnivalManager$onStart$1 implements js0.b {
    public final /* synthetic */ DanmakuCarnivalManager a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.barrage.model.a b;

    public final void onSuccess(String r13) {
        Intrinsics.checkNotNullParameter(r13, "track");
        this.a.l("onStart id=" + this.b.getMessageId() + " contour=" + this.b.o());
        DanmakuCarnivalManager r14 = this.a;
        boolean r0 = true;
        r14.e = true;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r1 = this.b;
        if ((r1 instanceof d) == false) goto L39;
        long r2 = r1.getMessageId();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r15 = this.a.b;
        if (r15 == null) goto L14;
        n<d> r16 = r15.getChatCarnivalMessage();
        if (r16 == null) goto L14;
        d r17 = (d) r16.getValue();
        if (r17 == null) goto L14;
        if (r2 != r17.getMessageId()) goto L14;
        boolean r18 = false;
    L15:
        DanmakuCarnivalManager r3 = this.a;
        r3.h = this.b;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r4 = r3.b;
        if (r4 == null) goto L18;
        DanmakuCarnivalManager.r(r4, new DanmakuCarnivalManager$onStart$1$onSuccess$1(this));
    L18:
        ((d) this.b).getClass();
        long r5 = (com.bytedance.android.livesdk.utils.ntp.a.a + System.currentTimeMillis()) - (((d) this.b).x() * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        DanmakuCarnivalManager r6 = this.a;
        if (r18 == false) goto L28;
        if (a0.l(r6.x, true) == false) goto L23;
    L31:
        r6.g = r0;
        DanmakuCarnivalManager r19 = this.a;
        o22.c r7 = r19.m;
        if (r7 == null) goto L34;
        r7.g(r19, this.b, r19.g);
    L34:
        DanmakuCarnivalManager r110 = this.a;
        if (r110.g == false) goto L37;
        StateMachine<DanmakuCarnivalManager.State, DanmakuCarnivalManager.Event, DanmakuCarnivalManager.SideEffect> r111 = r110.v;
        DanmakuCarnivalManager.Event.WarmUp r8 = DanmakuCarnivalManager.Event.WarmUp.INSTANCE;
        StateMachine.a r9 = StateMachine.c;
        r111.d(r8, null);
    L38:
        this.a.q("comment_carnival");
    L47:
        if (v.a() == true) goto L49;
        return;
    L49:
        if (CarnivalAutoTestUtil.a == true) goto L51;
        return;
    L51:
        if (CarnivalAutoTestUtil.a() != null) goto L53;
        return;
    L53:
        if ((this.b instanceof j) == false) goto L55;
        String r112 = "EcomCarnival";
    L56:
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        return;
    L55:
        r112 = "ChatCarnival";
        goto L56
    L37:
        r110.s.run();
        goto L38
    L23:
        if (((d) this.b).x() == 0) goto L31;
        if (r5 < 2000) goto L31;
    L30:
        r0 = false;
        goto L31
    L28:
        if (r5 >= 2000) goto L30;
    L14:
        r18 = true;
        goto L15
    L39:
        r14.q("general_carnival");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r113 = this.a.b;
        if (r113 == null) goto L42;
        DanmakuCarnivalManager.r(r113, DanmakuCarnivalManager$onStart$1$onSuccess$2.INSTANCE);
    L42:
        DanmakuCarnivalManager r114 = this.a;
        o22.c r10 = r114.m;
        if (r10 == null) goto L45;
        r10.g(r114, this.b, true);
    L45:
        StateMachine<DanmakuCarnivalManager.State, DanmakuCarnivalManager.Event, DanmakuCarnivalManager.SideEffect> r115 = this.a.v;
        DanmakuCarnivalManager.Event.WarmUp r11 = DanmakuCarnivalManager.Event.WarmUp.INSTANCE;
        StateMachine.a r20 = StateMachine.c;
        r115.d(r11, null);
        goto L47
    }

    public DanmakuCarnivalManager$onStart$1(DanmakuCarnivalManager r1, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
