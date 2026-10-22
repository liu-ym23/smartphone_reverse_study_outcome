package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L8:
        if (r4 != null) goto L11;
    L13:
        ALogger.i("BlackFrameManager", "LinkStateObserver ;; LinkPlayerState == " + r4);
        return;
    L11:
        if (r4.intValue() != 2) goto L13;
        h r5 = this.a;
        r5.i.onOnlineListChanged(r5.f);
        return;
    L6:
        if (r4.intValue() != 0) goto L8;
        h r6 = this.a;
        r6.e = null;
        r6.f = null;
        r6.d = null;
        r6.b = null;
        r6.c = null;
        ((CompositeDisposable) r6.h.getValue()).clear();
    }
}
