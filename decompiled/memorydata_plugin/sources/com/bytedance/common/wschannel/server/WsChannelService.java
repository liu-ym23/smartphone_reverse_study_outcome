package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelService extends com.bytedance.common.wschannel.app.a {

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f2152b;
        final long c;
        final WsChannelMsg d;

        a(int r1, WsChannelMsg r2, long r3) {
            this.f2151a = r1;
            this.d = r2;
            this.c = r3;
            this.f2152b = null;
        }

        a(int r1, byte[] r2, long r3) {
            this.f2151a = r1;
            this.f2152b = r2;
            this.c = r3;
            this.d = null;
        }
    }

    public WsChannelService() {
    }

    static int a(IWsApp r2) {
        IWsApp r3 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r2, IWsApp.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return r3.getChannelId();
    }

    private void a(Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r0) == false) goto L9;
        int r5 = r4.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r1 = new Message();
        int r2 = 2;
    L7:
        r1.what = r2;
        r1.arg1 = r5;
        handleMsg(r1);
        return;
    L9:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r0) == false) goto L12;
        r5 = r4.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        r1 = new Message();
        r2 = 3;
        goto L7
    L12:
        if (WsConstants.MEM_TRIM_ACTION.equals(r0) == false) goto L18;
        int r3 = r4.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
        com.bytedance.common.wschannel.f r6 = com.bytedance.common.wschannel.j.a();
        if (r6 == null) goto L19;
        r6.a(r3);
        return;
    L19:
        return;
    }

    static /* synthetic */ void a(WsChannelService r2, Intent r3) {
        ((WsChannelService) ZeusTransformUtils.wrapperContextForParams(r2, WsChannelService.class, "com.obric.memorydata.plugin")).a(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.common.wschannel.app.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        super.handleMsg(r3);
        if (r3 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r3.what);
    L8:
        j.a(this).handleMsg(r3);
    }

    @Override // com.bytedance.common.wschannel.app.a
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
    }

    @Override // com.bytedance.common.wschannel.app.a
    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(final Intent r1, int r2, int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r1));
        return 2;
    }
}
