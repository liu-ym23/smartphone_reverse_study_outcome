package com.bytedance.common.wschannel.app;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.lynx.tasm.ui.image.v;
import g8.c;
import g8.f;
import t8.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsMessengerService extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f3974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakHandler f3975b;

    public AbsMessengerService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.f3974a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Application r5 = getApplication();
        if (f.f17069b == true) goto L29;
        boolean r10 = true;
        f.f17069b = true;
        f.f17070c = r5;
        String r11 = a.a(r5);
        f.f = r11;
        if (r11 != null) goto L8;
    L10:
        if (r11 != null) goto L12;
    L14:
        r10 = false;
    L15:
        if (r10 == false) goto L17;
        c r12 = new c();
        r12.f17062a = f.d;
        r5.registerActivityLifecycleCallbacks(r12);
        WsConstants.setOnMessageReceiveListener(null);
        WsConstants.setOnLinkProgressChangeListener(null);
    L25:
        i4.a r13 = f.f17068a;
        Application r14 = f.f17070c;
        r13.getClass();
        if (r10 == false) goto L28;
        e8.f.b(new v(18, r13, r14));
        goto L29
    L28:
        e8.f.b(new jm.a(r14, 2));
        goto L29
    L17:
        String r15 = f.f;
        if (r15 == null) goto L25;
        if (r15.endsWith(":push") == false) goto L25;
        IntentFilter r16 = new IntentFilter();     // Catch: Exception -> L23
        r16.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L23
        Application r17 = f.f17070c;     // Catch: Exception -> L23
        Application r18 = f.f17070c;     // Catch: Exception -> L23
        r17.registerReceiver(new WsChannelReceiver(r18, fj.a.g(r18)), r16);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L12:
        if (r11.equals(r5.getPackageName()) == false) goto L14;
    L8:
        if (r11.contains(":") == false) goto L10;
    L29:
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.f3975b = new WeakHandler(this);
        this.f3974a = new Messenger(this.f3975b);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r5) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(r5);
    }
}
