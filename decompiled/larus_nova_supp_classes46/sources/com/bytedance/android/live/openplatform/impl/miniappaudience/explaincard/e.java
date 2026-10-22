package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ AudienceLynxExplainCardContextService a;

    public e(AudienceLynxExplainCardContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        r71.f r6 = (r71.f) r5;
        if (r6.a == 10) goto L6;
        return;
    L6:
        if (this.a.a != null) goto L9;
        qo0.a.c("AudienceLynxExplainCardContextService", "explain card is not initialized, create card");
        AudienceLynxExplainCardContextService r0 = this.a;
        r0.getClass();
        r0.a = k.n(IMsgWindowService.class).commonCardBuilder().a(new AudienceLynxExplainCardContextService$createExplainCard$1(r0, r6)).b();
    L9:
        if (r6.b != CardDataState.SHOW) goto L15;
        qo0.a.c("AudienceLynxExplainCardContextService", "show explain card");
        AudienceLynxExplainCardContextService r1 = this.a;
        if (r6.c != CommonCardInitScene.ROOM_ENTER) goto L13;
        boolean r7 = true;
    L14:
        AudienceLynxExplainCardContextService.f(r1, r7, null, 2);
        return;
    L13:
        r7 = false;
        goto L14
    L15:
        int r2 = qo0.a.a;
        qo0.a.c("AudienceLynxExplainCardContextService", "explain card state is changed, state: " + r6.b);
    }
}
