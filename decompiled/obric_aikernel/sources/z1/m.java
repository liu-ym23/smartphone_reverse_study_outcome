package z1;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class m implements k {
    public m() {
    }

    private void d(Context r10, int r11) {
        if (r10 == null) goto L15;
        if (r11 > 0) goto L5;
        return;
    L5:
        if (r11 <= 3) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r11);
    L11:
        if (com.bytedance.common.wschannel.l.f(r10).g() == true) goto L13;
        return;
    L13:
        Message r12 = new Message();
        r12.what = 2;
        r12.arg1 = r11;
        com.bytedance.common.wschannel.server.h.b(r10).handleMsg(r12);
        return;
    }

    @Override // z1.k
    public void a(Context r10, boolean r11, boolean r12) {
    }

    @Override // z1.k
    public void b(Context r10) {
        d(r10, 2);
    }

    @Override // z1.k
    public void c(Context r10) {
        d(r10, 1);
    }
}
