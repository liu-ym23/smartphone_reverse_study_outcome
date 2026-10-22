package e6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.g;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.j;
import com.bytedance.crash.upload.k;
import com.lynx.tasm.ui.image.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import q0.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16763b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f16762a = r10;
        this.f16763b = r5;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        switch(this.f16762a) {
            case 0: goto L39;
            case 1: goto L12;
            case 2: goto L55;
            default: goto L4;
        };
    L4:
        if (r10 == null) goto L69;
        float r11 = r10.getIntExtra("temperature", 0) / 10.0f;
        ip.b r12 = (ip.b) this.f16763b;
        r12.f18208a = r11;
        r10.getIntExtra(NotificationCompat.CATEGORY_STATUS, 1);
        r12.getClass();
        r10.getIntExtra("plugged", -1);
        r12.getClass();
        return;
    L69:
        return;
    L12:
        k0.b r13 = (k0.b) this.f16763b;
        boolean r14 = r13.f18574c;
        r13.f18574c = k0.b.j(r5);
        if (r14 != ((k0.b) this.f16763b).f18574c) goto L15;
        return;
    L15:
        if (Log.isLoggable("ConnectivityMonitor", 3) == false) goto L17;
        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + ((k0.b) this.f16763b).f18574c);
    L17:
        k0.b r15 = (k0.b) this.f16763b;
        q7.a r16 = r15.f18573b;
        if (r15.f18574c == false) goto L37;
        g r17 = (g) r16.f21489c;
        monitor-enter(r17);
        c5.a r18 = (c5.a) r16.f21488b;     // Catch: Throwable -> L34
        Iterator r19 = i.d((Set) r18.d).iterator();     // Catch: Throwable -> L34
    L23:
        if (r19.hasNext() == false) goto L32;
        com.bumptech.glide.request.d r20 = (com.bumptech.glide.request.d) ((com.bumptech.glide.request.b) r19.next());     // Catch: Throwable -> L34
        if (r20.f() == true) goto L23;
        if (r20.e() == true) goto L23;
        r20.c();     // Catch: Throwable -> L34
        if (r18.f1118b == false) goto L30;
        ((ArrayList) r18.f1119c).add(r20);     // Catch: Throwable -> L34
        goto L23
    L30:
        r20.a();     // Catch: Throwable -> L34
        goto L23
    L32:
        monitor-exit(r17);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        throw th;
    L37:
        r16.getClass();
        return;
    L39:
        if (r10 == null) goto L74;
        String r21 = r10.getStringExtra("PROCESS_NAME");     // Catch: Throwable -> L51
        boolean r22 = j.f3887a;     // Catch: Throwable -> L51
        String r23 = xq.b.l();     // Catch: Throwable -> L51
        if (j.f3887a == false) goto L44;
        Log.i("apm_initializing", f.o(new String[]{"BroadcastReceiver.onReceive, processName:", r21, "currentProcessName:", r23}));     // Catch: Throwable -> L51
    L44:
        if (TextUtils.isEmpty(r21) == false) goto L46;
        return;
    L46:
        if (TextUtils.isEmpty(r23) == false) goto L48;
        return;
    L48:
        if (r21.equals(r23) == true) goto L77;
        z6.b.f23409a.d(new h(this, 12));     // Catch: Throwable -> L51
        return;
    L77:
        return;
    L78:
        return;
    L74:
        return;
    L55:
        if ("android.intent.action.BATTERY_CHANGED".equals(r10.getAction()) == false) goto L70;
        int r24 = r10.getIntExtra("level", 0);     // Catch: Throwable -> L52
        ((k) this.f16763b).f4136a = (int) ((r24 * 100.0f) / r10.getIntExtra("scale", 100));     // Catch: Throwable -> L52
        return;
    L70:
        return;
    }
}
