package d7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class f implements f7.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f7.d f6859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6860b;

    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            if (isInitialStickyBroadcast() == false) goto L6;
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r10.getAction()) == true) goto L8;
            return;
        L8:
            e7.e r11 = e7.e.g();
            r11.getClass();
            Message r12 = Message.obtain();
            r12.obj = r11;
            r12.what = 6;
            e7.e.F.sendMessage(r12);
        }
    }

    public f() {
        this.f6859a = new f7.d();
        this.f6860b = new a();
    }
}
