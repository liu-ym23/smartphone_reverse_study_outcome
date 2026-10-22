package com.obric.aikernel.service.session.inr;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import androidx.work.WorkRequest;
import com.obric.aikernel.middleware.api.log.AIKLog;

/* JADX INFO: loaded from: classes2.dex */
public class TriggerAnrService extends Service {
    public TriggerAnrService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (r10 == null) goto L4;
        Integer r13 = Integer.valueOf(r10.getIntExtra("pid", -1));
    L5:
        int r14 = Process.myPid();
        if (r13 != null) goto L9;
    L11:
        AIKLog.INSTANCE.w("TriggerAnrService", "ignore io thread block by trigger pid " + r13 + " but current is " + r14);
    L13:
        return super.onStartCommand(r10, r11, r12);
    L9:
        if (r13.intValue() != r14) goto L11;
        Thread.sleep(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        goto L13
    L4:
        r13 = null;
        goto L5
    }
}
