package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ LiveInteractiveAnnieXHelper a;
    public final /* synthetic */ IBannerInfo b;
    public final /* synthetic */ boolean c;

    public f(LiveInteractiveAnnieXHelper r1, IBannerInfo r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r4) {
        if (Intrinsics.areEqual((Boolean) r4, Boolean.TRUE) == false) goto L6;
        LiveInteractiveAnnieXHelper r5 = this.a;
        r5.k(this.b, this.c, r5.h);
        LiveInteractiveAnnieXHelper r6 = this.a;
        r6.a.removeObservers(r6.r);
        return;
    }
}
