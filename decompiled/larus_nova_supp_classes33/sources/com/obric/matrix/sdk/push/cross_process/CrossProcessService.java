package com.obric.matrix.sdk.push.cross_process;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/CrossProcessService;", "Landroid/app/Service;", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class CrossProcessService extends Service {
    public AnonymousClass1 a;

    public abstract void c();

    public CrossProcessService() {
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.matrix.sdk.push.cross_process.CrossProcessService$onBind$1] */
    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        if (this.a != null) goto L6;
        c();
        this.a = new AnonymousClass1(this);
    L6:
        return this.a;
    }
}
