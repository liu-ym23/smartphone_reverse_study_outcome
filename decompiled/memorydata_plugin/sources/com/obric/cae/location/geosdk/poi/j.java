package com.obric.cae.location.geosdk.poi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StarPoiManager f7229a;

    public j(StarPoiManager r1) {
        this.f7229a = r1;
    }

    public final void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        BroadcastReceiver.PendingResult r6 = goAsync();
        StarPoiManager.a(this.f7229a, r4, r6);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "POI config command failed", e);
        String r2 = "ERROR " + e.getClass().getSimpleName() + ": " + String.valueOf(e.getMessage());
        StarPoiManager r0 = StarPoiManager.f7164a;
        r6.setResultCode(1);
        r6.setResultData(r2);
        r6.finish();
    }
}
