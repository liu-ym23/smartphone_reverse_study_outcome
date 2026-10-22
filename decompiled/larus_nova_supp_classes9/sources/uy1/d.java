package uy1;

import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.scope.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ ty1.b b;

    public d(e r1, ty1.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Integer r7 = (Integer) r6;
        k r0 = this.a.g;
        m r1 = m.e;
        com.bytedance.android.livesdk.revenue.service.sti.a r2 = (com.bytedance.android.livesdk.revenue.service.sti.a) r1.d(r0, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        int r3 = 0;
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r4 = r2.cd();
        if (r4 == null) goto L9;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L9;
        int r8 = r5.intValue();
    L10:
        com.bytedance.android.livesdk.revenue.service.sti.a r9 = (com.bytedance.android.livesdk.revenue.service.sti.a) r1.d(this.a.g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r9 == null) goto L17;
        com.bytedance.live.datacontext.m r10 = r9.u8();
        if (r10 == null) goto L17;
        Integer r11 = (Integer) r10.getValue();
        if (r11 == null) goto L17;
        r3 = r11.intValue();
    L17:
        e.a(this.a, r8, r3, r7.intValue(), this.b.getType());
        return;
    L9:
        r8 = 0;
        goto L10
    }
}
