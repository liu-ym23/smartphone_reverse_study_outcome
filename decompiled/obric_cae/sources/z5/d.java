package z5;

import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f14255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f14256b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b f14257m;

    public d(b r8, Map r10, List r11) {
        this.f14257m = r8;
        this.f14255a = r10;
        this.f14256b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r8 = this.f14257m;
        monitor-enter(r8);
        int r10 = r8.f14228o;     // Catch: Throwable -> L21
        monitor-exit(r8);
        if (r10 != 4) goto L9;
    L19:
        Log.d("WsChannelSdk_ok", "cancel connect :,current state = " + r10);
        return;
    L9:
        if (r10 == 1) goto L19;
        if (r10 == 5) goto L19;
        Map r11 = this.f14255a;
        if (r11 == null) goto L17;
        r11.remove(WsConstants.KEY_CHANNEL_ID);
        r8.f14231r.putAll(r11);
    L17:
        r8.handleMsg(r8.f14232s.obtainMessage(2, this.f14256b));
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
