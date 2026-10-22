package r62;

import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewV2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ ChannelTrayListViewV2 a;

    public b(ChannelTrayListViewV2 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.smoothScrollToPosition(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
