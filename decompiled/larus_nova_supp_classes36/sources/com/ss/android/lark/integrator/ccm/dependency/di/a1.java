package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.location.dto.POIInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a1 implements ew4.p {
    public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.r.a a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ z0 c;

    public a1(vp4.h r1, FragmentActivity r2, z0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(ew4.o r4) {
        com.bytedance.ee.bear.lark.dependency.r.a r0 = this.a;
        if (r0 == null) goto L10;
        Activity r1 = this.b;
        if (r4 == null) goto L7;
        POIInfo r5 = z0.i(this.c, r4);
    L8:
        r0.a(r1, r5);
        return;
    L7:
        r5 = null;
        goto L8
    }
}
