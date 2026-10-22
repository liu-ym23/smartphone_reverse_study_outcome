package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.livesdk.link.model.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h {

    public interface a {
        void a();
    }

    public interface b {
        void a();

        void b(long r1, long r3, ExtraResponse<r, Extra> r5, boolean r6);
    }

    public interface c {
        void a();

        void b(long r1, long r3, ExtraResponse<r, Extra> r5, boolean r6);
    }

    boolean a(long r1, long r3, long r5, boolean r7);

    void d();

    void e(PkDoubleAudienceDataContext.C03571 r1);

    void f(b r1);

    void g();
}
