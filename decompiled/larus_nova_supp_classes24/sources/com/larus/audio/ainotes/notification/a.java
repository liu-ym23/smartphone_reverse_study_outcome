package com.larus.audio.ainotes.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import h58.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements ServiceConnection {
    public a() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        b.c = false;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r6) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r6, "service");
        AiNoteService r7 = b.a;
        if ((r6 instanceof AiNoteService.a) == false) goto L5;
        AiNoteService.a r8 = (AiNoteService.a) r6;
    L6:
        if (r8 == null) goto L8;
        AiNoteService r9 = r8.a;
    L9:
        b.a = r9;
        if (r9 == null) goto L14;
        Intrinsics.checkNotNullParameter(r9, "context");
        if (Build.VERSION.SDK_INT < 26) goto L14;
        NotificationChannel r10 = new NotificationChannel("ai_note_channel", "AiNote", 3);
        r10.setLockscreenVisibility(1);
        r10.enableVibration(false);
        r10.setSound(null, null);
        ((NotificationManager) r9.getSystemService(NotificationManager.class)).createNotificationChannel(r10);
    L14:
        h58.a r11 = b.b;
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
