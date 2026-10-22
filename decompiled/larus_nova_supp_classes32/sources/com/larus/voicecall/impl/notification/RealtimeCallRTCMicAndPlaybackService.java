package com.larus.voicecall.impl.notification;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/voicecall/impl/notification/RealtimeCallRTCMicAndPlaybackService;", "Landroid/app/Service;", "Lcom/larus/voicecall/impl/notification/IRtcService;", "<init>", "()V", "binder", "Lcom/larus/voicecall/impl/notification/RealtimeCallRTCMicAndPlaybackService$RTCMicAndPlaybackServiceBinder;", "onStartCommand", NameKeys.UnloadStrategy_No_Strategy, "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "onDestroy", NameKeys.UnloadStrategy_No_Strategy, "getService", "Companion", "RTCMicAndPlaybackServiceBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallRTCMicAndPlaybackService extends Service implements com.larus.voicecall.impl.notification.b {
    public final b a;

    public static final class a {
    }

    public final class b extends Binder {
        public final /* synthetic */ RealtimeCallRTCMicAndPlaybackService a;

        public b(RealtimeCallRTCMicAndPlaybackService r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.notification.b
    public final Service getService() {
        return this;
    }

    public RealtimeCallRTCMicAndPlaybackService() {
        this.a = new b(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        FLogger.a.i("RTCService2", "onDestroy");
        stopForeground(true);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onBind: ");
        if (r4 == null) goto L5;
        String r5 = r4.getAction();
    L6:
        r1.append(r5);
        r0.i("RTCService2", r1.toString());
        return this.a;
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r6, int r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onStartCommand: ");
        String r2 = null;
        if (r5 == null) goto L5;
        String r3 = r5.getAction();
    L6:
        r1.append(r3);
        r1.append(", flags: ");
        r1.append(r6);
        r1.append(", startId: ");
        r1.append(r7);
        r0.i("RTCService2", r1.toString());
        d r4 = d.a;
        if (r5 == null) goto L9;
        r2 = r5.getAction();
    L9:
        r4.getClass();
        d.e(r2);
        return super.onStartCommand(r5, r6, r7);
    L5:
        r3 = null;
        goto L6
    }
}
