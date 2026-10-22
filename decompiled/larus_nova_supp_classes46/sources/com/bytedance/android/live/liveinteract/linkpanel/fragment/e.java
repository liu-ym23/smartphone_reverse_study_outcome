package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ApplyPermissionSwitchFragment a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ boolean c;

    public e(ApplyPermissionSwitchFragment r1, Ref.ObjectRef r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
        int r5 = this.a.k;
        if (r5 != 1) goto L5;
        ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.b.element));
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.t1;
        Boolean r0 = Boolean.valueOf(this.c);
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r0);
        xs2.b.a().post(new jd0.m(this.c));
    L9:
        ApplyPermissionSwitchFragment r7 = this.a;
        r7.n = this.c;
        r7.ea0();
        return;
    L5:
        if (r5 != 3) goto L9;
        ALogger.i("ttlive_link", "audioTalk update_setting " + ((HashMap) this.b.element));
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.c.L0;
        Boolean r1 = Boolean.valueOf(this.c);
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r1);
        xs2.b.a().post(new jd0.n(this.c));
        goto L9
    }
}
