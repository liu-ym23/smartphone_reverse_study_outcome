package com.obric.assistant;

import android.content.Intent;
import com.larus.camera.contract.CameraServiceDiffContract;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class y0 implements Runnable {
    public final /* synthetic */ ObricAssistantImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Intent c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ y0(ObricAssistantImpl r1, String r2, Intent r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ObricAssistantImpl r0 = this.a;
        final String r1 = this.b;
        Intent r2 = this.c;
        final boolean r3 = this.d;
        int r4 = ObricAssistantImpl.a;
        r0.getClass();
        if (r1 != null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L9;
        if (r1 == null) goto L11;
        uga.c.a(r1);
        return;
    L11:
        return;
    L9:
        CameraServiceDiffContract.b.doAfterPreCameraRelease(r2, new z0(r0, r1, r3));
        return;
    L5:
        r5 = uga.c.b(r1);
        goto L6
    }
}
