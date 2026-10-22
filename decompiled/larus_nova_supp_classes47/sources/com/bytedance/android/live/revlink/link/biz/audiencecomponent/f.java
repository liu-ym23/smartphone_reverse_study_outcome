package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenuelink.h;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.link.biz.service.i;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ MultiAudienceSeiComponent a;
    public final /* synthetic */ RevSeiFrame b;

    public f(MultiAudienceSeiComponent r1, RevSeiFrame r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r13) {
        long r3 = ((JSONObject) r13).optLong("sei_index", 0);
        v r14 = i.H(this.a);
        String r5 = this.b.C;
        MultiAudienceSeiComponent r6 = this.a;
        long r7 = r6.g;
        RevSeiFrame r8 = r6.h;
        if (r8 == null) goto L7;
        Long r9 = (Long) r8.w.getValue();
        if (r9 == null) goto L7;
        long r10 = r9.longValue();
    L8:
        r14.getClass();
        LinkedHashMap r12 = new LinkedHashMap();
        if (r3 < r10) goto L11;
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r12.put("seiStr", r5);
        r14.d(r12);
        r14.D("audience_unload_multi_link_by_sei", t.a(r7), r12);
        MultiAudienceSeiComponent r15 = this.a;
        r15.getClass();
        jy0.b.e(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r15), "MultiAnchorWindowManger.unloadModule", new IllegalStateException());
        r15.k.getAudienceUnloadSource().setValue(h.c.b);
        com.bytedance.android.live.revlink.impl.service.internal.a r16 = i.p(r15);
        if (r16 == null) goto L19;
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r16, 64, false, 6);
        return;
    L19:
        return;
    L11:
        if (r3 == 0) goto L13;
        r12.put("error_code", 1);
        r12.put("sei_index", r10 + "->" + r3);
    L7:
        r10 = -1;
        goto L8
    }
}
