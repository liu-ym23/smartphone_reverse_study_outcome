package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.log.k0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;
    public final /* synthetic */ b c;

    public final void fail(IHostFrescoHelper.BitmapDataSource r4) {
        HashMap r0 = new HashMap();
        r0.put("event_name", "message badges load error");
        if (r4 == null) goto L5;
        Throwable r2 = r4.error;
    L6:
        if (r2 == null) goto L8;
        String r5 = r4.error.getMessage();
    L9:
        r0.put("error_msg", r5);
        k0.o().f("ttlive_msg", r0);
        boolean r6 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.a;
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.b == false) goto L14;
        pm0.a r7 = om0.c.c();
        if (r7 == null) goto L14;
        r7.i("ttlive_render_engine", "rend async failed for : " + this.c + ".toloadImg");
    L14:
        this.a.b(this.b, null);
        return;
    L8:
        r5 = BuildConfig.FLAVOR;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void onNewResultImpl(Bitmap r5) {
        j r0 = this.a;
        if (r0.c == false) goto L6;
        return;
    L6:
        if (r5 != null) goto L9;
        r0.b(this.b, null);
        return;
    L9:
        Bitmap r6 = r5.copy(Bitmap.Config.ARGB_8888, true);
        if (r6 != null) goto L13;
        this.a.b(this.b, null);
        return;
    L13:
        int r1 = j.e;
        int r2 = j.e;
        int r3 = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r2, this.c.g);
        int r4 = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r2, this.c.g);
        BitmapDrawable r7 = new BitmapDrawable(s1.getResources(), r6);
        r7.setBounds(0, 0, r3, r4);
        this.a.b(this.b, r7);
    }

    public k(j r1, int r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
