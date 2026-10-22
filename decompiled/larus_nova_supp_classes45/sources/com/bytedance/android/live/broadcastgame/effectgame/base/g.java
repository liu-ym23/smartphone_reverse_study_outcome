package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements IFetchEffectListListener {
    public final /* synthetic */ c.b a;

    public g(c.b r1) {
        this.a = r1;
    }

    public final void onFail(ExceptionResult r2) {
        this.a.onFail(r2);
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        List r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        this.a.onSuccess(CollectionsKt.emptyList());
        return;
    L11:
        com.bytedance.android.live.effect.sticker.d.e(r3).subscribe(new f(this));
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
