package com.larus.uaigc.chat.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements ServiceConnection {
    public e() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        f.c = true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r6) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r6, "service");
        CreationService r7 = f.a;
        if ((r6 instanceof CreationService.a) == false) goto L5;
        CreationService.a r8 = (CreationService.a) r6;
    L6:
        if (r8 == null) goto L8;
        CreationService r9 = r8.a;
    L9:
        f.a = r9;
        if (r9 == null) goto L14;
        Intrinsics.checkNotNullParameter(r9, "context");
        if (Build.VERSION.SDK_INT < 26) goto L14;
        NotificationChannel r10 = new NotificationChannel("ugc_creation_channel", "creation_task", 3);
        r10.setLockscreenVisibility(1);
        r10.enableVibration(false);
        r10.setSound(null, null);
        ((NotificationManager) r9.getSystemService(NotificationManager.class)).createNotificationChannel(r10);
    L14:
        d r11 = f.b;
        if (r11 == null) goto L18;
        r11.invoke();
        return;
    L18:
        return;
    L8:
        r9 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
    }
}
