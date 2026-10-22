package z5;

import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f14260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f14261b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b f14262m;

    public g(b r8, Map r10, List r11) {
        this.f14262m = r8;
        this.f14260a = r10;
        this.f14261b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r8 = this.f14262m;
        r8.getClass();
        Map r10 = this.f14260a;
        if (r10 == null) goto L6;
        r10.remove(WsConstants.KEY_CHANNEL_ID);
        r8.f14231r.putAll(r10);
    L6:
        r8.handleMsg(r8.f14232s.obtainMessage(7, this.f14261b));
    }
}
