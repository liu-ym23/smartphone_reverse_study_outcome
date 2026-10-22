package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.app.AbsMessengerService;
import com.lynx.tasm.ui.image.v;
import e8.f;
import s8.a;
import s8.h;
import xq.b;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelService extends AbsMessengerService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4020c = 0;

    public WsChannelService() {
    }

    public final void a(Message r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r5.what);
    L5:
        a r10 = fj.a.g(this);
        r10.getClass();
        r10.f21835a.post(new v(27, r10, Message.obtain(r5)));
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public final void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
        f.b(new jm.a(this, 11));
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r10, int r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        f.b(new h(0, this, r5));
        if (b.d == false) goto L21;
    L10:
        boolean r12 = b.f23212c;
    L11:
        if (r12 == true) goto L23;
    L19:
        return 1;
    L23:
        if (Integer.parseInt(t8.a.f22107a.a().substring(1)) < 12) goto L19;
        return 2;
    L21:
        Class.forName("miui.os.Build");     // Catch: Exception -> L9
        b.f23212c = true;     // Catch: Exception -> L9
        b.d = true;     // Catch: Exception -> L9
        r12 = true;
    L9:
        b.d = true;
        goto L10
    }
}
