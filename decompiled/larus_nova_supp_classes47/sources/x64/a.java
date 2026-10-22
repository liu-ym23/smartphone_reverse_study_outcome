package x64;

import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import z64.f;
import z64.g;
import z64.h;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements g {
    public final /* synthetic */ f a;
    public final /* synthetic */ long b;

    public a(f r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // z64.g
    public final void a(i r23) {
        if ((r23 instanceof i.b) == false) goto L6;
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.c, TriggerStage.login, CollectStage.collect_finished, this.a, null, 0, System.currentTimeMillis() - this.b, 0, null, null, false, 0, null, 0, h.c.a, 6544);
        return;
    L6:
        if ((r23 instanceof i.a) == false) goto L10;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.c, TriggerStage.login, new com.bytedance.badger.utils.c("update errorMsg:" + ((i.a) r23).a, -1203, null, null, 12), 0, null, 0, 0, 0, this.a, null, false, 0, null, h.c.a, 3964);
        return;
    }
}
