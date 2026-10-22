package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ PkApplyPermissionSwitchDialog a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ boolean c;

    public i(PkApplyPermissionSwitchDialog r1, Ref.ObjectRef r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
        if (this.a.e != 1) goto L6;
        ALogger.i("ttlive_pk", "pk update_setting " + ((HashMap) this.b.element));
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.t1;
        Boolean r0 = Boolean.valueOf(this.c);
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        xs2.b.a().post(new jd0.m(this.c));
    L6:
        PkApplyPermissionSwitchDialog r6 = this.a;
        r6.c = this.c;
        r6.O0();
    }
}
