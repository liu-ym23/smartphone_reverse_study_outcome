package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AoActivityResultRequest.a c;
    public final /* synthetic */ AoActivityResultRequest d;

    public final void a() {
        AoActivityResultRequest.OnActivityResultFragment r0 = new AoActivityResultRequest.OnActivityResultFragment();
        Activity r1 = this.d.a;
        Intent r2 = this.a;
        int r3 = this.b;
        AoActivityResultRequest.a r4 = this.c;
        if (r0.a.getAndSet(true) == true) goto L18;
        r0.b = r2;
        r0.c = r3;
        r0.d = r4;
        if (r1.isFinishing() == true) goto L14;
        r1.getFragmentManager().beginTransaction().add(0, r0).commitAllowingStateLoss();
        return;
    L14:
        r1.startActivityForResult(r0.b, r0.c);     // Catch: ActivityNotFoundException -> L9
        return;
    L10:
        if (r4 == null) goto L16;
        ((a) r4).a(r3, ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION, null);
        return;
    L16:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(AoActivityResultRequest r1, Intent r2, a r3) {
        this.d = r1;
        this.a = r2;
        this.b = 32766;
        this.c = r3;
    }
}
