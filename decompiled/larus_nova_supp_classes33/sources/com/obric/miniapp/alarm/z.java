package com.obric.miniapp.alarm;

import android.os.Bundle;
import com.obric.livecard.api.DefaultIslandCardCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z implements DefaultIslandCardCallback {
    public final /* synthetic */ String a;

    public z(String r1) {
        this.a = r1;
    }

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

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionDestroy(IslandSession r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r9, "session");
        DefaultIslandCardCallback.DefaultImpls.onSessionDestroy(this, r9, r10);
        LiveCardAlarmExpirationController r11 = LiveCardAlarmExpirationController.a;
        String r12 = this.a;
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r9, "session");
        BuildersKt.launch$default(LiveCardAlarmExpirationController.b, null, null, new LiveCardAlarmExpirationController$removeSession$1(r12, r9, null), 3, null);
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionDisplayStatusChanged(IslandSession r1, int r2) {
        DefaultIslandCardCallback.DefaultImpls.onSessionDisplayStatusChanged(this, r1, r2);
    }

    @Override // com.obric.livecard.api.DefaultIslandCardCallback
    public final void onSessionStatusChanged(IslandSession r1, int r2) {
        DefaultIslandCardCallback.DefaultImpls.onSessionStatusChanged(this, r1, r2);
    }
}
