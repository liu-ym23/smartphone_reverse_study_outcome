package j2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c2.k;

/* JADX INFO: loaded from: classes.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8557a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8558a;

        public a(b r8) {
            this.f8558a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f8558a.f8557a.f();     // Catch: Throwable -> L4
            return;
        }
    }

    public b(d r8) {
        this.f8557a = r8;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if (r10 == null) goto L14;
        String r11 = r10.getStringExtra("PROCESS_NAME");     // Catch: Throwable -> L11
        boolean r12 = k.f3297a;     // Catch: Throwable -> L11
        String r13 = t2.b.A();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r13) == false) goto L8;
        return;
    L8:
        if (r11.equals(r13) == true) goto L17;
        b3.b.C0032b.f3038a.c(new a(this));     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L18:
        return;
    }
}
