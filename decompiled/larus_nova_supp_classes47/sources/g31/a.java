package g31;

import com.bytedance.android.live.revlink.impl.multianchor.ui.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.service.room.c;
import d21.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements k {
    public final boolean a;
    public boolean b;
    public boolean c;
    public p d;
    public final b e;
    public final c f;
    public final com.bytedance.android.live.revlink.impl.global.c g;
    public final i h;

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.g;
    }

    public a(c r2, d r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.e = new b();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r5 = r2.getRoomContext();
        if (r5 == null) goto L7;
        boolean r6 = r5.getCommonIsAnchor();
    L8:
        this.a = r6;
        return;
    L7:
        r6 = false;
        goto L8
    }
}
