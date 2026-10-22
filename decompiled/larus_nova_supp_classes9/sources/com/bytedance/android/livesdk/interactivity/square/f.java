package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        if (((com.bytedance.android.livesdk.interactivity.api.base.d) r5).a != PublicScreenAreaPageType.Square) goto L5;
        boolean r6 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).setNeedShowGiftEffectSwitch(false);
        DataCenter r7 = this.a.g;
        j32.a r3 = new j32.a();
        r3.a = 9;
        r3.b = false;
        Unit r0 = Unit.INSTANCE;
        r7.put("cmd_enter_widget_visible_change", r3);
        return;
    L5:
        DataCenter r8 = this.a.g;
        j32.a r1 = new j32.a();
        r1.a = 9;
        r1.b = true;
        Unit r2 = Unit.INSTANCE;
        r8.put("cmd_enter_widget_visible_change", r1);
    }
}
