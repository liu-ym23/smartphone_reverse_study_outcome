package com.obric.matrix.push.common.cross_process;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.ArrayList;
import kka.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements ServiceConnection {
    public final /* synthetic */ CrossProcessService a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ArrayList<Object> c;
    public final /* synthetic */ jka.a d;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        if (r5 == null) goto L5;
        CrossProcessService r0 = this.a;
        b.a(r0.b, "on bind  " + r5.getPackageName() + "'s CrossProcessService disconnected");
        r0.d.remove(r5.getPackageName());
        ICrossProcessInterface r6 = r0.c.remove(r5.getPackageName());
        return;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r8, IBinder r9) {
        if (r8 == null) goto L7;
        CrossProcessService r0 = this.a;
        String r1 = this.b;
        ArrayList<Object> r2 = this.c;
        jka.a r3 = this.d;
        if (r9 == null) goto L8;
        b.a(r0.b, "success bind  " + r8.getPackageName() + "'s CrossProcessService, invoke " + r1 + " method internal");
        ICrossProcessInterface r10 = ICrossProcessInterface.Stub.asInterface(r9);
        r0.d.put(r8.getPackageName(), this);
        r0.c.put(r8.getPackageName(), r10);
        r0.c(r10, r1, r2, r3);
        return;
    L8:
        return;
    }

    public a(CrossProcessService r1, String r2, ArrayList<Object> r3, jka.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
