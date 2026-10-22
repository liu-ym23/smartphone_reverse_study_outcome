package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.x6;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ MultiOtherComponent a;

    public m(MultiOtherComponent r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        MultiOtherComponent r9 = this.a;
        r9.getClass();
        f21.a r0 = com.bytedance.android.live.revlink.link.biz.service.i.i(r9);
        if (r0 == null) goto L29;
        f21.a.C0236a r1 = r0.o;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.a != 2) goto L31;
        f21.a r2 = com.bytedance.android.live.revlink.link.biz.service.i.i(r9);
        if (r2 != null) goto L11;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r3 = com.bytedance.android.live.revlink.link.biz.service.i.D(r9);
        if (r3 == null) goto L33;
        f21.a r10 = com.bytedance.android.live.revlink.link.biz.service.i.i(r9);
        if (r10 == null) goto L26;
        f21.a.C0236a r12 = r10.o;
        if (r12 == null) goto L26;
        IBattleConfigSetting r13 = r12.c;
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.b(r3, false, r13, 4);
        return;
    L26:
        r13 = null;
        goto L27
    L33:
        return;
    L11:
        if (r2.f == false) goto L17;
        x6 r4 = r2.o.e;
        if (r4 == null) goto L17;
        if (x.d((int) r4.getMatchType()) != true) goto L17;
        boolean r5 = true;
    L18:
        if (r5 != true) goto L19;
        return;
    L17:
        r5 = false;
        goto L18
    L31:
        return;
    }
}
