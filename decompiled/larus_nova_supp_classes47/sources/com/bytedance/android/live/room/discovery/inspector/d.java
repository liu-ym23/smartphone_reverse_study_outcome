package com.bytedance.android.live.room.discovery.inspector;

import android.animation.AnimatorSet;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ OfficialInspectorWidget a;

    public d(OfficialInspectorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        Disposable r6 = this.a.g;
        if (r6 == null) goto L5;
        r6.dispose();
    L5:
        OfficialInspectorWidget r7 = this.a;
        if (r7.e == true) goto L8;
        return;
    L8:
        if (r7.isViewValid() == false) goto L29;
        LinearLayout r0 = r7.a;
        if (r0 == null) goto L13;
        r0.setOnClickListener(null);
    L13:
        AnimatorSet r1 = r7.i;
        if (r1 != null) goto L16;
    L20:
        AnimatorSet r2 = r7.j;
        if (r2 != null) goto L23;
    L25:
        r7.xq();
        return;
    L23:
        if (r2.isRunning() != true) goto L25;
        r7.k = true;
        return;
    L16:
        if (r1.isRunning() != true) goto L20;
        ALogger.e("OfficialInspectorWidget", "enter room animation is running when onShowEnd");
        AnimatorSet r3 = r7.i;
        if (r3 == null) goto L20;
        r3.cancel();
        goto L20
    }
}
