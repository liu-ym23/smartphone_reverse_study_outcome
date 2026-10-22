package l6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.util.m;
import q0.b;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: l6.a$a, reason: collision with other inner class name */
    class RunnableC0232a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f10908c;

        RunnableC0232a(a r10, Context r11) {
            this.f10908c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.b(this.f10908c) == false) goto L6;
            k6.a.k().e();
            return;
        }
    }

    public a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        b.f().i(new RunnableC0232a(this, r10));
    }
}
