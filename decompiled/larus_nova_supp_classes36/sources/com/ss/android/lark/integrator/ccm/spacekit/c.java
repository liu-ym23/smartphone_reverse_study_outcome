package com.ss.android.lark.integrator.ccm.spacekit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final a a;

    public class a extends Handler {
        public final /* synthetic */ c a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            if (r2.what != 6401) goto L11;
            this.a.getClass();
            if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L8;
            qa5.b.a.a.a.a.d();
            return;
        L8:
            Log.i("DocSdkPreloader", "preloadDocSdk, not login, return. ");
            return;
        }

        public a(c r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public c() {
        this.a = new a(this, CoreThreadPool.getSerialTaskHandler().getLooper());
    }

    public final void a(int r5) {
        Log.i("DocSdkPreloader", "preloadDocSdk, delayLoadTime: " + r5);
        if (r5 <= 0) goto L5;
        this.a.removeMessages(6401);
        this.a.sendEmptyMessageDelayed(6401, r5);
        return;
    L5:
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L7;
        qa5.b.a.a.a.a.d();
        return;
    L7:
        Log.i("DocSdkPreloader", "preloadDocSdk, not login, return. ");
    }
}
