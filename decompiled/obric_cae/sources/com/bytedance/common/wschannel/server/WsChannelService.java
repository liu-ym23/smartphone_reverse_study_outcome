package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelService extends x5.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f3926m = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f3928b;

        public a() {
        }
    }

    public WsChannelService() {
    }

    @Override // x5.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r8.what);
    L7:
        j6.a.e(this).handleMsg(r8);
    }

    @Override // x5.a, android.app.Service
    public final void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
        j6.a.e(this);
    }

    @Override // x5.a, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r8, int r10, int r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        if (r8 == null) goto L17;
        String r12 = r8.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r12) == false) goto L11;
        int r13 = r8.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r14 = new Message();
        int r15 = 2;
    L13:
        r14.what = r15;
        r14.arg1 = r13;
        handleMsg(r14);
        return 1;
    L11:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r12) == false) goto L16;
        r13 = r8.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        r14 = new Message();
        r15 = 3;
        goto L13
    L16:
        return 1;
    L17:
        return 1;
    }
}
