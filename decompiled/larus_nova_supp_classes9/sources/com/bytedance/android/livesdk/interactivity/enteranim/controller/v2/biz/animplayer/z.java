package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.u0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EnterAnimAppLogger;
import com.bytedance.android.livesdk.message.model.pg;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements com.bytedance.android.livesdk.interactivity.enteranim.utils.i {
    public final /* synthetic */ a a;
    public final /* synthetic */ h3 b;
    public final /* synthetic */ u0 c;
    public final /* synthetic */ ViewGroup d;
    public final /* synthetic */ BaseWindScreenAnimEnterTrayView e;
    public final /* synthetic */ a0 f;

    public final void a() {
        if (this.b.getShowTime() <= 0) goto L5;
        long r0 = System.currentTimeMillis() - this.b.getShowTime();
        EnterAnimAppLogger.e(this.b, r0);
    L5:
        this.d.removeView(this.e);
        ((v72.c.a) this.a).a();
        com.bytedance.android.livesdk.interactivity.enteranim.utils.k r1 = this.f.c;
        h3 r2 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "message");
        com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.getClass();
        if (r2 == null) goto L10;
        pg.c r3 = r2.M();
        if (r3 == null) goto L10;
        boolean r4 = com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.a(r3);
    L11:
        if (r4 == true) goto L13;
        return;
    L13:
        if (r1.b != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r1.a, r2) == false) goto L17;
        r1.a = null;
        ALogger.d("EnterAnimExtraHeightUpdater", "on end special enter anim extra height: 0");
        r1.b.put("data_special_enter_anim_extra_height", 0);
        return;
    L17:
        ALogger.d("EnterAnimExtraHeightUpdater", "current show is not this end, ignore");
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void b() {
        a r0 = this.a;
        if (r0 == null) goto L5;
        ((v72.c.a) r0).b();
    L5:
        com.bytedance.android.livesdk.interactivity.enteranim.utils.k r1 = this.f.c;
        h3 r2 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "message");
        if (r1.b == null) goto L16;
        com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.getClass();
        if (r2 == null) goto L12;
        pg.c r3 = r2.M();
        if (r3 == null) goto L12;
        boolean r4 = com.bytedance.android.livesdk.interactivity.common.enterAnim.b.a.a(r3);
    L13:
        if (r4 == false) goto L17;
        r1.a = r2;
        int r5 = s1.f(7.0f);
        ALogger.d("EnterAnimExtraHeightUpdater", "special enter anim extra height: 7");
        r1.b.put("data_special_enter_anim_extra_height", Integer.valueOf(r5));
        return;
    L17:
        return;
    L12:
        r4 = false;
        goto L13
    }

    public z(a0 r1, a r2, h3 r3, u0 r4, ViewGroup r5, BaseWindScreenAnimEnterTrayView r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
