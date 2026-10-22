package ig0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ List d;

    public c(b r1, boolean r2, boolean r3, List r4, Integer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r7 = this.a.t().getWidth();     // Catch: Throwable -> L4
        SeatAnimationView r1 = this.a.t();     // Catch: Throwable -> L4
        b r0 = this.a;     // Catch: Throwable -> L4
        int r2 = r0.i;     // Catch: Throwable -> L4
        MicSeatScene r3 = r0.b;     // Catch: Throwable -> L4
        boolean r5 = this.b;     // Catch: Throwable -> L4
        r1.c(r2, r3, this.c, r5, r7, r7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
