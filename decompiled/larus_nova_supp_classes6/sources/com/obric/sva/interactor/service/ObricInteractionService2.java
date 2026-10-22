package com.obric.sva.interactor.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.service.voice.VoiceInteractionService;
import com.obric.sva.sdk.ipc.TrackAPI;
import com.obric.sva.sdk.service.WakeupService;
import com.obric.sva.sdk.utils.KtUtils;
import vna.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ObricInteractionService2 extends VoiceInteractionService {
    public static final /* synthetic */ int j = 0;
    public Messenger a;
    public Messenger b;
    public boolean c;
    public boolean d;
    public final vna.a e;
    public int f;
    public final vna.b g;
    public final a h;
    public final Handler i;

    public class a implements ServiceConnection {
        public final /* synthetic */ ObricInteractionService2 a;

        public a(ObricInteractionService2 r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            int r3 = ObricInteractionService2.j;
            xna.a.b("ObricInteractionService2", "enter onServiceDisconnected");
            ObricInteractionService2 r4 = this.a;
            r4.c = false;
            r4.b();
            this.a.a = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, IBinder r5) {
            int r6 = ObricInteractionService2.j;
            xna.a.b("ObricInteractionService2", "enter onServiceConnected " + r5 + " caller pid " + Binder.getCallingPid());
            ObricInteractionService2 r7 = this.a;
            r7.c = true;
            r7.a = new Messenger(r5);
            ObricInteractionService2 r8 = this.a;
            r8.getClass();
            xna.a.d("registerClient: clientId = 1");
            Message r1 = Message.obtain(null, 4096);
            r1.arg1 = 1;
            r8.c(r1);
            ObricInteractionService2 r9 = this.a;
            r9.i.removeCallbacks(r9.e);
            r5.linkToDeath(new b(this.a, r5), 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final IBinder a;
        public final /* synthetic */ ObricInteractionService2 b;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            int r0 = ObricInteractionService2.j;
            xna.a.b("ObricInteractionService2", "binderDied");
            this.a.unlinkToDeath(this, 0);
            this.b.onDestroy();
            Process.killProcess(Process.myPid());
        }

        public b(ObricInteractionService2 r1, IBinder r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void a() {
        xna.a.b("ObricInteractionService2", "bindWakeupServiceAsync mainUser:" + KtUtils.isMainUser());
        Intent r0 = new Intent(this, WakeupService.class);
        if (Build.VERSION.SDK_INT < 30) goto L5;
        bindServiceAsUser(r0, this.h, 1, Process.myUserHandle());
    L6:
        this.i.postDelayed(this.e, 10000);
        return;
    L5:
        bindService(r0, this.h, 1);
        goto L6
    }

    public final void b() {
        xna.a.d("deRegisterClient: clientId = 1");
        Message r0 = Message.obtain(null, 4098);
        r0.arg1 = 1;
        c(r0);
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onShutdown() {
        xna.a.b("ObricInteractionService2", "onShutdown");
        super.onShutdown();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [vna.a] */
    /* JADX WARN: Type inference failed for: r0v2, types: [vna.b] */
    public ObricInteractionService2() {
        this.d = false;
        this.e = new vna.a(this);
        this.g = new vna.b(this);
        this.h = new a(this);
        this.i = new Handler(new c(this));
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        xna.a.b("ObricInteractionService2", "onCreate mainUser?:" + KtUtils.isMainUser());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        xna.a.b("ObricInteractionService2", "onDestroy mainUser?:" + KtUtils.isMainUser());
        if (this.c == false) goto L9;
        b();
        unbindService(this.h);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        this.d = true;
        Handler r0 = this.i;
        if (r0 == null) goto L15;
        r0.removeCallbacksAndMessages(null);
        return;
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onReady() {
        super.onReady();
        boolean r0 = KtUtils.isMainUser();
        xna.a.b("ObricInteractionService2", "onReady mainUser?:" + r0);
        if (r0 == false) goto L6;
        this.b = new Messenger(this.i);
        a();
        return;
    }

    static {
    }

    public final void c(Message r3) {
        Messenger r0 = this.a;
        if (r0 == null) goto L10;
        r3.replyTo = this.b;
        r0.send(r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        xna.a.a("sendRequest: mServerMessenger: " + this.a + " msg: " + r3);
    }

    public final void d(Bundle r5) {
        StringBuilder r0 = new StringBuilder("showSessionSafely, invocationType=");
        Integer r1 = null;
        if (r5 != null) goto L5;
        Integer r2 = null;
    L6:
        r0.append(r2);
        r0.append(", showSessionId=");
        if (r5 == null) goto L10;
        r1 = Integer.valueOf(r5.getInt("android.service.voice.SHOW_SESSION_ID"));
    L10:
        r0.append(r1);
        xna.a.b("ObricInteractionService2", r0.toString());
        showSession(r5, 4);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        TrackAPI.trackWakeupInterrupted(r5, "stage3_entry", "showSession failed", e.getMessage());
        xna.a.a("showSession failed with " + e.getMessage());
        return;
    L5:
        r2 = Integer.valueOf(r5.getInt("invocation_type"));
        goto L6
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onShowSessionFailed(Bundle r4) {
        StringBuilder r0 = new StringBuilder("onShowSessionFailed, invocationType=");
        Integer r1 = null;
        if (r4 != null) goto L5;
        Integer r2 = null;
    L6:
        r0.append(r2);
        r0.append(", showSessionId=");
        if (r4 == null) goto L10;
        r1 = Integer.valueOf(r4.getInt("android.service.voice.SHOW_SESSION_ID"));
    L10:
        r0.append(r1);
        xna.a.b("ObricInteractionService2", r0.toString());
        super.onShowSessionFailed(r4);
        return;
    L5:
        r2 = Integer.valueOf(r4.getInt("invocation_type"));
        goto L6
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onPrepareToShowSession(Bundle r4, int r5) {
        StringBuilder r0 = new StringBuilder("onPrepareToShowSession, invocationType=");
        Integer r1 = null;
        if (r4 != null) goto L5;
        Integer r2 = null;
    L6:
        r0.append(r2);
        r0.append(", showSessionId=");
        if (r4 == null) goto L10;
        r1 = Integer.valueOf(r4.getInt("android.service.voice.SHOW_SESSION_ID"));
    L10:
        r0.append(r1);
        r0.append(", flags=");
        r0.append(r5);
        xna.a.b("ObricInteractionService2", r0.toString());
        super.onPrepareToShowSession(r4, r5);
        return;
    L5:
        r2 = Integer.valueOf(r4.getInt("invocation_type"));
        goto L6
    }
}
