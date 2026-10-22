package com.bytedance.android.live.openplatform.impl.miniappaudience.important;

import com.bytedance.android.live.room.api.messagewindow.builder.card.c;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import io.reactivex.functions.Consumer;
import jc1.k;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AudienceImportantCardContextService a;

    public a(AudienceImportantCardContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        final f r6 = (f) r5;
        if (r6.a == 33) goto L6;
        return;
    L6:
        if (this.a.b != null) goto L9;
        qo0.a.c("AudienceImportantCardContextService", "important card is not initialized, create card");
        AudienceImportantCardContextService r0 = this.a;
        r0.getClass();
        r0.b = k.n(IMsgWindowService.class).commonCardBuilder().a(new AudienceImportantCardContextService$createExplainCard$1(r6)).b();
    L9:
        if (r6.b != CardDataState.SHOW) goto L13;
        qo0.a.c("AudienceImportantCardContextService", "show important card");
        c r7 = this.a.b;
        if (r7 == null) goto L15;
        r7.c(null);
        return;
    L15:
        return;
    L13:
        int r1 = qo0.a.a;
        qo0.a.c("AudienceImportantCardContextService", "important card state is changed, state: " + r6.b);
    }
}
