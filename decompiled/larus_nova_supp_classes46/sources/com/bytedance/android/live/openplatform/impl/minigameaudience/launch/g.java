package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ AudienceLaunchMgContextService a;

    public g(AudienceLaunchMgContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        if (r5 == null) goto L15;
        fr0.a r6 = (fr0.a) r5.data;
        if (r6 == null) goto L16;
        String r7 = r6.a();
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 != true) goto L18;
        f2.c(s1.B(2131920989), 0);
        this.a.autoDispose(Observable.timer(4, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(f.a));
        return;
    L18:
        return;
    L11:
        r8 = false;
        goto L12
    L16:
        return;
    }
}
