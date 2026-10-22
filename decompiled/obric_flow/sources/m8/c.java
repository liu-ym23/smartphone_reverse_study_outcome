package m8;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.LinkedBlockingDeque;
import s8.d;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20022b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f20021a = r10;
        this.f20022b = r5;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r10) {
        switch(this.f20021a) {
            case 0: goto L26;
            default: goto L5;
        };
    L26:
        if (r5 == null) goto L43;
        if (r10 != null) goto L30;
        return;
    L30:
        if (Logger.debug() == false) goto L38;
        Logger.d("WsChannelSdk", "onServiceConnected name = " + r5.toString());
    L38:
        Messenger r11 = new Messenger(r10);     // Catch: Throwable -> L34
        i4.a r12 = (i4.a) this.f20022b;     // Catch: Throwable -> L34
        r12.f17503c = r11;     // Catch: Throwable -> L34
        i4.a.p(r12, r5);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        th.printStackTrace();
        return;
    L43:
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "onServiceConnected name = " + r5.toString());
    L7:
        Object r13 = ((d) this.f20022b).f;
        monitor-enter(r13);
        ((d) this.f20022b).f();     // Catch: Throwable -> L20
        if (r5 == null) goto L22;
        if (r10 == null) goto L22;
        ((d) this.f20022b).f21843b = new Messenger(r10);     // Catch: Throwable -> L15
        Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L15
        ((d) this.f20022b).e();     // Catch: Throwable -> L15
    L17:
        Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
        ((d) this.f20022b).e = false;     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
    L22:
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        switch(this.f20021a) {
            case 0: goto L19;
            default: goto L5;
        };
    L19:
        if (r5 != null) goto L22;
        return;
    L22:
        if (Logger.debug() == false) goto L31;
        Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r5.toString());
    L31:
        i4.a r10 = (i4.a) this.f20022b;     // Catch: Throwable -> L28
        r10.f17503c = null;     // Catch: Throwable -> L28
        ((LinkedBlockingDeque) r10.d).clear();     // Catch: Throwable -> L28
        i4.a r11 = (i4.a) this.f20022b;     // Catch: Throwable -> L28
        monitor-enter(r11);     // Catch: Throwable -> L28
        monitor-exit(r11);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r5.toString());
    L7:
        Object r12 = ((d) this.f20022b).f;
        monitor-enter(r12);
        if (r5 != null) goto L14;
        monitor-exit(r12);     // Catch: Throwable -> L12
    L33:
        return;
    L14:
        Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L12
        d r13 = (d) this.f20022b;     // Catch: Throwable -> L12
        r13.f21843b = null;     // Catch: Throwable -> L12
        r13.d = null;     // Catch: Throwable -> L12
        Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L12
        d r14 = (d) this.f20022b;     // Catch: Throwable -> L12
        r14.e = false;     // Catch: Throwable -> L12
        r14.g();     // Catch: Throwable -> L12
        ((d) this.f20022b).f();     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
