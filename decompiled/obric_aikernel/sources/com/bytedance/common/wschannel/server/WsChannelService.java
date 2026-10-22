package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelService extends u1.a {

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f1369c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ WsChannelService f1370g;

        a(WsChannelService r10, Intent r11) {
            this.f1370g = r10;
            this.f1369c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsChannelService.c(this.f1370g, this.f1369c);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f1372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f1373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final WsChannelMsg f1374d;

        b(int r10, WsChannelMsg r11, long r12) {
            this.f1371a = r10;
            this.f1374d = r11;
            this.f1373c = r12;
            this.f1372b = null;
        }

        b(int r10, byte[] r11, long r12) {
            this.f1371a = r10;
            this.f1372b = r11;
            this.f1373c = r12;
            this.f1374d = null;
        }
    }

    public WsChannelService() {
    }

    static /* synthetic */ void c(WsChannelService r10, Intent r11) {
        r10.e(r11);
    }

    static int d(IWsApp r10) {
        if (r10 != null) goto L6;
        return Integer.MIN_VALUE;
    L6:
        return r10.getChannelId();
    }

    private void e(Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r11) == false) goto L9;
        int r12 = r10.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r13 = new Message();
        int r14 = 2;
    L7:
        r13.what = r14;
        r13.arg1 = r12;
        handleMsg(r13);
        return;
    L9:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r11) == false) goto L12;
        r12 = r10.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        r13 = new Message();
        r14 = 3;
        goto L7
    L12:
        if (WsConstants.MEM_TRIM_ACTION.equals(r11) == false) goto L18;
        int r15 = r10.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
        com.bytedance.common.wschannel.e r16 = com.bytedance.common.wschannel.j.h();
        if (r16 == null) goto L19;
        r16.onTrimMemory(r15);
        return;
    L19:
        return;
    }

    @Override // u1.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        super.handleMsg(r10);
        if (r10 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r10.what);
    L8:
        j.b(this).handleMsg(r10);
    }

    @Override // u1.a, android.app.Service
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
    }

    @Override // u1.a, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        r1.c.b(new a(this, r10));
        return 2;
    }
}
