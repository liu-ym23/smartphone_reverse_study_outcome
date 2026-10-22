package com.bytedance.common.wschannel.client;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.lynx.tasm.ui.image.v;
import g8.d;
import m8.a;
import zm.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsWsClientService extends Service implements WeakHandler.IHandler, a {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f3976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f3978c;

    public AbsWsClientService() {
        this.f3976a = new WeakHandler(this);
        this.f3977b = new c(this, 10);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        return this.f3978c.getBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f3978c = new Messenger(this.f3976a);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d("AbsWsClientService", "onDestroy");
        return;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r10, int r11) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r12 = new StringBuilder("onStartCommand intent = ");
        if (r5 == null) goto L7;
        String r13 = r5.toString();
    L8:
        r12.append(r13);
        Logger.d("AbsWsClientService", r12.toString());
        goto L9
    L7:
        r13 = "null";
    L9:
        d r14 = d.a();
        v r15 = new v(17, this, r5);
        r14.getClass();
        d.f17065b.post(r15);
        return 2;
    }
}
