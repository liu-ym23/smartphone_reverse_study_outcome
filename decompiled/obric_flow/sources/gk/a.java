package gk;

import com.bytedance.vmsdk.log.VLog;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends TimerTask {
    public a() {
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (VLog.access$000() == false) goto L6;
        cancel();
        return;
    }
}
