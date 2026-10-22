package j6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public final class g extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f8732c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.a f8734b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f8736b;

        public a(g r8, Context r10) {
            this.f8736b = r8;
            this.f8735a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context r8 = this.f8735a;
            this.f8736b.getClass();
            int r10 = 1;
            boolean r11 = com.bytedance.common.wschannel.a.a(r8).f3869a.a(WsConstants.KEY_FRONTIER_ENABLED, true);     // Catch: Throwable -> L23
            if (r11 == g.f8732c) goto L7;
            g.f8732c = r11;     // Catch: Throwable -> L23
        L7:
            if (g.f8732c == true) goto L25;
            return;
        L25:
            if (Logger.debug() == false) goto L12;
            Logger.d("WsChannelReceiver", "ConnectivityReceiver");     // Catch: Exception -> L24
        L12:
            boolean r12 = c.b(r8);     // Catch: Exception -> L24
            c.a r13 = c.a(r8);     // Catch: Exception -> L24
            if (r12 == true) goto L16;
            r10 = 2;
        L21:
            Message r14 = Message.obtain();     // Catch: Exception -> L24
            r14.what = 3;     // Catch: Exception -> L24
            r14.arg1 = r10;     // Catch: Exception -> L24
            j6.a.e(r8.getApplicationContext()).handleMsg(r14);     // Catch: Exception -> L24
            return;
        L16:
            if (c.a.f8723o != r13) goto L19;
            r10 = 3;
            goto L21
        L19:
            if (c.a.f8719a == r13) goto L21;
            r10 = 4;
        }
    }

    public g() {
        this.f8733a = true;
        this.f8734b = c.a(w5.c.f12986b);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if (r8 == null) goto L18;
        if (r10 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10.getAction()) == false) goto L9;
        return;
    L9:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r10.getAction()) == true) goto L12;
        return;
    L12:
        if (this.f8733a == false) goto L16;
        this.f8733a = false;
        if (c.a(w5.c.f12986b) != this.f8734b) goto L16;
        return;
    L16:
        a r11 = new a(this, r8);
        s5.c.f12034b.submit(r11);
        return;
    }
}
