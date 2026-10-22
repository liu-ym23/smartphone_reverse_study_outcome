package j8;

import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f18277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f18278c;
    public final /* synthetic */ e d;

    public /* synthetic */ d(e r5, Map r10, List r11, int r12) {
        this.f18276a = r12;
        this.d = r5;
        this.f18277b = r10;
        this.f18278c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f18276a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        e r5 = this.d;
        r5.getClass();
        Map r10 = this.f18277b;
        if (r10 == null) goto L8;
        r10.remove(WsConstants.KEY_CHANNEL_ID);
        r5.f18282h.putAll(r10);
    L8:
        r5.c(r5.f18283i.obtainMessage(7, this.f18278c));
        return;
    L10:
        e r11 = this.d;
        monitor-enter(r11);
        int r12 = r11.e;     // Catch: Throwable -> L28
        monitor-exit(r11);     // Catch: Throwable -> L28
        if (r12 != 4) goto L17;
    L26:
        Log.d("WsChannelSdk_ok", "cancel connect :,current state = " + r12);
        return;
    L17:
        if (r12 == 1) goto L26;
        if (r12 == 5) goto L26;
        e r13 = this.d;
        Map r14 = this.f18277b;
        r13.getClass();
        if (r14 == null) goto L25;
        r14.remove(WsConstants.KEY_CHANNEL_ID);
        r13.f18282h.putAll(r14);
    L25:
        e r15 = this.d;
        r15.c(r15.f18283i.obtainMessage(2, this.f18278c));
        return;
    L28:
        th = move-exception;
        throw th;
    }
}
