package ds1;

import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ VSChorusConcertWidget a;

    public a(VSChorusConcertWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PlayerProgressServiceContext r0 = this.a.h;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        m r1 = r0.getDisableSeek();     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.setValue(Boolean.TRUE);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
