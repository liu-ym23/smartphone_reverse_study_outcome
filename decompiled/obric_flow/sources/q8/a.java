package q8;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import j8.c;
import j8.e;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f21491b;

    public /* synthetic */ a(b r5, int r10) {
        this.f21490a = r10;
        this.f21491b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f21490a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        b r10 = this.f21491b;
        if (r10.f21492a == null) goto L14;
        StringBuilder r5 = dn.a.K(-1, "interval :", " ms,the next time to send heartbeat is ");
        r5.append(DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis() - 1)));
        Logger.d("WsChannelSdk_ok", r5.toString());
        WeakHandler r11 = r10.f21493b;
        a r12 = r10.e;
        r11.removeCallbacks(r12);
        r10.f21493b.postDelayed(r12, -1);
        e r13 = (e) r10.f21492a.f21902a;
        r13.f18283i.post(new c(r13, 2));
        return;
    L14:
        return;
    L8:
        b r14 = this.f21491b;
        if (r14.f21494c.getAndSet(false) == false) goto L15;
        r14.f21493b.removeCallbacks(r14.d);
        r14.f21493b.removeCallbacks(r14.e);
        r14.f21494c.set(false);
        if (r14.f21492a == null) goto L16;
        Logger.d("WsChannelSdk_ok", "heartbeat timeout，ready to close connection");
        ((e) r14.f21492a.f21902a).i();
        return;
    L16:
        return;
    }
}
