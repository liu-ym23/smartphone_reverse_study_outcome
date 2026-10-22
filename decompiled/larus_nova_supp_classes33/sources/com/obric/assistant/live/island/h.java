package com.obric.assistant.live.island;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.livecard.api.DefaultIslandCardCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements DefaultIslandCardCallback {
    public final /* synthetic */ a a;
    public final /* synthetic */ g b;

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionActive(IslandSession r1) {
        DefaultIslandCardCallback.DefaultImpls.onSessionActive(this, r1);
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionCreate(IslandSession r1) {
        DefaultIslandCardCallback.DefaultImpls.onSessionCreate(this, r1);
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionInactive(IslandSession r1) {
        DefaultIslandCardCallback.DefaultImpls.onSessionInactive(this, r1);
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final Bundle onWidgetShow(IslandWidget r1) {
        return DefaultIslandCardCallback.DefaultImpls.onWidgetShow(this, r1);
    }

    public h(a r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionDestroy(IslandSession r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "session");
        DefaultIslandCardCallback.DefaultImpls.onSessionDestroy(this, r4, r5);
        FLogger.a.i("ComplexTaskCompletedIslandModule", "onSessionDestroy, taskId=" + this.a.a + ", reason=" + r5);
        this.b.c(this.a.a);
        this.b.d.c(this.a.a, r4);
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionDisplayStatusChanged(IslandSession r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "session");
        DefaultIslandCardCallback.DefaultImpls.onSessionDisplayStatusChanged(this, r4, r5);
        FLogger.a.i("ComplexTaskCompletedIslandModule", "onSessionDisplayStatusChanged, taskId=" + this.a.a + ", status=" + r5);
        if (r5 != 2) goto L8;
        this.b.c(this.a.a);
        IslandSession r6 = this.b.d.c(this.a.a, r4);
        if (r6 == null) goto L9;
        int r7 = j.a;
        j.f(r6);
        return;
    L9:
        return;
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionStatusChanged(IslandSession r1, int r2) {
        DefaultIslandCardCallback.DefaultImpls.onSessionStatusChanged(this, r1, r2);
    }
}
